import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.time.LocalTime;

public class ASIM extends UnicastRemoteObject implements ASI {
    private LocalTime currentTime;
    public ASIM (LocalTime currentTime) throws RemoteException {
        this.currentTime = currentTime;
    };
    public LocalTime getTime() throws RemoteException {
        return currentTime;
    }

    public void adjustTime(LocalTime clientTime,long timeDiff) throws RemoteException{
        long ct = clientTime.toNanoOfDay();
        long st = this.getTime().toNanoOfDay();
        long newNanos = ct - st;
        newNanos = newNanos * -1 + ct + st;
        System.out.println("New Time is " + ACT.formatter.format(LocalTime.ofNanoOfDay(newNanos)));
        this.currentTime = LocalTime.ofNanoOfDay(newNanos);
    } 
}
