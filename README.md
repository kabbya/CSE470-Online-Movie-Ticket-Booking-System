
# Online Movie Ticket Buying System

An website where people can buy movie ticket online. Admin will upload the movie on the website and User can simply purchase ticket from online without standing at the long queue. The user will pay online, and Admin will manually verify the payment status. The user can also refund ticket.

## Features

Admin:

-	Login, Logout
-	Upload Movie with Image
-	Update Movie Information
-	Delete Movie
-   Search Movie
-   Update Payment Status

User:
-	Registration, Login and Logout
-   Search Movie by Name
-	Can Buy Movie Tickets 
-	Refund Policy 
-	Pay Online
-	Pages of User Profile, User Watchlist, User Payment History



## Requirements

I have Used Spring Boot and followed MVC pattern to complete this poject.

I have added the following dependencies for this project:

- Spring Boot DevTools
- Spring Data JPA
- MySQL Driver
- Thymeleaf
- Spring Web

After that we have to configure our database and server port. I have set my locahost port as 9292. My database name is "movie_ticket_db" and TCP port is 3306.

```
server.port=9292

spring.datasource.url=jdbc:mysql://localhost:3306/movie_ticket_db
spring.datasource.username= ( Give your Username )
spring.datasource.password= ( Give your Password )
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

spring.servlet.multipart.max-file-size=-1
spring.servlet.multipart.max-request-size=-1
```
## Screenshots


Website Langing Page

<img src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Landing Page.PNG">

User Registration Form

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Registration%20Form.PNG">

User Login Form

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Login%20Form.PNG">

User Dashboard

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Dashboard.PNG">

Admin Dashboard

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20Dashboard.PNG">

Admin Upload Movie Form

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20Upload%20Movie%20Form.PNG">

Admin Update Movie Form

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20Update%20Movie%20Form.PNG">

Admin Movie List View

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20Movie%20View.PNG">

Use Movie List view

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Movielist%20View.jpg">

User Buy Ticket Form

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Buy%20Ticket%20Form.PNG">

Admin Payment Update Panel

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20Payment%20Update%20Panel.PNG">

Admin All Payment History View Page

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/Admin%20All%20Transaction%20History.PNG">

User's Own Payment History

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Transaction%20History.PNG">

User's Purchased List Page

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Purchase%20List%20View.jpg">

User Refund Ticket

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Refund%20Ticket.PNG">

User Profile

<imt src="https://github.com/kabbya/CSE470-Online-Movie-Ticket-Booking-System/blob/main/Screenshot/User%20Profile.PNG">

