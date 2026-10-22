package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;

    @VisibleForTesting
    static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;

    @VisibleForTesting
    static final int POOL_LIMIT = 15;
    private static final int STRING = 4;

    @VisibleForTesting
    static final TreeMap<Integer, RoomSQLiteQuery> sQueryPool = null;

    @VisibleForTesting
    int mArgCount;
    private final int[] mBindingTypes;

    @VisibleForTesting
    final byte[][] mBlobBindings;

    @VisibleForTesting
    final int mCapacity;

    @VisibleForTesting
    final double[] mDoubleBindings;

    @VisibleForTesting
    final long[] mLongBindings;
    private volatile String mQuery;

    @VisibleForTesting
    final String[] mStringBindings;

    static {
        sQueryPool = new TreeMap();
    }

    private RoomSQLiteQuery(int r2) {
        this.mCapacity = r2;
        int r3 = r2 + 1;
        this.mBindingTypes = new int[r3];
        this.mLongBindings = new long[r3];
        this.mDoubleBindings = new double[r3];
        this.mStringBindings = new String[r3];
        this.mBlobBindings = new byte[r3][];
    }

    public static RoomSQLiteQuery acquire(String r3, int r4) {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        monitor-enter(r0);
        Map.Entry<Integer, RoomSQLiteQuery> r1 = r0.ceilingEntry(Integer.valueOf(r4));     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r0.remove(r1.getKey());     // Catch: Throwable -> L12
        RoomSQLiteQuery r2 = r1.getValue();     // Catch: Throwable -> L12
        r2.init(r3, r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        RoomSQLiteQuery r5 = new RoomSQLiteQuery(r4);
        r5.init(r3, r4);
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    public static RoomSQLiteQuery copyFrom(SupportSQLiteQuery r2) {
        final RoomSQLiteQuery r0 = acquire(r2.getSql(), r2.getArgCount());
        r2.bindTo(new AnonymousClass1(r0));
        return r0;
    }

    private static void prunePoolLocked() {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        if (r0.size() <= 15) goto L8;
        int r1 = r0.size() - 10;
        Iterator<Integer> r2 = r0.descendingKeySet().iterator();
    L5:
        int r3 = r1 - 1;
        if (r1 <= 0) goto L10;
        r2.next();
        r2.remove();
        r1 = r3;
        goto L5
    L10:
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r3, byte[] r4) {
        this.mBindingTypes[r3] = 5;
        this.mBlobBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r3, double r4) {
        this.mBindingTypes[r3] = 3;
        this.mDoubleBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r3, long r4) {
        this.mBindingTypes[r3] = 2;
        this.mLongBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r2) {
        this.mBindingTypes[r2] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r3, String r4) {
        this.mBindingTypes[r3] = 4;
        this.mStringBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r5) {
        int r1 = 1;
    L4:
        if (r1 > this.mArgCount) goto L22;
        int r2 = this.mBindingTypes[r1];
        if (r2 != 1) goto L8;
        r5.bindNull(r1);
    L21:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 != 2) goto L10;
        r5.bindLong(r1, this.mLongBindings[r1]);
        goto L21
    L10:
        if (r2 != 3) goto L12;
        r5.bindDouble(r1, this.mDoubleBindings[r1]);
        goto L21
    L12:
        if (r2 != 4) goto L14;
        r5.bindString(r1, this.mStringBindings[r1]);
        goto L21
    L14:
        if (r2 != 5) goto L21;
        r5.bindBlob(r1, this.mBlobBindings[r1]);
        goto L21
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.mBindingTypes, 1);
        Arrays.fill(this.mStringBindings, null);
        Arrays.fill(this.mBlobBindings, null);
        this.mQuery = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copyArgumentsFrom(RoomSQLiteQuery r5) {
        int r0 = r5.getArgCount() + 1;
        System.arraycopy(r5.mBindingTypes, 0, this.mBindingTypes, 0, r0);
        System.arraycopy(r5.mLongBindings, 0, this.mLongBindings, 0, r0);
        System.arraycopy(r5.mStringBindings, 0, this.mStringBindings, 0, r0);
        System.arraycopy(r5.mBlobBindings, 0, this.mBlobBindings, 0, r0);
        System.arraycopy(r5.mDoubleBindings, 0, this.mDoubleBindings, 0, r0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.mArgCount;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.mQuery;
    }

    void init(String r1, int r2) {
        this.mQuery = r1;
        this.mArgCount = r2;
    }

    public void release() {
        TreeMap<Integer, RoomSQLiteQuery> r0 = sQueryPool;
        monitor-enter(r0);
        r0.put(Integer.valueOf(this.mCapacity), this);     // Catch: Throwable -> L7
        prunePoolLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
