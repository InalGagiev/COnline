package com.example.COnline.Controllers;
import com.example.COnline.Models.requests.AppError;
import com.example.COnline.Models.requests.AuthRequest;
import com.example.COnline.Models.requests.JwtResponse;
import com.example.COnline.Models.requests.RegistrationDto;
import com.example.COnline.utils.JwtTokenUtil;
import com.example.COnline.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.AuthenticationManager;

@RequestMapping("/api/test")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtils;
    private final AuthenticationManager authenticationManager;




    @PostMapping("/authorization")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
        try {
            LOG.debug("dannie polzovatela kotoryie budut proverenbl" + authRequest.getUsername(), authRequest.getPassword());
            //проводим аутентификацию
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {

            return ResponseEntity.ok("Неправильный логин или парольб фдывоадлыфоваджыоваджфыловд");
        }

        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationDto registrationUserDto) {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if (userService.findByUsername(registrationUserDto.getUsername()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }

        userService.createNewUser(registrationUserDto);
        return ResponseEntity.ok("пользователь успешно создан");
    }


}
