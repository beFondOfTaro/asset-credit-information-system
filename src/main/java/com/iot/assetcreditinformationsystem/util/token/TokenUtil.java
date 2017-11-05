package com.iot.assetcreditinformationsystem.util.token;

public interface TokenUtil {

    String createDigest(DigestModel digestModel);

    String createDigest(DigestModel digestModel, long expirationTime);

    boolean validToken(Token clientToken);

    boolean validToken(Token clientToken,long delayTime);

    boolean deleteToken(Integer userId);
}
