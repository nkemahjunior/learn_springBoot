package com.zeco.jwtdemo2.controller;


import com.zeco.jwtdemo2.entity.AuthenticationResponse_08;
import com.zeco.jwtdemo2.entity.JwtResponse_14;
import com.zeco.jwtdemo2.entity.RefreshTokenRequest_16;
import com.zeco.jwtdemo2.entity.Users_01;
import com.zeco.jwtdemo2.service.AuthenticationService_09;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController_10 {

    private final AuthenticationService_09 authenticationService;

    public AuthenticationController_10(AuthenticationService_09 authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse_08> register(@RequestBody Users_01 request) {
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse_14> login(@RequestBody Users_01 request) {

        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refreshToken")
    public JwtResponse_14 refreshToken(@RequestBody RefreshTokenRequest_16 refreshTokenRequest){
        return authenticationService.refreshToken(refreshTokenRequest);
    }
}
