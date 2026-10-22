package com.obric.oui.calendar;

import android.R;
import android.animation.Animator;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f10912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private com.obric.oui.calendar.v.g f10913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator f10917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10918g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10919h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CalendarDay f10920i;

    class a extends com.obric.oui.calendar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f10921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f10923c;

        a(s r1, CharSequence r2, int r3) {
            this.f10923c = r1;
            this.f10921a = r2;
            this.f10922b = r3;
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            s r4 = this.f10923c;
            s.b(r4, s.a(r4), 0);
            s.a(this.f10923c).setAlpha(1.0f);
        }

        @Override // com.obric.oui.calendar.a, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            s.a(this.f10923c).setText(this.f10921a);
            s r5 = this.f10923c;
            s.b(r5, s.a(r5), this.f10922b);
            ViewPropertyAnimator r6 = s.a(this.f10923c).animate();
            if (s.c(this.f10923c) != 1) goto L5;
            r6.translationX(0.0f);
        L6:
            r6.alpha(1.0f).setDuration(s.e(this.f10923c)).setInterpolator(s.d(this.f10923c)).setListener(new com.obric.oui.calendar.a()).start();
            return;
        L5:
            r6.translationY(0.0f);
            goto L6
        }
    }

    public s(TextView r3) {
        this.f10913b = com.obric.oui.calendar.v.g.f10931a;
        this.f10917f = new DecelerateInterpolator(2.0f);
        this.f10918g = 0;
        this.f10919h = 0;
        this.f10920i = null;
        this.f10912a = r3;
        Resources r4 = r3.getResources();
        this.f10914c = 400;
        this.f10915d = r4.getInteger(R.integer.config_shortAnimTime) / 2;
        this.f10916e = (int) TypedValue.applyDimension(1, 20.0f, r4.getDisplayMetrics());
    }

    static /* synthetic */ TextView a(s r0) {
        return r0.f10912a;
    }

    static /* synthetic */ void b(s r0, TextView r1, int r2) {
        r0.h(r1, r2);
    }

    static /* synthetic */ int c(s r0) {
        return r0.f10918g;
    }

    static /* synthetic */ Interpolator d(s r0) {
        return r0.f10917f;
    }

    static /* synthetic */ int e(s r0) {
        return r0.f10915d;
    }

    private void g(long r3, CalendarDay r5, boolean r6) {
        this.f10912a.animate().cancel();
        h(this.f10912a, 0);
        this.f10912a.setAlpha(1.0f);
        this.f10919h = r3;
        CharSequence r4 = this.f10913b.a(r5);
        if (r6 == true) goto L5;
        this.f10912a.setText(r4);
    L14:
        this.f10920i = r5;
        return;
    L5:
        int r7 = this.f10916e;
        if (this.f10920i.l(r5) == false) goto L8;
        int r8 = 1;
    L9:
        int r9 = r7 * r8;
        ViewPropertyAnimator r10 = this.f10912a.animate();
        if (this.f10918g != 1) goto L12;
        r10.translationX(r9 * (-1));
    L13:
        r10.alpha(0.0f).setDuration(this.f10915d).setInterpolator(this.f10917f).setListener(new a(this, r4, r9)).start();
        goto L14
    L12:
        r10.translationY(r9 * (-1));
        goto L13
    L8:
        r8 = -1;
        goto L9
    }

    private void h(TextView r2, int r3) {
        if (this.f10918g != 1) goto L5;
        r2.setTranslationX(r3);
        return;
    L5:
        r2.setTranslationY(r3);
    }

    public void f(CalendarDay r7) {
        long r0 = System.currentTimeMillis();
        if (r7 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f10912a.getText()) == false) goto L8;
    L9:
        g(r0, r7, false);
    L11:
        if (r7.equals(this.f10920i) == false) goto L13;
        return;
    L13:
        if (r7.g() == this.f10920i.g()) goto L15;
    L17:
        g(r0, r7, true);
        return;
    L15:
        if (r7.h() != this.f10920i.h()) goto L17;
        return;
    L8:
        if ((r0 - this.f10919h) >= this.f10914c) goto L11;
        goto L9
    }

    public int i() {
        return this.f10918g;
    }

    public void j(int r1) {
        this.f10918g = r1;
    }

    public void k(CalendarDay r1) {
        this.f10920i = r1;
    }

    public void l(@Nullable com.obric.oui.calendar.v.g r1) {
        if (r1 != null) goto L4;
        r1 = com.obric.oui.calendar.v.g.f10931a;
    L4:
        this.f10913b = r1;
    }
}
