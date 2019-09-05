# Spring Boot, MySQL, JPA, Hibernate Rest Forum

Build Restful CRUD API for a simple Forum application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/khanwahid1995/forum
```

**2. Create Mysql database**
```
 run the forumDB script
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/forum-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.
    
    POST /forum/save-question
	
	POST /forum/save-reply
    
    GET /forum/get-question-replies/{questionId}
    
    GET /forum/get-all-questions
	
	GET /forum/get-cached-question-replies/1

You can test them using postman or any other rest client.

## Api Details 

1. http://localhost:8080/forum/save-question 
	
	Input : {
			"question" : "Can anyone suggest a good place to chill in chennai",
			"userId" : 1
		}
		
	Output : Response Status - 201 created
	
2. http://localhost:8080/forum/save-reply

	Input : {
				"userId" : 1,
				"questionId" : 1,
				"parentReplyId" : null,
				"reply" : "thgreat , hahah i am great and awesome2"
			}
	Output : Output : Response Status - 201 created
	
3. http://localhost:8080/forum/get-all-questions
	
	Output : {
				"errorMessage": null,
				"data": [
					{
						"questionId": 3,
						"question": "Can anyone suggest a good place to chill in Mumvai",
						"userDisplayName": "khanwahid",
						"createdAt": "2019-09-05T14:47:32.000+0000"
					},
					{
						"questionId": 2,
						"question": "helo how are u?",
						"userDisplayName": "kha",
						"createdAt": "2019-09-04T19:07:02.000+0000"
					},
					{
						"questionId": 1,
						"question": "Can anyone suggest a good place to chill in chennai",
						"userDisplayName": "khanwahid",
						"createdAt": "2019-09-03T19:22:44.000+0000"
					}
				]
			}
			
4. http://localhost:8080/forum/get-question-replies/1

	Output : {
				"errorMessage": null,
				"data": {
					"question": "Can anyone suggest a good place to chill in chennai",
					"userDispayName": "khanwahid",
					"createdAt": "2019-09-03T19:22:44.000+0000",
					"replies": [
						{
							"reply": "I have a few places in mind, should i tell?",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-03T19:36:25.000+0000",
							"replies": [
								{
									"reply": "yes, why not and please suggest for dinner aso",
									"userDisplayName": "khanwahid",
									"createdAt": "2019-09-03T19:38:00.000+0000",
									"replies": [
										{
											"reply": "there is this place in paror called copper kitchen",
											"userDisplayName": "kha",
											"createdAt": "2019-09-03T19:39:11.000+0000",
											"replies": []
										},
										{
											"reply": "there is this place in paror called copper kitchen , this is not grat",
											"userDisplayName": "khanwahid",
											"createdAt": "2019-09-03T20:03:10.000+0000",
											"replies": []
										}
									]
								}
							]
						},
						{
							"reply": "thgreat",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-03T21:04:39.000+0000",
							"replies": []
						},
						{
							"reply": "thgreat , hahah",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-04T19:39:12.000+0000",
							"replies": []
						},
						{
							"reply": "thgreat , hahah i am great",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-04T19:47:19.000+0000",
							"replies": []
						},
						{
							"reply": "thgreat , hahah i am great and awesome",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-04T19:57:02.000+0000",
							"replies": []
						},
						{
							"reply": "thgreat , hahah i am great and awesome2",
							"userDisplayName": "khanwahid",
							"createdAt": "2019-09-04T20:00:15.000+0000",
							"replies": []
						}
					]
				}
			}
			
5. http://localhost:8080/forum/get-cached-question-replies/1
	
	Output :  save as Api 4 but response time will be less as whole json is save in memeory