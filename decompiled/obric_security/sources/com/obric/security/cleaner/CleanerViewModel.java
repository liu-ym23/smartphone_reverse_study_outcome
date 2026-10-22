package com.obric.security.cleaner;

import android.content.Context;
import android.view.Window;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.storage.DefaultMeasurementReceiver;
import com.bytedanceos.storage.StorageMeasurement;
import com.obric.apm.ApmHelper;
import com.obric.security.cleaner.trashclear.CleanStatusCallBack;
import com.obric.security.cleaner.trashclear.DeepScanCallBack;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: compiled from: CleanerViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\u0018\u00002\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020\tJ\u0006\u00104\u001a\u00020\tJ\u0006\u00105\u001a\u00020\tJ\u0006\u00106\u001a\u00020\tJ\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020\tJ\u0006\u00109\u001a\u00020\tJ\u0006\u0010:\u001a\u00020\tJ\u0006\u0010;\u001a\u00020\tJ(\u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020\u0005J\u0010\u0010C\u001a\u0002022\b\u0010D\u001a\u0004\u0018\u00010EJ\u0006\u0010F\u001a\u000202J\u0006\u0010G\u001a\u000202J\u0018\u0010H\u001a\u0002022\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010JH\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u001a\u0010\u001a\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR#\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\b\u0018\u00010!R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\rR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\r¨\u0006M"}, d2 = {"Lcom/obric/security/cleaner/CleanerViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "apkSugSize", "", "getApkSugSize", "()J", "setApkSugSize", "(J)V", "cleanCallBack", "Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "cleanFinished", "getCleanFinished", "cleanProcess", "", "getCleanProcess", "deepScanCallBack", "com/obric/security/cleaner/CleanerViewModel$deepScanCallBack$1", "Lcom/obric/security/cleaner/CleanerViewModel$deepScanCallBack$1;", "scanFinished", "getScanFinished", "softSugtSize", "getSoftSugtSize", "setSoftSugtSize", "storageInfo", "Lkotlin/Pair;", "getStorageInfo", "storageReciver", "Lcom/obric/security/cleaner/CleanerViewModel$StorageStateReceiver;", "systemSugSize", "getSystemSugSize", "setSystemSugSize", "totalSugSize", "getTotalSugSize", "setTotalSugSize", "trashClearHelper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "getTrashClearHelper", "()Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "setTrashClearHelper", "(Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;)V", "uninstallSugtSize", "getUninstallSugtSize", "setUninstallSugtSize", "clearSelected", "", "getApkSuggestSize", "getApkTotalSize", "getSoftSuggestSize", "getSoftTotalSize", "getSystemSuggestSize", "getSystemTotalSize", "getTotalSuggestSize", "getUninstallSuggestSize", "getUninstallTotalSize", "popPermissionDialogIfNeeded", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "from", "", "forceShow", "reFreshStorageState", "measure", "Lcom/bytedanceos/storage/StorageMeasurement;", "removeCallBack", "requestData", "setStatus", "rubbishList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "StorageStateReceiver", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanerViewModel extends ViewModel {
    private final MutableLiveData<Boolean> agreeGrant;
    private long apkSugSize;
    private final CleanStatusCallBack cleanCallBack;
    private final MutableLiveData<Boolean> cleanFinished;
    private final MutableLiveData<Integer> cleanProcess;
    private final CleanerViewModel$deepScanCallBack$1 deepScanCallBack;
    private final MutableLiveData<Boolean> scanFinished;
    private long softSugtSize;
    private final MutableLiveData<Pair<Long, Long>> storageInfo;
    private StorageStateReceiver storageReciver;
    private long systemSugSize;
    private long totalSugSize;
    private TcTrashClearHelper trashClearHelper;
    private long uninstallSugtSize;

    /* JADX INFO: compiled from: CleanerViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/security/cleaner/CleanerViewModel$StorageStateReceiver;", "Lcom/bytedanceos/storage/DefaultMeasurementReceiver;", "(Lcom/obric/security/cleaner/CleanerViewModel;)V", "updateApproximate", "", "meas", "Lcom/bytedanceos/storage/StorageMeasurement;", "totalSize", "", "availSize", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public final class StorageStateReceiver extends DefaultMeasurementReceiver {
        final /* synthetic */ CleanerViewModel this$0;

        public StorageStateReceiver(CleanerViewModel r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedanceos.storage.DefaultMeasurementReceiver, com.bytedanceos.storage.StorageMeasurement.MeasurementReceiver
        public void updateApproximate(StorageMeasurement r2, long r3, long r5) {
            Intrinsics.checkNotNullParameter(r2, "meas");
            super.updateApproximate(r2, r3, r5);
            this.this$0.getStorageInfo().postValue(new Pair(Long.valueOf(r3), Long.valueOf(r5)));
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.security.cleaner.CleanerViewModel$deepScanCallBack$1] */
    public CleanerViewModel() {
        this.scanFinished = new MutableLiveData();
        this.cleanFinished = new MutableLiveData();
        this.cleanProcess = new MutableLiveData();
        this.agreeGrant = new MutableLiveData();
        this.storageInfo = new MutableLiveData();
        this.deepScanCallBack = new CleanerViewModel$deepScanCallBack$1(this);
        this.cleanCallBack = new CleanerViewModel$cleanCallBack$1(this);
    }

    public final TcTrashClearHelper getTrashClearHelper() {
        return this.trashClearHelper;
    }

    public final void setTrashClearHelper(TcTrashClearHelper r1) {
        this.trashClearHelper = r1;
    }

    public final MutableLiveData<Boolean> getScanFinished() {
        return this.scanFinished;
    }

    public final MutableLiveData<Boolean> getCleanFinished() {
        return this.cleanFinished;
    }

    public final MutableLiveData<Integer> getCleanProcess() {
        return this.cleanProcess;
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }

    public final MutableLiveData<Pair<Long, Long>> getStorageInfo() {
        return this.storageInfo;
    }

    public final long getTotalSugSize() {
        return this.totalSugSize;
    }

    public final void setTotalSugSize(long r1) {
        this.totalSugSize = r1;
    }

    public final long getSoftSugtSize() {
        return this.softSugtSize;
    }

    public final void setSoftSugtSize(long r1) {
        this.softSugtSize = r1;
    }

    public final long getUninstallSugtSize() {
        return this.uninstallSugtSize;
    }

    public final void setUninstallSugtSize(long r1) {
        this.uninstallSugtSize = r1;
    }

    public final long getApkSugSize() {
        return this.apkSugSize;
    }

    public final void setApkSugSize(long r1) {
        this.apkSugSize = r1;
    }

    public final long getSystemSugSize() {
        return this.systemSugSize;
    }

    public final void setSystemSugSize(long r1) {
        this.systemSugSize = r1;
    }

    public final void requestData() {
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L9;
        r0.deepScan(this.deepScanCallBack, true);
        return;
    }

    public final void clearSelected() {
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r0 = this.trashClearHelper;
        Collection<RubbishEntity> r1 = null;
        if (r0 == null) goto L10;
        DeepScanCallBack r2 = r0.deepScanCallBack;
        if (r2 == null) goto L10;
        RubbishHolder r3 = r2.currentRubbish;
    L11:
        TcTrashClearHelper r4 = this.trashClearHelper;
        if (r4 == null) goto L14;
        Collection<RubbishEntity> r5 = r4.getSoftCacheRubbish();
    L15:
        setStatus(r5);
        TcTrashClearHelper r6 = this.trashClearHelper;
        if (r6 == null) goto L18;
        Collection<RubbishEntity> r7 = r6.getUninstallRubbish();
    L19:
        setStatus(r7);
        TcTrashClearHelper r8 = this.trashClearHelper;
        if (r8 == null) goto L22;
        Collection<RubbishEntity> r9 = r8.getApkRubbish();
    L23:
        setStatus(r9);
        TcTrashClearHelper r10 = this.trashClearHelper;
        if (r10 == null) goto L26;
        r1 = r10.getSystemRubbish();
    L26:
        setStatus(r1);
        TcTrashClearHelper r11 = this.trashClearHelper;
        if (r11 == null) goto L30;
        r11.cleanRubbish(r3, this.cleanCallBack);
        return;
    L30:
        return;
    L22:
        r9 = null;
        goto L23
    L18:
        r7 = null;
        goto L19
    L14:
        r5 = null;
    L10:
        r3 = null;
        goto L11
    }

    public final void removeCallBack() {
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L5;
        r0.removeScanStatusCallBack(this.deepScanCallBack);
    L5:
        TcTrashClearHelper r1 = this.trashClearHelper;
        if (r1 == null) goto L9;
        r1.removeCleanStatusCallBack(this.cleanCallBack);
        return;
    }

    private final void setStatus(Collection<? extends RubbishEntity> r5) {
        if (r5 == null) goto L19;
        Iterator<? extends RubbishEntity> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L26;
        RubbishEntity r0 = r6.next();
        boolean r1 = r0.isSuggest();
        TcTrashClearHelper r2 = this.trashClearHelper;
        if (r2 == null) goto L14;
        DeepScanCallBack r3 = r2.deepScanCallBack;
        if (r3 == null) goto L14;
        HashMap<RubbishEntity, Boolean> r4 = r3.uiSelectedItem;
        if (r4 == null) goto L14;
        Boolean r7 = r4.getOrDefault(r0, Boolean.valueOf(r1));
        if (r7 == null) goto L14;
    L15:
        Intrinsics.checkNotNullExpressionValue(r7, "trashClearHelper?.deepSc…, isSuggest) ?: isSuggest");
        if (r7.booleanValue() == true) goto L17;
        r0.setStatus(0);
        goto L5
    L17:
        r0.setStatus(1);
    L14:
        r7 = Boolean.valueOf(r1);
        goto L15
    L26:
        return;
    }

    public static /* synthetic */ void popPermissionDialogIfNeeded$default(CleanerViewModel r0, BaseActivity r1, boolean r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2, r3, r4);
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r3, boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r5, "from");
        if ((!GrantUtil.INSTANCE.isAllowed(r3, r5, r6)) == false) goto L5;
        GrantUtil.INSTANCE.requestGrant(r3, new AnonymousClass1(this, r3), r5, r6);
        return;
    L5:
        CleanSDK.INSTANCE.initCleanSDK();
        Context r7 = r3.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r7, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r7);
        Window r8 = r3.getWindow();
        Intrinsics.checkNotNullExpressionValue(r8, "activity.window");
        r8.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final long getSoftSuggestSize() {
        this.softSugtSize = 0;
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L21;
        Collection<RubbishEntity> r1 = r0.getSoftCacheRubbish();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        TcTrashClearHelper r4 = this.trashClearHelper;
        if (r4 == null) goto L16;
        DeepScanCallBack r5 = r4.deepScanCallBack;
        if (r5 == null) goto L16;
        HashMap<RubbishEntity, Boolean> r6 = r5.uiSelectedItem;
        if (r6 == null) goto L16;
        Boolean r7 = r6.get(r3);
    L18:
        if (Intrinsics.areEqual(r7, true) == false) goto L8;
        this.softSugtSize += r3.getSize();
    L16:
        r7 = null;
    L21:
        return this.softSugtSize;
    }

    public final long getSoftTotalSize() {
        TcTrashClearHelper r4 = this.trashClearHelper;
        long r0 = 0;
        if (r4 == null) goto L10;
        Collection<RubbishEntity> r5 = r4.getSoftCacheRubbish();
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0 = r0 + ((RubbishEntity) r6.next()).getSize();
    L10:
        return r0;
    }

    public final long getUninstallSuggestSize() {
        this.uninstallSugtSize = 0;
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L21;
        Collection<RubbishEntity> r1 = r0.getUninstallRubbish();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        TcTrashClearHelper r4 = this.trashClearHelper;
        if (r4 == null) goto L16;
        DeepScanCallBack r5 = r4.deepScanCallBack;
        if (r5 == null) goto L16;
        HashMap<RubbishEntity, Boolean> r6 = r5.uiSelectedItem;
        if (r6 == null) goto L16;
        Boolean r7 = r6.get(r3);
    L18:
        if (Intrinsics.areEqual(r7, true) == false) goto L8;
        this.uninstallSugtSize += r3.getSize();
    L16:
        r7 = null;
    L21:
        return this.uninstallSugtSize;
    }

    public final long getUninstallTotalSize() {
        TcTrashClearHelper r4 = this.trashClearHelper;
        long r0 = 0;
        if (r4 == null) goto L10;
        Collection<RubbishEntity> r5 = r4.getUninstallRubbish();
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0 = r0 + ((RubbishEntity) r6.next()).getSize();
    L10:
        return r0;
    }

    public final long getApkSuggestSize() {
        this.apkSugSize = 0;
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L21;
        Collection<RubbishEntity> r1 = r0.getApkRubbish();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        TcTrashClearHelper r4 = this.trashClearHelper;
        if (r4 == null) goto L16;
        DeepScanCallBack r5 = r4.deepScanCallBack;
        if (r5 == null) goto L16;
        HashMap<RubbishEntity, Boolean> r6 = r5.uiSelectedItem;
        if (r6 == null) goto L16;
        Boolean r7 = r6.get(r3);
    L18:
        if (Intrinsics.areEqual(r7, true) == false) goto L8;
        this.apkSugSize += r3.getSize();
    L16:
        r7 = null;
    L21:
        return this.apkSugSize;
    }

    public final long getApkTotalSize() {
        TcTrashClearHelper r4 = this.trashClearHelper;
        long r0 = 0;
        if (r4 == null) goto L10;
        Collection<RubbishEntity> r5 = r4.getApkRubbish();
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0 = r0 + ((RubbishEntity) r6.next()).getSize();
    L10:
        return r0;
    }

    public final long getSystemSuggestSize() {
        this.systemSugSize = 0;
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L21;
        Collection<RubbishEntity> r1 = r0.getSystemRubbish();
        if (r1 == null) goto L21;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        TcTrashClearHelper r4 = this.trashClearHelper;
        if (r4 == null) goto L16;
        DeepScanCallBack r5 = r4.deepScanCallBack;
        if (r5 == null) goto L16;
        HashMap<RubbishEntity, Boolean> r6 = r5.uiSelectedItem;
        if (r6 == null) goto L16;
        Boolean r7 = r6.get(r3);
    L18:
        if (Intrinsics.areEqual(r7, true) == false) goto L8;
        this.systemSugSize += r3.getSize();
    L16:
        r7 = null;
    L21:
        return this.systemSugSize;
    }

    public final long getSystemTotalSize() {
        TcTrashClearHelper r4 = this.trashClearHelper;
        long r0 = 0;
        if (r4 == null) goto L10;
        Collection<RubbishEntity> r5 = r4.getSystemRubbish();
        if (r5 == null) goto L10;
        Iterator<T> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0 = r0 + ((RubbishEntity) r6.next()).getSize();
    L10:
        return r0;
    }

    public final long getTotalSuggestSize() {
        long r0 = ((this.softSugtSize + this.uninstallSugtSize) + this.apkSugSize) + this.systemSugSize;
        this.totalSugSize = r0;
        return r0;
    }

    public final void reFreshStorageState(StorageMeasurement r2) {
        this.storageReciver = new StorageStateReceiver(this);
        if (r2 == null) goto L6;
        r2.resetReciver();
        r2.setMeasureDetail(false);
        r2.setReceiver(this.storageReciver);
        r2.invalidate();
        r2.measure();
        return;
    }
}
