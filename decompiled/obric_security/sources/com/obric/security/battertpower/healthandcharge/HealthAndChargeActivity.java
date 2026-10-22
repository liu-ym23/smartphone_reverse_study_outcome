package com.obric.security.battertpower.healthandcharge;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.utils.Constants;
import com.obric.matrix.platform.sdk.ones.producttype.ProductTypeUtils;
import com.obric.olog.OLog;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.alert.OViewStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthAndChargeActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 S2\u00020\u0001:\u0001SB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020AJ\b\u0010\u0017\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020DJ\b\u0010F\u001a\u00020DH\u0002J\u0012\u0010G\u001a\u00020D2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020DH\u0014J\b\u0010K\u001a\u00020DH\u0014J\b\u0010L\u001a\u00020DH\u0014J\b\u0010M\u001a\u00020BH\u0016J\u0010\u0010N\u001a\u00020D2\u0006\u0010O\u001a\u00020\fH\u0002J\b\u0010P\u001a\u00020DH\u0002J\b\u0010Q\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001b\u00106\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u001c\u0010;\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001aR\u000e\u0010>\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/obric/security/battertpower/healthandcharge/HealthAndChargeActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "batteryCapacity", "Lcom/obric/oui/lisitem/OCardListItem;", "getBatteryCapacity", "()Lcom/obric/oui/lisitem/OCardListItem;", "setBatteryCapacity", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "batteryInfoReceiver", "Landroid/content/BroadcastReceiver;", HealthAndChargeActivity.BATTERY_PERCENTAGE, "", "getBatteryPct", "()I", "setBatteryPct", "(I)V", HealthAndChargeActivity.BATTERY_TEMPERATURE, "getBatteryTemperature", "setBatteryTemperature", "bypassCharging", "capacityVaule", "Lcom/obric/oui/text/OTextView;", "getCapacityVaule", "()Lcom/obric/oui/text/OTextView;", "setCapacityVaule", "(Lcom/obric/oui/text/OTextView;)V", "handlerCallback", "Landroid/os/Handler$Callback;", "isUserClick", "", "mainHandler", "Landroid/os/Handler;", "placeholderWirelessChargeView", "Landroid/view/View;", "reverseWirelessCharge", "reverseWirelessChargeSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "scrollView", "Lcom/obric/oui/bouncelayout/OScrollView;", "getScrollView", "()Lcom/obric/oui/bouncelayout/OScrollView;", "setScrollView", "(Lcom/obric/oui/bouncelayout/OScrollView;)V", "smartChargingModeEnabled", "getSmartChargingModeEnabled", "setSmartChargingModeEnabled", "smartChargingModeEnabledObserver", "Landroid/database/ContentObserver;", "smartChargingModeEnabledSwitch", "getSmartChargingModeEnabledSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "setSmartChargingModeEnabledSwitch", "(Lcom/obric/oui/oswitch/OSwitch;)V", "supportsReverseWirelessCharging", "getSupportsReverseWirelessCharging", "()Z", "supportsReverseWirelessCharging$delegate", "Lkotlin/Lazy;", "temperatureVaule", "getTemperatureVaule", "setTemperatureVaule", "wirelessChargingObserver", "getBatteryLevel", "batteryChangedIntent", "Landroid/content/Intent;", "", "initBypassCharging", "", "initReverseWirelessChargeSwitch", "initSmartChargingModeEnabledSwitch", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "scene", "setReverseWirelessChargeStatus", "batteryLevel", "showGuideDialog", "updateReverseWirelessChargeSwitch", "updateSmartChargingModeEnabledSwitch", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthAndChargeActivity extends BaseActivity {
    public static final String BATTERY_PERCENTAGE = "batteryPct";
    public static final int BATTERY_PROPERTY_SOH = 13;
    public static final String BATTERY_TEMPERATURE = "batteryTemperature";
    public static final Companion Companion = null;
    public static final int MSG_BATTERY_STATUS_CHANGE = 100;
    public static final long MSG_BATTERY_STATUS_CHANGE_DELAY = 200;
    private HashMap _$_findViewCache;
    private OCardListItem batteryCapacity;
    private final BroadcastReceiver batteryInfoReceiver;
    private int batteryPct;
    private OCardListItem batteryTemperature;
    private OCardListItem bypassCharging;
    private OTextView capacityVaule;
    private final Handler.Callback handlerCallback;
    private boolean isUserClick;
    private Handler mainHandler;
    private View placeholderWirelessChargeView;
    private OCardListItem reverseWirelessCharge;
    private OSwitch reverseWirelessChargeSwitch;
    private OScrollView scrollView;
    private OCardListItem smartChargingModeEnabled;
    private final ContentObserver smartChargingModeEnabledObserver;
    private OSwitch smartChargingModeEnabledSwitch;
    private final Lazy supportsReverseWirelessCharging$delegate;
    private OTextView temperatureVaule;
    private final ContentObserver wirelessChargingObserver;

    /* JADX INFO: compiled from: HealthAndChargeActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/security/battertpower/healthandcharge/HealthAndChargeActivity$Companion;", "", "()V", "BATTERY_PERCENTAGE", "", "BATTERY_PROPERTY_SOH", "", "BATTERY_TEMPERATURE", "MSG_BATTERY_STATUS_CHANGE", "MSG_BATTERY_STATUS_CHANGE_DELAY", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    private final boolean getSupportsReverseWirelessCharging() {
        return ((Boolean) this.supportsReverseWirelessCharging$delegate.getValue()).booleanValue();
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

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "battery_health_charge_page";
    }

    public HealthAndChargeActivity() {
        this.isUserClick = true;
        this.supportsReverseWirelessCharging$delegate = LazyKt.lazy(new HealthAndChargeActivity$supportsReverseWirelessCharging$2(this));
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.wirelessChargingObserver = new HealthAndChargeActivity$wirelessChargingObserver$1(this, r1);
        final Handler r2 = new Handler(Looper.getMainLooper());
        this.smartChargingModeEnabledObserver = new HealthAndChargeActivity$smartChargingModeEnabledObserver$1(this, r2);
        this.batteryInfoReceiver = new HealthAndChargeActivity$batteryInfoReceiver$1(this);
        this.handlerCallback = new HealthAndChargeActivity$handlerCallback$1(this);
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(HealthAndChargeActivity r0) {
        return r0.mainHandler;
    }

    public static final /* synthetic */ View access$getPlaceholderWirelessChargeView$p(HealthAndChargeActivity r0) {
        return r0.placeholderWirelessChargeView;
    }

    public static final /* synthetic */ OCardListItem access$getReverseWirelessCharge$p(HealthAndChargeActivity r0) {
        return r0.reverseWirelessCharge;
    }

    public static final /* synthetic */ OSwitch access$getReverseWirelessChargeSwitch$p(HealthAndChargeActivity r0) {
        return r0.reverseWirelessChargeSwitch;
    }

    public static final /* synthetic */ boolean access$isUserClick$p(HealthAndChargeActivity r0) {
        return r0.isUserClick;
    }

    public static final /* synthetic */ void access$setMainHandler$p(HealthAndChargeActivity r0, Handler r1) {
        r0.mainHandler = r1;
    }

    public static final /* synthetic */ void access$setPlaceholderWirelessChargeView$p(HealthAndChargeActivity r0, View r1) {
        r0.placeholderWirelessChargeView = r1;
    }

    public static final /* synthetic */ void access$setReverseWirelessCharge$p(HealthAndChargeActivity r0, OCardListItem r1) {
        r0.reverseWirelessCharge = r1;
    }

    public static final /* synthetic */ void access$setReverseWirelessChargeSwitch$p(HealthAndChargeActivity r0, OSwitch r1) {
        r0.reverseWirelessChargeSwitch = r1;
    }

    public static final /* synthetic */ void access$setUserClick$p(HealthAndChargeActivity r0, boolean r1) {
        r0.isUserClick = r1;
    }

    public static final /* synthetic */ void access$showGuideDialog(HealthAndChargeActivity r0) {
        r0.showGuideDialog();
    }

    public static final /* synthetic */ void access$updateReverseWirelessChargeSwitch(HealthAndChargeActivity r0) {
        r0.updateReverseWirelessChargeSwitch();
    }

    public static final /* synthetic */ void access$updateSmartChargingModeEnabledSwitch(HealthAndChargeActivity r0) {
        r0.updateSmartChargingModeEnabledSwitch();
    }

    public final int getBatteryPct() {
        return this.batteryPct;
    }

    public final void setBatteryPct(int r1) {
        this.batteryPct = r1;
    }

    public final OCardListItem getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public final void setBatteryCapacity(OCardListItem r1) {
        this.batteryCapacity = r1;
    }

    public final OCardListItem getSmartChargingModeEnabled() {
        return this.smartChargingModeEnabled;
    }

    public final void setSmartChargingModeEnabled(OCardListItem r1) {
        this.smartChargingModeEnabled = r1;
    }

    public final OCardListItem getBatteryTemperature() {
        return this.batteryTemperature;
    }

    public final void setBatteryTemperature(OCardListItem r1) {
        this.batteryTemperature = r1;
    }

    public final OSwitch getSmartChargingModeEnabledSwitch() {
        return this.smartChargingModeEnabledSwitch;
    }

    public final void setSmartChargingModeEnabledSwitch(OSwitch r1) {
        this.smartChargingModeEnabledSwitch = r1;
    }

    public final OScrollView getScrollView() {
        return this.scrollView;
    }

    public final void setScrollView(OScrollView r1) {
        this.scrollView = r1;
    }

    /* JADX INFO: renamed from: getCapacityVaule, reason: collision with other method in class */
    public final OTextView m603getCapacityVaule() {
        return this.capacityVaule;
    }

    public final void setCapacityVaule(OTextView r1) {
        this.capacityVaule = r1;
    }

    public final OTextView getTemperatureVaule() {
        return this.temperatureVaule;
    }

    public final void setTemperatureVaule(OTextView r1) {
        this.temperatureVaule = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R.layout.battery_health_and_charge);
        this.batteryCapacity = (OCardListItem) findViewById(R.id.battery_capacity);
        this.smartChargingModeEnabled = (OCardListItem) findViewById(R.id.smart_charging_mode_enabled);
        this.scrollView = (OScrollView) findViewById(R.id.main_view);
        initTitleBar(false, false);
        this.mainHandler = new Handler(Looper.getMainLooper(), this.handlerCallback);
        HealthAndChargeActivity r1 = this;
        this.smartChargingModeEnabledSwitch = new OSwitch(r1, null, 0, 6, null);
        OCardListItem r0 = (OCardListItem) findViewById(R.id.battery_temperature);
        this.batteryTemperature = r0;
        if (r0 == null) goto L5;
        OCardListItem.setCardPosition$default(r0, 2, false, 2, null);
    L5:
        this.capacityVaule = (OTextView) LayoutInflater.from(r1).inflate(R.layout.battery_capacity_value, null, false);
        OCardListItem r2 = this.batteryCapacity;
        if (r2 == null) goto L8;
        OCardListItem.setEndDetailText$default(r2, "0%", 0, 2, null);
    L8:
        OCardListItem r3 = this.batteryCapacity;
        if (r3 == null) goto L11;
        r3.showCustomEnd(true);
    L11:
        this.temperatureVaule = (OTextView) LayoutInflater.from(r1).inflate(R.layout.battery_capacity_value, null, false);
        OCardListItem r4 = this.batteryTemperature;
        if (r4 == null) goto L14;
        OCardListItem.setEndDetailText$default(r4, "0℃", 0, 2, null);
    L14:
        OCardListItem r5 = this.batteryTemperature;
        if (r5 == null) goto L17;
        r5.showCustomEnd(true);
    L17:
        OCardListItem r6 = this.batteryCapacity;
        if (r6 == null) goto L20;
        r6.showSubTitle(true);
    L20:
        OCardListItem r7 = this.batteryCapacity;
        if (r7 == null) goto L23;
        OCardListItem.setCardPosition$default(r7, 1, false, 2, null);
    L23:
        initSmartChargingModeEnabledSwitch();
        initReverseWirelessChargeSwitch();
        initBypassCharging();
        if (getSupportsReverseWirelessCharging() == false) goto L27;
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.WIRELESS_CHARGING), true, this.wirelessChargingObserver);
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        updateSmartChargingModeEnabledSwitch();
        updateReverseWirelessChargeSwitch();
        registerReceiver(this.batteryInfoReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        OCardListItem r0 = this.batteryCapacity;
        if (r0 == null) goto L5;
        OCardListItem.setEndDetailText$default(r0, getCapacityVaule(), 0, 2, null);
    L5:
        getContentResolver().registerContentObserver(Settings.System.getUriFor(Constants.SMART_CHARGING_MODE_ENABLED), true, this.smartChargingModeEnabledObserver);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.batteryInfoReceiver);
        getContentResolver().unregisterContentObserver(this.smartChargingModeEnabledObserver);
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Handler r0 = this.mainHandler;
        if (r0 == null) goto L6;
        r0.removeCallbacksAndMessages(null);
    L6:
        if (getSupportsReverseWirelessCharging() == false) goto L9;
        getContentResolver().unregisterContentObserver(this.wirelessChargingObserver);
        return;
    }

    private final String getCapacityVaule() {
        BatteryManager r6 = (BatteryManager) getSystemService(BatteryManager.class);
        if (r6 == null) goto L5;
        Long r7 = Long.valueOf(r6.getLongProperty(13));
    L6:
        OLog.d("HealthAndChargeActivity", "getCapacityVaule: " + r7);
        if (r7 != null) goto L10;
        r7 = 100L;
    L10:
        if (r7.longValue() <= 100) goto L12;
    L13:
        r7 = 100L;
    L14:
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "battery_health_display_show", MapsKt.mapOf(TuplesKt.to("battery_health_percent", r7)), false, 4, null);
        return "" + r7 + "%";
    L12:
        if (r7.longValue() >= 0) goto L14;
    L5:
        r7 = null;
        goto L6
    }

    private final void setReverseWirelessChargeStatus(int r3) {
        OCardListItem r0 = this.reverseWirelessCharge;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r3 >= 10000) goto L15;
        View r4 = this.placeholderWirelessChargeView;
        if (r4 != null) goto L13;
        if (r0 == null) goto L19;
        View r5 = r0.getCustomEndView();
        if (r5 == null) goto L20;
        r5.post(new RunnableC03521(this));
        return;
    L20:
        return;
    L19:
        return;
    L13:
        if (r4 == null) goto L22;
        r4.setVisibility(0);
        return;
    L22:
        return;
    L15:
        View r2 = this.placeholderWirelessChargeView;
        if (r2 == null) goto L24;
        r2.setVisibility(8);
        return;
    }

    public final int getBatteryLevel(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "batteryChangedIntent");
        int r2 = r3.getIntExtra("level", 0);
        int r4 = r2 * 100;
        return r4 / r3.getIntExtra("scale", 100);
    }

    private final void initSmartChargingModeEnabledSwitch() {
        OCardListItem r0 = this.smartChargingModeEnabled;
        if (r0 == null) goto L5;
        OCardListItemExtKt.setEndView(r0, this.smartChargingModeEnabledSwitch);
    L5:
        OCardListItem r1 = this.smartChargingModeEnabled;
        if (r1 != null) goto L8;
    L12:
        OCardListItem r2 = this.smartChargingModeEnabled;
        if (r2 == null) goto L15;
        r2.showSubTitle(true);
    L15:
        OCardListItem r3 = this.smartChargingModeEnabled;
        if (r3 == null) goto L19;
        r3.setOnContentClickListener(new ViewOnClickListenerC03511(this));
        return;
    L19:
        return;
    L8:
        if (getSupportsReverseWirelessCharging() == false) goto L10;
        int r4 = 2;
    L11:
        OCardListItem.setCardPosition$default(r1, r4, false, 2, null);
        goto L12
    L10:
        r4 = 3;
        goto L11
    }

    public final void initReverseWirelessChargeSwitch() {
        View r0 = findViewById(R.id.reverse_wireless_charging);
        if (r0 == null) goto L21;
        this.reverseWirelessCharge = (OCardListItem) r0;
        if (getSupportsReverseWirelessCharging() == true) goto L10;
        OCardListItem r7 = this.reverseWirelessCharge;
        if (r7 == null) goto L22;
        r7.setVisibility(8);
        return;
    L22:
        return;
    L10:
        OSwitch r1 = new OSwitch(this, null, 0, 6, null);
        this.reverseWirelessChargeSwitch = r1;
        r1.setEnabled(true);
        OCardListItem r2 = this.reverseWirelessCharge;
        if (r2 == null) goto L13;
        OCardListItem.setCardPosition$default(r2, 3, false, 2, null);
    L13:
        OSwitch r3 = this.reverseWirelessChargeSwitch;
        if (r3 == null) goto L16;
        r3.setOnTouchListener(new AnonymousClass1(this));
    L16:
        OCardListItemExtKt.setEndView(this.reverseWirelessCharge, this.reverseWirelessChargeSwitch);
        OCardListItem r8 = this.reverseWirelessCharge;
        if (r8 == null) goto L23;
        r8.showSubTitle(true);
        return;
    L23:
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
    }

    private final void initBypassCharging() {
        if (ProductTypeUtils.INSTANCE.isNerida() == true) goto L5;
        return;
    L5:
        View r0 = findViewById(R.id.bypass_charging);
        if (r0 == null) goto L12;
        OCardListItem r1 = (OCardListItem) r0;
        this.bypassCharging = r1;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
        r1.setDefaultTailIcon(0);
        r1.showTailIcon(true);
        r1.showSubTitle(true);
        r1.setOnContentClickListener(new HealthAndChargeActivity$initBypassCharging$$inlined$run$lambda$1(this));
        return;
    L13:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
    }

    private final void updateSmartChargingModeEnabledSwitch() {
        boolean r2 = false;
        int r0 = Settings.System.getInt(getContentResolver(), Constants.SMART_CHARGING_MODE_ENABLED, 0);
        OSwitch r1 = this.smartChargingModeEnabledSwitch;
        if (r1 == null) goto L9;
        boolean r3 = r1.isChecked();
        if (r0 != 1) goto L7;
        boolean r4 = true;
    L8:
        if (r3 != r4) goto L9;
        return;
    L7:
        r4 = false;
    L9:
        OSwitch r5 = this.smartChargingModeEnabledSwitch;
        if (r5 == null) goto L16;
        if (r0 != 1) goto L13;
        r2 = true;
    L13:
        r5.setChecked(r2);
        return;
    }

    private final void updateReverseWirelessChargeSwitch() {
        OSwitch r0 = this.reverseWirelessChargeSwitch;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        this.isUserClick = true;
        int r2 = Settings.System.getInt(getContentResolver(), Constants.WIRELESS_CHARGING, 0);
        Intrinsics.checkNotNull(r0);
        boolean r3 = r0.isChecked();
        if (r2 != 1) goto L8;
        boolean r5 = true;
    L9:
        if (r3 == r5) goto L16;
        this.isUserClick = false;
        if (r2 == 1) goto L14;
        r1 = false;
    L14:
        r0.setChecked(r1);
        return;
    L16:
        return;
    L8:
        r5 = false;
        goto L9
    }

    private final void showGuideDialog() {
        final HealthAndChargeActivity r4 = this;
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(r4);
        r0.autoDismiss(false).title(R.string.reverse_wireless_charging).message(R.string.reverse_wireless_charging_message).negativeButton(R.string.ok2, C03531.INSTANCE).body(new OViewStyleController(new AnonymousClass2(r4)));
        r0.show();
    }
}
