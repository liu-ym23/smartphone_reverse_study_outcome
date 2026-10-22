package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSelectionPanelBtnView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. ")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnNegative", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnPositive", "getBtnPositive", "horizontal_space", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelBtnView extends ConstraintLayout {
    private final OButton btnNegative;
    private final OButton btnPositive;
    private final View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    public OSelectionPanelBtnView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSelectionPanelBtnView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OSelectionPanelBtnView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        ConstraintLayout.inflate(r2, R.layout.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r4 = findViewById(R.id.btn_negative);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.btn_negative)");
        this.btnNegative = (OButton) r4;
        View r5 = findViewById(R.id.btn_positive);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.btn_positive)");
        this.btnPositive = (OButton) r5;
        View r6 = findViewById(R.id.horizontal_space);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.horizontal_space)");
        this.horizontal_space = r6;
    }

    public final OButton getBtnNegative() {
        return this.btnNegative;
    }

    public final OButton getBtnPositive() {
        return this.btnPositive;
    }

    public final View getHorizontal_space() {
        return this.horizontal_space;
    }
}
