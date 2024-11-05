package com.pdyp.soap_service.endpoint;

import com.pdyp.soap_service.GetParqueaderoRequest;
import com.pdyp.soap_service.GetParqueaderoResponse;
import com.pdyp.soap_service.Parqueadero;
import com.pdyp.soap_service.entity.ParqueaderoEntity;
import com.pdyp.soap_service.service.IParqueaderoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class ParqueaderoEndpoint {

    private static final String NAMESPACE_URI = "http://pdyp.com/soap_service";

    private final IParqueaderoService parqueaderoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getParqueaderoRequest")
    @ResponsePayload
    public GetParqueaderoResponse getParqueadero(@RequestPayload GetParqueaderoRequest request) {
        GetParqueaderoResponse response = new GetParqueaderoResponse();
        response.setParqueadero(transformParqueadero(parqueaderoService.getParqueadero(request.getId())));
        return response;
    }

    private Parqueadero transformParqueadero(ParqueaderoEntity entity) {
        Parqueadero p = new Parqueadero();
        p.setNombre(entity.getNombre());
        p.setCapacidad(entity.getCapacidad());
        return p;
    }

}
