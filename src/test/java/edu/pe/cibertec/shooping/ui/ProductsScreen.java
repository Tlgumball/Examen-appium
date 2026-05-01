package edu.pe.cibertec.shooping.ui;


import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsScreen {
    public static Target categoryFilter(String category) {
        return Target
                .the(category + " category filter")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + category + "']"));
    }

    public static Target productByName(String productName) {
        return Target
                .the("Product: "+ productName)
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']"));
    }

    public static final Target TXT_SEARCH = Target.the("Campo de búsqueda")
            .located(By.id("com.cibertec.shopping:id/txtSearch"));

    public static final Target BTN_FILTER = Target.the("Botón para abrir filtros")
            .located(By.id("com.cibertec.shopping:id/btnFilter"));





}
