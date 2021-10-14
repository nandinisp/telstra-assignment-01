package com.telstra.assinment.springbootmongodb.controller;

import com.telstra.assinment.springbootmongodb.model.JsonMessageRequest;
import com.telstra.assinment.springbootmongodb.service.JsonRequestService;
import com.telstra.assinment.springbootmongodb.validation.JsonRequestValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.NullType;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JsonRequestController {

    private final JsonRequestService jsonRequestService;
    private final JsonRequestValidation jsonRequestValidation;

    public JsonRequestController(JsonRequestService jsonRequestService, JsonRequestValidation jsonRequestValidation) {
        this.jsonRequestService = jsonRequestService;
        this.jsonRequestValidation = jsonRequestValidation;
    }

    //a) Store the JSON request in MongoDB
    @PostMapping("/jsonrequestprocessor")
    public ResponseEntity<Integer> requestProcess(@RequestBody JsonMessageRequest jsonMessageRequest) {
        try {
            //Doing validation
            boolean isValid = jsonRequestValidation.Validate(jsonMessageRequest);
            if (isValid) {
                //Transforming Data
                jsonRequestValidation.transformData(jsonMessageRequest);
                Integer generatedId = jsonRequestService.addJsonRequest(jsonMessageRequest);
                return new ResponseEntity<>(generatedId, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //d) Store the results of the above methods in a MongoDB
    @GetMapping("/getall")
    public ResponseEntity<List<JsonMessageRequest>> getAll(@RequestParam(required = false) String title) {

        try {
            List<JsonMessageRequest> lstJsonMessageRequest = jsonRequestService.getAll();

            if (lstJsonMessageRequest.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lstJsonMessageRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
