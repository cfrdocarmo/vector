INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$PvcHE5ZWbd/QHikcvHEZz.JjKgDHLZuWP9Jdcl.SoK53qxAqTuctq');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderador', 'moderador@email.com', '$2a$10$PvcHE5ZWbd/QHikcvHEZz.JjKgDHLZuWP9Jdcl.SoK53qxAqTuctq');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO DOCUMENTO(codigo, resumo, solicitante) VALUES('001/2019', 'Processo fala do processo de vacinacao',  'Secretaria de Saúde');
INSERT INTO DOCUMENTO(codigo, resumo, solicitante) VALUES('001/2020', 'Processo fala do processo de vacinacao',  'Secretaria de Saúde');
INSERT INTO DOCUMENTO(codigo, resumo, solicitante) VALUES('001/2021', 'Processo fala do processo de vacinacao',  'Secretaria de Saúde');

