package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.common.wschannel.app.IWsApp;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.bytedance.common.wschannel.server.b f3768a;

    static class a implements f {
        a() {
        }

        @Override // com.bytedance.common.wschannel.server.f
        public boolean a() {
            return true;
        }

        @Override // com.bytedance.common.wschannel.server.f
        public void b() {
        }

        @Override // com.bytedance.common.wschannel.server.f
        public void c(f.a r1) {
        }
    }

    static class b implements g {
        b() {
        }

        @Override // com.bytedance.common.wschannel.server.g
        public Map<Integer, IWsApp> a() {
            return Collections.emptyMap();
        }

        @Override // com.bytedance.common.wschannel.server.g
        public void b(Map<Integer, IWsApp> r1) {
        }
    }

    private static com.bytedance.common.wschannel.server.b a(Context r10) {
        HandlerThread r0 = new HandlerThread("wschannel");
        r0.start();
        com.bytedance.common.wschannel.server.a r6 = new com.bytedance.common.wschannel.server.a();
        i r1 = new i(r10, r6);
        a r8 = new a();
        com.bytedance.common.wschannel.server.b r9 = new com.bytedance.common.wschannel.server.b(r10, r0.getLooper(), new b(), r6, r1, r8);
        r1.k(r9);
        return r9;
    }

    public static com.bytedance.common.wschannel.server.b b(Context r2) {
        if (f3768a != null) goto L15;
        monitor-enter(com.bytedance.common.wschannel.server.b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3768a != null) goto L9;
        f3768a = a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.common.wschannel.server.b.class);     // Catch: Throwable -> L11
    L15:
        return f3768a;
    }
}
