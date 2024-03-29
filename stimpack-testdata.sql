DELETE FROM student_subject;
DELETE FROM subject;
DELETE FROM student;
DELETE FROM teacher;

INSERT INTO teacher
( teacher_id, username, password, firstname, lastname, phone, email, age )
VALUES
( 1, 'd.balsam', '5f4dcc3b5aa765d61d8327deb882cf99', 'David', 'Balsam', '0409404075', 'd.balsam@uni.edu', 44 ),
( 2, 'a.programmer', '5f4dcc3b5aa765d61d8327deb882cf99', 'Andrew', 'Programmer', '+63 88494885', 'a.programmer@uni.edu', 27 ),
( 3, 't.user', '5f4dcc3b5aa765d61d8327deb882cf99', 'Test', 'User', '30923 722', 't.user@uni.edu', 47 ),
( 4, 'j.rule', '5f4dcc3b5aa765d61d8327deb882cf99', 'Ja', 'Rule', '343897322', 'j.rule@uni.edu', 24 );

INSERT INTO subject
( class_id, teacher_id, name, maxstudents, schedule )
VALUES
( 1, 1, 'Intro to Music Theory', 66, 'Monday 14:30' ),
( 2, 2, 'Programming 2', 40, 'Tuesday 09:30' ),
( 3, 1, 'Elements of Classical Music', 30, 'Thursday 08:30' ),
( 4, 3, 'Generating Test Data 101', 90, 'Thursday 16:30' ),
( 5, 2, 'Database Administration', 30, 'Monday 12:30' ),
( 6, 3, 'Advanced Test Data', 20, 'Wednesday 12:30' );

INSERT INTO student
( student_id, username, password, firstname, lastname, phone, email, age )
VALUES
( 1, '30081056', '5f4dcc3b5aa765d61d8327deb882cf99', 'Joshua', 'McLean', '098484309', 'joshua.mclean@students.uni.edu', 24 ),
( 2, '30054983', '5f4dcc3b5aa765d61d8327deb882cf99', 'Typical', 'Student', '33985930', 'typical.student@students.uni.edu', 20 ),
( 3, '30020973', '5f4dcc3b5aa765d61d8327deb882cf99', 'Dave', 'Hughes', '+64 298734343', 'dave.hughes@students.uni.edu', 32 ),
( 4, '30093305', '5f4dcc3b5aa765d61d8327deb882cf99', 'Patricia', 'Hendrix', '738347832', 'patricia.hendrix@students.uni.edu', 28 ),
( 5, '30882937', '5f4dcc3b5aa765d61d8327deb882cf99', 'Rowan', 'Freeman', '0988938499', 'rowan.freeman@students.uni.edu', 22 ),
( 6, '30082988', '5f4dcc3b5aa765d61d8327deb882cf99', 'Gordon', 'Freeman', '539948944', 'gordon.freeman@students.uni.edu', 35 ),
( 7, '30082211', '5f4dcc3b5aa765d61d8327deb882cf99', 'Soap', 'McTavish', '53998773', 'soap.mctavish@students.uni.edu', 41 ),
( 8, '30079822', '5f4dcc3b5aa765d61d8327deb882cf99', 'Andrew', 'Kilmartin', '0404099837', 'andrew.kilmartin@students.uni.edu', 25 ),
( 9, '30011011', '5f4dcc3b5aa765d61d8327deb882cf99', 'Amar', 'Kaur', '+62 9983222', 'amar.kaur@students.uni.edu', 30 );

INSERT INTO student_subject
( class_id, student_id )
VALUES
( 1, 1 ),
( 1, 2 ),
( 1, 4 ),
( 1, 5 ),
( 1, 6 ),
( 1, 7 ),
( 1, 8 ),
( 1, 9 ),
( 2, 1 ),
( 5, 1 );
