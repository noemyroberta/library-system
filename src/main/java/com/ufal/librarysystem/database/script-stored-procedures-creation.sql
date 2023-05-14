USE db_biblioteca;

DELIMITER &&
START TRANSACTION;

	CREATE PROCEDURE `sp_inserir_clientes`(
		IN var_nome 		   VARCHAR(100), 
		   var_cpf 			   VARCHAR(14),
		   var_data_nascimento VARCHAR(10),
		   var_complemento 	   VARCHAR(45),
		   var_bai_codigo 	   INT,
           var_numero 		   VARCHAR(13))
		
	BEGIN
		
        INSERT INTO tb_pessoas (
            pes_nome,
            pes_cpf,
            pes_data_nascimento,
            pes_complemento,
            pes_bai_codigo)
		VALUES (var_nome, var_cpf, var_data_nascimento, var_complemento, var_bai_codigo);
		
        SET @var_codigo = 0;
        SELECT MAX(pes_codigo) FROM tb_pessoas INTO @var_codigo;
        
        INSERT INTO tb_telefones_pessoas (
			tel_pes_codigo,
			tel_numero)
		VALUES (@var_codigo, var_numero);
        
		INSERT INTO tb_clientes (cli_pes_codigo) VALUES (@var_codigo);
         
	END

&&

DELIMITER $$
START TRANSACTION;

		CREATE PROCEDURE `sp_deletar_clientes`(IN var_codigo INT)
		
		BEGIN
			
			UPDATE tb_pessoas
			SET pes_deletado = TRUE
			WHERE pes_codigo = @var_codigo;
			
			UPDATE tb_clientes
			SET cli_deletado = TRUE
			WHERE cli_pes_codigo = @var_codigo;
			
			UPDATE tb_telefones_pessoas
			SET tel_deletado = TRUE
			WHERE tel_pes_codigo = @var_codigo;
			
			UPDATE tb_emprestimos
			SET emp_deletado = TRUE
			WHERE emp_cli_pes_codigo = @var_codigo;
			
		END

$$


DELIMITER && 
START TRANSACTION;

		CREATE PROCEDURE `sp_inserir_funcionarios`(
				IN var_nome 		   VARCHAR(100), 
				   var_cpf 			   VARCHAR(14),
				   var_data_nascimento VARCHAR(10),
				   var_complemento 	   VARCHAR(45),
				   var_bai_codigo 	   INT,
				   var_numero 		   VARCHAR(13))
			
		BEGIN
			
			INSERT INTO tb_pessoas (
			       pes_nome,
				   pes_cpf,
				   pes_data_nascimento,
				   pes_complemento,
				   pes_bai_codigo)
			VALUES (var_nome, var_cpf, var_data_nascimento, var_complemento, var_bai_codigo);
				
			SET @var_codigo = 0;
			SELECT MAX(pes_codigo) FROM tb_pessoas INTO @var_codigo;
				
			INSERT INTO tb_telefones_pessoas (
				   tel_pes_codigo,
				   tel_numero)
			VALUES (@var_codigo, var_numero);
				
			INSERT INTO tb_funcionarios (fun_pes_codigo) VALUES (@var_codigo);

		END

&&

DELIMITER $$
START TRANSACTION;

		CREATE PROCEDURE `sp_deletar_funcionarios`(IN var_codigo INT)
		
		BEGIN
			
			UPDATE tb_pessoas
			SET pes_deletado = TRUE
			WHERE pes_codigo = @var_codigo;
			
			UPDATE tb_funcionarios
			SET fun_deletado = TRUE
			WHERE fun_pes_codigo = @var_codigo;
			
			UPDATE tb_telefones_pessoas
			SET tel_deletado = TRUE
			WHERE tel_pes_codigo = @var_codigo;
			
			UPDATE tb_emprestimos
			SET emp_deletado = TRUE
			WHERE emp_fun_pes_codigo = @var_codigo;
			
		END

$$

DELIMITER &&
START TRANSACTION;

    CREATE PROCEDURE `sp_alugar_exemplares` (
		IN var_data_saida 	  VARCHAR(10),
           var_data_devolucao VARCHAR(10),
           var_cli_codigo	  INT,
           var_fun_codigo	  INT,
           var_exe_codigo	  INT,
           var_quantidade	  INT)
	BEGIN
    
		INSERT INTO tb_emprestimos (
		   emp_data_devolucao,
           emp_data_saida,
           emp_cli_pes_codigo,
           emp_fun_pes_codigo,
           emp_exe_codigo)
		VALUES (var_data_devolucao, var_data_saida, var_cli_codigo, var_fun_codigo, var_exe_codigo);
		
        SET @var_exe_codigo = 0;
        SELECT MAX(emp_exe_codigo) INTO @var_exe_codigo FROM tb_emprestimos;
        
		UPDATE tb_exemplares 
        SET exe_quantidade = exe_quantidade - var_quantidade
        WHERE exe_codigo = var_exe_codigo;
        
    END
&&

DELIMITER $$
START TRANSACTION;
		/* Deletar empréstimo */
		CREATE PROCEDURE `sp_devolver_exemplares`(IN var_codigo INT)
			
		BEGIN 
        
			UPDATE tb_emprestimos
			SET emp_deletado = TRUE
			WHERE emp_codigo = var_codigo;
			
		END
$$
