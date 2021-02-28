package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
    }

    /**
     * ���Ԫ��
     * 1.Ԫ�ش��ڣ��ŵ���β
     * 2.�����ڣ��ж������Ƿ�����
     * ���������ɾ������Ԫ�أ������βԪ�أ�ɾ�����¹�ϣ��
     * ��������������βԪ�أ����¹�ϣ��
     */
    public void put(Integer key, Integer value) {
        Integer v = map.get(key);
        if (v != null) {
            list.remove(key);
            list.addLast(key);
            map.put(key, value);
            return;
        }

        //����δ������ӵ�β��
        if (list.size() < capacity) {
            list.addLast(key);
            map.put(key, value);
        } else {
            //�����������Ƴ�����
            Integer firstKey = list.removeFirst();
            map.remove(firstKey);
            list.addLast(key);
            map.put(key, value);
        }
    }

    /**
     * ����Ԫ��
     * Ԫ�ش��ڣ��ŵ���β
     */
    public Integer get(Integer key) {
        Integer v = map.get(key);
        if (v != null) {
            list.remove(key);
            list.addLast(key);
            return v;
        }
        return -1;
    }

}
