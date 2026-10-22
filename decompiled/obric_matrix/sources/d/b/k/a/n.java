package d.b.k.a;

import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14014b;

    public n(int r1, int r2) {
        this.f14013a = r1;
        this.f14014b = r2;
    }

    public String toString() {
        return String.format(Locale.US, "image width=%d, height=%d", new Object[]{Integer.valueOf(this.f14013a), Integer.valueOf(this.f14014b)});
    }
}
