package tmsdk.common.module.qscanner.impl;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.android.apksigner.CertInfoObject;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import tmsdkobf.d2;
import tmsdkobf.m;
import tmsdkobf.me;
import tmsdkobf.o3;
import tmsdkobf.qd;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f45a = null;
    private static o3 b;

    /* JADX INFO: renamed from: tmsdk.common.module.qscanner.impl.a$a, reason: collision with other inner class name */
    public static final class C0089a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f46a;
        private String b;
        private String c;
        private String d;
        private int e;
        private long f;
        private long g;
        private long h;
        private long i;
        private String j;
        private String k;
        private String l;
        private String m;
        private long n;
        private String o;

        public C0089a(boolean r4, String r5, String r6, String r7, int r8, long r9, long r11, long r13, long r15, String r17, String r18, String r19, String r20, long r21, String r23) {
            this.f46a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r11;
            this.h = r13;
            this.i = r15;
            this.j = r17;
            this.k = r18;
            this.l = r19;
            this.m = r20;
            this.n = r21;
            this.o = r23;
        }

        public final long a() {
            return this.i;
        }

        public final String b() {
            return this.l;
        }

        public final String c() {
            return this.j;
        }

        public final String d() {
            return this.k;
        }

        public final long e() {
            return this.n;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0089a) == true) goto L8;
            return false;
        L8:
            C0089a r9 = (C0089a) r8;
            if (this.f46a == r9.f46a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L30;
            return false;
        L30:
            if (this.h == r9.h) goto L33;
            return false;
        L33:
            if (this.i == r9.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
            return false;
        L48:
            if (this.n == r9.n) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.o, r9.o) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public final long g() {
            return this.h;
        }

        public final String h() {
            return this.m;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v31 */
        public int hashCode() {
            boolean r0 = this.f46a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            String r3 = this.b;
            int r4 = 0;
            if (r3 != null) goto L8;
            int r5 = 0;
        L9:
            int r6 = (r2 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L12;
            int r8 = 0;
        L13:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L16;
            int r11 = 0;
        L17:
            int r12 = (((((((((((r9 + r11) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31;
            String r13 = this.j;
            if (r13 != null) goto L20;
            int r14 = 0;
        L21:
            int r15 = (r12 + r14) * 31;
            String r16 = this.k;
            if (r16 != null) goto L24;
            int r17 = 0;
        L25:
            int r18 = (r15 + r17) * 31;
            String r19 = this.l;
            if (r19 != null) goto L28;
            int r20 = 0;
        L29:
            int r21 = (r18 + r20) * 31;
            String r22 = this.m;
            if (r22 != null) goto L32;
            int r23 = 0;
        L33:
            int r24 = (((r21 + r23) * 31) + Long.hashCode(this.n)) * 31;
            String r25 = this.o;
            if (r25 == null) goto L38;
            r4 = r25.hashCode();
        L38:
            return r24 + r4;
        L32:
            r23 = r22.hashCode();
            goto L33
        L28:
            r20 = r19.hashCode();
            goto L29
        L24:
            r17 = r16.hashCode();
            goto L25
        L20:
            r14 = r13.hashCode();
            goto L21
        L16:
            r11 = r10.hashCode();
            goto L17
        L12:
            r8 = r7.hashCode();
            goto L13
        L8:
            r5 = r3.hashCode();
            goto L9
        }

        public final String i() {
            return this.b;
        }

        public final String j() {
            return this.o;
        }

        public final String k() {
            return this.c;
        }

        public final long l() {
            return this.g;
        }

        public final int m() {
            return this.e;
        }

        public final String n() {
            return this.d;
        }

        public final boolean o() {
            return this.f46a;
        }

        public String toString() {
            return "CacheData(isApk=" + this.f46a + ", pkg=" + this.b + ", sourceDir=" + this.c + ", versionName=" + this.d + ", versionCode=" + this.e + ", installTime=" + this.f + ", updateTime=" + this.g + ", modifyTime=" + this.h + ", apkSize=" + this.i + ", certInfoMain=" + this.j + ", dexSha1=" + this.k + ", certInfoAll=" + this.l + ", others=" + this.m + ", hashTime=" + this.n + ", softInfo=" + this.o + ")";
        }
    }

    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f47a = null;

        static {
            f47a = new b();
        }

        b() {
            super(1);
        }

        public final CharSequence a(CertInfoObject r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return a.f45a.a(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((CertInfoObject) r1);
        }
    }

    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f48a = null;

        static {
            f48a = new c();
        }

        c() {
            super(1);
        }

        public final d2 a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return a.f45a.a(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((String) r1);
        }
    }

    static {
        f45a = new a();
        Object r0 = qd.a(9);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type meri.service.StorageService");
        o3 r1 = ((me) r0).a("QQSecureProvider");
        Intrinsics.checkNotNullExpressionValue(r1, "storageService.getDBServ…orageService.DB_QQSECURE)");
        b = r1;
    }

    private a() {
    }

    public final void a() {
    }

    public final String b(String r8) {
        Object r7 = null;
        if (r8 == null) goto L17;
        List r9 = StringsKt.split$default(r8, new String[]{"|"}, false, 0, 6, null);
        if (r9 == null) goto L18;
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        Object r0 = r10.next();
        if (((String) r0).length() <= 0) goto L8;
        r7 = r0;
    L13:
        return (String) r7;
    L18:
        return null;
    L17:
        return null;
    }

    public final String c(String r11) {
        if (r11 == null) goto L26;
        List r10 = StringsKt.split$default(r11, new String[]{";"}, false, 0, 6, null);
        if (r10 == null) goto L26;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        String r0 = (String) r13.next();
        d2 r1 = f45a.a(r0);
        if (r1 == null) goto L7;
        r12.add(r1);
        goto L7
    L11:
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r15 = r12.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        r14.add(((d2) r15.next()).f142a);
        goto L13
    L15:
        ArrayList r2 = new ArrayList();
        Iterator r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        Object r17 = r16.next();
        String r3 = (String) r17;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        if (r3.length() <= 0) goto L17;
        r2.add(r17);
        goto L17
    L21:
        String r18 = CollectionsKt.joinToString$default(r2, ";", null, null, 0, null, null, 62, null);
        if (r18 == null) goto L26;
        if (r18.length() <= 0) goto L26;
        return r18;
    L26:
        return null;
    }

    public final String d(String r7) {
        if (r7 == null) goto L10;
        List r6 = StringsKt.split$default(r7, new String[]{"|"}, false, 0, 6, null);
        if (r6 == null) goto L10;
        String r8 = (String) CollectionsKt.getOrNull(r6, 1);
        if (r8 == null) goto L10;
        if (r8.length() <= 0) goto L10;
        return r8;
    L10:
        return null;
    }

    public final C0089a a(m r25, tmsdk.common.module.qscanner.impl.b.e r26) {
        Intrinsics.checkNotNullParameter(r25, "app");
        Intrinsics.checkNotNullParameter(r26, "certData");
        return new C0089a(r25.r(), r25.k(), r25.a(), r25.p(), r25.q(), r25.i(), r25.o(), r25.j(), r25.m(), r26.f53a, r25.f(), r26.b, "", System.currentTimeMillis(), a(r25));
    }

    public final String a(m r13) {
        Object[] r12 = new Object[7];
        String r0 = null;
        if (r13 == null) goto L5;
        String r1 = r13.b();
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        int r3 = 0;
        r12[0] = r1;
        if (r13 != null) goto L12;
    L14:
        int r4 = 0;
    L15:
        r12[1] = Integer.valueOf(r4);
        if (r13 == null) goto L18;
        Integer r5 = Integer.valueOf(r13.n());
    L19:
        r12[2] = r5;
        if (r13 == null) goto L22;
        Long r6 = Long.valueOf(r13.m());
    L23:
        r12[3] = r6;
        if (r13 == null) goto L26;
        Long r7 = Long.valueOf(r13.j());
    L27:
        r12[4] = r7;
        if (r13 != null) goto L30;
    L32:
        r12[5] = Integer.valueOf(r3);
        if (r13 == null) goto L35;
        r0 = r13.k();
    L35:
        if (r0 == null) goto L38;
        r2 = r0;
    L38:
        r12[6] = r2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r12), ";", null, null, 0, null, null, 62, null);
    L30:
        if (r13.s() != true) goto L32;
        r3 = 1;
        goto L32
    L26:
        r7 = null;
        goto L27
    L22:
        r6 = null;
        goto L23
    L18:
        r5 = null;
        goto L19
    L12:
        if (r13.t() != true) goto L14;
        r4 = 1;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final String a(CertInfoObject r13) {
        String[] r12 = new String[5];
        String r0 = null;
        if (r13 == null) goto L5;
        String r1 = r13.getHash1();
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r12[0] = r1;
        if (r13 == null) goto L12;
        String r3 = r13.getHash2();
    L13:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r12[1] = r3;
        String r4 = "0";
        if (r13 == null) goto L19;
        String r5 = Long.valueOf(r13.getStartTime()).toString();
        if (r5 == null) goto L19;
    L20:
        r12[2] = r5;
        if (r13 == null) goto L26;
        String r6 = Long.valueOf(r13.getEndTime()).toString();
        if (r6 == null) goto L26;
        r4 = r6;
    L26:
        r12[3] = r4;
        if (r13 == null) goto L29;
        r0 = r13.getSignerVersion();
    L29:
        if (r0 == null) goto L32;
        r2 = r0;
    L32:
        r12[4] = r2;
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r12), "|", null, null, 0, null, null, 62, null);
    L19:
        r5 = "0";
        goto L20
    L12:
        r3 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final String a(List r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return CollectionsKt.joinToString$default(r10, ";", null, null, 0, null, b.f47a, 30, null);
    }

    public final d2 a(String r11) {
        d2 r0 = null;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        String r1 = r11;
    L6:
        if (r1 == null) goto L37;
        List r10 = StringsKt.split$default(r1, new String[]{"|"}, false, 0, 6, null);
        if (r10 == null) goto L37;
        if (r10.size() >= 5) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L37;
        String r12 = (String) CollectionsKt.getOrNull(r10, 0);
        if (r12 != null) goto L17;
        String r2 = "";
    L18:
        String r13 = (String) CollectionsKt.getOrNull(r10, 1);
        if (r13 != null) goto L21;
        String r3 = "";
    L22:
        String r14 = (String) CollectionsKt.getOrNull(r10, 2);
        long r4 = 0;
        if (r14 == null) goto L27;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L27;
        long r6 = r15.longValue();
    L28:
        String r16 = (String) CollectionsKt.getOrNull(r10, 3);
        if (r16 == null) goto L33;
        Long r17 = StringsKt.toLongOrNull(r16);
        if (r17 == null) goto L33;
        r4 = r17.longValue();
    L33:
        long r8 = r4;
        String r18 = (String) CollectionsKt.getOrNull(r10, 4);
        if (r18 != null) goto L36;
        r18 = "";
    L36:
        r0 = new d2(r2, r3, r6, r8, r18);
    L27:
        r6 = 0;
        goto L28
    L21:
        r3 = r13;
        goto L22
    L17:
        r2 = r12;
    L37:
        return r0;
    L5:
        r1 = null;
        goto L6
    }

    public final ArrayList a(String r7, String r8) {
        List r6 = CollectionsKt.createListBuilder();
        if (r8 != null) goto L5;
    L8:
        d2 r9 = f45a.a(r7);
        if (r9 == null) goto L12;
        r6.add(r9);
    L12:
        return (ArrayList) CollectionsKt.toCollection(CollectionsKt.build(r6), new ArrayList());
    L5:
        if (r8.length() == 0) goto L8;
        r6.addAll(SequencesKt.toList(SequencesKt.mapNotNull(CollectionsKt.asSequence(StringsKt.split$default(r8, new String[]{";"}, false, 0, 6, null)), c.f48a)));
        goto L12
    }

    public final List a(tmsdk.common.module.qscanner.impl.b.e r8) {
        if (r8 == null) goto L4;
        List r7 = CollectionsKt.createListBuilder();
        String r0 = r8.b;
        if (r0 != null) goto L8;
    L23:
        String r1 = r8.f53a;
        if (r1 != null) goto L26;
    L37:
        return CollectionsKt.toMutableList(CollectionsKt.distinct(CollectionsKt.build(r7)));
    L26:
        if (r1.length() == 0) goto L37;
        String r9 = f45a.b(r8.f53a);
        if (r9 == null) goto L37;
        if (r9.length() > 0) goto L34;
        r9 = null;
    L34:
        if (r9 == null) goto L37;
        r7.add(r9);
        goto L37
    L8:
        if (r0.length() == 0) goto L23;
        String r2 = r8.b;
        Intrinsics.checkNotNullExpressionValue(r2, "certData.cert2");
        List r10 = StringsKt.split$default(r2, new String[]{";"}, false, 0, 6, null);
        ArrayList r3 = new ArrayList();
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L16;
        String r4 = (String) r11.next();
        String r5 = f45a.b(r4);
        if (r5 == null) goto L12;
        r3.add(r5);
        goto L12
    L16:
        ArrayList r12 = new ArrayList();
        Iterator r6 = r3.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r13 = r6.next();
        if (((String) r13).length() <= 0) goto L18;
        r12.add(r13);
        goto L18
    L22:
        r7.addAll(r12);
        goto L37
    L4:
        return new ArrayList();
    }

    public final String b(String r11, String r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return null;
    L5:
        List r10 = CollectionsKt.createListBuilder();
        if (TextUtils.isEmpty(r12) == true) goto L19;
        String r1 = f45a.c(r12);
        if (r1 == null) goto L23;
        List r13 = StringsKt.split$default(r1, new String[]{";"}, false, 0, 6, null);
        if (r13 == null) goto L23;
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L17;
        Object r2 = r15.next();
        if (((String) r2).length() <= 0) goto L13;
        r14.add(r2);
        goto L13
    L17:
        r10.addAll(r14);
    L23:
        String r16 = CollectionsKt.joinToString$default(CollectionsKt.build(r10), ";", null, null, 0, null, null, 62, null);
        if (r16.length() > 0) goto L26;
        return null;
    L26:
        return r16;
    L19:
        if (TextUtils.isEmpty(r11) == true) goto L23;
        String r17 = f45a.b(r11);
        if (r17 == null) goto L23;
        r10.add(r17);
        goto L23
    }

    public final void a(SQLiteDatabase r1) {
        Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        r1.execSQL("create table if not exists table_app2(info1 TEXT primary key,info2 LONG,info3 LONG,info5 TEXT,info6 INTEGER,info4 TEXT,info7 TEXT,info8 TEXT,info9 TEXT,info10 TEXT,info11 LONG,info12 TEXT)");     // Catch: Throwable -> L5
        r1.execSQL("create table if not exists table_apk2(info1 TEXT primary key,info2 TEXT,info3 LONG,info4 LONG,info5 TEXT,info6 INTEGER,info7 TEXT,info8 TEXT,info9 TEXT,info10 TEXT,info11 LONG,info12 TEXT)");     // Catch: Throwable -> L5
        return;
    }

    private final boolean a(C0089a r10) {
        boolean r9 = false;
    L12:
        Cursor r11 = null;
    L13:
        if (r11 != null) goto L21;
    L15:
        return r9;
    L21:
        r11.close();     // Catch: Throwable -> L16
        goto L15
    L5:
        if (r10.o() == false) goto L7;
        r11 = b.a("table_apk2", new String[]{"info1"}, "info1 = ?", new String[]{r10.k()}, null);     // Catch: Throwable -> L12
    L8:
        if (r11 != null) goto L19;
    L10:
        if (r11 == null) goto L15;
    L19:
        r9 = r11.moveToFirst();     // Catch: Throwable -> L17
    L7:
        r11 = b.a("table_app2", new String[]{"info1"}, "info1 = ?", new String[]{r10.i()}, null);     // Catch: Throwable -> L12
        goto L8
    }

    public final Map a(String r36, List r37, boolean r38) {
        HashMap r1 = new HashMap();
        Cursor r4 = null;
        if (r38 == false) goto L10;
        o3 r5 = b;     // Catch: Throwable -> L35
        String[] r7 = {"info1", "info2", "info3", "info5", "info6", "info4", "info7", "info8", "info9", "info10", "info11", "info12"};     // Catch: Throwable -> L35
        if (r37 == null) goto L7;
        Object[] r0 = r37.toArray(new String[0]);     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L35
        String[] r9 = (String[]) r0;     // Catch: Throwable -> L35
    L8:
        Cursor r2 = r5.a("table_apk2", r7, r36, r9, null);     // Catch: Throwable -> L35
    L9:
        r4 = r2;
        if (r4 == null) goto L33;
    L16:
        if (r4.moveToNext() == false) goto L33;
        if (r38 == false) goto L21;
        String r17 = r4.getString(r4.getColumnIndexOrThrow("info1"));     // Catch: Exception -> L38 Throwable -> L35
        C0089a r3 = new C0089a(true, r4.getString(r4.getColumnIndexOrThrow("info2")), r17, r4.getString(r4.getColumnIndexOrThrow("info5")), r4.getInt(r4.getColumnIndexOrThrow("info6")), 0, 0, r4.getLong(r4.getColumnIndexOrThrow("info3")), r4.getLong(r4.getColumnIndexOrThrow("info4")), r4.getString(r4.getColumnIndexOrThrow("info7")), r4.getString(r4.getColumnIndexOrThrow("info8")), r4.getString(r4.getColumnIndexOrThrow("info9")), r4.getString(r4.getColumnIndexOrThrow("info10")), r4.getLong(r4.getColumnIndexOrThrow("info11")), r4.getString(r4.getColumnIndexOrThrow("info12")));     // Catch: Exception -> L38 Throwable -> L35
    L22:
        if (r38 == false) goto L26;
        String r6 = r3.k();     // Catch: Exception -> L38 Throwable -> L35
        if (r6 != null) goto L30;
    L28:
        r6 = "";
    L30:
        if (r6.length() <= 0) goto L16;
        r1.put(r6, r3);     // Catch: Exception -> L38 Throwable -> L35
        goto L16
    L26:
        r6 = r3.i();     // Catch: Exception -> L38 Throwable -> L35
        if (r6 != null) goto L30;
    L21:
        String r16 = r4.getString(r4.getColumnIndexOrThrow("info1"));     // Catch: Exception -> L38 Throwable -> L35
        long r20 = r4.getLong(r4.getColumnIndexOrThrow("info2"));     // Catch: Exception -> L38 Throwable -> L35
        long r22 = r4.getLong(r4.getColumnIndexOrThrow("info3"));     // Catch: Exception -> L38 Throwable -> L35
        r3 = new C0089a(false, r16, r4.getString(r4.getColumnIndexOrThrow("info4")), r4.getString(r4.getColumnIndexOrThrow("info5")), r4.getInt(r4.getColumnIndexOrThrow("info6")), r20, r22, 0, 0, r4.getString(r4.getColumnIndexOrThrow("info7")), r4.getString(r4.getColumnIndexOrThrow("info8")), r4.getString(r4.getColumnIndexOrThrow("info9")), r4.getString(r4.getColumnIndexOrThrow("info10")), r4.getLong(r4.getColumnIndexOrThrow("info11")), r4.getString(r4.getColumnIndexOrThrow("info12")));     // Catch: Exception -> L38 Throwable -> L35
    L33:
        if (r4 != null) goto L44;
    L37:
        return r1;
    L44:
        r4.close();     // Catch: Throwable -> L39
        goto L37
    L7:
        r9 = null;
        goto L8
    L10:
        o3 r8 = b;     // Catch: Throwable -> L35
        String[] r10 = {"info1", "info2", "info3", "info5", "info6", "info4", "info7", "info8", "info9", "info10", "info11", "info12"};     // Catch: Throwable -> L35
        if (r37 == null) goto L13;
        Object[] r11 = r37.toArray(new String[0]);     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L35
        String[] r12 = (String[]) r11;     // Catch: Throwable -> L35
    L14:
        r2 = r8.a("table_app2", r10, r36, r12, null);     // Catch: Throwable -> L35
        goto L9
    L13:
        r12 = null;
    L35:
        if (r4 == null) goto L37;
        goto L37
    }

    public final String b(tmsdk.common.module.qscanner.impl.b.e r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return b(r2.f53a, r2.b);
    }

    public final void b(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        r2.execSQL("DROP TABLE IF EXISTS table_app");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_apk");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_app2");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_apk2");     // Catch: Throwable -> L5
        a(r2);     // Catch: Throwable -> L5
        return;
    }

    public final boolean b(List r9) {
        Intrinsics.checkNotNullParameter(r9, "cacheDataList");
        boolean r1 = false;
        if (r9.isEmpty() == false) goto L45;
        return false;
    L45:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L44
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L44
    L7:
        if (r10.hasNext() == false) goto L37;
        C0089a r2 = (C0089a) r10.next();     // Catch: Throwable -> L44
        if (r2.o() == false) goto L14;
        if (TextUtils.isEmpty(r2.k()) == true) goto L7;
    L14:
        if (r2.o() == true) goto L18;
        if (TextUtils.isEmpty(r2.i()) == true) goto L7;
    L18:
        boolean r4 = a(r2);     // Catch: Throwable -> L44
        ContentValues r5 = b(r2);     // Catch: Throwable -> L44
        String r6 = "table_apk2";
        if (r4 == false) goto L31;
        if (r2.o() == true) goto L25;
        r6 = "table_app2";
    L25:
        r2.o();     // Catch: Throwable -> L44
        if (r2.o() == false) goto L28;
        String r3 = r2.k();     // Catch: Throwable -> L44
    L29:
        ContentProviderOperation r7 = ContentProviderOperation.newUpdate(b.b(r6)).withSelection("info1 = ?", new String[]{r3}).withValues(r5).build();     // Catch: Throwable -> L44
    L35:
        r0.add(r7);     // Catch: Throwable -> L44
        goto L7
    L28:
        r3 = r2.i();     // Catch: Throwable -> L44
        goto L29
    L31:
        if (r2.o() == true) goto L34;
        r6 = "table_app2";
    L34:
        r7 = ContentProviderOperation.newInsert(b.c(r6)).withValues(r5).build();     // Catch: Throwable -> L44
        goto L35
    L37:
        if (r0.isEmpty() == false) goto L39;
        return false;
    L39:
        if (b.a(r0).length != 0) goto L43;
        r1 = true;
    L43:
        return !r1;
    L44:
        return false;
    }

    private final ContentValues b(C0089a r18) {
        ContentValues r0 = new ContentValues();
        String r14 = "";
        if (r18.o() == false) goto L27;
        String r1 = r18.k();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.put("info1", r1);
        String r2 = r18.i();
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        r0.put("info2", r2);
        r0.put("info3", Long.valueOf(r18.g()));
        String r3 = r18.n();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r0.put("info5", r3);
        r0.put("info6", Integer.valueOf(r18.m()));
        r0.put("info4", Long.valueOf(r18.a()));
        String r4 = r18.c();
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r0.put("info7", r4);
        String r5 = r18.d();
        if (r5 != null) goto L19;
        r5 = "";
    L19:
        r0.put("info8", r5);
        String r6 = r18.b();
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r0.put("info9", r6);
        String r7 = r18.h();
        if (r7 == null) goto L26;
        r14 = r7;
    L26:
        r0.put("info10", r14);
        r0.put("info11", Long.valueOf(r18.e()));
        r0.put("info12", r18.j());
    L50:
        return r0;
    L27:
        String r8 = r18.i();
        if (r8 != null) goto L30;
        r8 = "";
    L30:
        r0.put("info1", r8);
        r0.put("info2", Long.valueOf(r18.f()));
        r0.put("info3", Long.valueOf(r18.l()));
        String r9 = r18.n();
        if (r9 != null) goto L33;
        r9 = "";
    L33:
        r0.put("info5", r9);
        r0.put("info6", Integer.valueOf(r18.m()));
        String r10 = r18.k();
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        r0.put("info4", r10);
        String r11 = r18.c();
        if (r11 != null) goto L39;
        r11 = "";
    L39:
        r0.put("info7", r11);
        String r12 = r18.d();
        if (r12 != null) goto L42;
        r12 = "";
    L42:
        r0.put("info8", r12);
        String r13 = r18.b();
        if (r13 != null) goto L45;
        r13 = "";
    L45:
        r0.put("info9", r13);
        String r15 = r18.h();
        if (r15 == null) goto L49;
        r14 = r15;
    L49:
        r0.put("info10", r14);
        r0.put("info11", Long.valueOf(r18.e()));
        r0.put("info12", r18.j());
        goto L50
    }

    public final void c(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        r2.execSQL("DROP TABLE IF EXISTS table_app");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_apk");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_app2");     // Catch: Throwable -> L5
        r2.execSQL("DROP TABLE IF EXISTS table_apk2");     // Catch: Throwable -> L5
        a(r2);     // Catch: Throwable -> L5
        return;
    }

    public final boolean c(C0089a r8) {
        Intrinsics.checkNotNullParameter(r8, "cacheData");
        boolean r0 = false;
    L30:
        return false;
    L4:
        if (r8.o() == false) goto L9;
        if (TextUtils.isEmpty(r8.k()) == false) goto L9;
        return false;
    L9:
        if (r8.o() == false) goto L11;
    L13:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L30
        boolean r2 = a(r8);     // Catch: Throwable -> L30
        ContentValues r7 = b(r8);     // Catch: Throwable -> L30
        if (r2 == false) goto L22;
        if (r8.o() == false) goto L20;
        r1.add(ContentProviderOperation.newUpdate(b.b("table_apk2")).withSelection("info1 = ?", new String[]{r8.k()}).withValues(r7).build());     // Catch: Throwable -> L30
    L25:
        ContentProviderResult[] r9 = b.a(r1);     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r9, "mDBService.applyBatch(operations)");     // Catch: Throwable -> L30
        if (r9.length != 0) goto L29;
        r0 = true;
    L29:
        return !r0;
    L20:
        r1.add(ContentProviderOperation.newUpdate(b.b("table_app2")).withSelection("info1 = ?", new String[]{r8.i()}).withValues(r7).build());     // Catch: Throwable -> L30
        goto L25
    L22:
        if (r8.o() == false) goto L24;
        r1.add(ContentProviderOperation.newInsert(b.c("table_apk2")).withValues(r7).build());     // Catch: Throwable -> L30
        goto L25
    L24:
        r1.add(ContentProviderOperation.newInsert(b.c("table_app2")).withValues(r7).build());     // Catch: Throwable -> L30
        goto L25
    L11:
        if (TextUtils.isEmpty(r8.i()) == false) goto L13;
        return false;
    }
}
