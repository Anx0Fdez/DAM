package Hibernate.Metodos;

import Datos.Pokedex;
import Hibernate.Utilidad.Utilidad;
import org.hibernate.query.NativeQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class MetodosPokedex {

    public void crearPokemon_enPokedex(Pokedex pokedex) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(pokedex);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al crear el pokemon: " + e.getMessage());
        }
    }

    /**
     * Listar pokemons en la pokedex
     */
    public List<Pokedex> listarPokemon_enPokedex() {
        List<Pokedex> pokedex = null;
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Query<Pokedex> query= session.createQuery("from Pokedex ", Pokedex.class);
            pokedex= query.list();
            pokedex.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error al listar los pokemons: " + e.getMessage());
        }
        return pokedex;
    }

    /**
     * Modificar entradas en la pokedex
     */
    public void modificarPokemon_enPokedex(int id,String nome) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class, id);
            if(pokedex!=null){
                pokedex.setNome(nome);
                session.update(pokedex);
                transaction.commit();
            } else{
                System.out.println("No se encontro al pokemon en la pokedex con ese id ");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el pokemon: " + e.getMessage());
        }
    }
    /**
     * Eliminar todos los pokemons de la pokedex
     */
    public void eliminarPokemon_enPokedex(int id) {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex pokedex = session.get(Pokedex.class, id);
            if (pokedex != null) {
                session.delete(pokedex);
            } else {
                System.out.println("No se encontro al pokemon en la pokedex ");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al eliminar el pokemon en la pokedex: " + e.getMessage());
        }
    }

    public void borrarTablaPokedex() {
        try (Session session = Utilidad.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery("DELETE FROM pokedex");
            session.createNativeQuery("ALTER SEQUENCE pokedex_id_seq RESTART WITH 1").executeUpdate();
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error al borrar la tabla --> " + e.getMessage());
        }
    }

    public void modificarPokedexSerializada(int id1, int id2){
        try(Session session=Utilidad.getSessionFactory().openSession()){
            Transaction transaction=session.beginTransaction();

            Pokedex pokedex1 = session.get(Pokedex.class,id1);
            Pokedex pokedex2 = session.get(Pokedex.class,id2);

            if(pokedex1 !=null) pokedex1.setNome("Modificado1");
            if(pokedex2 !=null) pokedex2.setNome("Modificado2");

            session.update(pokedex1);
            session.update(pokedex2);

            transaction.commit();
        } catch (Exception e){
            System.out.println("Error al modificar los pokedex: "+e.getMessage());
        }
    }
}
