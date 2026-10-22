package com.android.settings;

import android.app.INotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.TextView;
import bytedanceos.api.SmtOpsManagerSmt;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.ThreadUtils;
import com.obric.olog.OLog;
import com.obric.oui.SearchAnimationHelper;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationSearchFragment extends BaseFragment implements View.OnClickListener {
    private boolean finished;
    private final Comparator<NotificationSettingsFragment.NotificationEntry> mAlphaComparator;
    private ApplicationsState mApplicationsState;
    private View mBlankView;
    private View mCancelBtn;
    private View mClearTextView;
    private TextView mEmptyView;
    private boolean mEnableAll;
    private ArrayList<NotificationSettingsFragment.NotificationEntry> mEntries;
    private boolean mFeatureLEDEnable;
    private String mKeyWord;
    private INotificationManager mNotificationManager;
    private NotificationAppsAdapter mSearchAdapter;
    private OSearchBar mSearchBar;
    private int mSearchBarPaddingLeft;
    private ArrayList<NotificationSettingsFragment.NotificationEntry> mSearchList;
    private ListView mSearchResultListView;
    private SmtOpsManagerSmt mSmtOps;
    private View mTipsView;

    private class NotificationAppsAdapter extends SettingsAdapter implements ApplicationsState.Callbacks {
        private int mIconSize;
        private LayoutInflater mLayoutInflater;
        private PackageManager mPackageManager;
        private boolean mResumed;
        private ApplicationsState.Session mSession;
        final /* synthetic */ NotificationSearchFragment this$0;

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ApplicationsState.Session access$1100(NotificationAppsAdapter r0) {
            return r0.mSession;
        }

        static /* synthetic */ ArrayList access$900(NotificationAppsAdapter r0, ArrayList r1) {
            return r0.filter(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public NotificationAppsAdapter(NotificationSearchFragment r2, Context r3, ApplicationsState r4) {
            this.this$0 = r2;
            this.mResumed = false;
            this.mLayoutInflater = LayoutInflater.from(r3);
            this.mSession = r4.newSession(this);
            this.mPackageManager = r2.getPackageManager();
            this.mIconSize = r3.getResources().getDimensionPixelSize(R.dimen.settings_list_item_icon_size);
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

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            if (NotificationSearchFragment.access$100(this.this$0) != null) goto L7;
            return 0;
        L7:
            return NotificationSearchFragment.access$100(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public NotificationSettingsFragment.NotificationEntry getItem(int r1) {
            return (NotificationSettingsFragment.NotificationEntry) NotificationSearchFragment.access$100(this.this$0).get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return ((NotificationSettingsFragment.NotificationEntry) NotificationSearchFragment.access$100(this.this$0).get(r1)).appEntry.id;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(final int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
        L7:
            OCardListItem r8 = new OCardListItem(this.this$0.mContext);
        L8:
            NotificationSettingsFragment.NotificationEntry r9 = getItem(r5);
            if (r9.appEntry.icon != null) goto L11;
            r9.appEntry.ensureIconLocked(this.this$0.mContext, this.mPackageManager);
        L11:
            r8.setTitle(r9.appEntry.label);
            int r0 = 1;
            r8.showTitle(true);
            r8.setIcon(r9.appEntry.icon);
            r8.showIcon(true);
            String r1 = getSubTitle(r9);
            if (TextUtils.isEmpty(r1) == true) goto L14;
            r8.setSubTitle(r1);
            r8.showSubTitle(true);
        L16:
            if (r9.noficationEnabled == false) goto L18;
            String r10 = this.this$0.getResources().getString(R.string.settings_state_on);
        L19:
            OCardListItemUtils.setCustomEndTipTextView(r8, r10);
            r8.setDefaultTailIcon(0);
            r8.showTailIcon(true);
            r8.setOnContentClickListener(new AnonymousClass1(this, r5));
            OCardListItemUtils.setContentContainerEnabled(r8, NotificationSearchFragment.access$800(this.this$0));
            if (r5 != 0) goto L26;
            if (getCount() != 1) goto L24;
            r0 = 0;
        L24:
            r8.setCardPosition(r0);
            r8.setPadding(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, 0);
        L29:
            return r8;
        L26:
            if (r5 != (getCount() - 1)) goto L28;
            r8.setCardPosition(3);
            r8.setPadding(0, 0, 0, 0);
            goto L29
        L28:
            r8.setCardPosition(2);
            r8.setPadding(0, 0, 0, 0);
            goto L29
        L18:
            r10 = this.this$0.getResources().getString(R.string.settings_state_off);
            goto L19
        L14:
            r8.showSubTitle(false);
            goto L16
        L4:
            if ((r6 instanceof OCardListItem) == false) goto L7;
            r8 = (OCardListItem) r6;
            goto L8
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.NotificationSearchFragment$NotificationAppsAdapter$2] */
        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(final ArrayList<ApplicationsState.AppEntry> r2) {
            new AnonymousClass2(this, r2).execute(new Void[0]);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
        }

        private String getSubTitle(NotificationSettingsFragment.NotificationEntry r12) {
            StringBuilder r0 = new StringBuilder("");
            String r2 = this.this$0.getString(R.string.notification_summary_devide);
            boolean r3 = r12.noficationEnabled;
            boolean r4 = r12.lightenScreenEnabled;
            boolean r5 = r12.topLocateEnabled;
            boolean r6 = r12.isPopupDialogEnabled;
            boolean r7 = r12.ledEnabled;
            if (r3 == true) goto L5;
            return "";
        L5:
            String r8 = r12.appEntry.info.packageName;
            if (Constants.PKG_MMS.equals(r8) == true) goto L11;
            if ("com.android.contacts".equals(r8) == true) goto L11;
            return "";
        L11:
            if (Constants.PKG_MMS.equals(r12.appEntry.info.packageName) == false) goto L19;
            int r13 = android.provider.Settings.System.getInt(this.this$0.getContentResolver(), "pref_key_quickmessage", 1);
            if (r13 != 1) goto L16;
            r0.append(this.this$0.getString(R.string.popup_mms_always));
            r0.append(r2);
        L27:
            if (r7 == true) goto L29;
        L31:
            if (r5 == false) goto L33;
            r0.append(this.this$0.getString(R.string.notification_top_summary));
            r0.append(r2);
        L33:
            if (r6 == false) goto L36;
            r0.append(this.this$0.getString(R.string.pop_up_dialog_notification_text));
            r0.append(r2);
        L36:
            if (r0.toString().endsWith(r2) == false) goto L39;
            return r0.substring(0, r0.length() - r2.length());
        L39:
            return r0.toString();
        L29:
            if (NotificationSearchFragment.access$1000(this.this$0) == false) goto L31;
            r0.append(this.this$0.getString(R.string.notification_led_summary));
            r0.append(r2);
            goto L31
        L16:
            if (r13 != 2) goto L27;
            r0.append(this.this$0.getString(R.string.popup_mms_lockscreen));
            r0.append(r2);
            goto L27
        L19:
            if ("com.android.contacts".equals(r12.appEntry.info.packageName) == true) goto L27;
            if (SettingsFeature.NEW_NOFITICATION_FEATURE == true) goto L23;
        L25:
            if (r4 == false) goto L27;
            r0.append(this.this$0.getString(R.string.notification_lighten_summary));
            r0.append(r2);
            goto L27
        L23:
            if (r12.lockscreenNotificationEnabled == false) goto L25;
            r0.append(this.this$0.getString(R.string.lockscreen_notification_title));
            r0.append(r2);
            goto L25
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.NotificationSearchFragment$NotificationAppsAdapter$3] */
        public void rebuild() {
            new AnonymousClass3(this).execute(new Void[0]);
        }

        private ArrayList<NotificationSettingsFragment.NotificationEntry> filter(ArrayList<ApplicationsState.AppEntry> r10) {
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            ArrayList<NotificationSettingsFragment.NotificationEntry> r3 = new ArrayList();
            Iterator<ApplicationsState.AppEntry> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L25;
            ApplicationsState.AppEntry r4 = r11.next();
            if (NotificationHelper.isRootOrSystemUid(r4.info.uid) == true) goto L4;
            if (Utils.isNotificationWhiteApp(this.this$0.mContext, NotificationSearchFragment.access$1200(this.this$0), r4.info) == true) goto L4;
            if (Utils.isPackageLocked(this.mPackageManager, r4.info.packageName, r4.info.uid) == true) goto L4;
            if (r4.info.packageName.equals(r4.label) == true) goto L4;
            boolean r5 = isNotificationEnabled(r4.info.packageName, r4.info.uid);
            NotificationSettingsFragment.NotificationEntry r6 = new NotificationSettingsFragment.NotificationEntry();
            r6.appEntry = r4;
            r6.noficationEnabled = r5;
            r6.lightenScreenEnabled = isLightenScreenEnabled(r4.info.packageName, r4.info.uid);
            r6.topLocateEnabled = isTopLocateEnabled(r4.info.packageName, r4.info.uid);
            boolean r7 = false;
            if (Arrays.asList(this.this$0.mContext.getResources().getStringArray(R.array.pop_up_dialog_package_list)).contains(r4.info.packageName) == true) goto L18;
            r6.isPopupDialogEnabled = false;
        L24:
            r6.ledEnabled = isLedEnable(r4.info);
            r6.lockscreenNotificationEnabled = isLockscreenNotificationOn(r4.info);
            r0.add(r6);
            goto L4
        L18:
            if (isPopupDialogEnable(r4.info.packageName, r4.info.uid) == true) goto L20;
        L22:
            r6.isPopupDialogEnabled = r7;
            goto L24
        L20:
            if (SettingsFeature.NEW_NOFITICATION_FEATURE == true) goto L22;
            r7 = true;
            goto L22
        L25:
            Collections.sort(r0, NotificationSearchFragment.access$1300(this.this$0));
            Collections.sort(r1, NotificationSearchFragment.access$1300(this.this$0));
            Collections.sort(r2, NotificationSearchFragment.access$1300(this.this$0));
            r3.addAll(r0);
            r3.addAll(r1);
            r3.addAll(r2);
            r0.clear();
            r1.clear();
            r2.clear();
            return r3;
        }

        private boolean isNotificationEnabled(String r1, int r2) {
            return NotificationSearchFragment.access$1400(this.this$0).areNotificationsEnabledForPackage(r1, r2);
        L4:
            return false;
        }

        private boolean isLightenScreenEnabled(String r3, int r4) {
            if (NotificationSearchFragment.access$1500(this.this$0).checkOpNoThrow(this.this$0.mContext, 25, r4, r3) != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isLockscreenNotificationOn(ApplicationInfo r3) {
            if (android.provider.Settings.Global.getInt(this.this$0.mContext.getContentResolver(), "lockscreen_notification_for" + r3.packageName + ":" + UserHandle.getUserId(r3.uid), 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean isTopLocateEnabled(String r4, int r5) {
            if ("com.android.contacts".equals(r4) == false) goto L6;
            r5 = Utils.getAppUid(this.this$0.mContext, "com.android.server.telecom");
            r4 = "com.android.server.telecom";
        L6:
            if (NotificationSearchFragment.access$1500(this.this$0).checkOpNoThrow(this.this$0.mContext, 26, r5, r4) != 0) goto L8;
            return true;
        L8:
            return false;
        }

        private boolean isPopupDialogEnable(String r3, int r4) {
            if (android.provider.Settings.Global.getInt(this.this$0.getContentResolver(), "pop_up_dialog_in_lock_screen_" + r3 + ":" + UserHandle.getUserId(r4), 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean isLedEnable(ApplicationInfo r4) {
            if ("com.android.contacts".equals(r4.packageName) == true) goto L16;
        L14:
            return NotificationSearchFragment.access$1400(this.this$0).getISmtEx().isNotiicationLedEnabledForPackage(r4.packageName, r4.uid);
        L11:
            e = move-exception;
            OLog.e(NotificationSearchFragment.access$1600(this.this$0), "isLedEnable error:" + e);
            return false;
        L16:
            r4 = this.mPackageManager.getApplicationInfo("com.android.server.telecom", 0);     // Catch: PackageManager.NameNotFoundException -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            return false;
        }
    }

    public void com_android_settings_NotificationSearchFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationSearchFragment() {
        this.finished = false;
        this.mAlphaComparator = new AnonymousClass4(this);
    }

    static /* synthetic */ String access$000(NotificationSearchFragment r0) {
        return r0.mKeyWord;
    }

    static /* synthetic */ String access$002(NotificationSearchFragment r0, String r1) {
        r0.mKeyWord = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$100(NotificationSearchFragment r0) {
        return r0.mSearchList;
    }

    static /* synthetic */ boolean access$1000(NotificationSearchFragment r0) {
        return r0.mFeatureLEDEnable;
    }

    static /* synthetic */ ArrayList access$102(NotificationSearchFragment r0, ArrayList r1) {
        r0.mSearchList = r1;
        return r1;
    }

    static /* synthetic */ ApplicationsState access$1200(NotificationSearchFragment r0) {
        return r0.mApplicationsState;
    }

    static /* synthetic */ Comparator access$1300(NotificationSearchFragment r0) {
        return r0.mAlphaComparator;
    }

    static /* synthetic */ INotificationManager access$1400(NotificationSearchFragment r0) {
        return r0.mNotificationManager;
    }

    static /* synthetic */ SmtOpsManagerSmt access$1500(NotificationSearchFragment r0) {
        return r0.mSmtOps;
    }

    static /* synthetic */ String access$1600(NotificationSearchFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ ArrayList access$200(NotificationSearchFragment r0) {
        return r0.mEntries;
    }

    static /* synthetic */ ArrayList access$202(NotificationSearchFragment r0, ArrayList r1) {
        r0.mEntries = r1;
        return r1;
    }

    static /* synthetic */ TextView access$300(NotificationSearchFragment r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ ListView access$400(NotificationSearchFragment r0) {
        return r0.mSearchResultListView;
    }

    static /* synthetic */ View access$500(NotificationSearchFragment r0) {
        return r0.mBlankView;
    }

    static /* synthetic */ NotificationAppsAdapter access$600(NotificationSearchFragment r0) {
        return r0.mSearchAdapter;
    }

    static /* synthetic */ void access$700(NotificationSearchFragment r0) {
        r0.clearCurrentFocus();
    }

    static /* synthetic */ boolean access$800(NotificationSearchFragment r0) {
        return r0.mEnableAll;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        boolean r0 = false;
        this.mRootView = r2.inflate(R.layout.fragment_notification_search, r3, false);
        this.mNotificationManager = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        this.mSmtOps = SmtOpsManagerSmt.getInstance();
        this.mSearchBar = (OSearchBar) findViewByIdNullable(R.id.search_field_bar);
        this.mSearchBarPaddingLeft = getResources().getDimensionPixelSize(R.dimen.dimen_16);
        View r5 = findViewByIdNullable(R.id.search_cancel_button);
        this.mCancelBtn = r5;
        r5.setOnClickListener(this);
        this.mBlankView = findViewByIdNullable(R.id.blankview);
        this.mEmptyView = (TextView) findViewByIdNullable(R.id.search_empty_view);
        this.mTipsView = findViewByIdNullable(R.id.tips_view);
        this.mSearchBar.getInputView().addTextChangedListener(new AnonymousClass1(this));
        if (SettingsFeature.isSupportLED() == true) goto L5;
    L7:
        this.mFeatureLEDEnable = r0;
        this.mSearchResultListView = (ListView) findViewByIdNullable(R.id.search_listview);
        this.mApplicationsState = ApplicationsState.getInstance(this._mActivity.getApplication(), true);
        this.mSearchAdapter = new NotificationAppsAdapter(this, this.mContext, this.mApplicationsState);
        initListView();
        this.mSearchResultListView.setAdapter(this.mSearchAdapter);
        this.mSearchResultListView.setOnScrollListener(new AnonymousClass2(this));
        return this.mRootView;
    L5:
        if (this.mIsExtDisplaying == true) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r6, Bundle r7) {
        super.onViewCreated(r6, r7);
        new SearchAnimationHelper().playSearchBoxEnter(this.mSearchBar, this.mSearchBarPaddingLeft, this.mCancelBtn, Arrays.asList(new View[]{this.mSearchResultListView, this.mEmptyView, this.mTipsView}));
        this.mSearchBar.getInputView().requestFocus();
        showSoftInput(this.mSearchBar.getInputView());
    }

    public void initListView() {
        ArrayList<NotificationSettingsFragment.NotificationEntry> r0 = this.mSearchList;
        if (r0 != null) goto L5;
    L8:
        this.mSearchResultListView.setVisibility(8);
        this.mBlankView.setVisibility(0);
        return;
    L5:
        if (r0.size() == 0) goto L8;
        this.mSearchResultListView.setVisibility(0);
        this.mBlankView.setVisibility(8);
    }

    private void clearCurrentFocus() {
        View r0 = this._mActivity.getCurrentFocus();
        if (r0 == null) goto L6;
        r0.clearFocus();
        return;
    }

    public void com_android_settings_NotificationSearchFragment__onResume$___twin___() {
        super.onResume();
        this.mEnableAll = !NotificationSettingsFragment.isAllNotificationsDisabled(this.mContext);
        NotificationAppsAdapter r1 = this.mSearchAdapter;
        if (r1 == null) goto L6;
        r1.resume();
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hideSoftInput();
        NotificationAppsAdapter r0 = this.mSearchAdapter;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        NotificationAppsAdapter r0 = this.mSearchAdapter;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mCancelBtn) goto L6;
        finish();
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public boolean onBackPressedSupport() {
        if (this.finished == true) goto L7;
        this.finished = true;
        this.mSearchBar.getInputView().setText("");
        new SearchAnimationHelper().playSearchBoxExit(this.mSearchBar, this.mSearchBarPaddingLeft, this.mCancelBtn, Arrays.asList(new View[]{this.mSearchResultListView, this.mEmptyView, this.mTipsView}));
        ThreadUtils.getUiThreadHandler().postDelayed(new AnonymousClass3(this), 100);
        return true;
    L7:
        return super.onBackPressedSupport();
    }

    public ArrayList<NotificationSettingsFragment.NotificationEntry> getNotificationEntryList(ArrayList<NotificationSettingsFragment.NotificationEntry> r4, String r5) {
        ArrayList<NotificationSettingsFragment.NotificationEntry> r3 = new ArrayList();
        if (r4 != null) goto L5;
        return r3;
    L5:
        Iterator<NotificationSettingsFragment.NotificationEntry> r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        NotificationSettingsFragment.NotificationEntry r0 = r6.next();
        if (r0.appEntry.label.contains(r5) == true) goto L12;
        if (r0.appEntry.label.toUpperCase().contains(r5.toUpperCase()) == false) goto L7;
    L12:
        r3.add(r0);
        goto L7
    L13:
        return r3;
    }

    public void hideInputMethod() {
        InputMethodManager r0 = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationSearchFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationSearchFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationSearchFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationSearchFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationSearchFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
