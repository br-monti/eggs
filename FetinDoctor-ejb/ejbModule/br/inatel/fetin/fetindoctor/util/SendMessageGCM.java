package br.inatel.fetin.fetindoctor.util;
import java.io.IOException;

import com.google.android.gcm.server.Result;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;


public class SendMessageGCM {
    
    //private static final String ID_DISPOSITIVO_GCM = "APA91bEf0mHt8_MTwam3srBQzVSzeIlOE_tmRr6nBrnekW-fhqtL-3-Etluae_7eig4OdIaJJ7E5tpqCo8wb8e82P4w4JpF6VrZ_mjDYjmWOH2Rt_h-GU4OqbMMMQFLlftv4H2h2br7M";
    //tablet
	private static final String ID_DISPOSITIVO_GCM = "APA91bHqugCUjVxlNJlNA_a_JSV2b9p6hkbwkcGS2UONgNyyn9YzQjxyPI8zgLM32dPZuHO3CiX9ciiuQ8cZnScZIJGvZjFFSeavD5quE9K5uuqjVqFei1xM7kW62wosTVZdBaFfChII";
    private static final String API_KEY = "AIzaSyCDUJwNyD5Ru7JcNy9cz65bzZ5qWNUsPVo";
     
    public void sendMessage(String doctor, String quantity, String remedy, String acessCode, String date){          	
        Sender sender = new Sender(API_KEY);
        
        CreateDataHour createDataHour = new CreateDataHour();
         
        Message message = new Message.Builder()
           .collapseKey("1")
           .delayWhileIdle(true)
           .addData("mensagem", // identificador da mensagem
             "Médico, Você fez uma consulta com o Dr. " + doctor 
             + " e você precisa comprar "+ quantity
             + " un. do remédio " + remedy 
             + "\n" 
             + "Código de Acesso: " + acessCode
             +","
             + createDataHour.generateReverseDate() +","
             + createDataHour.generateHour())
           .build();
         
        Result result = null;         
        
        //Envia a mensagem para o dispositivo         
        try {
            result = sender.send(message,ID_DISPOSITIVO_GCM, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        // Imprime o resultado do envio na saída padrão
        if (result != null)
            System.out.println(result.toString());
         
    }
 
}