package com.demoqa.webform.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.webform.components.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

@Owner("LutSerg")
@Severity(SeverityLevel.NORMAL)
@Feature("Тесты с формой регистрации")
@Story("Заполнение и проверка формы регистрации")

public class RegistrationFormPageObjectTests extends TestBase {

    RegistrationOpenPage registrationOpenPage = new RegistrationOpenPage();
    PersonInfo fillPersonInfo = new PersonInfo();
    OtherInfo setOtherInfo = new OtherInfo();
    PictureComponent setPicture = new PictureComponent();
    AdressComponent setFullAdress = new AdressComponent();
    Faker faker = new Faker();



        @Test
        @DisplayName("Региcтрация студента")
        void fillRegistrationForm() {


            SelenideElement submit = $("#submit");

            step("Открытие страницы сайта", () -> {
                registrationOpenPage.openRegistrationForm();
                    });
            //открытие страницы браузера

            step("Ввод данных", () -> {
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
        });

            step("Проверка введенных данных", () -> {
            fillPersonInfo.checkPersonResult();
            setFullAdress.checkAdressResult();
            setOtherInfo.checkOtherInfo();
            setPicture.checkPhoto();
        });

    }
}
