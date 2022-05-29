import org.pcj.*;


@RegisterStorage(Example3.Shared.class)
public class Example3 implements StartPoint{

    @Storage(Example3.class)
    enum Shared{
        numbers,
    }

    private int[] numbers = new int[PCJ.threadCount()];;

    public static void main(String[] args) {

        int threadsNumberPerNode = 8;
        String[] threadsDescriptions = new String[threadsNumberPerNode * 2];

        for(int i = 0; i < threadsNumberPerNode; i++){
            threadsDescriptions[i] = "localhost";
        }

        for(int i = 0; i < threadsNumberPerNode; i++){
            threadsDescriptions[i + threadsNumberPerNode] = "localhost:8090";
        }

        PCJ.deploy(Example3.class, new NodesDescription(threadsDescriptions));
    }

    @Override
    public void main() throws Throwable {

        PCJ.barrier();
        for(int i = 0; i < PCJ.threadCount(); i++){
            if(i == PCJ.myId()){
                System.out.println(PCJ.myId());
            }
            PCJ.barrier();
        }
    }
}
