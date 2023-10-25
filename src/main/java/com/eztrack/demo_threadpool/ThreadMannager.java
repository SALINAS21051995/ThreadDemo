/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eztrack.demo_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
    * @author Carlos Salinas
 */
public class ThreadMannager implements IListener{
    private final IListener context = this; // variable para obtener el contexto del listener ya que este se implemento en la clase
    public static final long RUN_OUT_TIME = 1;
        
    public void mainWork() throws InterruptedException{
        ExecutorService es = Executors.newCachedThreadPool();
        // ahora a los objetos se les envia el contexto del listener, o se puede tomar como que se envia el objeto al que s ele va a notificar
        Hilo hilo1 = new Hilo(8000L, 1, context);
        Hilo hilo2 = new Hilo(5000L, 2, context); 
        Hilo hilo3 = new Hilo(9000L, 3, context); 
        Hilo hilo4 = new Hilo(2000L, 4, context); 
        Hilo hilo5 = new Hilo(4000L, 5, context); 
        Thread alert1  = new Thread((Runnable) hilo1);
        Thread alert2  = new Thread((Runnable) hilo2);
        Thread alert3  = new Thread((Runnable) hilo3);
        Thread alert4  = new Thread((Runnable) hilo4);  
        Thread alert5  = new Thread((Runnable) hilo5);
        es.execute(alert1);
        es.execute(alert2);
        es.execute(alert3);
        es.execute(alert4);
        es.execute(alert5);
        es.shutdown(); 
        if(es.awaitTermination(RUN_OUT_TIME, TimeUnit.MINUTES)){ 
            System.out.println("Cerrando conexion porque ya paso el tiempo de espera definido. Min =  " + 1);
        } 
    }
    
    @Override //METODO QUE SE IMPLEMENTO DE LA INTERFAZ
    public void notifyMainThread(int hiloID) {
        System.out.println("HILO: " + hiloID + " NOTIFICA!");    
    }

}
