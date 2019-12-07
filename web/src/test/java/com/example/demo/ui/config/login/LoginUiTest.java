package com.example.demo.ui.config.login;

import com.example.demo.ui.config.SeleniumConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginUiTest extends SeleniumConfig {

    @Test
    void shouldOpenLoginPageWithMenus() {
        openPage();
        assertThat(getElementByClass("header-links").isDisplayed());
    }

    @Test
    void shouldHighlightLoginAndPasswordUponClickOnSubmitWhenEmptyFormIsSubmitted() {
        openPage();
        assertThat(getElementByClass("header-links").isDisplayed());
        WebElement submitButton = getElementById("submit");
        submitButton.click();
        assertThat(getElementById("login").getCssValue("border-color")).isNotEqualTo("");
        assertThat(getElementById("password").getCssValue("border-color")).isNotEqualTo("");
    }

    @Test
    void shouldShowDefaultViewWhenFocusedOnField() {
        openPage();
        WebElement submitButton = getElementById("submit");
        submitButton.click();
        assertThat(getElementById("login").getCssValue("border-color")).isNotEqualTo("");
        assertThat(getElementById("password").getCssValue("border-color")).isNotEqualTo("");
        getElementById("login").click();
        assertThat(getElementById("login").getCssValue("border-color")).isEqualTo("rgb(0, 0, 0)");
        getElementById("password").click();
        assertThat(getElementById("password").getCssValue("border-color")).isEqualTo("rgb(0, 0, 0)");
    }



    private void openPage() {
        driver.get("http://localhost:8082/login");
    }
}
