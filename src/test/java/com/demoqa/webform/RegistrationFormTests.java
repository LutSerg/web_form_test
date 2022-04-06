package com.demoqa.webform;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    static void close() {
        $("#closeLargeModal").click();

    }
        @Test
        void fillRegistrationForm() {
            String name = "Serg";
            String surname = "erweFF";
            String email = "eFdd@aadasd.gg";
            String adress = "test address 19";
            String phone = "9552231745";
            SelenideElement assertVar = $(".table-responsive");
            SelenideElement month = $(".react-datepicker__month-select");
            SelenideElement year = $(".react-datepicker__year-select");

            open ("/automation-practice-form");
            //вставка имени и фамилии в полях firstName и lastName
            $("#firstName").setValue(name);
            $("#lastName").setValue(surname);

            //Вставка email
            $("#userEmail").setValue(email);

            //выделение радиобаттона Пол
            $(".custom-control-label[for=gender-radio-2]").click();

            //вставка номера телефона
            $("#userNumber").setValue(phone);

            //заполнение даты рождения
            $("#dateOfBirthInput").click();
            month.click();
            month.selectOption("May");
            year.click();
            year.selectOption("1999");
            year.click();
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


            //Asserts
            assertVar.shouldHave(Condition.text("Serg erweFF"));
            assertVar.shouldHave(Condition.text(email));
            assertVar.shouldHave(Condition.text("Female"));
            assertVar.shouldHave(Condition.text(phone));
            assertVar.shouldHave(Condition.text("12 May,1999"));
            assertVar.shouldHave(Condition.text("History"));
            assertVar.shouldHave(Condition.text("Sports"));
            assertVar.shouldHave(Condition.text("getting_strt.PNG"));
            assertVar.shouldHave(Condition.text(adress));
            assertVar.shouldHave(Condition.text("NCR Gurgaon"));
        }
}
