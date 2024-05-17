package dev.Aditi.BookMyShow.controller;

import dev.Aditi.BookMyShow.dto.LoginRequestDTO;
import dev.Aditi.BookMyShow.dto.SignupRequestDTO;
import dev.Aditi.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
   private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody SignupRequestDTO signupRequestDTO) throws Exception {
        return ResponseEntity.ok(userService.signup(signupRequestDTO.getName(), signupRequestDTO.getEmail(), signupRequestDTO.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        return ResponseEntity.ok(userService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
    }

}
