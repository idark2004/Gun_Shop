package com.intern.gunshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.intern.gunshop.dto.AmmoDTO;
import com.intern.gunshop.entity.Ammo;
import com.intern.gunshop.request.AmmoRequest;

@Mapper(componentModel = "spring")
public interface AmmoMapper {
	
	// Map entity to dto
	public AmmoDTO entityToDTO(Ammo ammo);
	
	// Map request to entity ( use for add and update )
	@Mapping(target = "ammo_name" , source = "request.ammo_name" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "rounds" , source = "request.rounds" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "ammo_quantity" , source = "request.ammo_quantity" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "ammo_price" , source = "request.ammo_price" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "ammo_weight" , source = "request.ammo_weight" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public Ammo requestToEntity(AmmoRequest request);
}
