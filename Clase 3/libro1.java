class libro {

    String Titulo;
    String autor;
    double precio;

    //Constructor
    public libro(String Titulo, String autor, int precio){
        this.Titulo= Titulo;
        this.autor= autor;
        this.precio= precio;
    }
    
    public double calcularPrecio(libro[] libros){
        double total=0;
        for(int i=0; i<libros.length; i++){
            total+= libros[i].precio;
        }
        return total;
       
    }
    
    
        
    
    
    
        
}
