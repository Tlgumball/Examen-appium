@checkout
Feature: Proceso de compra

  Scenario: Completar compra exitosamente
    Given que el usuario tiene productos en el carrito
    When procede al checkout
    And ingresa los datos de envio
    And confirma la compra
    Then deberia ver el mensaje de compra exitosa

  Scenario: Carrito vacio no permite checkout
    Given que el usuario tiene el carrito vacio
    When intenta proceder al checkout
    Then deberia ver mensaje de carrito vacio

  @error_envio
  Scenario: No permitir completar la compra sin ingresar direccion de envio
    Given que el usuario tiene productos en el carrito
    When procede al checkout
    And intenta confirmar la compra sin direccion
    Then deberia ver un mensaje de advertencia solicitando direccion