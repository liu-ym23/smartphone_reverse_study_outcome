package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
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

/* JADX INFO: compiled from: OBottomActionBarNormalVertical.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001*B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0014J\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0013J\u0014\u0010\u001f\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0!J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u000fJ\u000e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\bJ\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "buttonGap", "", "defaultPaddingBottom", "divider", "Lcom/obric/oui/divider/ODivider;", "headerContainer", "maxButtons", "root", "Landroid/view/View;", "verticalContainer", "Landroid/widget/LinearLayout;", "addButton", "", "button", "getButtonCount", "getMaxButtonCount", "hasHeaderView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeAllButtons", "removeButton", "removeHeaderView", "setButtons", "buttons", "", "setHeaderView", "headerView", "setMaxButtonCount", "maxCount", "showDivider", InvokeHistoryActivity.PREF_SHOW, "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomActionBarNormalVertical extends FrameLayout {
    public static final Companion Companion = null;
    private static final int MAX_BUTTONS = 3;
    public static final String TAG = "OBottomActionBarNormalVertical";
    private int buttonGap;
    private int defaultPaddingBottom;
    private ODivider divider;
    private FrameLayout headerContainer;
    private int maxButtons;
    private View root;
    private LinearLayout verticalContainer;

    /* JADX INFO: compiled from: OBottomActionBarNormalVertical.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/actionbar/v2/OBottomActionBarNormalVertical$Companion;", "", "()V", "MAX_BUTTONS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$V7R1qNDd4z_XD1-g8lKPJhqu7b4, reason: not valid java name */
    public static /* synthetic */ WindowInsets m198$r8$lambda$V7R1qNDd4z_XD1g8lKPJhqu7b4(OBottomActionBarNormalVertical r0, View r1, WindowInsets r2) {
        return m199lambda3$lambda2(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OBottomActionBarNormalVertical(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public OBottomActionBarNormalVertical(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        OBottomActionBarNormalVertical r0 = this;
        this.buttonGap = OUnitExtensionKt.vdp(r0, 12);
        this.maxButtons = 3;
        FrameLayout.inflate(r9, R.layout.o_widget_bottom_action_bar_v2_normal_vertical, this);
        View r1 = findViewById(R.id.bottom_action_bar_root);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.bottom_action_bar_root)");
        this.root = r1;
        this.defaultPaddingBottom = r1.getPaddingBottom();
        ODivider r2 = new ODivider(r9, null, 0, 6, null);
        this.divider = r2;
        addView(r2, new FrameLayout.LayoutParams(-1, OUnitExtensionKt.vdp(r0, 0.6d)));
        View r3 = findViewById(R.id.action_bar_vertical_container);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.action_bar_vertical_container)");
        this.verticalContainer = (LinearLayout) r3;
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
        updateLayoutForInsetBottom(OWindowConfigController.getSystemBarInsets(r0, null).bottom);
        setOnApplyWindowInsetsListener(new OBottomActionBarNormalVertical$$ExternalSyntheticLambda0(this));
    L5:
        r11.recycle();
    }

    public /* synthetic */ OBottomActionBarNormalVertical(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    /* JADX INFO: renamed from: lambda-3$lambda-2, reason: not valid java name */
    private static final WindowInsets m199lambda3$lambda2(OBottomActionBarNormalVertical r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        OWindowConfigController r4 = OWindowConfigController.INSTANCE;
        r1.updateLayoutForInsetBottom(OWindowConfigController.getSystemBarInsets(r1, r3).bottom);
        return r3;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r9, int r10) {
        if (this.headerContainer.getChildCount() <= 0) goto L19;
        int r0 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r9), Integer.MIN_VALUE);
        int r3 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.verticalContainer.measure(r1, r3);
        int r4 = this.verticalContainer.getMeasuredHeight();
        int r5 = this.root.getPaddingTop() + this.root.getPaddingBottom();
        ViewGroup.LayoutParams r6 = this.verticalContainer.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L8:
        if (r7 != null) goto L10;
        int r8 = 0;
    L11:
        int r2 = Math.max(0, r0 - ((r5 + r8) + r4));
        this.headerContainer.measure(r1, r3);
        int r11 = this.headerContainer.getMeasuredHeight();
        ViewGroup.LayoutParams r12 = this.headerContainer.getLayoutParams();
        if (r2 >= r11) goto L17;
        if (r12.height == r2) goto L19;
        r12.height = r2;
        this.headerContainer.setLayoutParams(r12);
        goto L19
    L17:
        if (r12.height == (-2)) goto L19;
        r12.height = -2;
        this.headerContainer.setLayoutParams(r12);
        goto L19
    L10:
        r8 = r7.topMargin;
        goto L11
    L7:
        r7 = null;
    L19:
        super.onMeasure(r9, r10);
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
        return this.verticalContainer.getChildCount();
    }

    public final void setButtons(List<? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "buttons");
        this.verticalContainer.removeAllViews();
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        addButton((View) r3.next());
        goto L4
    }

    public final void addButton(View r4) {
        Intrinsics.checkNotNullParameter(r4, "button");
        int r0 = this.verticalContainer.getChildCount();
        int r1 = this.maxButtons;
        if (r0 < r1) goto L6;
        L.w(TAG, Intrinsics.stringPlus("Maximum number of buttons reached: ", Integer.valueOf(r1)));
        return;
    L6:
        ViewGroup.LayoutParams r2 = r4.getLayoutParams();
        if (r2 == null) goto L9;
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r2.width, r2.height);
    L10:
        LinearLayout r5 = this.verticalContainer;
        if (r5.getChildCount() <= 0) goto L13;
        r3.topMargin = this.buttonGap;
    L13:
        Unit r6 = Unit.INSTANCE;
        r5.addView(r4, r3);
        return;
    L9:
        r3 = new LinearLayout.LayoutParams(-1, -2);
        goto L10
    }

    public final void removeButton(View r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        this.verticalContainer.removeView(r2);
    }

    public final void removeButton() {
        if (this.verticalContainer.getChildCount() != 0) goto L6;
        L.w(TAG, "No buttons to remove");
        return;
    L6:
        LinearLayout r1 = this.verticalContainer;
        r1.removeViewAt(r1.getChildCount() - 1);
    }

    public final void removeAllButtons() {
        this.verticalContainer.removeAllViews();
    }

    public final int getMaxButtonCount() {
        return this.maxButtons;
    }

    public final void setMaxButtonCount(int r3) {
        if (this.verticalContainer.getChildCount() <= r3) goto L6;
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
        ViewGroup.LayoutParams r3 = this.verticalContainer.getLayoutParams();
        if (r3 == null) goto L7;
        int r1 = OUnitExtensionKt.vdp(this, 8);
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r1;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void removeHeaderView() {
        this.headerContainer.removeAllViews();
        ViewGroup.LayoutParams r0 = this.verticalContainer.getLayoutParams();
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
