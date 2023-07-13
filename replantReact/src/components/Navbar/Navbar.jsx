import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import "./Navbar.css";

const AppNavbar = () => {
  const setActiveNav = (e) => {
    const navLinks = document.querySelectorAll(".nav-link");
    console.log(navLinks);
    navLinks.forEach((link) => {
      link.classList.remove("active");
      console.log(link);
    });
    e.target.classList.add("active");
  };

  return (
    <Navbar expand="lg" bg="light" variant="light" className="bootstrap-navbar">
      <div className="container d-flex justify-content-between">
        <Navbar.Brand href="/" className="ml-auto">
          RePlant
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarNav" />
        <Navbar.Collapse id="navbarNav">
          <Nav className="mr-auto">
            <Nav.Link
              href="/"
              onClick={setActiveNav}
              active={window.location.pathname === "/" ? true : false}
            >
              Início
            </Nav.Link>
            <Nav.Link
              href="plantas"
              onClick={setActiveNav}
              active={window.location.pathname === "/plantas" ? true : false}
            >
              Suas Plantas
            </Nav.Link>
            <Nav.Link
              href="biblioteca"
              onClick={setActiveNav}
              active={window.location.pathname === "/biblioteca" ? true : false}
            >
              Biblioteca
            </Nav.Link>
            <Nav.Link
              href="contato"
              onClick={setActiveNav}
              active={window.location.pathname === "/contato" ? true : false}
            >
              Contato
            </Nav.Link>
            <Nav.Link
              href="login"
              onClick={setActiveNav}
              active={window.location.pathname === "/login" ? true : false}
            >
              Login
            </Nav.Link>
            <Nav.Link
              href="cadastro"
              onClick={setActiveNav}
              active={window.location.pathname === "/cadastro" ? true : false}
            >
              Cadastre-se
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </div>
    </Navbar>
  );
};

export default AppNavbar;
