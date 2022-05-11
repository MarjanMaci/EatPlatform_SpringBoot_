package com.example.kasnisi.auth;

public class JwtAuthConstants {
    public static final String SECRET = "s3CrEt1309";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
