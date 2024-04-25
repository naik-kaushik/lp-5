import java.rmi.Remote;
import java.time.LocalTime;
import java.rmi.RemoteException;

public interface ASI extends Remote{
    LocalTime getTime() throws RemoteException;
    void adjustTime(LocalTime clientTime, long timeDiff) throws RemoteException;
}
