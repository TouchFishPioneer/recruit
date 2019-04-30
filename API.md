## Application Programming Interfaces

### Student Information

1. Get the list of students

   Request
    
   ```http request
    GET info/student/index?page=0&size=20
   ```
   
   Response
   
   ```json
   {
       "code": 200,
       "message": "success",
       "data": [
           {
               "studentId": 1,
               "studentName": "李车干",
               "studentGender": 1,
               "studentTel": "15651969275",
               "studentBirthday": "1995-04-25T05:00:00.000+0000",
               "studentIdentityNumber": "321323199411202851",
               "studentAdmissionNumber": "62125147856982345345",
               "studentRegion": "621322",
               "studentSchool": "河北省正定中学",
               "studentMark": 615,
               "studentDivision": 1,
               "studentRank": 2000,
               "studentRemarks": "给我整个最好的",
               "studentInfoSource": 1,
               "studentContactStatus": 3,
               "studentIntentionalMajor": "{3}",
               "studentUnintentionalMajor": "{2}",
               "studentGrade": 3,
               "studentUuid": "53e27903a13b4eabb4fd69f8455a60e3"
           }
       ]
   }
   ```
   
2. Get the information of a specific student

    Request
    
    ```http request
    GET /info/student/index/{uuid}
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "studentId": 2,
            "studentName": "石伟",
            "studentGender": 1,
            "studentTel": "13057653392",
            "studentBirthday": "1995-10-14T05:00:00.000+0000",
            "studentIdentityNumber": "320805199510151257",
            "studentAdmissionNumber": "1341561565646498158478",
            "studentRegion": "320805",
            "studentSchool": "江苏省如皋中学",
            "studentMark": 385,
            "studentDivision": 1,
            "studentRank": 1500,
            "studentRemarks": "给我整个最好的",
            "studentInfoSource": null,
            "studentContactStatus": null,
            "studentIntentionalMajor": "{4}",
            "studentUnintentionalMajor": "{2}",
            "studentGrade": 3,
            "studentUuid": "5c46c0b035c14583a52dbc8d88d30bba"
        }
    }
    ```

3. Create a new record of student
    
    Request
    
    ```http request
    POST /info/student/index
    ```
    
    Parameters
    
    ```http request
    name: 石伟
    gender: 1
    tel: 13057653392
    birthday: 1995-10-15
    identity_number: 320805199510151257
    admission_number: 1341561565646498158478
    region: 320805
    school: 江苏省如皋中学
    mark: 385
    division: 1
    rank: 1500
    remarks: 给我整个最好的
    intentional_major: {4}
    unintentional_major: {2}
    grade: 3
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "studentId": 3,
            "studentName": "石伟",
            "studentGender": 1,
            "studentTel": "13057653392",
            "studentBirthday": "1995-10-14T16:00:00.000+0000",
            "studentIdentityNumber": "320805199510151257",
            "studentAdmissionNumber": "1341561565646498158478",
            "studentRegion": "320805",
            "studentSchool": "江苏省如皋中学",
            "studentMark": 385,
            "studentDivision": 1,
            "studentRank": 1500,
            "studentRemarks": "给我整个最好的",
            "studentInfoSource": null,
            "studentContactStatus": null,
            "studentIntentionalMajor": "{4}",
            "studentUnintentionalMajor": "{2}",
            "studentGrade": 3,
            "studentUuid": "5c46c0b035c14583a52dbc8d88d30bba"
        }
    }
    ```

4. Update a record of specific student
    
    Request
    
    ```http request
    PATCH /info/student/index
    ```
    
    Parameters
    
    ```http request
    name: "李轩"
    uuid: "53e27903a13b4eabb4fd69f8455a60e3"
    ```
    > Tip: you do not need to pass all the fields of one student but only pass the field(s) which you want to update
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "studentId": 1,
            "studentName": "李轩",
            "studentGender": 1,
            "studentTel": "15651969275",
            "studentBirthday": "1995-04-25T05:00:00.000+0000",
            "studentIdentityNumber": "321323199411202851",
            "studentAdmissionNumber": "62125147856982345345",
            "studentRegion": "621322",
            "studentSchool": "河北省正定中学",
            "studentMark": 615,
            "studentDivision": 1,
            "studentRank": 2000,
            "studentRemarks": "给我整个最好的",
            "studentInfoSource": 1,
            "studentContactStatus": 3,
            "studentIntentionalMajor": "{3}",
            "studentUnintentionalMajor": "{2}",
            "studentGrade": 3,
            "studentUuid": "53e27903a13b4eabb4fd69f8455a60e3"
        }
    }
    ```

### Teacher Information

1. Get the list of teachers
    
    Request
    
    ```http request
    GET /info/teacher/index?page=0&size=20
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": [
            {
                "teacherId": 1,
                "teacherName": "宋宇波",
                "teacherCardNumber": "130055213",
                "teacherGender": 1,
                "teacherTel": "13851884333",
                "teacherDepartment": "57",
                "teacherDuty": "副教授",
                "teacherGraduatedSchool": "东南大学",
                "teacherRemarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
                "teacherUuid": "e4181666db2e4499a9f18aaab49b7fd5"
            },
            {
                "teacherId": 2,
                "teacherName": "彭林宁",
                "teacherCardNumber": "130081245",
                "teacherGender": 1,
                "teacherTel": "025-52091692",
                "teacherDepartment": "57",
                "teacherDuty": "副研究员",
                "teacherGraduatedSchool": "法国雷恩国立应用科学学院",
                "teacherRemarks": "研究领域：通信系统物理层安全，射频指纹识别，无线信道密钥生成，室内定位，软件无线电。",
                "teacherUuid": "6c36e068a3e546f58a1a0f45205dfd34"
            },
            {
                "teacherId": 3,
                "teacherName": "胡爱群",
                "teacherCardNumber": "130905417",
                "teacherGender": 1,
                "teacherTel": "025-83795112",
                "teacherDepartment": "57",
                "teacherDuty": "教授",
                "teacherGraduatedSchool": "东南大学",
                "teacherRemarks": "研究领域：无线网络安全、物理层安全技术。",
                "teacherUuid": "3beeccd51c484d8ab154139a48316301"
            }
        ]
    }
    ```
    
2. Get the information of a specific teacher

    Request
    
    ```http request
    GET /info/teacher/index/{uuid}
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "teacherId": 2,
            "teacherName": "彭林宁",
            "teacherCardNumber": "130081245",
            "teacherGender": 1,
            "teacherTel": "025-52091692",
            "teacherDepartment": "57",
            "teacherDuty": "副研究员",
            "teacherGraduatedSchool": "法国雷恩国立应用科学学院",
            "teacherRemarks": "研究领域：通信系统物理层安全，射频指纹识别，无线信道密钥生成，室内定位，软件无线电。",
            "teacherUuid": "6c36e068a3e546f58a1a0f45205dfd34"
        }
    }
    ```
    
3. Create a new record of teacher
    
    Request
    
    ```http request
    POST /info/teacher/index
    ```
    
    Parameters
    
    ```http request
    name: 胡爱群
    card_number: 130905417
    gender: 1
    tel: 025-83795112
    department: 57
    duty: 教授
    graduated_school: 东南大学
    remarks: 研究领域：无线网络安全、物理层安全技术。
    ```
    
    Response
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "teacherId": 3,
            "teacherName": "胡爱群",
            "teacherCardNumber": "130905417",
            "teacherGender": true,
            "teacherTel": "025-83795112",
            "teacherDepartment": "57",
            "teacherDuty": "教授",
            "teacherGraduatedSchool": "东南大学",
            "teacherRemarks": "研究领域：无线网络安全、物理层安全技术。",
            "teacherUuid": "3beeccd51c484d8ab154139a48316301"
        }
    }
    ```

4. Update a record of specific teacher

    Request
    
    ```http request
    PATCH /info/teacher/index
    ```
    
    Parameters
    
    ```http request
    remarks: 研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。
    uuid: e4181666db2e4499a9f18aaab49b7fd5
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "teacherId": 1,
            "teacherName": "宋宇波",
            "teacherCardNumber": "130055213",
            "teacherGender": true,
            "teacherTel": "13851884333",
            "teacherDepartment": "57",
            "teacherDuty": "副教授",
            "teacherGraduatedSchool": "东南大学",
            "teacherRemarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
            "teacherUuid": "e4181666db2e4499a9f18aaab49b7fd5"
        }
    }
    ```

### Login and Logout

1. Get the uuid of the captcha

    Request
    
    ```http request
    GET /log/teacher/captcha
    ```
    
    Response
    
    ```json
    {
        "code": 200,
        "message": "验证码生成成功，请请求验证码图片",
        "data": {
            "captcha": "CAPTCHA_KEY_PREFIX_2740a82195"
        }
        
    }
    ```

2. Teacher login and get the token
    
    Request
    
    ```http request
    POST /log/teacher/in
    ```
    
    Parameters
    
    ```http request
    username: 
    password:
    captcha_uuid:
    captcha_code:
    ```
    
    Response:
    
3. Teacher get detail information
    
    Request
    
    ```http request
    GET /log/teacher/info
    ```
    
    Response
    
4. Teacher logout
    
    Request
    
    ```http request
    POST /log/teacher/out
    ```
    
    Response

### Question and Answer

1. Get the list of questions

    Request
    
    ```http request
    GET /interactive/question/index
    ```
    
    Response

2. Student create a new question

    Request
    
    ```http request
    POST /interactive/question/index
    ```
    
    Parameters
    
    Response
    
3. Teacher review and validate the question
 
    Request
    
    ```http request
    PATCH /interactive/question/index/review/{uuid}
    ```
   
4. Teacher answer a specific question

    Request
    
    ```http request
    PATCH /interactive/question/index/answer/{uuid}
    ```
    
    Parameters
    
    Response


### Notification

1. Get the list of notifications

    Request
    
    ```http request
    GET /interactive/notification/index
    ```
    
    Response

2. Teacher create new notification
    
    Request
    
    ```http request
    POST /interactive/notification/index
    ```
    
    Parameters
    
    Response
    
3. Teacher change the detail of failed notification

    Request
    
    ```http request
    PATCH /interactive/notification/index/{uuid}
    ```
    
    Parameters
    
    Response

### Data Visualization

1. Get the visualization data of student region distribution

    Request
    
    ```http request
    GET /visualization/region/index
    ```
    
    Response
    
2. Get the visualization data of statistics

    Request
    
    ```http request
    GET /visualization/statistics/index
    ```
    
    Response
    
3. Get the visualization data of line charts

    Request
    
    ```http request
    GET /visualization/chart/index
    ```
    
    Response
    
4. Get the visualization data of division distribution

    Request
    
    ```http request
    GET /visualization/division/index
    ```
    
    Response
    
5. Get the visualization data of communication situation

    Request
    
    ```http request
    GET /visualization/communication/index
    ``` 
    
    Response
