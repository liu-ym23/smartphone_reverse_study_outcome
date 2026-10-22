package com.bytedanceos.security.permission;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedanceos.application.AppComparator;
import com.bytedanceos.datausage.DataUsageMenuItem;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.QuickBarEx;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.SlideListView;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersListView;
import com.bytedanceos.utils.NavigationBarHelper;
import com.bytedanceos.utils.Task;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.OPopoverHelper;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.searchbar.OSearchBar;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.simplified.ORoundedListItemText;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import kotlin.Unit;
import obric.widget.BarsHelper;
import obric.widget.ButtonTabGroup;
import obric.widget.TitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class NativeRadioPermissions extends BaseActivity implements View.OnClickListener, PermissionApps.Callback, AdapterView.OnItemClickListener, SearchBar.Listener, SlideListView.Listener {
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static int MAX_NUMBER = 30;
    private static final String TAG = "RadioPermissions";
    private int animInLeft;
    private int animOutRight;
    private String lastQueryText;
    SwitchedAdapter mAdapter;
    private CompoundButton.OnCheckedChangeListener mAutoStartCheckChangeListener;
    private View mBottomBar;
    private OCheckBox mBtnSelectAll;
    private int mCurrentSortMode;
    private List<PermissionApp> mDataList;
    private LinearInterpolator mDecelerateInterpolator;
    private long mDuration;
    private View mEditBarView;
    private AnimatorSet mEndSearchAnim;
    private boolean mFromManageUnknownAppSource;
    boolean mHidePrompt;
    boolean mIgnore;
    private boolean mIsAnimating;
    private boolean mIsEdit;
    private boolean mIsHandleClick;
    private boolean mIsSwitchMode;
    private float mItemTranslateX;
    PermissionApp mLastClickItem;
    private StickyListHeadersListView mListView;
    private View mListViewEmptyView;
    private OInsetSheet mMenuDialog;
    private OIconButton mModeFilterBtn;
    private NativePermission mNativePermission;
    private ViewStub mNetListControlVS;
    private ViewStub mOptionBarVS;
    private Point mOutSize;
    BroadcastReceiver mPackageReceiver;
    private OButton mPermissionAllow;
    private PermissionApps mPermissionApps;
    private OButton mPermissionAsk;
    private OButton mPermissionDeny;
    private PermissionReceiver mPermissionReceiver;
    private HashMap<Character, Integer> mPositionOfSections;
    private QuickBarEx.QBListener mQBListener;
    private QuickBarEx mQuickBar;
    private int mResId;
    private OCheckBox mRightCheckBox;
    private View mRightEditContainer;
    private int mRightImgCancelRes;
    private int mRightImgEditRes;
    private SwitchedAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private OSearchBar mSearchBar;
    private OButton mSearchBarCancel;
    private OCTitleBar mSearchBarContainer;
    private View mSearchEmptyView;
    private ArrayList<PermissionApp> mSearchResultList;
    private OListView mSearchResultListView;
    private View mSearchResultView;
    private EditText mSearchView;
    private ArrayList<String> mSections;
    private TextView mSelectFiles;
    private ArrayList<PermissionApp> mSelectedInfos;
    private ExecutorService mSingleThreadExecutor;
    private OPopover mSortDialog;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private ImageView mTitleBarRightImg;
    private int mTitleId;
    private View mWholeView;

    public class AutoStartAdapter extends SwitchedAdapter {
        final /* synthetic */ NativeRadioPermissions this$0;

        public AutoStartAdapter(final NativeRadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(this$0, context);
        }

        @Override // com.bytedanceos.security.permission.NativeRadioPermissions.SwitchedAdapter, android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            PermissionApp r10 = (PermissionApp) getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(R.layout.autostart_item_scroll_layout, null);
            AutoStartViewHolder r1 = new AutoStartViewHolder(convertView);
            convertView.setTag(r1);
        L6:
            PermissionApp r8 = (PermissionApp) getItem(position);
            r1.item.setTitleString(r10.getLabel());
            OListItemSwitch r2 = r1.item;
            Drawable r3 = r10.getIcon();
            if (UserHandle.getUserId(r10.getUid()) != 10) goto L9;
            boolean r4 = true;
        L10:
            OuiWidgetUtils.initDopplegangerBadge(r2, r3, r4);
            r1.item.getMTrailingElement().getChildAt(0).setTag(r10);
            r1.item.setOnCheckedChangeListener(null);
            r1.item.setChecked(r8.areRuntimePermissionsGranted());
            r1.item.setOnCheckedChangeListener(NativeRadioPermissions.access$3600(this.this$0));
            return convertView;
        L9:
            r4 = false;
            goto L10
        L5:
            r1 = (AutoStartViewHolder) convertView.getTag();
            goto L6
        }
    }

    static class AutoStartViewHolder {
        OListItemSwitch item;

        public AutoStartViewHolder(View view) {
            this.item = (OListItemSwitch) view.findViewById(R.id.app_info);
        }
    }

    static class HeaderViewHolder {
        TextView headerText;

        HeaderViewHolder() {
        }
    }

    private class PermissionReceiver extends BroadcastReceiver {
        final /* synthetic */ NativeRadioPermissions this$0;

        private PermissionReceiver(final NativeRadioPermissions this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ PermissionReceiver(NativeRadioPermissions r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ArrayList<String> r6 = intent.getStringArrayListExtra("permissions");
            if (NativeRadioPermissions.access$3700(this.this$0) == null) goto L19;
            if (r6 == null) goto L24;
            String[] r7 = NativeRadioPermissions.access$3700(this.this$0).getPermissions();
            if (r7 != null) goto L9;
            return;
        L9:
            int r0 = r7.length;
            int r1 = 0;
        L10:
            if (r1 >= r0) goto L25;
            String r2 = r7[r1];
            Iterator<String> r3 = r6.iterator();
        L13:
            if (r3.hasNext() == false) goto L18;
            if (TextUtils.equals(r2, r3.next()) == false) goto L13;
            NativeRadioPermissions.access$000(this.this$0).refresh(true);
            return;
        L18:
            r1 = r1 + 1;
            goto L10
        L25:
            return;
        L24:
            return;
        }
    }

    private class SearchAdapter extends SwitchedAdapter {
        final /* synthetic */ NativeRadioPermissions this$0;

        public SearchAdapter(final NativeRadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(this$0, context);
        }
    }

    public class SwitchedAdapter extends ArrayAdapter<PermissionApp> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
        protected List<PermissionApp> mEntries;
        LayoutInflater mInflater;
        private boolean mIsEdit;
        private View.OnClickListener mOnClickListener;
        final /* synthetic */ NativeRadioPermissions this$0;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
        }

        public SwitchedAdapter(final NativeRadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(context, NativeRadioPermissions.access$2800(this$0));
            this.mEntries = new ArrayList();
            this.mIsEdit = false;
            this.mOnClickListener = new AnonymousClass1(this);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public List<PermissionApp> getDatas() {
            return this.mEntries;
        }

        public void setEdit(boolean isEdit) {
            this.mIsEdit = isEdit;
        }

        public void setData(List<PermissionApp> data, boolean initSections) {
            NativeRadioPermissions.access$2300(this.this$0).setEmptyView(NativeRadioPermissions.access$2900(this.this$0));
            clear();
            resetSelecteds(data);
            this.mEntries = data;
            if (data == null) goto L18;
            if (data.size() <= 0) goto L18;
            Collections.sort(data, AppComparator.PERMISSIONAPP_COMPARATOR);
            addAll(data);
            OCTitleBar r4 = NativeRadioPermissions.access$3000(this.this$0);
            if (getCount() <= 0) goto L9;
            int r2 = 0;
        L10:
            r4.setVisibility(r2);
            if (initSections == false) goto L14;
            initSections();
        L14:
            if (NativeRadioPermissions.access$3100(this.this$0) == true) goto L16;
            NativeRadioPermissions.access$3200(this.this$0).setEnabled(true);
            NativeRadioPermissions.access$3200(this.this$0).setVisibility(0);
        L16:
            NativeRadioPermissions.access$2900(this.this$0).setVisibility(8);
        L22:
            NativeRadioPermissions.access$2500(this.this$0);
            return;
        L9:
            r2 = 8;
        L18:
            if (NativeRadioPermissions.access$3300(this.this$0).isFocused() == false) goto L20;
            NativeRadioPermissions.access$2900(this.this$0).setVisibility(8);
        L21:
            NativeRadioPermissions.access$3200(this.this$0).setEnabled(false);
            goto L22
        L20:
            NativeRadioPermissions.access$2900(this.this$0).setVisibility(0);
            NativeRadioPermissions.access$3200(this.this$0).setVisibility(8);
            goto L21
        }

        private void resetSelecteds(List<PermissionApp> datas) {
            if (NativeRadioPermissions.access$900(this.this$0).size() > 0) goto L5;
            return;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<PermissionApp> r8 = datas.iterator();
        L7:
            if (r8.hasNext() == false) goto L23;
            PermissionApp r1 = r8.next();
            Iterator r2 = NativeRadioPermissions.access$900(this.this$0).iterator();
        L10:
            if (r2.hasNext() == false) goto L7;
            PermissionApp r3 = (PermissionApp) r2.next();
            int r5 = 0;
            if (r1.getAppInfo() != null) goto L14;
            int r4 = 0;
        L16:
            if (r3.getAppInfo() == null) goto L19;
            r5 = r3.getAppInfo().uid;
        L19:
            if (r4 != r5) goto L10;
            if (TextUtils.equals(r1.getPackageName(), r3.getPackageName()) == false) goto L10;
            r0.add(r1);
            goto L10
        L14:
            r4 = r1.getAppInfo().uid;
            goto L16
        L23:
            NativeRadioPermissions.access$900(this.this$0).clear();
            if (r0.size() <= 0) goto L35;
            NativeRadioPermissions.access$900(this.this$0).addAll(r0);
            return;
        }

        public ArrayList<PermissionApp> query(String input) {
            ArrayList<PermissionApp> r0 = new ArrayList();
            if (TextUtils.isEmpty(input) == true) goto L17;
            List<PermissionApp> r5 = this.mEntries;
            String r6 = input.toUpperCase();
            if (r5 == null) goto L17;
            Iterator<PermissionApp> r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L17;
            PermissionApp r1 = r7.next();
            boolean r2 = r1.getLabel().toUpperCase().contains(r6);
            boolean r3 = r1.getLabelEntry().firstLetters.toUpperCase().contains(r6);
            if (PinyinUtils.isChinese(r6) == true) goto L12;
            boolean r4 = r1.getLabelEntry().labelPinyin.toUpperCase().contains(r6);
        L13:
            if (r2 == true) goto L16;
            if (r4 == true) goto L16;
            if (r3 == false) goto L8;
        L16:
            r0.add(r1);
            goto L8
        L12:
            r4 = false;
        L17:
            return r0;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            PermissionApp r10 = getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(R.layout.application_item_scroll_layout, null);
            ViewHolder r1 = new ViewHolder(convertView, this.mInflater.inflate(R.layout.single_checkbox, null));
            convertView.setTag(r1);
        L6:
            r1.checkBox.setOnClickListener(this.mOnClickListener);
            r1.checkBox.setTag(Integer.valueOf(position));
            ViewGroup r0 = r1.item.getMLeadingElement();
            boolean r3 = false;
            if (this.mIsEdit == false) goto L9;
            int r2 = 0;
        L10:
            r0.setVisibility(r2);
            updateCheckBox(r1.item, r1.checkBox, this.mIsEdit, NativeRadioPermissions.access$900(this.this$0).contains(getItem(position)));
            r1.item.setTitleString(r10.getLabel());
            r1.item.setContentImage(r10.getIcon());
            ORoundedListItemText r8 = r1.item;
            if (UserHandle.getUserId(r10.getUid()) != 10) goto L13;
            r3 = true;
        L13:
            r8.setDoppleganger(r3);
            r1.item.setTrailingText(NativeRadioPermissions.access$3400(this.this$0, r10));
            r1.item.getTrailingIconView().setVisibility(8);
            return convertView;
        L9:
            r2 = 8;
            goto L10
        L5:
            r1 = (ViewHolder) convertView.getTag();
            goto L6
        }

        private void initSections() {
            NativeRadioPermissions.access$2400(this.this$0).clear();
            NativeRadioPermissions.access$3500(this.this$0).clear();
            List<PermissionApp> r0 = this.mEntries;
            if (r0.size() <= 0) goto L11;
            String r2 = String.valueOf(r0.get(0).getLabelEntry().firstChar);
            NativeRadioPermissions.access$2400(this.this$0).add(r2);
            NativeRadioPermissions.access$3500(this.this$0).put(Character.valueOf(r0.get(0).getLabelEntry().firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L15;
            String r3 = String.valueOf(r0.get(r1).getLabelEntry().firstChar);
            if (r2.equals(r3) == true) goto L10;
            NativeRadioPermissions.access$2400(this.this$0).add(r3);
            NativeRadioPermissions.access$3500(this.this$0).put(Character.valueOf(r0.get(r1).getLabelEntry().firstChar), Integer.valueOf(r1));
            r2 = r3;
        L10:
            r1 = r1 + 1;
            goto L6
        L15:
            return;
        }

        private void updateCheckBox(View mPicFrameView, OCheckBox mCheckBox, boolean isEditMode, boolean isCheck) {
            if (isEditMode == false) goto L9;
            if (NativeRadioPermissions.access$1400(this.this$0) == true) goto L7;
            mCheckBox.setVisibility(0);
        L7:
            mCheckBox.setChecked(isCheck);
            return;
        L9:
            if (NativeRadioPermissions.access$1400(this.this$0) == true) goto L13;
            mPicFrameView.setVisibility(0);
            mCheckBox.setVisibility(8);
            return;
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) goto L4;
        L7:
            HeaderViewHolder r5 = new HeaderViewHolder();
            convertView = this.mInflater.inflate(R.layout.sticky_list_header_view, null);
            r5.headerText = (TextView) convertView.findViewById(R.id.sticky_header);
            convertView.setTag(r5);
        L8:
            List<PermissionApp> r2 = this.mEntries;
            if (r2.get(position).getLabelEntry() == null) goto L11;
            String r3 = Character.toString(r2.get(position).getLabelEntry().firstChar);
        L13:
            if (r5.headerText == null) goto L15;
            r5.headerText.setText(r3);
        L15:
            return convertView;
        L11:
            r3 = "#";
            goto L13
        L4:
            if ((convertView.getTag() instanceof HeaderViewHolder) == false) goto L7;
            r5 = (HeaderViewHolder) convertView.getTag();
            goto L8
        }

        @Override // com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int position) {
            List<PermissionApp> r1 = this.mEntries;
            if (r1.get(position).getLabelEntry() != null) goto L7;
            return 35;
        L7:
            return r1.get(position).getLabelEntry().firstChar;
        }

        public int getPositionForSection(int section) {
            Integer r0 = (Integer) NativeRadioPermissions.access$3500(this.this$0).get(Character.valueOf((char) section));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }
    }

    static class ViewHolder {
        OCheckBox checkBox;
        ORoundedListItemText item;

        public ViewHolder(View view, View checkBoxContainer) {
            ORoundedListItemText r0 = (ORoundedListItemText) view.findViewById(R.id.app_info);
            this.item = r0;
            r0.getMLeadingElement().addView(checkBoxContainer);
            this.checkBox = (OCheckBox) view.findViewById(R.id.checkBox);
        }
    }

    static {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
    }

    public NativeRadioPermissions() {
        this.mIgnore = false;
        this.mAdapter = null;
        this.mLastClickItem = null;
        this.mDataList = new ArrayList();
        this.mCurrentSortMode = 6;
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.lastQueryText = "";
        this.mIsEdit = false;
        this.mIsHandleClick = false;
        this.mDuration = 200;
        this.mSelectedInfos = new ArrayList();
        this.mOutSize = new Point();
        this.mIsSwitchMode = false;
        this.mIsAnimating = false;
        this.mQBListener = new AnonymousClass22(this);
        this.mAutoStartCheckChangeListener = new AnonymousClass26(this);
    }

    static /* synthetic */ PermissionApps access$000(NativeRadioPermissions r0) {
        return r0.mPermissionApps;
    }

    static /* synthetic */ int access$1000(NativeRadioPermissions r0) {
        return r0.mCurrentSortMode;
    }

    static /* synthetic */ boolean access$1100(NativeRadioPermissions r0, PermissionApp r1, int r2) {
        return r0.isModeApp(r1, r2);
    }

    static /* synthetic */ boolean access$1200(NativeRadioPermissions r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$1300(NativeRadioPermissions r0) {
        r0.clickBtnEdit();
    }

    static /* synthetic */ boolean access$1400(NativeRadioPermissions r0) {
        return r0.mIsAnimating;
    }

    static /* synthetic */ boolean access$1402(NativeRadioPermissions r0, boolean r1) {
        r0.mIsAnimating = r1;
        return r1;
    }

    static /* synthetic */ View access$1500(NativeRadioPermissions r0) {
        return r0.mEditBarView;
    }

    static /* synthetic */ void access$1600(NativeRadioPermissions r0, PermissionApp r1, boolean r2) {
        r0.sendPermissionChangeBroadCast(r1, r2);
    }

    static /* synthetic */ void access$1700(NativeRadioPermissions r0) {
        r0.updateUiAfterChange();
    }

    static /* synthetic */ View access$1800(NativeRadioPermissions r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ View access$1900(NativeRadioPermissions r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ void access$200(NativeRadioPermissions r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ Point access$2000(NativeRadioPermissions r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ int access$2100(NativeRadioPermissions r0) {
        return r0.mTitleBarHeight;
    }

    static /* synthetic */ void access$2200(NativeRadioPermissions r0) {
        r0.resetOkButton();
    }

    static /* synthetic */ StickyListHeadersListView access$2300(NativeRadioPermissions r0) {
        return r0.mListView;
    }

    static /* synthetic */ ArrayList access$2400(NativeRadioPermissions r0) {
        return r0.mSections;
    }

    static /* synthetic */ void access$2500(NativeRadioPermissions r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ boolean access$2602(NativeRadioPermissions r0, boolean r1) {
        r0.mIsHandleClick = r1;
        return r1;
    }

    static /* synthetic */ void access$2700(NativeRadioPermissions r0, int r1, boolean r2) {
        r0.setCheckedInternal(r1, r2);
    }

    static /* synthetic */ int access$2800(NativeRadioPermissions r0) {
        return r0.mResId;
    }

    static /* synthetic */ View access$2900(NativeRadioPermissions r0) {
        return r0.mListViewEmptyView;
    }

    static /* synthetic */ OIconButton access$300(NativeRadioPermissions r0) {
        return r0.mModeFilterBtn;
    }

    static /* synthetic */ OCTitleBar access$3000(NativeRadioPermissions r0) {
        return r0.mSearchBarContainer;
    }

    static /* synthetic */ boolean access$3100(NativeRadioPermissions r0) {
        return r0.mIsSwitchMode;
    }

    static /* synthetic */ ImageView access$3200(NativeRadioPermissions r0) {
        return r0.mTitleBarRightImg;
    }

    static /* synthetic */ EditText access$3300(NativeRadioPermissions r0) {
        return r0.mSearchView;
    }

    static /* synthetic */ String access$3400(NativeRadioPermissions r0, PermissionApp r1) {
        return r0.getStatusText(r1);
    }

    static /* synthetic */ HashMap access$3500(NativeRadioPermissions r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$3600(NativeRadioPermissions r0) {
        return r0.mAutoStartCheckChangeListener;
    }

    static /* synthetic */ NativePermission access$3700(NativeRadioPermissions r0) {
        return r0.mNativePermission;
    }

    static /* synthetic */ OButton access$400(NativeRadioPermissions r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ QuickBarEx access$500(NativeRadioPermissions r0) {
        return r0.mQuickBar;
    }

    static /* synthetic */ boolean access$600(NativeRadioPermissions r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ void access$700(NativeRadioPermissions r0) {
        r0.hideIME();
    }

    static /* synthetic */ OInsetSheet access$800(NativeRadioPermissions r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ ArrayList access$900(NativeRadioPermissions r0) {
        return r0.mSelectedInfos;
    }

    @Override // com.bytedanceos.security.widget.SlideListView.Listener
    public void setChecked(int position, boolean isChecked) {
        if (position < this.mListView.getHeaderViewsCount()) goto L10;
        setCheckedInternal(position - this.mListView.getHeaderViewsCount(), isChecked);
        int r2 = position - this.mListView.getFirstVisiblePosition();
        View r1 = this.mListView.getWrappedList().getChildAt(r2);
        if (r1 == null) goto L11;
        OCheckBox r3 = (OCheckBox) r1.findViewById(R.id.checkBox);
        if (r3 == null) goto L12;
        r3.setChecked(isChecked);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void setCheckedInternal(int position, boolean isChecked) {
        if (this.mSearchView.isFocused() == false) goto L11;
        SwitchedAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getCount() <= 0) goto L19;
        PermissionApp r2 = this.mSearchAdapter.getItem(position);
    L12:
        if (isChecked == true) goto L14;
        this.mSelectedInfos.remove(r2);
    L17:
        recoverQuickBar();
        updateSelectDesc();
        return;
    L14:
        if (this.mSelectedInfos.contains(r2) == true) goto L17;
        this.mSelectedInfos.add(r2);
        goto L17
    L19:
        return;
    L11:
        r2 = this.mAdapter.getItem(position);
        goto L12
    }

    private void updateSelectDesc() {
        if (this.mAdapter == null) goto L15;
        int r0 = this.mSelectedInfos.size();
        if (r0 == 0) goto L7;
        boolean r3 = true;
    L8:
        this.mPermissionAllow.setEnabled(r3);
        this.mPermissionAsk.setEnabled(r3);
        this.mPermissionDeny.setEnabled(r3);
        OCheckBox r4 = this.mBtnSelectAll;
        if (r0 != this.mAdapter.getCount()) goto L12;
        if (r0 == 0) goto L12;
        boolean r5 = true;
    L13:
        r4.setChecked(r5);
        this.mSelectFiles.setText(getResources().getString(R.string.select_apps, new Object[]{Integer.valueOf(r0), Integer.valueOf(this.mAdapter.getCount())}));
        return;
    L12:
        r5 = false;
        goto L13
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.bytedanceos.security.widget.SlideListView.Listener
    public boolean isChecked(int position) {
        if (this.mSearchView.isFocused() == false) goto L5;
        PermissionApp r2 = this.mSearchAdapter.getItem(position);
    L7:
        return this.mSelectedInfos.contains(r2);
    L5:
        r2 = this.mAdapter.getItem(position);
        goto L7
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_radio);
        AnonymousClass1 r0 = null;
        getWindow().setBackgroundDrawable(null);
        this.mItemTranslateX = getResources().getDimension(R.dimen.list_item_translation_x);
        NativePermission r5 = NativePermissionManager.getPermissionByName(getIntent().getStringExtra(Utils.INTENT_KEY_NATIVE_PERMISSION));
        this.mNativePermission = r5;
        this.mRightImgEditRes = R.drawable.oic_line_3_list_checkmark;
        this.mRightImgCancelRes = R.drawable.oic_list_cancel;
        if (r5 != null) goto L6;
        finish();
        return;
    L6:
        this.mSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.mPermissionApps = new PermissionApps(this, this.mNativePermission, this);
        this.mIsSwitchMode = this.mNativePermission.isSwitchMode();
        this.mTitleId = this.mNativePermission.getLabelRes();
        initTitle();
        initView();
        if (getWindowManager() != null) goto L9;
    L11:
        this.mPackageReceiver = new AnonymousClass1(this);
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        IntentFilter r6 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r6.addAction("android.intent.action.PACKAGE_ADDED");
        r6.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r6);
        this.mResId = Utils.getResouceId("android", "simple_list_item_2", "layout", android.R.layout.simple_list_item_2);
        if (Utils.isDesktop(this) == false) goto L15;
        IntentFilter r7 = new IntentFilter(DangerousPermissionUtil.BROADCAST_PERMISSION_CHANGE_ACTION);
        PermissionReceiver r1 = new PermissionReceiver(this, r0);
        this.mPermissionReceiver = r1;
        registerReceiver(r1, r7);
        return;
    L15:
        return;
    L9:
        if (getWindowManager().getDefaultDisplay() == null) goto L11;
        getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        goto L11
    }

    private void initView() {
        OCTitleBar r0 = (OCTitleBar) findViewById(R.id.oc_searchbar_container);
        this.mSearchBarContainer = r0;
        r0.removeAllLeftViews();
        this.mSearchBarContainer.removeAllRightViews();
        int r1 = getResources().getDimensionPixelSize(R.dimen.dimen_44);
        int r2 = getResources().getDimensionPixelSize(R.dimen.dimen_32);
        this.mModeFilterBtn = (OIconButton) getLayoutInflater().inflate(R.layout.f_oic_icon_button, this.mSearchBarContainer.getMRightContainer(), false);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r1, r2);
        this.mModeFilterBtn.setLayoutParams(r3);
        this.mModeFilterBtn.setImageResource(R.drawable.oic_list_sort_down);
        this.mModeFilterBtn.setOnClickListener(this);
        this.mSearchBarContainer.addRightView(this.mModeFilterBtn);
        OCTitleBar r4 = this.mSearchBarContainer;
        OButton r5 = r4.createNeutralButton(this, r4.getMRightContainer());
        this.mSearchBarCancel = r5;
        r5.setVisibility(8);
        this.mSearchBarCancel.setText(R.string.btn_cancel);
        this.mSearchBarCancel.setOnClickListener(new AnonymousClass2(this));
        OSearchBar r6 = new OSearchBar(this);
        this.mSearchBar = r6;
        r6.getInputView().setHint(getString(R.string.search));
        this.mSearchView = this.mSearchBar.getInputView().getVInput();
        int r7 = getResources().getDimensionPixelOffset(R.dimen.dimen_8);
        this.mSearchBarContainer.getMCenterContainer().setPadding(r7, 0, r7, 0);
        this.mSearchBarContainer.getMCenterContainer().addView(this.mSearchBar);
        this.mSearchBar.getInputView().setOnTextClearedListener(new AnonymousClass3(this));
        this.mSearchView.setShowSoftInputOnFocus(true);
        this.mSearchView.setOnFocusChangeListener(new AnonymousClass4(this));
        this.mSearchView.addTextChangedListener(new AnonymousClass5(this));
        this.mSearchView.setOnEditorActionListener(new AnonymousClass6(this));
        this.mWholeView = findViewById(R.id.whole_view);
        QuickBarEx r8 = (QuickBarEx) findViewById(R.id.quickbar);
        this.mQuickBar = r8;
        if (r8 == null) goto L5;
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(r8);
        this.mQuickBar.setLongPressEnabled(false);
        this.mQuickBar.setQBListener(this.mQBListener);
        this.mQuickBar.setPoundVisibility(true);
        this.mQuickBar.setPoundPosition(1);
        this.mQuickBar.initLetters();
    L5:
        this.mListViewEmptyView = findViewById(R.id.empty_view);
        this.mListView = (StickyListHeadersListView) findViewById(R.id.listView);
        if (this.mIsSwitchMode == false) goto L8;
        this.mAdapter = new AutoStartAdapter(this, this);
    L9:
        StickyListHeadersListView r9 = this.mListView;
        if (r9 == null) goto L12;
        r9.setAreHeadersSticky(true);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setSlideListener(this);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setOnTouchListener(new AnonymousClass7(this));
    L12:
        this.mSearchResultView = findViewById(R.id.seachresultview);
        this.mSearchResultListView = (OListView) findViewById(R.id.search_listview);
        this.mSearchEmptyView = findViewById(R.id.search_empty_view);
        OListView r10 = this.mSearchResultListView;
        if (r10 == null) goto L15;
        r10.setOnItemClickListener(this);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass8(this));
    L15:
        TextView r11 = (TextView) findViewById(R.id.searchview_bg);
        this.mSearchBackground = r11;
        if (r11 == null) goto L19;
        r11.setOnClickListener(new AnonymousClass9(this));
        return;
    L19:
        return;
    L8:
        this.mAdapter = new SwitchedAdapter(this, this);
        goto L9
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mPermissionApps.refresh(true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.mSearchBar == null) goto L8;
        if (this.mSearchView.isFocused() == false) goto L8;
        cancelSearch();
        return;
    L8:
        if (resetQuickBarState() == false) goto L11;
        return;
    L11:
        if (this.mIsEdit == false) goto L13;
        this.mTitleBarRightImg.performClick();
        return;
    L13:
        super.onBackPressed();
    }

    private void cancelSearch() {
        this.mSearchView.setText("");
        this.mSearchView.clearFocus();
        this.mIsHandleClick = false;
    }

    private void prepareMenuDialog(PermissionApp info) {
        Resources r0 = getResources();
        OInsetSheet r1 = new OInsetSheet(this);
        this.mMenuDialog = r1;
        r1.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OInsetSheetTitleBar r2 = new OInsetSheetTitleBar(this);
        r2.setTitleText(r0.getString(R.string.menu_head_text, new Object[]{r0.getString(this.mTitleId)}));
        r2.setShowLeftBack(false);
        OButton r3 = r2.createNeutralButton(this, r2.mLeftContainer);
        r3.setButtonSourceBitmap(R.drawable.o_ic_close);
        r3.setOnClickListener(new AnonymousClass10(this));
        this.mMenuDialog.setHeaderView(r2);
        this.mMenuDialog.setOnDismissListener(new AnonymousClass11(this));
        View r4 = LayoutInflater.from(this).inflate(R.layout.permission_menu_item, null);
        if (this.mNativePermission.isInUseMode() == true) goto L5;
    L8:
        this.mMenuDialog.setContainerView(r4);
        this.mMenuDialog.show();
        return;
    L5:
        if (info.hasBackgroundPermission() == false) goto L7;
        OListItemSettings r6 = (OListItemSettings) r4.findViewById(R.id.permission_status_allow);
        r6.setVisibility(0);
        r6.mTrailingElement.setVisibility(8);
        r6.setOnClickListener(new AnonymousClass12(this));
    L7:
        OListItemSettings r7 = (OListItemSettings) r4.findViewById(R.id.permission_allow_in_use);
        r7.mTrailingElement.setVisibility(8);
        r7.setOnClickListener(new AnonymousClass13(this));
        OListItemSettings r8 = (OListItemSettings) r4.findViewById(R.id.permission_status_deny);
        r8.mTrailingElement.setVisibility(8);
        r8.setTitleString(r0.getString(R.string.permission_status_deny));
        r8.setOnClickListener(new AnonymousClass14(this));
        goto L8
    }

    private void initTitle() {
        initTitleBar(false);
        this.mTitleBarBackView.setOnClickListener(new AnonymousClass15(this));
        int r1 = getResources().getDimensionPixelSize(R.dimen.dimen_44);
        int r2 = getResources().getDimensionPixelSize(R.dimen.dimen_32);
        LayoutInflater r3 = getLayoutInflater();
        this.mTitleBarRightImg = (OIconButton) r3.inflate(R.layout.f_oic_icon_button, this.mTitle, false);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(r1, r2);
        this.mTitleBarRightImg.setLayoutParams(r4);
        this.mTitleBarRightImg.setImageResource(this.mRightImgEditRes);
        this.mTitle.addEndAction(this.mTitleBarRightImg, -1);
        setTitle(getResources().getString(this.mTitleId));
        this.mRightEditContainer = r3.inflate(R.layout.select_all_right_view, this.mTitle, false);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-2, r2);
        this.mRightEditContainer.setLayoutParams(r5);
        this.mTitle.addEndAction(this.mRightEditContainer, -1);
        this.mRightEditContainer.setVisibility(8);
        OCheckBox r6 = (OCheckBox) this.mRightEditContainer.findViewById(R.id.select_all_cb);
        this.mRightCheckBox = r6;
        r6.setOnClickListener(this);
        if (this.mIsSwitchMode == true) goto L5;
        this.mTitleBarRightImg.setOnClickListener(this);
        this.mTitleBarRightImg.setEnabled(false);
        return;
    L5:
        this.mTitleBarRightImg.setVisibility(8);
    }

    private List<DataUsageMenuItem> getSortMenuList() {
        int r3 = 0;
        DataUsageMenuItem r1 = new DataUsageMenuItem(getString(R.string.permission_status_all), false, 6);
        DataUsageMenuItem r2 = new DataUsageMenuItem(getString(R.string.permission_status_allow), false, SearchBar.FILTER_BY_ALLOW);
        DataUsageMenuItem r5 = new DataUsageMenuItem(getString(R.string.permission_status_deny), false, SearchBar.FILTER_BY_DENY);
        DataUsageMenuItem r7 = new DataUsageMenuItem(getString(R.string.permission_status_prompt), false, SearchBar.FILTER_BY_ALLOW_ASK);
        DataUsageMenuItem r8 = new DataUsageMenuItem(getString(R.string.permission_status_foreground_allow), false, SearchBar.FILTER_BY_INUSE);
        DataUsageMenuItem r9 = new DataUsageMenuItem(getString(R.string.permission_status_not_set), false, 7);
        DataUsageMenuItem r10 = new DataUsageMenuItem(getString(R.string.switch_open), false, SearchBar.FILTER_BY_ALLOW);
        DataUsageMenuItem r12 = new DataUsageMenuItem(getString(R.string.switch_close), false, SearchBar.FILTER_BY_DENY);
        DataUsageMenuItem r13 = new DataUsageMenuItem(getString(R.string.background_network_allow), false, 10);
        DataUsageMenuItem r14 = new DataUsageMenuItem(getString(R.string.background_network_reject_screen_off), false, 11);
        DataUsageMenuItem r4 = new DataUsageMenuItem(getString(R.string.background_network_reject), false, 12);
        DataUsageMenuItem r6 = new DataUsageMenuItem(getString(R.string.permission_allow_in_use), false, 13);
        DataUsageMenuItem r11 = new DataUsageMenuItem(getString(R.string.permission_allow_button), false, 7);
        DataUsageMenuItem r15 = new DataUsageMenuItem(getString(R.string.permission_status_deny), false, 8);
        if (this.mIsSwitchMode == false) goto L5;
        char r16 = 2;
    L6:
        ArrayList r17 = new ArrayList();
        r17.add(r1);
        switch(r16) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L17;
        };
    L9:
        r17.add(r11);
        r17.add(r15);
        goto L17
    L10:
        r17.add(r2);
        r17.add(r6);
        r17.add(r5);
        goto L17
    L11:
        r17.add(r13);
        r17.add(r14);
        r17.add(r4);
        goto L17
    L12:
        r17.add(r9);
        r17.add(r2);
        r17.add(r7);
        r17.add(r5);
        goto L17
    L13:
        r17.add(r9);
        r17.add(r2);
        r17.add(r8);
        r17.add(r5);
        goto L17
    L14:
        r17.add(r10);
        r17.add(r12);
        goto L17
    L15:
        r17.add(r2);
        r17.add(r5);
    L17:
        if (r3 >= r17.size()) goto L22;
        DataUsageMenuItem r18 = (DataUsageMenuItem) r17.get(r3);
        if (r18.getValue() == this.mCurrentSortMode) goto L20;
        r3 = r3 + 1;
        goto L17
    L20:
        r18.setSelected(true);
    L22:
        return r17;
    L5:
        this.mNativePermission.isInUseMode();
        r16 = 6;
        goto L6
    }

    private void showSortDialog(View anchorView) {
        OPopover.Builder r1 = new OPopover.Builder(this);
        this.mSortDialog = null;
        final Function r2 = new NativeRadioPermissions$$ExternalSyntheticLambda0(this);
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder(this);
        r13.enableOption();
        final List<DataUsageMenuItem> r14 = getSortMenuList();
        int r12 = 0;
    L4:
        if (r12 >= r14.size()) goto L6;
        DataUsageMenuItem r3 = r14.get(r12);
        r13.addPopoverRightOptionItem(false, 0, 0, Integer.valueOf(getColor(R.color.oui_accent_fg)), r3.getTitle(), null, false, r3.isSelected(), new AnonymousClass16(this, r14, r2));
        r12 = r12 + 1;
        goto L4
    L6:
        OPopover r4 = r1.setView(r13.build()).setGravity(48).build();
        OPopoverHelper.INSTANCE.showPopoverSmartly(r4, anchorView, 48, false, 0.0f, 0, 0);
        this.mSortDialog = r4;
    }

    /* JADX INFO: renamed from: lambda$showSortDialog$0$com-bytedanceos-security-permission-NativeRadioPermissions, reason: not valid java name */
    /* synthetic */ Unit m129x1b44ff13(Unit r2) {
        OPopover r3 = this.mSortDialog;
        if (r3 == null) goto L5;
        r3.dismiss();
        this.mSortDialog = null;
    L5:
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (view != this.mTitleBarRightImg) goto L16;
        if (this.mIsAnimating == false) goto L11;
        return;
    L11:
        if (this.mSearchView.isFocused() == true) goto L13;
        resetQuickBarState();
        clickBtnEdit();
    L13:
        resetHandleClickState();
        return;
    L16:
        if (view != this.mPermissionAllow) goto L19;
        setPermissionsForList(true, true);
    L27:
        int r4 = view.getId();
        if (r4 != R.id.checkbox_select_all) goto L30;
    L32:
        this.mIsHandleClick = false;
        if (this.mBtnSelectAll.isChecked() == true) goto L35;
        this.mSelectedInfos.clear();
    L36:
        this.mAdapter.notifyDataSetChanged();
        recoverQuickBar();
        updateSelectDesc();
    L37:
        resetHandleClickState();
        return;
    L35:
        this.mSelectedInfos.clear();
        this.mSelectedInfos.addAll(this.mAdapter.getDatas());
        goto L36
    L30:
        if (r4 == R.id.select_all_cb) goto L32;
    L19:
        if (view != this.mPermissionAsk) goto L22;
        setPermissionsForList(true, false);
        goto L27
    L22:
        if (view != this.mPermissionDeny) goto L25;
        setPermissionsForList(false, false);
        goto L27
    L25:
        if (view != this.mModeFilterBtn) goto L27;
        showSortDialog(view);
        goto L27
    }

    private void setPermissionsForList(final boolean fowardGrant, final boolean backGrant) {
        Task.execute(new AnonymousClass17(this, fowardGrant, backGrant), new AnonymousClass18(this), "setPermissionsForList2");
    }

    private void clickBtnEdit() {
        initOptionBar();
        if (this.mIsEdit == false) goto L5;
        this.mTitleBarRightImg.setImageResource(this.mRightImgEditRes);
        setTitle(getResources().getString(this.mTitleId));
        this.mTitleBarRightImg.setVisibility(0);
        this.mBottomBar.setVisibility(8);
        this.mListView.setSlideEnable(false);
        this.mSelectedInfos.clear();
        this.mSearchBar.setEnabled(true);
    L6:
        processEditChanged(!this.mIsEdit, this.mListView.getWrappedList());
        return;
    L5:
        this.mTitleBarRightImg.setImageResource(this.mRightImgCancelRes);
        this.mBottomBar.setVisibility(0);
        updateSelectDesc();
        this.mListView.setSlideEnable(true);
        this.mSearchBar.setEnabled(false);
        goto L6
    }

    private void initOptionBar() {
        ViewStub r0 = (ViewStub) findViewById(R.id.option_bar_vs);
        this.mOptionBarVS = r0;
        if (r0 == null) goto L7;
        r0.inflate();
        this.mEditBarView = findViewById(R.id.option_bar);
        this.mSelectFiles = (TextView) findViewById(R.id.option_title);
        OCheckBox r1 = (OCheckBox) findViewById(R.id.checkbox_select_all);
        this.mBtnSelectAll = r1;
        if (r1 == null) goto L7;
        r1.setOnClickListener(this);
    L7:
        View r2 = findViewById(R.id.net_list_control);
        this.mBottomBar = r2;
        if (r2 == null) goto L11;
        addButtonTab(r2);
        return;
    }

    private void performAnimationForEdit(final boolean isEdit, OListView targetListView) {
        this.mIsEdit = isEdit;
        ArrayList<Animator> r2 = getEditAnimators(isEdit, targetListView);
        AnimatorSet r3 = new AnimatorSet();
        r3.addListener(new AnonymousClass19(this));
        r3.playTogether(r2);
        r3.start();
    }

    private void processEditChanged(boolean isEdit, OListView targetListView) {
        this.mIsEdit = isEdit;
        this.mAdapter.setEdit(isEdit);
        if (this.mIsEdit == false) goto L5;
        this.mSearchBarContainer.setVisibility(8);
        this.mEditBarView.setVisibility(0);
    L6:
        this.mAdapter.notifyDataSetChanged();
        return;
    L5:
        this.mEditBarView.setVisibility(8);
        this.mSearchBarContainer.setVisibility(0);
        goto L6
    }

    private ArrayList<Animator> getEditAnimators(boolean isEdit, OListView targetListView) {
        ArrayList<Animator> r2 = new ArrayList();
        int r3 = this.mSearchBarContainer.getWidth();
        int r4 = targetListView.getFirstVisiblePosition();
        int r5 = targetListView.getLastVisiblePosition();
        if (this.mDecelerateInterpolator != null) goto L5;
        this.mDecelerateInterpolator = new LinearInterpolator();
    L5:
        ListAdapter r6 = targetListView.getAdapter();
        if (isEdit == false) goto L24;
        Utils.AnimatorInfo r22 = r15;
        Utils.AnimatorInfo r15 = new Utils.AnimatorInfo("translationX", this.mDuration, 0, this.mDecelerateInterpolator, new float[]{0.0f, this.mItemTranslateX});
        long r10 = this.mDuration;
        Utils.AnimatorInfo r7 = new Utils.AnimatorInfo("scaleX", r10, r10, this.mDecelerateInterpolator, new float[]{0.1f, 1.0f});
        long r11 = this.mDuration;
        Utils.AnimatorInfo r8 = new Utils.AnimatorInfo("scaleY", r11, r11, this.mDecelerateInterpolator, new float[]{0.1f, 1.0f});
        long r14 = this.mDuration;
        Utils.AnimatorInfo r12 = new Utils.AnimatorInfo("alpha", r14, r14, this.mDecelerateInterpolator, new float[]{0.0f, 1.0f});
        int r13 = r4;
    L8:
        if (r13 > r5) goto L23;
        if (r13 >= r6.getCount()) goto L23;
        View r16 = targetListView.getChildAt(r13 - r4);
        if (r16 != null) goto L15;
    L14:
        Utils.AnimatorInfo r17 = r22;
    L22:
        r13 = r13 + 1;
        r22 = r17;
        goto L8
    L15:
        View r18 = r16.findViewById(R.id.app_info);
        if (r18 == null) goto L14;
        r18.setVisibility(0);
        r17 = r22;
        r2.add(Utils.makePropertyAnimator(r17, r18));
        CheckBox r19 = (CheckBox) r16.findViewById(R.id.checkBox);
        if (r19 == null) goto L21;
        r19.setVisibility(0);
        r19.setAlpha(0.0f);
        r19.setChecked(false);
    L21:
        r2.add(Utils.makePropertyAnimator(r7, r19));
        r2.add(Utils.makePropertyAnimator(r8, r19));
        r2.add(Utils.makePropertyAnimator(r12, r19));
    L23:
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{0.0f, r3});
        r1.setDuration(this.mDuration);
        r2.add(r1);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.mEditBarView, "translationX", new float[]{-r3, 0.0f});
        r9.setDuration(this.mDuration);
        r2.add(r9);
    L41:
        return r2;
    L24:
        Utils.AnimatorInfo r20 = new Utils.AnimatorInfo("scaleX", this.mDuration, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.1f});
        Utils.AnimatorInfo r21 = new Utils.AnimatorInfo("scaleY", this.mDuration, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.1f});
        Utils.AnimatorInfo r110 = new Utils.AnimatorInfo("alpha", this.mDuration, 0, this.mDecelerateInterpolator, new float[]{1.0f, 0.0f});
        Utils.AnimatorInfo r111 = new Utils.AnimatorInfo("translationX", this.mDuration, 0, this.mDecelerateInterpolator, new float[]{this.mItemTranslateX, 0.0f});
        int r23 = r4;
    L25:
        if (r23 > r5) goto L40;
        if (r23 >= r6.getCount()) goto L40;
        View r112 = targetListView.getChildAt(r23 - r4);
        if (r112 == null) goto L39;
        View r113 = r112.findViewById(R.id.app_info);
        if (r113 == null) goto L39;
        View r114 = r112.findViewById(R.id.checkBox);
        if (r114 == null) goto L38;
        r114.setVisibility(0);
    L38:
        r2.add(Utils.makePropertyAnimator(r20, r114));
        r2.add(Utils.makePropertyAnimator(r21, r114));
        r2.add(Utils.makePropertyAnimator(r110, r114));
        r113.setVisibility(0);
        r2.add(Utils.makePropertyAnimator(r111, r113));
    L39:
        r23 = r23 + 1;
    L40:
        ObjectAnimator r24 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{r3, 0.0f});
        r24.setDuration(this.mDuration);
        r2.add(r24);
        ObjectAnimator r25 = ObjectAnimator.ofFloat(this.mEditBarView, "translationX", new float[]{0.0f, -r3});
        r25.setDuration(this.mDuration);
        r2.add(r25);
        goto L41
    }

    public void showMenuDialog(PermissionApp info) {
        OInsetSheet r0 = this.mMenuDialog;
        if (r0 != null) goto L5;
    L7:
        prepareMenuDialog(info);
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mMenuDialog.dismiss();
        goto L7
    }

    protected void onMenuItemClick(int position) {
        if (position != 0) goto L5;
        savePermissionStatus(this.mLastClickItem, true, true);
    L12:
        this.mMenuDialog.dismiss();
        return;
    L5:
        if (position != 2) goto L7;
        savePermissionStatus(this.mLastClickItem, false, false);
        goto L12
    L7:
        if (position != 3) goto L12;
        savePermissionStatus(this.mLastClickItem, true, false);
        goto L12
    }

    protected void savePermissionStatus(final PermissionApp entry, final boolean grant, final boolean backgrant) {
        if (entry != null) goto L5;
        return;
    L5:
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this, entry) == false) goto L8;
        RiskPermissionControlGuard.showBlockedToast(this);
        return;
    L8:
        this.mSingleThreadExecutor.execute(new AnonymousClass20(this, grant, entry, backgrant));
    }

    private void updateUiAfterChange() {
        if (this.mSearchView.isFocused() == false) goto L20;
        if (this.mCurrentSortMode == 6) goto L13;
        ArrayList r0 = new ArrayList();
        Iterator<PermissionApp> r1 = this.mDataList.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        PermissionApp r3 = r1.next();
        if (isModeApp(r3, this.mCurrentSortMode) == false) goto L8;
        r0.add(r3);
        goto L8
    L12:
        this.mAdapter.setData(r0, true);
    L14:
        this.mAdapter.notifyDataSetChanged();
        this.mListViewEmptyView.setVisibility(8);
        SwitchedAdapter r2 = this.mSearchAdapter;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.getCount() <= 0) goto L35;
        this.mSearchAdapter.notifyDataSetChanged();
        return;
    L35:
        return;
    L13:
        this.mAdapter.setData(this.mDataList, true);
        goto L14
    L20:
        if (this.mCurrentSortMode == 6) goto L27;
        List<PermissionApp> r4 = this.mAdapter.getDatas();
        if (isModeApp(this.mLastClickItem, this.mCurrentSortMode) == true) goto L24;
        r4.remove(this.mLastClickItem);
    L24:
        int r5 = this.mListView.getFirstVisiblePosition();
        this.mAdapter.setData(r4, true);
        if (r5 <= 0) goto L27;
        this.mListView.setSelection(r5);
    L27:
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.bytedanceos.security.permission.PermissionApps.Callback
    public void onPermissionsLoaded(PermissionApps permissionApps) {
        List<PermissionApp> r5 = permissionApps.getApps();
        List<PermissionApp> r0 = this.mAdapter.getDatas();
        int r1 = 0;
        if (r5 != null) goto L5;
    L11:
        int r2 = 0;
    L12:
        this.mAdapter.setData(r5, true);
        this.mDataList = r5;
        View r6 = findViewById(R.id.package_loading_text);
        if (r6 == null) goto L15;
        r6.setVisibility(8);
    L15:
        if (r1 != 0) goto L17;
        if (r2 != 0) goto L17;
        return;
    L17:
        this.mListView.setRealSelectionFromTop(r1, r2);
        return;
    L5:
        if (r0.size() <= 0) goto L11;
        OListView r3 = this.mListView.getWrappedList();
        int r4 = r3.getFirstVisiblePosition();
        View r7 = r3.getChildAt(0);
        if (r7 == null) goto L10;
        r1 = r7.getTop();
    L10:
        r2 = r1;
        r1 = r4;
        goto L12
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        if (this.mIsHandleClick == false) goto L9;
        return;
    L9:
        if (this.mSearchView.isFocused() == false) goto L15;
        SwitchedAdapter r1 = this.mSearchAdapter;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.getCount() > position) goto L21;
        return;
    L21:
        if (position <= this.mAdapter.getCount()) goto L24;
        LogTag.w(TAG, "[onItemClick]: must some wrong position=" + position + " adapter size=" + this.mAdapter.getCount());
    L24:
        if (this.mSearchView.isFocused() == false) goto L26;
        PermissionApp r2 = this.mSearchAdapter.getItem(position);
    L27:
        hideIME();
        if (this.mIsEdit == true) goto L30;
        this.mIsHandleClick = true;
        this.mLastClickItem = r2;
        if (this.mIsSwitchMode == true) goto L37;
        showMenuDialog(r2);
    L37:
        resetHandleClickState();
        return;
    L30:
        if (this.mSelectedInfos.contains(r2) == false) goto L32;
        setChecked(position, false);
        return;
    L32:
        setChecked(position, true);
        return;
    L26:
        r2 = this.mAdapter.getItem(position - this.mListView.getHeaderViewsCount());
        goto L27
    L15:
        SwitchedAdapter r3 = this.mAdapter;
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.getCount() != 0) goto L21;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public boolean onModeChange(int sortMode) {
        this.mLastClickItem = null;
        List<PermissionApp> r0 = new ArrayList();
        if (6 != sortMode) goto L6;
        r0 = this.mDataList;
    L22:
        if (r0 != null) goto L24;
    L27:
        this.mAdapter.setData(r0, false);
        this.mAdapter.notifyDataSetChanged();
    L28:
        this.mCurrentSortMode = sortMode;
        return true;
    L24:
        if (r0.size() == 0) goto L27;
        this.mAdapter.setData(r0, true);
        goto L28
    L6:
        if (SearchBar.FILTER_BY_ALLOW != sortMode) goto L8;
    L15:
        Iterator<PermissionApp> r1 = this.mDataList.iterator();
    L17:
        if (r1.hasNext() == false) goto L22;
        PermissionApp r2 = r1.next();
        if (isModeApp(r2, sortMode) == false) goto L17;
        r0.add(r2);
        goto L17
    L8:
        if (SearchBar.FILTER_BY_ALLOW_ASK == sortMode) goto L15;
        if (SearchBar.FILTER_BY_INUSE == sortMode) goto L15;
        if (SearchBar.FILTER_BY_DENY == sortMode) goto L15;
        if (13 != sortMode) goto L22;
        goto L15
    }

    private boolean isModeApp(PermissionApp app, int sortMode) {
        if (app != null) goto L6;
        return false;
    L6:
        if (sortMode != 6) goto L8;
        return true;
    L8:
        boolean r1 = app.areRuntimePermissionsGranted();
        boolean r3 = app.areBackgroudPermissionGranted();
        if (sortMode != SearchBar.FILTER_BY_ALLOW) goto L18;
        if (this.mNativePermission.isLocationPermission() == false) goto L35;
        if (app.hasBackgroundPermission() == false) goto L29;
        if (r1 == false) goto L30;
        if (r3 == true) goto L32;
        return false;
    L32:
        return true;
    L30:
        return false;
    L29:
        return false;
    L35:
        return r1;
    L18:
        if (sortMode != 13) goto L26;
        if (app.hasBackgroundPermission() == false) goto L35;
        if (r1 == false) goto L33;
        if (r3 == false) goto L32;
        return false;
    L33:
        return false;
    L26:
        if (sortMode == SearchBar.FILTER_BY_DENY) goto L28;
        return false;
    L28:
        return !r1;
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void setSoftKeyboardHide() {
        hideIME();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void startSearchAnimation() {
        initStartSearchAnimation();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimation() {
        startEndSearchAnimation();
        resetOkButton();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void onQueryTextChange(String newString) {
        search(newString);
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void hideQuickContactView() {
        this.mIsHandleClick = true;
        resetHandleClickState();
        resetQuickBarState();
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void endSearchAnimationWithoutAnimation() {
        Utils.setAnimatorScale(this);
        this.mWholeView.setTranslationY(0.0f);
        this.mSearchResultView.setAlpha(0.0f);
        searchAnimationEnd();
        OInsetSheet r2 = this.mMenuDialog;
        if (r2 == null) goto L6;
        r2.cancel();
        return;
    }

    private void resetOkButton() {
        if (this.mAdapter.isEmpty() == true) goto L5;
        this.mTitleBarRightImg.setEnabled(true);
        setQuickBarVisibility();
        return;
    L5:
        this.mTitleBarRightImg.setEnabled(false);
    }

    protected void searchAnimationEnd() {
        this.mWholeView.postDelayed(new AnonymousClass21(this), 30);
    }

    @Override // com.bytedanceos.security.widget.SearchBar.Listener
    public void recoverQuickBar() {
        this.mQuickBar.hideLetterGrid();
    }

    private void hideIME() {
        Utils.hideInputMethod(this, getWindow().getDecorView().getWindowToken());
    }

    private void initStartSearchAnimation() {
        if (this.mStartSearchAnim != null) goto L5;
        this.mTitleBarHeight = this.mTitle.getHeight() + 2;
        Utils.setAnimatorScale(this);
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mTitleBarHeight})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(200);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass23(this));
    L5:
        this.mStartSearchAnim.start();
        resetHandleClickState();
    }

    private void resetHandleClickState() {
        this.mWholeView.postDelayed(new AnonymousClass24(this), 500);
    }

    private void startEndSearchAnimation() {
        isFromSecurityCenter();
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitleBarHeight, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass25(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void setQuickBarVisibility() {
        if (this.mQuickBar == null) goto L18;
        SwitchedAdapter r0 = this.mAdapter;
        int r1 = 0;
        if (r0 != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        QuickBarEx r3 = this.mQuickBar;
        if (r2 == true) goto L16;
        r1 = 8;
    L16:
        r3.setVisibility(r1);
        return;
    L7:
        if (r0.getCount() < MAX_NUMBER) goto L11;
        if (this.mSearchView.isFocused() == true) goto L11;
        r2 = true;
        goto L12
    }

    private boolean resetQuickBarState() {
        if (this.mQuickBar.isLetterGridShow() == false) goto L6;
        this.mQuickBar.hideLetterGrid(true);
        return true;
    L6:
        return false;
    }

    private void search(String keyword) {
        if (keyword != null) goto L4;
        return;
    L4:
        if (keyword.trim().equals(this.lastQueryText) == true) goto L25;
        this.lastQueryText = keyword.trim();
        if (TextUtils.isEmpty(keyword) == true) goto L9;
    L13:
        this.mListView.setEmptyView(null);
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        this.mSearchResultList = this.mAdapter.query(keyword);
        if (this.mSearchAdapter == null) goto L16;
    L20:
        this.mSearchAdapter.setData(this.mSearchResultList, false);
        return;
    L16:
        if (this.mIsSwitchMode == false) goto L18;
        this.mSearchAdapter = new AutoStartAdapter(this, this);
    L19:
        this.mSearchResultListView.setAdapter(this.mSearchAdapter);
        goto L20
    L18:
        this.mSearchAdapter = new SearchAdapter(this, this);
        goto L19
    L9:
        if (this.mSearchView.isFocused() == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        if (this.mAdapter.getCount() > 0) goto L23;
        this.mListView.setEmptyView(this.mListViewEmptyView);
        return;
    L23:
        return;
    }

    private String getStatusText(PermissionApp entry) {
        LogTag.d(TAG, " " + entry.getPackageName() + ", permission granted = " + entry.areRuntimePermissionsGranted());
        boolean r0 = entry.areRuntimePermissionsGranted();
        boolean r3 = entry.areBackgroudPermissionGranted();
        if (r0 == false) goto L6;
        if (r3 == false) goto L6;
        return getResources().getString(R.string.permission_status_allow);
    L6:
        if (r0 == false) goto L9;
        return getResources().getString(R.string.permission_allow_in_use);
    L9:
        return getResources().getString(R.string.permission_status_deny);
    }

    private void addButtonTab(View bar) {
        OButton r0 = (OButton) bar.findViewById(R.id.permission_status_allow);
        this.mPermissionAllow = r0;
        r0.setOnClickListener(this);
        this.mPermissionAsk = (OButton) bar.findViewById(R.id.permission_status_prompt);
        if (this.mNativePermission.isInUseMode() == false) goto L5;
        this.mPermissionAsk.setVisibility(8);
        OButton r1 = (OButton) bar.findViewById(R.id.permission_allow_in_use);
        this.mPermissionAsk = r1;
        r1.setVisibility(0);
    L5:
        this.mPermissionAsk.setOnClickListener(this);
        if (this.mHidePrompt == false) goto L8;
        this.mPermissionAsk.setVisibility(8);
    L8:
        OButton r4 = (OButton) bar.findViewById(R.id.permission_status_deny);
        this.mPermissionDeny = r4;
        r4.setOnClickListener(this);
    }

    private ButtonTabGroup createButtonTabGroup(TitleBar bar) {
        ArrayList r0 = new ArrayList();
        r0.add(getResources().getString(R.string.permission_status_allow));
        r0.add(getResources().getString(R.string.permission_status_prompt));
        r0.add(getResources().getString(R.string.permission_status_deny));
        return BarsHelper.createTabBuilder(this, bar).setAttachMode(false).setHasGap(true).setBigFilterTwoTabs(false).setStringData(r0).build();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.mSearchView.isFocused() == false) goto L5;
        cancelSearch();
        this.mListView.setVisibility(0);
    L5:
        resetQuickBarState();
    }

    private void sendPermissionChangeBroadCast(PermissionApp entry, boolean granted) {
        if (entry == null) goto L10;
        NativePermission r0 = this.mNativePermission;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getPermissions() == null) goto L12;
        Intent r1 = new Intent(DangerousPermissionUtil.BROADCAST_PERMISSION_CHANGE_ACTION);
        r1.putExtra("package", entry.getPackageName());
        r1.putExtra("uid", entry.getUid());
        r1.putExtra("permission", this.mNativePermission.getPermissions()[0]);
        r1.putExtra("granted", granted);
        r1.putExtra(DBHelper.BATTERY_COL_SOURCE, 2);
        sendBroadcast(r1);
        return;
    L12:
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(0);
        BroadcastReceiver r0 = this.mPackageReceiver;
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
        this.mPackageReceiver = null;
    L6:
        if (Utils.isDesktop(this) == false) goto L10;
        PermissionReceiver r1 = this.mPermissionReceiver;
        if (r1 == null) goto L10;
        unregisterReceiver(r1);
        this.mPermissionReceiver = null;
    L10:
        ExecutorService r2 = this.mSingleThreadExecutor;
        if (r2 == null) goto L14;
        r2.shutdown();
        return;
    }
}
