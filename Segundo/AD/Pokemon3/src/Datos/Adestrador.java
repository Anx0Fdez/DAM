package Datos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Adestrador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nacemento")
    private Date nacemento;

    public Adestrador(){

    }
    public Adestrador(int id, String nome, Date nacemento){
        this.id=id;
        this.nome=nome;
        this.nacemento=nacemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}
