package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.divider.ODivider;
import com.obric.oui.utils.KtExt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomActionBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001:\u000245B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001c\u001a\u00020\u00182\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0016H\u0014J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0014J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u0011JC\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u001f2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000101¢\u0006\u0002\u00103R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "actionButtons", "", "Lcom/obric/oui/button/OButton;", "contentView", "Landroid/view/View;", "dividerView", "Lcom/obric/oui/divider/ODivider;", "onClickListener", "Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "rootView", "Landroid/widget/LinearLayout;", "getButton", Utils.INTENT_KEY_INDEX, "", "initButtons", "", "config", "Lcom/obric/oui/actionbar/OBottomActionBar$OBABConfig;", "initImgButton", "initNormalButton", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "performButtonClick", "button", "resetLayoutStatus", "setBottomButtonClickListener", "l", "updateStyle", "hasDivider", "buttonStyle", "lastPrimary", "buttonTexts", "", "buttonImgIds", "(ZLjava/lang/String;Z[Ljava/lang/String;[Ljava/lang/Integer;)V", "OBABConfig", "OnBottomButtonClickListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBottomActionBar extends FrameLayout {
    private final String TAG;
    private List<OButton> actionButtons;
    private View contentView;
    private final ODivider dividerView;
    private OnBottomButtonClickListener onClickListener;
    private final LinearLayout rootView;

    /* JADX INFO: compiled from: OBottomActionBar.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar$OBABConfig;", "", "hasDivider", "", "lastPrimary", "buttonStyle", "", "buttonTexts", "", "buttonImgIds", "", "(ZZLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getButtonImgIds", "()Ljava/util/List;", "getButtonStyle", "()Ljava/lang/String;", "getButtonTexts", "getHasDivider", "()Z", "getLastPrimary", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OBABConfig {
        private final List<Integer> buttonImgIds;
        private final String buttonStyle;
        private final List<String> buttonTexts;
        private final boolean hasDivider;
        private final boolean lastPrimary;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OBABConfig copy$default(OBABConfig r3, boolean r4, boolean r5, String r6, List r7, List r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.hasDivider;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.lastPrimary;
        L8:
            boolean r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.buttonStyle;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.buttonTexts;
        L14:
            List r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.buttonImgIds;
        L17:
            boolean r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final boolean component1() {
            return this.hasDivider;
        }

        public final boolean component2() {
            return this.lastPrimary;
        }

        public final String component3() {
            return this.buttonStyle;
        }

        public final List<String> component4() {
            return this.buttonTexts;
        }

        public final List<Integer> component5() {
            return this.buttonImgIds;
        }

        public final OBABConfig copy(boolean r7, boolean r8, String r9, List<String> r10, List<Integer> r11) {
            Intrinsics.checkNotNullParameter(r9, "buttonStyle");
            return new OBABConfig(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof OBABConfig) == true) goto L8;
            return false;
        L8:
            OBABConfig r6 = (OBABConfig) r5;
            if (this.hasDivider == r6.hasDivider) goto L12;
            return false;
        L12:
            if (this.lastPrimary == r6.lastPrimary) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.buttonStyle, r6.buttonStyle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.buttonTexts, r6.buttonTexts) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.buttonImgIds, r6.buttonImgIds) == true) goto L23;
            return false;
        L23:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            boolean r0 = this.hasDivider;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.lastPrimary;
            if (r4 == true) goto L9;
            r1 = r4;
        L9:
            int r5 = (((r3 + r1) * 31) + this.buttonStyle.hashCode()) * 31;
            List<String> r6 = this.buttonTexts;
            int r7 = 0;
            if (r6 != null) goto L12;
            int r8 = 0;
        L13:
            int r9 = (r5 + r8) * 31;
            List<Integer> r10 = this.buttonImgIds;
            if (r10 == null) goto L18;
            r7 = r10.hashCode();
        L18:
            return r9 + r7;
        L12:
            r8 = r6.hashCode();
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.hasDivider + ", lastPrimary=" + this.lastPrimary + ", buttonStyle=" + this.buttonStyle + ", buttonTexts=" + this.buttonTexts + ", buttonImgIds=" + this.buttonImgIds + ')';
        }

        public OBABConfig(boolean r2, boolean r3, String r4, List<String> r5, List<Integer> r6) {
            Intrinsics.checkNotNullParameter(r4, "buttonStyle");
            this.hasDivider = r2;
            this.lastPrimary = r3;
            this.buttonStyle = r4;
            this.buttonTexts = r5;
            this.buttonImgIds = r6;
        }

        public final boolean getHasDivider() {
            return this.hasDivider;
        }

        public final boolean getLastPrimary() {
            return this.lastPrimary;
        }

        public final String getButtonStyle() {
            return this.buttonStyle;
        }

        public final List<String> getButtonTexts() {
            return this.buttonTexts;
        }

        public final List<Integer> getButtonImgIds() {
            return this.buttonImgIds;
        }
    }

    /* JADX INFO: compiled from: OBottomActionBar.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar$OnBottomButtonClickListener;", "", "onClick", "", "button", "Landroid/view/View;", Utils.INTENT_KEY_INDEX, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnBottomButtonClickListener {
        void onClick(View r1, int r2);
    }

    public static /* synthetic */ void $r8$lambda$AVt0uajSpV2z2hEdH8NbIdtXcec(OBottomActionBar r0, int r1, View r2) {
        m195initNormalButton$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$d8lQHxT26kpIR7xpDnys7ydIoHE(OBottomActionBar r0, int r1, View r2) {
        m194initImgButton$lambda2(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBar(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OBottomActionBar(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OBottomActionBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.TAG = "OBottomActionBar";
        FrameLayout.inflate(r10, R.layout.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.getColor(r10, R.color.Transparent));
        View r0 = findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.root_layout)");
        this.rootView = (LinearLayout) r0;
        View r1 = findViewById(R.id.top_divider);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.top_divider)");
        this.dividerView = (ODivider) r1;
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, R.styleable.OBottomActionBar, 0, 0);
        boolean r3 = r12.getBoolean(R.styleable.OBottomActionBar_oui_hasDivider, true);
        boolean r4 = r12.getBoolean(R.styleable.OBottomActionBar_oui_buttonLastPrimary, false);
        String r13 = r12.getString(R.styleable.OBottomActionBar_oui_buttonStyle);
        int r2 = r12.getResourceId(R.styleable.OBottomActionBar_oui_buttonTexts, 0);
        int r5 = r12.getResourceId(R.styleable.OBottomActionBar_oui_buttonImgIds, 0);
        if (r2 != 0) goto L5;
        List r6 = null;
    L6:
        if (r5 != 0) goto L8;
        List r7 = null;
    L12:
        if (r13 != null) goto L14;
        r13 = "l1";
    L14:
        OBABConfig r14 = new OBABConfig(r3, r4, r13, r6, r7);
        r12.recycle();
        initButtons(r14);
        return;
    L8:
        TypedArray r8 = r12.getResources().obtainTypedArray(r5);
        Intrinsics.checkNotNullExpressionValue(r8, "resources.obtainTypedArray(buttonImg)");
        ArrayList r9 = new ArrayList();
        int r15 = r8.length();
        int r16 = 0;
    L9:
        if (r16 >= r15) goto L11;
        r9.add(Integer.valueOf(r8.getResourceId(r16, 0)));
        r16 = r16 + 1;
        goto L9
    L11:
        List r17 = CollectionsKt.toMutableList(r9);
        r8.recycle();
        r7 = r17;
        goto L12
    L5:
        String[] r18 = r12.getResources().getStringArray(r2);
        Intrinsics.checkNotNullExpressionValue(r18, "resources.getStringArray(buttonResourceId)");
        r6 = ArraysKt.toMutableList(r18);
        goto L6
    }

    private final void initButtons(OBABConfig r17) {
        String r2 = r17.getButtonStyle();
        int r3 = r2.hashCode();
        if (r3 == (-1612256902)) goto L36;
        if (r3 == 3397) goto L32;
        if (r3 == 104387) goto L28;
        if (r3 == 678742426) goto L24;
        if (r3 == 3428) goto L20;
        if (r3 != 3429) goto L40;
        if (r2.equals("m2") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r4 = findViewById(R.id.action_button_m20);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.action_button_m20)");
        View r5 = findViewById(R.id.action_button_m21);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.action_button_m21)");
        View r6 = findViewById(R.id.action_button_m22);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.action_button_m22)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r4, (OButton) r5, (OButton) r6});
    L40:
        if (r17.getButtonStyle().compareTo("img") != 0) goto L42;
        initImgButton(this.actionButtons, r17);
    L44:
        if (r17.getHasDivider() == false) goto L46;
        this.dividerView.setVisibility(0);
        return;
    L46:
        this.dividerView.setVisibility(8);
        return;
    L42:
        initNormalButton(this.actionButtons, r17);
        goto L44
    L20:
        if (r2.equals("m1") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m1, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r7 = findViewById(R.id.action_button_0);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.action_button_0)");
        View r8 = findViewById(R.id.action_button_1);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.action_button_1)");
        View r9 = findViewById(R.id.action_button_2);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.action_button_2)");
        View r10 = findViewById(R.id.action_button_3);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.action_button_3)");
        View r11 = findViewById(R.id.action_button_4);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.action_button_4)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r7, (OButton) r8, (OButton) r9, (OButton) r10, (OButton) r11});
        goto L40
    L24:
        if (r2.equals("m2-primary") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_m2_primary, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r12 = findViewById(R.id.action_button_m2_primary0);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.action_button_m2_primary0)");
        View r13 = findViewById(R.id.action_button_m2_primary1);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.action_button_m2_primary1)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r12, (OButton) r13});
        goto L40
    L28:
        if (r2.equals("img") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_img, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r14 = findViewById(R.id.action_button_0);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.action_button_0)");
        View r15 = findViewById(R.id.action_button_1);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.action_button_1)");
        View r16 = findViewById(R.id.action_button_2);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.action_button_2)");
        View r18 = findViewById(R.id.action_button_3);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.action_button_3)");
        View r19 = findViewById(R.id.action_button_4);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.action_button_4)");
        View r20 = findViewById(R.id.action_button_5);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.action_button_5)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r14, (OButton) r15, (OButton) r16, (OButton) r18, (OButton) r19, (OButton) r20});
        goto L40
    L32:
        if (r2.equals("l1") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r21 = findViewById(R.id.action_button_L10);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.action_button_L10)");
        View r22 = findViewById(R.id.action_button_L11);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.action_button_L11)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r21, (OButton) r22});
        goto L40
    L36:
        if (r2.equals("l1-primary") == false) goto L40;
        this.contentView = FrameLayout.inflate(getContext(), R.layout.o_widget_bottom_action_bar_l1_primary, null);
        this.rootView.addView(this.contentView, new LinearLayout.LayoutParams(-1, -1));
        View r23 = findViewById(R.id.action_button_L1_primary);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.action_button_L1_primary)");
        this.actionButtons = CollectionsKt.mutableListOf(new OButton[]{(OButton) r23});
        goto L40
    }

    private final void initNormalButton(List<OButton> r9, OBABConfig r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        final int r2 = 0;
        if (r10.getButtonTexts() == null) goto L12;
        int r0 = Math.min(r10.getButtonTexts().size(), r9.size());
        if (r10.getButtonTexts().size() <= r9.size()) goto L9;
        Log.e(this.TAG, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r9.size())));
    L9:
        int r3 = r0 - 1;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L13;
        r9.get(r4).setVisibility(0);
        r9.get(r4).setText(r10.getButtonTexts().get(r4));
        r4 = r4 + 1;
    L13:
        if (r3 != (-1)) goto L16;
        r3 = r9.size() - 1;
    L16:
        if (r10.getLastPrimary() == false) goto L26;
        r9.get(r3).setBackgroundColor(getResources().getColor(R.color.oui_accent_bg_high_contrast));
        r9.get(r3).setTextColor(getResources().getColor(R.color.oui_on_accent_default));
        KtExt r11 = KtExt.INSTANCE;
        OButton r12 = r9.get(r3);
        if (r12 != null) goto L21;
    L19:
        r12 = null;
    L22:
        OButton r13 = r12;
        if (r13 == null) goto L26;
        r13.refreshColors(this.TAG);
        goto L26
    L21:
        if ((r12 instanceof IOUIAlpha) == false) goto L19;
    L26:
        if (r3 < 0) goto L31;
    L27:
        int r14 = r2 + 1;
        r9.get(r2).setOnClickListener(new OBottomActionBar$$ExternalSyntheticLambda1(this, r2));
        if (r2 == r3) goto L34;
        r2 = r14;
        goto L27
    L34:
        return;
    L31:
        return;
    L12:
        r3 = -1;
        goto L13
    }

    /* JADX INFO: renamed from: initNormalButton$lambda-1, reason: not valid java name */
    private static final void m195initNormalButton$lambda1(OBottomActionBar r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r1.performButtonClick(r3, r2);
    }

    private final void initImgButton(List<OButton> r9, OBABConfig r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        final int r2 = 0;
        if (r10.getButtonImgIds() == null) goto L12;
        int r0 = Math.min(r10.getButtonImgIds().size(), r9.size());
        if (r10.getButtonImgIds().size() <= r9.size()) goto L9;
        Log.e(this.TAG, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r9.size())));
    L9:
        int r3 = r0 - 1;
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L13;
        r9.get(r4).setVisibility(0);
        r9.get(r4).setButtonSourceBitmap(r10.getButtonImgIds().get(r4).intValue());
        r4 = r4 + 1;
    L13:
        if (r3 != (-1)) goto L15;
        r3 = r9.size() - 1;
    L15:
        if (r3 < 0) goto L20;
    L16:
        int r11 = r2 + 1;
        r9.get(r2).setOnClickListener(new OBottomActionBar$$ExternalSyntheticLambda0(this, r2));
        if (r2 == r3) goto L23;
        r2 = r11;
        goto L16
    L23:
        return;
    L20:
        return;
    L12:
        r3 = -1;
        goto L13
    }

    /* JADX INFO: renamed from: initImgButton$lambda-2, reason: not valid java name */
    private static final void m194initImgButton$lambda2(OBottomActionBar r1, int r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        r1.performButtonClick(r3, r2);
    }

    private final void performButtonClick(View r1, int r2) {
        OnBottomButtonClickListener r0 = this.onClickListener;
        if (r0 == null) goto L7;
        r0.onClick(r1, r2);
        return;
    }

    public final void setBottomButtonClickListener(OnBottomButtonClickListener r1) {
        this.onClickListener = r1;
    }

    public final void updateStyle(boolean r8, String r9, boolean r10, String[] r11, Integer[] r12) {
        Intrinsics.checkNotNullParameter(r9, "buttonStyle");
        resetLayoutStatus();
        if (r11 != null) goto L5;
        List r5 = null;
    L6:
        if (r12 != null) goto L8;
        List r6 = null;
    L9:
        initButtons(new OBABConfig(r8, r10, r9, r5, r6));
        return;
    L8:
        r6 = ArraysKt.toMutableList(r12);
        goto L9
    L5:
        r5 = ArraysKt.toMutableList(r11);
        goto L6
    }

    public final OButton getButton(int r3) {
        List<OButton> r0 = this.actionButtons;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L7;
        int r1 = 0;
    L8:
        if (r3 >= r1) goto L13;
        List<OButton> r2 = this.actionButtons;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.get(r3);
    L13:
        OButton r4 = (OButton) null;
        return null;
    L7:
        r1 = r0.size();
        goto L8
    }

    private final void resetLayoutStatus() {
        View r0 = this.contentView;
        if (r0 == null) goto L6;
        this.rootView.removeView(r0);
        this.contentView = null;
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
