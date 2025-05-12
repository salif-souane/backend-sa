package Salif.s.sa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    //@Column(unique = true)
   // private String name;

    @Column(unique = true)
    private String email;

    public  Client(){
    }

    public Client(int id, String email){
        this.id = id;
        //this.name = name;
        this.email = email;

    }

    public int getClient(){
        return this.id;
    }

    public void setClient(int id){
        this.id = id;
    }

   

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
