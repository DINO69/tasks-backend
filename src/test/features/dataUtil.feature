
  @datautil
  Feature: Validar utilitario que compara datas para não permitir inserção de tarefas passadas


    @datautilmenor
    Scenario: Data menor que hoje
      Given que seja 11/06/2021
      When hoje for igual a 12/06/2021
      Then data menor


    @datautilmaior
    Scenario: Data maior que hoje
      Given que seja 13/06/2021
      When hoje for igual a 12/06/2021
      Then data maior

    @datautiligual
    Scenario: Data igual que hoje
      Given que seja 12/06/2021
      When hoje for igual a 12/06/2021
      Then data maior ou igual