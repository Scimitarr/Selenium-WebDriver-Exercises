Feature: Testowanie logowania
    
Scenario: Poprawne logowanie
    Given Uzytkownik jest na stronie "https://the-internet.herokuapp.com/login"
    When Uzytkownik w pole o id "username" wprowadza wartosc "tomsmith"
    And Uzytkownik w pole o id "password" wprowadza wartosc "SuperSecretPassword!"
    And Uzytkownik klika w przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany

@now
Scenario: Niepoprawne logowanie
    Given Uzytkownik jest na stronie "https://the-internet.herokuapp.com/login"
    When Uzytkownik w pole o id "username" wprowadza wartosc "tomsmith1"
    And Uzytkownik w pole o id "password" wprowadza wartosc "SuperSecretPassword!1"
    And Uzytkownik klika w przycisk Login
    Then Uzytkownik nie zostal zalogowany