package com.obric.oui.panel.header;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.panel.BottomSheetBehavior;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultHeaderAnimHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/panel/header/ExpandableDefaultHeaderCallback;", "Lcom/obric/oui/panel/BottomSheetBehavior$BottomSheetCallback;", "header", "Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "animateTitle", "", "(Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;Z)V", "getAnimateTitle", "()Z", "getHeader", "()Lcom/obric/oui/panel/header/BasicPanelDefaultHeader;", "lastSlideOffset", "", "mainHeight", "", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "onStateChanged", "newState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpandableDefaultHeaderCallback extends BottomSheetBehavior.BottomSheetCallback {
    private final boolean animateTitle;
    private final BasicPanelDefaultHeader header;
    private float lastSlideOffset;
    private final int mainHeight;

    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public void onStateChanged(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public /* synthetic */ ExpandableDefaultHeaderCallback(BasicPanelDefaultHeader r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public final boolean getAnimateTitle() {
        return this.animateTitle;
    }

    public final BasicPanelDefaultHeader getHeader() {
        return this.header;
    }

    public ExpandableDefaultHeaderCallback(BasicPanelDefaultHeader r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "header");
        this.header = r3;
        this.animateTitle = r4;
        this.lastSlideOffset = -1.0f;
        this.mainHeight = r3.getThemedContext().getResources().getDimensionPixelSize(R.dimen.oui_panel_default_header_height_when_grabber);
        r3.showGrabberView$OUI_standardRelease();
        if (r4 == false) goto L5;
        ViewExtensionsKt.makeGone(r3.getMainContentView());
        return;
    L5:
        ViewExtensionsKt.makeVisible(r3.getMainContentView());
        ViewExtensionsKt.makeGone(r3.getCloseView());
    }

    @Override // com.obric.oui.panel.BottomSheetBehavior.BottomSheetCallback
    public void onSlide(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        if (this.lastSlideOffset >= 0.0f) goto L5;
    L19:
        this.lastSlideOffset = r11;
        return;
    L5:
        if (this.animateTitle == false) goto L17;
        double r2 = r11;
        if (r2 > 0.5d) goto L9;
    L16:
        float r3 = 1.0f - r11;
        this.header.getMainContentView().setAlpha(1.0f - (r3 / 0.5f));
        this.header.getMainContentView().setTranslationY((this.header.getMainContentView().getHeight() * r3) / 0.5f);
    L18:
        this.header.getCloseView().setAlpha(1.0f - ((1.0f - r11) / 0.5f));
        goto L19
    L9:
        if (ViewExtensionsKt.isGone(this.header.getMainContentView()) == false) goto L11;
        ViewExtensionsKt.makeVisible(this.header.getMainContentView());
    L11:
        View r12 = this.header.getMainContentView();
        ViewGroup.LayoutParams r6 = r12.getLayoutParams();
        if (r6 == null) goto L15;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        ConstraintLayout.LayoutParams r8 = r7;
        r8.constrainedHeight = true;
        r8.height = (int) (((r2 - 0.5d) / ((double) 0.5f)) * ((double) this.mainHeight));
        r12.setLayoutParams(r7);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L17:
        ViewExtensionsKt.makeVisible(this.header.getCloseView());
        goto L18
    }
}
