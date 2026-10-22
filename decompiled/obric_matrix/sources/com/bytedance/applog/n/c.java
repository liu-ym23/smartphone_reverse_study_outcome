package com.bytedance.applog.n;

import android.app.Application;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.bytedance.applog.m;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.i0;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    h0 a();

    void b(Application r1, String r2);

    @Nullable
    i0 c();

    void d(a.f r1);

    void e(Application r1, com.bytedance.applog.q.b r2, m r3, Looper r4, com.bytedance.applog.b r5);

    String getDid();

    void start();
}
