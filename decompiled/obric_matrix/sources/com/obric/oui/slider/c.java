package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.RequiresApi;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11423c = "SeekBarVibrateHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f11424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11425b;

    static {
    }

    public c() {
        this.f11425b = Integer.MAX_VALUE;
    }

    private final void b(Context r4, int r5, String r6, boolean r7, View r8) {
        if (this.f11425b >= 2) goto L10;
        d.g.d.f.f.b.a(f11423c, "vibrateIfNeeded: " + r6);
        if (r7 == false) goto L7;
        d.g.d.d.a.b(r4, r5);
    L8:
        this.f11425b++;
        return;
    L7:
        d.g.d.d.a.f16932c.a(r8, r5);
        goto L8
    }

    static /* synthetic */ void c(c r6, Context r7, int r8, String r9, boolean r10, View r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = true;
    L5:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = null;
    L8:
        r6.b(r7, r8, r9, r4, r11);
    }

    @RequiresApi(26)
    public final void a(Context r11, SeekBar r12, int r13, boolean r14, int r15, boolean r16) {
        o.f(r11, "context");
        o.f(r12, "seekBar");
        if (r14 == false) goto L5;
        this.f11425b = 0;
    L5:
        int r0 = r12.getMin();
        int r2 = r12.getMax();
        if (r13 != r0) goto L9;
        int r3 = 5;
        boolean r4 = false;
        View r5 = null;
        int r7 = 24;
        Object r8 = null;
        String r6 = "hit minProgress";
    L8:
        c(this, r11, r3, r6, r4, r5, r7, r8);
        return;
    L9:
        if (r13 != r2) goto L11;
        r3 = 4;
        r4 = false;
        r5 = null;
        r7 = 24;
        r8 = null;
        r6 = "hit maxProgress";
        goto L8
    L11:
        int r9 = 1;
        int r10 = r15 - 1;
        if (r16 == false) goto L34;
        if (r10 > 1) goto L15;
        return;
    L15:
        if (this.f11424a == null) goto L26;
        float r17 = (r2 - r0) / r10;
    L17:
        if (r9 >= r10) goto L26;
        int r18 = kotlin.o0.a.a(r9 * r17) + r0;
        Integer r19 = this.f11424a;
        o.c(r19);
        if (r19.intValue() >= r18) goto L21;
        if (r13 < r18) goto L21;
    L24:
        b(r11, 26, "passed boundary: " + r9 + '/' + r10 + ", progress: " + r13, false, r12);
    L21:
        Integer r20 = this.f11424a;
        o.c(r20);
        if (r20.intValue() <= r18) goto L25;
        if (r13 <= r18) goto L24;
    L25:
        r9 = r9 + 1;
    L26:
        this.f11424a = Integer.valueOf(r13);
        return;
    }
}
