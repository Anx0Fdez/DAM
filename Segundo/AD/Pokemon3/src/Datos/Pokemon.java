package Datos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Pokemon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name ="nacemento")
    private Date nacemento;

    @ManyToOne
    @JoinColumn(name ="pokedexentry", referencedColumnName = "id", nullable = true)
    private Pokedex pokedexentry;

    @ManyToOne
    @JoinColumn(name ="adestrador", referencedColumnName = "id", nullable = true)
    private Adestrador adestrador;

    public Pokemon() {
    }

    public Pokemon(String nome, Date nacemento, Pokedex pokemonentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokemonentry;
        this.adestrador = adestrador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedex getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(Pokedex pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                ", pokedexentry=" + pokedexentry +
                ", adestrador=" + adestrador +
                '}';
    }
}
