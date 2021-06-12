

  Feature: Validar utilitario que compara datas para não permitir inserção de tarefas passadas


    Scenario: Data menor que hoje
      Given que seja 11/06/2021
      When hoje for igual a 12/06/2021
      Then data menor