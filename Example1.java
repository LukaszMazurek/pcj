
import org.pcj.NodesDescription;
import org.pcj.PCJ;
import org.pcj.StartPoint;

public class Example1 implements StartPoint {
    public static void main(String[] args) {
        PCJ.start(Example1.class, new NodesDescription(new String[] {
                "localhost",
        }));
    }

    @Override
    public void main() throws Throwable {
        System.out.println("Hello world");
    }
}

