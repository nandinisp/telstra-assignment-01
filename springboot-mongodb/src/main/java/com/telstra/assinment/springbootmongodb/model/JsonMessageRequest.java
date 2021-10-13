package com.telstra.assinment.springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "jsonrequests")
public class JsonMessageRequest {
    @Id
    private int id;
    @Field("findDuplicates")
    private  String  findDuplicates;
    @Field("whiteSpacesGalore")
    private String  whiteSpacesGalore;
    @Field("validateMeOnlyIActuallyShouldBeABoolean")
    private boolean validateMeOnlyIActuallyShouldBeABoolean;
    @Field("numbersMeetNumbers")
    private  int[] numbersMeetNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFindDuplicates() {
        return findDuplicates;
    }

    public void setFindDuplicates(String findDuplicates) {
        this.findDuplicates = findDuplicates;
    }

    public String getWhiteSpacesGalore() {
        return whiteSpacesGalore;
    }

    public void setWhiteSpacesGalore(String whiteSpacesGalore) {
        this.whiteSpacesGalore = whiteSpacesGalore;
    }

    public boolean isValidateMeOnlyIActuallyShouldBeABoolean() {
        return validateMeOnlyIActuallyShouldBeABoolean;
    }

    public void setValidateMeOnlyIActuallyShouldBeABoolean(boolean validateMeOnlyIActuallyShouldBeABoolean) {
        this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
    }

    public int[] getNumbersMeetNumbers() {
        return numbersMeetNumbers;
    }

    public void setNumbersMeetNumbers(int[] numbersMeetNumbers) {
        this.numbersMeetNumbers = numbersMeetNumbers;
    }



    public JsonMessageRequest(int id, String findDuplicates, String whiteSpacesGalore, boolean validateMeOnlyIActuallyShouldBeABoolean, int[] numbersMeetNumbers) {
        this.id = id;
        this.findDuplicates = findDuplicates;
        this.whiteSpacesGalore = whiteSpacesGalore;
        this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
        this.numbersMeetNumbers = numbersMeetNumbers;
    }


}
