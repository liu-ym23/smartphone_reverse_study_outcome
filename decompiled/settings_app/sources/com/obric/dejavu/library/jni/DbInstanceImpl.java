package com.obric.dejavu.library.jni;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.dejavu.library.DbIndexConfig;
import com.obric.dejavu.library.DbInfo;
import com.obric.dejavu.library.DbInstance;
import com.obric.dejavu.library.DbKvResult;
import com.obric.dejavu.library.DbObjResult;
import com.obric.dejavu.library.DbOptions;
import com.obric.dejavu.library.DbSearchOption;
import com.obric.dejavu.library.DbStatus;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbInstanceImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 22\u00020\u0001:\u00012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011H\u0016J(\u0010\u0012\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130\u000fj\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016JM\u0010\u001f\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 0\u00130\u00130\u000fj\u0002`\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016¢\u0006\u0002\u0010(J \u0010\u001f\u001a\u00020)2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/dejavu/library/jni/DbInstanceImpl;", "Lcom/obric/dejavu/library/DbInstance;", "handle", "", "(J)V", "clear", "Lcom/obric/dejavu/library/DbStatus;", "close", "", "dims", "exists", "", "key", "", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", "start", TraceStatsConsts.STATS_KEY_END, "getProperty", "insert", "vec", "", "value", "normalize", "name", "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", PerfConsts.PERF_DISK_FILE_SIZE, "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbInstanceImpl extends DbInstance {
    public static final Companion Companion = null;
    private final long handle;

    /* JADX INFO: compiled from: DbInstanceImpl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/obric/dejavu/library/jni/DbInstanceImpl$Companion;", "", "()V", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInstance;", "Lcom/obric/dejavu/library/DbOpenResult;", "dirPrefix", "", "opt", "Lcom/obric/dejavu/library/DbOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DbObjResult<DbInstance> openDb(String r5, DbOptions r6) {
            Intrinsics.checkNotNullParameter(r5, "dirPrefix");
            Intrinsics.checkNotNullParameter(r6, "opt");
            new File(r5).mkdirs();     // Catch: Throwable -> L9
            long r7 = Bridge.createDb(r5, Bridge.INSTANCE.formatOptStr(r6));     // Catch: Throwable -> L9
            if (r7 < 0) goto L8;
            return new DbObjResult(DbStatus.Companion.getSuccess(), new DbInstanceImpl(r7));
        L8:
            return new DbObjResult(new DbStatus(-1, "unnkown craete error."), null);
        L9:
            th = move-exception;
            String r8 = th.getMessage();
            if (r8 != null) goto L14;
            r8 = "";
        L14:
            return new DbObjResult(new DbStatus(-1, r8), null);
        }

        public final DbObjResult<DbInstance> openDb(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "dirPrefix");
            Intrinsics.checkNotNullParameter(r6, "dbName");
            new File(r5).mkdirs();     // Catch: Throwable -> L9
            long r7 = Bridge.openDb(r5, r6);     // Catch: Throwable -> L9
            if (r7 < 0) goto L8;
            return new DbObjResult(DbStatus.Companion.getSuccess(), new DbInstanceImpl(r7));
        L8:
            return new DbObjResult(new DbStatus(-1, "unnkown craete error."), null);
        L9:
            th = move-exception;
            String r8 = th.getMessage();
            if (r8 != null) goto L14;
            r8 = "";
        L14:
            return new DbObjResult(new DbStatus(-1, r8), null);
        }

        public final DbStatus removeDb(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "dirPrefix");
            Intrinsics.checkNotNullParameter(r2, "dbName");
            return Bridge.removeDb(r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DbInstanceImpl(long r1) {
        this.handle = r1;
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus insert(String r8, float[] r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        return Bridge.insert(this.handle, r8, r9, r10, r11);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbKvResult search(String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.searchKv(this.handle, r3, r4, r5);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<Pair<String, Float>[][]> search(float[][] r3, int r4, DbSearchOption r5) {
        Intrinsics.checkNotNullParameter(r3, "vecs");
        Intrinsics.checkNotNullParameter(r5, "opt");
        return Bridge.searchVec(this.handle, r3, r4, Bridge.INSTANCE.formatOptStr(r5));
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<String[]> getKeys(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "start");
        Intrinsics.checkNotNullParameter(r4, TraceStatsConsts.STATS_KEY_END);
        return Bridge.getKeys(this.handle, r3, r4);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus remove(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.remove(this.handle, r3);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus clear() {
        return Bridge.clear(this.handle);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public boolean exists(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.exists(this.handle, r3);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public long size() {
        return Bridge.size(this.handle);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Bridge.releaseDb(this.handle);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public long dims() {
        return Bridge.dims(this.handle);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public String name() {
        return Bridge.name(this.handle);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus validate() {
        return Bridge.validate(this.handle);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbStatus updateIndexConfig(DbIndexConfig r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "cfg");
        return Bridge.updateIndexConfig(this.handle, Bridge.INSTANCE.formatOptStr(r3), r4);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public String getProperty(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return Bridge.getProperty(this.handle, r3);
    }

    @Override // com.obric.dejavu.library.DbInstance
    public DbObjResult<DbInfo> getDbInfo() {
        return new DbObjResult(DbStatus.Companion.getSuccess(), Bridge.INSTANCE.parseDbInfo(Bridge.getDbInfo(this.handle)));
    }
}
