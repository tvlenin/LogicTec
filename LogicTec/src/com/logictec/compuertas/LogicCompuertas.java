package com.LogicTec.compuertas;

public class LogicCompuertas {

    public LogicCompuertas(){}
    
    public static boolean doLogic(boolean A, boolean B, String plogic){
        boolean resp = false;
        switch (plogic){
            case "NOT":
                resp = !A;
                break;
            case "AND":
                resp = A && B;
                break;
            case "NAND":
                if (A == false || B == false)
                    resp = true;
                break;
            case "NOR":
                if (A == false && B == false)
                    resp = true;
                break;
            case "OR":
                if (A == true || B == true)
                    resp = true;
                break;
            case "XNOR":
                if (A == B)
                    resp = true;
                break;
            case "XOR":
                if (A != B)
                    resp = true;
                break;
            default:
                System.out.println("I/O no tienen logica de compuertas.");
                break;
        }
        
        return resp;
    }
}
