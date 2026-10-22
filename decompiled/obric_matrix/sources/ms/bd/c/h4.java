package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f22364c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f22365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f22366e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static h4 f22367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f22368g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f22369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f22370b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f22371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f22372b;

        private a() {
            throw new RuntimeException((String) m.a(16777217, 0, 0, "9daf1f", new byte[]{1, 104, 26, 27, 12, 120, 46, 64, 52, 119}));
        }

        public a(String r1, String r2) {
            this.f22371a = r1;
            this.f22372b = r2;
        }

        public String a() {
            return this.f22372b;
        }

        public String b() {
            return this.f22371a;
        }
    }

    static {
        f22364c = (String) m.a(16777217, 0, 0, "5ea609", new byte[]{107, 100, 19, 82, 27, 45, 62, 69, 127, 112, 33, 117, 27, 68, 22});
        f22365d = (String) m.a(16777217, 0, 0, "8bc80e", new byte[]{102, 112, 17, 95, 28, 98, 52, 81, 38, 39, 36, 111, 18, 69, 3, 119, 116, 78, 61, 106, 32, 108, 21, 115, 12, 115, 41, 71, 13, 100, 38, 103, 25, 66, 64});
        f22366e = (String) m.a(16777217, 0, 0, "4f366e", new byte[]{106, 116, 65, 81, 26, 98, 56, 85, 118, 41, 40, 107, 66, 75, 5, 119, 120, 84, 111, 117, 26, 104, 79, 69, 0, 124, 120});
        f22368g = (String) m.a(16777217, 0, 0, "63fd4c", new byte[]{53, 52, 18, 21, 19, 75, 56, 29, 51, 49, 24, 61, 28, 3, 31});
    }

    private h4(Context r12) {
        this.f22370b = new ArrayList(10);
        SharedPreferences r13 = a(r12);
        this.f22369a = r13;
        d(r13.getString((String) m.a(16777217, 0, 0, "e7d90f", new byte[]{102, 48, 16, 72, 23, 78, 107, 25, 49, 108, 75, 57, 30, 94, 27}), ""), false);
        if (this.f22370b.size() >= 1) goto L18;
        Object r14 = b.d(33554445, 3, 0, null, null);
        Object r2 = b.d(33554445, 2, 0, null, null);
        Object r3 = b.d(33554445, 1, 0, null, null);
        if (r14 != null) goto L7;
    L9:
        if (r2 != null) goto L11;
    L13:
        if (r3 != null) goto L15;
        return;
    L15:
        if (((Integer) r3).intValue() != 1) goto L20;
        a r15 = new a((String) m.a(16777217, 0, 0, "f2b3fb", new byte[]{56, 32, 16, 84, 74, 101, 106, 1, 39, 44, 122, 63, 19, 78, 85, 112, 42, 0, 62, 112, 72, 60, 30, 64, 80, 123, 42}), (String) m.a(16777217, 0, 0, "e4c2e2", new byte[]{103, 47, 30, 69}));
        this.f22370b.add(r15);
        return;
    L20:
        return;
    L11:
        if (((Integer) r2).intValue() != 1) goto L13;
        a r16 = new a((String) m.a(16777217, 0, 0, "6d94b9", new byte[]{104, 118, 75, 83, 78, 62, 58, 87, 124, 43, 42, 105, 72, 73, 81, 43, 122, 72, 103, 102, 46, 106, 79, 127, 94, 47, 39, 65, 87, 104, 40, 97, 67, 78, 18}), (String) m.a(16777217, 0, 0, "eb43b2", new byte[]{103, 121, 73, 68}));
        this.f22370b.add(r16);
        goto L13
    L7:
        if (((Integer) r14).intValue() == 0) goto L9;
        a r17 = new a((String) m.a(16777217, 0, 0, "e159b4", new byte[]{59, 48, 71, 93, 73, 32, 110, 17, 43, 127, 113, 33, 79, 75, 68}), (String) m.a(16777217, 0, 0, "26bf5c", new byte[]{48, 45, 31, 17}));
        this.f22370b.add(r17);
        goto L9
    }

    @Proxy("getDefaultSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.preference.PreferenceManager")
    public static SharedPreferences a(Context r0) {
        return PreferenceManager.getDefaultSharedPreferences(com.obric.matrix.r.b.g(r0));
    }

    public static synchronized h4 c(Context r2) {
        monitor-enter(h4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f22367f != null) goto L7;
        f22367f = new h4(r2);     // Catch: Throwable -> L10
    L7:
        h4 r3 = f22367f;     // Catch: Throwable -> L10
        monitor-exit(h4.class);
        return r3;
    }

    public synchronized a b(String r12) {
        monitor-enter(this);
        if (r12 != null) goto L50;
        monitor-exit(this);
        return null;
    L50:
        int r7 = b.f22318b;     // Catch: Throwable -> L47
        Object r1 = m.a(33554445, 3, 0, null, null);     // Catch: Throwable -> L47
        boolean r2 = false;
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        Object r4 = m.a(33554445, 2, 0, null, null);     // Catch: Throwable -> L47
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        Object r6 = m.a(33554445, 1, 0, null, null);     // Catch: Throwable -> L47
        if (r6 != null) goto L24;
    L26:
        Iterator<a> r8 = this.f22370b.iterator();     // Catch: Throwable -> L47
    L27:
        if (r8.hasNext() == false) goto L45;
        a r9 = r8.next();     // Catch: Throwable -> L47
        if (r9.b().equals(f22366e) == false) goto L34;
        if (r2 == false) goto L27;
    L34:
        if (r9.b().equals(f22365d) == false) goto L38;
        if (r5 == false) goto L27;
    L38:
        if (r9.b().equals(f22364c) == false) goto L42;
        if (r3 == false) goto L27;
    L42:
        if (Pattern.compile(r9.b()).matcher(r12).find() == false) goto L27;
        monitor-exit(this);
        return r9;
    L45:
        monitor-exit(this);
        return null;
    L24:
        if (((Integer) r6).intValue() != 1) goto L26;
        r2 = true;
        goto L26
    L18:
        if (((Integer) r4).intValue() != 1) goto L20;
        r5 = true;
        goto L21
    L11:
        if (((Integer) r1).intValue() != 0) goto L14;
        r3 = false;
    L47:
        th = move-exception;
        throw th;
    }

    public synchronized void d(String r22, boolean r23) {
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r22) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        ArrayList r2 = new ArrayList(20);     // Catch: Throwable -> L38 JSONException -> L43
        JSONObject r3 = new JSONObject(r22);     // Catch: Throwable -> L38 JSONException -> L43
        String r4 = r3.getString((String) m.a(16777217, 0, 0, "be6b1c", new byte[]{101, 98, 87, 5, 7, 123, 111}));     // Catch: Throwable -> L38 JSONException -> L43
        String r5 = r3.getString((String) m.a(16777217, 0, 0, "9ad79e", new byte[]{58, 118, 27, 70, 21}));     // Catch: Throwable -> L38 JSONException -> L43
        if (((String) m.a(16777217, 0, 0, "9e437c", new byte[]{121})).equals(r4) == false) goto L34;
        if (r5 == null) goto L34;
        String[] r6 = r5.split((String) m.a(16777217, 0, 0, "7c754b", new byte[]{26, 125}));     // Catch: Throwable -> L38 JSONException -> L43
        int r7 = r6.length;     // Catch: Throwable -> L38 JSONException -> L43
        int r8 = 0;
    L24:
        if (r8 >= r7) goto L34;
        String[] r9 = r6[r8].split((String) m.a(16777217, 0, 0, "4facab", new byte[]{127}));     // Catch: Throwable -> L38 JSONException -> L43
        if (r9 == null) goto L33;
        if (r9.length < 2) goto L33;
        r2.add(new a(new String(d0.d(r9[0])), r9[1]));     // Catch: Throwable -> L38 JSONException -> L43
    L33:
        r8 = r8 + 1;     // Catch: Throwable -> L38 JSONException -> L43
    L34:
        this.f22370b = r2;     // Catch: Throwable -> L38 JSONException -> L43
        if (r23 == false) goto L41;
        this.f22369a.edit().putString(f22368g, r22).apply();     // Catch: Throwable -> L38 JSONException -> L43
    L41:
        monitor-exit(this);
    }
}
