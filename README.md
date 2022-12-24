# TheGreatestTeacher_BackEnd

## Database Design: Entity-Relationship Diagram
There are three entity tables: Teacher, Course, and Score.
There is a Many-To-One relationship between the Course and the Teacher entity since a teacher can have many courses.
There is a One-To-One relationship between the Course and the Score entity since a course can have only one score.
![Entity-Relationship Diagram](C:\Users\kehay\Desktop\finalEntityTables.drawio.png)

## Classes Structures
In addition to the Teacher entity, there is the TeacherController, TeacherService, TeacherRepository, TeacherRequest, and TeacherResponse.
The TeacherController contains the end-points for getting all the teachers, adding teachers, and deleting teachers.
To get all the teachers, the TeacherService communicates with the TeacherRepository to find all the teachers with the repository's findAll() method.
The save() method from the TeacherRepository is used to save a newly added teacher, and the deleteById() method allows to delete a teacher with a specific Id.
To build a TeacherRequest (ex.: when adding a teacher), its id, and its first, and last name should be specified. The TeacherResponse is composed of the teacher's id and their full name (first name + last name).

In addition to the Course entity, there is also the CourseController, CourseService, CourseRepository, CourseRequest, and CourseResponse.
The CourseController contains end-points to get, add, and update the courses of a specific teacher.
To get all the teacher's courses, the CourseService communicates with the CourseRepository that uses the getAllByTeacherId() method. 
The TeacherRepository's findById() method is used to find the specific teacher to whom a course would be added. Then, with the save() method from the CourseRepository, a new course can be saved for the teacher.
The save() method is also used when updating a teacher.
To build a CourseRequest, the id and the name of the course should be specified. The CourseResponse is composed of the course's id, its name, the name of the teacher who teaches the course, and the number of votes for the course.

In addition to the Score entity, there is also the ScoreController, ScoreService, ScoreRepository, ScoreRequest, and ScoreResponse.
The ScoreController contains end-points to add a score to a course and to get the overall score of the teacher's courses (which is the teacher's rating).
To add a score, the save() method from the ScoreRepository is used. To get all the courses, the getScoresByCourseId() method from the ScoreRepository is used.
To build a ScoreRequest, the id and the score should be specified. There is a TeacherRatingResponse that is composed of the teacher's id, full name, overall score, and the number of votes.
The TeacherRatingResponse is used for the bar chart in the front-end. For a more detailed explanation of the front-end, please visit the front-end repository at https://github.com/Mila5847/The-Greatest-Teacher.

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
Returns the newly added teacher.
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
   Status: 200 - List of the teachers and their ratings (overall score, number of votes) is returned.

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





