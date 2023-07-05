import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import "./Navbar.css";

const AppNavbar = () => {
  return (
    <Navbar expand="lg" bg="light" variant="light" className="bootstrap-navbar">
      <div className="container d-flex justify-content-between">
        <Navbar.Brand href="/" className="ml-auto">
          RePlant
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarNav" />
        <Navbar.Collapse id="navbarNav">
          <Nav className="mr-auto">
            <Nav.Link href="/" active>
              Início
            </Nav.Link>
            <Nav.Link href="plantas">Suas Plantas</Nav.Link>
            <Nav.Link href="biblioteca">Biblioteca</Nav.Link>
            <Nav.Link href="contato">Contato</Nav.Link>
            <Nav.Link href="login">Login</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </div>
    </Navbar>
  );
};

export default AppNavbar;
