# CST 3613 - Application Development With Java
## Merged-Apps

## How to create a jar for this project:
Make sure you have Maven installed on your computer. Otherwise, you will have to build a jar from Intellij-IDEA or Eclipse.
<br />
From your command line interface (CLI) go to the project folder.
<br />
e.g. `cd final-project `
<br />
Once you are inside the project folder, type `mvn clean` then `mvn package`.
<br />
You will see a new folder called **target**, inside this folder you will find a **.jar** file.

## How to run this project:
Make sure you have JavaFX somewhere in your computer.

Go to the .jar file folder and open your CLI referencing the same folder. (You can also go to the folder using your CLI).

Then proceed to copy and paste the following code into your CLI
and replace **/path/to/javafx-sdk-15.0.1/lib** with your own JavaFX path.
Also, make sure you replace **your-jar-file.jar** with the jar you just created.

java --module-path **/path/to/javafx-sdk-15.0.1/lib**
--add-modules javafx.controls,javafx.fxml -jar **your-jar-file.jar**

## Technologies used to build this project:
* Java 16
* Junit 5
* Project Lombok
* Maven
* FXML
* JavaFX
* MongoDB
* CSS

## Endpoints:
#### ABC Counter App:
* abc = `GET http://localhost:8080/api/v1/mode/abc`
* cba = `GET http://localhost:8080/api/v1/mode/cba`
* AaBbCc = `GET http://localhost:8080/api/v1/mode/AaBbCc`
* 123 = `GET http://localhost:8080/api/v1/mode/123`
* 321 = `GET http://localhost:8080/api/v1/mode/321`
* 369 = `GET http://localhost:8080/api/v1/mode/369`
* isVowel = `GET http://localhost:8080/api/v1/isVowel/{vowel}`
* isVowelAaBbCc = `GET http://localhost:8080/api/v1/isVowelAaBbCc/{vowel}`
* isConsonant = `GET http://localhost:8080/api/v1/isConsonant/{consonant}`
* isConsonantAaBbCc = `GET http://localhost:8080/api/v1/isConsonantAaBbCc/{consonant}`
* isEven = `GET http://localhost:8080/api/v1/isEven/{number}`
* isOdd = `GET http://localhost:8080/api/v1/isOdd/{number}`
* isDivisibleBy6 = `GET http://localhost:8080/api/v1/isDivisibleBy6/{number}`
* contains7 = `GET http://localhost:8080/api/v1/contains7/{number}`

#### Customer Chart App:
* Retrieve all data = `GET http://localhost:9215/api/reports/year/month/days/price/location`

#### Customer Purchase App:
* getPurchaseById = `GET http://localhost:3613/customer/api/query/{id}`
* updateReward = `PUT http://localhost:3613/customer/api/update/reward/{id}`
* getTaxToPay = `GET http://localhost:3613/customer/api/tax/preview/{id}`
* updateTaxToPay = `PUT http://localhost:3613/customer/api/tax/{id}`

#### Final Exam App:
* getSummaries = `GET http://localhost:9215/api/summary/year/:year`

## Disclaimer: