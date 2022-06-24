package stepdefinitions;

import Exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import models.DatosEmpleadoConsulta;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.ValidarEmpleadoUnico;
import tasks.ConsultarEmpleadoUnico;

import java.util.List;
import java.util.Map;

import static Exceptions.EmployeeException.MESSAGE;
import static org.hamcrest.Matchers.equalTo;

public class ConsultarPorIdStepDefinitions {

    @DataTableType
    public DatosEmpleadoConsulta infoEmployeeEntry(Map<String, String> entry){
        DatosEmpleadoConsulta obj = new DatosEmpleadoConsulta();
        obj.setId(entry.get("id") == null ? "" : entry.get("id"));
        obj.setEmployee_name (entry.get("employee_name") == null ? "" : entry.get("employee_name"));
        obj.setEmployee_salary(entry.get("employee_salary") == null ? "" : entry.get("employee_salary"));
        obj.setEmployee_age(entry.get("employee_age") == null ? "" : entry.get("employee_age"));
        return obj;
    }

    @When("consultar usuario con id")
    public void consultarUsuarioConId(DatosEmpleadoConsulta datosEmpleado) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarEmpleadoUnico.porId(datosEmpleado));
    }
    @Then("Deberia ver la informacion del usuario")
    public void deberiaVerLaInsofrmacionDelUsuario(DatosEmpleadoConsulta datosEmpleado) {


     OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarEmpleadoUnico.porSusDatosPersonales(datosEmpleado),equalTo(true))
             .orComplainWith(EmployeeException.class, MESSAGE));
    }
}
