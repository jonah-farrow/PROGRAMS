public class Main{    
    public void play(){
        for (int i= 1; i <= 100; i++){
            String output = "";
            if(i % 3 == 0){ System.out.println(output+="fizz");}
            if(i % 5 == 0){ System.out.println(output+="buzz");}
            else{System.out.println(i);}
        }
    }
}