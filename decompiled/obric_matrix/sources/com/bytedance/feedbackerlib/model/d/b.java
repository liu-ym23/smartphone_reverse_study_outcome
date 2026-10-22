package com.bytedance.feedbackerlib.model.d;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.y.c;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c("message")
    public final Map<String, String> f4611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c("status")
    public final int f4612b;

    public static b a(@NonNull String r2) {
        return (b) new Gson().m(r2, b.class);
    }
}
