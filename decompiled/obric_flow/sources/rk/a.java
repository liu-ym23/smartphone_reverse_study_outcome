package rk;

import java.util.Stack;
import wc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ThreadLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21780b;

    public a(int r5) {
        this.f21779a = r5;
        switch(r5) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        this.f21780b = new b();
        return;
    L6:
        f r10 = new f(15);
        new Stack();
        this.f21780b = r10;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch(this.f21779a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return (f) this.f21780b;
    L7:
        return (b) this.f21780b;
    }
}
