package com.example.COnline.Models.requests;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}