package ETSMed.API.controller;

import ETSMed.API.infta.security.DadosTokenJWT;
import ETSMed.API.infta.security.TokenService;
import ETSMed.API.model.user.DadosAutenticacap;
import ETSMed.API.model.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    public AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacap dadosAutenticacap){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacap.username(),dadosAutenticacap.password());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
