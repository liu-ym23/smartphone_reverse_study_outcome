package tmsdk.fg.module.cleanV2;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.ac;
import tmsdkobf.b0;
import tmsdkobf.f;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class CleanManager extends BaseManagerF {
    public static final int DISK_SCAN_TAG = 0;
    public static final int EASY_SCAN_TAG = 1;
    public static final int ERROR_SCAN_ENGINE_FAILED = -1;
    public static final int ERROR_SCAN_EXCEPTION = -4;
    public static final int ERROR_SCAN_LOAD_APP_RULE_FAILED = -5;
    public static final int ERROR_SCAN_LOAD_RULE_FAILED = -2;
    public static final int ERROR_SCAN_NOT_INIT = -6;
    public static final int ERROR_SCAN_SEARCH_SD_FAILED = -3;
    public static final int PKG_SCAN_TAG = 2;
    public static final int RESERVED_FILE_SCAN_TAG = 3;
    public static final String TAG = "TMSDK_CleanManager";
    a b;

    public CleanManager() {
    }

    public boolean addUninstallPkg(String r1) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.addUninstallPkg(r1);
    }

    public void appendCustomSdcardRoots(String r1) {
        ac.a(r1);
    }

    public boolean cancelClean() {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.cancelClean();
    }

    public boolean cancelScan(int r1) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.cancelScan(r1);
    }

    public boolean cleanRubbish(RubbishHolder r1, boolean r2, ICleanTaskCallBack r3) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.cleanRubbish(r1, r2, r3);
    }

    public boolean cleanRubbishSlow(RubbishHolder r1, boolean r2, ICleanTaskCallBack r3) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.cleanRubbishSlow(r1, r2, r3);
    }

    public void clearCustomSdcardRoots() {
        ac.a();
    }

    public boolean delUninstallPkg(String r1) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.delUninstallPkg(r1);
    }

    public boolean easyScan(IScanTaskCallBack r10, ArrayList<String> r11, Set<String> r12) {
        return easyScan(r10, r11, r12, null, false, true, 5, false);
    }

    public AppGroupDesc getGroupInfo(int r1) {
        a r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGroupInfo(r1);
    }

    public List<String> getSdcardRoots() {
        return new ArrayList(ac.e());
    }

    public void languageChange() {
        a r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.languageChange();
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        a r0 = new a();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void onDestroy() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public boolean scan4app(String r9, ArrayList<String> r10, IScanTaskCallBack r11) {
        return scan4app(r9, r10, false, true, 5, false, r11);
    }

    public boolean scanDisk(IScanTaskCallBack r10, ArrayList<String> r11, Set<String> r12) {
        return scanDisk(r10, r11, r12, null, false, true, 5, false);
    }

    public void setIgnoredSdcardRoots(List<String> r1) {
        ac.c(r1);
    }

    public boolean updateRule(IUpdateCallBack r1, long r2) {
        return updateRule(false, r1);
    }

    public boolean updateRuleAndDatFile(boolean r3, IUpdateCallBack r4) {
        q8.c(TAG, "updateRuleAndDatFile");
        if (this.b != null) goto L6;
        return false;
    L6:
        f.e(29963);
        return this.b.updateRuleAndDatFile(r3, r4);
    }

    public boolean easyScan(IScanTaskCallBack r12, ArrayList<String> r13, Set<String> r14, Set<String> r15, boolean r16, boolean r17, int r18, boolean r19) {
        q8.c(TAG, "easyScan");
        if (this.b != null) goto L6;
        return false;
    L6:
        f.f(1320005);
        return this.b.easyScan(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public boolean scan4app(String r9, ArrayList<String> r10, boolean r11, IScanTaskCallBack r12) {
        return scan4app(r9, r10, r11, true, 5, false, r12);
    }

    public boolean scanDisk(IScanTaskCallBack r12, ArrayList<String> r13, Set<String> r14, Set<String> r15, boolean r16, boolean r17, int r18, boolean r19) {
        q8.c(TAG, "scanDisk");
        if (this.b != null) goto L6;
        q8.b(TAG, "scanDisk: mImpl is null");
        return false;
    L6:
        f.f(29965);
        return this.b.scanDisk(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public boolean updateRule(boolean r3, IUpdateCallBack r4) {
        q8.c(TAG, "updateRule");
        if (this.b != null) goto L6;
        return false;
    L6:
        f.e(29963);
        return this.b.updateRule(r3, r4);
    }

    public boolean easyScan(IScanTaskCallBack r10, ArrayList<String> r11, Set<String> r12, boolean r13) {
        return easyScan(r10, r11, r12, null, r13, true, 5, false);
    }

    public boolean scan4app(String r11, ArrayList<String> r12, boolean r13, boolean r14, int r15, boolean r16, IScanTaskCallBack r17) {
        q8.c(TAG, "scan4app");
        if (this.b != null) goto L6;
        return false;
    L6:
        f.f(29994);
        return this.b.scan4app(r11, r12, r13, r14, r15, r16, r17);
    }

    public boolean scanDisk(IScanTaskCallBack r10, ArrayList<String> r11, Set<String> r12, boolean r13) {
        return scanDisk(r10, r11, r12, null, r13, true, 5, false);
    }

    public boolean easyScan(IScanTaskCallBack r10, Set<String> r11) {
        return easyScan(r10, null, r11, null, false, true, 5, false);
    }

    public boolean scan4app(String r9, IScanTaskCallBack r10) {
        return scan4app(r9, null, false, true, 5, false, r10);
    }

    public boolean scanDisk(IScanTaskCallBack r10, Set<String> r11) {
        return scanDisk(r10, null, r11, null, false, true, 5, false);
    }

    public boolean easyScan(IScanTaskCallBack r10, Set<String> r11, boolean r12) {
        return easyScan(r10, null, r11, null, r12, true, 5, false);
    }

    public boolean scan4app(String r9, boolean r10, IScanTaskCallBack r11) {
        return scan4app(r9, null, r10, true, 5, false, r11);
    }

    public boolean scanDisk(IScanTaskCallBack r10, Set<String> r11, boolean r12) {
        return scanDisk(r10, null, r11, null, r12, true, 5, false);
    }
}
