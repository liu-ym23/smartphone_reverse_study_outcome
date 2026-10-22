package com.obric.matrix.platform.sdk.ones.env;

import com.bytedance.watson.assist.utils.SystemProperties;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class EnvUtils {

    @NotNull
    public static final EnvUtils INSTANCE = null;

    static {
        INSTANCE = new EnvUtils();
    }

    private EnvUtils() {
    }

    private final String getOSVersion() {
        Object r2 = "";
        Object r0 = SystemProperties.get("ro.os.ota.version", "");     // Catch: Throwable -> L5
    L8:
        if ((r0 instanceof Result.Failure) == true) goto L12;
        r2 = r0;
    L12:
        return (String) r2;
    L5:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L8
    }

    @NotNull
    public final String getCurrChannel() {
        if (isReleaseChannel() == false) goto L6;
        return "release";
    L6:
        return "dev";
    }

    public final boolean isReleaseChannel() {
        return StringsKt.m("release", false, getOSVersion());
    }
}
