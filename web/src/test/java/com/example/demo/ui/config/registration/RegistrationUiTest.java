package com.example.demo.ui.config.registration;

import com.example.demo.ui.config.SeleniumConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationUiTest extends SeleniumConfig {

    @Test
    void shouldLoadLogoOnthePage() {
        openPage();
        assertThat(getElementById("logo").isDisplayed());

    }

    @Test
    void shouldDisplayErrorContainerWhenRequiredFieldsAreNotEntered() {
        openPage();
        assertThat(getElementById("error-container").getCssValue("display")).isEqualTo("none");
        WebElement submitButton = getElementById("submit");
        submitButton.click();
        assertThat(getElementById("error-container").isDisplayed());
    }



    private void openPage() {
        driver.get("http://localhost:8082/register");
    }
}
