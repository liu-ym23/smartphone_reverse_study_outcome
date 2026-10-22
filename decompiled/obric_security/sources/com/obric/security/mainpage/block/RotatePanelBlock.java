package com.obric.security.mainpage.block;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.blockframework.framework.async.AsyncUIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.interaction.Event;
import com.bytedanceos.securitycenter.MainActivity;
import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import com.obric.security.R;
import com.obric.security.health.model.HealthScoreSnapshot;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.mainpage.MainViewModel;
import com.obric.security.mainpage.block.event.ActivityResultEvent;
import com.obric.security.mainpage.util.DisplaySizeStableContext;
import com.obric.security.mainpage.view.RotatePannelManager2;
import com.obric.security.mainpage.view.RotatePannelView2;
import com.obric.security.service.SecurityServiceBinder;
import com.obric.security.service.health.HealthScoreBundleMapper;
import com.obric.securitycenter.api.Const;
import com.obric.securitycenter.api.ISecurityCenterService;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotatePanelBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\b\u0013\u0018\u0000 12\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u00011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bH\u0002J\u0012\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010!H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\u0010\u0010/\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u00100\u001a\u00020\u0018R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/security/mainpage/block/RotatePanelBlock;", "Lcom/bytedance/blockframework/framework/async/AsyncUIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "eventCallback", "com/obric/security/mainpage/block/RotatePanelBlock$eventCallback$1", "Lcom/obric/security/mainpage/block/RotatePanelBlock$eventCallback$1;", "hostActivity", "Lcom/bytedanceos/securitycenter/MainActivity;", "isBlockResumed", "", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "pendingScoreUpdate", "Landroid/os/Bundle;", "rotateListener", "com/obric/security/mainpage/block/RotatePanelBlock$rotateListener$1", "Lcom/obric/security/mainpage/block/RotatePanelBlock$rotateListener$1;", "rotatePannelManager", "Lcom/obric/security/mainpage/view/RotatePannelManager2;", "applyScoreUpdate", "", "event", "", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "enableAsyncBind", "handleActivityResult", "Lcom/obric/security/mainpage/block/event/ActivityResultEvent;", "initRotatePanel", "view", "Landroid/view/View;", "latestHealthScoreBundle", "layoutResource", "", "observeViewModel", "activity", "onCreateView", "parent", "onDestroy", "onEvent", "Lcom/bytedance/blockframework/interaction/Event;", "onPause", "onRegister", "onResume", "onViewCreated", "startScan", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RotatePanelBlock extends AsyncUIBlock<Objects, IBlockModel<Objects>> {
    private static final Companion Companion = null;

    @Deprecated
    private static final float ROTATE_PANEL_SIZE = 212.0f;

    @Deprecated
    private static final String SOURCE = "RotatePanelBlock";
    private RotatePanelBlock$eventCallback$1 eventCallback;
    private MainActivity hostActivity;
    private volatile boolean isBlockResumed;
    private MainViewModel mainViewModel;
    private volatile Bundle pendingScoreUpdate;
    private RotatePanelBlock$rotateListener$1 rotateListener;
    private RotatePannelManager2 rotatePannelManager;

    /* JADX INFO: compiled from: RotatePanelBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/mainpage/block/RotatePanelBlock$Companion;", "", "()V", "ROTATE_PANEL_SIZE", "", "SOURCE", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public boolean enableAsyncBind() {
        return false;
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock
    public int layoutResource() {
        return -1;
    }

    public static final /* synthetic */ void access$applyScoreUpdate(RotatePanelBlock r0, String r1, Bundle r2) {
        r0.applyScoreUpdate(r1, r2);
    }

    public static final /* synthetic */ RotatePanelBlock$eventCallback$1 access$getEventCallback$p(RotatePanelBlock r0) {
        return r0.eventCallback;
    }

    public static final /* synthetic */ MainActivity access$getHostActivity$p(RotatePanelBlock r0) {
        return r0.hostActivity;
    }

    public static final /* synthetic */ MainViewModel access$getMainViewModel$p(RotatePanelBlock r0) {
        return r0.mainViewModel;
    }

    public static final /* synthetic */ Bundle access$getPendingScoreUpdate$p(RotatePanelBlock r0) {
        return r0.pendingScoreUpdate;
    }

    public static final /* synthetic */ RotatePannelManager2 access$getRotatePannelManager$p(RotatePanelBlock r0) {
        return r0.rotatePannelManager;
    }

    public static final /* synthetic */ boolean access$isBlockResumed$p(RotatePanelBlock r0) {
        return r0.isBlockResumed;
    }

    public static final /* synthetic */ void access$setBlockResumed$p(RotatePanelBlock r0, boolean r1) {
        r0.isBlockResumed = r1;
    }

    public static final /* synthetic */ void access$setEventCallback$p(RotatePanelBlock r0, RotatePanelBlock$eventCallback$1 r1) {
        r0.eventCallback = r1;
    }

    public static final /* synthetic */ void access$setHostActivity$p(RotatePanelBlock r0, MainActivity r1) {
        r0.hostActivity = r1;
    }

    public static final /* synthetic */ void access$setMainViewModel$p(RotatePanelBlock r0, MainViewModel r1) {
        r0.mainViewModel = r1;
    }

    public static final /* synthetic */ void access$setPendingScoreUpdate$p(RotatePanelBlock r0, Bundle r1) {
        r0.pendingScoreUpdate = r1;
    }

    public static final /* synthetic */ void access$setRotatePannelManager$p(RotatePanelBlock r0, RotatePannelManager2 r1) {
        r0.rotatePannelManager = r1;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.security.mainpage.block.RotatePanelBlock$eventCallback$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.obric.security.mainpage.block.RotatePanelBlock$rotateListener$1] */
    public RotatePanelBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.eventCallback = new RotatePanelBlock$eventCallback$1(this);
        this.rotateListener = new RotatePanelBlock$rotateListener$1(this);
    }

    private final void applyScoreUpdate(String r4, Bundle r5) {
        Bundle r1 = (Bundle) null;
        this.pendingScoreUpdate = null;
        RotatePannelManager2 r3 = this.rotatePannelManager;
        if (r3 != null) goto L5;
        return;
    L5:
        int r0 = r5.getInt(Const.CURRENT_SCORE);
        r3.setMaxScore(r5.getInt(Const.TOTAL_SCORE));
        int r6 = r4.hashCode();
        if (r6 == (-509153886)) goto L14;
        if (r6 == 1775068966) goto L11;
        return;
    L11:
        if (r4.equals(Const.EVENT_SCAN_TASK_FINISH) == false) goto L17;
        r3.finishScanToScore(r0, true, true);
        return;
    L17:
        return;
    L14:
        if (r4.equals(Const.EVENT_CLEAR_TASK_FINISH) == false) goto L19;
        r3.finishOptimizeToScore(r0, true);
        return;
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public View onCreateView(View r5) {
        Context r1 = null;
        if ((r5 instanceof ViewGroup) == true) goto L5;
        View r0 = null;
    L6:
        ViewGroup r2 = (ViewGroup) r0;
        if (r2 == null) goto L18;
        Context r3 = r2.getContext();
        if (r3 == null) goto L18;
        if ((r3 instanceof MainActivity) == false) goto L15;
        r1 = r3;
    L15:
        this.hostActivity = (MainActivity) r1;
        View r4 = LayoutInflater.from(DisplaySizeStableContext.INSTANCE.create(r3)).inflate(R.layout.rotate_pannel_view, r2, false);
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(DisplaySizeStableContext.INSTANCE.dpToPx(r3, ROTATE_PANEL_SIZE), DisplaySizeStableContext.INSTANCE.dpToPx(r3, ROTATE_PANEL_SIZE));
        r6.gravity = 17;
        Unit r7 = Unit.INSTANCE;
        r4.setLayoutParams(r6);
        Intrinsics.checkNotNullExpressionValue(r4, "LayoutInflater.from(Disp…          }\n            }");
        return r4;
    L18:
        return super.onCreateView(r5);
    L5:
        r0 = r5;
        goto L6
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        MainActivity r0 = this.hostActivity;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mainViewModel = MainViewModel.Companion.getMainViewModel(r0);
        observeViewModel(r0);
        initRotatePanel(r4);
    }

    private final void observeViewModel(MainActivity r4) {
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<ISecurityCenterService> r1 = r0.getServiceLiveData();
        if (r1 == null) goto L7;
        r1.observe(r4, new C03871(this));
    L7:
        MainViewModel r2 = this.mainViewModel;
        if (r2 == null) goto L13;
        MutableLiveData<Integer> r3 = r2.getStartScanTrashAndMem();
        if (r3 == null) goto L14;
        r3.observe(r4, new AnonymousClass2(this));
        return;
    L14:
        return;
    }

    private final void initRotatePanel(View r3) {
        RotatePannelManager2 r0 = new RotatePannelManager2((RotatePannelView2) r3.findViewById(R.id.main_rotate_pannel));
        this.rotatePannelManager = r0;
        r0.setRotateListener(this.rotateListener);
        RotatePannelManager2 r4 = this.rotatePannelManager;
        if (r4 == null) goto L6;
        r4.setScoreClickListener(new AnonymousClass1(this));
        return;
    }

    public final void startScan() {
        HealthScoreLog.INSTANCE.i(SOURCE, "startScan");
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Integer> r1 = r0.getStartScanTrashAndMem();
        if (r1 == null) goto L7;
        r1.setValue(2);
    L7:
        MainViewModel r2 = this.mainViewModel;
        if (r2 == null) goto L14;
        MutableLiveData<ISecurityCenterService> r3 = r2.getServiceLiveData();
        if (r3 == null) goto L14;
        ISecurityCenterService r4 = r3.getValue();
        if (r4 == null) goto L14;
        r4.startScanTrashAndMem();
    L14:
        RotatePannelManager2 r5 = this.rotatePannelManager;
        if (r5 == null) goto L18;
        r5.startScan(false);
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        this.isBlockResumed = true;
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L9;
        MutableLiveData<ISecurityCenterService> r1 = r0.getServiceLiveData();
        if (r1 == null) goto L9;
        ISecurityCenterService r2 = r1.getValue();
        if (r2 == null) goto L9;
        r2.resumeScanTrashAndMem();
    L9:
        Bundle r3 = this.pendingScoreUpdate;
        if (r3 == null) goto L20;
        Bundle r4 = (Bundle) null;
        this.pendingScoreUpdate = null;
        String r5 = r3.getString("event");
        if (Intrinsics.areEqual(r5, Const.EVENT_SCAN_TASK_FINISH) == false) goto L14;
    L15:
        Bundle r6 = latestHealthScoreBundle();
        if (r6 != null) goto L18;
        r6 = r3;
    L18:
        HealthScoreLog.INSTANCE.i(SOURCE, "applyPendingScoreUpdate event=" + r5 + " score=" + r3.getInt(Const.CURRENT_SCORE) + " totalScore=" + r3.getInt(Const.TOTAL_SCORE) + " latestScore=" + r6.getInt(Const.CURRENT_SCORE));
        applyScoreUpdate(r5, r6);
        return;
    L14:
        if (Intrinsics.areEqual(r5, Const.EVENT_CLEAR_TASK_FINISH) == true) goto L15;
        return;
    }

    private final Bundle latestHealthScoreBundle() {
        MainViewModel r2 = this.mainViewModel;
        if (r2 == null) goto L17;
        MutableLiveData<ISecurityCenterService> r3 = r2.getServiceLiveData();
        if (r3 == null) goto L18;
        ISecurityCenterService r4 = r3.getValue();
        if (r4 != null) goto L9;
        return null;
    L9:
        if ((r4 instanceof SecurityServiceBinder) == true) goto L11;
        r4 = null;
    L11:
        SecurityServiceBinder r5 = (SecurityServiceBinder) r4;
        if (r5 == null) goto L20;
        HealthScoreSnapshot r6 = r5.getHealthSnapshot();
        if (r6 != null) goto L16;
        return null;
    L16:
        return HealthScoreBundleMapper.INSTANCE.fromHealthSnapshot(r6);
    L20:
        return null;
    L18:
        return null;
    L17:
        return null;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void onRegister() {
        subscribe(this, ActivityResultEvent.class);
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock, com.bytedance.blockframework.interaction.IObserver
    public boolean onEvent(Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof ActivityResultEvent) == false) goto L6;
        handleActivityResult((ActivityResultEvent) r2);
    L6:
        return super.onEvent(r2);
    }

    private final void handleActivityResult(ActivityResultEvent r6) {
        RotatePannelManager2 r0 = this.rotatePannelManager;
        if (r0 != null) goto L5;
    L25:
        HealthScoreLog.INSTANCE.d(SOURCE, "activityResult ignored requestCode=" + r6.getRequestCode() + " resultState=false");
        return;
    L5:
        if (r0.isResultState() != true) goto L25;
        boolean r1 = r6.getData().getBooleanExtra("hasClean", false);
        HealthScoreLog.INSTANCE.i(SOURCE, "activityResult requestCode=" + r6.getRequestCode() + " resultCode=" + r6.getResultCode() + " hasClean=" + r1);
        switch(r6.getRequestCode()) {
            case 1001: goto L20;
            case 1002: goto L16;
            case 1003: goto L13;
            case 1004: goto L10;
            default: goto L36;
        };
    L10:
        MainViewModel r5 = this.mainViewModel;
        if (r5 == null) goto L27;
        r5.startSpamInterceptHealthScoreRefresh();
        return;
    L27:
        return;
    L13:
        MainViewModel r7 = this.mainViewModel;
        if (r7 == null) goto L29;
        r7.startSafeCheckHealthScoreRefresh();
        return;
    L29:
        return;
    L16:
        if (r1 == false) goto L31;
        MainViewModel r8 = this.mainViewModel;
        if (r8 == null) goto L32;
        r8.startMemoryCleanHealthScoreRefresh();
        return;
    L32:
        return;
    L31:
        return;
    L20:
        if (r1 == false) goto L34;
        MainViewModel r9 = this.mainViewModel;
        if (r9 == null) goto L35;
        r9.startTrashCleanHealthScoreRefresh();
        return;
    L35:
        return;
    L34:
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        this.isBlockResumed = false;
        MainViewModel r1 = this.mainViewModel;
        if (r1 == null) goto L10;
        MutableLiveData<ISecurityCenterService> r2 = r1.getServiceLiveData();
        if (r2 == null) goto L11;
        ISecurityCenterService r3 = r2.getValue();
        if (r3 == null) goto L12;
        r3.pauseScanTrashAndMem();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
        super.onDestroy();
        SecurityServiceBinder.Companion.getInstance().unsubscribe(this.eventCallback);
        RotatePannelManager2 r2 = this.rotatePannelManager;
        if (r2 == null) goto L6;
        r2.onDestory();
        return;
    }
}
