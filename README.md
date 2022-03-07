# Skittwhale-Marriage-Inc_P1_ABJS

- Created by Austin Blandford and Jacob Sotto

## Description
A wedding planner built using the stack of Java, Maven, Tomcat, HttpServlets, Hibernate, and PostgreSQL. This project includes an entire front-end with pages created using HTML from the doGet methods of each servlet. Both developers had their own branch and communicated whatever part of the project they were working on to avoid as many merge conflicts as possible. In that aspect, the project was a huge success with only a few merge conflicts consisting of white space and simply some files slipping through on a push somehow. Both developers on this project weren't fully aware of how to use the tech stack on the first week and made a promise to review all the material that they could to get to work on the project. It is safe to say, they had their struggles throughout, but were able to still have some form of functionality within this massive project. MVP was not met, but an entire front-end was build and functioning to show off, which made up for the lack of MVP.

## Functionality
The current functionality of the project consists of registering a user as an employee, bachelor/bachelorette, or attendee, logging in as one of those types of users, and each type of user had their own page built to handle future funtionality. Furthermore, the project is able to pull from our database and use that information within the project. As an example, an Attendee can log in and view the current weddings that are available. A Bachelor/Bachelorette can view the services that are available for their wedding. An Employee can log in and create new services to be used within the app. The creation of new services is fully functional and included validation to see if any service exists of the same name before creating the new service. Login, Register, and the Employee page all have a form that takes in user input and passes it to our doPost methods within their dedicated servlets, which does include some form of validation. Currently, the main validation that works is the one for the Employee page. There was some bugs with Login and Register by the time we presented this project, but we were able to show the problem and that we did have an answer for it.

## How to Start
1. You would need to first have the project on your local machine, so you would probably clone this repository and then import the project into your choice of IDE.
2. You also need to make sure that you have Tomcat as well as Maven installed and working correctly. You might have to update some of the user settings of Tomcat and the settings of Maven to be able to run the project.
3. Once Tomcat is working, you want to make sure that you have the Tomcat server running, which would be at localhost:8080.
4. After your Tomcat is running, you then need to build the project using the goal of tomcat7:deploy, and you need to build it as a Maven build.
5. Keep a careful eye on the console output to make sure that the project was properly deployed to the Tomcat server.
6. Once deployed, you can go to the app manager of Tomcat and view the project from '/weddingapp'.

## Struggles
Both developers of this project experienced some rough patches during this project. One was making sure Maven, Tomcat, and even Spring Tools Suite was working correctly, including doing several reinstallations and edits of some files. The other struggled to get a grasp of Hibernate as well as the servlets, typically missing very small parts of the program which were very important to remember. Both developers in general had struggles catching up with the material covered for this project, especially when the batch was learning Spring and Springboot at the same time as working on this project.

## Conclusion
Despite the struggles of this project, both developers ended up being able to have something presentable for the end of this project, including a fully working front-end. This front-end was not required for MVP, but was a part of the challenges to attempt on this project that the developers took to the best of their ability to make up for the lack of MVP. The developers of this project learned a lot and enjoyed working with one another when co-developing this project. While the project wasn't perfect, this project proved that these developers could still get the work done had they not needed to review the material once more to develop the project.
