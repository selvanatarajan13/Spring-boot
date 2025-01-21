-- Drop user first if they exist --
DROP USER IF EXISTS 'springEmployee'@'localhost';

-- Now create user with prop privileges --
CREATE USER 'springEmployee'@'localhost' IDENTIFIED BY 'springEmployee';

GRANT ALL PRIVILEGES ON *.* TO 'springEmployee'@'localhost';