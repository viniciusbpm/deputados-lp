import axios from 'axios';
import { useEffect, useState } from 'react';
import './index.css';
import { useParams } from 'react-router-dom';

const Eventos = () => {
  const [eventos, setEventos] = useState();
  const { idDeputado } = useParams();

  useEffect(() => {
    const fetch = async () => {
      const items = await axios.get(
        `http://localhost:8080/deputados/${idDeputado}/eventos`
      );

      setEventos(items.data);
    };
    fetch();
  }, []);

  return (
    <div className="deputados-box">
      <h1>Eventos</h1>
      {eventos?.map((item) => (
        <div>
          <a href={`eventos/${item.id}`}>{item.descricaoTipo}</a>
        </div>
      ))}
    </div>
  );
};

export default Eventos;
