package com.bytedance.ttnet.n;

import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import com.bytedance.ttnet.TTNetInit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f6490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f6491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f6492f;

    b(String r1, int r2, Map<String, String> r3) {
        this.f6487a = r1;
        this.f6488b = r2;
        this.f6490d = r3;
        this.f6489c = UUID.randomUUID().toString();
        this.f6491e = new CountDownLatch(1);
    }

    public void a() {
        this.f6491e.await();
    }

    public void b() {
        j.w(TTNetInit.getTTNetDepend().getContext()).e0(this.f6487a, this.f6488b, this.f6489c, this.f6490d);
    }

    public c c() {
        return this.f6492f;
    }

    public void d() {
        this.f6491e.countDown();
    }

    public void e(c r1) {
        this.f6492f = r1;
    }

    public String f() {
        return this.f6489c;
    }
}
