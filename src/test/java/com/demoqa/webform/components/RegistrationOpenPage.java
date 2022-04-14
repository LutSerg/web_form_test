package com.demoqa.webform.components;


import static com.codeborne.selenide.Selenide.*;

public class RegistrationOpenPage {

    public RegistrationOpenPage openRegistrationForm () {

        open("/automation-practice-form");
        //убираем баннеры
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

}




