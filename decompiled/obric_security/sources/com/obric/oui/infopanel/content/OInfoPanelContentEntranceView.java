package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInfoPanelContentEntranceView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "entranceContainer", "Landroid/view/ViewGroup;", "ivJump", "Landroid/widget/ImageView;", "tvEntrance", "Landroid/widget/TextView;", "onAttachedToWindow", "", "onClick", "listener", "Landroid/view/View$OnClickListener;", "setEntranceText", "text", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentEntranceView extends ConstraintLayout {
    private final ViewGroup entranceContainer;
    private final ImageView ivJump;
    private final TextView tvEntrance;

    public static /* synthetic */ void $r8$lambda$s9JNiBKgUHBCRYrwYKA70RgyFxk(OInfoPanelContentEntranceView r0) {
        m377onAttachedToWindow$lambda1(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentEntranceView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OInfoPanelContentEntranceView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OInfoPanelContentEntranceView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        ConstraintLayout.inflate(r3, R.layout.o_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r5 = new ViewGroup.MarginLayoutParams(-1, -2);
        OInfoPanelContentEntranceView r6 = this;
        r5.setMargins(0, OUnitExtensionKt.vdp(r6, 8), 0, OUnitExtensionKt.vdp(r6, 12));
        setLayoutParams(r5);
        View r7 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.tv_title)");
        this.tvEntrance = (TextView) r7;
        View r8 = findViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.iv_arrow)");
        this.ivJump = (ImageView) r8;
        View r9 = findViewById(R.id.entrance_container);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.entrance_container)");
        this.entranceContainer = (ViewGroup) r9;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new OInfoPanelContentEntranceView$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: onAttachedToWindow$lambda-1, reason: not valid java name */
    private static final void m377onAttachedToWindow$lambda1(OInfoPanelContentEntranceView r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        OInfoPanelContentEntranceView r0 = r5;
        ViewExtensionsKt.expandTouchArea(r0, r5.entranceContainer.getWidth(), OUnitExtensionKt.vdp(r0, 44), true);
        ViewGroup r6 = r5.entranceContainer;
        ViewExtensionsKt.expandTouchArea(r6, r6.getWidth(), OUnitExtensionKt.vdp(r0, 44), true);
    }

    public final void onClick(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.entranceContainer.setOnClickListener(r2);
    }

    public final void setEntranceText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.tvEntrance.setText(r2);
    }
}
