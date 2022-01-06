import com.tydic.pojo.User;
import com.tydic.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");//获取beans已经进行构建
        User user= (User) context.getBean("user");
        UserT userT = (UserT) context.getBean("Tuser");
        System.out.println(user.toString());
        System.out.println(userT.toString());
    }
}
