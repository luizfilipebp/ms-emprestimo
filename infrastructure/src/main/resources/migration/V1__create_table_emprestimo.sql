CREATE TABLE emprestimo
(
    emp_id              BIGSERIAL PRIMARY KEY,
    emp_livro_id        VARCHAR(255) NOT NULL,
    emp_usuario_id      VARCHAR(255) NOT NULL,
    emp_data_emprestimo DATE         NOT NULL,
    emp_data_devolucao  DATE         NOT NULL,
    emp_data_devolvido  DATE
);