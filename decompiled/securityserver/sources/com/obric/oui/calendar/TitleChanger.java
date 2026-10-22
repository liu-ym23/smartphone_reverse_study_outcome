package com.obric.oui.calendar;

import android.R;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.obric.oui.calendar.format.TitleFormatter;

/* JADX INFO: loaded from: classes2.dex */
class TitleChanger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f189a;
    public TitleFormatter b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f190d;
    public final int e;
    public final DecelerateInterpolator f;
    public int g;
    public long h;
    public CalendarDay i;

    public TitleChanger(TextView r3) {
        this.b = TitleFormatter.f193a;
        this.f = new DecelerateInterpolator(2.0f);
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.f189a = r3;
        Resources r4 = r3.getResources();
        this.c = 400;
        this.f190d = r4.getInteger(R.integer.config_shortAnimTime) / 2;
        this.e = (int) TypedValue.applyDimension(1, 20.0f, r4.getDisplayMetrics());
    }

    public final void a(long r5, CalendarDay r7, boolean r8) {
        TextView r0 = this.f189a;
        r0.animate().cancel();
        b(r0, 0);
        r0.setAlpha(1.0f);
        this.h = r5;
        final CharSequence r6 = this.b.a(r7);
        if (r8 == true) goto L6;
        r0.setText(r6);
    L14:
        this.i = r7;
        return;
    L6:
        if (this.i.g(r7) == false) goto L8;
        int r9 = 1;
    L9:
        final int r1 = this.e * r9;
        ViewPropertyAnimator r10 = r0.animate();
        if (this.g != 1) goto L12;
        r10.translationX(r1 * (-1));
    L13:
        r10.alpha(0.0f).setDuration(this.f190d).setInterpolator(this.f).setListener(new AnonymousClass1(this, r6, r1)).start();
        goto L14
    L12:
        r10.translationY(r1 * (-1));
        goto L13
    L8:
        r9 = -1;
        goto L9
    }

    public final void b(TextView r2, int r3) {
        if (this.g != 1) goto L5;
        r2.setTranslationX(r3);
        return;
    L5:
        r2.setTranslationY(r3);
    }

    public final void c(int r1) {
        this.g = r1;
    }
}
