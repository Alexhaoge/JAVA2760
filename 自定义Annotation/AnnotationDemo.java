//https://www.cnblogs.com/gmq-sh/p/4798194.html
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})//meta-annotation
@Retention(RetentionPolicy.RUNTIME)

public @interface Describe{
    public String describe();
    @SuppressWarnings("rawtypes")
    public Class type() default void.class;
}

class test{
    @Describe(describe = "ID", type = int.class)
    int pid;
    @Describe(describe = "Name", type = String.class)
    String name;

    @Override
    @Describe(describe = "String to String", type = String.class)
    public String toString(){
        return "(pid = "+pid+","+name+")";
    }
}

public class AnnotationDemo{
    public static void main(String[] args) throws Exception{
        Class <?> c = Class.forName("test");
        Field[] f = c.getDeclaredFields();
        for(int i = 0; i<f.length; i++){
            Field ff = f[i];
            if(ff.isAnnotationPresent(Describe.class)){
                Describe da = ff.getAnnotation(Describe.class);
                System.out.println(da.describe()+":");
                System.out.println(da.type());
            }
        }
        Method m = c.getMethod("toString");
        if(m.isAnnotationPresent(Describe.class)){
            Describe da = m.getAnnotation(Describe.class);
            System.out.println(da.describe()+":");
                System.out.println(da.type());
        }
    }
}