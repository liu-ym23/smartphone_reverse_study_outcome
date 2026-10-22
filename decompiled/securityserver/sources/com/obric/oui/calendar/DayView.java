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
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.oui.calendar.format.DateFormatDayFormatter;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.haptic.VibratorSmt;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
class DayView extends AppCompatCheckedTextView {
    public final CalendarDay b;
    public int c;
    public Drawable e;
    public Drawable f;
    public StateListDrawable i;
    public DayFormatter j;
    public DayFormatter k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public final Rect p;
    public final Rect q;

    public DayView(Context r2, CalendarDay r3) {
        super(r2);
        this.c = -7829368;
        this.e = null;
        DateFormatDayFormatter r4 = DayFormatter.f192a;
        this.j = r4;
        this.k = r4;
        this.l = true;
        this.m = true;
        this.n = false;
        this.o = 4;
        this.p = new Rect();
        this.q = new Rect();
        this.c = this.c;
        b();
        setGravity(17);
        setTextAlignment(4);
        this.b = r3;
        setText(this.j.a(r3));
    }

    public static ShapeDrawable a(int r2) {
        ShapeDrawable r0 = new ShapeDrawable(new OvalShape());
        r0.getPaint().setColor(r2);
        return r0;
    }

    public final void b() {
        Drawable r0 = this.f;
        if (r0 == null) goto L5;
        setBackgroundDrawable(r0);
        return;
    L5:
        int r1 = this.c;
        StateListDrawable r2 = new StateListDrawable();
        r2.setExitFadeDuration(50);
        r2.addState(new int[]{R.attr.state_checked}, a(r1));
        r2.addState(new int[]{R.attr.state_pressed}, new RippleDrawable(ColorStateList.valueOf(r1), null, a(-1)));
        r2.addState(new int[0], a(0));
        this.i = r2;
        setBackgroundDrawable(r2);
    }

    public final void c() {
        int r1 = 0;
        boolean r2 = true;
        if (this.m == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.l == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        super.setEnabled(r3);
        boolean r4 = MaterialCalendarView.e(this.o);
        int r5 = this.o;
        if ((r5 & 2) != 0) goto L20;
        if (r4 == true) goto L20;
        boolean r6 = false;
    L23:
        if ((r5 & 4) == 0) goto L25;
        boolean r7 = true;
    L26:
        boolean r8 = this.m;
        if (r8 == true) goto L30;
        if (r4 == false) goto L30;
        r0 = true;
    L30:
        boolean r9 = this.l;
        if (r9 == true) goto L35;
        if (r6 == false) goto L35;
        r0 = r0 | r8;
    L35:
        if (this.n == false) goto L42;
        if (r7 == false) goto L42;
        if (r8 == false) goto L40;
        if (r9 == false) goto L40;
    L41:
        r0 = r0 | r2;
    L40:
        r2 = false;
    L42:
        if (r8 == true) goto L45;
        if (r0 == false) goto L45;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L45:
        if (r0 == true) goto L48;
        r1 = 4;
    L48:
        setVisibility(r1);
        return;
    L25:
        r7 = false;
    L20:
        r6 = true;
        goto L23
    L13:
        if (this.n == true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (this.l == false) goto L9;
        if (this.n == true) goto L9;
        r0 = true;
        goto L11
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r3) {
        Drawable r0 = this.e;
        if (r0 == null) goto L5;
        r0.setBounds(this.p);
        this.e.setState(getDrawableState());
        this.e.draw(r3);
    L5:
        this.i.setBounds(this.q);
        super.onDraw(r3);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        super.onLayout(r3, r4, r5, r6, r7);
        int r8 = r6 - r4;
        int r9 = r7 - r5;
        int r10 = Math.min(r9, r8);
        int r11 = Math.abs(r9 - r8) / 2;
        Rect r12 = this.q;
        Rect r0 = this.p;
        if (r8 < r9) goto L5;
        int r13 = r10 + r11;
        r0.set(r11, 0, r13, r9);
        r12.set(r11, 0, r13, r9);
    L6:
        b();
        return;
    L5:
        int r14 = r10 + r11;
        r0.set(0, r11, r8, r14);
        r12.set(0, r11, r8, r14);
        goto L6
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r0 = super.performClick();
        VibratorSmt.a(getContext(), 1);
        return r0;
    }
}
