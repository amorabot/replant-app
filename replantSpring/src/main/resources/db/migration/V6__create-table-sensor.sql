CREATE TABLE public.sensor (
	serial_id varchar(255) NOT NULL,
	ativo bool NOT NULL,
	umidade int4 NULL,
	usuario_id varchar(255) NOT NULL,
	CONSTRAINT sensor_pkey PRIMARY KEY (serial_id, usuario_id),
	CONSTRAINT fkjc5xh03nai3r0tbg30urwnkml FOREIGN KEY (usuario_id) REFERENCES public.usuario(uuid)
);