package com.android.settings.wifi.scanner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.obric.olog.OLog;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: AutoFitSurfaceView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0007J\b\u0010\u001e\u001a\u00020\u0017H\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/settings/wifi/scanner/AutoFitSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aspectRatio", "", "expectHeight", "getExpectHeight", "()I", "setExpectHeight", "(I)V", "expectWidth", "getExpectWidth", "setExpectWidth", "topMargin", "getScreenSize", "Landroid/util/Size;", "setAspectRatio", "", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "tMargin", "reverse", "", "setExpectSize", "updateLayout", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AutoFitSurfaceView extends SurfaceView {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private float aspectRatio;
    private int expectHeight;
    private int expectWidth;
    private float topMargin;

    /* JADX INFO: compiled from: AutoFitSurfaceView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/settings/wifi/scanner/AutoFitSurfaceView$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public AutoFitSurfaceView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public AutoFitSurfaceView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ AutoFitSurfaceView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AutoFitSurfaceView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public final int getExpectWidth() {
        return this.expectWidth;
    }

    public final void setExpectWidth(int r1) {
        this.expectWidth = r1;
    }

    public final int getExpectHeight() {
        return this.expectHeight;
    }

    public final void setExpectHeight(int r1) {
        this.expectHeight = r1;
    }

    public final void setExpectSize(int r1, int r2) {
        this.expectWidth = r1;
        this.expectHeight = r2;
    }

    public final void setAspectRatio(int r3, int r4, float r5, boolean r6) {
        if (r3 <= 0) goto L10;
        if (r4 <= 0) goto L11;
        this.aspectRatio = r3 / r4;
        this.topMargin = r5;
        if (r6 == false) goto L7;
        getHolder().setFixedSize(r4, r3);
        setExpectSize(r4, r3);
    L8:
        updateLayout();
        return;
    L7:
        getHolder().setFixedSize(r3, r4);
        setExpectSize(r3, r4);
        goto L8
    L11:
        return;
    }

    private final void updateLayout() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1.topMargin == ((int) this.topMargin)) goto L5;
        OLog.d(TAG, "Update top margin, " + r1.topMargin + " to " + this.topMargin);
        r1.topMargin = (int) TypedValue.applyDimension(1, this.topMargin, getResources().getDisplayMetrics());
    L5:
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        int r3 = getScreenSize(r2).getWidth();
        int r4 = MathKt.roundToInt(r3 * this.aspectRatio);
        r1.width = r3;
        r1.height = r4;
        setLayoutParams(r1);
    }

    public final Size getScreenSize(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r1 = r2.getSystemService("window");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.WindowManager");
        WindowMetrics r3 = ((WindowManager) r1).getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(r3, "getCurrentWindowMetrics(...)");
        return new Size(r3.getBounds().width(), r3.getBounds().height());
    }

    static {
        Companion = new Companion(null);
        TAG = "AutoFitSurfaceView";
    }
}
