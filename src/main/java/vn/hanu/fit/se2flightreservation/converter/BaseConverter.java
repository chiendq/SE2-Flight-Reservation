package vn.hanu.fit.se2flightreservation.converter;

import org.springframework.stereotype.Component;

@Component
public class BaseConverter {

    public Object toEntity(Object dto){
        Object entity = new Object();
        // entity.setter(dto.getter)
        return entity;
    }

    public Object toEntity(Object dto, Object oldEntity){
        // oldEntity.setter(dto.getter)
        return oldEntity;
    }

    public Object toDTO(Object entity){
        Object dto = new Object();
        // dto.setter(entity.getter)
        return dto;
    }
}
