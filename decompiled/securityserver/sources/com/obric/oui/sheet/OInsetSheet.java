package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import com.bytedance.securityserver.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public class OInsetSheet extends Dialog {
    public final FrameLayout b;
    public final FrameLayout c;
    public final FrameLayout e;
    public final RadiusLayout f;
    public boolean i;
    public PanelWidth j;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final enum PanelWidth extends Enum<PanelWidth> {
        public static final PanelWidth b = null;
        public static final /* synthetic */ PanelWidth[] c = null;

        static {
            PanelWidth r0 = new PanelWidth("NARROW_WIDTH", 0);
            PanelWidth r1 = new PanelWidth("BOARD_WIDTH", 1);
            b = r1;
            c = new PanelWidth[]{r0, r1};
        }

        public static PanelWidth valueOf(String r1) {
            return (PanelWidth) Enum.valueOf(PanelWidth.class, r1);
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) c.clone();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[PanelWidth.values().length];
            r0[0] = 1;
            r0[1] = 2;
            int[] r1 = new int[PanelWidth.values().length];
            r1[0] = 1;
            r1[1] = 2;
            int[] r2 = new int[PanelWidth.values().length];
            r2[0] = 1;
            r2[1] = 2;
        }
    }

    static {
    }

    public OInsetSheet(Context r3) {
        Intrinsics.f(r3, "context");
        super(r3);
        this.j = PanelWidth.b;
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.requestFeature(1);
    L5:
        setContentView(R.layout.o_inset_sheet_container);
        View r5 = findViewById(R.id.root_constraint);
        Intrinsics.e(r5, "findViewById(R.id.root_constraint)");
        RadiusLayout r6 = (RadiusLayout) r5;
        this.f = r6;
        r6.setMeasureHeightUnspecified(true);
        View r7 = findViewById(R.id.header_container);
        Intrinsics.e(r7, "findViewById(R.id.header_container)");
        this.b = (FrameLayout) r7;
        View r8 = findViewById(R.id.content_container);
        Intrinsics.e(r8, "findViewById(R.id.content_container)");
        this.e = (FrameLayout) r8;
        View r9 = findViewById(R.id.foot_container);
        Intrinsics.e(r9, "findViewById(R.id.foot_container)");
        this.c = (FrameLayout) r9;
        RadiusLayout r10 = this.f;
        if (r10 == null) goto L13;
        DialogAnimStyle.b(r10);
        RadiusLayout r11 = this.f;
        if (r11 == null) goto L11;
        r11.setOnApplyWindowInsetsListener(new OInsetSheet$setOnApplyWindowInsetsListener$1(this));
        return;
    L11:
        Intrinsics.m("rootContainer");
        throw null;
    L13:
        Intrinsics.m("rootContainer");
        throw null;
    }

    public static void c(ViewGroup r0, View r1) {
        if (r0 == null) goto L4;
        ViewExtensionsKt.e(r0);
    L4:
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (r0 == null) goto L9;
        r0.addView(r1);
        return;
    }

    public final RadiusLayout a() {
        RadiusLayout r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("rootContainer");
        throw null;
    }

    public final void b() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        RadiusLayout r0 = this.f;
        if (r0 == null) goto L6;
        ViewPropertySpringAnimator r1 = DialogAnimStyle.e(r0, getWindow(), !this.i, true);
        ViewPropertySpringAnimator.c(r1, null, new OInsetSheet$performExitAnimation$$inlined$apply$lambda$2(this), new OInsetSheet$performExitAnimation$$inlined$apply$lambda$1(this), 1);
        r1.d();
        return;
    L6:
        Intrinsics.m("rootContainer");
        throw null;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        RadiusLayout r0 = this.f;
        if (r0 == null) goto L6;
        r0.post(new OInsetSheet$performEnterAnimation$1(this));
        return;
    L6:
        Intrinsics.m("rootContainer");
        throw null;
    }

    @Override // android.app.Dialog
    public void show() {
        Context r0 = getContext();
        Intrinsics.e(r0, "context");
        if (ResourceUtils.a(r0) == true) goto L50;
    L35:
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L51;
        r1.setBackgroundDrawableResource(android.R.color.transparent);
        r1.setNavigationBarContrastEnforced(false);
        r1.setDecorFitsSystemWindows(false);
        r1.clearFlags(134217728);
        r1.addFlags(Integer.MIN_VALUE);
        r1.setNavigationBarColor(0);
        r1.setNavigationBarDividerColor(0);
        if (this.i == false) goto L40;
        r1.clearFlags(2);
    L41:
        Context r2 = r1.getContext();
        Intrinsics.e(r2, "context");
        Resources r3 = r2.getResources();
        Intrinsics.e(r3, "context.resources");
        if ((r3.getConfiguration().uiMode & 48) != 32) goto L44;
        float r4 = 0.5f;
    L45:
        WindowManager.LayoutParams r5 = r1.getAttributes();
        if ((!this.i) == true) goto L48;
        r5.dimAmount = r4;
    L48:
        r5.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r5.gravity = 80;
        r1.setAttributes(r5);
        return;
    L44:
        r4 = 0.16f;
        goto L45
    L40:
        r1.addFlags(2);
        goto L41
    L51:
        return;
    L50:
        RadiusLayout r6 = this.f;     // Catch: Exception -> L20
        if (r6 == null) goto L32;
        r6.measure(0, 0);     // Catch: Exception -> L20
        int r7 = OWindowConfigController.b(r0);     // Catch: Exception -> L20
        Resources r10 = Resources.getSystem();     // Catch: Exception -> L20
        Intrinsics.e(r10, "Resources.getSystem()");     // Catch: Exception -> L20
        int r8 = MathKt.a(TypedValue.applyDimension(1, 296, r10.getDisplayMetrics())) - r7;     // Catch: Exception -> L20
        FrameLayout r9 = this.b;     // Catch: Exception -> L20
        if (r9 == null) goto L30;
        int r11 = r8 - r9.getMeasuredHeight();     // Catch: Exception -> L20
        FrameLayout r12 = this.c;     // Catch: Exception -> L20
        if (r12 == null) goto L28;
        int r13 = r11 - r12.getMeasuredHeight();     // Catch: Exception -> L20
        Resources r14 = Resources.getSystem();     // Catch: Exception -> L20
        Intrinsics.e(r14, "Resources.getSystem()");     // Catch: Exception -> L20
        int r15 = View.MeasureSpec.makeMeasureSpec(MathKt.a(TypedValue.applyDimension(1, 440, r14.getDisplayMetrics())), Integer.MIN_VALUE);     // Catch: Exception -> L20
        FrameLayout r16 = this.e;     // Catch: Exception -> L20
        if (r16 == null) goto L26;
        r16.measure(r15, 0);     // Catch: Exception -> L20
        FrameLayout r17 = this.e;     // Catch: Exception -> L20
        if (r17 == null) goto L24;
        int r18 = r17.getMeasuredHeight();     // Catch: Exception -> L20
        Resources r19 = Resources.getSystem();     // Catch: Exception -> L20
        Intrinsics.e(r19, "Resources.getSystem()");     // Catch: Exception -> L20
        int r20 = RangesKt.b(r13, 0, MathKt.a(TypedValue.applyDimension(1, 244, r19.getDisplayMetrics())));     // Catch: Exception -> L20
        if (r18 <= r20) goto L35;
        L.d("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r18 + ", final contentHeight: " + r20);     // Catch: Exception -> L20
        FrameLayout r21 = this.e;     // Catch: Exception -> L20
        if (r21 == null) goto L22;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();     // Catch: Exception -> L20
        r22.height = r20;     // Catch: Exception -> L20
        r21.setLayoutParams(r22);     // Catch: Exception -> L20
        goto L35
    L22:
        Intrinsics.m("contentContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L24:
        Intrinsics.m("contentContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L26:
        Intrinsics.m("contentContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L28:
        Intrinsics.m("footerContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L30:
        Intrinsics.m("headerContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L32:
        Intrinsics.m("rootContainer");     // Catch: Exception -> L20
        throw null;     // Catch: Exception -> L20
    L20:
        e = move-exception;
        L.c("OInsetSheet", "adjustContentHeight error", e);
        goto L35
    }
}
