package stepdefinitions;

import Exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import models.DatosEmpleadoEliminacion;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidarEliminacion;
import tasks.EliminarEmpleado;

import java.util.List;
import java.util.Map;

import static Exceptions.EmployeeException.MESSAGE;
import static org.hamcrest.Matchers.equalTo;

public class EliminarEmpleadoStepDefinitions {

    @DataTableType
    public DatosEmpleadoEliminacion infoEmployeeEntry(Map<String, String> entry){
        DatosEmpleadoEliminacion obj = new DatosEmpleadoEliminacion();
        obj.setStatus(entry.get("status") == null ? "" : entry.get("status"));
        obj.setData(entry.get("data") == null ? "" : entry.get("data"));
        obj.setMessage(entry.get("message") == null ? "" : entry.get("message"));
        return obj;
    }

    @When("se busca el empleado a eliminar con el id {int}")
    public void seBuscaElEmpleadoAEliminarConElId(Integer numId) {

        OnStage.theActorInTheSpotlight().attemptsTo(
       EliminarEmpleado.porId(numId)

        );

    }
    @Then("se observa el mensaje de eliminación")
    public void seObservaElMensajeDeEliminación(DatosEmpleadoEliminacion datosEliminacion) {
   OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarEliminacion.porMensaje(datosEliminacion.getMessage()),equalTo(true))
           .orComplainWith(EmployeeException.class, MESSAGE));
    }
}
