Feature: Subscription on Testmaster.vn
  Scenario Outline: Show error message below email field after subscribing with invalid email
    Given The testmaster homepage has been shown
    When The user subscribe with an invalid email <value>
    Then The error message "* Email không đúng định dạng" is shown in red color
    And The border of email field is changed to red color

    Examples:
      | value          |
      | -              |
      | lan            |
      | lan@           |
      | lan@gmail.     |
      | lan @gmail.com |

    #scenario 2
  Scenario: Show message after subscribe with an email in used
    Given The testmaster hompage has been shown
    When The user subscribe with an email "lan.pc.hbt@gmail.com" in used
    Then The message "E-mail lan.pc.hbt@gmail.com đã được sử dụng, bạn hãy chọn một E-mail khác" is shown
    And The focus is set back Email field after the user agree with the message
    And The content of Email field is cleared

    #scenario 3
  Scenario: Show extra information popup after subscribe with an email not in used
    Given The testmaster homepage is shown
    When The user subscribes with email"lan1@gmail.com" not in used
    Then The extra information popup is shown with default value of gender and news type
    And The focus is set on Fullname field

    #scenario 4
  Scenario: Show required input after subscribe with fullname blank
    Given The testmaster homepage is shown
    When The user subscribe with fullname blank on the extra popup
    Then The require message "* Bạn cần phải nhập dữ liệu" is shown with red color
    And The border of fullname field is changed to red and the background is yellow