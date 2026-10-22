package com.obric.matrix.common;

import android.content.Context;
import com.bytedance.mobsec.metasec.ml.d;
import com.obric.matrix.account_api.OAccount;
import com.obric.matrix.account_api.c;
import com.obric.matrix.common_api.IMetaSec;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/common/MetaSecImpl;", "Lcom/obric/matrix/common_api/IMetaSec;", "()V", "TAG", "", "teaTrackerListener", "com/obric/matrix/common/MetaSecImpl$teaTrackerListener$1", "Lcom/obric/matrix/common/MetaSecImpl$teaTrackerListener$1;", "init", "", "context", "Landroid/content/Context;", "updateDidAndInstallId", "updateXttToken", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MetaSecImpl implements IMetaSec {
    private final String TAG;
    private final b teaTrackerListener;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/common/MetaSecImpl$init$1", "Lcom/obric/matrix/account_api/IAccountStatusListener;", "onAccountInfoUpdate", "", "scene", "", "onLogin", "onLogout", "logoutScene", "", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaSecImpl f8908a;

        a(MetaSecImpl r1) {
            this.f8908a = r1;
        }

        @Override // com.obric.matrix.account_api.c
        public void e() {
            MetaSecImpl.access$updateXttToken(this.f8908a);
        }

        @Override // com.obric.matrix.account_api.c
        public void h(int r2) {
            com.bytedance.mobsec.metasec.ml.c r3 = d.a("508474");
            if (r3 == null) goto L6;
            MetaSecImpl r1 = this.f8908a;
            r3.c("logout");
            com.obric.matrix.r.c.c.j(MetaSecImpl.access$getTAG$p(r1), "onLogout");
            return;
        }

        @Override // com.obric.matrix.account_api.c
        public void j(String r2) {
            o.f(r2, "scene");
            if (o.a(r2, "xTTTokenUpdated") == false) goto L6;
            MetaSecImpl.access$updateXttToken(this.f8908a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/common/MetaSecImpl$teaTrackerListener$1", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "onDeviceIdLoaded", "", "did", "", "onInstallIdLoaded", "installId", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaSecImpl f8909a;

        b(MetaSecImpl r1) {
            this.f8909a = r1;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r1) {
            MetaSecImpl.access$updateDidAndInstallId(this.f8909a);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r1) {
            MetaSecImpl.access$updateDidAndInstallId(this.f8909a);
        }
    }

    public MetaSecImpl() {
        this.TAG = "MetaSecImpl";
        this.teaTrackerListener = new b(this);
    }

    public static final /* synthetic */ String access$getTAG$p(MetaSecImpl r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$updateDidAndInstallId(MetaSecImpl r0) {
        r0.updateDidAndInstallId();
    }

    public static final /* synthetic */ void access$updateXttToken(MetaSecImpl r0) {
        r0.updateXttToken();
    }

    private final void updateDidAndInstallId() {
        String r4 = com.obric.matrix.ostracker_api.b.c();
        String r0 = com.obric.matrix.ostracker_api.b.e();
        boolean r1 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L19;
        if (r0 != null) goto L12;
    L13:
        r1 = true;
    L14:
        if (r1 == true) goto L20;
        com.bytedance.mobsec.metasec.ml.c r2 = d.a("508474");
        if (r2 == null) goto L21;
        r2.e(r4);
        r2.b(r0);
        r2.c("did-iid-update");
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (r0.length() != 0) goto L14;
    L19:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final void updateXttToken() {
        com.bytedance.mobsec.metasec.ml.c r0 = d.a("508474");
        if (r0 == null) goto L6;
        String r1 = OAccount.INSTANCE.getAccountInfo().r();
        r0.d(r1);
        r0.c("login");
        com.obric.matrix.r.c.c.j(this.TAG, "updateXttToken token.length = " + r1.length());
        return;
    }

    @Override // com.obric.matrix.common_api.IMetaSec
    public void init(Context r7) {
        o.f(r7, "context");
        com.obric.matrix.r.c.c.j(this.TAG, "init");
        com.bytedance.mobsec.metasec.ml.b.a r0 = new com.bytedance.mobsec.metasec.ml.b.a("508474", "3LO9A4D6bIBZ0fDtdGqo2uJS4QPjYVVDKd1W+DLwRODngC9XVmw3wPZi6RDhF9Td5WU6Q5969el+LMw/+DRSHqbHqrZ+lJbYhTsrsfYWEPLAeLrkcvaZUH3pihkKnaL4tMYl457QuC9w7NHYcPw0E5Q9f2liSfMHCrFu2CouU6+e9vOw4NYYeiKlPNcTHUhbjJN3OQGprx7t21Rhwe21U7UgUABFU1pLYennmtoQz1y4vrBYrWmoD5xR0FBvgBK3AoGooPPCMXJ6uJzFzw6aOn4MR0cJ7t/BYipm77aLmSf4GqeS6HvYFZhQ2tT7IrwsFLUI2+MFJ35zQcyWwGmxJJjsTzUhOnasE92ZCdsG2bn/JSV624+afQ1GchdSF+xZxwPK8Q==");
        String r1 = com.obric.matrix.ostracker_api.b.c();
        String r2 = com.obric.matrix.ostracker_api.b.e();
        boolean r3 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L17;
        if (r2 != null) goto L12;
    L15:
        if (r3 == true) goto L17;
        r0.i(r1);
        r0.j(r2);
        goto L17
    L12:
        if (r2.length() == 0) goto L15;
        r3 = false;
    L17:
        r0.h(0);
        d.b(r7, r0.g());
        com.obric.matrix.ostracker_api.b.a(this.teaTrackerListener);
        OAccount r8 = OAccount.INSTANCE;
        if (r8.getAccountInfo().f() == false) goto L20;
        updateXttToken();
    L20:
        r8.addAccountStatusListener(new a(this));
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r5 = false;
        goto L9
    }
}
