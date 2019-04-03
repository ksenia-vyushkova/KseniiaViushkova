# TODO Take a look on the recommended project structure https://docs.cucumber.io/guides/10-minute-tutorial/
# TODO Basically, you should not create methods that sound like "I click/tick/whatever_low_level_action".
#      Just think about business stuff, for the example "I select nature element WATER"
Feature: Different Elements page test

  Scenario: Basic functionality test
    Given I'm on the Home Page
    Then The page title is correct

    When I login as user PITER_CHALOVSKII
    Then Username is displayed and has value pertaining to user PITER_CHALOVSKII
    And Home Page contains main elements

    # TODO It will be better with parameter
    When I open Service dropdown in header
    Then Header Service dropdown contains services:
      | Services           |
      | SUPPORT            |
      | DATES              |
      | SEARCH             |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I open Service sidebar dropdown
    Then Sidebar Service dropdown contains services:
      | Services           |
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | SEARCH             |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I open DIFFERENT_ELEMENTS page through Service header dropdown
    #!TODO
    Then Expected elements are present
    And Navigation sidebar is displayed
    And Log sidebar is displayed

    When I select WATER element
    Then Last log contains a record about selecting WATER element

    When I select WIND element
    Then Last log contains a record about selecting WIND element

    When I select SELEN material
    Then Last log contains a record about selecting SELEN material

    When I select color YELLOW
    Then Last log contains a record about selecting color YELLOW

    When I deselect WATER element
    Then Element WATER is deselected
    And Last log contains a record about deselecting WATER element

    When I deselect WIND element
    Then Element WIND is deselected
    And Last log contains a record about deselecting WIND element