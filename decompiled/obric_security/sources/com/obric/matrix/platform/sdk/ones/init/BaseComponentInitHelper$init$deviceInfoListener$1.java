package com.obric.matrix.platform.sdk.ones.init;

import android.content.Context;
import android.os.Build;
import com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseComponentInitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/init/BaseComponentInitHelper$init$deviceInfoListener$1", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/DeviceInfoListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseComponentInitHelper$init$deviceInfoListener$1 implements DeviceInfoListener {
    final /* synthetic */ BaseComponentConfig $baseComponentConfig;
    final /* synthetic */ Context $context;

    public static /* synthetic */ void $r8$lambda$fju82MLtZ67jykZxYTcUAiCDn2A(Context r0, String r1, BaseComponentConfig r2) {
        m164onDeviceIdLoaded$lambda0(r0, r1, r2);
    }

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener
    public void onInstallIdLoaded(String r1) {
        Intrinsics.checkNotNullParameter(r1, "installId");
    }

    BaseComponentInitHelper$init$deviceInfoListener$1(Context r1, BaseComponentConfig r2) {
        this.$context = r1;
        this.$baseComponentConfig = r2;
    }

    @Override // com.obric.matrix.platform.sdk.ones.dataanalysis.DeviceInfoListener
    public void onDeviceIdLoaded(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "did");
        if (BaseComponentInitHelper.access$isValidDeviceIdOrInstallId(BaseComponentInitHelper.INSTANCE, r4) == true) goto L6;
        MLog.e$default("BaseComponentInitHelper", "did is not valid", null, 4, null);
        return;
    L6:
        ExecutorService r0 = BaseComponentInitHelper.access$getInitExecutor(BaseComponentInitHelper.INSTANCE);
        final Context r1 = this.$context;
        final BaseComponentConfig r3 = this.$baseComponentConfig;
        r0.execute(new BaseComponentInitHelper$init$deviceInfoListener$1$$ExternalSyntheticLambda0(r1, r4, r3));
    }

    /* JADX INFO: renamed from: onDeviceIdLoaded$lambda-0, reason: not valid java name */
    private static final void m164onDeviceIdLoaded$lambda0(Context r3, String r4, BaseComponentConfig r5) {
        Intrinsics.checkNotNullParameter(r3, "$context");
        Intrinsics.checkNotNullParameter(r4, "$did");
        Intrinsics.checkNotNullParameter(r5, "$baseComponentConfig");
        if (Build.VERSION.SDK_INT >= 33) goto L11;
        MLog.e$default("BaseComponentInitHelper", "initInterval skipped, requires Android 13+", null, 4, null);
        return;
    L11:
        BaseComponentInitHelper.access$initInterval(r3, r4, r5);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        MLog.e("BaseComponentInitHelper", "initInterval error", th);
    }
}
