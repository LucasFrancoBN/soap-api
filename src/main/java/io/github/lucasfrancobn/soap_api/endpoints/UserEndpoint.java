package io.github.lucasfrancobn.soap_api.endpoints;


import com.example.soap.users.*;
import io.github.lucasfrancobn.soap_api.services.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/users";

    private final UserService service;

    public UserEndpoint(UserService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public UserResponse createUser(@RequestPayload CreateUserRequest request) {
        return service.createUser(request.getCreateUser());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public UserResponse get(@RequestPayload GetUserRequest request) {
        return service.getUser(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UserResponse update(@RequestPayload UpdateUserRequest request) {
        return service.updateUser(request.getUpdateUser());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse delete(@RequestPayload DeleteUserRequest request) {
        return service.deleteUser(request.getId());
    }

}
