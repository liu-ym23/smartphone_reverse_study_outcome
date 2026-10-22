package com.bytedance.apm.battery.dao.tmp;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.battery.dao.BaseDao;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.entity.BatteryLogEntity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BatteryTmpLogDao extends BaseDao<BatteryLogEntity> implements BaseDao.CursorGetter<BatteryLogEntity> {
    private static final String[] BATTERY_LOG_COL_ARRAY = null;
    private static String WHERE_CLAUSE_ID_LESS_THAN = "_id <= ? ";
    private static String WHERE_CLAUSE_MAIN_PROCESS;
    private static String WHERE_CLAUSE_NOT_MAIN_PROCESS;
    private static volatile BatteryTmpLogDao singleton;

    static {
        BATTERY_LOG_COL_ARRAY = new String[]{"_id", "front", "type", "timestamp", DBHelper.BATTERY_COL_ACCUMULATION, DBHelper.COL_VERSION_ID, DBHelper.BATTERY_COL_SOURCE, "status", "scene", DBHelper.BATTERY_COL_PROCESS_NAME, DBHelper.BATTERY_COL_MAIN_PROCESS, "sid"};
        WHERE_CLAUSE_MAIN_PROCESS = "main_process = 1 AND delete_flag = 0";
        WHERE_CLAUSE_NOT_MAIN_PROCESS = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }

    private BatteryTmpLogDao() {
    }

    public static BatteryTmpLogDao getInstance() {
        if (singleton != null) goto L16;
        monitor-enter(BatteryTmpLogDao.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L11;
        singleton = new BatteryTmpLogDao();     // Catch: Throwable -> L9
    L11:
        monitor-exit(BatteryTmpLogDao.class);     // Catch: Throwable -> L9
    L16:
        return singleton;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    @NonNull
    public /* bridge */ /* synthetic */ BatteryLogEntity get(BaseDao.CursorWrapper r1) {
        return get(r1);
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String[] getColumns() {
        return BATTERY_LOG_COL_ARRAY;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    @Nullable
    public /* bridge */ /* synthetic */ ContentValues getContentValues(BatteryLogEntity r1) {
        return getContentValues2(r1);
    }

    public synchronized List<BatteryLogEntity> getLogs(boolean r1, long r2) {
        monitor-enter(this);
        if (r1 == false) goto L7;
        List<BatteryLogEntity> r3 = query(WHERE_CLAUSE_MAIN_PROCESS, null, "_id", this);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return r3;
    L7:
        r3 = query(WHERE_CLAUSE_NOT_MAIN_PROCESS, new String[]{String.valueOf(r2)}, "_id", this);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String getTableName() {
        return DBHelper.T_BATTERY;
    }

    public synchronized long saveLog(BatteryLogEntity r7) {
        monitor-enter(this);
        if (r7 != null) goto L15;
        monitor-exit(this);
        return -1;
    L15:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L10 Exception -> L13
        r2.put("front", Integer.valueOf(r7.isFront() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r2.put(DBHelper.BATTERY_COL_SOURCE, r7.getSource());     // Catch: Throwable -> L10 Exception -> L13
        r2.put("type", r7.getType());     // Catch: Throwable -> L10 Exception -> L13
        r2.put("timestamp", Long.valueOf(r7.getTime()));     // Catch: Throwable -> L10 Exception -> L13
        r2.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(r7.getAccumulation()));     // Catch: Throwable -> L10 Exception -> L13
        r2.put(DBHelper.COL_VERSION_ID, Long.valueOf(r7.getVersionId()));     // Catch: Throwable -> L10 Exception -> L13
        r2.put("status", Integer.valueOf(r7.isStatus() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r2.put("scene", r7.getScene());     // Catch: Throwable -> L10 Exception -> L13
        r2.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(r7.isMainProcess() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r2.put(DBHelper.BATTERY_COL_PROCESS_NAME, r7.getProcessName());     // Catch: Throwable -> L10 Exception -> L13
        r2.put("sid", r7.getStartUuid());     // Catch: Throwable -> L10 Exception -> L13
        long r0 = insert(r2);     // Catch: Throwable -> L10 Exception -> L13
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    L14:
        return -1;
    }

    public synchronized void updateDeleteFlag(long r4) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put(DBHelper.COL_DELETE, 1);     // Catch: Throwable -> L6
        update(r0, WHERE_CLAUSE_ID_LESS_THAN, new String[]{String.valueOf(r4)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    @NonNull
    public BatteryLogEntity get(BaseDao.CursorWrapper r22) {
        long r1 = r22.getLong("_id");
        long r3 = r22.getLong("front");
        String r10 = r22.getString("type");
        long r8 = r22.getLong("timestamp");
        long r12 = r22.getLong(DBHelper.BATTERY_COL_ACCUMULATION);
        long r14 = r22.getLong(DBHelper.COL_VERSION_ID);
        String r5 = r22.getString(DBHelper.BATTERY_COL_SOURCE);
        long r6 = r22.getLong("status");
        String r16 = r22.getString("scene");
        int r11 = r22.getInt(DBHelper.BATTERY_COL_MAIN_PROCESS);
        String r13 = r22.getString(DBHelper.BATTERY_COL_PROCESS_NAME);
        if (r3 == 0) goto L5;
        boolean r4 = true;
    L7:
        if (r6 == 0) goto L9;
        boolean r17 = true;
    L10:
        BatteryLogEntity r0 = new BatteryLogEntity(r4, r8, r10, r17, r12, r16, r5);
        r0.setProcessName(r13);
        r0.setId(r1);
        r0.setVersionId(r14);
        if (r11 != 1) goto L13;
        boolean r7 = true;
    L14:
        r0.setMainProcess(r7);
        r0.setStartUuid(r22.getString("sid"));
        return r0;
    L13:
        r7 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    @Nullable
    /* JADX INFO: renamed from: getContentValues, reason: avoid collision after fix types in other method */
    public ContentValues getContentValues2(BatteryLogEntity r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ContentValues r2 = new ContentValues();
        r2.put("front", Integer.valueOf(r3.isFront() ? 1 : 0));
        r2.put(DBHelper.BATTERY_COL_SOURCE, r3.getSource());
        r2.put("type", r3.getType());
        r2.put("timestamp", Long.valueOf(r3.getTime()));
        r2.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(r3.getAccumulation()));
        r2.put(DBHelper.COL_VERSION_ID, Long.valueOf(r3.getVersionId()));
        r2.put("status", Integer.valueOf(r3.isStatus() ? 1 : 0));
        r2.put("scene", r3.getScene());
        r2.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(r3.isMainProcess() ? 1 : 0));
        r2.put(DBHelper.BATTERY_COL_PROCESS_NAME, r3.getProcessName());
        r2.put("sid", r3.getStartUuid());
        return r2;
    }
}
