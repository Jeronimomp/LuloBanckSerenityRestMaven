package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
public class ValidarTodos implements Question <Boolean> {
    String mensajeEsperado;

    public ValidarTodos(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String mensajeResponse= SerenityRest.lastResponse().then().extract().body().asString();
        assertThat(from(mensajeResponse).get("message"),equalTo(mensajeEsperado));
        return true;
    }

    public static  ValidarTodos losEmpleadosPor(String mensajeEsperado){
        return new ValidarTodos(mensajeEsperado);
    }
}
