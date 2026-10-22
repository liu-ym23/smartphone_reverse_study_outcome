package xn;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23184c;
    public final Bitmap.Config d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f23185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f23186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f23187j;

    public e(f r5) {
        this.f23182a = r5.f23188a;
        this.f23183b = r5.f23189b;
        this.f23185h = r5.g;
        this.f23184c = r5.f23190c;
        this.d = r5.d;
        this.f = r5.e;
        this.f23186i = r5.f;
        this.e = r5.f23193j;
        this.g = r5.f23192i;
        this.f23187j = r5.f23191h;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L36:
        return false;
    L8:
        if (e.class != r5.getClass()) goto L36;
        e r10 = (e) r5;
        if (this.f23183b == r10.f23183b) goto L14;
        return false;
    L14:
        if (this.f23184c == r10.f23184c) goto L17;
        return false;
    L17:
        if (this.e == r10.e) goto L20;
        return false;
    L20:
        if (this.f == r10.f) goto L23;
        return false;
    L23:
        if (this.g == r10.g) goto L26;
        return false;
    L26:
        if (this.f23185h == r10.f23185h) goto L29;
        return false;
    L29:
        if (Objects.equals(this.f23182a, r10.f23182a) == true) goto L32;
        return false;
    L32:
        if (this.d == r10.d) goto L35;
        return false;
    L35:
        return Objects.equals(this.f23186i, r10.f23186i);
    }

    public final int hashCode() {
        int r5 = 0;
        String r10 = this.f23182a;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L6:
        int r12 = ((((r11 * 31) + this.f23183b) * 31) + this.f23184c) * 31;
        Bitmap.Config r13 = this.d;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (((((((((r12 + r14) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.f23185h ? 1 : 0)) * 31;
        ArrayList r16 = this.f23186i;
        if (r16 == null) goto L14;
        r5 = r16.hashCode();
    L14:
        return r15 + r5;
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }
}
