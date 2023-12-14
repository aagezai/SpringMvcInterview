package com.facebooked.demofacebooked.JWTCreationAndValidateJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.json.JSONObject;

import java.security.Key;

public class JwtCreator {

    private final String secretKey;

    public JwtCreator(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createJwt() {
        JSONObject headerJson = createHeader();
        JSONObject payloadJson = createPayload();

        String jwt = Jwts.builder()
                .setHeader(headerJson.toMap())  // Pass the JSON object directly
                .setPayload(payloadJson.toString()) // Pass the JSON object directly
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .compact();

        return jwt;
    }

    private JSONObject createHeader() {
        String algorithm = "HS256";
        String type = "JWT";

        JSONObject headerJson = new JSONObject();
        headerJson.put("alg", algorithm);
        headerJson.put("typ", type);

        return headerJson;
    }

    private JSONObject createPayload() {
        String subject = "1234567890";
        String issuer = "aaron";
        String audience = "your_audience";
        long expirationTime = System.currentTimeMillis() + 3600000; // 1 hour from now
        long notBefore = System.currentTimeMillis() - 60000; // 1 minute ago
        long issuedAt = System.currentTimeMillis();
        String jwtId = "your_jwt_id";
        String name = "aaron";
        String[] roles = {"admin", "user"};

        JSONObject payloadJson = new JSONObject();
        payloadJson.put("sub", subject);
        payloadJson.put("iss", issuer);
        payloadJson.put("aud", audience);
        payloadJson.put("exp", expirationTime);
        payloadJson.put("nbf", notBefore);
        payloadJson.put("iat", issuedAt);
        payloadJson.put("jti", jwtId);
        payloadJson.put("name", name);
        payloadJson.put("roles", roles);

        return payloadJson;
    }

    private String createSignature(String dataToSign) {
        Key key = getSecretKey();
        return Jwts.builder().setPayload(dataToSign).signWith(key).compact();
    }


    private Key getSecretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }



    public static void main(String[] args) {
        // Replace "your_secret_key_here" with your actual secret key
        String secretKey = "your_secret_key_here";

        JwtCreator jwtCreator = new JwtCreator(secretKey);
        String jwt = jwtCreator.createJwt();
        System.out.println("Generated JWT: " + jwt);

      ;
    }
}
