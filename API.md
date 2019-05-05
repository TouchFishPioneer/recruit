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
               "name": "宋睿",
               "gender": 1,
               "tel": "18795887803",
               "birthday": "1994-11-19T06:00:00.000+0000",
               "identity_number": "321323199411202852",
               "admission_number": "123486486158648794648",
               "region": "321323",
               "school": "江苏省泗阳中学",
               "mark": 378,
               "division": 1,
               "rank": 2000,
               "remarks": "除了机械学院，可能还配能环",
               "info_source": 1,
               "contact_status": 0,
               "intentional_major": "2",
               "unintentional_major": "",
               "grade": 3,
               "uuid": "08af02a583424620966b24156a58ea9f"
           },
           {
               "name": "李轩",
               "gender": 1,
               "tel": "18452579588",
               "birthday": "1995-04-25T05:00:00.000+0000",
               "identity_number": "140502199504262574",
               "admission_number": "140524523664578825657",
               "region": "140502",
               "school": "河北省正定中学",
               "mark": 675,
               "division": 1,
               "rank": 1500,
               "remarks": "给我整个最好的",
               "info_source": 0,
               "contact_status": 0,
               "intentional_major": "3",
               "unintentional_major": "2",
               "grade": 3,
               "uuid": "446b96a42b9a4745b522c2b69a3163c1"
           },
           {
               "name": "石伟",
               "gender": 1,
               "tel": "14758745214",
               "birthday": "1995-10-14T05:00:00.000+0000",
               "identity_number": "320805199510150257",
               "admission_number": "320815156548468486684",
               "region": "320805",
               "school": "江苏省如皋中学",
               "mark": 385,
               "division": 1,
               "rank": 1200,
               "remarks": "也给我整个最好的",
               "info_source": 0,
               "contact_status": 0,
               "intentional_major": "4",
               "unintentional_major": "2",
               "grade": 3,
               "uuid": "cb52749664ad4d60925a4c01e4f052fa"
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
            "name": "宋睿",
            "gender": 1,
            "tel": "18795887803",
            "birthday": "1994-11-19T06:00:00.000+0000",
            "identity_number": "321323199411202852",
            "admission_number": "123486486158648794648",
            "region": "321323",
            "school": "江苏省泗阳中学",
            "mark": 378,
            "division": 1,
            "rank": 2000,
            "remarks": "只配机械学院",
            "info_source": 1,
            "contact_status": 0,
            "intentional_major": "2",
            "unintentional_major": "",
            "grade": 3,
            "uuid": "08af02a583424620966b24156a58ea9f"
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
    name: 宋睿
    gender: 1
    tel: 18795887803
    birthday: 1994-11-20
    identity_number: 321323199411202852
    admission_number: 123486486158648794648
    region: 321323
    school: 江苏省泗阳中学
    mark: 378
    division: 1
    rank: 2000
    remarks: 只配机械学院
    intentional_major: 2
    unintentional_major:
    grade: 3
    uuid: 08af02a583424620966b24156a58ea9f
    ```
    > If the parameters from front end contain 'uuid' field, it means that this student has already signed in this system, and the given 'uuid' should be consistent with the 'studentUuid' field in student account table.

    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "name": "宋睿",
            "gender": 1,
            "tel": "18795887803",
            "birthday": "1994-11-19T16:00:00.000+0000",
            "identity_number": "321323199411202852",
            "admission_number": "123486486158648794648",
            "region": "321323",
            "school": "江苏省泗阳中学",
            "mark": 378,
            "division": 1,
            "rank": 2000,
            "remarks": "只配机械学院",
            "info_source": 1,
            "contact_status": 0,
            "intentional_major": "2",
            "unintentional_major": "",
            "grade": 3,
            "uuid": "08af02a583424620966b24156a58ea9f"
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
    remarks: 除了机械学院，可能还配能环
    uuid: 08af02a583424620966b24156a58ea9f
    ```
    > Tip: you do not need to pass all the fields of one student but only the field(s) which you want to update.
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "name": "宋睿",
            "gender": 1,
            "tel": "18795887803",
            "birthday": "1994-11-19T06:00:00.000+0000",
            "identity_number": "321323199411202852",
            "admission_number": "123486486158648794648",
            "region": "321323",
            "school": "江苏省泗阳中学",
            "mark": 378,
            "division": 1,
            "rank": 2000,
            "remarks": "除了机械学院，可能还配能环",
            "info_source": 1,
            "contact_status": 0,
            "intentional_major": "2",
            "unintentional_major": "",
            "grade": 3,
            "uuid": "08af02a583424620966b24156a58ea9f"
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
                "name": "宋宇波",
                "card_number": "130055213",
                "gender": 1,
                "tel": "025-12345678",
                "department": "57",
                "duty": "副教授",
                "graduated_school": "东南大学",
                "remarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
                "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
            },
            {
                "name": "彭林宁",
                "card_number": "130081245",
                "gender": 1,
                "tel": "025-52091692",
                "department": "57",
                "duty": "副研究员",
                "graduated_school": "法国雷恩国立应用科学学院",
                "remarks": "研究领域：通信系统物理层安全，射频指纹识别，无线信道密钥生成，室内定位，软件无线电。",
                "uuid": "b5133f642e044ca5842680848adcf41a"
            },
            {
                "name": "胡爱群",
                "card_number": "130905417",
                "gender": 1,
                "tel": "025-83795112",
                "department": "57",
                "duty": "教授",
                "graduated_school": "东南大学",
                "remarks": "研究领域：无线网络安全、物理层安全技术。",
                "uuid": "af1256aa57c14a8183a0767135cbb2fe"
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
            "name": "宋宇波",
            "card_number": "130055213",
            "gender": 1,
            "tel": "025-12345678",
            "department": "57",
            "duty": "副教授",
            "graduated_school": "东南大学",
            "remarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
            "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
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
    name: 宋宇波
    card_number: 130055213
    gender: 1
    tel: 13851884333
    department: 57
    duty: 副教授
    graduated_school: 东南大学
    remarks: 研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。
    uuid: 7aa4b10e277f4d4c820571b848b7e60d
    ```
    
    > If the parameters from front end contain 'uuid' field, it means that this teacher has already signed in this system, and the given 'uuid' should be consistent with the 'teacherUuid' field in teacher account table.
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "name": "宋宇波",
            "card_number": "130055213",
            "gender": 1,
            "tel": "13851884333",
            "department": "57",
            "duty": "副教授",
            "graduated_school": "东南大学",
            "remarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
            "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
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
    tel: 025-12345678
    uuid: 7aa4b10e277f4d4c820571b848b7e60d
    ```
    > Tip: Just like the student side, you do not need to pass all the fields of one teacher but only the field(s) which you want to update.
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "name": "宋宇波",
            "card_number": "130055213",
            "gender": 1,
            "tel": "025-12345678",
            "department": "57",
            "duty": "副教授",
            "graduated_school": "东南大学",
            "remarks": "研究领域：无线网络和移动通信安全，移动终端安全，隐私数据安全等。",
            "uuid": "7aa4b10e277f4d4c820571b848b7e60d"
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
    
    > Caution: You should not modify the 'password' field by this interface. The modification of 'password' should be performed by its specific API below.
    
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

3. Update the password of specific student

    **Request**
    
    ```http request
    PATCH /account/student/index/password
    ```
    
    **Parameters**
    
    ```http request
    old_password: 123456789
    password: 20090520
    uuid: 08af02a583424620966b24156a58ea9f
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success"
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

3. Update the password of specific teacher

    **Request**
    
    ```http request
    PATCH /account/teacher/index/password
    ```
    
    **Parameters**
    
    ```http request
    old_password: 18765432
    password: 12345678
    uuid: 7aa4b10e277f4d4c820571b848b7e60d
    ```

    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success"
    }
    ```

### Q & A

1. Get the list of questions

    **Request**
    
    ```http request
    GET /interactive/question/index
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": [
            {
                "region": "001122",
                "asker_uuid": "b9b59dc26d384f08a777d42fc1734708",
                "theme": "母猪的产后护理",
                "category": null,
                "tag": null,
                "status": 0,
                "content": "你说你🐎呢",
                "vote": 0,
                "answer": null,
                "answerer_uuid": null,
                "uuid": "c4495f4937eb445bb48d0c78d0cb2398"
            },
            {
                "region": "320100",
                "asker_uuid": "08af02a583424620966b24156a58ea9f",
                "theme": "母猪的产后护理",
                "category": null,
                "tag": null,
                "status": 1,
                "content": "想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？",
                "vote": 1,
                "answer": "没有，滚。",
                "answerer_uuid": "7aa4b10e277f4d4c820571b848b7e60d",
                "uuid": "befdb25be4934f1eb9613c2e5c1392cb"
            }
        ]
    }
    ```

2. Student create a new question

    **Request**
    
    ```http request
    POST /interactive/question/index
    ```
    
    **Parameters**
    
    ```http request
    region: 320100
    asker_uuid: 08af02a583424620966b24156a58ea9f
    theme: 母猪的产后护理
    content: 想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "region": "320100",
            "asker_uuid": "08af02a583424620966b24156a58ea9f",
            "theme": "母猪的产后护理",
            "category": null,
            "tag": null,
            "status": 0,
            "content": "想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？",
            "vote": 0,
            "answer": null,
            "answerer_uuid": null,
            "uuid": "befdb25be4934f1eb9613c2e5c1392cb"
        }
    }
    ```
    
3. Teacher review and validate the question
 
    **Request**
    
    ```http request
    PATCH /interactive/question/index/review/{uuid}
    ```
    
    **Parameters**
    
    ```http request
    status: 1
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "region": "320100",
            "asker_uuid": "08af02a583424620966b24156a58ea9f",
            "theme": "母猪的产后护理",
            "category": null,
            "tag": null,
            "status": 1,
            "content": "想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？",
            "vote": 0,
            "answer": null,
            "answerer_uuid": null,
            "uuid": "befdb25be4934f1eb9613c2e5c1392cb"
        }
    }
    ```
    
4. Student vote for a specific question

    **Request**
    
    ```http request
    POST /interactive/question/index/vote/{uuid}
    ```
    
    **Parameters**
    
    ```http request
    student_uuid: 08af02a583424620966b24156a58ea9f
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "region": "320100",
            "asker_uuid": "08af02a583424620966b24156a58ea9f",
            "theme": "母猪的产后护理",
            "category": null,
            "tag": null,
            "status": 1,
            "content": "想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？",
            "vote": 1,
            "answer": null,
            "answerer_uuid": null,
            "uuid": "befdb25be4934f1eb9613c2e5c1392cb"
        }
    }
    ```

5. Teacher answer a specific question

    **Request**
    
    ```http request
    PATCH /interactive/question/index/answer/{uuid}
    ```
    
    **Parameters**
    
    ```http request
    answer: 没有，滚。
    answerer_uuid: 7aa4b10e277f4d4c820571b848b7e60d
    ```
    
    **Response**
    
    ```json
    {
        "code": 200,
        "message": "success",
        "data": {
            "region": "320100",
            "asker_uuid": "08af02a583424620966b24156a58ea9f",
            "theme": "母猪的产后护理",
            "category": null,
            "tag": null,
            "status": 1,
            "content": "想要咨询一下东南大学有母猪产后护理专业吗？在江苏省多少分能上啊？",
            "vote": 1,
            "answer": "没有，滚。",
            "answerer_uuid": "7aa4b10e277f4d4c820571b848b7e60d",
            "uuid": "befdb25be4934f1eb9613c2e5c1392cb"
        }
    }
    ```


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
