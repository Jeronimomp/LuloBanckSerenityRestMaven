package tasks;

import models.DatosEmpleadoCreacion;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import utils.Constantes;

import static utils.Constantes.PATH_CREATE_EMPLOYEE;

public class CrearEmpleado implements Task {
    private DatosEmpleadoCreacion datosEmpleado;

    public CrearEmpleado(DatosEmpleadoCreacion datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Post.to(PATH_CREATE_EMPLOYEE).with(rq -> rq
                        .header("Content-Type", "application/json")
                        .body(datosEmpleado).log().all())
        );


        SerenityRest.lastResponse().prettyPrint();
    }

    public static CrearEmpleado conSusDatos(DatosEmpleadoCreacion datosEmpleado){
        return Tasks.instrumented(CrearEmpleado.class, datosEmpleado);
    }
}
