package org.example;

import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.function.Consumer;

public class less_1 {

    public static void mongoDB(){
        try(var mongoClient = MongoClients.create()){
            var database = mongoClient.getDatabase("test");
            var todoCollection = database.getCollection("todo");

            todoCollection.find().forEach((Consumer<Document>) System.out::println);
        }
    }

    public static void main(String[] args) {
        mongoDB();
    }
}
