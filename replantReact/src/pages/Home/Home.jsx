import React from "react";
import "./Home.css";

const Home = () => {
  return (
    <main className="home-container">
      <section name="WelcomeSection" id="WelcomeSection">
        <div className="container" style={{ marginTop: 64 }}>
          <div className="row">
            <div className="col-12 col-md-6">
              <img
                src={require("../../assets/smilling_plant.png")}
                alt="Smilling Plant"
                className="img-fluid"
              />
            </div>
            <div className="col-12 col-md-6 d-flex flex-column justify-content-center ">
              <h1 className="welcome-title">
                Bem-vindo ao <br />{" "}
                <strong className="bold-main-name">RePlant</strong>
              </h1>
              <p className="welcome-paragraph">
                Um espaço dedicado à jardinagem sustentável e ao cultivo
                consciente de plantas. Aqui, estamos comprometidos em fornecer
                as melhores soluções para aqueles que desejam criar um jardim
                exuberante e saudável, enquanto cuidam do nosso planeta.
              </p>
              <button type="button" class="btn btn-light btn-register">
                Cadastre-se
              </button>
            </div>
          </div>
        </div>
      </section>
      <section name="KnowTheProject" id="KnowTheProject">
        <div className="container">
          <h2 className="text-center title">Conheça nosso projeto</h2>
          <div className="row mt-5">
            <div className="col-12 col-md-4 card-container d-flex flex-column justify-content-center">
              <img
                src={require("../../assets/user_heart_icon.png")}
                alt="User Heart Icon"
                className="img-fluid m-auto mb-4"
              />
              <div className="card p-3">
                <p>
                  Estamos comprometidos em fornecer as melhores soluções para
                  ajudar você a cuidar das suas plantas de maneira eficiente e
                  bem-sucedida.
                </p>
              </div>
            </div>
            <div className="col-12 col-md-4 card-container d-flex flex-column justify-content-center">
              <img
                src={require("../../assets/cactus_icon.png")}
                alt="Cactus Icon"
                className="img-fluid m-auto mb-4"
              />
              <div className="card p-3">
                <p>
                  Somos uma equipe apaixonada por jardinagem e botânica, e
                  acreditamos no poder das plantas para melhorar nossas vidas e
                  o meio ambiente.
                </p>
              </div>
            </div>
            <div className="col-12 col-md-4 card-container d-flex flex-column justify-content-center">
              <img
                src={require("../../assets/users_icon.png")}
                alt="Users Icon"
                className="img-fluid m-auto mb-4"
              />
              <div className="card p-3">
                <p>
                  Nossa missão é capacitar os entusiastas de plantas, sejam
                  jardineiros novatos ou especialistas, a cultivarem e cuidarem
                  de suas plantas com confiança.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section name="OurFunctionalities" id="OurFunctionalities">
        <div className="container">
          <h2 className="text-center title">
            <span className="small-text">Nossas</span>
            <br /> Funcionalidades
          </h2>
          <div className="row mt-5 functionality-container">
            <div className="col-12 col-md-6 d-flex flex-column justify-content-evenly">
              <h3 className="subtitle">Conheça os Plants</h3>
              <p className="sub-text">
                Bem-vindo ao universo encantador dos Plants! Aqui, convidamos
                você a se aventurar em um mundo onde o conhecimento sobre
                plantas floresce e prospera. Prepare-se para explorar o
                fascinante reino vegetal e mergulhar em uma jornada de
                descobertas botânicas. Os Plants são seus companheiros virtuais
                para a busca do conhecimento sobre plantas.
              </p>
            </div>
            <div className="col-12 col-md-6">
              <img
                src={require("../../assets/rectangle.png")}
                alt="Rectangle"
                className="img-fluid"
              />
            </div>
          </div>
          <div className="row mt-5 functionality-container-reversed">
            <div className="col-12 col-md-6">
              <img
                src={require("../../assets/rectangle.png")}
                alt="Rectangle"
                className="img-fluid"
              />
            </div>
            <div className="col-12 col-md-6 d-flex flex-column justify-content-evenly">
              <h3 className="subtitle">Aprenda na biblioteca</h3>
              <p className="sub-text">
                Bem-vindo ao universo encantador dos Plants! Aqui, convidamos
                você a se aventurar em um mundo onde o conhecimento sobre
                plantas floresce e prospera. Prepare-se para explorar o
                fascinante reino vegetal e mergulhar em uma jornada de
                descobertas botânicas. Os Plants são seus companheiros virtuais
                para a busca do conhecimento sobre plantas.
              </p>
            </div>
          </div>
          <div className="row mt-5 functionality-container">
            <div className="col-12 col-md-6 d-flex flex-column justify-content-evenly">
              <h3 className="subtitle">Sincronize com sensores!</h3>
              <p className="sub-text">
                Bem-vindo ao universo encantador dos Plants! Aqui, convidamos
                você a se aventurar em um mundo onde o conhecimento sobre
                plantas floresce e prospera. Prepare-se para explorar o
                fascinante reino vegetal e mergulhar em uma jornada de
                descobertas botânicas. Os Plants são seus companheiros virtuais
                para a busca do conhecimento sobre plantas.
              </p>
            </div>
            <div className="col-12 col-md-6">
              <img
                src={require("../../assets/rectangle.png")}
                alt="Rectangle"
                className="img-fluid"
              />
            </div>
          </div>
        </div>
      </section>
      <section name="Feedbacks" id="Feedbacks">
        <div className="container mb-5 mt-3">
          <h2 className="text-center title mb-5">Jardineiros Satisfeitos</h2>

          <div className="row text-center d-flex align-items-stretch">
            <div className="col-md-4 mb-5 mb-md-0 d-flex align-items-stretch">
              <div className="card testimonial-card">
                <div
                  className="card-up"
                  style={{ backgroundColor: "#9d789b" }}
                ></div>
                <div className="avatar mx-auto bg-white">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(1).webp"
                    className="rounded-circle img-fluid"
                    alt="User Profile Avatar"
                  />
                </div>
                <div className="card-body">
                  <h4 className="mb-4">Jardineiro 1</h4>
                  <hr />
                  <p className="dark-grey-text mt-4">
                    <i className="fas fa-quote-left pe-2"></i>O Replant foi uma
                    descoberta maravilhosa para mim! Como moradora de um
                    apartamento pequeno, sempre desejei ter um jardim, mas não
                    sabia por onde começar. O Replant me guiou passo a passo,
                    desde a seleção das plantas adequadas até as dicas para
                    aproveitar espaços limitados. Agora tenho um belo jardim de
                    ervas aromáticas na minha varanda, onde posso colher
                    ingredientes frescos para as minhas receitas.
                  </p>
                </div>
              </div>
            </div>
            <div className="col-md-4 mb-5 mb-md-0 d-flex align-items-stretch">
              <div className="card testimonial-card">
                <div
                  className="card-up"
                  style={{ backgroundColor: "#7a81a8" }}
                ></div>
                <div className="avatar mx-auto bg-white">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(2).webp"
                    className="rounded-circle img-fluid"
                    alt="User Profile Avatar"
                  />
                </div>
                <div className="card-body">
                  <h4 className="mb-4">Jardineiro 2</h4>
                  <hr />
                  <p className="dark-grey-text mt-4">
                    <i className="fas fa-quote-left pe-2"></i>Como um jardineiro
                    novato, o Replant foi um verdadeiro salvador para mim. Eu
                    sempre tive o desejo de cultivar meu próprio jardim, mas não
                    sabia por onde começar. O Replant ofereceu recursos fáceis
                    de entender e guias passo a passo que me ajudaram a criar um
                    jardim colorido e vibrante no meu quintal.
                  </p>
                </div>
              </div>
            </div>
            <div className="col-md-4 mb-0 d-flex align-items-stretch">
              <div className="card testimonial-card">
                <div
                  className="card-up"
                  style={{ backgroundColor: "#6d5b98" }}
                ></div>
                <div className="avatar mx-auto bg-white">
                  <img
                    src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(9).webp"
                    className="rounded-circle img-fluid"
                    alt="User Profile Avatar"
                  />
                </div>
                <div className="card-body">
                  <h4 className="mb-4">Jardineiro 3</h4>
                  <hr />
                  <p className="dark-grey-text mt-4">
                    <i className="fas fa-quote-left pe-2"></i>Como amante da
                    natureza, o Replant se tornou meu refúgio online favorito. A
                    plataforma oferece uma riqueza de informações sobre plantas,
                    dicas de jardinagem e práticas sustentáveis. Eu amo como
                    posso explorar o banco de dados de plantas e descobrir novas
                    espécies interessantes para adicionar ao meu jardim.
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <footer className="text-center text-lg-start bg-light text-muted">
        <section className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
          <div className="me-5 d-none d-lg-block">
            <span>Conecte-se com as nossas redes sociais:</span>
          </div>

          <div>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-facebook-f"></i>
            </a>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-twitter"></i>
            </a>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-google"></i>
            </a>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-instagram"></i>
            </a>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-linkedin"></i>
            </a>
            <a href="/" className="me-4 text-reset">
              <i className="fab fa-github"></i>
            </a>
          </div>
        </section>
        <div className="text-center p-4">© 2023 Copyright: RePlant</div>
      </footer>
    </main>
  );
};

export default Home;
