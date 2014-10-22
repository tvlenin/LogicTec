package com.EstructurasDeDatos;


public class Arbol<E> {
    
    protected Rama_Hoja _primerElemento;
    protected int _nElementos; 
    protected Lista<Rama_Hoja> _entradas;
    protected Lista<Rama_Hoja> _salidas;
    
    public Arbol(){
        this._nElementos = -1; //profundidad por defecto de -1
        this._primerElemento = null;
        this._entradas = new Lista<>();
        this._salidas = new Lista<>();
    }
    
    public void conectar_A_ArribaDe_B(Rama_Hoja pRamaA,Rama_Hoja pRamaB){ //la estructura es semejante a un arbol (se ensancha en la base y disminuye al subir)
        //el pRamaA tiene como entrada la salida de pRamaB.
        if(_nElementos == -1 && pRamaB == null)//se asume que si pCompuerta es nulo, el arbol esta vacio
            this.insertarPrimerElemento(pRamaA);
        else if(pRamaB == null)// este elemento solo es nulo en caso de que el arbol este vacio.
            System.out.println("Error. El arbol no esta vacio, se trato de insertar un nodo como raiz");
        else{
            if(_entradas.buscar(pRamaA)){//si se conecta un nuevo nodo en la parte inferior de uno existente
                _entradas.eliminar(pRamaA);
                _entradas.insertar(pRamaB);
            }
            if (_salidas.buscar(pRamaB)){
                _salidas.eliminar(pRamaB);
                _salidas.insertar(pRamaA);
            }
            
            pRamaA.setNewInput(pRamaB);
            pRamaB.setNewOutPut(pRamaA);
            this._nElementos++;
            //System.out.println("Agregue un elemento nuevo al tree");
        }
    }
    
    public Nodo<Rama_Hoja> darObjectoNombre(String pName){
        Nodo<Rama_Hoja> resp = null;
        for(Nodo<Rama_Hoja> iterador = _entradas.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            if(iterador.getDato().getIdentificador() == pName)
                break;
            else{
            }
        }
        
        return resp;
    }
    private Nodo<Rama_Hoja> buscarObjeto(){
        Nodo<Rama_Hoja> resp = null;
        return resp;
    }
    
    private void insertarPrimerElemento(Rama_Hoja pNewRama){
        this._primerElemento = pNewRama;
        this._nElementos++;
        this._entradas.insertar(pNewRama);
        this._salidas.insertar(pNewRama);
        //System.out.println("Extio un elemento en el arbol");
    }
    
    public boolean revisarEntradasYSalidas(){//cada nodo debe estar declarado como salida o entrada en los extremos del arbol
        boolean resp = true;
        for(Nodo<Rama_Hoja> iterador = _entradas.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            if(iterador.getDato().getIdentificador() != "IN")
                return false;
        }
        for( Nodo<Rama_Hoja> iterador = _salidas.getHead(); iterador != null; iterador = iterador.getSiguiente() ){
            if(iterador.getDato().getIdentificador() != "OUT")
                return false;
        }
        return resp;
    }
    
    public boolean revisarConexionLogica(){
        boolean resp = false;
        
        return resp;
    }
    public Rama_Hoja getRoot(){
        return _primerElemento;
    }
    
    public void eliminar(){}

}
