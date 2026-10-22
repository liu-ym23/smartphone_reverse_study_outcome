package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {

    static class a implements com.bytedance.framwork.core.sdkmonitor.k.m {
        a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.k.m
        public String getSessionId() {
            return null;
        }
    }

    static class b implements Runnable {

        class a implements com.bytedance.framwork.core.sdkmonitor.k.l {
            a(b r1) {
            }

            @Override // com.bytedance.framwork.core.sdkmonitor.k.l
            public void a(boolean r1) {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.m.p$b$b, reason: collision with other inner class name */
        class C0129b implements com.bytedance.framwork.core.sdkmonitor.k.l {
            C0129b(b r1) {
            }

            @Override // com.bytedance.framwork.core.sdkmonitor.k.l
            public void a(boolean r1) {
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = 0;
        L4:
            if (r0 >= 5) goto L6;
            com.bytedance.feedbackerlib.j.b.b().C(new a(this));
            SystemClock.sleep(2000);
            r0 = r0 + 1;
            goto L4
        L6:
            com.bytedance.feedbackerlib.j.b.b().E(new C0129b(this));
        }
    }

    private static void a() {
        t.c(new b());
    }

    public static synchronized void b(Context r3, String r4, String r5, String r6) {
        monitor-enter(p.class);
        a();     // Catch: Throwable -> L20
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L20
        r1.putOpt(WsConstants.KEY_DEVICE_ID, r6);     // Catch: JSONException -> L15 Throwable -> L20
        r1.putOpt("host_aid", r4);     // Catch: JSONException -> L15 Throwable -> L20
        r1.putOpt("channel", r5);     // Catch: JSONException -> L15 Throwable -> L20
        if (r3 == null) goto L8;
        r1.putOpt("package_name", r3.getPackageName());     // Catch: JSONException -> L15 Throwable -> L20
    L8:
        PackageManager r7 = r3.getPackageManager();     // Catch: JSONException -> L15 Throwable -> L20
        if (r7 == null) goto L17;
        PackageInfo r8 = null;
        r8 = r7.getPackageInfo(r3.getPackageName(), 0);     // Catch: Throwable -> L23
    L12:
        if (r8 == null) goto L17;
        r1.putOpt("base_version_code", Integer.valueOf(r8.versionCode));     // Catch: JSONException -> L15 Throwable -> L20
        r1.putOpt(WsConstants.KEY_APP_VERSION, r8.versionName);     // Catch: JSONException -> L15 Throwable -> L20
        r1.putOpt("update_version_code", Integer.valueOf(r8.versionCode));     // Catch: JSONException -> L15 Throwable -> L20
        r1.putOpt("sdk_version", r8.versionName);     // Catch: JSONException -> L15 Throwable -> L20
    L17:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L20
        r9.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");     // Catch: Throwable -> L20
        SDKMonitorUtils.d(String.valueOf(1925), r9);     // Catch: Throwable -> L20
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L20
        r10.add("https://mon.snssdk.com/monitor/collect/");     // Catch: Throwable -> L20
        SDKMonitorUtils.e(String.valueOf(1925), r10);     // Catch: Throwable -> L20
        SDKMonitorUtils.c(r3, String.valueOf(1925), r1, new a());     // Catch: Throwable -> L20
        monitor-exit(p.class);
        return;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
