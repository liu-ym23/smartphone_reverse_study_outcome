package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.obric.common.oui.j;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f11249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11251e;

    private b(Context r1, boolean r2, int r3) {
        this.f11249c = r1;
        this.f11250d = r2;
        this.f11251e = r3;
        this.f11248b = true;
    }

    /* synthetic */ b(Context r2, boolean r3, int r4, int r5, g r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r2, r3, r4);
    }

    public static /* synthetic */ Context b(b r0, Context r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = r0.f11250d;
    L7:
        return r0.a(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateThemedContext");
    }

    protected final Context a(Context r2, boolean r3) {
        o.f(r2, "baseContext");
        if (this.f11251e != 0) goto L10;
        if (r3 == false) goto L7;
        ContextThemeWrapper r4 = new ContextThemeWrapper(r2, j.f8280e);
    L8:
        this.f11247a = r4;
        return r4;
    L7:
        r4 = new ContextThemeWrapper(r2, j.f8279d);
        goto L8
    L10:
        return new ContextThemeWrapper(r2, this.f11251e);
    }

    public final boolean c() {
        return this.f11248b;
    }

    public final Context d() {
        Context r0 = this.f11247a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return b(this, this.f11249c, false, 2, null);
    }

    public abstract View e();
}
