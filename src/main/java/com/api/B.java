package com.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B {


    public static void main(String[] args) {

        List<Employe> employes = Arrays.asList(
                new Employe(1, "Afrid"),
                new Employe(2, "Aravind"),
                new Employe(3, "Sai Pavan")
        );

        employes.stream().map(e->mapToDto(e)).collect(Collectors.toList());
    }


     static EmployeDto mapToDto(Employe employe)
    {
        EmployeDto dto = new EmployeDto();
        dto.setId(employe.getId());
        dto.setName(employe.getName());
        return dto;
    }
}
