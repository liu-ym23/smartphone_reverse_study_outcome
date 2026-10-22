package com.obric.security.battertpower.block;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.blockframework.framework.async.AsyncUIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.bytedanceos.security.SmtDevice;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.bytedanceos.securitycenter.SharedPreferUtil;
import com.bytedanceos.utils.Constants;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.battertpower.PowerAdvisorService;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryConfigBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 m2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001mB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010J\u001a\u00020IH\u0016J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020IH\u0002J\u0010\u0010R\u001a\u00020I2\b\u0010S\u001a\u0004\u0018\u00010TJ\u0010\u0010U\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010X\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010Y\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010Z\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010[\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010\\\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010]\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010^\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0002J\u0012\u0010_\u001a\u00020I2\b\u0010S\u001a\u0004\u0018\u00010TH\u0002J\u0010\u0010Q\u001a\u00020I2\b\u0010S\u001a\u0004\u0018\u00010TJ\b\u0010`\u001a\u00020%H\u0016J\b\u0010a\u001a\u00020LH\u0016J\b\u0010b\u001a\u00020LH\u0016J\b\u0010c\u001a\u00020LH\u0016J\u0010\u0010d\u001a\u00020L2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010e\u001a\u00020LH\u0002J\b\u0010f\u001a\u00020LH\u0002J\b\u0010g\u001a\u00020LH\u0002J\b\u0010h\u001a\u00020LH\u0002J\b\u0010i\u001a\u00020LH\u0002J\b\u0010j\u001a\u00020LH\u0002J\b\u0010k\u001a\u00020LH\u0002J\b\u0010l\u001a\u00020LH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020%2\u0006\u0010&\u001a\u00020%8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0012\"\u0004\b<\u0010\u0014R\u0010\u0010=\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010\u0014R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0012\"\u0004\bG\u0010\u0014R\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lcom/obric/security/battertpower/block/BatteryConfigBlock;", "Lcom/bytedance/blockframework/framework/async/AsyncUIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "LOW_POWER_MODE_TRIGER", "", "getLOW_POWER_MODE_TRIGER", "()[I", "setLOW_POWER_MODE_TRIGER", "([I)V", "appNetControlItem", "Lcom/obric/oui/lisitem/OCardListItem;", "autoEnablesSaverMode", "Lcom/obric/oui/oswitch/OSwitch;", "getAutoEnablesSaverMode", "()Lcom/obric/oui/oswitch/OSwitch;", "setAutoEnablesSaverMode", "(Lcom/obric/oui/oswitch/OSwitch;)V", "autoEnablesSaverModeSwitch", "autoPowerModeChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "autoSleepModeSwitch", "getAutoSleepModeSwitch", "setAutoSleepModeSwitch", "autoSleepModeView", "batteryHealthAndCharging", "batteryHealthAndChargingSwitch", "getBatteryHealthAndChargingSwitch", "setBatteryHealthAndChargingSwitch", "batteryPercentage", "batterySwitch", "getBatterySwitch", "setBatterySwitch", "mChooseIndex", "", "value", "mLastConfirmedIndex", "getMLastConfirmedIndex", "()I", "setMLastConfirmedIndex", "(I)V", "mLowBatteryModeChangeListener", "Landroid/view/View$OnClickListener;", "mLowBatteryModeObserver", "Landroid/database/ContentObserver;", "mLowPowerModeTriggerLevelObserver", "mPowerManager", "Landroid/os/PowerManager;", "mSavePowerDialog", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "mSettingValueObserver", "mSimStateReceiver", "Landroid/content/BroadcastReceiver;", "mTelephonyManager", "Landroid/telephony/TelephonyManager;", "powerSaverModeSwitch", "getPowerSaverModeSwitch", "setPowerSaverModeSwitch", "powerSaverModeView", "screenPowerOptimizeSwitch", "getScreenPowerOptimizeSwitch", "setScreenPowerOptimizeSwitch", "screenPowerOptimizeTips", "Landroid/widget/TextView;", "screenPowerOptimizeView", "smartPowerSaving5g", "smartPowerSaving5gSwitch", "getSmartPowerSaving5gSwitch", "setSmartPowerSaving5gSwitch", "viewInit", "", "enableAsyncBind", "generateSubBlocks", "", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "getDrainTimeInSaverMode", "", "isPowerMode", "hasSimCard", "context", "Landroid/content/Context;", "initAppNetControlItem", "view", "Landroid/view/View;", "initAutoPowerMode", "initAutoSleepMode", "initBatteryHealthaAndCharging", "initBatteryPercentage", "initPowerModeView", "initScreenPowerOptimize", "initSmartPowerSaving5g", "isAirPlaneModeOn", "layoutResource", "onCreate", "onPause", "onResume", "onViewCreated", "showSingleChoiceDialog", "updateAutoPowerMode", "updateAutoPowerModeSubtitle", "updateAutoSleepMode", "updateBatteryPercent", "updatePowerModeView", "updateScreenPowerOptimize", "updateSmartPowerSaving5g", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryConfigBlock extends AsyncUIBlock<Objects, IBlockModel<Objects>> {
    public static final Companion Companion = null;
    private static final String SP_BATTERY_CONFIG = "battery_config";
    private static final String SP_KEY_LAST_CONFIRMED_INDEX = "low_power_mode_last_confirmed_index";
    private int[] LOW_POWER_MODE_TRIGER;
    private OCardListItem appNetControlItem;
    private OSwitch autoEnablesSaverMode;
    private OCardListItem autoEnablesSaverModeSwitch;
    private final CompoundButton.OnCheckedChangeListener autoPowerModeChangeListener;
    private OSwitch autoSleepModeSwitch;
    private OCardListItem autoSleepModeView;
    private OCardListItem batteryHealthAndCharging;
    private OSwitch batteryHealthAndChargingSwitch;
    private OCardListItem batteryPercentage;
    private OSwitch batterySwitch;
    private int mChooseIndex;
    private final View.OnClickListener mLowBatteryModeChangeListener;
    private final ContentObserver mLowBatteryModeObserver;
    private final ContentObserver mLowPowerModeTriggerLevelObserver;
    private PowerManager mPowerManager;
    private OSelectionDialog mSavePowerDialog;
    private final ContentObserver mSettingValueObserver;
    private final BroadcastReceiver mSimStateReceiver;
    private TelephonyManager mTelephonyManager;
    private OSwitch powerSaverModeSwitch;
    private OCardListItem powerSaverModeView;
    private OSwitch screenPowerOptimizeSwitch;
    private TextView screenPowerOptimizeTips;
    private OCardListItem screenPowerOptimizeView;
    private OCardListItem smartPowerSaving5g;
    private OSwitch smartPowerSaving5gSwitch;
    private boolean viewInit;

    /* JADX INFO: compiled from: BatteryConfigBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/security/battertpower/block/BatteryConfigBlock$Companion;", "", "()V", "SP_BATTERY_CONFIG", "", "SP_KEY_LAST_CONFIRMED_INDEX", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void generateSubBlocks(BlockGenerator r1) {
        Intrinsics.checkNotNullParameter(r1, "generator");
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock
    public int layoutResource() {
        return R.layout.battery_config;
    }

    public BatteryConfigBlock(IBlockContext r3) {
        Intrinsics.checkNotNullParameter(r3, "blockContext");
        super(r3);
        final Handler r0 = new Handler(Looper.getMainLooper());
        this.mLowBatteryModeObserver = new BatteryConfigBlock$mLowBatteryModeObserver$1(this, r0);
        this.mSimStateReceiver = new BatteryConfigBlock$mSimStateReceiver$1(this);
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mSettingValueObserver = new BatteryConfigBlock$mSettingValueObserver$1(this, r1);
        final Handler r2 = new Handler(Looper.getMainLooper());
        this.mLowPowerModeTriggerLevelObserver = new BatteryConfigBlock$mLowPowerModeTriggerLevelObserver$1(this, r2);
        this.autoPowerModeChangeListener = new BatteryConfigBlock$autoPowerModeChangeListener$1(this);
        this.LOW_POWER_MODE_TRIGER = new int[]{10, 20, 30, 40, 50};
        this.mLowBatteryModeChangeListener = new BatteryConfigBlock$mLowBatteryModeChangeListener$1(this);
    }

    public static final /* synthetic */ OCardListItem access$getAutoEnablesSaverModeSwitch$p(BatteryConfigBlock r0) {
        return r0.autoEnablesSaverModeSwitch;
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener access$getAutoPowerModeChangeListener$p(BatteryConfigBlock r0) {
        return r0.autoPowerModeChangeListener;
    }

    public static final /* synthetic */ OCardListItem access$getBatteryHealthAndCharging$p(BatteryConfigBlock r0) {
        return r0.batteryHealthAndCharging;
    }

    public static final /* synthetic */ int access$getMChooseIndex$p(BatteryConfigBlock r0) {
        return r0.mChooseIndex;
    }

    public static final /* synthetic */ int access$getMLastConfirmedIndex$p(BatteryConfigBlock r0) {
        return r0.getMLastConfirmedIndex();
    }

    public static final /* synthetic */ PowerManager access$getMPowerManager$p(BatteryConfigBlock r0) {
        return r0.mPowerManager;
    }

    public static final /* synthetic */ OSelectionDialog access$getMSavePowerDialog$p(BatteryConfigBlock r0) {
        return r0.mSavePowerDialog;
    }

    public static final /* synthetic */ OCardListItem access$getSmartPowerSaving5g$p(BatteryConfigBlock r0) {
        return r0.smartPowerSaving5g;
    }

    public static final /* synthetic */ boolean access$getViewInit$p(BatteryConfigBlock r0) {
        return r0.viewInit;
    }

    public static final /* synthetic */ void access$setAutoEnablesSaverModeSwitch$p(BatteryConfigBlock r0, OCardListItem r1) {
        r0.autoEnablesSaverModeSwitch = r1;
    }

    public static final /* synthetic */ void access$setBatteryHealthAndCharging$p(BatteryConfigBlock r0, OCardListItem r1) {
        r0.batteryHealthAndCharging = r1;
    }

    public static final /* synthetic */ void access$setMChooseIndex$p(BatteryConfigBlock r0, int r1) {
        r0.mChooseIndex = r1;
    }

    public static final /* synthetic */ void access$setMLastConfirmedIndex$p(BatteryConfigBlock r0, int r1) {
        r0.setMLastConfirmedIndex(r1);
    }

    public static final /* synthetic */ void access$setMPowerManager$p(BatteryConfigBlock r0, PowerManager r1) {
        r0.mPowerManager = r1;
    }

    public static final /* synthetic */ void access$setMSavePowerDialog$p(BatteryConfigBlock r0, OSelectionDialog r1) {
        r0.mSavePowerDialog = r1;
    }

    public static final /* synthetic */ void access$setSmartPowerSaving5g$p(BatteryConfigBlock r0, OCardListItem r1) {
        r0.smartPowerSaving5g = r1;
    }

    public static final /* synthetic */ void access$setViewInit$p(BatteryConfigBlock r0, boolean r1) {
        r0.viewInit = r1;
    }

    public static final /* synthetic */ void access$showSingleChoiceDialog(BatteryConfigBlock r0) {
        r0.showSingleChoiceDialog();
    }

    public static final /* synthetic */ void access$updateAutoPowerMode(BatteryConfigBlock r0) {
        r0.updateAutoPowerMode();
    }

    public static final /* synthetic */ void access$updateAutoPowerModeSubtitle(BatteryConfigBlock r0) {
        r0.updateAutoPowerModeSubtitle();
    }

    public static final /* synthetic */ void access$updatePowerModeView(BatteryConfigBlock r0) {
        r0.updatePowerModeView();
    }

    public static final /* synthetic */ void access$updateSmartPowerSaving5g(BatteryConfigBlock r0) {
        r0.updateSmartPowerSaving5g();
    }

    public final OSwitch getBatterySwitch() {
        return this.batterySwitch;
    }

    public final void setBatterySwitch(OSwitch r1) {
        this.batterySwitch = r1;
    }

    public final OSwitch getPowerSaverModeSwitch() {
        return this.powerSaverModeSwitch;
    }

    public final void setPowerSaverModeSwitch(OSwitch r1) {
        this.powerSaverModeSwitch = r1;
    }

    public final OSwitch getAutoEnablesSaverMode() {
        return this.autoEnablesSaverMode;
    }

    public final void setAutoEnablesSaverMode(OSwitch r1) {
        this.autoEnablesSaverMode = r1;
    }

    public final OSwitch getSmartPowerSaving5gSwitch() {
        return this.smartPowerSaving5gSwitch;
    }

    public final void setSmartPowerSaving5gSwitch(OSwitch r1) {
        this.smartPowerSaving5gSwitch = r1;
    }

    public final OSwitch getAutoSleepModeSwitch() {
        return this.autoSleepModeSwitch;
    }

    public final void setAutoSleepModeSwitch(OSwitch r1) {
        this.autoSleepModeSwitch = r1;
    }

    public final OSwitch getScreenPowerOptimizeSwitch() {
        return this.screenPowerOptimizeSwitch;
    }

    public final void setScreenPowerOptimizeSwitch(OSwitch r1) {
        this.screenPowerOptimizeSwitch = r1;
    }

    public final OSwitch getBatteryHealthAndChargingSwitch() {
        return this.batteryHealthAndChargingSwitch;
    }

    public final void setBatteryHealthAndChargingSwitch(OSwitch r1) {
        this.batteryHealthAndChargingSwitch = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.blockframework.framework.async.AsyncUIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.viewInit = false;
        initBatteryPercentage(r2);
        initPowerModeView(r2);
        initAutoPowerMode(r2);
        initSmartPowerSaving5g(r2);
        initScreenPowerOptimize(r2);
        initAutoSleepMode(r2);
        initBatteryHealthaAndCharging(r2);
        initAppNetControlItem(r2);
        this.viewInit = true;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        updateBatteryPercent();
        updatePowerModeView();
        updateAutoPowerMode();
        updateSmartPowerSaving5g();
        updateScreenPowerOptimize();
        updateAutoSleepMode();
        this.viewInit = true;
        OCardListItem r1 = this.powerSaverModeView;
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
        if (r2 == null) goto L9;
        ContentResolver r3 = r2.getContentResolver();
        if (r3 == null) goto L9;
        r3.registerContentObserver(Settings.Global.getUriFor("low_power"), true, this.mLowBatteryModeObserver);
    L9:
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.intent.action.AIRPLANE_MODE");
        r4.addAction("android.intent.action.SIM_STATE_CHANGED");
        OCardListItem r5 = this.smartPowerSaving5g;
        if (r5 == null) goto L14;
        Context r6 = r5.getContext();
        if (r6 == null) goto L14;
        r6.registerReceiver(this.mSimStateReceiver, r4);
    L14:
        OCardListItem r7 = this.smartPowerSaving5g;
        if (r7 == null) goto L21;
        Context r8 = r7.getContext();
        if (r8 == null) goto L21;
        ContentResolver r9 = r8.getContentResolver();
        if (r9 == null) goto L21;
        r9.registerContentObserver(Settings.Global.getUriFor(Constants.SMT_5G_STATUS_KEY), true, this.mSettingValueObserver);
    L21:
        OCardListItem r10 = this.smartPowerSaving5g;
        if (r10 == null) goto L28;
        Context r11 = r10.getContext();
        if (r11 == null) goto L28;
        ContentResolver r12 = r11.getContentResolver();
        if (r12 == null) goto L28;
        r12.registerContentObserver(Settings.Global.getUriFor(Constants.FIVEG_POWER_SAVER_ENABLED), true, this.mSettingValueObserver);
    L28:
        OCardListItem r13 = this.autoEnablesSaverModeSwitch;
        if (r13 == null) goto L36;
        Context r14 = r13.getContext();
        if (r14 == null) goto L37;
        ContentResolver r15 = r14.getContentResolver();
        if (r15 == null) goto L38;
        r15.registerContentObserver(Settings.Global.getUriFor("low_power_trigger_level"), true, this.mLowPowerModeTriggerLevelObserver);
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        this.viewInit = false;
        OCardListItem r0 = this.powerSaverModeView;
        if (r0 == null) goto L9;
        Context r1 = r0.getContext();
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L9;
        r2.unregisterContentObserver(this.mLowBatteryModeObserver);
    L9:
        OCardListItem r3 = this.smartPowerSaving5g;
        if (r3 == null) goto L14;
        Context r4 = r3.getContext();
        if (r4 == null) goto L14;
        r4.unregisterReceiver(this.mSimStateReceiver);
    L14:
        OCardListItem r5 = this.smartPowerSaving5g;
        if (r5 == null) goto L21;
        Context r6 = r5.getContext();
        if (r6 == null) goto L21;
        ContentResolver r7 = r6.getContentResolver();
        if (r7 == null) goto L21;
        r7.unregisterContentObserver(this.mSettingValueObserver);
    L21:
        OCardListItem r8 = this.autoEnablesSaverModeSwitch;
        if (r8 == null) goto L29;
        Context r9 = r8.getContext();
        if (r9 == null) goto L30;
        ContentResolver r10 = r9.getContentResolver();
        if (r10 == null) goto L31;
        r10.unregisterContentObserver(this.mLowPowerModeTriggerLevelObserver);
        return;
    L31:
        return;
    L30:
        return;
    }

    private final void initAppNetControlItem(final View r2) {
        OCardListItem r0 = (OCardListItem) r2.findViewById(R.id.app_network_control_settings);
        this.appNetControlItem = r0;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new AnonymousClass1(r2));
        return;
    }

    private final void initSmartPowerSaving5g(View r11) {
        OCardListItem r0 = (OCardListItem) r11.findViewById(R.id.smart_power_saving_5g);
        this.smartPowerSaving5g = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 0, false, 2, null);
    L5:
        Context r5 = r11.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "view.context");
        OSwitch r1 = new OSwitch(r5, null, 0, 6, null);
        this.smartPowerSaving5gSwitch = r1;
        OCardListItem r12 = this.smartPowerSaving5g;
        if (r12 == null) goto L8;
        r12.setCustomEndView(r1);
    L8:
        OCardListItem r13 = this.smartPowerSaving5g;
        if (r13 == null) goto L11;
        r13.showCustomEnd(true);
    L11:
        updateSmartPowerSaving5g();
        OCardListItem r14 = this.smartPowerSaving5g;
        if (r14 == null) goto L15;
        r14.setOnContentClickListener(new ViewOnClickListenerC03471(this));
        return;
    }

    private final void updateSmartPowerSaving5g() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.smartPowerSaving5g;
        ContentResolver r1 = null;
        if (r0 == null) goto L10;
        Context r2 = r0.getContext();
        if (r2 == null) goto L10;
        ContentResolver r3 = r2.getContentResolver();
    L11:
        boolean r4 = true;
        if (Settings.Global.getInt(r3, Constants.SMT_5G_STATUS_KEY, 1) != 1) goto L14;
        boolean r5 = true;
    L16:
        if (Utils.support5G() == false) goto L53;
        if (r5 == false) goto L53;
        OCardListItem r6 = this.smartPowerSaving5g;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        OCardListItem r7 = this.smartPowerSaving5g;
        if (r7 == null) goto L25;
        Context r8 = r7.getContext();
    L27:
        if (hasSimCard(r8) == false) goto L38;
        OCardListItem r9 = this.smartPowerSaving5g;
        if (r9 == null) goto L31;
        Context r10 = r9.getContext();
    L33:
        if (isAirPlaneModeOn(r10) == true) goto L38;
        OCardListItem r11 = this.smartPowerSaving5g;
        if (r11 == null) goto L41;
        r11.setEnabled(true);
    L41:
        OCardListItem r12 = this.smartPowerSaving5g;
        if (r12 == null) goto L46;
        Context r13 = r12.getContext();
        if (r13 == null) goto L46;
        r1 = r13.getContentResolver();
    L46:
        int r14 = Settings.Global.getInt(r1, Constants.FIVEG_POWER_SAVER_ENABLED, 1);
        OSwitch r15 = this.smartPowerSaving5gSwitch;
        if (r15 == null) goto L57;
        if (r14 == 1) goto L51;
        r4 = false;
    L51:
        r15.setChecked(r4);
        return;
    L57:
        return;
    L31:
        r10 = null;
    L38:
        OCardListItem r16 = this.smartPowerSaving5g;
        if (r16 == null) goto L41;
        r16.setEnabled(false);
        goto L41
    L25:
        r8 = null;
    L53:
        OCardListItem r17 = this.smartPowerSaving5g;
        if (r17 == null) goto L58;
        r17.setVisibility(8);
        return;
    L58:
        return;
    L14:
        r5 = false;
    L10:
        r3 = null;
        goto L11
    }

    private final boolean isAirPlaneModeOn(Context r2) {
        if (r2 != null) goto L13;
        ContentResolver r3 = null;
    L6:
        if (Settings.Global.getInt(r3, "airplane_mode_on") == 1) goto L10;
        return false;
    L10:
        return true;
    L11:
        Log.d("BatteryConfigBlock", " get air plane mode error");
        return false;
    L13:
        r3 = r2.getContentResolver();     // Catch: Settings.SettingNotFoundException -> L11
        goto L6
    }

    public final boolean hasSimCard(Context r2) {
        if (this.mTelephonyManager != null) goto L8;
        if (r2 == null) goto L6;
        Object r3 = r2.getSystemService("phone");
    L7:
        this.mTelephonyManager = (TelephonyManager) r3;
        goto L8
    L6:
        r3 = null;
    L8:
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L11;
        int r4 = r1.getSimState();
    L13:
        if (r4 == 1) goto L17;
        if (r4 == 0) goto L17;
        return true;
    L17:
        return false;
    L11:
        r4 = 0;
        goto L13
    }

    private final void updateScreenPowerOptimize() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.screenPowerOptimizeView;
        if (r0 == null) goto L10;
        Context r1 = r0.getContext();
        if (r1 == null) goto L10;
        ContentResolver r2 = r1.getContentResolver();
    L11:
        boolean r3 = true;
        int r4 = Settings.Global.getInt(r2, Constants.POWER_ACL_MODE_ENABLE, 1);
        if (r4 != 1) goto L14;
        boolean r5 = true;
    L15:
        OSwitch r6 = this.screenPowerOptimizeSwitch;
        if (r6 != null) goto L18;
    L19:
        OSwitch r7 = this.screenPowerOptimizeSwitch;
        if (r7 == null) goto L27;
        if (r4 == 1) goto L24;
        r3 = false;
    L24:
        r7.setChecked(r3);
        return;
    L27:
        return;
    L18:
        if (r5 != r6.isChecked()) goto L19;
        return;
    L14:
        r5 = false;
    L10:
        r2 = null;
        goto L11
    }

    private final void initScreenPowerOptimize(final View r8) {
        this.screenPowerOptimizeView = (OCardListItem) r8.findViewById(R.id.screen_power_optimize);
        View r0 = r8.findViewById(R.id.screen_power_optimize_tips);
        if ((r0 instanceof TextView) == true) goto L5;
        r0 = null;
    L5:
        this.screenPowerOptimizeTips = (TextView) r0;
        Context r2 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "view.context");
        OSwitch r1 = new OSwitch(r2, null, 0, 6, null);
        this.screenPowerOptimizeSwitch = r1;
        OCardListItem r3 = this.screenPowerOptimizeView;
        if (r3 == null) goto L8;
        r3.setCustomEndView(r1);
    L8:
        OCardListItem r4 = this.screenPowerOptimizeView;
        if (r4 == null) goto L11;
        r4.showCustomEnd(true);
    L11:
        updateScreenPowerOptimize();
        OCardListItem r5 = this.screenPowerOptimizeView;
        if (r5 == null) goto L15;
        r5.setOnContentClickListener(new ViewOnClickListenerC03461(this, r8));
    L15:
        if (MultiSdkAdapter.isBeforeP() == false) goto L17;
    L18:
        OCardListItem r9 = this.screenPowerOptimizeView;
        if (r9 == null) goto L21;
        r9.setVisibility(8);
    L21:
        TextView r7 = this.screenPowerOptimizeTips;
        if (r7 == null) goto L26;
        r7.setVisibility(8);
        return;
    L26:
        return;
    L17:
        if (Utils.isDeviceType(SmtDevice.DARWIN) == true) goto L18;
    }

    private final void initAutoSleepMode(final View r9) {
        OCardListItem r0 = (OCardListItem) r9.findViewById(R.id.auto_sleep_mode);
        this.autoSleepModeView = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 0, false, 2, null);
    L5:
        OCardListItem r1 = this.autoSleepModeView;
        if (r1 == null) goto L8;
        r1.setSubTitle(r9.getContext().getString(R.string.auto_sleep_mode_tip2));
    L8:
        OCardListItem r2 = this.autoSleepModeView;
        if (r2 == null) goto L11;
        r2.showSubTitle(true);
    L11:
        Context r3 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "view.context");
        OSwitch r4 = new OSwitch(r3, null, 0, 6, null);
        this.autoSleepModeSwitch = r4;
        OCardListItem r5 = this.autoSleepModeView;
        if (r5 == null) goto L14;
        r5.setCustomEndView(r4);
    L14:
        OCardListItem r6 = this.autoSleepModeView;
        if (r6 == null) goto L17;
        r6.showCustomEnd(true);
    L17:
        updateAutoSleepMode();
        OCardListItem r7 = this.autoSleepModeView;
        if (r7 == null) goto L21;
        r7.setOnContentClickListener(new ViewOnClickListenerC03431(this, r9));
        return;
    }

    private final void updateAutoSleepMode() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.autoSleepModeView;
        if (r0 == null) goto L10;
        Context r1 = r0.getContext();
        if (r1 == null) goto L10;
        ContentResolver r2 = r1.getContentResolver();
    L11:
        boolean r3 = true;
        if (Settings.Global.getInt(r2, Constants.POWER_SLEEP_MODE_ENABLE, 1) == 1) goto L15;
        r3 = false;
    L15:
        OSwitch r4 = this.autoSleepModeSwitch;
        if (r4 != null) goto L18;
    L19:
        OSwitch r5 = this.autoSleepModeSwitch;
        if (r5 == null) goto L24;
        r5.setChecked(r3);
        return;
    L24:
        return;
    L18:
        if (r4.isChecked() != r3) goto L19;
        return;
    L10:
        r2 = null;
        goto L11
    }

    private final void initBatteryHealthaAndCharging(View r4) {
        OCardListItem r5 = (OCardListItem) r4.findViewById(R.id.battery_health_and_charging);
        this.batteryHealthAndCharging = r5;
        if (r5 == null) goto L5;
        OCardListItem.setCardPosition$default(r5, 0, false, 2, null);
    L5:
        OCardListItem r6 = this.batteryHealthAndCharging;
        if (r6 == null) goto L8;
        r6.setDefaultTailIcon(0);
    L8:
        OCardListItem r7 = this.batteryHealthAndCharging;
        if (r7 == null) goto L11;
        r7.showTailIcon(true);
    L11:
        OCardListItem r8 = this.batteryHealthAndCharging;
        if (r8 == null) goto L15;
        r8.setOnContentClickListener(new ViewOnClickListenerC03441(this));
        return;
    }

    private final int getMLastConfirmedIndex() {
        return SecurityCenterApplication.getApplication().getSharedPreferences(SP_BATTERY_CONFIG, 0).getInt(SP_KEY_LAST_CONFIRMED_INDEX, 0);
    }

    private final void setMLastConfirmedIndex(int r3) {
        SharedPreferUtil.commitAsynchronously(SecurityCenterApplication.getApplication().getSharedPreferences(SP_BATTERY_CONFIG, 0).edit().putInt(SP_KEY_LAST_CONFIRMED_INDEX, r3));
    }

    public final int[] getLOW_POWER_MODE_TRIGER() {
        return this.LOW_POWER_MODE_TRIGER;
    }

    public final void setLOW_POWER_MODE_TRIGER(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.LOW_POWER_MODE_TRIGER = r2;
    }

    private final void showSingleChoiceDialog() {
        if (this.mSavePowerDialog != null) goto L21;
        OCardListItem r1 = this.autoEnablesSaverModeSwitch;
        if (r1 == null) goto L9;
        Context r2 = r1.getContext();
        if (r2 == null) goto L9;
        ContentResolver r3 = r2.getContentResolver();
    L10:
        int r4 = Settings.Global.getInt(r3, "low_power_trigger_level", 10);
        this.mChooseIndex = -1;
        OCardListItem r5 = this.autoEnablesSaverModeSwitch;
        if (r5 == null) goto L20;
        final Context r6 = r5.getContext();
        if (r6 != null) goto L16;
        return;
    L16:
        if (ArraysKt.indexOf(this.LOW_POWER_MODE_TRIGER, r4) != (-1)) goto L18;
        int r7 = getMLastConfirmedIndex();
    L19:
        String r8 = r6.getString(R.string.low_battery_auto_enable_title);
        Intrinsics.checkNotNullExpressionValue(r8, "ctx.getString(R.string.l…attery_auto_enable_title)");
        BatteryConfigBlock$showSingleChoiceDialog$modifier$1 r9 = new BatteryConfigBlock$showSingleChoiceDialog$modifier$1(this, r6, r7);
        String r10 = r6.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(r10, "ctx.getString(R.string.ok)");
        OBaseDialog.ButtonConfig r11 = new OBaseDialog.ButtonConfig(r10, new BatteryConfigBlock$showSingleChoiceDialog$modifier$2(this, r6), null, 4, null);
        String r15 = r6.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(r15, "ctx.getString(R.string.cancel)");
        OSelectionDialog r12 = new OSelectionDialog(r6, new OSelectionDialog.Modifier(r8, "", r9, r11, new OBaseDialog.ButtonConfig(r15, new BatteryConfigBlock$showSingleChoiceDialog$modifier$3(this), null, 4, null)));
        r12.setOnCancelListener(new BatteryConfigBlock$showSingleChoiceDialog$$inlined$apply$lambda$1(this));
        r12.setOnDismissListener(new BatteryConfigBlock$showSingleChoiceDialog$$inlined$apply$lambda$2(this));
        Unit r13 = Unit.INSTANCE;
        this.mSavePowerDialog = r12;
        goto L21
    L18:
        r7 = ArraysKt.indexOf(this.LOW_POWER_MODE_TRIGER, r4);
        goto L19
    L20:
        return;
    L9:
        r3 = null;
    L21:
        OSelectionDialog r14 = this.mSavePowerDialog;
        if (r14 != null) goto L24;
    L25:
        OSelectionDialog r0 = this.mSavePowerDialog;
        if (r0 == null) goto L31;
        r0.show();
        return;
    L31:
        return;
    L24:
        if (r14.isShowing() != true) goto L25;
    }

    private final void initAutoPowerMode(View r12) {
        OCardListItem r0 = (OCardListItem) r12.findViewById(R.id.auto_enable_saver_mode_switch);
        this.autoEnablesSaverModeSwitch = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 3, false, 2, null);
    L5:
        Context r6 = r12.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "view.context");
        OSwitch r1 = new OSwitch(r6, null, 0, 6, null);
        this.autoEnablesSaverMode = r1;
        OCardListItem r13 = this.autoEnablesSaverModeSwitch;
        if (r13 == null) goto L8;
        r13.setCustomEndView(r1);
    L8:
        OCardListItem r14 = this.autoEnablesSaverModeSwitch;
        if (r14 == null) goto L11;
        r14.showCustomEnd(true);
    L11:
        updateAutoPowerMode();
        OCardListItem r15 = this.autoEnablesSaverModeSwitch;
        if (r15 == null) goto L15;
        r15.setOnContentClickListener(new ViewOnClickListenerC03421(this));
        return;
    }

    private final void updateAutoPowerMode() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.autoEnablesSaverModeSwitch;
        if (r0 == null) goto L10;
        Context r1 = r0.getContext();
        if (r1 == null) goto L10;
        ContentResolver r2 = r1.getContentResolver();
    L11:
        boolean r3 = false;
        int r4 = Settings.Global.getInt(r2, "low_power_trigger_level", 0);
        OSwitch r5 = this.autoEnablesSaverMode;
        if (r5 == null) goto L14;
        r5.setOnCheckedChangeListener(null);
    L14:
        OSwitch r6 = this.autoEnablesSaverMode;
        if (r6 == null) goto L19;
        if (r4 == 0) goto L18;
        r3 = true;
    L18:
        r6.setChecked(r3);
    L19:
        OSwitch r7 = this.autoEnablesSaverMode;
        if (r7 == null) goto L22;
        r7.setOnCheckedChangeListener(this.autoPowerModeChangeListener);
    L22:
        updateAutoPowerModeSubtitle();
        return;
    L10:
        r2 = null;
        goto L11
    }

    private final void updateAutoPowerModeSubtitle() {
        OCardListItem r0 = this.autoEnablesSaverModeSwitch;
        String r1 = null;
        if (r0 == null) goto L7;
        Context r2 = r0.getContext();
        if (r2 == null) goto L7;
        ContentResolver r3 = r2.getContentResolver();
    L8:
        int r4 = Settings.Global.getInt(r3, "low_power_trigger_level", 0);
        if (r4 == 0) goto L20;
        OCardListItem r5 = this.autoEnablesSaverModeSwitch;
        if (r5 == null) goto L17;
        if (r5 == null) goto L16;
        Context r6 = r5.getContext();
        if (r6 == null) goto L16;
        r1 = r6.getString(R.string.low_battery_auto_enable_subtitle_value, new Object[]{"" + r4});
    L16:
        r5.setSubTitle(r1);
    L17:
        OCardListItem r8 = this.autoEnablesSaverModeSwitch;
        if (r8 == null) goto L24;
        r8.showSubTitle(true);
        return;
    L24:
        return;
    L20:
        OCardListItem r9 = this.autoEnablesSaverModeSwitch;
        if (r9 == null) goto L26;
        r9.showSubTitle(false);
        return;
    L26:
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final String getDrainTimeInSaverMode(boolean r5) {
        if (r5 == true) goto L5;
        return "";
    L5:
        long r0 = PowerAdvisorService.computePowerSavingModeBatteryTimeRemaining() / ((long) 1000000);
        if (r0 >= 60) goto L8;
        return "";
    L8:
        return SecurityCenterApplication.getApplication().getString(R.string.remaining) + BatteryPowerActivityViewModel.Companion.formatDurationForCharacters(r0);
    }

    private final void updatePowerModeView() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.powerSaverModeView;
        if (r0 == null) goto L8;
        Context r1 = r0.getContext();
    L9:
        boolean r2 = isPowerMode(r1);
        OSwitch r3 = this.powerSaverModeSwitch;
        if (r3 != null) goto L12;
    L13:
        OSwitch r4 = this.powerSaverModeSwitch;
        if (r4 == null) goto L16;
        r4.setChecked(r2);
    L16:
        OCardListItem r5 = this.powerSaverModeView;
        if (r5 == null) goto L19;
        r5.setCardType(0);
    L19:
        OCardListItem r6 = this.powerSaverModeView;
        if (r6 == null) goto L22;
        r6.setSubTitle(getDrainTimeInSaverMode(r2));
    L22:
        OCardListItem r7 = this.powerSaverModeView;
        if (r7 == null) goto L26;
        r7.showSubTitle(true);
        return;
    L26:
        return;
    L12:
        if (r3.isChecked() == r2) goto L16;
    L8:
        r1 = null;
        goto L9
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

    private final void initBatteryPercentage(final View r8) {
        Context r1 = r8.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "view.context");
        this.batterySwitch = new OSwitch(r1, null, 0, 6, null);
        OCardListItem r0 = (OCardListItem) r8.findViewById(R.id.power_usage_battery_percentage);
        this.batteryPercentage = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 1, false, 2, null);
    L5:
        OCardListItem r2 = this.batteryPercentage;
        if (r2 == null) goto L8;
        r2.setCustomEndView(this.batterySwitch);
    L8:
        OCardListItem r3 = this.batteryPercentage;
        if (r3 == null) goto L11;
        r3.showCustomEnd(true);
    L11:
        updateBatteryPercent();
        OCardListItem r4 = this.batteryPercentage;
        if (r4 == null) goto L15;
        r4.setOnContentClickListener(new ViewOnClickListenerC03451(this, r8));
        return;
    }

    private final void initPowerModeView(View r9) {
        OCardListItem r0 = (OCardListItem) r9.findViewById(R.id.power_saver_mode);
        this.powerSaverModeView = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 2, false, 2, null);
    L5:
        OCardListItem r1 = this.powerSaverModeView;
        if (r1 == null) goto L8;
        r1.setTitle(r9.getContext().getString(R.string.power_usage_save_mode));
    L8:
        OCardListItem r2 = this.powerSaverModeView;
        if (r2 == null) goto L11;
        r2.showTitle(true);
    L11:
        Context r3 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "view.context");
        OSwitch r4 = new OSwitch(r3, null, 0, 6, null);
        this.powerSaverModeSwitch = r4;
        OCardListItem r5 = this.powerSaverModeView;
        if (r5 == null) goto L14;
        r5.setCustomEndView(r4);
    L14:
        OCardListItem r6 = this.powerSaverModeView;
        if (r6 == null) goto L17;
        r6.showCustomEnd(true);
    L17:
        updatePowerModeView();
        Object r10 = r9.getContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r10 == null) goto L24;
        this.mPowerManager = (PowerManager) r10;
        OCardListItem r11 = this.powerSaverModeView;
        if (r11 == null) goto L25;
        r11.setOnContentClickListener(this.mLowBatteryModeChangeListener);
        return;
    L25:
        return;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
    }

    private final void updateBatteryPercent() {
        if (this.viewInit == false) goto L5;
        return;
    L5:
        OCardListItem r0 = this.batteryPercentage;
        if (r0 == null) goto L10;
        Context r1 = r0.getContext();
        if (r1 == null) goto L10;
        ContentResolver r2 = r1.getContentResolver();
    L11:
        boolean r3 = true;
        int r4 = Settings.System.getInt(r2, "status_bar_show_battery_percent", 1);
        OSwitch r5 = this.batterySwitch;
        if (r5 == null) goto L18;
        if (r4 == 1) goto L16;
        r3 = false;
    L16:
        r5.setChecked(r3);
        return;
    L18:
        return;
    L10:
        r2 = null;
        goto L11
    }
}
