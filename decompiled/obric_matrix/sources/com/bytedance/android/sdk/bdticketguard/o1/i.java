package com.bytedance.android.sdk.bdticketguard.o1;

import android.util.Base64;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Arrays;
import kotlin.n0.d.o;
import net.bytedance.zdplib.Delta;

/* JADX INFO: loaded from: classes.dex */
public final class i extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f965e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KeyPair f966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f968d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final String a(ECPublicKey r4) {
            o.g(r4, "ecPublicKey");
            ECPoint r3 = r4.getW();
            o.b(r3, "point");
            byte[] r5 = r3.getAffineX().toByteArray();
            byte[] r6 = r3.getAffineY().toByteArray();
            if (r5[0] != 0) goto L6;
            r5 = Arrays.copyOfRange(r5, 1, r5.length);
        L6:
            if (r6[0] != 0) goto L9;
            r6 = Arrays.copyOfRange(r6, 1, r6.length);
        L9:
            return "04" + Delta.d(r5) + Delta.d(r6);
        }

        public final String b(ECPublicKey r2, int r3) {
            o.g(r2, "ecPublicKey");
            String r1 = Base64.encodeToString(Delta.e(a(r2)), r3);
            o.b(r1, "Base64.encodeToString(De…Array(pub04), encodeFlag)");
            return r1;
        }
    }

    static {
        f965e = new a(null);
    }

    public i(boolean r2, KeyPair r3, String r4, String r5) {
        o.g(r3, "keyPair");
        super(r2, null);
        this.f966b = r3;
        this.f967c = r4;
        this.f968d = r5;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.c
    public boolean b() {
        String r0 = this.f967c;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L19;
        String r3 = this.f968d;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L19;
        return false;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L19:
        return true;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String c() {
        return this.f968d;
    }

    public final String d() {
        return this.f967c;
    }

    public final KeyPair e() {
        return this.f966b;
    }

    public String f(int r2) {
        PublicKey r1 = this.f966b.getPublic();
        if ((r1 instanceof ECPublicKey) == true) goto L5;
        r1 = null;
    L5:
        ECPublicKey r3 = (ECPublicKey) r1;
        if (r3 == null) goto L10;
        String r4 = f965e.b(r3, r2);
        if (r4 == null) goto L10;
        return r4;
    L10:
        return "";
    }

    public final void g(String r1) {
        this.f968d = r1;
    }

    public final void h(String r1) {
        this.f967c = r1;
    }
}
