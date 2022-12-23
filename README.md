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

1. GET /api/teachers 
Returns a list of all the teachers present in the Teacher table.
Status: 400 - Status code is returned.
Status: 200 - List of teachers is returned.

Example Response
```JSON
[
   {
      "id": 1,
      "fullName": "Tawfiq Jawhar"
   },
   {
      "id": 2,
      "fullName": "Petar Kehayov"
   },
   {
      "id": 3,
      "fullName": "Jean Savoie"
   }
] 
```
Response Schema
```JSON
{
   "type": "array",
   "items": {
      "type": "object",
      "required": [],
      "properties": {
         "id": {
            "type": "number"
         },
         "fullName": {
            "type": "string"
         }
      }
   }
}
```
2. POST /api/teachers
Returns the newly added teacher
Status: 400 - Status code is returned.
Status: 201 – Teacher created successfully.

3. DELETE /api/teachers/{teacherId}
Status: 400 - Status code is returned.
Status: 200 - Id of deleted teacher is returned.

### Course end-points

1. GET /api/courses/{teacherId}
Status code: 400 - Status code is returned.
Status: 200 - List of teacher's courses with their respective teachers and number of votes is returned.

Example Response
```JSON
[
   {
      "id": 1,
      "name": "Java",
      "teacher": {
         "id": 1,
         "fullName": "Tawfiq Jawhar"
      },
      "numberOfVotes": 1
   },
   {
      "id": 2,
      "name": ".NET",
      "teacher": {
         "id": 1,
         "fullName": "Tawfiq Jawhar"
      },
      "numberOfVotes": 0
   }
]
```
Response Schema
```JSON
{
   "type": "array",
   "items": {
      "type": "object",
      "required": [],
      "properties": {
         "id": {
            "type": "number"
         },
         "name": {
            "type": "string"
         },
         "teacher": {
            "type": "object",
            "required": [],
            "properties": {
               "id": {
                  "type": "number"
               },
               "fullName": {
                  "type": "string"
               }
            }
         },
         "numberOfVotes": {
            "type": "number"
         }
      }
   }
}
```
2. POST /api/courses/{teacherId}
Returns the newly added course.
Status: 400 - Status code is returned.
Status: 201 – Course created successfully.

3. PUT /api/courses/{teacherId}/{courseId}
Status: 400 - Status code is returned.
Status: 200 - Updated course is returned.

### Score end-points

1. GET /api/scores
   Status code: 400 - Status code is returned.
   Status: 200 - List of the teachers and their ratings (overall score, number of votes). is returned.

Example Response
```JSON
[
   {
      "teacher_id": 1,
      "fullName": "Tawfiq Jawhar",
      "overallScore": 83.0,
      "overallNumberOfVotes": 5
   },
   {
      "teacher_id": 2,
      "fullName": "Petar Kehayov",
      "overallScore": 80.0,
      "overallNumberOfVotes": 0
   }
]
```
Response Schema
```JSON
{
   "type": "array",
   "items": {
      "type": "object",
      "required": [],
      "properties": {
         "teacher_id": {
            "type": "number"
         },
         "fullName": {
            "type": "string"
         },
         "overallScore": {
            "type": "number"
         },
         "overallNumberOfVotes": {
            "type": "number"
         }
      }
   }
}
```
2. POST /api/scores/{courseId}
   Status: 400 - Status code is returned.
   Status: 201 – Newly added score is returned.





