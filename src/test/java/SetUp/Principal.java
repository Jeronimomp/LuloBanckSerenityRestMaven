package SetUp;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import io.cucumber.java.Before;

import static utils.Constantes.BASE_URL;
import static utils.Constantes.EL_ACTOR;


public class Principal {

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast()) ;
        OnStage.theActorCalled(EL_ACTOR);
        OnStage.theActorInTheSpotlight().can(CallAnApi.at(BASE_URL));
    }
}
