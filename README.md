# Sensor-Application

In this project, I have created a Service which will be able to register new sensors, the sensors have the ability to store various metrics such as temperature, humidity and wind.
Ther senspors are registered using a unique field i.e Sensor Id. 

Registration of sensors can include some metadata such as the County Name and City Name which can be stored in the sensors. After the registration of the sensor, the varying weather data can ber stored in the sensors using an API call.

The data stored in the sensors can be queried to retrieve the the temperature, wind or humidity values for a particular time interval. Additionally, the average operation can be performed on the metrics stored in the sensors. 

Input validation is implemented to make sure that unwanted or data in the wrong format is not accepted in the program.
Exception Handlling is done to ensure uninterrupted program flow even when unexpected events occur. The test cases are written to to check whether the functions are working properly for a variety of input values. 

PostgreSQL is used to store the data and create a database for this project. Eclipse Integrated Development Environment is used to write the computer programs. POSTMAN is used to verify the working of the APIs.

The code can be run on the Eclipse workspace.
