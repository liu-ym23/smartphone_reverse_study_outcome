package com.bytedanceos.datausage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.utils.Constants;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.AlertDialogButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.popover.v2.OPopoverHelperEx;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageLimitActivity extends BaseActivity implements View.OnClickListener {
    public static final String ACTION_DATA_USAGE_LIMIT_CHANGED = "com.bytedanceos.action.DATA_USAGE_LIMIT_CHANGED";
    private static final String DATA_USAGE_LIMIT_SUB2 = "data_usage_limit_sub2";
    private static final long MAX_GB = 8589934591L;
    private static final long MAX_MB = 8796093022207L;
    public static final int UNIT_GB = 1;
    public static final int UNIT_MB = 0;
    private long mCurrentBytes;
    private int mCurrentSub;
    private int mCurrentUnitType;
    private OInputLayout mEditText;
    private OAlertDialog mExitConfirmDialog;
    private boolean mIgnoreSwitchPersist;
    private boolean mInitialLimitEnabled;
    private int mInitialUnitType;
    private OCardListItem mLimitItem;
    private boolean mSkipExitConfirm;
    private OCardListItem mSwitchDisconnect;

    class InputFilterMinMax implements InputFilter {
        private long max;
        private long min;
        final /* synthetic */ DataUsageLimitActivity this$0;

        private boolean isInRange(long min, long max, long input) {
            if (max <= min) goto L10;
            if (input < min) goto L15;
            if (input > max) goto L15;
            return true;
        L15:
            return false;
        L10:
            if (input < max) goto L15;
            if (input > min) goto L15;
            return true;
        }

        public InputFilterMinMax(final DataUsageLimitActivity this$0, long min, long type) {
            this.this$0 = this$0;
            this.min = min;
            if (type != 0) goto L5;
            long r1 = DataUsageLimitActivity.MAX_MB;
        L6:
            this.max = r1;
            return;
        L5:
            r1 = DataUsageLimitActivity.MAX_GB;
            goto L6
        }

        public void updateMax(long newMaxValue) {
            if (this.max == newMaxValue) goto L6;
            this.max = newMaxValue;
            return;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            char[] r9 = dest.toString().toCharArray();     // Catch: NumberFormatException -> L16
            StringBuilder r10 = new StringBuilder();     // Catch: NumberFormatException -> L16
            StringBuilder r11 = new StringBuilder();     // Catch: NumberFormatException -> L16
            int r0 = 0;
        L4:
            if (r0 >= r9.length) goto L10;
            if (r0 >= dstart) goto L7;
            r10.append(r9[r0]);     // Catch: NumberFormatException -> L16
        L9:
            r0 = r0 + 1;     // Catch: NumberFormatException -> L16
            goto L4
        L7:
            if (r0 < dend) goto L9;
            r11.append(r9[r0]);     // Catch: NumberFormatException -> L16
            goto L9
        L10:
            if (isInRange(this.min, this.max, Long.parseLong(r10.toString() + source + r11.toString())) == false) goto L14;
            return null;
        L14:
            return "";
        L23:
            return "";
        }
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "data_limit_setting_page";
    }

    public DataUsageLimitActivity() {
        this.mCurrentUnitType = 0;
        this.mInitialUnitType = 0;
        this.mSkipExitConfirm = false;
        this.mIgnoreSwitchPersist = false;
    }

    static /* synthetic */ OCardListItem access$000(DataUsageLimitActivity r0) {
        return r0.mSwitchDisconnect;
    }

    static /* synthetic */ boolean access$100(DataUsageLimitActivity r0) {
        return r0.mIgnoreSwitchPersist;
    }

    static /* synthetic */ int access$200(DataUsageLimitActivity r0) {
        return r0.mCurrentSub;
    }

    static /* synthetic */ void access$300(DataUsageLimitActivity r0, View r1, int r2, int[] r3) {
        r0.showUnitPopover(r1, r2, r3);
    }

    static /* synthetic */ void access$401(DataUsageLimitActivity r0) {
        super.finish();
    }

    public static OAlertDialog showAlertDialog(Context context, int titleResId, int subtitleResId, Integer positiveButtonTextResId, Integer negativeButtonTextResId, boolean horizontalButton, DialogInterface.OnClickListener onPositiveClick, DialogInterface.OnClickListener onNegativeClick) {
        OAlertDialogBuilder r2 = new OAlertDialogBuilder(context).title(titleResId).message(subtitleResId).overrideButtonStyleController(new DataUsageLimitActivity$$ExternalSyntheticLambda3()).horizontalButton(horizontalButton);
        if (positiveButtonTextResId == null) goto L5;
        r2.positiveButton(positiveButtonTextResId.intValue(), onPositiveClick);
    L5:
        if (negativeButtonTextResId == null) goto L7;
        r2.negativeButton(negativeButtonTextResId.intValue(), onNegativeClick);
    L7:
        OAlertDialog r3 = r2.build();
        OButton r4 = (OButton) r3.getPositiveButton();     // Catch: Throwable -> L16
        if (r4 == null) goto L11;
        r4.setTextColor(context.getColor(R.color.oui_accent_fg));     // Catch: Throwable -> L16
    L11:
        Window r1 = r3.getWindow();
        if (r1 == null) goto L14;
        r1.setGravity(80);
        r1.setLayout(-1, -2);
    L14:
        r3.show();
        return r3;
    }

    static /* synthetic */ ButtonStyleController lambda$showAlertDialog$0(Context r1, Integer r2) {
        return new AlertDialogButtonStyleController(r1, r2.intValue());
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_usage_limit);
        this.mCurrentSub = getIntent().getIntExtra("slot", 0);
        this.mCurrentBytes = Math.max(0, getIntent().getLongExtra(DataUsageDetailActivity.INTENT_EXTRA_LIMIT, 0));
        OCardListItem r7 = (OCardListItem) findViewById(R.id.disable_connectivity);
        this.mSwitchDisconnect = r7;
        if (r7 == null) goto L5;
        boolean r8 = getLimitEnabledFromGlobal();
        this.mSwitchDisconnect.getEndSwitch().setChecked(r8);
        this.mInitialLimitEnabled = r8;
        this.mSwitchDisconnect.setOnContentClickListener(new AnonymousClass1(this));
        this.mSwitchDisconnect.getEndSwitch().setOnCheckedChangeListener(new AnonymousClass2(this));
        this.mSwitchDisconnect.showSubTitle(true);
        this.mSwitchDisconnect.showCustomEnd(true);
        this.mSwitchDisconnect.setCardPosition(0);
    L5:
        initTitleBar(false);
        if (this.mTitle == null) goto L8;
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(R.drawable.oic_list_cancel, -1, new DataUsageLimitActivity$$ExternalSyntheticLambda2(this));
    L8:
        this.mTitle.bringToFront();
        this.mTitle.requestLayout();
        this.mTitle.addEndAction(R.drawable.icon_leading, -1, this);
        OCardListItem r9 = (OCardListItem) findViewById(R.id.limit_item);
        this.mLimitItem = r9;
        r9.setCardType(2);
        this.mLimitItem.setCardPosition(0);
        OInputLayout r10 = new OInputLayout(this);
        this.mEditText = r10;
        r10.setHint(getString(R.string.data_usage_limit));
        this.mLimitItem.setEndDetailText(getString(R.string.gigabyteShort));
        this.mLimitItem.showCustomEnd(true);
        this.mLimitItem.setDefaultTailIcon(1);
        this.mLimitItem.showTailIcon(true);
        this.mEditText.setInputType(2);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-1, -1);
        r11.gravity = 16;
        this.mEditText.setLayoutParams(r11);
        this.mLimitItem.setCustomStartView(this.mEditText);
        this.mEditText.setType(0);
        this.mEditText.setInputType(2);
        initEditText();
        updateViewWidth(R.id.ll_container);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-bytedanceos-datausage-DataUsageLimitActivity, reason: not valid java name */
    /* synthetic */ void m109xfbdb3fd2(View r1) {
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    private boolean hasUnsavedChanges() {
        OInputLayout r0 = this.mEditText;
        if (r0 != null) goto L5;
    L11:
        long r1 = 0;
    L13:
        if (r1 == this.mCurrentBytes) goto L15;
        boolean r2 = true;
    L17:
        if (getLimitEnabledFromGlobal() == this.mInitialLimitEnabled) goto L19;
        boolean r3 = true;
    L21:
        if (this.mCurrentUnitType == this.mInitialUnitType) goto L23;
        boolean r5 = true;
    L24:
        if (r2 == true) goto L32;
        if (r3 == true) goto L33;
        if (r5 == false) goto L29;
        return true;
    L29:
        return false;
    L33:
        return true;
    L32:
        return true;
    L23:
        r5 = false;
        goto L24
    L19:
        r3 = false;
        goto L21
    L15:
        r2 = false;
        goto L17
    L5:
        if (r0.getText() == null) goto L11;
        if (this.mEditText.getText().length() <= 0) goto L11;
        r1 = currentValueToByte();     // Catch: Exception -> L10
    L10:
        r1 = this.mCurrentBytes;
        goto L13
    }

    @Override // com.bytedanceos.security.BaseActivity, android.app.Activity
    public void finish() {
        if (this.mSkipExitConfirm == false) goto L5;
    L14:
        super.finish();
        return;
    L5:
        if (hasUnsavedChanges() == false) goto L14;
        OAlertDialog r0 = this.mExitConfirmDialog;
        if (r0 != null) goto L10;
    L12:
        this.mExitConfirmDialog = showAlertDialog(this, R.string.data_usage_limit_exit_confirm_title, R.string.data_usage_limit_exit_confirm_message, Integer.valueOf(R.string.confirm), Integer.valueOf(R.string.cancel), true, new DataUsageLimitActivity$$ExternalSyntheticLambda0(this), new DataUsageLimitActivity$$ExternalSyntheticLambda1());
        return;
    L10:
        if (r0.isShowing() == false) goto L12;
    }

    /* JADX INFO: renamed from: lambda$finish$2$com-bytedanceos-datausage-DataUsageLimitActivity, reason: not valid java name */
    /* synthetic */ void m108lambda$finish$2$combytedanceosdatausageDataUsageLimitActivity(DialogInterface r1, int r2) {
        this.mSkipExitConfirm = true;
        restoreStateToInitial();
        r1.dismiss();
        access$401(this);
    }

    static /* synthetic */ void lambda$finish$3(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    private void restoreStateToInitial() {
        int r0 = 1;
        this.mIgnoreSwitchPersist = true;     // Catch: Throwable -> L29
        if (this.mInitialLimitEnabled == true) goto L8;
        r0 = 0;
    L8:
        if (this.mCurrentSub != 0) goto L10;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_LIMIT, r0);     // Catch: Throwable -> L29
    L11:
        OCardListItem r1 = this.mSwitchDisconnect;     // Catch: Throwable -> L29
        if (r1 == null) goto L16;
        if (r1.getEndSwitch() == null) goto L16;
        this.mSwitchDisconnect.getEndSwitch().setChecked(this.mInitialLimitEnabled);     // Catch: Throwable -> L29
        goto L16
    L10:
        Settings.Global.putInt(getContentResolver(), "data_usage_limit_sub2", r0);     // Catch: Throwable -> L29
    L16:
        this.mIgnoreSwitchPersist = false;
        this.mCurrentUnitType = this.mInitialUnitType;
        OCardListItem r2 = this.mLimitItem;
        if (r2 != null) goto L19;
    L25:
        OInputLayout r3 = this.mEditText;
        if (r3 == null) goto L32;
        r3.setText(currentValueToNumberText(this.mCurrentBytes));
        return;
    L32:
        return;
    L19:
        if (r2.getEndDetail() == null) goto L25;
        OTextView r4 = this.mLimitItem.getEndDetail();
        if (this.mCurrentUnitType != 0) goto L23;
        int r5 = R.string.megabyteShort;
    L24:
        r4.setText(r5);
        goto L25
    L23:
        r5 = R.string.gigabyteShort;
        goto L24
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        OAlertDialog r0 = this.mExitConfirmDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mExitConfirmDialog.dismiss();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void initEditText() {
        int r0 = getCurrentLimitUnit(this, this.mCurrentSub);
        this.mCurrentUnitType = r0;
        this.mInitialUnitType = r0;
        final ImageView r1 = this.mLimitItem.getTailIconView();
        OTextView r2 = this.mLimitItem.getEndDetail();
        r1.setOnClickListener(new AnonymousClass3(this));
        r2.setOnClickListener(new AnonymousClass4(this, r1));
        if (this.mCurrentUnitType != 0) goto L5;
        int r3 = R.string.megabyteShort;
    L6:
        r2.setText(r3);
        this.mEditText.getVInput().setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        this.mEditText.setText(currentValueToNumberText(this.mCurrentBytes));
        return;
    L5:
        r3 = R.string.gigabyteShort;
        goto L6
    }

    private boolean getLimitEnabledFromGlobal() {
    L15:
        OCardListItem r2 = this.mSwitchDisconnect;
        if (r2 == null) goto L23;
        if (r2.getEndSwitch() == null) goto L23;
        if (this.mSwitchDisconnect.getEndSwitch().isChecked() == false) goto L23;
        return true;
    L23:
        return false;
    L4:
        if (this.mCurrentSub != 0) goto L11;
        if (Settings.Global.getInt(getContentResolver(), Constants.DATA_USAGE_LIMIT, 0) != 1) goto L9;
        return true;
    L9:
        return false;
    L11:
        if (Settings.Global.getInt(getContentResolver(), "data_usage_limit_sub2", 0) != 1) goto L14;
        return true;
    L14:
        return false;
    }

    private void showUnitPopover(View anchorView, int gravity, int[] location) {
        OPopoverEntranceMenuView.Builder r11 = new OPopoverEntranceMenuView.Builder(this);
        r11.enableOption();
        int[] r13 = {R.string.gigabyteShort, R.string.megabyteShort};
        final OPopover[] r15 = new OPopover[1];
        final int r10 = 0;
    L3:
        if (r10 >= 2) goto L12;
        int r1 = this.mCurrentUnitType;
        if (r1 != 1) goto L7;
        if (r10 != 0) goto L7;
    L9:
        boolean r9 = true;
    L11:
        r11.addPopoverLeftOptionItem(0, 0, Integer.valueOf(getColor(R.color.oui_accent_fg)), getString(r13[r10]), null, false, false, r9, new DataUsageLimitActivity$$ExternalSyntheticLambda4(this, r10, r15));
        r10 = r10 + 1;
    L7:
        if (r1 != 0) goto L10;
        if (r10 == 1) goto L9;
    L10:
        r9 = false;
        goto L11
    L12:
        OPopover r0 = new OPopover.Builder(this).setView(r11.build()).build();
        r15[0] = r0;
        OPopoverHelperEx.INSTANCE.showPopoverSmartly(r0, anchorView, gravity);
    }

    /* JADX INFO: renamed from: lambda$showUnitPopover$4$com-bytedanceos-datausage-DataUsageLimitActivity, reason: not valid java name */
    /* synthetic */ Unit m110x90b73b60(int r1, OPopover[] r2, View r3, Integer r4) {
        if (r1 != 0) goto L5;
        this.mCurrentUnitType = 1;
        updateEditIfNeed(this.mEditText.getText().toString());
        int r5 = R.string.gigabyteShort;
    L6:
        this.mLimitItem.getEndDetail().setText(r5);
        OPopover r0 = r2[0];
        if (r0 == null) goto L11;
        r0.dismiss();
        return null;
    L11:
        return null;
    L5:
        this.mCurrentUnitType = 0;
        r5 = R.string.megabyteShort;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        Intent r9 = new Intent();
        if (this.mEditText.getText().length() <= 0) goto L8;
        long r0 = currentValueToByte();
    L10:
        if (r0 <= 0) goto L19;
        if (getIntent().getBooleanExtra("checked", false) == true) goto L14;
    L17:
        r9.putExtra(DataUsageDetailActivity.INTENT_EXTRA_LIMIT, r0);
    L22:
        setCurrentLimitUnit(this, this.mCurrentSub, this.mCurrentUnitType);
        setResult(-1, r9);
        this.mSkipExitConfirm = true;
        finish();
        overridePendingTransition(0, 0);
        return;
    L14:
        if (this.mCurrentSub != 0) goto L16;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING, 1);
        goto L17
    L16:
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING_SUB2, 1);
        goto L17
    L19:
        if (this.mCurrentSub != 0) goto L21;
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING, 0);
        goto L22
    L21:
        Settings.Global.putInt(getContentResolver(), Constants.DATA_USAGE_WARNING_SUB2, 0);
        goto L22
    L8:
        r0 = -1;
        goto L10
    }

    public static void setCurrentLimitUnit(Context context, int currentSubId, int currentUnitType) {
        ContentResolver r0 = context.getContentResolver();
        if (currentSubId != 0) goto L5;
        Settings.Global.putInt(r0, Constants.DATA_USAGE_LIMIT_UNIT, currentUnitType);
        return;
    L5:
        Settings.Global.putInt(r0, Constants.DATA_USAGE_LIMIT_UNIT_SUB2, currentUnitType);
    }

    public static int getCurrentLimitUnit(Context context, int currentSubId) {
        ContentResolver r1 = context.getContentResolver();
        if (currentSubId != 0) goto L6;
        return Settings.Global.getInt(r1, Constants.DATA_USAGE_LIMIT_UNIT, 0);
    L6:
        return Settings.Global.getInt(r1, Constants.DATA_USAGE_LIMIT_UNIT_SUB2, 0);
    }

    private long currentValueToByte() {
        if (this.mEditText.getText().length() > 0) goto L5;
        return 0;
    L5:
        String r0 = this.mEditText.getText().toString();
        int r4 = this.mCurrentUnitType;
        if (r4 != 0) goto L10;
        long r1 = Long.parseLong(r0);
        long r2 = 1048576;
    L12:
        return r1 * r2;
    L10:
        if (r4 != 1) goto L13;
        r1 = Long.parseLong(r0);
        r2 = 1073741824;
        goto L12
    L13:
        return 0;
    }

    private String currentValueToNumberText(long currentBytes) {
        if (currentBytes >= 0) goto L6;
        return "0";
    L6:
        int r2 = this.mCurrentUnitType;
        if (r2 != 0) goto L10;
        return String.valueOf(currentBytes / 1048576);
    L10:
        if (r2 == 1) goto L15;
        return null;
    L15:
        return String.valueOf(currentBytes / 1073741824);
    }

    private void updateEditIfNeed(String valueText) {
        if (TextUtils.isEmpty(valueText) == false) goto L6;
        return;
    L6:
        if (this.mCurrentUnitType == 1) goto L8;
        return;
    L8:
        if (Long.parseLong(valueText) < MAX_GB) goto L12;
        String r5 = currentValueToNumberText(Long.MAX_VALUE);
        this.mEditText.setText(r5);
        this.mEditText.setMaxLines(r5.length());
        return;
    }

    private void notifyDataLimitChanged(long warning) {
        Intent r0 = new Intent(ACTION_DATA_USAGE_LIMIT_CHANGED);
        r0.putExtra(DataUsageDetailActivity.INTENT_EXTRA_LIMIT, warning);
        sendBroadcast(r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
