package com.obric.oui.common.debug;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.oui.common.util.OUILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DebugFrameLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0014¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugFrameLayout extends FrameLayout {
    public static final Companion Companion = null;
    public static final String TAG = "DebugFrameLayout";

    /* JADX INFO: compiled from: DebugFrameLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/common/debug/DebugFrameLayout$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DebugFrameLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ DebugFrameLayout(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public DebugFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        int r0 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        int r1 = View.MeasureSpec.getMode(r11);
        int r13 = View.MeasureSpec.getSize(r11);
        int r2 = getMeasuredWidth();
        int r9 = getMeasuredHeight();
        String r3 = NetworkStackConstant.UNKNOWN_TYPE;
        if (r0 == Integer.MIN_VALUE) goto L9;
        if (r0 == 0) goto L8;
        if (r0 == 1073741824) goto L7;
        String r4 = NetworkStackConstant.UNKNOWN_TYPE;
    L10:
        if (r1 == Integer.MIN_VALUE) goto L16;
        if (r1 == 0) goto L15;
        if (r1 != 1073741824) goto L17;
        r3 = "EXACTLY";
    L17:
        OUILogger.INSTANCE.d("DebugFrameLayout onMeasure", "Width mode: " + r4 + ", width size: " + r12 + ", measured width: " + r2);
        OUILogger.INSTANCE.d("DebugFrameLayout onMeasure", "Height mode: " + r3 + ", height size: " + r13 + ", measured height: " + r9);
        return;
    L15:
        r3 = "UNSPECIFIED";
        goto L17
    L16:
        r3 = "AT_MOST";
        goto L17
    L7:
        r4 = "EXACTLY";
        goto L10
    L8:
        r4 = "UNSPECIFIED";
        goto L10
    L9:
        r4 = "AT_MOST";
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r3 = r7 - r5;
        OUILogger.INSTANCE.d("DebugFrameLayout onLayout", "Layout left: " + r5 + ", top: " + r6 + ", right: " + r7 + ", bottom: " + r8);
        OUILogger.INSTANCE.d("DebugFrameLayout onLayout", new StringBuilder("Layout width: ").append(r3).append(", height: ").append(r8 - r6).toString());
    }
}
