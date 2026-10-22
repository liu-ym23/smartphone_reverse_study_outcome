package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.android.vcard.VCardConfig;
import com.obric.common.oui.R;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ResourceUtils;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.indicator.IndicatorExternalsKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OInsetSheet.kt */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use com.obric.oui.sheet.v2.OSheet(context: Context, hostWindowHeight: Int) instead")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0017\u0018\u0000 H2\u00020\u0001:\u0002HIB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010+\u001a\u00020%H\u0016J\u0006\u0010,\u001a\u00020%J\u0010\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\u0012\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020%H\u0014J\u0006\u00107\u001a\u00020%J\u0006\u00108\u001a\u00020%J\b\u00109\u001a\u00020%H\u0016J\u001a\u0010:\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)J\u000e\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u0012J\u0010\u0010=\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010>\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010?\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)J\b\u0010@\u001a\u00020%H\u0003J\u000e\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u001fJ\u000e\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006J"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentContainer", "Landroid/widget/FrameLayout;", "getContentContainer", "()Landroid/widget/FrameLayout;", "setContentContainer", "(Landroid/widget/FrameLayout;)V", "footerContainer", "getFooterContainer", "setFooterContainer", "headerContainer", "getHeaderContainer", "setHeaderContainer", "hideFirstFrame", "", "mClearDimFlag", "getMClearDimFlag", "()Z", "setMClearDimFlag", "(Z)V", "rootContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "getRootContainer", "()Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "setRootContainer", "(Lcom/obric/oui/dialog/alert/view/RadiusLayout;)V", "widthMode", "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "getWidthMode", "()Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "setWidthMode", "(Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;)V", "addChildToParent", "", "parent", "Landroid/view/ViewGroup;", "child", "Landroid/view/View;", "adjustContentHeight", "dismiss", "forceHideFirstFrame", "getTargetWindowDimAmount", "", "hideAndTransparentNavigationBar", "window", "Landroid/view/Window;", "needDimAnim", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "originDismiss", "performEnterAnimation", "performExitAnimation", "setChildToParent", "setClearDimFlag", "dim", "setContainerView", "setFooterView", "setHeaderView", "setOnApplyWindowInsetsListener", "setRootWidth", MaterialConfigFormatNames.WIDTH, "setSheetBgColor", "color", "", "setupView", "show", "Companion", "PanelWidth", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInsetSheet extends Dialog {
    public static final Companion Companion = null;
    private static final int HORIZONTAL_MAX_CONTENT_HEIGHT = 244;
    private static final int HORIZONTAL_MAX_HEIGHT = 296;
    private static final int HORIZONTAL_MAX_WIDTH = 440;
    public static final String TAG = "OInsetSheet";
    public FrameLayout contentContainer;
    public FrameLayout footerContainer;
    public FrameLayout headerContainer;
    private boolean hideFirstFrame;
    private boolean mClearDimFlag;
    public RadiusLayout rootContainer;
    private PanelWidth widthMode;

    /* JADX INFO: compiled from: OInsetSheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$Companion;", "", "()V", "HORIZONTAL_MAX_CONTENT_HEIGHT", "", "HORIZONTAL_MAX_HEIGHT", "HORIZONTAL_MAX_WIDTH", "TAG", "", "getMaxWidth", "context", "Landroid/content/Context;", "expected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ int access$getMaxWidth(Companion r0, Context r1, int r2) {
            return r0.getMaxWidth(r1, r2);
        }

        private final int getMaxWidth(Context r1, int r2) {
            if (ResourceUtils.INSTANCE.isLandscape(r1) == true) goto L5;
            return r2;
        L5:
            return RangesKt.coerceAtMost(r2, OUnitExtensionKt.cdp(r1, 440));
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "", "(Ljava/lang/String;I)V", "NARROW_WIDTH", "BOARD_WIDTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PanelWidth extends Enum<PanelWidth> {
        private static final /* synthetic */ PanelWidth[] $VALUES = null;
        public static final PanelWidth BOARD_WIDTH = null;
        public static final PanelWidth NARROW_WIDTH = null;

        private static final /* synthetic */ PanelWidth[] $values() {
            return new PanelWidth[]{NARROW_WIDTH, BOARD_WIDTH};
        }

        public static PanelWidth valueOf(String r1) {
            return (PanelWidth) Enum.valueOf(PanelWidth.class, r1);
        }

        public static PanelWidth[] values() {
            return (PanelWidth[]) $VALUES.clone();
        }

        private PanelWidth(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NARROW_WIDTH = new PanelWidth("NARROW_WIDTH", 0);
            BOARD_WIDTH = new PanelWidth("BOARD_WIDTH", 1);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[PanelWidth.values().length];
            r0[PanelWidth.NARROW_WIDTH.ordinal()] = 1;
            r0[PanelWidth.BOARD_WIDTH.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$5P-qY61Wjgo9OSb-OwQzVbc0A34, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1380$r8$lambda$5PqY61Wjgo9OSbOwQzVbc0A34(OInsetSheet r0, View r1, WindowInsets r2) {
        return m1383setOnApplyWindowInsetsListener$lambda0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$H7bMZ_50jZcuGihzTSM-iPNbp44, reason: not valid java name */
    public static /* synthetic */ void m1381$r8$lambda$H7bMZ_50jZcuGihzTSMiPNbp44(OInsetSheet r0) {
        m1382performEnterAnimation$lambda4(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public OInsetSheet(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.widthMode = PanelWidth.BOARD_WIDTH;
        Window r3 = getWindow();
        if (r3 == null) goto L6;
        r3.requestFeature(1);
    L6:
        setContentView(R.layout.o_inset_sheet_container);
        setupView();
        setOnApplyWindowInsetsListener();
    }

    public final FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.headerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    public final void setHeaderContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.headerContainer = r2;
    }

    public final FrameLayout getFooterContainer() {
        FrameLayout r0 = this.footerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    public final void setFooterContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.footerContainer = r2;
    }

    public final FrameLayout getContentContainer() {
        FrameLayout r0 = this.contentContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final void setContentContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentContainer = r2;
    }

    public final RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.rootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    public final void setRootContainer(RadiusLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootContainer = r2;
    }

    public final boolean getMClearDimFlag() {
        return this.mClearDimFlag;
    }

    public final void setMClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    public final PanelWidth getWidthMode() {
        return this.widthMode;
    }

    public final void setWidthMode(PanelWidth r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.widthMode = r2;
    }

    public final void setRootWidth(PanelWidth r5) {
        Intrinsics.checkNotNullParameter(r5, MaterialConfigFormatNames.WIDTH);
        this.widthMode = r5;
        int r6 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r6 == 1) goto L7;
        if (r6 != 2) goto L10;
        int r7 = getContext().getResources().getDisplayMetrics().widthPixels;
        Companion r0 = Companion;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        int r8 = Companion.access$getMaxWidth(r0, r2, r7);
        IndicatorExternalsKt.setWidth(getRootContainer(), r8);
        float r9 = getContext().getResources().getDimension(R.dimen.oui_r_l3);
        getRootContainer().setRadius(r9, r9, 0.0f, 0.0f);
        return;
    L10:
        return;
    L7:
        int r10 = getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R.dimen.oui_dialog_narrow_layout_margin) * 2);
        Companion r1 = Companion;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        int r11 = Companion.access$getMaxWidth(r1, r3, r10);
        IndicatorExternalsKt.setWidth(getRootContainer(), r11);
        getRootContainer().setRadius(getContext().getResources().getDimension(R.dimen.oui_r_l2));
    }

    private final void hideAndTransparentNavigationBar(Window r2) {
        if (r2 == null) goto L6;
        r2.setNavigationBarContrastEnforced(false);
    L6:
        if (r2 == null) goto L9;
        r2.setDecorFitsSystemWindows(false);
    L9:
        if (r2 == null) goto L12;
        r2.clearFlags(VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
    L12:
        if (r2 == null) goto L15;
        r2.addFlags(Integer.MIN_VALUE);
    L15:
        if (r2 == null) goto L18;
        r2.setNavigationBarColor(0);
    L18:
        if (r2 == null) goto L22;
        r2.setNavigationBarDividerColor(0);
        return;
    }

    public final void setHeaderView(View r2) {
        setChildToParent(getHeaderContainer(), r2);
    }

    public final void setSheetBgColor(int r1) {
        getRootContainer().setBackgroundColor(r1);
    }

    public final void setContainerView(View r2) {
        setChildToParent(getContentContainer(), r2);
    }

    public final void setFooterView(View r2) {
        setChildToParent(getFooterContainer(), r2);
    }

    public final void setClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    private final void setupView() {
        View r0 = findViewById(R.id.root_constraint);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.root_constraint)");
        setRootContainer((RadiusLayout) r0);
        getRootContainer().setMeasureHeightUnspecified(true);
        View r1 = findViewById(R.id.header_container);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.header_container)");
        setHeaderContainer((FrameLayout) r1);
        View r2 = findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.content_container)");
        setContentContainer((FrameLayout) r2);
        View r3 = findViewById(R.id.foot_container);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.foot_container)");
        setFooterContainer((FrameLayout) r3);
        DialogAnimStyle.INSTANCE.adjustDialogTopSpace(getRootContainer());
    }

    private final void setOnApplyWindowInsetsListener() {
        getRootContainer().setOnApplyWindowInsetsListener(new OInsetSheet$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: setOnApplyWindowInsetsListener$lambda-0, reason: not valid java name */
    private static final WindowInsets m1383setOnApplyWindowInsetsListener$lambda0(OInsetSheet r6, View r7, WindowInsets r8) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "v");
        Intrinsics.checkNotNullParameter(r8, "insets");
        int r0 = OWindowConfigController.INSTANCE.getNavigationBarHeight(r6.getContext());
        int r1 = OWindowConfigController.INSTANCE.getImeHeight(r6.getRootContainer());
        if (r1 <= 0) goto L10;
        PanelWidth r2 = r6.widthMode;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L9;
        if (r3 != 2) goto L17;
        r7.setPadding(0, 0, 0, r1);
    L17:
        return r8.consumeSystemWindowInsets();
    L9:
        IndicatorExternalsKt.setMarginBottom(r6.getRootContainer(), r1 + OUnitExtensionKt.vdp(r7, 16));
        goto L17
    L10:
        PanelWidth r9 = r6.widthMode;
        int r10 = WhenMappings.$EnumSwitchMapping$0[r9.ordinal()];
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L17;
        IndicatorExternalsKt.setMarginBottom(r6.getRootContainer(), 0);
        r6.getRootContainer().setPadding(0, 0, 0, r0);
        goto L17
    L15:
        IndicatorExternalsKt.setMarginBottom(r6.getRootContainer(), r0);
        r6.getRootContainer().setPadding(0, 0, 0, 0);
        goto L17
    }

    @Override // android.app.Dialog
    public void show() {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        adjustContentHeight(r0);
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L21;
        r1.setBackgroundDrawableResource(android.R.color.transparent);
        hideAndTransparentNavigationBar(r1);
        if (getMClearDimFlag() == false) goto L8;
        r1.clearFlags(2);
    L10:
        if ((r1.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        float r3 = 0.5f;
    L16:
        WindowManager.LayoutParams r4 = r1.getAttributes();
        if (needDimAnim() == true) goto L19;
        r4.dimAmount = r3;
    L19:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r4.gravity = 80;
        r1.setAttributes(r4);
        return;
    L15:
        r3 = 0.16f;
        goto L16
    L12:
        r2 = false;
        goto L13
    L8:
        r1.addFlags(2);
        goto L10
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.hideFirstFrame == false) goto L6;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        performEnterAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        performExitAnimation();
    }

    public final void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public void performExitAnimation() {
        ViewPropertySpringAnimator r0 = DialogAnimStyle.dialogBottomHide$default(DialogAnimStyle.INSTANCE, getRootContainer(), getWindow(), needDimAnim(), false, 4, null);
        ViewPropertySpringAnimator.setListener$default(r0, null, new OInsetSheet$performExitAnimation$1$1(this), new OInsetSheet$performExitAnimation$1$2(this), 1, null);
        r0.start();
    }

    public final void performEnterAnimation() {
        getRootContainer().post(new OInsetSheet$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-4, reason: not valid java name */
    private static final void m1382performEnterAnimation$lambda4(final OInsetSheet r15) {
        Intrinsics.checkNotNullParameter(r15, "this$0");
        DialogAnimStyle r1 = DialogAnimStyle.INSTANCE;
        RadiusLayout r2 = r15.getRootContainer();
        Window r3 = r15.getWindow();
        boolean r4 = r15.needDimAnim();
        Context r0 = r15.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        ViewPropertySpringAnimator r6 = ViewPropertySpringAnimator.setListener$default(DialogAnimStyle.dialogBottomShow$default(r1, r2, r3, r4, r15.getTargetWindowDimAmount(r0), false, 8, null), null, null, OInsetSheet$performEnterAnimation$1$anim$1.INSTANCE, 3, null);
        if (r15.hideFirstFrame == false) goto L5;
        ViewPropertySpringAnimator.setListener$default(r6, new OInsetSheet$performEnterAnimation$1$1(r15), null, null, 6, null);
    L5:
        r6.start();
    }

    public final void setChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L12;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L9;
        r1.removeAllViews();
    L9:
        if (r1 == null) goto L17;
        r1.addView(r2);
        return;
    L17:
        return;
    L12:
        if (r1 == null) goto L18;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        ViewExtensionsKt.makeVisible(r1);
    L6:
        if (r1 == null) goto L14;
        r1.addView(r2);
        return;
    L14:
        return;
    L9:
        if (r1 == null) goto L15;
        ViewExtensionsKt.makeGone(r1);
        return;
    }

    private final boolean needDimAnim() {
        return !this.mClearDimFlag;
    }

    private final float getTargetWindowDimAmount(Context r1) {
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r0 = false;
        goto L6
    }

    private final void adjustContentHeight(Context r7) {
        if (ResourceUtils.INSTANCE.isLandscape(r7) == false) goto L13;
        getRootContainer().measure(0, 0);     // Catch: Exception -> L8
        int r4 = ((OUnitExtensionKt.cdp(r7, 296) - OWindowConfigController.INSTANCE.getNavigationBarHeight(r7)) - getHeaderContainer().getMeasuredHeight()) - getFooterContainer().getMeasuredHeight();     // Catch: Exception -> L8
        getContentContainer().measure(View.MeasureSpec.makeMeasureSpec(OUnitExtensionKt.cdp(r7, 440), Integer.MIN_VALUE), 0);     // Catch: Exception -> L8
        int r2 = getContentContainer().getMeasuredHeight();     // Catch: Exception -> L8
        int r8 = RangesKt.coerceIn(r4, 0, OUnitExtensionKt.cdp(r7, 244));     // Catch: Exception -> L8
        if (r2 <= r8) goto L14;
        L.i("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r2 + ", final contentHeight: " + r8);     // Catch: Exception -> L8
        FrameLayout r1 = getContentContainer();     // Catch: Exception -> L8
        ViewGroup.LayoutParams r6 = getContentContainer().getLayoutParams();     // Catch: Exception -> L8
        r6.height = r8;     // Catch: Exception -> L8
        r1.setLayoutParams(r6);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        L.e("OInsetSheet", "adjustContentHeight error", e);
        return;
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }
}
