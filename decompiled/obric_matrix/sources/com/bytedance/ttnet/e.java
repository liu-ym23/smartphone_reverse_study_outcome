package com.bytedance.ttnet;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    @Deprecated
    void a(Context r1, JSONObject r2);

    void b(Context r1, Map<String, ?> r2);

    void c(String r1, JSONObject r2);

    void d(Context r1, String r2, String r3, JSONObject r4);

    void e(String r1);

    String[] f();

    boolean g();

    int getAppId();

    Context getContext();

    String h(Context r1, String r2, String r3);

    int i(Context r1, String r2, int r3);

    Map<String, String> j();

    String k();

    String l();

    ArrayList<String> m();

    void onColdStartFinish();
}
