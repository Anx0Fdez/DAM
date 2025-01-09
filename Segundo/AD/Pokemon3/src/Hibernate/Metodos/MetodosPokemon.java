package Hibernate.Metodos;

import Datos.Adestrador;
import Datos.Pokedex;
import Datos.Pokemon;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class MetodosPokemon {

    /**
     * Insertar 12 pokemons en la tabla pokemon(6 para cada Adestrador)
     */
    public void insertarPokemons(String nome, Date nacemento, int pokedexEntryId, int adestradorId) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Pokedex pokedexEntry = session.get(Pokedex.class, pokedexEntryId);
            Adestrador adestrador = session.get(Adestrador.class, adestradorId);

            if (pokedexEntry != null && adestrador != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNome(nome);
                pokemon.setNacemento(nacemento);
                pokemon.setPokedexentry(pokedexEntry);
                pokemon.setAdestrador(adestrador);

                session.save(pokemon);
                transaction.commit();
                System.out.println("Pokemon creado exitosamente");
            } else {
                System.out.println("Pokedex entry o Adestrador no encontrados");
            }
        } catch (Exception e) {
            System.out.println("Error al crear el pokemon: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Adestrador  buscarAdestrador(int id){
        try(Session session = Utilidad.getSessionFactory().openSession()){
            return session.get(Adestrador.class, id);
        } catch (Exception e){
            System.out.println("Error al buscar el adestrador: "+e.getMessage());
            return null;
        }
    }

    public Pokedex buscarPokedex(int id){
        try(Session session = Utilidad.getSessionFactory().openSession()){
            return session.get(Pokedex.class, id);
        } catch (Exception e){
            System.out.println("Error al buscar el pokedex: "+e.getMessage());
            return null;
        }
    }

    public List<Pokemon> listarPokemons(){
        List<Pokemon> pokemons = null;
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Query<Pokemon> query = session.createQuery("from Pokemon", Pokemon.class);
            pokemons = query.list();
            pokemons.forEach(System.out::println);
        } catch (Exception e){
            System.out.println("Error al listar los pokemons: "+e.getMessage());
        }
        return pokemons;
    }


    public void borrarTablaPokemon() {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery("DELETE FROM pokemon");
            session.createNativeQuery("ALTER SEQUENCE pokemon_id_seq RESTART WITH 1").executeUpdate();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla --> " + e.getMessage());
        }
    }



    public void modificarCuatroPokemons(){
        try(Session session = Utilidad.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Pokemon pokemon1 = session.get(Pokemon.class,1);
            Pokemon pokemon2 = session.get(Pokemon.class,2);
            Pokemon pokemon3 = session.get(Pokemon.class,3);
            Pokemon pokemon4 = session.get(Pokemon.class,4);

            if(pokemon1 !=null) pokemon1.setNome("Pokemon Modificado 1");
            if(pokemon2 !=null) pokemon2.setNome("Pokemon Modificado 2");
            if(pokemon3 !=null) pokemon3.setNome("Pokemon Modificado 3");
            if(pokemon4 !=null) pokemon4.setNome("Pokemon Modificado 4");

            session.update(pokemon1);
            session.update(pokemon2);
            session.update(pokemon3);
            session.update(pokemon4);

            transaction.commit();

        } catch (Exception e){
            System.out.println("Error al modificar los pokemons: "+e.getMessage());
        }
    }

}
