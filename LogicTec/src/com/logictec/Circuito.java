package com.logictec;

import com.LogicTec.compuertas.LogicCompuertas;
import com.LogicTec.EstructurasDeDatos.Arbol;
import com.LogicTec.EstructurasDeDatos.Lista;
import com.LogicTec.EstructurasDeDatos.Nodo;
import com.LogicTec.EstructurasDeDatos.Rama_Hoja;

public class Circuito {
    
    private Lista<Rama_Hoja> _compuertasDesconectadas; 
    private Arbol _circuito;
    private Lista<String> _ID_HASHCODE_IO;
    
    public Circuito(){
        this._compuertasDesconectadas = new Lista<>();
        this._circuito = new Arbol();   
        this._ID_HASHCODE_IO = new Lista<>();
    }
    
    public void crearNodo(String pID,String logica, Lista<String> listaHashCodes){
        Rama_Hoja nuevaRama = new Rama_Hoja(logica, pID, listaHashCodes);
        _compuertasDesconectadas.insertar(nuevaRama);
        _ID_HASHCODE_IO.concatenar(listaHashCodes);
    }
    
    public void conectar(String AHC, String BHC){ //hashcode B y B
        String Acode= null;
        String Bcode= null;
        for (Nodo<String> i = _ID_HASHCODE_IO.getHead(); i != null; i = i.getSiguiente()){
            if(i.getDato().contains(AHC)){
                Acode = i.getDato();
            }
            if(i.getDato().contains(BHC)){
                Bcode = i.getDato();
            }
        }
        System.out.println(Acode+" , conectando , "+Bcode);
        Rama_Hoja NODOA =_circuito.getObjectoNombre(Acode.split("_")[0]);
        if(NODOA == null){
            for(Nodo<Rama_Hoja> i = _compuertasDesconectadas.getHead(); i != null; i= i.getSiguiente()){
                if (Acode.contains(i.getDato().getIdentificador())){
                    NODOA = i.getDato();
                }
            }
        }
        Rama_Hoja NODOB =_circuito.getObjectoNombre(Bcode.split("_")[0]);
        if(NODOB == null){
            for(Nodo<Rama_Hoja> i = _compuertasDesconectadas.getHead(); i != null; i= i.getSiguiente())
                if (Bcode.contains(i.getDato().getIdentificador())){
                    NODOB = i.getDato();
                }
        }
        _circuito.conectarA_B(NODOA, AHC , NODOB, BHC);
    }
    
    /*public void conectar_A_ArribaDe_B(String pA, String pB){
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
    */
    
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
