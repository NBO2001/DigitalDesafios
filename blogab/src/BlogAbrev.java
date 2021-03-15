import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BlogAbrev {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt;
        while (!".".equals( (txt = br.readLine()) )){

            Map<String, String> abs = new HashMap<>();

            StringTokenizer st = new StringTokenizer(txt);

            Map<String, Integer> rp = new HashMap<>();

            String txtFinal = txt;

            while(st.hasMoreTokens()){
                String tmp = st.nextToken();

                if(rp.containsKey(tmp)){

                    rp.put(tmp,rp.get(tmp)+1);

                }else{
                    rp.put(tmp,1);
                }

            }
            Map<String, Integer> abvtmp = new HashMap<>();


            for(Map.Entry<String, Integer> abrev: rp.entrySet()){

                if(abrev.getKey().length() > 2){

                    //Pega a frase
                    String tmp = abrev.getKey();

                    //Criar a abreviatura
                    String tmpAbv = tmp.substring(0,1) + ".";

                    //Veifica se a abreviatura existe
                    if(abvtmp.containsKey(tmpAbv)){

                        // Se o valor que tu pegar for maior que o registrado, substiua

                        if( ( (abs.get(tmpAbv).length()-2)*abvtmp.get(tmpAbv) ) < ((tmp.length()-2)*abrev.getValue()) ){

                            abs.put(tmpAbv,tmp);

                            abvtmp.put(tmpAbv,abrev.getValue());


                        }
                    }else{

                        abs.put(tmpAbv,tmp);

                        abvtmp.put(tmpAbv,abrev.getValue());
                    }


                }
            }

            for (Map.Entry<String, String> entrada : abs.entrySet()) {

                txtFinal = txtFinal.replaceAll("\\b" + entrada.getValue() + "\\b"," " + entrada.getKey());
                //  txtFinal = txtFinal.replace("\\b" + "abc" + "\\b",entrada.getKey());

            }

            System.out.println(txtFinal.trim());

            int  i =0;

            for (Map.Entry<String, String> entradaThree : abs.entrySet()) {

                i++;

            }

            System.out.println(i);

            Map<String, String> result = abs.entrySet().stream().sorted(Entry.comparingByValue())
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            result.forEach((k,v)->System.out.println(k+" = "+v));


        }
    }

}
