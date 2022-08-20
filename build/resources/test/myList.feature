Feature: My list

  Scenario: Add list

    # vamos a usar un mapa como argumento  key:valor
    Given ingreso a la app de WhenDo

    #vamos a utilizr un objeto
    When yo agrego una nueva nota
      | titulo | prueba    |
      | notes  | TallerSession |

    Then se debe crear la nota "prueba"