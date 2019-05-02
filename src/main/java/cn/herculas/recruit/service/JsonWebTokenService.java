package cn.herculas.recruit.service;

public interface JsonWebTokenService {
    String createJsonWebToken(String subject);
    String parseJsonWebToken(String token);
}
