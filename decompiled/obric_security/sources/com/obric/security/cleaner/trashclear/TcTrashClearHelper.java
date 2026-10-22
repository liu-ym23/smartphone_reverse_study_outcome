package com.obric.security.cleaner.trashclear;

import android.content.Context;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.olog.OLog;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import com.obric.securitycenter.api.TrackUtils;
import com.ss.android.message.log.PushLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.creator.ManagerCreatorF;
import tmsdk.fg.module.cleanV2.CleanManager;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: compiled from: TcTrashClearHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0012J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0006\u0010$\u001a\u00020\u0014J\u0010\u0010%\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010&\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "", "()V", "cleanManager", "Ltmsdk/fg/module/cleanV2/CleanManager;", "getCleanManager", "()Ltmsdk/fg/module/cleanV2/CleanManager;", "setCleanManager", "(Ltmsdk/fg/module/cleanV2/CleanManager;)V", "cleanStatusCallBack", "Lcom/obric/security/cleaner/trashclear/CleanCallback;", "deepScanCallBack", "Lcom/obric/security/cleaner/trashclear/DeepScanCallBack;", "emptyFileWhitelist", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "canDeepScan", "", "cleanRubbish", "", "currentRubbish", "Ltmsdk/fg/module/cleanV2/RubbishHolder;", "callBack", "Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "deepScan", "Lcom/obric/security/cleaner/trashclear/ScanStatusCallBack;", "forceScan", "filterRubbish", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "rubbishes", "getApkRubbish", "getSoftCacheRubbish", "getSystemRubbish", "getUninstallRubbish", "onDestory", "removeCleanStatusCallBack", "removeScanStatusCallBack", "updateRule", "enable", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TcTrashClearHelper {
    public static final Companion Companion = null;
    private static volatile TcTrashClearHelper clearHelper;
    private CleanManager cleanManager;
    public CleanCallback cleanStatusCallBack;
    public DeepScanCallBack deepScanCallBack;
    private final HashSet<String> emptyFileWhitelist;

    /* JADX INFO: compiled from: TcTrashClearHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper$Companion;", "", "()V", "clearHelper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "getInstance", "context", "Landroid/content/Context;", PushLog.KEY_TAG, "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TcTrashClearHelper getInstance(Context r1, String r2) {
            monitor-enter(TcTrashClearHelper.class);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (TcTrashClearHelper.access$getClearHelper$cp() != null) goto L7;
            CleanSDK.INSTANCE.initCleanSDK();     // Catch: Throwable -> L10
            TcTrashClearHelper.access$setClearHelper$cp(new TcTrashClearHelper(null));     // Catch: Throwable -> L10
        L7:
            TcTrashClearHelper r3 = TcTrashClearHelper.access$getClearHelper$cp();     // Catch: Throwable -> L10
            monitor-exit(TcTrashClearHelper.class);
            return r3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TcTrashClearHelper getInstance(Context r1, String r2) {
        return Companion.getInstance(r1, r2);
    }

    public final boolean canDeepScan() {
        return true;
    }

    private TcTrashClearHelper() {
        this.emptyFileWhitelist = SetsKt.hashSetOf(new String[]{"/storage/emulated/0/slardaros", "/storage/emulated/0/Notifications", "/storage/emulated/0/slardaros/DumpUploader", "/storage/emulated/0/Recordings", "/storage/emulated/0/Download/obric/aikernel", "/storage/emulated/0/Audiobooks", "/storage/emulated/0/Download/obric", "/storage/emulated/0/Ringtones", "/storage/emulated/0/Download/obric/appstore", "/storage/emulated/0/DCIM", "/storage/emulated/0/Documents", "/storage/emulated/0/Download", "/storage/emulated/0/Alarms", "/storage/emulated/0/Download/obric/aikernel/update/downloads", "/storage/emulated/0/Download/obric/aikernel/update", "/storage/emulated/0/Podcasts", "/storage/emulated/0/Android/media"});
        this.deepScanCallBack = new DeepScanCallBack();
        this.cleanStatusCallBack = new CleanCallback();
    }

    public /* synthetic */ TcTrashClearHelper(DefaultConstructorMarker r1) {
        this();
    }

    public static final /* synthetic */ TcTrashClearHelper access$getClearHelper$cp() {
        return clearHelper;
    }

    public static final /* synthetic */ void access$setClearHelper$cp(TcTrashClearHelper r0) {
        clearHelper = r0;
    }

    public final CleanManager getCleanManager() {
        return this.cleanManager;
    }

    public final void setCleanManager(CleanManager r1) {
        this.cleanManager = r1;
    }

    public static /* synthetic */ void deepScan$default(TcTrashClearHelper r0, ScanStatusCallBack r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.deepScan(r1, r2);
    }

    public final void deepScan(ScanStatusCallBack r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "callBack");
        if (this.cleanManager != null) goto L5;
        this.cleanManager = (CleanManager) ManagerCreatorF.getManager(CleanManager.class);
    L5:
        this.deepScanCallBack.addScanStatusCallBack(r13);
        if (this.deepScanCallBack.sdkStatus != 0) goto L11;
        CleanManager r3 = this.cleanManager;
        if (r3 == null) goto L20;
        boolean r12 = r3.scanDisk(this.deepScanCallBack, null, null, this.emptyFileWhitelist, false, true, 5, true);
    L22:
        if (r12 == true) goto L24;
        OLog.e("TencentCleanSdk_TMSDK", "scanDisk:result  = " + r12);
        CleanSDK.INSTANCE.setCheckLicenceSafeState(false);
        CleanSDK.INSTANCE.initCleanSDK();
        r13.onScanFinished();
    L24:
        TrackUtils r4 = TrackUtils.INSTANCE;
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to("scan_mode", "deep_scan");
        if (r12 == false) goto L27;
        String r16 = "success";
    L28:
        r15[1] = TuplesKt.to("result", r16);
        if (r12 == false) goto L31;
        String r17 = "";
    L32:
        r15[2] = TuplesKt.to(EventConstants.EVENT_KEY_ERROR_MESSAGE, r17);
        TrackUtils.trackEvent$default(r4, "rubbish_scan_call", MapsKt.mapOf(r15), false, 4, null);
        return;
    L31:
        r17 = String.valueOf(CleanSDK.INSTANCE.getLicenceCheckCode());
        goto L32
    L27:
        r16 = "fail";
    L20:
        r12 = true;
        goto L22
    L11:
        if (this.deepScanCallBack.sdkStatus != 2) goto L15;
        if (r14 == true) goto L15;
        r13.onScanFinished();
    L15:
        if (this.deepScanCallBack.sdkStatus != 2) goto L20;
        if (r14 == false) goto L20;
        CleanManager r5 = this.cleanManager;
        if (r5 == null) goto L20;
        r12 = r5.scanDisk(this.deepScanCallBack, null, null, this.emptyFileWhitelist, false, true, 5, true);
        goto L22
    }

    public final void onDestory() {
        CleanManager r0 = this.cleanManager;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        this.deepScanCallBack.sdkStatus = 0;
    }

    public final void updateRule(boolean r4) {
        CleanManager r5 = this.cleanManager;
        if (r5 == null) goto L5;
        r5.updateRule(new AnonymousClass1(), -1);
    L5:
        CleanManager r6 = this.cleanManager;
        if (r6 == null) goto L8;
        r6.updateRule(true, new AnonymousClass2());
    L8:
        CleanManager r3 = this.cleanManager;
        if (r3 == null) goto L12;
        r3.updateRuleAndDatFile(true, new AnonymousClass3());
        return;
    }

    public final void cleanRubbish(RubbishHolder r8, CleanStatusCallBack r9) {
        if (this.cleanManager != null) goto L5;
        this.cleanManager = (CleanManager) ManagerCreatorF.getManager(CleanManager.class);
    L5:
        this.cleanStatusCallBack.addCleanStatusCallBack(r9);
        if (r8 == null) goto L11;
        CleanManager r1 = this.cleanManager;
        if (r1 == null) goto L10;
        boolean r7 = r1.cleanRubbishSlow(r8, false, this.cleanStatusCallBack);
    L12:
        TrackUtils r2 = TrackUtils.INSTANCE;
        Pair[] r10 = new Pair[3];
        r10[0] = TuplesKt.to("clean_mode", "deep_scan");
        if (r7 == false) goto L15;
        String r0 = "success";
    L16:
        r10[1] = TuplesKt.to("result", r0);
        if (r7 == false) goto L19;
        String r11 = "";
    L20:
        r10[2] = TuplesKt.to(EventConstants.EVENT_KEY_ERROR_MESSAGE, r11);
        TrackUtils.trackEvent$default(r2, "rubbish_clean_call", MapsKt.mapOf(r10), false, 4, null);
        return;
    L19:
        r11 = String.valueOf(CleanSDK.INSTANCE.getLicenceCheckCode());
        goto L20
    L15:
        r0 = "fail";
        goto L16
    L10:
        r7 = false;
        goto L12
    L11:
        r7 = true;
        goto L12
    }

    public final void removeScanStatusCallBack(ScanStatusCallBack r1) {
        this.deepScanCallBack.removeScanStatusCallBack(r1);
    }

    public final void removeCleanStatusCallBack(CleanStatusCallBack r1) {
        this.cleanStatusCallBack.removeCleanStatusCallBack(r1);
    }

    public final Collection<RubbishEntity> getSoftCacheRubbish() {
        Collection<RubbishEntity> r1 = null;
        if (this.deepScanCallBack.currentRubbish == null) goto L11;
        RubbishHolder r0 = this.deepScanCallBack.currentRubbish;
        if (r0 == null) goto L10;
        Map<String, RubbishEntity> r2 = r0.getmInstallRubbishes();
        if (r2 == null) goto L10;
        r1 = r2.values();
    L10:
        return filterRubbish(r1);
    L11:
        return null;
    }

    public final Collection<RubbishEntity> getUninstallRubbish() {
        Collection<RubbishEntity> r1 = null;
        if (this.deepScanCallBack.currentRubbish == null) goto L11;
        RubbishHolder r0 = this.deepScanCallBack.currentRubbish;
        if (r0 == null) goto L10;
        Map<String, RubbishEntity> r2 = r0.getmUnInstallRubbishes();
        if (r2 == null) goto L10;
        r1 = r2.values();
    L10:
        return filterRubbish(r1);
    L11:
        return null;
    }

    public final Collection<RubbishEntity> getApkRubbish() {
        List<RubbishEntity> r1 = null;
        if (this.deepScanCallBack.currentRubbish == null) goto L9;
        RubbishHolder r0 = this.deepScanCallBack.currentRubbish;
        if (r0 == null) goto L8;
        r1 = r0.getmApkRubbishes();
    L8:
        return filterRubbish(r1);
    L9:
        return null;
    }

    public final Collection<RubbishEntity> getSystemRubbish() {
        Collection<RubbishEntity> r1 = null;
        if (this.deepScanCallBack.currentRubbish == null) goto L11;
        RubbishHolder r0 = this.deepScanCallBack.currentRubbish;
        if (r0 == null) goto L10;
        Map<String, RubbishEntity> r2 = r0.getmSystemRubbishes();
        if (r2 == null) goto L10;
        r1 = r2.values();
    L10:
        return filterRubbish(r1);
    L11:
        return null;
    }

    private final Collection<RubbishEntity> filterRubbish(Collection<? extends RubbishEntity> r5) {
        if (r5 == null) goto L15;
        ArrayList r4 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L14;
        Object r0 = r6.next();
        RubbishEntity r1 = (RubbishEntity) r0;
        boolean r3 = true;
        if (r1.getStatus() != 0) goto L9;
    L12:
        if (r3 == false) goto L5;
        r4.add(r0);
        goto L5
    L9:
        if (r1.getStatus() == 1) goto L12;
        r3 = false;
        goto L12
    L14:
        ArrayList r7 = r4;
    L17:
        return r7;
    L15:
        r7 = null;
        goto L17
    }
}
