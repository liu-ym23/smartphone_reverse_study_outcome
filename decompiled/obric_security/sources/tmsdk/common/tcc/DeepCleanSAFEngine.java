package tmsdk.common.tcc;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.saf.DocumentFile;
import android.provider.saf.TreeDocumentFile;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.TMSDKContext;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class DeepCleanSAFEngine implements IDeepCleanEngine {
    private static final int PATTERN_LONGER_PATH = -1;
    private static final int PATTERN_MATCH_PATH = 0;
    private static final int PATTERN_NOT_MATCH_PATH = -2;
    private static final int PATTERN_SHORTER_PATH = 1;
    public static final String ROOT_DIR_URI_STR = null;
    private static final String SD_PREFIX = null;
    static final int STATE_IN_DETAILPATH = 2;
    static final int STATE_IN_ROOTPATH = 1;
    static final int STATE_NONE = 0;
    public static final String TAG = "SAFE";
    private static final boolean mFastTest = false;
    private static final String mFastTestMatch = "com.zhuoyi.appstore.lite";
    private DeepCleanEngine.Callback mCallback;
    private Object mLock;
    HashMap<String, List<DetailPath>> mRootPaths;
    private volatile boolean mScanCancel;
    private DeepCleanEngine mUtil;
    private List<String> mWhiteList;

    public static class DetailPath {
        public static final char ATIME = '6';
        public static final char CTIME = '4';
        public static final char DETAIL_PATH = '1';
        public static final char FILENAME = '2';
        public static final char FILESIZE = '3';
        public static final char IMPORTANT = '7';
        public static final char KEY = '0';
        public static final char MTIME = '5';
        public boolean isApkDelete;
        public String mATime;
        public String mCTime;
        public String mDetailPath;
        public String mFileName;
        public String mFileSize;
        public int mID;
        public int mImportance;
        public String mMTime;
        public String mRootPath;

        public DetailPath() {
            this.mImportance = -1;
        }

        public static List<DetailPath> str2DetailRuleList(String r12) {
            if (r12 != null) goto L6;
            return null;
        L6:
            if (r12.length() >= 2) goto L8;
            return null;
        L8:
            String r13 = r12.substring(2);
            ArrayList r1 = new ArrayList();
            String[] r14 = r13.split(";");
            if (r14 != null) goto L11;
            return null;
        L11:
            int r0 = r14.length;
            int r3 = 0;
        L12:
            if (r3 >= r0) goto L48;
            String[] r4 = r14[r3].split(":");
            if (r4 == null) goto L47;
            DetailPath r5 = new DetailPath();
            int r6 = r4.length;
            int r7 = 0;
        L17:
            if (r7 >= r6) goto L41;
            String r8 = r4[r7];
            if (r8.length() == 0) goto L39;
            if (r8.charAt(0) != '0') goto L25;
            r5.mID = Integer.valueOf(r8.substring(1)).intValue();
            goto L39
        L25:
            if (r8.charAt(0) != '1') goto L28;
            r5.mDetailPath = r8.substring(1);
            goto L39
        L28:
            if (r8.charAt(0) != '7') goto L31;
            r5.mImportance = Integer.valueOf(r8.substring(1)).intValue();
            goto L39
        L31:
            if (r8.charAt(0) != '2') goto L34;
            r5.mFileName = r8.substring(1);
            goto L39
        L34:
            if (r8.charAt(0) != '3') goto L37;
            r5.mFileSize = r8.substring(1);
            goto L39
        L37:
            if (r8.charAt(0) != '5') goto L39;
            r5.mMTime = r8.substring(1);
        L39:
            r7 = r7 + 1;
            goto L17
        L41:
            if (r5.mID == 0) goto L47;
            if (r5.mDetailPath == null) goto L47;
            if (r5.mImportance == (-1)) goto L47;
            r1.add(r5);
        L47:
            r3 = r3 + 1;
            goto L12
        L48:
            return r1;
        }
    }

    public static class ScanContext {
        public DetailPath mCurDetailPath;
        public int mState;
        public String mcurRootPath;

        public ScanContext() {
            this.mState = 0;
        }

        public ScanContext(int r1) {
            this.mState = r1;
        }

        public ScanContext(int r1, String r2, DetailPath r3) {
            this.mState = r1;
            this.mcurRootPath = r2;
            this.mCurDetailPath = r3;
        }
    }

    public static class ScanResult {
        public DetailPath mDetailPath;
        public List<String> mPaths;
        public long mTotalSize;

        public ScanResult() {
            this.mPaths = new ArrayList();
            this.mTotalSize = 0;
        }
    }

    static {
        if (Build.VERSION.SDK_INT != 30) goto L5;
        String r0 = "content://com.android.externalstorage.documents/tree/primary%3A/document/primary%3A";
    L6:
        ROOT_DIR_URI_STR = r0;
        SD_PREFIX = Environment.getExternalStorageDirectory().getAbsolutePath();
        return;
    L5:
        r0 = "content://com.android.externalstorage.documents/tree/primary%3AA%E2%80%8Bndroid%2Fdata/document/primary%3A";
        goto L6
    }

    public DeepCleanSAFEngine(DeepCleanEngine.Callback r3) {
        this.mLock = new Object();
        this.mRootPaths = new HashMap();
        this.mUtil = new DeepCleanEngine(null);
        this.mScanCancel = false;
        this.mCallback = r3;
    }

    public static List<DocumentFile> getDocumenFiles(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        DocumentFile r4 = uri2DocumentFile(ROOT_DIR_URI_STR + r3.substring(1).replace(LibrarianImpl.Constants.SEPARATOR, "%2F"));
        if (r4 != null) goto L8;
    L10:
        return r0;
    L8:
        if (r4.exists() == false) goto L10;
        r0.add(r4);
        goto L10
    }

    private int isMatchPath(int r2, String r3, DetailPath r4) {
        if (r3.length() != r2) goto L5;
        String r5 = LibrarianImpl.Constants.SEPARATOR;
    L7:
        return this.mUtil.isMatchPath(r5, r4.mDetailPath);
    L5:
        r5 = r3.substring(r2);
        goto L7
    }

    private boolean isPureDirRule(DetailPath r1) {
        if (r1.mFileSize == null) goto L5;
        return false;
    L5:
        if (r1.mMTime == null) goto L7;
        return false;
    L7:
        if (r1.mFileName != null) goto L13;
        return true;
    L13:
        return false;
    }

    private void traverseInDetailPath(DocumentFile r23, String r24, String r25, List<DetailPath> r26) {
        String r2 = r24;
        String r3 = r25;
        List<DetailPath> r4 = r26;
        q8.c("xxq", "traverseInDetailPath:" + r2);
        if (r23 == null) goto L140;
        if (r2 == null) goto L180;
        if (r3 == null) goto L181;
        if (r4 == null) goto L183;
        Iterator<DetailPath> r5 = r26.iterator();
        ArrayList r8 = null;
        ArrayList r9 = null;
    L10:
        if (r5.hasNext() == false) goto L23;
        DetailPath r10 = r5.next();
        if (this.mScanCancel == true) goto L13;
        int r11 = isMatchPath(r25.length(), r2, r10);
        if (r11 == (-2)) goto L16;
        if (r11 < 0) goto L10;
        if (r9 != null) goto L22;
        r9 = new ArrayList();
    L22:
        r9.add(r10);
        goto L10
    L16:
        if (r8 != null) goto L18;
        r8 = new ArrayList();
    L18:
        r8.add(r10);
        goto L10
    L13:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 1");
    L23:
        if (r8 == null) goto L26;
        List<DetailPath> r6 = new ArrayList();
        r6.addAll(r4);
        r6.removeAll(r8);
        r4 = r6;
    L26:
        if (r4.isEmpty() == true) goto L42;
        if (r9 != null) goto L29;
    L31:
        if (r9 != null) goto L73;
        Iterator<DetailPath> r7 = r4.iterator();
    L34:
        if (r7.hasNext() == false) goto L178;
        DetailPath r15 = r7.next();
        if (this.mScanCancel == true) goto L37;
        if (r15.mImportance != 1) goto L34;
    L37:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 3");
        return;
    L178:
        return;
    L73:
        DocumentFile[] r1 = r23.listFiles();
        int r12 = r1.length;
        int r13 = 0;
    L74:
        if (r13 >= r12) goto L184;
        DocumentFile r14 = r1[r13];
        if (this.mScanCancel == true) goto L77;
        if (r14 != null) goto L80;
    L136:
        DocumentFile[] r27 = r1;
    L137:
        List<DetailPath> r28 = r4;
    L139:
        r13 = r13 + 1;
        r1 = r27;
        r2 = r24;
        r3 = r25;
        r4 = r28;
        goto L74
    L80:
        if (r14.getName() == null) goto L136;
        String r16 = r2 + LibrarianImpl.Constants.SEPARATOR + r14.getName().toLowerCase();
        if (r14.isDirectory() == false) goto L85;
        traverseInDetailPath(r14, r16, r3, r4);
        goto L136
    L85:
        if (r9 == null) goto L136;
        Iterator r17 = r9.iterator();
        ArrayList r18 = null;
    L89:
        if (r17.hasNext() == false) goto L111;
        DetailPath r19 = (DetailPath) r17.next();
        r27 = r1;
        if (this.mScanCancel == true) goto L92;
        if (r19.mFileName == null) goto L99;
        if (matchFile(r14.getName().toLowerCase(), r19.mFileName.toLowerCase()) == true) goto L99;
    L107:
        r1 = r27;
    L99:
        if (r19.mFileSize == null) goto L104;
        if (matchFileSize(r14.length(), r19.mFileSize.toLowerCase()) == false) goto L107;
    L104:
        if (r19.mMTime != null) goto L106;
    L108:
        if (r18 != null) goto L110;
        r18 = new ArrayList();
    L110:
        r18.add(r19);
        goto L107
    L106:
        if (matchTime(r14.lastModified(), r19.mMTime.toLowerCase()) == true) goto L108;
    L92:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 5");
    L112:
        if (r18 == null) goto L137;
        Iterator r20 = r18.iterator();
        DetailPath r21 = null;
    L116:
        if (r20.hasNext() == false) goto L127;
        DetailPath r22 = (DetailPath) r20.next();
        if (this.mScanCancel == true) goto L119;
        if (r22.mDetailPath == null) goto L116;
        if (r21 == null) goto L126;
        if (r21.mDetailPath.length() >= r22.mDetailPath.length()) goto L116;
    L126:
        r21 = r22;
        goto L116
    L119:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 6");
    L127:
        if (r21 == null) goto L137;
        if (r21.mImportance == 0) goto L137;
        long r110 = r14.length();
        ScanResult r29 = new ScanResult();
        r29.mDetailPath = r21;
        r29.mPaths.add(r16);
        r28 = r4;
        r29.mTotalSize += r110;
        if (this.mCallback == null) goto L139;
        if (".nomedia".equals(r14.getName().toLowerCase()) == true) goto L139;
        String r30 = SD_PREFIX + r16;
        q8.c("xxq", "traverseInDetailPath onFoundSoftRubbish:" + r30 + " " + r110);
        this.mCallback.onFoundSoftRubbish(String.valueOf(r21.mID), r30, null, r29.mTotalSize * 1000);
        goto L139
    L111:
        r27 = r1;
        goto L112
    L77:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 4");
        return;
    L184:
        return;
    L29:
        if (r4.size() != r9.size()) goto L31;
    L42:
        if (r9 != null) goto L45;
        return;
    L45:
        if (r9.size() == 1) goto L47;
        Iterator r31 = r9.iterator();
        DetailPath r32 = null;
    L51:
        if (r31.hasNext() == false) goto L64;
        DetailPath r111 = (DetailPath) r31.next();
        if (this.mScanCancel == true) goto L54;
        if (r111.mDetailPath == null) goto L51;
        if (r32 != null) goto L60;
    L63:
        r32 = r111;
        goto L51
    L60:
        if (r32.mDetailPath.length() >= r111.mDetailPath.length()) goto L51;
    L54:
        q8.c(TAG, "mScanCancel > traverseInDetailPath 2");
    L64:
        if (r32 == null) goto L73;
        if (r32.mImportance != 1) goto L73;
        if (isPureDirRule(r32) == false) goto L73;
        ScanResult r33 = new ScanResult();
        r33.mDetailPath = r32;
        r33.mPaths.add(r2);
        r33.mTotalSize += r23.length();
        traversePureDetailPath(r23, r2, r3, r33);
        if (this.mCallback == null) goto L179;
        StringBuilder r34 = new StringBuilder("traversePureDetailPath onFoundSoftRubbish:");
        String r35 = SD_PREFIX;
        q8.c("xxq", r34.append(r35).append(r2).append(" ").append(r33.mTotalSize).toString());
        this.mCallback.onFoundSoftRubbish(String.valueOf(r32.mID), r35 + r2, null, r33.mTotalSize * 1000);
        return;
    L179:
        return;
    L47:
        if (((DetailPath) r9.get(0)).mImportance != 0) goto L73;
        return;
    L183:
        return;
    L181:
        return;
    L180:
        return;
    }

    private void traverseInRootPath(DocumentFile r6, String r7, String r8, List<DetailPath> r9) {
        q8.c("xxq", "traverseInRootPath absPath:" + r7);
        if (r6 == null) goto L40;
        if (r7 == null) goto L41;
        if (r8 == null) goto L42;
        if (r9 == null) goto L43;
        Iterator<DetailPath> r10 = r9.iterator();
        ArrayList r0 = null;
        ArrayList r1 = null;
    L10:
        if (r10.hasNext() == false) goto L23;
        DetailPath r2 = r10.next();
        if (this.mScanCancel == true) goto L13;
        int r3 = isMatchPath(r8.length(), r7, r2);
        if (r3 == (-1)) goto L16;
        if (r3 < 0) goto L10;
        if (r1 != null) goto L22;
        r1 = new ArrayList();
    L22:
        r1.add(r2);
        goto L10
    L16:
        if (r0 != null) goto L18;
        r0 = new ArrayList();
    L18:
        r0.add(r2);
        goto L10
    L13:
        q8.c(TAG, "mScanCancel > traverseInRootPath");
    L23:
        if (r0 != null) goto L26;
        if (r1 != null) goto L26;
        return;
    L26:
        if (r0 != null) goto L29;
        if (r1 == null) goto L29;
        r0 = r1;
    L29:
        traverseInDetailPath(r6, r7, r8, r0);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    }

    private void traverseNormal(DocumentFile r6, String r7, int r8, int r9) {
        q8.c("xxq", "traverseNormal:" + r7 + " " + r6.getUri());
        if (r7 != null) goto L6;
        return;
    L6:
        if (r9 == (-1)) goto L9;
        if (r8 < r9) goto L9;
        return;
    L9:
        List<String> r0 = this.mWhiteList;
        if (r0 == null) goto L20;
        if (r0.isEmpty() == true) goto L20;
        Iterator<String> r1 = this.mWhiteList.iterator();
    L15:
        if (r1.hasNext() == false) goto L20;
        if (TextUtils.equals(r1.next().toLowerCase(), r7.toLowerCase()) == false) goto L15;
        return;
    L20:
        if (this.mRootPaths.containsKey(r7) == false) goto L25;
        List<DetailPath> r10 = this.mRootPaths.get(r7);
        if (r10 != null) goto L24;
        r10 = DetailPath.str2DetailRuleList(this.mCallback.getDetailRule(r7));
        this.mRootPaths.put(r7, r10);
    L24:
        traverseInRootPath(r6, r7, r7, r10);
        return;
    L25:
        DocumentFile[] r11 = r6.listFiles();
        int r12 = r8 + 1;
        int r2 = r11.length;
        int r3 = 0;
    L26:
        if (r3 >= r2) goto L43;
        DocumentFile r4 = r11[r3];
        if (this.mScanCancel == true) goto L29;
        if (r4.isDirectory() == false) goto L33;
        traverseNormal(r4, r7 + LibrarianImpl.Constants.SEPARATOR + r4.getName().toLowerCase(), r12, r9);
    L33:
        r3 = r3 + 1;
        goto L26
    L29:
        q8.c(TAG, "mScanCancel > traverseNormal");
        return;
    }

    private void traversePureDetailPath(DocumentFile r8, String r9, String r10, ScanResult r11) {
        q8.c("xxq", "traversePureDetailPath:" + r9);
        if (r8 == null) goto L21;
        if (r9 == null) goto L26;
        if (r10 == null) goto L27;
        if (r11 == null) goto L29;
        DocumentFile[] r12 = r8.listFiles();
        int r0 = r12.length;
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L30;
        DocumentFile r2 = r12[r1];
        if (this.mScanCancel == true) goto L12;
        if (r2.isDirectory() == false) goto L19;
        String r3 = r2.getName();
        if (r3 == null) goto L20;
        traversePureDetailPath(r2, r9 + LibrarianImpl.Constants.SEPARATOR + r3.toLowerCase(), r10, r11);
    L20:
        r1 = r1 + 1;
    L19:
        r11.mTotalSize += r2.length();
        goto L20
    L12:
        q8.c(TAG, "mScanCancel > traversePureDetailPath");
        return;
    L30:
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    }

    public static DocumentFile uri2DocumentFile(String r3) {
        if (r3 == null) goto L6;
        Uri r4 = Uri.parse(r3);
        return new TreeDocumentFile(null, TMSDKContext.getApplicaionContext(), r4);
    L6:
        return null;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void cancel() {
        this.mScanCancel = true;
        q8.c(TAG, "mScanCancel > cancel");
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public String getDetailRule(String r1) {
        return null;
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public boolean init() {
        System.loadLibrary("dce-1.1.28-mfr");
        this.mScanCancel = false;
        q8.c(TAG, "mScanCancel > init");
        return true;
    }

    public boolean matchComRule(String r1, String r2, String r3) {
        return this.mUtil.isMatchComRule(r1, r2, r3);
    }

    public boolean matchFile(String r1, String r2) {
        return this.mUtil.isMatchFile(r1, r2);
    }

    public boolean matchFileSize(long r1, String r3) {
        return this.mUtil.isMatchFileSize(r1, r3);
    }

    public boolean matchPath(String r1, String r2) {
        if (this.mUtil.isMatchPath(r1, r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean matchTime(long r1, String r3) {
        return this.mUtil.isMatchTime(r1, r3);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onDirectoryChange(String r1, int r2) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundComRubbish(String r2, String r3, long r4) {
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        DeepCleanEngine.Callback r1 = this.mCallback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onFoundComRubbish(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        q8.c("TMSDK_", "onFoundComRubbish:" + th);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundEmptyDir(String r2, long r3) {
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        DeepCleanEngine.Callback r1 = this.mCallback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onFoundEmptyDir(r2, r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        q8.c("TMSDK_", "onFoundEmptyDir:" + th);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundKeySoftRubbish(String r2, String[] r3, long r4) {
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        DeepCleanEngine.Callback r1 = this.mCallback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onFoundKeySoftRubbish(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        q8.c("TMSDK_", "onFoundKeySoftRubbish:" + th);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onFoundSoftRubbish(String r8, String r9, String r10, long r11) {
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        DeepCleanEngine.Callback r1 = this.mCallback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onFoundSoftRubbish(r8, r9, r10, r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        q8.c("TMSDK_", "onFoundSoftRubbish:" + th);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onProcessChange(int r2) {
        Object r0 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r0);     // Catch: Throwable -> L12
        DeepCleanEngine.Callback r1 = this.mCallback;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onProcessChange(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        q8.c("TMSDK_", "onProcessChange:" + th);
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void onVisit(String r1, boolean r2, long r3, long r5, long r7, long r9) {
    }

    public void pause() {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void release() {
        this.mScanCancel = true;
        q8.c(TAG, "mScanCancel > release");
    }

    public void resume() {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void scanPath(String r6, String r7) {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L37;
        q8.c(TAG, "scanPath dirPath = " + r7);
        if (r7.toLowerCase().startsWith("/android/data") == false) goto L10;
        r7 = ApkSAFScanner.ANDROID_DATA + r7.substring(13);
        boolean r8 = true;
    L11:
        StringBuilder r3 = new StringBuilder("/A%E2%80%8Bndroid%2Fdata");
        if (r8 == false) goto L14;
        String r9 = r7.substring(13);
    L31:
        List<DocumentFile> r10 = getDocumenFiles(r3.append(r9).toString());     // Catch: Throwable -> L18
    L19:
        if (r10 != null) goto L21;
        return;
    L21:
        if (r10.isEmpty() == true) goto L38;
        Iterator<DocumentFile> r11 = r10.iterator();
    L25:
        if (r11.hasNext() == false) goto L39;
        DocumentFile r1 = r11.next();
        if (this.mScanCancel == true) goto L28;
        traverseNormal(r1, r7.toLowerCase(), 0, 5);
        goto L25
    L28:
        q8.c(TAG, "mScanCancel > scanPath cancel");
        return;
    L39:
        return;
    L38:
        return;
    L18:
        r10 = null;
        goto L19
    L14:
        r9 = r7;
        goto L31
    L10:
        r8 = false;
        goto L11
    }

    public void scanPathFromCache(String r1, String r2, String r3) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setComRubRule(String[] r1) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setOtherFilterRule(String[] r1) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setRootPaths(String[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r6[r1];
        this.mRootPaths.put(r2, null);
        r1 = r1 + 1;
        goto L3
    }

    public void setScanConfig(int r1, String r2) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setUninstallFilterSuffix(String[] r1) {
    }

    @Override // tmsdk.common.tcc.IDeepCleanEngine
    public void setWhitePaths(String[] r2) {
        if (r2 != null) goto L4;
    L9:
        List<String> r1 = this.mWhiteList;
        if (r1 == null) goto L15;
        r1.clear();
        return;
    L15:
        return;
    L4:
        if (r2.length <= 0) goto L9;
        List<String> r0 = this.mWhiteList;
        if (r0 != null) goto L8;
        this.mWhiteList = new ArrayList(Arrays.asList(r2));
        return;
    L8:
        r0.clear();
        this.mWhiteList.addAll(new ArrayList(Arrays.asList(r2)));
    }

    public boolean init(DeepCleanEngine.Callback r1, String[] r2) {
        this.mCallback = r1;
        this.mScanCancel = false;
        return true;
    }
}
