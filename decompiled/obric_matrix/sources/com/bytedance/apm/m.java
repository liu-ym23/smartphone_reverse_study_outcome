package com.bytedance.apm;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IZstdDict;
import com.obric.matrix.common_api.INetworkApi;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m implements IZstdDict {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f1651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1653e;

    public m() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private void b() {
        HashMap r1 = new HashMap(d.b.b.i.c.a.w());
        r1.put("slardar_zstd_dict_type", "monitor");
        r1.put("zstd_client_code_version", "dynamic");
        r1.put(INetworkApi.CONTENT_TYPE, INetworkApi.DEFAULT_CONTENT_TYPE);
        byte[] r2 = new JSONObject(r1).toString().getBytes();     // Catch: Exception -> L13
        HttpResponse r3 = d.b.b.i.c.a.g(d.b.b.o.k.a(this.f1649a, r1), r1, r2);     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.getResponseBytes() == null) goto L19;
        JSONObject r4 = new JSONObject(new String(r3.getResponseBytes()));     // Catch: Exception -> L13
        String r5 = r4.getString("dict_version");     // Catch: Exception -> L13
        String r6 = r4.getString("dict");     // Catch: Exception -> L13
        if (r4.getInt("code") == 200) goto L10;
        return;
    L10:
        byte[] r7 = Base64.decode(r6, 0);     // Catch: Exception -> L13
        d(new File(d.b.b.o.a.b().getFilesDir(), "monitor_dict"), r7);     // Catch: Exception -> L13
        this.f1653e = r5;     // Catch: Exception -> L13
        this.f1651c = r7;     // Catch: Exception -> L13
        this.f1652d = System.currentTimeMillis();
        a(d.b.b.o.a.b(), "dict_interval", 0).edit().putLong("dict_interval", this.f1652d).putString("dict_version", r5).commit();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void c() {
        if (this.f1650b == false) goto L5;
        return;
    L5:
        this.f1651c = d.b.b.o.c.e(new File(d.b.b.o.a.b().getFilesDir(), "monitor_dict"));
        SharedPreferences r0 = a(d.b.b.o.a.b(), "dict_interval", 0);
        this.f1652d = r0.getLong("dict_interval", 0);
        this.f1653e = r0.getString("dict_version", null);
        this.f1650b = true;
    }

    private static void d(File r2, byte[] r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L30;
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
    L18:
        th = th;
    L19:
        d.b.b.o.d.b(r0);
        throw th;
    L10:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r2.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L18 Exception -> L23
        r1.write(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        d.b.b.o.d.b(r1);
        return;
    L17:
        r0 = r1;
    L15:
        th = th;
        r0 = r1;
        goto L19
    L21:
        d.b.b.o.d.b(r0);
        return;
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    @Nullable
    public Pair<byte[], String> getDictAndDictVersion() {
        c();
        byte[] r0 = this.f1651c;
        if (r0 != null) goto L5;
    L6:
        b();
        r0 = this.f1651c;
    L8:
        return new Pair(r0, this.f1653e);
    L5:
        if ((System.currentTimeMillis() - this.f1652d) <= 604800000) goto L8;
        goto L6
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public void setDomain(String r3) {
        this.f1649a = "https://" + r3 + "/monitor/collect/zstd_dict/";
    }
}
