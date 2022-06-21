INSERT INTO roles (id, roles)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, roles)
VALUES (2, 'USER');

INSERT INTO users(id, email, first_name, last_name, password, image_url, is_active)
VALUES (1, 'testmail@mail.bg', 'Drago', 'Stoqnov', '7fcb1cd7c2ebd11c601fcdf666cb8967287ca91474a5147e5e9aa29e425b19add137d239934a14e4', null, 1);

INSERT INTO brands(id, name)
VALUES (1, 'Volkswagen'),(2, 'Ford');

INSERT INTO models(id, name, categories, start_year, end_year, brand_id, image_url )
VALUES (1, 'Golf MK2', 'CAR', 1980, 2000, 1, 'https://otde-lmoderen.news/pictures/3_%D0%9A%D0%BB%D0%B0%D1%81%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8-golf-mk2-%D0%BE%D0%B1%D0%B8%D1%87%D0%B0%D0%B9-%D1%81%D0%BF%D0%BE%D1%80%D1%82%D0%B5%D0%BD-38696/content.jpg'),
(2, 'Polo MK3', 'CAR', 1992, 2005, 1, 'https://upload.wikimedia.org/wikipedia/commons/6/67/VW_Polo_front_20090329.jpg'),
(3, 'Focus', 'CAR', 1999, null, 2, 'https://dizzyriders.bg/uploads/avtomobili/2021_10/ford-focus-st-7.jpg'),
(4, 'Mustang', 'CAR', 1965, null, 2, 'https://media.ed.edmunds-media.com/ford/mustang/2022/oem/2022_ford_mustang_coupe_ecoboost-premium_fq_oem_1_1280.jpg');

