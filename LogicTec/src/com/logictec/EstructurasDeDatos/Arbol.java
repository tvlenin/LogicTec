package com.LogicTec.EstructurasDeDatos;


public class Arbol<E>{
    
    protected Rama_Hoja _primerElemento;
    protected int _nElementos; 
    protected Lista<Rama_Hoja> _entradasDelArbol;
    protected Lista<Rama_Hoja> _salidasDelArbol; //elementos en la parte mas superior de la estrutura vista como arbol
    
    public Arbol(){
        this._nElementos = -1; //profundidad por defecto de -1
        this._primerElemento = null;
        this._entradasDelArbol = new Lista<>();
        this._salidasDelArbol = new Lista<>();
        
    }
    
    public void conectar_A_ArribaDe_B(Rama_Hoja pRamaA ,Rama_Hoja pRamaB){ //la estructura es semejante a un arbol (se ensancha en la base y disminuye al subir)
        //el pRamaA tiene como entrada la salida de pRamaB.
        if(_nElementos == -1 && pRamaB == null)//se asume que si pCompuerta es nulo, el arbol esta vacio
            this.conectarPrimerElemento(pRamaA);
        else if(pRamaB == null)// este elemento solo es nulo en caso de que el arbol este vacio.
            System.out.println("Error. El arbol no esta vacio, se trato de insertar un nodo como raiz");
        else{
            
                    if(_salidasDelArbol.buscar(pRamaB)){ //
                        _salidasDelArbol.eliminar(pRamaB);
                        _salidasDelArbol.insertar(pRamaA);
                    }
                    else{
                        this.esUnaNuevaSalida(pRamaA, pRamaB);
                       // System.out.println("Probando nueva in con : "+pRamaA.getIdentificador()+"y  "+pRamaB.getIdentificador());
                    }
                    if(_entradasDelArbol.buscar(pRamaA)){
                        _entradasDelArbol.eliminar(pRamaA);
                        _entradasDelArbol.insertar(pRamaB);
                    }
                    else
                        this.esUnaNuevaEntrada(pRamaA,pRamaB);
                    
                    pRamaA.setNewInput(pRamaB);
                    pRamaB.setNewOutPut(pRamaA);
                    this._nElementos++;
                    //System.out.println("Agregue un elemento nuevo al tree");
        }
    }
    
    public void conectarPrimerElemento(Rama_Hoja pNewRama){
        this._primerElemento = pNewRama;
        this._nElementos++;
        this._salidasDelArbol.insertar(pNewRama);
        this._entradasDelArbol.insertar(pNewRama);
        //System.out.println("Extio un elementoh en el arbol");
    }
    
    private void esUnaNuevaEntrada(Rama_Hoja pRamaA, Rama_Hoja pRamaB) {
        //System.out.println("testing IN");
        for(Nodo<Rama_Hoja> iterador = _entradasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente())
            for(Nodo<Rama_Hoja> subiterador = iterador.getDato().getSalidas().getHead(); subiterador != null; subiterador = subiterador.getSiguiente())
                if(subiterador.getDato() == pRamaA){
                    _salidasDelArbol.insertar(pRamaB);
                    //System.out.println("es una nueva IN");
                }
    }
    private void esUnaNuevaSalida(Rama_Hoja pRamaA, Rama_Hoja pRamaB){
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente())
            for(Nodo<Rama_Hoja> subiterador = iterador.getDato().getEntradas().getHead(); subiterador != null; subiterador = subiterador.getSiguiente())
                if(subiterador.getDato() == pRamaB)
                    _salidasDelArbol.insertar(pRamaA);
    }    
    
    public Rama_Hoja getObjetoConXEntradaOSalida(){
        Rama_Hoja resp = null;
        
        return resp;
    }
    public Rama_Hoja getObjectoNombre(String pNombre){//el criterio es el nombre de cada objeto (String) unico
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
    
    public Rama_Hoja getRoot(){
        return this._primerElemento;
    }
    public Lista<Rama_Hoja> getListaSalidas(){
        return this._salidasDelArbol;
    }
    
    public boolean eliminar(String pId){
        for(Nodo<Rama_Hoja> iterador = _entradasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente())
            if( iterador.getDato().getIdentificador() == pId)
                return true;
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente())
            if( iterador.getDato().getIdentificador() == pId)
                return true;
        return false;
    }
    
    public boolean revisarEntradasYSalidas(){//cada nodo debe estar declarado como salida o entrada en los extremos del arbol
        boolean resp = true;
        
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            if(iterador.getDato().getIdentificador() != "IN")
                return false;
        }
        for(Nodo<Rama_Hoja> iterador = _entradasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            if(iterador.getDato().getIdentificador() != "OUT")
                return false;
        }
        return resp;
    }
       
    public void printlnSalidas(){
        for(Nodo<Rama_Hoja> iterador = _salidasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            System.out.println(iterador.getDato().getIdentificador());
        }
    }
    
    public void printlnEntradas(){
        for(Nodo<Rama_Hoja> iterador = _entradasDelArbol.getHead(); iterador != null; iterador = iterador.getSiguiente()){
            System.out.println(iterador.getDato().getIdentificador());
        }
    }
    
    public Lista<Rama_Hoja> getListaEntradas(){
        return this._entradasDelArbol;
    }
    
}
