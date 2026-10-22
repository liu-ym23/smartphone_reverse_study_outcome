package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPanelTitleBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J0\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010)\u001a\u00020\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "info", "", "showExpandIcon", "", "showInfo", "showInfoIcon", "title", "type", "vActionContainer", "Landroid/widget/FrameLayout;", "vActionView", "Landroid/view/View;", "vExpandIcon", "Landroid/widget/ImageView;", "vInfoIcon", "vInfoText", "Lcom/obric/oui/text/OTextView;", "vTitleText", "inflate", "", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setActionView", "view", "setInfo", "setTitle", "setType", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPanelTitleBar extends ConstraintLayout {
    public static final Companion Companion = null;
    public static final int DISPLAY = 0;
    public static final int REGULAR = 1;
    private String info;
    private boolean showExpandIcon;
    private boolean showInfo;
    private boolean showInfoIcon;
    private String title;
    private int type;
    private FrameLayout vActionContainer;
    private View vActionView;
    private ImageView vExpandIcon;
    private ImageView vInfoIcon;
    private OTextView vInfoText;
    private OTextView vTitleText;

    /* JADX INFO: compiled from: OPanelTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar$Companion;", "", "()V", "DISPLAY", "", "REGULAR", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OPanelTitleBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPanelTitleBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPanelTitleBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OPanelTitleBar(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        boolean r0 = true;
        this.type = 1;
        TypedArray r7 = r4.getTheme().obtainStyledAttributes(r5, R.styleable.OPanelTitleBar, r6, 0);
        this.type = r7.getInt(R.styleable.OPanelTitleBar_oui_panel_type, 1);
        this.showInfo = r7.getBoolean(R.styleable.OPanelTitleBar_oui_panel_show_info, true);
        this.showInfoIcon = r7.getBoolean(R.styleable.OPanelTitleBar_oui_panel_show_info_icon, false);
        this.showExpandIcon = r7.getBoolean(R.styleable.OPanelTitleBar_oui_panel_show_expand_icon, false);
        this.title = r7.getString(R.styleable.OPanelTitleBar_oui_panel_title);
        this.info = r7.getString(R.styleable.OPanelTitleBar_oui_panel_info);
        r7.recycle();
        inflate(this.type);
        setTitle(this.title);
        setInfo(this.info);
        if (this.showInfo == false) goto L13;
        String r8 = this.info;
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == true) goto L13;
    L14:
        showInfo(r0);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        return;
    L7:
        if (r8.length() == 0) goto L10;
        r9 = false;
    L13:
        r0 = false;
        goto L14
    }

    public final void setType(int r2) {
        if (r2 == 0) goto L6;
        if (r2 == 1) goto L6;
        return;
    L6:
        if (r2 == this.type) goto L13;
        this.type = r2;
        inflate(r2);
        setTitle(this.title);
        setInfo(this.info);
        showInfo(this.showInfo);
        showExpandIcon(this.showExpandIcon);
        showInfoIcon(this.showInfoIcon);
        View r3 = this.vActionView;
        if (r3 == null) goto L14;
        setActionView(r3);
        return;
    L14:
        return;
    }

    public final void setTitle(String r1) {
        this.title = r1;
        OTextView r0 = this.vTitleText;
        if (r0 == null) goto L7;
        r0.setText(r1);
        return;
    }

    public final void setInfo(String r1) {
        this.info = r1;
        OTextView r0 = this.vInfoText;
        if (r0 == null) goto L7;
        r0.setText(r1);
        return;
    }

    public final void showInfoIcon(boolean r1) {
        this.showInfoIcon = r1;
        ImageView r0 = this.vInfoIcon;
        if (r0 == null) goto L7;
        ViewExtensionsKt.setVisibility(r0, r1);
        return;
    }

    public final void showInfo(boolean r1) {
        this.showInfo = r1;
        OTextView r0 = this.vInfoText;
        if (r0 == null) goto L7;
        ViewExtensionsKt.setVisibility(r0, r1);
        return;
    }

    public final void showExpandIcon(boolean r1) {
        this.showExpandIcon = r1;
        ImageView r0 = this.vExpandIcon;
        if (r0 == null) goto L7;
        ViewExtensionsKt.setVisibility(r0, r1);
        return;
    }

    public final void setActionView(View r3) {
        this.vActionView = r3;
        FrameLayout r0 = this.vActionContainer;
        if (r0 == null) goto L6;
        r0.removeAllViews();
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        FrameLayout r2 = this.vActionContainer;
        if (r2 == null) goto L13;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 21;
        Unit r4 = Unit.INSTANCE;
        r2.addView(r3, r1);
        return;
    }

    private final void inflate(int r6) {
        if (r6 == 0) goto L7;
        if (r6 == 1) goto L6;
        OPanelTitleBar r7 = this;
        setPadding(OUnitExtensionKt.vdp(r7, 12), OUnitExtensionKt.vdp(r7, 12), OUnitExtensionKt.vdp(r7, 12), OUnitExtensionKt.vdp(r7, 12));
        int r8 = R.layout.o_panel_title_bar_regular;
    L8:
        removeAllViews();
        View r9 = LayoutInflater.from(getContext()).inflate(r8, this, true);
        this.vTitleText = (OTextView) r9.findViewById(R.id.panel_title);
        this.vInfoText = (OTextView) r9.findViewById(R.id.panel_info);
        this.vExpandIcon = (ImageView) r9.findViewById(R.id.panel_expand_icon);
        this.vInfoIcon = (ImageView) r9.findViewById(R.id.panel_info_icon);
        this.vActionContainer = (FrameLayout) r9.findViewById(R.id.panel_action_container);
        return;
    L6:
        OPanelTitleBar r10 = this;
        setPadding(OUnitExtensionKt.vdp(r10, 12), OUnitExtensionKt.vdp(r10, 12), OUnitExtensionKt.vdp(r10, 12), OUnitExtensionKt.vdp(r10, 12));
        r8 = R.layout.o_panel_title_bar_regular;
        goto L8
    L7:
        OPanelTitleBar r11 = this;
        setPadding(OUnitExtensionKt.vdp(r11, 12), OUnitExtensionKt.vdp(r11, 14), OUnitExtensionKt.vdp(r11, 12), OUnitExtensionKt.vdp(r11, 8));
        r8 = R.layout.o_panel_title_bar_display;
        goto L8
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
