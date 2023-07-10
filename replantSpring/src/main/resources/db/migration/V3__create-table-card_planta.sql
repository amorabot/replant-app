CREATE TABLE public.card_planta (
	id int4 NOT NULL,
	descricao text NOT NULL,
	regiao_nativa text NULL,
	tempo_rega int4 NOT NULL,
	umidade_ideal varchar NOT NULL,
	nome_cientifico text NOT NULL,
	nome_convencional text NOT NULL,
	CONSTRAINT card_planta_pk PRIMARY KEY (id)
);