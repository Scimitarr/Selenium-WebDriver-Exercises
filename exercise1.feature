Feature: Exercises

@ten
Scenario: Exercise1
    Given Uzytkownik wszedl na strone "https://antycaptcha.amberteam.pl:5443/exercises/exercise1"
    When Uzytkownik klika w pierwszy przycisk
    And Uzytkownik klika w drugi przycisk
    And Uzytkownik klika w trzeci przycisk
    And Uzytkownik klika w przycisk checkSolution
    Then Uzytkownik widzi napis OK. Good answer
