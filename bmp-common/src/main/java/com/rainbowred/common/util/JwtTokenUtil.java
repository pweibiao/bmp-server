package com.rainbowred.common.util;

import com.rainbowred.common.enums.ErrorCode;
import com.rainbowred.common.exception.BusinessException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: JWT 轮子
 * @Date: 2022/8/31 09:53
 * @Author: pengweibiao
 **/
@Component
@Slf4j
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token-head}")
    private String tokenHead;

    @Value("${jwt.token-validity-in-seconds}")
    private long expiration;

    public String getSecret() {
        return secret;
    }

    public String getTokenHead() {
        return tokenHead;
    }

    public long getExpiration() {
        return expiration;
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
//        claims.put(CLAIM_KEY_CREATED, new Date());
//        return generateToken(claims);
//    }

    public Claims getClaimFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.info("token解析失败"+e.toString());
        }
        return claims;
    }

    public String getClaimKeyUsername(String token) {
        Claims claimFromToken = getClaimFromToken(token);
        return (String) claimFromToken.get("sub");
    }

//    /**
//     * 校验token有效性
//     */
//    public boolean validateToken(String token, UserDetails userDetails) {
//        try {
//            // 获取token解析信息
//            Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//
//            // 是否超时
//            if (claims.getBody().getExpiration().before(new Date())) {
//                return false;
//            }
//            // 是否无效token
//            if (!claims.getBody().getSubject().equals(userDetails.getUsername())) {
//                return false;
//            }
//            return true;
//        } catch (JwtException | IllegalArgumentException e) {
//            throw new BusinessException(ErrorCode.E402);
//        }
//    }

    /**
     * 生成过期时间
     * @return expiration
     */
    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }

}
