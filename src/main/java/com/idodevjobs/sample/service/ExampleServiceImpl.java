package com.idodevjobs.sample.service;

import com.idodevjobs.sample.model.ExampleModel;
import com.mongodb.*;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    @Override
    public ExampleModel get(String modelId) {


        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        DB db = mongo.getDB("dbtest");

        DBCollection table = db.getCollection("user");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "mkyong");
        document.put("age", 30);
        document.put("createdDate", new Date());
        table.insert(document);


        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "mkyong");

        DBCursor cursor = table.find(searchQuery);
        String temp="nadith";
        while (cursor.hasNext()) {
            temp=cursor.next().toString();
        }

        return new ExampleModel(temp, 1001);
    }
}