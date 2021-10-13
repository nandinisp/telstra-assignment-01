package com.telstra.assinment.springbootmongodb.controller;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import com.telstra.assinment.springbootmongodb.service.JsonRequestService;
import com.telstra.assinment.springbootmongodb.validation.JsonRequestValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JsonRequestController {

    private final JsonRequestService jsonRequestService;
    private final JsonRequestValidation jsonRequestValidation;

    public JsonRequestController(JsonRequestService jsonRequestService, JsonRequestValidation jsonRequestValidation) {
        this.jsonRequestService = jsonRequestService;
        this.jsonRequestValidation = jsonRequestValidation;
    }

    @GetMapping("/get")
    public ResponseEntity<String> getWelcomeMessage(@RequestParam(required = false) String title) {
        return new ResponseEntity<String>("Hi Welcome", HttpStatus.OK);
    }

    @PostMapping("/jsonrequestprocessor")
    public ResponseEntity<Integer> requestProcess(@RequestBody JsonMessageRequest jsonMessageRequest) {
        try {
            //Doing validation
            boolean requestValid = jsonRequestValidation.isValid(jsonMessageRequest);
            if (requestValid) {
                Integer generatedId = jsonRequestService.addJsonRequest(jsonMessageRequest);
                return new ResponseEntity<>(generatedId, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
