package com.persist.UI;

import com.persist.models.Article;
import com.persist.service.Controller;
import redis.clients.jedis.Jedis;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        // "localhost" e porta 6379
        try(Jedis jedis = new Jedis()){
            System.out.println(jedis.ping());
            Controller controller = new Controller(jedis);

            //Como não especifico o Id, eles recebem o Id 1 e 2 em ordem
            controller.cArticle(new Article("Artico sobre Spring", "Description beutifull"
                    , "00", LocalDate.of(2001, 9, 5)), 1);
            controller.cArticle(new Article("Artico sobre Redis", "Uma boa ferramenta"
                    , "023", LocalDate.of(2004, 5, 23)), 2);

            //Associando
            controller.vincArtToTag("Primeira Tag associada e criada", 1 );
            controller.vincArtToTag("Segunda Tag Associada e criada", 2);

            //Listar as tag por artigo
            System.out.println(controller.TagOfArticle(1));

            //Todos os artigos de uma determinada tag

            System.out.println(controller.ArtOfTag("Primeira Tag associada e criada"));

            //Nome e descrição de todos os artigos
            System.out.println(controller.NameAndDescAllAr());
        }

    }
}
