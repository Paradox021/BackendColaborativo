package com.example.demo.services;

import com.example.demo.models.TranslatedText;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslatorService {

    @Autowired
    RestTemplate restTemplate;

    public TranslatedText getTranslationFromAPI(String cad){
        String url = "https://api.mymemory.translated.net/get?q="+cad+"&langpair=es|en";
        TranslatedText text = restTemplate.getForObject(url, TranslatedText.class);
        return text;
    }
}
