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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.panel.header.BasicPanelDefaultHeader;
import com.obric.oui.panel.header.BasicPanelDragHeader;
import com.obric.oui.panel.header.BasicPanelHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OBasePanelDialog extends BottomSheetDialog {
    public boolean A;
    public Integer B;
    public Integer C;
    public boolean D;
    public Integer E;
    public Function0 F;
    public boolean G;
    public ConstraintLayout H;
    public RadiusLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public RadiusLayout f250J;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public BasicPanelHeader t;
    public boolean u;
    public Function1 v;
    public boolean w;
    public boolean x;
    public View.OnClickListener y;
    public boolean z;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[OBasicPanel.PadCompatConfig.CloseIconStyle.values().length];
            r0[2] = 1;
            r0[1] = 2;
            r0[0] = 3;
        }
    }

    public OBasePanelDialog(Context r1, int r2) {
        super(r1, r2);
        this.n = -1;
        this.r = true;
        this.D = true;
        this.G = true;
    }

    public final ConstraintLayout d(int r13, View r14, ViewGroup.LayoutParams r15) {
        if (this.H != null) goto L5;
    L8:
        ConstraintLayout r9 = (ConstraintLayout) View.inflate(getContext(), R.layout.o_basic_panel, null);
        this.H = r9;
        if (r9 == null) goto L11;
        RadiusLayout r10 = (RadiusLayout) r9.findViewById(R.id.header_container);
    L12:
        this.I = r10;
        ConstraintLayout r11 = this.H;
        if (r11 == null) goto L15;
        RadiusLayout r12 = (RadiusLayout) r11.findViewById(R.id.content_container);
    L16:
        this.f250J = r12;
    L17:
        if (r13 == 0) goto L20;
        if (r14 != null) goto L20;
        r14 = getLayoutInflater().inflate(r13, this.f250J, false);
    L20:
        RadiusLayout r16 = this.f250J;
        if (r16 == null) goto L23;
        r16.removeAllViews();
    L23:
        if (r15 != null) goto L27;
        RadiusLayout r17 = this.f250J;
        if (r17 == null) goto L31;
        r17.addView(r14);
    L31:
        if (this.t != null) goto L34;
        Context r18 = getContext();
        Intrinsics.e(r18, "context");
        this.t = new BasicPanelDefaultHeader(r18);
    L34:
        if (this.G == false) goto L36;
        Resources r19 = Resources.getSystem();
        Intrinsics.e(r19, "Resources.getSystem()");
        float r110 = TypedValue.applyDimension(1, 20, r19.getDisplayMetrics());
    L37:
        RadiusLayout r111 = this.I;
        if (r111 == null) goto L41;
        r111.f = new float[]{r110, r110, r110, r110, 0.0f, 0.0f, 0.0f, 0.0f};
        r111.invalidate();
    L41:
        if (this.q == false) goto L45;
        RadiusLayout r112 = this.f250J;
        if (r112 == null) goto L45;
        r112.f = new float[]{r110, r110, r110, r110, 0.0f, 0.0f, 0.0f, 0.0f};
        r112.invalidate();
    L45:
        BasicPanelHeader r113 = this.t;
        if (r113 == null) goto L50;
        View r114 = r113.b();
        if (r114 == null) goto L50;
        ViewParent r115 = r114.getParent();
    L52:
        if ((r115 instanceof ViewGroup) == false) goto L69;
        BasicPanelHeader r116 = this.t;
        if (r116 == null) goto L58;
        View r117 = r116.b();
        if (r117 == null) goto L58;
        ViewParent r118 = r117.getParent();
    L60:
        if ((r118 instanceof ViewGroup) == true) goto L62;
        r118 = null;
    L62:
        ViewGroup r119 = (ViewGroup) r118;
        if (r119 == null) goto L69;
        BasicPanelHeader r120 = this.t;
        if (r120 == null) goto L67;
        View r121 = r120.b();
    L68:
        r119.removeView(r121);
        goto L69
    L67:
        r121 = null;
    L58:
        r118 = null;
    L69:
        RadiusLayout r122 = this.I;
        if (r122 == null) goto L92;
        BasicPanelHeader r123 = this.t;
        if (r123 == null) goto L74;
        View r124 = r123.b();
    L75:
        if (r124 == null) goto L77;
        ViewParent r0 = r124.getParent();
    L78:
        if (r0 != null) goto L80;
    L90:
        r122.addView(r124);
        goto L92
    L80:
        if ((r124.getParent() instanceof ViewGroup) == false) goto L90;
        if (r124.getParent() == null) goto L90;
        if ((r124.getParent() instanceof ViewGroup) == false) goto L90;
        ViewParent r1 = r124.getParent();
        if (r1 == null) goto L89;
        ((ViewGroup) r1).removeView(r124);
        goto L90
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L77:
        r0 = null;
        goto L78
    L74:
        r124 = null;
    L92:
        if (this.q == false) goto L102;
        if (this.f250J == null) goto L102;
        ConstraintSet r125 = new ConstraintSet();
        r125.clone(this.H);
        RadiusLayout r126 = this.f250J;
        Intrinsics.c(r126);
        r125.clear(r126.getId(), 3);
        RadiusLayout r127 = this.f250J;
        Intrinsics.c(r127);
        r125.connect(r127.getId(), 3, 0, 3);
        r125.applyTo(this.H);
        RadiusLayout r128 = this.I;
        if (r128 == null) goto L98;
        r128.setBackground(null);
    L98:
        RadiusLayout r129 = this.I;
        if (r129 == null) goto L102;
        r129.bringToFront();
    L102:
        if (this.r == true) goto L107;
        Window r130 = getWindow();
        if (r130 == null) goto L107;
        r130.setDimAmount(0.0f);
    L107:
        if (this.s == false) goto L126;
        Integer r131 = this.E;
        if (r131 == null) goto L114;
        int r132 = r131.intValue();
        Window r133 = getWindow();
        if (r133 == null) goto L126;
        r133.setNavigationBarColor(r132);
        goto L126
    L114:
        if (this.u == false) goto L120;
        if (this.o == false) goto L118;
        int r134 = R.color.BGPanelTone;
    L123:
        Window r135 = getWindow();
        if (r135 == null) goto L126;
        r135.setNavigationBarColor(ContextCompat.getColor(getContext(), r134));
        goto L126
    L118:
        r134 = R.color.BGPanelTint;
        goto L123
    L120:
        if (this.o == false) goto L122;
        r134 = R.color.ConstBGPanelReverse;
        goto L123
    L122:
        r134 = R.color.ConstTextInverse;
    L126:
        ConstraintLayout r136 = this.H;
        Intrinsics.c(r136);
        return r136;
    L50:
        r115 = null;
        goto L52
    L36:
        r110 = 0.0f;
        goto L37
    L27:
        RadiusLayout r137 = this.f250J;
        if (r137 == null) goto L31;
        r137.addView(r14, r15);
        goto L31
    L15:
        r12 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L5:
        if (this.I == null) goto L8;
        if (this.f250J != null) goto L17;
        goto L8
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.f(r2, "ev");
        Function1 r0 = this.v;
        if (r0 == null) goto L9;
        if (((Boolean) r0.invoke(r2)).booleanValue() == false) goto L9;
        return true;
    L9:
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Function0 r0 = this.F;
        if (r0 != null) goto L5;
    L7:
        super.onBackPressed();
        return;
    L5:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L7;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        BottomSheetBehavior r9 = b();
        Intrinsics.e(r9, "behavior");
        boolean r1 = true;
        r9.l = true;
        b().E = this.D;
        b().G = !this.A;
        if (this.p == false) goto L26;
        this.k = true;
        BottomSheetBehavior r10 = b();
        Intrinsics.e(r10, "behavior");
        Integer r0 = this.B;
        if (r0 == null) goto L7;
        int r7 = r0.intValue();
    L25:
        r10.setPeekHeight(r7);
        return;
    L7:
        Context r2 = getContext();
        Intrinsics.e(r2, "context");
        Resources r3 = r2.getResources();
        if (r3 == null) goto L10;
        Integer r4 = Integer.valueOf(r3.getIdentifier("config_showNavigationBar", "bool", "android"));
    L11:
        if (r4 != null) goto L13;
    L20:
        r1 = false;
    L21:
        if (r1 == false) goto L24;
        Context r11 = getContext();
        Intrinsics.e(r11, "context");
        double r5 = OUnitExtensionKt.b(r11);
        double r6 = 0.65d;
    L23:
        r7 = (int) (r5 * r6);
        goto L25
    L24:
        Context r12 = getContext();
        Intrinsics.e(r12, "context");
        r5 = OUnitExtensionKt.b(r12);
        r6 = 0.6d;
        goto L23
    L13:
        if (r4.intValue() <= 0) goto L20;
        Context r13 = getContext();
        Intrinsics.e(r13, "context");
        Resources r14 = r13.getResources();
        if (r14 == null) goto L17;
        boolean r15 = r14.getBoolean(r4.intValue());
    L18:
        if (r15 == false) goto L20;
    L17:
        r15 = false;
        goto L18
    L10:
        r4 = null;
        goto L11
    L26:
        BottomSheetBehavior r16 = b();
        BasicPanelHeader r17 = this.t;
        if ((r17 instanceof BasicPanelDragHeader) == true) goto L33;
        if (r17 != null) goto L30;
    L32:
        r1 = false;
        goto L33
    L30:
        if (r17.b != true) goto L32;
    L33:
        r16.m = r1;
        if (this.n <= 0) goto L42;
        BottomSheetBehavior r18 = b();
        int r19 = this.n;
        r18.c = r19;
        if (this.x == false) goto L43;
        FrameLayout r20 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r20 == null) goto L44;
        r20.getLayoutParams().height = r19;
        return;
    L44:
        return;
    L43:
        return;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.w == false) goto L8;
        FrameLayout r2 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r2 == null) goto L8;
        r2.setMinimumHeight(0);
    L8:
        if (this.G == false) goto L10;
        Resources r5 = Resources.getSystem();
        Intrinsics.e(r5, "Resources.getSystem()");
        float r3 = TypedValue.applyDimension(1, 20, r5.getDisplayMetrics());
    L11:
        GradientDrawable r6 = new GradientDrawable();
        r6.setShape(0);
        r6.setCornerRadii(new float[]{r3, r3, r3, r3, 0.0f, 0.0f, 0.0f, 0.0f});
        if (this.u == false) goto L18;
        if (this.o == false) goto L16;
        int r0 = R.color.BGPanelTone;
    L21:
        r6.setColor(ContextCompat.getColor(getContext(), r0));
        if (this.e != null) goto L24;
        a();
    L24:
        FrameLayout r1 = this.e;
        if (r1 == null) goto L28;
        r1.setBackground(r6);
    L28:
        if (this.p == false) goto L36;
        Integer r4 = this.C;
        if (r4 == null) goto L32;
        int r7 = r4.intValue();
    L33:
        FrameLayout r8 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r8 == null) goto L36;
        r8.getLayoutParams().height = r7;
        goto L36
    L32:
        Context r9 = getContext();
        Intrinsics.e(r9, "context");
        r7 = (int) (((double) OUnitExtensionKt.b(r9)) * 0.9d);
    L36:
        boolean r10 = this.D;
        FrameLayout r11 = (FrameLayout) findViewById(R.id.container);
        if (r11 == null) goto L39;
        r11.setFitsSystemWindows(r10);
    L39:
        b().b = this.p;
        if (this.y == null) goto L44;
        View r12 = findViewById(R.id.touch_outside);
        if (r12 == null) goto L44;
        r12.setOnClickListener(this.y);
    L44:
        b().F = this.z;
        return;
    L16:
        r0 = R.color.BGPanelTint;
        goto L21
    L18:
        if (this.o == false) goto L20;
        r0 = R.color.ConstBGPanelReverse;
        goto L21
    L20:
        r0 = R.color.ConstTextInverse;
        goto L21
    L10:
        r3 = 0.0f;
        goto L11
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r3) {
        Intrinsics.f(r3, "view");
        super.setContentView(d(0, r3, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r2) {
        super.setContentView(d(r2, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.f(r2, "view");
        super.setContentView(d(0, r2, r3));
    }
}
