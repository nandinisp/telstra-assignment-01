package com.telstra.assinment.springbootmongodb.repository;
import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsonMessageRequestRepository extends MongoRepository<JsonMessageRequest,String> {

}
