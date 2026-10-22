package p000j.k0.i;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f18076b;

    public m() {
        this.f18076b = new int[10];
    }

    void a() {
        this.f18075a = 0;
        Arrays.fill(this.f18076b, 0);
    }

    int b(int r1) {
        return this.f18076b[r1];
    }

    int c() {
        if ((this.f18075a & 2) != 0) goto L7;
        return -1;
    L7:
        return this.f18076b[1];
    }

    int d() {
        if ((this.f18075a & 128) != 0) goto L7;
        return SupportMenu.USER_MASK;
    L7:
        return this.f18076b[7];
    }

    int e(int r2) {
        if ((this.f18075a & 16) != 0) goto L5;
        return r2;
    L5:
        return this.f18076b[4];
    }

    int f(int r2) {
        if ((this.f18075a & 32) != 0) goto L5;
        return r2;
    L5:
        return this.f18076b[5];
    }

    boolean g(int r2) {
        int r1 = this.f18075a;
        if ((r1 & (1 << r2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    void h(m r3) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L10;
        if (r3.g(r0) == false) goto L9;
        i(r0, r3.b(r0));
    L9:
        r0 = r0 + 1;
        goto L4
    }

    m i(int r4, int r5) {
        if (r4 < 0) goto L7;
        int[] r0 = this.f18076b;
        if (r4 >= r0.length) goto L7;
        this.f18075a = (1 << r4) | this.f18075a;
        r0[r4] = r5;
    L7:
        return this;
    }

    int j() {
        return Integer.bitCount(this.f18075a);
    }
}
