package com.bytedanceos.securitycenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockJoin;
import com.bytedance.blockframework.framework.join.IBlockJoinKt;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.init.VirusDbAutoUpdateInitializer;
import com.obric.apm.ApmHelper;
import com.obric.matrix.platform.sdk.ones.appupdate.MatrixAppUpdateManager;
import com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch.AppLaunchMonitor;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.ExtKt;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.PageMonitor;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import com.obric.security.mainpage.MainViewModel;
import com.obric.security.mainpage.block.MainRootBlock;
import com.obric.security.mainpage.block.event.ActivityResultEvent;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.security.service.SecurityServiceBinder;
import com.obric.securitycenter.api.ISecurityCenterService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0005¢\u0006\u0002\u0010\u0003J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u001dH\u0002J\u0010\u00109\u001a\u0002042\u0006\u00108\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u000204H\u0002J\"\u0010;\u001a\u0002042\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000204H\u0016J\u0012\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0014J\b\u0010E\u001a\u000204H\u0014J\b\u0010F\u001a\u000204H\u0014J\b\u0010G\u001a\u000204H\u0014J\u0010\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020DH\u0014J\u001a\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020\u001d2\b\b\u0002\u0010L\u001a\u000206H\u0002J\b\u0010M\u001a\u000204H\u0002J\b\u0010N\u001a\u00020\u001dH\u0016J\b\u0010O\u001a\u000204H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006Q"}, d2 = {"Lcom/bytedanceos/securitycenter/MainActivity;", "Lcom/bytedanceos/security/BaseActivity;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "()V", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockContext$delegate", "Lkotlin/Lazy;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "getBlockScene", "()Lcom/bytedance/blockframework/framework/join/IBlockScene;", "blockScene$delegate", "handlerCallback", "Landroid/os/Handler$Callback;", "mDebugSettingEntry", "Landroid/view/View;", "mPreferenceMgr", "Lcom/bytedanceos/cloud/PreferenceMgr;", "mainHandler", "Landroid/os/Handler;", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "pageMonitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/page/PageMonitor;", "periodStarts", "", "", "", "privacyFrom", "rootBlock", "Lcom/obric/security/mainpage/block/MainRootBlock;", "getRootBlock", "()Lcom/obric/security/mainpage/block/MainRootBlock;", "setRootBlock", "(Lcom/obric/security/mainpage/block/MainRootBlock;)V", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "securityCenterService", "Lcom/obric/security/service/SecurityServiceBinder;", "settings", "getSettings", "()Landroid/view/View;", "setSettings", "(Landroid/view/View;)V", "bindSecurityCenterService", "", "isActivityAlive", "", "markEnd", "period", "markStart", "observeLifeCycle", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "popPermissionDialogIfNeeded", "from", "forceShow", "reconnectToService", "scene", "showMainMenu", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MainActivity extends BaseActivity implements IBlockJoin {
    public static final Companion Companion = null;
    public static final int RECONNECT_TO_SERVICE = 1000;
    public static final int RESULT_CODE_MEMORY = 1002;
    public static final int RESULT_CODE_SAFE_CHECK = 1003;
    public static final int RESULT_CODE_SPAM_INTERCEPT = 1004;
    public static final int RESULT_CODE_TRASH = 1001;
    public static final String RESULT_PARAM_HASCLEAN = "hasClean";
    private static final String STATE_PRIVACY_FROM = "privacy_from";
    private HashMap _$_findViewCache;
    private final Lazy blockContext$delegate;
    private final Lazy blockScene$delegate;
    private final Handler.Callback handlerCallback;
    private View mDebugSettingEntry;
    private PreferenceMgr mPreferenceMgr;
    private Handler mainHandler;
    private MainViewModel mainViewModel;
    private final PageMonitor pageMonitor;
    private final Map<String, Long> periodStarts;
    private String privacyFrom;
    private MainRootBlock rootBlock;
    private ConstraintLayout rootView;
    private SecurityServiceBinder securityCenterService;
    private View settings;

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedanceos/securitycenter/MainActivity$Companion;", "", "()V", "RECONNECT_TO_SERVICE", "", "RESULT_CODE_MEMORY", "RESULT_CODE_SAFE_CHECK", "RESULT_CODE_SPAM_INTERCEPT", "RESULT_CODE_TRASH", "RESULT_PARAM_HASCLEAN", "", "STATE_PRIVACY_FROM", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            r0[Lifecycle.Event.ON_START.ordinal()] = 2;
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            r0[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
        }
    }

    static {
        Companion = new Companion(null);
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

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockContext getBlockContext() {
        return (IBlockContext) this.blockContext$delegate.getValue();
    }

    @Override // com.bytedance.blockframework.framework.join.IBlockJoin
    public IBlockScene getBlockScene() {
        return (IBlockScene) this.blockScene$delegate.getValue();
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "home_page";
    }

    public MainActivity() {
        this.privacyFrom = "";
        this.pageMonitor = PerformanceMonitors.createPageMonitor(PerformanceScenes.PAGE_MAIN_HOME);
        this.periodStarts = new LinkedHashMap();
        this.handlerCallback = new MainActivity$handlerCallback$1(this);
        this.blockContext$delegate = LazyKt.lazy(new MainActivity$blockContext$2(this));
        this.blockScene$delegate = LazyKt.lazy(MainActivity$blockScene$2.INSTANCE);
    }

    public static final /* synthetic */ void access$bindSecurityCenterService(MainActivity r0) {
        r0.bindSecurityCenterService();
    }

    public static final /* synthetic */ MainViewModel access$getMainViewModel$p(MainActivity r0) {
        return r0.mainViewModel;
    }

    public static final /* synthetic */ boolean access$isActivityAlive(MainActivity r0) {
        return r0.isActivityAlive();
    }

    public static final /* synthetic */ void access$markEnd(MainActivity r0, String r1) {
        r0.markEnd(r1);
    }

    public static final /* synthetic */ void access$setMainViewModel$p(MainActivity r0, MainViewModel r1) {
        r0.mainViewModel = r1;
    }

    public static final /* synthetic */ void access$showMainMenu(MainActivity r0) {
        r0.showMainMenu();
    }

    public final MainRootBlock getRootBlock() {
        return this.rootBlock;
    }

    public final void setRootBlock(MainRootBlock r1) {
        this.rootBlock = r1;
    }

    public final View getSettings() {
        return this.settings;
    }

    public final void setSettings(View r1) {
        this.settings = r1;
    }

    public final ConstraintLayout getRootView() {
        return this.rootView;
    }

    public final void setRootView(ConstraintLayout r1) {
        this.rootView = r1;
    }

    private final void markStart(String r4) {
        this.periodStarts.put(r4, Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.pageMonitor.markStart(r4);
    }

    private final void markEnd(String r6) {
        Long r0 = this.periodStarts.remove(r6);
        if (r0 == null) goto L5;
        long r1 = PerformanceMonitors.nowElapsedMs() - r0.longValue();
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(PerformanceScenes.PAGE_MAIN_HOME, r6), r1);
    L5:
        this.pageMonitor.markEnd(r6);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r12) {
        AppLaunchMonitor.Companion.getInstance().markStart(AppLaunchMonitor.PERIOD_MAIN_ACT_CREATE);
        markStart(PageMonitor.PERIOD_ACTIVITY_CREATE);
        super.onCreate(r12);
        setDescription();
        MainActivity r2 = this;
        this.mPreferenceMgr = PreferenceMgr.getInstance(r2);
        this.mainViewModel = MainViewModel.Companion.getMainViewModel(r2);
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
        if (r12 == null) goto L6;
        String r13 = r12.getString(STATE_PRIVACY_FROM);
        if (r13 == null) goto L6;
    L9:
        this.privacyFrom = r13;
        boolean r14 = getIntent().getBooleanExtra("force_show_privacy_dialog", false);
        popPermissionDialogIfNeeded(this.privacyFrom, r14);
        setContentView(R.layout.security_main3);
        PerformanceMonitors.reportSceneFrequency(PerformanceScenes.PAGE_MAIN_HOME);
        this.rootView = (ConstraintLayout) findViewById(R.id.homepage_container);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_scroll_view), C01441.INSTANCE);
        View r15 = OFloatingTitleBar.addEndAction$default((OFloatingTitleBar) findViewById(R.id.title_bar), R.drawable.ic_more_vertical, 0, null, 6, null);
        this.settings = r15;
        if (r15 == null) goto L12;
        r15.setOnClickListener(new AnonymousClass2(this));
    L12:
        View r16 = findViewById(R.id.debug_setting_entry);
        this.mDebugSettingEntry = r16;
        if (r16 == null) goto L15;
        final Ref.IntRef r3 = new Ref.IntRef();
        r3.element = 0;
        final Ref.LongRef r4 = new Ref.LongRef();
        r4.element = 0;
        r16.setOnClickListener(new MainActivity$onCreate$3$1(r4, r3));
    L15:
        ConstraintLayout r5 = this.rootView;
        Intrinsics.checkNotNull(r5);
        MainRootBlock r17 = new MainRootBlock(r5, getBlockContext());
        this.rootBlock = r17;
        Intrinsics.checkNotNull(r17);
        IBlockJoinKt.initRootBlock(this, r2, r17);
        observeLifeCycle();
        ExtKt.onPreDrawOnce(getWindow(), new AnonymousClass4(this));
        markStart("userdata_real_show");
        AppLaunchMonitor.Companion.getInstance().markEnd(AppLaunchMonitor.PERIOD_MAIN_ACT_CREATE);
        MatrixAppUpdateManager.INSTANCE.checkUpdate(this);
        markEnd(PageMonitor.PERIOD_ACTIVITY_CREATE);
        return;
    L6:
        r13 = getIntent().getStringExtra("from");
        if (r13 != null) goto L9;
        r13 = "";
        goto L9
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        AppLaunchMonitor.Companion.getInstance().markStart(AppLaunchMonitor.PERIOD_MAIN_ACT_RESUME);
        markStart(PageMonitor.PERIOD_ACTIVITY_RESUME);
        super.onResume();
        AppLaunchMonitor.Companion.getInstance().markEnd(AppLaunchMonitor.PERIOD_MAIN_ACT_RESUME);
        markEnd(PageMonitor.PERIOD_ACTIVITY_RESUME);
    }

    private final void bindSecurityCenterService() {
        SecurityServiceBinder r0 = SecurityServiceBinder.Companion.getInstance();
        this.securityCenterService = r0;
        if (r0 == null) goto L5;
        r0.onCreate();
    L5:
        MainViewModel r1 = this.mainViewModel;
        if (r1 == null) goto L11;
        MutableLiveData<ISecurityCenterService> r2 = r1.getServiceLiveData();
        if (r2 == null) goto L12;
        r2.setValue(this.securityCenterService);
        return;
    L12:
        return;
    }

    private final void reconnectToService() {
        Handler r0 = this.mainHandler;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.hasMessages(1000) == true) goto L11;
        Message r1 = Message.obtain();
        r1.what = 1000;
        Handler r3 = this.mainHandler;
        if (r3 == null) goto L12;
        r3.sendMessageDelayed(r1, 200);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final boolean isActivityAlive() {
        if (isFinishing() == false) goto L5;
    L7:
        return false;
    L5:
        if (isDestroyed() == true) goto L7;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, kotlin.jvm.functions.Function0] */
    private final void showMainMenu() {
        View r2 = this.settings;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ViewCompat.isAttachedToWindow(r2) == true) goto L8;
        return;
    L8:
        if (r2.getWindowToken() == null) goto L13;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = MainActivity$showMainMenu$dismiss$1.INSTANCE;
        MainActivity r15 = this;
        OPopoverEntranceMenuView.Builder r3 = new OPopoverEntranceMenuView.Builder(r15);
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r3, Integer.valueOf(R.drawable.oic_info_circle), null, null, getString(R.string.about_phone_manager), null, null, false, null, new MainActivity$showMainMenu$$inlined$apply$lambda$1(this, r1), 242, null);
        OPopoverEntranceMenuView r0 = r3.build();
        final OPopover r4 = new OPopover.Builder(r15).setView(r0).build();
        r1.element = (Function0) new C01461(r4);
        OPopoverHelperEx.showPopoverSmartly$default(OPopoverHelperEx.INSTANCE, r4, r2, 83, false, 0, false, 0, 0, 248, null);
        return;
    }

    private final void observeLifeCycle() {
        getLifecycle().addObserver(new AnonymousClass1(this));
    }

    static /* synthetic */ void popPermissionDialogIfNeeded$default(MainActivity r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2);
    }

    private final void popPermissionDialogIfNeeded(String r4, boolean r5) {
        if (GrantUtil.INSTANCE.isAllowed(this, r4, r5) == true) goto L5;
        GrantUtil.INSTANCE.requestGrant(this, new C01451(this, this), r4, r5);
        return;
    L5:
        Context r6 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r6, "applicationContext");
        ApmHelper.onPrivacyApproved(r6);
        VirusDbAutoUpdateInitializer.init(getApplicationContext());
        bindSecurityCenterService();
        MainViewModel r3 = this.mainViewModel;
        if (r3 == null) goto L10;
        r3.initAndStartScan();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        MainRootBlock r1 = this.rootBlock;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        r4 = new Intent();
    L7:
        r1.notifyEvent(new ActivityResultEvent(r2, r3, r4));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        getIntent().putExtra("from", "");
        getIntent().putExtra("force_show_privacy_dialog", false);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        r3.putString(STATE_PRIVACY_FROM, this.privacyFrom);
        super.onSaveInstanceState(r3);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        SecurityServiceBinder r0 = this.securityCenterService;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        MatrixAppUpdateManager.INSTANCE.abortUpdate();
    }
}
