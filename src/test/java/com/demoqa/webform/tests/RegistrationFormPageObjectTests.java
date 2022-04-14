package com.demoqa.webform.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.webform.components.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


public class RegistrationFormPageObjectTests {

    RegistrationOpenPage registrationOpenPage = new RegistrationOpenPage();
    PersonInfo fillPersonInfo = new PersonInfo();
    OtherInfo setOtherInfo = new OtherInfo();
    PictureComponent setPicture = new PictureComponent();
    AdressComponent setFullAdress = new AdressComponent();
    Faker faker = new Faker();


    @BeforeAll
        static void setUp() {
            Configuration.holdBrowserOpen = true;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
        }

    @AfterAll
    static void close() {
        SelenideElement closeButton = $("#closeLargeModal");
        closeButton.click();
    }
        @Test
        void fillRegistrationForm() {

            SelenideElement submit = $("#submit");


            //открытие страницы браузера
            registrationOpenPage.openRegistrationForm();
            //Ввод личных данных
            fillPersonInfo.setPersonInfo();
            //ввод даты рождения
            fillPersonInfo.setBirthDate("30", "July", "2008");
            //Задае пол
            fillPersonInfo.setGender();
            //Выбираем дполнительную информацию (хобби, предмет)
            setOtherInfo.chooseSubject();
            setOtherInfo.chooseHobby();
            //загрузка фото
            setPicture.setPhoto();
            //Полное заполнение адреса
            setFullAdress.currentAdress();
            setFullAdress.setStateAndCity();

            submit.click();

            fillPersonInfo.checkPersonResult();
            setFullAdress.checkAdressResult();
            setOtherInfo.checkOtherInfo();
            setPicture.checkPhoto();

        }
}
