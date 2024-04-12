package org.example;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import org.bson.Document;

public class TestGitBasies {

    public static void mongoDB(){
        try(var mongoClient = MongoClients.create()){
            var database = mongoClient.getDatabase("test");
            var todoCollection = database.getCollection("todo");

            Document filter = new Document();
            filter.append("first_name", true);
            filter.append("email", true);
            filter.append("_id", 0);

            FindIterable<Document> results = todoCollection.find();
            
            for (Document d: results) {
                System.out.println(d.getString("first_name") + "\t" + "|" + "\t" +
                        d.getString("email"));

            }
        }
    }

    public static void main(String[] args) {
        mongoDB();
    }
}
