package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;

public class less_4 {

    public static void mongoDB(){
        try(var mongoClient = MongoClients.create()){
            var database = mongoClient.getDatabase("test");
            var todoCollection = database.getCollection("todo");

            Document filter = new Document();
            filter.append("salary", true);
            filter.append("_id", 0);

            FindIterable<Document> results = todoCollection.find();

            ArrayList<Integer> arr = new ArrayList<>();
            for (Document d: results) {
                arr.add(d.getInteger("salary"));
            }

            int[] aver = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                aver[i] += arr.get(i);
            }

            System.out.println("Средняя зарплата: " + Arrays.stream(aver).average().getAsDouble());
        }
    }

    public static void main(String[] args) {
        mongoDB();
    }
}
