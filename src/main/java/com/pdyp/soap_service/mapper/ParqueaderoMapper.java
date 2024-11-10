package com.pdyp.soap_service.mapper;

import com.pdyp.soap_service.CrearParqueadero;
import com.pdyp.soap_service.Parqueadero;
import com.pdyp.soap_service.entity.ParqueaderoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParqueaderoMapper {

    ParqueaderoMapper INSTNACE = Mappers.getMapper(ParqueaderoMapper.class);

    Parqueadero instanceToResponse(ParqueaderoEntity entity);

    List<Parqueadero> listInstanceToListResponse(List<ParqueaderoEntity> entities);

    ParqueaderoEntity parqueaderoToInstance(CrearParqueadero parqueadero);

    ParqueaderoEntity updateToInstance(Parqueadero parqueadero);
}
