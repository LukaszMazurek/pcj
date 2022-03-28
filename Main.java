
import org.pcj.NodesDescription;
import org.pcj.PCJ;
import org.pcj.StartPoint;

public class Main implements StartPoint {
    public static void main(String[] args) {
        PCJ.start(Main.class, new NodesDescription(new String[] {
                "localhost",
        }));
    }

    @Override
    public void main() throws Throwable {
        System.out.println("Hello world");
    }
}

