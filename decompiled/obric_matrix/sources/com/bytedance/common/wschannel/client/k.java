package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: loaded from: classes.dex */
public interface k {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Parcelable f3503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3504c;

        public a() {
        }
    }

    void a(Context r1, SsWsApp r2);

    void b(Context r1, int r2);

    void c(Context r1, boolean r2, boolean r3);

    void d(Context r1);

    void e(Context r1);

    void f(Context r1, WsChannelMsg r2);

    void g(Context r1, SsWsApp r2);
}
