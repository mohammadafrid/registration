package com.api.service;

import com.api.entity.Registration;
import com.api.exception.NoData;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;

    private ModelMapper modelMapper;

    public RegistrationService(RegistrationRepository registrationRepository, ModelMapper modelMapper) {
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public List<RegistrationDto> getRegistrations(){
        List<Registration> registrations = registrationRepository.findAll();
        List<RegistrationDto> dtos = registrations.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        return  dtos;
    }

    public RegistrationDto createRegistration(RegistrationDto registrationDto) {
        
        // Entity   =----dto to entity -- 
        Registration creg = modelMapper.map(registrationDto, Registration.class);
//        Registration registration = new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setEmail(registrationDto.getEmail());
//        registration.setMobile(registrationDto.getMobile());
        //entity
        Registration savedEntity = registrationRepository.save(creg);
        // dto = entity to dto

        RegistrationDto dto = modelMapper.map(savedEntity, registrationDto.getClass());

//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(savedEntity.getName());
//        dto.setEmail(savedEntity.getEmail());
//        dto.setMobile(savedEntity.getMobile());

        return dto;
    }

    public void deleteRegistration(long id)
    {
      registrationRepository.deleteById(id);
    }

    public Registration updateRegistration(long id, Registration registration) {

        Registration reg = registrationRepository.findById(id).get();

         reg.setName(registration.getName());
         reg.setEmail(registration.getEmail());
        reg.setMobile(registration.getMobile());
        Registration regup = registrationRepository.save(reg);
        return regup;

    }



    public RegistrationDto mapToDto(Registration registration)
    {

        return modelMapper.map(registration, RegistrationDto.class);

    }

    public Registration mapToEntity(RegistrationDto registrationDto)
    {

        return modelMapper.map(registrationDto, Registration.class);

    }


    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(()->new NoData("puka data ledu y"));
        return mapToDto(registration);
    }
}
