package com.bytedance.bdinstall.b1;

import android.app.Application;
import android.content.Context;
import com.bytedance.bdinstall.h0;
import com.bytedance.bdinstall.i0;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.r;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    h0 a();

    r c();

    void d(Application r1);

    void e(Context r1, Map<String, String> r2, boolean r3, boolean r4);

    void f(Context r1, r r2, long r3, n0 r5);

    boolean g(JSONObject r1);

    String getDid();

    void h(i0 r1, r r2);

    void start();
}
