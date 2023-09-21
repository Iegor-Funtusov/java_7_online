package ua.com.alevel.service.security;

import ua.com.alevel.api.data.request.RegisterData;
import ua.com.alevel.api.data.response.AuthenticationData;

public interface AuthenticationService {

    AuthenticationData register(RegisterData data);
    AuthenticationData login(RegisterData data);
}
