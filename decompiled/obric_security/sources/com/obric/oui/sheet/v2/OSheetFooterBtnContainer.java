package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.ViewUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSheetFooterBtnContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018JG\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010#JB\u0010\u0019\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010&\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnNegative", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "setBtnNegative", "(Lcom/obric/oui/button/OButton;)V", "btnPositive", "getBtnPositive", "setBtnPositive", "horizontal_space", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "setHorizontal_space", "(Landroid/view/View;)V", "createButton", "isPrimary", "", "setButtons", "", "negativeBtnTextResId", "", "negativeIsPrimary", "negativeActionEvent", "Landroid/view/View$OnClickListener;", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "negativeBtnText", "", "positiveBtnText", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetFooterBtnContainer extends LinearLayout {
    private OButton btnNegative;
    private OButton btnPositive;
    private View horizontal_space;

    /* JADX WARN: Multi-variable type inference failed */
    public OSheetFooterBtnContainer(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OSheetFooterBtnContainer(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OSheetFooterBtnContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r4 = getResources().getDimensionPixelSize(R.dimen.oui_p_container_large_1);
        int r5 = OUnitExtensionKt.vdp(this, 8);
        setPadding(r4, r5, r4, r5);
    }

    public final OButton getBtnNegative() {
        return this.btnNegative;
    }

    public final void setBtnNegative(OButton r1) {
        this.btnNegative = r1;
    }

    public final OButton getBtnPositive() {
        return this.btnPositive;
    }

    public final void setBtnPositive(OButton r1) {
        this.btnPositive = r1;
    }

    public final View getHorizontal_space() {
        return this.horizontal_space;
    }

    public final void setHorizontal_space(View r1) {
        this.horizontal_space = r1;
    }

    public static /* synthetic */ void setButtons$default(OSheetFooterBtnContainer r7, Integer r8, boolean r9, View.OnClickListener r10, Integer r11, boolean r12, View.OnClickListener r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = false;
    L5:
        boolean r2 = r9;
        if ((r14 & 16) == 0) goto L8;
        r12 = true;
    L8:
        r7.setButtons(r8, r2, r10, r11, r12, r13);
    }

    public final void setButtons(Integer r9, boolean r10, View.OnClickListener r11, Integer r12, boolean r13, View.OnClickListener r14) {
        String r0 = null;
        if (r9 == null) goto L5;
        String r2 = getResources().getString(r9.intValue());
    L6:
        if (r12 == null) goto L8;
        r0 = getResources().getString(r12.intValue());
    L8:
        setButtons(r2, r10, r11, r0, r13, r14);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static /* synthetic */ void setButtons$default(OSheetFooterBtnContainer r7, String r8, boolean r9, View.OnClickListener r10, String r11, boolean r12, View.OnClickListener r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = false;
    L5:
        boolean r2 = r9;
        if ((r14 & 16) == 0) goto L8;
        r12 = true;
    L8:
        r7.setButtons(r8, r2, r10, r11, r12, r13);
    }

    public final void setButtons(String r3, boolean r4, View.OnClickListener r5, String r6, boolean r7, View.OnClickListener r8) {
        if (r3 != null) goto L5;
        char r9 = 0;
    L18:
        if (r9 <= 0) goto L27;
        View r10 = new View(getContext());
        this.horizontal_space = r10;
        addView(r10);
        View r11 = this.horizontal_space;
        if (r11 == null) goto L23;
        ViewUtilKt.setWidth(r11, OUnitExtensionKt.vdp(this, 12));
    L23:
        View r12 = this.horizontal_space;
        if (r12 == null) goto L27;
        ViewUtilKt.setHeight(r12, OUnitExtensionKt.vdp(this, 1));
    L27:
        if (r6 == null) goto L42;
        setBtnPositive(createButton(r7));
        OButton r13 = getBtnPositive();
        if (r13 == null) goto L33;
        r13.setId(R.id.btn_positive);
    L33:
        OButton r14 = getBtnPositive();
        if (r14 == null) goto L37;
        r14.setOnClickListener(r8);
    L37:
        OButton r2 = getBtnPositive();
        if (r2 == null) goto L43;
        r2.setText(r6);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        setBtnNegative(createButton(r4));
        OButton r15 = getBtnNegative();
        if (r15 == null) goto L9;
        r15.setId(R.id.btn_negative);
    L9:
        OButton r16 = getBtnNegative();
        if (r16 == null) goto L13;
        r16.setOnClickListener(r5);
    L13:
        OButton r17 = getBtnNegative();
        if (r17 == null) goto L17;
        r17.setText(r3);
    L17:
        r9 = 1;
        goto L18
    }

    public final OButton createButton(boolean r2) {
        Context r0 = getContext();
        if (r2 == false) goto L5;
        int r3 = R.layout.oui_widget_panel_primary_btn;
    L6:
        View r1 = LinearLayout.inflate(r0, r3, this);
        if (r1 == null) goto L15;
        ViewGroup r4 = (ViewGroup) r1;
        View r5 = r4.getChildAt(r4.getChildCount() - 1);
        if (r5 == null) goto L13;
        return (OButton) r5;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r3 = R.layout.oui_widget_panel_netural_btn;
        goto L6
    }
}
