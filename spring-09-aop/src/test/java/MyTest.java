import com.tydic.pojo.iF1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        iF1 if1Impl = (iF1) context.getBean("if1Impl");
        if1Impl.add();
    }
}
