package com.EstructurasDeDatos;


public class Arbol<E> {
    
    protected Rama_Hoja _primerElemento;
    protected int _nElementos; 
   // protected Lista<Rama_Hoja> _entradas;
    protected Lista<Rama_Hoja> _salidasDelArbol; //elementos en la parte mas superior de la estrutura vista como arbol
    
    public Arbol(){
        this._nElementos = -1; //profundidad por defecto de -1
        this._primerElemento = null;
       // this._entradas = new Lista<>();
        this._salidasDelArbol = new Lista<>();
    }
    
    public void conectar_A_ArribaDe_B(Rama_Hoja pRamaA, String pNameRamaB){
        Rama_Hoja pRamaB = this.darObjectoNombre(pNameRamaB);
        if (pRamaB != null)
            this.conectar_A_ArribaDe_B(pRamaA, pRamaB);
        else
            System.out.println("Ese nombre donde quiere insertar no existe");
    }
    
    public void conectar_A_ArribaDe_B(Rama_Hoja pRamaA,Rama_Hoja pRamaB){ //la estructura es semejante a un arbol (se ensancha en la base y disminuye al subir)
        //el pRamaA tiene como entrada la salida de pRamaB.
        if(_nElementos == -1 && pRamaB == null)//se asume que si pCompuerta es nulo, el arbol esta vacio
            this.insertarPrimerElemento(pRamaA);
        else if(pRamaB == null)// este elemento solo es nulo en caso de que el arbol este vacio.
            System.out.println("Error. El arbol no esta vacio, se trato de insertar un nodo como raiz");
        else{
            if (_salidasDelArbol.buscar(pRamaB)){//estoy insertando sobre un actual objeto marcado como salida
                _salidasDelArbol.eliminar(pRamaB);
                _salidasDelArbol.insertar(pRamaA);
            }
            else{//si se inserta algo que queda al mismo nivel que una salida, debe agregarse como salida tambien.
                for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente())
                    for(Nodo<Rama_Hoja> subiterador = iterador.getDato().getEntradas().getHead(); iterador != null; iterador = iterador.getSiguiente())
                        if( subiterador.getDato() == pRamaB)
                            _salidasDelArbol.insertar(pRamaA);
            }
            pRamaA.setNewInput(pRamaB);
            pRamaB.setNewOutPut(pRamaA);
            this._nElementos++;
            //System.out.println("Agregue un elemento nuevo al tree");
        }
    }
    
    private void insertarPrimerElemento(Rama_Hoja pNewRama){
        this._primerElemento = pNewRama;
        this._nElementos++;
        this._salidasDelArbol.insertar(pNewRama);
        //System.out.println("Extio un elemento en el arbol");
    }
    
    
    public Rama_Hoja darObjectoNombre(String pNombre){//el criterio es el nombre de cada objeto (String) unico
        Rama_Hoja resp = null;                       //si no encuentra retorna null.
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            resp = this.buscarObjeto(pNombre,iterador.getDato());
            if (resp != null )
                break;
        }
        return resp;
    }
    
    private Rama_Hoja buscarObjeto(String pNombre,Rama_Hoja pNodo){
        Rama_Hoja resp = null;
        if(pNodo.getIdentificador() == pNombre)
            resp = pNodo;
        else
            for(Nodo<Rama_Hoja> iterador = pNodo.getEntradas().getHead(); iterador != null; iterador = iterador.getSiguiente())
                resp = this.buscarObjeto(pNombre, iterador.getDato());
        return resp;
    }
    
    public boolean revisarEntradasYSalidas(){//cada nodo debe estar declarado como salida o entrada en los extremos del arbol
        boolean resp = true;
        
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            if(iterador.getDato().getIdentificador() != "IN")
                return false;
        }
        return resp;
    }
    
    public Lista<Rama_Hoja> getUltimoNivel(Lista<Rama_Hoja> pRespuesta){
        
        for(Nodo<Rama_Hoja> iterador = pRespuesta.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            
        }
        return pRespuesta;
    }
    
    public void revisarConexionLogica(){}
    
    public Rama_Hoja getRoot(){
        return this._primerElemento;
    }
    public Lista<Rama_Hoja> getListaSalidas(){
        return this._salidasDelArbol;
    }
    
    public void eliminar(){}
       
    public void printlnSalidas(){
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            System.out.println(iterador.getDato().getIdentificador());
        }
    }
    
}
