package com.abhiyaaan;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class Upload {

	

	DatastoreService datastore;
	
	
	
   // @Override
    public void doPost(String message1 , String message2,String message3) throws Exception {

     	datastore = DatastoreServiceFactory.getDatastoreService();
        String Location = message1;
        Location = Location.toLowerCase().trim();
        
       
    	Entity person = new Entity("Person",Location  );
    	person.setProperty("rating", message1);
    	person.setProperty("Location", message2);
    	person.setProperty("Image", message3);
    	datastore.put(person);  	
        
    }
}

	
