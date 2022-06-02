package com.bosonit.bean.validation.application;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public class ModelMapperMock extends ModelMapper {

    @Override
    public <D> D map(Object source, Type destinationType) {
        return null;
    }
}
