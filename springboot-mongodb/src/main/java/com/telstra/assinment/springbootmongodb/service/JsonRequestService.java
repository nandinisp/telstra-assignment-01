package com.telstra.assinment.springbootmongodb.service;
import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import com.telstra.assinment.springbootmongodb.repository.JsonMessageRequestRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonRequestService {

    private final JsonMessageRequestRepository jsonMessageRequestRepository;

    public JsonRequestService(JsonMessageRequestRepository jsonMessageRequestRepository) {
        this.jsonMessageRequestRepository = jsonMessageRequestRepository;
    }

    public Integer addJsonRequest(JsonMessageRequest jsonMessageRequest) {
        jsonMessageRequestRepository.save(jsonMessageRequest);
        return jsonMessageRequest.getId();
    }

    public List<JsonMessageRequest> getAll() {
       return jsonMessageRequestRepository.findAll();
    }
}
