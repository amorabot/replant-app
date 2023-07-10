CREATE TABLE public.nutrientes_favoritos (
	nutriente text NOT NULL,
	card_planta_id int4 NOT NULL,
	CONSTRAINT nutrientes_favoritos_pk PRIMARY KEY (nutriente, card_planta_id),
	CONSTRAINT nutrientes_favoritos_fk FOREIGN KEY (card_planta_id) REFERENCES public.card_planta(id) ON DELETE CASCADE ON UPDATE CASCADE
);