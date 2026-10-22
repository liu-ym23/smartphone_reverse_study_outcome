package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.securityserver.R;
import com.obric.oui.button.OButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public final class OSelectionPanelBtnView extends ConstraintLayout {
    public final OButton b;
    public final OButton c;
    public final View e;

    public OSelectionPanelBtnView(Context r2, AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3);
        View.inflate(r2, R.layout.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r4 = findViewById(R.id.btn_negative);
        Intrinsics.e(r4, "findViewById(R.id.btn_negative)");
        this.b = (OButton) r4;
        View r5 = findViewById(R.id.btn_positive);
        Intrinsics.e(r5, "findViewById(R.id.btn_positive)");
        this.c = (OButton) r5;
        View r6 = findViewById(R.id.horizontal_space);
        Intrinsics.e(r6, "findViewById(R.id.horizontal_space)");
        this.e = r6;
    }

    @NotNull
    public final OButton getBtnNegative() {
        return this.b;
    }

    @NotNull
    public final OButton getBtnPositive() {
        return this.c;
    }

    @NotNull
    public final View getHorizontal_space() {
        return this.e;
    }
}
