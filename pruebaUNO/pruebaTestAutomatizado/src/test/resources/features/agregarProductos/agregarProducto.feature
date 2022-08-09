Feature: Yo como usuario,
  Quiero agregar un producto al carrito y validar su precio

  Background:
    Given Entro a Amazon

  Scenario Outline: Agrego un producto y lo valido
    Given entro a los mas vendidos
    When agrego el producto y lo valido
    | <addProduct> | <price> |
    And valido el carrito
    | <cartValidate> | <cartValidateNotHave> |
    Examples:
    | addProduct                                                     | price | cartValidate | cartValidateNotHave |
    | Pokémon Brilliant Diamond - Standard Edition - Nintendo Switch | 749   | $749.99      | $800.00             |