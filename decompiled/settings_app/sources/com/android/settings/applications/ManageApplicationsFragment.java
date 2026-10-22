package com.android.settings.applications;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.ApplicationManager;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.LauncherApps;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.NavigationBarHelper;
import com.android.settings.DeviceAdminAdd;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.applications.api.OnSettingsItemClickListener;
import com.android.settings.applications.api.OnSettingsItemLongClickListener;
import com.android.settings.applications.utils.OButtonUtils;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.pinyin.PinyinUtils;
import com.android.settings.stickylistheaders.StickyListHeadersAdapter;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DisplayUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.HorizontalScrollListView;
import com.android.settings.widget.SlideListView;
import com.android.settingslib.RestrictedLockUtils;
import com.android.vcard.VCardConfig;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.obric.common.oea.style.scene.search.SearchModeSwitchAnimHelperType2;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.button.OIconButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.forms.OEditText;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.menu.PopMenu;
import com.obric.oui.menu.PopMenuItem;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.OPopoverHelper;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.segmentedtab.OTabSegmentedLayout;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.obric.systemapp.SystemAppRecorder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.BytedanceProgressDialog;
import obric.app.OMenuDialog;
import obric.widget.SearchBar;
import obric.widget.letters.QuickBarEx;
import obric.widget.support.AbsMenuItem;
import obric.widget.support.ListPopMenuStandardAdapter;
import obric.widget.support.ListPopupMenu;

/* JADX INFO: loaded from: classes2.dex */
public class ManageApplicationsFragment extends BaseFragment implements OnSettingsItemClickListener, HorizontalScrollListView.ScrollStateListener, OnSettingsItemLongClickListener, View.OnClickListener, SlideListView.Listener, SlideListView.OnQuickBarChangedListener {
    private static final int ANIM_DURATION = 300;
    private static final int ANIM_START_DELAY = 10;
    private static final String CLOUD_GALLERY_PKG_NAME = "com.bytedanceos.cloudgallery";
    private static final int DLG_APP_NOT_FOUND = 3;
    private static final int DLG_BASE = 0;
    private static final int DLG_CANNOT_CLEAR_DATA = 4;
    private static final int DLG_CLEAR_DATA = 1;
    private static final int DLG_DISABLE = 7;
    private static final int DLG_DISABLE_NOTIFICATIONS = 8;
    private static final int DLG_FACTORY_RESET = 2;
    private static final int DLG_FORCE_STOP = 5;
    private static final int DLG_MOVE_FAILED = 6;
    private static final int DLG_SPECIAL_DISABLE = 9;
    private static final String EMAIL_PKG_NAME = "com.android.email";
    private static final String EXTRA_HIDDEN_PACKAGES = "extra_hidden_packages";
    private static final String EXTRA_LOCK_PACKAGES = "extra_locked_packages";
    public static final String EXTRA_SYSTEM_APP_MANAGER = "extra_system_app_manager";
    private static final String HAND_IN_HAND_PKG_NAME = "com.bytedanceos.handinhand";
    private static final int MSG_ID_DISMISS_CALCULATING_SIZE_DIALOG = 13;
    private static final int MSG_ID_DISMISS_DIALOG = 12;
    private static final int MSG_ID_DISMISS_UNINSTALLING_DIALOG = 14;
    private static final int MSG_ID_SHOW_PROGRESS_DIALOG = 11;
    private static final String MUSICFX_PKG_NAME = "com.android.musicfx";
    private static final String MUSIC_SHARE_PKG_NAME = "com.obric.music.share";
    private static final String NOTE_PKG_NAME = "com.obric.notes";
    private static final int PROFILE_TAB_PERSONAL = 0;
    private static final int PROFILE_TAB_WORK = 1;
    private static final String RECHARGE_PKG_NAME = "com.bytedanceos.recharge";
    public static final int REQUEST_UNINSTALL = 1;
    private static final int REQ_VERIFY_PASSWORD = 10;
    private static final String SCREEN_RECORDER_PKG_NAME = "com.bytedanceos.screenrecorder";
    public static final int SORT_BY_FREQUENCY = 8;
    public static final int SORT_BY_INSTALL_TIME = 4;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_SIZE = 2;
    public static final String TAG = "ManageApplications";
    private static final String TEXT_BOOM_PKG_NAME = "com.bytedanceos.textboom";
    private static final String YOUDAO_BYTEDANCE_PKG_NAME = "com.youdao.dict.bytedance";
    private static List<String> whiteAppList;
    private static List<String> whiteAppsHasPrefixMsg;
    private static List<String> whiteComponentList;
    private int animTargetTransY;
    private long coldStartTime;
    private boolean isHiddenPackagesPage;
    private boolean isLockedPackagesPage;
    private boolean mAllSizesComputed;
    private ApplicationsState.AppFilter mAppFilter;
    private ApplicationsAdapter mApplicationsAdapter;
    private ApplicationsState mApplicationsState;
    private int mAppsCanEditSize;
    private BytedanceProgressDialog mCalculateSizeDialog;
    private Comparator<ApplicationsState.AppEntry> mComparator;
    private int mCurrentSortMode;
    private String mDefaultTitle;
    private Animator.AnimatorListener mDeleteAnimatorListener;
    private Runnable mDoppelgangerAppDeleteRunnable;
    private int mDownX;
    private int mDownY;
    private DevicePolicyManager mDpm;
    private RelativeLayout mEditBarView;
    private OButton mEditView;
    private TextView mEmptyView;
    private AnimatorSet mEndSearchAnim;
    private FpsTracer mFpsTracer;
    private final Handler mHandler;
    private View mHeaderSpaceView;
    private View mHeaderView;
    private OCardListItem mHiddenAppsView;
    private OIndexScrollbar mIndexScrollbar;
    private boolean mIsEditAnimationRunning;
    private boolean mIsEditMode;
    private boolean mIsItemScrollRestored;
    private boolean mIsSystemAppManager;
    private BroadcastReceiver mKeyguardOnReceiver;
    private SearchAction mLastSearch;
    private LauncherApps mLauncherAppsService;
    private LauncherApps.Callback mLauncherCallback;
    private Bitmap[][] mLetterProfileBitmaps;
    private SlideListView mListView;
    private View mLockedAppsView;
    private OPopover mLongPopupWindow;
    private SortMenuItem[] mMenuItems;
    private OIconButton mModeFilterBtn;
    private TextView mOptionTextView;
    PackageDeleteObserver mPkgDeleteObserver;
    private PackageManager mPm;
    private PopMenu mPopMenu;
    private ListPopupMenu mPopupWindow;
    private HashMap<Character, Integer> mPositionOfSections;
    private OTabSegmentedLayout mProfileTabs;
    private View mProfileTabsContainer;
    private BytedanceProgressDialog mProgressDialog;
    private QuickBarEx.QBListener mQBListener;
    private QuickBarEx mQuickBar;
    private SearchAdapter mSearchAdapter;
    private TextView mSearchBackground;
    private OSearchBar mSearchBar;
    private int mSearchBarAnimHeight;
    private SearchBarCallback mSearchBarCallback;
    private OButtonGroup mSearchBarCancel;
    private OCTitleBar mSearchBarContainer;
    private View mSearchEmptyView;
    private View mSearchIcon;
    private ArrayList<ApplicationsState.AppEntry> mSearchResultList;
    private HorizontalScrollListView mSearchResultListView;
    private View mSearchResultView;
    private OEditText mSearchView;
    private ArrayList<String> mSections;
    private OCheckBox mSelectAllCheckBox;
    private int mSelectedProfileTab;
    private OPopover mSortDialog;
    private AnimatorSet mStartSearchAnim;
    private AlertDialog mSystemAppWarningDialog;
    private int mTitleOkBtnDefaultBgRes;
    private int mTitleStringResId;
    private Map<Integer, Set<String>> mTodoUninstallMap;
    private OAlertDialog mUninstallAlertDialog;
    private int mUninstallAppTotal;
    private OButton mUninstallBtn;
    private AlertDialog mUninstallDialog;
    private boolean mUninstallingApp;
    private BytedanceProgressDialog mUninstallingDialog;
    private String mUninstallingPkg;
    private OFloatingTitleBar mViewTitle;
    private View mWholeView;
    private SearchModeSwitchAnimHelperType2 searchModeSwitchAnimHelperType2;

    /* JADX INFO: renamed from: com.android.settings.applications.ManageApplicationsFragment$40, reason: invalid class name */
    class AnonymousClass40 implements Animator.AnimatorListener {
        View hintView;
        final /* synthetic */ ManageApplicationsFragment this$0;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        AnonymousClass40(ManageApplicationsFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
            if (ManageApplicationsFragment.access$1200(this.this$0).isFocused() == false) goto L5;
            this.hintView = ManageApplicationsFragment.access$7800(this.this$0).getHintView();
        L6:
            View r2 = this.hintView;
            if (r2 != null) goto L9;
            return;
        L9:
            if (r2.hasFocus() == false) goto L11;
            this.hintView.clearFocus();
        L11:
            this.hintView.setTag(ManageApplicationsFragment.access$1900(this.this$0));
            return;
        L5:
            this.hintView = ManageApplicationsFragment.access$300(this.this$0).getHintView();
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            if (this.this$0.isAdded() == true) goto L5;
            return;
        L5:
            ManageApplicationsFragment.access$5602(this.this$0, false);
            View r3 = this.hintView;
            if (r3 == null) goto L9;
            r3.post(new AnonymousClass1(this));
        L9:
            if (ManageApplicationsFragment.access$600(this.this$0) == null) goto L14;
            if (ManageApplicationsFragment.access$600(this.this$0).isShowing() == false) goto L14;
            ManageApplicationsFragment.access$600(this.this$0).setMessage(ManageApplicationsFragment.access$700(this.this$0));
        L14:
            if (ManageApplicationsFragment.access$7900(this.this$0) == null) goto L17;
            ManageApplicationsFragment.access$7900(this.this$0).run();
            ManageApplicationsFragment.access$7902(this.this$0, null);
            return;
        L17:
            if (ManageApplicationsFragment.access$1900(this.this$0) == null) goto L21;
            ManageApplicationsFragment.access$1900(this.this$0).rebuild();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            onAnimationEnd(r1);
        }
    }

    private class AppListAdapter extends BaseAdapter {
        private View.OnClickListener mClickListener;
        private ArrayList<ApplicationsState.AppEntry> mEntries;
        private int mItemArrowRightMargin;
        protected LayoutInflater mLayoutInflater;
        private OnSettingsItemClickListener mOnSettingsItemClickListener;
        private OnSettingsItemLongClickListener mOnSettingsItemLongClickListener;
        final /* synthetic */ ManageApplicationsFragment this$0;

        class ViewHolder implements View.OnClickListener {
            ApplicationsState.AppEntry entry;
            OCardListItem itemView;
            final /* synthetic */ AppListAdapter this$1;
            ImageView uninstallButton;

            ViewHolder(AppListAdapter r1) {
                this.this$1 = r1;
            }

            void updateSizeText() {
                if (this.itemView != null) goto L5;
                return;
            L5:
                if (this.entry.info.enabled == true) goto L8;
                this.itemView.setEndDetailText(this.this$1.this$0.getString(R.string.filter_apps_disabled));
                return;
            L8:
                if (this.entry.sizeStr == null) goto L11;
                this.itemView.setEndDetailText(this.entry.sizeStr);
                return;
            L11:
                if (this.entry.size != (-2)) goto L17;
                this.itemView.setEndDetailText(this.this$1.this$0.getString(R.string.invalid_size_value));
                return;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r2) {
                if (r2 != this.uninstallButton) goto L6;
                ManageApplicationsFragment.access$7100(this.this$1.this$0, this.entry);
                return;
            }
        }

        static /* synthetic */ View.OnClickListener access$6800(AppListAdapter r0) {
            return r0.mClickListener;
        }

        static /* synthetic */ OnSettingsItemClickListener access$6900(AppListAdapter r0) {
            return r0.mOnSettingsItemClickListener;
        }

        static /* synthetic */ OnSettingsItemLongClickListener access$7000(AppListAdapter r0) {
            return r0.mOnSettingsItemLongClickListener;
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public AppListAdapter(ManageApplicationsFragment r2, Context r3) {
            this.this$0 = r2;
            this.mClickListener = null;
            this.mOnSettingsItemLongClickListener = null;
            this.mOnSettingsItemClickListener = null;
            this.mLayoutInflater = LayoutInflater.from(r3);
            this.mItemArrowRightMargin = r2.getResources().getDimensionPixelSize(R.dimen.settings_item_right_arrow_margin);
        }

        public void setOnClickListener(View.OnClickListener r1) {
            this.mClickListener = r1;
        }

        public void setOnItemClickListener(OnSettingsItemClickListener r1) {
            this.mOnSettingsItemClickListener = r1;
        }

        public void setOnItemLongClickListener(OnSettingsItemLongClickListener r1) {
            this.mOnSettingsItemLongClickListener = r1;
        }

        protected void updateAppEntries(ArrayList<ApplicationsState.AppEntry> r9) {
            PackageManager r0 = this.this$0.mContext.getPackageManager();
            boolean r2 = false;
            if (ManageApplicationsFragment.access$5100(this.this$0) == false) goto L5;
            ManageApplicationsFragment.access$6200(this.this$0, false);
        L40:
            ArrayList<ApplicationsState.AppEntry> r1 = filterEditableApplist(r9);
            ManageApplicationsFragment.access$6402(this.this$0, r1.size());
            if (ManageApplicationsFragment.access$000(this.this$0) == false) goto L43;
            r9 = r1;
        L43:
            ManageApplicationsFragment.access$6500(this.this$0);
            ArrayList<ApplicationsState.AppEntry> r3 = this.mEntries;
            if (r3 == null) goto L46;
            r3.clear();
        L46:
            this.mEntries = r9;
            notifyDataSetChanged();
            if (ManageApplicationsFragment.access$6600(this.this$0) <= 0) goto L67;
            AppMetricsUtils.INSTANCE.reportColdStartActivity("self", "ManageApplications", ManageApplicationsFragment.access$6600(this.this$0));
            ManageApplicationsFragment.access$6602(this.this$0, 0);
            return;
        L67:
            return;
        L5:
            if (ManageApplicationsFragment.access$5300(this.this$0) == true) goto L24;
            ArrayList<ApplicationsState.AppEntry> r4 = new ArrayList();
            r4.clear();
            Iterator<ApplicationsState.AppEntry> r10 = r9.iterator();
            boolean r5 = false;
        L8:
            if (r10.hasNext() == false) goto L18;
            ApplicationsState.AppEntry r6 = r10.next();
            if (ManageApplicationsFragment.access$6100(this.this$0) == false) goto L15;
            if (Utils.isSystemPackage(r6.info) == false) goto L8;
        L15:
            if (Utils.isPackageAlreadyLocked(r0, r6.info.packageName, UserHandle.getUserId(r6.info.uid)) == false) goto L16;
            r5 = true;
            goto L8
        L16:
            r4.add(r6);
            goto L8
        L18:
            ManageApplicationsFragment r11 = this.this$0;
            if (r5 == true) goto L21;
        L23:
            ManageApplicationsFragment.access$6200(r11, r2);
        L38:
            r9 = r4;
            goto L40
        L21:
            if (ManageApplicationsFragment.access$000(r11) == true) goto L23;
            r2 = true;
            goto L23
        L24:
            r4 = new ArrayList();
            r4.clear();
            Iterator<ApplicationsState.AppEntry> r12 = r9.iterator();
        L26:
            if (r12.hasNext() == false) goto L36;
            ApplicationsState.AppEntry r7 = r12.next();
            if (ManageApplicationsFragment.access$6100(this.this$0) == false) goto L33;
            if (Utils.isSystemPackage(r7.info) == false) goto L26;
        L33:
            if (Utils.isPackageAlreadyLocked(r0, r7.info.packageName, UserHandle.getUserId(r7.info.uid)) == false) goto L26;
            r4.add(r7);
            goto L26
        L36:
            if (r4.size() != 0) goto L38;
            ManageApplicationsFragment.access$6300(this.this$0).setText(R.string.locked_packages_none);
            goto L38
        }

        private ArrayList<ApplicationsState.AppEntry> filterEditableApplist(ArrayList<ApplicationsState.AppEntry> r5) {
            ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList();
            Iterator<ApplicationsState.AppEntry> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L21;
            ApplicationsState.AppEntry r1 = r6.next();
            if (ManageApplicationsFragment.access$000(this.this$0) == false) goto L19;
            if ("com.bytedanceos.screenrecorder".equals(r1.info.packageName) == false) goto L12;
            if (Utils.isScreenRecording(this.this$0.mContext) == false) goto L12;
        L15:
            Set r2 = (Set) ManageApplicationsFragment.access$100(this.this$0).get(Integer.valueOf(UserHandle.getUserId(r1.info.uid)));
            if (r2.contains(r1.info.packageName) == false) goto L4;
            r2.remove(r1.info.packageName);
        L12:
            if ("com.obric.recorder".equals(r1.info.packageName) == false) goto L19;
            if (Utils.isRecorderRecording(this.this$0.mContext) == true) goto L15;
        L19:
            if (ManageApplicationsFragment.access$6700(this.this$0, r1) == false) goto L4;
            r0.add(r1);
            goto L4
        L21:
            return r0;
        }

        private boolean hasAppCanbeUninstalled(ArrayList<ApplicationsState.AppEntry> r3) {
            Iterator<ApplicationsState.AppEntry> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L9;
            ApplicationsState.AppEntry r0 = r4.next();
            if (ManageApplicationsFragment.access$6700(this.this$0, r0) == false) goto L4;
            return true;
        L9:
            return false;
        }

        protected ArrayList<ApplicationsState.AppEntry> getAppEntries() {
            return this.mEntries;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<ApplicationsState.AppEntry> r0 = this.mEntries;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public ApplicationsState.AppEntry getItem(int r1) {
            return this.mEntries.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r2) {
            if (r2 < getCount()) goto L7;
            return 0;
        L7:
            return this.mEntries.get(r2).id;
        }

        @Override // android.widget.Adapter
        public View getView(final int r7, View r8, ViewGroup r9) {
            boolean r0 = true;
            if (r8 != null) goto L5;
        L8:
            r8 = this.mLayoutInflater.inflate(R.layout.settings_oui_card_list_item, null, false);
            OCardListItem r2 = (OCardListItem) r8.findViewById(R.id.card_list_item);
            if (ManageApplicationsFragment.access$000(this.this$0) == false) goto L11;
            r2.setCustomStartView(0);
            r2.showCustomStart(true);
        L12:
            ViewHolder r3 = new ViewHolder(this);
            r3.itemView = r2;
            r2.showCustomEnd(true);
            r8.setTag(r3);
            final ViewHolder r4 = r3;
        L13:
            ApplicationsState.AppEntry r5 = this.mEntries.get(r7);
            monitor-enter(r5);
            r4.entry = r5;     // Catch: Throwable -> L54
            if (r5.label == null) goto L21;
            if (r4.itemView == null) goto L21;
            OCardListItemUtils.setTitle(r4.itemView, r5.label);     // Catch: Throwable -> L54
        L21:
            if (r5.icon != null) goto L24;
            r5.ensureIconLocked(this.this$0.mContext, ManageApplicationsFragment.access$5200(this.this$0));     // Catch: Throwable -> L54
        L24:
            if (r4.itemView == null) goto L26;
            r4.itemView.setAppIcon(r5.icon);     // Catch: Throwable -> L54
            r4.itemView.getIconView().setOutlineProvider(null);     // Catch: Throwable -> L54
            r4.itemView.showIcon(true);     // Catch: Throwable -> L54
        L26:
            r4.updateSizeText();     // Catch: Throwable -> L54
            if (r4.uninstallButton == null) goto L34;
            ImageView r10 = r4.uninstallButton;     // Catch: Throwable -> L54
            if (ManageApplicationsFragment.access$000(this.this$0) == true) goto L31;
            int r6 = 0;
        L32:
            r10.setVisibility(r6);     // Catch: Throwable -> L54
            goto L34
        L31:
            r6 = 8;
        L34:
            if (r4.itemView.getCustomStartView() == null) goto L49;
            OCheckBoxLayout r11 = (OCheckBoxLayout) r4.itemView.getCustomStartView().findViewById(R.id.custom_start_checkbox);     // Catch: Throwable -> L54
            if (r11 == null) goto L49;
            if (r5.info != null) goto L40;
        L48:
            r11.setChecked(false);     // Catch: Throwable -> L54
            goto L49
        L40:
            if (r5.info.packageName == null) goto L48;
            Set r12 = (Set) ManageApplicationsFragment.access$100(this.this$0).get(Integer.valueOf(UserHandle.getUserId(r5.info.uid)));     // Catch: Throwable -> L54
            if (r12 != null) goto L44;
        L46:
            r0 = false;
        L47:
            r11.setChecked(r0);     // Catch: Throwable -> L54
            goto L49
        L44:
            if (r12.contains(r5.info.packageName) == false) goto L46;
        L49:
            monitor-exit(r5);     // Catch: Throwable -> L54
            if (r4.itemView == null) goto L53;
            r4.itemView.setOnContentClickListener(new AnonymousClass1(this, r4, r7));
            r4.itemView.setOnContentLongClickListener(new AnonymousClass2(this, r4, r7));
        L53:
            return r8;
        L54:
            th = move-exception;
            throw th;
        L11:
            r2.showCustomStart(false);
            goto L12
        L5:
            if (r8.getTag() == null) goto L8;
            r4 = (ViewHolder) r8.getTag();
            goto L13
        }
    }

    private class ApplicationsAdapter extends AppListAdapter implements ApplicationsState.Callbacks, AbsListView.RecyclerListener, StickyListHeadersAdapter, SectionIndexer {
        private final ArrayList<View> mActives;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ ManageApplicationsFragment this$0;

        class HeaderViewHolder {
            OSectionTitleBar headerText;
            final /* synthetic */ ApplicationsAdapter this$1;

            HeaderViewHolder(ApplicationsAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.SectionIndexer
        public int getSectionForPosition(int r1) {
            return 0;
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ApplicationsState.Session access$5800(ApplicationsAdapter r0) {
            return r0.mSession;
        }

        public ApplicationsAdapter(ManageApplicationsFragment r1, Context r2, ApplicationsState r3) {
            this.this$0 = r1;
            super(r1, r2);
            this.mActives = new ArrayList();
            this.mSession = r3.newSession(this);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(true);
            rebuild();
            return;
        L5:
            rebuild();
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            this.mSession.pause();
            return;
        }

        public void destroy() {
            this.mSession.release();
        }

        public ArrayList<ApplicationsState.AppEntry> query(String r10) {
            ArrayList<ApplicationsState.AppEntry> r0 = new ArrayList();
            if (TextUtils.isEmpty(r10) == false) goto L5;
            ManageApplicationsFragment.access$4602(this.this$0, null);
        L74:
            return r0;
        L5:
            if (ManageApplicationsFragment.access$4600(this.this$0) != null) goto L7;
        L9:
            ArrayList r1 = new ArrayList();
            ArrayList<ApplicationsState.AppEntry> r3 = getAppEntries();
            SparseArray<HashMap<String, ApplicationsState.AppEntry>> r4 = ManageApplicationsFragment.access$4900(this.this$0).mUserIdEntriesMap;
            monitor-enter(r4);
            if (r3 == null) goto L75;
        L13:
            Iterator<ApplicationsState.AppEntry> r5 = r3.iterator();     // Catch: Throwable -> L70
        L15:
            if (r5.hasNext() == false) goto L38;
            ApplicationsState.AppEntry r6 = r5.next();     // Catch: Throwable -> L70
            if (r6 == null) goto L15;
            if (r6.info == null) goto L15;
            if (ManageApplicationsFragment.access$5000(this.this$0) == null) goto L27;
            if (ManageApplicationsFragment.access$5000(this.this$0).filterApp(r6.info) == false) goto L15;
        L27:
            if (ManageApplicationsFragment.access$5100(this.this$0) == true) goto L35;
            boolean r7 = Utils.isPackageAlreadyLocked(ManageApplicationsFragment.access$5200(this.this$0), r6.info.packageName, UserHandle.getUserId(r6.info.uid));     // Catch: Throwable -> L70
            if (ManageApplicationsFragment.access$5300(this.this$0) == true) goto L30;
            if (r7 == false) goto L35;
        L30:
            if (r7 == false) goto L15;
        L35:
            if (r6.mLabelEntry != null) goto L37;
            r6.ensureLabelEntry(this.this$0.mContext);     // Catch: Throwable -> L70
        L37:
            r1.add(r6);     // Catch: Throwable -> L70
            goto L15
        L38:
            monitor-exit(r4);     // Catch: Throwable -> L70
            ManageApplicationsFragment.access$4602(this.this$0, null);
            ArrayList r9 = r1;
        L40:
            String r11 = r10.toUpperCase();
            if (r9 == null) goto L74;
            Iterator r12 = r9.iterator();
        L44:
            if (r12.hasNext() == false) goto L74;
            ApplicationsState.AppEntry r2 = (ApplicationsState.AppEntry) r12.next();
            boolean r8 = true;
            boolean r13 = false;
            if (r2.label != null) goto L48;
        L50:
            boolean r14 = false;
        L52:
            if (r2.mLabelEntry != null) goto L54;
        L58:
            r8 = false;
        L60:
            if (PinyinUtils.isChinese(r11) == false) goto L62;
        L66:
            if (r14 == true) goto L69;
            if (r13 == true) goto L69;
            if (r8 == false) goto L44;
        L69:
            r0.add(r2);
            goto L44
        L62:
            if (r2.mLabelEntry == null) goto L66;
            if (r2.mLabelEntry.labelPinyin == null) goto L66;
            r13 = r2.mLabelEntry.labelPinyin.toUpperCase().contains(r11);
            goto L66
        L54:
            if (r2.mLabelEntry.firstLetters == null) goto L58;
            if (r2.mLabelEntry.firstLetters.toUpperCase().contains(r11) == false) goto L58;
        L48:
            if (r2.label.toUpperCase().contains(r11) == false) goto L50;
            r14 = true;
        L70:
            th = move-exception;
            throw th;
        L75:
            r3 = ManageApplicationsFragment.access$4900(this.this$0).mAppEntries;     // Catch: Throwable -> L70
            goto L13
        L7:
            if (r10.startsWith(SearchAction.access$4700(ManageApplicationsFragment.access$4600(this.this$0))) == false) goto L9;
            r9 = SearchAction.access$4800(ManageApplicationsFragment.access$4600(this.this$0));
            goto L40
        }

        @Override // com.android.settings.applications.ManageApplicationsFragment.AppListAdapter
        protected void updateAppEntries(ArrayList<ApplicationsState.AppEntry> r1) {
            super.updateAppEntries(r1);
            initSections();
            ManageApplicationsFragment.access$5400(this.this$0);
        }

        @Override // com.android.settings.applications.ManageApplicationsFragment.AppListAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            this.mActives.remove(r4);
            this.mActives.add(r4);
            return r4;
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            ManageApplicationsFragment.access$4602(this.this$0, null);
            rebuild();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r3) {
            ManageApplicationsFragment.access$4602(this.this$0, null);
            updateAppEntries(r3);
            ManageApplicationsFragment.access$4200(this.this$0);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mActives.size()) goto L16;
            AppListAdapter.ViewHolder r1 = (AppListAdapter.ViewHolder) this.mActives.get(r0).getTag();
            if (r1.entry.info.packageName.equals(r4) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            ApplicationsState.AppEntry r2 = r1.entry;
            monitor-enter(r2);
            r1.updateSizeText();     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            OLog.d("ManageApplications", "onAllSizesComputed");
            ManageApplicationsFragment.access$5502(this.this$0, true);
            ManageApplicationsFragment.access$500(this.this$0).sendEmptyMessageDelayed(13, 1000);
            rebuild();
        }

        @Override // android.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View r1) {
            this.mActives.remove(r1);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.android.settings.applications.ManageApplicationsFragment$ApplicationsAdapter$1] */
        public void rebuild() {
            if (ManageApplicationsFragment.access$5600(this.this$0) == false) goto L5;
            return;
        L5:
            new AnonymousClass1(this).execute(new Void[0]);
        }

        public void sortEntries(Comparator<ApplicationsState.AppEntry> r2) {
            if (getAppEntries() == null) goto L5;
            Collections.sort(getAppEntries(), r2);
        L5:
            notifyDataSetChanged();
        }

        private void initSections() {
            int r1 = 1;
            if (ManageApplicationsFragment.access$5900(this.this$0) == 1) goto L5;
            return;
        L5:
            ManageApplicationsFragment.access$3700(this.this$0).clear();
            ManageApplicationsFragment.access$6000(this.this$0).clear();
            ArrayList<ApplicationsState.AppEntry> r0 = getAppEntries();
            OLog.d("ManageApplications", "entries size:" + r0.size());
            if (r0.size() <= 0) goto L14;
            String r4 = String.valueOf(r0.get(0).mLabelEntry.firstChar);
            ManageApplicationsFragment.access$3700(this.this$0).add(r4);
            ManageApplicationsFragment.access$6000(this.this$0).put(Character.valueOf(r0.get(0).mLabelEntry.firstChar), 0);
        L9:
            if (r1 >= r0.size()) goto L14;
            String r2 = String.valueOf(r0.get(r1).mLabelEntry.firstChar);
            if (r4.equals(r2) == true) goto L13;
            ManageApplicationsFragment.access$3700(this.this$0).add(r2);
            ManageApplicationsFragment.access$6000(this.this$0).put(Character.valueOf(r0.get(r1).mLabelEntry.firstChar), Integer.valueOf(r1));
            r4 = r2;
        L13:
            r1 = r1 + 1;
        L14:
            OLog.d("ManageApplications", "section position map:" + ManageApplicationsFragment.access$6000(this.this$0));
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public View getHeaderView(int r4, View r5, ViewGroup r6) {
            if (r5 != null) goto L4;
        L7:
            HeaderViewHolder r7 = new HeaderViewHolder(this);
            r5 = this.mLayoutInflater.inflate(R.layout.sticky_list_header_view, null);
            r7.headerText = (OSectionTitleBar) r5.findViewById(R.id.sticky_header);
            r5.setTag(r7);
        L8:
            ArrayList<ApplicationsState.AppEntry> r0 = getAppEntries();
            if (r0.get(r4).mLabelEntry == null) goto L11;
            String r1 = Character.toString(r0.get(r4).mLabelEntry.firstChar);
        L12:
            r7.headerText.setTitleText(r1);
            int r2 = 8;
            if (r4 != 0) goto L15;
            ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7.headerText.getLayoutParams();
            r8.topMargin = UIUtils.INSTANCE.dp2px(8);
            r7.headerText.setLayoutParams(r8);
        L16:
            OSectionTitleBar r9 = r7.headerText;
            if (ManageApplicationsFragment.access$5900(this.this$0) != 1) goto L19;
            int r10 = 0;
        L20:
            r9.setVisibility(r10);
            if (ManageApplicationsFragment.access$5900(this.this$0) != 1) goto L23;
            r2 = 0;
        L23:
            r5.setVisibility(r2);
            return r5;
        L19:
            r10 = 8;
            goto L20
        L15:
            ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r7.headerText.getLayoutParams();
            r11.topMargin = UIUtils.INSTANCE.dp2px(16);
            r7.headerText.setLayoutParams(r11);
            goto L16
        L11:
            r1 = "#";
            goto L12
        L4:
            if ((r5.getTag() instanceof HeaderViewHolder) == false) goto L7;
            r7 = (HeaderViewHolder) r5.getTag();
            goto L8
        }

        private boolean previousPositionHasSameHeader(int r4) {
            if (r4 != 0) goto L4;
        L6:
            return false;
        L4:
            if (getHeaderId(r4) != getHeaderId(r4 - 1)) goto L6;
            return true;
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public void onBindHeaderAndItem(int r6, View r7, View r8) {
            ArrayList<ApplicationsState.AppEntry> r9 = getAppEntries();
            if (r9.get(r6).mLabelEntry == null) goto L5;
            char r0 = r9.get(r6).mLabelEntry.firstChar;
        L6:
            int r1 = r6 + 1;
            if (r1 > (r9.size() - 1)) goto L9;
            char r10 = r9.get(r1).mLabelEntry.firstChar;
        L10:
            OCardListItem r11 = (OCardListItem) r8.findViewById(R.id.card_list_item);
            if (r10 == r0) goto L16;
            if (previousPositionHasSameHeader(r6) == true) goto L16;
            r11.setCardPosition(0);
            return;
        L16:
            if (previousPositionHasSameHeader(r6) == true) goto L18;
            r11.setCardPosition(1);
            return;
        L18:
            if (r10 == r0) goto L20;
            r11.setCardPosition(3);
            return;
        L20:
            r11.setCardPosition(2);
            return;
        L9:
            r10 = 0;
            goto L10
        L5:
            r0 = '#';
            goto L6
        }

        @Override // com.android.settings.stickylistheaders.StickyListHeadersAdapter
        public long getHeaderId(int r2) {
            ArrayList<ApplicationsState.AppEntry> r1 = getAppEntries();
            if (r1.get(r2).mLabelEntry != null) goto L7;
            return 35;
        L7:
            return r1.get(r2).mLabelEntry.firstChar;
        }

        @Override // android.widget.SectionIndexer
        public Object[] getSections() {
            return ManageApplicationsFragment.access$3700(this.this$0).toArray();
        }

        @Override // android.widget.SectionIndexer
        public int getPositionForSection(int r1) {
            Integer r0 = (Integer) ManageApplicationsFragment.access$6000(this.this$0).get(Character.valueOf((char) r1));
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.intValue();
        }
    }

    class PackageDeleteObserver extends IPackageDeleteObserver.Stub {
        final /* synthetic */ ManageApplicationsFragment this$0;

        PackageDeleteObserver(ManageApplicationsFragment r1) {
            this.this$0 = r1;
        }

        public void packageDeleted(String r4, int r5) {
            if (ManageApplicationsFragment.access$1100(this.this$0) == null) goto L5;
            ManageApplicationsFragment.access$1100(this.this$0).dismiss();
        L5:
            ManageApplicationsFragment.access$500(this.this$0).removeMessages(2);
            Message r6 = ManageApplicationsFragment.access$500(this.this$0).obtainMessage(2);
            r6.arg1 = 1;
            r6.obj = new Pair(r4, -1);
            ManageApplicationsFragment.access$500(this.this$0).sendMessageDelayed(r6, 500);
            if (Utils.isPackageInstalled(this.this$0.mContext, r4) == false) goto L9;
            ToastUtils.show(this.this$0.getActivity(), R.string.uninstall_updated_sys_app_done);
            return;
        }
    }

    private class SearchAction {
        private String keyword;
        private ArrayList<ApplicationsState.AppEntry> searchResult;
        final /* synthetic */ ManageApplicationsFragment this$0;

        static /* synthetic */ String access$4700(SearchAction r0) {
            return r0.keyword;
        }

        static /* synthetic */ ArrayList access$4800(SearchAction r0) {
            return r0.searchResult;
        }

        public SearchAction(ManageApplicationsFragment r1, String r2, ArrayList<ApplicationsState.AppEntry> r3) {
            this.this$0 = r1;
            this.keyword = r2;
            this.searchResult = r3;
        }
    }

    private class SearchAdapter extends AppListAdapter {
        final /* synthetic */ ManageApplicationsFragment this$0;

        public SearchAdapter(ManageApplicationsFragment r1, Context r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.android.settings.applications.ManageApplicationsFragment.AppListAdapter, android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            View r4 = super.getView(r1, r2, r3);
            OCardListItemUtils.initCardItemInAdapter(this, (OCardListItem) r4.findViewById(R.id.card_list_item), r1);
            return r4;
        }
    }

    private class SearchBarCallback extends SearchBar.ListenerAdapter {
        final /* synthetic */ ManageApplicationsFragment this$0;

        private SearchBarCallback(ManageApplicationsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SearchBarCallback(ManageApplicationsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationStart() {
            if (ManageApplicationsFragment.access$1200(this.this$0).isFocused() == false) goto L6;
            ViewGroup.LayoutParams r0 = ManageApplicationsFragment.access$1300(this.this$0).getLayoutParams();
            r0.height = ManageApplicationsFragment.access$1300(this.this$0).getHeight() + ManageApplicationsFragment.access$1400(this.this$0);
            ManageApplicationsFragment.access$1300(this.this$0).setLayoutParams(r0);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void exeAnimationEnd() {
            if (ManageApplicationsFragment.access$1200(this.this$0).isFocused() == true) goto L6;
            ViewGroup.LayoutParams r0 = ManageApplicationsFragment.access$1300(this.this$0).getLayoutParams();
            r0.height = -1;
            ManageApplicationsFragment.access$1300(this.this$0).setLayoutParams(r0);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void searchText(String r1) {
            ManageApplicationsFragment.access$1500(this.this$0, r1);
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchEdit() {
            if (ManageApplicationsFragment.access$1200(this.this$0).isFocused() == true) goto L6;
            ManageApplicationsFragment.access$1600(this.this$0);
            ManageApplicationsFragment.access$1700(this.this$0);
            ManageApplicationsFragment.access$300(this.this$0).restoreScrollState(true);
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickCancelButton() {
            if (ManageApplicationsFragment.access$1200(this.this$0).isFocused() == false) goto L8;
            ManageApplicationsFragment.access$1800(this.this$0);
            if (ManageApplicationsFragment.access$1900(this.this$0) == null) goto L9;
            ManageApplicationsFragment.access$1900(this.this$0).rebuild();
            return;
        L9:
            return;
        }

        @Override // obric.widget.SearchBar.ListenerAdapter, obric.widget.SearchBar.Listener
        public void onClickSearchRightView() {
            ManageApplicationsFragment.access$2000(this.this$0);
        }
    }

    private class SortMenuItem extends AbsMenuItem {
        int iconRes;
        boolean isSelected;
        final /* synthetic */ ManageApplicationsFragment this$0;
        String title;

        SortMenuItem(ManageApplicationsFragment r7, Context r8, int r9, int r10) {
            this(r7, r8, r9, r10, false);
        }

        SortMenuItem(ManageApplicationsFragment r1, Context r2, int r3, int r4, boolean r5) {
            this.this$0 = r1;
            this.title = r2.getResources().getString(r3);
            this.iconRes = r4;
            this.isSelected = r5;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public String getTitle() {
            return this.title;
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public void setMenuIcon(ImageView r1) {
            r1.setImageResource(this.iconRes);
        }

        @Override // obric.widget.support.AbsMenuItem, obric.widget.support.IMenuItem
        public boolean isSelected() {
            return this.isSelected;
        }
    }

    private class SortModeItemClickListener implements AdapterView.OnItemClickListener {
        final /* synthetic */ ManageApplicationsFragment this$0;

        private SortModeItemClickListener(ManageApplicationsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SortModeItemClickListener(ManageApplicationsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
            if (r3 != 0) goto L5;
            ManageApplicationsFragment.access$2100(this.this$0, 1);
            return;
        L5:
            if (r3 == 1) goto L12;
            if (r3 != 2) goto L8;
            ManageApplicationsFragment.access$2100(this.this$0, 4);
            return;
        L8:
            if (r3 != 3) goto L18;
            ManageApplicationsFragment.access$2100(this.this$0, 8);
            return;
        L18:
            return;
        L12:
            ManageApplicationsFragment.access$2100(this.this$0, 2);
        }
    }

    private boolean resetQuickBarState() {
        return false;
    }

    private void updateTitleBar() {
    }

    public void com_android_settings_applications_ManageApplicationsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public boolean isItemCanScroll(int r1) {
        return true;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.api.OnSettingsItemLongClickListener
    public boolean onItemLongClick(Adapter r1, View r2, int r3) {
        return false;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // com.android.settings.widget.SlideListView.OnQuickBarChangedListener
    public boolean processQuickBar() {
        return false;
    }

    public ManageApplicationsFragment() {
        this.coldStartTime = 0;
        this.mSelectedProfileTab = 0;
        this.mSections = new ArrayList();
        this.mPositionOfSections = new HashMap();
        this.mCurrentSortMode = 1;
        this.mComparator = ApplicationsState.ALPHA_COMPARATOR;
        this.mUninstallingApp = false;
        this.mIsItemScrollRestored = true;
        this.mIsEditMode = false;
        this.mIsEditAnimationRunning = false;
        this.mTodoUninstallMap = new HashMap();
        this.mAppsCanEditSize = 0;
        this.mPopMenu = new PopMenu();
        this.mSearchBarAnimHeight = 0;
        this.animTargetTransY = UIUtils.INSTANCE.dp2px(-56);
        this.searchModeSwitchAnimHelperType2 = new SearchModeSwitchAnimHelperType2();
        this.mHandler = new AnonymousClass1(this);
        this.mKeyguardOnReceiver = new AnonymousClass19(this);
        this.mQBListener = new AnonymousClass23(this);
        this.mPkgDeleteObserver = new PackageDeleteObserver(this);
        this.mDeleteAnimatorListener = new AnonymousClass40(this);
        this.mLauncherCallback = new AnonymousClass43(this);
    }

    static /* synthetic */ boolean access$000(ManageApplicationsFragment r0) {
        return r0.mIsEditMode;
    }

    static /* synthetic */ Map access$100(ManageApplicationsFragment r0) {
        return r0.mTodoUninstallMap;
    }

    static /* synthetic */ BytedanceProgressDialog access$1000(ManageApplicationsFragment r0) {
        return r0.mCalculateSizeDialog;
    }

    static /* synthetic */ BytedanceProgressDialog access$1002(ManageApplicationsFragment r0, BytedanceProgressDialog r1) {
        r0.mCalculateSizeDialog = r1;
        return r1;
    }

    static /* synthetic */ BytedanceProgressDialog access$1100(ManageApplicationsFragment r0) {
        return r0.mUninstallingDialog;
    }

    static /* synthetic */ BytedanceProgressDialog access$1102(ManageApplicationsFragment r0, BytedanceProgressDialog r1) {
        r0.mUninstallingDialog = r1;
        return r1;
    }

    static /* synthetic */ OEditText access$1200(ManageApplicationsFragment r0) {
        return r0.mSearchView;
    }

    static /* synthetic */ View access$1300(ManageApplicationsFragment r0) {
        return r0.mWholeView;
    }

    static /* synthetic */ int access$1400(ManageApplicationsFragment r0) {
        return r0.mSearchBarAnimHeight;
    }

    static /* synthetic */ void access$1500(ManageApplicationsFragment r0, String r1) {
        r0.search(r1);
    }

    static /* synthetic */ boolean access$1600(ManageApplicationsFragment r0) {
        return r0.resetQuickBarState();
    }

    static /* synthetic */ void access$1700(ManageApplicationsFragment r0) {
        r0.initStartSearchAnimation();
    }

    static /* synthetic */ void access$1800(ManageApplicationsFragment r0) {
        r0.startEndSearchAnimation();
    }

    static /* synthetic */ ApplicationsAdapter access$1900(ManageApplicationsFragment r0) {
        return r0.mApplicationsAdapter;
    }

    static /* synthetic */ int access$200(ManageApplicationsFragment r0, String r1, int r2) {
        return r0.getPositionInList(r1, r2);
    }

    static /* synthetic */ void access$2000(ManageApplicationsFragment r0) {
        r0.showSortByPopupWindow();
    }

    static /* synthetic */ void access$2100(ManageApplicationsFragment r0, int r1) {
        r0.switchSortMode(r1);
    }

    static /* synthetic */ OIconButton access$2300(ManageApplicationsFragment r0) {
        return r0.mModeFilterBtn;
    }

    static /* synthetic */ void access$2400(ManageApplicationsFragment r0) {
        r0.initSearchPaddingTop();
    }

    static /* synthetic */ OSearchBar access$2500(ManageApplicationsFragment r0) {
        return r0.mSearchBar;
    }

    static /* synthetic */ SearchModeSwitchAnimHelperType2 access$2600(ManageApplicationsFragment r0) {
        return r0.searchModeSwitchAnimHelperType2;
    }

    static /* synthetic */ void access$2700(ManageApplicationsFragment r0) {
        r0.cancelSearch();
    }

    static /* synthetic */ void access$2800(ManageApplicationsFragment r0) {
        r0.hideIME();
    }

    static /* synthetic */ SlideListView access$300(ManageApplicationsFragment r0) {
        return r0.mListView;
    }

    static /* synthetic */ SearchBarCallback access$3000(ManageApplicationsFragment r0) {
        return r0.mSearchBarCallback;
    }

    static /* synthetic */ int access$3102(ManageApplicationsFragment r0, int r1) {
        r0.mDownX = r1;
        return r1;
    }

    static /* synthetic */ int access$3202(ManageApplicationsFragment r0, int r1) {
        r0.mDownY = r1;
        return r1;
    }

    static /* synthetic */ int access$3300(ManageApplicationsFragment r0) {
        return r0.mSelectedProfileTab;
    }

    static /* synthetic */ int access$3302(ManageApplicationsFragment r0, int r1) {
        r0.mSelectedProfileTab = r1;
        return r1;
    }

    static /* synthetic */ OButtonGroup access$3400(ManageApplicationsFragment r0) {
        return r0.mSearchBarCancel;
    }

    static /* synthetic */ View access$3500(ManageApplicationsFragment r0) {
        return r0.mSearchIcon;
    }

    static /* synthetic */ View access$3600(ManageApplicationsFragment r0) {
        return r0.mProfileTabsContainer;
    }

    static /* synthetic */ ArrayList access$3700(ManageApplicationsFragment r0) {
        return r0.mSections;
    }

    static /* synthetic */ FpsTracer access$3800(ManageApplicationsFragment r0) {
        return r0.mFpsTracer;
    }

    static /* synthetic */ void access$3900(ManageApplicationsFragment r0) {
        r0.launchLockedAppsManagement();
    }

    static /* synthetic */ Animator.AnimatorListener access$400(ManageApplicationsFragment r0) {
        return r0.mDeleteAnimatorListener;
    }

    static /* synthetic */ void access$4000(ManageApplicationsFragment r0) {
        r0.launchHiddenAppsManagement();
    }

    static /* synthetic */ View access$4100(ManageApplicationsFragment r0) {
        return r0.mSearchResultView;
    }

    static /* synthetic */ void access$4200(ManageApplicationsFragment r0) {
        r0.setQuickBarVisibility();
    }

    static /* synthetic */ int access$4302(ManageApplicationsFragment r0, int r1) {
        r0.mUninstallAppTotal = r1;
        return r1;
    }

    static /* synthetic */ RelativeLayout access$4400(ManageApplicationsFragment r0) {
        return r0.mEditBarView;
    }

    static /* synthetic */ boolean access$4502(ManageApplicationsFragment r0, boolean r1) {
        r0.mIsEditAnimationRunning = r1;
        return r1;
    }

    static /* synthetic */ SearchAction access$4600(ManageApplicationsFragment r0) {
        return r0.mLastSearch;
    }

    static /* synthetic */ SearchAction access$4602(ManageApplicationsFragment r0, SearchAction r1) {
        r0.mLastSearch = r1;
        return r1;
    }

    static /* synthetic */ ApplicationsState access$4900(ManageApplicationsFragment r0) {
        return r0.mApplicationsState;
    }

    static /* synthetic */ Handler access$500(ManageApplicationsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ ApplicationsState.AppFilter access$5000(ManageApplicationsFragment r0) {
        return r0.mAppFilter;
    }

    static /* synthetic */ boolean access$5100(ManageApplicationsFragment r0) {
        return r0.isOriginalLauncherActive();
    }

    static /* synthetic */ PackageManager access$5200(ManageApplicationsFragment r0) {
        return r0.mPm;
    }

    static /* synthetic */ boolean access$5300(ManageApplicationsFragment r0) {
        return r0.isLockedPackagesPage;
    }

    static /* synthetic */ void access$5400(ManageApplicationsFragment r0) {
        r0.updateView();
    }

    static /* synthetic */ boolean access$5502(ManageApplicationsFragment r0, boolean r1) {
        r0.mAllSizesComputed = r1;
        return r1;
    }

    static /* synthetic */ boolean access$5600(ManageApplicationsFragment r0) {
        return r0.mUninstallingApp;
    }

    static /* synthetic */ boolean access$5602(ManageApplicationsFragment r0, boolean r1) {
        r0.mUninstallingApp = r1;
        return r1;
    }

    static /* synthetic */ Comparator access$5700(ManageApplicationsFragment r0) {
        return r0.mComparator;
    }

    static /* synthetic */ int access$5900(ManageApplicationsFragment r0) {
        return r0.mCurrentSortMode;
    }

    static /* synthetic */ BytedanceProgressDialog access$600(ManageApplicationsFragment r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ HashMap access$6000(ManageApplicationsFragment r0) {
        return r0.mPositionOfSections;
    }

    static /* synthetic */ BytedanceProgressDialog access$602(ManageApplicationsFragment r0, BytedanceProgressDialog r1) {
        r0.mProgressDialog = r1;
        return r1;
    }

    static /* synthetic */ boolean access$6100(ManageApplicationsFragment r0) {
        return r0.mIsSystemAppManager;
    }

    static /* synthetic */ void access$6200(ManageApplicationsFragment r0, boolean r1) {
        r0.inflateFooterView(r1);
    }

    static /* synthetic */ TextView access$6300(ManageApplicationsFragment r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ int access$6402(ManageApplicationsFragment r0, int r1) {
        r0.mAppsCanEditSize = r1;
        return r1;
    }

    static /* synthetic */ void access$6500(ManageApplicationsFragment r0) {
        r0.updateSelectBar();
    }

    static /* synthetic */ long access$6600(ManageApplicationsFragment r2) {
        return r2.coldStartTime;
    }

    static /* synthetic */ long access$6602(ManageApplicationsFragment r0, long r1) {
        r0.coldStartTime = r1;
        return r1;
    }

    static /* synthetic */ boolean access$6700(ManageApplicationsFragment r0, ApplicationsState.AppEntry r1) {
        return r0.canUninstall(r1);
    }

    static /* synthetic */ String access$700(ManageApplicationsFragment r0) {
        return r0.getUninstallProgressText();
    }

    static /* synthetic */ void access$7100(ManageApplicationsFragment r0, ApplicationsState.AppEntry r1) {
        r0.unintall(r1);
    }

    static /* synthetic */ boolean access$7200(ManageApplicationsFragment r0, boolean r1) {
        return r0.restoreListViewScrollState(r1);
    }

    static /* synthetic */ void access$7300(ManageApplicationsFragment r0, ApplicationsState.AppEntry r1) {
        r0.startUninstallPackageDialog(r1);
    }

    static /* synthetic */ void access$7400(ManageApplicationsFragment r0, String r1) {
        r0.showUninstallingProgressDialog(r1);
    }

    static /* synthetic */ void access$7500(ManageApplicationsFragment r0, ApplicationManager r1, ApplicationsState.AppEntry r2, PackageManager r3) {
        r0.uninstallPackage(r1, r2, r3);
    }

    static /* synthetic */ AlertDialog access$7602(ManageApplicationsFragment r0, AlertDialog r1) {
        r0.mUninstallDialog = r1;
        return r1;
    }

    static /* synthetic */ String access$7700(ManageApplicationsFragment r0) {
        return r0.mUninstallingPkg;
    }

    static /* synthetic */ String access$7702(ManageApplicationsFragment r0, String r1) {
        r0.mUninstallingPkg = r1;
        return r1;
    }

    static /* synthetic */ HorizontalScrollListView access$7800(ManageApplicationsFragment r0) {
        return r0.mSearchResultListView;
    }

    static /* synthetic */ Runnable access$7900(ManageApplicationsFragment r0) {
        return r0.mDoppelgangerAppDeleteRunnable;
    }

    static /* synthetic */ Runnable access$7902(ManageApplicationsFragment r0, Runnable r1) {
        r0.mDoppelgangerAppDeleteRunnable = r1;
        return r1;
    }

    static /* synthetic */ void access$800(ManageApplicationsFragment r0) {
        r0.loopUninstall();
    }

    static /* synthetic */ void access$900(ManageApplicationsFragment r0, boolean r1) {
        r0.onEditModeChanged(r1);
    }

    private int getPositionInList(String r5, int r6) {
        ArrayList<ApplicationsState.AppEntry> r4 = this.mApplicationsAdapter.getAppEntries();
        if (r4 == null) goto L17;
        int r1 = 0;
    L6:
        if (r1 >= r4.size()) goto L24;
        ApplicationsState.AppEntry r2 = r4.get(r1);
        if (r5.equals(r2.info.packageName) == false) goto L12;
        if (r6 != (-1)) goto L12;
    L23:
        return r1;
    L12:
        if (r5.equals(r2.info.packageName) == false) goto L16;
        if (UserHandle.getUserId(r2.info.uid) == r6) goto L23;
    L16:
        r1 = r1 + 1;
        goto L6
    L24:
        return -1;
    L17:
        return -1;
    }

    private String getUninstallProgressText() {
        if (this.mTodoUninstallMap.isEmpty() == false) goto L5;
        int r0 = this.mUninstallAppTotal;
    L13:
        return getString(R.string.deleting_current_app, new Object[]{Integer.valueOf(r0), Integer.valueOf(this.mUninstallAppTotal)});
    L5:
        Iterator<Set<String>> r1 = this.mTodoUninstallMap.values().iterator();
        int r3 = 0;
    L7:
        if (r1.hasNext() == false) goto L9;
        r3 = r3 + r1.next().size();
        goto L7
    L9:
        r0 = this.mUninstallAppTotal - r3;
        if (r0 != 0) goto L13;
        r0 = 1;
        goto L13
    }

    private void loopUninstall() {
        ApplicationManager r0 = new ApplicationManager(this.mContext, this.mHandler);
        Iterator<ApplicationsState.AppEntry> r1 = this.mApplicationsAdapter.getAppEntries().iterator();
        boolean r3 = true;
    L4:
        if (r1.hasNext() == false) goto L11;
        ApplicationsState.AppEntry r4 = r1.next();
        if (this.mTodoUninstallMap.get(Integer.valueOf(UserHandle.getUserId(r4.info.uid))).contains(r4.info.packageName) == false) goto L4;
        if (this.mUninstallingApp == true) goto L9;
        this.mUninstallingApp = true;
        uninstallPackage(r0, r4, this.mContext.getPackageManager());
        r3 = false;
        goto L4
    L9:
        return;
    L11:
        if (r3 == false) goto L20;
        this.mHandler.sendEmptyMessage(12);
        return;
    }

    private void initPopupMenuItems() {
        SortMenuItem[] r0 = new SortMenuItem[4];
        this.mMenuItems = r0;
        r0[0] = new SortMenuItem(this, this.mContext, R.string.sort_by_name, R.drawable.sort_menu_name_icon);
        this.mMenuItems[1] = new SortMenuItem(this, this.mContext, R.string.sort_by_size, R.drawable.sort_menu_size_icon);
        this.mMenuItems[2] = new SortMenuItem(this, this.mContext, R.string.sort_by_install_time, R.drawable.sort_menu_creat_time_icon);
        this.mMenuItems[3] = new SortMenuItem(this, this.mContext, R.string.sort_by_frequency, R.drawable.sort_menu_frequency_icon);
    }

    private void showSortByPopupWindow() {
        initSortModeUI();
        ListPopupMenu r0 = new ListPopupMenu(this.mContext);
        this.mPopupWindow = r0;
        r0.setMenuListTitleVisible(true);
        String r1 = this.mContext.getResources().getString(R.string.sort_menu_title);
        this.mPopupWindow.setMenuListTitle(r1);
        this.mPopupWindow.setAnchorView(this.mModeFilterBtn);
        this.mPopupWindow.setArrowInvisible();
        this.mPopupWindow.setAdapter(new ListPopMenuStandardAdapter(this.mContext, 0, this.mMenuItems));
        this.mPopupWindow.setOnItemClickListener(new SortModeItemClickListener(this, null));
        int r4 = -Utils.dp2Pixels(this.mContext, 218.5f);
        int r5 = -Utils.dp2Pixels(this.mContext, 6.5f);
        int r6 = Utils.dp2Pixels(this.mContext, 190.6f);
        this.mPopupWindow.show(0, r4, r5, r6, 0);
        this.mModeFilterBtn.setActivated(true);
        this.mPopupWindow.setOnDismissListener(new AnonymousClass2(this));
    }

    private void initSortModeUI() {
        SortMenuItem[] r0 = this.mMenuItems;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0[r3].isSelected = false;
        r3 = r3 + 1;
        goto L3
    L5:
        int r2 = this.mCurrentSortMode;
        if (r2 != 1) goto L8;
        this.mMenuItems[0].isSelected = true;
        return;
    L8:
        if (r2 != 2) goto L10;
        this.mMenuItems[1].isSelected = true;
        return;
    L10:
        if (r2 != 4) goto L12;
        this.mMenuItems[2].isSelected = true;
        return;
    L12:
        if (r2 != 8) goto L23;
        this.mMenuItems[3].isSelected = true;
        return;
    }

    private void switchSortMode(int r3) {
        ListPopupMenu r0 = this.mPopupWindow;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mPopupWindow.dismiss();
    L8:
        if (this.mCurrentSortMode != r3) goto L10;
        return;
    L10:
        this.mCurrentSortMode = r3;
        OLog.d("ManageApplications", "onModeChange: switchSortMode " + this.mCurrentSortMode);
        if (r3 != 1) goto L13;
        this.mComparator = ApplicationsState.ALPHA_COMPARATOR;
    L25:
        resetQuickBarState();
        setQuickBarVisibility();
        this.mApplicationsAdapter.sortEntries(this.mComparator);
        this.mListView.smoothScrollToPosition(0);
        return;
    L13:
        if (r3 != 2) goto L15;
        this.mComparator = ApplicationsState.SIZE_COMPARATOR;
        if (this.mAllSizesComputed == true) goto L25;
        showCalculateDialog();
        goto L25
    L15:
        if (r3 != 4) goto L17;
        this.mComparator = ApplicationsState.INSTALL_TIME_COMPARATOR;
        goto L25
    L17:
        if (r3 != 8) goto L25;
        this.mComparator = ApplicationsState.FREQUENCY_COMPARATOR;
        goto L25
    }

    public void com_android_settings_applications_ManageApplicationsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mDefaultTitle = getString(R.string.title_button_text_back);
        List<String> r5 = whiteAppList;
        if (r5 != null) goto L5;
    L6:
        whiteAppList = Arrays.asList(getResources().getStringArray(R.array.uninstall_white_app_list));
    L7:
        List<String> r6 = whiteComponentList;
        if (r6 != null) goto L10;
    L11:
        whiteComponentList = Arrays.asList(getResources().getStringArray(R.array.uninstall_white_component_list));
    L12:
        List<String> r7 = whiteAppsHasPrefixMsg;
        if (r7 != null) goto L15;
    L16:
        whiteAppsHasPrefixMsg = Arrays.asList(getResources().getStringArray(R.array.uninstall_white_app_prefix_list));
    L17:
        OLog.d("ManageApplications", "the white app list size:" + whiteAppList.size() + ", component size:" + whiteComponentList.size());
        this.coldStartTime = AppMetricsUtils.INSTANCE.getColdStartTime();
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
        OLog.d("ManageApplications", "onCreate coldStartTime=" + this.coldStartTime);
        return;
    L15:
        if (r7.size() != 0) goto L17;
    L10:
        if (r6.size() != 0) goto L12;
    L5:
        if (r5.size() != 0) goto L7;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        this.mRootView = (ViewGroup) r5.inflate(R.layout.manage_applications_sticky_header_list, r6, false);
        this.mTitleOkBtnDefaultBgRes = R.drawable.selector_title_button_highlight;
        this.mViewTitle = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        this.mWholeView = findViewByIdNullable(R.id.whole_view);
        this.mSearchBar = (OSearchBar) findViewByIdNullable(R.id.search_field_bar);
        this.mSearchIcon = this.mViewTitle.addEndAction(R.drawable.settings_ext_oic_magnifier_search, -1, new AnonymousClass3(this));
        this.mSearchView = this.mSearchBar.getInputView();
        this.mSearchBarCancel = (OButtonGroup) findViewByIdNullable(R.id.search_cancel_button);
        View r8 = OButtonUtils.INSTANCE.createIconActionView(getContext(), R.drawable.oui_cance_x_icon);
        this.mSearchBarCancel.addItemView(r8, new ViewGroup.MarginLayoutParams(-2, -2));
        this.mSearchBarCancel.setVisibility(4);
        r8.setOnClickListener(new AnonymousClass4(this));
        this.mSearchBarCallback = new SearchBarCallback(this, null);
        this.mSearchView.addTextChangedListener(new AnonymousClass5(this));
        this.mSearchView.setOnEditorActionListener(new AnonymousClass6(this));
        initPopupMenuItems();
        this.mEditBarView = (RelativeLayout) findViewByIdNullable(R.id.option_bar);
        OCheckBox r9 = (OCheckBox) findViewByIdNullable(R.id.checkbox_select_all);
        this.mSelectAllCheckBox = r9;
        r9.setOnClickListener(this);
        this.mOptionTextView = (TextView) findViewByIdNullable(R.id.option_title);
        Bundle r10 = getArguments();
        this.isLockedPackagesPage = r10.getBoolean(EXTRA_LOCK_PACKAGES, false);
        this.isHiddenPackagesPage = r10.getBoolean(EXTRA_HIDDEN_PACKAGES, false);
        this.mIsSystemAppManager = r10.getBoolean(EXTRA_SYSTEM_APP_MANAGER, false);
        if (this.isLockedPackagesPage == false) goto L6;
        registerKeyguardReceiver();
    L6:
        if (this.isHiddenPackagesPage == false) goto L8;
        this.mAppFilter = ApplicationsState.SYSTEM_COMPONENT_FILTER;
    L9:
        Iterator<UserHandle> r11 = ((UserManager) getSystemService(PickApplicationActivity.EXTRA_USER)).getUserProfiles().iterator();
    L11:
        if (r11.hasNext() == false) goto L13;
        UserHandle r12 = r11.next();
        this.mTodoUninstallMap.put(Integer.valueOf(r12.getIdentifier()), new HashSet());
        goto L11
    L13:
        this.mTodoUninstallMap.put(10, new HashSet());
        this.mEmptyView = (TextView) findViewByIdNullable(R.id.view_empty);
        SlideListView r13 = (SlideListView) findViewByIdNullable(R.id.listView);
        this.mListView = r13;
        r13.setSlideListener(this);
        this.mListView.setEmptyView(this.mEmptyView);
        this.mListView.setOnScrollStateChangeListener(this);
        this.mListView.setOnQuickBarChanged(this);
        if (this.mIsExtDisplaying == false) goto L16;
        this.mListView.setVerticalScrollBarEnabled(false);
    L16:
        NavigationBarHelper.setBottomPaddingWhenNavigationBarStatusChange(this.mListView);
        this.mSearchResultView = findViewByIdNullable(R.id.seachresultview);
        this.mSearchResultListView = (HorizontalScrollListView) findViewByIdNullable(R.id.search_listview);
        this.mSearchEmptyView = findViewByIdNullable(R.id.search_empty_view);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass7(this));
        this.mSearchResultListView.setOnTouchListener(new AnonymousClass8(this));
        TextView r14 = (TextView) findViewByIdNullable(R.id.searchview_bg);
        this.mSearchBackground = r14;
        r14.setOnClickListener(new AnonymousClass9(this));
        Bitmap[][] r15 = (Bitmap[][]) Array.newInstance(Bitmap.class, new int[]{1, 3});
        this.mLetterProfileBitmaps = r15;
        r15[0][0] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_nor);
        this.mLetterProfileBitmaps[0][1] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_holder);
        this.mLetterProfileBitmaps[0][2] = BitmapFactory.decodeResource(getResources(), R.drawable.quickbar_setting_touch);
        if (this.isLockedPackagesPage == false) goto L20;
        this.mTitleStringResId = R.string.locked_packages;
    L23:
        this.mApplicationsState = ApplicationsState.getInstance(getApplication(), true);
        this.mApplicationsAdapter = new ApplicationsAdapter(this, this._mActivity, this.mApplicationsState);
        this.mListView.setAreHeadersSticky(true);
        this.mListView.setAdapter(this.mApplicationsAdapter);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        this.mApplicationsAdapter.setOnItemClickListener(this);
        this.mApplicationsAdapter.setOnItemLongClickListener(this);
        this.mListView.setOnTouchListener(new AnonymousClass10(this));
        this.mPm = getPackageManager();
        this.mDpm = (DevicePolicyManager) getSystemService("device_policy");
        this.mLauncherAppsService = (LauncherApps) getSystemService("launcherapps");
        initAnimationInSearchBar();
        setAllParentClipChildrenFalse(this.mSearchIcon);
        setAllParentClipChildrenFalse(this.mBackView);
        setAllParentClipChildrenFalse(this.mSearchBar);
        this.mSearchBackground.setVisibility(8);
        this.mListView.setAreHeadersSticky(false);
        View r16 = new View(getContext());
        this.mHeaderSpaceView = r16;
        r16.setLayoutParams(new AbsListView.LayoutParams(-1, UIUtils.INSTANCE.dp2px(96)));
        this.mListView.addHeaderView(this.mHeaderSpaceView);
        setupProfileTabs();
        updateProfileTabsVisibility();
        return this.mRootView;
    L20:
        if (this.isHiddenPackagesPage == false) goto L22;
        this.mTitleStringResId = R.string.hidden_packages;
        goto L23
    L22:
        this.mTitleStringResId = R.string.advanced_item_application;
        goto L23
    L8:
        this.mAppFilter = ApplicationsState.COMMON_APP_FILTER;
        goto L9
    }

    private void setupProfileTabs() {
        this.mProfileTabsContainer = findViewByIdNullable(R.id.profile_tabs_container);
        OTabSegmentedLayout r0 = (OTabSegmentedLayout) findViewByIdNullable(R.id.profile_tabs);
        this.mProfileTabs = r0;
        if (r0 == null) goto L6;
        ArrayList r1 = new ArrayList(2);
        r1.add(getResources().getString(R.string.category_personal));
        r1.add(getResources().getString(R.string.category_work));
        this.mProfileTabs.setTabTitleAndDrawable((String[]) r1.toArray(new String[0]), null);
        this.mProfileTabs.setOnTabSelectListener(new AnonymousClass11(this));
        return;
    }

    private void updateProfileTabsVisibility() {
        if (this.mProfileTabsContainer != null) goto L5;
        return;
    L5:
        UserManager r0 = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        Iterator<UserHandle> r1 = r0.getUserProfiles().iterator();
    L6:
        int r3 = 0;
        if (r1.hasNext() == false) goto L11;
        if (r0.isManagedProfile(r1.next().getIdentifier()) == false) goto L6;
        boolean r2 = true;
    L12:
        View r4 = this.mProfileTabsContainer;
        if (r2 == true) goto L16;
        r3 = 8;
    L16:
        r4.setVisibility(r3);
        View r5 = this.mHeaderSpaceView;
        if (r5 == null) goto L28;
        if (r2 == false) goto L20;
        int r6 = 160;
    L21:
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L29;
        r7.height = UIUtils.INSTANCE.dp2px(r6);
        this.mHeaderSpaceView.setLayoutParams(r7);
        return;
    L29:
        return;
    L20:
        r6 = 96;
        goto L21
    L28:
        return;
    L11:
        r2 = false;
        goto L12
    }

    private void initSearchPaddingTop() {
        ViewGroup r0 = (ViewGroup) this.mTitleView.findViewById(R.id.title_bar_container);
        ViewGroup r1 = (ViewGroup) this.mRootView.findViewById(R.id.search_bar_container);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        if (r3 == null) goto L6;
        if (r2 == null) goto L6;
        r3.topMargin = r2.topMargin + UIUtils.INSTANCE.dp2px(8);
        r1.setLayoutParams(r3);
    L6:
        View r5 = this.mRootView.findViewById(R.id.seachresultview);
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        if (r4 == null) goto L10;
        r4.topMargin = UIUtils.INSTANCE.dp2px(112);
        r5.setLayoutParams(r4);
        return;
    }

    private void setAllParentClipChildrenFalse(View r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if ((r3 instanceof ViewGroup) == false) goto L10;
        ViewGroup r0 = (ViewGroup) r3;
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        ViewParent r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L11;
        setAllParentClipChildrenFalse((ViewGroup) r4);
        return;
    L11:
        return;
    }

    private void initAnimationInSearchBar() {
        final View r0 = findViewByIdNullable(R.id.main_page);
        final View r1 = findViewByIdNullable(R.id.seachresultview);
        this.mSearchBar.post(new AnonymousClass12(this, r0, r1));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mBackView.setOnClickListener(this);
        this.mLauncherAppsService.registerCallback(this.mLauncherCallback, this.mHandler);
        OIndexScrollbar r4 = (OIndexScrollbar) findViewByIdNullable(R.id.index_scrollbar);
        this.mIndexScrollbar = r4;
        r4.setQBListener(new AnonymousClass13(this));
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L5;
        String r6 = r5.getLocalClassName();
    L6:
        final String r7 = r6 + "_ManageApplications_list_view_scroll";
        OLog.i("ManageApplications", "scene=" + r7);
        FpsTracer r8 = new FpsTracer(r7);
        this.mFpsTracer = r8;
        r8.setIFPSCallBack(new AnonymousClass14(this, r7));
        this.mFpsTracer.setDropFrameCallback(new AnonymousClass15(this, r7));
        this.mListView.setOnScrollListener(new AnonymousClass16(this));
        return;
    L5:
        r6 = "null";
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void inflateFooterView(boolean r6) {
        if (this.isLockedPackagesPage == false) goto L5;
        return;
    L5:
        if (this.isHiddenPackagesPage == false) goto L8;
        return;
    L8:
        if (this.mIsEditMode == true) goto L10;
        int r1 = 0;
        if (this.mListView.getFooterViewsCount() == 0) goto L16;
        View r5 = this.mLockedAppsView;
        if (r5 == null) goto L33;
        if (r6 == true) goto L28;
        r1 = 8;
    L28:
        r5.setVisibility(r1);
        return;
    L33:
        return;
    L16:
        if (this.mHeaderView != null) goto L22;
        View r0 = LayoutInflater.from(this._mActivity).inflate(R.layout.app_management_list_header_view, null);
        this.mHeaderView = r0;
        this.mHiddenAppsView = (OCardListItem) r0.findViewById(R.id.hidden_packages_view);
        View r2 = this.mHeaderView.findViewById(R.id.locked_packages_view);
        this.mLockedAppsView = r2;
        r2.setOnClickListener(new AnonymousClass17(this));
        if (r6 == true) goto L20;
        this.mLockedAppsView.setVisibility(8);
    L21:
        this.mHiddenAppsView.setOnContentClickListener(new AnonymousClass18(this));
        goto L22
    L20:
        this.mLockedAppsView.setVisibility(0);
    L22:
        this.mListView.addFooterView(this.mHeaderView);
        return;
    L10:
        if (this.mListView.getFooterViewsCount() <= 0) goto L30;
        this.mListView.removeFooterView(this.mHeaderView);
        return;
    }

    private void registerKeyguardReceiver() {
        IntentFilter r0 = new IntentFilter(InstalledAppDetails.ACTION_KEYGUARD_ON);
        registerReceiver(this.mKeyguardOnReceiver, r0);
    }

    private void launchLockedAppsManagement() {
        ManageApplicationsFragment r0 = new ManageApplicationsFragment();
        Bundle r1 = new Bundle();
        r1.putInt("back_text_id", R.string.advanced_item_application);
        r1.putInt("title_id", R.string.locked_packages);
        r1.putBoolean(EXTRA_LOCK_PACKAGES, true);
        r1.putBoolean(EXTRA_SYSTEM_APP_MANAGER, this.mIsSystemAppManager);
        r0.setArguments(r1);
        start(r0);
    }

    private void launchHiddenAppsManagement() {
        ManageApplicationsFragment r0 = new ManageApplicationsFragment();
        Bundle r1 = new Bundle();
        r1.putInt("back_text_id", R.string.advanced_item_application);
        r1.putInt("title_id", R.string.hidden_packages);
        r1.putBoolean(EXTRA_HIDDEN_PACKAGES, true);
        r1.putBoolean(EXTRA_SYSTEM_APP_MANAGER, this.mIsSystemAppManager);
        r0.setArguments(r1);
        start(r0);
    }

    private List<ManageApplicationsMenuItem> getSortMenuList() {
        String r1 = getString(R.string.sort_by_name);
        boolean r3 = false;
        if (this.mCurrentSortMode != 1) goto L5;
        boolean r2 = true;
    L6:
        ManageApplicationsMenuItem r0 = new ManageApplicationsMenuItem(r1, r2, 1, R.drawable.settings_oic_text_a_cricle_fill);
        String r4 = getString(R.string.sort_by_size);
        if (this.mCurrentSortMode != 2) goto L9;
        boolean r5 = true;
    L10:
        ManageApplicationsMenuItem r6 = new ManageApplicationsMenuItem(r4, r5, 2, R.drawable.settings_oic_disk_fill);
        String r7 = getString(R.string.sort_by_install_time);
        if (this.mCurrentSortMode != 4) goto L13;
        boolean r8 = true;
    L14:
        ManageApplicationsMenuItem r9 = new ManageApplicationsMenuItem(r7, r8, 4, R.drawable.settings_oic_clock);
        String r10 = getString(R.string.sort_by_frequency);
        if (this.mCurrentSortMode != 8) goto L17;
        r3 = true;
    L17:
        ManageApplicationsMenuItem r11 = new ManageApplicationsMenuItem(r10, r3, 8, R.drawable.o_ic_list);
        ArrayList r12 = new ArrayList();
        r12.add(r0);
        r12.add(r6);
        r12.add(r9);
        r12.add(r11);
        return r12;
    L13:
        r8 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private void showSortDialog(View r19) {
        OPopover.Builder r1 = new OPopover.Builder(getActivity());
        this.mSortDialog = null;
        final Function r2 = new ManageApplicationsFragment$$ExternalSyntheticLambda0(this);
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder(getActivity());
        r13.enableOption();
        final List<ManageApplicationsMenuItem> r14 = getSortMenuList();
        int r12 = 0;
    L4:
        if (r12 >= r14.size()) goto L6;
        ManageApplicationsMenuItem r3 = r14.get(r12);
        r13.addPopoverRightOptionItem(true, Integer.valueOf(r3.getIconRes()), 0, null, r3.getTitle(), null, false, r3.isSelected(), new AnonymousClass20(this, r14, r2));
        r12 = r12 + 1;
        goto L4
    L6:
        OPopover r4 = r1.setView(r13.build()).setGravity(48).build();
        OPopoverHelper.INSTANCE.showPopoverSmartly(r4, r19, 48, false, 0.0f, 0, 0);
        this.mSortDialog = r4;
    }

    /* JADX INFO: renamed from: lambda$showSortDialog$0$com-android-settings-applications-ManageApplicationsFragment, reason: not valid java name */
    /* synthetic */ Unit m302x96ca1a9a(Unit r2) {
        OPopover r3 = this.mSortDialog;
        if (r3 == null) goto L5;
        r3.dismiss();
        this.mSortDialog = null;
    L5:
        return null;
    }

    private void search(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.mSearchResultListView.setEmptyView(null);
        this.mSearchEmptyView.setVisibility(8);
        this.mSearchResultListView.restoreScrollState(false);
        this.mSearchResultListView.setVisibility(8);
        this.mSearchBackground.setClickable(true);
    L6:
        ApplicationsAdapter r0 = this.mApplicationsAdapter;
        if (r0 != null) goto L9;
        return;
    L9:
        this.mSearchResultList = r0.query(r4);
        if (TextUtils.isEmpty(r4) == true) goto L13;
        this.mLastSearch = new SearchAction(this, r4, this.mSearchResultList);
    L13:
        if (this.mSearchAdapter != null) goto L15;
        SearchAdapter r5 = new SearchAdapter(this, this._mActivity);
        this.mSearchAdapter = r5;
        this.mSearchResultListView.setAdapter(r5);
        this.mSearchAdapter.setOnItemClickListener(this);
        this.mSearchAdapter.setOnItemLongClickListener(this);
    L15:
        this.mSearchAdapter.updateAppEntries(this.mSearchResultList);
        updateView();
        return;
    L5:
        this.mSearchResultListView.setEmptyView(this.mSearchEmptyView);
        this.mSearchEmptyView.setVisibility(0);
        this.mSearchResultListView.setVisibility(0);
        this.mSearchBackground.setClickable(false);
        goto L6
    }

    private void cancelSearch() {
        this.mSearchView.setText("");
        this.mSearchView.clearFocus();
    }

    private void hideIME() {
        Utils.hideInputMethod(this._mActivity);
    }

    private void setQuickBarVisibility() {
        if (this.mIndexScrollbar == null) goto L22;
        ApplicationsAdapter r0 = this.mApplicationsAdapter;
        int r1 = 0;
        if (r0 != null) goto L7;
    L15:
        boolean r2 = false;
    L16:
        OIndexScrollbar r3 = this.mIndexScrollbar;
        if (r2 == true) goto L20;
        r1 = 8;
    L20:
        r3.setVisibility(r1);
        return;
    L7:
        if (r0.getCount() <= 0) goto L15;
        r2 = true;
        if (this.mCurrentSortMode != 1) goto L15;
        if (this.mSearchView.isFocused() == true) goto L15;
        if (this.mIsItemScrollRestored == false) goto L15;
    }

    private void initStartSearchAnimation() {
        boolean r0 = this.mFromSecurityCenter;
        if (this.mStartSearchAnim != null) goto L5;
        this.mSearchBarAnimHeight = this.mTitleView.getHeight() + 2;
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, -this.mSearchBarAnimHeight})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mStartSearchAnim = r3;
        r3.setDuration(300);
        this.mStartSearchAnim.setStartDelay(10);
        this.mStartSearchAnim.setInterpolator(new DecelerateInterpolator());
        this.mStartSearchAnim.playTogether(new Animator[]{r1, r2});
        this.mStartSearchAnim.addListener(new AnonymousClass21(this));
    L5:
        this.mStartSearchAnim.start();
    }

    private void startEndSearchAnimation() {
        boolean r0 = this.mFromSecurityCenter;
        if (this.mEndSearchAnim != null) goto L5;
        ObjectAnimator r1 = ObjectAnimator.ofPropertyValuesHolder(this.mWholeView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{-this.mSearchBarAnimHeight, 0.0f})});
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(this.mSearchResultView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f})});
        AnimatorSet r3 = new AnimatorSet();
        this.mEndSearchAnim = r3;
        r3.setDuration(300);
        this.mStartSearchAnim.setInterpolator(new DecelerateInterpolator());
        this.mEndSearchAnim.playTogether(new Animator[]{r1, r2});
        this.mEndSearchAnim.addListener(new AnonymousClass22(this));
    L5:
        this.mEndSearchAnim.start();
    }

    private void updateViews() {
        updateProfileTabsVisibility();
        updateView();
        this.mApplicationsAdapter.resume();
        if (this.mSearchView.isFocused() == false) goto L10;
        SearchAdapter r0 = this.mSearchAdapter;
        if (r0 != null) goto L7;
    L8:
        Utils.showSoftInputMethod(this.mContext, this.mSearchView);
        getWindow().setSoftInputMode(21);
        goto L10
    L7:
        if (r0.getCount() == 0) goto L8;
    L10:
        if (this.mSearchView.isFocused() == true) goto L15;
        OEditText r2 = this.mSearchView;
        if (r2 == null) goto L16;
        TextUtils.isEmpty(r2.getText());
        return;
    L16:
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.coldStartTime = 0;
        this.mSearchView.isFocused();
        this.mApplicationsAdapter.pause();
        this.mLastSearch = null;
        AlertDialog r0 = this.mUninstallDialog;
        if (r0 != null) goto L5;
    L7:
        OAlertDialog r1 = this.mUninstallAlertDialog;
        if (r1 != null) goto L10;
    L12:
        AlertDialog r2 = this.mSystemAppWarningDialog;
        if (r2 != null) goto L15;
    L17:
        restoreListViewScrollState(false);
        PopMenu r3 = this.mPopMenu;
        if (r3 == null) goto L21;
        r3.dismiss();
        return;
    L21:
        return;
    L15:
        if (r2.isShowing() == false) goto L17;
        this.mSystemAppWarningDialog.dismiss();
        goto L17
    L10:
        if (r1.isShowing() == false) goto L12;
        this.mUninstallAlertDialog.dismiss();
        goto L12
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mUninstallDialog.dismiss();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mListView.setOnScrollListener(null);
        this.mListView.setSlideListener(null);
        this.mApplicationsAdapter.destroy();
        this.mApplicationsAdapter = null;
        this.mLauncherAppsService.unregisterCallback(this.mLauncherCallback);
        if (this.isLockedPackagesPage == false) goto L5;
        unregisterReceiver(this.mKeyguardOnReceiver);
    L5:
        this.mHandler.removeCallbacksAndMessages(null);
        this.searchModeSwitchAnimHelperType2.release();
    }

    private boolean isSearchVisible() {
        OButtonGroup r1 = this.mSearchBarCancel;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    private void hideSearchView() {
        OButtonGroup r0 = this.mSearchBarCancel;
        if (r0 == null) goto L7;
        View r1 = r0.getItemViewAt(0);
        if (r1 == null) goto L7;
        r1.performClick();
    L7:
        cancelSearch();
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (isSearchVisible() == false) goto L10;
        if (this.mSearchResultListView.restoreScrollState(true) == false) goto L7;
        return true;
    L7:
        hideSearchView();
        return true;
    L10:
        if (resetQuickBarState() == false) goto L13;
        return true;
    L13:
        if (this.mListView.restoreScrollState(true) == false) goto L16;
        return true;
    L16:
        if (this.mIsEditMode == false) goto L19;
        onEditModeChanged(false);
        return true;
    L19:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r2 == RESULT_OK) goto L5;
        return;
    L5:
        if (r1 != 10) goto L9;
        launchLockedAppsManagement();
        return;
    }

    @Override // com.android.settings.applications.api.OnSettingsItemClickListener
    public void onItemClick(Adapter r1, View r2, int r3) {
        if (this.mIsEditAnimationRunning == false) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
        return;
    L7:
        ApplicationsState.AppEntry r4 = (ApplicationsState.AppEntry) r1.getItem(r3);
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.info.packageName != null) goto L12;
        return;
    L12:
        if (this.mIsEditMode == false) goto L14;
        onAppCheckStateChanged(r4);
        return;
    L14:
        startApplicationDetailsActivity(r4.info.packageName, r4.info.uid);
        hideIME();
    }

    private void onAppCheckStateChanged(ApplicationsState.AppEntry r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.info != null) goto L6;
        return;
    L6:
        if (r3.info.packageName == null) goto L11;
        onAppCheckStateChanged(r3, !this.mTodoUninstallMap.get(Integer.valueOf(UserHandle.getUserId(r3.info.uid))).contains(r3.info.packageName));
        return;
    }

    private void onAppCheckStateChanged(ApplicationsState.AppEntry r3, boolean r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.info != null) goto L6;
        return;
    L6:
        if (r3.info.packageName != null) goto L8;
        return;
    L8:
        if (this.mIsEditMode == false) goto L18;
        Set<String> r0 = this.mTodoUninstallMap.get(Integer.valueOf(UserHandle.getUserId(r3.info.uid)));
        if (r4 == false) goto L12;
        r0.add(r3.info.packageName);
    L13:
        updateView();
        return;
    L12:
        r0.remove(r3.info.packageName);
        goto L13
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (this.mIsEditAnimationRunning == false) goto L6;
        return;
    L6:
        if (r4 != this.mBackView) goto L12;
        if (this.mIsEditMode == false) goto L10;
        onEditModeChanged(false);
        return;
    L10:
        finish();
        return;
    L12:
        if (r4 != this.mSelectAllCheckBox) goto L29;
        resetQuickBarState();
        if (this.mSelectAllCheckBox.isChecked() == false) goto L19;
        Iterator<ApplicationsState.AppEntry> r5 = this.mApplicationsAdapter.getAppEntries().iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        ApplicationsState.AppEntry r0 = r5.next();
        this.mTodoUninstallMap.get(Integer.valueOf(UserHandle.getUserId(r0.info.uid))).add(r0.info.packageName);
    L23:
        updateView();
        return;
    L19:
        Iterator<Set<String>> r6 = this.mTodoUninstallMap.values().iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        r6.next().clear();
        goto L21
    }

    public void showDelDialog() {
        final OMenuDialog r0 = new OMenuDialog(this._mActivity);
        Iterator<Set<String>> r1 = this.mTodoUninstallMap.values().iterator();
        final int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L6;
        r3 = r3 + r1.next().size();
        goto L4
    L6:
        r0.setTitle(getResources().getQuantityString(R.plurals.uninstall_app_dialog_title, r3, new Object[]{Integer.valueOf(r3)}));
        r0.setPositiveButton(R.string.confirm_uninstall, new AnonymousClass24(this, r3));
        r0.setNegativeButton(new AnonymousClass25(this, r0));
        r0.setOnCancelListener(new AnonymousClass26(this));
        r0.show();
    }

    private void updateView() {
        updateTitleBar();
        updateSelectBar();
        this.mSearchView.setEnabled(!this.mIsEditMode);
        SlideListView r0 = this.mListView;
        if (r0 == null) goto L6;
        r0.setHorizontalScrollEnabled(false);
    L6:
        if (this.mSearchView.isFocused() == false) goto L8;
        AppListAdapter r3 = this.mSearchAdapter;
    L9:
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.getAppEntries() == null) goto L17;
        Iterator<ApplicationsState.AppEntry> r1 = r3.getAppEntries().iterator();
    L14:
        if (r1.hasNext() == false) goto L16;
        r1.next().icon = null;
        goto L14
    L16:
        OLog.d("ManageApplications", "updateView-更新icon");
    L17:
        r3.notifyDataSetChanged();
        return;
    L8:
        r3 = this.mApplicationsAdapter;
        goto L9
    }

    private void onEditModeChanged(boolean r1) {
        performAnimationForEdit();
        resetQuickBarState();
        updateView();
    }

    private void updateSelectBar() {
        boolean r1 = false;
        if (this.mIsEditMode == false) goto L16;
        Iterator<Set<String>> r0 = this.mTodoUninstallMap.values().iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L8;
        r2 = r2 + r0.next().size();
        goto L6
    L8:
        int r3 = this.mAppsCanEditSize;
        this.mOptionTextView.setText(getResources().getString(R.string.selected_item_count, new Object[]{Integer.valueOf(r2), Integer.valueOf(r3)}));
        RelativeLayout r4 = this.mEditBarView;
        if (r3 != 0) goto L11;
        int r5 = 8;
    L12:
        r4.setVisibility(r5);
        OCheckBox r7 = this.mSelectAllCheckBox;
        if (r2 != r3) goto L15;
        r1 = true;
    L15:
        r7.setChecked(r1);
        return;
    L11:
        r5 = 0;
        goto L12
    L16:
        this.mOptionTextView.setText(null);
        this.mSelectAllCheckBox.setChecked(false);
    }

    private boolean canUninstall(ApplicationsState.AppEntry r2) {
        if (this.mDpm.packageHasActiveAdmins(r2.info.packageName) == false) goto L7;
        return false;
    L7:
        return Utils.canUninstall(r2.info);
    }

    private void performAnimationForEdit() {
        ArrayList<Animator> r0 = getEditAnimators(this.mIsEditMode);
        AnimatorSet r1 = new AnimatorSet();
        r1.addListener(new AnonymousClass27(this));
        r1.playTogether(r0);
        r1.start();
        this.mIsEditAnimationRunning = true;
    }

    private ArrayList<Animator> getEditAnimators(boolean r12) {
        ArrayList<Animator> r0 = new ArrayList();
        int r1 = this.mSearchBarContainer.getWidth();
        if (r12 == false) goto L5;
        ObjectAnimator r13 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{0.0f, r1});
        r13.setDuration(300);
        r0.add(r13);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "alpha", new float[]{1.0f, 0.0f});
        r14.setDuration(300);
        r0.add(r14);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.mEditBarView, "alpha", new float[]{0.0f, 1.0f});
        r11.setDuration(300);
        r0.add(r11);
    L6:
        return r0;
    L5:
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "translationX", new float[]{r1, 0.0f});
        r15.setDuration(300);
        r0.add(r15);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.mSearchBarContainer, "alpha", new float[]{0.0f, 1.0f});
        r16.setDuration(300);
        r0.add(r16);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(this.mEditBarView, "alpha", new float[]{1.0f, 0.0f});
        r17.setDuration(300);
        r0.add(r17);
        goto L6
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public void setChecked(int r2, boolean r3) {
        onAppCheckStateChanged(this.mApplicationsAdapter.getItem(r2), r3);
    }

    @Override // com.android.settings.widget.SlideListView.Listener
    public boolean isChecked(int r2) {
        ApplicationsState.AppEntry r3 = this.mApplicationsAdapter.getItem(r2);
        if (r3.info != null) goto L5;
        return false;
    L5:
        if (r3.info.packageName != null) goto L7;
        return false;
    L7:
        return this.mTodoUninstallMap.get(Integer.valueOf(UserHandle.getUserId(r3.info.uid))).contains(r3.info.packageName);
    }

    private boolean isOriginalLauncherActive() {
        return Utils.isOriginalLauncher(this.mContext);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        ApplicationsAdapter r2 = this.mApplicationsAdapter;
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getAppEntries() == null) goto L10;
        Iterator<ApplicationsState.AppEntry> r4 = r2.getAppEntries().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r4.next().icon = null;
    L10:
        r2.notifyDataSetChanged();
    }

    private boolean handleAppSkipped(String r3) {
        if ("com.bytedanceos.screenrecorder".equals(r3) == false) goto L8;
        if (Utils.isScreenRecording(this.mContext) == false) goto L12;
        ToastUtils.show(getActivity(), R.string.toast_quit_screen_record_mode);
        return true;
    L12:
        return false;
    L8:
        if ("com.obric.recorder".equals(r3) == false) goto L12;
        if (Utils.isRecorderRecording(this.mContext) == false) goto L12;
        ToastUtils.show(getActivity(), R.string.toast_please_exit_record);
        return true;
    }

    private void unintall(ApplicationsState.AppEntry r6) {
        boolean r0 = Utils.canUninstall(r6.info);
        if ((r6.info.flags & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        handleObricApp(r6, true);
        return;
    L9:
        if (r0 == false) goto L15;
        if (this.mDpm.packageHasActiveAdmins(r6.info.packageName) == false) goto L15;
        ToastUtils.show(this._mActivity, R.string.cannot_uninstall_admin_app);
        restoreListViewScrollState(true);
        return;
    L15:
        if ((r6.info.flags & 128) != 0) goto L17;
    L23:
        if (r0 == true) goto L26;
        ToastUtils.show(this._mActivity, R.string.cannot_uninstall_system_app);
        restoreListViewScrollState(true);
        return;
    L26:
        if (handleAppSkipped(r6.info.packageName) == false) goto L29;
        return;
    L29:
        if (ApplicationInfoEx.isObricApp(r6.info) == false) goto L33;
        handleObricApp(r6, false);
        return;
    L33:
        if (whiteAppList.contains(r6.info.packageName) == false) goto L35;
        showSystemAppUninstallWarning(r6);
        return;
    L35:
        startUninstallPackageDialog(r6);
        return;
    L17:
        if (this.mIsSystemAppManager == false) goto L23;
        if (whiteAppList.contains(r6.info.packageName) == false) goto L21;
        showSystemAppUninstallWarning(r6);
        return;
    L21:
        startUninstallPackageDialog(r6);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void handleObricApp(final ApplicationsState.AppEntry r5, boolean r6) {
        if (r6 == false) goto L5;
        String r7 = getString(R.string.uninstall_system_app_title, new Object[]{r5.info.loadLabel(this.mPm)});
        String r0 = getString(R.string.uninstal_update);
    L6:
        OAlertDialog r2 = this.mUninstallAlertDialog;
        if (r2 != null) goto L9;
    L11:
        OAlertDialog r8 = new OAlertDialogBuilder(getContext()).autoDismiss(false).horizontalButton().title(r7, false).message(SystemAppRecorder.INSTANCE.getUninstallDescription(r5.info.packageName, this.mContext)).icon(r5.info.loadIcon(this.mPm)).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f)).positiveButton(r0, new ManageApplicationsFragment$$ExternalSyntheticLambda1(this, r5)).negativeButton(getString(R.string.cancel), new ManageApplicationsFragment$$ExternalSyntheticLambda2()).build();
        this.mUninstallAlertDialog = r8;
        r8.show();
        return;
    L9:
        if (r2.isShowing() == false) goto L11;
        this.mUninstallAlertDialog.dismiss();
        goto L11
    L5:
        r7 = getString(R.string.uninstall_app_title, new Object[]{r5.info.loadLabel(this.mPm)});
        r0 = getString(R.string.uninstal);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$handleObricApp$1$com-android-settings-applications-ManageApplicationsFragment, reason: not valid java name */
    /* synthetic */ void m300x714be4ac(ApplicationsState.AppEntry r1, DialogInterface r2, int r3) {
        showUninstallingProgressDialog(r1.info.packageName);
        uninstallPkgDirectly(r1);
        r2.dismiss();
    }

    static /* synthetic */ void lambda$handleObricApp$2(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    private boolean checkAppCanBeUninstall(ApplicationsState.AppEntry r3) {
        if (r3.info != null) goto L6;
        return false;
    L6:
        if (this.mDpm.packageHasActiveAdmins(r3.info.packageName) == false) goto L9;
        return false;
    L9:
        if ((r3.info.flags & 128) == 0) goto L13;
        return true;
    L13:
        return Utils.canUninstall(r3.info);
    }

    private void showSystemAppUninstallWarning(final ApplicationsState.AppEntry r7) {
        AlertDialog r0 = this.mSystemAppWarningDialog;
        if (r0 != null) goto L5;
    L7:
        String r1 = getResources().getString(R.string.uninstall_dlg_msg_info);
        if (whiteComponentList.contains(r7.info.packageName) == false) goto L10;
        String r2 = String.format(r1, new Object[]{r7.label, getResources().getString(R.string.system_internal_component)});
    L11:
        AlertDialog.Builder r3 = new AlertDialog.Builder(this._mActivity);
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_uninstall_layout, null);
        r3.setTitle(R.string.uninstall_warning);
        r3.setView(r4);
        TextView r5 = (TextView) r4.findViewById(R.id.id_dlg_msg_tv);
        if (r5 == null) goto L14;
        r5.setText(r2);
    L15:
        r3.setOnCancelListener(new AnonymousClass28(this));
        r3.setNegativeButton(R.string.review_button_cancel, new AnonymousClass29(this));
        r3.setPositiveButton(R.string.review_button_continue, new AnonymousClass30(this, r7));
        this.mSystemAppWarningDialog = r3.show();
        return;
    L14:
        OLog.e("ManageApplications", "showSystemAppUninstallWarning: dialogMsgView is null");
        r3.setMessage(r2);
        goto L15
    L10:
        r2 = String.format(r1, new Object[]{r7.label, getResources().getString(R.string.system_internal_app)});
        goto L11
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mSystemAppWarningDialog.dismiss();
        goto L7
    }

    private void showDialogInner(int r3, int r4) {
        if (getActivity() != null) goto L5;
    L12:
        OLog.d("ManageApplications", "Illegal state : The parent activity has been destroyed!");
        return;
    L5:
        if (getActivity().isResumed() == false) goto L12;
        if (r3 != 8) goto L10;
        return;
    L10:
        InstalledAppDetails.MyAlertDialogFragment.newInstance(r3, r4).show(getChildFragmentManager(), "dialog " + r3);
    }

    private void uninstallPkgByUid(String r2, boolean r3, boolean r4, int r5) {
        Intent r6 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r2));
        r6.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", r3);
        r6.putExtra("android.intent.extra.USER", UserHandle.getUserId(r5));
        r6.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);
        r6.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivityForResult(r6, 1);
    }

    private void uninstallDoppelgangerPkg(String r2, boolean r3) {
        Intent r4 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r2));
        r4.putExtra("android.intent.extra.USER", new UserHandle(10));
        r4.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);
        r4.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);
        startActivityForResult(r4, 1);
    }

    private void uninstallPkg(String r2, boolean r3, boolean r4) {
        Intent r5 = new Intent("android.intent.action.UNINSTALL_PACKAGE", Uri.parse("package:" + r2));     // Catch: ActivityNotFoundException -> L5
        r5.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", r3);     // Catch: ActivityNotFoundException -> L5
        r5.putExtra("isFromSecurityCenter", this.mFromSecurityCenter);     // Catch: ActivityNotFoundException -> L5
        r5.addFlags(VCardConfig.FLAG_APPEND_TYPE_PARAM);     // Catch: ActivityNotFoundException -> L5
        startActivityForResult(r5, 1);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void startUninstallPackageDialog(ApplicationsState.AppEntry r8) {
        String r0 = r8.info.packageName;
        if ((r8.info.flags & 128) == 0) goto L5;
        boolean r1 = true;
    L7:
        if (Utils.isFastDoubleClick() == false) goto L10;
        return;
    L10:
        if (handleAppSkipped(r0) == false) goto L13;
        return;
    L13:
        if (this.mDpm.packageHasActiveAdmins(r0) == false) goto L18;
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L43;
        Intent r9 = new Intent(r7, DeviceAdminAdd.class);
        r9.putExtra(DeviceAdminAdd.EXTRA_DEVICE_ADMIN_PACKAGE_NAME, r0);
        r7.startActivityForResult(r9, 1);
        return;
    L43:
        return;
    L18:
        RestrictedLockUtils.EnforcedAdmin r4 = MultiSDKAdapterNew.checkIfUninstallBlocked(getActivity(), r0, UserHandle.myUserId());
        boolean r5 = MultiSDKAdapterNew.hasBaseUserRestriction(getActivity(), r0, UserHandle.myUserId());
        if (r4 == null) goto L22;
        if (r5 == true) goto L22;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), r4);
    L41:
        restoreListViewScrollState(true);
        return;
    L22:
        if (r1 == false) goto L25;
        showDialogInner(2, 0);
        goto L41
    L25:
        if ((r8.info.flags & 1) == 0) goto L35;
        if (Utils.canUninstall(r8.info) == false) goto L31;
        uninstallPkgByUid(r0, false, false, r8.info.uid);
        return;
    L31:
        if (r8.info.enabled == false) goto L33;
        showDialogInner(7, 0);
        goto L41
    L33:
        new InstalledAppDetails.DisableChanger(this.mPm, r8.info, 0).execute(new Object[]{null});
        goto L41
    L35:
        if ((r8.info.flags & 8388608) != 0) goto L38;
        uninstallPkgByUid(r0, false, false, r8.info.uid);
        goto L41
    L38:
        if (UserHandle.getUserId(r8.info.uid) != 10) goto L40;
        uninstallDoppelgangerPkg(r0, false);
        goto L41
    L40:
        uninstallPkg(r0, false, false);
        goto L41
    L5:
        r1 = false;
        goto L7
    }

    private AlertDialog createSystemAppUninstallDialog(final ApplicationsState.AppEntry r6, final String r7) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this._mActivity);
        View r1 = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_uninstall_layout, null);
        TextView r2 = (TextView) r1.findViewById(R.id.id_dlg_msg_tv);
        StringBuilder r3 = new StringBuilder();
        buildUninstallMessage(r3, r6.label, r7);
        String r4 = r3.toString();
        r0.setTitle(R.string.uninstall_warning_again);
        r0.setView(r1);
        if (r2 == null) goto L5;
        r2.setBreakStrategy(0);
        r2.setText(r4);
    L6:
        r0.setPositiveButton(R.string.review_button_confirm, new AnonymousClass31(this, r7, r6));
        r0.setNegativeButton(R.string.review_button_cancel, new AnonymousClass32(this));
        r0.setOnDismissListener(new AnonymousClass33(this));
        r0.setOnCancelListener(new AnonymousClass34(this));
        return r0.create();
    L5:
        OLog.e("ManageApplications", "startUninstallPackageDialog: dialogMsgView is null");
        r0.setMessage(r4);
        goto L6
    }

    private AlertDialog createThirdAppUninstallDialog(final ApplicationsState.AppEntry r7, boolean r8, PackageManager r9) {
        String r0 = getString(R.string.uninstal_user_app_text);
        if (r8 == false) goto L6;
        r0 = getString(R.string.uninstall_updated_sys_app_message);
        int r10 = R.string.app_factory_reset;
    L17:
        AlertDialog.Builder r11 = new AlertDialog.Builder(this._mActivity, getResources().getInteger(R.integer.dialog_style_id));
        r11.setTitle(r7.label).setMessage(r0).setPositiveButton(r10, new AnonymousClass38(this, r7)).setOnDismissListener(new AnonymousClass37(this)).setOnCancelListener(new AnonymousClass36(this)).setNegativeButton(R.string.cancel, new AnonymousClass35(this));
        return r11.create();
    L6:
        if (UserHandle.getUserId(r7.info.uid) != 10) goto L9;
        r0 = getString(R.string.uninstall_doppelganger_app_dlg_message, new Object[]{r7.label, r7.label});
    L16:
        r10 = R.string.uninstall_text;
        goto L17
    L9:
        if (UserHandle.getUserId(r7.info.uid) != 0) goto L16;
        PackageInfo r12 = r9.getPackageInfoAsUser(r7.info.packageName, 0, 10);     // Catch: PackageManager.NameNotFoundException -> L12
    L14:
        if (r12 == null) goto L16;
        r0 = getString(R.string.uninstall_app_has_doppelganger_dlg_message, new Object[]{r7.label, r7.label});
    L12:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L14
    }

    private void buildUninstallMessage(StringBuilder r7, String r8, String r9) {
        if (whiteAppsHasPrefixMsg.contains(r9) == false) goto L6;
        OLog.d("ManageApplications", "buildUninstallMessage: it's message should contains pkgName:" + r9);
        r7.append(String.format(getResources().getString(R.string.app_uninstall_dlg_msg_with_prefix), new Object[]{r8}));
        return;
    L6:
        if ("com.obric.notes".equals(r9) == false) goto L9;
        r7.append(getResources().getString(R.string.app_note_uninstall_dlg_msg_suffix)).append(getResources().getString(R.string.app_uninstall_confirm_dlg_msg_prefix));
        return;
    L9:
        if (EMAIL_PKG_NAME.equals(r9) == false) goto L12;
        r7.append(getResources().getString(R.string.app_email_uninstall_dlg_msg_suffix)).append(getResources().getString(R.string.app_uninstall_confirm_dlg_msg_prefix));
        return;
    L12:
        if (MUSICFX_PKG_NAME.equals(r9) == false) goto L15;
        r7.append(getResources().getString(R.string.app_musicfx_uninstall_dlg_msg_suffix)).append(getResources().getString(R.string.app_uninstall_confirm_dlg_msg_prefix));
        return;
    L15:
        if (YOUDAO_BYTEDANCE_PKG_NAME.equals(r9) == false) goto L18;
        r7.append(getResources().getString(R.string.app_yd_dict_uninstall_dlg_msg_suffix)).append(getResources().getString(R.string.func_uninstall_dlg_msg_prefix));
        return;
    L18:
        if ("com.bytedanceos.screenrecorder".equals(r9) == false) goto L21;
        String r10 = getResources().getString(R.string.app_screen_recorder_uninstall_dlg_msg_suffix);
        String r6 = getResources().getString(R.string.app_uninstall_dlg_msg_with_prefix);
        r7.append(r10);
        r7.append(String.format(r6, new Object[]{r8}));
        return;
    L21:
        if ("com.bytedanceos.handinhand".equals(r9) == false) goto L24;
        r7.append(String.format(getResources().getString(R.string.app_uninstall_app_dlg_msg_with_prefix), new Object[]{r8}));
        return;
    L24:
        if (MUSIC_SHARE_PKG_NAME.equals(r9) == false) goto L27;
        r7.append(getResources().getString(R.string.app_music_share_uninstall_dlg_msg_suffix));
        return;
    L27:
        if (whiteComponentList.contains(r9) == false) goto L29;
        OLog.d("ManageApplications", "buildUninstallMessage: build message for component:" + r9);
        buildComponentMessage(r7, r9);
        return;
    L29:
        OLog.e("ManageApplications", "buildUninstallMessage: error: the package {" + r9 + "} is not match to white list!");
    }

    private void buildComponentMessage(StringBuilder r3, String r4) {
        String r0 = getResources().getString(R.string.func_uninstall_dlg_msg_prefix);
        if ("com.bytedanceos.recharge".equals(r4) == false) goto L6;
        r3.append(getResources().getString(R.string.func_recharge_uninstall_dlg_msg_suffix)).append(r0);
        return;
    L6:
        if (CLOUD_GALLERY_PKG_NAME.equals(r4) == false) goto L9;
        r3.append(getResources().getString(R.string.func_cloudgallery_uninstall_dlg_msg_suffix)).append(r0);
        return;
    L9:
        if ("com.bytedanceos.textboom".equals(r4) == false) goto L14;
        r3.append(getResources().getString(R.string.func_textboom_uninstall_dlg_msg_suffix)).append(r0);
        return;
    }

    private void showUninstallingProgressDialog(String r2) {
        BytedanceProgressDialog r0 = this.mUninstallingDialog;
        if (r0 != null) goto L6;
        this.mUninstallingPkg = r2;
        BytedanceProgressDialog r3 = new BytedanceProgressDialog(this._mActivity);
        this.mUninstallingDialog = r3;
        r3.setCanceledOnTouchOutside(false);
        this.mUninstallingDialog.setCancelable(false);
        this.mUninstallingDialog.setOnDismissListener(new AnonymousClass39(this));
    L8:
        this.mUninstallingDialog.show();
        return;
    L6:
        if (r0.isShowing() == false) goto L8;
    }

    private void uninstallPkgDirectly(ApplicationsState.AppEntry r4) {
        if ((r4.info.flags & 1) != 0) goto L5;
    L7:
        this.mPm.deletePackageAsUser(r4.info.packageName, this.mPkgDeleteObserver, 0, UserHandle.myUserId());
        return;
    L5:
        if ((r4.info.flags & 128) != 0) goto L7;
        this.mPm.deletePackage(r4.info.packageName, this.mPkgDeleteObserver, 4);
    }

    private void uninstallPackage(ApplicationManager r4, ApplicationsState.AppEntry r5, PackageManager r6) {
        if (UserHandle.getUserId(r5.info.uid) != 10) goto L10;
        if (r6 == null) goto L16;
        MultiSDKAdapter.deletePackageAsUser(r6, r5.info.packageName, null, 0, 10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        return;
    L10:
        if (Utils.isSystemPackage(r5.info) == false) goto L12;
        this.mPm.deletePackage(r5.info.packageName, null, 4);
        return;
    L12:
        r4.unInstallPackage(r5.info.packageName);
    }

    private boolean restoreListViewScrollState(boolean r2) {
        if (this.mSearchView.isFocused() == false) goto L7;
        return this.mSearchResultListView.restoreScrollState(r2);
    L7:
        return this.mListView.restoreScrollState(r2);
    }

    public void handleUninstallMessage(Message r8) {
        BytedanceProgressDialog r1 = this.mUninstallingDialog;
        if (r1 == null) goto L5;
        r1.dismiss();
    L5:
        final Pair r2 = (Pair) r8.obj;
        String r3 = (String) r2.first;
        this.mHandler.postDelayed(new AnonymousClass41(this, r2), 50);
        int r9 = r8.arg1;
        if (r9 != (-2)) goto L8;
        OLog.i("ManageApplications", "Uninstall package DELETE_FAILED_DEVICE_POLICY_MANAGER [" + r3 + "]");
        return;
    L8:
        if (r9 != (-1)) goto L19;
        getPackageManager().getInstallerPackageName(r3);     // Catch: Exception -> L12
        OLog.i("ManageApplications", "Uninstall package DELETE_FAILED_INTERNAL_ERROR [" + r3 + "]");
        return;
    L12:
        OLog.d(ApplicationManager.TAG, "Uninstall package DELETE_FAILED_INTERNAL_ERROR [" + r3 + "] failed, app is not exist, so just remove app info from launcher.");
        return;
    }

    private void startApplicationDetailsActivity(String r3, int r4) {
        Bundle r0 = new Bundle();
        r0.putString("package", r3);
        r0.putInt(InstalledAppDetails.ARG_APP_UID, r4);
        r0.putInt("back_text_id", this.mTitleStringResId);
        r0.putBoolean(EXTRA_SYSTEM_APP_MANAGER, this.mIsSystemAppManager);
        InstalledAppDetails r5 = new InstalledAppDetails();
        r5.setArguments(r0);
        start(r5);
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollStart(int r1) {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollStartToComplete() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrolling() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollCompleted() {
        this.mIsItemScrollRestored = false;
        setQuickBarVisibility();
    }

    @Override // com.android.settings.widget.HorizontalScrollListView.ScrollStateListener
    public void onScrollRestored() {
        this.mIsItemScrollRestored = true;
        setQuickBarVisibility();
    }

    private void showPopupMenuWhenLongPressed(View r6, final ApplicationsState.AppEntry r7) {
        final Function r0 = new ManageApplicationsFragment$$ExternalSyntheticLambda3(this);
        r0.apply(null);
        if ((r7.info.flags & 128) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        String r2 = getString(R.string.uninstal_update);
    L9:
        this.mPopMenu.show(r6, Collections.singletonList(new PopMenuItem(0, R.drawable.ic_swipe_delete, r2)), new AnonymousClass42(this, r7, r0));
        return;
    L8:
        r2 = getString(R.string.uninstal);
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$showPopupMenuWhenLongPressed$3$com-android-settings-applications-ManageApplicationsFragment, reason: not valid java name */
    /* synthetic */ Unit m301x5c278d5c(Unit r1) {
        PopMenu r0 = this.mPopMenu;
        if (r0 == null) goto L7;
        r0.dismiss();
        return null;
    L7:
        return null;
    }

    private void showCalculateDialog() {
        if (this.mCalculateSizeDialog != null) goto L5;
        BytedanceProgressDialog r0 = new BytedanceProgressDialog(this._mActivity);
        this.mCalculateSizeDialog = r0;
        r0.setCanceledOnTouchOutside(false);
        this.mCalculateSizeDialog.setCancelable(false);
    L5:
        this.mCalculateSizeDialog.show();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManageApplicationsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageApplicationsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManageApplicationsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_ManageApplicationsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManageApplicationsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_ManageApplicationsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
