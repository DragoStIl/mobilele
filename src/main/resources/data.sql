INSERT INTO roles (id, roles)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, roles)
VALUES (2, 'USER');

--INSERT INTO users (id, email, first_name, image_url, is_active, last_name, `password`)
--VALUES (1, 'testmail@abv.bg', 'Drago', null, 1, 'Stoqnov', '7fcb1cd7c2ebd11c601fcdf666cb8967287ca91474a5147e5e9aa29e425b19add137d239934a14e4');
INSERT INTO users(id, email, first_name, last_name, password, image_url, is_active)
VALUES (1, 'testmail@mail.bg', 'Drago', 'Stoqnov', '7fcb1cd7c2ebd11c601fcdf666cb8967287ca91474a5147e5e9aa29e425b19add137d239934a14e4', null, 1)