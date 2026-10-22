package com.ss.android.l.a;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Float> f12007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12008d;

    public void a(Map<String, Float> r4) {
        if (r4 == null) goto L15;
        Map<String, Float> r3 = this.f12007c;
        if (r3 == null) goto L21;
        Iterator<Map.Entry<String, Float>> r5 = r3.entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L22;
        Map.Entry<String, Float> r0 = r5.next();
        if (r0 == null) goto L8;
        float r1 = r0.getValue().floatValue();
        Float r2 = r4.get(r0.getKey());
        if (r2 == null) goto L14;
        r1 = r1 + r2.floatValue();
    L14:
        r4.put(r0.getKey(), Float.valueOf(r1));
        goto L8
    L22:
        return;
    L21:
        return;
    }

    public String toString() {
        return "{" + this.f12005a + ", " + this.f12006b + ", " + this.f12007c + ", " + this.f12008d + "}";
    }
}
