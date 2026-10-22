package com.android.settings;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.api.TextViewSmt;
import bytedanceos.util.SettingsUtil;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class OneHandModeSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, VerticalOptionsCheckView.OptionSelectListener {
    public static final int BACK_ON_LEFT_SIDE = 0;
    public static final int BACK_ON_RIGHT_SIDE = 1;
    private static final int[] GESTURE_NAVBAR_LAYOUT_RES = null;
    public static final int HAND_MODE_CENTER = 2;
    public static final int HAND_MODE_LEFT = 0;
    public static final int HAND_MODE_RIGHT = 1;
    private static final String KEY_HARDWARE_BUTTONS = "hardware_buttons";
    private static final String KEY_VOLUME_KEY = "volume_key";
    private static final int[] NORMAL_NAVBAR_LAYOUT_PLUS_RES = null;
    private static final int[] NORMAL_NAVBAR_LAYOUT_POINT_RES = null;
    private static final int[] NORMAL_NAVBAR_LAYOUT_RES = null;
    private static final int[] STICKER_NAVBAR_LAYOUT_RES = null;
    private static final int[] VIRTUAL_KEY_LAYOUT_RES = null;
    private VerticalOptionsCheckView.OptionSelectListener dockerCheckListener;
    boolean isFirst;
    private HandSwitchAdapter mAdapter;
    private PreviewSettingItemView mClassicKeypadMode;
    private int[] mCurrentModeList;
    private int mCurrentNavbarKeyStyle;
    private ArrayList<ListOptionDataMode> mDatas;
    private VerticalOptionsCheckView mDockFlipView;
    private int mGestureNavbarPreviewHeight;
    private ListView mHandSwitchSettingList;
    private PreviewSettingItemView mImproveKeypadMode;
    private boolean mIsSmartScreenEnabled;
    private boolean mIsSupportNavbar;
    private SettingItemCheck mItemLeftHand;
    private SettingItemCheck mItemRightHand;
    private int mLauncherMode;
    private TextView mLeftBack;
    private TextView mLeftHome;
    RelativeLayout.LayoutParams mLeftKeyLParams;
    RelativeLayout.LayoutParams mLeftKeyRParams;
    private TextView mLeftMenu;
    private SettingItemText mMenuMoveDownItem;
    RelativeLayout.LayoutParams mMiddleKeyLParams;
    RelativeLayout.LayoutParams mMiddleKeyRParams;
    private int mMultiBlockMode;
    private VerticalOptionsCheckView mNavbarOneHandModeView;
    private int mNavbarTriggerMode;
    private int mNormalNavbarPreviewHeight;
    private int mOriPreviewSelected;
    private SettingItemSwitch mPulldownWallpaperSwitch;
    private TextView mRightBack;
    private TextView mRightHome;
    RelativeLayout.LayoutParams mRightKeyLParams;
    RelativeLayout.LayoutParams mRightKeyRParams;
    private TextView mRightMenu;
    private FrameLayout mThumbDropdown;
    private TextView mThumbPullScreenDownTitle;
    private SettingItemSwitch mThumbPushDownSwitch;
    private View mThumbTriggerAreaLayout;
    private SettingItemText mThumbTriggerAreaOption;
    private TextView mThumbTriggerSwitchTips;
    private int mTitleRes;
    private int mVirtualKeyPreviewHeight;

    class HandSwitchAdapter extends BaseAdapter {
        final /* synthetic */ OneHandModeSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        HandSwitchAdapter(OneHandModeSettingsFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return OneHandModeSettingsFragment.access$000(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r10, View r11, ViewGroup r12) {
            if (r11 != null) goto L4;
            r11 = (LinearLayout) LayoutInflater.from(this.this$0.mContext).inflate(R.layout.one_hand_settings_item_layout, null);
            ViewHolder r13 = new ViewHolder();
            r13.leftPreview = (PreviewSettingItemView) r11.findViewById(R.id.item_preview_left);
            r13.rightPreview = (PreviewSettingItemView) r11.findViewById(R.id.item_preview_right);
            r13.itemTitle = (TextView) r11.findViewById(R.id.text_item_title);
            TextViewSmt.getInstance().setMaxTextSize(r13.itemTitle, this.this$0.getResources().getDimensionPixelOffset(R.dimen.keypad_mode_text_maxsize));
            r13.previewlayout = (LinearLayout) r11.findViewById(R.id.one_hand_preview);
            r11.setTag(r13);
        L5:
            if (r10 == 0) goto L7;
        L12:
            ListOptionDataMode r0 = (ListOptionDataMode) OneHandModeSettingsFragment.access$000(this.this$0).get(r10);
            r13.leftPreview.setOnClickListener(this.this$0);
            r13.rightPreview.setOnClickListener(this.this$0);
            r13.leftPreview.setTag(Integer.valueOf(r10));
            r13.rightPreview.setTag(Integer.valueOf(r10));
            r13.leftPreview.setPreview(this.this$0.getResources().getDrawable(r0.leftIconRes));
            r13.rightPreview.setPreview(this.this$0.getResources().getDrawable(r0.rightIconRes));
            r13.previewlayout.setBackground(this.this$0.getResources().getDrawable(R.drawable.one_hand_preview_bg_2));
            updateState(r10, r13.leftPreview, r13.rightPreview);
            r13.itemTitle.setText(r0.titleRes);
            return r11;
        L7:
            if (OneHandModeSettingsFragment.KEY_HARDWARE_BUTTONS.equals(((ListOptionDataMode) OneHandModeSettingsFragment.access$000(this.this$0).get(r10)).key) == false) goto L12;
            if (this.this$0.isFirst == false) goto L11;
            this.this$0.isFirst = false;
            r13.leftPreview.addView(OneHandModeSettingsFragment.access$100(this.this$0));
            r13.leftPreview.addView(OneHandModeSettingsFragment.access$200(this.this$0));
            r13.leftPreview.addView(OneHandModeSettingsFragment.access$300(this.this$0));
            r13.rightPreview.addView(OneHandModeSettingsFragment.access$400(this.this$0));
            r13.rightPreview.addView(OneHandModeSettingsFragment.access$500(this.this$0));
            r13.rightPreview.addView(OneHandModeSettingsFragment.access$600(this.this$0));
        L11:
            Resources r1 = this.this$0.getResources();
            int r2 = (int) r1.getDimension(R.dimen.onehand_pic_leftkey_margin_left);
            int r3 = (int) r1.getDimension(R.dimen.onehand_pic_rightkey_margin_left);
            int r4 = (int) r1.getDimension(R.dimen.onehand_pic_middlekey_margin_left);
            int r5 = (int) r1.getDimension(R.dimen.onehand_pic_leftkey_margin_top);
            int r6 = (int) r1.getDimension(R.dimen.onehand_pic_middlekey_margin_top);
            float r7 = r2;
            this.this$0.mLeftKeyLParams.setMargins((int) (r7 - (caculateTextWidth(OneHandModeSettingsFragment.access$100(this.this$0)) / 2.0f)), r5, 0, 0);
            OneHandModeSettingsFragment.access$100(this.this$0).setLayoutParams(this.this$0.mLeftKeyLParams);
            float r8 = r3;
            this.this$0.mRightKeyLParams.setMargins((int) (r8 - (caculateTextWidth(OneHandModeSettingsFragment.access$200(this.this$0)) / 2.0f)), r5, 0, 0);
            OneHandModeSettingsFragment.access$200(this.this$0).setLayoutParams(this.this$0.mRightKeyLParams);
            float r9 = r4;
            this.this$0.mMiddleKeyLParams.setMargins((int) (r9 - (caculateTextWidth(OneHandModeSettingsFragment.access$300(this.this$0)) / 2.0f)), r6, 0, 0);
            OneHandModeSettingsFragment.access$300(this.this$0).setLayoutParams(this.this$0.mMiddleKeyLParams);
            this.this$0.mLeftKeyRParams.setMargins((int) (r7 - (caculateTextWidth(OneHandModeSettingsFragment.access$400(this.this$0)) / 2.0f)), r5, 0, 0);
            OneHandModeSettingsFragment.access$400(this.this$0).setLayoutParams(this.this$0.mLeftKeyRParams);
            this.this$0.mRightKeyRParams.setMargins((int) (r8 - (caculateTextWidth(OneHandModeSettingsFragment.access$500(this.this$0)) / 2.0f)), r5, 0, 0);
            OneHandModeSettingsFragment.access$500(this.this$0).setLayoutParams(this.this$0.mRightKeyRParams);
            this.this$0.mMiddleKeyRParams.setMargins((int) (r9 - (caculateTextWidth(OneHandModeSettingsFragment.access$600(this.this$0)) / 2.0f)), r6, 0, 0);
            OneHandModeSettingsFragment.access$600(this.this$0).setLayoutParams(this.this$0.mMiddleKeyRParams);
            goto L12
        L4:
            r13 = (ViewHolder) r11.getTag();
            goto L5
        }

        private float caculateTextWidth(TextView r2) {
            Paint r1 = new Paint();
            r1.setTextSize(r2.getTextSize());
            if (r2.getText() != null) goto L7;
            return 0.0f;
        L7:
            return r1.measureText(r2.getText().toString());
        }

        private void updateState(int r2, PreviewSettingItemView r3, PreviewSettingItemView r4) {
            int r1 = OneHandModeSettingsFragment.access$700(this.this$0)[r2];
            if (r1 == 0) goto L7;
            if (r1 != 1) goto L10;
            r3.setChecked(false);
            r4.setChecked(true);
            return;
        L10:
            return;
        L7:
            r3.setChecked(true);
            r4.setChecked(false);
        }
    }

    class ListOptionDataMode {
        String key;
        int leftIconRes;
        int rightIconRes;
        final /* synthetic */ OneHandModeSettingsFragment this$0;
        int titleRes;

        ListOptionDataMode(OneHandModeSettingsFragment r1) {
            this.this$0 = r1;
        }
    }

    static class ViewHolder {
        TextView itemTitle;
        PreviewSettingItemView leftPreview;
        LinearLayout previewlayout;
        PreviewSettingItemView rightPreview;

        ViewHolder() {
        }
    }

    public void com_android_settings_OneHandModeSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_OneHandModeSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OneHandModeSettingsFragment() {
        this.mDatas = new ArrayList();
        this.isFirst = true;
        this.dockerCheckListener = new AnonymousClass1(this);
    }

    static /* synthetic */ ArrayList access$000(OneHandModeSettingsFragment r0) {
        return r0.mDatas;
    }

    static /* synthetic */ TextView access$100(OneHandModeSettingsFragment r0) {
        return r0.mLeftBack;
    }

    static /* synthetic */ TextView access$200(OneHandModeSettingsFragment r0) {
        return r0.mLeftMenu;
    }

    static /* synthetic */ TextView access$300(OneHandModeSettingsFragment r0) {
        return r0.mLeftHome;
    }

    static /* synthetic */ TextView access$400(OneHandModeSettingsFragment r0) {
        return r0.mRightMenu;
    }

    static /* synthetic */ TextView access$500(OneHandModeSettingsFragment r0) {
        return r0.mRightBack;
    }

    static /* synthetic */ TextView access$600(OneHandModeSettingsFragment r0) {
        return r0.mRightHome;
    }

    static /* synthetic */ int[] access$700(OneHandModeSettingsFragment r0) {
        return r0.mCurrentModeList;
    }

    static {
        STICKER_NAVBAR_LAYOUT_RES = new int[]{R.drawable.navigation_bar_sticker_setting_r, R.drawable.navigation_bar_sticker_setting_l};
        NORMAL_NAVBAR_LAYOUT_RES = new int[]{R.drawable.navbar_setting_left_bg, R.drawable.navbar_setting_right_bg};
        NORMAL_NAVBAR_LAYOUT_POINT_RES = new int[]{R.drawable.navbar_setting_left_point_bg, R.drawable.navbar_setting_right_point_bg};
        NORMAL_NAVBAR_LAYOUT_PLUS_RES = new int[]{R.drawable.navbar_setting_left_plus_bg, R.drawable.navbar_setting_right_plus_bg};
        GESTURE_NAVBAR_LAYOUT_RES = new int[]{R.drawable.navbar_gesture_setting_left_bg, R.drawable.navbar_gesture_setting_right_bg};
        VIRTUAL_KEY_LAYOUT_RES = new int[]{R.drawable.navbar_virtual_key_setting_left_bg, R.drawable.navbar_virtual_key_setting_right_bg};
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.one_hand_settings_layout, r5, false);
        this.mIsSupportNavbar = SettingsUtil.hasNavigationBar();
        boolean r7 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0) == 1) goto L6;
        r7 = false;
    L6:
        this.mIsSmartScreenEnabled = r7;
        this.mTitleRes = R.string.one_hand_mode;
        initAdapterDatas();
        this.mCurrentModeList = new int[this.mDatas.size()];
        ListView r8 = (ListView) findViewByIdNullable(android.R.id.list);
        this.mHandSwitchSettingList = r8;
        LinearLayout r9 = (LinearLayout) r4.inflate(R.layout.one_hand_settings_header, r8, false);
        LinearLayout r10 = (LinearLayout) r4.inflate(R.layout.one_hand_settings_footer, this.mHandSwitchSettingList, false);
        r9.setOnTouchListener(new AnonymousClass2(this));
        this.mItemLeftHand = (SettingItemCheck) r9.findViewById(R.id.item_id_prefer_left);
        this.mItemRightHand = (SettingItemCheck) r9.findViewById(R.id.item_id_prefer_right);
        this.mMenuMoveDownItem = (SettingItemText) r9.findViewById(R.id.item_menu_down);
        this.mThumbPushDownSwitch = (SettingItemSwitch) r10.findViewById(R.id.thumb_push_down_switch);
        SettingItemSwitch r11 = (SettingItemSwitch) r10.findViewById(R.id.item_id_pulldown_wallpaper_enable);
        this.mPulldownWallpaperSwitch = r11;
        if (SettingsFeature.ENABLE_THUMB_PULLDOWN_WALLPAPER == false) goto L9;
        int r1 = 0;
    L10:
        r11.setVisibility(r1);
        this.mThumbTriggerAreaOption = (SettingItemText) r10.findViewById(R.id.thumb_trigger_area_options);
        this.mThumbTriggerAreaLayout = r10.findViewById(R.id.thumb_trigger_area_layout);
        if (SettingsFeature.hasMenuAndBackKeys() == false) goto L14;
        initDynamicTextView();
    L14:
        if (SettingsFeature.hasMenuAndBackKeys() == true) goto L16;
        this.mMenuMoveDownItem.setVisibility(8);
    L16:
        this.mThumbTriggerAreaOption.setOnClickListener(this);
        this.mItemLeftHand.setOnClickListener(this);
        this.mItemRightHand.setOnClickListener(this);
        this.mMenuMoveDownItem.setOnClickListener(this);
        r9.setPadding(0, getResources().getDimensionPixelSize(R.dimen.settings_item_top_bottom_margin), 0, 0);
        this.mHandSwitchSettingList.addHeaderView(r9);
        this.mHandSwitchSettingList.addFooterView(r10);
        this.mHandSwitchSettingList.setOnItemClickListener(null);
        HandSwitchAdapter r12 = new HandSwitchAdapter(this);
        this.mAdapter = r12;
        this.mHandSwitchSettingList.setAdapter(r12);
        PreviewSettingItemView r13 = (PreviewSettingItemView) r10.findViewById(R.id.item_preview_left);
        this.mClassicKeypadMode = r13;
        r13.setOnClickListener(this);
        this.mClassicKeypadMode.setTitle(getString(R.string.keypad_mode_classic));
        PreviewSettingItemView r14 = (PreviewSettingItemView) r10.findViewById(R.id.item_preview_right);
        this.mImproveKeypadMode = r14;
        r14.setOnClickListener(this);
        this.mImproveKeypadMode.setTitle(getString(R.string.keypad_mode_improve));
        ((TextView) r10.findViewById(R.id.text_item_title)).setText(R.string.keypad_mode);
        VerticalOptionsCheckView r15 = (VerticalOptionsCheckView) r10.findViewById(R.id.id_launcher_docker_view);
        this.mDockFlipView = r15;
        r15.setTitle(R.string.launcher_flip_orientation_title);
        this.mDockFlipView.setOptionSelectListener(this.dockerCheckListener);
        this.mDockFlipView.setContentDesc(R.string.one_hand_mode_flip_to_right, R.string.one_hand_mode_flip_to_left);
        VerticalOptionsCheckView r16 = (VerticalOptionsCheckView) r10.findViewById(R.id.id_navigation_layout_one_hand_mode);
        this.mNavbarOneHandModeView = r16;
        if (this.mIsSupportNavbar == false) goto L19;
        r16.setOptionSelectListener(this);
        this.mNormalNavbarPreviewHeight = getResources().getDimensionPixelSize(R.dimen.navigationbar_preview_height);
        this.mGestureNavbarPreviewHeight = getResources().getDimensionPixelSize(R.dimen.navigationbar_preview_gesture_height);
        this.mVirtualKeyPreviewHeight = getResources().getDimensionPixelSize(R.dimen.navigationbar_preview_height);
        this.mNavbarOneHandModeView.setPreviewHeight(this.mNormalNavbarPreviewHeight);
        this.mNavbarOneHandModeView.setContentDesc(R.string.one_hand_mode_back_on_left_side, R.string.one_hand_mode_back_on_right_side);
    L20:
        registerSwitchers(this);
        this.mThumbPullScreenDownTitle = (TextView) r10.findViewById(R.id.id_thumb_pull_screen_down_title);
        this.mThumbDropdown = (FrameLayout) r10.findViewById(R.id.id_thumb_dropdown);
        this.mThumbTriggerSwitchTips = (TextView) r10.findViewById(R.id.id_thumb_trigger_switch_tips);
        if (SettingsFeature.isSupportThumbPullDown() == false) goto L24;
        this.mThumbPullScreenDownTitle.setVisibility(0);
        this.mThumbDropdown.setVisibility(0);
        this.mThumbTriggerSwitchTips.setVisibility(0);
        this.mThumbPushDownSwitch.setVisibility(0);
    L24:
        return this.mRootView;
    L19:
        r16.setVisibility(8);
        goto L20
    L9:
        r1 = 8;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void initAdapterDatas() {
        this.mDatas.clear();
        if (SettingsFeature.hasMenuAndBackKeys() == false) goto L6;
        ListOptionDataMode r0 = new ListOptionDataMode(this);
        r0.key = KEY_HARDWARE_BUTTONS;
        r0.titleRes = R.string.hardware_buttons;
        r0.leftIconRes = R.drawable.hardware_phone;
        r0.rightIconRes = R.drawable.hardware_phone;
        this.mDatas.add(r0);
    L6:
        if (SettingsFeature.isDoubleSideKey() == false) goto L8;
        ListOptionDataMode r1 = new ListOptionDataMode(this);
        r1.key = KEY_VOLUME_KEY;
        r1.titleRes = R.string.volume_key;
        r1.leftIconRes = R.drawable.volume_key_left;
        r1.rightIconRes = R.drawable.volume_key_right;
        this.mDatas.add(r1);
    L8:
        this.mDatas.trimToSize();
    }

    private boolean isThumbPushDownOn() {
        return Boolean.parseBoolean(android.provider.Settings.Global.getString(getContentResolver(), SettingsSwitchKeyUtil.THUMB_PUSH_DOWN));
    }

    private void setThumbPushDown(boolean r2) {
        android.provider.Settings.Global.putString(getContentResolver(), SettingsSwitchKeyUtil.THUMB_PUSH_DOWN, Boolean.toString(r2));
    }

    private String getThumbTriggerAreaSubtitle() {
        String[] r0 = getResources().getStringArray(R.array.thumb_trigger_area_options);
        int r2 = getThumbTriggerAreaSettings();
        if (r2 < r0.length) goto L5;
        return null;
    L5:
        return r0[r2];
    }

    private int getThumbTriggerAreaSettings() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "thumb_trigger_area", 2);
    }

    private void saveThumbTriggerAreaSettings(int r2) {
        if (r2 != 0) goto L4;
    L12:
        android.provider.Settings.Global.putInt(getContentResolver(), "thumb_trigger_area", r2);
        return;
    L4:
        if (r2 == 1) goto L12;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L12;
        if (r2 == 4) goto L12;
    }

    public void loadOriginalPrefer() {
        ContentResolver r0 = getContentResolver();
        boolean r2 = true;
        this.mOriPreviewSelected = android.provider.Settings.Global.getInt(r0, "one_hand_mode", 1);
        int r3 = 0;
        if (android.provider.Settings.Global.getInt(r0, SettingsSwitchKeyUtil.SMART_SCREEN_PROTECTOR, 0) == 1) goto L6;
        r2 = false;
    L6:
        this.mIsSmartScreenEnabled = r2;
        if (SettingsFeature.hasPhysicalVirtualKey() == false) goto L9;
        int r1 = 0;
    L10:
        this.mNavbarTriggerMode = android.provider.Settings.Global.getInt(r0, "navigationbar_trigger_mode", r1);
        this.mCurrentNavbarKeyStyle = android.provider.Settings.Global.getInt(r0, "navigationbar_style", 0);
    L12:
        if (r3 >= this.mDatas.size()) goto L14;
        loadDetailMode(r3);
        r3 = r3 + 1;
        goto L12
    L14:
        updateHeaderItem();
        updateSelectedImage();
        return;
    L9:
        r1 = 2;
        goto L10
    }

    public void updateHeaderItem() {
        int r0 = this.mOriPreviewSelected;
        if (r0 != 0) goto L5;
        this.mItemLeftHand.setChecked(true);
        this.mItemRightHand.setChecked(false);
        return;
    L5:
        if (r0 != 1) goto L9;
        this.mItemLeftHand.setChecked(false);
        this.mItemRightHand.setChecked(true);
        return;
    }

    public void updateContactItems() {
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_change_layout", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mClassicKeypadMode.setChecked(!r0);
        this.mClassicKeypadMode.setPreview(getResources().getDrawable(R.drawable.keypad_mode_left));
        this.mImproveKeypadMode.setChecked(r0);
        if (android.provider.Settings.Global.getInt(getContentResolver(), "contacts_dialpad_left_mode", 1) != 1) goto L9;
        r2 = true;
    L9:
        PreviewSettingItemView r1 = this.mImproveKeypadMode;
        Resources r6 = getResources();
        if (r2 == false) goto L12;
        int r3 = R.drawable.keypad_mode_improve_left;
    L13:
        r1.setPreview(r6.getDrawable(r3));
        return;
    L12:
        r3 = R.drawable.keypad_mode_improve_right;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public void loadDetailMode(int r4) {
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), this.mDatas.get(r4).key, 1);
        this.mCurrentModeList[r4] = r0;
    }

    public void updateViews() {
        loadOriginalPrefer();
        this.mThumbTriggerAreaOption.setSubTitle(getThumbTriggerAreaSubtitle());
        this.mAdapter.notifyDataSetChanged();
        updateContactItems();
        boolean r0 = isThumbPushDownOn();
        this.mThumbPushDownSwitch.setChecked(r0);
        this.mPulldownWallpaperSwitch.setChecked(isPulldownWallpaperEnabled());
        View r1 = this.mThumbTriggerAreaLayout;
        boolean r2 = false;
        if (r0 == true) goto L5;
    L7:
        int r3 = 8;
    L8:
        r1.setVisibility(r3);
        updateMenuMovedownItemView();
        this.mLauncherMode = getDefaultLauncherMode();
        if (android.provider.Settings.Global.getInt(getContentResolver(), "launcher_switching_orientation", 0) != 0) goto L11;
        boolean r4 = true;
    L12:
        updateDockFlipView(r4);
        if (this.mIsSupportNavbar == true) goto L15;
    L18:
        this.mMultiBlockMode = getDefaultMultiBlockMode();
        updateDockPreview();
        updateNavbarOneHandView();
        return;
    L15:
        if (android.provider.Settings.Global.getInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, 1) != 1) goto L17;
        r2 = true;
    L17:
        updateNavbarBackStyle(r2);
        goto L18
    L11:
        r4 = false;
        goto L12
    L5:
        if (SettingsFeature.isSupportThumbPullDown() == false) goto L7;
        r3 = 0;
        goto L8
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void registerSwitchers(CompoundButton.OnCheckedChangeListener r2) {
        this.mThumbPushDownSwitch.setOnCheckedChangeListener(r2);
        this.mPulldownWallpaperSwitch.setOnCheckedChangeListener(r2);
    }

    private void updateDockPreview() {
        int r0 = this.mMultiBlockMode;
        if (r0 != 64) goto L6;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_64_right, R.drawable.flip_64_left);
        return;
    L6:
        if (r0 != 36) goto L9;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_36_right, R.drawable.flip_36_left);
        return;
    L9:
        if (r0 != 81) goto L12;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_81_right, R.drawable.flip_81_left);
        return;
    L12:
        if (r0 != 80) goto L15;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_80_right, R.drawable.flip_80_left);
        return;
    L15:
        if (r0 != 48) goto L22;
        this.mDockFlipView.bindOptionPreview(R.drawable.flip_48_right, R.drawable.flip_48_left);
        return;
    }

    private void updateNavbarBackStyle(boolean r1) {
        VerticalOptionsCheckView r0 = this.mNavbarOneHandModeView;
        if (r1 == false) goto L5;
        int r2 = 2;
    L6:
        r0.setCheck(r2);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    private void updateNavbarOneHandView() {
        int[] r0 = NORMAL_NAVBAR_LAYOUT_RES;
        int r2 = r0[0];
        int r1 = r0[1];
        int r4 = this.mNormalNavbarPreviewHeight;
        int r5 = this.mNavbarTriggerMode;
        int r7 = R.string.navigation_bar_layout;
        if (r5 == 0) goto L9;
        if (r5 == 1) goto L8;
        if (r5 != 2) goto L17;
        int[] r3 = VIRTUAL_KEY_LAYOUT_RES;
        r2 = r3[0];
        r1 = r3[1];
        r4 = this.mVirtualKeyPreviewHeight;
        r7 = R.string.virtual_key_physical_setting_title;
    L17:
        if (SettingsFeature.isSupportSmartScreenProtection() == true) goto L19;
    L21:
        int r6 = getResources().getDimensionPixelSize(R.dimen.option_navbar_layout_preview_vertical_margin);
        this.mNavbarOneHandModeView.setPreviewHeight(r4);
        this.mNavbarOneHandModeView.setTopMargin(r6);
        this.mNavbarOneHandModeView.setBottomMargin(r6);
        this.mNavbarOneHandModeView.setTitle(r7);
        this.mNavbarOneHandModeView.getOptionPreview(0).setBackgroundResource(r2);
        this.mNavbarOneHandModeView.getOptionPreview(2).setBackgroundResource(r1);
        if (this.mNavbarTriggerMode != 2) goto L25;
        this.mNavbarOneHandModeView.setVisibility(8);
        return;
    L25:
        return;
    L19:
        if (this.mIsSmartScreenEnabled == false) goto L21;
        int[] r8 = STICKER_NAVBAR_LAYOUT_RES;
        r2 = r8[0];
        r1 = r8[1];
        r7 = R.string.smart_screen_setting_title;
        goto L21
    L8:
        int[] r9 = GESTURE_NAVBAR_LAYOUT_RES;
        r2 = r9[0];
        r1 = r9[1];
        r4 = this.mGestureNavbarPreviewHeight;
        r7 = R.string.navbar_trigger_mode_gesture_title;
        goto L17
    L9:
        int r10 = this.mCurrentNavbarKeyStyle;
        if (r10 == 0) goto L17;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L17;
        int[] r11 = NORMAL_NAVBAR_LAYOUT_PLUS_RES;
        r2 = r11[0];
        r1 = r11[1];
        goto L17
    L15:
        int[] r12 = NORMAL_NAVBAR_LAYOUT_POINT_RES;
        r2 = r12[0];
        r1 = r12[1];
        goto L17
    }

    private void updateDockFlipView(boolean r3) {
        if (this.mLauncherMode != 0) goto L5;
    L12:
        this.mDockFlipView.setVisibility(8);
        return;
    L5:
        if (Utils.isThirdPartHome(this.mContext) == true) goto L12;
        int r1 = 0;
        this.mDockFlipView.setVisibility(0);
        VerticalOptionsCheckView r2 = this.mDockFlipView;
        if (r3 == false) goto L10;
        r1 = 2;
    L10:
        r2.setCheck(r1);
    }

    private int getDefaultLauncherMode() {
        return Utils.getCurrentLauncherMode(this.mContext);
    }

    private int getDefaultMultiBlockMode() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "multi_block_mode", 36);
    }

    private void updateMenuMovedownItemView() {
        boolean r1 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_nc", 0) == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        String r0 = getResources().getStringArray(R.array.move_down_when_setting_list)[android.provider.Settings.Global.getInt(getContentResolver(), "menu_move_down_when", 0)];
    L9:
        this.mMenuMoveDownItem.setSubTitle(r0);
        return;
    L8:
        r0 = getString(R.string.close);
        goto L9
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.mClassicKeypadMode) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_dialpad_change_layout", 0);
        this.mClassicKeypadMode.setChecked(true);
        this.mImproveKeypadMode.setChecked(false);
        return;
    L6:
        if (r5 != this.mMenuMoveDownItem) goto L9;
        start(MenuMoveDownSettingFragment.class);
        SettingsTracker.onItemClick(EntityType.USER_PROFILE);
        return;
    L9:
        if (r5 != this.mImproveKeypadMode) goto L12;
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_dialpad_change_layout", 1);
        this.mClassicKeypadMode.setChecked(false);
        this.mImproveKeypadMode.setChecked(true);
        return;
    L12:
        switch(r5.getId()) {
            case 2131429397: goto L19;
            case 2131429398: goto L18;
            case 2131429480: goto L17;
            case 2131429482: goto L16;
            case 2131431325: goto L14;
            default: goto L20;
        };
    L14:
        launchThumbTriggerAreaOptions();
        SettingsTracker.onItemClick(1502);
        return;
    L16:
        applyDetailHandMode(((Integer) r5.getTag()).intValue(), 1);
        goto L20
    L17:
        applyDetailHandMode(((Integer) r5.getTag()).intValue(), 0);
        goto L20
    L18:
        setPreferLeftHand(false);
        goto L20
    L19:
        setPreferLeftHand(true);
    L20:
        updateSelectedImage();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void setPreferLeftHand(boolean r4) {
        this.mItemLeftHand.setChecked(r4);
        this.mItemRightHand.setChecked(!r4);
        applyNewHandMode(!r4 ? 1 : 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "launcher_switching_orientation", r4 ? 1 : 0);
        android.provider.Settings.Global.putInt(getContentResolver(), "contacts_dialpad_left_mode", r4 ? 1 : 0);
        updateDockFlipView(!r4);
        updateContactItems();
        if (this.mIsSupportNavbar == false) goto L6;
        android.provider.Settings.System.putInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, !r4 ? 1 : 0);
        updateNavbarBackStyle(!r4);
        return;
    }

    private void launchThumbTriggerAreaOptions() {
        Utils.launchOptionsActivity(getActivity(), new OptionsInfo(getResources().getStringArray(R.array.thumb_trigger_area_options), new Integer[]{0, 1, 2, 3, 4}, OptionsInfo.SaveTargetTable.Global, "thumb_trigger_area"), String.valueOf(getThumbTriggerAreaSettings()), getString(R.string.one_hand_thumb_trigger_area), this.mTitleRes);
    }

    public void applyDetailHandMode(int r3, int r4) {
        android.provider.Settings.Global.putInt(getContentResolver(), this.mDatas.get(r3).key, r4);
        this.mAdapter.notifyDataSetChanged();
        this.mCurrentModeList[r3] = r4;
    }

    public void applyNewHandMode(int r4) {
        this.mOriPreviewSelected = r4;
        android.provider.Settings.Global.putInt(getContentResolver(), "one_hand_mode", r4);
        int r0 = 0;
    L4:
        if (r0 >= this.mDatas.size()) goto L12;
        if (this.mDatas.get(r0).key.equals("input_keyboard_mode") == true) goto L11;
        if (this.mDatas.get(r0).key.equals("keypad_mode") == true) goto L11;
        applyDetailHandMode(r0, r4);
    L11:
        r0 = r0 + 1;
        goto L4
    }

    private void updateSelectedImage() {
        int r1 = 0;
    L3:
        int[] r2 = this.mCurrentModeList;
        if (r1 >= r2.length) goto L10;
        if (r2[r1] != this.mOriPreviewSelected) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        this.mItemLeftHand.setCheckedIconLight(true);
        this.mItemRightHand.setCheckedIconLight(true);
        return;
    L10:
        this.mItemLeftHand.setCheckedIconLight(false);
        this.mItemRightHand.setCheckedIconLight(false);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mThumbPushDownSwitch.getSwitch()) goto L12;
        setThumbPushDown(r3);
        View r1 = this.mThumbTriggerAreaLayout;
        if (r3 == true) goto L7;
    L9:
        int r4 = 8;
    L10:
        r1.setVisibility(r4);
        SettingsTracker.onSwitcherClick(1503, r3);
        return;
    L7:
        if (SettingsFeature.isSupportThumbPullDown() == false) goto L9;
        r4 = 0;
        goto L10
    L12:
        if (r2 != this.mPulldownWallpaperSwitch.getSwitch()) goto L16;
        setPulldownWallpaperEnable(r3);
        return;
    }

    @Override // com.android.settings.widget.VerticalOptionsCheckView.OptionSelectListener
    public void onOptionSelected(int r3) {
        int r0 = 0;
        if (r3 != 0) goto L5;
    L8:
        android.provider.Settings.System.putInt(getContentResolver(), settings.Settings.Global.KEY_REVERSE_NAVIGATION_BAR, r0);
        return;
    L5:
        if (r3 != 2) goto L8;
        r0 = 1;
        goto L8
    }

    private boolean isPulldownWallpaperEnabled() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "thumb_pulldown_wallpaper_enabled", 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setPulldownWallpaperEnable(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "thumb_pulldown_wallpaper_enabled", r2 ? 1 : 0);
    }

    private void initDynamicTextView() {
        this.mLeftMenu = getTextView(R.string.onehand_mode_menu);
        this.mRightMenu = getTextView(R.string.onehand_mode_menu);
        this.mLeftBack = getTextView(R.string.onehand_mode_back);
        this.mRightBack = getTextView(R.string.onehand_mode_back);
        this.mLeftHome = getTextView(R.string.onehand_mode_home);
        this.mRightHome = getTextView(R.string.onehand_mode_home);
        this.mLeftKeyLParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mMiddleKeyLParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mRightKeyLParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mLeftKeyRParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mMiddleKeyRParams = new RelativeLayout.LayoutParams(-2, -2);
        this.mRightKeyRParams = new RelativeLayout.LayoutParams(-2, -2);
    }

    private TextView getTextView(int r3) {
        TextView r0 = new TextView(this.mContext);
        r0.setText(r3);
        r0.setTextSize(getResources().getDimension(R.dimen.onehand_pic_font_size));
        r0.setTextColor(getResources().getColor(R.color.onehand_pic_font_color));
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OneHandModeSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OneHandModeSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OneHandModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OneHandModeSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OneHandModeSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OneHandModeSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
