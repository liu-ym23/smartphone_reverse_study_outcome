package z;

import ai.j0;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final sj.e e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f23354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f23355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23356c;
    public volatile byte[] d;

    static {
        e = new sj.e();
    }

    public e(String r5, Object r10, d r11) {
        if (TextUtils.isEmpty(r5) == true) goto L7;
        this.f23356c = r5;
        this.f23354a = r10;
        this.f23355b = r11;
        return;
    L7:
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static e a(Object r5, String r10) {
        return new e(r10, r5, e);
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof e) == true) goto L5;
        return false;
    L5:
        return this.f23356c.equals(((e) r5).f23356c);
    }

    public final int hashCode() {
        return this.f23356c.hashCode();
    }

    public final String toString() {
        return j0.q(new StringBuilder("Option{key='"), this.f23356c, "'}");
    }
}
