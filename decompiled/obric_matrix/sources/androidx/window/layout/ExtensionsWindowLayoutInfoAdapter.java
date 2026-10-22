package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import androidx.window.core.Bounds;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001d\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/ExtensionsWindowLayoutInfoAdapter;", "", "()V", "translate", "Landroidx/window/layout/FoldingFeature;", "activity", "Landroid/app/Activity;", "oemFeature", "Landroidx/window/extensions/layout/FoldingFeature;", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", LocationMonitorConst.INFO, "Landroidx/window/extensions/layout/WindowLayoutInfo;", "validBounds", "", "bounds", "Landroidx/window/core/Bounds;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionsWindowLayoutInfoAdapter {
    public static final ExtensionsWindowLayoutInfoAdapter INSTANCE = null;

    static {
        INSTANCE = new ExtensionsWindowLayoutInfoAdapter();
    }

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    private final boolean validBounds(Activity r3, Bounds r4) {
        Rect r2 = WindowMetricsCalculatorCompat.INSTANCE.computeCurrentWindowMetrics(r3).getBounds();
        if (r4.isZero() == false) goto L6;
        return false;
    L6:
        if (r4.getWidth() == r2.width()) goto L11;
        if (r4.getHeight() == r2.height()) goto L11;
        return false;
    L11:
        if (r4.getWidth() >= r2.width()) goto L16;
        if (r4.getHeight() >= r2.height()) goto L16;
        return false;
    L16:
        if (r4.getWidth() == r2.width()) goto L18;
        return true;
    L18:
        if (r4.getHeight() != r2.height()) goto L22;
        return false;
    L22:
        return true;
    }

    public final FoldingFeature translate$window_release(Activity r7, androidx.window.extensions.layout.FoldingFeature r8) {
        o.f(r7, "activity");
        o.f(r8, "oemFeature");
        int r0 = r8.getType();
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L6;
        return null;
    L6:
        HardwareFoldingFeature.Type r1 = HardwareFoldingFeature.Type.Companion.getHINGE();
    L8:
        int r4 = r8.getState();
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L12;
        return null;
    L12:
        FoldingFeature.State r2 = FoldingFeature.State.HALF_OPENED;
    L14:
        Rect r5 = r8.getBounds();
        o.e(r5, "oemFeature.bounds");
        if (validBounds(r7, new Bounds(r5)) == false) goto L18;
        Rect r9 = r8.getBounds();
        o.e(r9, "oemFeature.bounds");
        return new HardwareFoldingFeature(new Bounds(r9), r1, r2);
    L18:
        return null;
    L13:
        r2 = FoldingFeature.State.FLAT;
        goto L14
    L7:
        r1 = HardwareFoldingFeature.Type.Companion.getFOLD();
        goto L8
    }

    public final WindowLayoutInfo translate$window_release(Activity r4, androidx.window.extensions.layout.WindowLayoutInfo r5) {
        o.f(r4, "activity");
        o.f(r5, LocationMonitorConst.INFO);
        List r3 = r5.getDisplayFeatures();
        o.e(r3, "info.displayFeatures");
        ArrayList r6 = new ArrayList();
        Iterator r7 = r3.iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        androidx.window.extensions.layout.FoldingFeature r0 = (androidx.window.extensions.layout.DisplayFeature) r7.next();
        if ((r0 instanceof androidx.window.extensions.layout.FoldingFeature) == false) goto L8;
        ExtensionsWindowLayoutInfoAdapter r1 = INSTANCE;
        o.e(r0, "feature");
        FoldingFeature r2 = r1.translate$window_release(r4, r0);
    L9:
        if (r2 == null) goto L4;
        r6.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L13:
        return new WindowLayoutInfo(r6);
    }
}
