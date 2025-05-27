package com.project.SecurityLectures.service;

import com.project.SecurityLectures.requestResponse.LoginRequest;

public interface SignInService {
    Object authenticateUser(LoginRequest loginRequest);
}
