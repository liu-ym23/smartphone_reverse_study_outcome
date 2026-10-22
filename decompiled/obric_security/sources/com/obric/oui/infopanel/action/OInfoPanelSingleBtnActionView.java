package com.obric.oui.infopanel.action;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OInfoPanelSingleBtnActionView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView;", "Landroid/widget/LinearLayout;", "Lcom/obric/oui/infopanel/action/IOInfoPanelActionView;", "context", "Landroid/content/Context;", "style", "Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;Landroid/util/AttributeSet;)V", "showingBtn", "Lcom/obric/oui/button/OButton;", "getView", "Landroid/view/View;", "setBtnOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setBtnText", "text", "", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInfoPanelSingleBtnActionView extends LinearLayout implements IOInfoPanelActionView {
    private final OButton showingBtn;

    /* JADX INFO: compiled from: OInfoPanelSingleBtnActionView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/infopanel/action/OInfoPanelSingleBtnActionView$Style;", "", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style PRIMARY = null;
        public static final Style SECONDARY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{PRIMARY, SECONDARY};
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
            PRIMARY = new Style("PRIMARY", 0);
            SECONDARY = new Style("SECONDARY", 1);
            $VALUES = $values();
        }
    }

    public OInfoPanelSingleBtnActionView(Context r8, Style r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "style");
        this(r8, r9, null, 4, null);
    }

    public /* synthetic */ OInfoPanelSingleBtnActionView(Context r1, Style r2, AttributeSet r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public OInfoPanelSingleBtnActionView(Context r2, Style r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "style");
        super(r2, r4);
        LinearLayout.inflate(r2, R.layout.o_info_panel_action_single_btn, this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        OInfoPanelSingleBtnActionView r5 = this;
        int r6 = OUnitExtensionKt.vdp(r5, 16);
        int r7 = OUnitExtensionKt.vdp(r5, 12);
        setPadding(r6, r7, r6, r7);
        if (r3 != Style.PRIMARY) goto L5;
        View r8 = findViewById(R.id.btn_primary);
        Intrinsics.checkNotNullExpressionValue(r8, "{\n            findViewBy…id.btn_primary)\n        }");
        OButton r9 = (OButton) r8;
    L6:
        this.showingBtn = r9;
        ViewExtensionsKt.makeVisible(r9);
        return;
    L5:
        View r10 = findViewById(R.id.btn_secondary);
        Intrinsics.checkNotNullExpressionValue(r10, "{\n            findViewBy….btn_secondary)\n        }");
        r9 = (OButton) r10;
        goto L6
    }

    public final void setBtnText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.showingBtn.setText(r2);
    }

    public final void setBtnOnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.showingBtn.setOnClickListener(r2);
    }

    @Override // com.obric.oui.infopanel.action.IOInfoPanelActionView
    public View getView() {
        return this;
    }
}
