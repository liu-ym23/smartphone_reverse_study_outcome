package com.obric.matrix.account.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.matrix.account.p.b;
import com.obric.matrix.r.c.c;
import com.obric.matrix.r.c.e;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016JO\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001dJ;\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u001f¨\u0006!"}, d2 = {"Lcom/obric/matrix/account/provider/OAccountProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "ensureTTNetInit", "", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OAccountProvider extends ContentProvider {
    static {
    }

    public OAccountProvider() {
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r30, String r31, Bundle r32) {
        o.f(r30, "method");
        String r2 = getCallingPackage();
        int r3 = Binder.getCallingUid();
        c.b("OAccountProvider", "onCall:packageName:" + r2 + " method " + r30 + " uid:" + r3 + " t:" + Thread.currentThread().getName());
        if (com.obric.matrix.q.a.a.f9829a.f(getContext(), r3, r2) == true) goto L7;
        c.b("OAccountProvider", "query isAuth failed callPkg = " + r2 + ", uid = " + r3);
        return a.f8611a.a(-1000);
    L7:
        if (b.f8600a.k() == false) goto L9;
    L11:
        if (r2 != null) goto L14;
        r2 = "unknownPkgName";
    L14:
        switch(r30.hashCode()) {
            case -1977687120: goto L58;
            case 225561413: goto L40;
            case 974078489: goto L22;
            case 1803005551: goto L17;
            default: goto L70;
        };
    L17:
        if (r30.equals("getMatrixVersionInfo") == false) goto L70;
        Bundle r0 = new Bundle();
        r0.putInt("supportSecureAccountStatusListener", 1);
        return r0;
    L22:
        if (r30.equals("getTokenMap") == false) goto L70;
        com.obric.matrix.account.q.b r1 = com.obric.matrix.account.q.b.a();
        if (r1 == null) goto L71;
        r1.i("getTokenMap", r2);
    L71:
        v.a r4 = v.f21457g;     // Catch: Throwable -> L29
        Bundle r5 = new Bundle();     // Catch: Throwable -> L29
        r5.putSerializable("tokenMap", (Serializable) com.obric.matrix.account.a.f8438a.n());     // Catch: Throwable -> L29
        v.b(r5);     // Catch: Throwable -> L29
        Object r6 = r5;
    L31:
        Throwable r7 = v.d(r6);
        if (r7 == null) goto L34;
        c.g("OAccountProvider", "getTokenMap failed", r7);
    L34:
        Bundle r8 = new Bundle();
        boolean r9 = v.f(r6);
        Object r10 = r6;
        if (r9 == false) goto L38;
        r10 = r8;
    L38:
        return (Bundle) r10;
    L29:
        th = move-exception;
        v.a r11 = v.f21457g;
        Object r12 = w.a(th);
        v.b(r12);
        r6 = r12;
        goto L31
    L40:
        if (r30.equals("getAccountInfo") == false) goto L70;
        com.obric.matrix.account.q.b r13 = com.obric.matrix.account.q.b.a();
        if (r13 == null) goto L73;
        r13.i("getAccountInfo", r2);
    L73:
        v.a r14 = v.f21457g;     // Catch: Throwable -> L47
        com.obric.matrix.account_api.a r15 = com.obric.matrix.account.a.f8438a.b();     // Catch: Throwable -> L47
        c.j("OAccountProvider", "getAccountInfo isLogin = " + r15.f() + " secUid = " + k.K0(r15.k(), 4) + " uid=" + k.K0(r15.n(), 4));     // Catch: Throwable -> L47
        e.d("OAccountProvider", "getAccountInfo loginPhoneNumber = " + r15.e() + ", loginUtcTime = " + r15.g() + ", userMobile = " + r15.o());     // Catch: Throwable -> L47
        v.b(r15);     // Catch: Throwable -> L47
        Object r16 = r15;
    L49:
        Throwable r17 = v.d(r16);
        if (r17 == null) goto L52;
        c.g("OAccountProvider", "getAccountInfo failed", r17);
    L52:
        com.obric.matrix.account_api.a r18 = new com.obric.matrix.account_api.a(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
        boolean r19 = v.f(r16);
        Object r20 = r16;
        if (r19 == false) goto L56;
        r20 = r18;
    L56:
        return com.obric.matrix.account_api.b.a((com.obric.matrix.account_api.a) r20);
    L47:
        th = move-exception;
        v.a r21 = v.f21457g;
        Object r22 = w.a(th);
        v.b(r22);
        r16 = r22;
        goto L49
    L58:
        if (r30.equals("setLoginPhoneNumber") == false) goto L70;
        if (r32 == null) goto L62;
        String r23 = r32.getString("phoneNumber");
    L64:
        if (r23 != null) goto L67;
        Bundle r24 = new Bundle();
        r24.putInt("setLoginPhoneNumberResult", -1);
        return r24;
    L67:
        StringBuilder r25 = new StringBuilder();
        r25.append("setLoginPhoneNumber ");
        r25.append(r2);
        r25.append(" before=");
        com.obric.matrix.account.a r26 = com.obric.matrix.account.a.f8438a;
        r25.append(r26.h());
        r25.append(", after=");
        r25.append(r23);
        e.d("OAccountProvider", r25.toString());
        r26.y(r23);
        Bundle r27 = new Bundle();
        r27.putInt("setLoginPhoneNumberResult", 0);
        return r27;
    L62:
        r23 = null;
    L70:
        return a.f8611a.c();
    L9:
        if (com.obric.matrix.r.b.f9910a.d() == false) goto L11;
        Log.d("OAccountProvider", "onCall:initAccountTask");
        com.obric.matrix.account.o.a.f8592a.a();
        goto L11
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        o.f(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        c.b("OAccountProvider", "onCreate " + getCallingPackage());
        com.obric.matrix.r.b r0 = com.obric.matrix.r.b.f9910a;
        if (r0.d() == false) goto L5;
    L6:
        Log.d("OAccountProvider", "onCreate initPre");
        b r1 = b.f8600a;
        Context r3 = getContext();
        o.c(r3);
        r1.n(r3);
        return true;
    L5:
        if (r0.f() == true) goto L6;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        o.f(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        o.f(r1, "uri");
        return 0;
    }
}
