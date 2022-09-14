use Lovushkina;

CREATE TABLE app (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    description text NOT NULL,
    weight_in_mb int NOT NULL,
    create_date date NOT NULL,
    is_free bool NOT NULL,
    price decimal(8,2) NULL,
    has_advert bool NOT NULL,
    category_id int NOT NULL,
    CONSTRAINT app_pk PRIMARY KEY (id)
);

-- Table: app_category
CREATE TABLE app_category (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    description text NULL,
    CONSTRAINT app_category_pk PRIMARY KEY (id)
);

-- Table: app_creating
CREATE TABLE app_creating (
    app_id int NOT NULL,
    creater_id int NOT NULL,
    CONSTRAINT app_creating_pk PRIMARY KEY (app_id,creater_id)
);

-- Table: card
CREATE TABLE card (
    number_hash varchar(50) NOT NULL,
    bank_name varchar(25) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (number_hash)
);

-- Table: category
CREATE TABLE category (
    id int NOT NULL AUTO_INCREMENT,
    audience_type enum ('child', 'teen', 'mature', 'all') NOT NULL,
    app_category_id int NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: creater
CREATE TABLE creater (
    id int NOT NULL AUTO_INCREMENT,
    full_name varchar(60) NOT NULL,
    work_branch varchar(50) NOT NULL,
    email varchar(70) NOT NULL,
    created_app int NULL,
    CONSTRAINT creater_pk PRIMARY KEY (id)
);

-- Table: device_type
CREATE TABLE device_type (
    device enum('mobile', 'tablet', 'chromebook', 'tv') NOT NULL,
    app_id int NOT NULL,
    id int NOT NULL AUTO_INCREMENT,
    CONSTRAINT device_type_pk PRIMARY KEY (id)
);

-- Table: download
CREATE TABLE download (
    id int NOT NULL AUTO_INCREMENT,
    amount int NOT NULL,
    total_price decimal(8,2) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT download_pk PRIMARY KEY (id)
);

-- Table: download_info
CREATE TABLE download_info (
    downloaded_time time NOT NULL,
    app_id int NOT NULL,
    download_id int NOT NULL,
    CONSTRAINT download_info_pk PRIMARY KEY (app_id,download_id)
);

-- Table: email_preferences
CREATE TABLE email_preferences (
    email varchar(100) NOT NULL AUTO_INCREMENT,
    keep_with_up_to_date_news bool NOT NULL,
    receive_reply_notification bool NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT email_preferences_pk PRIMARY KEY (email)
);

-- Table: feedback
CREATE TABLE feedback (
    id int NOT NULL AUTO_INCREMENT,
    description text NULL,
    created_date date NOT NULL,
    rate int NOT NULL,
    user_id int NOT NULL,
    app_id int NOT NULL,
    CONSTRAINT feedback_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    password_hash char(50) NOT NULL,
    full_name varchar(100) NOT NULL,
    country varchar(30) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: app_category (table: app)
ALTER TABLE app ADD CONSTRAINT app_category FOREIGN KEY app_category (category_id)
    REFERENCES category (id);

-- Reference: app_creating_app (table: app_creating)
ALTER TABLE app_creating ADD CONSTRAINT app_creating_app FOREIGN KEY app_creating_app (app_id)
    REFERENCES app (id);

-- Reference: app_creating_creater (table: app_creating)
ALTER TABLE app_creating ADD CONSTRAINT app_creating_creater FOREIGN KEY app_creating_creater (creater_id)
    REFERENCES creater (id);

-- Reference: card_user (table: card)
ALTER TABLE card ADD CONSTRAINT card_user FOREIGN KEY card_user (user_id)
    REFERENCES user (id);

-- Reference: category_app_category (table: category)
ALTER TABLE category ADD CONSTRAINT category_app_category FOREIGN KEY category_app_category (app_category_id)
    REFERENCES app_category (id);

-- Reference: device_type_app (table: device_type)
ALTER TABLE device_type ADD CONSTRAINT device_type_app FOREIGN KEY device_type_app (app_id)
    REFERENCES app (id);

-- Reference: download_info_app (table: download_info)
ALTER TABLE download_info ADD CONSTRAINT download_info_app FOREIGN KEY download_info_app (app_id)
    REFERENCES app (id);

-- Reference: download_info_download (table: download_info)
ALTER TABLE download_info ADD CONSTRAINT download_info_download FOREIGN KEY download_info_download (download_id)
    REFERENCES download (id);

-- Reference: download_user (table: download)
ALTER TABLE download ADD CONSTRAINT download_user FOREIGN KEY download_user (user_id)
    REFERENCES user (id);

-- Reference: email_preferences_user (table: email_preferences)
ALTER TABLE email_preferences ADD CONSTRAINT email_preferences_user FOREIGN KEY email_preferences_user (user_id)
    REFERENCES user (id);

-- Reference: feedback_app (table: feedback)
ALTER TABLE feedback ADD CONSTRAINT feedback_app FOREIGN KEY feedback_app (app_id)
    REFERENCES app (id);

-- Reference: feedback_user (table: feedback)
ALTER TABLE feedback ADD CONSTRAINT feedback_user FOREIGN KEY feedback_user (user_id)
    REFERENCES user (id);


-- Insertions:


INSERT INTO app_category( name, description )  VALUES('Books', 'Apps that provide extensive interactivity for content that is traditionally offered in printed form. If you’re planning a more traditional reading experience, you may want to look at publishing an iBook instead.');
INSERT INTO app_category( name, description )  VALUES('Business', 'Apps that assist with running a business or provide a means to collaborate, edit, or share content.');
INSERT INTO app_category( name, description )  VALUES('Developer Tools', 'Apps that provide tools for app development, management, and distribution.');
INSERT INTO app_category( name, description )  VALUES('Education', 'Apps that provide an interactive learning experience on a specific skill or subject.');
INSERT INTO app_category( name, description )  VALUES('Entertainment', 'Apps that are interactive and designed to entertain and inform the user, and which contain audio, visual, or other content.');
INSERT INTO app_category( name, description )  VALUES('Games', 'Apps that provide single or multiplayer interactive activities for entertainment purposes.');
INSERT INTO app_category( name, description )  VALUES('Sports', 'Apps related to professional, amateur, collegiate, or recreational sporting activities.');
INSERT INTO app_category( name, description )  VALUES('Social Networking', 'Apps that connect people by means of text, voice, photo, or video. Apps that contribute to community development.');
INSERT INTO app_category( name, description )  VALUES('Photo & Video', 'Apps that assist in capturing, editing, managing, storing, or sharing photos and videos.');
INSERT INTO app_category( name, description )  VALUES('Music', 'Apps that are for discovering, listening to, recording, performing, or composing music, and that are interactive in nature.');

INSERT INTO category( audience_type, app_category_id )  VALUES('child', 6);
INSERT INTO category( audience_type, app_category_id )  VALUES('teen', 4);
INSERT INTO category( audience_type, app_category_id )  VALUES('all', 8);
INSERT INTO category( audience_type, app_category_id )  VALUES('teen', 10);
INSERT INTO category( audience_type, app_category_id )  VALUES('mature', 3);
INSERT INTO category( audience_type, app_category_id )  VALUES('mature', 2);
INSERT INTO category( audience_type, app_category_id )  VALUES('all', 5);
INSERT INTO category( audience_type, app_category_id )  VALUES('teen', 9);
INSERT INTO category( audience_type, app_category_id )  VALUES('all', 1);
INSERT INTO category( audience_type, app_category_id )  VALUES('mature', 7);

INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Amoung us','Play online or over local WiFi with 4-15 players as you attempt to prep your spaceship for departure, but beware as one will be an impostor bent on killing everyone', 230, '2021-12-12', true, null, true, 1);
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Cash up','Cash App is the easy way to send, spend, save, and invest* your money. It’s the SAFE, FAST, and FREE mobile finance** app.', 150, '2022-01-30', true, null, true, 6);
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Audible','Get entertainment that moves with you this summer. Wherever your travels take you, indulge in a binge-worthy library of audiobooks, tune into exclusive podcasts and discover genre-bending Audible Originals', 150, '2022-09-01', false, 5, true, 9); -- books
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Deep Cleaner-Phone Faster','DeepCleaner, focusing on mobile phone cleaning, makes your mobile phone smooth from now on.', 130, '2022-07-27', true, null, false, 5);   -- dev tools
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('SkyView Explore Universe','You dont need to be an astronomer to find stars or constellations in the sky, just open SkyView® and let it guide you to their location and identify them.', 350, '2022-01-30', false, 2, false, 2);   -- education
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Scanner Radio Pro','Listen to live audio from over 7,000 fire and police scanners, weather radios, amateur radio repeaters, air traffic and marine radios from around the world. ', 260, '2022-08-20', false, 24.99, true, 7);   -- entertaiment
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('ESPN','Watch thousands of live events and shows from the ESPN networks plus get scores, on-demand news, highlights, and expert analysis.', 250, '2022-08-25', true, null, true, 10);   -- sport
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('TikTok','trends start here. On a device or on the web, viewers can watch and discover millions of personalized short videos.', 450, '2022-06-29', true, null, true, 3);   -- social
INSERT INTO app( name, description, weight, create_date, is_free, price, has_advert, category_id )  
VALUES('Filto: Video Editor','Best photo/video editor with customized aesthetic sparkle filters & VHS effects which updated weekly. The coolest video & photo editor with multi-style content for creators! Its the easiest to use on IG and Facebook!', 180, '2022-09-01', true, null, true, 8);   -- photo video

INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Benjamin Franklin', 'back-end developer', 'benjamin@gmail.com',3);  
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Antoniy Fraanz', 'fron-end developer', 'front_ant@gmail.com',5);  
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Liss Trass', 'full-stack developer', 'trass11@gmail.com',2);  
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Kety Bonni', 'designer developer', 'rett455@gmail.com',7);
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Mellisa Gniss', 'back-end developer', 'mellis@gmail.com',5);
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Irina Kucher', 'front-end developer', 'kucher00@gmail.com',2);
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Pfilip Temonenko', 'designer', 'temonenko1@gmail.com',1);
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Georg Simomns', 'full-stack developer', 'tgeorg101@gmail.com',6);
INSERT INTO creater( full_name, work_branch, email, created_app ) VALUES('Anita Lovush', 'back-end developer', 'anita_lov11@gmail.com',5);
DELETE FROM app WHERE id between 14 AND 19;

INSERT INTO app_creating( app_id, creater_id ) VALUES(1,1);
INSERT INTO app_creating( app_id, creater_id ) VALUES(1,2);
INSERT INTO app_creating( app_id, creater_id ) VALUES(2,3);
INSERT INTO app_creating( app_id, creater_id ) VALUES(3,1);
INSERT INTO app_creating( app_id, creater_id ) VALUES(3,4);
INSERT INTO app_creating( app_id, creater_id ) VALUES(4,5);
INSERT INTO app_creating( app_id, creater_id ) VALUES(4,6);
INSERT INTO app_creating( app_id, creater_id ) VALUES(5,5);
INSERT INTO app_creating( app_id, creater_id ) VALUES(5,7);
INSERT INTO app_creating( app_id, creater_id ) VALUES(6,8);
INSERT INTO app_creating( app_id, creater_id ) VALUES(7,9);
INSERT INTO app_creating( app_id, creater_id ) VALUES(7,2);
INSERT INTO app_creating( app_id, creater_id ) VALUES(8,3);
INSERT INTO app_creating( app_id, creater_id ) VALUES(9,1);
INSERT INTO app_creating( app_id, creater_id ) VALUES(9,2);
INSERT INTO app_creating( app_id, creater_id ) VALUES(10,8);

INSERT INTO download( amount, total_price, user_id ) VALUES(3,5,1);
INSERT INTO download( amount, total_price, user_id ) VALUES(1,24.99,3);
INSERT INTO download( amount, total_price, user_id ) VALUES(4,7,4);
INSERT INTO download( amount, total_price, user_id ) VALUES(2,0,5);
INSERT INTO download( amount, total_price, user_id ) VALUES(3,7.99,6);
INSERT INTO download( amount, total_price, user_id ) VALUES(1,0,7);
INSERT INTO download( amount, total_price, user_id ) VALUES(2,5,8);
INSERT INTO download( amount, total_price, user_id ) VALUES(5,26.99,9);
INSERT INTO download( amount, total_price, user_id ) VALUES(2,2,10);

INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('11:12:00',1,1);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('11:12:00',2,1);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('11:12:00',,1);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('22:10:00',6,2);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('17:11:50',3,3);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('17:12:50',4,3);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('17:15:50',5,3);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('17:16:50',7,3);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('19:06:40',8,4);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('19:06:44',9,4);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('10:06:40',5,5);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('10:08:40',10,5);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('10:09:40',7,5);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('01:30:40',4,6);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('16:48:00',3,7);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('16:49:40',9,7);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('18:20:40',6,8);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('18:22:40',5,8);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('18:22:10',8,8);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('18:23:30',4,8);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('18:26:40',1,8);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('08:40:00',5,9);
INSERT INTO download_info( downloaded_time, app_id, download_id ) VALUES('08:45:00',9,9);

alter table card modify number bigint;
INSERT INTO card( number, bank_name, user_id ) VALUES(4149303340666789,'privat',1);
INSERT INTO card( number, bank_name, user_id ) VALUES(5749303390696989,'mono',2);
INSERT INTO card( number, bank_name, user_id ) VALUES(5847373390655970,'pumb',2);
INSERT INTO card( number, bank_name, user_id ) VALUES(4149373390655970,'privat',3);
INSERT INTO card( number, bank_name, user_id ) VALUES(5947373390657000,'mono',4);
INSERT INTO card( number, bank_name, user_id ) VALUES(5890073390688970,'alpfa',5);
INSERT INTO card( number, bank_name, user_id ) VALUES(4557373390655970,'mono',5);
INSERT INTO card( number, bank_name, user_id ) VALUES(4149372380655900,'privat',6);
INSERT INTO card( number, bank_name, user_id ) VALUES(5847377270645970,'pumb',7);
INSERT INTO card( number, bank_name, user_id ) VALUES(41447722396655920,'mono',8);
INSERT INTO card( number, bank_name, user_id ) VALUES(5882277395655076,'alpfa',9);
INSERT INTO card( number, bank_name, user_id ) VALUES(4149390396157550,'privat',10);

alter table feedback modify rate float;
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('nice try , go forward','2022-01-10', 4.0, 1, 4);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('could be better','2021-11-13', 3.0, 2, 1);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('and i paid money for that!','2022-05-30', 2.0, 3, 3);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('everything works totally fine','2020-09-16', 4.5, 4, 7);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('i like that app','2022-08-08', 5.0, 5, 2);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('uh....', '2022-09-08',1.0, 6, 6);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('nice app','2021-12-12', 4.0, 7, 8);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('i hope you change the bugs','2022-03-18', 3.0, 8, 9);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('that is my favorite app','2022-02-20', 5.0, 9, 10);
INSERT INTO feedback( description, created_date, rate, user_id , app_id) VALUES('i like it','2021-09-10', 4.5, 2, 5);

INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('mirzoyan@gmail.com',true, false, 1);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('filomonova11@gmail.com',true, true, 2);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('govorotnhuk12@gmail.com',false, false, 3);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('govorotnhuk22@gmail.com',true, true, 3);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('tigran002@gmail.com',true, false, 4);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('kateryna_petr12@gmail.com',false, false, 5);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('olekseyinko_nina11@gmail.com',true, true, 6);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('kin_olga77@gmail.com',false, true, 7);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('olga_kin99@gmail.com',true, false, 7);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('kostomarow-evg4@gmail.com',true, true, 8);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('naguevich55@gmail.com',false, true, 9);
INSERT INTO email_preferences( email, keep_with_up_to_date_news,receive_reply_notification, user_id ) VALUES('tilda-nastya2@gmail.com',false, false, 10);

INSERT INTO device_type( device, app_id ) VALUES('mobile',1);
INSERT INTO device_type( device, app_id ) VALUES('mobile',2);
INSERT INTO device_type( device, app_id ) VALUES('mobile',3);
INSERT INTO device_type( device, app_id ) VALUES('tablet',4);
INSERT INTO device_type( device, app_id ) VALUES('mobile',4);
INSERT INTO device_type( device, app_id ) VALUES('mobile',5);
INSERT INTO device_type( device, app_id ) VALUES('chromebook',6);
INSERT INTO device_type( device, app_id ) VALUES('mobile',6);
INSERT INTO device_type( device, app_id ) VALUES('tv',7);
INSERT INTO device_type( device, app_id ) VALUES('mobile',8);
INSERT INTO device_type( device, app_id ) VALUES('mobile',9);
INSERT INTO device_type( device, app_id ) VALUES('mobile',10);
INSERT INTO device_type( device, app_id ) VALUES('tablet',10);

-- Validation
ALTER TABLE device_type ADD CONSTRAINT device_type_check CHECK (device in ('mobile', 'tablet', 'chromebook', 'tv'));
ALTER TABLE category ADD CONSTRAINT audience_type_check CHECK (audience_type in ('child', 'teen', 'mature', 'all'));
ALTER TABLE feedback ADD CONSTRAINT rate_range_check CHECK (rate >= 0 and rate <= 5);
ALTER TABLE email_preferences ADD CONSTRAINT email_validation_check CHECK (email REGEXP "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$");
ALTER TABLE creater ADD CONSTRAINT email_validation_check_for_creater CHECK (email REGEXP "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$");


ALTER TABLE user RENAME COLUMN password TO password_hash;
alter table user modify password_hash char(60);
ALTER TABLE card RENAME COLUMN number TO number_hash;
ALTER TABLE card MODIFY COLUMN number_hash char(50);
INSERT INTO card(number_hash, bank_name, user_id ) VALUES('ga2dd8ff12348ce63b447c9e005b58fc953608d00','privat',8);
SELECT * FROM user;
SELECT * FROM card;
SELECT * FROM email_preferences;
SELECT * FROM app;
SELECT * FROM creater;
SELECT * FROM app_creating;
SELECT * FROM device_type;
SELECT * FROM app_category;
SELECT * FROM category;
SELECT * FROM download;
SELECT * FROM download_info;
SELECT * FROM feedback;

