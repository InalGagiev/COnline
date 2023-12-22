package com.example.COnline.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/test")
@RestController
public class TestCotnroller {
    @GetMapping("/protected")
    public ResponseEntity<?> control() {
        String request = "Вы успешно вошли в защишенный эндпоинт, значит вы авторизировались";
        return ResponseEntity.ok(request);
    }
    @GetMapping("/authorization")
    public ResponseEntity<?> createAuthToken() {
        String request = "пройдено";
        return ResponseEntity.ok(request);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> Admin() {
        String request = "вы перешли на страницу админа";
        return ResponseEntity.ok(request);
    }

}
