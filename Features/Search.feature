Feature: Product Search

  Scenario: Product Search
    Given the user navigates to login page
    When user enters email as "Deepu.k@gmail.com" and password as "9494144858"
    And the user clicks on the Login button
    And the user search for a product (productName: "MacBook")
    And the user clicks on the required product from search result
    And the user navigates to the product details page and updates quantity (quantity: "2")
    And the user clicks on Add to cart button
    Then the user should see a message Added to cart Successfully
