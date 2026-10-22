package z;

import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class f implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CachedHashCodeArrayMap f23357b;

    public f() {
        this.f23357b = new CachedHashCodeArrayMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // z.c
    public final void b(MessageDigest r10) {
        int r5 = 0;
    L4:
        if (r5 >= this.f23357b.size()) goto L9;
        e r11 = (e) this.f23357b.keyAt(r5);
        Object r12 = this.f23357b.valueAt(r5);
        d r13 = r11.f23355b;
        if (r11.d != null) goto L8;
        r11.d = r11.f23356c.getBytes(c.f23353a);
    L8:
        r13.a(r11.d, r12, r10);
        r5 = r5 + 1;
        goto L4
    }

    public final Object c(e r5) {
        CachedHashCodeArrayMap r10 = this.f23357b;
        if (r10.containsKey(r5) == false) goto L6;
        return r10.get(r5);
    L6:
        return r5.f23354a;
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof f) == true) goto L5;
        return false;
    L5:
        return this.f23357b.equals(((f) r5).f23357b);
    }

    @Override // z.c
    public final int hashCode() {
        return this.f23357b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f23357b + '}';
    }
}
