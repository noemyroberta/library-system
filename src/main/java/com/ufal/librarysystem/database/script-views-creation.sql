USE db_biblioteca;

CREATE VIEW `v_dados_clientes` 	 AS
	SELECT P.pes_nome 		   	 AS nome_cliente, 
		   P.pes_data_nascimento AS data_nascimento,
		   P.pes_cpf 			 AS cpf_cliente,
           B.bai_bairro 		 AS bairro_cliente, 
           TP.tel_numero 		 AS telefone_cliente,
           C.cli_pes_codigo 	 AS codigo_cliente
	FROM tb_pessoas P
		INNER JOIN tb_clientes 			C  ON (C.cli_pes_codigo = P.pes_codigo)
        INNER JOIN tb_telefones_pessoas TP ON (TP.tel_codigo = C.cli_pes_codigo)
        INNER JOIN tb_bairros 			B  ON (B.bai_codigo = P.pes_bai_codigo);


CREATE VIEW `v_dados_funcionarios` AS
	SELECT P.pes_nome			   AS nome_funcionario,
		   P.pes_data_nascimento   AS data_nascimento,
           P.pes_cpf 			   AS cpf_funcionario,
           B.bai_bairro 		   AS bairro_funcionario,
           TP.tel_numero 		   AS telefone_funcionario,
           F.fun_pes_codigo 	   AS codigo_funcionario
	FROM tb_pessoas P
		INNER JOIN tb_funcionarios 		F  ON (F.fun_pes_codigo = P.pes_codigo)
        INNER JOIN tb_telefones_pessoas TP ON (TP.tel_codigo = F.fun_pes_codigo)
        INNER JOIN tb_bairros 			B  ON (B.bai_codigo = P.pes_bai_codigo);


CREATE VIEW `v_dados_exemplares` AS
	SELECT L.liv_titulo 		 AS titulo, 
		   L.liv_sinopse 	     AS sinopse,
		   L.liv_autor 			 AS autor, 
           G.gen_genero 		 AS genero,
		   EXE.exe_quantidade 	 AS quantidade, 
           EXE.exe_codigo 		 AS exemplar_codigo
    FROM tb_livros L
		INNER JOIN tb_exemplares EXE ON (EXE.exe_codigo = L.liv_codigo)
		INNER JOIN tb_generos G 	 ON (G.gen_codigo = L.liv_gen_codigo);
        
        
CREATE VIEW `v_dados_emprestimos` AS
	SELECT VDF.nome_funcionario, 
		   VDF.codigo_funcionario,
		   VDC.nome_cliente,
           VDC.codigo_cliente,
		   VDE.titulo, 
           VDE.autor,
		   EMP.emp_data_saida 	  AS data_saida, 
           EMP.emp_data_devolucao AS data_devolucao,
           EMP.emp_codigo 		  AS codigo_emprestimo
    FROM v_dados_exemplares VDE
		INNER JOIN tb_emprestimos EMP ON (EMP.emp_codigo = VDE.exemplar_codigo)
        INNER JOIN v_dados_funcionarios VDF ON (VDF.codigo_funcionario = EMP.emp_fun_pes_codigo)
        INNER JOIN v_dados_clientes VDC ON (VDC.codigo_cliente = EMP.emp_cli_pes_codigo)
	ORDER BY codigo_emprestimo;
    