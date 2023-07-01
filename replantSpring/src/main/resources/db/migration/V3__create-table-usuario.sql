CREATE TABLE usuario (
	uuid text NOT NULL,
	email text NOT NULL,
	nome_completo varchar NOT NULL,
	regiao text NOT NULL,
	tema text NOT NULL,
	refresh_timer int4 NOT NULL DEFAULT 6,
	enciclopedia_id int4 NOT NULL,
	CONSTRAINT usuario_email_uk UNIQUE (email),
	CONSTRAINT usuario_pk PRIMARY KEY (uuid),
	CONSTRAINT usuario_fk FOREIGN KEY (enciclopedia_id) REFERENCES public.enciclopedia(id) ON DELETE SET DEFAULT ON UPDATE CASCADE
);