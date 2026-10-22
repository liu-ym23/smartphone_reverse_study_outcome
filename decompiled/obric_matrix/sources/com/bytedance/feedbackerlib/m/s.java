package com.bytedance.feedbackerlib.m;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static void a(@Nullable Closeable r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }
}
