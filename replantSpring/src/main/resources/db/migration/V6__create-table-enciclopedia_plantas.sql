CREATE TABLE public.enciclopedia_plantas (
	enciclopedia_id int NOT NULL,
	card_planta_id int NOT NULL,
	CONSTRAINT enciclopedia_plantas_pk PRIMARY KEY (enciclopedia_id,card_planta_id)
);