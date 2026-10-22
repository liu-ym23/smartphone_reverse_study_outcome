package com.android.settings.teaevent;

import android.content.Context;
import com.android.settings.BuildConfig;
import com.android.settings.SettingsApplication;
import com.android.settings.utils.SysUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventReportUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0004J&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t¨\u0006\u001b"}, d2 = {"Lcom/android/settings/teaevent/EventReportUtil;", "", "()V", "initSDK", "", "reportActivateDeviceResult", "did", "", "isSuccess", "", "reportActivateDeviceStart", "reportActiveStart", "reportCheckActivationDidGet", "reportCheckActivationStart", "reportCheckActivationTimeout", "reportCheckLockStatusResult", "isLocked", "reportCheckLockStatusStart", "reportFetchTimeResult", "reportFetchTimeStart", "reportUdfpsEnrolling", "startTime", "", "deltaTime", "progress", "", "isFirstProgress", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EventReportUtil {
    public static final EventReportUtil INSTANCE = null;

    static {
        INSTANCE = new EventReportUtil();
    }

    private EventReportUtil() {
    }

    public final void initSDK() {
        Context r2 = SettingsApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        TeaEventReportUtil.init(r2, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE);
    }

    public final void reportActiveStart() {
        TeaEventReportUtil.reportEvent("settings_provision_start", MapsKt.mapOf(TuplesKt.to("cur_version", SysUtils.getOsOtaVersion())));
    }

    public final void reportFetchTimeStart() {
        TeaEventReportUtil.reportEvent("settings_provision_fetchtime_start", MapsKt.mapOf(TuplesKt.to("cur_version", SysUtils.getOsOtaVersion())));
    }

    public final void reportFetchTimeResult(boolean r3) {
        TeaEventReportUtil.reportEvent("settings_provision_fetchtime_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("is_successed", Boolean.valueOf(r3))}));
    }

    public final void reportCheckActivationStart() {
        TeaEventReportUtil.reportEvent("settings_provision_check_activation_start", MapsKt.mapOf(TuplesKt.to("cur_version", SysUtils.getOsOtaVersion())));
    }

    public final void reportCheckActivationDidGet(String r4) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_check_activation_did_get", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4)}));
    }

    public final void reportCheckLockStatusStart(String r4) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_check_lock_status_start", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4)}));
    }

    public final void reportCheckLockStatusResult(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_check_lock_status_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4), TuplesKt.to("is_successed", Boolean.valueOf(r6)), TuplesKt.to("is_locked", Boolean.valueOf(r5))}));
    }

    public final void reportActivateDeviceStart(String r4) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_activate_device_start", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4)}));
    }

    public final void reportActivateDeviceResult(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_activate_device_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4), TuplesKt.to("is_successed", Boolean.valueOf(r5))}));
    }

    public final void reportCheckActivationTimeout(String r4) {
        Intrinsics.checkNotNullParameter(r4, "did");
        TeaEventReportUtil.reportEvent("settings_provision_check_activation_timeout", MapsKt.mapOf(new Pair[]{TuplesKt.to("cur_version", SysUtils.getOsOtaVersion()), TuplesKt.to("did", r4)}));
    }

    public final void reportUdfpsEnrolling(long r2, long r4, int r6, boolean r7) {
        TeaEventReportUtil.reportEvent("settings_udfps_enroll_enrolling", MapsKt.mapOf(new Pair[]{TuplesKt.to("start_time", Long.valueOf(r2)), TuplesKt.to("delta_time", Long.valueOf(r4)), TuplesKt.to("fp_progress", Integer.valueOf(r6)), TuplesKt.to("is_first_progress", Boolean.valueOf(r7))}));
    }
}
