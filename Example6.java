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
            threadsDescriptions[i] = "b03.solaris:8091";
        }

        for(int i = 0; i < threadsNumberPerNode; i++){
            threadsDescriptions[i + threadsNumberPerNode] = "b04.solaris:8091";
        }

        PCJ.deploy(Example6.class, new NodesDescription(threadsDescriptions));
    }

    @Override
    public void main() {
        PCJ.barrier();
        PCJ.put(PCJ.myId(),0, Shared.sharedArray, PCJ.myId());
        PCJ.barrier();

        if (PCJ.myId() == 0){
            PCJ.broadcast(sharedArray, Shared.sharedArray);
        }
        PCJ.waitFor(Shared.sharedArray);
        System.out.println(sharedArray[PCJ.myId()]);
    }
}
