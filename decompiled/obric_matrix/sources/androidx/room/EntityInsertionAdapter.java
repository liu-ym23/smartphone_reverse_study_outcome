package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public EntityInsertionAdapter(RoomDatabase r1) {
        super(r1);
    }

    protected abstract void bind(SupportSQLiteStatement r1, T r2);

    public final void insert(Iterable<? extends T> r3) {
        SupportSQLiteStatement r0 = acquire();
        Iterator<? extends T> r4 = r3.iterator();     // Catch: Throwable -> L10
    L5:
        if (r4.hasNext() == false) goto L8;
        bind(r0, r4.next());     // Catch: Throwable -> L10
        r0.executeInsert();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r0);
        return;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(T r2) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r2);     // Catch: Throwable -> L6
        r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(T[] r5) {
        SupportSQLiteStatement r0 = acquire();
        int r1 = r5.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        bind(r0, r5[r2]);     // Catch: Throwable -> L9
        r0.executeInsert();     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long insertAndReturnId(T r4) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, r4);     // Catch: Throwable -> L6
        long r1 = r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return r1;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r6) {
        SupportSQLiteStatement r0 = acquire();
        long[] r1 = new long[r6.size()];     // Catch: Throwable -> L10
        int r2 = 0;
        Iterator<? extends T> r7 = r6.iterator();     // Catch: Throwable -> L10
    L5:
        if (r7.hasNext() == false) goto L8;
        bind(r0, r7.next());     // Catch: Throwable -> L10
        r1[r2] = r0.executeInsert();     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r8) {
        SupportSQLiteStatement r0 = acquire();
        long[] r1 = new long[r8.length];     // Catch: Throwable -> L9
        int r2 = r8.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, r8[r3]);     // Catch: Throwable -> L9
        r1[r4] = r0.executeInsert();     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r6) {
        SupportSQLiteStatement r0 = acquire();
        Long[] r1 = new Long[r6.size()];     // Catch: Throwable -> L10
        int r2 = 0;
        Iterator<? extends T> r7 = r6.iterator();     // Catch: Throwable -> L10
    L5:
        if (r7.hasNext() == false) goto L8;
        bind(r0, r7.next());     // Catch: Throwable -> L10
        r1[r2] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] r8) {
        SupportSQLiteStatement r0 = acquire();
        Long[] r1 = new Long[r8.length];     // Catch: Throwable -> L9
        int r2 = r8.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, r8[r3]);     // Catch: Throwable -> L9
        r1[r4] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r6) {
        SupportSQLiteStatement r0 = acquire();
        ArrayList r1 = new ArrayList(r6.size());     // Catch: Throwable -> L10
        int r2 = 0;
        Iterator<? extends T> r7 = r6.iterator();     // Catch: Throwable -> L10
    L5:
        if (r7.hasNext() == false) goto L8;
        bind(r0, r7.next());     // Catch: Throwable -> L10
        r1.add(r2, Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r8) {
        SupportSQLiteStatement r0 = acquire();
        ArrayList r1 = new ArrayList(r8.length);     // Catch: Throwable -> L9
        int r2 = r8.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, r8[r3]);     // Catch: Throwable -> L9
        r1.add(r4, Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }
}
