package com.bytedance.securityserver.sdid;

import a.a;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.api.ISecretAddResult;
import com.bytedance.securityserver.adapter.api.ISecretData;
import com.bytedance.securityserver.adapter.api.ISecretDataManager;
import com.bytedance.securityserver.adapter.api.ISecretQueryResult;
import com.bytedance.securityserver.utils.GlobalContext;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class OAIDStore {
    public static volatile OAIDStore b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f62a;

    public static String a() {
        byte[] r0 = new byte[32];
        new SecureRandom().nextBytes(r0);
        String r1 = Build.getSerial();
        if (EnvironmentCompat.MEDIA_UNKNOWN.equals(r1) == false) goto L6;
        r1 = "";
    L6:
        if (r1 != null) goto L8;
    L30:
        Log.e("SecurityServer-OAIDStore", "get sn failed!");
        return null;
    L8:
        if (r1.isEmpty() == true) goto L30;
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Exception -> L28
        Charset r5 = StandardCharsets.UTF_8;     // Catch: Throwable -> L22
        r4.write(r1.getBytes(r5));     // Catch: Throwable -> L22
        r4.write(r0);     // Catch: Throwable -> L22
        r4.write("OAID_GENERATE_PARAM".getBytes(r5));     // Catch: Throwable -> L22
        byte[] r2 = r4.toByteArray();     // Catch: Throwable -> L22
        int r6 = 0;
        MessageDigest r3 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L15 Throwable -> L22
        r3.update(r2);     // Catch: Exception -> L15 Throwable -> L22
        byte[] r7 = r3.digest();     // Catch: Exception -> L15 Throwable -> L22
    L16:
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L22
        int r9 = r7.length;     // Catch: Throwable -> L22
    L17:
        if (r6 >= r9) goto L19;
        r8.append(String.format("%02x", new Object[]{Byte.valueOf(r7[r6])}));     // Catch: Throwable -> L22
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        String r10 = r8.toString();     // Catch: Throwable -> L22
        r4.close();     // Catch: Exception -> L28
        return r10;
    L15:
        Log.e("SecurityServer-CryptoUtils", "SHA256 failed.");     // Catch: Throwable -> L22
        r7 = new byte[0];     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Exception -> L28
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L28
    L28:
        Log.e("SecurityServer-OAIDStore", "generateOAID failed");
        return null;
    }

    public static OAIDStore b() {
        if (b != null) goto L16;
        monitor-enter(OAIDStore.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L11;
        OAIDStore r1 = new OAIDStore();     // Catch: Throwable -> L9
        r1.f62a = null;     // Catch: Throwable -> L9
        b = r1;     // Catch: Throwable -> L9
    L11:
        monitor-exit(OAIDStore.class);     // Catch: Throwable -> L9
    L16:
        return b;
    }

    public final String c() {
        if (this.f62a != null) goto L5;
    L6:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f62a != null) goto L10;
    L14:
        this.f62a = d(GlobalContext.f82a);     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);     // Catch: Throwable -> L12
    L17:
        if (this.f62a != null) goto L19;
    L22:
        Log.e("SecurityServer-OAIDStore", "Get OAID failed!!");
        throw new SDIDException(-4, "Get OAID failed");
    L19:
        if (this.f62a.isEmpty() == true) goto L22;
        return this.f62a;
    L10:
        if (this.f62a.isEmpty() == false) goto L15;
    L5:
        if (this.f62a.isEmpty() == false) goto L17;
        goto L6
    }

    public final String d(Context r8) {
        String r0 = null;
        if (r8 != null) goto L6;
        Log.e("SecurityServer-OAIDStore", "context is null");
        return null;
    L6:
        Bundle r2 = new Bundle();
        int r4 = 0;
        r2.putInt("query_mode", 0);
        ISecretDataManager r5 = SecurityLibFactory.a();
        if (r5 != null) goto L9;
        Log.w("SecurityServer-OAIDStore", "SecretDataManager unavailable, treat OAID as not exist");
    L34:
        Log.i("SecurityServer-OAIDStore", "OAID not exist, generating new one...");
        String r9 = a();
        if (r9 != null) goto L37;
    L56:
        Log.e("SecurityServer-OAIDStore", "generateOAID failed.");
        throw new SDIDException(-6, "generate OAID failed");
    L37:
        if (r9.isEmpty() == true) goto L56;
        if (r9.isEmpty() == false) goto L41;
        Log.e("SecurityServer-OAIDStore", "input oaid is null");
        r4 = -2;
    L52:
        if (r4 != 0) goto L54;
        return r9;
    L54:
        Log.e("SecurityServer-OAIDStore", "saveOAID failed, code=" + r4);
        throw new SDIDException(r4, a.e(r4, "saveOAID failed, code="));
    L41:
        ISecretDataManager r1 = SecurityLibFactory.a();
        if (r1 != null) goto L45;
        Log.e("SecurityServer-OAIDStore", "SecretDataManager unavailable in saveOAID");
    L44:
        r4 = -8;
        goto L52
    L45:
        ISecretData r3 = r1.a();
        r3.a(r9);
        r3.b();
        r3.d();
        ISecretAddResult r6 = r1.c(GlobalContext.f82a, r3, new Bundle());
        if (r6 != null) goto L48;
    L51:
        Log.e("SecurityServer-OAIDStore", "Store oaid  failed!!");
        goto L44
    L48:
        if (r6.a() != 0) goto L51;
        this.f62a = r9;
        goto L52
    L9:
        ISecretQueryResult r7 = r5.b(r8, r2);
        if (r7 == null) goto L34;
        if (r7.a() != 0) goto L34;
        Bundle r10 = new Bundle();
        r10.putInt("query_mode", 2);
        ISecretDataManager r11 = SecurityLibFactory.a();
        if (r11 != null) goto L16;
        Log.e("SecurityServer-OAIDStore", "SecretDataManager unavailable");
    L28:
        if (r0 != null) goto L30;
    L32:
        Log.e("SecurityServer-OAIDStore", "OAID exists but query failed!");
        throw new SDIDException(-5, "OAID exists but query failed");
    L30:
        if (r0.isEmpty() == true) goto L32;
        return r0;
    L16:
        ISecretQueryResult r12 = r11.b(r8, r10);
        if (r12 != null) goto L19;
    L27:
        Log.e("SecurityServer-OAIDStore", "Query OAID failed!!");
        goto L28
    L19:
        if (r12.a() != 0) goto L27;
        ArrayList r13 = r12.b();
        if (r13 == null) goto L28;
        if (r13.isEmpty() == true) goto L28;
        r0 = ((ISecretData) r13.get(0)).c();
        goto L28
    }

    public final void e() {
        String r1 = a();
        if (r1 != null) goto L5;
    L22:
        Log.e("SecurityServer-OAIDStore", "input new oaid is null");
        throw new SDIDException(-6, "generate OAID failed");
    L5:
        if (r1.isEmpty() == true) goto L22;
        monitor-enter(this);
        ISecretDataManager r2 = SecurityLibFactory.a();     // Catch: Throwable -> L14
        if (r2 == null) goto L18;
        ISecretData r4 = r2.a();     // Catch: Throwable -> L14
        r4.b();     // Catch: Throwable -> L14
        r4.a(r1);     // Catch: Throwable -> L14
        int r3 = r2.d(GlobalContext.f82a, r4, new Bundle());     // Catch: Throwable -> L14
        if (r3 != 0) goto L16;
        this.f62a = r1;     // Catch: Throwable -> L14
        Log.i("SecurityServer-OAIDStore", "resetOAID success!");     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L16:
        Log.e("SecurityServer-OAIDStore", "reset oaid failed!!");     // Catch: Throwable -> L14
        throw new SDIDException(-9, "reset oaid failed, code=" + r3);     // Catch: Throwable -> L14
    L18:
        Log.e("SecurityServer-OAIDStore", "SecretDataManager unavailable in resetOAID");     // Catch: Throwable -> L14
        throw new SDIDException(-9, "secret data manager unavailable");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
