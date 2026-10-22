package u9;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f22312c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f22313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f22314b;

    public static g a() {
        if (f22312c != null) goto L16;
        monitor-enter(g.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22312c != null) goto L11;
        g r5 = new g();     // Catch: Throwable -> L9
        r5.f22313a = 0;     // Catch: Throwable -> L9
        r5.f22314b = new CopyOnWriteArrayList();     // Catch: Throwable -> L9
        f22312c = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L9
    L16:
        return f22312c;
    }

    public static boolean c(String r5, ArrayList r10, JSONObject r11) {
        int r12 = 0;
        if (r11 != null) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L17;
        JSONArray r13 = r11.optJSONArray(r5);
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r12 >= r13.length()) goto L15;
        String r14 = r13.optString(r12);
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r10.add(r14);
    L14:
        r12 = r12 + 1;
        goto L10
    L15:
        return true;
    }

    public final void b(String r10, boolean r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        Iterator r5 = this.f22314b.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        f r12 = (f) r5.next();
        if (r12.f22305i.equals(r10) == false) goto L7;
    L12:
        if (r12 != null) goto L15;
        return;
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.d("g", "Forbidden: " + r12.f22308l + " failed count: " + r12.f22306j + " max count: " + r12.f22304h);
    L17:
        if (r11 == true) goto L19;
        int r13 = r12.f22306j + 1;
        r12.f22306j = r13;
        if (r13 >= r12.f22304h) goto L28;
        return;
    L28:
        if (r12.f22308l == true) goto L31;
        r12.f22308l = true;
        r12.f22307k = SystemClock.uptimeMillis();
    L31:
        if (Logger.debug() == false) goto L38;
        Logger.d("g", "Forbidden: " + r12.f22308l + " failed count: " + r12.f22306j);
        return;
    L38:
        return;
    L19:
        if (r12.f22306j == 0) goto L21;
    L23:
        r12.f22306j = 0;
        r12.f22308l = false;
        return;
    L21:
        if (r12.f22308l == true) goto L23;
        return;
    L11:
        r12 = null;
        goto L12
    }

    public final void d(JSONObject r10) {
        ArrayList r5 = new ArrayList();
        c("host_group", r5, r10);
        ArrayList r11 = new ArrayList();
        c("concurrent_hosts", r11, r10);
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11.size() < 2) goto L50;
        f r12 = new f(r5, r11);
        ArrayList r13 = new ArrayList();
        if (c("equal_group", r13, r10) == false) goto L10;
        r12.f22303c = r13;
    L10:
        ArrayList r14 = new ArrayList();
        if (c("prefix_group", r14, r10) == false) goto L13;
        r12.d = r14;
    L13:
        ArrayList r15 = new ArrayList();
        JSONArray r16 = r10.optJSONArray("pattern_group");
        int r17 = 0;
        if (r16 == null) goto L23;
        int r18 = 0;
    L17:
        if (r18 >= r16.length()) goto L22;
        String r19 = r16.optString(r18);
        if (TextUtils.isEmpty(r19) == true) goto L21;
        r15.add(Pattern.compile(r19, 2));     // Catch: Throwable -> L42
    L21:
        r18 = r18 + 1;
        goto L17
    L22:
        r12.e = r15;
    L23:
        r12.f22304h = r10.optInt("fail_count", Integer.MAX_VALUE);
        r12.g = r10.optInt("forbid_seconds", 0);
        r12.f22309m = r10.optInt("connect_interval_millis", 4000);
        boolean r20 = true;
        if (r10.optInt("bypass_rs_enabled", 1) <= 0) goto L26;
        boolean r21 = true;
    L27:
        r12.f22311o = r21;
        if (r12.f22309m > 0) goto L31;
        return;
    L31:
        if (r10.optInt("retry_for_not_2xx_code", 0) > 0) goto L34;
        r20 = false;
    L34:
        r12.f22310n = r20;
        HashSet r22 = new HashSet();
        JSONArray r23 = r10.optJSONArray("block_code_list");
        if (r23 != null) goto L37;
    L40:
        this.f22314b.add(r12);
        return;
    L37:
        if (r17 >= r23.length()) goto L39;
        r22.add(Integer.valueOf(r23.optInt(r17)));
        r17 = r17 + 1;
        goto L37
    L39:
        r12.f = r22;
        goto L40
    L26:
        r21 = false;
        goto L27
    }
}
