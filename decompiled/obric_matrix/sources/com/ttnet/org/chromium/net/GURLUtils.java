package com.ttnet.org.chromium.net;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public final class GURLUtils {

    @VisibleForTesting
    public interface Natives {
        String getOrigin(String r1);
    }

    public GURLUtils() {
    }

    public static String getOrigin(String r1) {
        return GURLUtilsJni.get().getOrigin(r1);
    }
}
