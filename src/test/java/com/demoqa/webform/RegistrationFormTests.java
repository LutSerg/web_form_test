package com.demoqa.webform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

            open ("/automation-practice-form");
            //вставка имени и фамилии в полях firstName и lastName
            $("#firstName").setValue(name);
            $("#lastName").setValue(surname);

            //Вставка email
            $("#userEmail").setValue(email);

            //выделение радиобаттона Пол
            $(".custom-control-label[for=gender-radio-2]").click();



        }
}
