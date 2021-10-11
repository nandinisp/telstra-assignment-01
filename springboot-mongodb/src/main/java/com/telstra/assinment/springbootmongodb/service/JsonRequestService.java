package com.telstra.assinment.springbootmongodb.service;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import com.telstra.assinment.springbootmongodb.repository.JsonMessageRequestRepository;

public class JsonRequestService {

    private final JsonMessageRequestRepository jsonMessageRequestRepository;

    public JsonRequestService(JsonMessageRequestRepository jsonMessageRequestRepository) {
        this.jsonMessageRequestRepository = jsonMessageRequestRepository;
    }

    public void addJsonRequest(JsonMessageRequest jsonMessageRequest) {
        jsonMessageRequestRepository.save(jsonMessageRequest);
    }
}
