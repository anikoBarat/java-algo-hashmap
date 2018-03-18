import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    private HashMap hm;

    @BeforeEach
    void init(){
        hm = new HashMap();
        hm.add("Alma", 10);
        hm.add("Körte", 20);
        hm.add("Narancs", 30);
    }

    @Test
    void testAddMethod(){
        assertTrue(hm.getValue("Alma").equals(10) && hm.getValue("Körte").equals(20) &&
        hm.getValue("Narancs").equals(30));
    }

    @Test
    void testThrowExceptionWhenAlreadyExistingKeyAdded(){
        assertThrows(IllegalArgumentException.class, ()->{hm.add("Alma", 10);});
    }

    @Test
    void testGetValueMethod(){
        assertEquals(10, (int) hm.getValue("Alma"));
        assertEquals(20, (int) hm.getValue("Körte"));
        assertEquals(30, (int) hm.getValue("Narancs"));
    }

    @Test
    void testRemoveMethod(){
        hm.remove("Alma");
        assertThrows(IllegalArgumentException.class, ()->{hm.getValue("Alma");});
    }

    @Test
    void testClearAll(){
        hm.clearAll();
        assertThrows(IllegalArgumentException.class, ()->{hm.getValue("Alma");});
        assertThrows(IllegalArgumentException.class, ()->{hm.getValue("Körte");});
        assertThrows(IllegalArgumentException.class, ()->{hm.getValue("Narancs");});
    }
}