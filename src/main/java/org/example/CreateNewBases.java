package org.example;

import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;


public class CreateNewBases {


    public static void create() {
        try (var mongoClient = MongoClients.create()) {
            var database = mongoClient.getDatabase("MongoBasesUsers");

            database.listCollectionNames().forEach((Consumer<String>) System.out::println);
            database.listCollections().forEach((Consumer<Document>) System.out::println);

            var todoCollection = database.getCollection("todo");

            var todoDocument1 = new Document(Map.of("_id", 1, "first_name", "Steven", "last_name", "King", "email", "SKING", "phone_number", "515.123.4567", "hire_date", new Date(1987, 6, 17), "job_id", "AD_PRES", "salary", 24000));
            var todoDocument2 = new Document(Map.of("_id", 2, "first_name", "Neena", "last_name", "Kochhar", "email", "NKOCHHAR", "phone_number", "515.123.4568", "hire_date", new Date(1987, 6, 18), "job_id", "AD_VP", "salary", 17000));
            var todoDocument3 = new Document(Map.of("_id", 3, "first_name", "Lex", "last_name", "De Haan", "email", "LDEHAAN", "phone_number", "515.123.4569", "hire_date", new Date(1987, 6, 19), "job_id", "AD_VP", "salary", 17000));
            var todoDocument4 = new Document(Map.of("_id", 4, "first_name", "Alexandr", "last_name", "Hunold", "email", "AHUNOLD", "phone_number", "590.423.4567", "hire_date", new Date(1987, 6, 20), "job_id", "IT_PROG", "salary", 9000));
            var todoDocument5 = new Document(Map.of("_id", 5, "first_name", "Bruce", "last_name", "Ernst", "email", "BERNST", "phone_number", "590.423.4568", "hire_date", new Date(1987, 6, 21), "job_id", "IT_PROG", "salary", 6000));
            var todoDocument6 = new Document(Map.of("_id", 6, "first_name", "David", "last_name", "Austin", "email", "DAUSTIN", "phone_number", "590.423.4569", "hire_date", new Date(1987, 6, 22), "job_id", "IT_PROG", "salary", 4800));
            var todoDocument7 = new Document(Map.of("_id", 7, "first_name", "Valli", "last_name", "Pataballa", "email", "VPATABAL", "phone_number", "590.423.4560", "hire_date", new Date(1987, 6, 23), "job_id", "IT_PROG", "salary", 4800));

            todoCollection.insertOne(todoDocument1);
            todoCollection.insertOne(todoDocument2);
            todoCollection.insertOne(todoDocument3);
            todoCollection.insertOne(todoDocument4);
            todoCollection.insertOne(todoDocument5);
            todoCollection.insertOne(todoDocument6);
            todoCollection.insertOne(todoDocument7);

            todoCollection.find().forEach((Consumer<Document>) System.out::println);
        }
    }

    public static void main(String[] args) {
        create();
    }
}