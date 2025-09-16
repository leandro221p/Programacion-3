import java.util.Stack;

public class Operacionpila {
    Stack<String> pilaSignos;
  public boolean ValidarParentesis(String[]s) {
    boolean flag= false;
    pilaSignos = new Stack<>();
    //almacenar en la pila el arreglo de signos
    for (int i=0; i < s.length; i++) {
      pilaSignos.push(s[i]);
    }
      int tam = pilaSignos.size();
      int cont=0, cont2=0;
      //recorrer la pila
      for (int i=0; i < tam; i++) {
        if (pilaSignos.peek().equals("(")) {
            cont += 1;
        }else{
            cont2 += 1;
        }
        pilaSignos.pop();  
    }
    flag = (cont == cont2 ? true : false);
    return flag;
    
  }  
}
