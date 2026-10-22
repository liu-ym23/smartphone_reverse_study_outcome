package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.divider.ODivider;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBottomActionBarNormalHorizontal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0013J\u0014\u0010\u001d\u001a\u00020\u00132\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001fJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0016J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonGap", "", "defaultPaddingBottom", "divider", "Lcom/obric/oui/divider/ODivider;", "headerContainer", "horizontalContainer", "Landroid/widget/LinearLayout;", "maxButtons", "root", "Landroid/view/View;", "addButton", "", "button", "isSingleButton", "", "getButtonCount", "getMaxButtonCount", "hasHeaderView", "removeAllButtons", "removeButton", "removeHeaderView", "setButtons", "buttons", "", "setHeaderView", "headerView", "setMaxButtonCount", "maxCount", "showDivider", "show", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalHorizontal extends FrameLayout {
    public static final Companion Companion = null;
    private static final int MAX_BUTTONS = 2;
    public static final String TAG = "OBottomActionBarNormalHorizontal";
    private int buttonGap;
    private int defaultPaddingBottom;
    private ODivider divider;
    private FrameLayout headerContainer;
    private LinearLayout horizontalContainer;
    private int maxButtons;
    private View root;

    /* JADX INFO: compiled from: OBottomActionBarNormalHorizontal.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalHorizontal$Companion;", "", "()V", "MAX_BUTTONS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$sD585snicY-vMCVyeoEhx_r5M1k, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1048$r8$lambda$sD585snicYvMCVyeoEhx_r5M1k(OBottomActionBarNormalHorizontal r0, View r1, WindowInsets r2) {
        return m1049lambda3$lambda2(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBarNormalHorizontal(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomActionBarNormalHorizontal(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        OBottomActionBarNormalHorizontal r0 = this;
        this.buttonGap = OUnitExtensionKt.vdp(r0, 12);
        this.maxButtons = 2;
        View.inflate(r9, R.layout.o_widget_bottom_action_bar_v2_normal_horizontal, this);
        View r1 = findViewById(R.id.bottom_action_bar_root);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.bottom_action_bar_root)");
        this.root = r1;
        this.defaultPaddingBottom = r1.getPaddingBottom();
        ODivider r2 = new ODivider(r9, null, 0, 6, null);
        this.divider = r2;
        addView(r2, new FrameLayout.LayoutParams(-1, OUnitExtensionKt.vdp(r0, 0.6d)));
        View r3 = findViewById(R.id.action_bar_horizontal_container);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.action_bar_horizontal_container)");
        this.horizontalContainer = (LinearLayout) r3;
        View r4 = findViewById(R.id.action_bar_header_container);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.action_bar_header_container)");
        this.headerContainer = (FrameLayout) r4;
        setClipChildren(false);
        setClipToPadding(false);
        int[] r5 = R.styleable.OBottomActionBar;
        Intrinsics.checkNotNullExpressionValue(r5, "OBottomActionBar");
        TypedArray r11 = r9.obtainStyledAttributes(r10, r5, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r11, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r11.getBoolean(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, true) == false) goto L5;
        OWindowConfigController r12 = OWindowConfigController.INSTANCE;
        updateLayoutForInsetBottom(OWindowConfigController.getSystemBarInsetsInfo(r0, null, true).bottom);
        setOnApplyWindowInsetsListener(new OBottomActionBarNormalHorizontal$$ExternalSyntheticLambda0(this));
    L5:
        r11.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalHorizontal(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    /* JADX INFO: renamed from: lambda-3$lambda-2, reason: not valid java name */
    private static final WindowInsets m1049lambda3$lambda2(OBottomActionBarNormalHorizontal r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        OWindowConfigController r4 = OWindowConfigController.INSTANCE;
        r1.updateLayoutForInsetBottom(OWindowConfigController.getSystemBarInsetsInfo(r1, r3, true).bottom);
        return r3;
    }

    public final void updateLayoutForInsetBottom(int r5) {
        View r0 = this.root;
        r0.setPaddingRelative(r0.getPaddingLeft(), this.root.getPaddingTop(), this.root.getPaddingRight(), Math.max(r5, this.defaultPaddingBottom));
    }

    public final void showDivider(boolean r1) {
        ODivider r0 = this.divider;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public final int getButtonCount() {
        return this.horizontalContainer.getChildCount();
    }

    public final void setButtons(List<? extends View> r5) {
        Intrinsics.checkNotNullParameter(r5, "buttons");
        if (r5.size() <= this.maxButtons) goto L6;
        L.w(TAG, "Cannot set more than " + this.maxButtons + " buttons");
        return;
    L6:
        this.horizontalContainer.removeAllViews();
        Iterator<T> r0 = r5.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        View r1 = (View) r0.next();
        boolean r3 = true;
        if (r5.size() == 1) goto L13;
        r3 = false;
    L13:
        addButton(r1, r3);
        goto L8
    }

    private final void addButton(View r5, boolean r6) {
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        if (r0 == null) goto L5;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r0.width, r0.height);
    L6:
        if (r6 == false) goto L8;
        r2.width = -1;
    L9:
        LinearLayout r7 = this.horizontalContainer;
        if (r7.getChildCount() <= 0) goto L12;
        r2.leftMargin = this.buttonGap;
    L12:
        Unit r4 = Unit.INSTANCE;
        r7.addView(r5, r2);
        return;
    L8:
        r2.width = 0;
        r2.weight = 1.0f;
        goto L9
    L5:
        r2 = new LinearLayout.LayoutParams(-1, -2);
        goto L6
    }

    public final void removeButton(View r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        this.horizontalContainer.removeView(r2);
    }

    public final void removeButton() {
        if (this.horizontalContainer.getChildCount() != 0) goto L6;
        L.w(TAG, "No buttons to remove");
        return;
    L6:
        LinearLayout r1 = this.horizontalContainer;
        r1.removeViewAt(r1.getChildCount() - 1);
    }

    public final void removeAllButtons() {
        this.horizontalContainer.removeAllViews();
    }

    public final int getMaxButtonCount() {
        return this.maxButtons;
    }

    public final void setMaxButtonCount(int r3) {
        if (this.horizontalContainer.getChildCount() <= r3) goto L6;
        L.e(TAG, "Cannot set max button count to less than current button count");
        return;
    L6:
        if (r3 <= 0) goto L8;
        this.maxButtons = r3;
        return;
    L8:
        L.e(TAG, "Max button count must be greater than 0");
    }

    public final void setHeaderView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "headerView");
        this.headerContainer.removeAllViews();
        this.headerContainer.addView(r2);
        ViewGroup.LayoutParams r3 = this.horizontalContainer.getLayoutParams();
        if (r3 == null) goto L7;
        int r1 = OUnitExtensionKt.vdp(this, 8);
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r1;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void removeHeaderView() {
        this.headerContainer.removeAllViews();
        ViewGroup.LayoutParams r0 = this.horizontalContainer.getLayoutParams();
        if (r0 == null) goto L7;
        int r2 = OUnitExtensionKt.vdp(this, 0);
        ((ViewGroup.MarginLayoutParams) r0).topMargin = r2;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final boolean hasHeaderView() {
        if (this.headerContainer.getChildCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
