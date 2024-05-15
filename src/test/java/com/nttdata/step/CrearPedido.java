package com.nttdata.step;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CrearPedido {
    private static String CREATE_PEDIDO = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear pedido {0} en PetStore")
    public void crearPedido(int id, int petId, int quantity, String shipDate, String status, String complete) {
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \""+shipDate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\":true\n" +
                        "}")
                .log()
                .all()
                .post(CREATE_PEDIDO);
    }


    public void validoQueCodigoDeRespuestaSea(int code1) {

        Assert.assertEquals(code1, lastResponse().getStatusCode());
        SerenityRest.given()
                .contentType("application/json")
                .log()
                .all();
    }


    public void validarQueElIdCreadoSeaElIngresado() {
/*
        System.out.println("El id del pedido creado es: " +lastResponse().body().path("id").toString());
*/

    }
}
