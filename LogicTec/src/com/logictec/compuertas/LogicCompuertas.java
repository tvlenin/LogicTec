package com.LogicTec.compuertas;

public class LogicCompuertas {

    public LogicCompuertas(){}
    
    public static int doLogic(int pA, int pB, String plogic){
        boolean resp = false;
        boolean A= false;
        boolean B = false;
        if(pA == 1)
            A = true;
        if(pB == 1)
            B = true;
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
        int res = 0;
        if (resp)
            res = 1;
        return res;
    }
}
