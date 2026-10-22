package d.b.h.a.a.k;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f13795a;

    public a(String[] r1) {
        this.f13795a = r1;
    }

    public String[] a() {
        return this.f13795a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (a.class == r3.getClass()) goto L10;
        return false;
    L10:
        return Arrays.equals(this.f13795a, ((a) r3).f13795a);
    }
}
