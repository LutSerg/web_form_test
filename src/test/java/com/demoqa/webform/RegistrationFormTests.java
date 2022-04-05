package com.demoqa.webform;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormTests {

        @BeforeAll
        static void setUp() {
            Configuration.holdBrowserOpen = true;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = "1920x1080";
        }
        @Test
        void fillRegistrationForm() {
            String name = "Serg";
            String surname = "erweFF";
            String email = "eFdd@aadasd.gg";
            String adress = "test address 19";

            open ("/automation-practice-form");
            //вставка имени и фамилии в полях firstName и lastName
            $("#firstName").setValue(name);
            $("#lastName").setValue(surname);

            //Вставка email
            $("#userEmail").setValue(email);

            //выделение радиобаттона Пол
            $(".custom-control-label[for=gender-radio-2]").click();

            //вставка номера телефона
            $("#userNumber").setValue("9552231745");

            //заполнение даты рождения
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__year-select").selectOption("1999");
            $(".react-datepicker__year-select").click();
            $(".react-datepicker__week", 2).click();

            //Выбор хобби
            $(".custom-control-label[for=hobbies-checkbox-1]").click();

            //загрузка изображения
            $("#uploadPicture").uploadFromClasspath("getting_strt.PNG");

           // Выбор предмета
            $("#subjectsInput").setValue("h");
            $$("[id^='react-select-2-option']").find(Condition.text("History")).click();

            //добавление адреса
            $(".form-control#currentAddress").setValue(adress);

            //Выбор State and City
            $(".css-1wa3eu0-placeholder").click();
            $("#react-select-3-option-0").click();
            $(".css-1wa3eu0-placeholder").click();
            $("#react-select-4-option-1").click();

            //нажатие Submit
            $("#submit").click();

        }
}
