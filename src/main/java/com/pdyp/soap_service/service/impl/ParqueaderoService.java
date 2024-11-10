package com.pdyp.soap_service.service.impl;

import com.pdyp.soap_service.CrearParqueadero;
import com.pdyp.soap_service.Parqueadero;
import com.pdyp.soap_service.entity.ParqueaderoEntity;
import com.pdyp.soap_service.mapper.ParqueaderoMapper;
import com.pdyp.soap_service.repository.ParqueaderoRepository;
import com.pdyp.soap_service.service.IParqueaderoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParqueaderoService implements IParqueaderoService {

    private final ParqueaderoRepository parqueaderoRepository;

    @Override
    public ParqueaderoEntity getParqueadero(Integer id) {
        return parqueaderoRepository.findById(id).orElseThrow();
    }

    @Override
    public String createParqueadero(CrearParqueadero parqueadero) {
        parqueaderoRepository.save(ParqueaderoMapper.INSTNACE.parqueaderoToInstance(parqueadero));
        return "El parqueadero se ha creado con éxito";
    }

    @Override
    public List<ParqueaderoEntity> getAllParqueaderos() {
        return parqueaderoRepository.findAll();
    }

    @Override
    public String deleteParqueadero(Integer id) {
        if(parqueaderoRepository.existsById(id)) {
            parqueaderoRepository.deleteById(id);
            return "Parqueadero eliminado con éxito";
        }
        return "El parqueadero no existe";
    }

    @Override
    public String updateParqueadero(Parqueadero parqueadero) {
        if(parqueaderoRepository.existsById(parqueadero.getId())) {
            parqueaderoRepository.save(ParqueaderoMapper.INSTNACE.updateToInstance(parqueadero));
            return "Parqueadero actualizado";
        }
        return "El parqueadero no existe";
    }
}
