USE db_biblioteca;

CALL sp_inserir_clientes ("Noemy R. de Oliveira", "144.578.104-67", "07/09/2000", "San Gonçalo", 10, "17760558-3747");
CALL sp_deletar_clientes (101);
CALL sp_alugar_exemplares ("05/03/2018","12/03/2018", 100, 14, 210, 1);
CALL sp_deletar_emprestimos (1001);

SELECT * FROM tb_pessoas;
SELECT * FROM tb_exemplares;
SELECT * FROM tb_emprestimos;
SELECT * FROM tb_telefones_pessoas;
SELECT * FROM tb_clientes;