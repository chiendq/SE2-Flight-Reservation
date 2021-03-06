
# Init flight_classes

INSERT INTO flight_classes (description, name) VALUES ('Bay tiết kiệm, đáp ứng mọi nhu cầu cơ bản', 'Economy Class');
INSERT INTO flight_classes (description, name) VALUES ('Chi phí hợp lý với bữa ăn ngon và chỗ để chân rộng rãi.', 'Special Economy Class');
INSERT INTO flight_classes (description, name) VALUES ('Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng.', 'Business Class');
INSERT INTO flight_classes (description, name) VALUES ('Bay vippro, mọi thứ thuộc về bạn.', 'First Class');

# Init airports
INSERT INTO airports (city, code, name) VALUES ('Hà Nội', 'HAN', 'Sân bay Nội Bài');
INSERT INTO airports (city, code, name) VALUES ('Hồ Chí Minh', 'SGN', 'Sân bay Tân Sơn Nhất');
INSERT INTO airports (city, code, name) VALUES ('Đà Nẵng', 'DAD', 'Sân bay Quốc Tế Đà Nẵng');
INSERT INTO airports (city, code, name) VALUES ('Nha Trang', 'CXR', 'Sân bay Cam Ranh');
INSERT INTO airports (city, code, name) VALUES ('Phú Quốc', 'PQC', 'Sân bay quốc tế Phú Quốc');
INSERT INTO airports (city, code, name) VALUES ('Huế', 'HUI', 'Sân bay Quốc tế Phú Bài');
INSERT INTO airports (city, code, name) VALUES ('Hải Phòng', 'HPH', 'Sân bay Quốc Tế Cát Bi');

# Init airplane
INSERT INTO airplanes (code) VALUES ('Airbus A320');
INSERT INTO airplanes (code) VALUES ('Airbus A321');
INSERT INTO airplanes (code) VALUES ('Airbus A350');
INSERT INTO airplanes (code) VALUES ('Boeing 787');
INSERT INTO airplanes (code) VALUES ('VN262');
INSERT INTO airplanes (code) VALUES ('VN260');
INSERT INTO airplanes (code) VALUES ('VN321');
INSERT INTO airplanes (code) VALUES ('QH280');

# Init airlines
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/Vietjet_Air_logo_transparent.png', 'Vietjet Air');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/VietnamAirlines_logo_transparent.png', 'Vietname Arilines');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/bamboo_airway.png', 'Bamboo Airway');
INSERT INTO airlines (imgapi, name) VALUES ('https://storage.googleapis.com/tripi-flights/agenticons/Pacific%20Airlines.png', 'Pacific Airlines');

# Init roles
INSERT INTO roles (description, name) VALUES ('user', 'ROLE_USER');
INSERT INTO roles (description, name) VALUES ('mod', 'ROLE_MODERATOR');
INSERT INTO roles (description, name) VALUES ('admin', 'ROLE_ADMIN');

#init users
INSERT INTO users (email, fullname, gender, password, phone, username) VALUES ('chieesnddafo@gmail.com', 'Dao Chien', 'male', '$2a$10$iCDLUsBEpOkLhq2iSrgdceAcNru1C/LMJ5eBVYEUATP.OAZTgucje', '123123123123', 'chieesnddafo');
INSERT INTO users (email, fullname, gender, password, phone, username) VALUES ('admin@gmail.com', 'Toi la admin', 'female', '$2a$10$l6ga5K/6xosf8hzZGTaz6envHXaONVLunSKKYAoHXK/Dwt1e9LG8K', '123456789', 'admin');
INSERT INTO users (email, fullname, gender, password, phone, username) VALUES ('user@gmail.com', 'Toi la user', 'female', '$2a$10$zfbSUb9VTkouQ4sPJnj6/Oof0TEFtKDgh7Az2ki.UVfrOR/7.4VrC', '123456789', 'user');

# Init user_roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2);


# Init tickets
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 100, '2022-04-29 16:00:00', 1, 'STATUS_AVAILABLE', 1, 1, 2, null, 1, 1);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 200, '2022-04-29 16:00:00', 2, 'STATUS_AVAILABLE', 1, 2, 2, null, 1, 2);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 300, '2022-04-29 16:00:00', 3, 'STATUS_AVAILABLE', 1, 3, 2, null, 1, 3);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 400, '2022-04-29 16:00:00', 4, 'STATUS_AVAILABLE', 1, 4, 2, null, 1, 4);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 200, '2022-04-29 16:00:00', 5, 'STATUS_AVAILABLE', 1, 5, 2, null, 1, 1);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 200, '2022-04-29 16:00:00', 6, 'STATUS_AVAILABLE', 1, 2, 2, null, 1, 1);
INSERT INTO tickets (arrival_time, cost, departure_time, seat, status, airline_id, airplane_id, arrival_airport_id, booking_id, departure_airport_id, flight_class_id) VALUES ('2022-04-29 18:00:00', 200, '2022-04-29 16:00:00', 7, 'STATUS_AVAILABLE', 1, 3, 2, null, 1, 1);
