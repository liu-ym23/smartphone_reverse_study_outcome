package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.panel.header.BasicPanelDefaultHeader;
import com.obric.oui.panel.header.BasicPanelDragHeader;
import com.obric.oui.panel.header.BasicPanelHeader;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OBasePanelDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010b\u001a\u00020cH\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010d\u001a\u00020&H\u0016J\b\u0010e\u001a\u00020cH\u0002J\u0006\u0010f\u001a\u00020\u0005J\b\u0010g\u001a\u0004\u0018\u00010 J\b\u0010,\u001a\u00020\u0005H\u0002J\b\u0010h\u001a\u0004\u0018\u00010 J\b\u0010i\u001a\u0004\u0018\u00010UJ\b\u0010j\u001a\u00020\u0005H\u0002J\u0006\u0010k\u001a\u00020cJ\b\u0010l\u001a\u00020cH\u0002J\b\u0010m\u001a\u00020cH\u0016J\u0012\u0010n\u001a\u00020c2\b\u0010o\u001a\u0004\u0018\u00010pH\u0014J\b\u0010q\u001a\u00020cH\u0014J\u0006\u0010\\\u001a\u00020cJ\u000e\u0010r\u001a\u00020c2\u0006\u0010s\u001a\u00020\u0005J\u0010\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020vH\u0016J\u001a\u0010t\u001a\u00020c2\u0006\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\u0010\u0010t\u001a\u00020c2\u0006\u0010y\u001a\u00020\u0005H\u0016J\u000e\u0010-\u001a\u00020c2\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010z\u001a\u00020c2\u0006\u0010{\u001a\u00020\bJ(\u0010|\u001a\u00020c2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020~2\u0007\u0010\u0080\u0001\u001a\u00020~2\u0007\u0010\u0081\u0001\u001a\u00020~J%\u0010\u0082\u0001\u001a\u00020v2\u0006\u0010y\u001a\u00020\u00052\b\u0010u\u001a\u0004\u0018\u00010v2\b\u0010w\u001a\u0004\u0018\u00010xH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010.\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001a\u00101\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR\u001a\u00104\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR\u0010\u00107\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001dR\"\u0010B\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u0004\u0018\u00010WX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010\\\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\n\"\u0004\b^\u0010\fR\u001a\u0010_\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\n\"\u0004\ba\u0010\f¨\u0006\u0083\u0001"}, d2 = {"Lcom/obric/oui/panel/OBasePanelDialog;", "Lcom/obric/oui/panel/BottomSheetDialog;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "adaptNavBarColor", "", "getAdaptNavBarColor", "()Z", "setAdaptNavBarColor", "(Z)V", "adaptRLSlide", "getAdaptRLSlide", "setAdaptRLSlide", "autoSwitchDayNight", "getAutoSwitchDayNight", "setAutoSwitchDayNight", "backgroundDimEnable", "getBackgroundDimEnable", "setBackgroundDimEnable", "clipTopCorner", "getClipTopCorner", "setClipTopCorner", "collapsedHeight", "getCollapsedHeight", "()Ljava/lang/Integer;", "setCollapsedHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "contentContainer", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "disableAutoAdaptHeight", "getDisableAutoAdaptHeight", "setDisableAutoAdaptHeight", "dispatchTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "expandedHeight", "getExpandedHeight", "setExpandedHeight", "fitsSystemWindows", "getFitsSystemWindows", "setFitsSystemWindows", "fixedHeight", "getFixedHeight", "setFixedHeight", "floatHeader", "getFloatHeader", "setFloatHeader", "headerContainer", "isExpandable", "setExpandable", "maxPanelHeight", "getMaxPanelHeight", "()I", "setMaxPanelHeight", "(I)V", "navBarColor", "getNavBarColor", "setNavBarColor", "onDialogBackPressCallback", "Lkotlin/Function0;", "getOnDialogBackPressCallback", "()Lkotlin/jvm/functions/Function0;", "setOnDialogBackPressCallback", "(Lkotlin/jvm/functions/Function0;)V", "outsideClickListener", "Landroid/view/View$OnClickListener;", "getOutsideClickListener", "()Landroid/view/View$OnClickListener;", "setOutsideClickListener", "(Landroid/view/View$OnClickListener;)V", "padCompatConfig", "Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "getPadCompatConfig", "()Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;", "setPadCompatConfig", "(Lcom/obric/oui/panel/OBasicPanel$PadCompatConfig;)V", "panelContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "panelHeader", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "getPanelHeader", "()Lcom/obric/oui/panel/header/BasicPanelHeader;", "setPanelHeader", "(Lcom/obric/oui/panel/header/BasicPanelHeader;)V", "removeMinHeight", "getRemoveMinHeight", "setRemoveMinHeight", "useToneBg", "getUseToneBg", "setUseToneBg", "compatibleWithPad", "", "ev", "ensureHeaderAndContainer", "getBgColor", "getContentContainer", "getHeaderContainer", "getPanelContainer", "getPeekHeight", "hideHeader", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setBgColor", "color", "setContentView", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResId", "setFitsSystemWindow", "fit", "setRadius", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "wrapWithHeader", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBasePanelDialog extends BottomSheetDialog {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private RadiusLayout contentContainer;
    private boolean disableAutoAdaptHeight;
    private Function1<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedHeight;
    private boolean floatHeader;
    private RadiusLayout headerContainer;
    private boolean isExpandable;
    private int maxPanelHeight;
    private Integer navBarColor;
    private Function0<Boolean> onDialogBackPressCallback;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.PadCompatConfig padCompatConfig;
    private ConstraintLayout panelContainer;
    private BasicPanelHeader panelHeader;
    private boolean removeMinHeight;
    private boolean useToneBg;

    /* JADX INFO: compiled from: OBasePanelDialog.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OBasicPanel.PadCompatConfig.CloseIconStyle.values().length];
            r0[OBasicPanel.PadCompatConfig.CloseIconStyle.BLACK_WITH_BG.ordinal()] = 1;
            r0[OBasicPanel.PadCompatConfig.CloseIconStyle.WHITE_WITH_BG.ordinal()] = 2;
            r0[OBasicPanel.PadCompatConfig.CloseIconStyle.BLACK_NO_BG.ordinal()] = 3;
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final void compatibleWithPad() {
    }

    public OBasePanelDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.fitsSystemWindows = true;
        this.clipTopCorner = true;
    }

    public /* synthetic */ OBasePanelDialog(Context r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = R.style.OBasicPanel;
    L5:
        this(r1, r2);
    }

    public final int getMaxPanelHeight() {
        return this.maxPanelHeight;
    }

    public final void setMaxPanelHeight(int r1) {
        this.maxPanelHeight = r1;
    }

    public final boolean getUseToneBg() {
        return this.useToneBg;
    }

    public final void setUseToneBg(boolean r1) {
        this.useToneBg = r1;
    }

    public final boolean isExpandable() {
        return this.isExpandable;
    }

    public final void setExpandable(boolean r1) {
        this.isExpandable = r1;
    }

    public final boolean getFloatHeader() {
        return this.floatHeader;
    }

    public final void setFloatHeader(boolean r1) {
        this.floatHeader = r1;
    }

    public final boolean getBackgroundDimEnable() {
        return this.backgroundDimEnable;
    }

    public final void setBackgroundDimEnable(boolean r1) {
        this.backgroundDimEnable = r1;
    }

    public final boolean getAdaptNavBarColor() {
        return this.adaptNavBarColor;
    }

    public final void setAdaptNavBarColor(boolean r1) {
        this.adaptNavBarColor = r1;
    }

    public final BasicPanelHeader getPanelHeader() {
        return this.panelHeader;
    }

    public final void setPanelHeader(BasicPanelHeader r1) {
        this.panelHeader = r1;
    }

    public final boolean getAutoSwitchDayNight() {
        return this.autoSwitchDayNight;
    }

    public final void setAutoSwitchDayNight(boolean r1) {
        this.autoSwitchDayNight = r1;
    }

    public final Function1<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final void setDispatchTouchEvent(Function1<? super MotionEvent, Boolean> r1) {
        this.dispatchTouchEvent = r1;
    }

    public final boolean getRemoveMinHeight() {
        return this.removeMinHeight;
    }

    public final void setRemoveMinHeight(boolean r1) {
        this.removeMinHeight = r1;
    }

    public final boolean getFixedHeight() {
        return this.fixedHeight;
    }

    public final void setFixedHeight(boolean r1) {
        this.fixedHeight = r1;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final void setOutsideClickListener(View.OnClickListener r1) {
        this.outsideClickListener = r1;
    }

    public final OBasicPanel.PadCompatConfig getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final void setPadCompatConfig(OBasicPanel.PadCompatConfig r1) {
        this.padCompatConfig = r1;
    }

    public final boolean getAdaptRLSlide() {
        return this.adaptRLSlide;
    }

    public final void setAdaptRLSlide(boolean r1) {
        this.adaptRLSlide = r1;
    }

    public final boolean getDisableAutoAdaptHeight() {
        return this.disableAutoAdaptHeight;
    }

    public final void setDisableAutoAdaptHeight(boolean r1) {
        this.disableAutoAdaptHeight = r1;
    }

    public final Integer getCollapsedHeight() {
        return this.collapsedHeight;
    }

    public final void setCollapsedHeight(Integer r1) {
        this.collapsedHeight = r1;
    }

    /* JADX INFO: renamed from: getExpandedHeight, reason: collision with other method in class */
    public final Integer m1259getExpandedHeight() {
        return this.expandedHeight;
    }

    public final void setExpandedHeight(Integer r1) {
        this.expandedHeight = r1;
    }

    public final boolean getFitsSystemWindows() {
        return this.fitsSystemWindows;
    }

    public final void setFitsSystemWindows(boolean r1) {
        this.fitsSystemWindows = r1;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final void setNavBarColor(Integer r1) {
        this.navBarColor = r1;
    }

    public final Function0<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final void setOnDialogBackPressCallback(Function0<Boolean> r1) {
        this.onDialogBackPressCallback = r1;
    }

    public final boolean getClipTopCorner() {
        return this.clipTopCorner;
    }

    public final void setClipTopCorner(boolean r1) {
        this.clipTopCorner = r1;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.setContentView(wrapWithHeader(0, r3, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapWithHeader(r2, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.setContentView(wrapWithHeader(0, r2, r3));
    }

    private final void ensureHeaderAndContainer() {
        if (this.panelContainer != null) goto L5;
    L8:
        RadiusLayout r2 = null;
        ConstraintLayout r0 = (ConstraintLayout) View.inflate(getContext(), R.layout.o_basic_panel, null);
        this.panelContainer = r0;
        if (r0 != null) goto L11;
        RadiusLayout r1 = null;
    L12:
        this.headerContainer = r1;
        ConstraintLayout r3 = this.panelContainer;
        if (r3 == null) goto L16;
        r2 = (RadiusLayout) r3.findViewById(R.id.content_container);
    L16:
        this.contentContainer = r2;
        return;
    L11:
        r1 = (RadiusLayout) r0.findViewById(R.id.header_container);
        goto L12
    L5:
        if (this.headerContainer == null) goto L8;
        if (this.contentContainer == null) goto L8;
    }

    private final View wrapWithHeader(int r3, View r4, ViewGroup.LayoutParams r5) {
        ensureHeaderAndContainer();
        if (r3 == 0) goto L6;
        if (r4 != null) goto L6;
        r4 = getLayoutInflater().inflate(r3, this.contentContainer, false);
    L6:
        RadiusLayout r6 = this.contentContainer;
        if (r6 == null) goto L10;
        r6.removeAllViews();
    L10:
        if (r5 != null) goto L15;
        RadiusLayout r7 = this.contentContainer;
        if (r7 == null) goto L19;
        r7.addView(r4);
    L19:
        initView();
        ConstraintLayout r2 = this.panelContainer;
        Intrinsics.checkNotNull(r2);
        return r2;
    L15:
        RadiusLayout r8 = this.contentContainer;
        if (r8 == null) goto L19;
        r8.addView(r4, r5);
        goto L19
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        boolean r0 = true;
        getBehavior().setHideable(true);
        getBehavior().fitsSystemWindow = this.fitsSystemWindows;
        getBehavior().setAutoSlideToPeekHeight(!this.disableAutoAdaptHeight);
        if (this.isExpandable == false) goto L5;
        setIs69Expandable(true);
        getBehavior().setPeekHeight(getPeekHeight());
        return;
    L5:
        BottomSheetBehavior<FrameLayout> r5 = getBehavior();
        BasicPanelHeader r1 = this.panelHeader;
        if ((r1 instanceof BasicPanelDragHeader) == false) goto L8;
    L16:
        r5.setDraggable(r0);
        if (this.maxPanelHeight <= 0) goto L23;
        getBehavior().setMaxExpandedHeight(this.maxPanelHeight);
        if (this.fixedHeight == false) goto L24;
        setExpandedHeight(this.maxPanelHeight);
        return;
    L24:
        return;
    L23:
        return;
    L8:
        if (r1 != null) goto L11;
    L9:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        r0 = false;
        goto L16
    L11:
        if (r1.getForceSupportSwipeToClose() != true) goto L9;
        r2 = true;
        goto L13
    }

    private final void initView() {
        if (this.panelHeader != null) goto L5;
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        this.panelHeader = new BasicPanelDefaultHeader(r2, null, null, 6, null);
    L5:
        compatibleWithPad();
        if (this.clipTopCorner == false) goto L8;
        FrameLayout r0 = getBottomSheet();
        Intrinsics.checkNotNullExpressionValue(r0, "bottomSheet");
        float r1 = OUnitExtensionKt.vdpFloat(r0, 20);
    L9:
        RadiusLayout r3 = this.headerContainer;
        if (r3 == null) goto L14;
        r3.setRadius(r1, r1, 0.0f, 0.0f);
    L14:
        if (this.floatHeader == false) goto L19;
        RadiusLayout r4 = this.contentContainer;
        if (r4 == null) goto L19;
        r4.setRadius(r1, r1, 0.0f, 0.0f);
    L19:
        BasicPanelHeader r5 = this.panelHeader;
        if (r5 != null) goto L22;
    L21:
        ViewParent r6 = null;
    L27:
        if ((r6 instanceof ViewGroup) == false) goto L46;
        BasicPanelHeader r7 = this.panelHeader;
        if (r7 != null) goto L31;
    L30:
        ViewParent r8 = null;
    L36:
        if ((r8 instanceof ViewGroup) == false) goto L38;
        ViewGroup r9 = (ViewGroup) r8;
    L39:
        if (r9 == null) goto L46;
        BasicPanelHeader r10 = this.panelHeader;
        if (r10 != null) goto L44;
        View r11 = null;
    L45:
        r9.removeView(r11);
        goto L46
    L44:
        r11 = r10.getView();
        goto L45
    L38:
        r9 = null;
        goto L39
    L31:
        View r12 = r7.getView();
        if (r12 == null) goto L30;
        r8 = r12.getParent();
    L46:
        RadiusLayout r13 = this.headerContainer;
        if (r13 == null) goto L55;
        RadiusLayout r14 = r13;
        BasicPanelHeader r15 = this.panelHeader;
        if (r15 != null) goto L52;
        View r16 = null;
    L53:
        ViewExtensionsKt.removeFromParentAndAdd(r14, r16);
        goto L55
    L52:
        r16 = r15.getView();
    L55:
        if (this.floatHeader == false) goto L67;
        if (this.contentContainer == null) goto L67;
        ConstraintSet r17 = new ConstraintSet();
        r17.clone(this.panelContainer);
        RadiusLayout r18 = this.contentContainer;
        Intrinsics.checkNotNull(r18);
        r17.clear(r18.getId(), 3);
        RadiusLayout r19 = this.contentContainer;
        Intrinsics.checkNotNull(r19);
        r17.connect(r19.getId(), 3, 0, 3);
        r17.applyTo(this.panelContainer);
        RadiusLayout r20 = this.headerContainer;
        if (r20 == null) goto L62;
        r20.setBackground(null);
    L62:
        RadiusLayout r21 = this.headerContainer;
        if (r21 == null) goto L67;
        r21.bringToFront();
    L67:
        if (this.backgroundDimEnable == true) goto L73;
        Window r22 = getWindow();
        if (r22 == null) goto L73;
        r22.setDimAmount(0.0f);
    L73:
        if (this.adaptNavBarColor == false) goto L95;
        Integer r23 = this.navBarColor;
        if (r23 == null) goto L77;
        int r24 = r23.intValue();
        Window r25 = getWindow();
        if (r25 == null) goto L98;
        r25.setNavigationBarColor(r24);
        return;
    L98:
        return;
    L77:
        if (this.autoSwitchDayNight == false) goto L83;
        if (this.useToneBg == false) goto L81;
        int r26 = R.color.BGPanelTone;
    L86:
        Window r27 = getWindow();
        if (r27 == null) goto L97;
        r27.setNavigationBarColor(ContextCompat.getColor(getContext(), r26));
        return;
    L97:
        return;
    L81:
        r26 = R.color.BGPanelTint;
        goto L86
    L83:
        if (this.useToneBg == false) goto L85;
        r26 = R.color.ConstBGPanelReverse;
        goto L86
    L85:
        r26 = R.color.ConstTextInverse;
        goto L86
    L95:
        return;
    L22:
        View r28 = r5.getView();
        if (r28 == null) goto L21;
        r6 = r28.getParent();
        goto L27
    L8:
        r1 = 0.0f;
        goto L9
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (this.removeMinHeight == false) goto L6;
        removeMinHeight();
    L6:
        if (this.clipTopCorner == false) goto L8;
        FrameLayout r0 = getBottomSheet();
        Intrinsics.checkNotNullExpressionValue(r0, "bottomSheet");
        float r1 = OUnitExtensionKt.vdpFloat(r0, 20);
    L9:
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setCornerRadii(new float[]{r1, r1, r1, r1, 0.0f, 0.0f, 0.0f, 0.0f});
        r2.setColor(getBgColor());
        FrameLayout r3 = getBottomSheet();
        if (r3 == null) goto L14;
        r3.setBackground(r2);
    L14:
        if (this.isExpandable == false) goto L16;
        setExpandedHeight(getExpandedHeight());
    L16:
        setFitsSystemWindow(this.fitsSystemWindows);
        getBehavior().setIs69Mode(this.isExpandable);
        if (this.outsideClickListener == null) goto L22;
        View r4 = findViewById(R.id.touch_outside);
        if (r4 == null) goto L22;
        r4.setOnClickListener(this.outsideClickListener);
    L22:
        adaptPortraitRLSlide(this.adaptRLSlide);
        return;
    L8:
        r1 = 0.0f;
        goto L9
    }

    public final int getBgColor() {
        if (this.autoSwitchDayNight == false) goto L9;
        if (this.useToneBg == false) goto L7;
        int r0 = R.color.BGPanelTone;
    L13:
        return ContextCompat.getColor(getContext(), r0);
    L7:
        r0 = R.color.BGPanelTint;
        goto L13
    L9:
        if (this.useToneBg == false) goto L11;
        r0 = R.color.ConstBGPanelReverse;
        goto L13
    L11:
        r0 = R.color.ConstTextInverse;
        goto L13
    }

    public final void setExpandedHeight(int r2) {
        FrameLayout r1 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r1 == null) goto L6;
        r1.getLayoutParams().height = r2;
        return;
    }

    public final void removeMinHeight() {
        FrameLayout r1 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r1 == null) goto L6;
        r1.setMinimumHeight(0);
        return;
    }

    public final void hideHeader() {
        RadiusLayout r0 = this.headerContainer;
        if (r0 == null) goto L7;
        ViewExtensionsKt.makeGone(r0);
        return;
    }

    private final int getPeekHeight() {
        Integer r0 = this.collapsedHeight;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0.intValue();
    L6:
        Resources r1 = getContext().getResources();
        if (r1 != null) goto L9;
        Integer r2 = null;
    L10:
        boolean r3 = false;
        if (r2 == null) goto L21;
        if (r2.intValue() <= 0) goto L21;
        Resources r4 = getContext().getResources();
        if (r4 != null) goto L17;
        boolean r5 = false;
    L18:
        if (r5 == false) goto L21;
        r3 = true;
        goto L21
    L17:
        r5 = r4.getBoolean(r2.intValue());
    L21:
        if (r3 == false) goto L24;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        return (int) (((double) OUnitExtensionKt.getScreenHeight(r6)) * 0.65d);
    L24:
        Context r7 = getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "context");
        return (int) (((double) OUnitExtensionKt.getScreenHeight(r7)) * 0.6d);
    L9:
        r2 = Integer.valueOf(r1.getIdentifier("config_showNavigationBar", "bool", RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME));
        goto L10
    }

    private final int getExpandedHeight() {
        Integer r0 = this.expandedHeight;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        return r0.intValue();
    L6:
        Context r4 = getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context");
        return (int) (((double) OUnitExtensionKt.getScreenHeight(r4)) * 0.9d);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        Function0<Boolean> r0 = this.onDialogBackPressCallback;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        super.onBackPressed();
        return;
    L6:
        if (r0.invoke().booleanValue() != true) goto L8;
        r1 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        Function1<? super MotionEvent, Boolean> r0 = this.dispatchTouchEvent;
        if (r0 == null) goto L10;
        if (r0.invoke(r2).booleanValue() == false) goto L10;
        return true;
    L10:
        return super.dispatchTouchEvent(r2);
    }

    public final ConstraintLayout getPanelContainer() {
        return this.panelContainer;
    }

    public final RadiusLayout getContentContainer() {
        return this.contentContainer;
    }

    public final RadiusLayout getHeaderContainer() {
        return this.headerContainer;
    }

    public final void setRadius(float r12, float r13, float r14, float r15) {
        RadiusLayout r0 = this.headerContainer;
        if (r0 == null) goto L7;
        r0.setRadius(r12, r13, r14, r15);
    L7:
        if (this.floatHeader == false) goto L12;
        RadiusLayout r1 = this.contentContainer;
        if (r1 == null) goto L12;
        r1.setRadius(r12, r13, r14, r15);
    L12:
        FrameLayout r2 = getBottomSheet();
        if (r2 != null) goto L15;
        Drawable r3 = null;
    L17:
        if ((r3 instanceof GradientDrawable) == false) goto L19;
        ((GradientDrawable) r3).setCornerRadii(new float[]{r12, r12, r13, r13, r14, r14, r15, r15});
        return;
    L19:
        if (r3 != null) goto L26;
        FrameLayout r11 = getBottomSheet();
        if (r11 == null) goto L27;
        GradientDrawable r4 = new GradientDrawable();
        r4.setCornerRadii(new float[]{r12, r12, r13, r13, r14, r14, r15, r15});
        r11.setBackground(r4);
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r3 = r2.getBackground();
        goto L17
    }

    public final void setBgColor(int r3) {
        FrameLayout r0 = getBottomSheet();
        if (r0 != null) goto L5;
        GradientDrawable r1 = null;
    L7:
        if ((r1 instanceof GradientDrawable) == false) goto L9;
        ((GradientDrawable) r1).setColor(r3);
    L10:
        FrameLayout r2 = getBottomSheet();
        if (r2 == null) goto L15;
        r2.setBackground(r1);
    L15:
        if (this.adaptNavBarColor == true) goto L17;
        return;
    L17:
        if (this.navBarColor != null) goto L24;
        Window r4 = getWindow();
        if (r4 == null) goto L25;
        r4.setNavigationBarColor(r3);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(r3);
        r1 = r5;
        goto L10
    L5:
        r1 = r0.getBackground();
        goto L7
    }

    public final void setFitsSystemWindow(boolean r2) {
        FrameLayout r1 = (FrameLayout) findViewById(R.id.container);
        if (r1 == null) goto L7;
        r1.setFitsSystemWindows(r2);
        return;
    }
}
