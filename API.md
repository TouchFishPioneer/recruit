## Application Programming Interfaces

### Student Information

1. Get the list of students

   **Request**
   
   ```http request
   GET /info/student/index?page=0&size=20
   ```
   
   **Response**
   
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

    **Request**
    
    ```http request
    GET /info/student/index/{uuid}
    ```
    
    **Response**
    
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
    
    **Request**
    
    ```http request
    POST /info/student/index
    ```
    
    **Parameters**
    
    ```http request
    name: 石伟
    gender: 1
    tel: 13057653392
    birthday: 1995-10-15
    identity_number: 320805199510151257
    admission_number: 1341561565646498158478
    region: 320805
    school: 江苏省如皋中学
    mark: 385
    division: 1
    rank: 1500
    remarks: 给我整个最好的
    intentional_major: {4}
    unintentional_major: {2}
    grade: 3
    ```
    
    **Response**
    
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
    
    **Request**
    
    ```http request
    PATCH /info/student/index
    ```
    
    **Parameters**
    
    ```http request
    name: "李轩"
    uuid: "53e27903a13b4eabb4fd69f8455a60e3"
    ```
    > Tip: you do not need to pass all the fields of one student but only the field(s) which you want to update.
    
    **Response**
    
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
    
    **Request**
    
    ```http request
    GET /info/teacher/index?page=0&size=20
    ```
    
    **Response**
    
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

    **Request**
    
    ```http request
    GET /info/teacher/index/{uuid}
    ```
    
    **Response**
    
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
    
    **Request**
    
    ```http request
    POST /info/teacher/index
    ```
    
    **Parameters**
    
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
    
    **Response**
    
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

    **Request**
    
    ```http request
    PATCH /info/teacher/index
    ```
    
    **Parameters**
    
    ```http request
    remarks: 研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。
    uuid: e4181666db2e4499a9f18aaab49b7fd5
    ```
    > Tip: Just like the student side, you do not need to pass all the fields of one teacher but only the field(s) which you want to update.

    **Response**
    
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

### Student Login and Logout

1. Student login and get the token

    **Request**
    
    ```http request
    POST /log/student/in
    ```
    
    **Response**
    
    
    
2. Get student account information

    **Request**
    
    ```http request
    GET /log/student/info
    ```
    
    **Response**

3. Student logout

    **Request**
    
    ```http request
    POST /log/student/out
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success"
    }
    ```

### Teacher Login and Logout

1. Get the storage key of the captcha

    **Request**
    
    ```http request
    GET /log/teacher/captcha/key
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "captcha_key": "CAPTCHA_94d051d544"
        }
    }
    ```
    
2. Get the image of the captcha

    **Request**
    
    ```http request
    GET /log/teacher/captcha/image?key=CAPTCHA_94d051d544
    ```
    
    **Response**
    
    _A captcha image in JPEG format_

3. Teacher login and get the token
    
    **Request**
    
    ```http request
    POST /log/teacher/in
    ```
    
    **Parameters**
    
    ```http request
    username: boboalis
    password: 19901919
    captcha_key: CAPTCHA_ffc5a94236
    captcha_content: 4g3xp
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJyZWNydWl0Iiwic3ViIjoiYm9ib2FsaXMiLCJpYXQiOjE1NTY3ODU2MDgsImV4cCI6MTU1NjgyODgwOH0.JxE0LOKQH4uhr-i3BARJoqiDXbfcnyfwoV2Dswehnn4"
        }
    }
    ```
    
4. Get teacher account information
    
    **Request**
    
    ```http request
    GET /log/teacher/info
    ```
    
    **Parameters**
    
    ```http request
    cookie: token=eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJyZWNydWl0Iiwic3ViIjoiYm9ib2FsaXMiLCJpYXQiOjE1NTY3ODYzNzcsImV4cCI6MTU1NjgyOTU3N30.AeUFZV7wbpRCvc270W9zAWcsONrf8qjtGJMUttykQrI
    ```
    
    > The parameter of this interface should be in the cookies.
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "username": "boboalis",
            "nickname": "bobo",
            "role": 0,
            "status": 1,
            "region": "000000",
            "avatar": "1",
            "uuid": "dasdsdawda"
        }
    }
    ```
    
5. Teacher logout
    
    **Request**
    
    ```http request
    POST /log/teacher/out
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success"
    }
    ```
    
### Student Account Management

1. Create a new student account
    
    **Request**
    
    ```http request
    POST /account/student/index
    ```
    
    **Parameters**
    
    ```http request
    email: wurahara@163.com
    password: 20090520
    nickname: tantailan
    ```
    
    **Response**
    
    ```json
    {
         "code": 200,
         "message": "success",
         "data": {
             "email": "wurahara@163.com",
             "nickname": "tantailan",
             "status": 1,
             "uuid": "08af02a583424620966b24156a58ea9f"
         }
    }
    ```

2. Update the account of a specific student

    **Request**
    
    ```http request
    PATCH /account/student/index
    ```
    
    **Parameters**
    
    ```http request
    nickname: killerquin
    uuid: 6c8f9c693bfd47aaa1f0a5ad2258e6ce
    ```
    
    > Tip: You do not need to pass all the fields of one account but only the field(s) which you want to update.
        
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "email": "wurahara@163.com",
            "nickname": "killerquin",
            "status": 1,
            "uuid": "08af02a583424620966b24156a58ea9f"
        }
    }
    ```

### Teacher Account Management

1. Create a new teacher account

    **Request**
    
    ```http request
    POST /account/teacher/index
    ```
    
    **Parameters**
    
    ```http request
    username: songyubo
    password: 18765432
    nickname: 追风大叔
    role: 2
    region: 320100
    avatar: 1
    ```
    
    **Response**
    
    ```json
    {
         "code": 200,
         "message": "success",
         "data": {
             "username": "songyubo",
             "nickname": "追风大叔",
             "role": 2,
             "status": 1,
             "region": "320100",
             "avatar": "1",
             "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
         }
    }
    ```

2. Update the account of a specific teacher
    
    **Request**
    
    ```http request
    PATCH /account/teacher/index
    ```
    
    **Parameters**
    
    ```http request
    nickname: 追风的油腻中年男
    avatar: 12
    uuid:7aa4b10e277f4d4c820571b848b7e60d
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "username": "songyubo",
            "nickname": "追风的油腻中年男",
            "role": 2,
            "status": 1,
            "region": "320100",
            "avatar": "12",
            "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
        }
    }
    ```

### Question and Answer

1. Get the list of questions

    **Request**
    
    ```http request
    GET /interactive/question/index
    ```
    
    **Response**

2. Student create a new question

    **Request**
    
    ```http request
    POST /interactive/question/index
    ```
    
    **Parameters**
    
    **Response**
    
3. Teacher review and validate the question
 
    **Request**
    
    ```http request
    PATCH /interactive/question/index/review/{uuid}
    ```
   
4. Teacher answer a specific question

    **Request**
    
    ```http request
    PATCH /interactive/question/index/answer/{uuid}
    ```
    
    **Parameters**
    
    **Response**


### Notification

1. Get the list of notifications

    **Request**
    
    ```http request
    GET /interactive/notification/index
    ```
    
    **Response**

2. Teacher create new notification
    
    **Request**
    
    ```http request
    POST /interactive/notification/index
    ```
    
    **Parameters**
    
    **Response**
    
3. Teacher change the detail of failed notification

    **Request**
    
    ```http request
    PATCH /interactive/notification/index/{uuid}
    ```
    
    **Parameters**
    
    **Response**

### Data Visualization

1. Get the visualization data of student region distribution

    **Request**
    
    ```http request
    GET /visualization/region/index
    ```
    
    **Response**
    
2. Get the visualization data of statistics

    **Request**
    
    ```http request
    GET /visualization/statistics/index
    ```
    
    **Response**
    
3. Get the visualization data of line charts

    **Request**
    
    ```http request
    GET /visualization/chart/index
    ```
    
    **Response**
    
4. Get the visualization data of division distribution

    **Request**
    
    ```http request
    GET /visualization/division/index
    ```
    
    **Response**
    
5. Get the visualization data of communication situation

    **Request**
    
    ```http request
    GET /visualization/communication/index
    ``` 
    
    **Response**
