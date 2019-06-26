public class JavaEquiationSolver{

     public static void main(String []args){
        linEq leq = new linEq();
        linEq leq1 = new linEq();
        linEq leq2 = new linEq();
        linEq leq3 = new linEq();
        
        leq.inpEq("32.1 x   + 43   = 1  98");
        leq1.inpEq("35x- 43=198");
        leq2.inpEq("35+ 43x=198");
        leq3.inpEq("35   = 198x - 43");
        
        System.out.println("x = " + leq.result);
        System.out.println("x = " + leq1.result);
        System.out.println("x = " + leq2.result);
        System.out.println("x = " + leq3.result);
        
     }
}

abstract class equiation{
    float a;
    float b;
    float c;
    float d;
    abstract void inpEq(String eq);
    float result;
}

class linEq extends equiation{
    
    void inpEq(String eq){
        //defining the patterns that could be a linear equiation
        String ptrn = new String("[1-9]+(\\.[1-9]+)?x[+-][1-9]+(\\.[1-9]+)?=[1-9]+(\\.[1-9]+)?");
        String ptrn1 = new String("[1-9]+(\\.[1-9]+)?[+-][1-9]+(\\.[1-9]+)?x=[1-9]+(\\.[1-9]+)?");
        String ptrn2 = new String("[1-9]+(\\.[1-9]+)?=[1-9]+(\\.[1-9]+)?x[+-][1-9]+(\\.[1-9]+)?");
        String ptrn3 = new String("[1-9]+(\\.[1-9]+)?=[1-9]+(\\.[1-9]+)?[+-][1-9]+(\\.[1-9]+)?x");
        
        //removing whitespaces in order to match the patterns
        String eqNospace = eq.replaceAll("\\s+","");
        
        //assigning the coeficients with the applicable pattern
        String[] tkn = new String[99];
        if(eqNospace.matches(ptrn)){
            tkn = eqNospace.split("x[+]|x[-]|[=]");
            a = Float.parseFloat(tkn[0]);
            b = Float.parseFloat(tkn[1]);
            c = Float.parseFloat(tkn[2]);
            
        }else if(eqNospace.matches(ptrn1)){
            tkn = eqNospace.split("[+]|[-]|x[=]");
            a = Float.parseFloat(tkn[1]);
            b = Float.parseFloat(tkn[0]);
            c = Float.parseFloat(tkn[2]);
            
        }else if(eqNospace.matches(ptrn2)){
            tkn = eqNospace.split("x[+]|x[-]|[=]");
            a = Float.parseFloat(tkn[1]);
            b = Float.parseFloat(tkn[2]);
            c = Float.parseFloat(tkn[0]);
            
        }else if(eqNospace.matches(ptrn3)){
            tkn = eqNospace.split("x[+]|x[-]|[=]");
            a = Float.parseFloat(tkn[2]);
            b = Float.parseFloat(tkn[1]);
            c = Float.parseFloat(tkn[0]);
            
        }else{
            tkn = ("1x+1=1000000000000").split("x|[+-]|[=]");
        }
        
        /*
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        */

        //dealing with the negative coeficients TBD
        
        if(eqNospace.contains("-")){
                result = slvLin(a, -b, c);
            }else{
                result = slvLin(a, b, c);
            }
    }
    
    private float slvLin(float a, float b, float c){
        try{
            return (c-b)/a;
        }catch(Exception e){
            return 999999;
        }
    }
    
}

class quadEq extends equiation{
    
    void inpEq(String eq){
        //TBD
    }
    
    
}

