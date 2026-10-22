package com.android.settings.utils;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ListUtils {
    public ListUtils() {
    }

    public static <T> void deDup(List<T> r3, List<T> r4) {
        if (isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (isEmpty(r4) == true) goto L17;
        int r0 = r4.size() - 1;
    L8:
        if (r0 < 0) goto L18;
        T r1 = r4.get(r0);
        if (isContain(r3, r1) == false) goto L12;
        r4.remove(r1);
    L12:
        r0 = r0 - 1;
        goto L8
    L18:
        return;
    }

    public static <T> boolean isContain(List<T> r2, T r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (isEmpty(r2) == true) goto L24;
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L25;
        T r1 = r4.next();
        if (r1 == null) goto L9;
        if (r3.equals(r1) == false) goto L9;
        return true;
    L25:
        return false;
    L24:
        return false;
    }

    public static <T> void addAll(List<T> r1, List<T> r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (isEmpty(r2) == true) goto L9;
        r1.addAll(r2);
        return;
    }

    public static boolean isEmpty(List r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isIndexInvalid(List r0, int r1) {
        if (r0 == null) goto L8;
        if (r1 < 0) goto L8;
        if (r1 >= r0.size()) goto L8;
        return false;
    L8:
        return true;
    }
}
