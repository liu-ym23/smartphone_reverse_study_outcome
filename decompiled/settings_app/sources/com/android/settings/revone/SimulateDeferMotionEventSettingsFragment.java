package com.android.settings.revone;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SimulateDeferMotionEventSettingsFragment extends BaseFragment {
    private static final int DEFAULT_DELAY_VALUE = 0;
    private static final String TAG = "SimulateDeferMotionEventSettingsFragment";
    private static final String TAG_DELAY_DURATION = "tag_delay_duration";
    private static final String TAG_MAX_DELAY = "tag_max_delay";
    private static final String TAG_MIN_DELAY = "tag_min_delay";
    private static final int TIME_DEFAULT_MAX_DEFER_INPUT = 200;
    private static final int TIME_DEFAULT_MIN_DEFER_INPUT = 0;
    private static final int TIME_DEFAULT_RADOM_DEFER_INPUT = 0;
    private static final String TIME_MIN_MAX_DEFER_INPUT = "time_min_max_defer_input";
    private AlertDialog mChangeValueDialog;
    private ContentResolver mContentResolver;
    private boolean mDialogConfirmed;
    private int mIndex;
    private SettingItemText mMaxDelay;
    private SettingItemText mMinDelay;
    private OButton mOkButton;
    private LinearLayout mValueContainer;
    private EditText mValueEditText;
    private HashMap<String, Integer> mValueHashMap;
    private AlertDialog mWarningDialog;

    public void com_android_settings_revone_SimulateDeferMotionEventSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_SimulateDeferMotionEventSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(SimulateDeferMotionEventSettingsFragment r0) {
        r0.showWarningDialog();
    }

    static /* synthetic */ AlertDialog access$100(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mChangeValueDialog;
    }

    static /* synthetic */ AlertDialog access$1002(SimulateDeferMotionEventSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$200(SimulateDeferMotionEventSettingsFragment r0, SettingItemText r1) {
        r0.resetSubTitle(r1);
    }

    static /* synthetic */ void access$300(SimulateDeferMotionEventSettingsFragment r0, SettingItemText r1) {
        r0.saveKeyValue(r1);
    }

    static /* synthetic */ EditText access$400(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mValueEditText;
    }

    static /* synthetic */ boolean access$500(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mDialogConfirmed;
    }

    static /* synthetic */ boolean access$502(SimulateDeferMotionEventSettingsFragment r0, boolean r1) {
        r0.mDialogConfirmed = r1;
        return r1;
    }

    static /* synthetic */ HashMap access$600(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mValueHashMap;
    }

    static /* synthetic */ SettingItemText access$700(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mMinDelay;
    }

    static /* synthetic */ SettingItemText access$800(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mMaxDelay;
    }

    static /* synthetic */ ContentResolver access$900(SimulateDeferMotionEventSettingsFragment r0) {
        return r0.mContentResolver;
    }

    public SimulateDeferMotionEventSettingsFragment() {
        super(R.layout.revone_simulate_defer_motion_event_settings_layout);
        this.mValueHashMap = new HashMap();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mContentResolver = getContentResolver();
        SettingItemText r3 = (SettingItemText) findViewByIdNullable(R.id.min_delay);
        this.mMinDelay = r3;
        r3.setTag(TAG_MIN_DELAY);
        SettingItemText r4 = (SettingItemText) findViewByIdNullable(R.id.max_delay);
        this.mMaxDelay = r4;
        r4.setTag(TAG_MAX_DELAY);
        ((SettingItemText) findViewByIdNullable(R.id.delay_duration)).setTag(TAG_DELAY_DURATION);
        OButton r5 = (OButton) findViewByIdNullable(R.id.confirmed2);
        this.mOkButton = r5;
        r5.setOnClickListener(new AnonymousClass1(this));
        this.mValueContainer = (LinearLayout) findViewByIdNullable(R.id.delay_value_container);
        int r6 = 0;
    L3:
        this.mIndex = r6;
        if (this.mIndex >= this.mValueContainer.getChildCount()) goto L11;
        View r7 = this.mValueContainer.getChildAt(this.mIndex);
        if ((r7 instanceof SettingItemText) == false) goto L8;
    L9:
        r7.setOnClickListener(new SimulateDeferMotionEventSettingsFragment$$ExternalSyntheticLambda0(this));
    L10:
        r6 = this.mIndex + 1;
        goto L3
    L8:
        if ((r7 instanceof OButton) == false) goto L10;
    L11:
        initMap();
        initSubTitles();
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-revone-SimulateDeferMotionEventSettingsFragment, reason: not valid java name */
    /* synthetic */ void m558xc096a264(View r2) {
        if ((r2 instanceof SettingItemText) == false) goto L6;
        showChangeValueDialog((SettingItemText) r2, this.mIndex);
        return;
    }

    private void initMap() {
        String r0 = Settings.Global.getString(this.mContentResolver, TIME_MIN_MAX_DEFER_INPUT);
        int[] r2 = {0, 0, 0};
        if (r0 == null) goto L18;
        String[] r1 = r0.split(":");
        if (r1 == null) goto L18;
        if (r1.length != 3) goto L18;
        r2[0] = Integer.valueOf(r1[0]).intValue();     // Catch: NumberFormatException -> L17
        r2[1] = Integer.valueOf(r1[1]).intValue();     // Catch: NumberFormatException -> L17
        int r3 = Integer.valueOf(r1[2]).intValue();     // Catch: NumberFormatException -> L17
        r2[2] = r3;     // Catch: NumberFormatException -> L17
        if (r2[0] >= 0) goto L12;
        r2[0] = 0;     // Catch: NumberFormatException -> L17
    L12:
        if (r2[1] <= 200) goto L14;
        r2[1] = 200;     // Catch: NumberFormatException -> L17
    L14:
        if (r3 >= 0) goto L18;
        r2[2] = 0;     // Catch: NumberFormatException -> L17
    L17:
        r2[0] = 0;
        r2[1] = 0;
        r2[2] = 0;
    L18:
        this.mValueHashMap.put(TAG_MIN_DELAY, Integer.valueOf(r2[0]));
        this.mValueHashMap.put(TAG_MAX_DELAY, Integer.valueOf(r2[1]));
        this.mValueHashMap.put(TAG_DELAY_DURATION, Integer.valueOf(r2[2]));
    }

    private void initSubTitles() {
        int r1 = 0;
    L4:
        if (r1 >= this.mValueContainer.getChildCount()) goto L12;
        View r2 = this.mValueContainer.getChildAt(r1);
        if ((r2 instanceof SettingItemText) == false) goto L11;
        int r3 = this.mValueHashMap.get(r2.getTag()).intValue();
        if (r3 >= 0) goto L10;
        r3 = 0;
    L10:
        ((SettingItemText) r2).setSubtitle(Integer.toString(r3));
    L11:
        r1 = r1 + 1;
        goto L4
    }

    private void showChangeValueDialog(final SettingItemText r5, int r6) {
        AlertDialog r7 = this.mChangeValueDialog;
        if (r7 != null) goto L5;
    L7:
        FragmentActivity r8 = getActivity();
        if (r8 != null) goto L11;
        OLog.e(TAG, "showChangeValueDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r0 = new AlertDialog.Builder(r8);
        View r9 = LayoutInflater.from(r8).inflate(R.layout.dlg_pattern_edittext_layout, null);
        EditText r1 = (EditText) NullSafe.nonNull(r9.findViewById(R.id.et_custom_key));
        this.mValueEditText = r1;
        r1.setInputType(2);
        Integer r2 = this.mValueHashMap.get(r5.getTag());
        if (r2 != null) goto L15;
        this.mValueEditText.setText("0");
    L17:
        r0.setTitle(r5.getTitle()).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, null).setNeutralButton(R.string.reset, null).setView(r9);
        AlertDialog r10 = r0.create();
        this.mChangeValueDialog = r10;
        r10.setOnShowListener(new AnonymousClass2(this, r5));
        this.mChangeValueDialog.setCanceledOnTouchOutside(true);
        if (this.mChangeValueDialog.getWindow() == null) goto L20;
        this.mChangeValueDialog.getWindow().getAttributes().setTitle(getString(R.string.custom_key_window_title));
    L20:
        this.mChangeValueDialog.show();
        return;
    L15:
        if (r2.intValue() <= 0) goto L17;
        this.mValueEditText.setText(Integer.toString(r2.intValue()));
        goto L17
    L5:
        if (r7.isShowing() == false) goto L7;
        this.mChangeValueDialog.dismiss();
        goto L7
    }

    private void saveKeyValue(SettingItemText r2) {
        int r0 = Integer.parseInt(r2.getSubTitle().toString());     // Catch: NumberFormatException -> L5
    L6:
        this.mValueHashMap.put((String) r2.getTag(), Integer.valueOf(r0));
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private void resetSubTitle(SettingItemText r2) {
        String r1 = this.mValueEditText.getText().toString();
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = String.valueOf(0);
    L5:
        r2.setSubtitle(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog r0 = this.mWarningDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private String[] getEntries(int r1) {
        return this.mContext.getResources().getStringArray(r1);
    }

    private String[] getValues(int r1) {
        return this.mContext.getResources().getStringArray(r1);
    }

    private void showWarningDialog() {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(TAG, "showWarningDialog, activity is null, return");
        return;
    L11:
        this.mDialogConfirmed = false;
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.defer_motion_time_settings_title).setMessage(R.string.defer_motion_time_dialog_content).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, new AnonymousClass4(this)).setOnDismissListener(new AnonymousClass3(this, r1)).setCancelable(false);
        AlertDialog r3 = r2.create();
        this.mWarningDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SimulateDeferMotionEventSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_SimulateDeferMotionEventSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SimulateDeferMotionEventSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_SimulateDeferMotionEventSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SimulateDeferMotionEventSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_SimulateDeferMotionEventSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
