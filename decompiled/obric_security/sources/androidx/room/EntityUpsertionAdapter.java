package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EntityUpsertionAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\f\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J#\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001bJ!\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001fJ\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/room/EntityUpsertionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "insertionAdapter", "Landroidx/room/EntityInsertionAdapter;", "updateAdapter", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "(Landroidx/room/EntityInsertionAdapter;Landroidx/room/EntityDeletionOrUpdateAdapter;)V", "checkUniquenessException", "", BaseHttpRequestInfo.KEY_EXCEPTION, "Landroid/database/sqlite/SQLiteConstraintException;", "upsert", "entity", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "upsertAndReturnId", "", "(Ljava/lang/Object;)J", "upsertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "upsertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "upsertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> r2, EntityDeletionOrUpdateAdapter<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "insertionAdapter");
        Intrinsics.checkNotNullParameter(r3, "updateAdapter");
        this.insertionAdapter = r2;
        this.updateAdapter = r3;
    }

    public final void upsert(T r2) {
        this.insertionAdapter.insert(r2);     // Catch: SQLiteConstraintException -> L4
        return;
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r2);
    }

    public final long upsertAndReturnId(T r2) {
        return this.insertionAdapter.insertAndReturnId(r2);
    L4:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r2);
        return -1;
    }

    public final long[] upsertAndReturnIdsArray(T[] r6) {
        Intrinsics.checkNotNullParameter(r6, "entities");
        int r0 = r6.length;
        long[] r1 = new long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        long r3 = this.insertionAdapter.insertAndReturnId(r6[r2]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r1[r2] = r3;
        r2 = r2 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r6[r2]);
        r3 = -1;
        goto L8
    L9:
        return r1;
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> r6) {
        Intrinsics.checkNotNullParameter(r6, "entities");
        Iterator<? extends T> r0 = r6.iterator();
        int r7 = r6.size();
        long[] r1 = new long[r7];
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L10;
        T r3 = r0.next();
        long r4 = this.insertionAdapter.insertAndReturnId(r3);     // Catch: SQLiteConstraintException -> L7
    L9:
        r1[r2] = r4;
        r2 = r2 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r3);
        r4 = -1;
        goto L9
    L10:
        return r1;
    }

    public final List<Long> upsertAndReturnIdsList(T[] r7) {
        Intrinsics.checkNotNullParameter(r7, "entities");
        List r0 = CollectionsKt.createListBuilder();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        T r3 = r7[r2];
        r0.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r3)));     // Catch: SQLiteConstraintException -> L7
    L9:
        r2 = r2 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r3);
        r0.add(-1L);
        goto L9
    L11:
        return CollectionsKt.build(r0);
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        List r0 = CollectionsKt.createListBuilder();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L11;
        T r1 = r6.next();
        r0.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(r1)));     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r1);
        r0.add(-1L);
        goto L4
    L11:
        return CollectionsKt.build(r0);
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] r6) {
        Intrinsics.checkNotNullParameter(r6, "entities");
        int r0 = r6.length;
        Long[] r1 = new Long[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        long r3 = this.insertionAdapter.insertAndReturnId(r6[r2]);     // Catch: SQLiteConstraintException -> L6
    L8:
        r1[r2] = Long.valueOf(r3);
        r2 = r2 + 1;
    L6:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r6[r2]);
        r3 = -1;
        goto L8
    L9:
        return r1;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> r6) {
        Intrinsics.checkNotNullParameter(r6, "entities");
        Iterator<? extends T> r0 = r6.iterator();
        int r7 = r6.size();
        Long[] r1 = new Long[r7];
        int r2 = 0;
    L3:
        if (r2 >= r7) goto L10;
        T r3 = r0.next();
        long r4 = this.insertionAdapter.insertAndReturnId(r3);     // Catch: SQLiteConstraintException -> L7
    L9:
        r1[r2] = Long.valueOf(r4);
        r2 = r2 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r3);
        r4 = -1;
        goto L9
    L10:
        return r1;
    }

    private final void checkUniquenessException(SQLiteConstraintException r3) {
        String r2 = r3.getMessage();
        if (r2 != null) goto L5;
        throw r3;
    L5:
        if (StringsKt.contains(r2, "1555", true) == false) goto L7;
        return;
    L7:
        throw r3;
    }

    public final void upsert(T[] r5) {
        Intrinsics.checkNotNullParameter(r5, "entities");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        T r2 = r5[r1];
        this.insertionAdapter.insert(r2);     // Catch: SQLiteConstraintException -> L7
    L9:
        r1 = r1 + 1;
    L7:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r2);
        goto L9
    }

    public final void upsert(Iterable<? extends T> r3) {
        Intrinsics.checkNotNullParameter(r3, "entities");
        Iterator<? extends T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        T r0 = r4.next();
        this.insertionAdapter.insert(r0);     // Catch: SQLiteConstraintException -> L8
    L8:
        e = move-exception;
        checkUniquenessException(e);
        this.updateAdapter.handle(r0);
        goto L4
    }
}
