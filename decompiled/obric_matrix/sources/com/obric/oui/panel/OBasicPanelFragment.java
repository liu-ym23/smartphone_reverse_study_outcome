package com.obric.oui.panel;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.obric.common.oui.j;
import com.obric.oui.common.util.h;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001$\b\u0016\u0018\u00002\u00020\u0001B\b¢\u0006\u0005\bÁ\u0001\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u00022\f\b\u0001\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R$\u00109\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010(\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,R0\u0010N\u001a\u0010\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u0006\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010Q\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010(\u001a\u0004\bO\u0010*\"\u0004\bP\u0010,R$\u0010Y\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010]\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010(\u001a\u0004\b[\u0010*\"\u0004\b\\\u0010,R$\u0010e\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010i\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010(\u001a\u0004\bg\u0010*\"\u0004\bh\u0010,R\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010(R\"\u0010q\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010(\u001a\u0004\br\u0010*\"\u0004\bs\u0010,R*\u0010|\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001f\u0010\u0082\u0001\u001a\u00020}8\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R&\u0010\u008e\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008b\u0001\u0010(\u001a\u0005\b\u008c\u0001\u0010*\"\u0005\b\u008d\u0001\u0010,R2\u0010\u0096\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u008f\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R,\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R&\u0010¢\u0001\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010l\u001a\u0005\b \u0001\u0010n\"\u0005\b¡\u0001\u0010pR&\u0010¦\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b£\u0001\u0010(\u001a\u0005\b¤\u0001\u0010*\"\u0005\b¥\u0001\u0010,R&\u0010ª\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010(\u001a\u0005\b¨\u0001\u0010*\"\u0005\b©\u0001\u0010,R,\u0010²\u0001\u001a\u0005\u0018\u00010«\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R&\u0010¶\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b³\u0001\u0010(\u001a\u0005\b´\u0001\u0010*\"\u0005\bµ\u0001\u0010,R(\u0010º\u0001\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b·\u0001\u00104\u001a\u0005\b¸\u0001\u00106\"\u0005\b¹\u0001\u00108R&\u0010½\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b»\u0001\u0010(\u001a\u0005\b\u0098\u0001\u0010*\"\u0005\b¼\u0001\u0010,R(\u0010À\u0001\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u00104\u001a\u0005\b¾\u0001\u00106\"\u0005\b¿\u0001\u00108¨\u0006Â\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasicPanelFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lkotlin/f0;", "k", "()V", "l", "", "allowingStateLoss", "tryDismissWithAnimation", "(Z)Z", "Lcom/obric/oui/panel/BottomSheetBehavior;", "behavior", "g", "(Lcom/obric/oui/panel/BottomSheetBehavior;Z)V", "dismissAfterAnimation", "", "value", "out", "i", "(FZ)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "dismiss", "dismissAllowingStateLoss", "onDismiss", "com/obric/oui/panel/OBasicPanelFragment$a", "H", "Lcom/obric/oui/panel/OBasicPanelFragment$a;", "bottomSheetDismissCallback", "Z", "getBackgroundDimEnable", "()Z", "setBackgroundDimEnable", "(Z)V", "backgroundDimEnable", "j", "getFloatHeader", "setFloatHeader", "floatHeader", "", BaseSwitches.V, "Ljava/lang/Integer;", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "collapsedHeight", "Landroid/view/View$OnClickListener;", "F", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "outsideClickListener", "z", "getFixedPanelHeight", "setFixedPanelHeight", "fixedPanelHeight", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "t", "Lkotlin/n0/c/l;", "getDispatchTouchEvent", "()Lkotlin/n0/c/l;", "setDispatchTouchEvent", "(Lkotlin/n0/c/l;)V", "dispatchTouchEvent", "getAdaptNavBarColor", "setAdaptNavBarColor", "adaptNavBarColor", "Landroid/content/DialogInterface$OnDismissListener;", "p", "Landroid/content/DialogInterface$OnDismissListener;", "getOnDismissListener", "()Landroid/content/DialogInterface$OnDismissListener;", "setOnDismissListener", "(Landroid/content/DialogInterface$OnDismissListener;)V", "onDismissListener", "u", "getRemoveMinHeight", "setRemoveMinHeight", "removeMinHeight", "Lcom/obric/oui/panel/d/a;", "A", "Lcom/obric/oui/panel/d/a;", "getAnimConfig", "()Lcom/obric/oui/panel/d/a;", "setAnimConfig", "(Lcom/obric/oui/panel/d/a;)V", "animConfig", "C", "getAdaptRLSlide", "setAdaptRLSlide", "adaptRLSlide", "f", "waitingForDismissAllowingStateLoss", "I", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "maxPanelHeight", "isExpandable", "setExpandable", "", "Lcom/obric/oui/panel/BottomSheetBehavior$d;", "y", "Ljava/util/List;", "getBottomSheetCallbacks", "()Ljava/util/List;", "setBottomSheetCallbacks", "(Ljava/util/List;)V", "bottomSheetCallbacks", "Lcom/obric/oui/panel/d/b;", "E", "Lcom/obric/oui/panel/d/b;", "getAnimController$OUI_standardRelease", "()Lcom/obric/oui/panel/d/b;", "animController", "Lcom/obric/oui/panel/OBasicPanel$b;", "G", "Lcom/obric/oui/panel/OBasicPanel$b;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$b;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$b;)V", "padCompatConfig", "D", "n", "setDisableAutoAdaptHeight", "disableAutoAdaptHeight", "Lkotlin/Function0;", "o", "Lkotlin/n0/c/a;", "getOnDialogBackPressCallback", "()Lkotlin/n0/c/a;", "setOnDialogBackPressCallback", "(Lkotlin/n0/c/a;)V", "onDialogBackPressCallback", "Lcom/obric/oui/panel/header/b;", "m", "Lcom/obric/oui/panel/header/b;", "getPanelHeader", "()Lcom/obric/oui/panel/header/b;", "setPanelHeader", "(Lcom/obric/oui/panel/header/b;)V", "panelHeader", "B", "getStyleId", "setStyleId", "styleId", "x", "getFitsSystemWindows", "setFitsSystemWindows", "fitsSystemWindows", "h", "getUseToneBg", "setUseToneBg", "useToneBg", "Landroid/content/DialogInterface$OnCancelListener;", "q", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "onCancelListener", "r", "getClipTopCorner", "setClipTopCorner", "clipTopCorner", "w", "getExpandedHeight", "setExpandedHeight", "expandedHeight", "s", "setAutoSwitchDayNight", "autoSwitchDayNight", "getNavBarColor", "setNavBarColor", "navBarColor", "<init>", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class OBasicPanelFragment extends AppCompatDialogFragment {
    private com.obric.oui.panel.d.a A;
    private int B;
    private boolean C;
    private boolean D;
    private final com.obric.oui.panel.d.b E;
    private View.OnClickListener F;
    private OBasicPanel.b G;
    private final a H;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11197l;
    private com.obric.oui.panel.header.b m;

    @ColorInt
    private Integer n;
    private kotlin.n0.c.a<Boolean> o;
    private DialogInterface.OnDismissListener p;
    private DialogInterface.OnCancelListener q;
    private boolean r;
    private boolean s;
    private l<? super MotionEvent, Boolean> t;
    private boolean u;
    private Integer v;
    private Integer w;
    private boolean x;
    private List<? extends BottomSheetBehavior.d> y;
    private boolean z;

    public static final class a extends BottomSheetBehavior.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f11198a;

        a(OBasicPanelFragment r1) {
            this.f11198a = r1;
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void c(View r1, float r2) {
            o.f(r1, "bottomSheet");
        }

        @Override // com.obric.oui.panel.BottomSheetBehavior.d
        public void d(View r2, int r3) {
            o.f(r2, "bottomSheet");
            if (r3 != 5) goto L6;
            OBasicPanelFragment.b(this.f11198a);
            return;
        }
    }

    static final class b extends q implements l<Float, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f11199f;

        b(OBasicPanelFragment r1) {
            this.f11199f = r1;
            super(1);
        }

        public final void a(float r2) {
            OBasicPanelFragment.c(this.f11199f, r2, false);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Float r1) {
            a(r1.floatValue());
            return f0.f18324a;
        }
    }

    static final class c extends q implements l<Float, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f11200f;

        c(OBasicPanelFragment r1) {
            this.f11200f = r1;
            super(1);
        }

        public final void a(float r4) {
            OBasicPanelFragment.j(this.f11200f, r4, false, 2, null);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Float r1) {
            a(r1.floatValue());
            return f0.f18324a;
        }
    }

    static final class d implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBasicPanelFragment f11201a;

        d(OBasicPanelFragment r1) {
            this.f11201a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r1) {
            OBasicPanelFragment.d(this.f11201a);
        }
    }

    public OBasicPanelFragment() {
        this.f11192g = -1;
        this.f11196k = true;
        this.r = true;
        this.x = true;
        this.B = j.f8278c;
        this.E = new com.obric.oui.panel.d.b();
        this.H = new a(this);
    }

    public static final /* synthetic */ void b(OBasicPanelFragment r0) {
        r0.dismissAfterAnimation();
    }

    public static final /* synthetic */ void c(OBasicPanelFragment r0, float r1, boolean r2) {
        r0.i(r1, r2);
    }

    public static final /* synthetic */ void d(OBasicPanelFragment r0) {
        r0.k();
    }

    private final void dismissAfterAnimation() {
        if (this.f11191f == false) goto L5;
        super.dismissAllowingStateLoss();
        return;
    L5:
        super.dismiss();
    }

    private final void g(@NonNull BottomSheetBehavior<?> r2, boolean r3) {
        this.f11191f = r3;
        if (r2.getState() != 5) goto L6;
        dismissAfterAnimation();
        return;
    L6:
        if ((getDialog() instanceof BottomSheetDialog) == false) goto L13;
        BottomSheetDialog r4 = (BottomSheetDialog) getDialog();
        if (r4 == null) goto L10;
        r4.removeDefaultCallback();
    L10:
        BottomSheetDialog r5 = (BottomSheetDialog) getDialog();
        if (r5 == null) goto L13;
        r5.e();
    L13:
        r2.e(this.H);
        r2.setState(5);
    }

    private final void i(float r2, boolean r3) {
        List<? extends BottomSheetBehavior.d> r1 = this.y;
        if (r1 == null) goto L11;
        Iterator<T> r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L18;
        BottomSheetBehavior.d r0 = (BottomSheetBehavior.d) r4.next();
        if (r3 == true) goto L9;
        r0.a(r2);
        goto L6
    L9:
        r0.b(r2);
        goto L6
    L18:
        return;
    }

    static /* synthetic */ void j(OBasicPanelFragment r0, float r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        r0.i(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchAnimProgress");
    }

    private final void k() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        View r2 = r1.getDecorView();
    L8:
        if (r2 == null) goto L15;
        com.obric.oui.panel.d.a r3 = this.A;
        if (r3 == null) goto L16;
        ObjectAnimator r4 = r3.a(r2);
        if (r4 == null) goto L17;
        this.E.a(r4, new b(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }

    private final void l() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        View r2 = r1.getDecorView();
    L8:
        if (r2 == null) goto L15;
        com.obric.oui.panel.d.a r3 = this.A;
        if (r3 == null) goto L16;
        ObjectAnimator r4 = r3.b(r2);
        if (r4 == null) goto L17;
        this.E.b(r4, new c(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r2 = null;
        goto L8
    }

    private final boolean tryDismissWithAnimation(boolean r4) {
        Dialog r0 = getDialog();
        if ((r0 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r1 = (BottomSheetDialog) r0;
        BottomSheetBehavior<FrameLayout> r2 = r1.f();
        o.e(r2, "dialog.behavior");
        if (r2.isHideable() == true) goto L7;
        return false;
    L7:
        if (r1.getDismissWithAnimation() == false) goto L13;
        g(r2, r4);
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        l();     // Catch: Exception -> L7
        if (tryDismissWithAnimation(true) == true) goto L5;
        super.dismiss();     // Catch: Exception -> L7
    L5:
        f0 r2 = f0.f18324a;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        h.a("Try exception occur " + e.getMessage());
        f0 r3 = f0.f18324a;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        l();
        super.dismissAllowingStateLoss();
    }

    public final boolean m() {
        return this.s;
    }

    public final boolean n() {
        return this.D;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r2) {
        o.f(r2, "dialog");
        l();
        super.onCancel(r2);
        DialogInterface.OnCancelListener r1 = this.q;
        if (r1 == null) goto L6;
        r1.onCancel(r2);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        Context r0 = requireContext();
        o.e(r0, "requireContext()");
        OBasePanelDialog r4 = new OBasePanelDialog(r0, this.B);
        r4.F(this.f11192g);
        r4.M(this.f11193h);
        r4.y(this.f11194i);
        r4.E(this.f11195j);
        r4.t(this.f11196k);
        r4.q(this.f11197l);
        r4.K(this.m);
        r4.G(this.n);
        r4.H(this.o);
        r4.u(this.r);
        r4.s(this.s);
        r4.x(this.t);
        r4.L(this.u);
        r4.J(this.G);
        r4.D(this.z);
        r4.I(this.F);
        r4.v(this.v);
        r4.A(this.w);
        r4.C(this.x);
        r4.r(this.C);
        r4.w(this.D);
        List<? extends BottomSheetBehavior.d> r2 = this.y;
        if (r2 == null) goto L9;
        if (r2 == null) goto L9;
        Iterator<T> r5 = r2.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r4.d((BottomSheetBehavior.d) r5.next());
    L9:
        return r4;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        o.f(r2, "dialog");
        super.onDismiss(r2);
        DialogInterface.OnDismissListener r1 = this.p;
        if (r1 == null) goto L6;
        r1.onDismiss(r2);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        o.f(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L6;
        r4.setOnShowListener(new d(this));
        return;
    }
}
