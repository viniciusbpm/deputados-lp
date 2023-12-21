import axios from 'axios';
import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './index.css';

const InscreverDeputado = () => {
  const { idDeputado } = useParams();
  const [eventos, setEventos] = useState();
  const [selecionado, setSelecionado] = useState();
  const navigate = useNavigate();

  function removeDuplicates(myArr, prop) {
    return myArr.filter((obj, pos, arr) => {
      return arr.map((mapObj) => mapObj[prop]).indexOf(obj[prop]) === pos;
    });
  }

  useEffect(() => {
    const fetch = async () => {
      const items = await axios.get(`http://localhost:8080/eventos`);

      const itemsFiltered = removeDuplicates(items.data, 'descricaoTipo');

      setEventos(itemsFiltered);
    };
    fetch();
  }, []);

  const handleChange = (event) => {
    setSelecionado(event.target.value);
  };

  const handleClick = async () => {
    const id = selecionado.split(' ');
    await axios.put(
      `http://localhost:8080/deputados/${idDeputado}/eventos/${id[0]}`
    );
    navigate(`/deputados/${idDeputado}/eventos`);
  };

  return (
    <div className="deputados-box">
      <h1>Selecionar evento</h1>
      <select name="select" id="" onChange={handleChange}>
        {eventos?.map((item) => (
          <option>{`${item.id} - ${item.descricaoTipo}`}</option>
        ))}
      </select>
      <button onClick={handleClick}>Selecionar</button>
    </div>
  );
};

export default InscreverDeputado;
