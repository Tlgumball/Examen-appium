package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProfilePage {
    public static final Target BTN_USER_MENU = Target.the("botón menú de usuario")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnUserMenu"));

    public static final Target BTN_LOGOUT = Target.the("botón cerrar sesión")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnLogout"));
}