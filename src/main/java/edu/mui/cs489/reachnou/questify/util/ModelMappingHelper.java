package edu.mui.cs489.reachnou.questify.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ModelMappingHelper<T, DTO, REQ> {
    private final ModelMapper modelMapper;

    public DTO convertEntityToDto(T entity, Class<DTO> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public T convertDtoToEntity(DTO dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public List<DTO> convertEntityListToDtoList(List<T> entities, Class<DTO> dtoClass) {
        return entities.stream()
                .map(entity -> this.convertEntityToDto(entity, dtoClass))
                .toList();
    }

    public T convertRequestToEntity(REQ request, Class<T> entityClass) {
        return modelMapper.map(request, entityClass);
    }
}
