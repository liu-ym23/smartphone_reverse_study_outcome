package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.common.oui.f;
import com.obric.common.oui.g;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\bN\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010(\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R&\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00109\u001a\u0012\u0012\u0004\u0012\u0002070)j\b\u0012\u0004\u0012\u000207`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010-R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010E\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00101\u001a\u0004\bC\u00103\"\u0004\bD\u00105R$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lcom/obric/oui/sheet/OActionSheet;", "Lcom/obric/oui/panel/OBasicPanelFragment;", "", "scene", "", "p", "(Ljava/lang/String;)I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "Lkotlin/f0;", "onDismiss", "(Landroid/content/DialogInterface;)V", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "()V", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "getMTitleText", "()Landroid/widget/TextView;", "setMTitleText", "(Landroid/widget/TextView;)V", "mTitleText", "O", "getMSubTitleText", "setMSubTitleText", "mSubTitleText", "Ljava/util/ArrayList;", "Landroid/content/DialogInterface$OnDismissListener;", "Lkotlin/collections/ArrayList;", "L", "Ljava/util/ArrayList;", "onDismissListeners", "", "K", "Ljava/lang/CharSequence;", "getMSubTitle", "()Ljava/lang/CharSequence;", "setMSubTitle", "(Ljava/lang/CharSequence;)V", "mSubTitle", "Lcom/obric/oui/sheet/OActionSheet$a;", "I", "mActions", "Landroid/widget/LinearLayout;", "P", "Landroid/widget/LinearLayout;", "getMActionContainer", "()Landroid/widget/LinearLayout;", "setMActionContainer", "(Landroid/widget/LinearLayout;)V", "mActionContainer", "J", "getMTitle", "setMTitle", "mTitle", "Landroid/view/View$OnClickListener;", "M", "Landroid/view/View$OnClickListener;", "o", "()Landroid/view/View$OnClickListener;", "setMCancelBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "mCancelBtnClickListener", "<init>", "a", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OActionSheet extends OBasicPanelFragment {
    private ArrayList<a> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private CharSequence f11371J;
    private CharSequence K;
    private final ArrayList<DialogInterface.OnDismissListener> L;
    private View.OnClickListener M;
    private TextView N;
    private TextView O;
    private LinearLayout P;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f11372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f11373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private p<? super View, ? super DialogFragment, f0> f11375d;

        public final boolean a() {
            return this.f11374c;
        }

        public final p<View, DialogFragment, f0> b() {
            return this.f11375d;
        }

        public final CharSequence c() {
            return this.f11373b;
        }

        public final CharSequence d() {
            return this.f11372a;
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f11376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ OActionSheet f11377g;

        b(a r1, OActionSheet r2, LinearLayout r3) {
            this.f11376f = r1;
            this.f11377g = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            p<View, DialogFragment, f0> r0 = this.f11376f.b();
            if (r0 == null) goto L5;
            o.e(r3, "it");
            f0 r4 = r0.invoke(r3, this.f11377g);
        L5:
            this.f11377g.dismissAllowingStateLoss();
        }
    }

    public static final class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
            o.f(r2, "host");
            o.f(r3, LocationMonitorConst.INFO);
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName("android.widget.ImageButton");
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OActionSheet f11378f;

        d(OActionSheet r1) {
            this.f11378f = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.f11378f.o();
            if (r0 == null) goto L5;
            r0.onClick(r2);
        L5:
            this.f11378f.dismissAllowingStateLoss();
        }
    }

    public static final class e extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11379a;

        e(a r1) {
            this.f11379a = r1;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfo r3) {
            o.f(r2, "host");
            o.f(r3, LocationMonitorConst.INFO);
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setClassName("android.widget.ImageButton");
            if (this.f11379a.a() == false) goto L6;
            r2.setSelected(true);
            return;
        }
    }

    static {
    }

    public OActionSheet() {
        this.I = new ArrayList();
        this.L = new ArrayList();
    }

    private final int p(String r2) {
        switch(r2.hashCode()) {
            case -1951390164: goto L34;
            case -1672427580: goto L28;
            case -1210163878: goto L22;
            case -1209866229: goto L16;
            case 1704015448: goto L11;
            case 1915336728: goto L6;
            default: goto L39;
        };
    L39:
        int r3 = 0;
    L41:
        return ContextCompat.getColor(requireContext(), r3);
    L6:
        if (r2.equals("extension_subtitle") == false) goto L39;
        if (m() == true) goto L31;
    L32:
        r3 = com.obric.common.oui.c.s;
    L31:
        r3 = com.obric.common.oui.c.t;
        goto L41
    L11:
        if (r2.equals("extension_title") == false) goto L39;
        if (m() == false) goto L32;
    L16:
        if (r2.equals("divider_view") == false) goto L39;
        if (m() == false) goto L20;
        r3 = com.obric.common.oui.c.f8207f;
        goto L41
    L20:
        r3 = com.obric.common.oui.c.f8204c;
        goto L41
    L22:
        if (r2.equals("divider_line") == false) goto L39;
        if (m() == false) goto L26;
        r3 = com.obric.common.oui.c.f8213l;
        goto L41
    L26:
        r3 = com.obric.common.oui.c.m;
        goto L41
    L28:
        if (r2.equals("item_subtitle") == false) goto L39;
        if (m() == false) goto L32;
    L34:
        if (r2.equals("item_title") == false) goto L39;
        if (m() == false) goto L38;
        r3 = com.obric.common.oui.c.p;
        goto L41
    L38:
        r3 = com.obric.common.oui.c.q;
        goto L41
    }

    public final View.OnClickListener o() {
        return this.M;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        Context r0 = requireContext();
        o.e(r0, "requireContext()");
        OBasePanelDialog r6 = new OBasePanelDialog(r0, 0, 2, null);
        r6.y(false);
        r6.L(true);
        r6.w(n());
        return r6;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        o.f(r1, "inflater");
        return r1.inflate(g.w, r2, false);
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        o.f(r2, "dialog");
        super.onDismiss(r2);
        Iterator<T> r1 = this.L.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) r1.next()).onDismiss(r2);
        goto L4
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if ((getDialog() instanceof OBasePanelDialog) == false) goto L6;
        Dialog r1 = getDialog();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
        ((OBasePanelDialog) r1).n();
        return;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r17, Bundle r18) {
        o.f(r17, "view");
        super.onViewCreated(r17, r18);
        LinearLayout r2 = (LinearLayout) r17.findViewById(f.s);
        if (m() == false) goto L5;
        Context r3 = requireContext();
        int r4 = com.obric.common.oui.e.f8230e;
    L6:
        Drawable r5 = ContextCompat.getDrawable(r3, r4);
        if (r2 == null) goto L9;
        r2.setBackground(r5);
    L9:
        r17.findViewById(f.O).setBackgroundColor(p("divider_view"));
        LinearLayout r6 = (LinearLayout) r17.findViewById(f.T0);
        TextView r7 = (TextView) r6.findViewById(f.u);
        this.N = r7;
        if (r7 == null) goto L12;
        r7.setTextColor(p("extension_title"));
    L12:
        TextView r8 = (TextView) r6.findViewById(f.t);
        this.O = r8;
        if (r8 == null) goto L15;
        r8.setTextColor(p("extension_subtitle"));
    L15:
        View r9 = r6.findViewById(f.U0);
        r9.setBackgroundColor(p("divider_line"));
        o.e(r9, "divider");
        int r10 = 4;
        r9.setVisibility(4);
        CharSequence r11 = this.f11371J;
        if (r11 == null) goto L26;
        TextView r12 = this.N;
        if (r12 == null) goto L20;
        r12.setText(r11);
    L20:
        TextView r13 = this.N;
        if (r13 == null) goto L23;
        r13.setVisibility(0);
    L23:
        TextView r14 = this.O;
        if (r14 == null) goto L32;
        r14.setMaxLines(1);
    L32:
        CharSequence r15 = this.K;
        if (r15 == null) goto L40;
        TextView r16 = this.O;
        if (r16 == null) goto L37;
        r16.setText(r15);
    L37:
        TextView r19 = this.O;
        if (r19 == null) goto L44;
        r19.setVisibility(0);
    L44:
        if (this.f11371J == null) goto L46;
    L48:
        TextView r20 = (TextView) r17.findViewById(f.C);
        if (r20 == null) goto L51;
        r20.setTextColor(p("item_title"));
    L51:
        o.e(r20, "cancelAction");
        r20.setAccessibilityDelegate(new c());
        r20.setOnClickListener(new d(this));
        this.P = (LinearLayout) r17.findViewById(f.r);
        Iterator<T> r1 = this.I.iterator();
    L53:
        if (r1.hasNext() == false) goto L82;
        a r21 = (a) r1.next();
        View r110 = LayoutInflater.from(getContext()).inflate(g.r, this.P, false);
        r110.setOnClickListener(new b(r21, this, r6));
        TextView r111 = (TextView) r110.findViewById(f.u);
        TextView r112 = (TextView) r110.findViewById(f.t);
        View r113 = r110.findViewById(f.U0);
        if (r111 == null) goto L57;
        r111.setTextColor(p("item_title"));
    L57:
        if (r112 == null) goto L59;
        r112.setTextColor(p("item_subtitle"));
    L59:
        if (r113 == null) goto L62;
        r113.setBackgroundColor(p("divider_line"));
    L62:
        if (this.I.indexOf(r21) != 0) goto L66;
        o.e(r6, "titleContainer");
        if (r6.getVisibility() != 8) goto L66;
        o.e(r113, "itemDivider");
        r113.setVisibility(r10);
    L68:
        if (r21.d() == null) goto L70;
        o.e(r111, "titleText");
        r111.setText(r21.d());
        r111.setVisibility(0);
        o.e(r110, "actionView");
        r110.setContentDescription(r21.d());
        o.e(r112, "subTitleText");
        r112.setMaxLines(1);
    L72:
        if (r21.c() == null) goto L74;
        r112.setText(r21.c());
        r112.setVisibility(0);
        o.e(r110, "actionView");
        r110.setContentDescription(r110.getContentDescription() + ", " + r21.c());
    L76:
        if (r21.a() == false) goto L78;
        r111.setTextColor(ContextCompat.getColor(requireContext(), com.obric.common.oui.c.o));
    L78:
        o.e(r110, "actionView");
        r110.setAccessibilityDelegate(new e(r21));
        LinearLayout r22 = this.P;
        if (r22 == null) goto L81;
        r22.addView(r110);
    L81:
        r10 = 4;
        goto L53
    L74:
        r112.setVisibility(8);
        goto L76
    L70:
        o.e(r111, "titleText");
        r111.setVisibility(8);
        o.e(r112, "subTitleText");
        r112.setMaxLines(2);
    L66:
        o.e(r113, "itemDivider");
        r113.setVisibility(0);
        goto L68
    L82:
        return;
    L46:
        if (this.K != null) goto L48;
        o.e(r6, "titleContainer");
        r6.setVisibility(8);
        goto L48
    L40:
        TextView r23 = this.O;
        if (r23 == null) goto L44;
        r23.setVisibility(8);
        goto L44
    L26:
        TextView r24 = this.N;
        if (r24 == null) goto L29;
        r24.setVisibility(8);
    L29:
        TextView r25 = this.O;
        if (r25 == null) goto L32;
        r25.setMaxLines(2);
        goto L32
    L5:
        r3 = requireContext();
        r4 = com.obric.common.oui.e.f8229d;
        goto L6
    }
}
