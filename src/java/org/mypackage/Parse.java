/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parse {
    private ArrayList<Result> resultsFromGoogle=new ArrayList<>();
    private ArrayList<Result> resultsFromBing=new ArrayList<>();
    
    public void search(String search) throws Exception {
        search=search.replace(" ","+");
        Document parseGoogle = Jsoup.connect("https://www.google.com/search?q="+search).get();
        Elements elementsGoogle = parseGoogle.select("h3");
        for(Element element:elementsGoogle){
                Elements aElements = element.select("a");
                for(Element aElement:aElements){
                    String url=aElement.attr("abs:href");
                    String title=aElement.text();
                    Result result=new Result(title,url);
                    resultsFromGoogle.add(result);
                    if(url.startsWith("https://www.google.com"))
                        resultsFromGoogle.remove(url);
                }
            }
        Document parseBing=Jsoup.connect("https://www.bing.com/search?q="+search).get();
        Elements elementsBing = parseBing.select("h2");
        for(Element element:elementsBing){
                Elements aElements = element.select("a");
                for(Element aElement:aElements){
                    String url=aElement.attr("abs:href");
                    String title=aElement.text();
                    Result result=new Result(title,url);
                    resultsFromBing.add(result);
                }
            }
    }
    public Result getResultFromGoogle(int i){
            if(i<resultsFromGoogle.size())
                return resultsFromGoogle.get(i);
            else
                return null;
    }
    
   
    public Result getResultFromBing(int i){
         if(i<resultsFromBing.size())
                return resultsFromBing.get(i);
            else
                return null;
    }
}   
    