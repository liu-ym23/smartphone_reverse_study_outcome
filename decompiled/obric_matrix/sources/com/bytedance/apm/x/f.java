package com.bytedance.apm.x;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f2131a;

    static class a implements b {
        a() {
        }

        @Override // com.bytedance.apm.x.f.b
        public void a(String r1, String r2, Object... r3) {
            if (r3 != null) goto L4;
        L7:
            Log.w(r1, r2);
            return;
        L4:
            if (r3.length == 0) goto L7;
            r2 = String.format(r2, r3);
            goto L7
        }

        @Override // com.bytedance.apm.x.f.b
        public void b(String r1, String r2, Object... r3) {
            if (r3 != null) goto L4;
        L7:
            Log.i(r1, r2);
            return;
        L4:
            if (r3.length == 0) goto L7;
            r2 = String.format(r2, r3);
            goto L7
        }

        @Override // com.bytedance.apm.x.f.b
        public void c(String r1, String r2, Object... r3) {
            if (r3 != null) goto L4;
        L7:
            Log.e(r1, r2);
            return;
        L4:
            if (r3.length == 0) goto L7;
            r2 = String.format(r2, r3);
            goto L7
        }
    }

    public interface b {
        void a(String r1, String r2, Object... r3);

        void b(String r1, String r2, Object... r3);

        void c(String r1, String r2, Object... r3);
    }

    static {
        f2131a = new a();
    }
}
