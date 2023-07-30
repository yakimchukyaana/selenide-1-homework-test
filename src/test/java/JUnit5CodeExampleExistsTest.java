import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JUnit5CodeExampleExistsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void jUnit5CodeExampleExistsTest() {
        //open selenide page in github
        Selenide.open("https://github.com/selenide/selenide");
        //open wiki tab
        $("#wiki-tab").click();
        //check whether it has page soft assertions
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        //go to soft assertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //check if it has junit5 code example
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class:\n" +
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}

