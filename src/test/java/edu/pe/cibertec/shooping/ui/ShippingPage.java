package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShippingPage {
    public static final Target TXT_ADDRESS = Target.the("campo dirección")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/txtAddress"));

    public static final Target BTN_NEXT = Target.the("botón siguiente")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnNext"));

    public static final Target LBL_ADDRESS_ERROR = Target.the("error dirección requerida")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/lblErrorAddress"));
}