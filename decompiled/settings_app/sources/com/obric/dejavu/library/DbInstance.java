package com.obric.dejavu.library;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.dejavu.library.jni.Bridge;
import com.obric.dejavu.library.jni.DbInstanceImpl;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DbInstance.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH&J,\u0010\u000f\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00100\fj\u0002`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\nH&J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\bH&J\b\u0010\u001a\u001a\u00020\nH&J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&JO\u0010\u001c\u001a$\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001e0\u001d0\u00100\u00100\fj\u0002`\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u00102\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H&¢\u0006\u0002\u0010%J$\u0010\u001c\u001a\u00020&2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\bH&J\b\u0010)\u001a\u00020\u0006H&J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\bH&J\b\u0010.\u001a\u00020\u0004H&¨\u00060"}, d2 = {"Lcom/obric/dejavu/library/DbInstance;", "Ljava/lang/AutoCloseable;", "()V", "clear", "Lcom/obric/dejavu/library/DbStatus;", "dims", "", "exists", "", "key", "", "getDbInfo", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInfo;", "Lcom/obric/dejavu/library/DbInfoResult;", "getKeys", "", "Lcom/obric/dejavu/library/DbKeysResult;", "start", TraceStatsConsts.STATS_KEY_END, "getProperty", "insert", "vec", "", "value", "normalize", "name", "remove", "search", "Lkotlin/Pair;", "", "Lcom/obric/dejavu/library/DbVecResult;", "vecs", "k", "", "opt", "Lcom/obric/dejavu/library/DbSearchOption;", "([[FILcom/obric/dejavu/library/DbSearchOption;)Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbKvResult;", "getValue", "getVec", PerfConsts.PERF_DISK_FILE_SIZE, "updateIndexConfig", "cfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "rebuildNow", "validate", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class DbInstance implements AutoCloseable {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: DbInstance.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/dejavu/library/DbInstance$Companion;", "", "()V", "openDb", "Lcom/obric/dejavu/library/DbObjResult;", "Lcom/obric/dejavu/library/DbInstance;", "Lcom/obric/dejavu/library/DbOpenResult;", "dirPrefix", "", "opt", "Lcom/obric/dejavu/library/DbOptions;", "dbName", "removeDb", "Lcom/obric/dejavu/library/DbStatus;", "setLogLevel", "", "level", "Lcom/obric/dejavu/library/LogLevel;", "setLogWriter", "writer", "Lcom/obric/dejavu/library/DbLogWriter;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final DbObjResult<DbInstance> openDb(String r1, DbOptions r2) {
            Intrinsics.checkNotNullParameter(r1, "dirPrefix");
            Intrinsics.checkNotNullParameter(r2, "opt");
            return DbInstanceImpl.Companion.openDb(r1, r2);
        }

        public final DbObjResult<DbInstance> openDb(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "dirPrefix");
            Intrinsics.checkNotNullParameter(r2, "dbName");
            return DbInstanceImpl.Companion.openDb(r1, r2);
        }

        public final DbStatus removeDb(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "dirPrefix");
            Intrinsics.checkNotNullParameter(r2, "dbName");
            return DbInstanceImpl.Companion.removeDb(r1, r2);
        }

        public final void setLogLevel(LogLevel r1) {
            Intrinsics.checkNotNullParameter(r1, "level");
            Bridge.setLogLevel(r1.getValue());
        }

        public final void setLogWriter(DbLogWriter r1) {
            Bridge.setLogWriter(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract DbStatus clear();

    public abstract long dims();

    public abstract boolean exists(String r1);

    public abstract DbObjResult<DbInfo> getDbInfo();

    public abstract DbObjResult<String[]> getKeys(String r1, String r2);

    public abstract String getProperty(String r1);

    public abstract DbStatus insert(String r1, float[] r2, String r3, boolean r4);

    public abstract String name();

    public abstract DbStatus remove(String r1);

    public abstract DbKvResult search(String r1, boolean r2, boolean r3);

    public abstract DbObjResult<Pair<String, Float>[][]> search(float[][] r1, int r2, DbSearchOption r3);

    public abstract long size();

    public abstract DbStatus updateIndexConfig(DbIndexConfig r1, boolean r2);

    public abstract DbStatus validate();

    public DbInstance() {
    }

    public static /* synthetic */ DbStatus insert$default(DbInstance r0, String r1, float[] r2, String r3, boolean r4, int r5, Object r6) {
        if (r6 != null) goto L15;
        if ((r5 & 2) == 0) goto L7;
        r2 = null;
    L7:
        if ((r5 & 4) == 0) goto L10;
        r3 = "";
    L10:
        if ((r5 & 8) == 0) goto L13;
        r4 = false;
    L13:
        return r0.insert(r1, r2, r3, r4);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insert");
    }

    public static /* synthetic */ DbKvResult search$default(DbInstance r0, String r1, boolean r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = true;
    L7:
        if ((r4 & 4) == 0) goto L10;
        r3 = false;
    L10:
        return r0.search(r1, r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    public static /* synthetic */ DbObjResult search$default(DbInstance r8, float[][] r9, int r10, DbSearchOption r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 4) == 0) goto L7;
        r11 = new DbSearchOption(false, 0, 0.0f, 0.0f, null, 31, null);
    L7:
        return r8.search(r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    public static /* synthetic */ DbObjResult getKeys$default(DbInstance r1, String r2, String r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 1) == 0) goto L7;
        r2 = "";
    L7:
        if ((r4 & 2) == 0) goto L10;
        r3 = "";
    L10:
        return r1.getKeys(r2, r3);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getKeys");
    }
}
