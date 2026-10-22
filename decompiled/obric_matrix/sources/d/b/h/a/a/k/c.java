package d.b.h.a.a.k;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f13807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f13808d;

    public c(int r1, int r2, b r3, a r4) {
        this.f13805a = r1;
        this.f13806b = r2;
        this.f13807c = r3;
        this.f13808d = r4;
    }

    public c(int r2, b r3, a r4) {
        this(r2, 0, r3, r4);
    }

    public int a() {
        return this.f13805a;
    }

    public int b() {
        return this.f13806b;
    }

    public a c() {
        return this.f13808d;
    }

    public b d() {
        return this.f13807c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L21;
        c r6 = (c) r5;
        if (this.f13805a != r6.f13805a) goto L20;
        if (this.f13806b != r6.f13806b) goto L20;
        if (Objects.equals(this.f13807c, r6.f13807c) == false) goto L20;
        if (Objects.equals(this.f13808d, r6.f13808d) == false) goto L20;
        return true;
    L20:
        return false;
    }
}
