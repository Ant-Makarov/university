insert into lector (lector_id, degree, name, salary) values
(gen_random_uuid(), 'PROFESSOR', 'Mike', 13500),
(gen_random_uuid(), 'ASSOCIATE_PROFESSOR', 'Bill', 7500),
(gen_random_uuid(), 'ASSISTANT', 'Fred', 5000),
(gen_random_uuid(), 'ASSISTANT', 'Mia', 5000),
(gen_random_uuid(), 'PROFESSOR', 'John', 13500),
(gen_random_uuid(), 'ASSOCIATE_PROFESSOR', 'Maria', 7500),
(gen_random_uuid(), 'ASSISTANT', 'Johanna', 5000),
(gen_random_uuid(), 'ASSISTANT', 'Victor', 5000),
(gen_random_uuid(), 'PROFESSOR', 'Katy', 13500),
(gen_random_uuid(), 'ASSOCIATE_PROFESSOR', 'Margo', 7500),
(gen_random_uuid(), 'ASSISTANT', 'Roxana', 5000),
(gen_random_uuid(), 'ASSISTANT', 'Barbara', 5000);

-- Given as example, the head_of_department column value is randomed by gen_random_uuid() function

insert into department values
(gen_random_uuid(), 'COMPUTER SCIENCE', '8c542277-6856-447c-b7de-301044ee14a0'),
(gen_random_uuid(), 'MATH', '423f5bf9-3360-4390-9eb2-ccf80c09be3a'),
(gen_random_uuid(), 'LANGS', 'db00f47c-9117-4e19-9ffc-5ecec5d2606d');

-- Given as example, in your case you will have different values for
-- lector_id and department_id in reason of gen_random_uuid() function

insert into lector_department values
('8c542277-6856-447c-b7de-301044ee14a0','82f87374-9d33-43bb-9766-8dcaa5ef1876'),
('57670901-979d-4f94-bf7c-a98efa8b1f48','82f87374-9d33-43bb-9766-8dcaa5ef1876'),
('f4fb58b5-1b26-43a1-bba3-d888a35ec564','82f87374-9d33-43bb-9766-8dcaa5ef1876'),
('6265f812-77fb-4708-a31e-433116023daa','82f87374-9d33-43bb-9766-8dcaa5ef1876'),
('423f5bf9-3360-4390-9eb2-ccf80c09be3a', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('a6a606fd-991d-4045-8df5-cbef180c590a', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('487c5848-852b-43dd-843d-0918240004bf', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('b8cbe427-4f4f-4f44-8743-22decb3e051d', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('db00f47c-9117-4e19-9ffc-5ecec5d2606d', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('0a9601ae-f26f-4858-a7c0-5b81b8fb7330', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('523fcb6e-abb3-4a95-bd85-f9ef07ab3e42', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc'),
('121ff73e-080e-4120-bf1d-e601d4074e25', 'cb1c474d-0de1-4d8e-907d-9c84c5f1dddc');