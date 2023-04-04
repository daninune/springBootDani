package com.example.demo.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.demo.security.UserDetailsImpl;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${demo-spring.app.jwtSecret}")
  private String jwtSecret;

  @Value("${demo-spring.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  public static String bytesToHex(byte[] bytes) {
    StringBuilder result = new StringBuilder();

    for (byte aByte : bytes) {
      result.append(String.format("%02x", aByte));
    }
    return result.toString();
  }

  public String getEncodedSecretKey(String secretKey) {
    String generatedPassword = null;
    String salt = "salt";

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      md.update(salt.getBytes(StandardCharsets.UTF_8));
      byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
      byte[] secretKeyDigested = md.digest(secretKeyBytes);
      generatedPassword = bytesToHex(secretKeyDigested);
    }
    catch (NoSuchAlgorithmException e){
      e.printStackTrace();
    }
    return generatedPassword;
  }
  public String generateJwtToken(Authentication authentication) {

    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
    String secretKey = getEncodedSecretKey(jwtSecret);

    return Jwts.builder()
        .setSubject((userPrincipal.getUsername()))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(SignatureAlgorithm.HS512, secretKey)
        .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
