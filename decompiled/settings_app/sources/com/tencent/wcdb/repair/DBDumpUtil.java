package com.tencent.wcdb.repair;

import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DBDumpUtil {
    private static final String TAG = "WCDB.DBDumpUtil";

    public interface ExecuteSqlCallback {
        String preExecute(String r1);
    }

    private static native boolean nativeDumpDB(String r0, String r1, String r2);

    private static native boolean nativeIsSqlComplete(String r0);

    public DBDumpUtil() {
    }

    public static boolean doRecoveryDb(SQLiteDatabase r8, String r9, String r10, String r11) {
        return doRecoveryDb(r8, r9, r10, r11, null, null, null, true);
    }

    public static boolean doRecoveryDb(SQLiteDatabase r17, String r18, String r19, String r20, List<String> r21, List<String> r22, ExecuteSqlCallback r23, boolean r24) {
        if (r17 != null) goto L5;
    L125:
        Log.w(TAG, "Database is not open");
        return false;
    L5:
        if (r17.isOpen() == false) goto L125;
        if (nativeDumpDB(r18, r19, r20) == true) goto L133;
        return false;
    L133:
        BufferedReader r7 = new BufferedReader(new FileReader(r20));     // Catch: FileNotFoundException -> L123
        r17.execSQL("PRAGMA foreign_keys=OFF;");
        r17.beginTransaction();
        HashMap r8 = new HashMap();     // Catch: Throwable -> L110 IOException -> L112
        boolean r10 = false;
        int r11 = 0;
        int r12 = 0;
        int r14 = 0;
    L13:
        String r13 = null;
    L14:
        r13 = r7.readLine();     // Catch: Throwable -> L110 IOException -> L112
        if (r13 != null) goto L17;
        r7.close();     // Catch: IOException -> L90
    L92:
        if (r12 > r11) goto L94;
        return false;
    L94:
        if (r17.inTransaction() == false) goto L97;
        r17.setTransactionSuccessful();
    L97:
        if (r17.inTransaction() == false) goto L99;
        r17.endTransaction();
    L99:
        if (r24 == false) goto L106;
        File r0 = new File(r20);
        if (r0.exists() == false) goto L103;
        r0.delete();
    L103:
        File r1 = new File(r18);
        if (r1.exists() == false) goto L106;
        r1.delete();
    L106:
        Log.i(TAG, "restore : %d , fail:%d ", new Object[]{Integer.valueOf(r12), Integer.valueOf(r11)});
        return true;
    L90:
        e = move-exception;
        e.printStackTrace();
        goto L92
    L17:
        if (r10 == true) goto L18;
        boolean r16 = r10;
        if (r13.startsWith("INSERT") == true) goto L32;
        if (r13.startsWith("CREATE TABLE") == true) goto L32;
    L30:
        r10 = r16;
    L32:
        if (r13.endsWith(";") == false) goto L83;
        if (nativeIsSqlComplete(r13) == false) goto L83;
    L36:
        if (r22 != null) goto L38;
    L47:
        if (r21 != null) goto L49;
    L57:
        String r6 = null;
    L58:
        boolean r9 = false;
    L59:
        if (r9 == false) goto L127;
        Log.i(TAG, "filter table %s", new Object[]{r6});     // Catch: Throwable -> L110 IOException -> L112
        r10 = false;
        goto L14
    L127:
        if (r13.startsWith("CREATE TABLE") == false) goto L66;
        r8.put(r6, buildColumnsString(getColumnNamesFromSql(r13)));     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
    L70:
        if (r23 == null) goto L72;
        String r5 = r23.preExecute(r13);     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
    L74:
        if (TextUtils.isEmpty(r5) == true) goto L76;
        r13 = r5;
    L76:
        r12 = r12 + 1;     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r17.execSQL(r13);     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r14 = r14 + 1;     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        if (r14 < 100) goto L81;
        r17.setTransactionSuccessful();     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r17.endTransaction();     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r17.beginTransaction();     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r14 = 0;
    L81:
        r10 = false;
        goto L13
    L72:
        r5 = null;
        goto L74
    L66:
        if (r13.startsWith("INSERT INTO") == false) goto L70;
        String r15 = (String) r8.get(r6);     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        if (TextUtils.isEmpty(r15) == true) goto L70;
        StringBuilder r25 = new StringBuilder("INSERT INTO ");     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r25.append("\"").append(r6).append("\"");     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        String r26 = r25.toString();     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r25.append(r15);     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
        r13 = r13.replace(r26, r25.toString());     // Catch: Exception -> L80 Throwable -> L110 IOException -> L112
    L80:
        r11 = r11 + 1;
        goto L81
    L49:
        if (r21.size() <= 0) goto L57;
        r6 = getTableNameFromSql(r13);     // Catch: Throwable -> L110 IOException -> L112
        Iterator<String> r27 = r21.iterator();     // Catch: Throwable -> L110 IOException -> L112
    L52:
        if (r27.hasNext() == false) goto L58;
        if (r6.equals(r27.next()) == false) goto L52;
        r13 = "";
        r9 = true;
        goto L59
    L38:
        if (r22.size() <= 0) goto L47;
        r6 = getTableNameFromSql(r13);     // Catch: Throwable -> L110 IOException -> L112
        Iterator<String> r28 = r22.iterator();     // Catch: Throwable -> L110 IOException -> L112
    L41:
        if (r28.hasNext() == false) goto L45;
        if (r6.equals(r28.next()) == false) goto L41;
        r9 = false;
    L46:
        r13 = r13;
        goto L59
    L45:
        r9 = true;
    L83:
        if (TextUtils.isEmpty(r13) == false) goto L86;
        r13 = r13;
    L87:
        r10 = true;
        goto L14
    L86:
        r13 = r13 + "\n" + r13;     // Catch: Throwable -> L110 IOException -> L112
        goto L87
    L18:
        r16 = r10;
        r13 = r13 + "\n" + r13;     // Catch: Throwable -> L110 IOException -> L112
        if (r13.endsWith(";") == false) goto L30;
        if (nativeIsSqlComplete(r13) == false) goto L30;
        r13 = r13;
        goto L36
    L112:
        Log.w(TAG, "I/O error in read sql file ");     // Catch: Throwable -> L110
        r7.close();     // Catch: IOException -> L115
        return false;
    L115:
        e = move-exception;
        e.printStackTrace();
        return false;
    L110:
        th = move-exception;
        r7.close();     // Catch: IOException -> L120
        throw th;
    L120:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L123:
        Log.w(TAG, "SQL file '%s' not found", new Object[]{r20});
        return false;
    }

    public static String buildColumnsString(ArrayList<String> r3) {
        if (r3 != null) goto L4;
        return "";
    L4:
        if (r3.size() == 0) goto L20;
        StringBuilder r0 = new StringBuilder("(");
        int r1 = 0;
    L8:
        if (r1 >= r3.size()) goto L13;
        r0.append(r3.get(r1));
        if (r1 == (r3.size() - 1)) goto L12;
        r0.append(",");
    L12:
        r1 = r1 + 1;
        goto L8
    L13:
        r0.append(")");
        String r4 = r0.toString();
        System.out.println(r4);
        return r4;
    L20:
        return "";
    }

    public static String getTableNameFromSql(String r2) {
        if (r2.length() <= 100) goto L5;
        r2 = r2.substring(0, 100);
    L5:
        String[] r3 = r2.split("\\s");
        if (r3 != null) goto L8;
        return null;
    L8:
        if (r3.length > 1) goto L10;
        return null;
    L10:
        return r3[2].replaceAll("\"", "");
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0072: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:35:0x0072 */
    public static byte[] readFromFile(String r9) {
        File r0 = new File(r9);
        FileInputStream r5 = null;
        if (r0.exists() == true) goto L53;
        Log.w(TAG, "readFromFile error, file is not exit, path = %s", new Object[]{r9});
        return null;
    L53:
        int r1 = (int) r0.length();     // Catch: Throwable -> L22 Exception -> L24
        FileInputStream r6 = new FileInputStream(r0);     // Catch: Throwable -> L22 Exception -> L24
        byte[] r2 = new byte[r1];     // Catch: Exception -> L20 Throwable -> L34
        int r7 = r6.read(r2);     // Catch: Exception -> L20 Throwable -> L34
        if (r7 == r1) goto L49;
        Log.w(TAG, "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", new Object[]{r9, Integer.valueOf(r1), Integer.valueOf(r7)});     // Catch: Exception -> L20 Throwable -> L34
        r6.close();     // Catch: IOException -> L12
    L14:
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L49:
        r6.close();     // Catch: IOException -> L17
    L19:
        return r2;
    L17:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = e;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L34
        if (r6 != null) goto L47;
    L32:
        Log.e(TAG, "readFromFile failed!");
        return null;
    L47:
        r6.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L24:
        e = e;
        r6 = null;
    L22:
        th = th;
    L36:
        if (r5 != null) goto L42;
    L41:
        throw th;
    L42:
        r5.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L34:
        th = th;
        r5 = r6;
        goto L36
    }

    public static ArrayList<String> getColumnNamesFromSql(String r5) {
        ArrayList<String> r0 = new ArrayList();
        String[] r6 = r5.substring(r5.indexOf("(") + 1, r5.lastIndexOf(")")).trim().split(",");
        int r2 = 0;
    L4:
        if (r2 >= r6.length) goto L6;
        String r3 = r6[r2].trim();
        r6[r2] = r3;
        r0.add(r6[r2].substring(0, r3.indexOf(HanziToPinyin.Token.SEPARATOR)));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
