package com.obric.oui.dialog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogRootView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/obric/oui/dialog/base/DialogRootView;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogRootView extends RadiusLayout {
    public DialogRootView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public DialogRootView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ DialogRootView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public DialogRootView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r7, int r8) {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        int r1 = (int) (((double) OUnitExtensionKt.getScreenHeight(r0)) * 0.9d);
        int r2 = View.MeasureSpec.getSize(r8);
        int r9 = View.MeasureSpec.getMode(r8);
        if (r9 == Integer.MIN_VALUE) goto L7;
        if (r9 == 0) goto L6;
        int r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, r1), 1073741824);
    L9:
        if (View.MeasureSpec.getMode(r7) != Integer.MIN_VALUE) goto L11;
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        r7 = View.MeasureSpec.makeMeasureSpec(OUnitExtensionKt.getScreenWidth(r11), 1073741824);
    L11:
        super.onMeasure(r7, r10);
        return;
    L6:
        r10 = View.MeasureSpec.makeMeasureSpec(r1, Integer.MIN_VALUE);
        goto L9
    L7:
        r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, r1), Integer.MIN_VALUE);
        goto L9
    }
}
