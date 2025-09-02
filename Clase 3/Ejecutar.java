
public class Ejecutar {
    public static void main(String[] args) {

        libro[] libros= new libro[5];
        
        libros[0]= new libro("El principito", "Antoine de Saint-Exupéry", 100000);
        libros[1]= new libro("Cien años de soledad", "Gabriel García Márquez", 12500);
        libros[2]= new libro("La ciudad y los perros", "Mario Vargas Llosa", 25000);
        libros[3]= new libro("La casa de los espíritus", "Isabel Allende", 150000);
        libros[4]= new libro("El lobo estepario", "Hermann Hesse", 400000);

        System.out.println("El precio total de los libros es: " + libros[0].calcularPrecio(libros));
    }    

}
