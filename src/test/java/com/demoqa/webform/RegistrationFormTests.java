package com.demoqa.webform;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;


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
            String name = "Serg",
                    surname = "erweFF",
                    fullName  = format("%s %s", name, surname),
                    email = "eFdd@aadasd.gg",
                    adress = "test address 19",
                    phone = "9552231745";
            SelenideElement assertVar = $(".table-responsive");
            SelenideElement month = $(".react-datepicker__month-select");
            SelenideElement year = $(".react-datepicker__year-select");

            open ("/automation-practice-form");
            //убираем баннеры
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");

            //вставка имени и фамилии в полях firstName и lastName
            $("#firstName").setValue(name);
            $("#lastName").setValue(surname);

            //Вставка email
            $("#userEmail").setValue(email);

            //выделение радиобаттона Пол
            // $(".custom-control-label[for=gender-radio-3]").click();
            //$("#gender-radio-2").parent().click();
            $("#genterWrapper").$(byText("Female")).click();

            //вставка номера телефона
            $("#userNumber").setValue(phone);

            //заполнение даты рождения
            $("#dateOfBirthInput").click();
            month.click();
            month.selectOption("May");
            year.click();
            year.selectOption("1999");
            year.click();
           // $(".react-datepicker__week", 2).click();
            $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)").click();


            //Выбор хобби
            //$(".custom-control-label[for=hobbies-checkbox-1]").click();
            $("#hobbiesWrapper").$(byText("Sports")).click();

            //загрузка изображения
            $("#uploadPicture").uploadFromClasspath("getting_strt.PNG");

           // Выбор предмета
            $("#subjectsInput").setValue("h");
            $$("[id^='react-select-2-option']").find(Condition.text("History")).click();

            //добавление адреса
            $(".form-control#currentAddress").setValue(adress);

            //Выбор State and City
            /*
            $(".css-1wa3eu0-placeholder").click();
            $("#react-select-3-option-0").click();
            $(".css-1wa3eu0-placeholder").click();
            $("#react-select-4-option-1").click();
            */
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Gurgaon")).click();

            //нажатие Submit
            $("#submit").click();


            //Asserts
            assertVar.shouldHave(Condition.text(fullName));
            assertVar.shouldHave(Condition.text(email));
            assertVar.shouldHave(Condition.text("Female"));
            assertVar.shouldHave(Condition.text(phone));
            assertVar.shouldHave(Condition.text("27 May,1999"));
            assertVar.shouldHave(Condition.text("History"));
            assertVar.shouldHave(Condition.text("Sports"));
            assertVar.shouldHave(Condition.text("getting_strt.PNG"));
            assertVar.shouldHave(Condition.text(adress));
            assertVar.shouldHave(Condition.text("NCR Gurgaon"));
        }
}
