 SELECT c.id,
               c.titulo,
               c.adopo,
               c.descripcion,
               pt.stars
              
        FROM chiste c
        LEFT JOIN (
          SELECT AVG(puntos) as stars,
                
                 idchiste
          FROM puntos
          GROUP BY idchiste
        ) pt ON c.id = pt.idchiste
        WHERE c.idcategoria LIKE '1'
        ORDER BY COALESCE(pt.stars, 0) DESC