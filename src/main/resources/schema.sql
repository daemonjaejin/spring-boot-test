-- drop table IF EXISTS BATCH_JOB_EXECUTION_CONTEXT;
-- drop table IF EXISTS BATCH_JOB_EXECUTION_PARAMS;
-- drop table IF EXISTS BATCH_JOB_EXECUTION_SEQ;
-- drop table IF EXISTS BATCH_JOB_SEQ;
-- drop table IF EXISTS BATCH_STEP_EXECUTION_CONTEXT;
-- drop table IF EXISTS BATCH_STEP_EXECUTION_SEQ;
-- drop table IF EXISTS BATCH_STEP_EXECUTION;
-- drop table IF EXISTS BATCH_JOB_EXECUTION;
-- drop table IF EXISTS BATCH_JOB_INSTANCE;
DROP TABLE IF EXISTS reader;
DROP TABLE IF EXISTS writer;

CREATE TABLE `reader` (`id` INT NOT NULL AUTO_INCREMENT,`firstName` VARCHAR(20) NULL,`lastName` VARCHAR(20) NULL,`random_num` VARCHAR(20) NULL, PRIMARY KEY (`id`));
CREATE TABLE `writer` (`id` INT NOT NULL AUTO_INCREMENT,`full_name` VARCHAR(40) NULL,`random_num` VARCHAR(20) NULL, PRIMARY KEY (`id`));

INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Hailee', 'Steinfeld', '1');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Aimee', 'Garcia', '2');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Whoopi', 'Goldberg', '3');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Joel', 'Grey', '4');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Rick', 'Gomez', '5');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Elle', 'Fanning', '6');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Gwyneth Kate', 'Paltrow', '7');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Amy Lou', 'Adams', '8');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Milena', 'Kunis', '9');
INSERT INTO `reader` (`firstName`, `lastName`, `random_num`) VALUES ('Rachel Anne', 'McAdams', '10');
