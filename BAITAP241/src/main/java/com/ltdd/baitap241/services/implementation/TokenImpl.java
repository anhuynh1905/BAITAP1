package com.ltdd.baitap241.services.implementation;

import com.ltdd.baitap241.repository.PasswordTokenRepository;
import com.ltdd.baitap241.services.Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenImpl implements Token {
    private final PasswordTokenRepository passwordTokenRepository;

    @Override
    public Boolean check(String token) {
        if(passwordTokenRepository.existsByToken(token))
            return true;
        return false;
    }
}
