package d.b.s.a.w;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.android.f;
import com.ss.android.i.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f14946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f14947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f14948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f14949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f14950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14952i;

    /* JADX INFO: renamed from: d.b.s.a.w.a$a, reason: collision with other inner class name */
    public static class C0402a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f14953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f14954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<String, String> f14955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<f> f14956d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f14957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f14958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14959g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f14960h;

        public C0402a() {
            this.f14960h = 0;
        }

        public C0402a(a r2) {
            this.f14960h = 0;
            this.f14953a = r2.f14944a;
            this.f14954b = r2.f14945b;
            this.f14955c = r2.f14946c;
            this.f14956d = r2.f14947d;
            this.f14957e = r2.f14949f;
            this.f14958f = r2.f14950g;
            this.f14959g = r2.f14951h;
            this.f14960h = r2.f14952i;
        }

        public C0402a a(f r2) {
            if (r2 != null) goto L5;
            return this;
        L5:
            if (this.f14956d != null) goto L7;
            this.f14956d = new ArrayList();
        L7:
            this.f14956d.add(r2);
            return this;
        }

        public C0402a b(Map<String, String> r5) {
            if (r5 != null) goto L4;
        L13:
            return this;
        L4:
            if (r5.isEmpty() == true) goto L13;
            if (this.f14956d != null) goto L9;
            this.f14956d = new ArrayList();
        L9:
            Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            Map.Entry<String, String> r0 = r6.next();
            this.f14956d.add(new f(r0.getKey(), r0.getValue()));
            goto L11
        }

        public a c() {
            if (TextUtils.isEmpty(this.f14954b) == false) goto L6;
            this.f14954b = "get";
        L6:
            return new a(this.f14953a, this.f14954b, this.f14955c, this.f14956d, this.f14957e, this.f14958f, this.f14959g, this.f14960h);
        }

        public C0402a d() {
            if (this.f14955c != null) goto L6;
            this.f14955c = new HashMap();
        L6:
            if (j.k().h() == false) goto L8;
            this.f14955c.put("multi_login", LocationInfoConst.ALLOW_USE_LOCATION);
        L8:
            return this;
        }

        public C0402a e(String r1, String r2) {
            if (r1 == null) goto L5;
            if (r2 == null) goto L5;
            this.f14957e = r1;
            this.f14958f = r2;
        L5:
            return this;
        }

        public a f() {
            this.f14954b = "get";
            return c();
        }

        public C0402a g(String r2, String r3) {
            if (this.f14955c != null) goto L5;
            this.f14955c = new HashMap();
        L5:
            this.f14955c.put(r2, r3);
            return this;
        }

        public C0402a h(Map<String, String> r4) {
            if (this.f14955c != null) goto L5;
            this.f14955c = r4;
        L10:
            return this;
        L5:
            if (r4 == null) goto L10;
            Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            Map.Entry<String, String> r0 = r5.next();
            this.f14955c.put(r0.getKey(), r0.getValue());
            goto L8
        }

        public C0402a i(Map<String, String> r4, Map<String, String> r5) {
            if (this.f14955c != null) goto L5;
            this.f14955c = new HashMap();
        L5:
            if (r4 == null) goto L10;
            Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
        L8:
            if (r6.hasNext() == false) goto L10;
            Map.Entry<String, String> r0 = r6.next();
            this.f14955c.put(r0.getKey(), r0.getValue());
        L10:
            if (r5 != null) goto L12;
        L21:
            return this;
        L12:
            if (r5.isEmpty() == true) goto L21;
            Iterator<String> r7 = r5.keySet().iterator();
        L15:
            if (r7.hasNext() == false) goto L21;
            String r1 = r7.next();
            if (TextUtils.isEmpty(r1) == true) goto L15;
            if (r5.get(r1) == null) goto L15;
            this.f14955c.put(r1, r5.get(r1));
            goto L15
        }

        public a j() {
            this.f14954b = "post";
            return c();
        }

        public a k() {
            this.f14954b = "post_file";
            return c();
        }

        public C0402a l(String r1) {
            this.f14953a = r1;
            return this;
        }

        public C0402a m(boolean r1) {
            this.f14959g = r1;
            return this;
        }
    }

    public a(String r3, String r4, Map<String, String> r5, List<f> r6, String r7, String r8, boolean r9, int r10) {
        this.f14948e = 0;
        this.f14952i = 0;
        this.f14944a = r3;
        this.f14945b = r4;
        this.f14946c = r5;
        this.f14949f = r7;
        this.f14950g = r8;
        this.f14947d = r6;
        this.f14951h = r9;
        this.f14952i = r10;
    }

    public C0402a a() {
        return new C0402a(this);
    }

    public String b(String r1) {
        Map<String, String> r0 = this.f14946c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get(r1);
    }
}
