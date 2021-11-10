package com.intern.gunshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.intern.gunshop.dto.UserDTO;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.request.UserRequest;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	//Map entity to dto
	public UserDTO entityToDto(Users user);
		
	//Map user request ( use for update ) to entity - keep the old data if the field is null
	@Mapping(target = "user_name" , source = "request.user_name" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "email" , source = "request.email" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "pass_word" , source = "request.pass_word" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "birth_date" , source="request.birth_date" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public Users requestToEntity(UserRequest request, @MappingTarget Users user);
	
	//Map user to user request
	public UserRequest entityToRequest(Users user);
}
