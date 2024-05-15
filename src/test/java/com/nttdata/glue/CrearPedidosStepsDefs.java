package com.nttdata.glue;

import com.nttdata.step.CrearPedido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearPedidosStepsDefs {
    /*
    private CrearPedido pedidos;*/

    @Steps
    CrearPedido crearpedido;
/*
    @Given("la url {string} del servicio de petstore")
    public void laUrlDelServicioDePetstore(String url) {
        pedidos.setURL(url);
    }*/

    @When("crea pedido con id {}, petId {}, quantity {}, shipDate {}, status {}, complete {}")
    public void creaPedidoConIdPetIdQuantityShipDateStatusComplete(int id, int petId, int quantity, String shipDate, String status, String complete) {
        crearpedido.crearPedido( id,  petId,  quantity ,  shipDate,  status,  complete);
    }

    @Then("valido que codigo de respuesta sea {int}")
    public void validoQueCodigoDeRespuestaSea(int code1) {

        crearpedido.validoQueCodigoDeRespuestaSea(code1);

    }

    @And("validar que el id creado sea el ingresado")
    public void validarQueElIdCreadoSeaElIngresado() {
/*
        crearpedido.validarQueElIdCreadoSeaElIngresado();
*/
    }
}
