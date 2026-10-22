package com.obric.oui.infopanel.content;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInfoPanelContentSwitchView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/infopanel/content/OInfoPanelContentSwitchView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "oSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "getOSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelContentSwitchView extends ConstraintLayout {
    private final OSwitch oSwitch;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public OInfoPanelContentSwitchView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OInfoPanelContentSwitchView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OInfoPanelContentSwitchView(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        ConstraintLayout.inflate(r5, R.layout.o_info_panel_content_switch_view, this);
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-1, -2);
        OInfoPanelContentSwitchView r8 = this;
        r7.setMargins(0, OUnitExtensionKt.vdp(r8, 16), 0, OUnitExtensionKt.vdp(r8, 12));
        setLayoutParams(r7);
        setBackgroundResource(R.drawable.o_info_panel_content_switch_view_bg);
        int r9 = OUnitExtensionKt.vdp(r8, 16);
        setPadding(r9, r9, r9, r9);
        View r10 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r10;
        View r11 = findViewById(R.id.o_switch);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.o_switch)");
        OSwitch r12 = (OSwitch) r11;
        this.oSwitch = r12;
        ViewExtensionsKt.expandTouchArea(r12, OUnitExtensionKt.vdp(r8, 44));
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final OSwitch getOSwitch() {
        return this.oSwitch;
    }
}
