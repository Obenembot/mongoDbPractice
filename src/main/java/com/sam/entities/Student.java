package com.sam.entities;

import lombok.*;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection =  "students")
public class Student  {

    @Id
    private Long id;

    @TextIndexed
    private String firstName;

    @TextIndexed
    private String lastName;

    @TextIndexed
    private Double salary;


}
