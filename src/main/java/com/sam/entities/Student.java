package com.sam.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection =  "students")
public class Student  {

    @Id
    private Long id;
    private String firstName;

    private String lastName;
}
