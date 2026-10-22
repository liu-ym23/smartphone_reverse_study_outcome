package com.obric.security.battertpower;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.framework.join.IBlockJoin;
import com.bytedance.blockframework.framework.join.IBlockJoinKt;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.security.BaseActivity;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import com.obric.security.battertpower.block.BatteryPowerRootBlock;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryPowerActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0002J\u0012\u00103\u001a\u0002012\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u000201H\u0014J\b\u00107\u001a\u000201H\u0014J\b\u00108\u001a\u000201H\u0014J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u000201H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006>"}, d2 = {"Lcom/obric/security/battertpower/BatteryPowerActivity;", "Lcom/bytedanceos/security/BaseActivity;", "Lcom/bytedance/blockframework/framework/join/IBlockJoin;", "()V", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "getBlockContext", "()Lcom/bytedance/blockframework/framework/join/IBlockContext;", "blockContext$delegate", "Lkotlin/Lazy;", "blockScene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "getBlockScene", "()Lcom/bytedance/blockframework/framework/join/IBlockScene;", "blockScene$delegate", "handlerCallback", "Landroid/os/Handler$Callback;", "mainHandler", "Landroid/os/Handler;", "rootView", "Landroid/widget/RelativeLayout;", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollFpsHandler", "scrollFpsSession", "Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "scrollFpsStarted", "", "scrollFpsStopRunnable", "Ljava/lang/Runnable;", "scrollView", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "getScrollView", "()Lcom/obric/oui/bouncelayout/ONestedScrollView;", "setScrollView", "(Lcom/obric/oui/bouncelayout/ONestedScrollView;)V", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "viewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "getViewModel", "()Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "setViewModel", "(Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;)V", "initObserve", "", "observeLifeCycle", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onScrollChangedForFps", "scene", "", "stopScrollFps", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryPowerActivity extends BaseActivity implements IBlockJoin {
    public static final Companion Companion = null;
    public static final int MSG_APP_POWER_DATA_REFRESH = 1022;
    public static final long MSG_APP_POWER_DATA_REFRESH_DELAY = 300000;
    private HashMap _$_findViewCache;
    private final Lazy blockContext$delegate;
    private final Lazy blockScene$delegate;
    private final Handler.Callback handlerCallback;
    private Handler mainHandler;
    private RelativeLayout rootView;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final Handler scrollFpsHandler;
    private final PerformanceMonitors.FpsSceneSession scrollFpsSession;
    private boolean scrollFpsStarted;
    private final Runnable scrollFpsStopRunnable;
    private ONestedScrollView scrollView;
    private OFloatingTitleBar titleBar;
    private BatteryPowerActivityViewModel viewModel;

    /* JADX INFO: compiled from: BatteryPowerActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/battertpower/BatteryPowerActivity$Companion;", "", "()V", "MSG_APP_POWER_DATA_REFRESH", "", "MSG_APP_POWER_DATA_REFRESH_DELAY", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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
        return "battery_saving_page";
    }

    public BatteryPowerActivity() {
        this.scrollFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_BATTERY_POWER_SCROLL);
        this.scrollFpsHandler = new Handler(Looper.getMainLooper());
        this.scrollFpsStopRunnable = new BatteryPowerActivity$scrollFpsStopRunnable$1(this);
        this.scrollChangedListener = new BatteryPowerActivity$scrollChangedListener$1(this);
        this.handlerCallback = new BatteryPowerActivity$handlerCallback$1(this);
        this.blockContext$delegate = LazyKt.lazy(new BatteryPowerActivity$blockContext$2(this));
        this.blockScene$delegate = LazyKt.lazy(BatteryPowerActivity$blockScene$2.INSTANCE);
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(BatteryPowerActivity r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ void access$onScrollChangedForFps(BatteryPowerActivity r0) {
        r0.onScrollChangedForFps();
    }

    public static final /* synthetic */ void access$setMainHandler$p(BatteryPowerActivity r0, Handler r1) {
        r0.mainHandler = r1;
    }

    public static final /* synthetic */ void access$stopScrollFps(BatteryPowerActivity r0) {
        r0.stopScrollFps();
    }

    public final RelativeLayout getRootView() {
        return this.rootView;
    }

    public final void setRootView(RelativeLayout r1) {
        this.rootView = r1;
    }

    public final ONestedScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(ONestedScrollView r1) {
        this.scrollView = r1;
    }

    public final BatteryPowerActivityViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel(BatteryPowerActivityViewModel r1) {
        this.viewModel = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.battery_power_layout);
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
        this.rootView = (RelativeLayout) findViewById(R.id.battery_power_root);
        this.scrollView = (ONestedScrollView) findViewById(R.id.main_view);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        this.titleBar = r0;
        if (r0 == null) goto L7;
        View r8 = OFloatingTitleBar.addStartAction$default(r0, R.drawable.o_floating_title_bar_icon_back, 0, null, 6, null);
        if (r8 == null) goto L7;
        r8.setOnClickListener(new ViewOnClickListenerC03401(this));
    L7:
        String r9 = getIntent().getStringExtra("from");
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        Intrinsics.checkNotNullExpressionValue(r9, "intent.getStringExtra(\"from\") ?: \"\"");
        this.viewModel = (BatteryPowerActivityViewModel) new ViewModelProvider(this).get(BatteryPowerActivityViewModel.class);
        initObserve();
        BatteryPowerActivityViewModel r1 = this.viewModel;
        if (r1 == null) goto L13;
        PreferenceMgr r2 = PreferenceMgr.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(r2, "PreferenceMgr.getInstance(this)");
        r1.popPermissionDialogIfNeeded(this, r2.isAllowed(), r9);
    L13:
        RelativeLayout r3 = this.rootView;
        Intrinsics.checkNotNull(r3);
        BatteryPowerRootBlock r10 = new BatteryPowerRootBlock(r3, getBlockContext());
        IBlockJoinKt.initRootBlock(this, this, r10);
        observeLifeCycle();
        ONestedScrollView r11 = this.scrollView;
        if (r11 == null) goto L19;
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12 == null) goto L20;
        r12.addOnScrollChangedListener(this.scrollChangedListener);
        return;
    L20:
        return;
    }

    private final void onScrollChangedForFps() {
        if (this.scrollFpsStarted == true) goto L5;
        this.scrollFpsStarted = true;
        this.scrollFpsSession.start();
    L5:
        this.scrollFpsHandler.removeCallbacks(this.scrollFpsStopRunnable);
        this.scrollFpsHandler.postDelayed(this.scrollFpsStopRunnable, 250);
    }

    private final void stopScrollFps() {
        if (this.scrollFpsStarted == true) goto L5;
        return;
    L5:
        this.scrollFpsStarted = false;
        this.scrollFpsSession.stop();
    }

    private final void initObserve() {
        BatteryPowerActivityViewModel r0 = this.viewModel;
        if (r0 == null) goto L8;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L9;
        r1.observe(this, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BatteryPowerActivity r0 = this;
        PreferenceMgr r1 = PreferenceMgr.getInstance(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "preferenceMgr");
        if (r1.isAllowed() == false) goto L5;
    L6:
        BatteryPowerActivityViewModel r2 = this.viewModel;
        if (r2 == null) goto L9;
        r2.getPowerProfileData(r0);
    L9:
        Message r3 = Message.obtain();
        r3.what = MSG_APP_POWER_DATA_REFRESH;
        Handler r4 = this.mainHandler;
        if (r4 == null) goto L14;
        r4.sendMessageDelayed(r3, 300000);
        return;
    L14:
        return;
    L5:
        if (r1.getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L6;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopScrollFps();
        this.scrollFpsHandler.removeCallbacks(this.scrollFpsStopRunnable);
        super.onPause();
        Handler r2 = this.mainHandler;
        if (r2 == null) goto L6;
        r2.removeCallbacksAndMessages(null);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        stopScrollFps();
        this.scrollFpsHandler.removeCallbacks(this.scrollFpsStopRunnable);
        ONestedScrollView r0 = this.scrollView;
        if (r0 == null) goto L12;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L12;
        if (r1.isAlive() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r1.removeOnScrollChangedListener(this.scrollChangedListener);
    L12:
        super.onDestroy();
    }

    private final void observeLifeCycle() {
        getLifecycle().addObserver(new C03391(this));
    }
}
