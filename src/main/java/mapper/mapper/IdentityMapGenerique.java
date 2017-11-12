package mapper.mapper;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by vantorre on 12/11/17.
 */
public class IdentityMapGenerique<K,V> {
    HashMap<K,WeakReference<V>> identityMap;
    IdentityMapGenerique (){
        identityMap = new HashMap<K, WeakReference<V>>();
    }
    public void put(K key, V value) {
        if(!identityMap.containsKey(key)){
            identityMap.put(key,new WeakReference<V>(value));
        }
    }
    public V get(K key) {
        if(identityMap.containsKey(key)){
            return identityMap.get(key).get();
        }else{
            return null;
        }
    }
    public void del(K key) {
        if(identityMap.containsKey(key)){
            identityMap.remove(key);
        }
    }
}
