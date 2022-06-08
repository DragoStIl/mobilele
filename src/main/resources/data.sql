INSERT INTO roles (id, roles)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, roles)
VALUES (2, 'USER');

INSERT INTO users (id, email, first_name, image_url, is_active, last_name, `password`)
VALUES (1, 'dragostoqnov@mail.bg', 'Drago', null, 1, 'Stoqnov', 'password');

INSERT INTO users (id, email, first_name, image_url, is_active, last_name, `password`)
VALUES (2, 'random.email@abv.bg', 'Ivan', null, 1, 'Ivanov', 'password');

INSERT INTO users (id, email, first_name, last_name, password, is_active, image_url)
VALUE (3, 'somemail@abv.bg', 'user', 'userov', 'password', 1, null)


