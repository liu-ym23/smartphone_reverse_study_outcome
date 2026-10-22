package com.bytedanceos.application;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAntiFraudRuleExpiry;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import com.obric.securitycenter.api.AppNetworkController;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AppEntry {
    private static final int GXB_QUERY_BATCH_SIZE = 500;
    private final String TAG;
    public boolean isDoppleganger;
    public Context mContext;
    private volatile Drawable mIcon;
    private ApplicationInfo mInfo;
    private volatile boolean mIsGxbForbidRun;
    private String mLabel;
    public LabelEntry mLabelEntry;
    private int mMode;
    private PackageManager mPm;

    public AppEntry(Context context, ApplicationInfo info) {
        this.TAG = "AppEntry";
        this.mLabel = null;
        this.mIcon = null;
        this.isDoppleganger = false;
        this.mInfo = null;
        this.mMode = OpsManagerHelper.get_MODE_ALLOWED();
        this.mIsGxbForbidRun = false;
        this.mInfo = info;
        this.mContext = context;
        this.mPm = context.getPackageManager();
        ensureLabel();
    }

    private String trimLabel(CharSequence label) {
        String r1 = label.toString().trim();
    L4:
        if (r1.length() <= 0) goto L8;
        if (r1.charAt(0) != 160) goto L8;
        r1 = r1.substring(1);
    L8:
        return r1;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mInfo;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void ensureIcon() {
        if (this.mIcon != null) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.mIcon != null) goto L12;
        this.mIcon = this.mInfo.loadIcon(this.mPm);     // Catch: Throwable -> L14
        if (UserHandle.getUserId(this.mInfo.uid) != 10) goto L12;
        if (this.mIcon == null) goto L12;
        this.isDoppleganger = true;     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    }

    public Drawable getIcon() {
        if (this.mIcon != null) goto L6;
        ensureIcon();
    L6:
        return this.mIcon;
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }

    public void setMode(int mode) {
        this.mMode = mode;
    }

    public int getMode() {
        return this.mMode;
    }

    public String getPackageName() {
        return this.mInfo.packageName;
    }

    public boolean isGxbForbidRun() {
        return this.mIsGxbForbidRun;
    }

    public void setGxbForbidRun(boolean forbidRun) {
        this.mIsGxbForbidRun = forbidRun;
    }

    public static void ensureGxbForbidRunBatch(Context context, List<AppEntry> entries) {
        if (context == null) goto L84;
        if (entries != null) goto L6;
        return;
    L6:
        if (entries.isEmpty() == true) goto L86;
        HashSet r1 = new HashSet();     // Catch: Throwable -> L50
        Iterator<AppEntry> r2 = entries.iterator();     // Catch: Throwable -> L50
    L10:
        if (r2.hasNext() == false) goto L19;
        AppEntry r3 = r2.next();     // Catch: Throwable -> L50
        if (r3 == null) goto L10;
        ApplicationInfo r4 = r3.mInfo;     // Catch: Throwable -> L50
        if (r4 == null) goto L10;
        if (r4.packageName == null) goto L10;
        r1.add(r3.mInfo.packageName);     // Catch: Throwable -> L50
        goto L10
    L19:
        if (r1.isEmpty() == false) goto L21;
        return;
    L21:
        List<GxbAntiFraudRuleItem> r5 = queryGxbRulesByPackageNames(context, r1);     // Catch: Throwable -> L50
        HashSet r6 = new HashSet();     // Catch: Throwable -> L50
        if (r5 == null) goto L35;
        Iterator<GxbAntiFraudRuleItem> r7 = r5.iterator();     // Catch: Throwable -> L50
    L25:
        if (r7.hasNext() == false) goto L35;
        GxbAntiFraudRuleItem r8 = r7.next();     // Catch: Throwable -> L50
        if (r8.getRuleType() == 3) goto L31;
        if (r8.getRuleType() != 4) goto L25;
    L31:
        if (GxbAntiFraudRuleExpiry.isExpired(r8) == true) goto L25;
        if (r8.getPacketName() == null) goto L25;
        r6.add(r8.getPacketName());     // Catch: Throwable -> L50
    L35:
        Iterator r9 = r6.iterator();     // Catch: Throwable -> L50
    L37:
        if (r9.hasNext() == false) goto L39;
        String r10 = (String) r9.next();     // Catch: Throwable -> L50
        OLog.d("AppEntry", "ensureGxbForbidRunBatch hit, pkg=" + r10 + ", blockAllNetwork=" + AppNetworkController.blockAllNetwork(context, r10));     // Catch: Throwable -> L50
        goto L37
    L39:
        Iterator<AppEntry> r11 = entries.iterator();     // Catch: Throwable -> L50
    L40:
        if (r11.hasNext() == false) goto L87;
        AppEntry r12 = r11.next();     // Catch: Throwable -> L50
        if (r12 == null) goto L40;
        ApplicationInfo r13 = r12.mInfo;     // Catch: Throwable -> L50
        if (r13 == null) goto L40;
        if (r13.packageName == null) goto L40;
        r12.markGxbForbidRun(r6.contains(r12.mInfo.packageName));     // Catch: Throwable -> L50
        goto L40
    L87:
        return;
    L50:
        th = move-exception;
        OLog.e("AppEntry", "ensureGxbForbidRunBatch failed", th);
        return;
    L86:
        return;
    }

    private static List<GxbAntiFraudRuleItem> queryGxbRulesByPackageNames(Context context, Set<String> packageNames) {
        ArrayList r0 = new ArrayList(packageNames);
        ArrayList r6 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        int r2 = r1 + 500;
        int r3 = Math.min(r2, r0.size());
        r6.addAll(AntiFraudDatabase.getDatabase(context).gxbAntiFraudRuleDao().getByPacketNames(r0.subList(r1, r3)));
        r1 = r2;
        goto L4
    L6:
        return r6;
    }

    public boolean ensureGxbForbidRun() {
        if (this.mContext == null) goto L29;
        ApplicationInfo r0 = this.mInfo;
        if (r0 == null) goto L29;
        if (r0.packageName == null) goto L29;
        List<GxbAntiFraudRuleItem> r1 = AntiFraudDatabase.getDatabase(this.mContext).gxbAntiFraudRuleDao().getByPacketName(this.mInfo.packageName);     // Catch: Throwable -> L24
        if (r1 == null) goto L21;
        Iterator<GxbAntiFraudRuleItem> r2 = r1.iterator();     // Catch: Throwable -> L24
    L13:
        if (r2.hasNext() == false) goto L21;
        GxbAntiFraudRuleItem r3 = r2.next();     // Catch: Throwable -> L24
        if (r3.getRuleType() == 3) goto L19;
        if (r3.getRuleType() != 4) goto L13;
    L19:
        if (GxbAntiFraudRuleExpiry.isExpired(r3) == true) goto L13;
        boolean r4 = true;
    L22:
        applyGxbForbidRun(r4);     // Catch: Throwable -> L24
    L27:
        return this.mIsGxbForbidRun;
    L21:
        r4 = false;
    L24:
        th = move-exception;
        OLog.e("AppEntry", "ensureGxbForbidRun failed, pkg=" + this.mInfo.packageName, th);
    L29:
        return this.mIsGxbForbidRun;
    }

    private void applyGxbForbidRun(boolean hit) {
        markGxbForbidRun(hit);
        if (hit == false) goto L6;
        OLog.d("AppEntry", "ensureGxbForbidRun hit, pkg=" + this.mInfo.packageName + ", blockAllNetwork=" + AppNetworkController.blockAllNetwork(this.mContext, this.mInfo.packageName));
        return;
    }

    private void markGxbForbidRun(boolean hit) {
        this.mIsGxbForbidRun = hit;
        if (hit == false) goto L6;
        this.mMode = OpsManagerHelper.get_MODE_IGNORED();
        return;
    }

    private void ensureLabel() {
        if (this.mPm != null) goto L5;
        return;
    L5:
        LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(this.mPm, this.mInfo.packageName);
        if (r0 == null) goto L8;
        this.mLabel = r0.label;
        return;
    L8:
        this.mLabel = trimLabel(this.mInfo.loadLabel(this.mPm));
    }

    public void ensureLabelEntry() {
        if (this.mPm != null) goto L5;
        return;
    L5:
        LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(this.mPm, this.mInfo.packageName);
        this.mLabelEntry = r0;
        if (r0 != null) goto L9;
        this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(this.mLabel);
        return;
    }
}
