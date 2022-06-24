package stepdefinitions;

import Exceptions.EmployeeException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import models.DatosEmpleadoConsulta;
import models.DatosEmpleadoCreacion;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import questions.ValidarCreacion;
import tasks.CrearEmpleado;

import java.util.Map;

import static Exceptions.EmployeeException.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CrearEmpleadoStepDefinitions {

    @DataTableType
    public DatosEmpleadoCreacion infoEmployeeEntry(Map<String, String> entry){
        DatosEmpleadoCreacion obj = new DatosEmpleadoCreacion();
        obj.setName(entry.get("name") == null ? "" : entry.get("name"));
        obj.setSalary(entry.get("salary") == null ? "" : entry.get("salary"));
        obj.setAge(entry.get("age") == null ? "" : entry.get("age"));
        return obj;
    }

    @When("se crea un empleado con los siguiente datos")
    public void seCreaUnEmpleadoConLosSiguienteDatos(DatosEmpleadoCreacion datosEmpleadoCreacion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CrearEmpleado.conSusDatos(datosEmpleadoCreacion)
        );
    }
    @Then("se velida el empleado creado con codigo de exito {int}")
    public void seVelidaElEmpleadoCreadoConCodigoDeExito(Integer statusCode){
        OnStage.theActorInTheSpotlight().should(seeThat(ValidarCreacion.empleados(), Matchers.equalTo(statusCode))
                .orComplainWith(EmployeeException.class, MESSAGE));

    }
}
