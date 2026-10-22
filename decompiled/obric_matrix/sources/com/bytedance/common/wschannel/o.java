package com.bytedance.common.wschannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3636b = "com.bytedance.common.wschannel.o";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak"})
    private static volatile o f3637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f3638d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WsChannelMultiProcessSharedProvider.c f3639a;

    public interface a {
        Map<String, String> a(String r1, Map<String, List<String>> r2);

        Map<String, String> b(Map<String, String> r1);
    }

    static {
    }

    private o(@NonNull Context r1) {
        this.f3639a = WsChannelMultiProcessSharedProvider.n(r1.getApplicationContext());
    }

    public static a b() {
        return f3638d;
    }

    public static o f(Context r2) {
        if (f3637c != null) goto L15;
        monitor-enter(o.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3637c != null) goto L9;
        f3637c = new o(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(o.class);     // Catch: Throwable -> L11
    L15:
        return f3637c;
    }

    public ArrayList<Integer> a() {
        ArrayList<Integer> r0 = new ArrayList();
        String r3 = this.f3639a.e(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return r0;
    L16:
        JSONArray r1 = new JSONArray(r3);     // Catch: JSONException -> L13
        int r4 = 0;
    L7:
        if (r4 >= r1.length()) goto L10;
        r0.add(Integer.valueOf(r1.getInt(r4)));     // Catch: JSONException -> L13
        r4 = r4 + 1;     // Catch: JSONException -> L13
        goto L7
    L10:
        if (Logger.debug() == false) goto L15;
        Logger.d(f3636b, "getAutoConnectDisabledChannelIds: " + r0);     // Catch: JSONException -> L13
    L15:
        return r0;
    L13:
        e = move-exception;
        Logger.e(f3636b, e.getMessage());
        goto L15
    }

    public long c() {
        return this.f3639a.d(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0);
    }

    public long d() {
        return this.f3639a.d(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public String e() {
        return this.f3639a.e(WsConstants.KEY_WS_APPS, "");
    }

    public boolean g() {
        return this.f3639a.c(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public boolean h() {
        return this.f3639a.c(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public boolean i() {
        return this.f3639a.c(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public boolean j() {
        return this.f3639a.c(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public void k(boolean r2) {
        WsChannelMultiProcessSharedProvider.b r1 = this.f3639a.b();
        r1.c(WsConstants.KEY_ENABLE_OFFLINE_DETECT, r2);
        r1.b();
    }

    public void l(String r2) {
        WsChannelMultiProcessSharedProvider.b r1 = this.f3639a.b();
        r1.d(WsConstants.KEY_WS_APPS, r2);
        r1.b();
    }
}
