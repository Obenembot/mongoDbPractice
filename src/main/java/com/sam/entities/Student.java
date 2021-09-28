package com.sam.entities;

import lombok.*;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    private String firstName;

    private String lastName;

    @Field()
    private Decimal128 salary;


}
