package mapper.objetMetier.virtualProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by vantorre on 12/11/17.
 */
public class VirtualProxyBuilder <K,V> implements InvocationHandler {

    V realObject;

    Factory<K,V> factory;

    Class iface;

    K id;

    public VirtualProxyBuilder(Class iface, Factory factory, K id){
        this.iface = iface;
        this.factory = factory;
        this.id = id;
    }

    V getProxy(){
        return (V) Proxy.newProxyInstance(iface.getClassLoader(),new Class[]{iface},this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(realObject==null){
            realObject = factory.create(id);
        }
        return method.invoke(realObject,args);
    }
}
