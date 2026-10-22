package com.bytedance.privacy.pcc;

import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.google.gson.Gson;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class EncryptedPayloadTlv {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Gson f5372e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("meta_info")
    public f f5373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("key_envelope")
    public e f5374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("content_info_meta")
    public c f5375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("sign_content_info")
    public h f5376d;

    private static final class ByteArrayBase64Adapter implements r<byte[]>, com.google.gson.i<byte[]> {
        private ByteArrayBase64Adapter() {
        }

        /* synthetic */ ByteArrayBase64Adapter(a r1) {
            this();
        }

        public byte[] a(com.google.gson.j r1, Type r2, com.google.gson.h r3) {
            return Base64.decode(r1.l(), 0);
        }

        public com.google.gson.j b(byte[] r1, Type r2, q r3) {
            return new p(Base64.encodeToString(r1, 2));
        }

        @Override // com.google.gson.i
        public /* bridge */ /* synthetic */ byte[] deserialize(com.google.gson.j r1, Type r2, com.google.gson.h r3) {
            return a(r1, r2, r3);
        }

        @Override // com.google.gson.r
        public /* bridge */ /* synthetic */ com.google.gson.j serialize(byte[] r1, Type r2, q r3) {
            return b(r1, r2, r3);
        }
    }

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c(IBdInstall.PARAM_APP_ID)
        public String f5377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("app_svc_id")
        public String f5378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("biz_type")
        public int f5379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("session_key_id")
        public byte[] f5380d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @com.google.gson.y.c("access_token")
        public byte[] f5381e;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("content_type")
        public int f5382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("content_encryption_algorithm")
        public int f5383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("other_key_attribute")
        public g f5384c;

        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("index")
        public int f5385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("key_identify")
        public byte[] f5386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("key_version")
        public int f5387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("key_encryption_algorithm")
        public int f5388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @com.google.gson.y.c("dh_pk")
        public byte[] f5389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @com.google.gson.y.c("salt")
        public byte[] f5390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @com.google.gson.y.c("encrypted_session_key")
        public byte[] f5391g;

        public d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("version")
        public int f5392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("envelope_type")
        public int f5393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("key_envelope_list_size")
        public int f5394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @com.google.gson.y.c("key_envelope_list")
        public List<d> f5395d;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("version")
        public int f5396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("content_type")
        public int f5397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("biz_attribute")
        public b f5398c;

        public f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("nonce")
        public byte[] f5399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("chunk_size")
        public int f5400b;

        public g() {
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("signature_algorithm")
        public int f5401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("content_signature")
        public byte[] f5402b;

        public h() {
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f5403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5404b;

        i(byte[] r1) {
            this.f5403a = r1;
            this.f5404b = 0;
        }

        boolean a() {
            if (this.f5404b >= this.f5403a.length) goto L5;
            return true;
        L5:
            return false;
        }

        int b() {
            return this.f5404b;
        }

        int c() {
            int r0 = this.f5404b;
            int r1 = r0 + 4;
            byte[] r2 = this.f5403a;
            if (r1 > r2.length) goto L11;
            int r3 = ((((r2[r0] & 255) << 24) | ((r2[r0 + 1] & 255) << 16)) | ((r2[r0 + 2] & 255) << 8)) | (r2[r0 + 3] & 255);
            if (r3 < 0) goto L9;
            this.f5404b = r0 + 4;
            return r3;
        L9:
            throw new Exception("TLV length overflow at offset " + this.f5404b);
        L11:
            throw new Exception("TLV underflow reading length at offset " + this.f5404b);
        }

        int d() {
            int r0 = this.f5404b;
            int r1 = r0 + 2;
            byte[] r2 = this.f5403a;
            if (r1 > r2.length) goto L7;
            int r3 = ((r2[r0] & 255) << 8) | (r2[r0 + 1] & 255);
            this.f5404b = r0 + 2;
            return r3;
        L7:
            throw new Exception("TLV underflow reading tag at offset " + this.f5404b);
        }

        byte[] e(int r5) {
            int r0 = this.f5404b;
            int r1 = r0 + r5;
            byte[] r2 = this.f5403a;
            if (r1 > r2.length) goto L7;
            byte[] r3 = new byte[r5];
            System.arraycopy(r2, r0, r3, 0, r5);
            this.f5404b += r5;
            return r3;
        L7:
            throw new Exception("TLV underflow reading value: need " + r5 + " bytes at offset " + this.f5404b + " but only " + (this.f5403a.length - this.f5404b) + " remain");
        }
    }

    private static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteArrayOutputStream f5405a;

        private j() {
            this.f5405a = new ByteArrayOutputStream();
        }

        /* synthetic */ j(a r1) {
            this();
        }

        private void d(int r3) {
            this.f5405a.write((r3 >> 24) & 255);
            this.f5405a.write((r3 >> 16) & 255);
            this.f5405a.write((r3 >> 8) & 255);
            this.f5405a.write(r3 & 255);
        }

        private void e(int r3) {
            this.f5405a.write((r3 >> 8) & 255);
            this.f5405a.write(r3 & 255);
        }

        byte[] a() {
            return this.f5405a.toByteArray();
        }

        void b(int r2, byte[] r3) {
            e(r2);
            d(r3.length);
            this.f5405a.write(r3, 0, r3.length);
        }

        void c(int r2, byte[] r3) {
            e(r2);
            d(r3.length);
            this.f5405a.write(r3, 0, r3.length);
        }

        void f(int r2, int r3) {
            e(r2);
            d(2);
            this.f5405a.write((r3 >> 8) & 255);
            this.f5405a.write(r3 & 255);
        }

        void g(int r2, int r3) {
            e(r2);
            d(4);
            this.f5405a.write((r3 >> 24) & 255);
            this.f5405a.write((r3 >> 16) & 255);
            this.f5405a.write((r3 >> 8) & 255);
            this.f5405a.write(r3 & 255);
        }
    }

    static {
        com.google.gson.e r0 = new com.google.gson.e();
        r0.g(byte[].class, new ByteArrayBase64Adapter(null));
        r0.h();
        f5372e = r0.d();
    }

    public EncryptedPayloadTlv() {
    }

    public static EncryptedPayloadTlv a(byte[] r4) {
        EncryptedPayloadTlv r0 = new EncryptedPayloadTlv();
        i r1 = new i(r4);
    L4:
        if (r1.a() == false) goto L18;
        int r5 = r1.d();
        byte[] r2 = r1.e(r1.c());
        r1.b();
        if (r5 != 256) goto L8;
        r0.f5373a = g(r2);
        goto L4
    L8:
        if (r5 != 512) goto L10;
        r0.f5374b = f(r2);
        goto L4
    L10:
        if (r5 != 768) goto L12;
        r0.f5375c = c(r2);
        goto L4
    L12:
        if (r5 != 1024) goto L4;
        r0.f5376d = i(r2);
        goto L4
    L18:
        return r0;
    }

    private static b b(byte[] r4) {
        b r0 = new b();
        i r1 = new i(r4);
    L4:
        if (r1.a() == false) goto L21;
        int r5 = r1.d();
        byte[] r2 = r1.e(r1.c());
        if (r5 != 1) goto L8;
        r0.f5377a = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.f5378b = new String(r2, StandardCharsets.UTF_8);
        goto L4
    L10:
        if (r5 != 3) goto L12;
        r0.f5379c = s(r2);
        goto L4
    L12:
        if (r5 != 4) goto L14;
        r0.f5380d = r2;
        goto L4
    L14:
        if (r5 != 5) goto L4;
        r0.f5381e = r2;
        goto L4
    L21:
        return r0;
    }

    private static c c(byte[] r3) {
        c r0 = new c();
        i r1 = new i(r3);
    L4:
        if (r1.a() == false) goto L11;
        int r4 = r1.d();
        byte[] r2 = r1.e(r1.c());
        switch(r4) {
            case 769: goto L10;
            case 770: goto L9;
            case 771: goto L8;
            default: goto L4;
        };
    L8:
        r0.f5384c = h(r2);
        goto L4
    L9:
        r0.f5383b = s(r2);
        goto L4
    L10:
        r0.f5382a = s(r2);
        goto L4
    L11:
        return r0;
    }

    private static d d(byte[] r3) {
        d r0 = new d();
        i r1 = new i(r3);
    L4:
        if (r1.a() == false) goto L14;
        int r4 = r1.d();
        byte[] r2 = r1.e(r1.c());
        switch(r4) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L4;
        };
    L8:
        r0.f5391g = r2;
        goto L4
    L9:
        r0.f5390f = r2;
        goto L4
    L10:
        r0.f5389e = r2;
        goto L4
    L11:
        r0.f5388d = s(r2);
        goto L4
    L12:
        r0.f5387c = t(r2);
        goto L4
    L13:
        r0.f5386b = r2;
        goto L4
    L14:
        return r0;
    }

    private static void e(byte[] r2, List<d> r3) {
        i r0 = new i(r2);
    L4:
        if (r0.a() == false) goto L6;
        int r4 = r0.d();
        d r1 = d(r0.e(r0.c()));
        r1.f5385a = r4;
        r3.add(r1);
        goto L4
    }

    private static e f(byte[] r3) {
        e r0 = new e();
        r0.f5395d = new ArrayList();
        i r1 = new i(r3);
    L4:
        if (r1.a() == false) goto L12;
        int r4 = r1.d();
        byte[] r2 = r1.e(r1.c());
        switch(r4) {
            case 513: goto L11;
            case 514: goto L10;
            case 515: goto L9;
            case 516: goto L8;
            default: goto L4;
        };
    L8:
        e(r2, r0.f5395d);
        goto L4
    L9:
        r0.f5394c = t(r2);
        goto L4
    L10:
        r0.f5393b = s(r2);
        goto L4
    L11:
        r0.f5392a = s(r2);
        goto L4
    L12:
        return r0;
    }

    private static f g(byte[] r3) {
        f r0 = new f();
        i r1 = new i(r3);
    L4:
        if (r1.a() == false) goto L11;
        int r4 = r1.d();
        byte[] r2 = r1.e(r1.c());
        switch(r4) {
            case 257: goto L10;
            case 258: goto L9;
            case 259: goto L8;
            default: goto L4;
        };
    L8:
        r0.f5398c = b(r2);
        goto L4
    L9:
        r0.f5397b = s(r2);
        goto L4
    L10:
        r0.f5396a = s(r2);
        goto L4
    L11:
        return r0;
    }

    private static g h(byte[] r4) {
        g r0 = new g();
        i r1 = new i(r4);
    L4:
        if (r1.a() == false) goto L12;
        int r5 = r1.d();
        byte[] r2 = r1.e(r1.c());
        if (r5 != 1) goto L8;
        r0.f5399a = r2;
        goto L4
    L8:
        if (r5 != 2) goto L4;
        r0.f5400b = t(r2);
        goto L4
    L12:
        return r0;
    }

    private static h i(byte[] r4) {
        h r0 = new h();
        i r1 = new i(r4);
    L4:
        if (r1.a() == false) goto L12;
        int r5 = r1.d();
        byte[] r2 = r1.e(r1.c());
        if (r5 != 1025) goto L8;
        r0.f5401a = s(r2);
        goto L4
    L8:
        if (r5 != 1026) goto L4;
        r0.f5402b = r2;
        goto L4
    L12:
        return r0;
    }

    private static byte[] k(b r4) {
        j r0 = new j(null);
        String r1 = r4.f5377a;
        if (r1 == null) goto L5;
        r0.b(1, r1.getBytes(StandardCharsets.UTF_8));
    L5:
        String r2 = r4.f5378b;
        if (r2 == null) goto L8;
        r0.b(2, r2.getBytes(StandardCharsets.UTF_8));
    L8:
        r0.f(3, r4.f5379c);
        byte[] r3 = r4.f5380d;
        if (r3 == null) goto L11;
        r0.b(4, r3);
    L11:
        byte[] r5 = r4.f5381e;
        if (r5 == null) goto L15;
        r0.b(5, r5);
    L15:
        return r0.a();
    }

    private static byte[] l(c r3) {
        j r0 = new j(null);
        r0.f(769, r3.f5382a);
        r0.f(770, r3.f5383b);
        g r4 = r3.f5384c;
        if (r4 == null) goto L6;
        r0.c(771, p(r4));
    L6:
        return r0.a();
    }

    private static byte[] m(d r3) {
        j r0 = new j(null);
        byte[] r1 = r3.f5386b;
        if (r1 == null) goto L5;
        r0.b(1, r1);
    L5:
        r0.g(2, r3.f5387c);
        r0.f(3, r3.f5388d);
        byte[] r2 = r3.f5389e;
        if (r2 == null) goto L8;
        r0.b(4, r2);
    L8:
        byte[] r4 = r3.f5390f;
        if (r4 == null) goto L11;
        r0.b(5, r4);
    L11:
        byte[] r5 = r3.f5391g;
        if (r5 == null) goto L15;
        r0.b(6, r5);
    L15:
        return r0.a();
    }

    private static byte[] n(e r4) {
        a r1 = null;
        j r0 = new j(r1);
        r0.f(InputDeviceCompat.SOURCE_DPAD, r4.f5392a);
        r0.f(514, r4.f5393b);
        r0.g(515, r4.f5394c);
        List<d> r2 = r4.f5395d;
        if (r2 == null) goto L12;
        if (r2.isEmpty() == true) goto L12;
        j r3 = new j(r1);
        Iterator<d> r5 = r4.f5395d.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        d r6 = r5.next();
        r3.c(r6.f5385a, m(r6));
        goto L8
    L10:
        r0.c(516, r3.a());
    L12:
        return r0.a();
    }

    private static byte[] o(f r3) {
        j r0 = new j(null);
        r0.f(257, r3.f5396a);
        r0.f(258, r3.f5397b);
        b r4 = r3.f5398c;
        if (r4 == null) goto L6;
        r0.c(259, k(r4));
    L6:
        return r0.a();
    }

    private static byte[] p(g r3) {
        j r0 = new j(null);
        byte[] r1 = r3.f5399a;
        if (r1 == null) goto L5;
        r0.b(1, r1);
    L5:
        int r4 = r3.f5400b;
        if (r4 <= 0) goto L9;
        r0.g(2, r4);
    L9:
        return r0.a();
    }

    private static byte[] q(h r3) {
        j r0 = new j(null);
        r0.f(InputDeviceCompat.SOURCE_GAMEPAD, r3.f5401a);
        byte[] r4 = r3.f5402b;
        if (r4 == null) goto L6;
        r0.b(1026, r4);
    L6:
        return r0.a();
    }

    private static int s(byte[] r2) {
        int r0 = (r2[0] & 255) << 8;
        return (r2[1] & 255) | r0;
    }

    private static int t(byte[] r2) {
        int r0 = (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)) | ((r2[2] & 255) << 8);
        return (r2[3] & 255) | r0;
    }

    public byte[] j() {
        j r0 = new j(null);
        f r1 = this.f5373a;
        if (r1 == null) goto L5;
        r0.c(256, o(r1));
    L5:
        e r2 = this.f5374b;
        if (r2 == null) goto L8;
        r0.c(512, n(r2));
    L8:
        c r3 = this.f5375c;
        if (r3 == null) goto L11;
        r0.c(768, l(r3));
    L11:
        h r4 = this.f5376d;
        if (r4 == null) goto L15;
        r0.c(1024, q(r4));
    L15:
        return r0.a();
    }

    public byte[] r() {
        j r0 = new j(null);
        f r1 = this.f5373a;
        if (r1 == null) goto L5;
        r0.c(256, o(r1));
    L5:
        e r2 = this.f5374b;
        if (r2 == null) goto L8;
        r0.c(512, n(r2));
    L8:
        c r3 = this.f5375c;
        if (r3 == null) goto L12;
        r0.c(768, l(r3));
    L12:
        return r0.a();
    }

    public String u() {
        return f5372e.v(this);
    }
}
