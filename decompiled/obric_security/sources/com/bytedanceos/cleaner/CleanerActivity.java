package com.bytedanceos.cleaner;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.oui.MultiSegmentProgressBar;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.storage.StorageMeasurement;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.bytedanceos.utils.OCardListItemExtKt;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerViewModel;
import com.obric.security.cleaner.trashclear.DeepScanCallBack;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: CleanerActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020!H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u0010?\u001a\u00020!H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010?\u001a\u00020!H\u0002J\b\u0010B\u001a\u00020=H\u0002J\b\u0010C\u001a\u00020=H\u0002J\u0012\u0010D\u001a\u00020=2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\b\u0010G\u001a\u00020=H\u0014J\b\u0010H\u001a\u00020=H\u0014J\b\u0010I\u001a\u00020=H\u0014J\b\u0010J\u001a\u00020=H\u0002J\b\u0010K\u001a\u00020=H\u0002J\b\u0010L\u001a\u00020=H\u0002J\b\u0010M\u001a\u00020=H\u0002J\b\u0010N\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020=H\u0002J\u0016\u0010Q\u001a\u00020=2\u0006\u0010R\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020!R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0010R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010%\u001a\n \n*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b&\u0010\u0006R\u001d\u0010(\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b)\u0010\u0010R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010-\u001a\n \n*\u0004\u0018\u00010.0.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\b\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\b\u001a\u0004\b3\u0010\u0010R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\b\u001a\u0004\b8\u0010\u0010R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/bytedanceos/cleaner/CleanerActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "availSize", "Landroid/widget/TextView;", "getAvailSize", "()Landroid/widget/TextView;", "availSize$delegate", "Lkotlin/Lazy;", "availSizeUnit", "kotlin.jvm.PlatformType", "getAvailSizeUnit", "availSizeUnit$delegate", "cacheTrash", "Lcom/obric/oui/lisitem/OCardListItem;", "getCacheTrash", "()Lcom/obric/oui/lisitem/OCardListItem;", "cacheTrash$delegate", "cleanButton", "getCleanButton", "cleanButton$delegate", "cleanButtonText", "mIsFirstEntry", "", "mMeasure", "Lcom/bytedanceos/storage/StorageMeasurement;", "mPreferenceMgr", "Lcom/bytedanceos/cloud/PreferenceMgr;", "getMPreferenceMgr", "()Lcom/bytedanceos/cloud/PreferenceMgr;", "setMPreferenceMgr", "(Lcom/bytedanceos/cloud/PreferenceMgr;)V", "mStorageAvailSize", "", "mStorageTotalSize", "mTrashScanReported", "mTrashScanStartMs", "mTvDetail", "getMTvDetail", "mTvDetail$delegate", "packageTrash", "getPackageTrash", "packageTrash$delegate", "privacyFrom", "", "storageProgress", "Lcom/bytedanceos/oui/MultiSegmentProgressBar;", "getStorageProgress", "()Lcom/bytedanceos/oui/MultiSegmentProgressBar;", "storageProgress$delegate", "systemTrash", "getSystemTrash", "systemTrash$delegate", "trashClearHelper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "uninstallTrash", "getUninstallTrash", "uninstallTrash$delegate", "viewModel", "Lcom/obric/security/cleaner/CleanerViewModel;", "doClean", "", "getSizeNumString", PerfConsts.PERF_DISK_FILE_SIZE, "getSizeString", "getSizeUnitString", "initObserve", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setApkTrashValue", "setCacheTrashValue", "setSystemTrashValue", "setUninstallTrashValue", "startScan", "uiUpdate", "updateStorageProgressBar", "updateStorageState", "toatalSize", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanerActivity extends BaseActivity {
    public static final Companion Companion = null;
    public static final String TYPE = null;
    private HashMap _$_findViewCache;
    private final Lazy availSize$delegate;
    private final Lazy availSizeUnit$delegate;
    private final Lazy cacheTrash$delegate;
    private final Lazy cleanButton$delegate;
    private TextView cleanButtonText;
    private boolean mIsFirstEntry;
    private StorageMeasurement mMeasure;
    private PreferenceMgr mPreferenceMgr;
    private long mStorageAvailSize;
    private long mStorageTotalSize;
    private boolean mTrashScanReported;
    private long mTrashScanStartMs;
    private final Lazy mTvDetail$delegate;
    private final Lazy packageTrash$delegate;
    private String privacyFrom;
    private final Lazy storageProgress$delegate;
    private final Lazy systemTrash$delegate;
    private TcTrashClearHelper trashClearHelper;
    private final Lazy uninstallTrash$delegate;
    private CleanerViewModel viewModel;

    /* JADX INFO: compiled from: CleanerActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/cleaner/CleanerActivity$Companion;", "", "()V", "TYPE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    private final TextView getAvailSize() {
        return (TextView) this.availSize$delegate.getValue();
    }

    private final TextView getAvailSizeUnit() {
        return (TextView) this.availSizeUnit$delegate.getValue();
    }

    private final OCardListItem getCacheTrash() {
        return (OCardListItem) this.cacheTrash$delegate.getValue();
    }

    private final OCardListItem getCleanButton() {
        return (OCardListItem) this.cleanButton$delegate.getValue();
    }

    private final TextView getMTvDetail() {
        return (TextView) this.mTvDetail$delegate.getValue();
    }

    private final OCardListItem getPackageTrash() {
        return (OCardListItem) this.packageTrash$delegate.getValue();
    }

    private final MultiSegmentProgressBar getStorageProgress() {
        return (MultiSegmentProgressBar) this.storageProgress$delegate.getValue();
    }

    private final OCardListItem getSystemTrash() {
        return (OCardListItem) this.systemTrash$delegate.getValue();
    }

    private final OCardListItem getUninstallTrash() {
        return (OCardListItem) this.uninstallTrash$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public CleanerActivity() {
        this.availSize$delegate = LazyKt.lazy(new CleanerActivity$availSize$2(this));
        this.availSizeUnit$delegate = LazyKt.lazy(new CleanerActivity$availSizeUnit$2(this));
        this.mTvDetail$delegate = LazyKt.lazy(new CleanerActivity$mTvDetail$2(this));
        this.cacheTrash$delegate = LazyKt.lazy(new CleanerActivity$cacheTrash$2(this));
        this.uninstallTrash$delegate = LazyKt.lazy(new CleanerActivity$uninstallTrash$2(this));
        this.packageTrash$delegate = LazyKt.lazy(new CleanerActivity$packageTrash$2(this));
        this.systemTrash$delegate = LazyKt.lazy(new CleanerActivity$systemTrash$2(this));
        this.cleanButton$delegate = LazyKt.lazy(new CleanerActivity$cleanButton$2(this));
        this.mIsFirstEntry = true;
        this.privacyFrom = "";
        this.storageProgress$delegate = LazyKt.lazy(new CleanerActivity$storageProgress$2(this));
    }

    public static final /* synthetic */ void access$doClean(CleanerActivity r0) {
        r0.doClean();
    }

    public static final /* synthetic */ OCardListItem access$getCleanButton$p(CleanerActivity r0) {
        return r0.getCleanButton();
    }

    public static final /* synthetic */ TextView access$getCleanButtonText$p(CleanerActivity r0) {
        return r0.cleanButtonText;
    }

    public static final /* synthetic */ StorageMeasurement access$getMMeasure$p(CleanerActivity r0) {
        return r0.mMeasure;
    }

    public static final /* synthetic */ long access$getMStorageAvailSize$p(CleanerActivity r2) {
        return r2.mStorageAvailSize;
    }

    public static final /* synthetic */ long access$getMStorageTotalSize$p(CleanerActivity r2) {
        return r2.mStorageTotalSize;
    }

    public static final /* synthetic */ boolean access$getMTrashScanReported$p(CleanerActivity r0) {
        return r0.mTrashScanReported;
    }

    public static final /* synthetic */ long access$getMTrashScanStartMs$p(CleanerActivity r2) {
        return r2.mTrashScanStartMs;
    }

    public static final /* synthetic */ String access$getPrivacyFrom$p(CleanerActivity r0) {
        return r0.privacyFrom;
    }

    public static final /* synthetic */ TcTrashClearHelper access$getTrashClearHelper$p(CleanerActivity r0) {
        return r0.trashClearHelper;
    }

    public static final /* synthetic */ CleanerViewModel access$getViewModel$p(CleanerActivity r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$setCleanButtonText$p(CleanerActivity r0, TextView r1) {
        r0.cleanButtonText = r1;
    }

    public static final /* synthetic */ void access$setMMeasure$p(CleanerActivity r0, StorageMeasurement r1) {
        r0.mMeasure = r1;
    }

    public static final /* synthetic */ void access$setMStorageAvailSize$p(CleanerActivity r0, long r1) {
        r0.mStorageAvailSize = r1;
    }

    public static final /* synthetic */ void access$setMStorageTotalSize$p(CleanerActivity r0, long r1) {
        r0.mStorageTotalSize = r1;
    }

    public static final /* synthetic */ void access$setMTrashScanReported$p(CleanerActivity r0, boolean r1) {
        r0.mTrashScanReported = r1;
    }

    public static final /* synthetic */ void access$setMTrashScanStartMs$p(CleanerActivity r0, long r1) {
        r0.mTrashScanStartMs = r1;
    }

    public static final /* synthetic */ void access$setPrivacyFrom$p(CleanerActivity r0, String r1) {
        r0.privacyFrom = r1;
    }

    public static final /* synthetic */ void access$setTrashClearHelper$p(CleanerActivity r0, TcTrashClearHelper r1) {
        r0.trashClearHelper = r1;
    }

    public static final /* synthetic */ void access$setViewModel$p(CleanerActivity r0, CleanerViewModel r1) {
        r0.viewModel = r1;
    }

    public static final /* synthetic */ void access$startScan(CleanerActivity r0) {
        r0.startScan();
    }

    public static final /* synthetic */ void access$uiUpdate(CleanerActivity r0) {
        r0.uiUpdate();
    }

    public static final /* synthetic */ void access$updateStorageProgressBar(CleanerActivity r0) {
        r0.updateStorageProgressBar();
    }

    static {
        Companion = new Companion(null);
        TYPE = "type";
    }

    public final PreferenceMgr getMPreferenceMgr() {
        return this.mPreferenceMgr;
    }

    public final void setMPreferenceMgr(PreferenceMgr r1) {
        this.mPreferenceMgr = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.cleaner_scan_activity);
        boolean r6 = false;
        initTitleBar(false, false);
        if ((this instanceof ViewModelStoreOwner) == true) goto L5;
        CleanerActivity r0 = null;
    L6:
        CleanerActivity r1 = r0;
        if (r1 == null) goto L9;
        this.viewModel = (CleanerViewModel) new ViewModelProvider(r1).get(CleanerViewModel.class);
    L9:
        this.mPreferenceMgr = PreferenceMgr.getInstance(this);
        String r2 = getIntent().getStringExtra("from");
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        this.privacyFrom = r2;
        boolean r3 = getIntent().getBooleanExtra("force_show_privacy_dialog", false);
        initObserve();
        CleanerViewModel r4 = this.viewModel;
        if (r4 == null) goto L18;
        CleanerActivity r7 = this;
        PreferenceMgr r8 = this.mPreferenceMgr;
        if (r8 == null) goto L17;
        r6 = r8.isAllowed();
    L17:
        r4.popPermissionDialogIfNeeded(r7, r6, this.privacyFrom, r3);
    L18:
        initView();
        return;
    L5:
        r0 = this;
        goto L6
    }

    private final void uiUpdate() {
        setCacheTrashValue();
        setUninstallTrashValue();
        setApkTrashValue();
        setSystemTrashValue();
        CleanerViewModel r0 = this.viewModel;
        if (r0 == null) goto L5;
        long r3 = r0.getTotalSuggestSize();
    L7:
        if (r3 <= 0) goto L11;
        TextView r1 = this.cleanButtonText;
        if (r1 == null) goto L14;
        r1.setText(R.string.memory_onestep_clean);
    L14:
        OCardListItem r5 = getCleanButton();
        if (r5 == null) goto L18;
        r5.setClickable(true);
        return;
    L18:
        return;
    L11:
        TextView r2 = this.cleanButtonText;
        if (r2 == null) goto L14;
        r2.setText(R.string.memory_has_clean);
        goto L14
    L5:
        r3 = 0;
        goto L7
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mIsFirstEntry == true) goto L24;
        PreferenceMgr r0 = this.mPreferenceMgr;
        if (r0 != null) goto L7;
    L8:
        PreferenceMgr r1 = this.mPreferenceMgr;
        if (r1 == null) goto L24;
        if (r1.getIsAllowedFromUid(GrantUtil.securitymanager) != true) goto L24;
    L12:
        TcTrashClearHelper r2 = this.trashClearHelper;
        if (r2 == null) goto L21;
        DeepScanCallBack r3 = r2.deepScanCallBack;
        if (r3 == null) goto L21;
        HashMap<RubbishEntity, Boolean> r4 = r3.uiSelectedItem;
        if (r4 == null) goto L21;
        if ((!r4.isEmpty()) != true) goto L21;
        uiUpdate();
    L21:
        CleanerViewModel r5 = this.viewModel;
        if (r5 == null) goto L24;
        r5.reFreshStorageState(this.mMeasure);
        goto L24
    L7:
        if (r0.isAllowed() == true) goto L12;
    L24:
        this.mIsFirstEntry = false;
    }

    private final void initView() {
        this.cleanButtonText = (TextView) LayoutInflater.from(this).inflate(R.layout.clean_textview, null);
        OCardListItem r0 = getCleanButton();
        if (r0 == null) goto L5;
        r0.setCardType(2);
    L5:
        OCardListItem r1 = getCleanButton();
        if (r1 == null) goto L8;
        OCardListItemExtKt.setStartView(r1, this.cleanButtonText);
    L8:
        OCardListItem r2 = getCacheTrash();
        if (r2 == null) goto L11;
        r2.setTitle(getResources().getString(R.string.scan_cache_trash_txt));
    L11:
        OCardListItem r3 = getUninstallTrash();
        if (r3 == null) goto L14;
        r3.setTitle(getResources().getString(R.string.scan_uninstall_trash_txt));
    L14:
        OCardListItem r4 = getPackageTrash();
        if (r4 == null) goto L17;
        r4.setTitle(getResources().getString(R.string.scan_package_trash_txt));
    L17:
        OCardListItem r5 = getSystemTrash();
        if (r5 == null) goto L20;
        r5.setTitle(getResources().getString(R.string.clear_sdk_trash_system));
    L20:
        OCardListItem r6 = getCacheTrash();
        if (r6 == null) goto L23;
        OCardListItemExtKt.setTailType(r6, 0);
    L23:
        OCardListItem r7 = getUninstallTrash();
        if (r7 == null) goto L26;
        OCardListItemExtKt.setTailType(r7, 0);
    L26:
        OCardListItem r8 = getPackageTrash();
        if (r8 == null) goto L29;
        OCardListItemExtKt.setTailType(r8, 0);
    L29:
        OCardListItem r9 = getSystemTrash();
        if (r9 == null) goto L32;
        OCardListItemExtKt.setTailType(r9, 0);
    L32:
        OCardListItem r10 = getCacheTrash();
        if (r10 == null) goto L35;
        OCardListItem.setCardPosition$default(r10, 1, false, 2, null);
    L35:
        OCardListItem r11 = getUninstallTrash();
        if (r11 == null) goto L38;
        OCardListItem.setCardPosition$default(r11, 2, false, 2, null);
    L38:
        OCardListItem r12 = getPackageTrash();
        if (r12 == null) goto L41;
        OCardListItem.setCardPosition$default(r12, 2, false, 2, null);
    L41:
        OCardListItem r13 = getSystemTrash();
        if (r13 == null) goto L44;
        OCardListItem.setCardPosition$default(r13, 2, false, 2, null);
    L44:
        OCardListItem r14 = getCleanButton();
        if (r14 == null) goto L47;
        OCardListItem.setCardPosition$default(r14, 3, false, 2, null);
    L47:
        OCardListItem r15 = getCacheTrash();
        if (r15 == null) goto L50;
        r15.setOnContentClickListener(new ViewOnClickListenerC01351(this));
    L50:
        OCardListItem r16 = getUninstallTrash();
        if (r16 == null) goto L53;
        r16.setOnContentClickListener(new ViewOnClickListenerC01362(this));
    L53:
        OCardListItem r17 = getPackageTrash();
        if (r17 == null) goto L56;
        r17.setOnContentClickListener(new ViewOnClickListenerC01373(this));
    L56:
        OCardListItem r18 = getSystemTrash();
        if (r18 == null) goto L59;
        r18.setOnContentClickListener(new ViewOnClickListenerC01384(this));
    L59:
        OCardListItem r19 = getCleanButton();
        if (r19 == null) goto L63;
        r19.setOnContentClickListener(new ViewOnClickListenerC01395(this));
        return;
    }

    private final void initObserve() {
        CleanerViewModel r0 = this.viewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L7;
        r1.observe(this, new AnonymousClass1(this));
    L7:
        CleanerViewModel r2 = this.viewModel;
        if (r2 == null) goto L12;
        MutableLiveData<Boolean> r3 = r2.getScanFinished();
        if (r3 == null) goto L12;
        r3.observe(this, new AnonymousClass2(this));
    L12:
        CleanerViewModel r4 = this.viewModel;
        if (r4 == null) goto L17;
        MutableLiveData<Boolean> r5 = r4.getCleanFinished();
        if (r5 == null) goto L17;
        r5.observe(this, new AnonymousClass3(this));
    L17:
        CleanerViewModel r6 = this.viewModel;
        if (r6 == null) goto L22;
        MutableLiveData<Integer> r7 = r6.getCleanProcess();
        if (r7 == null) goto L22;
        r7.observe(this, new AnonymousClass4(this));
    L22:
        CleanerViewModel r8 = this.viewModel;
        if (r8 == null) goto L28;
        MutableLiveData<Pair<Long, Long>> r9 = r8.getStorageInfo();
        if (r9 == null) goto L29;
        r9.observe(this, new AnonymousClass5(this));
        return;
    L29:
        return;
    }

    private final void updateStorageProgressBar() {
        float r0 = this.mStorageTotalSize;
        float r1 = this.mStorageAvailSize;
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        float r2 = (r0 - r1) / r0;
        Resources r3 = getResources();
        Intrinsics.checkNotNullExpressionValue(r3, "resources");
        float r4 = r3.getDisplayMetrics().density * 8.0f;
        float[] r5 = {r4, r4, 0.0f, 0.0f, 0.0f, 0.0f, r4, r4};
        int r6 = getColor(R.color.oui_blue_6);
        MultiSegmentProgressBar r7 = getStorageProgress();
        if (r7 == null) goto L9;
        r7.setSegments(CollectionsKt.listOf(new MultiSegmentProgressBar.Segment(r6, r2, r5)));
        return;
    }

    private final void startScan() {
        OCardListItem r0 = getCacheTrash();
        if (r0 == null) goto L5;
        OCardListItemExtKt.setEndText(r0, "0B");
    L5:
        OCardListItem r1 = getUninstallTrash();
        if (r1 == null) goto L8;
        OCardListItemExtKt.setEndText(r1, "0B");
    L8:
        OCardListItem r2 = getPackageTrash();
        if (r2 == null) goto L11;
        OCardListItemExtKt.setEndText(r2, "0B");
    L11:
        OCardListItem r3 = getSystemTrash();
        if (r3 == null) goto L14;
        OCardListItemExtKt.setEndText(r3, "0B");
    L14:
        TextView r4 = getAvailSize();
        if (r4 == null) goto L17;
        r4.setText("0");
    L17:
        TextView r5 = getAvailSizeUnit();
        if (r5 == null) goto L20;
        r5.setText("B");
    L20:
        TextView r6 = this.cleanButtonText;
        if (r6 == null) goto L23;
        r6.setText(R.string.blue_button_scanning);
    L23:
        OCardListItem r7 = getCleanButton();
        if (r7 == null) goto L27;
        r7.setClickable(false);
        return;
    }

    private final void setSystemTrashValue() {
        OCardListItem r0 = getSystemTrash();
        if (r0 == null) goto L13;
        StringBuilder r1 = new StringBuilder();
        CleanerViewModel r2 = this.viewModel;
        long r3 = 0;
        if (r2 == null) goto L7;
        long r5 = r2.getSystemSuggestSize();
    L8:
        StringBuilder r4 = r1.append(getSizeString(r5)).append(LibrarianImpl.Constants.SEPARATOR);
        CleanerViewModel r6 = this.viewModel;
        if (r6 == null) goto L11;
        r3 = r6.getSystemTotalSize();
    L11:
        OCardListItemExtKt.setEndText(r0, r4.append(getSizeString(r3)).toString());
        return;
    L7:
        r5 = 0;
        goto L8
    }

    private final void setApkTrashValue() {
        OCardListItem r0 = getPackageTrash();
        if (r0 == null) goto L13;
        StringBuilder r1 = new StringBuilder();
        CleanerViewModel r2 = this.viewModel;
        long r3 = 0;
        if (r2 == null) goto L7;
        long r5 = r2.getApkSuggestSize();
    L8:
        StringBuilder r4 = r1.append(getSizeString(r5)).append(LibrarianImpl.Constants.SEPARATOR);
        CleanerViewModel r6 = this.viewModel;
        if (r6 == null) goto L11;
        r3 = r6.getApkTotalSize();
    L11:
        OCardListItemExtKt.setEndText(r0, r4.append(getSizeString(r3)).toString());
        return;
    L7:
        r5 = 0;
        goto L8
    }

    private final void setUninstallTrashValue() {
        OCardListItem r0 = getUninstallTrash();
        if (r0 == null) goto L13;
        StringBuilder r1 = new StringBuilder();
        CleanerViewModel r2 = this.viewModel;
        long r3 = 0;
        if (r2 == null) goto L7;
        long r5 = r2.getUninstallSuggestSize();
    L8:
        StringBuilder r4 = r1.append(getSizeString(r5)).append(LibrarianImpl.Constants.SEPARATOR);
        CleanerViewModel r6 = this.viewModel;
        if (r6 == null) goto L11;
        r3 = r6.getUninstallTotalSize();
    L11:
        OCardListItemExtKt.setEndText(r0, r4.append(getSizeString(r3)).toString());
        return;
    L7:
        r5 = 0;
        goto L8
    }

    private final void setCacheTrashValue() {
        OCardListItem r0 = getCacheTrash();
        if (r0 == null) goto L13;
        StringBuilder r1 = new StringBuilder();
        CleanerViewModel r2 = this.viewModel;
        long r3 = 0;
        if (r2 == null) goto L7;
        long r5 = r2.getSoftSuggestSize();
    L8:
        StringBuilder r4 = r1.append(getSizeString(r5)).append(LibrarianImpl.Constants.SEPARATOR);
        CleanerViewModel r6 = this.viewModel;
        if (r6 == null) goto L11;
        r3 = r6.getSoftTotalSize();
    L11:
        OCardListItemExtKt.setEndText(r0, r4.append(getSizeString(r3)).toString());
        return;
    L7:
        r5 = 0;
        goto L8
    }

    public final void updateStorageState(long r4, long r6) {
        long r7 = r4 - r6;
        if (r7 >= 0) goto L5;
        r7 = 0;
    L5:
        ByteUnitPair r8 = ByteConverter.convertGB(r7, 1000, 1);
        TextView r9 = getAvailSize();
        if (r9 == null) goto L8;
        r9.setText(r8.getValue());
    L8:
        TextView r10 = getAvailSizeUnit();
        if (r10 == null) goto L11;
        r10.setText(r8.getUnit());
    L11:
        ByteUnitPair r5 = ByteConverter.convert(r4, "B", 1000);
        TextView r11 = getMTvDetail();
        if (r11 == null) goto L15;
        r11.setText(getString(R.string.total) + " " + r5.getValue() + r5.getUnit());
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        StorageMeasurement r0 = this.mMeasure;
        if (r0 == null) goto L6;
        r0.resetReciver();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CleanerViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.removeCallBack();
        return;
    }

    private final void doClean() {
        CleanerViewModel r0 = this.viewModel;
        if (r0 == null) goto L5;
        r0.clearSelected();
    L5:
        TextView r1 = this.cleanButtonText;
        if (r1 == null) goto L9;
        r1.setText(R.string.blue_button_cleaning);
        return;
    }

    private final String getSizeNumString(long r2) {
        String r1 = ByteConverter.convert(r2, "B", 1000).getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "pair.getValue()");
        return r1;
    }

    private final String getSizeUnitString(long r2) {
        String r1 = ByteConverter.convert(r2, "B", 1000).getUnit();
        Intrinsics.checkNotNullExpressionValue(r1, "pair.getUnit()");
        return r1;
    }

    private final String getSizeString(long r2) {
        ByteUnitPair r1 = ByteConverter.convert(r2, "B", 1000);
        return r1.getValue() + r1.getUnit();
    }
}
