import React from "react";
import "./PlantCard.css";
const PlantCard = (_) => {
  return (
    <div className="plant-card-container">
      <h2 className="plant-name-title">{_.plant_name}</h2>

      <div className="plant-img-container mt-4 mb-4">
        <img src={_.plant_image} alt="Plant Pic" className="plant-img" />
      </div>
      <div className="plant-attributes-container">
        <div className="card-title-text-container">
          <h4 className="card-title">{_.conventional_name}</h4>
          <p className="card-text scientific">{_.scientific_name}</p>
        </div>
        <div className="card-title-text-container">
          <h5 className="card-title">Região Nativa</h5>
          <p className="card-text">{_.native_region}</p>
        </div>
        <div className="card-title-text-container">
          <h5 className="card-title">Descrição</h5>
          <p className="card-text">{_.description}</p>
        </div>
      </div>
    </div>
  );
};

export default PlantCard;
