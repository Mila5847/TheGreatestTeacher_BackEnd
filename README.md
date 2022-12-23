# TheGreatestTeacher_BackEnd

## Database Design 
There are three entity tables: Teacher, Course, and Score.
There is a Many-To-One relationship between the Course and the Teacher entity since a teacher can have many courses.
The relationship is Many-To-One and not One-To-Many (one teacher can have many courses) because the course is not necessarily part of the Teacher and a teacher can have no courses.
There is a One-To-One relationship between the Course and the Score entity since a course can have only one score. 

## Classes Structures
In addition to the Teacher entity, there is the Teacher controller, service, repository, request and response.
The Teacher controller contains the end-points for getting all the teachers, adding teachers, and deleting teachers.
To get all the teachers, the teacher service communicates with the teacher repository to find all the teachers with the repository's findAll() method.
The save() method from the teacher repository is used to save a newly added teacher, and the deleteById() method allows to delete a teacher with a specific Id.
When making a teacher request (ex.: when adding a teacher), its id, and its first, and last name should be specified. A teacher response is composed of his id and his full name (first name + last name).

In addition to the Course entity, there is also the Course controller, service, repository, request and response.
The Course controller contains end-points to get and add courses to a specific teacher.
To get all the teacher's courses, the course service communicates with the course repository that uses the getAllByTeacherId() method. 
To add a course to a teacher. The teacherRepository.findById() is used to find the specific teacher to whom a course would be added. Then, with the save method from the courseRepository, a new course can be saved to the teacher.
To make a course request, the id and the name of the course should be specified. A course response is composed of its id, its name, the name of the teacher who teaches the course, and the number of votes for the course.

In addition to the Score entity, there is also the Score controller, service, repository, request and response.
The Score controller contains an end-point to add a score to a course and to get the overall score of the teacher's courses (which is the teacher's rating).
To add a score, the save() method from the score repository is used. To get all the courses, the getScoresByCourseId() method from the repository is used.
To make a score request, the id and the score should be specified. There is a TeacherRatingResponse that is composed of the teacher's id, full name, overall score and number of votes.
The TeacherRatingResponse is used for the bar chart in the front-end.

## End-points documentation
### Teacher end-points
1. To display the teachers on the application, the Teacher component should be created when the page loads. That is why a method to get all teachers from the database is needed.
GET /api/teachers
Status code: 400 - Status code is returned.
No response and no response schema, status code is returned.
Status: 200
   | Example Response           | Response Schema        |  
   |----------------------------|------------------------|
   |                            | {                      |  
   | {                          |  "type":"object"       |  
   |  "teachers": [             |  "required":[],        |   
   |  {                         |  "properties": {       |   
   |   "id": "123",             |   "teachers": {        |  
   |   "first_name": "Tawfiq",  |    "type": "array",    |   
   |  },                        |    "items": {          |   
   |  {                         |     "type": "object",  |   
   |   "id": "124",             |     "required": [],    |  
   |   "first_name": "Brendan", |     "properties": {    |   
   |   "last_name": "Wood"      |      "id": {           |   
   | }                          |       "type": "string" |   
   | ]                          |      },                |  
   | }                          |     "first_name": {    |   
   |                            |      "type": "string"  |   
   |                            |     },                 |  
   |                            |      "last_name": {    |   
   |                            |      "type": "string"  |   
   |                            |      }                 |  
   |                            |     }                  |   
   |                            |    }                   |   
   |                            |   }                    |   
   |                            |  }                     |   
   |                            | }                      |   