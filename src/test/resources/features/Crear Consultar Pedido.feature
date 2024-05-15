@pet
Feature: Gestión de Órdenes


  @test1
  Scenario Outline: Crear Pedido
    //Given la url "https://petstore.swagger.io/v2/store/order" del servicio de petstore
    When crea pedido con id <id>, petId <petId>, quantity <quantity>, shipDate <shipDate>, status <status>, complete <complete>
    Then valido que codigo de respuesta sea 200
    And validar que el id creado sea el ingresado
    Examples:
      | id  | petId | quantity | shipDate                 | status | complete |
      | 500 | 1     | 2        | 2024-05-14T23:02:55.679Z | placed | true     |
      | 501 | 3     | 1        | 2024-05-14T23:02:55.679Z | placed | true     |

  @test2
  Scenario Outline: Consultar Pedido
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio petstore
    When consulta el identificador de un pedido existente <id>
    Then valido que el codigo de respuesta sea 200
    And valido los detalles del pedido solicitado
    Examples:
      | id  |
      | 500 |
      | 501 |





