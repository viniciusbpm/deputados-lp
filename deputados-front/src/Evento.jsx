import axios from 'axios';
import { useEffect, useState } from 'react';
import './index.css';
import { useNavigate, useParams } from 'react-router-dom';

const Evento = () => {
  const [eventos, setEventos] = useState();
  const { idEvento, idDeputado } = useParams();
  const navigate = useNavigate();
  const [nomeEvento, setNomeEvento] = useState();

  useEffect(() => {
    const fetch = async () => {
      const items = await axios.get(
        `http://localhost:8080/deputados/${idDeputado}/eventos`
      );

      setEventos(items.data);
    };
    fetch();
  }, []);

  const handleChange = (event) => {
    setNomeEvento(event.target.value);
    console.log(nomeEvento);
  };

  const handleDelete = async () => {
    await axios.delete(
      `http://localhost:8080/deputados/${idDeputado}/eventos/${idEvento}`
    );
    navigate('/');
  };

  const handleEdit = async () => {
    await axios.put(`http://localhost:8080/deputados/${idDeputado}/eventos`, {
      idEvento: idEvento,
      nome: nomeEvento,
    });
    navigate(`/deputados/${idDeputado}/eventos`);
  };

  return (
    <div className="deputados-box">
      <input
        type="text"
        name=""
        id=""
        placeholder="Nome do evento..."
        onChange={handleChange}
      />
      <button onClick={handleEdit}>Editar evento</button>
      <button onClick={handleDelete}>Remover evento</button>
    </div>
  );
};

export default Evento;
