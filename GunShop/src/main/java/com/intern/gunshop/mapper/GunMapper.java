package com.intern.gunshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.intern.gunshop.dto.GunDTO;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.request.GunRequest;

@Mapper(componentModel = "spring")
public interface GunMapper {
	//map request to entity ( create new gun )
	public Gun requestToEntityCreate(GunRequest request);
	
	//map request to entity ( update existing gun )
	@Mapping(target = "gun_name" , source = "request.gun_name" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "capacity" , source = "request.capacity" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "gun_description" , source = "request.gun_description" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "gun_image" , source = "request.gun_image" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public Gun requestToEntityUpdate(GunRequest request, @MappingTarget Gun Gun);
	
	//map entity to dto
	public GunDTO entityToDTO(Gun Gun);
}
