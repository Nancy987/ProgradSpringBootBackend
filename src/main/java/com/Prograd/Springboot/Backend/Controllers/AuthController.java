//package com.Prograd.Springboot.Backend.Controllers;
//
//import com.Prograd.Springboot.Backend.Payload.Request.JwtAuthRequest;
//import com.Prograd.Springboot.Backend.Payload.Response.JwtAuthResponse;
//import com.Prograd.Springboot.Backend.Security.Jwt.JwtTokenHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/students/")
//public class AuthController {
//
//    @Autowired
//    private JwtTokenHelper jwtTokenHelper;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @PostMapping("/login")
//    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){
//
//        this.authenticate(request.getUsername(),request.getPassword());
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenHelper.generateJwtToken(authentication);
//
//        JwtAuthResponse response = new JwtAuthResponse();
//        response.setToken(jwt);
//
//        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
//
//
////        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
////
////        this.jwtTokenHelper.generateJwtToken(userDetails);
//    }
//
//    private void authenticate(String username, String password) {
//
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
//        try {
//            this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//        }
//        catch (DisabledException e){
//            System.out.println("User is disabled");
//        }
//    }
//}
