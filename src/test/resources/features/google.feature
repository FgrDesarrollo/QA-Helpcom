Feature: Probar la busqueda en google

Scenario: Un usuario busca algo en google
    Given   navego en google
    When    busco algo
    And     presiono el boton buscar
    Then    Obtengo algo

