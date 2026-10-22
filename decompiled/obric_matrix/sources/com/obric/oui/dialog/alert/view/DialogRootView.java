package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.obric.oui.common.util.f;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogRootView;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/f0;", "onMeasure", "(II)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class DialogRootView extends RadiusLayout {
    public DialogRootView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public DialogRootView(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ DialogRootView(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r7, int r8) {
        Context r0 = getContext();
        o.e(r0, "context");
        int r1 = (int) (((double) f.b(r0)) * 0.9d);
        int r2 = View.MeasureSpec.getSize(r8);
        int r9 = View.MeasureSpec.getMode(r8);
        if (r9 == Integer.MIN_VALUE) goto L7;
        if (r9 == 0) goto L6;
        int r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r2, r1), BasicMeasure.EXACTLY);
    L9:
        if (View.MeasureSpec.getMode(r7) != Integer.MIN_VALUE) goto L11;
        Context r11 = getContext();
        o.e(r11, "context");
        r7 = View.MeasureSpec.makeMeasureSpec(f.c(r11), BasicMeasure.EXACTLY);
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
