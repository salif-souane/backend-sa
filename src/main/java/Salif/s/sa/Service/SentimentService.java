package Salif.s.sa.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;

import Salif.s.sa.Entity.Client;
import Salif.s.sa.Entity.Sentiment;
import Salif.s.sa.Enums.TypeSentiments;
import Salif.s.sa.Repository.ClientRepository;
import Salif.s.sa.Repository.SentimentRepository;

@Service
public class SentimentService {
    
    @Autowired
    SentimentRepository sentimentRepository;

    @Autowired
    ClientService clientService;


    
    public void creer(Sentiment sentiment){
        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiments.NEGATIF);
        }else{
            sentiment.setType(TypeSentiments.POSITIF);
        }
        Client client = this.clientService.LireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        this.sentimentRepository.save(sentiment);
    }
    
    public List<Sentiment> lire(){
        return this.sentimentRepository.findAll();
    }

    public void supprimer(int id){
        this.sentimentRepository.deleteById(id);
    }
}
