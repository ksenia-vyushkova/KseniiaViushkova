Feature: User Table Interface Tests

  Scenario: User Table Page Test

    Given I'm on the Home Page
    When I login as user PITER_CHALOVSKII
    When I open Service dropdown in header
    And I open USER_TABLE page through Service header dropdown
    Then "User Table" page is opened
    And 6 NumberType Dropdowns are displayed on Users Table on User Table Page
    And 6 User names are displayed on Users Table on User Table Page
    And 6 Description images are displayed on Users Table on User Table Page
    And 6 Description texts under images are displayed on Users Table on User Table Page
    And 6 checkboxes are displayed on Users Table on User Table Page

    And User table contains following values:
      | Number | User             | Description                       |
      | 1      | Roman            | Wolverine                         |
      | 2      | Sergey Ivan      | Spider Man                        |
      | 3      | Vladzimir        | Punisher                          |
      | 4      | Helen Bennett    | Captain America\nsome description |
      | 5      | Yoshi Tannamuri  | Cyclope\nsome description         |
      | 6      | Giovanni Rovelli | Hulk\nsome description            |

    When I select "vip" checkbox for SERGEY_IVAN
    Then 1 log row has "Vip: condition changed to true" text in log section

    When I click on dropdown in column Type for user ROMAN
    Then droplist contains expected values for user ROMAN
      | Admin   |
      | User    |
      | Manager |