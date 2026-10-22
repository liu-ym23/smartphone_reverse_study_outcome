package s6;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.apm.j;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends a {
    public static final int f = 0;
    public static final boolean g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21834h = 0;

    static {
        f = Runtime.getRuntime().availableProcessors();
        g = false;
        f21834h = 300;
    }

    public static JSONObject l(int r5, int r10, String r11, String r12) {
        JSONObject r13 = new JSONObject();
        if (r5 > 0) goto L17;
    L7:
        r13.put("java_thread_count", r10);     // Catch: JSONException -> L5
        if (TextUtils.isEmpty(r11) == true) goto L11;
        r13.put("scene", r11);     // Catch: JSONException -> L5
    L11:
        if (TextUtils.isEmpty(r12) == true) goto L13;
        r13.put("thread_detail", r12);     // Catch: JSONException -> L5
    L13:
        r13.put("is_main_process", j.d());     // Catch: JSONException -> L5
        r13.put("cpu_count", f);     // Catch: JSONException -> L5
        r13.put("process_name", j.a());     // Catch: JSONException -> L5
    L16:
        return r13;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L17:
        r13.put("total_thread_count", r5);     // Catch: JSONException -> L5
        goto L7
    }

    public static int m(String r11, boolean r12) {
        int r5 = new File("/proc/self/task/").list().length;     // Catch: Throwable -> L5
    L6:
        if (r5 != 0) goto L8;
        return 0;
    L8:
        ThreadGroup r10 = Looper.getMainLooper().getThread().getThreadGroup();
    L10:
        if (r10.getParent() == null) goto L12;
        r10 = r10.getParent();
        goto L10
    L12:
        int[] r13 = {r10.activeCount()};
        z6.b.f23409a.d(new e(r12, r13, r11, r5, r10));
        return (r5 << 16) + r13[0];
    L5:
        r5 = 0;
        goto L6
    }
}
