package com.bytedanceos.security;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.res.Resources;
import android.graphics.Point;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import bytedanceos.util.LogTag;
import com.bytedanceos.application.AppComparator;
import com.bytedanceos.application.AppEntry;
import com.bytedanceos.application.AppListLoader;
import com.bytedanceos.datausage.DataUsageMenuItem;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.permission.RiskPermissionControlGuard;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.bytedanceos.security.widget.QuickBarEx;
import com.bytedanceos.security.widget.SearchBar;
import com.bytedanceos.security.widget.SlideListView;
import com.bytedanceos.security.widget.pinyin.PinyinUtils;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersAdapter;
import com.bytedanceos.security.widget.stickylistheaders.StickyListHeadersListView;
import com.bytedanceos.utils.NavigationBarHelper;
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
import java.util.function.Function;
import kotlin.Unit;
import obric.widget.BarsHelper;
import obric.widget.ButtonTabGroup;
import obric.widget.TitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class RadioPermissions extends BaseActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<List<AppEntry>>, AdapterView.OnItemClickListener, SearchBar.Listener, SlideListView.Listener {
    private static final String ACTION_UNKOWNED_RESOURCE = "android.settings.MANAGE_UNKNOWN_APP_SOURCES";
    private static final int ANIM_DURATION = 200;
    private static final int ANIM_START_DELAY = 10;
    private static int MAX_NUMBER = 30;
    private static final String TAG = "RadioPermissions";
    private int animInLeft;
    private int animOutRight;
    private String lastQueryText;
    SwitchedAdapter mAdapter;
    private AppListLoader mAppListLoader;
    private CompoundButton.OnCheckedChangeListener mAutoStartCheckChangeListener;
    private View mBottomBar;
    private OCheckBox mBtnSelectAll;
    private int mCurrentSortMode;
    private List<AppEntry> mDataList;
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
    boolean mIsLocation;
    private boolean mIsSwitchMode;
    private float mItemTranslateX;
    AppEntry mLastClickItem;
    private SearchAction mLastSearch;
    private StickyListHeadersListView mListView;
    private View mListViewEmptyView;
    private OInsetSheet mMenuDialog;
    private OIconButton mModeFilterBtn;
    private ViewStub mNetListControlVS;
    int[] mOps;
    OpsManagerHelper mOpsManagerHelper;
    private ViewStub mOptionBarVS;
    private Point mOutSize;
    BroadcastReceiver mPackageReceiver;
    private int mPermissioIndex;
    private OButton mPermissionAllow;
    private OButton mPermissionAsk;
    private OButton mPermissionDeny;
    String[] mPermissions;
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
    private ArrayList<AppEntry> mSearchResultList;
    private OListView mSearchResultListView;
    private View mSearchResultView;
    private EditText mSearchView;
    private ArrayList<String> mSections;
    private TextView mSelectFiles;
    private ArrayList<AppEntry> mSelectedInfos;
    private OPopover mSortDialog;
    private AnimatorSet mStartSearchAnim;
    private int mTitleBarHeight;
    private ImageView mTitleBarRightImg;
    private int mTitleId;
    private AlertDialog mWarningDialog;
    private View mWholeView;

    public class AutoStartAdapter extends SwitchedAdapter {
        final /* synthetic */ RadioPermissions this$0;

        public AutoStartAdapter(final RadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(this$0, context);
        }

        @Override // com.bytedanceos.security.RadioPermissions.SwitchedAdapter, android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int position, View convertView, ViewGroup parent) {
            AppEntry r5 = (AppEntry) getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(R.layout.autostart_item_scroll_layout, null);
            AutoStartViewHolder r0 = new AutoStartViewHolder(convertView);
            convertView.setTag(r0);
        L6:
            r0.item.setTitleString(r5.getLabel());
            OuiWidgetUtils.initDopplegangerBadge(r0.item, r5.getIcon(), r5.isDoppleganger);
            boolean r2 = false;
            r0.item.getMTrailingElement().getChildAt(0).setTag(r5);
            r0.item.setOnCheckedChangeListener(null);
            OListItemSwitch r7 = r0.item;
            int r6 = r5.getMode();
            OpsManagerHelper r1 = this.this$0.mOpsManagerHelper;
            if (r6 != OpsManagerHelper.get_MODE_ALLOWED()) goto L9;
            r2 = true;
        L9:
            r7.setChecked(r2);
            r0.item.setOnCheckedChangeListener(RadioPermissions.access$3000(this.this$0));
            return convertView;
        L5:
            r0 = (AutoStartViewHolder) convertView.getTag();
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

    private class SearchAction {
        private String keyword;
        private ArrayList<AppEntry> searchResult;
        final /* synthetic */ RadioPermissions this$0;

        public SearchAction(final RadioPermissions this$0, String keyword, ArrayList<AppEntry> list) {
            this.this$0 = this$0;
            this.keyword = keyword;
            this.searchResult = list;
        }
    }

    private class SearchAdapter extends SwitchedAdapter {
        final /* synthetic */ RadioPermissions this$0;

        public SearchAdapter(final RadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(this$0, context);
        }
    }

    public class SwitchedAdapter extends ArrayAdapter<AppEntry> implements AbsListView.RecyclerListener, StickyListHeadersAdapter {
        protected List<AppEntry> mEntries;
        LayoutInflater mInflater;
        private boolean mIsEdit;
        private View.OnClickListener mOnClickListener;
        final /* synthetic */ RadioPermissions this$0;

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
        }

        public SwitchedAdapter(final RadioPermissions this$0, Context context) {
            this.this$0 = this$0;
            super(context, RadioPermissions.access$2000(this$0));
            this.mEntries = new ArrayList();
            this.mIsEdit = false;
            this.mOnClickListener = new AnonymousClass1(this);
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public List<AppEntry> getDatas() {
            return this.mEntries;
        }

        public void setEdit(boolean isEdit) {
            this.mIsEdit = isEdit;
        }

        public void setData(List<AppEntry> data, boolean initSections) {
            RadioPermissions.access$1400(this.this$0).setEmptyView(RadioPermissions.access$2100(this.this$0));
            clear();
            resetSelecteds(data);
            this.mEntries = data;
            if (data == null) goto L18;
            if (data.size() <= 0) goto L18;
            Collections.sort(data, AppComparator.ALPHA_COMPARATOR);
            addAll(data);
            OCTitleBar r4 = RadioPermissions.access$2200(this.this$0);
            if (getCount() <= 0) goto L9;
            int r2 = 0;
        L10:
            r4.setVisibility(r2);
            if (initSections == false) goto L14;
            initSections();
        L14:
            if (RadioPermissions.access$2300(this.this$0) == true) goto L16;
            RadioPermissions.access$2400(this.this$0).setEnabled(true);
            RadioPermissions.access$2400(this.this$0).setVisibility(0);
        L16:
            RadioPermissions.access$2100(this.this$0).setVisibility(8);
        L22:
            RadioPermissions.access$1700(this.this$0);
            return;
        L9:
            r2 = 8;
        L18:
            if (RadioPermissions.access$2500(this.this$0).isFocused() == false) goto L20;
            RadioPermissions.access$2100(this.this$0).setVisibility(8);
        L21:
            RadioPermissions.access$2400(this.this$0).setEnabled(false);
            goto L22
        L20:
            RadioPermissions.access$2100(this.this$0).setVisibility(0);
            RadioPermissions.access$2400(this.this$0).setVisibility(8);
            goto L21
        }

        private void resetSelecteds(List<AppEntry> datas) {
            if (RadioPermissions.access$2600(this.this$0).size() > 0) goto L5;
            return;
        L5:
            ArrayList r0 = new ArrayList();
            Iterator<AppEntry> r8 = datas.iterator();
        L7:
            if (r8.hasNext() == false) goto L23;
            AppEntry r1 = r8.next();
            Iterator r2 = RadioPermissions.access$2600(this.this$0).iterator();
        L10:
            if (r2.hasNext() == false) goto L7;
            AppEntry r3 = (AppEntry) r2.next();
            int r5 = 0;
            if (r1.getApplicationInfo() != null) goto L14;
            int r4 = 0;
        L16:
            if (r3.getApplicationInfo() == null) goto L19;
            r5 = r3.getApplicationInfo().uid;
        L19:
            if (r4 != r5) goto L10;
            if (TextUtils.equals(r1.getPackageName(), r3.getPackageName()) == false) goto L10;
            r0.add(r1);
            goto L10
        L14:
            r4 = r1.getApplicationInfo().uid;
            goto L16
        L23:
            RadioPermissions.access$2600(this.this$0).clear();
            if (r0.size() <= 0) goto L35;
            RadioPermissions.access$2600(this.this$0).addAll(r0);
            return;
        }

        public ArrayList<AppEntry> query(String input) {
            ArrayList<AppEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(input) == true) goto L17;
            List<AppEntry> r5 = this.mEntries;
            String r6 = input.toUpperCase();
            if (r5 == null) goto L17;
            Iterator<AppEntry> r7 = r5.iterator();
        L8:
            if (r7.hasNext() == false) goto L17;
            AppEntry r1 = r7.next();
            boolean r2 = r1.getLabel().toUpperCase().contains(r6);
            boolean r3 = r1.mLabelEntry.firstLetters.toUpperCase().contains(r6);
            if (PinyinUtils.isChinese(r6) == true) goto L12;
            boolean r4 = r1.mLabelEntry.labelPinyin.toUpperCase().contains(r6);
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
            AppEntry r9 = getItem(position);
            if (convertView != null) goto L5;
            convertView = this.mInflater.inflate(R.layout.application_item_scroll_layout, null);
            ViewHolder r1 = new ViewHolder(convertView, this.mInflater.inflate(R.layout.single_checkbox, null));
            convertView.setTag(r1);
        L6:
            r1.checkBox.setOnClickListener(this.mOnClickListener);
            r1.checkBox.setTag(Integer.valueOf(position));
            ViewGroup r0 = r1.item.getMLeadingElement();
            if (this.mIsEdit == false) goto L9;
            int r2 = 0;
        L10:
            r0.setVisibility(r2);
            updateCheckBox(r1.item, r1.checkBox, this.mIsEdit, RadioPermissions.access$2600(this.this$0).contains(getItem(position)));
            r1.item.setTitleString(r9.getLabel());
            r1.item.setContentImage(r9.getIcon());
            r1.item.setDoppleganger(r9.isDoppleganger);
            r1.item.setTrailingText(RadioPermissions.access$2700(this.this$0, r9));
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
            RadioPermissions.access$1500(this.this$0).clear();
            RadioPermissions.access$2800(this.this$0).clear();
            List<AppEntry> r0 = this.mEntries;
            if (r0.size() <= 0) goto L11;
            String r2 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            RadioPermissions.access$1500(this.this$0).add(r2);
            RadioPermissions.access$2800(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
            int r1 = 1;
        L6:
            if (r1 >= r0.size()) goto L15;
            String r3 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r2.equals(r3) == true) goto L10;
            RadioPermissions.access$1500(this.this$0).add(r3);
            RadioPermissions.access$2800(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r2 = r3;
        L10:
            r1 = r1 + 1;
            goto L6
        L15:
            return;
        }

        private void updateCheckBox(View mPicFrameView, OCheckBox mCheckBox, boolean isEditMode, boolean isCheck) {
            if (isEditMode == false) goto L9;
            if (RadioPermissions.access$700(this.this$0) == true) goto L7;
            mCheckBox.setVisibility(0);
        L7:
            mCheckBox.setChecked(isCheck);
            return;
        L9:
            if (RadioPermissions.access$700(this.this$0) == true) goto L13;
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
            List<AppEntry> r2 = this.mEntries;
            if (r2.get(position).mLabelEntry == null) goto L11;
            String r3 = Character.toString(r2.get(position).mLabelEntry.firstChar);
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
            List<AppEntry> r1 = this.mEntries;
            if (r1.get(position).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(position).mLabelEntry.firstChar;
        }

        public int getPositionForSection(int section) {
            Integer r0 = (Integer) RadioPermissions.access$2800(this.this$0).get(Character.valueOf((char) section));
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

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<AppEntry>> loader) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
    }

    public RadioPermissions() {
        this.mIgnore = false;
        this.mIsLocation = false;
        this.mOpsManagerHelper = null;
        this.mAdapter = null;
        this.mPermissions = null;
        this.mOps = null;
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
        this.mPermissioIndex = -1;
        this.mIsAnimating = false;
        this.mQBListener = new AnonymousClass20(this);
        this.mAutoStartCheckChangeListener = new AnonymousClass24(this);
    }

    static /* synthetic */ void access$000(RadioPermissions r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ OIconButton access$100(RadioPermissions r0) {
        return r0.mModeFilterBtn;
    }

    static /* synthetic */ View access$1000(RadioPermissions r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ Point access$1100(RadioPermissions r0) {
        return r0.mOutSize;
    }

    static /* synthetic */ int access$1200(RadioPermissions r0) {
        return r0.mTitleBarHeight;
    }

    static /* synthetic */ void access$1300(RadioPermissions r0) {
        r0.resetOkButton();
    }

    static /* synthetic */ StickyListHeadersListView access$1400(RadioPermissions r0) {
        return r0.mListView;
    }

    static /* synthetic */ ArrayList access$1500(RadioPermissions r0) {
        return r0.mSections;
    }

    static /* synthetic */ boolean access$1600(RadioPermissions r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$1700(RadioPermissions r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ boolean access$1802(RadioPermissions r0, boolean r1) {
        r0.mIsHandleClick = r1;
        return r1;
    }

    static /* synthetic */ void access$1900(RadioPermissions r0, int r1, boolean r2) {
        r0.setCheckedInternal(r1, r2);
    }

    static /* synthetic */ OButton access$200(RadioPermissions r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ int access$2000(RadioPermissions r0) {
        return r0.mResId;
    }

    static /* synthetic */ View access$2100(RadioPermissions r0) {
        return r0.mListViewEmptyView;
    }

    static /* synthetic */ OCTitleBar access$2200(RadioPermissions r0) {
        return r0.mSearchBarContainer;
    }

    static /* synthetic */ boolean access$2300(RadioPermissions r0) {
        return r0.mIsSwitchMode;
    }

    static /* synthetic */ ImageView access$2400(RadioPermissions r0) {
        return r0.mTitleBarRightImg;
    }

    static /* synthetic */ EditText access$2500(RadioPermissions r0) {
        return r0.mSearchView;
    }

    static /* synthetic */ ArrayList access$2600(RadioPermissions r0) {
        return r0.mSelectedInfos;
    }

    static /* synthetic */ String access$2700(RadioPermissions r0, AppEntry r1) {
        return r0.getStatusText(r1);
    }

    static /* synthetic */ HashMap access$2800(RadioPermissions r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ AlertDialog access$2900(RadioPermissions r0) {
        return r0.mWarningDialog;
    }

    static /* synthetic */ QuickBarEx access$300(RadioPermissions r0) {
        return r0.mQuickBar;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$3000(RadioPermissions r0) {
        return r0.mAutoStartCheckChangeListener;
    }

    static /* synthetic */ boolean access$400(RadioPermissions r0) {
        return r0.mIsEdit;
    }

    static /* synthetic */ void access$500(RadioPermissions r0) {
        r0.hideIME();
    }

    static /* synthetic */ OInsetSheet access$600(RadioPermissions r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ boolean access$700(RadioPermissions r0) {
        return r0.mIsAnimating;
    }

    static /* synthetic */ boolean access$702(RadioPermissions r0, boolean r1) {
        r0.mIsAnimating = r1;
        return r1;
    }

    static /* synthetic */ View access$800(RadioPermissions r0) {
        return r0.mEditBarView;
    }

    static /* synthetic */ View access$900(RadioPermissions r0) {
        return r0.mSearchResultView;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        onLoadFinished2(loader, data);
    }

    @Override // com.bytedanceos.security.widget.SlideListView.Listener
    public void setChecked(int position, boolean isChecked) {
        if (position < this.mListView.getHeaderViewsCount()) goto L11;
        setCheckedInternal(position - this.mListView.getHeaderViewsCount(), isChecked);
        int r2 = position - this.mListView.getFirstVisiblePosition();
        View r1 = this.mListView.getWrappedList().getChildAt(r2);
        if (r1 != null) goto L7;
        return;
    L7:
        OCheckBox r3 = (OCheckBox) r1.findViewById(R.id.checkBox);
        if (r3 == null) goto L12;
        r3.setChecked(isChecked);
        return;
    L12:
        return;
    }

    private void setCheckedInternal(int position, boolean isChecked) {
        if (this.mSearchView.isFocused() == false) goto L11;
        SwitchedAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getCount() <= 0) goto L19;
        AppEntry r2 = this.mSearchAdapter.getItem(position);
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
        AppEntry r2 = this.mSearchAdapter.getItem(position);
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
        getWindow().setBackgroundDrawable(null);
        this.mItemTranslateX = getResources().getDimension(R.dimen.list_item_translation_x);
        Intent r5 = getIntent();
        this.mPermissioIndex = r5.getIntExtra(Utils.INTENT_KEY_INDEX, -1);
        this.mRightImgEditRes = R.drawable.oic_line_3_list_checkmark;
        this.mRightImgCancelRes = R.drawable.oic_list_cancel;
        if (this.mPermissioIndex == (-1)) goto L5;
    L7:
        int r6 = this.mPermissioIndex;
        if (r6 >= 0) goto L10;
        finish();
        return;
    L10:
        if (r6 != 19) goto L12;
    L28:
        this.mIsSwitchMode = true;
    L29:
        this.mTitleId = getResources().getIdentifier(Utils.mShortNames[this.mPermissioIndex], "string", getPackageName());
        this.mHidePrompt = Utils.mPromptHide[this.mPermissioIndex];
        this.mIgnore = Utils.mPermissionIgnore[this.mPermissioIndex];
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mPermissions = Utils.mMatchedPermissions[this.mPermissioIndex];
        int[] r7 = Utils.mOpCodes[this.mPermissioIndex];
        this.mOps = r7;
        if (r7[0] == OpsManagerHelper.get_OP_LOCATION()) goto L32;
    L35:
        initTitle();
        initView();
        if (getWindowManager() != null) goto L38;
    L40:
        this.mPackageReceiver = new AnonymousClass1(this);
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        IntentFilter r8 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r8.addAction("android.intent.action.PACKAGE_ADDED");
        r8.addDataScheme("package");
        registerReceiver(this.mPackageReceiver, r8);
        this.mResId = Utils.getResouceId("android", "simple_list_item_2", "layout", android.R.layout.simple_list_item_2);
        return;
    L38:
        if (getWindowManager().getDefaultDisplay() == null) goto L40;
        getWindowManager().getDefaultDisplay().getSize(this.mOutSize);
        goto L40
    L32:
        if (MultiSdkAdapter.isBeforeP() == false) goto L34;
        this.mIsLocation = true;
        goto L35
    L34:
        this.mIsSwitchMode = true;
        goto L35
    L12:
        if (r6 == 18) goto L28;
        if (r6 == 28) goto L28;
        if (r6 == 27) goto L28;
        if (r6 == 20) goto L28;
        if (r6 == 26) goto L28;
        if (r6 == 21) goto L28;
        if (r6 == 13) goto L28;
        if (r6 == 14) goto L28;
        if (r6 != 29) goto L29;
    L5:
        if (ACTION_UNKOWNED_RESOURCE.equals(r5.getAction()) == false) goto L7;
        this.mPermissioIndex = 27;
        this.mFromManageUnknownAppSource = true;
        goto L7
    }

    private void initView() {
        getLoaderManager().initLoader(0, null, this);
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

    private void prepareMenuDialog() {
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
        OListItemSettings r5 = (OListItemSettings) r4.findViewById(R.id.permission_status_allow);
        r5.setVisibility(0);
        r5.mTrailingElement.setVisibility(8);
        r5.setOnClickListener(new AnonymousClass12(this));
        if (this.mHidePrompt == true) goto L8;
        OListItemSettings r6 = (OListItemSettings) r4.findViewById(R.id.permission_allow_in_use);
        r6.mTrailingElement.setVisibility(8);
        if (this.mIsLocation == false) goto L7;
        r6.setTitleString(r0.getString(R.string.permission_status_foreground_allow));
        r6.setOnClickListener(new AnonymousClass13(this));
        goto L8
    L7:
        r6.setTitleString(r0.getString(R.string.permission_status_prompt));
        r6.setOnClickListener(new AnonymousClass14(this));
    L8:
        OListItemSettings r7 = (OListItemSettings) r4.findViewById(R.id.permission_status_deny);
        r7.mTrailingElement.setVisibility(8);
        r7.setTitleString(r0.getString(R.string.permission_status_deny));
        r7.setOnClickListener(new AnonymousClass15(this));
        this.mMenuDialog.setContainerView(r4);
    }

    private void initTitle() {
        initTitleBar(false);
        this.mTitleBarBackView.setOnClickListener(new AnonymousClass16(this));
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
        DataUsageMenuItem r1 = new DataUsageMenuItem(getString(R.string.permission_status_all), false, 6);
        DataUsageMenuItem r2 = new DataUsageMenuItem(getString(R.string.permission_status_allow), false, SearchBar.FILTER_BY_ALLOW);
        DataUsageMenuItem r3 = new DataUsageMenuItem(getString(R.string.permission_status_deny), false, SearchBar.FILTER_BY_DENY);
        DataUsageMenuItem r6 = new DataUsageMenuItem(getString(R.string.permission_status_prompt), false, SearchBar.FILTER_BY_ALLOW_ASK);
        DataUsageMenuItem r7 = new DataUsageMenuItem(getString(R.string.permission_status_foreground_allow), false, SearchBar.FILTER_BY_INUSE);
        DataUsageMenuItem r8 = new DataUsageMenuItem(getString(R.string.permission_status_not_set), false, 7);
        DataUsageMenuItem r9 = new DataUsageMenuItem(getString(R.string.switch_open), false, SearchBar.FILTER_BY_ALLOW);
        DataUsageMenuItem r11 = new DataUsageMenuItem(getString(R.string.switch_close), false, SearchBar.FILTER_BY_DENY);
        DataUsageMenuItem r12 = new DataUsageMenuItem(getString(R.string.background_network_allow), false, 10);
        DataUsageMenuItem r13 = new DataUsageMenuItem(getString(R.string.background_network_reject_screen_off), false, 11);
        DataUsageMenuItem r14 = new DataUsageMenuItem(getString(R.string.background_network_reject), false, 12);
        DataUsageMenuItem r5 = new DataUsageMenuItem(getString(R.string.permission_allow_in_use), false, 13);
        DataUsageMenuItem r10 = new DataUsageMenuItem(getString(R.string.permission_allow_button), false, 7);
        DataUsageMenuItem r15 = new DataUsageMenuItem(getString(R.string.permission_status_deny), false, 8);
        if (this.mIsSwitchMode == false) goto L6;
        char r16 = 2;
    L12:
        ArrayList r4 = new ArrayList();
        r4.add(r1);
        switch(r16) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            default: goto L22;
        };
    L15:
        r4.add(r10);
        r4.add(r15);
        goto L22
    L16:
        r4.add(r2);
        r4.add(r5);
        r4.add(r3);
        goto L22
    L17:
        r4.add(r12);
        r4.add(r13);
        r4.add(r14);
        goto L22
    L18:
        r4.add(r8);
        r4.add(r2);
        r4.add(r6);
        r4.add(r3);
        goto L22
    L19:
        r4.add(r8);
        r4.add(r2);
        r4.add(r7);
        r4.add(r3);
        goto L22
    L20:
        r4.add(r9);
        r4.add(r11);
        goto L22
    L21:
        r4.add(r2);
        r4.add(r3);
    L22:
        int r17 = 0;
    L24:
        if (r17 >= r4.size()) goto L29;
        DataUsageMenuItem r18 = (DataUsageMenuItem) r4.get(r17);
        if (r18.getValue() == this.mCurrentSortMode) goto L27;
        r17 = r17 + 1;
        goto L24
    L27:
        r18.setSelected(true);
    L29:
        return r4;
    L6:
        if (this.mIsLocation == false) goto L9;
        r16 = 3;
        goto L12
    L9:
        if (this.mHidePrompt == false) goto L11;
        r16 = 1;
        goto L12
    L11:
        r16 = 4;
        goto L12
    }

    private void showSortDialog(View anchorView) {
        OPopover.Builder r1 = new OPopover.Builder(this);
        this.mSortDialog = null;
        final Function r2 = new RadioPermissions$$ExternalSyntheticLambda0(this);
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder(this);
        r13.enableOption();
        final List<DataUsageMenuItem> r14 = getSortMenuList();
        int r12 = 0;
    L4:
        if (r12 >= r14.size()) goto L6;
        DataUsageMenuItem r3 = r14.get(r12);
        r13.addPopoverRightOptionItem(false, 0, 0, Integer.valueOf(getColor(R.color.oui_accent_fg)), r3.getTitle(), null, false, r3.isSelected(), new AnonymousClass17(this, r14, r2));
        r12 = r12 + 1;
        goto L4
    L6:
        OPopover r4 = r1.setView(r13.build()).setGravity(48).build();
        OPopoverHelper.INSTANCE.showPopoverSmartly(r4, anchorView, 48, false, 0.0f, 0, 0);
        this.mSortDialog = r4;
    }

    /* JADX INFO: renamed from: lambda$showSortDialog$0$com-bytedanceos-security-RadioPermissions, reason: not valid java name */
    /* synthetic */ Unit m127x360d5794(Unit r2) {
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
        setPermissionsForList(OpsManagerHelper.get_MODE_ALLOWED());
    L30:
        int r2 = view.getId();
        if (r2 != R.id.checkbox_select_all) goto L33;
    L35:
        this.mIsHandleClick = false;
        if (this.mBtnSelectAll.isChecked() == true) goto L38;
        this.mSelectedInfos.clear();
    L39:
        this.mAdapter.notifyDataSetChanged();
        recoverQuickBar();
        updateSelectDesc();
    L40:
        resetHandleClickState();
        return;
    L38:
        this.mSelectedInfos.clear();
        this.mSelectedInfos.addAll(this.mAdapter.getDatas());
        goto L39
    L33:
        if (r2 == R.id.select_all_cb) goto L35;
    L19:
        if (view != this.mPermissionAsk) goto L25;
        if (this.mIsLocation == false) goto L23;
        setPermissionsForList(OpsManagerHelper.get_MODE_DURING_USE());
        goto L30
    L23:
        setPermissionsForList(OpsManagerHelper.get_MODE_ASK());
        goto L30
    L25:
        if (view != this.mPermissionDeny) goto L28;
        setPermissionsForList(OpsManagerHelper.get_MODE_IGNORED());
        goto L30
    L28:
        if (view != this.mModeFilterBtn) goto L30;
        showSortDialog(view);
        goto L30
    }

    private void setPermissionsForList(int apo) {
        List<AppEntry> r0 = this.mAdapter.getDatas();
        int r2 = 0;
    L4:
        if (r2 >= this.mSelectedInfos.size()) goto L11;
        AppEntry r3 = this.mSelectedInfos.get(r2);
        r3.setMode(apo);
        this.mOpsManagerHelper.setMode(this.mOps[0], r3.getApplicationInfo().uid, r3.getApplicationInfo().packageName, apo);
        int r5 = this.mCurrentSortMode;
        if (apo == r5) goto L9;
        if (r5 == 6) goto L9;
        r0.remove(r3);
    L9:
        r2 = r2 + 1;
        goto L4
    L11:
        if (this.mCurrentSortMode == 6) goto L13;
        this.mAdapter.setData(r0, true);
    L13:
        resetQuickBarState();
        clickBtnEdit();
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
        r3.addListener(new AnonymousClass18(this));
        r3.playTogether(r2);
        r3.start();
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
        OCheckBox r19 = (OCheckBox) r16.findViewById(R.id.checkBox);
        if (r19 == null) goto L21;
        r19.setVisibility(0);
        r19.setAlpha(0);
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

    public void showMenuDialog() {
        if (this.mMenuDialog != null) goto L5;
        prepareMenuDialog();
    L5:
        this.mMenuDialog.show();
    }

    protected void onMenuItemClick(int position) {
        if (position != 0) goto L4;
        savePermissionStatus(this.mLastClickItem, OpsManagerHelper.get_MODE_ALLOWED());
    L14:
        this.mLastClickItem = null;
        this.mMenuDialog.dismiss();
        return;
    L4:
        if (position != 1) goto L6;
        savePermissionStatus(this.mLastClickItem, OpsManagerHelper.get_MODE_ASK());
        goto L14
    L6:
        if (position != 2) goto L8;
        savePermissionStatus(this.mLastClickItem, OpsManagerHelper.get_MODE_IGNORED());
        goto L14
    L8:
        if (position != 3) goto L14;
        savePermissionStatus(this.mLastClickItem, OpsManagerHelper.get_MODE_DURING_USE());
        goto L14
    }

    protected void savePermissionStatus(final AppEntry entry, int mode) {
        if (isRiskPermissionChangeBlocked(entry) == false) goto L6;
        RiskPermissionControlGuard.showBlockedToast(this);
        return;
    L6:
        entry.setMode(mode);
        this.mOpsManagerHelper.setMode(this.mOps[0], entry.getApplicationInfo().uid, entry.getApplicationInfo().packageName, mode);
        if (this.mSearchView.isFocused() == false) goto L32;
        if (this.mCurrentSortMode == 6) goto L25;
        ArrayList r5 = new ArrayList();
        if (this.mCurrentSortMode != 7) goto L18;
        String r0 = getResources().getString(R.string.permission_status_not_set);
        Iterator<AppEntry> r1 = this.mDataList.iterator();
    L14:
        if (r1.hasNext() == false) goto L24;
        AppEntry r2 = r1.next();
        if (getStatusText(r2).equals(r0) == false) goto L14;
        r5.add(r2);
    L24:
        this.mAdapter.setData(r5, true);
    L26:
        this.mAdapter.notifyDataSetChanged();
        this.mListViewEmptyView.setVisibility(8);
        SwitchedAdapter r6 = this.mSearchAdapter;
        if (r6 != null) goto L29;
        return;
    L29:
        if (r6.getCount() <= 0) goto L53;
        this.mSearchAdapter.notifyDataSetChanged();
        return;
    L53:
        return;
    L18:
        Iterator<AppEntry> r3 = this.mDataList.iterator();
    L20:
        if (r3.hasNext() == false) goto L24;
        AppEntry r4 = r3.next();
        if (r4.getMode() != this.mCurrentSortMode) goto L20;
        r5.add(r4);
        goto L20
    L25:
        this.mAdapter.setData(this.mDataList, true);
        goto L26
    L32:
        if (this.mCurrentSortMode == 6) goto L40;
        List<AppEntry> r7 = this.mAdapter.getDatas();
        int r8 = this.mLastClickItem.getMode();
        int r9 = this.mCurrentSortMode;
        if (r8 == r9) goto L37;
        if (r9 == 6) goto L37;
        r7.remove(this.mLastClickItem);
    L37:
        int r10 = this.mListView.getFirstVisiblePosition();
        this.mAdapter.setData(r7, true);
        if (r10 <= 0) goto L40;
        this.mListView.setSelection(r10);
    L40:
        this.mAdapter.notifyDataSetChanged();
    }

    private boolean isRiskPermissionChangeBlocked(AppEntry entry) {
        if (entry != null) goto L4;
        return false;
    L4:
        if (entry.getApplicationInfo() != null) goto L7;
        return false;
    L7:
        return RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this, entry.getApplicationInfo().packageName, UserHandle.getUserId(entry.getApplicationInfo().uid));
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
        AppListLoader r3 = new AppListLoader(this, this.mPermissions, this.mOps, this.mIgnore);
        this.mAppListLoader = r3;
        return r3;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.mAppListLoader.forceLoad();
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        List<AppEntry> r4 = this.mAdapter.getDatas();
        int r0 = 0;
        if (data != null) goto L5;
    L11:
        int r5 = 0;
    L12:
        this.mAdapter.setData(data, true);
        this.mDataList = data;
        View r6 = findViewById(R.id.package_loading_text);
        if (r6 == null) goto L15;
        r6.setVisibility(8);
    L15:
        if (r0 != 0) goto L17;
        if (r5 != 0) goto L17;
        return;
    L17:
        this.mListView.setRealSelectionFromTop(r0, r5);
        return;
    L5:
        if (r4.size() <= 0) goto L11;
        OListView r7 = this.mListView.getWrappedList();
        int r1 = r7.getFirstVisiblePosition();
        View r8 = r7.getChildAt(0);
        if (r8 == null) goto L10;
        r0 = r8.getTop();
    L10:
        r5 = r0;
        r0 = r1;
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
        AppEntry r2 = this.mSearchAdapter.getItem(position);
    L27:
        hideIME();
        if (this.mIsEdit == true) goto L30;
        this.mIsHandleClick = true;
        this.mLastClickItem = r2;
        if (this.mIsSwitchMode == true) goto L37;
        showMenuDialog();
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
        List<AppEntry> r0 = new ArrayList();
        if (6 != sortMode) goto L6;
        r0 = this.mDataList;
    L28:
        if (r0 != null) goto L30;
    L33:
        this.mAdapter.setData(r0, false);
        this.mAdapter.notifyDataSetChanged();
    L34:
        this.mCurrentSortMode = sortMode;
        return true;
    L30:
        if (r0.size() == 0) goto L33;
        this.mAdapter.setData(r0, true);
        goto L34
    L6:
        if (7 != sortMode) goto L14;
        String r1 = getResources().getString(R.string.permission_status_not_set);
        Iterator<AppEntry> r2 = this.mDataList.iterator();
    L9:
        if (r2.hasNext() == false) goto L28;
        AppEntry r3 = r2.next();
        if (getStatusText(r3).equals(r1) == false) goto L9;
        r0.add(r3);
        goto L9
    L14:
        if (SearchBar.FILTER_BY_ALLOW != sortMode) goto L16;
    L21:
        Iterator<AppEntry> r4 = this.mDataList.iterator();
    L23:
        if (r4.hasNext() == false) goto L28;
        AppEntry r5 = r4.next();
        if (isModeApp(sortMode, r5.getMode()) == false) goto L23;
        r0.add(r5);
        goto L23
    L16:
        if (SearchBar.FILTER_BY_ALLOW_ASK == sortMode) goto L21;
        if (SearchBar.FILTER_BY_INUSE == sortMode) goto L21;
        if (SearchBar.FILTER_BY_DENY != sortMode) goto L28;
        goto L21
    }

    private boolean isModeApp(int selectMode, int mode) {
        int r3 = this.mPermissioIndex;
        if (r3 == 29) goto L11;
        if (r3 == 20) goto L11;
        if (selectMode != mode) goto L9;
        return true;
    L9:
        return false;
    L11:
        if (selectMode != SearchBar.FILTER_BY_ALLOW) goto L18;
        if (mode != SearchBar.FILTER_BY_ALLOW) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (mode == SearchBar.FILTER_BY_ALLOW) goto L21;
        return true;
    L21:
        return false;
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
        this.mWholeView.postDelayed(new AnonymousClass19(this), 30);
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
        this.mStartSearchAnim.addListener(new AnonymousClass21(this));
    L5:
        this.mStartSearchAnim.start();
        resetHandleClickState();
    }

    private void resetHandleClickState() {
        this.mWholeView.postDelayed(new AnonymousClass22(this), 500);
    }

    private void startEndSearchAnimation() {
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r0 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mTitleBarHeight, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(200);
        this.mEndSearchAnim.playTogether(new Animator[]{r0, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass23(this));
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
        if (keyword.trim().equals(this.lastQueryText) == true) goto L28;
        this.lastQueryText = keyword.trim();
        if (TextUtils.isEmpty(keyword) == true) goto L9;
    L13:
        this.mListView.setEmptyView(null);
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        this.mSearchResultList = this.mAdapter.query(keyword);
        if (TextUtils.isEmpty(keyword) == true) goto L17;
        this.mLastSearch = new SearchAction(this, keyword, this.mSearchResultList);
    L17:
        if (this.mSearchAdapter == null) goto L19;
    L23:
        this.mSearchAdapter.setData(this.mSearchResultList, false);
        return;
    L19:
        if (this.mIsSwitchMode == false) goto L21;
        this.mSearchAdapter = new AutoStartAdapter(this, this);
    L22:
        this.mSearchResultListView.setAdapter(this.mSearchAdapter);
        goto L23
    L21:
        this.mSearchAdapter = new SearchAdapter(this, this);
        goto L22
    L9:
        if (this.mSearchView.isFocused() == false) goto L13;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
        if (this.mAdapter.getCount() > 0) goto L26;
        this.mListView.setEmptyView(this.mListViewEmptyView);
        return;
    L26:
        return;
    }

    public void showWaringDialog(final CompoundButton buttonView, final AppEntry entry) {
        final int r0 = OpsManagerHelper.get_MODE_ALLOWED();
        AlertDialog r1 = this.mWarningDialog;
        if (r1 != null) goto L5;
    L7:
        AlertDialog r5 = new AlertDialog.Builder(this, 5).setTitle(R.string.first_launch_dialog_title).setMessage(R.string.install_all_warning).setPositiveButton(R.string.first_launch_dialog_possitive, new AnonymousClass26(this, entry, r0)).setNegativeButton(R.string.first_launch_dialog_negative, new AnonymousClass25(this, buttonView)).create();
        this.mWarningDialog = r5;
        r5.setOnKeyListener(new AnonymousClass27(this, buttonView));
        this.mWarningDialog.setCancelable(false);
        this.mWarningDialog.show();
        return;
    L5:
        if (r1.isShowing() == false) goto L7;
        this.mWarningDialog.dismiss();
        goto L7
    }

    private String getStatusText(AppEntry entry) {
        LogTag.d(TAG, " " + entry.getPackageName() + ", entry.mode = " + entry.getMode());
        String r0 = getResources().getString(R.string.permission_status_not_set);
        int r3 = entry.getMode();
        if (OpsManagerHelper.get_MODE_ALLOWED() != r3) goto L6;
        return getResources().getString(R.string.permission_status_allow);
    L6:
        if (OpsManagerHelper.get_MODE_ASK() != r3) goto L9;
        return getResources().getString(R.string.permission_status_prompt);
    L9:
        if (OpsManagerHelper.get_MODE_IGNORED() != r3) goto L12;
        return getResources().getString(R.string.permission_status_deny);
    L12:
        if (OpsManagerHelper.get_MODE_DURING_USE() == r3) goto L14;
        return r0;
    L14:
        return getResources().getString(R.string.permission_status_foreground_allow);
    }

    private void addButtonTab(View bar) {
        OButton r0 = (OButton) bar.findViewById(R.id.permission_status_allow);
        this.mPermissionAllow = r0;
        r0.setOnClickListener(this);
        OButton r1 = (OButton) bar.findViewById(R.id.permission_status_prompt);
        this.mPermissionAsk = r1;
        if (this.mIsLocation == false) goto L5;
        r1.setVisibility(8);
        OButton r2 = (OButton) bar.findViewById(R.id.permission_status_foreground_allow);
        this.mPermissionAsk = r2;
        r2.setVisibility(0);
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

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getLoaderManager().destroyLoader(0);
        BroadcastReceiver r0 = this.mPackageReceiver;
        if (r0 == null) goto L6;
        unregisterReceiver(r0);
        this.mPackageReceiver = null;
        return;
    }
}
