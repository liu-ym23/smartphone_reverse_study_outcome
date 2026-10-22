package com.obric.oui.dialog.base;

import a.a;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public abstract class AbstractDialog extends Dialog {
    public final String b;
    public final View c;
    public final ImageView e;
    public boolean f;
    public final View i;
    public final CloseIconStyle j;
    public View.OnClickListener k;
    public boolean l;
    public final AbstractDialog$handler$1 m;
    public final boolean n;
    public final boolean o;

    @Metadata
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        public static final CloseIconStyle b = null;
        public static final /* synthetic */ CloseIconStyle[] c = null;

        static {
            CloseIconStyle r0 = new CloseIconStyle("LIGHT", 0);
            CloseIconStyle r1 = new CloseIconStyle("DARK", 1);
            b = r1;
            c = new CloseIconStyle[]{r0, r1, new CloseIconStyle("CUSTOM", 2)};
        }

        public static CloseIconStyle valueOf(String r1) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r1);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) c.clone();
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[CloseIconStyle.values().length];
            r0[1] = 1;
            r0[0] = 2;
            r0[2] = 3;
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.obric.oui.dialog.base.AbstractDialog$handler$1] */
    public AbstractDialog(Context r3) {
        Intrinsics.f(r3, "context");
        super(r3);
        this.n = false;
        this.o = false;
        this.b = "AbstractDialog";
        this.j = CloseIconStyle.b;
        this.l = true;
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.requestFeature(1);
    L5:
        setContentView(R.layout.o_base_dialog);
        View r4 = findViewById(R.id.root_view);
        Intrinsics.e(r4, "findViewById(R.id.root_view)");
        this.i = r4;
        this.e = (ImageView) findViewById(R.id.btn_close);
        this.c = findViewById(R.id.close_container);
        r4.setOnApplyWindowInsetsListener(new AbstractDialog$setOnApplyWindowInsetsListener$1(this));
        f(this.f, null);
        ViewStub r1 = (ViewStub) findViewById(R.id.contentView);
        Intrinsics.e(r1, "viewStub");
        r1.setLayoutResource(b());
        r1.inflate();
        DialogAnimStyle.b(r4);
        final Looper r2 = Looper.getMainLooper();
        this.m = new AbstractDialog$handler$1(this, r2);
    }

    public static float e(Context r1) {
        Resources r2 = r1.getResources();
        Intrinsics.e(r2, "context.resources");
        if ((r2.getConfiguration().uiMode & 48) != 32) goto L5;
        return 0.8f;
    L5:
        return 0.32f;
    }

    public final void a(CloseIconStyle r3, Integer r4, Integer r5) {
        Intrinsics.f(r3, "style");
        if (this.f == false) goto L34;
        int r6 = r3.ordinal();
        if (r6 == 0) goto L15;
        int r1 = R.color.ConstTextInverse;
        if (r6 != 1) goto L9;
        r5 = Integer.valueOf(R.color.ConstBGContainer7);
    L16:
        ImageView r7 = this.e;
        if (r7 == null) goto L19;
        r7.setImageTintList(ContextCompat.getColorStateList(getContext(), r1));
    L19:
        View r8 = this.c;
        Drawable r9 = null;
        if (r5 != null) goto L23;
        if (r8 == null) goto L35;
        r8.setBackground(null);
        return;
    L35:
        return;
    L23:
        if (r8 == null) goto L25;
        Drawable r10 = r8.getBackground();
    L27:
        if ((r10 instanceof GradientDrawable) == false) goto L30;
        r9 = r10;
    L30:
        GradientDrawable r11 = (GradientDrawable) r9;
        if (r11 == null) goto L37;
        r11.setColor(ContextCompat.getColorStateList(getContext(), r5.intValue()));
        return;
    L37:
        return;
    L25:
        r10 = null;
        goto L27
    L9:
        if (r6 != 2) goto L13;
        if (r4 == null) goto L16;
        r1 = r4.intValue();
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        r5 = Integer.valueOf(R.color.ConstTextInverse5);
        r1 = R.color.TextReverse;
        goto L16
    }

    public abstract int b();

    public int c(Window r1) {
        Context r0 = r1.getContext();
        Intrinsics.e(r0, "context");
        return r0.getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    }

    public final View d() {
        View r0 = this.i;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.m("rootView");
        throw null;
    }

    public final void f(boolean r4, View.OnClickListener r5) {
        this.f = r4;
        this.k = r5;
        ImageView r6 = this.e;
        if (r6 == null) goto L14;
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        ViewExtensionsKt.a(r6, MathKt.a(TypedValue.applyDimension(1, 44, r1.getDisplayMetrics())));
        View r7 = this.c;
        if (r4 == false) goto L11;
        if (r7 == null) goto L8;
        ViewExtensionsKt.e(r7);
    L8:
        a(this.j, null, null);
        if (r7 == null) goto L15;
        r7.setOnClickListener(new AbstractDialog$setCloseIconEnabled$$inlined$let$lambda$1(this));
        return;
    L15:
        return;
    L11:
        if (r7 == null) goto L17;
        ViewExtensionsKt.d(r7);
        return;
    L17:
        return;
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        removeCallbacksAndMessages(null);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window r5 = getWindow();
        if (r5 == null) goto L38;
        r5.setBackgroundDrawableResource(android.R.color.transparent);
        r5.addFlags(2);
        r5.setNavigationBarContrastEnforced(false);
        r5.setDecorFitsSystemWindows(false);
        r5.clearFlags(134217728);
        r5.addFlags(Integer.MIN_VALUE);
        r5.setNavigationBarColor(0);
        r5.setNavigationBarDividerColor(0);
        WindowManager.LayoutParams r6 = r5.getAttributes();
        r6.gravity = 81;
        r6.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        if (this.o == false) goto L7;
        r6.height = -1;
    L8:
        View r7 = this.i;
        if (this.n == false) goto L27;
        if (r7 == null) goto L25;
        ViewGroup.LayoutParams r13 = r7.getLayoutParams();
        r13.width = -1;
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        ViewGroup.LayoutParams r8 = null;
    L15:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9 == null) goto L18;
        r9.bottomMargin = 0;
    L18:
        r7.setLayoutParams(r13);
        if ((r7 instanceof RadiusLayout) == true) goto L21;
        View r14 = null;
    L22:
        RadiusLayout r15 = (RadiusLayout) r14;
        if (r15 == null) goto L29;
        Context r10 = r15.getContext();
        Intrinsics.e(r10, "context");
        float r11 = r10.getResources().getDimension(R.dimen.oui_r_l3);
        r15.f = new float[]{r11, r11, r11, r11, 0.0f, 0.0f, 0.0f, 0.0f};
        r15.invalidate();
    L29:
        Context r16 = r5.getContext();
        Intrinsics.e(r16, "context");
        if (ResourceUtils.a(r16) == false) goto L35;
        if (r7 == null) goto L33;
        ViewGroup.LayoutParams r17 = r7.getLayoutParams();
        r17.width = a.d("Resources.getSystem()", 1, 440);
        r7.setLayoutParams(r17);
        goto L35
    L33:
        Intrinsics.m("rootView");
        throw null;
    L35:
        r5.setAttributes(r6);
        return;
    L21:
        r14 = r7;
        goto L22
    L14:
        r8 = r13;
        goto L15
    L25:
        Intrinsics.m("rootView");
        throw null;
    L27:
        if (r7 == null) goto L36;
        ViewGroup.LayoutParams r1 = r7.getLayoutParams();
        Context r2 = r5.getContext();
        Intrinsics.e(r2, "context");
        Resources r3 = r2.getResources();
        Intrinsics.e(r3, "context.resources");
        r1.width = r3.getDisplayMetrics().widthPixels - (c(r5) * 2);
        r7.setLayoutParams(r1);
        goto L29
    L36:
        Intrinsics.m("rootView");
        throw null;
    L7:
        r6.height = -2;
        goto L8
    }
}
