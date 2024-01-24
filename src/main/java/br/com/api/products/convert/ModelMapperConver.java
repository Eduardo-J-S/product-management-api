package br.com.api.products.convert;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConver {
    
    private final ModelMapper modelMapper;

    public ModelMapperConver(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <O, D> D parseObject(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination){
        List<D> destinationObjs = new ArrayList<>();
        for (O o : origin) {
            destinationObjs.add(modelMapper.map(o, destination));
        }
        return destinationObjs;
    }
}
