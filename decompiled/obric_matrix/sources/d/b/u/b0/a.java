package d.b.u.b0;

import com.google.gson.y.c;
import com.ss.ttuploader.TTVideoUploader;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c("version")
    private int f14991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c("channel")
    private int f14992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c("sync")
    private int f14993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c("poll")
    private int f14994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c("background_sync")
    private int f14995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c("background_poll")
    private int f14996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c("report_size_limit")
    private int f14997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c("submit_size_limit")
    private int f14998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c("db_store_size_limit")
    private int f14999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c("event_send_delay")
    private long f15000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @c("android_ws_poll_interval")
    private long f15001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @c("is_compress")
    private int f15002l;

    @c("history_size_limit")
    private int m;

    @c("poll_interval_limit")
    private int n;

    @c("poll_try")
    private int o;

    public a() {
        this.f14993c = 60;
        this.f14994d = TTVideoUploader.KeyIsGetTosKey;
        this.f14995e = TTVideoUploader.KeyIsGetTosKey;
        this.f14996f = 600;
        this.f14997g = 6144;
        this.f14998h = 51200;
        this.f14999i = 51200;
        this.f15000j = 5;
        this.f15001k = -1;
        this.f15002l = 1;
        this.m = 10;
        this.n = 5000;
        this.o = 1;
    }

    public boolean a() {
        if (this.f15002l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean b() {
        if (this.f15001k == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int c() {
        return this.f14996f;
    }

    public int d() {
        return this.f14995e;
    }

    public int e() {
        return this.f14992b;
    }

    public int f() {
        return this.f14999i;
    }

    public long g() {
        return this.f15000j;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.f14994d;
    }

    public int j() {
        return this.n;
    }

    public long k() {
        long r0 = this.f15001k;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return i();
    }

    public int l() {
        return this.o;
    }

    public int m() {
        return this.f14997g;
    }

    public int n() {
        return this.f14993c;
    }

    public boolean o() {
        if (e() > 0) goto L5;
        return true;
    L5:
        return false;
    }
}
