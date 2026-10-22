package com.bytedance.feedbackerlib.m;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f4261d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4264c;

    static {
        f4261d = new f(WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME, WsConstants.EXIT_DELAY_TIME);
    }

    public f(long r1, long r3, long r5) {
        this.f4262a = r1;
        this.f4263b = r3;
        this.f4264c = r5;
    }
}
