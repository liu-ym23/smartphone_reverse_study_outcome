package com.bytedance.applog.y;

import androidx.annotation.NonNull;
import com.bytedance.applog.util.n;
import com.bytedance.keva.KevaImpl;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f2506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.bytedance.applog.q.b f2510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f2511h;

    public a(com.bytedance.applog.q.b r4, long r5) {
        this.f2504a = 0;
        this.f2506c = 0;
        this.f2507d = 0;
        this.f2508e = 0;
        this.f2509f = 0;
        this.f2510g = r4;
        this.f2511h = r5;
    }

    private int b(com.bytedance.applog.s.b r2) {
        if (r2 != null) goto L4;
        return 12;
    L4:
        if ((-1) != r2.f()) goto L7;
        return 12;
    L7:
        if (r2.f() != 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return 60;
    }

    public boolean a(int r11) {
        if (this.f2504a <= 0) goto L11;
        long r2 = System.currentTimeMillis();
        long r4 = this.f2506c;
        long r6 = this.f2511h;
        if (r2 >= (r4 + r6)) goto L10;
        int r0 = this.f2507d;
        if (r0 < this.f2505b) goto L9;
        return true;
    L9:
        this.f2507d = r0 + 1;
        goto L11
    L10:
        this.f2506c = r4 + (((r2 - r4) / r6) * r6);
        this.f2507d = 1;
    L11:
        int r1 = this.f2504a;
        if (r1 < 10000) goto L14;
        return true;
    L14:
        if (r1 <= 0) goto L20;
        if (r1 >= 10000) goto L20;
        if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) >= this.f2504a) goto L20;
        return true;
    L20:
        if (this.f2508e <= 0) goto L23;
        if (1 != r11) goto L23;
    L26:
        return true;
    L23:
        if (this.f2509f > 0) goto L25;
        return false;
    L25:
        if (3 == r11) goto L26;
        return false;
    }

    public void c(@NonNull JSONObject r5, long r6, com.bytedance.applog.s.b r8) {
        this.f2511h = r6;
        int r7 = r5.optInt("backoff_ratio", 0);
        this.f2504a = r7;
        if (r7 >= 0) goto L5;
    L6:
        this.f2504a = 0;
    L7:
        int r9 = r5.optInt("max_request_frequency", b(r8));
        this.f2505b = r9;
        if (r9 > 0) goto L10;
        this.f2505b = 12;
    L10:
        int r10 = this.f2504a;
        if (r10 > 0) goto L13;
    L15:
        if (r10 != 0) goto L17;
        this.f2506c = 0;
        this.f2507d = 0;
    L17:
        this.f2508e = r5.optInt("disable_session_start_request", 0);
        this.f2509f = r5.optInt("disable_session_end_request", 0);
        if (this.f2504a != 0) goto L22;
        int r11 = this.f2505b;
        if (r11 <= 0) goto L22;
        this.f2510g.U(r8, r11);
    L22:
        n.a("parseBackoffControllerFromResp mEventInterval: " + this.f2511h + ", mBackoffRatio: " + this.f2504a + ", mMaxRequestFrequency: " + this.f2505b + ", mBackoffWindowStartTime: " + this.f2506c + ", mBackoffWindowSendCount: " + this.f2507d + ", mDisableSessionStartRequest: " + this.f2508e + ", mDisableSessionEndRequest: " + this.f2509f);
        return;
    L13:
        if (this.f2506c != 0) goto L15;
        this.f2506c = System.currentTimeMillis();
        this.f2507d = 1;
        goto L17
    L5:
        if (r7 <= 10000) goto L7;
        goto L6
    }
}
