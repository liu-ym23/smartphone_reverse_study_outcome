package com.obric.oui.filter;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.common.oui.c;
import com.obric.common.oui.e;
import d.g.d.b.b.p;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010$\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b&\u0010\bR\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00100\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00104R\u0018\u0010>\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010(R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010(R\u0016\u0010L\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00108R\u0016\u0010N\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010(¨\u0006O"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "Lkotlin/f0;", "b", "()V", "Landroid/graphics/Canvas;", "canvas", "a", "(Landroid/graphics/Canvas;)V", "", "selected", "setSelected", "(Z)V", "", "getStyle", "()I", "c", "isAlwaysLight", "setAlwaysLight", "getIsAlwaysLight", "()Z", "enabled", "setEnabled", "Lcom/obric/oui/filter/OFilter$a;", "listener", "setSelectChangeListener", "(Lcom/obric/oui/filter/OFilter$a;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onDraw", "h", "I", "withIconPaddingHorizontal", "f", "normalPaddingHorizontal", "g", "normalPaddingVertical", "l", "Z", "showIcon", "m", "Landroid/graphics/Paint;", "r", "Landroid/graphics/Paint;", "strokePaint", "Landroid/graphics/RectF;", "t", "Landroid/graphics/RectF;", "strokeRect", "q", "bgPaint", "o", "Lcom/obric/oui/filter/OFilter$a;", "onFilterSelectChangeListener", "n", "tintAndTextColor", "", "p", "F", "paintStrokeWidth", "Landroid/graphics/drawable/Drawable;", "k", "Landroid/graphics/drawable/Drawable;", "drawable", "i", "withIconPaddingVertical", "s", "bgRect", "j", "style", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OFilter extends DrawableCenterButton {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f10978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f10983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10984l;
    private boolean m;
    private int n;
    private a o;
    private final float p;
    private final Paint q;
    private final Paint r;
    private final RectF s;
    private final RectF t;

    public interface a {
        void a(OFilter r1, boolean r2);
    }

    static {
    }

    private final void a(Canvas r7) {
        r7.save();
        r7.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.f10982j != 0) goto L5;
        int r0 = 4;
    L6:
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        float r1 = kotlin.o0.a.a(TypedValue.applyDimension(1, r0, r3.getDisplayMetrics()));
        this.s.set(0.0f, 0.0f, getWidth(), getHeight());
        p r2 = p.f16819e;
        r2.h(r7, this.s, r1, this.q);
        if (this.f10982j != 1) goto L9;
        float r4 = this.p * 0.5f;
        this.t.set(r4, r4, getWidth() - r4, getHeight() - r4);
        r2.h(r7, this.t, r1, this.r);
    L9:
        r7.restore();
        return;
    L5:
        r0 = 8;
        goto L6
    }

    private final void b() {
        if (this.f10984l == true) goto L5;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r0 = this.f10978f;
        int r1 = this.f10979g;
        setPadding(r0, r1, r0, r1);
        setGravity(17);
        return;
    L5:
        if (this.f10983k != null) goto L11;
        Drawable r2 = ContextCompat.getDrawable(getContext(), e.f8231f);
        if (r2 == null) goto L9;
        Drawable r3 = r2.mutate();
    L10:
        this.f10983k = r3;
        goto L11
    L9:
        r3 = null;
    L11:
        Drawable r4 = this.f10983k;
        o.c(r4);
        Drawable r5 = DrawableCompat.wrap(r4);
        DrawableCompat.setTintMode(r5, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r5, ContextCompat.getColor(getContext(), this.n));
        o.e(r5, "drawableCompat");
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r5, null);
        int r6 = this.f10980h;
        int r7 = this.f10981i;
        setPadding(r6, r7, r6, r7);
    }

    public final void c() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.f10982j != 1) goto L8;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r0 = kotlin.o0.a.a(TypedValue.applyDimension(1, 36, r2.getDisplayMetrics()));
    L9:
        setMinHeight(r0);
        if (isSelected() == false) goto L20;
        if (this.m == false) goto L16;
        int r1 = c.T;
        int r3 = c.f8202a;
        this.n = r1;
    L14:
        setTypeface(null, 1);
    L28:
        this.q.setColor(ContextCompat.getColor(getContext(), r3));
        this.r.setColor(ContextCompat.getColor(getContext(), r1));
        setTextColor(ContextCompat.getColor(getContext(), this.n));
        b();
        return;
    L16:
        if (this.f10982j != 1) goto L18;
        r1 = c.T;
        this.n = r1;
        r3 = c.u;
        goto L14
    L18:
        r1 = c.f8203b;
        this.n = c.p;
        setTypeface(null, 1);
        r3 = r1;
        goto L28
    L20:
        if (this.m == false) goto L25;
        r1 = c.m;
        this.n = c.q;
    L22:
        int r4 = c.u;
    L23:
        setTypeface(null, 0);
        r3 = r4;
        goto L28
    L25:
        if (this.f10982j != 1) goto L27;
        r1 = c.B;
        this.n = r1;
        goto L22
    L27:
        r1 = c.B;
        this.n = r1;
        r4 = c.C;
        goto L23
    L8:
        r0 = -1;
        goto L9
    }

    public final boolean getIsAlwaysLight() {
        return this.m;
    }

    public final int getStyle() {
        return this.f10982j;
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r2) {
        o.f(r2, "canvas");
        a(r2);
        super.onDraw(r2);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setAlwaysLight(boolean r1) {
        this.m = r1;
        c();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r1) {
        super.setEnabled(r1);
        if (r1 == false) goto L5;
        setAlpha(1.0f);
        c();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setSelectChangeListener(a r2) {
        o.f(r2, "listener");
        this.o = r2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        c();
        a r0 = this.o;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    }
}
