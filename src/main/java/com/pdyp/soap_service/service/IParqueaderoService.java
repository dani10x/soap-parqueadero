package com.pdyp.soap_service.service;

import com.pdyp.soap_service.CrearParqueadero;
import com.pdyp.soap_service.Parqueadero;
import com.pdyp.soap_service.entity.ParqueaderoEntity;

import java.util.List;

public interface IParqueaderoService {

    ParqueaderoEntity getParqueadero(Integer id);

    String createParqueadero(CrearParqueadero parqueadero);

    List<ParqueaderoEntity> getAllParqueaderos();

    String deleteParqueadero(Integer id);

    String updateParqueadero(Parqueadero parqueadero);
}
