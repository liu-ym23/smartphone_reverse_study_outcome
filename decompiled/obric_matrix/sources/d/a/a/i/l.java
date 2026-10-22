package d.a.a.i;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f12439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f12440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Type f12442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient String f12443e;

    public l(l r1, Object r2, Object r3) {
        this.f12440b = r1;
        this.f12439a = r2;
        this.f12441c = r3;
    }

    public String toString() {
        if (this.f12443e != null) goto L14;
        if (this.f12440b != null) goto L9;
        String r0 = "$";
    L7:
        this.f12443e = r0;
        goto L14
    L9:
        if ((this.f12441c instanceof Integer) == false) goto L11;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.f12440b.toString());
        r1.append("[");
        r1.append(this.f12441c);
        r1.append("]");
    L12:
        r0 = r1.toString();
        goto L7
    L11:
        r1 = new StringBuilder();
        r1.append(this.f12440b.toString());
        r1.append(".");
        r1.append(this.f12441c);
    L14:
        return this.f12443e;
    }
}
