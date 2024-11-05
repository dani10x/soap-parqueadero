package com.pdyp.soap_service.service.impl;

import com.pdyp.soap_service.entity.ParqueaderoEntity;
import com.pdyp.soap_service.repository.ParqueaderoRepository;
import com.pdyp.soap_service.service.IParqueaderoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParqueaderoService implements IParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;

    @Override
    public ParqueaderoEntity getParqueadero(Integer id) {
        return parqueaderoRepository.findById(id).orElseThrow();
    }
}
