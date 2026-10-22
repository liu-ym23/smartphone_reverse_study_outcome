package com.bytedance.monitor.collector;

import androidx.core.app.NotificationCompat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SamplingStackUtil {

    public static class MethodItem implements Comparable<MethodItem> {
        long begin;
        long cpuCost;
        int depth;
        long duration;
        long end;
        boolean isSystemMethod;
        long methodId;

        public MethodItem(boolean r1, int r2, long r3, long r5, long r7, long r9) {
            this.isSystemMethod = r1;
            this.depth = r2;
            this.methodId = r3;
            this.begin = r5;
            this.end = r7;
            this.cpuCost = r9;
            this.duration = (r7 - r5) / 1000000;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(MethodItem r1) {
            return compareTo2(r1);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.depth);
            r0.append(",");
            if (this.isSystemMethod == false) goto L5;
            String r2 = NotificationCompat.CATEGORY_SYSTEM;
        L6:
            r0.append(r2);
            r0.append(",");
            r0.append(this.methodId);
            r0.append(",");
            r0.append(this.begin);
            r0.append(",");
            r0.append(this.end);
            r0.append(",");
            r0.append(this.cpuCost);
            return r0.toString();
        L5:
            r2 = "app";
            goto L6
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(MethodItem r4) {
            long r0 = this.begin;
            long r3 = r4.begin;
            if (r0 <= r3) goto L7;
            return 1;
        L7:
            if (r0 != r3) goto L10;
            return 0;
        L10:
            return -1;
        }
    }

    public SamplingStackUtil() {
    }

    public static String getStackKey(List<MethodItem> r8, long r9) {
        StringBuilder r0 = new StringBuilder();
        long r10 = (long) (r9 * 0.3f);
        LinkedList r1 = new LinkedList();
        Iterator<MethodItem> r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        MethodItem r3 = r2.next();
        if ((r3.end - r3.begin) < r10) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Collections.sort(r1, new AnonymousClass1());
        if (r1.isEmpty() == true) goto L11;
    L13:
        Iterator r11 = r1.iterator();
        if (r11.hasNext() == false) goto L17;
        r0.append(((MethodItem) r11.next()).methodId + "\n");
    L17:
        return r0.toString();
    L11:
        if (r8.isEmpty() == true) goto L13;
        r1.add(r8.get(0));
        goto L13
    }

    public static String getStackString(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Iterator<MethodItem> r3 = sortStack(r2).iterator();
        StringBuilder r0 = new StringBuilder();
    L7:
        if (r3.hasNext() == false) goto L10;
        r0.append(r3.next().toString());
        r0.append('\n');
        goto L7
    L10:
        return r0.toString();
    }

    private static LinkedList<MethodItem> sortStack(String r19) {
        LinkedList<MethodItem> r0 = new LinkedList();
        String[] r1 = r19.split("\n");
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        String[] r5 = r1[r4].split(",");
        if (r5 == null) goto L10;
        if (r5.length < 6) goto L10;
        r0.add(new MethodItem(r5[1].startsWith(NotificationCompat.CATEGORY_SYSTEM), Integer.parseInt(r5[0]), Long.parseLong(r5[2]), Long.parseLong(r5[3]), Long.parseLong(r5[4]), Long.parseLong(r5[5])));
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        Collections.sort(r0);
        return r0;
    }

    public static String trimStack(String r5, StringBuilder r6, int r7, long r8) {
        LinkedList<MethodItem> r9 = sortStack(r5);
    L4:
        if (r9.size() <= r7) goto L11;
        long r0 = 21;
        Iterator<MethodItem> r2 = r9.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        if (r2.next().duration >= r0) goto L7;
        r2.remove();
        goto L7
    L11:
        Iterator<MethodItem> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        r6.append(r10.next().toString());
        r6.append('\n');
        goto L13
    L16:
        if (r9.size() != 0) goto L20;
        return null;
    L20:
        return getStackKey(r9, r8);
    }
}
