package com.bytedanceos.preventdisturb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.LongSparseArray;
import bytedanceos.util.LogTag;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpamRecipientIdCache {
    private static final boolean LOCAL_DEBUG = false;
    private static final String TAG = "SpamRecipientIdCache";
    private static Uri sAllCanonical;
    private static SpamRecipientIdCache sInstance;
    private static Uri sSingleCanonicalAddressUri;
    private final LongSparseArray<String> mCache;
    private final Context mContext;
    private final LongSparseArray<String> mNotiNameCache;

    public static class Entry {
        public long id;
        public String number;

        public Entry(long id, String number) {
            this.id = id;
            this.number = number;
        }
    }

    static {
        sAllCanonical = Uri.parse("content://bytedance_spam/canonical-addresses");
        sSingleCanonicalAddressUri = Uri.parse("content://bytedance_spam/canonical-address");
    }

    static SpamRecipientIdCache getInstance() {
        return sInstance;
    }

    static void init(Context context) {
        if (sInstance != null) goto L5;
        sInstance = new SpamRecipientIdCache(context);
    L5:
        new Thread(new AnonymousClass1(), "SpamRecipientIdCache.init").start();
    }

    SpamRecipientIdCache(Context context) {
        this.mCache = new LongSparseArray();
        this.mNotiNameCache = new LongSparseArray();
        this.mContext = context;
    }

    public static void fill() {
        OLog.d(TAG, "[SpamRecipientIdCache] fill: begin");
        Context r1 = sInstance.mContext;
        Cursor r0 = null;
        r0 = SqliteWrapper.query(r1, r1.getContentResolver(), sAllCanonical, null, null, null, null);     // Catch: Throwable -> L18 SQLiteException -> L20
        if (r0 == null) goto L16;
        SpamRecipientIdCache r2 = sInstance;     // Catch: Throwable -> L18 SQLiteException -> L20
        monitor-enter(r2);     // Catch: Throwable -> L18 SQLiteException -> L20
        sInstance.mCache.clear();     // Catch: Throwable -> L13
        sInstance.mNotiNameCache.clear();     // Catch: Throwable -> L13
    L9:
        if (r0.moveToNext() == false) goto L11;
        long r3 = r0.getLong(0);     // Catch: Throwable -> L13
        String r4 = r0.getString(1);     // Catch: Throwable -> L13
        String r5 = r0.getString(2);     // Catch: Throwable -> L13
        sInstance.mCache.put(r3, r4);     // Catch: Throwable -> L13
        sInstance.mNotiNameCache.put(r3, r5);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18 SQLiteException -> L20
    L16:
        if (r0 == null) goto L24;
    L17:
        r0.close();
    L24:
        if (LogTag.DBG == false) goto L35;
        LogTag.d(TAG, "[SpamRecipientIdCache] fill: finished");
        dump();
        return;
    L35:
        return;
    L18:
        th = move-exception;
        if (r0 == null) goto L29;
        r0.close();
    L29:
        throw th;
    L20:
        OLog.d(TAG, "query bytedance_spam error");     // Catch: Throwable -> L18
        if (r0 == null) goto L24;
        goto L17
    }

    public static List<Entry> getAddresses(String spaceSepIds) {
        SpamRecipientIdCache r0 = sInstance;
        monitor-enter(r0);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L18
        String[] r9 = spaceSepIds.split(" ");     // Catch: Throwable -> L18
        int r2 = r9.length;     // Catch: Throwable -> L18
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L16;
        long r4 = Long.parseLong(r9[r3]);     // Catch: NumberFormatException -> L21 Throwable -> L18
        String r6 = sInstance.mCache.get(r4);     // Catch: Throwable -> L18
        if (r6 != null) goto L12;
        dump();     // Catch: Throwable -> L18
        fill();     // Catch: Throwable -> L18
        r6 = sInstance.mCache.get(r4);     // Catch: Throwable -> L18
    L12:
        if (TextUtils.isEmpty(r6) == false) goto L14;
        OLog.w(TAG, "Spam RecipientId " + r4 + " has empty number!");     // Catch: Throwable -> L18
        goto L15
    L14:
        r1.add(new Entry(r4, r6));     // Catch: Throwable -> L18
    L15:
        r3 = r3 + 1;     // Catch: Throwable -> L18
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r1;
    L18:
        th = move-exception;
        throw th;
    }

    public static void dump() {
        SpamRecipientIdCache r0 = sInstance;
        monitor-enter(r0);
        OLog.d(TAG, "***Spam Recipient ID cache dump ***");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getNotiName(long recipientId) {
        return sInstance.mNotiNameCache.get(recipientId);
    }
}
