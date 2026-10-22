package com.obric.matrix.opush.g;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.i0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\"\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/opush/utils/AppSignatureCache;", "", "()V", "signatureCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "encryptionFingerprint", "byteStr", "", "algorithm", "getSignatureFingerprint", "context", "Landroid/content/Context;", "packageName", "getSignatureSHA1", "getSignatureSHA256", "readSignatureFromPackageManager", "removeSignature", "", "updateSignature", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f9425b = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements l<Byte, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9426f = null;

        static {
            f9426f = new a();
        }

        a() {
            super(1);
        }

        public final CharSequence a(byte r3) {
            i0 r2 = i0.f18445a;
            String r4 = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            o.e(r4, "format(format, *args)");
            String r5 = r4.toUpperCase(Locale.ROOT);
            o.e(r5, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return r5;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte r1) {
            return a(r1.byteValue());
        }
    }

    static {
        f9424a = new b();
        f9425b = new ConcurrentHashMap();
    }

    private b() {
    }

    private final String a(byte[] r10, String r11) {
        if (r10 != null) goto L8;
        return "";
    L8:
        MessageDigest r12 = MessageDigest.getInstance(r11);     // Catch: Throwable -> L7
        r12.reset();     // Catch: Throwable -> L7
        r12.update(r10);     // Catch: Throwable -> L7
        byte[] r0 = r12.digest();     // Catch: Throwable -> L7
        o.e(r0, "byteArray");     // Catch: Throwable -> L7
        return i.L(r0, ":", null, null, 0, null, a.f9426f, 30, null);
    L10:
        return "";
    }

    private final String b(Context r4, String r5, String r6) {
        if (r4 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r5) == true) goto L18;
        String r0 = r5 + ':' + r6;
        ConcurrentHashMap<String, String> r1 = f9425b;
        String r2 = r1.get(r0);
        if (r2 == null) goto L9;
        return r2;
    L9:
        String r3 = d(r4, r5, r6);
        if (r3.length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L15;
        r1.put(r0, r3);
    L15:
        return r3;
    L12:
        r7 = false;
        goto L13
    L18:
        return "";
    }

    private final String d(Context r7, String r8, String r9) {
        PackageManager r10 = r7.getPackageManager();
        if (r10 != null) goto L5;
        return "";
    L5:
        byte[] r1 = null;
        SigningInfo r2 = r10.getPackageInfo(r8, 134217728).signingInfo;     // Catch: Throwable -> L31
        if (r2 != null) goto L9;
    L19:
        if (r1 != null) goto L29;
        Signature[] r11 = r10.getPackageInfo(r8, 64).signatures;     // Catch: Throwable -> L31
        if (r11 == null) goto L29;
        if (r11.length != 0) goto L25;
        boolean r12 = true;
    L27:
        if ((!r12) == false) goto L29;
        r1 = r11[0].toByteArray();     // Catch: Throwable -> L31
        goto L29
    L25:
        r12 = false;
    L29:
        return a(r1, r9);
    L9:
        if (r2.getApkContentsSigners() == null) goto L19;
        Signature[] r3 = r2.getApkContentsSigners();     // Catch: Throwable -> L31
        if (r3 == null) goto L19;
        if (r3.length != 0) goto L15;
        boolean r5 = true;
    L17:
        if ((!r5) == false) goto L19;
        r1 = r3[0].toByteArray();     // Catch: Throwable -> L31
        goto L19
    L15:
        r5 = false;
    L31:
        return "";
    }

    public final String c(Context r2, String r3) {
        o.f(r3, "packageName");
        return b(r2, r3, "SHA-256");
    }

    public final void e(String r6) {
        o.f(r6, "packageName");
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return;
    L5:
        Iterator<String> r5 = f9425b.keySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        String r0 = r5.next();
        o.e(r0, "iterator.next()");
        if (k.A(r0, r6 + ':', false, 2, null) == false) goto L7;
        r5.remove();
        goto L7
    }

    public final void f(Context r10, String r11) {
        o.f(r11, "packageName");
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L43;
        Set<String> r0 = f9425b.keySet();
        o.e(r0, "signatureCache.keys");
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        String r8 = (String) r3;
        o.e(r8, "it");
        if (k.A(r8, r11 + ':', false, 2, null) == false) goto L9;
        r1.add(r3);
        goto L9
    L13:
        ArrayList r4 = new ArrayList(r.q(r1, 10));
        Iterator r5 = r1.iterator();
    L15:
        if (r5.hasNext() == false) goto L18;
        String r6 = (String) r5.next();
        o.e(r6, "it");
        r4.add(k.y0(r6, ":", null, 2, null));
        goto L15
    L18:
        if (r4.isEmpty() == false) goto L20;
        return;
    L20:
        Iterator r7 = r4.iterator();
    L22:
        if (r7.hasNext() == false) goto L44;
        String r9 = (String) r7.next();
        String r12 = d(r10, r11, r9);
        String r13 = r11 + ':' + r9;
        if (r12.length() <= 0) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == true) goto L28;
        f9425b.remove(r13);
        goto L22
    L28:
        f9425b.put(r13, r12);
        goto L22
    L26:
        r14 = false;
        goto L27
    L44:
        return;
    }
}
