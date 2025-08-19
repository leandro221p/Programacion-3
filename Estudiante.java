public class Estudiante{
    //Atributos
    private int id;
    private int cedula;
    private String nombre;
    private String facultad

    //constructor
    public Estudiante(int id, int cedula,String nombre,String facultad){
        this.id= id; 
        this.cedula=cedula;
        this.nombre=nombre;
        this.facultad=facultad;

    }

    //Metodo toString
    public String toString(){
        return"Estudiante: [ id: "+ id +"cedula: "+ cedula + "Nombre: "+ nombre +"Facultad: "+facultad;

    }

}