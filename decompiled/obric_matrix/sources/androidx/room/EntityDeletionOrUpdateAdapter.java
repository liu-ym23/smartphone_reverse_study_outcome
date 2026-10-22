package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase r1) {
        super(r1);
    }

    protected abstract void bind(SupportSQLiteStatement r1, T r2);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public final int handle(T r2) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r2);     // Catch: Throwable -> L6
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r0);
        return r3;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r4) {
        SupportSQLiteStatement r0 = acquire();
        int r1 = 0;
        Iterator<? extends T> r5 = r4.iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L8;
        bind(r0, r5.next());     // Catch: Throwable -> L10
        r1 = r1 + r0.executeUpdateDelete();
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(T[] r6) {
        SupportSQLiteStatement r0 = acquire();
        int r1 = r6.length;     // Catch: Throwable -> L9
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L7;
        bind(r0, r6[r2]);     // Catch: Throwable -> L9
        r3 = r3 + r0.executeUpdateDelete();
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return r3;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }
}
