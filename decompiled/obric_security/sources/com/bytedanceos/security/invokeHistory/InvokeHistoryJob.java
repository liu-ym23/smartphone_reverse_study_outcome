package com.bytedanceos.security.invokeHistory;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.obric.olog.OLog;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes2.dex */
public class InvokeHistoryJob extends IntentService {
    private static final String FILE_DIR = "obric/invoke_history";
    private static final String FILE_NAME = "invoke_data";
    private static final String INVOKE_HISTORY_REPORT_DAY = "invoke_history_report_day";
    private static final String TAG = "InvokeHistoryJob";

    private static void alarmReportData(Context context) {
    }

    public InvokeHistoryJob() {
        super(TAG);
        setIntentRedelivery(true);
    }

    private static void reportInvokeHistory(Context context) {
        long r0 = InvokeHistoryUtils.getBeginOfToday();
        SharedPreferences r2 = context.getSharedPreferences(context.getPackageName(), 0);
        if (r2.getLong(INVOKE_HISTORY_REPORT_DAY, 0) != r0) goto L5;
        return;
    L5:
        int r5 = 2;
        int r6 = 1;
        String[] r12 = {String.valueOf(r0), String.valueOf(r0 - 86400000)};
        ArrayList r3 = new ArrayList();
        Cursor r4 = context.getContentResolver().query(InvokeHistoryDataHelp.CONTENT_URI, new String[]{"*", "sum(number)"}, "time<? and time>? group by caller, allow", r12, " _id ASC LIMIT 10000");
        if (r4 != null) goto L8;
        return;
    L8:
        Integer r9 = null;
        Integer r10 = null;
        Integer r11 = null;
        Integer r13 = null;
        Integer r14 = null;
        Integer r15 = null;
        Integer r16 = null;
        Integer r17 = null;
        Integer r18 = null;
        Integer r19 = null;
    L10:
        if (r4.moveToNext() == false) goto L27;
        if (r9 != null) goto L13;
        r9 = Integer.valueOf(r4.getColumnIndex("callee"));
        r11 = Integer.valueOf(r4.getColumnIndex("calleeUid"));
        r13 = Integer.valueOf(r4.getColumnIndex("caller"));
        r14 = Integer.valueOf(r4.getColumnIndex("callerUid"));
        r15 = Integer.valueOf(r4.getColumnIndex("type"));
        r16 = Integer.valueOf(r4.getColumnIndex("className"));
        r17 = Integer.valueOf(r4.getColumnIndex("action"));
        r18 = Integer.valueOf(r4.getColumnIndex(DBHelper.COL_TIME));
        r19 = Integer.valueOf(r4.getColumnIndex("allow"));
        r10 = Integer.valueOf(r4.getColumnIndex("number") + r6);
    L13:
        int r7 = r4.getInt(r10.intValue());
        if (r7 > r5) goto L16;
        r9 = r9;
    L26:
        r9 = r9;
        r5 = 2;
        r6 = 1;
        goto L10
    L16:
        String r21 = r4.getString(r9.intValue());
        int r22 = r4.getInt(r11.intValue());
        String r8 = r4.getString(r13.intValue());
        int r20 = r4.getInt(r14.intValue());
        if (r8 != null) goto L21;
        r8 = "uid" + r20;
    L21:
        if (TextUtils.equals(BatteryEntry.BYTEDANCE_LAUNCHER_PACKAGE, r8) == true) goto L26;
        if (TextUtils.equals(BatteryEntry.LAUNCHER_PACKAGE, r8) == true) goto L26;
        r3.add(new InvokeHistoryActivity.InvokeRecord(r21, r22, r8, r20, r4.getString(r15.intValue()), r4.getString(r16.intValue()), r4.getString(r17.intValue()), r4.getLong(r18.intValue()), r4.getInt(r19.intValue()), r7, 0, null, null));
        goto L26
    L27:
        r4.close();
        Collections.sort(r3, InvokeHistoryUtils.NUMBER_COMPARATOR);
        File r23 = new File(Environment.getExternalStorageDirectory(), FILE_DIR);
        if (r23.exists() == false) goto L30;
    L67:
        PrintWriter r24 = new PrintWriter(new File(r23, FILE_NAME));     // Catch: Throwable -> L44 IOException -> L46
        Iterator r25 = r3.iterator();     // Catch: Throwable -> L40 IOException -> L42
    L35:
        if (r25.hasNext() == false) goto L37;
        r24.write(((InvokeHistoryActivity.InvokeRecord) r25.next()).toString() + IOUtils.LINE_SEPARATOR_UNIX);     // Catch: Throwable -> L40 IOException -> L42
        goto L35
    L37:
        r24.flush();     // Catch: Throwable -> L40 IOException -> L42
        SharedPreferUtil.commitAsynchronously(r2.edit().putLong(INVOKE_HISTORY_REPORT_DAY, r0));     // Catch: Throwable -> L40 IOException -> L42
        r24.close();     // Catch: IOException -> L52
    L66:
    L55:
        if (Build.IS_DEBUGGABLE == false) goto L82;
        OLog.i(TAG, "report done");
        return;
    L82:
        return;
    L42:
        e = e;
        PrintWriter r26 = r24;
    L69:
        e.printStackTrace();     // Catch: Throwable -> L58
        if (r26 == null) goto L55;
        r26.close();     // Catch: IOException -> L52
    L58:
        th = move-exception;
        Throwable r1 = th;
    L60:
        if (r26 == null) goto L83;
        r26.close();     // Catch: IOException -> L63
        throw r1;
    L63:
        e = move-exception;
        e.printStackTrace();
        throw r1;
    L83:
        throw r1;
    L40:
        th = move-exception;
        r1 = th;
        r26 = r24;
        goto L60
    L52:
        e = move-exception;
        e.printStackTrace();
    L46:
        e = e;
        r26 = null;
    L44:
        th = move-exception;
        r1 = th;
        r26 = null;
        goto L60
    L30:
        if (r23.mkdirs() == true) goto L67;
        OLog.e(TAG, "create dir fail");
        goto L67
    }

    public static void scheduleJob(final Context context) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new AnonymousClass1(context));
    }

    public static void cancelRepeatingAlarm(Context context) {
        PendingIntent r0 = PendingIntent.getService(context, 0, new Intent(context, InvokeHistoryJob.class), 603979776);     // Catch: Throwable -> L9
        if (r0 != null) goto L5;
        return;
    L5:
        AlarmManager r3 = (AlarmManager) context.getSystemService("alarm");     // Catch: Throwable -> L9
        if (r3 == null) goto L14;
        r3.cancel(r0);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        OLog.w(TAG, "cancelRepeatingAlarm failed", th);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        OLog.i(TAG, "onHandleIntent: disabled, ignoring");
    }
}
