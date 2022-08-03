package com.example.demo.repository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    List<Phone> findByPerson(Optional<Person> person);
}
