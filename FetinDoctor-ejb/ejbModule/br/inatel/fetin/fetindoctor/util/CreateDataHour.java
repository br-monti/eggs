package br.inatel.fetin.fetindoctor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDataHour {

    public String generateDate(){
        Date d = new Date();

        SimpleDateFormat simpedateformat = new SimpleDateFormat("dd/MM/yyyy");
        return (simpedateformat.format(d));
    }
    
    public String generateHour(){
        Date d = new Date();

        SimpleDateFormat simpedateformat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(simpedateformat.format(d));
        return (simpedateformat.format(d));
    }
    
    public String generateReverseDate(){
    	
    	Date d = new Date();
    	
        SimpleDateFormat simpedateformat = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(simpedateformat.format(d));
        return (simpedateformat.format(d));
        
    	
    }
    

}


