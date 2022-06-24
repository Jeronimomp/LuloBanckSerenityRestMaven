package tasks;

import models.DatosEmpleadoConsulta;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import utils.Constantes;

import static utils.Constantes.PATH_GET_EMPLOYEE_ID;

public class ConsultarEmpleadoUnico implements Task {

    private DatosEmpleadoConsulta datosEmpleado;

    public ConsultarEmpleadoUnico(DatosEmpleadoConsulta datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_GET_EMPLOYEE_ID).with(req->req
                        .header("Content-Type","application/json")
                        .pathParam("id", datosEmpleado.getId())

                )
        );
        SerenityRest.lastResponse().prettyPrint();

    }

    public static ConsultarEmpleadoUnico porId(DatosEmpleadoConsulta datosEmpleado){
        return Tasks.instrumented(ConsultarEmpleadoUnico.class,datosEmpleado);
    }
}
