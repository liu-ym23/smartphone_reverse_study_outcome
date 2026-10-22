package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import com.bytedanceos.datausage.DataUsageDetailActivity;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;

/* JADX INFO: compiled from: MathUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\t\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007J\u001e\u0010\t\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/MathUtils;", "", "()V", "keepDecimal", "", DayFormatter.DEFAULT_FORMAT, "n", "", "keepTwoDecimal", DataUsageDetailActivity.INTENT_EXTRA_LIMIT, "value", "min", "max", "", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MathUtils {
    public static final MathUtils INSTANCE = null;

    static {
        INSTANCE = new MathUtils();
    }

    private MathUtils() {
    }

    public final float limit(float r1, float r2, float r3) {
        return Math.min(r3, Math.max(r1, r2));
    }

    public final int limit(int r1, int r2, int r3) {
        return Math.min(r3, Math.max(r1, r2));
    }

    public final long limit(long r1, long r3, long r5) {
        return Math.min(r5, Math.max(r1, r3));
    }

    public final double limit(double r1, double r3, double r5) {
        return Math.min(r5, Math.max(r1, r3));
    }

    public final double keepTwoDecimal(double r3) {
        double r0 = 100;
        return Math.floor(r3 * r0) / r0;
    }

    public final double keepDecimal(double r5, int r7) {
        double r0 = Math.pow(10.0d, r7);
        return Math.floor(r5 * r0) / r0;
    }
}
