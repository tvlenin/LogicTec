package com.logictec;

import com.LogicTec.compuertas.LogicCompuertas;
import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Nodo;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;

public class Circuito {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    private Lista<String> _listaHashcode;
    
    public Circuito(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();   
        this._listaHashcode = new Lista<>();
    }
    
    public void crearNodo(String pID,String logica, Lista<String> listaHashCodes){
        Rama_Hoja nuevaRama = new Rama_Hoja(logica, pID, listaHashCodes);
        _compuertasDesconectadas.insertar(nuevaRama);
    }
    
    public void conectar_A_ArribaDe_B(String pA, String pB){
        Rama_Hoja A = _circuito.getObjectoNombre(pA);
        Rama_Hoja B = _circuito.getObjectoNombre(pB);
        if( A == null)
            for(Nodo<Rama_Hoja> iterador = _compuertasDesconectadas.getHead(); iterador != null; iterador = iterador.getSiguiente())
                if(pA == iterador.getDato().getIdentificador()){
                    A = iterador.getDato();
                    break;
                }
        if( B == null)
            for(Nodo<Rama_Hoja> iterador = _compuertasDesconectadas.getHead(); iterador != null; iterador = iterador.getSiguiente())
                if(pA == iterador.getDato().getIdentificador()){
                    A = iterador.getDato();
                    break;
                }
        _circuito.conectar_A_ArribaDe_B(A, B);
        
        System.out.println(_circuito.getListaEntradas().getHead());
        System.out.println(_circuito.getListaSalidas().getHead());
    }
    
    private Rama_Hoja buscarSacarEntreDesconectado(String pID){
        Rama_Hoja resp = null;
        for(Nodo<Rama_Hoja> iteradorTree = _compuertasDesconectadas.getHead(); iteradorTree != null; iteradorTree = iteradorTree.getSiguiente()){
            if(iteradorTree.getDato().getIdentificador() ==  pID)
                resp = iteradorTree.getDato();
                break;
        }
        return resp;
    }
    
    public boolean eliminar(String pData){
        return _circuito.eliminar(pData);
    }
    
    public boolean revisar(){
        return _circuito.revisarEntradasYSalidas();
    }
    
    public void getTablaVerdad(){
        
    }
}
