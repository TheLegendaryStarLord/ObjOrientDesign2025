package Problem4Reflection;



import java.lang.reflect.*;

public class Dispatcher {
    // methName = name of method to be invoked
    // args = an array of inputs for method
    
    public Object dispatch(String methName, Object... args) {
        Object result = null;
        try {
        // use reflection to call this.methName(args)
        Class<?> clazz = this.getClass();
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
             paramTypes[i] = args[i].getClass();
        }

        Method method = clazz.getMethod(methName, paramTypes);
        result = method.invoke(this, args);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}