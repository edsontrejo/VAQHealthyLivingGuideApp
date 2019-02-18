WHEN USING THIS PROGRAM REMEMBER TO EDIT THE FILE:

CONFIG.INI (Final Project Merged\NutritionMVC\config.ini)

ALL EXTERNAL FRAMEWORK NEEDED (JARS) ARE LOCATED IN (Final Project Merged\)

MERGED DATABASE SQL IS ALSO HERE, TEAM 1 STILL NEEDS TO FILL THE TABLES: equipment and exercise.

ALSO FROM TEAM 2, IN ORDER TO IMPLEMENT THEIR CONTRIBUTION, IS NEEDED: 
	- com.lowagie.text-2.1.7.jar
	- flying-saucer-pdf-9.0.1.jar

----------------------------------------- NOTES ---------------------------------------------------

Database:
 
These two tables have a big data, and I think the data is broken because it shows it as strange signs and I cannot run them as a query
•	Table ‘equipment’
•	Table ‘exercise’
 
Profile Picture:
 
When I try to update the profile picture, I think you guys did it using blob and it saves the actual image in the database, and I guess we have to define the size of the max_file_size for it to accept diverse pictures and not only small ones
 
Medical Profile:
 
I really do not understand how does the selection of allergies and diseases work so, I guess I’ll wait until you explain it to us, because I can’t select multiple allergies/diseases (I think the allergies do not even save in the database)
 
Some Fixes:
 
When creating a new account, it wasn’t creating Medical/ProfilePicture/Personal data on the database, now its fixed
 
TODO:
 
-	Fix the Routine Tab because I think it is missing some parts, but I can take care of it later in the day
-	Finish implementing Team’s 2 contribution
-	Export Tab is giving some errors but it has to do with the database (easy fix)
-	Add some stuff on the home, like a kind of Welcome Message and UTRGV Logo
-	Find more bugs



