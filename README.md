##These are the only relevent microservices at this point more would be cool but are not required for the assignment.
-Capstone-Server
-Capstone-Login
-Capstone-Flight-Planning

##Capstone-Server
#This binds the microservices togeather and must be launched first.
  Has no other functionality.

##Capstone-Login
#This is to allow the user either as customer or as admin to login.
  This calls the user Controller in Capston-Flight-Planning with restTemplate.
  The user Controller then uses user service to varify the user in the database.
  After that the users ID should be stored in the session.
#Their user Id being stored in session should allow user to call appropriate methods
  that require user ID field.
  As of now when testing with Postman It seems that Logins call to the user service with the restTemplate creates
  its own session and I end up with two session IDs.

  ##Capstone-Flight-Planning
  #This is the bulk of tha application possibly more bulky than I would like. In retrospect having a completely separate user microservice might have been a good idea
    However since I am having trouble getting the microservices to communicate properly I am not going to change it at this time.
  #This part of the App handles
  -User Verification through the user Controller
  -Flight Booking for the user through FlightBookingController
  -Flight Planning for admin through the FlightController
  -As well as a veriety of search methods for each.
