

/* Criado COTA 21/05/2020 */
create table tb_cota(
	id_cota int(6) PRIMARY KEY not null auto_increment,
	data DATE Null unique,
	barril float(10,2),
	dolar float(10,4)
	);
	
	 // NA ABA COTAR - INSERIR DATA ATUAL
        txtDataCota.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        

-- inserrir dados

insert into tb_cota Value(null,"2020/02/17",57.27,4.2977);


insert into tb_cota Value(null,"2020/02/19",59.31,4.3656);
insert into tb_cota Value(null,"2020/02/26",52.84,4.4505);
insert into tb_cota Value(null,"2020/02/27",51.02,4.4864);
insert into tb_cota Value(null,"2020/03/03",51.78,4.5148);
insert into tb_cota Value(null,"2020/03/04",51.45,4.5792);
insert into tb_cota Value(null,"2020/03/05",50.09,4.6076);
insert into tb_cota Value(null,"2020/03/09",33.32,4.7246);
insert into tb_cota Value(null,"2020/03/10",37.83,4.6439);
insert into tb_cota Value(null,"2020/03/11",35.71,4.8152);
insert into tb_cota Value(null,"2020/03/16",30.85,4.8596);
insert into tb_cota Value(null,"2020/03/18",26.46,5.1075);
insert into tb_cota Value(null,"2020/03/20",28.41,5.0222);
insert into tb_cota Value(null,"2020/03/24",27.66,5.0995);
insert into tb_cota Value(null,"2020/03/25",27.51,5.0350);
insert into tb_cota Value(null,"2020/03/26",26.95,5.0235);
insert into tb_cota Value(null,"2020/03/30",26.45,5.1943);
insert into tb_cota Value(null,"2020/04/07",32.41,5.2230);
insert into tb_cota Value(null,"2020/04/13",31.85,5.2007);
insert into tb_cota Value(null,"2020/04/14",30.03,5.1636);
insert into tb_cota Value(null,"2020/04/15",27.95,5.2385);
insert into tb_cota Value(null,"2020/04/16",28.50,5.2341);
insert into tb_cota Value(null,"2020/04/22",20.75,5.4583);
insert into tb_cota Value(null,"2020/05/06",29.84,5.7158);
insert into tb_cota Value(null,"2020/05/11",30.15,5.8190);
insert into tb_cota Value(null,"2020/05/12",29.45,5.8863);
insert into tb_cota Value(null,"2020/05/13",29.49,5.8870);
insert into tb_cota Value(null,"2020/05/20",35.81,5.6934);