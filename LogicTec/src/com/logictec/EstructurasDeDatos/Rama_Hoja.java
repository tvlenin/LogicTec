package com.LogicTec.EstructurasDeDatos;

import com.LogicTec.compuertas.LogicCompuertas;

public class Rama_Hoja{
    
    protected String _nombre; //identificador unico para cada compuerta, creado por la GUI
    protected int _ValorOutPut; //resultado de todas las entradas
    protected String _logicaCompuerta; //and, or, nor, not, etc
    protected Lista<Rama_Hoja> arrayIO;
    
    public Rama_Hoja(String pLogicaCompuerta,String pID,Lista<String> listaHashCode){
        this._nombre = pID;
        this._logicaCompuerta = pLogicaCompuerta;
        this.arrayIO = new Lista<>(listaHashCode);
        
        if(pLogicaCompuerta == "IN")
            this._ValorOutPut = 0;
        else
            this._ValorOutPut = -1;
    }
    
    public void conectar(String hascode, Rama_Hoja pRama){
        arrayIO.insertarEnIndex(hascode, pRama);
    }
    
    public void actualizarData(){
    }
    
    public int getValorOutPut(){
        this.actualizarData();
        return this._ValorOutPut;
    }
    
    public String getIdentificador(){//identificador unico asignado en la GUI
        return this._nombre;
    }
    
    public String getLogicAccion(){// String en MAYUSCULA que describe la accion logica de esta compuerta
        return this._logicaCompuerta;
    }
    
    public Lista<Rama_Hoja> getSalidas(){
        Lista<Rama_Hoja> resp = null;
        for (Nodo<Rama_Hoja> i = arrayIO.getHead(); i != null; i=i.getSiguiente()){
            if(i.getIndex().split("_")[2]=="O")
                resp.insertar(i.getDato());
        }
        return resp;
    }
    public Lista<Rama_Hoja> getEntradas(){
    Lista<Rama_Hoja> resp = null;
        for (Nodo<Rama_Hoja> i = arrayIO.getHead(); i != null; i=i.getSiguiente()){
            if(i.getIndex().split("_")[2]=="I")
                resp.insertar(i.getDato());
        }
        return resp;
    }
    
    public void printOutPuts(){ //Imprimir el nombre de todos los outpus 
    }
    
    public void printInPuts(){// Imprimir todos los nombres de los Inputs
    }
    
    public void setValueOfOutPut(int pData){
        if (_logicaCompuerta == "IN")
            _ValorOutPut = pData;
        else
            System.out.println("Por seguridad solo es permitido cambiar el resultado de logica a las compuertas de InPut");
    }
 
}

