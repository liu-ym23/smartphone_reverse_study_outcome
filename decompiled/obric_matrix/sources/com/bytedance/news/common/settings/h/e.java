package com.bytedance.news.common.settings.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile e f5325d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, com.bytedance.news.common.settings.g.c> f5327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.news.common.settings.g.c f5328c;

    private e(Context r5) {
        this.f5327b = new HashMap();
        this.f5328c = new com.bytedance.news.common.settings.g.c(null, null, "", false);
        SettingsConfigProvider r0 = (SettingsConfigProvider) com.bytedance.news.common.service.manager.d.a(SettingsConfigProvider.class);
        if (r0 == null) goto L8;
        if (r0.getConfig() == null) goto L8;
        this.f5326a = r0.getConfig().g(r5, "__local_settings_data.sp", 0);
    L8:
        if (this.f5326a != null) goto L11;
        this.f5326a = a(r5, "__local_settings_data.sp", 0);
        return;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static String b(String r1, String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r1;
    L6:
        return r1 + "_" + r2;
    }

    public static e c(Context r2) {
        if (f5325d != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5325d != null) goto L9;
        f5325d = new e(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f5325d;
    }

    @Nullable
    public synchronized com.bytedance.news.common.settings.g.c d(String r8) {
        monitor-enter(this);
        com.bytedance.news.common.settings.g.c r0 = this.f5327b.get(r8);     // Catch: Throwable -> L24
        if (r0 != null) goto L6;
        String r1 = this.f5326a.getString(b("key_local_app_settings_data", r8), "");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r1) == false) goto L28;
    L21:
        this.f5327b.put(r8, this.f5328c);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L28:
        JSONObject r2 = new JSONObject(r1);     // Catch: JSONException -> L19 Throwable -> L24
        String r3 = this.f5326a.getString(b("key_local_user_settings_data", r8), "");     // Catch: JSONException -> L19 Throwable -> L24
        if (TextUtils.isEmpty(r3) == true) goto L15;
        JSONObject r4 = new JSONObject(r3);     // Catch: JSONException -> L19 Throwable -> L24
    L16:
        com.bytedance.news.common.settings.g.c r5 = new com.bytedance.news.common.settings.g.c(r2, r4, this.f5326a.getString(b("key_last_update_token", r8), ""), false);     // Catch: JSONException -> L19 Throwable -> L24
        this.f5327b.put(r8, r5);     // Catch: JSONException -> L19 Throwable -> L24
        monitor-exit(this);
        return r5;
    L15:
        r4 = new JSONObject();     // Catch: JSONException -> L19 Throwable -> L24
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L21
    L6:
        if (r0 != this.f5328c) goto L8;
        r0 = null;
    L8:
        monitor-exit(this);
        return r0;
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void e(com.bytedance.news.common.settings.g.c r9, String r10) {
        monitor-enter(this);
        JSONObject r0 = r9.a();     // Catch: Throwable -> L74
        JSONObject r1 = r9.c();     // Catch: Throwable -> L74
        com.bytedance.news.common.settings.g.c r2 = d(r10);     // Catch: Throwable -> L74
        if (r2 == null) goto L50;
        JSONObject r3 = r2.a();     // Catch: Throwable -> L74
        JSONObject r4 = r2.c();     // Catch: Throwable -> L74
        if (r3 != null) goto L8;
        r3 = new JSONObject();     // Catch: Throwable -> L74
    L8:
        if (r4 != null) goto L10;
        r4 = new JSONObject();     // Catch: Throwable -> L74
    L10:
        if (r0 == null) goto L19;
        Iterator<String> r5 = r0.keys();     // Catch: Throwable -> L74
    L13:
        if (r5.hasNext() == false) goto L19;
        String r6 = r5.next();     // Catch: Throwable -> L74
        r3.put(r6, r0.opt(r6));     // Catch: JSONException -> L17 Throwable -> L74
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L19:
        if (r1 == null) goto L28;
        Iterator<String> r7 = r1.keys();     // Catch: Throwable -> L74
    L22:
        if (r7.hasNext() == false) goto L28;
        String r8 = r7.next();     // Catch: Throwable -> L74
        r4.put(r8, r1.opt(r8));     // Catch: JSONException -> L26 Throwable -> L74
    L26:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L28:
        this.f5327b.put(r10, r2);     // Catch: Throwable -> L74
        SharedPreferences.Editor r11 = this.f5326a.edit();     // Catch: Throwable -> L74
        r11.putString(b("key_last_update_token", r10), r9.b());     // Catch: Exception -> L31 Throwable -> L74
    L87:
        String r12 = b("key_local_app_settings_data", r10);     // Catch: Exception -> L39 Throwable -> L74
        if (r0 == null) goto L36;
        String r13 = r3.toString();     // Catch: Exception -> L39 Throwable -> L74
    L37:
        r11.putString(r12, r13);     // Catch: Exception -> L39 Throwable -> L74
    L83:
        String r14 = b("key_local_user_settings_data", r10);     // Catch: Exception -> L47 Throwable -> L74
        if (r1 == null) goto L44;
        String r15 = r4.toString();     // Catch: Exception -> L47 Throwable -> L74
    L45:
        r11.putString(r14, r15);     // Catch: Exception -> L47 Throwable -> L74
    L49:
        r11.apply();     // Catch: Throwable -> L74
        monitor-exit(this);
        return;
    L44:
        r15 = "";
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
        goto L49
    L36:
        r13 = "";
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
        goto L87
    L50:
        this.f5327b.put(r10, r9);     // Catch: Throwable -> L74
        r11 = this.f5326a.edit();     // Catch: Throwable -> L74
        r11.putString(b("key_last_update_token", r10), r9.b());     // Catch: Exception -> L53 Throwable -> L74
    L91:
        String r16 = b("key_local_app_settings_data", r10);     // Catch: Exception -> L61 Throwable -> L74
        if (r0 == null) goto L58;
        String r17 = r0.toString();     // Catch: Exception -> L61 Throwable -> L74
    L59:
        r11.putString(r16, r17);     // Catch: Exception -> L61 Throwable -> L74
    L85:
        String r18 = b("key_local_user_settings_data", r10);     // Catch: Exception -> L69 Throwable -> L74
        if (r1 == null) goto L66;
        String r19 = r1.toString();     // Catch: Exception -> L69 Throwable -> L74
    L67:
        r11.putString(r18, r19);     // Catch: Exception -> L69 Throwable -> L74
    L66:
        r19 = "";
    L69:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
        goto L49
    L58:
        r17 = "";
    L61:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;
    }
}
