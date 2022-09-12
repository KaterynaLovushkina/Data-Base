

-- tables
-- Table: app
CREATE TABLE app (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(25) NOT NULL,
    description text NOT NULL,
    weight int NOT NULL,
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
    number int NOT NULL,
    bank_name varchar(25) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT card_pk PRIMARY KEY (number)
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
    CONSTRAINT device_type_pk PRIMARY KEY (device)
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
    receive_reply_notification  bool NOT NULL,
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
    password varchar(50) NOT NULL,
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

-- End of file.

