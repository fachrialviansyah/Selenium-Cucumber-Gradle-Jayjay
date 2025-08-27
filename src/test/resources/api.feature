Feature: Automation Testing REST API User Controller

  @get-test
  Scenario: Test Get List Data Users
    Given prepare url for "get_list_users"
    When hit api get list users
    Then validation status code is equals 200
    And validation response body get list users
    And validation response json with JSONSchema "get_list_users.json"


  @post-test
  Scenario: Test Create user
    Given prepare url for "create_new_user"
    And hit api post create new user
    Then validation status code is equals 201
    And validation response body post create new user
    And validation response json with JSONSchema "post_create_new_user.json"

  @put-test
  Scenario: Test Update User
    Given prepare url for "modif_user"
    And hit api post create new user
    Then validation status code is equals 201
    And validation response body post create new user
    And hit api update data
    And validation status code is equals 200
    And validation response body update user

  @delete-test
  Scenario: Test Delete User
    Given prepare url for "modif_user"
    When hit api post create new user
    Then validation status code is equals 201
    And validation response body post create new user
    And hit api delete new user
    And validation status code is equals 204


