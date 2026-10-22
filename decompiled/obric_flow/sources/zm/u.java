package zm;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23541b;

    public u(ReadableArray r5) {
        this.f23541b = (float) r5.getDouble(0);
        this.f23540a = r5.getInt(1);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L15:
        return false;
    L8:
        if (u.class != r5.getClass()) goto L15;
        u r10 = (u) r5;
        if (this.f23541b != r10.f23541b) goto L15;
        if (this.f23540a != r10.f23540a) goto L15;
        return true;
    }

    public final int hashCode() {
        int r5 = this.f23540a * 31;
        return Float.floatToIntBits(this.f23541b) + r5;
    }
}
