package com.facebook.soloader;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends m {

    static /* synthetic */ class a {
    }

    private final class b extends m.f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c[] f6811f;

        private final class a extends m.e {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f6812f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f6813g;

            private a(b r1) {
                this.f6813g = r1;
            }

            /* synthetic */ a(b r1, a r2) {
                this(r1);
            }

            @Override // com.facebook.soloader.m.e
            public boolean a() {
                if (this.f6812f >= b.g(this.f6813g).length) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.facebook.soloader.m.e
            public m.d b() {
                c[] r0 = b.g(this.f6813g);
                int r1 = this.f6812f;
                this.f6812f = r1 + 1;
                c r3 = r0[r1];
                FileInputStream r2 = new FileInputStream(r3.f6814h);
                return new m.d(r3, r2);
            L5:
                th = move-exception;
                r2.close();
                throw th;
            }
        }

        b(e r17, m r18) {
            File r1 = new File("/data/local/tmp/exopackage/" + r17.f6827c.getPackageName() + "/native-libs/");
            ArrayList r0 = new ArrayList();
            LinkedHashSet r2 = new LinkedHashSet();
            String[] r3 = SysUtil.g();
            int r4 = r3.length;
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L55;
            String r7 = r3[r6];
            File r8 = new File(r1, r7);
            if (r8.isDirectory() == false) goto L33;
            r2.add(r7);
            File r9 = new File(r8, "metadata.txt");
            if (r9.isFile() == false) goto L33;
            FileReader r10 = new FileReader(r9);
            BufferedReader r11 = new BufferedReader(r10);     // Catch: Throwable -> L45
        L60:
            String r12 = r11.readLine();     // Catch: Throwable -> L34
            if (r12 == null) goto L31;
            if (r12.length() == 0) goto L60;
            int r13 = r12.indexOf(32);     // Catch: Throwable -> L34
            if (r13 == (-1)) goto L30;
            String r14 = r12.substring(0, r13) + ".so";     // Catch: Throwable -> L34
            int r15 = r0.size();     // Catch: Throwable -> L34
            int r16 = 0;
        L20:
            if (r16 >= r15) goto L25;
            if (((c) r0.get(r16)).f6836f.equals(r14) == true) goto L23;
            r16 = r16 + 1;     // Catch: Throwable -> L34
            goto L20
        L23:
            boolean r19 = true;
        L26:
            if (r19 == true) goto L60;
            String r110 = r12.substring(r13 + 1);     // Catch: Throwable -> L34
            r0.add(new c(r14, r110, new File(r8, r110)));     // Catch: Throwable -> L34
            goto L60
        L25:
            r19 = false;
            goto L26
        L30:
            throw new RuntimeException("illegal line in exopackage metadata: [" + r12 + "]");     // Catch: Throwable -> L34
        L31:
            r11.close();     // Catch: Throwable -> L45
            r10.close();
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            r11.close();     // Catch: Throwable -> L41
        L84:
            throw th;     // Catch: Throwable -> L45
        L41:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L45
            throw th;     // Catch: Throwable -> L45
        L45:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L52
            throw th;
        L52:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L33:
            r6 = r6 + 1;
            goto L3
        L55:
            r18.p((String[]) r2.toArray(new String[r2.size()]));
            this.f6811f = (c[]) r0.toArray(new c[r0.size()]);
        }

        static /* synthetic */ c[] g(b r0) {
            return r0.f6811f;
        }

        @Override // com.facebook.soloader.m.f
        protected m.c a() {
            return new m.c(this.f6811f);
        }

        @Override // com.facebook.soloader.m.f
        protected m.e b() {
            return new a(this, null);
        }
    }

    private static final class c extends m.b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final File f6814h;

        c(String r1, String r2, File r3) {
            super(r1, r2);
            this.f6814h = r3;
        }
    }

    public e(Context r1, String r2) {
        super(r1, r2);
    }

    @Override // com.facebook.soloader.m
    protected m.f l() {
        return new b(this, this);
    }
}
