import java.util.Stack;

public class Clase7 {
public static void main(String[] args) {
    //creacion de una pila de numeros enteros
    Stack<Integer> pila = new Stack<>();
    //verificar si la pila esta vacia
    System.out.println(pila.empty());//true
    //insertar elementos en la pila
    pila.push(8);
    pila.push(4);
    pila.push(9);
    pila.push(10);
    pila.push(6);
    //imprimir la pila
    System.out.println(pila);

    //mostrar el elemento en la cima de la pila sin removerlo
    System.out.println("Tope de la pila: " + pila.peek());
    
    //remover el elemento que se encuentra en el tope de la pila
    System.out.println("Elemento removido del tope de la pila: " + pila.pop());
    //imprimir la pila
    System.out.println(pila);
    //buscar y mostrar un elemento dentro de la pila
    System.out.println(pila.search(10));
    System.out.println(pila.search(9));
    System.out.println(pila.search(4));
    System.out.println(pila.search(8));
    System.out.println(pila.search(50));
    //verificar si la pila esta vacia
    System.out.println(pila.empty());//false
    //llamar el metodo para validar parentesis
    Operacionpila objOp = new Operacionpila();
    String[] signos = {"(", "(", ")", "(", ")", ")", "(", ")"};
    System.out.println(objOp.ValidarParentesis(signos));

    }
    
}