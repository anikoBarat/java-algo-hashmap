import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class HashMap {

    /*
    Your task will be to create your own HashMap with the following requirements:

    It should have the following functions: add(key, value), getValue(key), remove(key), clearAll()
    Its keys are Strings, its values Integers.
    Its initialized with the size of 16, you don't need to resize it when it gets too big.

    Hint: You can easily convert an Object to a number between 0 and N with the following code:
    obj.GetHashCode() % N (C#), obj.hashCode() % N (Java).
    */


    private LinkedList<KeyValue>[] array;
    private final int size = 16;
    private int index;

    public HashMap(){
        array = new LinkedList[size];

        for (int i = 0; i < array.length; i++){
            array[i] = new LinkedList<>();
        }

        index = 0;
    }

    public void add(String key, Integer value){
        KeyValue kv = new KeyValue(key, value);
        index = hashFunction(key);

        for (int i = 0; i < array[index].size(); i++) {
            if(array[index].get(i).getKey().equals(kv.getKey())){
                throw new IllegalArgumentException("Key is already exists");
            }
        }
        array[index].add(kv);
    }

    public Integer getValue(String key){
        for (int i = 0; i < array[hashFunction(key)].size(); i++) {
            if(array[hashFunction(key)].get(i).getKey().equals(key)){
                return array[hashFunction(key)].get(i).getValue();
            }
        }
        throw new IllegalArgumentException("Key not found");
    }

    public void remove(String key) {
        List<KeyValue> list = array[hashFunction(key)];
        int indexInList = -1;
        Boolean found = false;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getKey().equals(key)) {
                    indexInList = i;
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new IllegalArgumentException("Key not found");
            }

            list.remove(indexInList);
    }

    public void clearAll(){
        for (int i = 0; i < array.length; i++) {
           array[i].clear();
        }
    }

    private int hashFunction(String key) {
        return abs(key.hashCode()) % size;
    }
}
