/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Kasir;
import domain.Racun;
import domain.StavkaRacuna;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controller;
import server.Server;

/**
 *
 * @author Djapac
 */
public class ClientThread extends Thread{
    
    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private Server server;
    private boolean kraj=false;
    private Kasir kasir;
    
    
    public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
    }

    @Override
    public void run() {
        
        while(!kraj){
            
            try {
                Request request = (Request) receiver.receive();
                System.out.println("Server primio zahtev");
                Response response = new Response();
                
              try {
                  
                  switch(request.getOperation()){
                      
                     case LOGIN:
                           Kasir kasir = (Kasir) request.getArgument();
                           kasir = controller.login(kasir);  
                            if (server.notLogin(kasir) ) {
                                response.setResult(kasir);
                                this.kasir = kasir;          
                            } else {
                                throw new Exception("Zaposleni je već prijavljen.");
                            }
                            break;
                     case KREIRAJ_RACUN:
                         Racun racun = (Racun) request.getArgument();
                         controller.createBill(racun);
                         response.setResult(racun);
                         break;
                     case PRIKAZI_RACUNE:
                         Kasir kasirPrikaz = (Kasir) request.getArgument();
                         response.setResult(controller.getAllBills(kasirPrikaz));
                         break;
                     case PRETRAZI_STAVKE:
                            StavkaRacuna sr = (StavkaRacuna) request.getArgument();
                            response.setResult(controller.searchBillItems(sr));
                            break;
                     case IZMENI_RACUN:
                         Racun racunZaIzmenu = (Racun) request.getArgument();
                         controller.updateBill(racunZaIzmenu);
                         response.setResult(racunZaIzmenu);
                         break;
                      
                      
                  }
                  
              } catch(Exception e){
                  e.printStackTrace();
                  response.setException(e);
              }
                
                sender.send(response);
                
            } catch (Exception ex) {
                 ex.printStackTrace();
            }
            
            
        }
        
    }
    
     public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Kasir getZaposleni() {
        return kasir;
    }

    public void setZaposleni(Kasir zaposleni) {
        this.kasir = zaposleni;
    }
    
    
    
}
