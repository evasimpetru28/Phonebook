package com.example.demo.model;

import com.example.demo.entity.Person;
import com.example.demo.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PersonPhoneListModel {
    private Person person;
    private List<Phone> phone;

    @Override
    public String toString() {
        return "PersonPhoneListModel{" +
                "person=" + person +
                ", phone=" + phone +
                '}';
    }
}
