package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target BTN_CONFIRM = Target.the("botón confirmar compra")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnConfirm"));

    public static final Target LBL_SUCCESS = Target.the("mensaje de éxito")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/lblSuccess"));

    public static final Target LBL_EMPTY_ERROR = Target.the("error carrito vacío")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/lblEmptyCart"));
}