package com.obric.oui.checkbox;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.e;
import com.obric.common.oui.k;
import com.obric.oui.common.util.j;
import d.g.d.f.d;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002bcB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b`\u0010aJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0012J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\u0016H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u0017\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0016H\u0016¢\u0006\u0004\b#\u0010\u0019J\u0017\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010(¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010+\u001a\u00020\u0007H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\tH\u0014¢\u0006\u0004\b/\u0010\rJ7\u00105\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014¢\u0006\u0004\b5\u00106R\u0016\u00108\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00107R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00107R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010:R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00107R\u0018\u0010H\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010CR\u0018\u0010K\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010:R0\u0010S\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0004\b\u000e\u0010:\u0012\u0004\bR\u0010\r\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u0012R\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010:R\u0016\u0010Z\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010:R\u0018\u0010]\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010:¨\u0006d"}, d2 = {"Lcom/obric/oui/checkbox/OCheckBox;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Checkable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "Lkotlin/f0;", "i", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "l", "()V", "k", "h", TypedValues.Custom.S_COLOR, "setPrimaryColor", "(I)V", WsConstants.KEY_CONNECTION_TYPE, "setShape", "setSize", "", "light", "setAlwaysLight", "(Z)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "isChecked", "()Z", "toggle", "performClick", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$b;", "listener", "setOnCheckedStateChangedListener", "(Lcom/obric/oui/checkbox/OCheckBox$b;)V", "Lcom/obric/oui/checkbox/OCheckBox$a;", "setOnCheckedChangeListener", "(Lcom/obric/oui/checkbox/OCheckBox$a;)V", "extraSpace", "", "onCreateDrawableState", "(I)[I", "onAttachedToWindow", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Z", "broadcasting", "s", "I", "colorChecked", "t", "colorUnchecked", "u", "adaptForCSR", "size", "Landroid/graphics/ColorFilter;", "n", "Landroid/graphics/ColorFilter;", "checkedColorFilter", "m", "alwaysLight", "o", "uncheckedColorFilter", "p", "Lcom/obric/oui/checkbox/OCheckBox$b;", "onCheckedStateChangedListener", "g", "shape", "value", "getCheckedState", "()I", "setCheckedState", "getCheckedState$annotations", "checkedState", "Landroid/graphics/drawable/Drawable;", "f", "Landroid/graphics/drawable/Drawable;", "buttonDrawable", "colorStyle", "j", "iconSize", "q", "Lcom/obric/oui/checkbox/OCheckBox$a;", "onCheckedChangeListener", "r", "colorPrimary", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OCheckBox extends AppCompatImageView implements Checkable {
    private static final int[] v = null;
    private static final int[] w = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f10933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f10934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f10935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f10937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f10938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f10939l;
    private boolean m;
    private ColorFilter n;
    private ColorFilter o;
    private b p;
    private a q;
    private int r;
    private int s;
    private int t;
    private boolean u;

    public interface a {
        void a(OCheckBox r1, boolean r2);
    }

    public interface b {
        void a(OCheckBox r1, int r2);
    }

    static {
        v = new int[]{R.attr.state_checked};
        w = new int[]{com.obric.common.oui.b.f8199h};
    }

    public OCheckBox(Context r8, AttributeSet r9) {
        o.f(r8, "context");
        o.f(r9, "attrs");
        super(r8, r9);
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = true;
        j(this, r8, r9, 0, 4, null);
    }

    public static final /* synthetic */ int[] f(int[] r0, int[] r1) {
        return ImageView.mergeDrawableStates(r0, r1);
    }

    public static final /* synthetic */ int[] g(int[] r0, int[] r1) {
        return View.mergeDrawableStates(r0, r1);
    }

    public static /* synthetic */ void getCheckedState$annotations() {
    }

    private final void h() {
        int r0 = this.s;
        if (r0 == (-1)) goto L6;
        this.n = com.obric.oui.common.util.b.a(r0);
    L6:
        if (this.t == (-1)) goto L9;
        this.o = new PorterDuffColorFilter(this.t, PorterDuff.Mode.SRC_IN);
        return;
    }

    private final void i(Context r4, AttributeSet r5, int r6) {
        TypedArray r7 = r4.obtainStyledAttributes(r5, k.A, r6, 0);
        o.e(r7, "context.obtainStyledAttr…heckBox, defStyleAttr, 0)");
        this.f10934g = r7.getInt(k.G, 0);
        this.f10935h = r7.getInt(k.H, 0);
        this.f10936i = r7.getInt(k.E, 0);
        this.u = r7.getBoolean(k.H0, true);
        this.r = r7.getColor(k.F, -1);
        this.s = r7.getColor(k.D, -1);
        this.t = r7.getColor(k.I, -1);
        Drawable r8 = r7.getDrawable(k.C);
        if (r8 != null) goto L6;
        r8 = null;
    L6:
        this.f10933f = r8;
        this.m = r7.getBoolean(k.B, false);
        int r9 = k.f8287J;
        if (r7.hasValue(r9) == false) goto L9;
        setCheckedState(r7.getInt(r9, 0));
    L9:
        r7.recycle();
        h();
        Drawable r10 = this.f10933f;
        if (r10 != null) goto L12;
        setShape(this.f10934g);
    L13:
        setSize(this.f10935h);
        setBackground(null);
        k();
        setClickable(true);
        return;
    L12:
        setImageDrawable(r10);
        goto L13
    }

    static /* synthetic */ void j(OCheckBox r0, Context r1, AttributeSet r2, int r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L6;
        r3 = com.obric.common.oui.b.f8192a;
    L6:
        r0.i(r1, r2, r3);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    private final void k() {
        Drawable r0 = getDrawable();
        if (r0 == null) goto L5;
        r0.clearColorFilter();
    L5:
        h();
        Drawable r1 = getDrawable();
        if (r1 != null) goto L8;
        return;
    L8:
        if (isChecked() == false) goto L10;
        ColorFilter r2 = this.n;
    L11:
        r1.setColorFilter(r2);
        return;
    L10:
        r2 = this.o;
        goto L11
    }

    private final void l() {
        int r0 = this.f10934g;
        if (r0 == 0) goto L5;
    L8:
        if (r0 == 0) goto L10;
    L15:
        if (r0 != 0) goto L17;
    L19:
        if (r0 != 0) goto L21;
    L23:
        Resources r1 = getResources();
        int r2 = e.f8234i;
    L7:
        Drawable r3 = r1.getDrawable(r2, null);
        this.f10933f = r3;
        int r4 = this.r;
        if (r4 != (-1)) goto L27;
    L31:
        setImageDrawable(this.f10933f);
        return;
    L27:
        if ((r3 instanceof StateListDrawable) == false) goto L31;
        if (Build.VERSION.SDK_INT < 29) goto L31;
        d r5 = d.f16935a;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
        r5.c((StateListDrawable) r3, "primary_shape", r4);
        goto L31
    L21:
        if (this.m == true) goto L23;
        r1 = getResources();
        r2 = e.f8237l;
        goto L7
    L17:
        if (this.m == false) goto L19;
        r1 = getResources();
        r2 = e.m;
        goto L7
    L10:
        if (this.m == true) goto L15;
        if (this.f10936i != 1) goto L23;
        r1 = getResources();
        r2 = e.f8236k;
        goto L7
    L5:
        if (this.m == false) goto L8;
        r1 = getResources();
        r2 = e.f8235j;
        goto L7
    }

    public final int getCheckedState() {
        return this.f10938k;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        if (this.f10938k == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u == false) goto L6;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        j.a(this, kotlin.o0.a.a(TypedValue.applyDimension(1, 44, r2.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r3) {
        int[] r4 = super.onCreateDrawableState(r3 + 2);
        if (this.f10938k != 2) goto L6;
        f(r4, w);
    L6:
        if (isChecked() == false) goto L8;
        g(r4, v);
    L8:
        return r4;
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = this.f10937j;
        if (r0 <= 0) goto L5;
        r3 = View.MeasureSpec.makeMeasureSpec(r0, BasicMeasure.EXACTLY);
    L5:
        int r1 = this.f10937j;
        if (r1 <= 0) goto L8;
        r4 = View.MeasureSpec.makeMeasureSpec(r1, BasicMeasure.EXACTLY);
    L8:
        super.onMeasure(r3, r4);
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        boolean r0 = super.performClick();
        if (r0 == true) goto L6;
        playSoundEffect(0);
    L6:
        if (isChecked() == false) goto L8;
        d.g.d.d.a.b(getContext(), 1);
    L8:
        return r0;
    }

    public final void setAlwaysLight(boolean r1) {
        this.m = r1;
        l();
        invalidate();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        setCheckedState(r1 ? 1 : 0);
    }

    public final void setCheckedState(int r2) {
        if (this.f10938k == r2) goto L17;
        this.f10938k = r2;
        k();
        refreshDrawableState();
        if (this.f10939l == false) goto L7;
        return;
    L7:
        this.f10939l = true;
        b r3 = this.p;
        if (r3 == null) goto L11;
        r3.a(this, this.f10938k);
    L11:
        if (this.f10938k == 2) goto L15;
        a r4 = this.q;
        if (r4 == null) goto L15;
        r4.a(this, isChecked());
    L15:
        this.f10939l = false;
        return;
    }

    public final void setOnCheckedChangeListener(a r1) {
        this.q = r1;
    }

    public final void setOnCheckedStateChangedListener(b r1) {
        this.p = r1;
    }

    public final void setPrimaryColor(@ColorInt int r1) {
        this.r = r1;
        l();
        invalidate();
    }

    public final void setShape(int r1) {
        this.f10934g = r1;
        l();
        invalidate();
    }

    public final void setSize(int r4) {
        this.f10935h = r4;
        if (r4 != 0) goto L5;
        int r5 = 18;
    L6:
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        this.f10937j = kotlin.o0.a.a(TypedValue.applyDimension(1, r5, r2.getDisplayMetrics()));
        requestLayout();
        return;
    L5:
        r5 = 24;
        goto L6
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
