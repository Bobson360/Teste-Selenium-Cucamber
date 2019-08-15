

Feature: Pesquisa

  Scenario: Pesquisa diretor de cinema e filme
    Given Dado que eu esteja na pagina de buscas do google
    When quando eu pesquisar por um diretor de cinema e um de seus filmes
    Then entao devo retornar o numero de resultados