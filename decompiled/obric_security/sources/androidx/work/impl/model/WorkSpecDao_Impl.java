package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueuedTime;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    static /* synthetic */ RoomDatabase access$000(WorkSpecDao_Impl r0) {
        return r0.__db;
    }

    static /* synthetic */ void access$100(WorkSpecDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipWorkTagAsjavaLangString(r1);
    }

    static /* synthetic */ void access$200(WorkSpecDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipWorkProgressAsandroidxWorkData(r1);
    }

    public WorkSpecDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkSpec = new AnonymousClass1(this, __db);
        this.__updateAdapterOfWorkSpec = new AnonymousClass2(this, __db);
        this.__preparedStmtOfDelete = new AnonymousClass3(this, __db);
        this.__preparedStmtOfSetState = new AnonymousClass4(this, __db);
        this.__preparedStmtOfIncrementPeriodCount = new AnonymousClass5(this, __db);
        this.__preparedStmtOfSetOutput = new AnonymousClass6(this, __db);
        this.__preparedStmtOfSetLastEnqueuedTime = new AnonymousClass7(this, __db);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new AnonymousClass8(this, __db);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new AnonymousClass9(this, __db);
        this.__preparedStmtOfMarkWorkSpecScheduled = new AnonymousClass10(this, __db);
        this.__preparedStmtOfResetScheduledState = new AnonymousClass11(this, __db);
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new AnonymousClass12(this, __db);
        this.__preparedStmtOfIncrementGeneration = new AnonymousClass13(this, __db);
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkSpec.insert(workSpec);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(final WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfWorkSpec.handle(workSpec);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDelete.acquire();
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(final WorkInfo.State state, final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfSetState.acquire();
        WorkTypeConverters r1 = WorkTypeConverters.INSTANCE;
        r0.bindLong(1, WorkTypeConverters.stateToInt(state));
        if (id != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfSetState.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetState.release(r0);
        throw th;
    L5:
        r0.bindString(2, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementPeriodCount.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementPeriodCount.release(r0);
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(final String id, final Data output) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfSetOutput.acquire();
        byte[] r4 = Data.toByteArrayInternal(output);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (id != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfSetOutput.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetOutput.release(r0);
        throw th;
    L9:
        r0.bindString(2, id);
        goto L10
    L5:
        r0.bindBlob(1, r4);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueuedTime(final String id, final long enqueueTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfSetLastEnqueuedTime.acquire();
        r0.bindLong(1, enqueueTime);
        if (id != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfSetLastEnqueuedTime.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfSetLastEnqueuedTime.release(r0);
        throw th;
    L5:
        r0.bindString(2, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(r0);
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(r0);
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(final String id, final long startTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        r0.bindLong(1, startTime);
        if (id != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfMarkWorkSpecScheduled.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkWorkSpecScheduled.release(r0);
        throw th;
    L5:
        r0.bindString(2, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetScheduledState.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetScheduledState.release(r0);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(r0);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(final String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfIncrementGeneration.acquire();
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementGeneration.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrementGeneration.release(r0);
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(final String id) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (id != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "worker_class_name");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "input_merger_class_name");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "input");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "output");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "initial_delay");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "interval_duration");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "flex_duration");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "run_attempt_count");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_policy");     // Catch: Throwable -> L62
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_delay_duration");     // Catch: Throwable -> L62
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "last_enqueue_time");     // Catch: Throwable -> L62
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "minimum_retention_duration");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "schedule_requested_at");     // Catch: Throwable -> L60
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "run_in_foreground");     // Catch: Throwable -> L60
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "out_of_quota_policy");     // Catch: Throwable -> L60
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "period_count");     // Catch: Throwable -> L60
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "generation");     // Catch: Throwable -> L60
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "required_network_type");     // Catch: Throwable -> L60
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "requires_charging");     // Catch: Throwable -> L60
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "requires_device_idle");     // Catch: Throwable -> L60
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "requires_battery_not_low");     // Catch: Throwable -> L60
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "requires_storage_not_low");     // Catch: Throwable -> L60
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_content_update_delay");     // Catch: Throwable -> L60
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_max_content_delay");     // Catch: Throwable -> L60
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "content_uri_triggers");     // Catch: Throwable -> L60
        if (r5.moveToFirst() == true) goto L12;
        WorkSpec r30 = null;
    L58:
        r5.close();
        r16.release();
        return r30;
    L12:
        if (r5.isNull(r0) == false) goto L14;
        String r31 = null;
    L15:
        int r32 = r5.getInt(r6);     // Catch: Throwable -> L60
        WorkTypeConverters r33 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        WorkInfo.State r34 = WorkTypeConverters.intToState(r32);     // Catch: Throwable -> L60
        if (r5.isNull(r7) == false) goto L18;
        String r35 = null;
    L20:
        if (r5.isNull(r8) == false) goto L22;
        String r36 = null;
    L24:
        if (r5.isNull(r9) == false) goto L26;
        byte[] r37 = null;
    L27:
        Data r38 = Data.fromByteArray(r37);     // Catch: Throwable -> L60
        if (r5.isNull(r10) == false) goto L30;
        byte[] r39 = null;
    L31:
        Data r310 = Data.fromByteArray(r39);     // Catch: Throwable -> L60
        long r311 = r5.getLong(r11);     // Catch: Throwable -> L60
        long r312 = r5.getLong(r12);     // Catch: Throwable -> L60
        long r40 = r5.getLong(r13);     // Catch: Throwable -> L60
        int r43 = r5.getInt(r14);     // Catch: Throwable -> L60
        int r41 = r5.getInt(r15);     // Catch: Throwable -> L60
        WorkTypeConverters r42 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        BackoffPolicy r44 = WorkTypeConverters.intToBackoffPolicy(r41);     // Catch: Throwable -> L60
        long r45 = r5.getLong(r1);     // Catch: Throwable -> L60
        long r47 = r5.getLong(r3);     // Catch: Throwable -> L60
        long r49 = r5.getLong(r4);     // Catch: Throwable -> L60
        long r51 = r5.getLong(r17);     // Catch: Throwable -> L60
        if (r5.getInt(r18) == 0) goto L34;
        boolean r53 = true;
    L35:
        int r46 = r5.getInt(r19);     // Catch: Throwable -> L60
        WorkTypeConverters r48 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        OutOfQuotaPolicy r54 = WorkTypeConverters.intToOutOfQuotaPolicy(r46);     // Catch: Throwable -> L60
        int r55 = r5.getInt(r20);     // Catch: Throwable -> L60
        int r56 = r5.getInt(r21);     // Catch: Throwable -> L60
        int r50 = r5.getInt(r22);     // Catch: Throwable -> L60
        WorkTypeConverters r52 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        NetworkType r58 = WorkTypeConverters.intToNetworkType(r50);     // Catch: Throwable -> L60
        if (r5.getInt(r23) == 0) goto L38;
        boolean r59 = true;
    L40:
        if (r5.getInt(r24) == 0) goto L42;
        boolean r60 = true;
    L44:
        if (r5.getInt(r25) == 0) goto L46;
        boolean r61 = true;
    L48:
        if (r5.getInt(r26) == 0) goto L50;
        boolean r62 = true;
    L51:
        long r63 = r5.getLong(r27);     // Catch: Throwable -> L60
        long r65 = r5.getLong(r28);     // Catch: Throwable -> L60
        if (r5.isNull(r29) == false) goto L54;
        byte[] r57 = null;
    L55:
        WorkTypeConverters r64 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L60
        r30 = new WorkSpec(r31, r34, r35, r36, r38, r310, r311, r312, r40, new Constraints(r58, r59, r60, r61, r62, r63, r65, WorkTypeConverters.byteArrayToSetOfTriggers(r57)), r43, r44, r45, r47, r49, r51, r53, r54, r55, r56);     // Catch: Throwable -> L60
        goto L58
    L54:
        r57 = r5.getBlob(r29);     // Catch: Throwable -> L60
        goto L55
    L50:
        r62 = false;
        goto L51
    L46:
        r61 = false;
        goto L48
    L42:
        r60 = false;
        goto L44
    L38:
        r59 = false;
        goto L40
    L34:
        r53 = false;
        goto L35
    L30:
        r39 = r5.getBlob(r10);     // Catch: Throwable -> L60
        goto L31
    L26:
        r37 = r5.getBlob(r9);     // Catch: Throwable -> L60
        goto L27
    L22:
        r36 = r5.getString(r8);     // Catch: Throwable -> L60
        goto L24
    L18:
        r35 = r5.getString(r7);     // Catch: Throwable -> L60
        goto L20
    L14:
        r31 = r5.getString(r0);     // Catch: Throwable -> L60
    L60:
        th = th;
    L64:
        r5.close();
        r16.release();
        throw th;
    L62:
        th = th;
        r16 = r2;
        goto L64
    L5:
        r2.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(final String name) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        String r4 = null;
    L14:
        int r5 = r7.getInt(1);     // Catch: Throwable -> L18
        WorkTypeConverters r6 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L18
        r3.add(new WorkSpec.IdAndState(r4, WorkTypeConverters.intToState(r5)));     // Catch: Throwable -> L18
        goto L8
    L13:
        r4 = r7.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, name);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new AnonymousClass14(this, r0));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(final String id) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L19:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L17:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == false) goto L12;
        Integer r4 = null;
    L13:
        if (r4 == null) goto L17;
        WorkTypeConverters r2 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L19
        r1 = WorkTypeConverters.intToState(r4.intValue());     // Catch: Throwable -> L19
        goto L17
    L12:
        r4 = Integer.valueOf(r3.getInt(0));     // Catch: Throwable -> L19
        goto L13
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String r18) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?", 1);
        if (r18 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        WorkSpec.WorkInfoPojo r4 = null;
        byte[] r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, true, null);     // Catch: Throwable -> L41
        ArrayMap<String, ArrayList<String>> r0 = new ArrayMap();     // Catch: Throwable -> L38
        ArrayMap<String, ArrayList<Data>> r7 = new ArrayMap();     // Catch: Throwable -> L38
    L10:
        if (r6.moveToNext() == false) goto L17;
        String r8 = r6.getString(0);     // Catch: Throwable -> L38
        if (r0.get(r8) != null) goto L14;
        r0.put(r8, new ArrayList());     // Catch: Throwable -> L38
    L14:
        String r9 = r6.getString(0);     // Catch: Throwable -> L38
        if (r7.get(r9) != null) goto L10;
        r7.put(r9, new ArrayList());     // Catch: Throwable -> L38
        goto L10
    L17:
        r6.moveToPosition(-1);     // Catch: Throwable -> L38
        __fetchRelationshipWorkTagAsjavaLangString(r0);     // Catch: Throwable -> L38
        __fetchRelationshipWorkProgressAsandroidxWorkData(r7);     // Catch: Throwable -> L38
        if (r6.moveToFirst() == true) goto L20;
    L34:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L38
        r6.close();     // Catch: Throwable -> L41
        r2.release();     // Catch: Throwable -> L41
        this.__db.endTransaction();
        return r4;
    L20:
        if (r6.isNull(0) == false) goto L22;
        String r10 = null;
    L23:
        int r3 = r6.getInt(1);     // Catch: Throwable -> L38
        WorkTypeConverters r11 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L38
        WorkInfo.State r12 = WorkTypeConverters.intToState(r3);     // Catch: Throwable -> L38
        if (r6.isNull(2) == true) goto L27;
        r5 = r6.getBlob(2);     // Catch: Throwable -> L38
    L27:
        Data r13 = Data.fromByteArray(r5);     // Catch: Throwable -> L38
        int r14 = r6.getInt(3);     // Catch: Throwable -> L38
        int r15 = r6.getInt(4);     // Catch: Throwable -> L38
        ArrayList<String> r1 = r0.get(r6.getString(0));     // Catch: Throwable -> L38
        if (r1 != null) goto L30;
        r1 = new ArrayList();     // Catch: Throwable -> L38
    L30:
        ArrayList<String> r16 = r1;
        ArrayList<Data> r17 = r7.get(r6.getString(0));     // Catch: Throwable -> L38
        if (r17 != null) goto L33;
        r17 = new ArrayList();     // Catch: Throwable -> L38
    L33:
        r4 = new WorkSpec.WorkInfoPojo(r10, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L38
        goto L34
    L22:
        r10 = r6.getString(0);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L41
        r2.release();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r18);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(final List<String> ids) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r2 = ids.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator<String> r1 = ids.iterator();
        int r5 = 1;
    L4:
        if (r1.hasNext() == false) goto L10;
        String r6 = r1.next();
        if (r6 != null) goto L8;
        r3.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.bindString(r5, r6);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r7 = DBUtil.query(this.__db, r3, true, null);     // Catch: Throwable -> L46
        ArrayMap<String, ArrayList<String>> r4 = new ArrayMap();     // Catch: Throwable -> L43
        ArrayMap<String, ArrayList<Data>> r8 = new ArrayMap();     // Catch: Throwable -> L43
    L14:
        if (r7.moveToNext() == false) goto L21;
        String r9 = r7.getString(0);     // Catch: Throwable -> L43
        if (r4.get(r9) != null) goto L18;
        r4.put(r9, new ArrayList());     // Catch: Throwable -> L43
    L18:
        String r10 = r7.getString(0);     // Catch: Throwable -> L43
        if (r8.get(r10) != null) goto L14;
        r8.put(r10, new ArrayList());     // Catch: Throwable -> L43
        goto L14
    L21:
        r7.moveToPosition(-1);     // Catch: Throwable -> L43
        __fetchRelationshipWorkTagAsjavaLangString(r4);     // Catch: Throwable -> L43
        __fetchRelationshipWorkProgressAsandroidxWorkData(r8);     // Catch: Throwable -> L43
        ArrayList r11 = new ArrayList(r7.getCount());     // Catch: Throwable -> L43
    L23:
        if (r7.moveToNext() == false) goto L39;
        if (r7.isNull(0) == false) goto L27;
        String r12 = null;
    L28:
        int r13 = r7.getInt(1);     // Catch: Throwable -> L43
        WorkTypeConverters r14 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L43
        WorkInfo.State r15 = WorkTypeConverters.intToState(r13);     // Catch: Throwable -> L43
        if (r7.isNull(2) == false) goto L31;
        byte[] r16 = null;
    L32:
        Data r17 = Data.fromByteArray(r16);     // Catch: Throwable -> L43
        int r18 = r7.getInt(3);     // Catch: Throwable -> L43
        int r19 = r7.getInt(4);     // Catch: Throwable -> L43
        ArrayList<String> r20 = r4.get(r7.getString(0));     // Catch: Throwable -> L43
        if (r20 != null) goto L35;
        r20 = new ArrayList();     // Catch: Throwable -> L43
    L35:
        ArrayList<String> r110 = r20;
        ArrayList<Data> r21 = r8.get(r7.getString(0));     // Catch: Throwable -> L43
        if (r21 != null) goto L38;
        r21 = new ArrayList();     // Catch: Throwable -> L43
    L38:
        r11.add(new WorkSpec.WorkInfoPojo(r12, r15, r17, r18, r19, r110, r21));     // Catch: Throwable -> L43
        goto L23
    L31:
        r16 = r7.getBlob(2);     // Catch: Throwable -> L43
        goto L32
    L27:
        r12 = r7.getString(0);     // Catch: Throwable -> L43
        goto L28
    L39:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L43
        r7.close();     // Catch: Throwable -> L46
        r3.release();     // Catch: Throwable -> L46
        this.__db.endTransaction();
        return r11;
    L43:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L46
        r3.release();     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(final List<String> ids) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int r1 = ids.size();
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")");
        final RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        Iterator<String> r6 = ids.iterator();
        int r3 = 1;
    L4:
        if (r6.hasNext() == false) goto L11;
        String r4 = r6.next();
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L11:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new AnonymousClass15(this, r2));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(final String tag) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, true, null);     // Catch: Throwable -> L42
        ArrayMap<String, ArrayList<String>> r0 = new ArrayMap();     // Catch: Throwable -> L39
        ArrayMap<String, ArrayList<Data>> r6 = new ArrayMap();     // Catch: Throwable -> L39
    L10:
        if (r5.moveToNext() == false) goto L17;
        String r7 = r5.getString(0);     // Catch: Throwable -> L39
        if (r0.get(r7) != null) goto L14;
        r0.put(r7, new ArrayList());     // Catch: Throwable -> L39
    L14:
        String r8 = r5.getString(0);     // Catch: Throwable -> L39
        if (r6.get(r8) != null) goto L10;
        r6.put(r8, new ArrayList());     // Catch: Throwable -> L39
        goto L10
    L17:
        r5.moveToPosition(-1);     // Catch: Throwable -> L39
        __fetchRelationshipWorkTagAsjavaLangString(r0);     // Catch: Throwable -> L39
        __fetchRelationshipWorkProgressAsandroidxWorkData(r6);     // Catch: Throwable -> L39
        ArrayList r9 = new ArrayList(r5.getCount());     // Catch: Throwable -> L39
    L19:
        if (r5.moveToNext() == false) goto L35;
        if (r5.isNull(0) == false) goto L23;
        String r11 = null;
    L24:
        int r10 = r5.getInt(1);     // Catch: Throwable -> L39
        WorkTypeConverters r12 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L39
        WorkInfo.State r13 = WorkTypeConverters.intToState(r10);     // Catch: Throwable -> L39
        if (r5.isNull(2) == false) goto L27;
        byte[] r14 = null;
    L28:
        Data r15 = Data.fromByteArray(r14);     // Catch: Throwable -> L39
        int r16 = r5.getInt(3);     // Catch: Throwable -> L39
        int r17 = r5.getInt(4);     // Catch: Throwable -> L39
        ArrayList<String> r18 = r0.get(r5.getString(0));     // Catch: Throwable -> L39
        if (r18 != null) goto L31;
        r18 = new ArrayList();     // Catch: Throwable -> L39
    L31:
        ArrayList<String> r19 = r18;
        ArrayList<Data> r20 = r6.get(r5.getString(0));     // Catch: Throwable -> L39
        if (r20 != null) goto L34;
        r20 = new ArrayList();     // Catch: Throwable -> L39
    L34:
        r9.add(new WorkSpec.WorkInfoPojo(r11, r13, r15, r16, r17, r19, r20));     // Catch: Throwable -> L39
        goto L19
    L27:
        r14 = r5.getBlob(2);     // Catch: Throwable -> L39
        goto L28
    L23:
        r11 = r5.getString(0);     // Catch: Throwable -> L39
        goto L24
    L35:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L39
        r5.close();     // Catch: Throwable -> L42
        r2.release();     // Catch: Throwable -> L42
        this.__db.endTransaction();
        return r9;
    L39:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L42
        r2.release();     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, tag);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(final String tag) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag != null) goto L5;
        r0.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new AnonymousClass16(this, r0));
    L5:
        r0.bindString(1, tag);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(final String name) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, true, null);     // Catch: Throwable -> L42
        ArrayMap<String, ArrayList<String>> r0 = new ArrayMap();     // Catch: Throwable -> L39
        ArrayMap<String, ArrayList<Data>> r6 = new ArrayMap();     // Catch: Throwable -> L39
    L10:
        if (r5.moveToNext() == false) goto L17;
        String r7 = r5.getString(0);     // Catch: Throwable -> L39
        if (r0.get(r7) != null) goto L14;
        r0.put(r7, new ArrayList());     // Catch: Throwable -> L39
    L14:
        String r8 = r5.getString(0);     // Catch: Throwable -> L39
        if (r6.get(r8) != null) goto L10;
        r6.put(r8, new ArrayList());     // Catch: Throwable -> L39
        goto L10
    L17:
        r5.moveToPosition(-1);     // Catch: Throwable -> L39
        __fetchRelationshipWorkTagAsjavaLangString(r0);     // Catch: Throwable -> L39
        __fetchRelationshipWorkProgressAsandroidxWorkData(r6);     // Catch: Throwable -> L39
        ArrayList r9 = new ArrayList(r5.getCount());     // Catch: Throwable -> L39
    L19:
        if (r5.moveToNext() == false) goto L35;
        if (r5.isNull(0) == false) goto L23;
        String r11 = null;
    L24:
        int r10 = r5.getInt(1);     // Catch: Throwable -> L39
        WorkTypeConverters r12 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L39
        WorkInfo.State r13 = WorkTypeConverters.intToState(r10);     // Catch: Throwable -> L39
        if (r5.isNull(2) == false) goto L27;
        byte[] r14 = null;
    L28:
        Data r15 = Data.fromByteArray(r14);     // Catch: Throwable -> L39
        int r16 = r5.getInt(3);     // Catch: Throwable -> L39
        int r17 = r5.getInt(4);     // Catch: Throwable -> L39
        ArrayList<String> r18 = r0.get(r5.getString(0));     // Catch: Throwable -> L39
        if (r18 != null) goto L31;
        r18 = new ArrayList();     // Catch: Throwable -> L39
    L31:
        ArrayList<String> r19 = r18;
        ArrayList<Data> r20 = r6.get(r5.getString(0));     // Catch: Throwable -> L39
        if (r20 != null) goto L34;
        r20 = new ArrayList();     // Catch: Throwable -> L39
    L34:
        r9.add(new WorkSpec.WorkInfoPojo(r11, r13, r15, r16, r17, r19, r20));     // Catch: Throwable -> L39
        goto L19
    L27:
        r14 = r5.getBlob(2);     // Catch: Throwable -> L39
        goto L28
    L23:
        r11 = r5.getString(0);     // Catch: Throwable -> L39
        goto L24
    L35:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L39
        r5.close();     // Catch: Throwable -> L42
        r2.release();     // Catch: Throwable -> L42
        this.__db.endTransaction();
        return r9;
    L39:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L42
        r2.release();     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, name);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(final String name) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name != null) goto L5;
        r0.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new AnonymousClass17(this, r0));
    L5:
        r0.bindString(1, name);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(final String id) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        byte[] r3 = null;
    L14:
        r2.add(Data.fromByteArray(r3));     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getBlob(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, id);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(final String tag) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (tag != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, tag);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(final String name) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (name != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, name);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public boolean hasUnfinishedWork() {
        boolean r1 = false;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<Long> getScheduleRequestedAtLiveData(final String id) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (id != null) goto L5;
        r0.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new AnonymousClass18(this, r0));
    L5:
        r0.bindString(1, id);
        goto L7
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(final int schedulerLimit) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        r1.bindLong(1, schedulerLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "worker_class_name");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "input_merger_class_name");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "input");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "output");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "initial_delay");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "interval_duration");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "flex_duration");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "run_attempt_count");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_policy");     // Catch: Throwable -> L58
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "last_enqueue_time");     // Catch: Throwable -> L58
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "schedule_requested_at");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "run_in_foreground");     // Catch: Throwable -> L56
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "period_count");     // Catch: Throwable -> L56
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "generation");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "required_network_type");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "requires_charging");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r4;
        ArrayList r31 = new ArrayList(r5.getCount());     // Catch: Throwable -> L56
    L6:
        if (r5.moveToNext() == false) goto L54;
        if (r5.isNull(r0) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r5.getInt(r6);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r5.isNull(r7) == false) goto L15;
        String r36 = null;
    L17:
        if (r5.isNull(r8) == false) goto L19;
        String r37 = null;
    L21:
        if (r5.isNull(r9) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r5.isNull(r10) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r5.getLong(r11);     // Catch: Throwable -> L56
        long r41 = r5.getLong(r12);     // Catch: Throwable -> L56
        long r42 = r5.getLong(r13);     // Catch: Throwable -> L56
        int r45 = r5.getInt(r14);     // Catch: Throwable -> L56
        int r43 = r5.getInt(r15);     // Catch: Throwable -> L56
        WorkTypeConverters r312 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r43);     // Catch: Throwable -> L56
        long r47 = r5.getLong(r2);     // Catch: Throwable -> L56
        long r49 = r5.getLong(r3);     // Catch: Throwable -> L56
        int r44 = r30;
        long r51 = r5.getLong(r44);     // Catch: Throwable -> L56
        int r313 = r0;
        int r48 = r17;
        long r53 = r5.getLong(r48);     // Catch: Throwable -> L56
        r17 = r48;
        r18 = r18;
        if (r5.getInt(r18) == 0) goto L31;
        boolean r55 = true;
    L32:
        int r110 = r5.getInt(r19);     // Catch: Throwable -> L56
        WorkTypeConverters r314 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r110);     // Catch: Throwable -> L56
        r19 = r19;
        int r50 = r20;
        int r57 = r5.getInt(r50);     // Catch: Throwable -> L56
        r20 = r50;
        int r52 = r21;
        int r58 = r5.getInt(r52);     // Catch: Throwable -> L56
        r21 = r52;
        int r54 = r22;
        int r210 = r5.getInt(r54);     // Catch: Throwable -> L56
        WorkTypeConverters r315 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r210);     // Catch: Throwable -> L56
        r22 = r54;
        r23 = r23;
        if (r5.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r5.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r5.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r5.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r5.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r59 = r28;
        long r67 = r5.getLong(r59);     // Catch: Throwable -> L56
        r28 = r59;
        int r66 = r29;
        if (r5.isNull(r66) == false) goto L51;
        byte[] r211 = null;
    L52:
        WorkTypeConverters r316 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r211));     // Catch: Throwable -> L56
        r29 = r66;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r0 = r313;
        r30 = r44;
        goto L6
    L51:
        r211 = r5.getBlob(r66);     // Catch: Throwable -> L56
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r40 = r5.getBlob(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r5.getBlob(r9);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r5.getString(r8);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r5.getString(r7);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r5.getString(r0);     // Catch: Throwable -> L56
        goto L12
    L54:
        r5.close();
        r16.release();
        return r31;
    L56:
        th = th;
    L60:
        r5.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r1;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(final int maxLimit) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        r1.bindLong(1, maxLimit);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "worker_class_name");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "input_merger_class_name");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "input");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "output");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "initial_delay");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "interval_duration");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "flex_duration");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "run_attempt_count");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_policy");     // Catch: Throwable -> L58
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "last_enqueue_time");     // Catch: Throwable -> L58
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "schedule_requested_at");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "run_in_foreground");     // Catch: Throwable -> L56
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "period_count");     // Catch: Throwable -> L56
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "generation");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "required_network_type");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "requires_charging");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r4;
        ArrayList r31 = new ArrayList(r5.getCount());     // Catch: Throwable -> L56
    L6:
        if (r5.moveToNext() == false) goto L54;
        if (r5.isNull(r0) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r5.getInt(r6);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r5.isNull(r7) == false) goto L15;
        String r36 = null;
    L17:
        if (r5.isNull(r8) == false) goto L19;
        String r37 = null;
    L21:
        if (r5.isNull(r9) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r5.isNull(r10) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r5.getLong(r11);     // Catch: Throwable -> L56
        long r41 = r5.getLong(r12);     // Catch: Throwable -> L56
        long r42 = r5.getLong(r13);     // Catch: Throwable -> L56
        int r45 = r5.getInt(r14);     // Catch: Throwable -> L56
        int r43 = r5.getInt(r15);     // Catch: Throwable -> L56
        WorkTypeConverters r312 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r43);     // Catch: Throwable -> L56
        long r47 = r5.getLong(r2);     // Catch: Throwable -> L56
        long r49 = r5.getLong(r3);     // Catch: Throwable -> L56
        int r44 = r30;
        long r51 = r5.getLong(r44);     // Catch: Throwable -> L56
        int r313 = r0;
        int r48 = r17;
        long r53 = r5.getLong(r48);     // Catch: Throwable -> L56
        r17 = r48;
        r18 = r18;
        if (r5.getInt(r18) == 0) goto L31;
        boolean r55 = true;
    L32:
        int r110 = r5.getInt(r19);     // Catch: Throwable -> L56
        WorkTypeConverters r314 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r110);     // Catch: Throwable -> L56
        r19 = r19;
        int r50 = r20;
        int r57 = r5.getInt(r50);     // Catch: Throwable -> L56
        r20 = r50;
        int r52 = r21;
        int r58 = r5.getInt(r52);     // Catch: Throwable -> L56
        r21 = r52;
        int r54 = r22;
        int r210 = r5.getInt(r54);     // Catch: Throwable -> L56
        WorkTypeConverters r315 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r210);     // Catch: Throwable -> L56
        r22 = r54;
        r23 = r23;
        if (r5.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r5.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r5.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r5.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r5.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r59 = r28;
        long r67 = r5.getLong(r59);     // Catch: Throwable -> L56
        r28 = r59;
        int r66 = r29;
        if (r5.isNull(r66) == false) goto L51;
        byte[] r211 = null;
    L52:
        WorkTypeConverters r316 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        Constraints r410 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r211));     // Catch: Throwable -> L56
        r29 = r66;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r410, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r0 = r313;
        r30 = r44;
        goto L6
    L51:
        r211 = r5.getBlob(r66);     // Catch: Throwable -> L56
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r40 = r5.getBlob(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r5.getBlob(r9);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r5.getString(r8);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r5.getString(r7);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r5.getString(r0);     // Catch: Throwable -> L56
        goto L12
    L54:
        r5.close();
        r16.release();
        return r31;
    L56:
        th = th;
    L60:
        r5.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r1;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L58
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "worker_class_name");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "input_merger_class_name");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "input");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "output");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "initial_delay");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "interval_duration");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "flex_duration");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "run_attempt_count");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "backoff_policy");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "last_enqueue_time");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "schedule_requested_at");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "run_in_foreground");     // Catch: Throwable -> L56
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "period_count");     // Catch: Throwable -> L56
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "generation");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "required_network_type");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "requires_charging");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r3;
        ArrayList r31 = new ArrayList(r4.getCount());     // Catch: Throwable -> L56
    L6:
        if (r4.moveToNext() == false) goto L54;
        if (r4.isNull(r0) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r4.getInt(r5);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r4.isNull(r6) == false) goto L15;
        String r36 = null;
    L17:
        if (r4.isNull(r7) == false) goto L19;
        String r37 = null;
    L21:
        if (r4.isNull(r8) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r4.isNull(r9) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r4.getLong(r10);     // Catch: Throwable -> L56
        long r41 = r4.getLong(r11);     // Catch: Throwable -> L56
        long r42 = r4.getLong(r12);     // Catch: Throwable -> L56
        int r45 = r4.getInt(r13);     // Catch: Throwable -> L56
        int r43 = r4.getInt(r14);     // Catch: Throwable -> L56
        WorkTypeConverters r312 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r43);     // Catch: Throwable -> L56
        long r47 = r4.getLong(r15);     // Catch: Throwable -> L56
        long r49 = r4.getLong(r2);     // Catch: Throwable -> L56
        int r44 = r30;
        long r51 = r4.getLong(r44);     // Catch: Throwable -> L56
        int r313 = r0;
        int r48 = r17;
        long r53 = r4.getLong(r48);     // Catch: Throwable -> L56
        r17 = r48;
        r18 = r18;
        if (r4.getInt(r18) == 0) goto L31;
        boolean r55 = true;
    L32:
        int r110 = r4.getInt(r19);     // Catch: Throwable -> L56
        WorkTypeConverters r410 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r110);     // Catch: Throwable -> L56
        r19 = r19;
        int r50 = r20;
        int r57 = r4.getInt(r50);     // Catch: Throwable -> L56
        r20 = r50;
        int r52 = r21;
        int r58 = r4.getInt(r52);     // Catch: Throwable -> L56
        r21 = r52;
        int r54 = r22;
        int r210 = r4.getInt(r54);     // Catch: Throwable -> L56
        WorkTypeConverters r411 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r210);     // Catch: Throwable -> L56
        r22 = r54;
        r23 = r23;
        if (r4.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r4.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r4.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r4.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r4.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r59 = r28;
        long r67 = r4.getLong(r59);     // Catch: Throwable -> L56
        r28 = r59;
        int r66 = r29;
        if (r4.isNull(r66) == false) goto L51;
        byte[] r211 = null;
    L52:
        WorkTypeConverters r314 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        Constraints r412 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r211));     // Catch: Throwable -> L56
        r29 = r66;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r412, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r0 = r313;
        r30 = r44;
        goto L6
    L51:
        r211 = r4.getBlob(r66);     // Catch: Throwable -> L56
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r40 = r4.getBlob(r9);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r4.getBlob(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r4.getString(r7);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r4.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r4.getString(r0);     // Catch: Throwable -> L56
        goto L12
    L54:
        r4.close();
        r16.release();
        return r31;
    L56:
        th = th;
    L60:
        r4.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r1;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L58
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "worker_class_name");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "input_merger_class_name");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "input");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "output");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "initial_delay");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "interval_duration");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "flex_duration");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "run_attempt_count");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "backoff_policy");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "last_enqueue_time");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "schedule_requested_at");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "run_in_foreground");     // Catch: Throwable -> L56
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "period_count");     // Catch: Throwable -> L56
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "generation");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "required_network_type");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "requires_charging");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "requires_device_idle");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "content_uri_triggers");     // Catch: Throwable -> L56
        int r30 = r3;
        ArrayList r31 = new ArrayList(r4.getCount());     // Catch: Throwable -> L56
    L6:
        if (r4.moveToNext() == false) goto L54;
        if (r4.isNull(r0) == false) goto L11;
        String r32 = null;
    L12:
        int r33 = r4.getInt(r5);     // Catch: Throwable -> L56
        WorkTypeConverters r34 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r35 = WorkTypeConverters.intToState(r33);     // Catch: Throwable -> L56
        if (r4.isNull(r6) == false) goto L15;
        String r36 = null;
    L17:
        if (r4.isNull(r7) == false) goto L19;
        String r37 = null;
    L21:
        if (r4.isNull(r8) == false) goto L23;
        byte[] r38 = null;
    L24:
        Data r39 = Data.fromByteArray(r38);     // Catch: Throwable -> L56
        if (r4.isNull(r9) == false) goto L27;
        byte[] r40 = null;
    L28:
        Data r310 = Data.fromByteArray(r40);     // Catch: Throwable -> L56
        long r311 = r4.getLong(r10);     // Catch: Throwable -> L56
        long r41 = r4.getLong(r11);     // Catch: Throwable -> L56
        long r42 = r4.getLong(r12);     // Catch: Throwable -> L56
        int r45 = r4.getInt(r13);     // Catch: Throwable -> L56
        int r43 = r4.getInt(r14);     // Catch: Throwable -> L56
        WorkTypeConverters r312 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        BackoffPolicy r46 = WorkTypeConverters.intToBackoffPolicy(r43);     // Catch: Throwable -> L56
        long r47 = r4.getLong(r15);     // Catch: Throwable -> L56
        long r49 = r4.getLong(r2);     // Catch: Throwable -> L56
        int r44 = r30;
        long r51 = r4.getLong(r44);     // Catch: Throwable -> L56
        int r313 = r0;
        int r48 = r17;
        long r53 = r4.getLong(r48);     // Catch: Throwable -> L56
        r17 = r48;
        r18 = r18;
        if (r4.getInt(r18) == 0) goto L31;
        boolean r55 = true;
    L32:
        int r110 = r4.getInt(r19);     // Catch: Throwable -> L56
        WorkTypeConverters r410 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        OutOfQuotaPolicy r56 = WorkTypeConverters.intToOutOfQuotaPolicy(r110);     // Catch: Throwable -> L56
        r19 = r19;
        int r50 = r20;
        int r57 = r4.getInt(r50);     // Catch: Throwable -> L56
        r20 = r50;
        int r52 = r21;
        int r58 = r4.getInt(r52);     // Catch: Throwable -> L56
        r21 = r52;
        int r54 = r22;
        int r210 = r4.getInt(r54);     // Catch: Throwable -> L56
        WorkTypeConverters r411 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        NetworkType r60 = WorkTypeConverters.intToNetworkType(r210);     // Catch: Throwable -> L56
        r22 = r54;
        r23 = r23;
        if (r4.getInt(r23) == 0) goto L35;
        boolean r61 = true;
    L37:
        if (r4.getInt(r24) == 0) goto L39;
        boolean r62 = true;
    L41:
        if (r4.getInt(r25) == 0) goto L43;
        boolean r63 = true;
    L45:
        if (r4.getInt(r26) == 0) goto L47;
        boolean r64 = true;
    L48:
        long r65 = r4.getLong(r27);     // Catch: Throwable -> L56
        r27 = r27;
        int r59 = r28;
        long r67 = r4.getLong(r59);     // Catch: Throwable -> L56
        r28 = r59;
        int r66 = r29;
        if (r4.isNull(r66) == false) goto L51;
        byte[] r211 = null;
    L52:
        WorkTypeConverters r314 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        Constraints r412 = new Constraints(r60, r61, r62, r63, r64, r65, r67, WorkTypeConverters.byteArrayToSetOfTriggers(r211));     // Catch: Throwable -> L56
        r29 = r66;
        r31.add(new WorkSpec(r32, r35, r36, r37, r39, r310, r311, r41, r42, r412, r45, r46, r47, r49, r51, r53, r55, r56, r57, r58));     // Catch: Throwable -> L56
        r0 = r313;
        r30 = r44;
        goto L6
    L51:
        r211 = r4.getBlob(r66);     // Catch: Throwable -> L56
        goto L52
    L47:
        r64 = false;
        goto L48
    L43:
        r63 = false;
        goto L45
    L39:
        r62 = false;
        goto L41
    L35:
        r61 = false;
        goto L37
    L31:
        r55 = false;
        goto L32
    L27:
        r40 = r4.getBlob(r9);     // Catch: Throwable -> L56
        goto L28
    L23:
        r38 = r4.getBlob(r8);     // Catch: Throwable -> L56
        goto L24
    L19:
        r37 = r4.getString(r7);     // Catch: Throwable -> L56
        goto L21
    L15:
        r36 = r4.getString(r6);     // Catch: Throwable -> L56
        goto L17
    L11:
        r32 = r4.getString(r0);     // Catch: Throwable -> L56
        goto L12
    L54:
        r4.close();
        r16.release();
        return r31;
    L56:
        th = th;
    L60:
        r4.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r1;
        goto L60
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(final long startingAt) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        r1.bindLong(1, startingAt);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "worker_class_name");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "input_merger_class_name");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "input");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "output");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "initial_delay");     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "interval_duration");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "flex_duration");     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "run_attempt_count");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_policy");     // Catch: Throwable -> L58
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "backoff_delay_duration");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "last_enqueue_time");     // Catch: Throwable -> L58
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "minimum_retention_duration");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r1;
        int r71 = CursorUtil.getColumnIndexOrThrow(r5, "schedule_requested_at");     // Catch: Throwable -> L56
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "run_in_foreground");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "out_of_quota_policy");     // Catch: Throwable -> L56
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "period_count");     // Catch: Throwable -> L56
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "generation");     // Catch: Throwable -> L56
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "required_network_type");     // Catch: Throwable -> L56
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "requires_charging");     // Catch: Throwable -> L56
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "requires_device_idle");     // Catch: Throwable -> L56
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "requires_battery_not_low");     // Catch: Throwable -> L56
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "requires_storage_not_low");     // Catch: Throwable -> L56
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_content_update_delay");     // Catch: Throwable -> L56
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "trigger_max_content_delay");     // Catch: Throwable -> L56
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "content_uri_triggers");     // Catch: Throwable -> L56
        int r29 = r4;
        ArrayList r30 = new ArrayList(r5.getCount());     // Catch: Throwable -> L56
    L6:
        if (r5.moveToNext() == false) goto L54;
        if (r5.isNull(r0) == false) goto L11;
        String r31 = null;
    L12:
        int r32 = r5.getInt(r6);     // Catch: Throwable -> L56
        WorkTypeConverters r33 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        WorkInfo.State r34 = WorkTypeConverters.intToState(r32);     // Catch: Throwable -> L56
        if (r5.isNull(r7) == false) goto L15;
        String r35 = null;
    L17:
        if (r5.isNull(r8) == false) goto L19;
        String r36 = null;
    L21:
        if (r5.isNull(r9) == false) goto L23;
        byte[] r37 = null;
    L24:
        Data r38 = Data.fromByteArray(r37);     // Catch: Throwable -> L56
        if (r5.isNull(r10) == false) goto L27;
        byte[] r39 = null;
    L28:
        Data r310 = Data.fromByteArray(r39);     // Catch: Throwable -> L56
        long r311 = r5.getLong(r11);     // Catch: Throwable -> L56
        long r312 = r5.getLong(r12);     // Catch: Throwable -> L56
        long r41 = r5.getLong(r13);     // Catch: Throwable -> L56
        int r44 = r5.getInt(r14);     // Catch: Throwable -> L56
        int r40 = r5.getInt(r15);     // Catch: Throwable -> L56
        WorkTypeConverters r313 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        BackoffPolicy r45 = WorkTypeConverters.intToBackoffPolicy(r40);     // Catch: Throwable -> L56
        long r46 = r5.getLong(r2);     // Catch: Throwable -> L56
        long r48 = r5.getLong(r3);     // Catch: Throwable -> L56
        int r42 = r29;
        long r50 = r5.getLong(r42);     // Catch: Throwable -> L56
        int r210 = r0;
        int r43 = r71;
        long r52 = r5.getLong(r43);     // Catch: Throwable -> L56
        r71 = r43;
        r17 = r17;
        if (r5.getInt(r17) == 0) goto L31;
        boolean r54 = true;
    L32:
        int r110 = r5.getInt(r18);     // Catch: Throwable -> L56
        WorkTypeConverters r314 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        OutOfQuotaPolicy r55 = WorkTypeConverters.intToOutOfQuotaPolicy(r110);     // Catch: Throwable -> L56
        r18 = r18;
        int r47 = r19;
        int r56 = r5.getInt(r47);     // Catch: Throwable -> L56
        r19 = r47;
        int r49 = r20;
        int r57 = r5.getInt(r49);     // Catch: Throwable -> L56
        r20 = r49;
        int r51 = r21;
        int r211 = r5.getInt(r51);     // Catch: Throwable -> L56
        WorkTypeConverters r315 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        NetworkType r59 = WorkTypeConverters.intToNetworkType(r211);     // Catch: Throwable -> L56
        r21 = r51;
        r22 = r22;
        if (r5.getInt(r22) == 0) goto L35;
        boolean r60 = true;
    L37:
        if (r5.getInt(r23) == 0) goto L39;
        boolean r61 = true;
    L41:
        if (r5.getInt(r24) == 0) goto L43;
        boolean r62 = true;
    L45:
        if (r5.getInt(r25) == 0) goto L47;
        boolean r63 = true;
    L48:
        long r64 = r5.getLong(r26);     // Catch: Throwable -> L56
        r26 = r26;
        int r53 = r27;
        long r66 = r5.getLong(r53);     // Catch: Throwable -> L56
        r27 = r53;
        int r58 = r28;
        if (r5.isNull(r58) == false) goto L51;
        byte[] r212 = null;
    L52:
        WorkTypeConverters r316 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L56
        Constraints r410 = new Constraints(r59, r60, r61, r62, r63, r64, r66, WorkTypeConverters.byteArrayToSetOfTriggers(r212));     // Catch: Throwable -> L56
        r28 = r58;
        r30.add(new WorkSpec(r31, r34, r35, r36, r38, r310, r311, r312, r41, r410, r44, r45, r46, r48, r50, r52, r54, r55, r56, r57));     // Catch: Throwable -> L56
        r0 = r210;
        r29 = r42;
        goto L6
    L51:
        r212 = r5.getBlob(r58);     // Catch: Throwable -> L56
        goto L52
    L47:
        r63 = false;
        goto L48
    L43:
        r62 = false;
        goto L45
    L39:
        r61 = false;
        goto L41
    L35:
        r60 = false;
        goto L37
    L31:
        r54 = false;
        goto L32
    L27:
        r39 = r5.getBlob(r10);     // Catch: Throwable -> L56
        goto L28
    L23:
        r37 = r5.getBlob(r9);     // Catch: Throwable -> L56
        goto L24
    L19:
        r36 = r5.getString(r8);     // Catch: Throwable -> L56
        goto L21
    L15:
        r35 = r5.getString(r7);     // Catch: Throwable -> L56
        goto L17
    L11:
        r31 = r5.getString(r0);     // Catch: Throwable -> L56
        goto L12
    L54:
        r5.close();
        r16.release();
        return r30;
    L56:
        th = th;
    L60:
        r5.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r1;
        goto L60
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    private void __fetchRelationshipWorkTagAsjavaLangString(final ArrayMap<String, ArrayList<String>> _map) {
        Set<String> r0 = _map.keySet();
        if (r0.isEmpty() == false) goto L6;
        return;
    L6:
        if (_map.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<String>> r1 = new ArrayMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        int r2 = _map.size();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r2) goto L12;
        r1.put(_map.keyAt(r4), _map.valueAt(r4));
        r4 = r4 + 1;
        r5 = r5 + 1;
        if (r5 != 999) goto L8;
        __fetchRelationshipWorkTagAsjavaLangString(r1);
        r1 = new ArrayMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        r5 = 0;
        goto L8
    L12:
        if (r5 <= 0) goto L59;
        __fetchRelationshipWorkTagAsjavaLangString(r1);
        return;
    L59:
        return;
    L15:
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int r6 = r0.size();
        StringUtil.appendPlaceholders(r3, r6);
        r3.append(")");
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r3.toString(), r6 + 0);
        Iterator<String> r8 = r0.iterator();
        int r9 = 1;
    L17:
        if (r8.hasNext() == false) goto L23;
        String r10 = r8.next();
        if (r10 != null) goto L21;
        r7.bindNull(r9);
    L22:
        r9 = r9 + 1;
        goto L17
    L21:
        r7.bindString(r9, r10);
        goto L22
    L23:
        Cursor r11 = DBUtil.query(this.__db, r7, false, null);
        int r12 = CursorUtil.getColumnIndex(r11, "work_spec_id");     // Catch: Throwable -> L41
        if (r12 != (-1)) goto L29;
        r11.close();
        return;
    L29:
        if (r11.moveToNext() == false) goto L39;
        ArrayList<String> r13 = _map.get(r11.getString(r12));     // Catch: Throwable -> L41
        if (r13 == null) goto L29;
        if (r11.isNull(0) == false) goto L36;
        String r14 = null;
    L37:
        r13.add(r14);     // Catch: Throwable -> L41
        goto L29
    L36:
        r14 = r11.getString(0);     // Catch: Throwable -> L41
        goto L37
    L39:
        r11.close();
        return;
    L41:
        th = move-exception;
        r11.close();
        throw th;
    }

    private void __fetchRelationshipWorkProgressAsandroidxWorkData(final ArrayMap<String, ArrayList<Data>> _map) {
        Set<String> r0 = _map.keySet();
        if (r0.isEmpty() == false) goto L6;
        return;
    L6:
        if (_map.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<Data>> r1 = new ArrayMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        int r2 = _map.size();
        int r4 = 0;
        int r5 = 0;
    L8:
        if (r4 >= r2) goto L12;
        r1.put(_map.keyAt(r4), _map.valueAt(r4));
        r4 = r4 + 1;
        r5 = r5 + 1;
        if (r5 != 999) goto L8;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r1);
        r1 = new ArrayMap(RoomDatabase.MAX_BIND_PARAMETER_CNT);
        r5 = 0;
        goto L8
    L12:
        if (r5 <= 0) goto L59;
        __fetchRelationshipWorkProgressAsandroidxWorkData(r1);
        return;
    L59:
        return;
    L15:
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int r6 = r0.size();
        StringUtil.appendPlaceholders(r3, r6);
        r3.append(")");
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r3.toString(), r6 + 0);
        Iterator<String> r8 = r0.iterator();
        int r9 = 1;
    L17:
        if (r8.hasNext() == false) goto L23;
        String r10 = r8.next();
        if (r10 != null) goto L21;
        r7.bindNull(r9);
    L22:
        r9 = r9 + 1;
        goto L17
    L21:
        r7.bindString(r9, r10);
        goto L22
    L23:
        Cursor r11 = DBUtil.query(this.__db, r7, false, null);
        int r12 = CursorUtil.getColumnIndex(r11, "work_spec_id");     // Catch: Throwable -> L41
        if (r12 != (-1)) goto L29;
        r11.close();
        return;
    L29:
        if (r11.moveToNext() == false) goto L39;
        ArrayList<Data> r13 = _map.get(r11.getString(r12));     // Catch: Throwable -> L41
        if (r13 == null) goto L29;
        if (r11.isNull(0) == false) goto L36;
        byte[] r14 = null;
    L37:
        r13.add(Data.fromByteArray(r14));     // Catch: Throwable -> L41
        goto L29
    L36:
        r14 = r11.getBlob(0);     // Catch: Throwable -> L41
        goto L37
    L39:
        r11.close();
        return;
    L41:
        th = move-exception;
        r11.close();
        throw th;
    }
}
