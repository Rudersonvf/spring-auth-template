-- Insere os usuarios
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES ('4573767f-1af6-4181-bdc7-4baa07947b5e', 'Admin', 'User', 'admin@example.com', '$2a$12$hV8Mfim0cgVX08ACzUumsu28HFGgkTRcAH2PDOqDJZsoSa47drHQS', 1);
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES ('4c8e6890-c35f-48ea-ac8a-987a9186d358', 'Normal', 'User', 'user@example.com', '$2a$12$hV8Mfim0cgVX08ACzUumsu28HFGgkTRcAH2PDOqDJZsoSa47drHQS');

-- Insere as roles
INSERT INTO tb_role (authority) VALUES ('ADMIN');
INSERT INTO tb_role (authority) VALUES ('USER');


-- Associa os usuarios as roles
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);