package com.ltdd.baitap241.services.implementation;

import com.ltdd.baitap241.dto.request.UserRegister;
import com.ltdd.baitap241.dto.response.UserResponse;
import com.ltdd.baitap241.entity.EmailDetails;
import com.ltdd.baitap241.entity.PasswordResetToken;
import com.ltdd.baitap241.entity.UserEntity;
import com.ltdd.baitap241.exception.UsernameNotFoundException;
import com.ltdd.baitap241.mapper.UserMapper;
import com.ltdd.baitap241.repository.PasswordTokenRepository;
import com.ltdd.baitap241.repository.UserRepository;
import com.ltdd.baitap241.services.EmailSender;
import com.ltdd.baitap241.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EmailSender emailSender;
    private final PasswordTokenRepository passwordTokenRepository;


    @Override
    public UserResponse login(UserRegister UserRegister) {
        UserEntity user = userRepository.findByEmail(UserRegister.getEmail());
        if(user !=null){
            if(user.getPassword().equals(UserRegister.getPassword()))
                return userMapper.toUserResponse(user);
        }

        throw new UsernameNotFoundException(UserRegister.getUsername());
    }

    @Override
    public UserEntity register(UserRegister UserRegister) {
        UserEntity user = userMapper.toUserEntity(UserRegister);
        userRepository.save(user);
        return user;
    }

    @Override
    public void resetPassword(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(resetToken);
        EmailDetails details = new EmailDetails();
        details.setRecipient(user.getEmail());
        details.setSubject("Reset Password");
        details.setMsgBody("To reset your password, click the link below:\n" +
                "http://localhost:8080/reset-password?token=" + token);
        emailSender.sendMail(details);
    }

    @Override
    public String updatePassword(String password, String token) {
        PasswordResetToken Token = passwordTokenRepository.findByToken(token);
        UserEntity user = Token.getUser();
        user.setPassword(password);
        userRepository.save(user);
        passwordTokenRepository.delete(Token);
        return "Success";
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserEntity found = userRepository.findByUsername(username);
        if(found == null)
            throw new UsernameNotFoundException(username);
        return found;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
