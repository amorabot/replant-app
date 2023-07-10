CREATE TABLE public.planta_virtual (
	id int4 NOT NULL,
	descricao varchar(255) NULL,
	nome varchar(255) NULL,
	ultima_rega timestamp(6) NULL,
	umidade_estimada int4 NULL,
	foto varchar(255) NULL,
	usuario_id varchar(255) NOT NULL,
	card_id int4 NOT NULL,
	sensor_serial_id varchar(255) NULL,
	usuario_id_sensor varchar(255) NULL,
	CONSTRAINT planta_virtual_pkey PRIMARY KEY (id, usuario_id),
	CONSTRAINT fkdx96pg53qs01gsfpkcy41h9e FOREIGN KEY (card_id) REFERENCES public.card_planta(id),
	CONSTRAINT fkfh1kqg61pmj5fydwfph7e0hak FOREIGN KEY (sensor_serial_id,usuario_id_sensor) REFERENCES public.sensor(serial_id,usuario_id),
	CONSTRAINT fks5ubaopnbkov6we2uttmbjqam FOREIGN KEY (usuario_id) REFERENCES public.usuario(uuid)
);