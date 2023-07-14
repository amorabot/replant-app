import * as React from "react";
import PropTypes from "prop-types";
import Backdrop from "@mui/material/Backdrop";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import api from "../../services/api";
import InputLabel from "@mui/material/InputLabel";
import { useSpring, animated } from "@react-spring/web";
import "./RegisterPlantModal.css";
import { MultiSelect } from "react-multi-select-component";
import { toast } from "react-toastify";

const Fade = React.forwardRef(function Fade(props, ref) {
  const {
    children,
    in: open,
    onClick,
    onEnter,
    onExited,
    ownerState,
    ...other
  } = props;
  const style = useSpring({
    from: { opacity: 0 },
    to: { opacity: open ? 1 : 0 },
    onStart: () => {
      if (open && onEnter) {
        onEnter(null, true);
      }
    },
    onRest: () => {
      if (!open && onExited) {
        onExited(null, true);
      }
    },
  });

  return (
    <animated.div ref={ref} style={style} {...other}>
      {React.cloneElement(children, { onClick })}
    </animated.div>
  );
});

Fade.propTypes = {
  children: PropTypes.element.isRequired,
  in: PropTypes.bool,
  onClick: PropTypes.any,
  onEnter: PropTypes.func,
  onExited: PropTypes.func,
  ownerState: PropTypes.any,
};

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "75%",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

const nutrient_options = [
  { label: "Nitrogênio", value: "nitrogenio" },
  { label: "Fósforo", value: "fosforo" },
  { label: "Potássio", value: "potassio" },
  { label: "Cálcio", value: "calcio" },
];

export default function RegisterPlantModal(props) {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const [plantDescription, setPlantDescription] = React.useState("");
  const [plantNativeRegion, setPlantNativeRegion] = React.useState("");
  const [plantTimeToWater, setPlantTimeToWater] = React.useState("");
  const [plantIdealUmidity, setPlantIdealUmidity] = React.useState("");
  const [plantScientificName, setPlantScientificName] = React.useState("");
  const [plantConventionalName, setPlantConventionalName] = React.useState("");
  const [plantNutrients, setPlantNutrients] = React.useState([]);

  const registerPlant = () => {
    const plant = {
      nome: plantConventionalName,
      nomeCientifico: plantScientificName,
      descricao: plantDescription,
      regiaoNativa: plantNativeRegion,
      tempoRega: plantTimeToWater,
      umidadeIdeal: plantIdealUmidity,
      nutrientesFavoritos: plantNutrients.map((nutrient) => {
        return {
          nutriente: nutrient.label,
        };
      }),
    };

    api.post("/cards", plant).then((response) => {
      toast.success("Card de planta criado com sucesso!", {
        position: "top-right",
        autoClose: 500,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });

      setTimeout(() => {
        window.location.reload();
      }, 1250);
    });
  };

  return (
    <div>
      <i className="fas fa-plus create-plant-icon" onClick={handleOpen}></i>
      <Modal
        aria-labelledby="spring-modal-title"
        aria-describedby="spring-modal-description"
        open={open}
        onClose={handleClose}
        closeAfterTransition
        slots={{ backdrop: Backdrop }}
        slotProps={{
          backdrop: {
            TransitionComponent: Fade,
          },
        }}
        id="registerPlantModal"
      >
        <Fade in={open}>
          <Box sx={style}>
            <h3 id="spring-modal-title" variant="h4" component="h2">
              Nova Planta
            </h3>
            <div className="flexer-container">
              <TextField
                id="conventional-name"
                label="Nome Convencional da Planta"
                variant="outlined"
                className="w-100 mt-3 "
                onChange={(e) => setPlantConventionalName(e.target.value)}
              />
              <TextField
                id="scientific-name"
                label="Nome Científico da Planta"
                variant="outlined"
                className="w-100 mt-3"
                onChange={(e) => setPlantScientificName(e.target.value)}
              />
            </div>
            <div className="flexer-container">
              <TextField
                id="native-region"
                label="Região Nativa"
                variant="outlined"
                className="w-100 mt-3"
                onChange={(e) => setPlantNativeRegion(e.target.value)}
              />
              <TextField
                id="time-to-water"
                label="Tempo para regar"
                variant="outlined"
                className="w-100 mt-3"
                type="number"
                onChange={(e) => setPlantTimeToWater(e.target.value)}
              />

              <TextField
                id="umidity"
                label="Umidade Ideal"
                variant="outlined"
                className="w-100 mt-3"
                type="number"
                onChange={(e) => setPlantIdealUmidity(e.target.value)}
              />
            </div>{" "}
            <TextField
              id="description"
              label="Descrição"
              variant="outlined"
              multiline
              rows={3}
              className="w-100 mt-3"
              onChange={(e) => setPlantDescription(e.target.value)}
            />
            <InputLabel className="mt-2" id="demo-simple-select-label">
              Nutrientes
            </InputLabel>
            <MultiSelect
              options={nutrient_options}
              value={plantNutrients}
              onChange={setPlantNutrients}
              labelledBy="Selecione os nutrientes"
              overrideStrings={{
                selectSomeItems: "Selecione os nutrientes",
                allItemsAreSelected: "Todos os nutrientes foram selecionados",
                selectAll: "Selecionar todos",
                search: "Pesquisar",
              }}
            />
            <Button
              variant="contained"
              className="mt-4 w-100 register-plant-button"
              onClick={registerPlant}
              size="large"
            >
              Registrar Planta
            </Button>
          </Box>
        </Fade>
      </Modal>
    </div>
  );
}
