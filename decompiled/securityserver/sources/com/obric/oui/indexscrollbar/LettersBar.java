package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.log.L;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LettersBar extends View {
    public List b;
    public int c;
    public boolean e;
    public Bitmap[] f;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public int n;
    public final Paint o;
    public int p;
    public int q;
    public final Bitmap r;
    public final int s;
    public LBListener t;
    public boolean u;
    public OnBackgroundVisibleChangedListener v;
    public final OIndexPopupWindowLayout w;
    public final int x;
    public String y;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface LBListener {
        boolean a();
    }

    @Metadata
    public interface OnBackgroundVisibleChangedListener {
        void a(boolean r1);
    }

    @JvmOverloads
    public LettersBar(@NotNull Context r7, @Nullable AttributeSet r8) {
        Intrinsics.f(r7, "context");
        super(r7, r8, 0);
        this.c = -1;
        this.e = true;
        Paint r1 = new Paint();
        this.o = r1;
        OIndexPopupWindowLayout r2 = new OIndexPopupWindowLayout(r7, null);
        View r3 = LayoutInflater.from(r7).inflate(R.layout.o_index_scrollbar_popup_circle, null);
        r2.e = (ImageView) r3.findViewById(R.id.popup_img);
        r2.c = (TextView) r3.findViewById(R.id.popup_text);
        r2.b = new PopupWindow(r3, -2, -2, false);
        this.w = r2;
        Resources r4 = r7.getResources();
        this.j = r4.getDimensionPixelSize(R.dimen.letters_bar_single_letter_min_height);
        this.i = OUnitExtensionKt.a(14);
        this.k = r4.getDimensionPixelOffset(R.dimen.letters_bar_letter_font_size);
        this.l = r4.getDimensionPixelOffset(R.dimen.letters_bar_letter_locale_font_size);
        this.m = getPaddingLeft() + (this.i / 2);
        BitmapFactory.decodeResource(r4, R.drawable.letters_bar_highlight_icon);
        Drawable r5 = r4.getDrawable(R.drawable.letters_bar_highlight_icon);
        Intrinsics.e(r5, "iconDrawable");
        r5.getIntrinsicWidth();
        r5.getIntrinsicHeight();
        this.p = r4.getColor(R.color.oui_functional_blue_6);
        this.q = r4.getColor(R.color.oui_text_3b);
        Bitmap r6 = BitmapFactory.decodeResource(r4, R.drawable.letters_bar_dot);
        this.r = r6;
        int r9 = this.m;
        Intrinsics.c(r6);
        this.s = r9 - (r6.getWidth() / 2);
        r1.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r1.setTextSize(this.k);
        r1.setAntiAlias(true);
        Resources r10 = r7.getResources();
        Intrinsics.e(r10, "context.resources");
        this.x = r10.getDisplayMetrics().widthPixels;
    }

    private final void setLetterPaint(int r7) {
        if (this.c != r7) goto L5;
        boolean r0 = true;
    L6:
        Paint r3 = this.o;
        if (r0 == false) goto L9;
        r3.setColor(this.p);
    L10:
        r3.setFakeBoldText(false);
        Resources r4 = Resources.getSystem();
        Intrinsics.e(r4, "Resources.getSystem()");
        r3.setTextSize(TypedValue.applyDimension(1, 10, r4.getDisplayMetrics()));
        List r1 = this.b;
        Intrinsics.c(r1);
        ((LBLetter) r1.get(r7)).getClass();
        if (StringsKt.F(null, LibrarianImpl.Constants.DOT, false) == true) goto L14;
        List r2 = this.b;
        Intrinsics.c(r2);
        ((LBLetter) r2.get(r7)).getClass();
        r3.setTextSize(this.k);
        return;
    L14:
        return;
    L9:
        r3.setColor(this.q);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private final void setTouchedLetter(int r1) {
        this.c = r1;
        invalidate();
    }

    public final ArrayList a() {
        ArrayList r0 = new ArrayList();
        int r1 = this.n;
        List r2 = this.b;
        Intrinsics.c(r2);
        if ((r1 / r2.size()) >= this.j) goto L5;
        List r3 = this.b;
        Intrinsics.c(r3);
        int r4 = (int) Math.max(2.0d, ((int) Math.ceil(r3.size() / ((this.n / this.j) - 2))) * 2);
    L6:
        r0.add(0);
        List r5 = this.b;
        Intrinsics.c(r5);
        if (r4 >= (r5.size() / 2)) goto L12;
        int r6 = r4;
    L9:
        List r7 = this.b;
        Intrinsics.c(r7);
        if (r6 >= (r7.size() - 1)) goto L12;
        r0.add(Integer.valueOf(r6));
        r6 = r6 + r4;
    L12:
        List r8 = this.b;
        Intrinsics.c(r8);
        if (r4 >= r8.size()) goto L15;
        List r9 = this.b;
        Intrinsics.c(r9);
        r0.add(Integer.valueOf(r9.size() - 1));
    L15:
        return r0;
    L5:
        r4 = 1;
        goto L6
    }

    public final void b(int r10, String r11) {
        float r0 = (float) Math.max(this.n / a().size(), this.j);
        List r1 = this.b;
        Intrinsics.c(r1);
        ((LBLetter) r1.get(r10)).getClass();
        if (Intrinsics.a(null, this.y) == false) goto L5;
        return;
    L5:
        L.a("LettersBar", "showPopupWindow, scene: " + r11 + ", c = " + r10 + ", letter = null, lastPopupLetter = " + this.y);
        Bitmap[] r12 = this.f;
        if (r12 == null) goto L8;
        int r13 = r12.length;
    L8:
        List r14 = this.b;
        Intrinsics.c(r14);
        ((LBLetter) r14.get(r10)).getClass();
        int r3 = getResources().getDimensionPixelSize(R.dimen.oui_h_title_bar_window);
        int r4 = this.x - getWidth();
        Resources r6 = Resources.getSystem();
        Intrinsics.e(r6, "Resources.getSystem()");
        int r5 = r4 - MathKt.a(TypedValue.applyDimension(1, 20, r6.getDisplayMetrics()));
        Resources r7 = Resources.getSystem();
        Intrinsics.e(r7, "Resources.getSystem()");
        int r8 = r5 - MathKt.a(TypedValue.applyDimension(1, 18, r7.getDisplayMetrics()));
        Resources r9 = Resources.getSystem();
        Intrinsics.e(r9, "Resources.getSystem()");
        int r15 = r8 - MathKt.a(TypedValue.applyDimension(1, 6, r9.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.e(r16, "Resources.getSystem()");
        int r17 = r15 - MathKt.a(TypedValue.applyDimension(1, 10, r16.getDisplayMetrics()));
        int r18 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r18 <= 0) goto L11;
        r3 = r3 + getResources().getDimensionPixelSize(r18);
    L11:
        int[] r19 = new int[2];
        getLocationInWindow(r19);
        int r110 = Math.max((int) ((r0 * (r10 - 1)) + r19[1]), r3);
        OIndexPopupWindowLayout r111 = this.w;
        r111.getClass();
        Intrinsics.f(null, "letter");
        ImageView r2 = r111.e;
        TextView r20 = r111.c;
        if (r20 == null) goto L14;
        r20.setText(null);
    L14:
        if (r2 == null) goto L16;
        r2.setVisibility(8);
    L16:
        if (r20 == null) goto L18;
        r20.setVisibility(0);
    L18:
        PopupWindow r21 = r111.b;
        if (r21 != null) goto L21;
    L25:
        PopupWindow r112 = r111.b;
        if (r112 == null) goto L28;
        r112.update(r17, r110, -2, -2);
    L28:
        this.y = null;
        return;
    L21:
        if (r21.isShowing() == true) goto L25;
        PopupWindow r22 = r111.b;
        if (r22 == null) goto L28;
        r22.showAtLocation(r111, 0, r17, r110);
        goto L28
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        Intrinsics.f(r9, "event");
        super.dispatchTouchEvent(r9);
        int r0 = r9.getAction();
        float r10 = r9.getY();
        int r1 = this.c;
        float r11 = (r10 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List r2 = this.b;
        Intrinsics.c(r2);
        int r12 = (int) (r11 * r2.size());
        if (r0 == 0) goto L37;
        OIndexPopupWindowLayout r6 = this.w;
        if (r0 == 1) goto L26;
        if (r0 != 2) goto L9;
        if (r12 < 0) goto L24;
        List r3 = this.b;
        Intrinsics.c(r3);
        if (r12 >= r3.size()) goto L24;
        if (this.e == false) goto L23;
        if (r1 == r12) goto L23;
        if (this.t == null) goto L23;
        b(r12, "ACTION_MOVE");
        LBListener r4 = this.t;
        Intrinsics.c(r4);
        List r8 = this.b;
        Intrinsics.c(r8);
        ((LBLetter) r8.get(r12)).getClass();
        r4.a();
        throw null;
    L23:
        setTouchedLetter(r12);
    L24:
        setShowBg(false);
    L44:
        return true;
    L9:
        if (r0 != 3) goto L44;
        r6.a();
        setTouchedLetter(-1);
        goto L44
    L26:
        if (this.e == false) goto L36;
        if (r12 < 0) goto L35;
        List r5 = this.b;
        Intrinsics.c(r5);
        if (r12 >= r5.size()) goto L35;
        LBListener r7 = this.t;
        if (r7 != null) goto L33;
        setTouchedLetter(r12);
        goto L35
    L33:
        List r13 = this.b;
        Intrinsics.c(r13);
        ((LBLetter) r13.get(r12)).getClass();
        r7.a();
        throw null;
    L35:
        r6.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L36:
        r6.a();
        invalidate();
        goto L44
    L37:
        this.y = null;
        if (r1 == r12) goto L43;
        if (r12 < 0) goto L43;
        List r14 = this.b;
        Intrinsics.c(r14);
        if (r12 >= r14.size()) goto L43;
        b(r12, "ACTION_DOWN");
        setTouchedLetter(r12);
    L43:
        setShowBg(false);
        goto L44
    }

    public final int getMHasChosenLetterFontColor() {
        return this.p;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.f(r17, "canvas");
        super.onDraw(r17);
        r17.save();
        r17.translate(0.0f, getPaddingTop());
        ArrayList r2 = a();
        float r3 = (float) Math.max(this.n / r2.size(), this.j);
        Iterator r4 = r2.iterator();
        int r5 = 0;
    L4:
        if (r4.hasNext() == false) goto L15;
        Integer r6 = (Integer) r4.next();
        Intrinsics.e(r6, "index");
        setLetterPaint(r6.intValue());
        float r7 = this.m;
        Paint r8 = this.o;
        List r9 = this.b;
        Intrinsics.c(r9);
        ((LBLetter) r9.get(r6.intValue())).getClass();
        float r11 = 2;
        float r10 = r7 - (r8.measureText(null) / r11);
        float r12 = (r3 / r11) + (r5 * r3);
        if (this.c == r6.intValue()) goto L8;
    L10:
        List r13 = this.b;
        Intrinsics.c(r13);
        ((LBLetter) r13.get(r6.intValue())).getClass();
        int r14 = r6.intValue();
        List r15 = this.b;
        Intrinsics.c(r15);
        ((LBLetter) r15.get(r14)).getClass();
        if (StringsKt.F(null, LibrarianImpl.Constants.DOT, false) == false) goto L13;
        Bitmap r16 = this.r;
        Intrinsics.c(r16);
        float r18 = r12 - (r16.getHeight() / 2);
        Bitmap r19 = this.r;
        Intrinsics.c(r19);
        r17.drawBitmap(r19, this.s, r18, null);
    L14:
        r5 = r5 + 1;
        goto L4
    L13:
        Paint.FontMetricsInt r20 = r8.getFontMetricsInt();
        int r21 = r20.bottom;
        int r22 = r20.top;
        r17.drawText(null, r10, (r12 - ((r21 - r22) / 2)) - r22, r8);
        goto L14
    L8:
        if (this.e == false) goto L10;
        Paint r23 = new Paint();
        Context r110 = getContext();
        Intrinsics.e(r110, "context");
        r23.setColor(r110.getResources().getColor(R.color.Transparent));
        int r111 = OUnitExtensionKt.a(14);
        OUnitExtensionKt.a(14);
        float r112 = r111 / 2.0f;
        float r113 = this.m;
        r17.drawRoundRect(new RectF(r113 - r112, r12 - r112, r113 + r112, r12 + r112), r112, r112, r23);
        goto L10
    L15:
        r17.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = View.MeasureSpec.getMode(r3);
        int r5 = View.MeasureSpec.getSize(r3);
        if (r4 != Integer.MIN_VALUE) goto L6;
    L9:
        this.n = (r5 - getPaddingTop()) - getPaddingBottom();
        return;
    L6:
        if (r4 == 1073741824) goto L9;
        r5 = 0;
        goto L9
    }

    public final void setBitmapsSelected(@Nullable Bitmap[] r1) {
        this.f = r1;
    }

    public final void setLetters(@Nullable List<LBLetter> r1) {
        this.b = r1;
    }

    public final void setListener(@Nullable LBListener r1) {
        this.t = r1;
    }

    public final void setMHasChosenLetterFontColor(int r1) {
        this.p = r1;
    }

    public final void setMNoChosenLetterFontColor(int r1) {
        this.q = r1;
    }

    public final void setOnBackgroundVisibleChangedListener(@Nullable OnBackgroundVisibleChangedListener r1) {
        this.v = r1;
    }

    public final void setSettled(boolean r1) {
        this.e = r1;
        if (r1 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r3) {
        if (this.u == r3) goto L13;
        this.u = r3;
        if (r3 == false) goto L7;
        Drawable r4 = getResources().getDrawable(R.drawable.letters_bar_background);
    L8:
        setBackground(r4);
        OnBackgroundVisibleChangedListener r5 = this.v;
        if (r5 == null) goto L14;
        r5.a(this.u);
        throw null;
    L14:
        return;
    L7:
        r4 = null;
        goto L8
    }
}
