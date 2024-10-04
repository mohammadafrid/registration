package com.api.controller;

import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import com.api.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService  registrationService;
    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationService registrationService,
                                  RegistrationRepository registrationRepository) {
        this.registrationService = registrationService;
        this.registrationRepository = registrationRepository;
    }

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
        List<RegistrationDto> registrationsdto = registrationService.getRegistrations();
        System.out.println(registrationsdto);
        return new ResponseEntity<>(registrationsdto , HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createRegistration(
//saving the data in database
   @Valid @RequestBody RegistrationDto registrationDto ,
        BindingResult result
    ){
        if (result.hasErrors())
        {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
        }


        RegistrationDto regsa = registrationService.createRegistration(registrationDto);

        return new ResponseEntity<>(regsa , HttpStatus.CREATED);

    }

    // now deleting the record in database

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam long id
    )
    {
        registrationService.deleteRegistration(id);

        return new ResponseEntity<>( "Deleted" ,HttpStatus.OK );
    }
     // now for updating record in databsae

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(

           @PathVariable long id ,
           @RequestBody Registration registration

    )
    {
           Registration regu = registrationService.updateRegistration(id,registration);
           return new ResponseEntity<>(regu, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getregistrationById( @PathVariable long id )
    {

        RegistrationDto dto = registrationService.getRegistrationById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }

//public int sum(int a , int b)
//{
//    int c=a+b;
//    return c;
//}

}
