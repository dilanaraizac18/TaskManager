CREATE TABLE Status(
IdStatus NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
StatusName VARCHAR(50) NOT NULL
);

CREATE TABLE Task (
IdTask NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
Tittle VARCHAR(100) NOT NULL,
Description VARCHAR(200) NULL,
IdStatus NUMBER NOT NULL,
CONSTRAINT FK_IdStatus
FOREIGN KEY (IdStatus)
REFERENCES Status(IdStatus),
CreationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)

INSERT INTO Status (StatusName) VALUES ('Pending');
INSERT INTO Status (StatusName) VALUES ('InProgress');
INSERT INTO Status (StatusName) VALUES ('Completed');

INSERT INTO Task (Tittle, Description, IdStatus) VALUES ('Create new table', 'We need to create a new table in our system', 1);

SELECT task.tittle, task.description, task.creationdate, status.statusname from task left join status on task.idstatus = status.idstatus