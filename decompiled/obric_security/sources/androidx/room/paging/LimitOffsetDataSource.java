package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    protected abstract List<T> convertRows(Cursor r1);

    protected LimitOffsetDataSource(RoomDatabase r1, SupportSQLiteQuery r2, boolean r3, String... r4) {
        this(r1, RoomSQLiteQuery.copyFrom(r2), r3, r4);
    }

    protected LimitOffsetDataSource(RoomDatabase r7, SupportSQLiteQuery r8, boolean r9, boolean r10, String... r11) {
        this(r7, RoomSQLiteQuery.copyFrom(r8), r9, r10, r11);
    }

    protected LimitOffsetDataSource(RoomDatabase r7, RoomSQLiteQuery r8, boolean r9, String... r10) {
        this(r7, r8, r9, true, r10);
    }

    protected LimitOffsetDataSource(RoomDatabase r3, RoomSQLiteQuery r4, boolean r5, boolean r6, final String... r7) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = r3;
        this.mSourceQuery = r4;
        this.mInTransaction = r5;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + r4.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + r4.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new AnonymousClass1(this, r7);
        if (r6 == false) goto L6;
        registerObserverIfNecessary();
        return;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true) == false) goto L6;
        this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        return;
    }

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        r0.copyArgumentsFrom(this.mSourceQuery);
        Cursor r3 = this.mDb.query(r0);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        int r1 = r3.getInt(0);     // Catch: Throwable -> L10
        r3.close();
        r0.release();
        return r1;
    L8:
        r3.close();
        r0.release();
        return 0;
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams r7, PositionalDataSource.LoadInitialCallback<T> r8) {
        registerObserverIfNecessary();
        List<T> r0 = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor r1 = null;
        int r2 = countItems();     // Catch: Throwable -> L18
        if (r2 == 0) goto L10;
        int r3 = computeInitialLoadPosition(r7, r2);     // Catch: Throwable -> L18
        RoomSQLiteQuery r9 = getSQLiteQuery(r3, computeInitialLoadSize(r7, r3, r2));     // Catch: Throwable -> L18
        r1 = this.mDb.query(r9);     // Catch: Throwable -> L8
        List<T> r4 = convertRows(r1);     // Catch: Throwable -> L8
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L8
        RoomSQLiteQuery r5 = r9;
        int r10 = r3;
        r0 = r4;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        this.mDb.endTransaction();
        if (r5 == null) goto L16;
        r5.release();
    L16:
        r8.onResult(r0, r10, r2);
        return;
    L8:
        th = th;
    L20:
        if (r1 == null) goto L22;
        r1.close();
    L22:
        this.mDb.endTransaction();
        if (r9 == null) goto L25;
        r9.release();
    L25:
        throw th;
    L10:
        r10 = 0;
        r5 = null;
    L18:
        th = th;
        r9 = null;
        goto L20
    }

    public void loadRange(PositionalDataSource.LoadRangeParams r2, PositionalDataSource.LoadRangeCallback<T> r3) {
        r3.onResult(loadRange(r2.startPosition, r2.loadSize));
    }

    public List<T> loadRange(int r3, int r4) {
        RoomSQLiteQuery r5 = getSQLiteQuery(r3, r4);
        if (this.mInTransaction == false) goto L15;
        this.mDb.beginTransaction();
        Cursor r6 = null;
        r6 = this.mDb.query(r5);     // Catch: Throwable -> L10
        List<T> r0 = convertRows(r6);     // Catch: Throwable -> L10
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        if (r6 == null) goto L8;
        r6.close();
    L8:
        this.mDb.endTransaction();
        r5.release();
        return r0;
    L10:
        th = move-exception;
        if (r6 == null) goto L13;
        r6.close();
    L13:
        this.mDb.endTransaction();
        r5.release();
        throw th;
    L15:
        Cursor r7 = this.mDb.query(r5);
        List<T> r2 = convertRows(r7);     // Catch: Throwable -> L19
        r7.close();
        r5.release();
        return r2;
    L19:
        th = move-exception;
        r7.close();
        r5.release();
        throw th;
    }

    private RoomSQLiteQuery getSQLiteQuery(int r4, int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        r0.copyArgumentsFrom(this.mSourceQuery);
        r0.bindLong(r0.getArgCount() - 1, r5);
        r0.bindLong(r0.getArgCount(), r4);
        return r0;
    }
}
