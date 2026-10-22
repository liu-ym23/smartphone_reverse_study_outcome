package androidx.window.layout;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.Bounds;
import androidx.window.core.SpecificationComputer;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\f\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0010\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\bJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarAdapter;", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "(Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "isEqualSidecarDeviceState", "", "first", "Landroidx/window/sidecar/SidecarDeviceState;", "second", "isEqualSidecarDisplayFeature", "Landroidx/window/sidecar/SidecarDisplayFeature;", "isEqualSidecarDisplayFeatures", "", "isEqualSidecarWindowLayoutInfo", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "translate", "Landroidx/window/layout/DisplayFeature;", "feature", "deviceState", "translate$window_release", "Landroidx/window/layout/WindowLayoutInfo;", "extensionInfo", WsConstants.KEY_CONNECTION_STATE, "sidecarDisplayFeatures", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarAdapter {
    public static final Companion Companion = null;
    private static final String TAG = null;
    private final SpecificationComputer.VerificationMode verificationMode;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0007J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getRawSidecarDevicePosture", "", "sidecarDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "getSidecarDevicePosture", "getSidecarDevicePosture$window_release", "getSidecarDisplayFeatures", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", LocationMonitorConst.INFO, "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "setSidecarDevicePosture", "", "posture", "setSidecarDisplayFeatures", "displayFeatures", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final int getRawSidecarDevicePosture(SidecarDeviceState r4) {
            o.f(r4, "sidecarDeviceState");
            return r4.posture;
        L15:
            Object r5 = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L12
            if (r5 == null) goto L11;
            return ((Integer) r5).intValue();
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L12
        L12:
            return 0;
        }

        public final int getSidecarDevicePosture$window_release(SidecarDeviceState r2) {
            o.f(r2, "sidecarDeviceState");
            int r1 = getRawSidecarDevicePosture(r2);
            if (r1 >= 0) goto L5;
        L6:
            return 0;
        L5:
            if (r1 > 4) goto L6;
            return r1;
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final List<SidecarDisplayFeature> getSidecarDisplayFeatures(SidecarWindowLayoutInfo r4) {
            o.f(r4, LocationMonitorConst.INFO);
            List<SidecarDisplayFeature> r3 = r4.displayFeatures;     // Catch: NoSuchFieldError -> L7
            if (r3 != null) goto L17;
            return r.g();
        L17:
            return r3;
        L7:
            Object r5 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L13
            if (r5 == null) goto L12;
            return (List) r5;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L13
        L14:
            return r.g();
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final void setSidecarDevicePosture(SidecarDeviceState r6, int r7) {
            o.f(r6, "sidecarDeviceState");
            r6.posture = r7;     // Catch: NoSuchFieldError -> L5
            return;
        L5:
            SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L7
            return;
        }

        @SuppressLint({"BanUncheckedReflection"})
        @VisibleForTesting
        public final void setSidecarDisplayFeatures(SidecarWindowLayoutInfo r6, List<SidecarDisplayFeature> r7) {
            o.f(r6, LocationMonitorConst.INFO);
            o.f(r7, "displayFeatures");
            r6.displayFeatures = r7;     // Catch: NoSuchFieldError -> L5
            return;
        L5:
            SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(r6, new Object[]{r7});     // Catch: Throwable -> L7
            return;
        }
    }

    static {
        Companion = new Companion(null);
        TAG = SidecarAdapter.class.getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SidecarAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SidecarAdapter(SpecificationComputer.VerificationMode r2) {
        o.f(r2, "verificationMode");
        this.verificationMode = r2;
    }

    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode r1, int r2, g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = SpecificationComputer.VerificationMode.QUIET;
    L5:
        this(r1);
    }

    private final boolean isEqualSidecarDisplayFeature(SidecarDisplayFeature r3, SidecarDisplayFeature r4) {
        if (o.a(r3, r4) == false) goto L7;
        return true;
    L7:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r3.getType() == r4.getType()) goto L15;
        return false;
    L15:
        return o.a(r3.getRect(), r4.getRect());
    }

    private final boolean isEqualSidecarDisplayFeatures(List<SidecarDisplayFeature> r7, List<SidecarDisplayFeature> r8) {
        if (r7 != r8) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
        return false;
    L8:
        if (r8 != null) goto L11;
        return false;
    L11:
        if (r7.size() == r8.size()) goto L13;
        return false;
    L13:
        int r2 = r7.size();
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L19;
        int r4 = r3 + 1;
        if (isEqualSidecarDisplayFeature(r7.get(r3), r8.get(r3)) == false) goto L17;
        r3 = r4;
        goto L14
    L17:
        return false;
    L19:
        return true;
    }

    public final boolean isEqualSidecarDeviceState(SidecarDeviceState r3, SidecarDeviceState r4) {
        if (o.a(r3, r4) == false) goto L6;
        return true;
    L6:
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r4 != null) goto L10;
        return false;
    L10:
        Companion r1 = Companion;
        if (r1.getSidecarDevicePosture$window_release(r3) != r1.getSidecarDevicePosture$window_release(r4)) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean isEqualSidecarWindowLayoutInfo(SidecarWindowLayoutInfo r2, SidecarWindowLayoutInfo r3) {
        if (o.a(r2, r3) == false) goto L7;
        return true;
    L7:
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r3 != null) goto L11;
        return false;
    L11:
        Companion r0 = Companion;
        return isEqualSidecarDisplayFeatures(r0.getSidecarDisplayFeatures(r2), r0.getSidecarDisplayFeatures(r3));
    }

    public final WindowLayoutInfo translate(SidecarWindowLayoutInfo r3, SidecarDeviceState r4) {
        o.f(r4, WsConstants.KEY_CONNECTION_STATE);
        if (r3 == null) goto L5;
        SidecarDeviceState r0 = new SidecarDeviceState();
        Companion r1 = Companion;
        r1.setSidecarDevicePosture(r0, r1.getSidecarDevicePosture$window_release(r4));
        return new WindowLayoutInfo(translate(r1.getSidecarDisplayFeatures(r3), r0));
    L5:
        return new WindowLayoutInfo(r.g());
    }

    public final List<DisplayFeature> translate(List<SidecarDisplayFeature> r3, SidecarDeviceState r4) {
        o.f(r3, "sidecarDisplayFeatures");
        o.f(r4, "deviceState");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        DisplayFeature r1 = translate$window_release((SidecarDisplayFeature) r5.next(), r4);
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return r0;
    }

    public final DisplayFeature translate$window_release(SidecarDisplayFeature r9, SidecarDeviceState r10) {
        o.f(r9, "feature");
        o.f(r10, "deviceState");
        SpecificationComputer.Companion r1 = SpecificationComputer.Companion;
        String r3 = TAG;
        o.e(r3, "TAG");
        SidecarDisplayFeature r8 = (SidecarDisplayFeature) SpecificationComputer.Companion.startSpecification$default(r1, r9, r3, this.verificationMode, null, 4, null).require("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).require("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).require("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).require("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).compute();
        if (r8 != null) goto L5;
        return null;
    L5:
        int r11 = r8.getType();
        if (r11 == 1) goto L10;
        if (r11 == 2) goto L9;
        return null;
    L9:
        HardwareFoldingFeature.Type r12 = HardwareFoldingFeature.Type.Companion.getHINGE();
    L11:
        int r13 = Companion.getSidecarDevicePosture$window_release(r10);
        if (r13 == 0) goto L23;
        if (r13 == 1) goto L24;
        if (r13 != 2) goto L16;
        FoldingFeature.State r14 = FoldingFeature.State.HALF_OPENED;
    L21:
        Rect r15 = r9.getRect();
        o.e(r15, "feature.rect");
        return new HardwareFoldingFeature(new Bounds(r15), r12, r14);
    L16:
        if (r13 != 3) goto L18;
    L19:
        r14 = FoldingFeature.State.FLAT;
        goto L21
    L18:
        if (r13 != 4) goto L19;
        return null;
    L24:
        return null;
    L23:
        return null;
    L10:
        r12 = HardwareFoldingFeature.Type.Companion.getFOLD();
        goto L11
    }
}
