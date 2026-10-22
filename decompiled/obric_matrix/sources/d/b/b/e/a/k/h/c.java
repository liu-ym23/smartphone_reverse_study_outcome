package d.b.b.e.a.k.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<a, b> f12706b;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f12707g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f12708h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ a[] f12709i = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f12710f;

        static {
            a r0 = new a("OTHER_LOG_TYPE", 0, "other");
            f12707g = r0;
            a r1 = new a("SERVICE_MONITOR", 1, "service_monitor");
            f12708h = r1;
            f12709i = new a[]{r0, r1};
        }

        private a(String r1, int r2, String r3) {
            super(r1, r2);
            this.f12710f = r3;
        }

        public static a valueOf(String r1) {
            return (a) Enum.valueOf(a.class, r1);
        }

        public static a[] values() {
            return (a[]) f12709i.clone();
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, JSONObject> f12712b;

        b() {
            this.f12712b = new HashMap();
        }

        public static b a(JSONObject r6) {
            b r0 = new b();
            boolean r2 = true;
            if (r6.optInt("default", 1) == 1) goto L6;
            r2 = false;
        L6:
            r0.f12711a = r2;
            Iterator<String> r3 = r6.keys();
        L8:
            if (r3.hasNext() == false) goto L14;
            String r4 = r3.next();
            if (TextUtils.equals(r4, "default") == true) goto L8;
            JSONObject r5 = r6.optJSONObject(r4);
            if (r5 == null) goto L8;
            r0.f12712b.put(r4, r5);
            goto L8
        L14:
            return r0;
        }

        @Nullable
        public JSONObject b() {
            JSONObject r0 = new JSONObject();     // Catch: JSONException -> L12
            if (this.f12711a == false) goto L5;
            int r2 = 1;
        L6:
            r0.put("default", r2);     // Catch: JSONException -> L12
            Iterator<Map.Entry<String, JSONObject>> r3 = this.f12712b.entrySet().iterator();     // Catch: JSONException -> L12
        L8:
            if (r3.hasNext() == false) goto L11;
            Map.Entry<String, JSONObject> r1 = r3.next();     // Catch: JSONException -> L12
            r0.put(r1.getKey(), r1.getValue());     // Catch: JSONException -> L12
            goto L8
        L11:
            return r0;
        L5:
            r2 = 0;
        L12:
            return null;
        }
    }

    public c() {
        this.f12706b = new HashMap();
    }

    public static c a(JSONObject r8) {
        if (d.b.b.o.a.c() == false) goto L5;
        d.b.b.o.m.b.d(d.b.b.e.a.a.f12571a, "DowngradeRule=" + r8.toString());
    L5:
        c r0 = new c();
        long r4 = r8.optLong(TypedValues.TransitionType.S_DURATION, 0);
        long r6 = r8.optLong("expire_time", 0);
        if (r6 <= 0) goto L8;
        r0.f12705a = r6;
    L9:
        a r1 = a.f12707g;
        JSONObject r2 = r8.optJSONObject(r1.f12710f);
        if (r2 == null) goto L12;
        r0.f12706b.put(r1, b.a(r2));
    L12:
        a r3 = a.f12708h;
        JSONObject r9 = r8.optJSONObject(r3.f12710f);
        if (r9 == null) goto L15;
        r0.f12706b.put(r3, b.a(r9));
    L15:
        return r0;
    L8:
        r0.f12705a = System.currentTimeMillis() + (r4 * 1000);
        goto L9
    }

    @Nullable
    public JSONObject b() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        r0.put("expire_time", this.f12705a);     // Catch: JSONException -> L8
        Iterator<Map.Entry<a, b>> r4 = this.f12706b.entrySet().iterator();     // Catch: JSONException -> L8
    L4:
        if (r4.hasNext() == false) goto L7;
        Map.Entry<a, b> r1 = r4.next();     // Catch: JSONException -> L8
        r0.put(r1.getKey().f12710f, r1.getValue().b());     // Catch: JSONException -> L8
        goto L4
    L7:
        return r0;
    L8:
        return null;
    }
}
