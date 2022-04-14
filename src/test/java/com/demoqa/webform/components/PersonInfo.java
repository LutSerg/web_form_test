package com.demoqa.webform.components;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import static java.lang.String.format;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.webform.components.MobilePhone.getRandomPhone;

public class PersonInfo {
    CalendarComponent calendar = new CalendarComponent();

    //локаторы
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement phoneInput = $("#userNumber");
    SelenideElement checkTable = $(".table-responsive");
//переменные
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = getRandomPhone(10),
            expectedFullName = format("%s %s", firstName, lastName);

    public PersonInfo setPersonInfo () {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        phoneInput.setValue(phone);

        return this;
    }

    public PersonInfo setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }
    public PersonInfo setGender () {
        $("#genterWrapper").$(byText("Female")).click();
        return this;
    }

    public PersonInfo checkPersonResult (){
        checkTable.shouldHave(Condition.text(expectedFullName));
        checkTable.shouldHave(Condition.text(email));
        checkTable.shouldHave(Condition.text(phone));
        checkTable.shouldHave(Condition.text("Female"));
        checkTable.shouldHave(Condition.text("30 July,2008"));
        return this;
    }

}
