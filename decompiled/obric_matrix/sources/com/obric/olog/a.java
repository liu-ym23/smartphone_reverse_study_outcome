package com.obric.olog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10701a;

    public a(Context r1) {
        this.f10701a = r1;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r12) {
        if (r12.what == 1011) goto L5;
        return;
    L5:
        Bundle r6 = r12.getData();
        if (r6 != null) goto L9;
        Log.e("olog ConfigHandler", "receive null data");
        return;
    L9:
        Log.i("olog ConfigHandler", "receive config data");
        String r7 = r6.getString("data");     // Catch: JSONException -> L40
        Log.i("olog ConfigHandler", r7);     // Catch: JSONException -> L40
        JSONObject r8 = new JSONObject(r7);     // Catch: JSONException -> L40
        Context r9 = this.f10701a;     // Catch: JSONException -> L40
        if (r9 != null) goto L14;
        Log.e("olog ConfigHandler", "context is null");     // Catch: JSONException -> L40
        return;
    L14:
        SharedPreferences.Editor r10 = a(r9, "olog_config", 0).edit();     // Catch: JSONException -> L40
        if (r8.has("report") == false) goto L20;
        boolean r11 = r8.getBoolean("report");     // Catch: JSONException -> L40
        r10.putBoolean("report", r11);     // Catch: JSONException -> L40
        if (OLog.i() == false) goto L20;
        OLog.l(r11);     // Catch: JSONException -> L40
    L20:
        if (r8.has("output_to_logd") == false) goto L25;
        boolean r5 = r8.getBoolean("output_to_logd");     // Catch: JSONException -> L40
        r10.putBoolean("output_to_logd", r5);     // Catch: JSONException -> L40
        if (OLog.i() == false) goto L25;
        OLog.k(r5);     // Catch: JSONException -> L40
    L25:
        if (r8.has("log_level") == false) goto L30;
        int r4 = r8.getInt("log_level");     // Catch: JSONException -> L40
        r10.putInt("log_level", r4);     // Catch: JSONException -> L40
        if (OLog.i() == false) goto L30;
        OLog.j(r4);     // Catch: JSONException -> L40
    L30:
        if (r8.has("save_to_disk") == false) goto L33;
        r10.putBoolean("save_to_disk", r8.getBoolean("save_to_disk"));     // Catch: JSONException -> L40
    L33:
        if (r8.has("max_dir_size") == false) goto L36;
        r10.putInt("max_dir_size", r8.getInt("max_dir_size"));     // Catch: JSONException -> L40
    L36:
        if (r8.has("log_expired_days") == false) goto L38;
        r10.putInt("log_expired_days", r8.getInt("log_expired_days"));     // Catch: JSONException -> L40
    L38:
        r10.apply();     // Catch: JSONException -> L40
    L42:
        super.handleMessage(r12);
        return;
    L40:
        e = move-exception;
        Log.e("olog ConfigHandler", e.getMessage());
        goto L42
    }
}
