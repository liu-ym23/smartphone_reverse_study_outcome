package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock;
    private volatile SupportSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase r3) {
        this.mLock = new AtomicBoolean(false);
        this.mDatabase = r3;
    }

    private SupportSQLiteStatement createNewStatement() {
        String r0 = createQuery();
        return this.mDatabase.compileStatement(r0);
    }

    private SupportSQLiteStatement getStmt(boolean r1) {
        if (r1 == false) goto L8;
        if (this.mStmt != null) goto L9;
        this.mStmt = createNewStatement();
    L9:
        return this.mStmt;
    L8:
        return createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(SupportSQLiteStatement r2) {
        if (r2 != this.mStmt) goto L6;
        this.mLock.set(false);
        return;
    }
}
