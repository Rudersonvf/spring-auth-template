-- Insere os usuarios
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES ('4573767f-1af6-4181-bdc7-4baa07947b5e', 'Admin', 'User', 'admin@example.com', '$2a$12$hV8Mfim0cgVX08ACzUumsu28HFGgkTRcAH2PDOqDJZsoSa47drHQS');
INSERT INTO tb_user (id, first_name, last_name, email, password) VALUES ('4c8e6890-c35f-48ea-ac8a-987a9186d358', 'Normal', 'User', 'user@example.com', '$2a$12$hV8Mfim0cgVX08ACzUumsu28HFGgkTRcAH2PDOqDJZsoSa47drHQS');

-- Insere as roles
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');


-- Associa os usuarios as roles
INSERT INTO tb_user_role (user_id, role_id) VALUES ('4573767f-1af6-4181-bdc7-4baa07947b5e', 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES ('4573767f-1af6-4181-bdc7-4baa07947b5e', 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES ('4c8e6890-c35f-48ea-ac8a-987a9186d358', 2);