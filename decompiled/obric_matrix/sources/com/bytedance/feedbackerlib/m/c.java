package com.bytedance.feedbackerlib.m;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(@NonNull String r3, @Nullable String r4, @Nullable Throwable r5) {
        d.i.a.a.a.g("feedbacker.tag", r3 + " -> " + r4, r5);
        Log.e("feedbacker.tag", "==> " + r3 + " e: " + r4, r5);
    }

    public static void b(@NonNull String r3, @NonNull String r4) {
        d.i.a.a.a.j("feedbacker.tag", r3 + " -> " + r4);
        Log.i("feedbacker.tag", "==> " + r3 + " i: " + r4);
    }
}
