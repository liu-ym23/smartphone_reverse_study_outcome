package com.obric.oui.titlebar.behavior;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
class ViewOffsetHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f309a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f310d;

    public ViewOffsetHelper(View r1) {
        this.f309a = r1;
    }

    public final void a() {
        int r0 = this.f310d;
        View r1 = this.f309a;
        ViewCompat.offsetTopAndBottom(r1, r0 - (r1.getTop() - this.b));
        ViewCompat.offsetLeftAndRight(r1, 0 - (r1.getLeft() - this.c));
    }
}
