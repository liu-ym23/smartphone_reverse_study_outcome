package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public FileUtils() {
    }

    public static List<Entry> loadEntriesFromFile(String r7) {
        File r1 = new File(Environment.getExternalStorageDirectory(), r7);
        ArrayList r8 = new ArrayList();
        BufferedReader r0 = new BufferedReader(new FileReader(r1));     // Catch: IOException -> L14
    L4:
        String r2 = r0.readLine();     // Catch: IOException -> L14
        if (r2 == null) goto L16;
        String[] r3 = r2.split("#");     // Catch: IOException -> L14
        int r4 = 0;
        if (r3.length <= 2) goto L8;
        int r5 = r3.length - 1;     // Catch: IOException -> L14
        float[] r6 = new float[r5];     // Catch: IOException -> L14
    L10:
        if (r4 >= r5) goto L12;
        r6[r4] = Float.parseFloat(r3[r4]);     // Catch: IOException -> L14
        r4 = r4 + 1;     // Catch: IOException -> L14
        goto L10
    L12:
        r8.add(new BarEntry(Integer.parseInt(r3[r3.length - 1]), r6));     // Catch: IOException -> L14
        goto L4
    L8:
        r8.add(new Entry(Float.parseFloat(r3[0]), Integer.parseInt(r3[1])));     // Catch: IOException -> L14
    L16:
        return r8;
    L14:
        e = move-exception;
        Log.e(LOG, e.toString());
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [float[]] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13, types: [float] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:37:0x0088). Please report as a decompilation issue!!! */
    public static List<Entry> loadEntriesFromAssets(AssetManager r7, String r8) {
        ArrayList r1 = new ArrayList();
        ?? r2 = 0;
        ?? r3 = 0;
        BufferedReader r4 = null;
        r2 = 0;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(r7.open(r8), "UTF-8"));     // Catch: Throwable -> L21 IOException -> L23
        String r9 = r5.readLine();     // Catch: Throwable -> L17 IOException -> L19
    L5:
        if (r9 == null) goto L15;
        String[] r10 = r9.split("#");     // Catch: Throwable -> L17 IOException -> L19
        int r6 = 0;
        if (r10.length > 2) goto L9;
        ?? r11 = Float.parseFloat(r10[1]);     // Catch: Throwable -> L17 IOException -> L19
        r1.add(new Entry(r11, Float.parseFloat(r10[0])));     // Catch: Throwable -> L17 IOException -> L19
    L13:
        r9 = r5.readLine();     // Catch: Throwable -> L17 IOException -> L19
        r3 = r11;
        goto L5
    L9:
        int r12 = r10.length - 1;     // Catch: Throwable -> L17 IOException -> L19
        r11 = new float[r12];     // Catch: Throwable -> L17 IOException -> L19
    L10:
        if (r6 >= r12) goto L12;
        r11[r6] = Float.parseFloat(r10[r6]);     // Catch: Throwable -> L17 IOException -> L19
        r6 = r6 + 1;     // Catch: Throwable -> L17 IOException -> L19
        goto L10
    L12:
        r1.add(new BarEntry(Integer.parseInt(r10[r10.length - 1]), r11));     // Catch: Throwable -> L17 IOException -> L19
        goto L13
    L15:
        r5.close();     // Catch: IOException -> L28
        r2 = r3;
    L37:
        return r1;
    L19:
        e = e;
        r4 = r5;
    L24:
        Log.e(LOG, e.toString());     // Catch: Throwable -> L21
        r2 = r4;
        if (r4 == null) goto L37;
        r4.close();     // Catch: IOException -> L28
        r2 = r4;
    L17:
        th = th;
        r2 = r5;
    L31:
        if (r2 != 0) goto L41;
    L36:
        throw th;
    L41:
        r2.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e(LOG, e.toString());
    L21:
        th = th;
    L23:
        e = e;
    L28:
        e = move-exception;
        Log.e(LOG, e.toString());
        r2 = r2;
        goto L37
    }

    public static void saveToSdCard(List<Entry> r4, String r5) {
        File r1 = new File(Environment.getExternalStorageDirectory(), r5);
        if (r1.exists() == true) goto L19;
        r1.createNewFile();     // Catch: IOException -> L6
    L6:
        e = move-exception;
        Log.e(LOG, e.toString());
    L19:
        BufferedWriter r6 = new BufferedWriter(new FileWriter(r1, true));     // Catch: IOException -> L14
        Iterator<Entry> r7 = r4.iterator();     // Catch: IOException -> L14
    L10:
        if (r7.hasNext() == false) goto L12;
        Entry r2 = r7.next();     // Catch: IOException -> L14
        r6.append(r2.getY() + "#" + r2.getX());     // Catch: IOException -> L14
        r6.newLine();     // Catch: IOException -> L14
        goto L10
    L12:
        r6.close();     // Catch: IOException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(LOG, e.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager r5, String r6) {
        ArrayList r1 = new ArrayList();
        ?? r2 = 0;
        float r3 = 0.0f;
        r2 = 0;
        r2 = 0;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r5.open(r6), "UTF-8"));     // Catch: Throwable -> L14 IOException -> L16
        String r7 = r4.readLine();     // Catch: Throwable -> L10 IOException -> L12
    L5:
        if (r7 == null) goto L8;
        String[] r8 = r7.split("#");     // Catch: Throwable -> L10 IOException -> L12
        r3 = Float.parseFloat(r8[1]);     // Catch: Throwable -> L10 IOException -> L12
        r1.add(new BarEntry(r3, Float.parseFloat(r8[0])));     // Catch: Throwable -> L10 IOException -> L12
        r7 = r4.readLine();     // Catch: Throwable -> L10 IOException -> L12
    L8:
        r4.close();     // Catch: IOException -> L21
        r2 = r3;
    L30:
    L35:
        return r1;
    L12:
        e = e;
        r2 = r4;
    L17:
        Log.e(LOG, e.toString());     // Catch: Throwable -> L14
        if (r2 == 0) goto L35;
        r2.close();     // Catch: IOException -> L21
        r2 = r2;
    L10:
        th = th;
        r2 = r4;
    L24:
        if (r2 != 0) goto L33;
    L29:
        throw th;
    L33:
        r2.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        Log.e(LOG, e.toString());
    L21:
        e = move-exception;
        Log.e(LOG, e.toString());
    L16:
        e = e;
    L14:
        th = th;
        goto L24
    }
}
