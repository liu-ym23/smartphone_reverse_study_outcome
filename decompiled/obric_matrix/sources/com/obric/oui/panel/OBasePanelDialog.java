package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.f;
import com.obric.common.oui.j;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.n0.c.l;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001e\u0012\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u0005¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0014J!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u0014J\r\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\r\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b'\u0010(R\"\u0010.\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010(R\"\u00101\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010*\u001a\u0004\b/\u0010,\"\u0004\b0\u0010(R\"\u00105\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010*\u001a\u0004\b3\u0010,\"\u0004\b4\u0010(R$\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00102\u001a\u0004\b<\u0010\u000f\"\u0004\b)\u0010\u0014R$\u0010A\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00107\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R\"\u0010C\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010*\u001a\u0004\bB\u0010,\"\u0004\b>\u0010(R\"\u0010F\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\bD\u0010,\"\u0004\bE\u0010(R$\u0010L\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010H\u001a\u0004\bI\u0010J\"\u0004\b2\u0010KR\"\u0010O\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010*\u001a\u0004\bM\u0010,\"\u0004\bN\u0010(R*\u0010V\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010P8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bQ\u0010UR$\u0010X\u001a\u0004\u0018\u00010W8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010a\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010*\u001a\u0004\b_\u0010,\"\u0004\b`\u0010(R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\"\u0010i\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010*\u001a\u0004\bg\u0010,\"\u0004\bh\u0010(R$\u0010l\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u00107\u001a\u0004\bk\u00109\"\u0004\bj\u0010;R\u0018\u0010m\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010dR\"\u0010n\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010*\u001a\u0004\bn\u0010,\"\u0004\bf\u0010(R\"\u0010p\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010*\u001a\u0004\bo\u0010,\"\u0004\b6\u0010(R\"\u0010s\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010*\u001a\u0004\br\u0010,\"\u0004\bq\u0010(R\"\u0010u\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010*\u001a\u0004\bt\u0010,\"\u0004\b^\u0010(R\u0018\u0010x\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010wR$\u0010~\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010z\u001a\u0004\b{\u0010|\"\u0004\bc\u0010}R6\u0010$\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020#\u0018\u00010\u007f8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0080\u0001\u0010\u0084\u0001¨\u0006\u008a\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasePanelDialog;", "Lcom/obric/oui/panel/BottomSheetDialog;", "Lkotlin/f0;", "j", "()V", "", "layoutResId", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "N", "(ILandroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;", "o", "m", "()I", "l", "i", "setContentView", "(Landroid/view/View;)V", "(I)V", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "k", "expandedHeight", "z", "p", "n", "onBackPressed", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "fit", "B", "(Z)V", "F", "Z", "getFitsSystemWindows", "()Z", "C", "fitsSystemWindows", "getDisableAutoAdaptHeight", "w", "disableAutoAdaptHeight", "I", "getClipTopCorner", "u", "clipTopCorner", "E", "Ljava/lang/Integer;", "getExpandedHeight", "()Ljava/lang/Integer;", "A", "(Ljava/lang/Integer;)V", "getMaxPanelHeight", "maxPanelHeight", "D", "getCollapsedHeight", BaseSwitches.V, "collapsedHeight", "getFixedHeight", "fixedHeight", "getAutoSwitchDayNight", "s", "autoSwitchDayNight", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "(Landroid/view/View$OnClickListener;)V", "outsideClickListener", "getAdaptRLSlide", "r", "adaptRLSlide", "Lkotlin/Function0;", "H", "Lkotlin/n0/c/a;", "getOnDialogBackPressCallback", "()Lkotlin/n0/c/a;", "(Lkotlin/n0/c/a;)V", "onDialogBackPressCallback", "Lcom/obric/oui/panel/OBasicPanel$b;", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$b;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$b;", "J", "(Lcom/obric/oui/panel/OBasicPanel$b;)V", "q", "getUseToneBg", "M", "useToneBg", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "K", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "headerContainer", "y", "getRemoveMinHeight", "L", "removeMinHeight", "G", "getNavBarColor", "navBarColor", "contentContainer", "isExpandable", "getFloatHeader", "floatHeader", "t", "getBackgroundDimEnable", "backgroundDimEnable", "getAdaptNavBarColor", "adaptNavBarColor", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "panelContainer", "Lcom/obric/oui/panel/header/b;", "Lcom/obric/oui/panel/header/b;", "getPanelHeader", "()Lcom/obric/oui/panel/header/b;", "(Lcom/obric/oui/panel/header/b;)V", "panelHeader", "Lkotlin/Function1;", "x", "Lkotlin/n0/c/l;", "getDispatchTouchEvent", "()Lkotlin/n0/c/l;", "(Lkotlin/n0/c/l;)V", "Landroid/content/Context;", "context", "themeResId", "<init>", "(Landroid/content/Context;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OBasePanelDialog extends BottomSheetDialog {
    private View.OnClickListener A;
    private boolean B;
    private boolean C;
    private Integer D;
    private Integer E;
    private boolean F;

    @ColorInt
    private Integer G;
    private kotlin.n0.c.a<Boolean> H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ConstraintLayout f11190J;
    private RadiusLayout K;
    private RadiusLayout L;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private com.obric.oui.panel.header.b v;
    private boolean w;
    private l<? super MotionEvent, Boolean> x;
    private boolean y;
    private boolean z;

    public OBasePanelDialog(Context r2, int r3) {
        o.f(r2, "context");
        super(r2, r3);
        this.p = -1;
        this.t = true;
        this.F = true;
        this.I = true;
    }

    public /* synthetic */ OBasePanelDialog(Context r1, int r2, int r3, g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = j.f8278c;
    L5:
        this(r1, r2);
    }

    private final View N(int r3, View r4, ViewGroup.LayoutParams r5) {
        j();
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, this.L, false);
    L6:
        RadiusLayout r6 = this.L;
        if (r6 == null) goto L9;
        r6.removeAllViews();
    L9:
        RadiusLayout r7 = this.L;
        if (r5 != null) goto L13;
        if (r7 == null) goto L15;
        r7.addView(r4);
    L15:
        o();
        ConstraintLayout r2 = this.f11190J;
        o.c(r2);
        return r2;
    L13:
        if (r7 == null) goto L15;
        r7.addView(r4, r5);
        goto L15
    }

    private final void i() {
    }

    private final void j() {
        if (this.f11190J != null) goto L5;
    L8:
        RadiusLayout r2 = null;
        ConstraintLayout r0 = (ConstraintLayout) View.inflate(getContext(), com.obric.common.oui.g.f8259i, null);
        this.f11190J = r0;
        if (r0 == null) goto L11;
        RadiusLayout r1 = (RadiusLayout) r0.findViewById(f.S);
    L12:
        this.K = r1;
        ConstraintLayout r3 = this.f11190J;
        if (r3 == null) goto L15;
        r2 = (RadiusLayout) r3.findViewById(f.H);
    L15:
        this.L = r2;
        return;
    L11:
        r1 = null;
        goto L12
    L5:
        if (this.K == null) goto L8;
        if (this.L == null) goto L8;
    }

    private final int l() {
        Integer r0 = this.E;
        if (r0 == null) goto L6;
        o.c(r0);
        return r0.intValue();
    L6:
        Context r4 = getContext();
        o.e(r4, "context");
        return (int) (((double) com.obric.oui.common.util.f.b(r4)) * 0.9d);
    }

    private final int m() {
        Integer r0 = this.D;
        if (r0 == null) goto L6;
        o.c(r0);
        return r0.intValue();
    L6:
        Context r1 = getContext();
        o.e(r1, "context");
        Resources r2 = r1.getResources();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.getIdentifier("config_showNavigationBar", "bool", "android"));
    L10:
        boolean r4 = false;
        if (r3 != null) goto L13;
    L20:
        Context r5 = getContext();
        o.e(r5, "context");
        double r6 = com.obric.oui.common.util.f.b(r5);
        if (r4 == false) goto L25;
        return (int) (r6 * 0.65d);
    L25:
        return (int) (r6 * 0.6d);
    L13:
        if (r3.intValue() <= 0) goto L20;
        Context r7 = getContext();
        o.e(r7, "context");
        Resources r8 = r7.getResources();
        if (r8 == null) goto L17;
        boolean r9 = r8.getBoolean(r3.intValue());
    L18:
        if (r9 == false) goto L20;
        r4 = true;
        goto L20
    L17:
        r9 = false;
        goto L18
    L9:
        r3 = null;
        goto L10
    }

    private final void o() {
        if (this.v != null) goto L5;
        Context r2 = getContext();
        o.e(r2, "context");
        this.v = new com.obric.oui.panel.header.a(r2, null, null, 6, null);
    L5:
        i();
        if (this.I == false) goto L8;
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        float r0 = TypedValue.applyDimension(1, 20, r3.getDisplayMetrics());
    L9:
        RadiusLayout r4 = this.K;
        if (r4 == null) goto L13;
        r4.c(r0, r0, 0.0f, 0.0f);
    L13:
        if (this.s == false) goto L17;
        RadiusLayout r5 = this.L;
        if (r5 == null) goto L17;
        r5.c(r0, r0, 0.0f, 0.0f);
    L17:
        com.obric.oui.panel.header.b r1 = this.v;
        if (r1 == null) goto L22;
        View r6 = r1.e();
        if (r6 == null) goto L22;
        ViewParent r7 = r6.getParent();
    L24:
        if ((r7 instanceof ViewGroup) == false) goto L41;
        com.obric.oui.panel.header.b r8 = this.v;
        if (r8 == null) goto L30;
        View r9 = r8.e();
        if (r9 == null) goto L30;
        ViewParent r10 = r9.getParent();
    L32:
        if ((r10 instanceof ViewGroup) == true) goto L34;
        r10 = null;
    L34:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 == null) goto L41;
        com.obric.oui.panel.header.b r12 = this.v;
        if (r12 == null) goto L39;
        View r13 = r12.e();
    L40:
        r11.removeView(r13);
        goto L41
    L39:
        r13 = null;
    L30:
        r10 = null;
    L41:
        RadiusLayout r14 = this.K;
        if (r14 == null) goto L49;
        com.obric.oui.panel.header.b r15 = this.v;
        if (r15 == null) goto L46;
        View r16 = r15.e();
    L47:
        com.obric.oui.common.util.j.i(r14, r16);
        goto L49
    L46:
        r16 = null;
    L49:
        if (this.s == false) goto L59;
        if (this.L == null) goto L59;
        ConstraintSet r17 = new ConstraintSet();
        r17.clone(this.f11190J);
        RadiusLayout r18 = this.L;
        o.c(r18);
        r17.clear(r18.getId(), 3);
        RadiusLayout r19 = this.L;
        o.c(r19);
        r17.connect(r19.getId(), 3, 0, 3);
        r17.applyTo(this.f11190J);
        RadiusLayout r20 = this.K;
        if (r20 == null) goto L55;
        r20.setBackground(null);
    L55:
        RadiusLayout r21 = this.K;
        if (r21 == null) goto L59;
        r21.bringToFront();
    L59:
        if (this.t == true) goto L64;
        Window r22 = getWindow();
        if (r22 == null) goto L64;
        r22.setDimAmount(0.0f);
    L64:
        if (this.u == false) goto L86;
        Integer r23 = this.G;
        if (r23 == null) goto L72;
        int r24 = r23.intValue();
        Window r25 = getWindow();
        if (r25 == null) goto L85;
        r25.setNavigationBarColor(r24);
        return;
    L85:
        return;
    L72:
        if (this.w == false) goto L78;
        if (this.q == false) goto L76;
        int r26 = com.obric.common.oui.c.f8206e;
    L81:
        Window r27 = getWindow();
        if (r27 == null) goto L87;
        r27.setNavigationBarColor(ContextCompat.getColor(getContext(), r26));
        return;
    L87:
        return;
    L76:
        r26 = com.obric.common.oui.c.f8205d;
        goto L81
    L78:
        if (this.q == false) goto L80;
        r26 = com.obric.common.oui.c.f8210i;
        goto L81
    L80:
        r26 = com.obric.common.oui.c.f8211j;
        goto L81
    L86:
        return;
    L22:
        r7 = null;
        goto L24
    L8:
        r0 = 0.0f;
        goto L9
    }

    public final void A(Integer r1) {
        this.E = r1;
    }

    public final void B(boolean r2) {
        FrameLayout r1 = (FrameLayout) findViewById(f.F);
        if (r1 == null) goto L6;
        r1.setFitsSystemWindows(r2);
        return;
    }

    public final void C(boolean r1) {
        this.F = r1;
    }

    public final void D(boolean r1) {
        this.z = r1;
    }

    public final void E(boolean r1) {
        this.s = r1;
    }

    public final void F(int r1) {
        this.p = r1;
    }

    public final void G(Integer r1) {
        this.G = r1;
    }

    public final void H(kotlin.n0.c.a<Boolean> r1) {
        this.H = r1;
    }

    public final void I(View.OnClickListener r1) {
        this.A = r1;
    }

    public final void J(OBasicPanel.b r1) {
    }

    public final void K(com.obric.oui.panel.header.b r1) {
        this.v = r1;
    }

    public final void L(boolean r1) {
        this.y = r1;
    }

    public final void M(boolean r1) {
        this.q = r1;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        o.f(r2, "ev");
        l<? super MotionEvent, Boolean> r0 = this.x;
        if (r0 == null) goto L9;
        if (r0.invoke(r2).booleanValue() == false) goto L9;
        return true;
    L9:
        return super.dispatchTouchEvent(r2);
    }

    public final int k() {
        if (this.w == false) goto L9;
        if (this.q == false) goto L7;
        int r0 = com.obric.common.oui.c.f8206e;
    L13:
        return ContextCompat.getColor(getContext(), r0);
    L7:
        r0 = com.obric.common.oui.c.f8205d;
        goto L13
    L9:
        if (this.q == false) goto L11;
        r0 = com.obric.common.oui.c.f8210i;
        goto L13
    L11:
        r0 = com.obric.common.oui.c.f8211j;
        goto L13
    }

    public final void n() {
        RadiusLayout r0 = this.K;
        if (r0 == null) goto L6;
        com.obric.oui.common.util.j.e(r0);
        return;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        kotlin.n0.c.a<Boolean> r0 = this.H;
        if (r0 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (r0.invoke().booleanValue() != true) goto L7;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        BottomSheetBehavior<FrameLayout> r5 = f();
        o.e(r5, "behavior");
        boolean r1 = true;
        r5.setHideable(true);
        f().E = this.F;
        f().j(!this.C);
        if (this.r == false) goto L5;
        h(true);
        BottomSheetBehavior<FrameLayout> r6 = f();
        o.e(r6, "behavior");
        r6.setPeekHeight(m());
        return;
    L5:
        BottomSheetBehavior<FrameLayout> r7 = f();
        com.obric.oui.panel.header.b r0 = this.v;
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        r7.setDraggable(r1);
        if (this.p <= 0) goto L18;
        f().m(this.p);
        if (this.z == false) goto L19;
        z(this.p);
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r0.c() != true) goto L10;
        goto L10
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.y == false) goto L6;
        p();
    L6:
        if (this.I == false) goto L8;
        Resources r3 = Resources.getSystem();
        o.e(r3, "Resources.getSystem()");
        float r0 = TypedValue.applyDimension(1, 20, r3.getDisplayMetrics());
    L9:
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(0);
        r4.setCornerRadii(new float[]{r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f});
        r4.setColor(k());
        FrameLayout r1 = g();
        if (r1 == null) goto L13;
        r1.setBackground(r4);
    L13:
        if (this.r == false) goto L15;
        z(l());
    L15:
        B(this.F);
        f().l(this.r);
        if (this.A == null) goto L20;
        View r2 = findViewById(f.V0);
        if (r2 == null) goto L20;
        r2.setOnClickListener(this.A);
    L20:
        c(this.B);
        return;
    L8:
        r0 = 0.0f;
        goto L9
    }

    public final void p() {
        FrameLayout r1 = (FrameLayout) findViewById(f.K);
        if (r1 == null) goto L6;
        r1.setMinimumHeight(0);
        return;
    }

    public final void q(boolean r1) {
        this.u = r1;
    }

    public final void r(boolean r1) {
        this.B = r1;
    }

    public final void s(boolean r1) {
        this.w = r1;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(N(r2, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        o.f(r3, "view");
        super.setContentView(N(0, r3, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        o.f(r2, "view");
        super.setContentView(N(0, r2, r3));
    }

    public final void t(boolean r1) {
        this.t = r1;
    }

    public final void u(boolean r1) {
        this.I = r1;
    }

    public final void v(Integer r1) {
        this.D = r1;
    }

    public final void w(boolean r1) {
        this.C = r1;
    }

    public final void x(l<? super MotionEvent, Boolean> r1) {
        this.x = r1;
    }

    public final void y(boolean r1) {
        this.r = r1;
    }

    public final void z(int r2) {
        FrameLayout r1 = (FrameLayout) findViewById(f.K);
        if (r1 == null) goto L6;
        r1.getLayoutParams().height = r2;
        return;
    }
}
