package questions;

import models.DatosEmpleadoConsulta;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidarEmpleadoUnico implements Question<Boolean> {

   private DatosEmpleadoConsulta datosEmpleado;

    public ValidarEmpleadoUnico(DatosEmpleadoConsulta datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String mensajeResponse= SerenityRest.lastResponse().then().extract().body().asString();
        assertThat(from(mensajeResponse).get("data.employee_name"),equalTo(datosEmpleado.getEmployee_name()));

        return true;

    }

    public static ValidarEmpleadoUnico porSusDatosPersonales(DatosEmpleadoConsulta datosEmpleado){
        return new ValidarEmpleadoUnico(datosEmpleado);
    }
}
