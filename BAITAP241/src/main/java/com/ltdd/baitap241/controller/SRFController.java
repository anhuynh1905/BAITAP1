package com.ltdd.baitap241.controller;

import com.ltdd.baitap241.dto.request.UserRegister;
import com.ltdd.baitap241.services.Token;
import com.ltdd.baitap241.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_v1")
@RequiredArgsConstructor
public class SRFController {

    private final UserService userService;
    private final Token tokenService;

    @PostMapping("/register")
    public ResponseEntity login(@Valid @RequestBody UserRegister UserRegister){
        return ResponseEntity.ok().body(userService.register(UserRegister));
    }

    @PostMapping("/login")
    public ResponseEntity register(@Valid @RequestBody UserRegister UserRegister){
        return ResponseEntity.ok().body(userService.login(UserRegister));
    }

    @PostMapping("/reset-password")
    public ResponseEntity resetPassword(@Valid @RequestBody UserRegister UserRegister){
        return ResponseEntity.ok().body(userService.register(UserRegister));
    }

    @GetMapping("/reset-password")
    public ResponseEntity updatePassword(@RequestParam(value = "token") String token, @RequestParam(value = "password") String password){
        if(tokenService.check(token)){
            String result = userService.updatePassword(password, token);
            return ResponseEntity.ok().body(result);
        }
        else
            return ResponseEntity.badRequest().body("Invalid Token");
    }
}
