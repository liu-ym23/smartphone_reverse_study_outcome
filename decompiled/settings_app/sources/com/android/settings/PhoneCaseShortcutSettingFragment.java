package com.android.settings;

import android.app.SmtPCUtils;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import bytedanceos.util.SettingsUtil;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.CustomExpandableLinearLayout;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneCaseShortcutSettingFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, CustomExpandableLinearLayout.ClearCheckListener {
    private static final int APP_INSTALL_SUCCEED = 4097;
    private static final int APP_PACKAGE_CHANGED = 4098;
    private static final int APP_UNINSTALL_COMPLETED = 4099;
    private static final String JSON_ACTION_KEY = "action";
    private static final String JSON_CATEGORY_KEY = "category";
    private static final String JSON_INTENT_KEY = "intent";
    private static final String JSON_MASTER_KEY = "master";
    private static final String JSON_PKG_NAME_KEY = "appPackageName";
    private static final String JSON_TRIGGER_TYPE = "trigger_type";
    private static final String JSON_VERIFY_KEY = "isNeedQueryPackage";
    private static final int MSG_SHORTCUT_VALUE_CHANGE = 4100;
    private static final String TAG = "PhoneCaseShortcutSettin";
    public static final int TRIGGER_TYPE_LONG_SCREEN_OFF = 2;
    public static final int TRIGGER_TYPE_LONG_SCREEN_ON = 1;
    public static final int TRIGGER_TYPE_LONG_SCREEN_ON_OFF = 3;
    public static final int TRIGGER_TYPE_SHORT = 0;
    private ArrayList<String> applicationItemsEntryList;
    private ArrayList<String> mAccessibilityItemsEntryList;
    private boolean mAppInitialized;
    private int mAskKeyIndex;
    private final Handler mHandler;
    private ShortcutKeyChangeListener mKeyChangeListener;
    private LauncherApps mLauncherAppsService;
    private LauncherApps.Callback mLauncherCallback;
    private ArrayList<String> mOperationItemsEntryList;
    private PackageManager mPackageManager;
    private ArrayList<String> mPhoneCaseGlobalKeys;
    private CustomExpandableLinearLayout mShortcutAccessibility;
    private CustomExpandableLinearLayout mShortcutApplication;
    private CustomExpandableLinearLayout.ValueStoreListener mShortcutKeyStoreListener;
    private CustomExpandableLinearLayout mShortcutOperation;
    private PreferenceMgr mShortcutPreference;
    private CustomExpandableLinearLayout mShortcutTools;
    private ArrayList<String> mToolItemsEntryList;

    public interface ShortcutKeyChangeListener {
        void onKeyChange(int r1, String r2);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PhoneCaseShortcutSettingFragment() {
        this.mHandler = new AnonymousClass1(this);
        this.mLauncherCallback = new AnonymousClass2(this);
        this.mShortcutKeyStoreListener = new AnonymousClass3(this);
    }

    static /* synthetic */ CustomExpandableLinearLayout access$000(PhoneCaseShortcutSettingFragment r0) {
        return r0.mShortcutTools;
    }

    static /* synthetic */ CustomExpandableLinearLayout access$100(PhoneCaseShortcutSettingFragment r0) {
        return r0.mShortcutApplication;
    }

    static /* synthetic */ ShortcutKeyChangeListener access$200(PhoneCaseShortcutSettingFragment r0) {
        return r0.mKeyChangeListener;
    }

    static /* synthetic */ Handler access$300(PhoneCaseShortcutSettingFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ String access$400(PhoneCaseShortcutSettingFragment r0, CustomExpandableLinearLayout r1, String r2, String r3, int r4) {
        return r0.parseJsonString(r1, r2, r3, r4);
    }

    static /* synthetic */ int access$500(PhoneCaseShortcutSettingFragment r0) {
        return r0.mAskKeyIndex;
    }

    public void setKeyChangeListener(ShortcutKeyChangeListener r1) {
        this.mKeyChangeListener = r1;
    }

    public void com_android_settings_PhoneCaseShortcutSettingFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        this.mAskKeyIndex = r4.getInt(PhoneCaseKeySettingFragment.ARG_PHONE_CASE_KEY_INDEX, 0);
        this.mPhoneCaseGlobalKeys = r4.getStringArrayList(PhoneCaseKeySettingFragment.ARG_PHONE_CASE_KEYS);
        this.mShortcutPreference = PreferenceMgr.getInstance(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.phone_case_shortcut_settings_layout, r4, false);
        this.mShortcutTools = (CustomExpandableLinearLayout) this.mRootView.findViewById(R.id.id_shortcut_tool);
        this.mShortcutOperation = (CustomExpandableLinearLayout) this.mRootView.findViewById(R.id.id_shortcut_option);
        this.mShortcutAccessibility = (CustomExpandableLinearLayout) this.mRootView.findViewById(R.id.id_shortcut_accessibility);
        this.mShortcutApplication = (CustomExpandableLinearLayout) this.mRootView.findViewById(R.id.id_shortcut_application);
        this.mLauncherAppsService = (LauncherApps) getSystemService("launcherapps");
        this.mPackageManager = this.mContext.getPackageManager();
        initToolItemsEntry();
        initOperationItemsEntry();
        initAccessibilityItemsEntry();
        initAppItemsEntry();
        String r6 = this.mPhoneCaseGlobalKeys.get(this.mAskKeyIndex);
        CustomExpandableLinearLayout r7 = this.mShortcutTools;
        if (r7 == null) goto L5;
        r7.setSmartKey(r6, this.mPhoneCaseGlobalKeys);
        this.mShortcutTools.initViews(getResources().getStringArray(R.array.phone_case_quick_tools), this.mToolItemsEntryList);
        this.mShortcutTools.setStoreListener(this.mShortcutKeyStoreListener);
        this.mShortcutTools.setCheckListener(this);
    L5:
        CustomExpandableLinearLayout r8 = this.mShortcutOperation;
        if (r8 == null) goto L8;
        r8.setSmartKey(r6, this.mPhoneCaseGlobalKeys);
        this.mShortcutOperation.initViews(getResources().getStringArray(R.array.phone_case_quick_operation), this.mOperationItemsEntryList);
        this.mShortcutOperation.setStoreListener(this.mShortcutKeyStoreListener);
        this.mShortcutOperation.setCheckListener(this);
    L8:
        CustomExpandableLinearLayout r9 = this.mShortcutAccessibility;
        if (r9 == null) goto L11;
        r9.setSmartKey(r6, this.mPhoneCaseGlobalKeys);
        this.mShortcutAccessibility.initViews(getResources().getStringArray(R.array.phone_case_quick_accessibility), this.mAccessibilityItemsEntryList);
        this.mShortcutAccessibility.setStoreListener(this.mShortcutKeyStoreListener);
        this.mShortcutAccessibility.setCheckListener(this);
    L11:
        CustomExpandableLinearLayout r10 = this.mShortcutApplication;
        if (r10 == null) goto L14;
        r10.setSmartKey(r6, this.mPhoneCaseGlobalKeys);
        this.mShortcutApplication.setStoreListener(this.mShortcutKeyStoreListener);
        this.mShortcutApplication.setCheckListener(this);
    L14:
        this.mAppInitialized = false;
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mLauncherAppsService.registerCallback(this.mLauncherCallback, this.mHandler);
        int r5 = 0;
        if (this.mAppInitialized == true) goto L5;
        this.mShortcutApplication.initViews(new String[0], new ArrayList());
        this.mAppInitialized = true;
    L5:
        boolean r6 = SettingsUtil.isAccessibilityEnabled(this.mContext);
        CustomExpandableLinearLayout r2 = this.mShortcutAccessibility;
        if (r6 == true) goto L9;
        r5 = 8;
    L9:
        r2.setVisibility(r5);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        r1.getId();
    }

    @Override // com.android.settings.widget.CustomExpandableLinearLayout.ClearCheckListener
    public void clearChecks() {
        this.mShortcutTools.clearChecks();
        this.mShortcutOperation.clearChecks();
        this.mShortcutAccessibility.clearChecks();
        this.mShortcutApplication.clearChecks();
    }

    public void com_android_settings_PhoneCaseShortcutSettingFragment__onResume$___twin___() {
        super.onResume();
        boolean r0 = SettingsUtil.isAccessibilityEnabled(this.mContext);
        CustomExpandableLinearLayout r1 = this.mShortcutAccessibility;
        if (r0 == false) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mShortcutApplication.release();
        this.mLauncherAppsService.unregisterCallback(this.mLauncherCallback);
        this.mHandler.removeMessages(4097);
        this.mHandler.removeMessages(4098);
        this.mHandler.removeMessages(4099);
    }

    private void initToolItemsEntry() {
        this.mToolItemsEntryList = new ArrayList();
        String r0 = createOptionJson("search", 3);
        this.mToolItemsEntryList.add(r0);
        String r1 = appendOptionJson(createOptionJsonArray("idea_pills_list", 0), "voice_assistant", 3);
        this.mToolItemsEntryList.add(r1);
        String r2 = appendOptionJson(createActivityJsonArray(this.mPackageManager.getLaunchIntentForPackage(Constants.PKG_BULLET_SMS), Constants.PKG_BULLET_SMS, 0), "bullet_messenger", Constants.PKG_BULLET_SMS, 3);
        this.mToolItemsEntryList.add(r2);
        Intent r3 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
        r3.putExtra("LauncherUI.From.Scaner.Shortcut", true);
        r3.addFlags(268435456);
        String r4 = createActivityJson(r3, "com.tencent.mm", 0);
        this.mToolItemsEntryList.add(r4);
        Intent r5 = new Intent("com.bytedanceos.action.QuickPayment");
        r5.setPackage(Constants.PKG_WALLPAPER_PROVIDER);
        r5.putExtra("extra_payment", "com.tencent.mm");
        String r6 = createServiceJson(r5, true, "com.tencent.mm", 0);
        this.mToolItemsEntryList.add(r6);
        this.mToolItemsEntryList.add(createOptionJson("torch"));
        Intent r7 = new Intent();
        r7.setComponent(new ComponentName("com.bytedanceos.payment", "com.bytedanceos.payment.PaymentActivity"));
        r7.putExtra("extra_action", "ali_scan");
        String r8 = createActivityJson(r7, "com.eg.android.AlipayGphone", 0);
        this.mToolItemsEntryList.add(r8);
        Intent r9 = new Intent("android.intent.action.MAIN");
        r9.setClassName("com.bytedanceos.payment", "com.bytedanceos.payment.PaymentActivity");
        r9.setPackage("com.bytedanceos.payment");
        r9.putExtra("extra_action", "ali_qr_code");
        String r10 = createActivityJson(r9, "com.eg.android.AlipayGphone", 0);
        this.mToolItemsEntryList.add(r10);
        String r11 = appendOptionJson(null, "calculator", SmtPCUtils.PKG_CALCULATOR, 0);
        this.mToolItemsEntryList.add(r11);
        String r12 = appendOptionJson(null, "notes", Constants.PACKAGE_NOTES, 0);
        this.mToolItemsEntryList.add(r12);
        Intent r13 = newAppIntent("com.android.contacts");
        r13.putExtra(TimeChangeReceiver.ACTION_SHOW_TAB_AT, 2);
        r13.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.activities.DialtactsActivity"));
        String r14 = createActivityJson(r13, "com.android.contacts", 0);
        this.mToolItemsEntryList.add(r14);
    }

    private void initOperationItemsEntry() {
        ArrayList<String> r0 = new ArrayList();
        this.mOperationItemsEntryList = r0;
        r0.add(createOptionJson("go_back"));
        this.mOperationItemsEntryList.add(createOptionJson("multitask"));
        this.mOperationItemsEntryList.add(createOptionJson("go_noti_center"));
        this.mOperationItemsEntryList.add(createOptionJson("go_lastApplication"));
        this.mOperationItemsEntryList.add(createOptionJson("go_home"));
        this.mOperationItemsEntryList.add(createOptionJson("do_screen_shot"));
        this.mOperationItemsEntryList.add(createOptionJson("go_shortcut_panel"));
        this.mOperationItemsEntryList.add(createOptionJson("do_phone_silence"));
        Intent r1 = newAppIntent("com.android.contacts");
        r1.putExtra(TimeChangeReceiver.ACTION_SHOW_TAB_AT, 1);
        r1.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.activities.DialtactsActivity"));
        String r2 = createActivityJson(r1, "com.android.contacts", 0);
        this.mOperationItemsEntryList.add(r2);
    }

    private void initAccessibilityItemsEntry() {
        ArrayList<String> r0 = new ArrayList();
        this.mAccessibilityItemsEntryList = r0;
        r0.add(createOptionJson("speech_reading"));
        Intent r1 = new Intent();
        r1.setClass(this.mContext, Settings.TextToSpeechSettingsActivity.class);
        r1.setPackage(this.mContext.getPackageName());
        String r2 = createActivityJson(r1, r1.getPackage(), 0);
        this.mAccessibilityItemsEntryList.add(r2);
        this.mAccessibilityItemsEntryList.add(createOptionJson("brightness_down"));
        this.mAccessibilityItemsEntryList.add(createOptionJson("trigger_global_ocr"));
        this.mAccessibilityItemsEntryList.add(createOptionJson("voice_command", 3));
        this.mAccessibilityItemsEntryList.add(createOptionJson("current_time"));
        this.mAccessibilityItemsEntryList.add(createOptionJson("current_location"));
        addAccessibilityParams(this.mAccessibilityItemsEntryList, "accessibility");
    }

    private void initAppItemsEntry() {
        this.applicationItemsEntryList = new ArrayList();
    }

    private Intent newAppIntent(String r1) {
        return this.mPackageManager.getLaunchIntentForPackage(r1);
    }

    public static String createActivityJson(Intent r0, String r1, int r2) {
        return createActivityJsonArray(r0, r1, r2).toString();
    }

    public static JSONArray createActivityJsonArray(Intent r5, String r6, int r7) {
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        if (r5 != null) goto L14;
        r5 = new Intent("android.intent.action.MAIN");
        r5.addCategory("android.intent.category.LAUNCHER");
        r5.setPackage(r6);
        r5.addFlags(268435456);
        r5.setClassName(Constants.PKG_BULLET_SMS, "com.bytedance.flashim.main.activity.WelcomeActivity");
    L14:
        r2.put(JSON_MASTER_KEY, "activity");     // Catch: JSONException -> L10
        r2.put("intent", r5.toUri(1));     // Catch: JSONException -> L10
        r2.put("appPackageName", r6);     // Catch: JSONException -> L10
        r2.put(JSON_VERIFY_KEY, 1);     // Catch: JSONException -> L10
        if ("com.android.settings".equals(r6) == false) goto L8;
        r2.put(JSON_VERIFY_KEY, 0);     // Catch: JSONException -> L10
    L8:
        r2.put(JSON_TRIGGER_TYPE, r7);     // Catch: JSONException -> L10
    L12:
        r1.put(r2);
        return r1;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static String appendActivityJson(JSONArray r3, Intent r4, String r5, int r6) {
        if (r3 != null) goto L4;
        r3 = new JSONArray();
    L4:
        JSONObject r0 = new JSONObject();
        r0.put(JSON_MASTER_KEY, "activity");     // Catch: JSONException -> L7
        r0.put("intent", r4.toUri(1));     // Catch: JSONException -> L7
        r0.put("appPackageName", r5);     // Catch: JSONException -> L7
        r0.put(JSON_VERIFY_KEY, 1);     // Catch: JSONException -> L7
        r0.put(JSON_TRIGGER_TYPE, r6);     // Catch: JSONException -> L7
        r3.put(r0);     // Catch: JSONException -> L7
    L10:
        return r3.toString();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static String createServiceJson(Intent r0, boolean r1, String r2, int r3) {
        return createServiceJsonArray(r0, r1, r2, r3).toString();
    }

    public static JSONArray createServiceJsonArray(Intent r4, boolean r5, String r6, int r7) {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put(JSON_MASTER_KEY, "service");     // Catch: JSONException -> L9
        int r3 = 1;
        r1.put("intent", r4.toUri(1));     // Catch: JSONException -> L9
        if (r5 == true) goto L7;
        r3 = 0;
    L7:
        r1.put(JSON_VERIFY_KEY, r3);     // Catch: JSONException -> L9
        r1.put("appPackageName", r6);     // Catch: JSONException -> L9
        r1.put(JSON_TRIGGER_TYPE, r7);     // Catch: JSONException -> L9
    L11:
        r0.put(r1);
        return r0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public static String appendServiceJson(JSONArray r3, Intent r4, boolean r5, String r6, int r7) {
        if (r3 != null) goto L4;
        r3 = new JSONArray();
    L4:
        JSONObject r0 = new JSONObject();
        r0.put(JSON_MASTER_KEY, "service");     // Catch: JSONException -> L11
        int r2 = 1;
        r0.put("intent", r4.toUri(1));     // Catch: JSONException -> L11
        if (r5 == true) goto L9;
        r2 = 0;
    L9:
        r0.put(JSON_VERIFY_KEY, r2);     // Catch: JSONException -> L11
        r0.put("appPackageName", r6);     // Catch: JSONException -> L11
        r0.put(JSON_TRIGGER_TYPE, r7);     // Catch: JSONException -> L11
    L13:
        r3.put(r0);
        return r3.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static String createOptionJson(String r1) {
        return createOptionJson(r1, 0);
    }

    public static String createOptionJson(String r0, int r1) {
        return createOptionJsonArray(r0, r1).toString();
    }

    public static JSONArray createOptionJsonArray(String r4, int r5) {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put(JSON_MASTER_KEY, "option");     // Catch: JSONException -> L5
        r1.put(JSON_ACTION_KEY, r4);     // Catch: JSONException -> L5
        r1.put(JSON_TRIGGER_TYPE, r5);     // Catch: JSONException -> L5
    L7:
        r0.put(r1);
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static String appendOptionJson(JSONArray r1, String r2, int r3) {
        return appendOptionJson(r1, r2, null, r3);
    }

    public static String appendOptionJson(JSONArray r3, String r4, String r5, int r6) {
        if (r3 != null) goto L4;
        r3 = new JSONArray();
    L4:
        JSONObject r0 = new JSONObject();
        r0.put(JSON_MASTER_KEY, "option");     // Catch: JSONException -> L10
        r0.put(JSON_ACTION_KEY, r4);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r0.put("appPackageName", r5);     // Catch: JSONException -> L10
        r0.put(JSON_VERIFY_KEY, 1);     // Catch: JSONException -> L10
    L8:
        r0.put(JSON_TRIGGER_TYPE, r6);     // Catch: JSONException -> L10
    L12:
        r3.put(r0);
        return r3.toString();
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static void addDialogParams(JSONObject r1, String r2) {
        r1.put("appPackageName", r2);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "addDialogParams: json error, e:" + e);
    }

    private void addAccessibilityParams(ArrayList<String> r5, String r6) {
        ArrayList r4 = new ArrayList();
        Iterator<String> r0 = r5.iterator();     // Catch: JSONException -> L9
    L5:
        if (r0.hasNext() == false) goto L7;
        JSONArray r2 = new JSONArray(r0.next());     // Catch: JSONException -> L9
        r2.getJSONObject(0).put("category", r6);     // Catch: JSONException -> L9
        r4.add(r2.toString());     // Catch: JSONException -> L9
        goto L5
    L7:
        r5.clear();     // Catch: JSONException -> L9
        r5.addAll(r4);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "addAccessibilityParams: json error, e:" + e);
    }

    private String parseJsonString(CustomExpandableLinearLayout r2, String r3, String r4, int r5) {
        if (r2 != this.mShortcutTools) goto L6;
        handleToolItems(r3, r5);
        return null;
    L6:
        if (r2 != this.mShortcutOperation) goto L9;
        handleOperationItems(r3, r5);
        return null;
    L9:
        if (r2 != this.mShortcutAccessibility) goto L12;
        handleAccessibilityItems(r3, r5);
        return null;
    L12:
        if (r2 != this.mShortcutApplication) goto L19;
        handleApplicationItems(r3, r4);
        return null;
    L19:
        return null;
    }

    private void handleToolItems(String r6, int r7) {
        String[] r0 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.ENGLISH, R.array.phone_case_quick_tools);
        String[] r1 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.SIMPLIFIED_CHINESE, R.array.phone_case_quick_tools);
        String[] r2 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.TRADITIONAL_CHINESE, R.array.phone_case_quick_tools);
        saveItemLabelsJsonString(r6, r0[r7], r1[r7], r2[r7]);
    }

    private void handleOperationItems(String r6, int r7) {
        String[] r0 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.ENGLISH, R.array.phone_case_quick_operation);
        String[] r1 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.SIMPLIFIED_CHINESE, R.array.phone_case_quick_operation);
        String[] r2 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.TRADITIONAL_CHINESE, R.array.phone_case_quick_operation);
        saveItemLabelsJsonString(r6, r0[r7], r1[r7], r2[r7]);
    }

    private void handleAccessibilityItems(String r6, int r7) {
        String[] r0 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.ENGLISH, R.array.phone_case_quick_accessibility);
        String[] r1 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.SIMPLIFIED_CHINESE, R.array.phone_case_quick_accessibility);
        String[] r2 = Utils.getLocalizedStringArrayResources(this.mContext, Locale.TRADITIONAL_CHINESE, R.array.phone_case_quick_accessibility);
        saveItemLabelsJsonString(r6, r0[r7], r1[r7], r2[r7]);
    }

    private void handleApplicationItems(String r8, String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L15;
        return;
    L15:
        Context r2 = this.mContext.createPackageContext(r9, 2);     // Catch: PackageManager.NameNotFoundException -> L12
        PackageManager r3 = this.mContext.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L12
        if (r3 == null) goto L8;
        ApplicationInfo r4 = r3.getApplicationInfo(r9, 8192);     // Catch: PackageManager.NameNotFoundException -> L12
    L9:
        if (r4 == null) goto L17;
        String r5 = Utils.getLocalizedStringResources(r2, Locale.ENGLISH, r4.labelRes);     // Catch: PackageManager.NameNotFoundException -> L12
        String r6 = Utils.getLocalizedStringResources(r2, Locale.SIMPLIFIED_CHINESE, r4.labelRes);     // Catch: PackageManager.NameNotFoundException -> L12
        String r7 = Utils.getLocalizedStringResources(r2, Locale.TRADITIONAL_CHINESE, r4.labelRes);     // Catch: PackageManager.NameNotFoundException -> L12
        saveItemLabelsJsonString(r9, r5, r6, r7);     // Catch: PackageManager.NameNotFoundException -> L12
        saveItemLabelsJsonString(r8, r5, r6, r7);     // Catch: PackageManager.NameNotFoundException -> L12
        OLog.d(TAG, "englishLabel:" + r5 + r7 + r6);     // Catch: PackageManager.NameNotFoundException -> L12
        return;
    L17:
        return;
    L8:
        r4 = null;
    L12:
        e = move-exception;
        OLog.e(TAG, "Can not find " + r9 + " Context: ", e);
    }

    private void saveItemLabelsJsonString(String r3, String r4, String r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put(Constants.APP_LABELS_OF_EN_US, r4);     // Catch: JSONException -> L5
        r0.put(Constants.APP_LABELS_OF_ZH_CN, r5);     // Catch: JSONException -> L5
        r0.put(Constants.APP_LABELS_OF_ZH_TW, r6);     // Catch: JSONException -> L5
    L7:
        this.mShortcutPreference.putString(r3, r0.toString());
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "saveJsonString: json error:" + e);
        goto L7
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PhoneCaseShortcutSettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PhoneCaseShortcutSettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PhoneCaseShortcutSettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PhoneCaseShortcutSettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PhoneCaseShortcutSettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PhoneCaseShortcutSettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
