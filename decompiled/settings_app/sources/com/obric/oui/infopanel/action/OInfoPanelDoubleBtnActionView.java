package com.obric.oui.infopanel.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInfoPanelDoubleBtnActionView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0016B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "context", "Landroid/content/Context;", "style", "Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;Landroid/util/AttributeSet;)V", "leftBtn", "Lcom/obric/oui/button/OButton;", "rightBtn", "configLeftBtn", "", "text", "", "listener", "Landroid/view/View$OnClickListener;", "configRightBtn", "getView", "Landroid/view/View;", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelDoubleBtnActionView extends LinearLayout implements IOInfoPanelActionView {
    private final OButton leftBtn;
    private final OButton rightBtn;

    /* JADX INFO: compiled from: OInfoPanelDoubleBtnActionView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelDoubleBtnActionView$Style;", "", "(Ljava/lang/String;I)V", "PRIMARY_SECONDARY", "ONLY_SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style ONLY_SECONDARY = null;
        public static final Style PRIMARY_SECONDARY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{PRIMARY_SECONDARY, ONLY_SECONDARY};
        }

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PRIMARY_SECONDARY = new Style("PRIMARY_SECONDARY", 0);
            ONLY_SECONDARY = new Style("ONLY_SECONDARY", 1);
            $VALUES = $values();
        }
    }

    public OInfoPanelDoubleBtnActionView(Context r8, Style r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "style");
        this(r8, r9, null, 4, null);
    }

    public /* synthetic */ OInfoPanelDoubleBtnActionView(Context r1, Style r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public OInfoPanelDoubleBtnActionView(Context r2, Style r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "style");
        super(r2, r4);
        if (r3 != Style.PRIMARY_SECONDARY) goto L5;
        int r5 = R.layout.o_info_panel_action_double_btn_primary_or_secondary;
    L6:
        LinearLayout.inflate(r2, r5, this);
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OInfoPanelDoubleBtnActionView r6 = this;
        int r7 = OUnitExtensionKt.vdp(r6, 16);
        int r8 = OUnitExtensionKt.vdp(r6, 12);
        setPadding(r7, r8, r7, r8);
        View r9 = findViewById(R.id.btn_secondary);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.btn_secondary)");
        this.leftBtn = (OButton) r9;
        View r10 = findViewById(R.id.btn_primary);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.btn_primary)");
        this.rightBtn = (OButton) r10;
        return;
    L5:
        r5 = R.layout.o_info_panel_action_double_btn;
        goto L6
    }

    public final void configLeftBtn(CharSequence r2, View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.leftBtn.setText(r2);
        this.leftBtn.setOnClickListener(r3);
    }

    public final void configRightBtn(CharSequence r2, View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.rightBtn.setText(r2);
        this.rightBtn.setOnClickListener(r3);
    }

    @Override // com.obric.oui.infopanel.action.IOInfoPanelActionView
    public View getView() {
        return this;
    }
}
