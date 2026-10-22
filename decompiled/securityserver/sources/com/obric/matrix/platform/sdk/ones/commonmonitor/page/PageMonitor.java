package com.obric.matrix.platform.sdk.ones.commonmonitor.page;

import a.a;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PageMonitor {

    @NotNull
    public static final Companion Companion = null;
    private static final long MAX_TIME_THRESHOLD = 10000;

    @NotNull
    public static final String PERIOD_ACTIVITY_CREATE = "activity_create";

    @NotNull
    public static final String PERIOD_ACTIVITY_RESUME = "activity_resume";

    @NotNull
    public static final String PERIOD_FRAGMENT_CREATE = "fragment_create";

    @NotNull
    public static final String PERIOD_FRAGMENT_CREATE_VIEW = "fragment_create_view";

    @NotNull
    public static final String PERIOD_FRAGMENT_RESUME = "fragment_resume";

    @NotNull
    public static final String PERIOD_FRAGMENT_VIEW_CREATE = "fragment_view_create";

    @NotNull
    public static final String PERIOD_USERDATA_REAL_SHOW = "userdata_real_show";

    @NotNull
    private static final String TAG = "PageMonitor";
    private boolean mReportDuration;

    @NotNull
    private final String pageName;

    @NotNull
    private final HashMap<String, Long> periodEndMap;

    @NotNull
    private final HashMap<String, Long> periodStartMap;
    private long start;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PageMonitor(@NotNull String r2) {
        Intrinsics.f(r2, "pageName");
        this.pageName = r2;
        this.periodStartMap = new HashMap();
        this.periodEndMap = new HashMap();
    }

    private final void reportUserDataRealShowDuration() {
        if (this.mReportDuration == false) goto L5;
        return;
    L5:
        this.mReportDuration = true;
        if (this.start <= 0) goto L29;
        JSONObject r0 = new JSONObject();
        if (this.periodEndMap.size() <= 0) goto L15;
        Iterator<Map.Entry<String, Long>> r1 = this.periodEndMap.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, Long> r4 = r1.next();
        String r5 = r4.getKey();
        long r6 = r4.getValue().longValue();
        Long r7 = this.periodStartMap.get(r5);
        if (r7 == null) goto L11;
        r0.put(r5, r6 - r7.longValue()).put(a.j(r5, "_start"), r7.longValue()).put(r5 + "_end", r6);
    L15:
        Long r2 = this.periodEndMap.get("userdata_real_show");
        if (r2 != null) goto L18;
        r2 = 0L;
    L18:
        long r8 = r2.longValue();
        if (r8 > 0) goto L21;
        return;
    L21:
        if (r8 > TimeUnit.SECONDS.toMillis(10)) goto L31;
        MatrixTeaManager.Companion.getInstance().onPageShowEvent(this.pageName, r8, r0);
        return;
    L31:
        return;
    }

    public final void markEnd(@NotNull String r6) {
        Intrinsics.f(r6, TypedValues.CycleType.S_WAVE_PERIOD);
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (this.start <= 0) goto L11;
        this.periodEndMap.put(r6, Long.valueOf(SystemClock.elapsedRealtime() - this.start));
        if (r6.equals("userdata_real_show") == false) goto L12;
        reportUserDataRealShowDuration();
        return;
    L12:
        return;
    }

    public final void markStart(@NotNull String r6) {
        Intrinsics.f(r6, TypedValues.CycleType.S_WAVE_PERIOD);
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (this.start <= 0) goto L9;
        this.periodStartMap.put(r6, Long.valueOf(SystemClock.elapsedRealtime() - this.start));
        return;
    }

    public final void start() {
        if (this.mReportDuration == false) goto L5;
        return;
    L5:
        this.start = SystemClock.elapsedRealtime();
    }
}
