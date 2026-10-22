package com.bytedance.feedbackerlib.model.e;

import androidx.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f4621a;

    private d(Map<String, String> r1, int r2) {
        this.f4621a = r1;
    }

    @NonNull
    public static d a(@NonNull com.bytedance.feedbackerlib.model.d.b r2) {
        return new d(r2.f4611a, r2.f4612b);
    }

    @NonNull
    public static d b(@NonNull String r0) {
        return a(com.bytedance.feedbackerlib.model.d.b.a(r0));
    }
}
