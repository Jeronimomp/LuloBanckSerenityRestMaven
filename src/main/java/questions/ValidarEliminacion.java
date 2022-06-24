package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Tasks;

import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidarEliminacion implements Question {
    private String mensajeEsperado;

    public ValidarEliminacion(String mensajeEsperado) {
        this.mensajeEsperado = mensajeEsperado;
    }

    @Override
    public Object answeredBy(Actor actor) {

        String mensajeResponse= SerenityRest.lastResponse().then().extract().body().asString();
        assertThat(from(mensajeResponse).get("message"),equalTo(mensajeEsperado));
        return true;

    }
public static ValidarEliminacion porMensaje(String mensajeEsperado){
        return new ValidarEliminacion(mensajeEsperado);
}

}
