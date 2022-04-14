package com.demoqa.webform.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class PictureComponent {
    public PictureComponent setPhoto () {
        $("#uploadPicture").uploadFromClasspath("getting_strt.PNG");
        return this;
    }
    public PictureComponent checkPhoto () {
        $(".table-responsive").shouldHave(Condition.text("getting_strt.PNG"));
        return this;
    }
}
