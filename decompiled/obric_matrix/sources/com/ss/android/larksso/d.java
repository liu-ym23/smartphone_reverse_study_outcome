package com.ss.android.larksso;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f12032a = null;

    static /* synthetic */ class a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        public void a(WebView r1, String r2) {
            if (r1 != null) goto L7;
            return;
        L7:
            r1.loadUrl(r2);     // Catch: Throwable -> L6
            return;
        }
    }

    @TargetApi(19)
    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(a r1) {
            this();
        }

        @Override // com.ss.android.larksso.d.b
        public void a(WebView r2, String r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            boolean r1 = false;
            if (r3 != null) goto L7;
        L13:
            if (r1 == true) goto L21;
            r2.loadUrl(r3);     // Catch: Throwable -> L16
            return;
        L22:
            return;
        L21:
            return;
        L7:
            if (r3.startsWith("javascript:") == false) goto L13;
            r2.evaluateJavascript(r3, null);     // Catch: Throwable -> L11
            r1 = true;
        L11:
            th = move-exception;
            boolean r0 = th instanceof IllegalStateException;
            goto L13
        }
    }

    static {
        a r1 = null;
        if (Build.VERSION.SDK_INT < 19) goto L5;
        b r0 = new c(r1);
    L6:
        f12032a = r0;
        return;
    L5:
        r0 = new b(r1);
        goto L6
    }

    public static void a(WebView r1, String r2) {
        f12032a.a(r1, r2);
    }
}
