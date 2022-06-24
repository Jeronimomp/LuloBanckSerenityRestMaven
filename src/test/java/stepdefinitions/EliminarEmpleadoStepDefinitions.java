package stepdefinitions;

import Exceptions.EmployeeException;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidarEliminacion;
import tasks.EliminarEmpleado;

import java.util.List;
import java.util.Map;

import static Exceptions.EmployeeException.MESSAGE;
import static org.hamcrest.Matchers.equalTo;

public class EliminarEmpleadoStepDefinitions {


    @When("se busca el empleado a eliminar por")
    public void seBuscaElEmpleadoAEliminarPor(List<Map> table ) {

        OnStage.theActorInTheSpotlight().attemptsTo(
         EliminarEmpleado.porId((String) table.get(0).get("id"))

        );

    }
    @Then("se observa el mensaje de eliminación")
    public void seObservaElMensajeDeEliminación(List<Map> tablaMensaje) {
   OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarEliminacion.porMensaje((String) tablaMensaje.get(0).get("mensaje")),equalTo(true))
           .orComplainWith(EmployeeException.class, MESSAGE));
    }
}
