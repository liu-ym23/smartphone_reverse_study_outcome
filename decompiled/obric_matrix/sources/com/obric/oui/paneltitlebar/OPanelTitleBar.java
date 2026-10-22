package com.obric.oui.paneltitlebar;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.oui.common.util.j;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import kotlin.o0.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H\u0014¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010#R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010#R\u0018\u00107\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010.R\u0018\u0010;\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010*R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010=¨\u0006>"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", WsConstants.KEY_CONNECTION_TYPE, "Lkotlin/f0;", "f", "(I)V", "setType", "", "title", "setTitle", "(Ljava/lang/String;)V", LocationMonitorConst.INFO, "setInfo", "", "show", "i", "(Z)V", "h", "g", "Landroid/view/View;", "view", "setActionView", "(Landroid/view/View;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Z", "showInfoIcon", "j", "Ljava/lang/String;", "showInfo", "Lcom/obric/oui/text/OTextView;", "m", "Lcom/obric/oui/text/OTextView;", "vInfoText", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "vInfoIcon", "Landroid/widget/FrameLayout;", "p", "Landroid/widget/FrameLayout;", "vActionContainer", "showExpandIcon", "q", "Landroid/view/View;", "vActionView", "n", "vExpandIcon", "l", "vTitleText", "k", "I", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OPanelTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11255i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11256j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11257k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OTextView f11258l;
    private OTextView m;
    private ImageView n;
    private ImageView o;
    private FrameLayout p;
    private View q;

    static {
    }

    private final void f(int r7) {
        if (r7 == 0) goto L5;
        float r8 = 12;
        Resources r0 = Resources.getSystem();
        o.e(r0, "Resources.getSystem()");
        int r1 = a.a(TypedValue.applyDimension(1, r8, r0.getDisplayMetrics()));
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        int r4 = a.a(TypedValue.applyDimension(1, r8, r3.getDisplayMetrics()));
        Resources r5 = Resources.getSystem();
        o.e(r5, "Resources.getSystem()");
        int r6 = a.a(TypedValue.applyDimension(1, r8, r5.getDisplayMetrics()));
        Resources r9 = Resources.getSystem();
        o.e(r9, "Resources.getSystem()");
        setPadding(r1, r4, r6, a.a(TypedValue.applyDimension(1, r8, r9.getDisplayMetrics())));
        int r10 = g.t;
    L6:
        removeAllViews();
        View r11 = LayoutInflater.from(getContext()).inflate(r10, this, true);
        this.f11258l = (OTextView) r11.findViewById(f.D0);
        this.m = (OTextView) r11.findViewById(f.B0);
        this.n = (ImageView) r11.findViewById(f.A0);
        this.o = (ImageView) r11.findViewById(f.C0);
        this.p = (FrameLayout) r11.findViewById(f.z0);
        return;
    L5:
        float r12 = 12;
        Resources r2 = Resources.getSystem();
        o.e(r2, "Resources.getSystem()");
        int r13 = a.a(TypedValue.applyDimension(1, r12, r2.getDisplayMetrics()));
        Resources r14 = Resources.getSystem();
        o.e(r14, "Resources.getSystem()");
        int r15 = a.a(TypedValue.applyDimension(1, 14, r14.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        o.e(r16, "Resources.getSystem()");
        int r17 = a.a(TypedValue.applyDimension(1, r12, r16.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        o.e(r18, "Resources.getSystem()");
        setPadding(r13, r15, r17, a.a(TypedValue.applyDimension(1, 8, r18.getDisplayMetrics())));
        r10 = g.s;
        goto L6
    }

    public final void g(boolean r1) {
        this.f11255i = r1;
        ImageView r0 = this.n;
        if (r0 == null) goto L6;
        j.j(r0, r1);
        return;
    }

    public final void h(boolean r1) {
        this.f11253g = r1;
        OTextView r0 = this.m;
        if (r0 == null) goto L6;
        j.j(r0, r1);
        return;
    }

    public final void i(boolean r1) {
        this.f11254h = r1;
        ImageView r0 = this.o;
        if (r0 == null) goto L6;
        j.j(r0, r1);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setActionView(View r3) {
        this.q = r3;
        FrameLayout r0 = this.p;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        FrameLayout r2 = this.p;
        if (r2 == null) goto L11;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 21;
        f0 r4 = f0.f18324a;
        r2.addView(r3, r1);
        return;
    }

    public final void setInfo(String r1) {
        this.f11257k = r1;
        OTextView r0 = this.m;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public final void setTitle(String r1) {
        this.f11256j = r1;
        OTextView r0 = this.f11258l;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    public final void setType(int r2) {
        if (r2 == 0) goto L6;
        if (r2 == 1) goto L6;
        return;
    L6:
        if (r2 == this.f11252f) goto L12;
        this.f11252f = r2;
        f(r2);
        setTitle(this.f11256j);
        setInfo(this.f11257k);
        h(this.f11253g);
        g(this.f11255i);
        i(this.f11254h);
        View r3 = this.q;
        if (r3 == null) goto L13;
        setActionView(r3);
        return;
    L13:
        return;
    }
}
