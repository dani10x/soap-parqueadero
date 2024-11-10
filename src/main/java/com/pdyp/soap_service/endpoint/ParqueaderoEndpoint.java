package com.pdyp.soap_service.endpoint;

import com.pdyp.soap_service.*;
import com.pdyp.soap_service.mapper.ParqueaderoMapper;
import com.pdyp.soap_service.service.IParqueaderoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class ParqueaderoEndpoint {

    private static final String NAMESPACE_URI = "http://pdyp.com/soap_service";

    private final IParqueaderoService parqueaderoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getParqueaderoRequest")
    @ResponsePayload
    public GetParqueaderoResponse getParqueadero(@RequestPayload GetParqueaderoRequest request) {
        GetParqueaderoResponse response = new GetParqueaderoResponse();
        response.setParqueadero(ParqueaderoMapper.INSTNACE.instanceToResponse(parqueaderoService.getParqueadero(request.getId())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createParqueaderoRequest")
    @ResponsePayload
    public GetMensajeResponse createParqueadero(@RequestPayload CreateParqueaderoRequest request) {
        GetMensajeResponse response = new GetMensajeResponse();
        Mensaje mensaje = new Mensaje();
        mensaje.setRespuesta(parqueaderoService.createParqueadero(request.getParqueadero()));
        response.setMensaje(mensaje);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllParqueaderosRequest")
    @ResponsePayload
    public GetAllParqueaderosResponse getParqueaderos(@RequestPayload GetAllParqueaderosRequest request) {
        GetAllParqueaderosResponse response = new GetAllParqueaderosResponse();
        response.getParqueadero().addAll(
                parqueaderoService.getAllParqueaderos()
                        .stream()
                        .map(ParqueaderoMapper.INSTNACE::instanceToResponse)
                        .toList()
        );
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteParqueaderoRequest")
    @ResponsePayload
    public GetMensajeResponse deleteParqueadero(@RequestPayload DeleteParqueaderoRequest request) {
        GetMensajeResponse response = new GetMensajeResponse();
        Mensaje mensaje = new Mensaje();
        mensaje.setRespuesta(parqueaderoService.deleteParqueadero(request.getId()));
        response.setMensaje(mensaje);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateParqueaderoRequest")
    @ResponsePayload
    public GetMensajeResponse updateParqueadero(@RequestPayload UpdateParqueaderoRequest request) {
        GetMensajeResponse response = new GetMensajeResponse();
        Mensaje mensaje = new Mensaje();
        mensaje.setRespuesta(parqueaderoService.updateParqueadero(request.getParqueadero()));
        response.setMensaje(mensaje);
        return response;
    }
}
