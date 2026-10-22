package com.android.settings;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SidesKeyOptionsFragment extends BaseFragment {
    private static final String TAG = "SidesKeyOptionsFragment";
    private static final int mIndexLaunchApp = 12;
    private static final int mIndexNewCalendar = 8;
    private static final int mIndexNewNote = 9;
    private static final int mIndexNewRecorder = 10;
    private static final int mIndexQuickPanel = 11;
    private static final int mIndexQuickShot = 6;
    private static final int mIndexQuickShot_screenoff = 1;
    private static final int mIndexScreenShot = 5;
    private static final int mIndexSwitchPrevApp = 7;
    private static final int mIndexTitleWhenScreenOn = 3;
    private static final int mIndexTorch = 2;
    private static final int mIndexUndefined = 0;
    private static final int mIndexUndefinedScreenOn = 4;
    private static final int mIndexVoiceAssistWhenScreenOff = 0;
    private static final int mIndexVoiceAssistWhenScreenOn = 5;
    private static final boolean mVoiceAssistQuickShortEnabled = false;
    private BaseAdapter mAdapter;
    private String mCurrentActivity;
    private String mCurrentAppName;
    private String mCurrentPkg;
    private int mCurrentScreenOffIndex;
    private int mCurrentScreenOnIndex;
    CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private ListView mOptionsList;
    private Resources mResources;
    private List<String> mScreenOnSettingValueList;
    private ArrayList<String> mSidesKeyShortcutScreenOffValues;
    public ArrayList<String> mSidesKeyShortcutTitles;
    private String mSqueezeKeySettingValue;
    private SettingItemSwitch mSwitch;
    private int mUserId;

    class OptionsAdapter extends BaseAdapter {
        final /* synthetic */ SidesKeyOptionsFragment this$0;

        class ViewHolder {
            ImageView arrow;
            ImageView checked;
            RelativeLayout layout;
            TextView subTitle;
            final /* synthetic */ OptionsAdapter this$1;
            TextView title;

            ViewHolder(OptionsAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        OptionsAdapter(SidesKeyOptionsFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (SidesKeyOptionsFragment.access$800(this.this$0).isChecked() == true) goto L7;
            return 0;
        L7:
            return this.this$0.mSidesKeyShortcutTitles.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r9, View r10, ViewGroup r11) {
            if (r10 != null) goto L5;
        L8:
            r10 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.shortcut_dialog_item, r11, false);
            ViewHolder r12 = new ViewHolder(this);
            r12.layout = (RelativeLayout) r10.findViewById(R.id.list_item_layout);
            r12.title = (TextView) r10.findViewById(R.id.text_title);
            r12.checked = (ImageView) r10.findViewById(R.id.item_check);
            r12.subTitle = (TextView) r10.findViewById(R.id.sub_title);
            r12.arrow = (ImageView) r10.findViewById(R.id.icon_arrow);
            r10.setTag(r12);
        L9:
            r12.title.setText(this.this$0.mSidesKeyShortcutTitles.get(r9));
            r12.title.setTextSize(2, 18.0f);
            r12.title.setTextColor(this.this$0.getResources().getColorStateList(R.color.setting_item_text_colorlist));
            r12.title.setPadding(0, 0, 0, 0);
            if (SidesKeyOptionsFragment.access$900(this.this$0) != r9) goto L12;
        L15:
            boolean r1 = true;
        L17:
            if (r9 != 12) goto L19;
            r12.arrow.setDuplicateParentStateEnabled(true);
            r12.arrow.setClickable(false);
            r12.arrow.setImageResource(R.drawable.secletor_setting_item_arrow);
            r12.arrow.setVisibility(0);
        L20:
            ImageView r6 = r12.checked;
            if (r1 == false) goto L23;
            int r2 = 0;
        L24:
            r6.setVisibility(r2);
            if (TextUtils.isEmpty(SidesKeyOptionsFragment.access$1100(this.this$0)) == false) goto L27;
        L29:
            boolean r3 = false;
        L30:
            if (r9 != 12) goto L33;
            if (r3 == false) goto L33;
            r12.subTitle.setVisibility(0);
            r12.subTitle.setText(SidesKeyOptionsFragment.access$200(this.this$0));
        L35:
            if (r9 == 4) goto L57;
            if (r9 == 0) goto L57;
            if (r9 != 1) goto L40;
        L56:
            r12.layout.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_top);
            float r8 = this.this$0.getResources().getDimension(R.dimen.item_block_gap);
        L60:
            int r13 = (int) r8;
        L62:
            r10.setPadding(0, r13, 0, 0);
            return r10;
        L40:
            if (r9 == 5) goto L56;
            if (r9 == 8) goto L56;
            if (r9 != 2) goto L45;
        L55:
            r12.layout.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_bottom);
        L61:
            r13 = 0;
            goto L62
        L45:
            if (r9 == 7) goto L55;
            if (r9 == 11) goto L55;
            if (r9 != 3) goto L52;
            r12.title.setTextAppearance(this.this$0.mContext, R.style.SettingItemTitleStyle);
            r12.checked.setVisibility(8);
            r12.layout.setBackground(null);
            r12.title.setPadding((int) SidesKeyOptionsFragment.access$1200(this.this$0).getDimension(R.dimen.settings_item_title_left_margin), 18, 0, 6);
            goto L61
        L52:
            if (r9 != 12) goto L54;
            r13 = (int) this.this$0.getResources().getDimension(R.dimen.item_block_gap);
            r12.layout.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
            goto L62
        L54:
            r12.layout.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
        L57:
            r12.layout.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
            if (r9 != 4) goto L61;
            r8 = this.this$0.getResources().getDimension(R.dimen.item_block_gap);
        L33:
            r12.subTitle.setVisibility(8);
            goto L35
        L27:
            if (SidesKeyOptionsFragment.access$100(this.this$0) == false) goto L29;
            r3 = true;
            goto L30
        L23:
            r2 = 4;
            goto L24
        L19:
            r12.arrow.setVisibility(8);
            goto L20
        L12:
            if (SidesKeyOptionsFragment.access$1000(this.this$0) == r9) goto L15;
            r1 = false;
            goto L17
        L5:
            if ((r10.getTag() instanceof ViewHolder) == false) goto L8;
            r12 = (ViewHolder) r10.getTag();
            goto L9
        }
    }

    static {
    }

    public void com_android_settings_SidesKeyOptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_SidesKeyOptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SidesKeyOptionsFragment() {
        this.mScreenOnSettingValueList = new ArrayList();
        this.mOnCheckedChangeListener = new AnonymousClass2(this);
    }

    static /* synthetic */ ArrayList access$000(SidesKeyOptionsFragment r0) {
        return r0.mSidesKeyShortcutScreenOffValues;
    }

    static /* synthetic */ boolean access$100(SidesKeyOptionsFragment r0) {
        return r0.isQuickLaunchApp();
    }

    static /* synthetic */ int access$1000(SidesKeyOptionsFragment r0) {
        return r0.mCurrentScreenOffIndex;
    }

    static /* synthetic */ String access$1100(SidesKeyOptionsFragment r0) {
        return r0.mSqueezeKeySettingValue;
    }

    static /* synthetic */ Resources access$1200(SidesKeyOptionsFragment r0) {
        return r0.mResources;
    }

    static /* synthetic */ String access$200(SidesKeyOptionsFragment r0) {
        return r0.mCurrentAppName;
    }

    static /* synthetic */ String access$300(SidesKeyOptionsFragment r0) {
        return r0.mCurrentPkg;
    }

    static /* synthetic */ String access$400(SidesKeyOptionsFragment r0) {
        return r0.mCurrentActivity;
    }

    static /* synthetic */ int access$500(SidesKeyOptionsFragment r0) {
        return r0.mUserId;
    }

    static /* synthetic */ List access$600(SidesKeyOptionsFragment r0) {
        return r0.mScreenOnSettingValueList;
    }

    static /* synthetic */ BaseAdapter access$700(SidesKeyOptionsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SettingItemSwitch access$800(SidesKeyOptionsFragment r0) {
        return r0.mSwitch;
    }

    static /* synthetic */ int access$900(SidesKeyOptionsFragment r0) {
        return r0.mCurrentScreenOnIndex;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.options_layout, r3, false);
        this.mOptionsList = (ListView) findViewByIdNullable(R.id.options_list);
        this.mSwitch = new SettingItemSwitch(this.mContext);
        View r5 = requireActivity().getLayoutInflater().inflate(R.layout.side_keys_header, null, false);
        this.mSwitch = (SettingItemSwitch) r5.findViewById(R.id.enabled_switch);
        if (isSqueezeUpkeyEnabled() == false) goto L5;
        this.mSwitch.setTitle(R.string.enable_squeeze_down_side_key);
    L6:
        this.mOptionsList.addHeaderView(r5);
        View r6 = Utils.inflateListTransparentHeader(this.mContext);
        this.mOptionsList.addFooterView(r6);
        this.mResources = getResources();
        this.mSidesKeyShortcutTitles = buildTitleArray(this.mContext);
        this.mSidesKeyShortcutScreenOffValues = buildShortcutScreenOffValueArray();
        buildShortcutScreenOnValueList();
        loadCurrentValueIndex();
        OptionsAdapter r7 = new OptionsAdapter(this);
        this.mAdapter = r7;
        this.mOptionsList.setAdapter(r7);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        return this.mRootView;
    L5:
        this.mSwitch.setTitle(R.string.side_keys_enabled);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mSwitch.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        if (isSqueezeUpkeyEnabled() == false) goto L5;
        return R.string.squeeze_down_side_buttons;
    L5:
        return R.string.squeeze_side_buttons;
    }

    private boolean isSqueezeUpkeyEnabled() {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "squeeze_up_side_buttons_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public void updateViews() {
        checkAppInfo();
        loadCurrentValueIndex();
        boolean r2 = true;
        int r1 = 0;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "squeeze_side_buttons_enabled", 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mSwitch.setChecked(r2);
        View r0 = findViewByIdNullable(R.id.when_screen_off_title);
        if (r2 == true) goto L10;
        r1 = 8;
    L10:
        r0.setVisibility(r1);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r2 != RESULT_OK) goto L7;
        if (r3 == null) goto L8;
        this.mCurrentAppName = r3.getStringExtra("app_name");
        this.mCurrentPkg = r3.getStringExtra("package_name");
        this.mCurrentActivity = r3.getStringExtra(PickApplicationActivity.EXTRA_ACTIVITY_NAME);
        this.mUserId = r3.getIntExtra(PickApplicationActivity.EXTRA_USER, UserHandle.myUserId());
        this.mSqueezeKeySettingValue = this.mCurrentPkg + LibrarianImpl.Constants.SEPARATOR + this.mCurrentActivity + LibrarianImpl.Constants.SEPARATOR + this.mUserId;
        android.provider.Settings.Global.putString(getContentResolver(), "squeeze_side_buttons", this.mSqueezeKeySettingValue);
        this.mAdapter.notifyDataSetChanged();
        return;
    L8:
        return;
    }

    public void checkAppInfo() {
        if (TextUtils.isEmpty(this.mSqueezeKeySettingValue) == false) goto L6;
        this.mCurrentActivity = null;
        this.mCurrentPkg = null;
        this.mCurrentAppName = null;
        return;
    L6:
        String[] r2 = this.mSqueezeKeySettingValue.split("\\/");
        if (r2.length <= 1) goto L28;
        this.mCurrentPkg = r2[0];
        this.mCurrentActivity = r2[1];
        if (r2.length != 3) goto L11;
        this.mUserId = Integer.parseInt(r2[2]);
    L26:
        PackageManager r3 = getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L22
        ComponentName r4 = new ComponentName(this.mCurrentPkg, this.mCurrentActivity);     // Catch: PackageManager.NameNotFoundException -> L22
        this.mCurrentAppName = r3.getActivityInfo(r4, 32).loadLabel(r3).toString();     // Catch: PackageManager.NameNotFoundException -> L22
        if (this.mUserId != 10) goto L29;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: PackageManager.NameNotFoundException -> L22
        return;
    L16:
        if (AppGlobals.getPackageManager().getActivityInfo(r4, 32, this.mUserId) != null) goto L30;
        this.mCurrentActivity = null;     // Catch: RemoteException -> L19 PackageManager.NameNotFoundException -> L22
        this.mCurrentPkg = null;     // Catch: RemoteException -> L19 PackageManager.NameNotFoundException -> L22
        this.mCurrentAppName = null;     // Catch: RemoteException -> L19 PackageManager.NameNotFoundException -> L22
        android.provider.Settings.Global.putString(getContentResolver(), "squeeze_side_buttons", "screenshot");     // Catch: RemoteException -> L19 PackageManager.NameNotFoundException -> L22
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L22:
        this.mCurrentActivity = null;
        this.mCurrentPkg = null;
        this.mCurrentAppName = null;
        android.provider.Settings.Global.putString(getContentResolver(), "squeeze_side_buttons", "screenshot");
        return;
    L11:
        this.mUserId = UserHandle.myUserId();
        goto L26
    }

    public static ArrayList<String> buildShortcutScreenOffValueArray() {
        ArrayList<String> r0 = Lists.newArrayList();
        r0.add(null);
        r0.add("quick_shot");
        r0.add("torch");
        return r0;
    }

    public static ArrayList<String> buildTitleArray(Context r4) {
        ArrayList<String> r0 = Lists.newArrayList();
        r0.add(r4.getString(R.string.undefined));
        r0.add(r4.getString(R.string.quick_shot));
        r0.add(r4.getString(R.string.launch_torch));
        r0.add(r4.getString(R.string.side_keys_screen_on));
        r0.add(r4.getString(R.string.undefined));
        r0.add(r4.getString(R.string.screenshot));
        r0.add(r4.getString(R.string.quick_shot));
        r0.add(r4.getString(R.string.switch_to_prev_app));
        r0.add(r4.getString(R.string.new_calendar_task));
        r0.add(r4.getString(R.string.new_note));
        r0.add(r4.getString(R.string.new_record));
        r0.add(r4.getString(R.string.side_keys_quick_launch_pad));
        r0.add(r4.getString(R.string.launch_app));
        return r0;
    }

    private void buildShortcutScreenOnValueList() {
        this.mScreenOnSettingValueList.add("screenshot");
        this.mScreenOnSettingValueList.add("quick_shot");
        this.mScreenOnSettingValueList.add("quick_launch_previous_app");
        this.mScreenOnSettingValueList.add("new_calendar_task");
        this.mScreenOnSettingValueList.add("new_note");
        this.mScreenOnSettingValueList.add("new_voice_record");
        this.mScreenOnSettingValueList.add("quick_launch_pad");
    }

    public void loadCurrentValueIndex() {
        this.mSqueezeKeySettingValue = android.provider.Settings.Global.getString(getContentResolver(), "squeeze_side_buttons");
        String r0 = android.provider.Settings.Global.getString(getContentResolver(), "squeeze_side_buttons_screen_off");
        this.mCurrentScreenOnIndex = getListIndexFromValue(this.mSqueezeKeySettingValue, true);
        this.mCurrentScreenOffIndex = getListIndexFromValue(r0, false);
    }

    private int getListIndexFromValue(String r3, boolean r4) {
        if (r4 == false) goto L20;
        if (r3 != null) goto L7;
        return 4;
    L7:
        if ("quick_launch_pad".equals(r3) == false) goto L11;
        return 11;
    L11:
        if (r3.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L14;
        return 12;
    L14:
        int r2 = this.mScreenOnSettingValueList.indexOf(r3);
        if (r2 != (-1)) goto L17;
        return 4;
    L17:
        return (r2 + 4) + 1;
    L20:
        if (r3 != null) goto L22;
        return 0;
    L22:
        int r0 = 0;
    L24:
        if (r0 >= this.mSidesKeyShortcutScreenOffValues.size()) goto L29;
        if (r3.equals(this.mSidesKeyShortcutScreenOffValues.get(r0)) == true) goto L27;
        r0 = r0 + 1;
        goto L24
    L27:
        return r0;
    L29:
        OLog.w(TAG, "this should won't happen~");
        return 0;
    }

    private boolean isQuickLaunchApp() {
        String r1 = this.mSqueezeKeySettingValue;
        if (r1 != null) goto L6;
        return false;
    L6:
        return r1.contains(LibrarianImpl.Constants.SEPARATOR);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SidesKeyOptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SidesKeyOptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SidesKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SidesKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SidesKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SidesKeyOptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
