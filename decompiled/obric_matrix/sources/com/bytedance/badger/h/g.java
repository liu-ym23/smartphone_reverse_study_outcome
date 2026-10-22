package com.bytedance.badger.h;

import java.util.concurrent.TimeUnit;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public g() {
    }

    public final c a(String r2, boolean r3) {
        o.g(r2, "key");
        return new c(this, r2, r3);
    }

    public final d b(String r8, long r9, TimeUnit r11) {
        o.g(r8, "key");
        o.g(r11, "timeUnit");
        return new d(this, r8, r9, r11);
    }

    public abstract JSONObject c();
}
