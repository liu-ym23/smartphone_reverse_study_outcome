package com.obric.oui.popover;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.utils.ViewUtil;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: FakeAnchorView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/obric/oui/popover/FakeAnchorView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FakeAnchorView extends FrameLayout {
    public static final Companion Companion = null;
    private static final String TAG = "FakeAnchorView";

    /* JADX INFO: compiled from: FakeAnchorView.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ.\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/popover/FakeAnchorView$Companion;", "", "()V", "TAG", "", "addFakeAnchorView", "Lcom/obric/oui/popover/FakeAnchorView;", "context", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "rootView", "Landroid/view/ViewGroup;", "posX", "posY", "addInvisibleViewAtPosition", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "parent", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final View addInvisibleViewAtPosition(Activity r9, int r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r9, "activity");
            ViewGroup r5 = ViewUtil.INSTANCE.getActivityContentView(r9);
            if (r5 == null) goto L7;
            return addFakeAnchorView(r9, r12, r13, r5, r10, r11);
        L7:
            throw new Exception("rootView is null");
        }

        public final View addInvisibleViewAtPosition(Dialog r9, int r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r9, "dialog");
            ViewGroup r5 = ViewUtil.INSTANCE.getDialogContentView(r9);
            if (r5 == null) goto L7;
            Context r2 = r9.getContext();
            Intrinsics.checkNotNullExpressionValue(r2, "dialog.context");
            return addFakeAnchorView(r2, r12, r13, r5, r10, r11);
        L7:
            throw new Exception("rootView is null");
        }

        public final View addInvisibleViewAtPosition(ViewGroup r9, int r10, int r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r9, "parent");
            Context r2 = r9.getContext();
            Intrinsics.checkNotNullExpressionValue(r2, "parent.context");
            return addFakeAnchorView(r2, r12, r13, r9, r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final FakeAnchorView addFakeAnchorView(Context r4, int r5, int r6, ViewGroup r7, int r8, int r9) {
            FakeAnchorView r3 = new FakeAnchorView(r4, null, 2, 0 == true ? 1 : 0);
            r3.setBackgroundColor(0);
            r3.setAlpha(0.0f);
            r7.addView(r3, new FrameLayout.LayoutParams(r5, r6));
            int[] r0 = new int[2];
            r7.getLocationOnScreen(r0);
            int r10 = r8 - r0[0];
            int r11 = r9 - r0[1];
            r3.setX(r10);
            r3.setY(r11);
            r3.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(r6, 1073741824));
            r3.layout(0, 0, r5, r6);
            L.d(FakeAnchorView.TAG, "w: " + r3.getMeasuredWidth() + ", h: " + r3.getMeasuredHeight());
            return r3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FakeAnchorView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ FakeAnchorView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public FakeAnchorView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
