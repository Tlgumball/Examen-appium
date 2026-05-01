package edu.pe.cibertec.shooping.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginScreen {

    public static final Target EMAIL_FIELD = Target.the("campo de correo electrónico")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/editEmail"));


    public static final Target PASSWORD_FIELD = Target.the("campo de contraseña")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/editPassword"));


    public static final Target LOGIN_BUTTON = Target.the("botón para iniciar sesión")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/btnLogin"));


    public static final Target LBL_ERROR_MESSAGE = Target.the("mensaje de error de login")
            .located(By.id("edu.pe.cibertec.shooping_cart_appium_demo:id/lblError"));
}
