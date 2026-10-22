package com.bytedance.applog.o;

import com.bytedance.applog.util.n;
import com.ss.ttuploader.TTUploadResolver;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2298h;

    class a implements com.bytedance.applog.t.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f2299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f2300b;

        a(i r1, JSONObject r2) {
            this.f2300b = r1;
            this.f2299a = r2;
        }

        @Override // com.bytedance.applog.t.b
        public void onFail(int r2) {
            n.c("sync error: " + r2, null);
        }

        @Override // com.bytedance.applog.t.b
        public void onSuccess() {
            i.m(this.f2300b, this.f2299a.hashCode());
        }
    }

    i(e r1) {
        super(r1);
    }

    static /* synthetic */ int m(i r0, int r1) {
        r0.f2298h = r1;
        return r1;
    }

    @Override // com.bytedance.applog.o.c
    protected boolean c(int r9) {
        com.bytedance.applog.q.c r10 = this.f2259a.t();     // Catch: Exception -> L9
        JSONObject r0 = r10.d();     // Catch: Exception -> L9
        if (r10.l() == true) goto L5;
        return true;
    L5:
        if (this.f2298h == r0.hashCode()) goto L14;
        com.bytedance.applog.t.c.c(this.f2259a, 1, new JSONObject(), new a(this, r0), null, true);     // Catch: Exception -> L9
        return true;
    L14:
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.applog.o.c
    protected String e() {
        return "up";
    }

    @Override // com.bytedance.applog.o.c
    protected long[] f() {
        return new long[TTUploadResolver.HOST_MAX_CACHE_TIME];
    }

    @Override // com.bytedance.applog.o.c
    protected boolean h() {
        return true;
    }

    @Override // com.bytedance.applog.o.c
    protected long i() {
        return 60000;
    }
}
