@PedidoLinio
Feature: Pedido en Linio

  Scenario: Login en Linio
    Given Que estoy en la pagina de inicio de Linio
    When  Ingreso mis credenciales "no.david.albornoz@gmail.com" y pass "c3p0r2d2"
    Then  Hago click en el boton iniciar sesión
    And   Valido que estoy logeado correctamente con el nombre "David Dominick"


  Scenario: Agregar Producto al carrito exitosamente

    Given Estoy logeado
    When  Hago click en mejores calificados
    And   Hago click en cualquier producto
    And   Hago click en el boton añadir al carrito
    Then  El producto se agrego al carrito
    And   Valido que se agrego al carrito con el mensaje "Tu producto se agregó al carrito"