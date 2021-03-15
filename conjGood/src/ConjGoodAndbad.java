import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConjGoodAndbad {

    public static void main(String[] args) throws IOException {

        BufferedReader inpt = new BufferedReader(new InputStreamReader(System.in));
        String response;
        int cont = 0;
        while(!"0".equals((response = inpt.readLine()))){

            try{
                cont = Integer.parseInt(response);
            }catch(Exception e){

            }


        }

    }
}
