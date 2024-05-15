package com.nttdata.glue;

import com.nttdata.step.CrearConsultarPedidos;
import com.nttdata.step.CrearPedido;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearConsultarPedidosStepDef {
    @Steps
    private CrearConsultarPedidos pedidos;
    private CrearPedido crearpedido ;

    @Given("la url {string} del servicio petstore")
    public void laUrlDelServicioPetstore(String url) {
        pedidos.setURL(url);
    }

    @When("crea el pedido con id {}, petId {}, quantity {}, shipDate{}, status{}, complete{}")
    public void creaElPedidoConIdPetIdQuantity(int id, int petId, int quantity, String shipDate, String status, String complete) {
        //c.crearPedido(id, petId, quantity);
        crearpedido.crearPedido( id,  petId,  quantity ,  shipDate,  status,  complete);
    }


    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int code) {
        pedidos.validoQueElCodigoDeRespuestaSea(code);
    }

    @And("el body es {string}")
    public void elBodyEs(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }




    @When("consulta el identificador de un pedido existente {}")
    public void consultaElIdentificadorDeUnPedidoExistente(int id) {

        pedidos.ConsultarPedido(id);
    }

    @And("valido los detalles del pedido solicitado")
    public void validoLosDetallesDelPedidoSolicitado() {

        pedidos.validoLosDetallesDelPedidoSolicitado();

    }


}
