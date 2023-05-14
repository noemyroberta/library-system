-- DROP DATABASE db_biblioteca;
CREATE DATABASE db_biblioteca;
USE db_biblioteca;

CREATE TABLE tb_bairros (

	bai_codigo 				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    bai_bairro				VARCHAR(30)		NOT NULL
);

CREATE TABLE tb_pessoas (
	
    pes_codigo 				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    pes_nome   				VARCHAR(100) 	NOT NULL,
    pes_cpf    				VARCHAR(14)  	NOT NULL,
    pes_data_nascimento 	VARCHAR(10)	 	NOT NULL,
    pes_complemento			VARCHAR(45),
	pes_bai_codigo			INT,
    pes_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (pes_bai_codigo) 
    REFERENCES tb_bairros (bai_codigo)
);

CREATE TABLE tb_telefones_pessoas (

	tel_codigo				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    tel_pes_codigo			INT 			NOT NULL,
    tel_numero              VARCHAR(13)     NOT NULL,
    tel_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,

	FOREIGN KEY (tel_pes_codigo)
    REFERENCES tb_pessoas (pes_codigo)
    
);

CREATE TABLE tb_clientes (

	cli_pes_codigo 			INT PRIMARY KEY NOT NULL UNIQUE,
    cli_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (cli_pes_codigo)
    REFERENCES tb_pessoas (pes_codigo)
    
);

CREATE TABLE tb_funcionarios (

	fun_pes_codigo			INT PRIMARY KEY NOT NULL UNIQUE,
    fun_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (fun_pes_codigo)
    REFERENCES tb_pessoas (pes_codigo)

);

CREATE TABLE tb_generos (

	gen_codigo 				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    gen_genero				VARCHAR(45) 	NOT NULL

);

CREATE TABLE tb_livros (

	liv_codigo 				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    liv_titulo				VARCHAR(45)   	NOT NULL,
	liv_editora				VARCHAR(45)		NOT NULL,
    liv_data_lancamento		VARCHAR(10)		NOT NULL,
    liv_autor				VARCHAR(100)	NOT NULL,
    liv_sinopse				VARCHAR(120)	NOT NULL,
    liv_gen_codigo			INT,
    liv_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (liv_gen_codigo)
    REFERENCES tb_generos (gen_codigo)
	
);

CREATE TABLE tb_exemplares (

	exe_codigo				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    exe_quantidade			INT 			NOT NULL,
    exe_liv_codigo			INT,
    
    FOREIGN KEY (exe_liv_codigo)
    REFERENCES tb_livros (liv_codigo)

);

CREATE TABLE tb_emprestimos (

	emp_codigo				INT PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    emp_data_devolucao		VARCHAR(10)		NOT NULL,
    emp_data_saida			VARCHAR(10)		NOT NULL,
    emp_cli_pes_codigo		INT,
    emp_fun_pes_codigo		INT,
    emp_exe_codigo			INT,
    emp_deletado			BOOLEAN 		NOT NULL DEFAULT FALSE,
    
    FOREIGN KEY (emp_cli_pes_codigo)
    REFERENCES tb_clientes (cli_pes_codigo),
    
    FOREIGN KEY (emp_fun_pes_codigo)
    REFERENCES tb_funcionarios (fun_pes_codigo),
    
    FOREIGN KEY (emp_exe_codigo)
    REFERENCES tb_exemplares (exe_codigo)

);


