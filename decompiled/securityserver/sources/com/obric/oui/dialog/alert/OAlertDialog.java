package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import com.ttnet.org.chromium.net.NetError;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@RequiresApi(30)
@Metadata
public class OAlertDialog extends AbstractDialog {
    public static final /* synthetic */ int y = 0;
    public final String p;
    public final FrameLayout q;
    public StyleController r;
    public final TextView s;
    public final TextView t;
    public final FrameLayout u;
    public StyleController v;
    public final FrameLayout w;
    public StyleController x;

    public OAlertDialog(Context r4) {
        Intrinsics.f(r4, "context");
        super(r4);
        this.p = "OAlertDialog";
        this.q = (FrameLayout) findViewById(R.id.iconPanel);
        TextView r5 = (TextView) findViewById(R.id.textTitle);
        TextView r1 = null;
        if (r5 != null) goto L5;
        r5 = null;
    L12:
        this.s = r5;
        TextView r6 = (TextView) findViewById(R.id.textSubTitle);
        if ((r6 instanceof OTextView) == false) goto L16;
        r1 = r6;
    L16:
        OTextView r2 = (OTextView) r1;
        if (r2 == null) goto L19;
        r2.setEnableAutoAlignLeft(true);
    L19:
        this.t = r6;
        this.u = (FrameLayout) findViewById(R.id.button_container);
        this.w = (FrameLayout) findViewById(R.id.body_container);
        return;
    L5:
        if ((r5 instanceof OTextView) == true) goto L7;
        TextView r3 = null;
    L8:
        OTextView r7 = (OTextView) r3;
        if (r7 == null) goto L12;
        r7.setEnableAutoAlignLeft(true);
        goto L12
    L7:
        r3 = r5;
        goto L8
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int b() {
        return R.layout.o_alert_dialog;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ViewPropertySpringAnimator r0 = DialogAnimStyle.e(d(), getWindow(), true, true);
        Function1<ViewPropertySpringAnimator<View>, Unit> r1 = new OAlertDialog$performExitAnimation$$inlined$apply$lambda$1(this);
        ViewPropertySpringAnimator.c(r0, null, new OAlertDialog$performExitAnimation$$inlined$apply$lambda$2(this), r1, 1);
        r0.d();
    }

    public final void g() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        StyleController r2 = this.r;
        if (r2 == null) goto L5;
        r2.b(this);
    L5:
        StyleController r3 = this.v;
        if (r3 == null) goto L8;
        r3.b(this);
    L8:
        StyleController r4 = this.x;
        if (r4 == null) goto L12;
        r4.b(this);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        d().post(new OAlertDialog$performEnterAnimation$1(this));
        StyleController r0 = this.v;
        if ((r0 instanceof ButtonStyleController) == false) goto L8;
        if (r0 == null) goto L7;
        ButtonStyleController r1 = (ButtonStyleController) r0;
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
    L8:
        TextView r2 = this.t;
        if (r2 == null) goto L12;
        r2.postDelayed(new AnonymousClass1(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public final void show() {
        super.show();
        Context r1 = getContext();
        Intrinsics.e(r1, "context");
        String r2 = this.p;
        FrameLayout r10 = this.w;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 0) goto L8;
        return;
    L8:
        if (ResourceUtils.a(r1) == false) goto L119;
        int r11 = OWindowConfigController.b(r1);     // Catch: Exception -> L14
        if (this.n == false) goto L16;
        float r12 = 16;
        Resources r15 = Resources.getSystem();     // Catch: Exception -> L14
        Intrinsics.e(r15, "Resources.getSystem()");     // Catch: Exception -> L14
        r11 = r11 - MathKt.a(TypedValue.applyDimension(1, r12, r15.getDisplayMetrics()));     // Catch: Exception -> L14
    L16:
        FrameLayout r13 = this.q;     // Catch: Exception -> L14
        if (r13 != null) goto L19;
        int r14 = 0;
    L33:
        TextView r16 = this.s;     // Catch: Exception -> L14
        if (r16 != null) goto L36;
        int r17 = 0;
    L50:
        TextView r18 = this.t;     // Catch: Exception -> L14
        if (r18 != null) goto L53;
        String r19 = r2;
        int r3 = 0;
    L69:
        FrameLayout r0 = this.u;     // Catch: Exception -> L108
        if (r0 != null) goto L72;
        int r4 = 0;
    L86:
        ViewGroup.LayoutParams r5 = r10.getLayoutParams();     // Catch: Exception -> L108
        if (r5 != null) goto L90;
    L88:
        ViewGroup.LayoutParams r110 = null;
    L92:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;     // Catch: Exception -> L108
        if (r111 == null) goto L95;
        int r6 = r111.topMargin;     // Catch: Exception -> L108
    L96:
        int r7 = OUnitExtensionKt.b(r1);     // Catch: Exception -> L108
        float r112 = HttpStatus.SC_MULTIPLE_CHOICES;
        Resources r8 = Resources.getSystem();     // Catch: Exception -> L108
        Intrinsics.e(r8, "Resources.getSystem()");     // Catch: Exception -> L108
        if (r7 <= MathKt.a(TypedValue.applyDimension(1, r112, r8.getDisplayMetrics()))) goto L99;
        int r9 = r7 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L108
    L100:
        int r20 = (((((r9 - r11) - r14) - r17) - r3) - r4) - r6;     // Catch: Exception -> L108
        Resources r113 = Resources.getSystem();     // Catch: Exception -> L108
        Intrinsics.e(r113, "Resources.getSystem()");     // Catch: Exception -> L108
        int r21 = RangesKt.b(r20, 0, r9 - MathKt.a(TypedValue.applyDimension(1, 52, r113.getDisplayMetrics())));     // Catch: Exception -> L108
        Resources r114 = Resources.getSystem();     // Catch: Exception -> L108
        Intrinsics.e(r114, "Resources.getSystem()");     // Catch: Exception -> L108
        r10.measure(View.MeasureSpec.makeMeasureSpec(MathKt.a(TypedValue.applyDimension(1, 440, r114.getDisplayMetrics())), Integer.MIN_VALUE), 0);     // Catch: Exception -> L108
        int r115 = r10.getMeasuredHeight();     // Catch: Exception -> L108
        String r22 = r19;
        L.a(r22, "adjustContentHeight, maxHeight: " + r9 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r20 + ", measured BodyHeight: " + r115 + ", maxBodyHeight: " + r21 + ", iconPanelVerticalSpace: " + r14 + ", titleVerticalSpace: " + r17 + ", messageVerticalSpace: " + r3 + ", buttonVerticalSpace: " + r4 + ", bodyMarginSpace: " + r6);     // Catch: Exception -> L106
        if (r115 <= r21) goto L120;
        L.d(r22, "adjustContentHeight, from: " + r115 + " to: " + r21);     // Catch: Exception -> L106
        ViewGroup.LayoutParams r23 = r10.getLayoutParams();     // Catch: Exception -> L106
        r23.height = r21;     // Catch: Exception -> L106
        r10.setLayoutParams(r23);     // Catch: Exception -> L106
        return;
    L120:
        return;
    L106:
        e = e;
    L110:
        L.c(r22, "adjustContentHeight error", e);
        return;
    L108:
        e = e;
        r22 = r19;
        goto L110
    L99:
        Resources r24 = Resources.getSystem();     // Catch: Exception -> L108
        Intrinsics.e(r24, "Resources.getSystem()");     // Catch: Exception -> L108
        r9 = MathKt.a(TypedValue.applyDimension(1, r112, r24.getDisplayMetrics()));     // Catch: Exception -> L108
        goto L100
    L95:
        r6 = 0;
        goto L96
    L90:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L88;
        r110 = r5;
        goto L92
    L72:
        r0.measure(0, 0);     // Catch: Exception -> L108
        if (r0.getVisibility() != 0) goto L75;
        int r25 = r0.getMeasuredHeight();     // Catch: Exception -> L108
    L76:
        ViewGroup.LayoutParams r26 = r0.getLayoutParams();     // Catch: Exception -> L108
        if (r26 != null) goto L80;
    L78:
        r26 = null;
    L81:
        ViewGroup.MarginLayoutParams r27 = (ViewGroup.MarginLayoutParams) r26;     // Catch: Exception -> L108
        if (r27 == null) goto L84;
        int r28 = r27.topMargin;     // Catch: Exception -> L108
    L85:
        r4 = r28 + r25;     // Catch: Exception -> L108
        goto L86
    L84:
        r28 = 0;
        goto L85
    L80:
        if ((r26 instanceof ViewGroup.MarginLayoutParams) == false) goto L78;
    L75:
        r25 = 0;
        goto L76
    L53:
        r18.measure(0, 0);     // Catch: Exception -> L14
        if (r18.getVisibility() != 0) goto L56;
        int r29 = r18.getMeasuredHeight();     // Catch: Exception -> L14
    L57:
        ViewGroup.LayoutParams r116 = r18.getLayoutParams();     // Catch: Exception -> L14
        if (r116 != null) goto L61;
        r19 = r2;
    L60:
        r116 = null;
    L64:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;     // Catch: Exception -> L108
        if (r117 == null) goto L67;
        int r30 = r117.topMargin;     // Catch: Exception -> L108
    L68:
        r3 = r30 + r29;     // Catch: Exception -> L108
        goto L69
    L67:
        r30 = 0;
        goto L68
    L61:
        r19 = r2;
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L60;
    L56:
        r29 = 0;
        goto L57
    L36:
        r16.measure(0, 0);     // Catch: Exception -> L14
        if (r16.getVisibility() != 0) goto L39;
        int r118 = r16.getMeasuredHeight();     // Catch: Exception -> L14
    L40:
        ViewGroup.LayoutParams r119 = r16.getLayoutParams();     // Catch: Exception -> L14
        if (r119 != null) goto L44;
    L42:
        r119 = null;
    L45:
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;     // Catch: Exception -> L14
        if (r120 == null) goto L48;
        int r121 = r120.topMargin;     // Catch: Exception -> L14
    L49:
        r17 = r118 + r121;     // Catch: Exception -> L14
        goto L50
    L48:
        r121 = 0;
        goto L49
    L44:
        if ((r119 instanceof ViewGroup.MarginLayoutParams) == false) goto L42;
    L39:
        r118 = 0;
        goto L40
    L19:
        r13.measure(0, 0);     // Catch: Exception -> L14
        if (r13.getVisibility() != 0) goto L22;
        int r122 = r13.getMeasuredHeight();     // Catch: Exception -> L14
    L23:
        ViewGroup.LayoutParams r123 = r13.getLayoutParams();     // Catch: Exception -> L14
        if (r123 != null) goto L27;
    L25:
        r123 = null;
    L28:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;     // Catch: Exception -> L14
        if (r124 == null) goto L31;
        int r125 = r124.topMargin;     // Catch: Exception -> L14
    L32:
        r14 = r122 + r125;     // Catch: Exception -> L14
        goto L33
    L31:
        r125 = 0;
        goto L32
    L27:
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
    L22:
        r122 = 0;
    L14:
        e = e;
        r22 = r2;
        goto L110
    }
}
