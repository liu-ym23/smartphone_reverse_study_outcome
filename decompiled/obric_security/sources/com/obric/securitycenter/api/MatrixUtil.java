package com.obric.securitycenter.api;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.MatrixOnesSdk;
import com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch.AppLaunchMonitor;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaConfig;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentConfig;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentInitHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.util.Utils;

/* JADX INFO: compiled from: MatrixUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¨\u0006\u0012"}, d2 = {"Lcom/obric/securitycenter/api/MatrixUtil;", "", "()V", Utils.METHOD_GET_DEVICE_ID, "", "initMatrix", "", "context", "Landroid/content/Context;", "versionName", "versionCode", "", "debug", "", "markLaunchPeriod", "period", "isStart", "isMainProcess", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MatrixUtil {
    public static final MatrixUtil INSTANCE = null;

    static {
        INSTANCE = new MatrixUtil();
    }

    private MatrixUtil() {
    }

    public final void initMatrix(Context r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "versionName");
        MatrixTeaConfig r1 = new MatrixTeaConfig.Builder().setPackageName("com.obric.security").setIsBoe(false).setVersionName(r3).setVersionCode(r4).build();
        MatrixTeaManager.Companion.init(r2, r1);
        BaseComponentInitHelper.init(r2, new BaseComponentConfig.Builder().setIsBoe(false).setBaseUrl("https://os.obriccloud.com").setNeedSetCookieHandler(false).setAppId(899598).build());
        MatrixOnesSdk.INSTANCE.enableLog(r5);
    }

    public final void markLaunchPeriod(String r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "period");
        if (r3 == false) goto L8;
        if (r2 == false) goto L6;
        AppLaunchMonitor.Companion.getInstance().markStart(r1);
        return;
    L6:
        AppLaunchMonitor.Companion.getInstance().markEnd(r1);
        return;
    }

    public final String getDeviceId() {
        return MatrixTeaManager.Companion.getInstance().getDeviceId();
    }
}
