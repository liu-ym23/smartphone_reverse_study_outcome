package com.obric.oui.calendar;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class g extends AppCompatCheckedTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CalendarDay f10894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable f10896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Drawable f10897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f10898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.obric.oui.calendar.v.e f10899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.obric.oui.calendar.v.e f10900l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private final Rect q;
    private final Rect r;

    public g(Context r2, CalendarDay r3) {
        super(r2);
        this.f10895g = -7829368;
        this.f10896h = null;
        com.obric.oui.calendar.v.e r4 = com.obric.oui.calendar.v.e.f10929a;
        this.f10899k = r4;
        this.f10900l = r4;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = 4;
        this.q = new Rect();
        this.r = new Rect();
        o(this.f10895g);
        setGravity(17);
        setTextAlignment(4);
        k(r3);
    }

    private void b(int r4, int r5) {
        int r0 = Math.min(r5, r4);
        int r1 = Math.abs(r5 - r4) / 2;
        if (r4 < r5) goto L5;
        int r2 = r0 + r1;
        this.q.set(r1, 0, r2, r5);
        this.r.set(r1, 0, r2, r5);
        return;
    L5:
        int r3 = r0 + r1;
        this.q.set(0, r1, r4, r3);
        this.r.set(0, r1, r4, r3);
    }

    private static Drawable c(int r5, int r6, Rect r7) {
        StateListDrawable r0 = new StateListDrawable();
        r0.setExitFadeDuration(r6);
        r0.addState(new int[]{R.attr.state_checked}, d(r5));
        int[] r8 = new int[1];
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r8[0] = 16842919;
        r0.addState(r8, e(r5, r7));
    L6:
        r0.addState(new int[0], d(0));
        return r0;
    L5:
        r8[0] = 16842919;
        r0.addState(r8, d(r5));
        goto L6
    }

    private static Drawable d(int r2) {
        ShapeDrawable r0 = new ShapeDrawable(new OvalShape());
        r0.getPaint().setColor(r2);
        return r0;
    }

    private static Drawable e(int r2, Rect r3) {
        return new RippleDrawable(ColorStateList.valueOf(r2), null, d(-1));
    }

    private void i() {
        Drawable r0 = this.f10897i;
        if (r0 != null) goto L6;
        r0 = c(this.f10895g, 50, this.r);
        this.f10898j = r0;
    L6:
        setBackgroundDrawable(r0);
    }

    private void n() {
        int r2 = 0;
        if (this.n == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.m == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        super.setEnabled(r3);
        boolean r4 = MaterialCalendarView.K(this.p);
        if (MaterialCalendarView.L(this.p) == true) goto L21;
        if (r4 == true) goto L21;
        boolean r5 = false;
    L22:
        boolean r6 = MaterialCalendarView.J(this.p);
        boolean r7 = this.n;
        if (r7 == true) goto L26;
        if (r4 == false) goto L26;
        r0 = true;
    L26:
        boolean r8 = this.m;
        if (r8 == true) goto L31;
        if (r5 == false) goto L31;
        r0 = r0 | r7;
    L31:
        if (this.o == false) goto L38;
        if (r6 == false) goto L38;
        if (r7 == false) goto L36;
        if (r8 == false) goto L36;
        boolean r9 = true;
    L37:
        r0 = r0 | r9;
    L36:
        r9 = false;
    L38:
        if (r7 == true) goto L41;
        if (r0 == false) goto L41;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L41:
        if (r0 == true) goto L44;
        r2 = 4;
    L44:
        setVisibility(r2);
        return;
    L21:
        r5 = true;
        goto L22
    L13:
        if (this.o == true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (this.m == false) goto L9;
        if (this.o == true) goto L9;
        r0 = true;
        goto L11
    }

    void a(i r7) {
        this.o = r7.b();
        n();
        j(r7.c());
        p(r7.d());
        List<i.a> r8 = r7.e();
        if (r8.isEmpty() == true) goto L9;
        String r0 = h();
        SpannableString r1 = new SpannableString(h());
        Iterator<i.a> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r1.setSpan(r9.next().f10906a, 0, r0.length(), 33);
        goto L6
    L8:
        setText(r1);
        return;
    L9:
        setText(h());
    }

    @NonNull
    public String f() {
        com.obric.oui.calendar.v.e r0 = this.f10900l;
        if (r0 != null) goto L6;
        r0 = this.f10899k;
    L6:
        return r0.a(this.f10894f);
    }

    public CalendarDay g() {
        return this.f10894f;
    }

    @NonNull
    public String h() {
        return this.f10899k.a(this.f10894f);
    }

    public void j(Drawable r2) {
        if (r2 != null) goto L4;
        Drawable r3 = null;
    L5:
        this.f10896h = r3;
        invalidate();
        return;
    L4:
        r3 = r2.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void k(CalendarDay r1) {
        this.f10894f = r1;
        setText(h());
    }

    public void l(com.obric.oui.calendar.v.e r8) {
        com.obric.oui.calendar.v.e r0 = this.f10900l;
        if (r0 != this.f10899k) goto L5;
        r0 = r8;
    L5:
        this.f10900l = r0;
        if (r8 != null) goto L8;
        r8 = com.obric.oui.calendar.v.e.f10929a;
    L8:
        this.f10899k = r8;
        CharSequence r9 = getText();
        Object[] r1 = null;
        if ((r9 instanceof Spanned) == false) goto L11;
        r1 = ((Spanned) r9).getSpans(0, r9.length(), Object.class);
    L11:
        SpannableString r10 = new SpannableString(h());
        if (r1 == null) goto L16;
        int r2 = r1.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L16;
        r10.setSpan(r1[r3], 0, r10.length(), 33);
        r3 = r3 + 1;
    L16:
        setText(r10);
    }

    public void m(com.obric.oui.calendar.v.e r1) {
        if (r1 != null) goto L4;
        r1 = this.f10899k;
    L4:
        this.f10900l = r1;
        setContentDescription(f());
    }

    public void o(int r1) {
        this.f10895g = r1;
        i();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas r3) {
        Drawable r0 = this.f10896h;
        if (r0 == null) goto L5;
        r0.setBounds(this.q);
        this.f10896h.setState(getDrawableState());
        this.f10896h.draw(r3);
    L5:
        this.f10898j.setBounds(this.r);
        super.onDraw(r3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        b(r4 - r2, r5 - r3);
        i();
    }

    public void p(Drawable r2) {
        if (r2 != null) goto L4;
        Drawable r3 = null;
    L5:
        this.f10897i = r3;
        i();
        return;
    L4:
        r3 = r2.getConstantState().newDrawable(getResources());
        goto L5
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        d.g.d.d.a.b(getContext(), 1);
        return r0;
    }

    protected void q(int r1, boolean r2, boolean r3) {
        this.p = r1;
        this.n = r3;
        this.m = r2;
        n();
    }
}
