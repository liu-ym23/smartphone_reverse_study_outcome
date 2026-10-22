package d.a.a.j;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f12513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12516d;

    public w(w r1, Object r2, Object r3, int r4) {
        this.f12513a = r1;
        this.f12514b = r2;
        this.f12515c = r3;
        this.f12516d = r4;
    }

    public String toString() {
        if (this.f12513a != null) goto L7;
        return "$";
    L7:
        if ((this.f12515c instanceof Integer) == false) goto L11;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f12513a.toString());
        r0.append("[");
        r0.append(this.f12515c);
        r0.append("]");
    L10:
        return r0.toString();
    L11:
        r0 = new StringBuilder();
        r0.append(this.f12513a.toString());
        r0.append(".");
        r0.append(this.f12515c);
        goto L10
    }
}
