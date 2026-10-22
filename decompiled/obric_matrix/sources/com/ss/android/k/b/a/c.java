package com.ss.android.k.b.a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int a(@NonNull Context r2, @NonNull String r3) {
        if (r3 == null) goto L13;
        return r2.checkPermission(r3, Process.myPid(), Process.myUid());
    L5:
        th = move-exception;
        th.printStackTrace();
        if (Build.VERSION.SDK_INT < 23) goto L10;
        return -1;
    L10:
        return 0;
    L13:
        throw new IllegalArgumentException("permission is null");
    }
}
