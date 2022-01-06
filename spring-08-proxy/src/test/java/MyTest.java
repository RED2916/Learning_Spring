import com.tydic.demo1.Host;
import com.tydic.demo1.ProxyInvocationHandler;
import com.tydic.demo1.Rent;

public class MyTest {
    public static void main(String[] args) {
        Host host = new Host();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(host);

        Rent rent = (Rent) pih.getProxy();
        rent.rent();
    }
}
