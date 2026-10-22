package com.bytedance.ttnet.r;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f6572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f6580k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6581l;

    public a() {
        this.f6570a = false;
        this.f6571b = true;
        this.f6572c = null;
        this.f6573d = 10;
        this.f6574e = 3;
        this.f6575f = 3;
        this.f6576g = 10;
        this.f6577h = 3;
        this.f6578i = 3;
        this.f6579j = TypedValues.Custom.TYPE_INT;
        this.f6580k = 120;
        this.f6581l = null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(" localEnable: ");
        r0.append(this.f6570a);
        r0.append(" probeEnable: ");
        r0.append(this.f6571b);
        r0.append(" hostFilter: ");
        Map<String, Integer> r1 = this.f6572c;
        if (r1 == null) goto L5;
        int r2 = r1.size();
    L6:
        r0.append(r2);
        r0.append(" reqTo: ");
        r0.append(this.f6573d);
        r0.append("#");
        r0.append(this.f6574e);
        r0.append("#");
        r0.append(this.f6575f);
        r0.append(" reqErr: ");
        r0.append(this.f6576g);
        r0.append("#");
        r0.append(this.f6577h);
        r0.append("#");
        r0.append(this.f6578i);
        r0.append(" updateInterval: ");
        r0.append(this.f6579j);
        r0.append(" updateRandom: ");
        r0.append(this.f6580k);
        r0.append(" httpBlack: ");
        r0.append(this.f6581l);
        return r0.toString();
    L5:
        r2 = 0;
        goto L6
    }
}
