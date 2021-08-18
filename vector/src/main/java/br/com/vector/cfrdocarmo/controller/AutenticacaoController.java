package br.com.vector.cfrdocarmo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vector.cfrdocarmo.config.security.TokenServices;
import br.com.vector.cfrdocarmo.controller.dto.TokenDto;
import br.com.vector.cfrdocarmo.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
@Profile(value = {"prod", "test"})
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenServices tokenServices;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		
		try {
			UsernamePasswordAuthenticationToken dadosLogin = form.converter();
			
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenServices.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	
	}
	
	
	
}
