Feature: Update and Delete the ResQes functionality

  Scenario: verify user delete the request
    Given user wants to call "/users" end point
    And set header "Content-Type" to "application/json"
    And set request body from the pojo_file "createResQes.json"
    When user performs post call
    Then verify status code is 201
    And verify booking id is not empty
    And user stores created request id into "request.id"
    And  user wants to call "/users/@id" end point
    When set header "Content-Type" to "application/json"
    And set request body from the file "updateResQes.json"
    And user perform put call
    Then verify status code is 200
    When  user wants to call "/users/@id" end point
    And user perform delete call
    Then verify status code is 204


