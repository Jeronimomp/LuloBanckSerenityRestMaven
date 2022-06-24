package tasks;


import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import utils.Constantes;

import static utils.Constantes.PATH_GET_EMPLOYEES;


public class ConsultarEmpleados implements Task{

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_GET_EMPLOYEES).with(req->req
                        .header("Content-Type","application/json")
                )
        );
        SerenityRest.lastResponse().prettyPrint();

    }


  public static ConsultarEmpleados porMensajeRespuesta(){
  return Tasks.instrumented(ConsultarEmpleados.class);
  }



}
