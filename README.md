`				`Todo API Documentation


The Todo Application is a basic Java and Springboot project that uses a MongoDB database. After installing and creating the database, frontend applications can use the application endpoint.

Create a database in mongodb named “ToDoList”.

If user wants to create some other database and use that in application, change the database name in application.properties located under todolist/src/main/resources


Spring.data.mongodb.database = ToDoList.

Java sdk version : 17

Spring boot version : 3.1.0


Default port of application is set to 8080 in localhost and if user wants to change the port, “server.port” in application.properties can be used to change the port number.

API’s:-

1. ` `Fetch todo tasks:-

Fetch api is used to retrieve list of all tasks added to the database.

Url:-  

[http://localhost:8080/todo/fetch]()


Response :-

[

`    `{

`        `"id": 1,

`        `"task": "Learn react",

`        `"description": "Complete course and clear certification"

`    `},

`    `{

`        `"id": 3,

`        `"task": "Learn java",

`        `"description": "Complete course and clear certification"

`    `},

]


1. Add task :-

Add Api is used to add task to the db.

url:-



`	`[http://localhost:8080/todo/add]()

`	`Request Body:-

`	`{

`    		`"id":10,

`    		`"task":"Book tickets",

`    		`"description":"Book a movie ticket before all tickets gets sold out"

}

`	`Response:-

`	`{

`    		`"id": 10,

`    		`"task": "Book tickets",

`    		`"description": "Book a movie ticket before all tickets gets sold out"

}


1. Modify Task:-

Api which is used to modify the data which is available in database. We need to pass the changes of the field as below.

For this api to work, id should be matched with existing record.

Ur<a name="_hlt149832328"></a><a name="_hlt149832329"></a>l<a name="_hlt149832442"></a>:-  

[http://localhost:8080/todo/update]()

Request Body:-

{

`   		 `"id":10,

`    		`"task":"Book Movie tickets",

`    		`"description":"Book a movie ticket before all tickets gets sold out"

}

Response:-

{

`    		`"id":10,

`    		`"task":"Book Movie tickets",

`    		`"description":"Book a movie ticket before all tickets gets sold out"

}


1. Delete Task:-

Delete Api is used to delete the task from database.

Url:-

[http://localhost:8080/todo/delete/{id}]()

Response:-

Task Deleted Successfully












