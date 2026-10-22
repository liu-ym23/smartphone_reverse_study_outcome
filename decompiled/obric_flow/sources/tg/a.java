package tg;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f22131a;

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public a(Context r5) {
        SharedPreferences r10 = r5.getSharedPreferences("__ab_vid_info.sp", 0);
        SharedPreferences r11 = r5.getSharedPreferences("__ab_exposed_info.sp", 0);
        r5.getSharedPreferences("__ab_local_exposed_info.sp", 0).edit();
        r11.edit();
        String r12 = r10.getString("key_vid_info", "");
        if (TextUtils.isEmpty(r12) == true) goto L11;
        new JSONObject(r12);     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static a a(Context r5) {
        if (f22131a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22131a != null) goto L11;
        f22131a = new a(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f22131a;
    }
}
