# Authentication in Tomcat

## Basic Authentication
Monitor the requests and responses between client and server. Explain how your Browser knows when to put up the login window (chrome://net-internals/#events)  
En Klient requester en protected resouce og serveren en pop-up box, hvor brugeren kan taste brugernavn og password.

Explain how your server knows that you are logged in for subsequent request.  


Copy the part that holds the Authorizations part and use the decode option on this link to comment what always must be done as a supplement when using Basic Http (and all other) authentication.  


Reflect (write down) the pros & cons of using Basic Authentication, and the use cases where it (still) could be relevant.  
Du er hele tiden logget ind, da browseren sender brugernavn og password med hvert request.  
Basic auth er stateless og client sided, hvilket gør det svært at like basic auth til java sessions.  

## Form authentication
Reflect (write down) the pros & cons of using Form-based Authentication, and the use cases where it could be relevant.  
Vi kan lave vores egen login page og redirecte til user/admin eller error page. Vi har mere kontrol over det her i forhold til form auth.  

## JWT-based Authentication Strategy for a REST-API
What is the advantage (if any) for a REST-based API of using JWT’s compared to session Cookies. 


What is the advantage (if any) for a REST based API of using JWT’s compared to Basic HTTP Authentication. 


What is the disadvantage (if any) with the implemented JWT-solution.  


What will a client (Single Page WEB, Mobile App, etc.) have to do in order to use this API.  




