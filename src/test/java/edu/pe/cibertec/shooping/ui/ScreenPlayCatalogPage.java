package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ScreenPlayCatalogPage {

    public static final Target TXT_SEARCH = Target.the("Campo de búsqueda")
            .located(By.id("com.cibertec.shopping:id/txtSearch"));

    public static final Target LBL_PRODUCT_LIST = Target.the("Lista de productos")
            .located(By.id("com.cibertec.shopping:id/recyclerViewProducts"));

    public static Target categoryOption(String category) {
        return Target.the("Categoría " + category)
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + category + "']"));
    }

    public static Target productItem(String name) {
        return Target.the("Producto " + name)
                .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + name + "')]"));
    }
}