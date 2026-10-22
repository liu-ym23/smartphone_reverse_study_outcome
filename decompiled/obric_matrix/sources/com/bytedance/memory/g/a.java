package com.bytedance.memory.g;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f5025h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f5026i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f5027j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f5028k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f5029l = null;
    public static final a m = null;
    public static final a n = null;
    public static final a o = null;
    public static final a p = null;
    private static Map<Integer, a> q;
    private static final /* synthetic */ a[] r = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5031g;

    static {
        int r2 = 0;
        a r0 = new a("OBJECT", 0, 2, 0);
        f5025h = r0;
        a r1 = new a("BOOLEAN", 1, 4, 1);
        f5026i = r1;
        a r4 = new a("CHAR", 2, 5, 2);
        f5027j = r4;
        a r7 = new a("FLOAT", 3, 6, 4);
        f5028k = r7;
        a r9 = new a("DOUBLE", 4, 7, 8);
        f5029l = r9;
        a r12 = new a("BYTE", 5, 8, 1);
        m = r12;
        a r15 = new a("SHORT", 6, 9, 2);
        n = r15;
        a r8 = new a("INT", 7, 10, 4);
        o = r8;
        a r3 = new a("LONG", 8, 11, 8);
        p = r3;
        r = new a[]{r0, r1, r4, r7, r9, r12, r15, r8, r3};
        q = new HashMap();
        a[] r5 = values();
        int r6 = r5.length;
    L3:
        if (r2 >= r6) goto L5;
        a r10 = r5[r2];
        q.put(Integer.valueOf(r10.f5030f), r10);
        r2 = r2 + 1;
        goto L3
    }

    private a(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.f5030f = r3;
        this.f5031g = r4;
    }

    public static a b(int r1) {
        return q.get(Integer.valueOf(r1));
    }

    public static a valueOf(String r1) {
        return (a) Enum.valueOf(a.class, r1);
    }

    public static a[] values() {
        return (a[]) r.clone();
    }

    public int a(int r1) {
        int r0 = this.f5031g;
        if (r0 != 0) goto L5;
        return r1;
    L5:
        return r0;
    }
}
