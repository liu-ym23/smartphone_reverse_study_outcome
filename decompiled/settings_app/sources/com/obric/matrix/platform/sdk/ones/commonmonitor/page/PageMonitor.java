package com.obric.matrix.platform.sdk.ones.commonmonitor.page;

import android.os.SystemClock;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PageMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0006\u0010\f\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/page/PageMonitor;", "", "pageName", "", "(Ljava/lang/String;)V", "mReportDuration", "", "periodEndMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "periodStartMap", "start", "markEnd", "", "period", "markStart", "reportUserDataRealShowDuration", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PageMonitor {
    public static final Companion Companion = null;
    private static final long MAX_TIME_THRESHOLD = 10000;
    public static final String PERIOD_ACTIVITY_CREATE = "activity_create";
    public static final String PERIOD_ACTIVITY_RESUME = "activity_resume";
    public static final String PERIOD_FRAGMENT_CREATE = "fragment_create";
    public static final String PERIOD_FRAGMENT_CREATE_VIEW = "fragment_create_view";
    public static final String PERIOD_FRAGMENT_RESUME = "fragment_resume";
    public static final String PERIOD_FRAGMENT_VIEW_CREATE = "fragment_view_create";
    public static final String PERIOD_USERDATA_REAL_SHOW = "userdata_real_show";
    private static final String TAG = "PageMonitor";
    private boolean mReportDuration;
    private final String pageName;
    private final HashMap<String, Long> periodEndMap;
    private final HashMap<String, Long> periodStartMap;
    private long start;

    /* JADX INFO: compiled from: PageMonitor.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/page/PageMonitor$Companion;", "", "()V", "MAX_TIME_THRESHOLD", "", "PERIOD_ACTIVITY_CREATE", "", "PERIOD_ACTIVITY_RESUME", "PERIOD_FRAGMENT_CREATE", "PERIOD_FRAGMENT_CREATE_VIEW", "PERIOD_FRAGMENT_RESUME", "PERIOD_FRAGMENT_VIEW_CREATE", "PERIOD_USERDATA_REAL_SHOW", "TAG", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public PageMonitor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        this.pageName = r2;
        this.periodStartMap = new HashMap();
        this.periodEndMap = new HashMap();
    }

    public final void start() {
        if (this.mReportDuration == false) goto L5;
        return;
    L5:
        this.start = SystemClock.elapsedRealtime();
    }

    public final void markStart(String r6) {
        Intrinsics.checkNotNullParameter(r6, "period");
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (this.start <= 0) goto L9;
        this.periodStartMap.put(r6, Long.valueOf(SystemClock.elapsedRealtime() - this.start));
        return;
    }

    public final void markEnd(String r6) {
        Intrinsics.checkNotNullParameter(r6, "period");
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (this.start <= 0) goto L11;
        this.periodEndMap.put(r6, Long.valueOf(SystemClock.elapsedRealtime() - this.start));
        if (Intrinsics.areEqual(r6, "userdata_real_show") == false) goto L12;
        reportUserDataRealShowDuration();
        return;
    L12:
        return;
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
        r0.put(r5, r6 - r7.longValue()).put(r5 + "_start", r7.longValue()).put(r5 + "_end", r6);
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
}
