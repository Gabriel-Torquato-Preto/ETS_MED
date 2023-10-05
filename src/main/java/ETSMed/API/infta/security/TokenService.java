package ETSMed.API.infta.security;

import ETSMed.API.model.user.User;
import ETSMed.API.model.user.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
@Service
public class TokenService {
    @Value("{api.security.token.secret}")
    private String secret;


    public String gerarToken(User user){
        try {
            var algoritimo = Algorithm.HMAC256(secret);

            return JWT.create().withSubject(user.getUsername()).withIssuer("API").withExpiresAt(dataExpiracao()).sign(algoritimo);
        }catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
    public String getSubject(String tokenJWT){
        try {


        var algoritimo = Algorithm.HMAC256(secret);
        return JWT.require(algoritimo).withIssuer("API").build().verify(tokenJWT).getSubject();
        }catch (JWTVerificationException e){
            throw  new RuntimeException("Token JWT inválido");
        }
        }
}
