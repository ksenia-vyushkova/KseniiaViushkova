Feature: Service Page Interface Tests

  Scenario: Service Page Interface Test
    Given I'm on the Home Page
    Then The browser title is correct

    When I login as user PITER_CHALOVSKII
    Then Username is displayed and has value pertaining to user PITER_CHALOVSKII
    And Home Page contains main elements

    When I click on "Service" button in Header
    Then Header "Service" dropdown contains appropriate services

    When I click on "Service" sidebar dropdown
    Then Sidebar "Service" dropdown contains appropriate services

    When I open "Different Elements" page through "Service" header dropdown
    Then Expected elements are present
    And Navigation sidebar is displayed
    And Log sidebar is displayed

    When I tick checkbox WATER
    Then Last log contains a record about of ticking checkbox WATER

    When I tick checkbox WIND
    Then Last log contains a record about of ticking checkbox WIND

    When I select radio button SELEN
    Then Last log contains a record about of selecting radio button SELEN

    When I select color YELLOW
    Then Last log contains a record about selecting color YELLOW

    When I untick checkbox WATER
    Then Checkbox WATER is unchecked
    And Last log contains a record about of unticking checkbox WATER

    When I untick checkbox WIND
    Then Checkbox WIND is unchecked
    And Last log contains a record about of unticking checkbox WIND