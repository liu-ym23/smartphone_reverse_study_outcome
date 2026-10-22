package com.bytedance.bdinstall.c1;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.t;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AccountManager f2686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Account f2688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f2689e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Account f2690f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f2691g;

        a(b r1, Account r2) {
            this.f2691g = r1;
            this.f2690f = r2;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MissingPermission"})
        public void run() {
            if (b.n(this.f2691g).size() > 0) goto L5;
            return;
        L5:
            if (b.o(this.f2691g) == null) goto L26;
            Iterator r0 = b.n(this.f2691g).entrySet().iterator();     // Catch: Exception -> L16
        L9:
            if (r0.hasNext() == false) goto L14;
            Map.Entry r1 = (Map.Entry) r0.next();     // Catch: Exception -> L16
            if (r1 == null) goto L9;
            b.o(this.f2691g).setUserData(this.f2690f, (String) r1.getKey(), (String) r1.getValue());     // Catch: Exception -> L16
            goto L9
        L14:
            b.n(this.f2691g).clear();     // Catch: Exception -> L16
            return;
        L26:
            return;
        }
    }

    b(Context r2, String r3) {
        this.f2689e = new ConcurrentHashMap();
        this.f2686b = AccountManager.get(r2);
        this.f2687c = r3;
    }

    static /* synthetic */ ConcurrentHashMap n(b r0) {
        return r0.f2689e;
    }

    static /* synthetic */ AccountManager o(b r0) {
        return r0.f2686b;
    }

    private String q(String r2) {
        return r2 + this.f2687c;
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    @SuppressLint({"MissingPermission"})
    public void a(String r2, String r3) {
        String r4 = q(r2);
        Account r0 = this.f2688d;
        if (r0 != null) goto L6;
        this.f2689e.put(r4, r3);
        return;
    L6:
        if (r3 != null) goto L11;
        return;
    L11:
        this.f2686b.setUserData(r0, r4, r3);     // Catch: Throwable -> L10
        return;
    }

    @Override // com.bytedance.bdinstall.c1.d, com.bytedance.bdinstall.c1.i
    @SuppressLint({"MissingPermission"})
    public String b(String r3) {
        String r4 = q(r3);
        String r0 = this.f2689e.get(r4);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Account r1 = this.f2688d;
        if (r1 != null) goto L11;
        return null;
    L11:
        return this.f2686b.getUserData(r1, r4);
    L10:
        return null;
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected void d(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        a(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.bdinstall.c1.d
    protected String[] e(String r1) {
        String r0 = b(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    void p(Account r2) {
        if (r2 == null) goto L8;
        this.f2688d = r2;
        if (this.f2689e.size() > 0) goto L6;
        return;
    L6:
        t.f(new a(this, r2));
        return;
    }
}
