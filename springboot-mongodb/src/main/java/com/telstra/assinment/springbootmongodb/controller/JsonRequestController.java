package com.telstra.assinment.springbootmongodb.controller;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import com.telstra.assinment.springbootmongodb.service.JsonRequestService;
import com.telstra.assinment.springbootmongodb.validation.JsonRequestValidation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jsonrequestprocessor")
public class JsonRequestController {

    private final JsonRequestService jsonRequestService;
    private final JsonRequestValidation jsonRequestValidation;

    public JsonRequestController(JsonRequestService jsonRequestService, JsonRequestValidation jsonRequestValidation) {
        this.jsonRequestService = jsonRequestService;
        this.jsonRequestValidation = jsonRequestValidation;
    }


    @PostMapping
    public void addExpense(@RequestBody JsonMessageRequest jsonMessageRequest) {
        //Doing validation
        boolean requestValid = jsonRequestValidation.isValid(jsonMessageRequest);
        if(requestValid) {
            jsonRequestService.addJsonRequest(jsonMessageRequest);
        }
    }
}
