package com.demoqa.webform.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AdressComponent {
    Faker faker = new Faker();
    String setCurrentAdress = faker.address().fullAddress();
    SelenideElement checkTable = $(".table-responsive");

    public AdressComponent setStateAndCity () {
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        return this;
    }
    public AdressComponent currentAdress (){
        $(".form-control#currentAddress").setValue(setCurrentAdress);
        return this;
    }
    public AdressComponent checkAdressResult () {
        checkTable.shouldHave(Condition.text(setCurrentAdress));
        checkTable.shouldHave(Condition.text("NCR Gurgaon"));
        return this;
    }
}
