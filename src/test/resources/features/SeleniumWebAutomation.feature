@webautomation
Feature: Search
  Scenario:Search,add and delete item
    Given open web page
    When search computer on search box
    Then open page two
    And check whether page two open or not
    And choose a rondom product from results
    And write product info and price to file
    And add product to cart
    Then compare cart and product page  price
    And increase the product quantity and verify that it is two
    Then delete product and check cart is empty or not








