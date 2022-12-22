# Full Stack Assesment
## Introduction
You will be implementing an Android application using Android Studio that will call the national weather api and populate the forecast on a screen.

All reasources and architecture has been provided to you. It will be your job to implement these resources into a functioning weather forecast app.

This should take approximately 2-3 hours to complete, please keep track of your time as you go and get as much done as you can.

## The UI
The following are the two screens we would like to see implemented.
<p align=center>
  <img src="https://user-images.githubusercontent.com/82067568/206795000-3bb1db3b-375d-4fd7-a624-0d4eda7d48ac.png" height = "500">
</p>

### Screen #1 
Should be implemented as closely as possible to the provided screen. Margins, text size, and shades of colors don't have to be precise.

### Screen #2
Should consist of a textview on top and a forecast card. 

This forecast should have a corresponding:
- icon
- time of day
- temperature

If the Api fails to call then display the failure in the textView


## Function 

When Screen #1's forecast button is pressed the application should initialize the forecast activity, which will call the national weather api for the forecast of a given location.

Calling the weather api is a two step process.

- The first step is to send a location request. The response will be two grid coordinates. 

- The second step will be to send a forecast request with the previously given grid coordinates. The response will be the finale forecast for the next couple of days.

Please reference the following link: https://weather-gov.github.io/api/general-faqs

## When Finished

When you have completed the assessment, email molly@ascentitech.com with the link to your new repository and answer the following questions as honestly as you can.  

# Submission

## Application Screenshots
Home Page                  |  Forecast Page            |  API Error
:-------------------------:|:-------------------------:|:-------------------------:
![](https://raw.githubusercontent.com/Kodiris-Dev/Ascent_Assessment/Xavier/screenshots/Activity1.PNG)  |  ![](https://raw.githubusercontent.com/Kodiris-Dev/Ascent_Assessment/Xavier/screenshots/Activity2.PNG)  |  ![](https://raw.githubusercontent.com/Kodiris-Dev/Ascent_Assessment/Xavier/screenshots/Activity2Error.PNG) 


## Modifications and Notes

After the first round interview with Erin Motley, I spent a few hours every day for a week reviewing Android Studio and Java full stack software engineering since the bulk of my experience
is in full stack web development and my last interaction with Android Studio was several years ago. I had began self studying, teaching myself, and transferring my knowledge from web development
into app development in that week prior to any knowledge that there would be a coding assessment in order to ensure I was ready if given the job. This submission is the culmination of my studies
as well as my existing knowledge in full stack, going from very minimal Android Studio and Java experience to having an understanding on how to translate my already existing skills
into this platform in just a few weeks. Throughout my development, I made minor adjustments to my output to reflect how I would approach actually developing an application that would be in use. 
Additionally, due to my experience in full stack web development, the biggest challenge for me was learning the specific technical skills needed to complete the application
despite knowing how to complete it on a theoretical level. Therefore, I will be referencing web development techniques and skills in my write up to explain my thought process in coming up with solutions
as well as highlighting the transferability of my previous experience to this job. 

### Modifications

The first modification I did was a simple back button to return to the MainActivity in order to be able to refresh the WeatherApi call without having to restart the app. This helped me rapidly test and manipulate the
classes and objects needed to handle the response body of the get requests being made. The second modification I did was in retrieving the forecast icons for the forecast card. I used the shortForecast property
in the Periods class as the key for the hashmap, however I quickly realized that the API returns some fairly complicated short forecasts and that it would be incredibly difficult to hardcode all of icons in the map in order
for the application to display the correct one for each forecast. In addition to keeping the hashmap's functionality, I decided to check if a short forecast existed in the hashmap, and if it didn't, return the icon url string
from the API instead. This way, the icon would always reflect the correct forecast. 

## Final Questions
1) How long did the assessment take to complete?  Was there any task that took significantly longer than the others, and if so why?

    The assessment took me 4 hours and 25 minutes to complete upon receiving the repository including analyzing the data source and code base. While I went over the 2-3 hours recommended time, my goal was to implement
all of the features and requirements listed, as well as implement some small nice to have features to help with basic user experience and application functionality. 

    The task that took me the longest was figuring out how to retrieve data out of the view model and displaying it in the application. In web development, this task is fairly straight forward. Some libraries such as Nest.js
provide a controller in the back end that handles get and set functions for the endpoint itself and the front end is required to hit these endpoints to use the response in method. However I noticed quickly that the interaction
between the ViewModel and Activities are not similar to a backend server and a front end library. I noticed that retrofit was using GSON to immediately "fit" the response data into an object of class Weather, but 
referencing those objects wasn't possible through passing them as parameters in a method and calling the method in the Activity. Instead I used a mutable live data type to store the created object and then monitor
the changes happening to the object in the Activity, setting the UI elements that way. This method aligned with what I am familiar with in web development and methods I have used to "wait" for asynchronous actions to complete before
re rendering UI elements to display the information. 

    The second task that took longer than most was manipulating the UI in order to create layouts that imitated what was given in the assessment. The layouts have changed since I previously
used android studio and required some tinkering around through trial and error to achieve the look and feel that I wanted. As seen in the submission, there were still some small details
that I didn't get right, such as some visible corners in the MainActivity transparent card. 

2) Were there any tasks that you initially did not know how to complete? And if so, how did you approach them and take the steps to learn how to complete them? (It’s okay if the answer is yes! Everyone learns on the job at some point)

    There were a few tasks that I did not initially know how to complete that ranged from larger tasks to smaller tasks. In terms of larger tasks, as mentioned above, I knew that the get request would
be handled asynchronously, but did not know the technique to re render UI elements once a request was completed. In order to figure this out, I searched for ways to access data from viewmodels in general
as well as be able to monitor the data passing through the object. In terms of smaller tasks, I had assumed it would have been easy to set an image url to an image
in android studio but realized quickly that unlike web development, the application needs to initiate some sort of Https connection in order to reference it. An initial google
search led me to some complex solutions to connect to Https directly but after some trial and error, it proved to be too convoluted. In my previous experience, I always looked to dependencies before trying to fit
convoluted code into my projects, which led me to finding the Picasso dependency to add image sources in one line of code. This process also taught me how dependencies and gradle works in Java, which
was very familiar and similar to technologies I had worked with in the past such as Docker and NPM. Additionally, one small inconvenience was not knowing how to create a button with an image as well as a text view inside.
While I am unsure if this is the best way to do it, my instinct was to reference my previous experience and use a layout to design the button and make the layout clickable, similar to how I would make a custom button with a div or React Material UI component.


4) Was this assessment feasible for the time given and relatively easy to follow? Any points of feedback? 

    As someone who has less experience with Java and Android Studio compared to other technology stacks, this assignment was still feasible within a relatively
short timeframe. I thoroughly enjoyed this mini project and learned a lot already prior and during this coding assessment. The one point of feedback I have is to include
a portion in which the applicants are tested in their data handling skills - translating data retrieved from API into usable classes for the application. 
This allows the candidate to show off organizational skills as well as an understanding of end to end solution architecture. 

    
