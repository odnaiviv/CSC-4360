
3.5
1) open app on phone emulator 
2) app should open up to editTexts labeled "1st Number" & "2nd Number", four buttons each with a different math operation, and an "Answer: " text at the bottom 
3) enter in first & second number 
 - for this case, I used 20 and 5 
4) click on "+" button 
 - you should see the answer text print the sum of these two numbers (25.0) 
5) click on "-" button 
 - you should see the answer text print the difference of these two numbers (15.0) 
6) click on "*" button 
 - you should see the answer text print the product of these two numbers (100.0) 
7) click on "/" button 
 - you should see the answer text print the quotient of these two numbers (4.0) 


4.1 
1) open app on phone emulator 
2) app should open up with data entry part of the contact list 
 - the background color of this should be light blue 


4.5 
1) open app on phone emulator 
2) app should open up to "Restaurant: ", "Dish: ", and two additional blank editTexts as inputs 
 - app should also see "Rating: " and "0 / 5" as the rating and a "Rate Meal!" button 
3) enter in restaurant name in first blank & dish name in second blank 
 - for this case, I used Starbucks & Mocha Frappuccino (just as an example bc i usually dont go outside haha) 
4) click on "Rate Meal!" button 
 - alert screen should pop up 
 - you should see "Please Rate the Meal: ", radio buttons of 1 to 5 for the rating scale, and "Cancel" button 
5) click on any number (5) 
6) alert screen closes and updates meal rating (5 / 5) 
 - you can rate the meal again by clicking "Rate Meal!" button again (let's go with 1)
 - this changes the rating value of the meal to "1 / 5"


5.5 
1) open app on phone emulator 
2) app should look very similar to Ex 4.5 app 
 - only addition is the "Save" button 
3) follow the same process as 4.5 
4) once meal has been rated, click on "Save" button 
 - info should be stored in the SQLite database table 


5.7 
1) open app on phone emulator 
2) app should open up to "Place: ", "Address: ", two blank editTexts as inputs, and two "Rate" & "Save" buttons 
 - app should also have "Beer: 0.00", "Wine: 0.00", and "Music: 0.00" as rating output editText 
3) enter in bar/nightclub name in the first blank & address of place in second blank 
 - I used the Starbucks Reserve & Chicago, IL as the example
4) click on "Rate" button 
 - alert screen should pop up 
 - you should see the prompt to rate the place we've entered in and a "Cancel" and "Rate" button 
 - one for beer, wine, & music selection 
 - pressing "Cancel" will take you out of the alert screen 
5) choose any rating to your liking (1, 2, 3 because it's easy) 
6) ratings of beer, wine & music should update (1.00, 2.00, 3.00) below the buttons & a prompt "Successfully saved rating!" should show for a second 




Notes: 
3.5
I made the text of the multiplication symbol as asterisk "*" instead of "x" for better consistency with the other operation symbols. I wanted them to all match! 

4.1
I downloaded the code from Chapter 4 textbook & changed the string name of the app to "Do - Ex 4.1". I thought a light blue would fit as a very nice background color! :)

4.5 
I'm not sure if I made enough TextViews but I made sure to use one of them to change the rating score. I made some of the text bigger for better visibility & changed the colors to a purple/pink theme to match the button color & it looks really pretty to me!!

5.5 
I reused the code from Ex 4.5. My app worked fine with the additional save button, but when I added the database functionalities similarly made from the textbook, my app crashed & would not load anymore after that :( Am I missing something here or was I supposed to add another class???? 

5.7 
I reused the code from Ex 4.5 again, but this time I added & changed some values as necessary. I was able to get the app to load but when I try to save my ratings to the database it didn't save like it was supposed to?? I'm not sure if I'm missing something else again or if there is another bug in my code :/ 

