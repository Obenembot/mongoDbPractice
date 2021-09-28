package com.sam.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "courses")
public class Course {

    @Id
    private Long id;

    private String name;
    private String type;
    private String description;
}
