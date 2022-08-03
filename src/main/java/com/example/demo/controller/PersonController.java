package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Phone;
import com.example.demo.model.PersonPhoneListModel;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor

public class PersonController {

    final PersonRepository personRepository;
    final PhoneRepository phoneRepository;

    @GetMapping("/home")
    public String getAllPersons(Model model) {
        List<Phone> phoneList = phoneRepository.findAll();
        List<PersonPhoneListModel> personPhoneListModel = new ArrayList<>();
        List<Person> personList = personRepository.findAll();
        for (Person person : personList) {
            List<Phone> personPhoneList =  phoneList.stream().filter(phone -> phone.getPerson().equals(person)).collect(Collectors.toList());
            personPhoneListModel.add(new PersonPhoneListModel(person, personPhoneList));
        }

        model.addAttribute("personsAndPhoneLists", personPhoneListModel);
        return "home";
    }


    @GetMapping("/details/{id}")
    public String getPersonDetails(Model model, @PathVariable Integer id) {
        Optional<Person> person = getPersonById(id);
        model.addAttribute("name", person.get().getName());
        model.addAttribute("email", person.get().getEmail());
        model.addAttribute("personPhoneList", phoneRepository.findByPerson(personRepository.findById(id)));

        return "details";
    }

    @GetMapping("/add")
    public String addNewPerson() {
        return "add";
    }

    @GetMapping("/edit")
    public String editPerson() {
        return "edit";
    }

    @DeleteMapping("/deleteperson/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        personRepository.deleteById(id);
        return "redirect:home";
    }

    @PostMapping(path = "/editperson")
    public String editPerson(Person person) {
        personRepository.save(person);
        return "redirect:home";
    }

    @PostMapping(path = "/addeperson")
    public String addPerson(Person person) {
        personRepository.save(person);
        return "redirect:home";
    }

    private Optional<Person> getPersonById(Integer id) {
        return personRepository.findById(id);
    }

}
