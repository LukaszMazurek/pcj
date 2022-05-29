import org.pcj.*;

import java.util.Random;


@RegisterStorage(Example2.Shared.class)
public class Example2 implements StartPoint{

    @Storage(Example2.class)
    enum Shared{
        numbers,
    }

    private int[] numbers = new int[PCJ.threadCount()];;

    public static void main(String[] args) {

        int threadsNumber = 4;
        String[] threadsDescriptions = new String[threadsNumber];

        for(int i = 0; i < threadsNumber; i++){
            threadsDescriptions[i] = "localhost";
        }

        PCJ.start(Example2.class, new NodesDescription(threadsDescriptions));
    }

    @Override
    public void main() throws Throwable {
        Random random = new Random();

        int number = random.nextInt();

        PCJ.put(number, 0, Shared.numbers, PCJ.myId());



        System.out.println(PCJ.myId());



    }
}
