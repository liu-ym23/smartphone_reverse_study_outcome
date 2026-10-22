package com.obric.oui.indexscrollbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.ttnet.org.chromium.net.NetError;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OIndexScrollbar extends LinearLayout {
    public static final /* synthetic */ int o = 0;
    public int b;
    public int c;
    public int e;
    public float f;
    public float i;
    public QBListener j;
    public SurnameListener k;
    public PopupWindow l;
    public int m;
    public boolean n;

    @Metadata
    public final class AlphabetsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public final int getCount() {
            Intrinsics.m("mAlphabets");
            throw null;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int r1) {
            Intrinsics.m("mAlphabets");
            throw null;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.Adapter
        public final View getView(int r1, View r2, ViewGroup r3) {
            Intrinsics.f(r3, "parent");
            Intrinsics.m("mAlphabets");
            throw null;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public final boolean isEnabled(int r1) {
            Intrinsics.m("mAlphabets");
            throw null;
        }
    }

    @Metadata
    public interface QBListener {
        void a();

        void b();
    }

    @Metadata
    public final class SurnameAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public final int getCount() {
            return 0;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int r1) {
            Intrinsics.c(null);
            throw null;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r1) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int r1, View r2, ViewGroup r3) {
            Intrinsics.f(r3, "parent");
            throw null;
        }
    }

    @Metadata
    public interface SurnameListener {
    }

    public static final void a(OIndexScrollbar r1) {
        r1.setX(r1.c);
        r1.setState(0);
        r1.setLettersBarBg(true);
    }

    public static final /* synthetic */ void b(OIndexScrollbar r1) {
        r1.setLettersBarBg(true);
    }

    private final void getParentxPos() {
        if (this.m == 0) goto L5;
        return;
    L5:
        Object r0 = getParent();
        Intrinsics.e(r0, "this@OIndexScrollbar.getParent()");
        if ((r0 instanceof View) == false) goto L9;
        int[] r1 = new int[2];
        ((View) r0).getLocationInWindow(r1);
        this.m = r1[0];
        return;
    }

    private final int getScreenWidth() {
        new Point();
        Intrinsics.c(null);
        throw null;
    }

    private final void setHostWidth(int r2) {
        this.b = r2;
        this.c = r2;
        int r0 = this.e;
        if (r0 != 0) goto L5;
    L4:
        float r3 = r2;
    L8:
        setX(r3);
        invalidate();
        return;
    L5:
        if (r0 == 0) goto L4;
        r3 = getX();
        goto L8
    }

    private final void setLettersBarBg(boolean r1) {
        Intrinsics.c(null);
        throw null;
    }

    private final void setShadowVisible(boolean r1) {
        Intrinsics.c(null);
        throw null;
    }

    private final void setState(int r1) {
        this.e = r1;
        Intrinsics.c(null);
        throw null;
    }

    public final void c() {
        PopupWindow r0 = this.l;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.l = null;
        return;
    }

    public final void d() {
        c();
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.b})});
        Intrinsics.e(r1, "ObjectAnimator.ofPropertyValuesHolder(this, pvhX)");
        r0.play(r1);
        r0.setDuration(200);
        r0.addListener(new OIndexScrollbar$hideLetterGridWithAnim$1(this));
        r0.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r15) {
        Intrinsics.f(r15, "event");
        Locale r3 = Locale.getDefault();
        Intrinsics.e(r3, "Locale.getDefault()");
        String r4 = r3.getLanguage();
        Intrinsics.e(r4, "Locale.getDefault().language");
        Locale r6 = Locale.CHINESE;
        Intrinsics.e(r6, "Locale.CHINESE");
        if (Intrinsics.a(r6.getLanguage(), r4) == true) goto L16;
        Locale r8 = Locale.ENGLISH;
        Intrinsics.e(r8, "Locale.ENGLISH");
        if (Intrinsics.a(r8.getLanguage(), r4) == true) goto L16;
        Locale r9 = Locale.KOREA;
        Intrinsics.e(r9, "Locale.KOREA");
        if (Intrinsics.a(r9.getLanguage(), r4) == true) goto L16;
        Locale r10 = Locale.JAPAN;
        Intrinsics.e(r10, "Locale.JAPAN");
        if (Intrinsics.a(r10.getLanguage(), r4) == true) goto L16;
        if ("ru".equals(r4) == true) goto L16;
        return super.dispatchTouchEvent(r15);
    L16:
        getParentxPos();
        int r5 = r15.getAction();
        r15.getX();
        r15.getY();
        float r11 = r15.getRawX() - this.m;
        if (r5 == 0) goto L66;
        if (r5 == 1) goto L38;
        if (r5 == 2) goto L24;
        if (r5 == 3) goto L38;
    L68:
        if (super.dispatchTouchEvent(r15) == true) goto L70;
        return false;
    L70:
        return true;
    L24:
        if (this.n == true) goto L68;
        float r0 = this.i;
        this.f = r0;
        this.i = r11;
        int r7 = this.e;
        if (r7 != 0) goto L29;
        int r1 = (r11 > this.b ? 1 : (r11 == this.b ? 0 : -1));
        goto L68
    L29:
        if (r7 == 0) goto L68;
        if (r7 != 0) goto L68;
        if ((r11 - r0) <= 0) goto L68;
        if (r0 <= this.c) goto L68;
    L38:
        if (this.n == false) goto L53;
        Locale r2 = Locale.getDefault();
        Intrinsics.e(r2, "Locale.getDefault()");
        String r12 = r2.getLanguage();
        Intrinsics.e(r12, "Locale.getDefault().language");
        Intrinsics.e(r6, "Locale.CHINESE");
        if (Intrinsics.a(r6.getLanguage(), r12) == true) goto L68;
        Locale r13 = Locale.ENGLISH;
        Intrinsics.e(r13, "Locale.ENGLISH");
        if (Intrinsics.a(r13.getLanguage(), r12) == true) goto L68;
        Locale r14 = Locale.KOREA;
        Intrinsics.e(r14, "Locale.KOREA");
        if (Intrinsics.a(r14.getLanguage(), r12) == true) goto L68;
        Locale r16 = Locale.JAPAN;
        Intrinsics.e(r16, "Locale.JAPAN");
        if (Intrinsics.a(r16.getLanguage(), r12) == true) goto L68;
        "ru".equals(r12);
        goto L68
    L53:
        if (getX() != this.b) goto L56;
        setLettersBarBg(false);
        goto L68
    L56:
        if (this.e != 0) goto L68;
        if ((this.i - this.f) <= 0) goto L60;
    L65:
        d();
        goto L70
    L60:
        if (getX() >= (getScreenWidth() + NetError.ERR_SSL_PINNED_KEY_NOT_IN_CERT_CHAIN)) goto L65;
        QBListener r17 = this.j;
        if (r17 == null) goto L64;
        r17.b();
    L64:
        AnimatorSet r18 = new AnimatorSet();
        ObjectAnimator r19 = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.c})});
        Intrinsics.e(r19, "ObjectAnimator.ofPropertyValuesHolder(this, pvhX)");
        r18.play(r19);
        r18.setDuration(200);
        r18.addListener(new OIndexScrollbar$showLetterGridWithAnim$1(this));
        r18.start();
        goto L70
    L66:
        this.n = false;
        this.i = r11;
        this.f = r11;
        goto L68
    }

    public final void e() {
        setState(0);
        setX(this.b);
        setLettersBarBg(false);
    }

    public final int getLETTER_CHANGED_CLICK() {
        return 0;
    }

    public final int getLETTER_CHANGED_SLIDE() {
        return 0;
    }

    @Nullable
    public final LettersBar getLetterBar() {
        return null;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return false;
    }

    @NotNull
    public final String getOIndexScrollbar_TAG() {
        return null;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return 0;
    }

    public final int getPOUND_POSITION_TOP() {
        return 0;
    }

    public final int getVISIBILITY_LIMIT() {
        return 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        View.MeasureSpec.getSize(r2);
        View.MeasureSpec.getSize(r1);
        Object r3 = getParent();
        if (r3 == null) goto L8;
        int r4 = ((View) r3).getMeasuredWidth();
        if (r4 <= 0) goto L9;
        setHostWidth(r4);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.f(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
    }

    public final void setLongPressEnabled(boolean r1) {
    }

    public final void setPoundPosition(int r1) {
    }

    public final void setPoundVisibility(boolean r1) {
    }

    public final void setQBListener(@Nullable QBListener r1) {
        this.j = r1;
    }

    public final void setSurnameListener(@Nullable SurnameListener r1) {
        this.k = r1;
    }
}
