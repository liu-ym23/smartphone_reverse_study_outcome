package com.obric.matrix.platform.sdk.ones.env;

import com.bytedance.watson.assist.utils.SystemProperties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EnvUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/env/EnvUtils;", "", "()V", "getCurrChannel", "", "getOSVersion", "isReleaseChannel", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EnvUtils {
    public static final EnvUtils INSTANCE = null;

    static {
        INSTANCE = new EnvUtils();
    }

    private EnvUtils() {
    }

    public final String getCurrChannel() {
        if (isReleaseChannel() == false) goto L6;
        return "release";
    L6:
        return "dev";
    }

    public final boolean isReleaseChannel() {
        return StringsKt.contains$default(getOSVersion(), "release", false, 2, null);
    }

    private final String getOSVersion() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        EnvUtils r2 = this;     // Catch: Throwable -> L5
        Object r3 = Result.m774constructorimpl(SystemProperties.get("ro.os.ota.version", ""));     // Catch: Throwable -> L5
    L8:
        if (Result.m780isFailureimpl(r3) == true) goto L12;
        r0 = r3;
    L12:
        return (String) r0;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
