package org.example;

import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.function.Consumer;

public class less_2 {

    public static void mongoDB(){
        try(var mongoClient = MongoClients.create()){
            var database = mongoClient.getDatabase("test");
            var todoCollection = database.getCollection("todo");

            Document filter = new Document();
            filter.append("first_name", true);
            filter.append("last_name", true);
            filter.append("hire_date", true);
            filter.append("_id", 0);

//            todoCollection.find(filter).forEach((Consumer<Document>) System.out::println);

            FindIterable<Document> results = todoCollection.find();
            
            for (Document d: results) {
                System.out.println(d.getString("first_name") + "\t" + "|" + "\t" +
                        d.getString("last_name") + "\t" + "|" + "\t" +
                        d.getDate("hire_date"));

            }
        }
    }

    public static void main(String[] args) {
        mongoDB();
    }
}
