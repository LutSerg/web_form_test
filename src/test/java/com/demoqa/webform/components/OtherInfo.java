package com.demoqa.webform.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OtherInfo {
    SelenideElement checkTable = $(".table-responsive");
    public OtherInfo chooseHobby () {
        $("#hobbiesWrapper").$(byText("Sports")).click();
        return this;
    }
    public OtherInfo chooseSubject () {
        $("#subjectsInput").setValue("h");
        $$("[id^='react-select-2-option']").find(Condition.text("History")).click();
        return this;
    }

    public OtherInfo checkOtherInfo () {
        checkTable.shouldHave(Condition.text("Sports"));
        checkTable.shouldHave(Condition.text("History"));
        return  this;
    }
}
