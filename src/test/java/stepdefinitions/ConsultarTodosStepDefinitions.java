package stepdefinitions;


import Exceptions.EmployeeException;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidarTodos;
import tasks.ConsultarEmpleados;

import static Exceptions.EmployeeException.MESSAGE;
import static org.hamcrest.Matchers.equalTo;


public class ConsultarTodosStepDefinitions {

    @When("se consulta el servicio web de todos los empleados")
    public void seConsultaElServicioWebDeTodosLosEmpleados() {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarEmpleados.porMensajeRespuesta());
    }

    @Then("se valida el mensaje de exito {string}")
    public void seValidaElMensajeDeExito(String mensajeEsperado) {
         OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(
             ValidarTodos.losEmpleadosPor(mensajeEsperado),equalTo(true))
                 .orComplainWith(EmployeeException.class, MESSAGE));

    }
}
