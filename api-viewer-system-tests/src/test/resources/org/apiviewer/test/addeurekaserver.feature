Feature: Add Eureka Server with NickName , IP Address and Port.

Scenario: Add Eureka Server with all information via POST
When I add Eureka server with NICKNAME "testEurekaServer1", IPADDRESS "10.20.30.40" and PORT "8085"
Then I receive a link in location header for added Eureka Server
And I can retrieve the added Eureka Server
