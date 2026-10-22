package android.app.sceneperception.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null) goto L4;
    L7:
        return true;
    L4:
        if (collection.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map != null) goto L4;
    L7:
        return true;
    L4:
        if (map.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static int size(Collection<?> collection) {
        if (collection != null) goto L5;
        return 0;
    L5:
        return collection.size();
    }

    public static int size(Map<?, ?> map) {
        if (map != null) goto L5;
        return 0;
    L5:
        return map.size();
    }

    public static <T> boolean addIgnoreNull(Collection<T> collection, T object) {
        if (collection == null) goto L7;
        if (object != null) goto L6;
        return false;
    L6:
        return collection.add(object);
    L7:
        return false;
    }

    public static boolean contains(Collection<?> collection, Object object) {
        if (isEmpty(collection) == false) goto L7;
        return false;
    L7:
        return collection.contains(object);
    }

    public static <T> T getFirst(List<T> list) {
        if (isEmpty(list) == false) goto L7;
        return null;
    L7:
        return list.get(0);
    }

    public static <T> T getLast(List<T> list) {
        if (isEmpty(list) == false) goto L7;
        return null;
    L7:
        return list.get(list.size() - 1);
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList();
        if (elements == null) goto L7;
        int r1 = elements.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        T element = elements[r2];
        list.add(element);
        r2 = r2 + 1;
    L7:
        return list;
    }

    public static <T> Collection<T> intersection(Collection<T> a, Collection<T> b) {
        ArrayList<T> result = new ArrayList();
        if (isEmpty(a) == false) goto L5;
    L15:
        return result;
    L5:
        if (isEmpty(b) == true) goto L15;
        Iterator<T> r1 = a.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        T element = r1.next();
        if (b.contains(element) == false) goto L9;
        result.add(element);
        goto L9
    L14:
        return result;
    }

    public static <T> List<T> filterNull(Collection<T> collection) {
        ArrayList<T> result = new ArrayList();
        if (isEmpty(collection) == false) goto L5;
        return result;
    L5:
        Iterator<T> r1 = collection.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        T item = r1.next();
        if (item == null) goto L7;
        result.add(item);
        goto L7
    L12:
        return result;
    }
}
