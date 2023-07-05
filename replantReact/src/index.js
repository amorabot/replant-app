import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import { Home, Contact, Login, Plants, Library } from "./pages";
import { Navbar } from "./components";
import reportWebVitals from "./reportWebVitals";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

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
    <Navbar />
    <RouterProvider router={router} />
  </React.StrictMode>
);

reportWebVitals();
