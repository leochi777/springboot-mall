package com.leochi.springbootmall.controller;

import com.leochi.springbootmall.dto.linepay.CheckoutPaymentRequestForm;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;


import java.util.Map;
import java.util.UUID;

@RestController
public class PaymentController {

    private final String channelId="1655981339";
    private final String ChannelSecret="b201a511672e2bc203b6d7da963cf016";
    private final String url="https://sandbox-api-pay.line.me";

    @PostMapping("/payment/linePay")
    public ResponseEntity<Object> getLinePay(
            @RequestBody CheckoutPaymentRequestForm form
            ) {

        RestTemplate restTemplate= new RestTemplate();
        String requestUri = "/v3/payments/request";
        String nonce= UUID.randomUUID().toString();

        String json="{\n" +
                "    \"amount\" : 100,\n" +
                "    \"currency\" : \"TWD\",\n" +
                "    \"orderId\" : \"MKSI_S_20180904_1000001\",\n" +
                "    \"packages\" : [\n" +
                "        {\n" +
                "            \"id\" : \"1\",\n" +
                "            \"amount\": 100,\n" +
                "            \"products\" : [\n" +
                "                {\n" +
                "                    \"id\" : \"PEN-B-001\",\n" +
                "                    \"name\" : \"Pen Brown\",\n" +
                "                    \"imageUrl\" : \"https://pay-store.line.com/images/pen_brown.jpg\",\n" +
                "                    \"quantity\" : 2,\n" +
                "                    \"price\" : 50\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"redirectUrls\" : {\n" +
                "        \"confirmUrl\" : \"https://google.com\",\n" +
                "        \"cancelUrl\" : \"https://yahoo.com.tw\"\n" +
                "    }\n" +
                "}";
        String signature = encrypt(ChannelSecret, ChannelSecret + requestUri + json + nonce);

        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-LINE-ChannelId",channelId);
        headers.set("X-LINE-Authorization-Nonce",nonce);
        headers.set("X-LINE-Authorization",signature);
        HttpEntity entity=new HttpEntity<>(json,headers);
        ResponseEntity entity1=restTemplate.postForEntity(url+requestUri,entity, Map.class);

        return ResponseEntity.status(HttpStatus.OK).body(entity1.getBody());
    }
    public static String encrypt(final String keys, final String data) {
        return toBase64String(HmacUtils.getHmacSha256(keys.getBytes()).doFinal(data.getBytes()));
    }

    public static String toBase64String(byte[] bytes) {
        byte[] byteArray = Base64.encodeBase64(bytes);
        return new String(byteArray);
    }

}
