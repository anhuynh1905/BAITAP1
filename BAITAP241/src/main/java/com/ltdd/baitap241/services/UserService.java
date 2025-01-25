package com.ltdd.baitap241.services;

import com.ltdd.baitap241.dto.request.ResetPassword;
import com.ltdd.baitap241.dto.request.UserRegister;
import com.ltdd.baitap241.dto.response.UserResponse;
import com.ltdd.baitap241.entity.UserEntity;

public interface UserService {
    public UserResponse login(UserRegister UserRegister);
    public UserEntity register(UserRegister UserRegister);
    public void resetPassword(String username);
    public String updatePassword(String password, String token);

    public UserEntity findByUsername(String username);
    public UserEntity findByEmail(String email);
}
