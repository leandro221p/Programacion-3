public class nodoArbol {
    //1 . visitar raiz
    //2 . recorrer subarbol nodoIzquierdo
    //3 . recorrer subarbol nodoDerecho
    private nodoArbol nodoIzquierdo;
    private nodoArbol nodoDerecho;
    private int valor;
    public nodoArbol(int valor) {
        this.valor = valor;
        this.nodoIzquierdo = null;
        this.nodoDerecho = null;
    }
    public int getValor() {
        return valor;
    }
    public nodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }
    public nodoArbol getNodoDerecho() {
        return nodoDerecho;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public void setNodoIzquierdo(nodoArbol nodoIzquierdo) { //asigna un nodo al nodoIzquierdo
        this.nodoIzquierdo = nodoIzquierdo;
    }
    public void setNodoDerecho(nodoArbol nodoDerecho) { //asigna un nodo al nodoDerecho
        this.nodoDerecho = nodoDerecho;
    }
}
class ArbolBinario {
    private nodoArbol raiz;
    public ArbolBinario() {
        this.raiz = null;
    }
    public nodoArbol getRaiz() {
        return raiz;
    }
    public void setRaiz(nodoArbol raiz) {
        this.raiz = raiz;
    }
    public void recorridoPreorden() {
        System.out.println("Recorrido en Preorden: ");
        recorrido(raiz);// llama al metodo recursivo recorrido pasandole la raiz como punto de inicio
    }
    private void recorrido(nodoArbol nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo.getValor());// visita el nodo actual
        recorrido(nodo.getNodoIzquierdo());// recorre el subarbol nodoIzquierdo
        recorrido(nodo.getNodoDerecho());// recorre el subarbol nodoDerecho
        // se detiene cuando encuentra un nodo nulo
    }
    public void insertar(int valor) { // recibe el nuevo valor y llama al método recursivo insertarValor
        raiz = insertarValor(raiz, valor);// raiz es el punto de partida
    }
    public nodoArbol insertarValor(nodoArbol nodo, int valor) {
        if (nodo == null) {// cuando encuentra un espacio vacío crea un nuevo nodo y lo enlaza al padre
            return new nodoArbol(valor);
        }
        // decide si insertar en nodoIzquierdo o nodoDerecho
        if (valor < nodo.getValor()) {
            nodo.setNodoIzquierdo(insertarValor(nodo.getNodoIzquierdo(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setNodoDerecho(insertarValor(nodo.getNodoDerecho(), valor));
        }
        return nodo;
    }
    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(42);
        arbol.insertar(9);
        arbol.insertar(10);
        arbol.insertar(18);
        arbol.insertar(34);
        arbol.insertar(49);
        arbol.insertar(33);
        arbol.insertar(21);
        arbol.recorridoPreorden();

    }

}
 