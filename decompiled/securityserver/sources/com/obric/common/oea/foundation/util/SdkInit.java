package com.obric.common.oea.foundation.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SdkInit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f150a;

    @Metadata
    public static final class Companion {
    }

    public SdkInit() {
        if (f150a != 0) goto L5;
        OEALogger.d("OEA_FOUNDATION", "init, SDK_BUILD_NO: [20260113-14:27:49|2|b8d6a45|20260113-14:20:56_feature: oea 2.0]");
    L5:
        f150a++;
    }
}
