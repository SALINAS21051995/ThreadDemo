/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eztrack.demo_threadpool;

/**
 *
 * @author Carlos 
 */
public class Hilo implements Runnable {
    private long await = 0;
    private int num = 0;
    private final IListener notificador; // objeto con el que podremos llamar el metodo notifyMainThread
    
    public Hilo(long await2, int num, IListener listener){
        this.await = await2;
        this.num= num;
        this.notificador = listener; // se agrega e listener al objeto notificador
    }   
    
    @Override
    public void run(){
        try{
            System.out.println("Trabajando en el thread: " + this.num);
            Thread.sleep(this.await);
            this.notificador.notifyMainThread(this.num); // notificacion
            System.out.println("Finalizo el thread: " + this.num);
        }catch(Exception ex){
            System.out.println("TRONO ALV`");
        }
    }
}
