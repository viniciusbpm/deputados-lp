import axios from 'axios';
import { useEffect, useState } from 'react';
import './index.css';

const Deputados = () => {
  const [deputados, setDeputados] = useState();

  useEffect(() => {
    const fetch = async () => {
      const items = await axios.get('http://localhost:8080/deputados');

      setDeputados(items.data);
    };
    fetch();
  });

  return (
    <div className="deputados-box">
      <h1>Deputados</h1>
      {deputados?.map((item) => (
        <a href={`/deputados/${item.id}`}>{item.nome}</a>
      ))}
    </div>
  );
};

export default Deputados;
