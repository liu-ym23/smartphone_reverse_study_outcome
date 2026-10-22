package com.android.settings.revone;

import android.app.AlertDialog;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.CustomKeyUtils;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class CustomKeyBoardSettingsFragment extends BaseFragment implements View.OnClickListener {
    private Button mBtnCancel;
    private Button mBtnOK;
    private Button mBtnReset;
    private OButton mBtnResetAllKeys;
    private HashMap<String, String> mCurrentHashMap;
    private AlertDialog mDialog;
    private LinearLayout mKeyContainer;
    private EditText mKeyEditText;
    private TextView mKeyTips;
    private HashMap<String, String> mMacHashMap;
    private HashMap<String, String> mOriginMacWinHashMap;
    private int mPreference;
    private HashMap<String, String> mWinHashMap;

    public void com_android_settings_revone_CustomKeyBoardSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_CustomKeyBoardSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ String access$000(CustomKeyBoardSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ EditText access$100(CustomKeyBoardSettingsFragment r0) {
        return r0.mKeyEditText;
    }

    static /* synthetic */ void access$1000(CustomKeyBoardSettingsFragment r0, SettingItemText r1) {
        r0.resetCurrentKey(r1);
    }

    static /* synthetic */ Button access$200(CustomKeyBoardSettingsFragment r0) {
        return r0.mBtnOK;
    }

    static /* synthetic */ Button access$202(CustomKeyBoardSettingsFragment r0, Button r1) {
        r0.mBtnOK = r1;
        return r1;
    }

    static /* synthetic */ int access$300(CustomKeyBoardSettingsFragment r0) {
        return r0.mPreference;
    }

    static /* synthetic */ HashMap access$400(CustomKeyBoardSettingsFragment r0) {
        return r0.mCurrentHashMap;
    }

    static /* synthetic */ AlertDialog access$500(CustomKeyBoardSettingsFragment r0) {
        return r0.mDialog;
    }

    static /* synthetic */ void access$600(CustomKeyBoardSettingsFragment r0, SettingItemText r1) {
        r0.resetSubTitle(r1);
    }

    static /* synthetic */ void access$700(CustomKeyBoardSettingsFragment r0, SettingItemText r1) {
        r0.saveKeyValue(r1);
    }

    static /* synthetic */ Button access$800(CustomKeyBoardSettingsFragment r0) {
        return r0.mBtnCancel;
    }

    static /* synthetic */ Button access$802(CustomKeyBoardSettingsFragment r0, Button r1) {
        r0.mBtnCancel = r1;
        return r1;
    }

    static /* synthetic */ Button access$900(CustomKeyBoardSettingsFragment r0) {
        return r0.mBtnReset;
    }

    static /* synthetic */ Button access$902(CustomKeyBoardSettingsFragment r0, Button r1) {
        r0.mBtnReset = r1;
        return r1;
    }

    public CustomKeyBoardSettingsFragment() {
        super(R.layout.revone_custom_keyboard_settings);
        this.mMacHashMap = new HashMap();
        this.mWinHashMap = new HashMap();
        this.mCurrentHashMap = null;
        this.mOriginMacWinHashMap = new HashMap();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        Bundle r6 = getArguments();
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_lock)).setTag("custom_key_lock");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_multi_tasks)).setTag("custom_key_multi_tasks");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_multi_tasks_within_app)).setTag("custom_key_multi_tasks_within_app");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_app_drawer)).setTag("custom_key_app_drawer");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_desktop)).setTag("custom_key_desktop");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_screen_shot)).setTag("custom_key_screen_shot");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_screen_shot_full)).setTag("custom_key_screen_shot_full");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_minimize_current_window)).setTag("custom_key_minimize_current_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_minimize_other_window)).setTag("custom_key_minimize_other_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_resume_window)).setTag("custom_key_resume_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_fullscreen)).setTag("custom_key_fullscreen");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_hide_app_all_windows)).setTag("custom_key_hide_app_all_windows");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_close_window)).setTag("custom_key_close_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_close_other_window)).setTag("custom_key_close_other_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_exit_app)).setTag("custom_key_exit_app");
        this.mBtnResetAllKeys = (OButton) findViewByIdNullable(R.id.btn_reset_all_keys);
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_title_bar_switch)).setTag("custom_key_title_bar_switch");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_close_all)).setTag("custom_key_close_all");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_scrapbook_drawer)).setTag("custom_key_scrapbook_drawer");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_quick_switch_center)).setTag("custom_key_quick_switch_center");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_notification_center)).setTag("custom_key_notification_center");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_file_drawer)).setTag("custom_key_file_drawer");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_album_drawer)).setTag("custom_key_album_drawer");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_fullscreen_to_the_right)).setTag("custom_key_fullscreen_to_the_right");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_fullscreen_to_the_left)).setTag("custom_key_fullscreen_to_the_left");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_open_new_file_manager_window)).setTag("custom_key_open_new_file_manager_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_hide_other_app_window)).setTag("custom_key_hide_other_app_window");
        ((SettingItemText) findViewByIdNullable(R.id.btn_key_organize_small_window)).setTag("custom_key_organize_small_window");
        this.mKeyContainer = (LinearLayout) findViewByIdNullable(R.id.page_container);
        int r0 = 0;
    L4:
        if (r0 >= this.mKeyContainer.getChildCount()) goto L11;
        View r1 = this.mKeyContainer.getChildAt(r0);
        if ((r1 instanceof SettingItemText) == false) goto L8;
    L9:
        r1.setOnClickListener(this);
    L10:
        r0 = r0 + 1;
        goto L4
    L8:
        if ((r1 instanceof OButton) == false) goto L10;
    L11:
        OFloatingTitleBar r2 = this.mTitleView;
        if (r2 == null) goto L16;
        if (r6 == null) goto L16;
        r2.setCenterTitle(r6.getString("title"));
        this.mPreference = r6.getInt("extra_target_key", 0);
    L22:
        CustomKeyUtils.setIsMacStyle(isKeyBoardMacStyle());
        parseKeyValues();
        if (isKeyBoardMacStyle() == false) goto L25;
        this.mCurrentHashMap = new HashMap(this.mMacHashMap);
    L26:
        updateSubTitle();
        return;
    L25:
        this.mCurrentHashMap = new HashMap(this.mWinHashMap);
    L16:
        if (getActivity() == null) goto L18;
        Bundle r7 = getActivity().getIntent().getExtras();
    L19:
        if (r2 == null) goto L22;
        if (r7 == null) goto L22;
        r2.setCenterTitle(r7.getString("title"));
        this.mPreference = r7.getInt("extra_target_key", 0);
        goto L22
    L18:
        r7 = null;
        goto L19
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof SettingItemText) == false) goto L6;
        showChangeKeyDialog((SettingItemText) r2);
        return;
    L6:
        if (r2 != this.mBtnResetAllKeys) goto L10;
        resetAllItems();
        return;
    }

    private void showChangeKeyDialog(final SettingItemText r8) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        final FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(this.TAG, "showChangeKeyDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        View r3 = LayoutInflater.from(r1).inflate(R.layout.dlg_pattern_edittext_layout, null);
        this.mKeyEditText = (EditText) NullSafe.nonNull(r3.findViewById(R.id.et_custom_key));
        this.mKeyTips = (TextView) NullSafe.nonNull(r3.findViewById(R.id.et_custom_key_tips));
        if (r8.getId() == R.id.btn_key_screen_shot_full) goto L14;
    L16:
        this.mKeyEditText.setInputType(0);
        String r4 = this.mCurrentHashMap.get(r8.getTag());
        if (TextUtils.isEmpty(r4) == true) goto L19;
        this.mKeyEditText.setText(getSubTitleString(r4));
    L19:
        this.mKeyEditText.requestFocus();
        EditText r5 = this.mKeyEditText;
        r5.setSelection(0, r5.getText().toString().length());
        this.mKeyEditText.setOnKeyListener(new AnonymousClass1(this, r8, r1));
        r2.setTitle(r8.getTitle()).setNegativeButton(android.R.string.cancel, null).setPositiveButton(android.R.string.ok, null).setNeutralButton(R.string.reset, null).setView(r3);
        AlertDialog r6 = r2.create();
        this.mDialog = r6;
        r6.setOnShowListener(new AnonymousClass2(this, r8));
        this.mDialog.setCanceledOnTouchOutside(true);
        if (this.mDialog.getWindow() == null) goto L22;
        this.mDialog.getWindow().getAttributes().setTitle(getString(R.string.custom_key_window_title));
    L22:
        this.mDialog.show();
        return;
    L14:
        if (isKeyBoardMacStyle() == true) goto L16;
        this.mKeyTips.setVisibility(0);
        goto L16
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    private void resetAllItems() {
        int r0 = 0;
    L4:
        if (r0 >= this.mKeyContainer.getChildCount()) goto L12;
        View r1 = this.mKeyContainer.getChildAt(r0);
        if ((r1 instanceof SettingItemText) == false) goto L11;
        String r2 = this.mOriginMacWinHashMap.get(r1.getTag());
        if (TextUtils.isEmpty(r2) == false) goto L10;
        ((SettingItemText) r1).setSubtitle(getSubTitleString("NONE"));
        goto L11
    L10:
        SettingItemText r3 = (SettingItemText) r1;
        r3.setSubtitle(getOriginSubTitleString(r2));
        saveKeyValue(r3);
    L11:
        r0 = r0 + 1;
        goto L4
    L12:
        resetAndSaveAllKeyValues();
    }

    private void resetCurrentKey(SettingItemText r4) {
        String r0 = getOriginSubTitleString(this.mOriginMacWinHashMap.get(r4.getTag()));
        this.mKeyEditText.setText(r0);
        if (getString(R.string.key_none).equals(r0) == false) goto L6;
        this.mBtnOK.setEnabled(true);
        return;
    L6:
        if (isCurrentKeyConflict(r0, r4) == true) goto L8;
        this.mBtnOK.setEnabled(true);
        return;
    L8:
        this.mBtnOK.setEnabled(false);
    }

    private void setKeyValues(String r4, String r5) {
        String r0 = Settings.Global.getString(getContentResolver(), r4);
        if (r0 == null) goto L5;
        String[] r1 = r0.split(CustomKeyUtils.PARSE_SEPARATE);
        this.mMacHashMap.put(r4, r1[0]);
        this.mWinHashMap.put(r4, r1[1]);
        this.mOriginMacWinHashMap.put(r4, r5);
        return;
    L5:
        this.mMacHashMap.put(r4, "NONE");
        this.mWinHashMap.put(r4, "NONE");
        this.mOriginMacWinHashMap.put(r4, "NONE$NONE");
    }

    private void parseKeyValues() {
        setKeyValues("custom_key_lock", "META_CTRL_ON+META_META_ON+KEYCODE_Q$META_META_ON+KEYCODE_L");
        setKeyValues("custom_key_multi_tasks", "NONE$NONE");
        setKeyValues("custom_key_multi_tasks_within_app", "META_CTRL_ON+KEYCODE_DPAD_DOWN$NONE");
        setKeyValues("custom_key_app_drawer", "NONE$NONE");
        setKeyValues("custom_key_desktop", "KEYCODE_F11$META_META_ON+KEYCODE_D");
        setKeyValues("custom_key_screen_shot", "META_SHIFT_ON+META_META_ON+KEYCODE_4$META_SHIFT_ON+META_META_ON+KEYCODE_S");
        setKeyValues("custom_key_screen_shot_full", "META_SHIFT_ON+META_META_ON+KEYCODE_3$KEYCODE_PrintScreen");
        setKeyValues("custom_key_minimize_current_window", "META_META_ON+KEYCODE_M$NONE");
        setKeyValues("custom_key_minimize_other_window", "NONE$NONE");
        setKeyValues("custom_key_resume_window", "NONE$NONE");
        setKeyValues("custom_key_fullscreen", "META_CTRL_ON+META_META_ON+KEYCODE_F$KEYCODE_F11");
        setKeyValues("custom_key_hide_app_all_windows", "META_META_ON+KEYCODE_H$NONE");
        setKeyValues("custom_key_close_window", "NONE$META_ALT_ON+KEYCODE_F4");
        setKeyValues("custom_key_close_other_window", "NONE$NONE");
        setKeyValues("custom_key_exit_app", "META_META_ON+KEYCODE_Q$NONE");
        setKeyValues("custom_key_title_bar_switch", "NONE$NONE");
        setKeyValues("custom_key_close_all", "NONE$NONE");
        setKeyValues("custom_key_scrapbook_drawer", "NONE$META_META_ON+KEYCODE_V");
        setKeyValues("custom_key_quick_switch_center", "NONE$NONE");
        setKeyValues("custom_key_notification_center", "NONE$META_META_ON+KEYCODE_A");
        setKeyValues("custom_key_file_drawer", "NONE$NONE");
        setKeyValues("custom_key_album_drawer", "NONE$NONE");
        setKeyValues("custom_key_fullscreen_to_the_right", "META_CTRL_ON+KEYCODE_DPAD_RIGHT$META_CTRL_ON+META_META_ON+KEYCODE_DPAD_RIGHT");
        setKeyValues("custom_key_fullscreen_to_the_left", "META_CTRL_ON+KEYCODE_DPAD_LEFT$META_CTRL_ON+META_META_ON+KEYCODE_DPAD_LEFT");
        setKeyValues("custom_key_open_new_file_manager_window", "NONE$META_META_ON+KEYCODE_E");
        setKeyValues("custom_key_hide_other_app_window", "META_META_ON+META_ALT_ON+KEYCODE_H$NONE");
        setKeyValues("custom_key_organize_small_window", "NONE$NONE");
    }

    private void updateSubTitle() {
        int r0 = 0;
    L4:
        if (r0 >= this.mKeyContainer.getChildCount()) goto L12;
        View r1 = this.mKeyContainer.getChildAt(r0);
        if ((r1 instanceof SettingItemText) == false) goto L11;
        String r2 = this.mCurrentHashMap.get(r1.getTag());
        if (TextUtils.isEmpty(r2) == false) goto L10;
        r2 = "NONE";
    L10:
        SettingItemText r3 = (SettingItemText) r1;
        r3.setSubtitle(getSubTitleString(r2));
    L11:
        r0 = r0 + 1;
        goto L4
    }

    private String getSubTitleString(String r3) {
        if (r3.equals("NONE") == true) goto L5;
        String[] r2 = r3.split(CustomKeyUtils.KEY_VALUE_SEPARATE_PARSE);
        StringBuilder r4 = new StringBuilder();
        int r0 = 0;
    L8:
        if (r0 >= r2.length) goto L14;
        r4.append(CustomKeyUtils.parseKeyToLabel(r2[r0]));
        if (r0 == (r2.length - 1)) goto L12;
        r4.append(CustomKeyUtils.KEY_SEPARATE_FOR_SHOW);
    L12:
        r0 = r0 + 1;
        goto L8
    L14:
        return r4.toString();
    L5:
        return getString(R.string.key_none);
    }

    private String getOriginSubTitleString(String r3) {
        String[] r4 = r3.split(CustomKeyUtils.PARSE_SEPARATE);
        if (r4.length < 2) goto L11;
        if (isKeyBoardMacStyle() == false) goto L9;
        return getSubTitleString(r4[0]);
    L9:
        return getSubTitleString(r4[1]);
    L11:
        return getString(R.string.key_none);
    }

    private void resetSubTitle(SettingItemText r1) {
        r1.setSubtitle(this.mKeyEditText.getText().toString());
    }

    private void resetAndSaveAllKeyValues() {
        Iterator<String> r0 = this.mOriginMacWinHashMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        Settings.Global.putString(getContentResolver(), r1, this.mOriginMacWinHashMap.get(r1));
        goto L4
    }

    private void saveKeyValue(SettingItemText r6) {
        String r0 = CustomKeyUtils.parseLabelToKeyValue(this.mContext, r6.getSubTitle().toString());
        this.mCurrentHashMap.put((String) r6.getTag(), r0);
        if (isKeyBoardMacStyle() == false) goto L5;
        String r1 = r0 + "$" + this.mWinHashMap.get(r6.getTag());
    L6:
        Settings.Global.putString(getContentResolver(), (String) r6.getTag(), r1);
        return;
    L5:
        r1 = this.mMacHashMap.get(r6.getTag()) + "$" + r0;
        goto L6
    }

    private boolean isCurrentKeyConflict(String r3, SettingItemText r4) {
        return MultiSDKAdapterNew.isCurrentKeyConflict(r3, r4, getActivity(), this.mPreference, this.mCurrentHashMap);
    }

    private boolean isKeyBoardMacStyle() {
        if (this.mPreference == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CustomKeyBoardSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_CustomKeyBoardSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CustomKeyBoardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_CustomKeyBoardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CustomKeyBoardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_CustomKeyBoardSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
