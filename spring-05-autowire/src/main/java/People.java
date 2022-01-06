import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.lang.reflect.Method;

public class People {
    private String name;
    @Resource(name="dog2")
    private Dog dog;
    //实际上”ByType“,这玩意一般“byName”也行，“byName”优先级更高；@Resouce也行，这玩意优先“byName”
    @Autowired
//    @Qualifier("cat2")
    private Cat cat;

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", dog=" + dog.shout() +
                ", cat=" + cat.shout() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }
}
