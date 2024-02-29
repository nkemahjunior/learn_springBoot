package com.zeco.jwtdemo2.service;


import com.zeco.jwtdemo2.entity.*;
import com.zeco.jwtdemo2.repository.UserRepository_04;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService_09 {


    private final UserRepository_04 repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService_03 jwtService;
    private final RefreshTokenService_13 refreshTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService_09(UserRepository_04 repository, PasswordEncoder passwordEncoder, JwtService_03 jwtService, RefreshTokenService_13 refreshTokenService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse_08 register(Users_01 request){

        // check if user already exist. if exist than authenticate the user
        if(repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse_08(null, "User already exist");
        }

        Users_01 user = new Users_01();
        //user.setFirstName(request.getFirstName());
       // user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        //user.setPassword(request.getPassword());
        user.setRoles_id(request.getRoles_id());


        Users_01 user1 = repository.save(user);

        String jwtToken = jwtService.generateToken(user1.getUsername());

        return new AuthenticationResponse_08(jwtToken,"registered successfully");
    }

    public JwtResponse_14 authenticate(Users_01 request){

          Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
          );

      if(authentication.isAuthenticated()){
          RefreshToken_12 refreshToken = refreshTokenService.createRefreshToken(request.getUsername());
          Users_01 user = repository.findByUsername(request.getUsername()).orElseThrow();

          JwtResponse_14 jwtResponse = new JwtResponse_14();
          jwtResponse.setAccessToken(jwtService.generateToken(user.getUsername()));
          jwtResponse.setToken(refreshToken.getToken());

          return jwtResponse;


      }else{
          throw new UsernameNotFoundException("invalid user request");
      }

      //Users_01 user = repository.findByUsername(request.getUsername()).orElseThrow();
     // String jwtToken = jwtService.generateToken(user);

     // return new AuthenticationResponse_08(jwtToken, "User login was successful");
    }

    public JwtResponse_14 refreshToken(RefreshTokenRequest_16 refreshTokenRequest){

        JwtResponse_14 jwtResponse = new JwtResponse_14();


        return  refreshTokenService.findByToken(refreshTokenRequest.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken_12::getUser)
                .map( users01 ->{
                     String accessToken = jwtService.generateToken(users01.getUsername());

                     jwtResponse.setAccessToken(accessToken);
                     jwtResponse.setToken(refreshTokenRequest.getToken());

                     return jwtResponse;

                } ).orElseThrow( () -> new RuntimeException("refresh token not found"));
    }
}
