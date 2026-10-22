package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ExternalCache extends Cache {
    private static final int FILE_MAX_SIZE = 2048;
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> sCipherTextCache;
    private static volatile Pair<String, byte[]> sClearTextCache;
    private String cacheDir;
    private volatile Map<String, String> mCachedParams;
    private final Context mContext;
    private final boolean mEnableWrite;
    private final String mFileName;
    private AtomicBoolean mIsDelayingToWrite;
    private final String mKey;
    private final String mState;

    private class WriteRunnable implements Runnable {
        final /* synthetic */ ExternalCache this$0;

        private WriteRunnable(ExternalCache r1) {
            this.this$0 = r1;
        }

        /* synthetic */ WriteRunnable(ExternalCache r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            ExternalCache.access$100(this.this$0).set(false);
            String r0 = "";
        L7:
            th = move-exception;
            th.printStackTrace();
        L9:
            ExternalCache.access$400(this.this$0, r0);
            return;
        L4:
            if (ExternalCache.access$200(this.this$0) == null) goto L9;
            ExternalCache r1 = this.this$0;     // Catch: Throwable -> L7
            r0 = ExternalCache.access$300(r1, ExternalCache.access$200(r1));     // Catch: Throwable -> L7
            goto L9
        }
    }

    static /* synthetic */ AtomicBoolean access$100(ExternalCache r0) {
        return r0.mIsDelayingToWrite;
    }

    static /* synthetic */ Map access$200(ExternalCache r0) {
        return r0.mCachedParams;
    }

    static /* synthetic */ String access$300(ExternalCache r0, Map r1) throws JSONException {
        return r0.map2Json(r1);
    }

    static /* synthetic */ void access$400(ExternalCache r0, String r1) {
        r0.write(r1);
    }

    ExternalCache(Context r3, boolean r4, String r5, String r6, String r7) {
        this.mIsDelayingToWrite = new AtomicBoolean(false);
        this.mState = Environment.getExternalStorageState();
        this.cacheDir = r5;
        this.mEnableWrite = r4;
        this.mContext = r3;
        this.mFileName = r6;
        this.mKey = r7;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r1, String r2) {
        storeValue(r1, r2);
    }

    private String getCachePath() {
        return this.cacheDir + LibrarianImpl.Constants.SEPARATOR + this.mFileName;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r1) {
        return getStorageValue(r1);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r1) {
        String r0 = getStorageValue(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        cacheString(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    private String getStorageValue(String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L11;
        if (this.mCachedParams == null) goto L11;
        String r0 = this.mCachedParams.get(r9);
        if (DrLog.debug() == false) goto L9;
        DrLog.v("get key = " + r9 + " value = " + r0 + " way = memory dir = " + getCachePath());
    L9:
        return r0;
    L11:
        if ("mounted".equals(this.mState) == true) goto L107;
        return null;
    L107:
    L56:
        th = th;
        RandomAccessFile r4 = null;
        FileLock r5 = null;
    L105:
    L69:
        th = move-exception;
        if (this.mCachedParams != null) goto L73;
        this.mCachedParams = new ConcurrentHashMap();
    L73:
        if (r5 != null) goto L91;
    L75:
        if (r4 == null) goto L113;
        r4.close();     // Catch: Exception -> L86
        throw th;
    L114:
        throw th;
    L113:
        throw th;
    L91:
        r5.release();     // Catch: Exception -> L85
        goto L75
    L59:
        if ((th instanceof IOException) == true) goto L62;
        th.printStackTrace();     // Catch: Throwable -> L69
    L62:
        if (this.mCachedParams != null) goto L64;
        this.mCachedParams = new ConcurrentHashMap();
    L64:
        if (r5 != null) goto L103;
    L66:
        if (r4 != null) goto L95;
    L68:
        return null;
    L95:
        r4.close();     // Catch: Exception -> L83
        goto L68
    L103:
        r5.release();     // Catch: Exception -> L84
        goto L66
    L14:
        if (new File(this.cacheDir).exists() == false) goto L16;
        File r1 = new File(getCachePath());     // Catch: Throwable -> L56
        r4 = new RandomAccessFile(r1, "rwd");     // Catch: Throwable -> L56
        r5 = r4.getChannel().lock();     // Catch: Throwable -> L54
    L52:
        th = th;
        goto L105
    L22:
        if (r1.isFile() == false) goto L46;
        byte[] r6 = new byte[2049];     // Catch: Throwable -> L52
        int r7 = r4.read(r6, 0, 2049);     // Catch: Throwable -> L52
        if (r7 <= 0) goto L46;
        if (r7 >= 2049) goto L46;
        this.mCachedParams = json2Map(decrypt(Arrays.copyOf(r6, r7)));     // Catch: Throwable -> L52
        if (TextUtils.isEmpty(r9) == true) goto L29;
        String r2 = this.mCachedParams.get(r9);     // Catch: Throwable -> L52
        if (DrLog.debug() == false) goto L39;
        DrLog.v("get key = " + r9 + " value = " + r2 + " way = file dir = " + getCachePath());     // Catch: Throwable -> L52
    L39:
        if (this.mCachedParams != null) goto L41;
        this.mCachedParams = new ConcurrentHashMap();
    L41:
        if (r5 == null) goto L111;
        r5.release();     // Catch: Exception -> L80
    L111:
        r4.close();     // Catch: Exception -> L81
    L44:
        return r2;
    L29:
        if (this.mCachedParams != null) goto L31;
        this.mCachedParams = new ConcurrentHashMap();
    L31:
        if (r5 != null) goto L99;
    L93:
        r4.close();     // Catch: Exception -> L79
    L34:
        return null;
    L99:
        r5.release();     // Catch: Exception -> L78
    L46:
        if (this.mCachedParams != null) goto L48;
        this.mCachedParams = new ConcurrentHashMap();
    L48:
        if (r5 == null) goto L95;
        r5.release();     // Catch: Exception -> L82
    L54:
        th = th;
        r5 = null;
        goto L105
    L16:
        if (this.mCachedParams != null) goto L18;
        this.mCachedParams = new ConcurrentHashMap();
    L18:
        return null;
    }

    private Map<String, String> json2Map(String r4) throws JSONException {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        JSONObject r3 = new JSONObject(r4);
        Iterator<String> r5 = r3.keys();
        ConcurrentHashMap r0 = new ConcurrentHashMap();
    L8:
        if (r5.hasNext() == false) goto L10;
        String r1 = r5.next();
        r0.put(r1, (String) r3.get(r1));
        goto L8
    L10:
        return r0;
    L5:
        return new ConcurrentHashMap();
    }

    private void storeValue(String r3, String r4) {
        if (this.mCachedParams != null) goto L8;
        getStorageValue(null);
        if (this.mCachedParams != null) goto L8;
        this.mCachedParams = new ConcurrentHashMap();
    L8:
        if (Utils.equal(this.mCachedParams.get(r3), r4) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r4) == false) goto L16;
        if (this.mCachedParams.containsKey(r3) == false) goto L16;
        this.mCachedParams.remove(r3);
    L19:
        if (this.mEnableWrite == true) goto L21;
        return;
    L21:
        if (this.mIsDelayingToWrite.compareAndSet(false, true) == false) goto L25;
        ExecutorUtil.getHandler().postDelayed(new AnonymousClass1(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        this.mCachedParams.put(r3, r4);
        goto L19
    }

    private void write(String r6) {
        if ("mounted".equals(this.mState) == true) goto L5;
        return;
    L5:
        FileLock r0 = null;
        File r1 = new File(this.cacheDir);     // Catch: Throwable -> L19
        if (r1.exists() == false) goto L9;
    L11:
        RandomAccessFile r2 = new RandomAccessFile(new File(getCachePath()), "rwd");     // Catch: Throwable -> L19
        r0 = r2.getChannel().lock();     // Catch: Throwable -> L17
        byte[] r5 = encrypt(r6);     // Catch: Throwable -> L17
        r2.setLength(0);     // Catch: Throwable -> L17
        r2.write(r5);     // Catch: Throwable -> L17
        if (r0 != null) goto L48;
    L40:
        r2.close();     // Catch: Exception -> L36
        return;
    L57:
        return;
    L48:
        r0.release();     // Catch: Exception -> L35
    L17:
        th = th;
    L42:
    L29:
        th = move-exception;
        if (r0 != null) goto L50;
    L32:
        if (r2 == null) goto L58;
        r2.close();     // Catch: Exception -> L39
        throw th;
    L59:
        throw th;
    L58:
        throw th;
    L50:
        r0.release();     // Catch: Exception -> L38
        goto L32
    L22:
        if ((th instanceof IOException) == true) goto L24;
        th.printStackTrace();     // Catch: Throwable -> L29
    L24:
        if (r0 != null) goto L44;
    L26:
        if (r2 != null) goto L40;
        return;
    L44:
        r0.release();     // Catch: Exception -> L37
        goto L26
    L9:
        if (r1.mkdirs() == true) goto L11;
        return;
    L19:
        th = th;
        r2 = null;
        goto L42
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r4.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        if (this.mCachedParams == null) goto L10;
        this.mCachedParams.remove(r1);
    L10:
        storeValue(r1, null);
        goto L6
    L11:
        super.clear(r4);
    }

    private String map2Json(Map<String, String> r3) throws JSONException {
        if (r3 != null) goto L5;
        return "";
    L5:
        JSONObject r2 = new JSONObject();
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, String> r0 = r4.next();
        r2.put(r0.getKey(), r0.getValue());
        goto L7
    L10:
        return r2.toString();
    }

    private String decrypt(byte[] r2) {
        if (sCipherTextCache == null) goto L9;
        if (Arrays.equals(r2, (byte[]) sCipherTextCache.first) == false) goto L9;
        return (String) sCipherTextCache.second;
    L9:
        if (sClearTextCache != null) goto L11;
    L21:
        String r1 = StringEncryptUtils.decryptAES(r2, this.mKey);     // Catch: Throwable -> L16
    L18:
        if (r1 == null) goto L20;
        sCipherTextCache = new Pair(r2, r1);
    L20:
        return r1;
    L16:
        th = move-exception;
        th.printStackTrace();
        r1 = null;
        goto L18
    L11:
        if (Arrays.equals(r2, (byte[]) sClearTextCache.second) == false) goto L21;
        return (String) sClearTextCache.first;
    }

    private byte[] encrypt(String r2) {
        if (sClearTextCache == null) goto L9;
        if (Utils.equal(r2, (String) sClearTextCache.first) == false) goto L9;
        return (byte[]) sClearTextCache.second;
    L9:
        if (sCipherTextCache != null) goto L11;
    L21:
        byte[] r1 = StringEncryptUtils.encryptAES(r2, this.mKey);     // Catch: Throwable -> L16
    L18:
        if (r1 == null) goto L20;
        sClearTextCache = new Pair(r2, r1);
    L20:
        return r1;
    L16:
        th = move-exception;
        th.printStackTrace();
        r1 = null;
        goto L18
    L11:
        if (Utils.equal(r2, (String) sCipherTextCache.second) == false) goto L21;
        return (byte[]) sCipherTextCache.first;
    }
}
