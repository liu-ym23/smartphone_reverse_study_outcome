package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f11588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f11590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11594g;

    public b(View r2) {
        this.f11593f = true;
        this.f11594g = true;
        this.f11588a = r2;
    }

    void a() {
        View r0 = this.f11588a;
        ViewCompat.offsetTopAndBottom(r0, this.f11591d - (r0.getTop() - this.f11589b));
        View r1 = this.f11588a;
        ViewCompat.offsetLeftAndRight(r1, this.f11592e - (r1.getLeft() - this.f11590c));
    }

    public int b() {
        return this.f11591d;
    }

    void c() {
        this.f11589b = this.f11588a.getTop();
        this.f11590c = this.f11588a.getLeft();
    }

    public boolean d(int r2) {
        if (this.f11594g == true) goto L5;
        return false;
    L5:
        if (this.f11592e == r2) goto L10;
        this.f11592e = r2;
        a();
        return true;
    L10:
        return false;
    }

    public boolean e(int r2) {
        if (this.f11593f == true) goto L5;
        return false;
    L5:
        if (this.f11591d == r2) goto L10;
        this.f11591d = r2;
        a();
        return true;
    L10:
        return false;
    }
}
