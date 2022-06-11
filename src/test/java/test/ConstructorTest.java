package test;

import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static util.UserInteraction.assertElementInState;

public class ConstructorTest extends BaseTest {

    @Test
    public void testNavigationToBuns() {
        mainPage.clickSauces();

        waitUntilCategoryLoads(mainPage.getSaucesButton());

        mainPage.clickBuns();

        assertElementInState(mainPage.getBunsHeader(), visible);
    }

    @Test
    public void testNavigationToSauces() {
        mainPage.clickIngredients();

        waitUntilCategoryLoads(mainPage.getIngredientsButton());

        mainPage.clickSauces();

        assertElementInState(mainPage.getSaucesHeader(), visible);
    }

    @Test
    public void testNavigationToIngredients() {
        mainPage.clickIngredients();

        assertElementInState(mainPage.getIngredientsHeader(), visible);
    }

    private void waitUntilCategoryLoads(SelenideElement element) {
        String classes = element.getAttribute("class");

        while (true) {
            if (Arrays.asList(classes.split(" ")).contains("tab_tab_type_current__2BEPc"))
                break;
        }
    }
}
