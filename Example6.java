import org.pcj.*;

@RegisterStorage(Example6.Shared.class)
public class Example6 implements StartPoint {

    @Storage(Example6.class)
    enum Shared { sharedArray }
    int sharedArray[] = new int[PCJ.threadCount()];

    public static void main(String[] args) {

        int threadsNumberPerNode = 8;
        String[] threadsDescriptions = new String[threadsNumberPerNode * 2];

        for(int i = 0; i < threadsNumberPerNode; i++){
            threadsDescriptions[i] = "localhost";
        }

        for(int i = 0; i < threadsNumberPerNode; i++){
            threadsDescriptions[i + threadsNumberPerNode] = "localhost:8090";
        }

        PCJ.deploy(Example6.class, new NodesDescription(threadsDescriptions));
    }

    @Override
    public void main() {
        PCJ.barrier();
        sharedArray[PCJ.myId()] = PCJ.myId();
        PCJ.broadcast(sharedArray, Shared.sharedArray);
        PCJ.barrier();
        for(int i = 0; i < PCJ.threadCount(); i++){
            System.out.println(sharedArray);
        }
    }
}
