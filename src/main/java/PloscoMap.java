public class PloscoMap<K,V> {
    private int size;
    final int capacity = 16;
    private final PloscoMapEntry<K,V>[] values;

    public PloscoMap() {
        values = null;
    }

    public void put(K key, V value) {
        if (!containsKey(key) && size < capacity) {
            values[size] = new PloscoMapEntry(key, value);
            size++;
        } else {
            // error? no space left
        }
    }

    public boolean containsKey(K key) {
        for (PloscoMapEntry<K,V> pair : values) {
            if(pair.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    private class PloscoMapEntry<K,V> {
        private final K key;
        private V value;

        private PloscoMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

}
