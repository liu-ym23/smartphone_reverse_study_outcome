package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.divider.ODivider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class OBottomActionBar extends FrameLayout {
    public final String b;
    public View c;
    public final LinearLayout e;
    public final ODivider f;
    public OnBottomButtonClickListener i;
    public ArrayList j;

    @Metadata
    public static final class OBABConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f154a;
        public final boolean b;
        public final String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f155d;
        public final List e;

        public OBABConfig(boolean r1, boolean r2, String r3, ArrayList r4, ArrayList r5) {
            this.f154a = r1;
            this.b = r2;
            this.c = r3;
            this.f155d = r4;
            this.e = r5;
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof OBABConfig) == false) goto L16;
            OBABConfig r4 = (OBABConfig) r3;
            boolean r0 = r4.f154a;
            if (this.f154a == r0) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.a(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(this.f155d, r4.f155d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.a(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        public final int hashCode() {
            ?? r0 = 1;
            boolean r1 = this.f154a;
            ?? r2 = r1;
            if (r1 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            if (r4 == true) goto L9;
            r0 = r4;
        L9:
            int r5 = (r3 + r0) * 31;
            int r6 = 0;
            String r7 = this.c;
            if (r7 == null) goto L12;
            int r8 = r7.hashCode();
        L13:
            int r9 = (r5 + r8) * 31;
            List r10 = this.f155d;
            if (r10 == null) goto L16;
            int r11 = r10.hashCode();
        L17:
            int r12 = (r9 + r11) * 31;
            List r13 = this.e;
            if (r13 == null) goto L21;
            r6 = r13.hashCode();
        L21:
            return r12 + r6;
        L16:
            r11 = 0;
            goto L17
        L12:
            r8 = 0;
            goto L13
        }

        public final String toString() {
            return "OBABConfig(hasDivider=" + this.f154a + ", lastPrimary=" + this.b + ", buttonStyle=" + this.c + ", buttonTexts=" + this.f155d + ", buttonImgIds=" + this.e + ")";
        }
    }

    @Metadata
    public interface OnBottomButtonClickListener {
        void a(View r1, int r2);
    }

    @JvmOverloads
    public OBottomActionBar(@NotNull Context r9, @Nullable AttributeSet r10) {
        Intrinsics.f(r9, "context");
        super(r9, r10);
        this.b = "OBottomActionBar";
        View.inflate(r9, R.layout.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.getColor(r9, R.color.Transparent));
        View r0 = findViewById(R.id.root_layout);
        Intrinsics.e(r0, "findViewById(R.id.root_layout)");
        this.e = (LinearLayout) r0;
        View r1 = findViewById(R.id.top_divider);
        Intrinsics.e(r1, "findViewById(R.id.top_divider)");
        this.f = (ODivider) r1;
        int r2 = 0;
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, com.obric.common.oui.R.styleable.c, 0, 0);
        boolean r3 = r11.getBoolean(4, true);
        boolean r4 = r11.getBoolean(1, false);
        String r12 = r11.getString(2);
        int r5 = r11.getResourceId(3, -1);
        int r6 = r11.getResourceId(0, -1);
        if (r5 != (-1)) goto L5;
        ArrayList r7 = null;
    L6:
        if (r6 != (-1)) goto L8;
        ArrayList r8 = null;
    L12:
        if (r12 == null) goto L14;
        String r13 = r12;
    L15:
        a(new OBABConfig(r3, r4, r13, r7, r8));
        return;
    L14:
        r13 = "l1";
        goto L15
    L8:
        TypedArray r14 = r11.getResources().obtainTypedArray(r6);
        Intrinsics.e(r14, "resources.obtainTypedArray(buttonImg)");
        ArrayList r15 = new ArrayList();
        int r16 = r14.length();
    L9:
        if (r2 >= r16) goto L11;
        r15.add(Integer.valueOf(r14.getResourceId(r2, -1)));
        r2 = r2 + 1;
        goto L9
    L11:
        ArrayList r17 = CollectionsKt.r(r15);
        r14.recycle();
        r8 = r17;
        goto L12
    L5:
        String[] r18 = r11.getResources().getStringArray(r5);
        Intrinsics.e(r18, "resources.getStringArray(buttonResourceId)");
        r7 = ArraysKt.v(r18);
        goto L6
    }

    public final void a(OBABConfig r23) {
        String r2 = r23.c;
        int r3 = r2.hashCode();
        LinearLayout r6 = this.e;
        Object r7 = null;
        if (r3 == (-1612256902)) goto L31;
        if (r3 == 3397) goto L28;
        if (r3 == 104387) goto L25;
        if (r3 == 678742426) goto L22;
        if (r3 == 3428) goto L19;
        if (r3 == 3429) goto L16;
    L33:
        int r4 = r2.compareTo("img");
        String r5 = this.b;
        if (r4 != 0) goto L54;
        ArrayList r8 = this.j;
        if (r8 == null) goto L84;
        List r9 = r23.e;
        if (r9 == null) goto L46;
        int r10 = Math.min(r9.size(), r8.size());
        if (r9.size() <= r8.size()) goto L43;
        Log.e(r5, "Exceeded the maximum number of buttons Max is " + r8.size());
    L43:
        int r11 = r10 - 1;
        int r12 = 0;
    L44:
        if (r12 >= r10) goto L47;
        ((OButton) r8.get(r12)).setVisibility(0);
        ((OButton) r8.get(r12)).setButtonSourceBitmap(((Number) r9.get(r12)).intValue());
        r12 = r12 + 1;
    L47:
        if (r11 != (-1)) goto L49;
        r11 = r8.size() - 1;
    L49:
        if (r11 < 0) goto L84;
        final int r13 = 0;
    L51:
        ((OButton) r8.get(r13)).setOnClickListener(new OBottomActionBar$initImgButton$1(this, r13));
        if (r13 == r11) goto L84;
        r13 = r13 + 1;
        goto L51
    L46:
        r11 = -1;
    L84:
        boolean r1 = r23.f154a;
        ODivider r0 = this.f;
        if (r1 == false) goto L87;
        r0.setVisibility(0);
        return;
    L87:
        r0.setVisibility(8);
        return;
    L54:
        ArrayList r14 = this.j;
        if (r14 == null) goto L84;
        List r15 = r23.f155d;
        if (r15 == null) goto L65;
        int r16 = Math.min(r15.size(), r14.size());
        if (r15.size() <= r14.size()) goto L62;
        Log.e(r5, "Exceeded the maximum number of buttons Max is " + r14.size());
    L62:
        int r17 = r16 - 1;
        int r18 = 0;
    L63:
        if (r18 >= r16) goto L66;
        ((OButton) r14.get(r18)).setVisibility(0);
        ((OButton) r14.get(r18)).setText((CharSequence) r15.get(r18));
        r18 = r18 + 1;
    L66:
        if (r17 != (-1)) goto L69;
        r17 = r14.size() - 1;
    L69:
        if (r23.b == false) goto L79;
        ((OButton) r14.get(r17)).setBackgroundColor(getResources().getColor(R.color.oui_accent_bg_high_contrast));
        ((OButton) r14.get(r17)).setTextColor(getResources().getColor(R.color.oui_on_accent_default));
        Object r19 = r14.get(r17);
        if (r19 != null) goto L74;
    L76:
        IOUIAlpha r20 = (IOUIAlpha) r7;
        if (r20 == null) goto L79;
        r20.c(r5);
        goto L79
    L74:
        if ((r19 instanceof IOUIAlpha) == false) goto L76;
        r7 = r19;
    L79:
        if (r17 < 0) goto L84;
        final int r21 = 0;
    L81:
        ((OButton) r14.get(r21)).setOnClickListener(new OBottomActionBar$initNormalButton$1(this, r21));
        if (r21 == r17) goto L84;
        r21 = r21 + 1;
        goto L81
    L65:
        r17 = -1;
        goto L66
    L16:
        if (r2.equals("m2") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r22 = findViewById(R.id.action_button_m20);
        Intrinsics.e(r22, "findViewById(R.id.action_button_m20)");
        View r24 = findViewById(R.id.action_button_m21);
        Intrinsics.e(r24, "findViewById(R.id.action_button_m21)");
        View r25 = findViewById(R.id.action_button_m22);
        Intrinsics.e(r25, "findViewById(R.id.action_button_m22)");
        this.j = CollectionsKt.l(new OButton[]{(OButton) r22, (OButton) r24, (OButton) r25});
        goto L33
    L19:
        if (r2.equals("m1") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m1, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r26 = findViewById(R.id.action_button_0);
        Intrinsics.e(r26, "findViewById(R.id.action_button_0)");
        View r27 = findViewById(R.id.action_button_1);
        Intrinsics.e(r27, "findViewById(R.id.action_button_1)");
        View r28 = findViewById(R.id.action_button_2);
        Intrinsics.e(r28, "findViewById(R.id.action_button_2)");
        View r110 = findViewById(R.id.action_button_3);
        Intrinsics.e(r110, "findViewById(R.id.action_button_3)");
        View r111 = findViewById(R.id.action_button_4);
        Intrinsics.e(r111, "findViewById(R.id.action_button_4)");
        this.j = CollectionsKt.l(new OButton[]{(OButton) r26, (OButton) r27, (OButton) r28, (OButton) r110, (OButton) r111});
        goto L33
    L22:
        if (r2.equals("m2-primary") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2_primary, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r29 = findViewById(R.id.action_button_m2_primary0);
        Intrinsics.e(r29, "findViewById(R.id.action_button_m2_primary0)");
        View r30 = findViewById(R.id.action_button_m2_primary1);
        Intrinsics.e(r30, "findViewById(R.id.action_button_m2_primary1)");
        this.j = CollectionsKt.l(new OButton[]{(OButton) r29, (OButton) r30});
        goto L33
    L25:
        if (r2.equals("img") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_img, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r31 = findViewById(R.id.action_button_0);
        Intrinsics.e(r31, "findViewById(R.id.action_button_0)");
        OButton r112 = (OButton) r31;
        View r32 = findViewById(R.id.action_button_1);
        Intrinsics.e(r32, "findViewById(R.id.action_button_1)");
        OButton r113 = (OButton) r32;
        View r33 = findViewById(R.id.action_button_2);
        Intrinsics.e(r33, "findViewById(R.id.action_button_2)");
        OButton r114 = (OButton) r33;
        View r34 = findViewById(R.id.action_button_3);
        Intrinsics.e(r34, "findViewById(R.id.action_button_3)");
        OButton r115 = (OButton) r34;
        View r35 = findViewById(R.id.action_button_4);
        Intrinsics.e(r35, "findViewById(R.id.action_button_4)");
        OButton r210 = (OButton) r35;
        View r36 = findViewById(R.id.action_button_5);
        Intrinsics.e(r36, "findViewById(R.id.action_button_5)");
        this.j = CollectionsKt.l(new OButton[]{r112, r113, r114, r115, r210, (OButton) r36});
        goto L33
    L28:
        if (r2.equals("l1") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r37 = findViewById(R.id.action_button_L10);
        Intrinsics.e(r37, "findViewById(R.id.action_button_L10)");
        View r38 = findViewById(R.id.action_button_L11);
        Intrinsics.e(r38, "findViewById(R.id.action_button_L11)");
        this.j = CollectionsKt.l(new OButton[]{(OButton) r37, (OButton) r38});
        goto L33
    L31:
        if (r2.equals("l1-primary") == false) goto L33;
        this.c = View.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1_primary, null);
        r6.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        View r39 = findViewById(R.id.action_button_L1_primary);
        Intrinsics.e(r39, "findViewById(R.id.action_button_L1_primary)");
        this.j = CollectionsKt.l(new OButton[]{(OButton) r39});
        goto L33
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public final void setBottomButtonClickListener(@Nullable OnBottomButtonClickListener r1) {
        this.i = r1;
    }
}
