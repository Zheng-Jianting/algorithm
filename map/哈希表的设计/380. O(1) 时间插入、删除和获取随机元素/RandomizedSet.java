import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// 哈希表插入 删除 查找的时间复杂度都是 O(1), 但不能保证随机访问得到的值的概率都一致
public class RandomizedSet {
    private List<Integer> arrayList;
    private Map<Integer, Integer> valToIndex; // key: arrayList 中的元素, value: 该元素在 arrayList 中的索引
    
    public RandomizedSet() {
        arrayList = new ArrayList<>();
        valToIndex = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)) {
            return false;
        }
        arrayList.set(valToIndex.get(val), arrayList.get(arrayList.size() - 1)); // 要删除的值用 arrayList 末尾的值替换
        valToIndex.replace(arrayList.get(arrayList.size() - 1), valToIndex.get(val)); // 更新 arrayList 末尾的值对应的索引

        arrayList.remove(arrayList.size() - 1);
        valToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(arrayList.size());
        return arrayList.get(index);
    }
}