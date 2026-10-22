package com.loc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<i3> f7217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h3 f7218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<i3> f7219c;

    final class a implements Comparator<i3> {
        a(c2 r1) {
        }

        private static int a(i3 r0, i3 r1) {
            return r1.f7375c - r0.f7375c;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(i3 r1, i3 r2) {
            return a(r1, r2);
        }
    }

    public c2() {
        this.f7217a = new ArrayList();
        this.f7219c = new ArrayList();
    }

    private static List<i3> b(List<i3> r5) {
        ArrayList r0 = new ArrayList();
        HashMap r1 = new HashMap();
        int r2 = 0;
    L4:
        if (r2 >= r5.size()) goto L6;
        i3 r3 = r5.get(r2);
        r1.put(Integer.valueOf(r3.f7375c), r3);
        r2 = r2 + 1;
        goto L4
    L6:
        r0.addAll(r1.values());
        return r0;
    }

    private boolean c(h3 r4) {
        float r0 = r4.f7322f;
        float r1 = 10.0f;
        if (r0 <= 10.0f) goto L6;
        r1 = 200.0f;
    L9:
        if (r4.a(this.f7218b) <= r1) goto L12;
        return true;
    L12:
        return false;
    L6:
        if (r0 <= 2.0f) goto L9;
        r1 = 50.0f;
        goto L9
    }

    private static boolean d(h3 r2, long r3, long r5) {
        if (r2.f7322f < 10.0f) goto L5;
        int r4 = 2000;
    L7:
        if (r3 > 0) goto L9;
        return false;
    L9:
        if ((r5 - r3) < r4) goto L11;
        return false;
    L11:
        return true;
    L5:
        r4 = 3500;
        goto L7
    }

    private static boolean e(List<i3> r8, List<i3> r9) {
        if (r8 == null) goto L23;
        if (r9 == null) goto L23;
        int r1 = r8.size();
        int r2 = r9.size();
        int r3 = r1 + r2;
        if (r1 > r2) goto L10;
        r9 = r8;
        r8 = r9;
    L10:
        HashMap r4 = new HashMap(r8.size());
        Iterator<i3> r10 = r8.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r4.put(Long.valueOf(r10.next().f7373a), 1);
        goto L12
    L14:
        Iterator<i3> r11 = r9.iterator();
        int r12 = 0;
    L16:
        if (r11.hasNext() == false) goto L21;
        if (((Integer) r4.get(Long.valueOf(r11.next().f7373a))) == null) goto L16;
        r12 = r12 + 1;
        goto L16
    L21:
        if ((((double) r12) * 2.0d) < (((double) r3) * 0.5d)) goto L23;
        return true;
    L23:
        return false;
    }

    private List<i3> f(List<i3> r2) {
        Collections.sort(r2, new a(this));
        return r2;
    }

    private void g(List<i3> r3, List<i3> r4) {
        r3.clear();
        if (r4 == null) goto L10;
        List<i3> r5 = b(r4);
        f(r5);
        int r2 = r5.size();
        if (r2 <= 40) goto L7;
        r2 = 40;
    L7:
        int r0 = 0;
    L8:
        if (r0 >= r2) goto L12;
        r3.add(r5.get(r0));
        r0 = r0 + 1;
        goto L8
    L12:
        return;
    }

    private boolean h(h3 r2, List<i3> r3, boolean r4, long r5, long r7) {
        if (r4 == true) goto L6;
        return false;
    L6:
        if (d(r2, r5, r7) == false) goto L17;
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.size() > 0) goto L11;
        return false;
    L11:
        if (this.f7218b == null) goto L16;
        boolean r0 = c(r2);
        if (r0 == false) goto L21;
        return r0;
    L21:
        return !e(r3, this.f7217a);
    L16:
        return true;
    L17:
        return false;
    }

    final List<i3> a(h3 r1, List<i3> r2, boolean r3, long r4, long r6) {
        if (h(r1, r2, r3, r4, r6) == false) goto L6;
        g(this.f7219c, r2);
        this.f7217a.clear();
        this.f7217a.addAll(r2);
        this.f7218b = r1;
        return this.f7219c;
    L6:
        return null;
    }
}
