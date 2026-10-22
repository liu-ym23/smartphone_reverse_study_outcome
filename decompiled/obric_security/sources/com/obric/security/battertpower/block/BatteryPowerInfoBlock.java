package com.obric.security.battertpower.block;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.android.calendar.privacy.GrantUtil;
import com.bytedance.blockframework.framework.async.AsyncUIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedance.blockframework.interaction.Event;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.oui.MultiSegmentProgressBar;
import com.bytedanceos.utils.BatteryUtil;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.battertpower.PowerAdvisorService;
import com.obric.security.battertpower.block.event.PowerSavingModeEvent;
import com.obric.security.battertpower.healthandcharge.HealthAndChargeActivity;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BatteryPowerInfoBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001+B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001eH\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\u001cH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/security/battertpower/block/BatteryPowerInfoBlock;", "Lcom/bytedance/blockframework/framework/async/AsyncUIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "batteryInfoReceiver", "Landroid/content/BroadcastReceiver;", "batteryLeftView", "Lcom/obric/oui/text/OTextView;", "firstResume", "", "handlerCallback", "Landroid/os/Handler$Callback;", "isCharging", "mainHandler", "Landroid/os/Handler;", "remainTimeView", "storageProgress", "Lcom/bytedanceos/oui/MultiSegmentProgressBar;", "viewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "enableAsyncBind", "isPowerMode", "context", "Landroid/content/Context;", "layoutResource", "", "onDestroy", "", "onEvent", "event", "Lcom/bytedance/blockframework/interaction/Event;", "onPause", "onRegister", "onResume", "onViewCreated", "view", "Landroid/view/View;", "remainTimeUpdate", "updateProgressBar", HealthAndChargeActivity.BATTERY_PERCENTAGE, "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryPowerInfoBlock extends AsyncUIBlock<Objects, IBlockModel<Objects>> {
    public static final Companion Companion = null;
    public static final long MSG_BATTERY_STATUS_CHANGE_DELAY2 = 500;
    private final BroadcastReceiver batteryInfoReceiver;
    private OTextView batteryLeftView;
    private boolean firstResume;
    private final Handler.Callback handlerCallback;
    private boolean isCharging;
    private Handler mainHandler;
    private OTextView remainTimeView;
    private MultiSegmentProgressBar storageProgress;
    private BatteryPowerActivityViewModel viewModel;

    /* JADX INFO: compiled from: BatteryPowerInfoBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/battertpower/block/BatteryPowerInfoBlock$Companion;", "", "()V", "MSG_BATTERY_STATUS_CHANGE_DELAY2", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.blockframework.framework.async.IAsyncBind
    public boolean enableAsyncBind() {
        return false;
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock
    public int layoutResource() {
        return R.layout.battery_power;
    }

    public BatteryPowerInfoBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.firstResume = true;
        this.handlerCallback = new BatteryPowerInfoBlock$handlerCallback$1(this);
        this.batteryInfoReceiver = new BatteryPowerInfoBlock$batteryInfoReceiver$1(this);
    }

    public static final /* synthetic */ OTextView access$getBatteryLeftView$p(BatteryPowerInfoBlock r0) {
        return r0.batteryLeftView;
    }

    public static final /* synthetic */ boolean access$getFirstResume$p(BatteryPowerInfoBlock r0) {
        return r0.firstResume;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(BatteryPowerInfoBlock r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ boolean access$isCharging$p(BatteryPowerInfoBlock r0) {
        return r0.isCharging;
    }

    public static final /* synthetic */ void access$remainTimeUpdate(BatteryPowerInfoBlock r0) {
        r0.remainTimeUpdate();
    }

    public static final /* synthetic */ void access$setBatteryLeftView$p(BatteryPowerInfoBlock r0, OTextView r1) {
        r0.batteryLeftView = r1;
    }

    public static final /* synthetic */ void access$setCharging$p(BatteryPowerInfoBlock r0, boolean r1) {
        r0.isCharging = r1;
    }

    public static final /* synthetic */ void access$setFirstResume$p(BatteryPowerInfoBlock r0, boolean r1) {
        r0.firstResume = r1;
    }

    public static final /* synthetic */ void access$setMainHandler$p(BatteryPowerInfoBlock r0, Handler r1) {
        r0.mainHandler = r1;
    }

    public static final /* synthetic */ void access$updateProgressBar(BatteryPowerInfoBlock r0, int r1) {
        r0.updateProgressBar(r1);
    }

    private final void remainTimeUpdate() {
        OTextView r0 = this.batteryLeftView;
        String r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L7:
        if (isPowerMode(r2) == false) goto L15;
        long r4 = PowerAdvisorService.computePowerSavingModeBatteryTimeRemaining() / ((long) 1000000);
        if (r4 >= 60) goto L17;
        OTextView r3 = this.batteryLeftView;
        if (r3 == null) goto L13;
        Context r5 = r3.getContext();
    L14:
        r4 = ((BatteryUtil.getBatteryTimeRemainingMs(r5) / ((long) 1000)) * ((long) 16)) / ((long) 15);
        goto L17
    L13:
        r5 = null;
    L17:
        if (this.isCharging == false) goto L28;
        OTextView r6 = this.remainTimeView;
        if (r6 == null) goto L40;
        OTextView r8 = this.batteryLeftView;
        if (r8 == null) goto L25;
        Context r9 = r8.getContext();
        if (r9 == null) goto L25;
        r1 = r9.getString(R.string.battery_info_status_charging_lower);
    L25:
        r6.setText(r1);
        return;
    L40:
        return;
    L28:
        if (r4 < 60) goto L36;
        OTextView r10 = this.remainTimeView;
        if (r10 == null) goto L41;
        if (r10 == null) goto L35;
        Context r7 = r10.getContext();
        if (r7 == null) goto L35;
        r1 = r7.getString(R.string.remaining);
    L35:
        r10.setText(Intrinsics.stringPlus(r1, BatteryPowerActivityViewModel.Companion.formatDurationForCharacters(r4)));
        return;
    L41:
        return;
    L36:
        OTextView r11 = this.remainTimeView;
        if (r11 == null) goto L43;
        r11.setText("--");
        return;
    L43:
        return;
    L15:
        r4 = PowerAdvisorService.computeBatteryTimeRemaining() / ((long) 1000000);
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Object r0 = r3.getContext();
        if ((r0 instanceof ViewModelStoreOwner) == true) goto L5;
        r0 = null;
    L5:
        ViewModelStoreOwner r1 = (ViewModelStoreOwner) r0;
        if (r1 == null) goto L8;
        this.viewModel = (BatteryPowerActivityViewModel) new ViewModelProvider(r1).get(BatteryPowerActivityViewModel.class);
    L8:
        this.batteryLeftView = (OTextView) r3.findViewById(R.id.battery_vaule);
        this.remainTimeView = (OTextView) r3.findViewById(R.id.remain_time_tv);
        MultiSegmentProgressBar r4 = (MultiSegmentProgressBar) r3.findViewById(R.id.storage_progress);
        this.storageProgress = r4;
        if (r4 == null) goto L11;
        r4.setAnimationDuration(300);
    L11:
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        OTextView r0 = this.batteryLeftView;
        Context r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.getContext();
    L6:
        PreferenceMgr r3 = PreferenceMgr.getInstance(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "PreferenceMgr.getInstanc…batteryLeftView?.context)");
        if (r3.isAllowed() == true) goto L13;
        OTextView r4 = this.batteryLeftView;
        if (r4 == null) goto L12;
        r1 = r4.getContext();
    L12:
        if (PreferenceMgr.getInstance(r1).getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L13;
        return;
    L13:
        OTextView r5 = this.batteryLeftView;
        if (r5 == null) goto L20;
        Context r6 = r5.getContext();
        if (r6 == null) goto L21;
        r6.registerReceiver(this.batteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void updateProgressBar(int r6) {
        OTextView r0 = this.batteryLeftView;
        if (r0 == null) goto L9;
        Resources r1 = r0.getResources();
        if (r1 == null) goto L9;
        DisplayMetrics r2 = r1.getDisplayMetrics();
        if (r2 == null) goto L9;
        float r3 = r2.density;
    L10:
        float r4 = 8.0f * r3;
        float[] r5 = {r4, r4, 0.0f, 0.0f, 0.0f, 0.0f, r4, r4};
        float r7 = RangesKt.coerceIn(r6, 0, 100) / 100.0f;
        OTextView r8 = this.batteryLeftView;
        if (r8 == null) goto L15;
        Resources r9 = r8.getResources();
        if (r9 == null) goto L15;
        int r10 = r9.getColor(R.color.oui_functional_green_6);
    L16:
        MultiSegmentProgressBar r11 = this.storageProgress;
        if (r11 == null) goto L20;
        r11.setSegments(CollectionsKt.listOf(new MultiSegmentProgressBar.Segment(r10, r7, r5)));
        return;
    L20:
        return;
    L15:
        r10 = (int) 4280391411L;
    L9:
        r3 = 1.0f;
        goto L10
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        OTextView r0 = this.batteryLeftView;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L6:
        PreferenceMgr r2 = PreferenceMgr.getInstance(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "PreferenceMgr.getInstanc…batteryLeftView?.context)");
        if (r2.isAllowed() == true) goto L14;
        OTextView r3 = this.batteryLeftView;
        if (r3 == null) goto L11;
        Context r4 = r3.getContext();
    L13:
        if (PreferenceMgr.getInstance(r4).getIsAllowedFromUid(GrantUtil.securitymanager) == true) goto L14;
        return;
    L11:
        r4 = null;
    L14:
        Handler r5 = this.mainHandler;
        if (r5 == null) goto L17;
        r5.removeCallbacksAndMessages(null);
    L17:
        OTextView r6 = this.batteryLeftView;
        if (r6 == null) goto L24;
        Context r7 = r6.getContext();
        if (r7 == null) goto L25;
        r7.unregisterReceiver(this.batteryInfoReceiver);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void onRegister() {
        subscribe(this, PowerSavingModeEvent.class);
    }

    @Override // com.bytedance.blockframework.contract.AbstractBlock, com.bytedance.blockframework.interaction.IObserver
    public boolean onEvent(Event r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof PowerSavingModeEvent) == false) goto L6;
        remainTimeUpdate();
    L6:
        return super.onEvent(r2);
    }

    public final boolean isPowerMode(Context r2) {
        if (r2 == null) goto L4;
        ContentResolver r1 = r2.getContentResolver();
    L6:
        if (Settings.Global.getInt(r1, "low_power", 0) == 0) goto L9;
        return true;
    L9:
        return false;
    L4:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
        super.onDestroy();
        Handler r1 = this.mainHandler;
        if (r1 == null) goto L6;
        r1.removeCallbacksAndMessages(null);
        return;
    }
}
