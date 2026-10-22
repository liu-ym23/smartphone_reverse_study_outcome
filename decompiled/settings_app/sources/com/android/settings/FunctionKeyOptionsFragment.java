package com.android.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.api.SettingsSmt;
import com.android.settings.base.BaseFragment;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.stickylistheaders.StickyListHeadersListView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionKeyOptionsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private static final int CATEGORY_CLICK_SMART_KEY = 1;
    private static final int CATEGORY_SCREEN_OFF = 3;
    private static final int CATEGORY_SCREEN_ON = 2;
    private static final int DIALOG_TYPE_OCR = 1;
    public static final String EXTRA_TYPE_HARDWARE_KEY = "extra_type_hardware_key";
    public static final int TYPE_SMART_KEY_AND_POWER = 2;
    public static final int TYPE_SMART_KEY_AND_VOLUME_DOWN = 4;
    public static final int TYPE_SMART_KEY_AND_VOLUME_UP = 3;
    private static final int VIEW_TYPE_COMMON = 1;
    private static final int VIEW_TYPE_INTRO_IMAGE = 3;
    private static final int VIEW_TYPE_TIPS = 2;
    private OptionsAdapter mAdapter;
    private AlertDialog mDialog;
    private List<FunctionItem> mFunctionList;
    private boolean mIsOCREnabled;
    private boolean mIsSideBarChecked;
    private boolean mIsSideBarSupport;
    private boolean mIsVoiceCommandEnable;
    private boolean mItemEnabled;
    private StickyListHeadersListView mOptionsList;
    private String mSwitchKey;
    private SettingItemSwitch mSwitcher;
    private int mType;

    private class FunctionItem {
        public int background;
        public int bgStyle;
        public int category;
        public String settingsValue;
        final /* synthetic */ FunctionKeyOptionsFragment this$0;
        public int titleResId;
        public int viewType;

        private FunctionItem(FunctionKeyOptionsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FunctionItem(FunctionKeyOptionsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    class OptionsAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
        private LayoutInflater mLayoutInflater;
        final /* synthetic */ FunctionKeyOptionsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return null;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public OptionsAdapter(FunctionKeyOptionsFragment r1, Context r2) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (FunctionKeyOptionsFragment.access$1200(this.this$0).isChecked() == true) goto L7;
            return 0;
        L7:
            return FunctionKeyOptionsFragment.access$300(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public FunctionItem getItem(int r1) {
            return (FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return ((FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r1)).viewType;
        }

        @Override // android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            int r8 = getItemViewType(r5);
            boolean r0 = true;
            if (r6 != null) goto L9;
            ViewHolder r1 = new ViewHolder(this.this$0);
            if (r8 != 1) goto L7;
            r6 = View.inflate(this.this$0.mContext, R.layout.list_content_item_check, null);
            r1.mItemCheck = (SettingItemCheck) r6.findViewById(R.id.item_check);
        L8:
            r6.setTag(r1);
        L10:
            FunctionItem r9 = (FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r5);
            if (r8 != 1) goto L13;
            SettingItemCheck r10 = r1.mItemCheck;
            r10.setTitle(r9.titleResId);
            r10.setEnabled(FunctionKeyOptionsFragment.access$200(this.this$0));
            r10.setChecked(FunctionKeyOptionsFragment.access$1300(this.this$0, r9));
            r10.setBackgroundStyle(r9.bgStyle);
            if (r9.bgStyle != 4) goto L22;
        L25:
            setupItemViewBottomGap(r6, r0);
        L26:
            return r6;
        L22:
            if (r9.bgStyle == 1) goto L25;
            r0 = false;
            goto L25
        L13:
            if (r8 != 2) goto L15;
            r1.tipsView.setText(r9.titleResId);
            r1.tipsEmptyView.setVisibility(0);
            setupItemViewTopGap(r6, true);
            goto L26
        L15:
            if (r8 != 3) goto L26;
            r1.introImage.setImageResource(r9.background);
            goto L26
        L7:
            r6 = bindViewHolder(r1, r6, r8);
            goto L8
        L9:
            r1 = (ViewHolder) r6.getTag();
            goto L10
        }

        private void setupItemViewBottomGap(View r2, boolean r3) {
            if (r3 == false) goto L5;
            r2.setPadding(0, 0, 0, this.this$0.mContext.getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin));
            return;
        L5:
            r2.setPadding(0, 0, 0, 0);
        }

        private void setupItemViewTopGap(View r2, boolean r3) {
            if (r3 == false) goto L5;
            r2.setPadding(0, this.this$0.mContext.getResources().getDimensionPixelSize(R.dimen.settings_item_header_tips_margin_top), 0, 0);
            return;
        L5:
            r2.setPadding(0, 0, 0, 0);
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r4) {
            int r0 = 0;
        L4:
            if (r0 >= FunctionKeyOptionsFragment.access$300(this.this$0).size()) goto L11;
            if (((FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r0)).category != r4) goto L10;
            if (((FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r0)).viewType != 1) goto L10;
            return r0;
        L10:
            r0 = r0 + 1;
            goto L4
        L11:
            return -1;
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return ((FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r1)).category;
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
        L5:
            r4 = this.mLayoutInflater.inflate(R.layout.header_text_layout, null);
            TextView r6 = (TextView) r4.findViewById(R.id.header_text);
            r4.findViewById(R.id.empty_head).setVisibility(8);
            r4.setTag(r6);
        L6:
            TextView r7 = (TextView) r4.getTag();
            int r8 = getSectionForPosition(r3);
            r7.setText(FunctionKeyOptionsFragment.access$1400(this.this$0, r8));
            return r4;
        L4:
            if (r4.getTag() != null) goto L6;
            goto L5
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r1) {
            return ((FunctionItem) FunctionKeyOptionsFragment.access$300(this.this$0).get(r1)).category;
        }

        private View bindViewHolder(ViewHolder r4, View r5, int r6) {
            if (r6 != 2) goto L5;
            r5 = this.mLayoutInflater.inflate(R.layout.tips_layout, null, false);
        L9:
            r4.layout = (RelativeLayout) r5.findViewById(R.id.list_item_layout);
            r4.title = (TextView) r5.findViewById(R.id.text_title);
            r4.checked = (ImageView) r5.findViewById(R.id.item_check);
            r4.subTitle = (TextView) r5.findViewById(R.id.sub_title);
            r4.arrow = (ImageView) r5.findViewById(R.id.icon_arrow);
            r4.introImage = (ImageView) r5.findViewById(R.id.intro_image);
            r4.tipsView = (TextView) r5.findViewById(R.id.tips);
            r4.tipsEmptyView = r5.findViewById(R.id.item_shadow);
            r4.viewType = r6;
            return r5;
        L5:
            if (r6 != 3) goto L9;
            r5 = this.mLayoutInflater.inflate(R.layout.intro_image_layout, null, false);
            goto L9
        }
    }

    class ViewHolder {
        ImageView arrow;
        ImageView checked;
        ImageView introImage;
        RelativeLayout layout;
        SettingItemCheck mItemCheck;
        TextView subTitle;
        final /* synthetic */ FunctionKeyOptionsFragment this$0;
        View tipsEmptyView;
        TextView tipsView;
        TextView title;
        int viewType;

        ViewHolder(FunctionKeyOptionsFragment r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_settings_FunctionKeyOptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_FunctionKeyOptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FunctionKeyOptionsFragment() {
        this.mFunctionList = new ArrayList();
        this.mItemEnabled = true;
    }

    static /* synthetic */ StickyListHeadersListView access$000(FunctionKeyOptionsFragment r0) {
        return r0.mOptionsList;
    }

    static /* synthetic */ String access$100(FunctionKeyOptionsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ AlertDialog access$1100(FunctionKeyOptionsFragment r0) {
        return r0.mDialog;
    }

    static /* synthetic */ SettingItemSwitch access$1200(FunctionKeyOptionsFragment r0) {
        return r0.mSwitcher;
    }

    static /* synthetic */ boolean access$1300(FunctionKeyOptionsFragment r0, FunctionItem r1) {
        return r0.isSelected(r1);
    }

    static /* synthetic */ int access$1400(FunctionKeyOptionsFragment r0, int r1) {
        return r0.getCategoryTitleResId(r1);
    }

    static /* synthetic */ boolean access$200(FunctionKeyOptionsFragment r0) {
        return r0.mItemEnabled;
    }

    static /* synthetic */ List access$300(FunctionKeyOptionsFragment r0) {
        return r0.mFunctionList;
    }

    static /* synthetic */ String access$400(FunctionKeyOptionsFragment r0, int r1) {
        return r0.getSettingsKey(r1);
    }

    static /* synthetic */ boolean access$500(FunctionKeyOptionsFragment r0) {
        return r0.mIsOCREnabled;
    }

    static /* synthetic */ void access$600(FunctionKeyOptionsFragment r0, int r1) {
        r0.showWarning(r1);
    }

    static /* synthetic */ void access$700(FunctionKeyOptionsFragment r0, String r1, FunctionItem r2) {
        r0.updateTorchIfNeed(r1, r2);
    }

    static /* synthetic */ String access$800(FunctionKeyOptionsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$900(FunctionKeyOptionsFragment r0) {
        r0.updateItems();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.sticky_options_list_layout, r3, false);
        this.mOptionsList = (StickyListHeadersListView) findViewByIdNullable(R.id.options_list);
        this.mType = getArguments().getInt(EXTRA_TYPE_HARDWARE_KEY);
        this.mIsSideBarChecked = "side_bar".equals(android.provider.Settings.Global.getString(getContentResolver(), "squeeze_side_buttons"));
        this.mIsSideBarSupport = SettingsFeature.isSupportOneStep(this.mContext);
        boolean r5 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_command_state", 0) != 1) goto L5;
        boolean r6 = true;
    L6:
        this.mIsVoiceCommandEnable = r6;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "accessibility_global_ocr", 0) == 1) goto L10;
        r5 = false;
    L10:
        this.mIsOCREnabled = r5;
        initData();
        addHeaderFooterView();
        this.mAdapter = new OptionsAdapter(this, requireActivity());
        StickyListHeadersListView r7 = this.mOptionsList;
        if (r7 == null) goto L14;
        r7.setAreHeadersSticky(false);
        this.mOptionsList.setAdapter(this.mAdapter);
        this.mOptionsList.setOnItemClickListener(new AnonymousClass1(this));
        this.mOptionsList.setWrapClipChildren(false);
    L14:
        return this.mRootView;
    L5:
        r6 = false;
        goto L6
    }

    private void updateTorchIfNeed(String r2, FunctionItem r3) {
        if ("squeeze_side_up_buttons".equals(r2) == true) goto L5;
        return;
    L5:
        if ("text_recognition".equals(r3.settingsValue) == false) goto L7;
        android.provider.Settings.Global.putString(getContentResolver(), "squeeze_side_up_buttons_screen_off", null);
        return;
    L7:
        android.provider.Settings.Global.putString(getContentResolver(), "squeeze_side_up_buttons_screen_off", r3.settingsValue);
    }

    private String getSettingsKey(int r6) {
        int r0 = this.mType;
        String r2 = null;
        if (r0 != 2) goto L5;
        if (r6 != 2) goto L21;
        r2 = "squeeze_with_power_function";
    L21:
        OLog.d(this.TAG, "getSettingsKey, type " + this.mType + " key " + r2);
        if (r2 != null) goto L24;
        finish();
    L24:
        return r2;
    L5:
        if (r0 != 3) goto L7;
        if (r6 != 2) goto L21;
        r2 = "squeeze_side_up_buttons";
        goto L21
    L7:
        if (r0 != 4) goto L21;
        if (r6 == 2) goto L13;
        if (r6 != 3) goto L21;
        String r7 = "squeeze_side_buttons_screen_off";
    L14:
        r2 = r7;
        goto L21
    L13:
        r7 = "squeeze_side_buttons";
        goto L14
    }

    private int getCategoryTitleResId(int r5) {
        int r4 = this.mType;
        if (r4 != 2) goto L5;
        if (r5 != 2) goto L27;
        return R.string.smart_key_and_power_key_when_screen_on;
    L27:
        return 0;
    L5:
        if (r4 != 3) goto L7;
        if (r5 != 2) goto L26;
        return R.string.smart_key_and_volume_up;
    L26:
        return 0;
    L7:
        if (r4 != 4) goto L24;
        if (r5 == 2) goto L13;
        if (r5 != 3) goto L25;
        int r6 = R.string.smart_key_and_vol_down_screen_off_voice_command;
    L22:
        return r6;
    L25:
        return 0;
    L13:
        r6 = R.string.smart_key_and_volume_down_when_screen_on;
        goto L22
    L24:
        return 0;
    }

    private boolean isSelected(FunctionItem r2) {
        String r0 = getSettingsKey(r2.category);
        String r1 = android.provider.Settings.Global.getString(getContentResolver(), r0);
        return TextUtils.equals(r2.settingsValue, r1);
    }

    private void initData() {
        int r0 = this.mType;
        if (r0 != 2) goto L5;
        this.mTitleResId = Integer.valueOf(R.string.smart_key_and_power_title);
        this.mSwitchKey = "squeeze_with_power_enabled";
        addFunctionItem(2, 1, R.string.undefined, SettingsSmt.SHORTCUT_KEY_VALUE.NONE, 0, 2);
        addFunctionItem(2, 1, R.string.screenshot, "screenshot", 0, 4);
        return;
    L5:
        if (r0 == 3) goto L34;
        if (r0 == 4) goto L8;
        finish();
        return;
    L8:
        this.mTitleResId = Integer.valueOf(R.string.smart_key_with_volume_down_title);
        this.mSwitchKey = "squeeze_side_buttons_enabled";
        String r5 = SettingsSmt.SHORTCUT_KEY_VALUE.NONE;
        if ((this.mIsVoiceCommandEnable | this.mIsSideBarSupport) == false) goto L11;
        int r9 = 2;
    L12:
        addFunctionItem(2, 1, R.string.undefined, r5, 0, r9);
        if (this.mIsVoiceCommandEnable == false) goto L20;
        if (this.mIsSideBarSupport == false) goto L17;
        int r6 = 3;
    L18:
        addFunctionItem(2, 1, R.string.voice_command_speaking, "voice_command", 0, r6);
        goto L20
    L17:
        r6 = 4;
    L20:
        if (this.mIsSideBarSupport == false) goto L23;
        addFunctionItem(2, 1, R.string.short_launch_one_step, "side_bar", 0, 4);
    L23:
        if (this.mIsSideBarSupport == false) goto L32;
        if (this.mIsSideBarChecked == false) goto L32;
        if (SettingsFeature.isSupportNewOneStep() == false) goto L29;
        int r1 = R.drawable.setting_shortcut_onestep_new;
    L30:
        addFunctionItem(2, 3, 0, null, r1, 0);
        addFunctionItem(2, 2, R.string.shortcut_key_one_step_tips, null, 0, 0);
        goto L32
    L29:
        r1 = R.drawable.setting_shortcut_onestep;
    L32:
        if (this.mIsVoiceCommandEnable == false) goto L44;
        addFunctionItem(3, 1, R.string.undefined, SettingsSmt.SHORTCUT_KEY_VALUE.NONE, 0, 2);
        addFunctionItem(3, 1, R.string.voice_command_speaking, "voice_command", 0, 4);
        return;
    L44:
        return;
    L11:
        r9 = 1;
        goto L12
    L34:
        this.mTitleResId = Integer.valueOf(R.string.smart_key_with_volume_up_title);
        this.mSwitchKey = "squeeze_up_side_buttons_enabled";
        addFunctionItem(2, 1, R.string.undefined, SettingsSmt.SHORTCUT_KEY_VALUE.NONE, 0, 2);
        if (this.mIsOCREnabled == false) goto L37;
        int r7 = 3;
    L38:
        addFunctionItem(2, 1, R.string.launch_torch, "torch", 0, r7);
        if (this.mIsOCREnabled == false) goto L46;
        addFunctionItem(2, 1, R.string.accessibility_global_ocr, "text_recognition", 0, 4);
        return;
    L46:
        return;
    L37:
        r7 = 4;
        goto L38
    }

    private void addFunctionItem(int r3, int r4, int r5, String r6, int r7, int r8) {
        FunctionItem r0 = new FunctionItem(this, null);
        r0.category = r3;
        r0.viewType = r4;
        r0.titleResId = r5;
        r0.background = r7;
        r0.settingsValue = r6;
        r0.bgStyle = r8;
        this.mFunctionList.add(r0);
    }

    private void addHeaderFooterView() {
        View r0 = requireActivity().getLayoutInflater().inflate(R.layout.switcher_view_header, null, false);
        this.mSwitcher = (SettingItemSwitch) r0.findViewById(R.id.enabled_switch);
        if (this.mTitleResId == null) goto L5;
        this.mSwitcher.setTitle(getResources().getString(R.string.enable_key_of, new Object[]{getString(this.mTitleResId.intValue())}));
    L5:
        this.mSwitcher.setOnCheckedChangeListener(this);
        this.mOptionsList.addHeaderView(r0);
        this.mOptionsList.addFooterView(Utils.inflateListTransparentHeader(this.mContext));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public void updateViews() {
        updateItems();
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), this.mSwitchKey, 1) == 1) goto L6;
        r2 = false;
    L6:
        this.mSwitcher.setChecked(r2);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateItems() {
        this.mIsSideBarChecked = "side_bar".equals(android.provider.Settings.Global.getString(getContentResolver(), "squeeze_side_buttons"));
        this.mIsSideBarSupport = SettingsFeature.isSupportOneStep(this.mContext);
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "voice_command_state", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mIsVoiceCommandEnable = r0;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "accessibility_global_ocr", 0) != 1) goto L9;
        r2 = true;
    L9:
        this.mIsOCREnabled = r2;
        this.mFunctionList.clear();
        initData();
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (this.mSwitcher.getSwitch() != r2) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), this.mSwitchKey, r3 ? 1 : 0);
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    private void showWarning(int r3) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showWarning, activity is null, return");
        return;
    L6:
        AlertDialog.Builder r1 = new AlertDialog.Builder(r0);
        if (r3 != 1) goto L11;
        r1.setTitle(R.string.dlg_title_notice);
        r1.setMessage(R.string.enable_global_ocr_tips);
        r1.setPositiveButton(R.string.goto_enable, new AnonymousClass2(this));
        r1.setNegativeButton(android.R.string.cancel, new AnonymousClass3(this));
        r1.setOnCancelListener(new AnonymousClass4(this));
        AlertDialog r4 = r1.create();
        this.mDialog = r4;
        r4.show();
        return;
    L11:
        throw new IllegalArgumentException("dialog type is invalidate");
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FunctionKeyOptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FunctionKeyOptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FunctionKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FunctionKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FunctionKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FunctionKeyOptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
