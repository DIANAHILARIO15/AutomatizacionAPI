package com.nttdata.step;


import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class CrearConsultarPedidos {
    private String URLBASE;

    public void setURL(String url) {
        this.URLBASE = url;
        System.out.println("SET URL: " + url);
    }

    public void ConsultarPedido(int id){
        System.out.println("Consultando pedido: " + id);

        SerenityRest.given()
                .baseUri(URLBASE)
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .when()
                .log()
                .all()
                .get("/"+ id)
                .then()
                .log()
                .all()
                ;
    }


    public void validoQueElCodigoDeRespuestaSea(int code) {

        Assert.assertEquals(code, lastResponse().getStatusCode());
    }

    public void validoLosDetallesDelPedidoSolicitado() {
        System.out.println("El id del pedido consultado es: " +lastResponse().body().path("id").toString());



    }


}
