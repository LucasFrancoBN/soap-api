package io.github.lucasfrancobn.soap_api.endpoints;



import com.example.soap.address.AddressResponse;
import com.example.soap.address.FindAddress;
import io.github.lucasfrancobn.soap_api.services.AddressService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AddressEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap/address";

    private final AddressService service;

    public AddressEndpoint(AddressService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findAddress")
    @ResponsePayload
    public AddressResponse findCep(@RequestPayload FindAddress request) {
        return service.findCep(request.getCep());
    }
}
