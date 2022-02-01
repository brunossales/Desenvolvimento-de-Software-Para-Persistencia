package com.persist.service;

import com.google.gson.Gson;
import com.persist.models.Article;

import redis.clients.jedis.Jedis;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Controller {
    private Jedis jedis;
    private Gson gson;
    public Controller(Jedis j){
        jedis = j;
        gson = new Gson();
    }
    public void cArticle(Article ar, Integer id){
        jedis.set("art:" + id, gson.toJson(ar));
        jedis.sadd("all:art", String.valueOf(id));
    }
    public void vincArtToTag(String tag, Integer idAr){
        jedis.sadd("art:" + idAr + ":tags:", tag);
        jedis.sadd("tags:art:" + tag, String.valueOf(idAr));
    }
    public  List<String> TagOfArticle(Integer idAr){
        return this.jedis.smembers("art:" + idAr +":tags").stream().collect(Collectors.toList());
    }
    public List<String> ArtOfTag(String tag){
        return this.jedis.smembers("tags:art:" + tag).stream().collect(Collectors.toList());
    }
    public List<String> NameAndDescAllAr(){
        return this.jedis.smembers("all:art").stream().collect(Collectors.toList());
    }
}
