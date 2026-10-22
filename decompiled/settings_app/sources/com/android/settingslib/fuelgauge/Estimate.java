package com.android.settingslib.fuelgauge;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import java.time.Duration;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Estimate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/android/settingslib/fuelgauge/Estimate;", "", "estimateMillis", "", "isBasedOnUsage", "", "averageDischargeTime", "(JZJ)V", "getAverageDischargeTime", "()J", "getEstimateMillis", "()Z", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Estimate {
    public static final Companion Companion = null;
    private final long averageDischargeTime;
    private final long estimateMillis;
    private final boolean isBasedOnUsage;

    /* JADX INFO: compiled from: Estimate.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¨\u0006\f"}, d2 = {"Lcom/android/settingslib/fuelgauge/Estimate$Companion;", "", "()V", "getCachedEstimateIfAvailable", "Lcom/android/settingslib/fuelgauge/Estimate;", "context", "Landroid/content/Context;", "getLastCacheUpdateTime", "Ljava/time/Instant;", "storeCachedEstimate", "", "estimate", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Estimate getCachedEstimateIfAvailable(Context r9) {
            Intrinsics.checkNotNullParameter(r9, "context");
            ContentResolver r0 = r9.getContentResolver();
            if (Duration.between(getLastCacheUpdateTime(r9), Instant.now()).compareTo(Duration.ofMinutes(1)) <= 0) goto L5;
            Estimate r10 = (Estimate) null;
            return null;
        L5:
            long r3 = Settings.Global.getLong(r0, "time_remaining_estimate_millis", -1);
            boolean r5 = false;
            if (Settings.Global.getInt(r0, "time_remaining_estimate_based_on_usage", 0) != 1) goto L9;
            r5 = true;
        L9:
            return new Estimate(r3, r5, Settings.Global.getLong(r0, "average_time_to_discharge", -1));
        }

        @JvmStatic
        public final void storeCachedEstimate(Context r3, Estimate r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "estimate");
            ContentResolver r2 = r3.getContentResolver();
            Settings.Global.putLong(r2, "time_remaining_estimate_millis", r4.getEstimateMillis());
            Settings.Global.putInt(r2, "time_remaining_estimate_based_on_usage", r4.isBasedOnUsage() ? 1 : 0);
            Settings.Global.putLong(r2, "average_time_to_discharge", r4.getAverageDischargeTime());
            Settings.Global.putLong(r2, "battery_estimates_last_update_time", System.currentTimeMillis());
        }

        @JvmStatic
        public final Instant getLastCacheUpdateTime(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Instant r2 = Instant.ofEpochMilli(Settings.Global.getLong(r3.getContentResolver(), "battery_estimates_last_update_time", -1));
            Intrinsics.checkNotNullExpressionValue(r2, "ofEpochMilli(\n          …                     -1))");
            return r2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final Estimate getCachedEstimateIfAvailable(Context r1) {
        return Companion.getCachedEstimateIfAvailable(r1);
    }

    @JvmStatic
    public static final Instant getLastCacheUpdateTime(Context r1) {
        return Companion.getLastCacheUpdateTime(r1);
    }

    @JvmStatic
    public static final void storeCachedEstimate(Context r1, Estimate r2) {
        Companion.storeCachedEstimate(r1, r2);
    }

    public Estimate(long r1, boolean r3, long r4) {
        this.estimateMillis = r1;
        this.isBasedOnUsage = r3;
        this.averageDischargeTime = r4;
    }

    public final long getEstimateMillis() {
        return this.estimateMillis;
    }

    public final boolean isBasedOnUsage() {
        return this.isBasedOnUsage;
    }

    public final long getAverageDischargeTime() {
        return this.averageDischargeTime;
    }
}
