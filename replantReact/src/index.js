import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import { Home, Contact, Login, Plants, Library, Register } from "./pages";
import { Navbar } from "./components";
import reportWebVitals from "./reportWebVitals";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/contato",
    element: <Contact />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/cadastro",
    element: <Register />,
  },
  {
    path: "/plantas",
    element: <Plants />,
  },
  {
    path: "/biblioteca",
    element: <Library />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <ToastContainer />

    <Navbar />
    <RouterProvider router={router} />
  </React.StrictMode>
);

reportWebVitals();
