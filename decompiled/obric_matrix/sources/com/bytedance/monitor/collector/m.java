package com.bytedance.monitor.collector;

import androidx.core.app.NotificationCompat;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    static class a implements Comparator<b> {
        a() {
        }

        public int a(b r7, b r8) {
            return Long.compare(((long) (r8.f5214g + 1)) * (r8.f5217j - r8.f5216i), ((long) (r7.f5214g + 1)) * (r7.f5217j - r7.f5216i));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(b r1, b r2) {
            return a(r1, r2);
        }
    }

    static class b implements Comparable<b> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f5213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f5214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f5215h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f5216i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f5217j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f5218k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f5219l;

        public b(boolean r2, int r3, long r4, long r6, long r8, long r10) {
            this.f5213f = false;
            this.f5213f = r2;
            this.f5214g = r3;
            this.f5215h = r4;
            this.f5216i = r6;
            this.f5217j = r8;
            this.f5218k = r10;
            this.f5219l = (r8 - r6) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        }

        public int a(b r4) {
            long r0 = this.f5216i;
            long r3 = r4.f5216i;
            if (r0 <= r3) goto L7;
            return 1;
        L7:
            if (r0 != r3) goto L10;
            return 0;
        L10:
            return -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b r1) {
            return a(r1);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.f5214g);
            r0.append(",");
            if (this.f5213f == false) goto L5;
            String r2 = NotificationCompat.CATEGORY_SYSTEM;
        L6:
            r0.append(r2);
            r0.append(",");
            r0.append(this.f5215h);
            r0.append(",");
            r0.append(this.f5216i);
            r0.append(",");
            r0.append(this.f5217j);
            r0.append(",");
            r0.append(this.f5218k);
            return r0.toString();
        L5:
            r2 = "app";
            goto L6
        }
    }

    public static String a(List<b> r8, long r9) {
        StringBuilder r0 = new StringBuilder();
        long r10 = (long) (r9 * 0.3f);
        LinkedList r1 = new LinkedList();
        Iterator<b> r2 = r8.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        b r3 = r2.next();
        if ((r3.f5217j - r3.f5216i) < r10) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Collections.sort(r1, new a());
        if (r1.isEmpty() == true) goto L11;
    L13:
        Iterator r11 = r1.iterator();
        if (r11.hasNext() == false) goto L17;
        r0.append(((b) r11.next()).f5215h + "\n");
    L17:
        return r0.toString();
    L11:
        if (r8.isEmpty() == true) goto L13;
        r1.add(r8.get(0));
        goto L13
    }

    private static LinkedList<b> b(String r19) {
        LinkedList<b> r0 = new LinkedList();
        String[] r1 = r19.split("\n");
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        String[] r5 = r1[r4].split(",");
        if (r5 == null) goto L10;
        if (r5.length < 6) goto L10;
        r0.add(new b(r5[1].startsWith(NotificationCompat.CATEGORY_SYSTEM), Integer.parseInt(r5[0]), Long.parseLong(r5[2]), Long.parseLong(r5[3]), Long.parseLong(r5[4]), Long.parseLong(r5[5])));
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        Collections.sort(r0);
        return r0;
    }

    public static String c(String r5, StringBuilder r6, int r7, long r8) {
        LinkedList<b> r9 = b(r5);
    L4:
        if (r9.size() <= r7) goto L11;
        long r0 = 21;
        Iterator<b> r2 = r9.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        if (r2.next().f5219l >= r0) goto L7;
        r2.remove();
        goto L7
    L11:
        Iterator<b> r10 = r9.iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        r6.append(r10.next().toString());
        r6.append('\n');
        goto L13
    L16:
        if (r9.size() != 0) goto L20;
        return null;
    L20:
        return a(r9, r8);
    }
}
