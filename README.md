# OEMS-Online event management sysyem

Evenzet - Event Management System

Evenzet is a comprehensive event management system designed to help individuals and organizations seamlessly plan, manage, and execute events. It allows users to easily manage event details, attendee registrations, tickets, and much more.

Table of Contents
Introduction
Features
Technologies Used
Project Structure
Setup Instructions
Screenshots
Contributors
License

Introduction
Evenzet is an innovative platform that aims to streamline the event management process. Whether you are hosting a corporate seminar, a wedding, or a community event, Evenzet allows you to manage all aspects of your event in one place.

Key Features:
Event Planning: Allows users to plan and organize their events effortlessly.
Attendee Management: Manage attendee registrations, tickets, and communications in an easy-to-use interface.
Analytics & Insights: Provides real-time reports and analytics on event performance.
User Dashboard: A personalized dashboard for both event organizers and attendees to track events, registrations, and more.
User Types: Admin, Event Organizer, and Attendee user roles with distinct functionalities.
This project is being developed by a dedicated team from Galgotias University.

Features
Event Creation and Management: Easily create events, set dates, manage schedules, and invite attendees.
Registration and Ticketing: Handle registrations and manage ticket sales for different events.
Real-Time Analytics: Get valuable insights into attendee participation, feedback, and event performance.
User Management: The platform supports Admin, Event Organizer, and Attendee roles, each with specific permissions and functionalities.
Contact & Support: Reach out for support and get in touch with the team via the contact section.

Technologies Used

Frontend:
HTML5
CSS3
Bootstrap 5
JavaScript

Backend:
Java (JSP)
MySQL Database
JDBC for Database Connectivity
Tools & Libraries:

IntelliJ IDEA (IDE)
MySQL Workbench
Apache Tomcat Server
Bootstrap for responsive design
Project Structure
plaintext
Copy code
Evenzet/
├── css/
│   └── styles.css               # Custom styles
├── images/
│   └── (image files for website)
├── index.html                   # Homepage
├── login.html                   # Login page
├── signup.html                  # Sign-up page
├── about-us.html                # About Us page
├── features.html                # Features page
├── contact-us.html              # Contact Us page
├── web.xml                      # Web configuration file
├── pom.xml                       # Maven Project Object Model file
├── README.md                    # This readme file
└── (Java files like DAO classes, Servlets, etc.)

Setup Instructions
Prerequisites
Java JDK (version 8 or higher)
Apache Tomcat server
MySQL Database
IntelliJ IDEA or any IDE of choice
Maven (for dependency management)
Clone the repository
bash
Copy code
git clone https://github.com/yourusername/evenzet.git

Setting up the database
Set up a MySQL database with the required schema and tables. You can use the provided schema.sql file to set up the tables.
Configure the DAO classes for database connectivity. Update your database connection details in the web.xml or appropriate configuration file.
Running the Application
Import the project into your IDE (e.g., IntelliJ IDEA).
Set up the pom.xml file for Maven.
Run the application on your Apache Tomcat server by deploying it to localhost.
Access the website through http://localhost:8080/evenzet/.
Screenshots
Homepage (Index Page)

Features Page

About Us Page

Contact Us Page

Contributors
Dhruv Goel - Project Manager
Swati Singh - Frontend Developer
Neha Kumari - FrontnedDeveloper
Apoorv Aryan -Backend Developer

License
This project is licensed under the MIT License - see the LICENSE file for details.

This README gives an overview of your project, its structure, how to set it up, and provides proper documentation for anyone who wants to work with or contribute to your project. You can further customize it based on additional functionalities or updates in the future.
