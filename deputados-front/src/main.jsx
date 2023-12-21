import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Deputados from './Deputados';
import Deputado from './Deputado';
import Eventos from './Eventos';
import Evento from './Evento';
import InscreverDeputado from './InscreverDeputado';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Deputados />,
  },
  {
    path: '/deputados/:idDeputado',
    element: <Deputado />,
  },
  {
    path: '/deputados/:idDeputado/eventos',
    element: <Eventos />,
  },
  {
    path: '/deputados/:idDeputado/eventos/:idEvento',
    element: <Evento />,
  },
  {
    path: '/deputados/:idDeputado/inscrever',
    element: <InscreverDeputado />,
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
