public class HashTable
  {
    public int size;
    public int step;
    public String [] slots; 

    public HashTable(int sz, int stp)
    {
      size = sz;
      step = stp;
      slots = new String[size];
      for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {    
        int hash = 0;
        for (int i = 0; i < value.length(); i++) {
            hash += value.charAt(i);
        }
        return hash % size;
    }

    public int seekSlot(String value)
    {
        int index = hashFun(value);
        int current = index;
        do {
            if (slots[current] == null) {
                return current;
            }
            current += step;
            if (current >= size) {
                current -= size;
            }
        } while (current != index);
        return -1;
    }

     public int put(String value)
     {
        int slot = seekSlot(value);
        if (slot == -1) {
            return -1;
        }
        slots[slot] = value;
        return slot;
       
     }

     public int find(String value)
     {
        int index = hashFun(value);
        int current = index;
        do {
            if (slots[current] == null) {
                return -1;
            }
            if (slots[current].equals(value)) {
                return current;
            }
            current += step;
            if (current >= size) {
                current -= size;
            }
        } while (current != index);
        return -1;
     }
  }