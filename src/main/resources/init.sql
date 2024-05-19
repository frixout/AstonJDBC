-- Таблица Profile (профиль)
CREATE TABLE Profile (
    ProfileID BIGSERIAL  PRIMARY KEY,
    Address VARCHAR(255),
    PhoneNumber VARCHAR(20)
);

-- Таблица Role (должность)
CREATE TABLE Role (
    RoleID BIGSERIAL  PRIMARY KEY,
    RoleName VARCHAR(100),
    Salary DECIMAL(10, 2)
);

-- Таблица Project (проект)
CREATE TABLE Project (
    ProjectID BIGSERIAL  PRIMARY KEY,
    ProjectName VARCHAR(100)
);

-- Таблица Employee (работник)
CREATE TABLE Employee (
    EmployeeID BIGSERIAL  PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    RoleID INT, -- Связь многие к одному с таблицей Role
    ProfileID INT UNIQUE, -- Связь один к одному с таблицей Profile
    FOREIGN KEY (RoleID) REFERENCES Role(RoleID),
    FOREIGN KEY (ProfileID) REFERENCES Profile(ProfileID)
);

-- Промежуточная таблица Project_Employee (связь многие ко многим между Project и Employee)
CREATE TABLE Project_Employee (
    ProjectID BIGINT,
    EmployeeID BIGINT,
    PRIMARY KEY (ProjectID, EmployeeID),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

