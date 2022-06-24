package runners;



import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"stepdefinitions","SetUp"},
        features = "src/test/resources/features/EscenariosRest.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE, tags = "@Delete"
)
public class EmpleadosRunner {
}
