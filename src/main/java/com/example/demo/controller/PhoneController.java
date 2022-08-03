package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Phone;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PhoneController {

    final PhoneRepository phoneRepository;
    final PersonRepository personRepository;



//    private List<Phone> getPhoneListOfPersonById(Integer id) {
//        Optional<Person> person = personRepository.findById(id);
//        return phoneRepository.findByPerson(person);
//    }


}
