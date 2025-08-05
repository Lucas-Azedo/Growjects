package br.com.growjects.service;

import br.com.growjects.entity.model.User;
import br.com.growjects.exception.BuildTokenException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${expiration.time}")
    private long expirationTime;

    public String buildToken(User user, List<String> roles){
        try{
            JWSSigner signer = new MACSigner(secret);

            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                    .subject(user.getId().toString())
                    .issuer("growjects.auth-api")
                    .claim("email", user.getEmail())
                    .claim("roles", roles)
                    .issueTime(new Date())
                    .expirationTime(new Date(System.currentTimeMillis() + expirationTime))
                    .build();

            SignedJWT signedJWT = new SignedJWT(
                    new JWSHeader(JWSAlgorithm.HS256),
                    claims
            );

            signedJWT.sign(signer);

            return signedJWT.serialize();
        }
        catch (Exception e) {
            throw new BuildTokenException("Error generation token" + e);
        }
    }
}
