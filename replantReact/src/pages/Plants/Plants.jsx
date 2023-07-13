import React, { useEffect, useState } from "react";
import { PlantCard, RegisterPlantModal } from "../../components";
import "./Plants.css";
import { Carousel } from "@trendyol-js/react-carousel";
import api from "../../services/api";

const Plants = () => {
  const [plants, setPlants] = useState(null);
  //   {
  //     "id": 3,
  //     "nome": "Sample common name 2",
  //     "nomeCientifico": "Sample scientific name 2",
  //     "descricao": "Sample description 2",
  //     "regiaoNativa": "Sample native region 2",
  //     "tempoRega": 3,
  //     "umidadeIdeal": 123,
  //     "nutrientesFavoritos": [],
  //     "enciclopediaEntries": []
  // }
  const getPlantCards = async () => {
    try {
      const response = await api.get("cards");
      const api_plants = response.data.map((plant) => {
        return {
          plant_name: plant.nome,
          conventional_name: plant.nomeCientifico,
          scientific_name: plant.nomeCientifico,
          native_region: plant.regiaoNativa,
          description: plant.descricao,
          plant_image: require("../../assets/smilling_plant.png"), // não tem o campo imagem na API
          ...plant,
        };
      });
      setPlants([]);
      setPlants(api_plants);
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    getPlantCards();
  }, []);
  return (
    <main className="plants-main-container">
      <div className="container">
        <h1 className="page-title mb-5">Seu Jardim</h1>
        <RegisterPlantModal getPlantCards={getPlantCards} />
        <div className="carousel-container">
          {plants && (
            <Carousel
              slide={2}
              show={3}
              transition={0.4}
              rightArrow={
                <div className="icon-container">
                  <i className="fas fa-chevron-right carousel-arrow"></i>
                </div>
              }
              leftArrow={
                <div className="icon-container">
                  <i className="fas fa-chevron-left carousel-arrow"></i>
                </div>
              }
              className="carousel-container"
            >
              {plants.map((plant) => {
                return (
                  <PlantCard
                    plant_name={plant.plant_name}
                    conventional_name={plant.conventional_name}
                    scientific_name={plant.scientific_name}
                    native_region={plant.native_region}
                    description={plant.description}
                    plant_image={plant.plant_image}
                    key={plant.id}
                  />
                );
              })}
            </Carousel>
          )}
        </div>
        {/* </div> */}
      </div>
    </main>
  );
};

export default Plants;
