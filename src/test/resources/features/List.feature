Feature: Probar encontrar un elemento de una lista tipo dropdown
@Test
Scenario: Un usuario busca un texto especifico dentro de una lista
    Given   Navego a la lista de la pagina
    When    Busco algo de la lista
    Then    Encuentro el texto que busco en la lista