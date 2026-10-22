package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.d;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.t;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import d.b.b.e.a.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<IResponseConfigListener> f12550a;

    /* JADX INFO: renamed from: d.b.b.a$a, reason: collision with other inner class name */
    static class C0324a extends com.bytedance.apm6.hub.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12551a;

        /* JADX INFO: renamed from: d.b.b.a$a$a, reason: collision with other inner class name */
        class C0325a implements d.b.b.n.e.a {
            C0325a(C0324a r1) {
            }

            @Override // d.b.b.n.e.a
            public String a(String r1, List<Pair<String, String>> r2) {
                return d.b.h.b.a.a.g(r1, r2);
            }
        }

        /* JADX INFO: renamed from: d.b.b.a$a$b */
        class b implements g {

            /* JADX INFO: renamed from: d.b.b.a$a$b$a, reason: collision with other inner class name */
            class RunnableC0326a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ JSONObject f12552f;

                RunnableC0326a(b r1, JSONObject r2) {
                    this.f12552f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.a(this.f12552f);
                }
            }

            b(C0324a r1) {
            }

            @Override // d.b.b.e.a.g
            public void onResponse(JSONObject r3) {
                if (d.G() == true) goto L5;
                return;
            L5:
                com.bytedance.apm.f0.b.f().i(new RunnableC0326a(this, r3));
            }
        }

        /* JADX INFO: renamed from: d.b.b.a$a$c */
        class c implements d.b.b.n.d.a {
            c(C0324a r1) {
            }

            @Override // d.b.b.n.d.a
            public JSONObject e() {
                JSONObject r1 = new JSONObject();
                com.bytedance.apm.util.c.k().a(r1);
                return r1;
            }
        }

        C0324a(Context r1) {
            this.f12551a = r1;
        }

        @Override // d.b.b.i.c.b
        public String a() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.b();
        }

        @Override // d.b.b.i.c.b
        public Map<String, String> b() {
            return d.w();
        }

        @Override // d.b.b.i.c.b
        public JSONObject c() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.i();
        }

        @Override // d.b.b.i.c.b
        public JSONObject d() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 == null) goto L8;
            JSONObject r1 = r0.i();
            if (r1 == null) goto L13;
            JSONObject r2 = new JSONObject();     // Catch: JSONException -> L10
            r2.put("max_size_mb_today", r1.optInt("max_size_mb_today", -1));     // Catch: JSONException -> L10
            return r2;
        L14:
            return null;
        L13:
            return null;
        L8:
            return null;
        }

        @Override // com.bytedance.apm6.hub.a, d.b.b.i.c.b
        public JSONObject e() {
            return super.e();
        }

        @Override // d.b.b.i.c.b
        public String f() {
            return d.i();
        }

        @Override // d.b.b.i.c.b
        public String g() {
            com.bytedance.apm.g r1 = d.v();
            if (r1 == null) goto L5;
            String r2 = r1.g();
        L7:
            if (TextUtils.isEmpty(r2) == true) goto L11;
            if (Objects.equals(r2, "null") == true) goto L11;
            return r2;
        L11:
            return t.a();
        L5:
            r2 = null;
            goto L7
        }

        @Override // d.b.b.i.c.b
        public int getAid() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.a();
        }

        @Override // d.b.b.i.c.b
        public String getChannel() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.c();
        }

        @Override // d.b.b.i.c.b
        public Context getContext() {
            return this.f12551a;
        }

        @Override // d.b.b.i.c.b
        public String getDeviceId() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.d();
        }

        @Override // d.b.b.i.c.b
        public int getManifestVersionCode() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.e();
        }

        @Override // d.b.b.i.c.b
        public String getSessionId() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.h();
        }

        @Override // d.b.b.i.c.b
        public long getUid() {
            com.bytedance.apm.g r2 = d.v();
            if (r2 != null) goto L5;
            return 0;
        L5:
            return r2.j();
        }

        @Override // d.b.b.i.c.b
        public int getUpdateVersionCode() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.k();
        }

        @Override // d.b.b.i.c.b
        public int getVersionCode() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.k();
        }

        @Override // d.b.b.i.c.b
        public String getVersionName() {
            com.bytedance.apm.g r0 = d.v();
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.l();
        }

        @Override // com.bytedance.apm6.hub.a
        protected d.b.b.n.d.a j() {
            return new c(this);
        }

        @Override // com.bytedance.apm6.hub.a
        protected d.b.b.n.e.a k() {
            return new C0325a(this);
        }

        @Override // com.bytedance.apm6.hub.a
        protected IEncrypt l() {
            return ApmDelegate.k().j();
        }

        @Override // com.bytedance.apm6.hub.a
        protected IHttpService n() {
            return d.m();
        }

        @Override // com.bytedance.apm6.hub.a
        protected d.b.b.k.a p() {
            return new d.b.b.b();
        }

        @Override // com.bytedance.apm6.hub.a
        protected d.b.b.k.f.b q() {
            return new d.b.b.c();
        }

        @Override // com.bytedance.apm6.hub.a
        protected g s() {
            return new b(this);
        }
    }

    public static void a(JSONObject r2) {
        List<IResponseConfigListener> r0 = f12550a;
        if (r0 == null) goto L8;
        Iterator<IResponseConfigListener> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().onResponse(r2);
        goto L6
    L10:
        return;
    }

    public static Runnable b(Context r1) {
        return Apm.c(new C0324a(r1));
    }

    public static void c(IResponseConfigListener r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (f12550a != null) goto L8;
        f12550a = new CopyOnWriteArrayList();
    L8:
        if (f12550a.contains(r1) == true) goto L11;
        f12550a.add(r1);
        return;
    }

    public static void d(IResponseConfigListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        List<IResponseConfigListener> r0 = f12550a;
        if (r0 == null) goto L8;
        r0.remove(r1);
        return;
    }
}
