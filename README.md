<h2>BusJourneyManager</h2>
<br>BusJourneyManager is a Java Spring Boot application designed to efficiently manage bus routes, bus stops, and customer interactions. It provides functionality to add, update, and delete buses, as well as view all buses in the system. The platform also enables users to manage routes and stops, post reviews, leave comments, and share feedback, enhancing the overall customer experience with detailed route information and community-driven insights.

<br>

Features

•	Bus Stops Management: Add, update, and remove bus stops.

•	Route Controller: Create and manage bus routes.


•	Review System: Submit and manage customer reviews.

•	Post System: Create and manage user posts.

•	Comment System: Add comments to posts and reviews.

<br>

Technologies Used

•	Java

•	Spring Boot

•	Hibernate ORM

•	MySQL (or your preferred database)

•	RESTful APIs

•	Maven

•	Swagger

<br>

Getting Started

Prerequisites

•	Java JDK 8 or higher

•	Maven

•	MySQL (or your preferred database)

<br>

Installation

1.	Clone the repository:->git clone https://github.com/yourusername/BusBookingSystemSpringBoot.git
   
3.	Configure the database: Update the application.properties file with your database connection details.
   
5.	Access Swagger UI: Open your browser and go to http://localhost:9999/swagger-ui/swagger-ui/index.html
<br>

API Endpoints

Bus 

•	GET /api/buses - List all buses

•	POST /api/buses - Add a new bus

•	PUT /api/buses/{id} - Update a bus

•	DELETE /api/buses/{id} - Delete a bus


 Stops

•	GET /api/busstops - List all bus stops

•	POST /api/busstops - Add a new bus stop

•	PUT /api/busstops/{id} - Update a bus stop

•	DELETE /api/busstops/{id} - Delete a bus stop

<br>

Routes

•	GET /api/routes - List all routes

•	POST /api/routes - Add a new route

•	DELETE /api/routes/{id} - Delete a route

<br>


Reviews

•	POST /api/reviews - Submit a new review

•	DELETE /api/reviews/{id} - Delete a review

<br>

Posts

•	GET /api/posts - List all posts

•	POST /api/posts - Create a new post

•	DELETE /api/posts/{id} - Delete a post

<br>

Comments

•	GET /api/comments/{postId} - Get all comments for a post

•	POST /api/comments - Add a new comment

•	DELETE /api/comments/{id} - Delete a comment


Contributing

Contributions are welcome! Please fork the repository and submit a pull request.


License

MIT License

Copyright (c) 2024 Ashutosh Ranjan]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


