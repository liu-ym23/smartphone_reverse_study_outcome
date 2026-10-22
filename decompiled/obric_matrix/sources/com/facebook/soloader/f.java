package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class f extends m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final File f6815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final String f6816g;

    static /* synthetic */ class a {
    }

    private static final class b extends m.b implements Comparable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ZipEntry f6817h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f6818i;

        b(String r2, ZipEntry r3, int r4) {
            super(r2, a(r3));
            this.f6817h = r3;
            this.f6818i = r4;
        }

        private static String a(ZipEntry r3) {
            return String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[]{r3.getName(), Long.valueOf(r3.getSize()), Long.valueOf(r3.getCompressedSize()), Long.valueOf(r3.getCrc())});
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r1) {
            return this.f6836f.compareTo(((b) r1).f6836f);
        }
    }

    protected class c extends m.f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private b[] f6819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ZipFile f6820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final m f6821h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f6822i;

        private final class a extends m.e {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f6823f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f6824g;

            private a(c r1) {
                this.f6824g = r1;
            }

            /* synthetic */ a(c r1, a r2) {
                this(r1);
            }

            @Override // com.facebook.soloader.m.e
            public boolean a() {
                this.f6824g.s();
                if (this.f6823f >= c.g(this.f6824g).length) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.facebook.soloader.m.e
            public m.d b() {
                this.f6824g.s();
                b[] r0 = c.g(this.f6824g);
                int r1 = this.f6823f;
                this.f6823f = r1 + 1;
                b r2 = r0[r1];
                InputStream r3 = c.l(this.f6824g).getInputStream(r2.f6817h);
                return new m.d(r2, r3);
            L5:
                th = move-exception;
                if (r3 == null) goto L8;
                r3.close();
            L8:
                throw th;
            }
        }

        c(f r2, m r3) {
            this.f6822i = r2;
            this.f6820g = new ZipFile(r2.f6815f);
            this.f6821h = r3;
        }

        static /* synthetic */ b[] g(c r0) {
            return r0.f6819f;
        }

        static /* synthetic */ ZipFile l(c r0) {
            return r0.f6820g;
        }

        @Override // com.facebook.soloader.m.f
        protected final m.c a() {
            return new m.c(s());
        }

        @Override // com.facebook.soloader.m.f
        protected final m.e b() {
            return new a(this, null);
        }

        @Override // com.facebook.soloader.m.f, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6820g.close();
        }

        final b[] s() {
            if (this.f6819f != null) goto L33;
            LinkedHashSet r0 = new LinkedHashSet();
            HashMap r1 = new HashMap();
            Pattern r2 = Pattern.compile(this.f6822i.f6816g);
            String[] r3 = SysUtil.g();
            Enumeration<? extends ZipEntry> r4 = this.f6820g.entries();
        L6:
            if (r4.hasMoreElements() == false) goto L16;
            ZipEntry r5 = r4.nextElement();
            Matcher r6 = r2.matcher(r5.getName());
            if (r6.matches() == false) goto L6;
            String r7 = r6.group(1);
            String r8 = r6.group(2);
            int r9 = SysUtil.d(r3, r7);
            if (r9 < 0) goto L6;
            r0.add(r7);
            b r10 = (b) r1.get(r8);
            if (r10 == null) goto L15;
            if (r9 >= r10.f6818i) goto L6;
        L15:
            r1.put(r8, new b(r8, r5, r9));
            goto L6
        L16:
            this.f6821h.p((String[]) r0.toArray(new String[r0.size()]));
            b[] r11 = (b[]) r1.values().toArray(new b[r1.size()]);
            Arrays.sort(r11);
            int r12 = 0;
            int r13 = 0;
            int r14 = 0;
        L18:
            if (r13 >= r11.length) goto L24;
            b r15 = r11[r13];
            if (x(r15.f6817h, r15.f6836f) == false) goto L22;
            r14 = r14 + 1;
        L23:
            r13 = r13 + 1;
            goto L18
        L22:
            r11[r13] = null;
            goto L23
        L24:
            b[] r16 = new b[r14];
            int r17 = 0;
        L26:
            if (r12 >= r11.length) goto L31;
            b r18 = r11[r12];
            if (r18 == null) goto L30;
            r16[r17] = r18;
            r17 = r17 + 1;
        L30:
            r12 = r12 + 1;
            goto L26
        L31:
            this.f6819f = r16;
        L33:
            return this.f6819f;
        }

        protected boolean x(ZipEntry r1, String r2) {
            throw null;
        }
    }

    public f(Context r1, String r2, File r3, String r4) {
        super(r1, r2);
        this.f6815f = r3;
        this.f6816g = r4;
    }
}
