package tmsdkobf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.oui.calendar.format.DayFormatter;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public class t3 {
    static t3 c;
    private static Object d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteOpenHelper f523a;
    private final String b;

    class a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t3 f524a;

        a(t3 r1, Context r2, String r3, SQLiteDatabase.CursorFactory r4, int r5) {
            this.f524a = r1;
            super(r2, r3, r4, r5);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r1) {
            t3.m2442$$Nest$ma(this.f524a, r1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
            t3.m2443$$Nest$ma(this.f524a, r1, r2, r3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2442$$Nest$ma(t3 r0, SQLiteDatabase r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$ma, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2443$$Nest$ma(t3 r0, SQLiteDatabase r1, int r2, int r3) {
        r0.a(r1, r2, r3);
    }

    static {
        d = new Object();
    }

    private t3() {
        this.b = "CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)";
        a r0 = new a(this, TMSDKContext.getApplicaionContext(), "r.db", null, 10);
        this.f523a = r0;
        r0.getWritableDatabase().setLockingEnabled(false);
    }

    private void a() {
        Object r0 = d;
        monitor-enter(r0);
        this.f523a.close();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void a(SQLiteDatabase r1, int r2, int r3) {
    }

    public static t3 g() {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<tmsdkobf.t3> r0 = tmsdkobf.t3.class
            monitor-enter(r0)
            tmsdkobf.t3 r1 = tmsdkobf.t3.c     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<tmsdkobf.t3> r1 = tmsdkobf.t3.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            tmsdkobf.t3 r2 = tmsdkobf.t3.c     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            tmsdkobf.t3 r2 = new tmsdkobf.t3     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            tmsdkobf.t3.c = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1e
            tmsdkobf.t3 r0 = tmsdkobf.t3.c
            return r0
        L1e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tmsdkobf.t3.g():tmsdkobf.t3");
    }

    public void b() {
        a();
    }

    public List c() {
        List r1 = null;
        StringBuilder r2 = new StringBuilder(120);     // Catch: Throwable -> L9
        r2.append("SELECT * FROM r_tb WHERE l=3 AND d=2");     // Catch: Throwable -> L9
        Cursor r0 = a(r2.toString());     // Catch: Throwable -> L9
        if (r0 != null) goto L15;
    L7:
        if (r0 != null) goto L17;
    L12:
        return r1;
    L17:
        r0.close();     // Catch: Throwable -> L13
        goto L12
    L15:
        r1 = a(r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
    L9:
        r0 = null;
        goto L10
    }

    public List d() {
        List r1 = null;
        StringBuilder r2 = new StringBuilder(120);     // Catch: Throwable -> L9
        r2.append("SELECT * FROM r_tb WHERE l=3 AND d=1");     // Catch: Throwable -> L9
        Cursor r0 = a(r2.toString());     // Catch: Throwable -> L9
        if (r0 != null) goto L15;
    L7:
        if (r0 != null) goto L17;
    L12:
        return r1;
    L17:
        r0.close();     // Catch: Throwable -> L13
        goto L12
    L15:
        r1 = a(r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
    L9:
        r0 = null;
        goto L10
    }

    public List e() {
        List r1 = null;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L9
        StringBuilder r4 = new StringBuilder(120);     // Catch: Throwable -> L9
        r4.append("SELECT * FROM r_tb WHERE k=2 OR e<");     // Catch: Throwable -> L9
        r4.append(r2);     // Catch: Throwable -> L9
        Cursor r0 = a(r4.toString());     // Catch: Throwable -> L9
        if (r0 != null) goto L17;
    L7:
        if (r0 != null) goto L19;
    L12:
        return r1;
    L19:
        r0.close();     // Catch: Throwable -> L13
        goto L12
    L17:
        r1 = a(r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
    L9:
        r0 = null;
        goto L10
    }

    public int f() {
        int r1 = 0;
        StringBuilder r2 = new StringBuilder(120);     // Catch: Throwable -> L11
        r2.append("SELECT COUNT(*) FROM r_tb");     // Catch: Throwable -> L11
        Cursor r4 = a(r2.toString());     // Catch: Throwable -> L11
        if (r4 != null) goto L19;
    L9:
        if (r4 != null) goto L21;
    L14:
        return r1;
    L21:
        r4.close();     // Catch: Throwable -> L15
        goto L14
    L19:
        if (r4.moveToNext() == false) goto L9;
        r1 = r4.getInt(0);     // Catch: Throwable -> L16
    L12:
        if (r4 == null) goto L14;
    L11:
        r4 = null;
        goto L12
    }

    public List h() {
        List r1 = null;
        StringBuilder r2 = new StringBuilder(120);     // Catch: Throwable -> L9
        r2.append("SELECT * FROM r_tb WHERE l=1 OR l=2 AND k=1");     // Catch: Throwable -> L9
        Cursor r0 = a(r2.toString());     // Catch: Throwable -> L9
        if (r0 != null) goto L15;
    L7:
        if (r0 != null) goto L17;
    L12:
        return r1;
    L17:
        r0.close();     // Catch: Throwable -> L13
        goto L12
    L15:
        r1 = a(r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
    L9:
        r0 = null;
        goto L10
    }

    private int a(String r2, String r3, String[] r4) {
        Object r0 = d;
        monitor-enter(r0);
        int r1 = this.f523a.getWritableDatabase().delete(r2, r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public s3 b(int r5) {
        s3 r1 = null;
        StringBuilder r2 = new StringBuilder(120);     // Catch: Throwable -> L13
        r2.append("SELECT * FROM r_tb WHERE a=");     // Catch: Throwable -> L13
        r2.append(r5);     // Catch: Throwable -> L13
        Cursor r6 = a(r2.toString());     // Catch: Throwable -> L13
        if (r6 != null) goto L21;
    L11:
        if (r6 != null) goto L23;
    L16:
        return r1;
    L23:
        r6.close();     // Catch: Throwable -> L17
        goto L16
    L21:
        List r4 = a(r6);     // Catch: Throwable -> L18
        if (r4 == null) goto L11;
        if (r4.size() <= 0) goto L11;
        r1 = (s3) r4.get(0);     // Catch: Throwable -> L18
    L14:
        if (r6 == null) goto L16;
    L13:
        r6 = null;
        goto L14
    }

    public void c(s3 r5) {
        a("r_tb", b(r5), "a=" + r5.f498a.f286a, null);     // Catch: Throwable -> L5
        return;
    }

    private ContentValues b(s3 r3) {
        ContentValues r2 = new ContentValues();
        r2.put("a", Integer.valueOf(r3.f498a.f286a));
        r2.put("b", Integer.valueOf(r3.f498a.b));
        r2.put("c", Integer.valueOf(r3.f498a.c));
        r2.put(DayFormatter.DEFAULT_FORMAT, Integer.valueOf(r3.f498a.d));
        r2.put("e", Long.valueOf(r3.f498a.e));
        r2.put("f", Integer.valueOf(r3.f498a.f));
        r2.put("i", r3.f498a.g);
        r2.put("j", y5.a(TccCryptor.encrypt(r3.f498a.h.getBytes(), null)));
        r2.put("k", Integer.valueOf(r3.b));
        r2.put("l", Integer.valueOf(r3.c));
        return r2;
    }

    public void a(int r4) {
        a("r_tb", "a=" + r4, null);     // Catch: Throwable -> L5
        return;
    }

    private long a(String r3, ContentValues r4) {
        Object r0 = d;
        monitor-enter(r0);
        long r2 = this.f523a.getWritableDatabase().insert(r3, null, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void a(s3 r2) {
        a("r_tb", b(r2));     // Catch: Throwable -> L4
        return;
    }

    private List a(Cursor r6) {
        ArrayList r5 = new ArrayList();
        r6.moveToFirst();     // Catch: Throwable -> L12
    L5:
        if (r6.isAfterLast() == true) goto L9;
        s3 r1 = new s3();     // Catch: Throwable -> L12
        jb r2 = new jb();     // Catch: Throwable -> L12
        r1.f498a = r2;     // Catch: Throwable -> L12
        r2.f286a = r6.getInt(r6.getColumnIndex("a"));     // Catch: Throwable -> L12
        jb r3 = r1.f498a;     // Catch: Throwable -> L12
        r3.b = r6.getInt(r6.getColumnIndex("b"));     // Catch: Throwable -> L12
        jb r4 = r1.f498a;     // Catch: Throwable -> L12
        r4.c = r6.getInt(r6.getColumnIndex("c"));     // Catch: Throwable -> L12
        jb r7 = r1.f498a;     // Catch: Throwable -> L12
        r7.d = r6.getInt(r6.getColumnIndex(DayFormatter.DEFAULT_FORMAT));     // Catch: Throwable -> L12
        jb r8 = r1.f498a;     // Catch: Throwable -> L12
        r8.e = r6.getLong(r6.getColumnIndex("e"));     // Catch: Throwable -> L12
        jb r9 = r1.f498a;     // Catch: Throwable -> L12
        r9.f = r6.getInt(r6.getColumnIndex("f"));     // Catch: Throwable -> L12
        jb r10 = r1.f498a;     // Catch: Throwable -> L12
        r10.g = r6.getString(r6.getColumnIndex("i"));     // Catch: Throwable -> L12
        r1.f498a.h = new String(TccCryptor.decrypt(y5.a(r6.getString(r6.getColumnIndex("j"))), null));     // Catch: Throwable -> L12
        r1.b = r6.getInt(r6.getColumnIndex("k"));     // Catch: Throwable -> L12
        r1.c = r6.getInt(r6.getColumnIndex("l"));     // Catch: Throwable -> L12
        r5.add(r1);     // Catch: Throwable -> L12
        r6.moveToNext();     // Catch: Throwable -> L12
    L9:
        if (r5.size() == 0) goto L11;
        return r5;
    L11:
        return null;
    }

    private void a(SQLiteDatabase r1) {
        r1.execSQL("CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)");
    }

    private Cursor a(String r3) {
        Object r0 = d;
        monitor-enter(r0);
        Cursor r2 = this.f523a.getReadableDatabase().rawQuery(r3, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private int a(String r2, ContentValues r3, String r4, String[] r5) {
        Object r0 = d;
        monitor-enter(r0);
        int r1 = this.f523a.getWritableDatabase().update(r2, r3, r4, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
