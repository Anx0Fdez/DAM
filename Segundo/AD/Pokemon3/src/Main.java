import Datos.Adestrador;
import Datos.Pokedex;
import Datos.Pokemon;
import Hibernate.Metodos.LecturaDatosXML;
import Hibernate.Metodos.MetodosAdestrador;
import Hibernate.Metodos.MetodosPokedex;
import Hibernate.Metodos.MetodosPokemon;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        MetodosPokedex metodosPokedex = new MetodosPokedex();


        Adestrador adestrador1 = new Adestrador(1, "Ash Ketchum", Date.valueOf("1990-05-22"));
        Adestrador adestrador2 = new Adestrador(2, "Misty Waterflower", Date.valueOf("1992-08-14"));

        metodosAdestrador.crearAdestrador(adestrador1);
        metodosAdestrador.crearAdestrador(adestrador2);


        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Pikachu", 6.0, "Electric type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Bulbasaur", 7.0, "Grass/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Charmander", 8.5, "Fire type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Squirtle", 9.0, "Water type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Caterpie", 2.9, "Bug type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Weedle", 3.2, "Bug/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Pidgey", 4.0, "Normal/Flying type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Rattata", 3.5, "Normal type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Spearow", 4.0, "Normal/Flying type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Ekans", 6.9, "Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Toxtricity", 40.0, "Electric/Poison type"));
        metodosPokedex.crearPokemon_enPokedex (new Pokedex("Gardevoir", 48.4, "Psychic/Fairy type"));


        metodosPokemon.insertarPokemons("Pikachu", Date.valueOf("2023-01-01"),1, 1);
        metodosPokemon.insertarPokemons("Bulbasaur", Date.valueOf("2023-01-01"), 2, 1);
        metodosPokemon.insertarPokemons("Charmander", Date.valueOf("2023-01-01"), 3,1);
        metodosPokemon.insertarPokemons("Squirtle", Date.valueOf("2023-01-01"), 4, 1);
        metodosPokemon.insertarPokemons("Caterpie", Date.valueOf("2023-01-01"), 5, 1);
        metodosPokemon.insertarPokemons("Weedle", Date.valueOf("2023-01-01"), 6, 1);

        metodosPokemon.insertarPokemons("Pidgey", Date.valueOf("2023-01-01"), 7, 2);
        metodosPokemon.insertarPokemons("Rattata", Date.valueOf("2023-01-01"), 8,2);
        metodosPokemon.insertarPokemons("Spearow", Date.valueOf("2023-01-01"), 9, 2);
        metodosPokemon.insertarPokemons("Ekans", Date.valueOf("2023-01-01"), 10, 2);
        metodosPokemon.insertarPokemons("Toxtricity", Date.valueOf("2023-01-01"), 11, 2);
        metodosPokemon.insertarPokemons("Gardevoir", Date.valueOf("2023-01-01"), 12, 2);


        System.out.println("Lista de Pokemons en Pokedex:");
        List<Pokedex> pokedexList = metodosPokedex.listarPokemon_enPokedex();
        for (Pokedex pokedex : pokedexList) {
            System.out.println(pokedex);
        }
        Pokedex[] pokedexArray = pokedexList.toArray(new Pokedex[0]);

        System.out.println("Lista de Adestradores:");
        List<Adestrador> adestradoresList = metodosAdestrador.listarAdestrador();
        for (Adestrador adestrador : adestradoresList) {
            System.out.println(adestrador);
        }

        System.out.println("Lista de Pokemons en la tabla Pokemon:");
        List<Pokemon> pokemonsList = metodosPokemon.listarPokemons();
        for (Pokemon pokemon : pokemonsList) {
            System.out.println(pokemon);
        }

        LecturaDatosXML lecturaDatosXML = new LecturaDatosXML();
        lecturaDatosXML.exportarPokedexSerializada();

        System.out.println("Modificando 2 entradas en la Pokedex serializadas...");
        metodosPokedex.modificarPokedexSerializada(pokedexArray[0].getId(),pokedexArray[1].getId());

        System.out.println("Modificando 4 pokemons...");
        metodosPokemon.modificarCuatroPokemons();


        System.out.println("Lista final de Pokemons en la Pokédex:");
        List<Pokedex> finalPokedexList = metodosPokedex.listarPokemon_enPokedex();
        for (Pokedex pokedex : finalPokedexList) {
            System.out.println(pokedex);
        }

        System.out.println("Lista final de Adestradores:");
        List<Adestrador> finalAdestradoresList = metodosAdestrador.listarAdestrador();
        for (Adestrador adestrador : finalAdestradoresList) {
            System.out.println(adestrador);
        }

        System.out.println("Lista final de Pokemons en la tabla Pokemon:");
        List<Pokemon> finalPokemonsList = metodosPokemon.listarPokemons();
        for (Pokemon pokemon : finalPokemonsList) {
            System.out.println(pokemon);
        }

        System.out.println("Importando datos serializados...");
        lecturaDatosXML.importarPokedexSerializado();

        System.out.println("Modificando las entradas de la pokedex con los datos serializados...");
        metodosPokedex.modificarPokedexSerializada(pokedexArray[0].getId(),pokedexArray[1].getId());

        lecturaDatosXML.leerDatosAdestrador(adestradoresList);
        System.out.println("Importando datos XML...");
        lecturaDatosXML.importarAdestradoresXML();

        System.out.println("Modificando las entradas de adestradores con los datos XML...");
        metodosAdestrador.modificarAdestradoresDesdeXML(adestrador1.getId(),adestrador2.getId());


        System.out.println("Lista final de Pokemons en la Pokedex despues de la importacion:");
        List<Pokedex> finalPokedexDespuesImport = metodosPokedex.listarPokemon_enPokedex();
        for(Pokedex pokedex : finalPokedexDespuesImport){
            System.out.println(pokedex);
        }

        System.out.println("Lista final de Adestradores despues de la importacion:");
        List<Adestrador> finalAdestradoresDespuesImport = metodosAdestrador.listarAdestrador();
        for(Adestrador adestrador : finalAdestradoresDespuesImport){
            System.out.println(adestrador);
        }

        System.out.println("Lista final de Pokemons en la tabla Pokemon despues de la importacion:");
        List<Pokemon> finalPokemonsDespuesImport = metodosPokemon.listarPokemons();
        for(Pokemon pokemon : finalPokemonsDespuesImport){
            System.out.println(pokemon);
        }
        System.out.println("Eliminando todos los datos de las tablas...");



        metodosPokemon.borrarTablaPokemon();
        metodosPokedex.borrarTablaPokedex();
        metodosAdestrador.borrarTablaAdestrador();
    }
}