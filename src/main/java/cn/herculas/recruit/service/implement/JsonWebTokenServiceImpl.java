package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.service.JsonWebTokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JsonWebTokenServiceImpl implements JsonWebTokenService {

    @Value("${spring.application.name}")
    private String issuer;
    @Value("${token.expires}")
    private Integer expires;

    private final SignatureAlgorithm SIGNATURE_ALGORITHM;
    private final Key key;

    public JsonWebTokenServiceImpl() {
        this.SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
        this.key = Keys.secretKeyFor(this.SIGNATURE_ALGORITHM);
    }

    @Override
    public String createJsonWebToken(String subject) {

        JwtBuilder jwtBuilder = Jwts.builder();

        jwtBuilder.setIssuer(issuer);
        jwtBuilder.setSubject(subject);
        jwtBuilder.setIssuedAt(new Date(System.currentTimeMillis()));
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + expires * 1000));
        jwtBuilder.signWith(this.key, this.SIGNATURE_ALGORITHM);

        return jwtBuilder.compact();
    }

    @Override
    public String parseJsonWebToken(String token) {
        try {
            return Jwts.parser().setSigningKey(this.key).parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            return null;
        }
    }
}
