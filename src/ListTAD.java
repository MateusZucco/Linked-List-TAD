public class ListTAD {
    private int numElements;
    private Nodo start, end;

    public ListTAD() {
        numElements = 0;
        start = null;
        end = null;
    }

    public int length() {
        return numElements;
    }

    public boolean isClear() {
        return numElements == 0;
    }

    public void print() {
        Nodo aux = start;
        while(aux != null) {
            System.out.print(aux.elem + " ");
            aux = aux.prox;
        }
        System.out.println('\n');
    }

    public void printReverse() {
        Nodo aux = end;
        while(aux != null) {
            System.out.print(aux.elem + " ");
            aux = aux.ant;
        }
        System.out.println('\n');
    }

    public String toString() {
        Nodo aux = start;
        StringBuilder newString = new StringBuilder("[");
        while(aux != null) {
            newString.append(aux.elem);
            if(aux.prox != null) {
                newString.append(",");
            }
            aux = aux.prox;
        }
        newString.append("]");
        return newString.toString();
    }

    public int getByPos(int pos) {
        if(pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Nodo aux = start;
            for (int i = 0; i < pos; i++) {
                aux = aux.prox;
            }
            return aux.elem;
        }
    }

    public void addEnd(int elem) {
        Nodo novo = new Nodo();
        novo.elem = elem;
        novo.prox = null;
        if(isClear()) {
            novo.ant = null;
            start = novo;
        }
        else { //lista não está vazia
            novo.ant = end;
            end.prox = novo;
        }
        end = novo;
        numElements ++;
    }

    public void addStart(int elem) {
        Nodo novo = new Nodo();
        novo.elem = elem;
        novo.ant = null;
        if(isClear()) {
            novo.prox = null;
            end = novo;
        }
        else {
            novo.prox = start;
            start.ant = novo;
        }
        start = novo;
        numElements ++;
    }
    public void add(int pos,int elem) {
        Nodo novo = new Nodo();
        novo.elem = elem;

        if (pos + 1 <= numElements) {
            Nodo nodoProx = returnNodo(pos + 1);
            novo.prox = nodoProx;
            nodoProx.ant = novo;
        }
        if (pos - 1 >= 0) {
            Nodo nodoAnterior = returnNodo(pos - 1);
            novo.ant = nodoAnterior;
            nodoAnterior.prox = novo;
        }

        if(pos == 0){
            start = novo;
        }
        if(pos == numElements) {
            end = novo;
        }

        numElements ++;
    }

    public void removeEnd() {
        if(!verifyIsEmpty());
        {
             if (numElements == 1) {
                start = null;
                end = null;
                numElements = 0;
            } else {
                end = end.ant;
                end.prox = null;
                numElements--;
            }
        }
    }

    public void removeStart() {
        
        Nodo nodoProx = returnNodo( 1);
        start = nodoProx;
        numElements--;
    }

    public void remove(int pos) {
        if(!verifyIsEmpty()){
            if(pos == 0){
                removeStart();
                return;
            }
            if(pos == numElements){
                removeEnd();
                return;
            }
            if (pos + 1 <= numElements && pos - 1 >= 0) {
                Nodo nodoProx = returnNodo(pos + 1);
                nodoProx.ant =  returnNodo(pos - 1);
                Nodo nodoAnt = returnNodo(pos - 1);
                nodoAnt.prox = returnNodo(pos + 1);
            }

            numElements--;
        }
    }

    public boolean find(int elem) {
        if(!verifyIsEmpty()) {
            Nodo nodo = start;
            while (nodo != null) {
                if (nodo.elem == elem) {
                    return true;
                }
                nodo = nodo.prox;
            }
        }
        return false;
    }

    public void change(int pos, int elem) {
        if(!verifyIsEmpty()) {
            if (pos < 0 || pos >= numElements) {
                throw new IndexOutOfBoundsException();
            }

            Nodo nodo = returnNodo(pos);
            nodo.elem = elem;
        }
    }

    public void clear(){
        start = null;
        end = null;
        numElements = 0;
    }

    private Nodo returnNodo(int pos) {
        if(pos < 0 || pos >= numElements) {
            return null;
        }
        else {
            Nodo aux = start;
            for (int i = 0; i < pos; i++) {
                aux = aux.prox;
            }
            return aux;
        }
    }
    
    private boolean verifyIsEmpty(){
        if(isClear()) {
            System.out.println("List is empty");
            return true;
        }
        return false;
    }
}
