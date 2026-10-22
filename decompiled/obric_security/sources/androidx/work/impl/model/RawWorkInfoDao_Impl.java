package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.WorkInfo;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    static /* synthetic */ RoomDatabase access$000(RawWorkInfoDao_Impl r0) {
        return r0.__db;
    }

    static /* synthetic */ void access$100(RawWorkInfoDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipWorkTagAsjavaLangString(r1);
    }

    static /* synthetic */ void access$200(RawWorkInfoDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipWorkProgressAsandroidxWorkData(r1);
    }

    public RawWorkInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(final SupportSQLiteQuery query) {
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, query, true, null);
        int r2 = CursorUtil.getColumnIndex(r1, SlardarConfigConsts.CONFIG_ID);     // Catch: Throwable -> L48
        int r4 = CursorUtil.getColumnIndex(r1, "state");     // Catch: Throwable -> L48
        int r5 = CursorUtil.getColumnIndex(r1, "output");     // Catch: Throwable -> L48
        int r6 = CursorUtil.getColumnIndex(r1, "run_attempt_count");     // Catch: Throwable -> L48
        int r7 = CursorUtil.getColumnIndex(r1, "generation");     // Catch: Throwable -> L48
        ArrayMap<String, ArrayList<String>> r8 = new ArrayMap();     // Catch: Throwable -> L48
        ArrayMap<String, ArrayList<Data>> r9 = new ArrayMap();     // Catch: Throwable -> L48
    L5:
        if (r1.moveToNext() == false) goto L12;
        String r10 = r1.getString(r2);     // Catch: Throwable -> L48
        if (r8.get(r10) != null) goto L9;
        r8.put(r10, new ArrayList());     // Catch: Throwable -> L48
    L9:
        String r11 = r1.getString(r2);     // Catch: Throwable -> L48
        if (r9.get(r11) != null) goto L5;
        r9.put(r11, new ArrayList());     // Catch: Throwable -> L48
        goto L5
    L12:
        r1.moveToPosition(-1);     // Catch: Throwable -> L48
        __fetchRelationshipWorkTagAsjavaLangString(r8);     // Catch: Throwable -> L48
        __fetchRelationshipWorkProgressAsandroidxWorkData(r9);     // Catch: Throwable -> L48
        ArrayList r0 = new ArrayList(r1.getCount());     // Catch: Throwable -> L48
    L13:
        if (r1.moveToNext() == false) goto L46;
        if (r2 != (-1)) goto L18;
    L16:
        String r13 = null;
    L21:
        if (r4 != (-1)) goto L23;
        WorkInfo.State r14 = null;
    L24:
        if (r5 != (-1)) goto L27;
        Data r15 = null;
    L31:
        int r12 = 0;
        if (r6 != (-1)) goto L34;
        int r16 = 0;
    L35:
        if (r7 != (-1)) goto L37;
    L36:
        int r17 = r12;
        ArrayList<String> r18 = r8.get(r1.getString(r2));     // Catch: Throwable -> L48
        if (r18 != null) goto L41;
        r18 = new ArrayList();     // Catch: Throwable -> L48
    L41:
        ArrayList<String> r19 = r18;
        ArrayList<Data> r110 = r9.get(r1.getString(r2));     // Catch: Throwable -> L48
        if (r110 != null) goto L44;
        r110 = new ArrayList();     // Catch: Throwable -> L48
    L44:
        r0.add(new WorkSpec.WorkInfoPojo(r13, r14, r15, r16, r17, r19, r110));     // Catch: Throwable -> L48
        goto L13
    L37:
        r12 = r1.getInt(r7);     // Catch: Throwable -> L48
        goto L36
    L34:
        r16 = r1.getInt(r6);     // Catch: Throwable -> L48
        goto L35
    L27:
        if (r1.isNull(r5) == false) goto L29;
        byte[] r111 = null;
    L30:
        r15 = Data.fromByteArray(r111);     // Catch: Throwable -> L48
        goto L31
    L29:
        r111 = r1.getBlob(r5);     // Catch: Throwable -> L48
        goto L30
    L23:
        int r112 = r1.getInt(r4);     // Catch: Throwable -> L48
        WorkTypeConverters r113 = WorkTypeConverters.INSTANCE;     // Catch: Throwable -> L48
        r14 = WorkTypeConverters.intToState(r112);     // Catch: Throwable -> L48
        goto L24
    L18:
        if (r1.isNull(r2) == true) goto L16;
        r13 = r1.getString(r2);     // Catch: Throwable -> L48
        goto L21
    L46:
        r1.close();
        return r0;
    L48:
        th = move-exception;
        r1.close();
        throw th;
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(final SupportSQLiteQuery query) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, new AnonymousClass1(this, query));
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
