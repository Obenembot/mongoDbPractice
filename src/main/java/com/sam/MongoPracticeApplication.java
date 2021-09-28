package com.sam;

import com.mongodb.client.*;
import com.sam.entities.Student;
import com.sam.reposotories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

@SpringBootApplication
public class MongoPracticeApplication {

    @Autowired
    static StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoPracticeApplication.class, args);


        String uri = "mongodb+srv://sam:sam@cluster0.rgwt0.mongodb.net/blog?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("blog");
            MongoCollection<Document> collection = database.getCollection("posts");

            FindIterable<Document> documents = collection.find();
            for (Document d : documents) {
                System.out.println(d);
            }


        }
    }

}
