package com.bytedanceos.powerusage;

import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class LowBatteryActivity extends BaseActivity {
    private static int[] LOW_POWER_MODE_TRIGER = null;
    private static final String ON_HAND_IN_HAND_KEY = "on_hand_in_hand";
    TextView mAutoTipsView;
    private int mChooseIndex;
    private ContentObserver mHandInHandObserver;
    private Handler mHandler;
    boolean mIsLowBatteryMode;
    private int mLastChooseIndex;
    private CompoundButton.OnCheckedChangeListener mLowBatteryAutoChangeListener;
    private CompoundButton.OnCheckedChangeListener mLowBatteryModeChangeListener;
    private ContentObserver mLowBatteryModeObserver;
    OListItemSwitch mLowerBatteryAuto;
    OListItemSwitch mLowerBatteryMode;
    PowerManager mPowerManager;
    private OInsetSheet mSavePowerDialog;

    /* JADX INFO: renamed from: com.bytedanceos.powerusage.LowBatteryActivity$1, reason: invalid class name */
    class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ LowBatteryActivity this$0;

        AnonymousClass1(final LowBatteryActivity this$0) {
            this.this$0 = this$0;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
            LowBatteryActivity.access$000(this.this$0).postDelayed(new RunnableC00251(this, isChecked), 100);
        }
    }

    public LowBatteryActivity() {
        this.mHandler = new Handler();
        this.mLowBatteryModeChangeListener = new AnonymousClass1(this);
        this.mLowBatteryAutoChangeListener = new AnonymousClass2(this);
        final Handler r1 = new Handler();
        this.mHandInHandObserver = new AnonymousClass8(this, r1);
        final Handler r2 = new Handler();
        this.mLowBatteryModeObserver = new AnonymousClass9(this, r2);
    }

    static /* synthetic */ Handler access$000(LowBatteryActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$100(LowBatteryActivity r0) {
        r0.showSingleChoiceDialog();
    }

    static /* synthetic */ int access$200(LowBatteryActivity r0) {
        return r0.mChooseIndex;
    }

    static /* synthetic */ int access$202(LowBatteryActivity r0, int r1) {
        r0.mChooseIndex = r1;
        return r1;
    }

    static /* synthetic */ OInsetSheet access$300(LowBatteryActivity r0) {
        return r0.mSavePowerDialog;
    }

    static /* synthetic */ OInsetSheet access$302(LowBatteryActivity r0, OInsetSheet r1) {
        r0.mSavePowerDialog = r1;
        return r1;
    }

    static /* synthetic */ int access$400(LowBatteryActivity r0) {
        return r0.mLastChooseIndex;
    }

    static /* synthetic */ int[] access$500() {
        return LOW_POWER_MODE_TRIGER;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$600(LowBatteryActivity r0) {
        return r0.mLowBatteryAutoChangeListener;
    }

    static /* synthetic */ void access$700(LowBatteryActivity r0) {
        r0.initLowBatteryEnable();
    }

    static /* synthetic */ void access$800(LowBatteryActivity r0) {
        r0.setChecked();
    }

    static {
        LOW_POWER_MODE_TRIGER = new int[]{10, 20, 30, 40, 50};
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.low_battery_activity);
        this.mAutoTipsView = (TextView) findViewById(R.id.auto_enable_switch_tips);
        OListItemSwitch r0 = (OListItemSwitch) findViewById(R.id.low_battery_mode_switch);
        this.mLowerBatteryMode = r0;
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(this.mLowBatteryModeChangeListener);
    L5:
        OListItemSwitch r1 = (OListItemSwitch) findViewById(R.id.auto_enable_switch);
        this.mLowerBatteryAuto = r1;
        if (r1 == null) goto L9;
        r1.setOnCheckedChangeListener(this.mLowBatteryAutoChangeListener);
    L9:
        if (MultiSdkAdapter.isBeforeP() == false) goto L16;
        resetLowPowerModeTriggerLevel();
        OListItemSwitch r2 = this.mLowerBatteryAuto;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        View r3 = findViewById(R.id.auto_enable_switch_tips);
        if (r3 == null) goto L16;
        r3.setVisibility(8);
    L16:
        this.mPowerManager = (PowerManager) getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        initTitleBar(false);
        updateViewWidth(R.id.ll_container);
    }

    private void resetLowPowerModeTriggerLevel() {
        if (Settings.Global.getInt(getContentResolver(), "low_power_trigger_level", 0) <= 0) goto L6;
        Settings.Global.putInt(getContentResolver(), "low_power_trigger_level", 0);
        return;
    }

    private void showSingleChoiceDialog() {
        if (this.mSavePowerDialog != null) goto L26;
        int r0 = Settings.Global.getInt(getContentResolver(), "low_power_trigger_level", 10);
        this.mLastChooseIndex = -1;
        this.mChooseIndex = -1;
        int[] r2 = LOW_POWER_MODE_TRIGER;
        int r3 = r2.length;
        int r5 = 0;
    L5:
        boolean r6 = true;
        if (r5 >= r3) goto L11;
        if (r2[r5] == r0) goto L9;
        this.mLastChooseIndex++;
        r5 = r5 + 1;
        goto L5
    L9:
        r6 = false;
    L11:
        if (r6 == false) goto L13;
        this.mLastChooseIndex = -1;
    L13:
        OInsetSheet r1 = new OInsetSheet(this);
        this.mSavePowerDialog = r1;
        r1.setRootWidth(OInsetSheet.PanelWidth.BOARD_WIDTH);
        OInsetSheetTitleBar r4 = new OInsetSheetTitleBar(this);
        r4.setTitleText(getString(R.string.low_battery_auto_enable_title));
        r4.setShowLeftBack(false);
        OButton r7 = r4.createNeutralButton(this, r4.mLeftContainer);
        r7.setButtonSourceBitmap(R.drawable.o_ic_close);
        r7.setOnClickListener(new AnonymousClass3(this));
        OButton r8 = r4.createPrimaryLightButton(this, r4.mRightContainer);
        r8.setButtonSourceBitmap(R.drawable.o_ic_confirm);
        r8.setOnClickListener(new AnonymousClass4(this));
        this.mSavePowerDialog.setHeaderView(r4);
        View r9 = LayoutInflater.from(this).inflate(R.layout.low_battery_menu_items, null);
        final LinearLayout r10 = (LinearLayout) r9.findViewById(R.id.page_container);
        View.OnClickListener r11 = new AnonymousClass5(this, r10);
        int r12 = this.mLastChooseIndex;
        if (r12 != (-1)) goto L16;
        r12 = 0;
    L16:
        int r13 = 0;
    L18:
        if (r13 >= r10.getChildCount()) goto L24;
        OListItemGeneral r14 = (OListItemGeneral) r10.getChildAt(r13);
        r14.setTag(Integer.valueOf(r13));
        r14.setOnClickListener(r11);
        if (r12 != r13) goto L22;
        r14.getMTrailingElement().setVisibility(0);
        r14.setTrailingImage(getDrawable(R.drawable.o_ic_confirm));
    L23:
        r13 = r13 + 1;
        goto L18
    L22:
        r14.getMTrailingElement().setVisibility(4);
        goto L23
    L24:
        this.mSavePowerDialog.setContainerView(r9);
        this.mSavePowerDialog.setOnCancelListener(new AnonymousClass6(this));
        this.mSavePowerDialog.setOnDismissListener(new AnonymousClass7(this));
    L26:
        if (this.mSavePowerDialog.isShowing() == true) goto L34;
        this.mSavePowerDialog.show();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsLowBatteryMode = isLowBatteryMode(this);
        int r0 = Settings.Global.getInt(getContentResolver(), "low_power_trigger_level", 0);
        this.mLowerBatteryAuto.setOnCheckedChangeListener(null);
        OListItemSwitch r1 = this.mLowerBatteryAuto;
        if (r0 == 0) goto L5;
        boolean r4 = true;
    L6:
        r1.setChecked(r4);
        if (r0 == 0) goto L9;
        this.mAutoTipsView.setText(getResources().getString(R.string.low_battery_auto_enable_tips_value, new Object[]{Integer.valueOf(r0)}));
    L10:
        this.mLowerBatteryAuto.setOnCheckedChangeListener(this.mLowBatteryAutoChangeListener);
        setChecked();
        getContentResolver().registerContentObserver(Settings.System.getUriFor(ON_HAND_IN_HAND_KEY), true, this.mHandInHandObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power"), true, this.mLowBatteryModeObserver);
        initLowBatteryEnable();
        return;
    L9:
        this.mAutoTipsView.setText(R.string.low_battery_auto_enable_tips);
        goto L10
    L5:
        r4 = false;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(this.mHandInHandObserver);
        getContentResolver().unregisterContentObserver(this.mLowBatteryModeObserver);
    }

    public boolean isHandInHand() {
        int r3 = Settings.System.getInt(getContentResolver(), ON_HAND_IN_HAND_KEY, 0);
        if (r3 == 1) goto L9;
        if (r3 == 2) goto L9;
        if (r3 == 101) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean isLowBatteryMode(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "low_power", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void initLowBatteryEnable() {
        if (isHandInHand() == false) goto L5;
        this.mLowerBatteryMode.setEnabled(false);
        this.mLowerBatteryAuto.setEnabled(false);
        return;
    L5:
        this.mLowerBatteryMode.setEnabled(true);
        this.mLowerBatteryAuto.setEnabled(true);
    }

    private void setChecked() {
        this.mLowerBatteryMode.setOnCheckedChangeListener(null);
        this.mLowerBatteryMode.setChecked(this.mIsLowBatteryMode);
        this.mLowerBatteryMode.setOnCheckedChangeListener(this.mLowBatteryModeChangeListener);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
