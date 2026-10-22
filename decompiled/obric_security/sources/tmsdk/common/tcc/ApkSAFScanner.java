package tmsdk.common.tcc;

import android.provider.saf.DocumentFile;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import tmsdkobf.c2;
import tmsdkobf.q8;
import tmsdkobf.ve;

/* JADX INFO: loaded from: classes5.dex */
public class ApkSAFScanner {
    public static final String ANDROID_DATA = "/Android/data";
    public static final int FULL_SCAN_DEEP = -1;
    public static final String TAG = "apk_scan_saf";
    public static final int mDeepCleanSAF = 5;
    public static int mFastScanDeep = 5;
    public static int mFitScanDeep = 7;
    private volatile boolean mCancel;
    protected onSAFFoundListener mFoundListener;
    private String[] mSuffix;
    private String[] mWhiteDir;

    public interface onSAFFoundListener {
        void onSAFFound(String r1, String r2, long r3);
    }

    static {
    }

    public ApkSAFScanner() {
        this.mCancel = false;
    }

    private void traverseNormal(DocumentFile r12, String r13, int r14, int r15) {
        if (r12 == null) goto L39;
        if (r13 != null) goto L6;
        return;
    L6:
        if (r15 == (-1)) goto L9;
        if (r14 < r15) goto L9;
        return;
    L9:
        DocumentFile[] r16 = r12.listFiles();
        int r0 = r16.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L53;
        DocumentFile r3 = r16[r2];
        if (r3 == null) goto L38;
        if (this.mCancel == true) goto L16;
        if (r3.isDirectory() == false) goto L29;
        String r4 = r13 + LibrarianImpl.Constants.SEPARATOR + r3.getName();
        String[] r5 = this.mWhiteDir;
        if (r5 == null) goto L27;
        int r6 = r5.length;
        int r7 = 0;
    L22:
        if (r7 >= r6) goto L27;
        if (TextUtils.equals((ANDROID_DATA + r5[r7]).toLowerCase(), r4.toLowerCase()) == true) goto L38;
        r7 = r7 + 1;
    L27:
        traverseNormal(r3, r4, r14 + 1, r15);
        goto L38
    L29:
        if (r3.isFile() == false) goto L38;
        String r8 = r3.getName();
        String r9 = r13 + LibrarianImpl.Constants.SEPARATOR + r8;
        String[] r10 = this.mSuffix;
        int r11 = r10.length;
        int r17 = 0;
    L31:
        if (r17 >= r11) goto L38;
        if (r8.toLowerCase().endsWith(r10[r17].toLowerCase()) == true) goto L34;
        r17 = r17 + 1;
        goto L31
    L34:
        onSAFFoundListener r18 = this.mFoundListener;
        if (r18 == null) goto L38;
        r18.onSAFFound(r3.getName(), r9, r3.length());
        goto L38
    L16:
        q8.a(TAG, "cancel now | traverseNormal");
        return;
    L38:
        r2 = r2 + 1;
        goto L10
    L53:
        return;
    }

    public void cancel() {
        this.mCancel = true;
    }

    public void release() {
        this.mCancel = true;
        this.mFoundListener = null;
    }

    public void scanApk(String r8, onSAFFoundListener r9) {
        scanApk(r8, new String[]{"apk"}, new String[]{new String(c2.e)}, r9, mFitScanDeep);
    }

    public void scanApk(String r8, onSAFFoundListener r9, int r10) {
        scanApk(r8, new String[]{"apk"}, new String[]{new String(c2.e)}, r9, r10);
    }

    private void scanApk(String r1, String[] r2, String[] r3, onSAFFoundListener r4, int r5) {
        boolean r0 = ve.f581a;
    }
}
