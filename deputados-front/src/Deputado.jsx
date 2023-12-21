import axios from 'axios';
import { useEffect, useState } from 'react';
import './index.css';
import { useNavigate, useParams } from 'react-router-dom';

const Deputado = () => {
  const [deputado, setDeputado] = useState();
  const { idDeputado } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const fetch = async () => {
      const items = await axios.get(
        `http://localhost:8080/deputados/${idDeputado}`
      );

      setDeputado(items.data);
    };
    fetch();
  }, []);

  const handleClickEvents = () => {
    navigate(`eventos`);
  };

  const handleClickSubscribe = () => {
    navigate(`inscrever`);
  };

  return (
    <div className="deputados-box">
      <h1>{deputado?.nome}</h1>
      <button onClick={handleClickEvents}>Ver eventos</button>
      <button onClick={handleClickSubscribe}>Inscrever</button>
    </div>
  );
};

export default Deputado;
