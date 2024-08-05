/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Kasir;
import domain.Racun;
import domain.StavkaRacuna;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class Controller {
    
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;
    private List<Kasir> listaPrijavljenih;
    
    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
        listaPrijavljenih = new ArrayList<>();
    }

    public static Controller getInstance() throws Exception{
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public Kasir login(Kasir kasir) throws Exception{
       
        Request request = new Request(Operation.LOGIN, kasir);
        sender.send(request);
        System.out.println("Poslao zahtev");
        Response response = (Response) receiver.receive();
        System.out.println("Primio zahtev");
        if (response.getException() == null) {
            Kasir prijavljen = (Kasir) response.getResult();
            listaPrijavljenih.add(prijavljen);
            return (Kasir) response.getResult();
            
        } else {
            throw response.getException();
        }
    }

    public List<Kasir> getListaPrijavljenih() {
        return listaPrijavljenih;
    }

    public void createBill(Racun racun) throws Exception {
        Request request = new Request(Operation.KREIRAJ_RACUN, racun);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            racun.setRacunID(((Racun)response.getResult()).getRacunID());
           
        } else {
            throw response.getException();
        }
    }

    public List<Racun> getAllBills(Kasir kasir) throws Exception {
        Request request = new Request(Operation.PRIKAZI_RACUNE, kasir);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List <Racun>) response.getResult();
        } else {
            throw response.getException();
        }
    }
    
    public List<StavkaRacuna> findBillItems(StavkaRacuna r) throws Exception{
        Request request = new Request(Operation.PRETRAZI_STAVKE, r);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<StavkaRacuna>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void updateBill(Racun racun) throws Exception {
        Request request = new Request(Operation.IZMENI_RACUN, racun);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            racun.setRacunID(((Racun) response.getResult()).getRacunID());
        } else {
            throw response.getException();
        }
    }
    
    
    
    
}
