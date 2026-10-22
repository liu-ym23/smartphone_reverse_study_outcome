package com.bytedance.apm.battery.dao.tmp;

import android.content.ContentValues;
import com.bytedance.apm.battery.dao.BaseDao;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.entity.BatteryLogEntity;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryTmpLogDao extends BaseDao<BatteryLogEntity> implements BaseDao.CursorGetter<BatteryLogEntity> {
    private static final String[] BATTERY_LOG_COL_ARRAY = null;
    private static String WHERE_CLAUSE_ID_LESS_THAN = "_id <= ? ";
    private static String WHERE_CLAUSE_MAIN_PROCESS;
    private static String WHERE_CLAUSE_NOT_MAIN_PROCESS;
    private static volatile BatteryTmpLogDao singleton;

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String getTableName() {
        return DBHelper.T_BATTERY;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    public /* bridge */ /* synthetic */ BatteryLogEntity get(BaseDao.CursorWrapper r1) {
        return get(r1);
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public /* bridge */ /* synthetic */ ContentValues getContentValues(BatteryLogEntity r1) {
        return getContentValues2(r1);
    }

    private BatteryTmpLogDao() {
    }

    public static BatteryTmpLogDao getInstance() {
        if (singleton != null) goto L15;
        monitor-enter(BatteryTmpLogDao.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (singleton != null) goto L9;
        singleton = new BatteryTmpLogDao();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BatteryTmpLogDao.class);     // Catch: Throwable -> L11
    L15:
        return singleton;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String[] getColumns() {
        return BATTERY_LOG_COL_ARRAY;
    }

    /* JADX INFO: renamed from: getContentValues, reason: avoid collision after fix types in other method */
    public ContentValues getContentValues2(BatteryLogEntity r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ContentValues r2 = new ContentValues();
        r2.put("front", Integer.valueOf(r3.isFront() ? 1 : 0));
        r2.put("source", r3.getSource());
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    public BatteryLogEntity get(BaseDao.CursorWrapper r22) {
        long r1 = r22.getLong("_id");
        long r3 = r22.getLong("front");
        String r10 = r22.getString("type");
        long r8 = r22.getLong("timestamp");
        long r12 = r22.getLong(DBHelper.BATTERY_COL_ACCUMULATION);
        long r14 = r22.getLong(DBHelper.COL_VERSION_ID);
        String r5 = r22.getString("source");
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

    public synchronized long saveLog(BatteryLogEntity r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L22 Exception -> L25
        int r5 = 1;
        if (r10.isFront() == false) goto L10;
        int r4 = 1;
    L11:
        r2.put("front", Integer.valueOf(r4));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("source", r10.getSource());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("type", r10.getType());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("timestamp", Long.valueOf(r10.getTime()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(r10.getAccumulation()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.COL_VERSION_ID, Long.valueOf(r10.getVersionId()));     // Catch: Throwable -> L22 Exception -> L25
        if (r10.isStatus() == false) goto L14;
        int r6 = 1;
    L15:
        r2.put("status", Integer.valueOf(r6));     // Catch: Throwable -> L22 Exception -> L25
        r2.put("scene", r10.getScene());     // Catch: Throwable -> L22 Exception -> L25
        if (r10.isMainProcess() == true) goto L19;
        r5 = 0;
    L19:
        r2.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(r5));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_PROCESS_NAME, r10.getProcessName());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("sid", r10.getStartUuid());     // Catch: Throwable -> L22 Exception -> L25
        long r0 = insert(r2);     // Catch: Throwable -> L22 Exception -> L25
        monitor-exit(this);
        return r0;
        goto L26
    L14:
        r6 = 0;
        goto L15
    L10:
        r4 = 0;
    L22:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    public synchronized List<BatteryLogEntity> getLogs(boolean r2, long r3) {
        monitor-enter(this);
        if (r2 == false) goto L5;
        List<BatteryLogEntity> r4 = query(WHERE_CLAUSE_MAIN_PROCESS, null, "_id", this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r4;
    L5:
        r4 = query(WHERE_CLAUSE_NOT_MAIN_PROCESS, new String[]{String.valueOf(r3)}, "_id", this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void updateDeleteFlag(long r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put(DBHelper.COL_DELETE, 1);     // Catch: Throwable -> L6
        update(r0, WHERE_CLAUSE_ID_LESS_THAN, new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        BATTERY_LOG_COL_ARRAY = new String[]{"_id", "front", "type", "timestamp", DBHelper.BATTERY_COL_ACCUMULATION, DBHelper.COL_VERSION_ID, "source", "status", "scene", DBHelper.BATTERY_COL_PROCESS_NAME, DBHelper.BATTERY_COL_MAIN_PROCESS, "sid"};
        WHERE_CLAUSE_MAIN_PROCESS = "main_process = 1 AND delete_flag = 0";
        WHERE_CLAUSE_NOT_MAIN_PROCESS = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }
}
