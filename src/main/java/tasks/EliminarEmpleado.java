package tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import utils.Constantes;

import static utils.Constantes.PATH_DELETE_EMPLOYEE;

public class EliminarEmpleado implements Task {
    private int id;

    public EliminarEmpleado(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PATH_DELETE_EMPLOYEE).with(rq ->rq
                        .header("Content-Type","application/json")
                        .pathParam("id",id)
                )
        );
        SerenityRest.lastResponse().prettyPrint();

    }
    public static EliminarEmpleado porId(int id){
        return Tasks.instrumented(EliminarEmpleado.class, id);
    }
}
