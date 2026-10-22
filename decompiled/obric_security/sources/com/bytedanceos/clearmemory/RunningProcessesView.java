package com.bytedanceos.clearmemory;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.UserHandle;
import android.text.BidiFormatter;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import bytedanceos.util.LogTag;
import com.android.internal.util.MemInfoReader;
import com.bytedanceos.oui.MultiSegmentProgressBar;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.widget.SlideListView;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.scrollbar.ListViewScrollBarHelper;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.cleanerpage.ApplicationsRunningViewModel;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RunningProcessesView extends FrameLayout implements AdapterView.OnItemClickListener, AbsListView.RecyclerListener, RunningState.OnRefreshUiListener {
    private static final int CLEAN_ALL_DONE = 4;
    public static final String RECORDER_PACKAGE = "com.obric.recorder";
    private static final int REFRESH_CLEAN_SIZE = 3;
    private static final int REMOVE_ITEM_FROM_ADPATER = 6;
    private static final int RESET_CLEANING_FLAG = 2;
    private static final int RESET_CLEAN_STATE = 5;
    private static final int RESET_CLEAN_STATE_INTERVAL = 30000;
    public static final String TAG = "RunningProcessesView";
    private static final int UPDATE_CLEAN_PROGRESS = 1;
    private static SparseArray<Set<String>> mHadChooseUnclear;
    private static SparseArray<Set<String>> mMarkClearPackage;
    long SECONDARY_SERVER_MEM;
    final Set<RunningState.MergedItem> clearedItems;
    private ImageView dropdown;
    final HashMap<View, ActiveItem> mActiveItems;
    ServiceListAdapter mAdapter;
    ActivityManager mAm;
    private ApplicationsRunningViewModel mAppsRunningViewModel;
    StringBuilder mBuilder;
    private OCardListItem mCarefulClean;
    private volatile long mCleanSize;
    private final Object mCleanSizeLock;
    private TextView mCleanSizeText;
    private CleanState mCleanState;
    private boolean mCleaningAllPackage;
    private OCardListItem mClearButton;
    private OTextView mClearButtonText;
    long mCurHighRam;
    long mCurLowRam;
    long mCurMedRam;
    private RunningState.MergedItem mCurSelected;
    boolean mCurShowCached;
    long mCurTotalRam;
    Runnable mDataAvail;
    private MyHandler mHandler;
    private boolean mHasClean;
    private View mHeader;
    IActivityManager mIActivityManager;
    private boolean mIsMemoryHeaderWrapped;
    private final PerformanceMonitors.FpsSceneSession mListFpsSession;
    private boolean mListFpsStarted;
    private SlideListView mListView;
    MemInfoReader mMemInfoReader;
    private TextView mMemoryAvailableSize;
    private ConstraintLayout mMemoryHeaderContent;
    private TextView mMemoryTotal;
    private TextView mMemoryUnused;
    private OTextView mMemoryUnusedlUnit;
    private OActionDialog mMenuDialog;
    final int mMyUserId;
    private Toast mNotProcessClearToast;
    private OCheckBox.OnCheckedChangeListener mOnCheckedChangeListener;
    Activity mOwner;
    private OCardListItem mPersistClean;
    private LinearLayout mSelectedContain;
    private View mShowAllContainer;
    private SlideListView.Listener mSlideListener;
    RunningState mState;
    private MultiSegmentProgressBar mStorageProgress;
    private final Runnable mUpdateMemoryHeaderLayoutRunnable;
    private Handler mWorkHandler;

    public static class ActiveItem {
        long mFirstRunTime;
        ViewHolder mHolder;
        RunningState.BaseItem mItem;
        View mRootView;
        ActivityManager.RunningServiceInfo mService;
        boolean mSetBackground;

        public ActiveItem() {
        }
    }

    private static class MyHandler extends Handler {
        WeakReference<RunningProcessesView> mReference;

        MyHandler(RunningProcessesView view) {
            this.mReference = new WeakReference(view);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            RunningProcessesView r0 = this.mReference.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r1 = msg.what;
            if (r1 != 2) goto L8;
            RunningProcessesView.access$102(r0, false);
            return;
        L8:
            if (r1 == 3) goto L28;
            List<RunningState.MergedItem> r2 = null;
            if (r1 == 4) goto L24;
            if (r1 != 5) goto L14;
            LogTag.d(RunningProcessesView.TAG, " handler msg RESET_CLEAN_STATE mCleanState = " + RunningProcessesView.access$500(r0));
            RunningProcessesView.access$502(r0, CleanState.IDLE);
            RunningProcessesView.access$600(r0);
            return;
        L14:
            if (r1 == 6) goto L17;
            return;
        L17:
            if (msg.obj == null) goto L20;
            r2 = (List) msg.obj;
        L20:
            if (r2 == null) goto L33;
            r0.mAdapter.removeItem(r2);
            return;
        L33:
            return;
        L24:
            if (RunningProcessesView.access$100(r0) == false) goto L26;
            RunningProcessesView.access$502(r0, CleanState.CLEANED);
            r0.clearMergedItems();
            RunningProcessesView.access$102(r0, false);
        L27:
            RunningProcessesView.access$600(r0);
            removeCallbacksAndMessages(null);
            return;
        L26:
            RunningProcessesView.access$502(r0, CleanState.IDLE);
            goto L27
        L28:
            RunningProcessesView.access$200(r0);
            RunningProcessesView.access$300(r0, ((Long) msg.obj).longValue());
            if (RunningProcessesView.access$400(r0) != 0) goto L37;
            sendEmptyMessage(4);
            return;
        }
    }

    class ServiceListAdapter extends BaseAdapter {
        private static final int SHOW_TOP_COUNT = 3;
        private static final int TYPE_ITEM = 0;
        private static final int TYPE_ITEM_HEADER = 1;
        final List<RunningState.MergedItem> mCarefulItems;
        int mClearCount;
        final LayoutInflater mInflater;
        final List<RunningState.MergedItem> mItems;
        ArrayList<RunningState.MergedItem> mOrigItems;
        final List<RunningState.MergedItem> mPersistfulItems;
        private boolean mShowAll;
        boolean mShowBackground;
        final Comparator<RunningState.MergedItem> mSizeComparator;
        final RunningState mState;
        final List<RunningState.MergedItem> mSuggestCleanItems;
        final List<RunningState.MergedItem> mSuggestShowItems;
        final /* synthetic */ RunningProcessesView this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int position) {
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        ServiceListAdapter(final RunningProcessesView this$0, RunningState state) {
            this.this$0 = this$0;
            this.mShowAll = false;
            this.mItems = new ArrayList();
            this.mSuggestCleanItems = new ArrayList();
            this.mSuggestShowItems = new ArrayList();
            this.mCarefulItems = new ArrayList();
            this.mPersistfulItems = new ArrayList();
            this.mClearCount = 0;
            this.mSizeComparator = new AnonymousClass1(this);
            this.mState = state;
            this.mInflater = (LayoutInflater) this$0.getContext().getSystemService("layout_inflater");
        }

        void removeItem(List<RunningState.MergedItem> item) {
            this.mSuggestCleanItems.removeAll(item);
            this.mSuggestShowItems.removeAll(item);
            refreshShowAllButton();
            notifyDataSetChanged();
        }

        boolean getCurrentShowAllStatus() {
            return this.mShowAll;
        }

        void setShowAll(boolean showAll) {
            if (this.mShowAll != showAll) goto L5;
            return;
        L5:
            this.mShowAll = showAll;
            refreshItems();
            notifyDataSetChanged();
        }

        void setShowBackground(boolean showBackground) {
            if (this.mShowBackground == showBackground) goto L6;
            this.mShowBackground = showBackground;
            this.mState.setWatchingBackgroundItems(showBackground);
            refreshItems();
            this.this$0.refreshUi(true);
            return;
        }

        boolean getShowBackground() {
            return this.mShowBackground;
        }

        public void refreshItems() {
            List<RunningState.MergedItem> r0 = RunningProcessesView.access$1000(this.this$0, this.mState.getCurrentMergedItems());
            final Set<RunningState.MergedItem> r1 = this.this$0.clearedItems;
            Objects.requireNonNull(r1);
            r0.removeIf(new RunningProcessesView$ServiceListAdapter$$ExternalSyntheticLambda3(r1));
            refreshItems(r0);
        }

        void refreshItems(List<RunningState.MergedItem> list) {
            this.mItems.clear();
            if (RunningProcessesView.access$500(this.this$0) != CleanState.CLEANED) goto L5;
            list = Collections.emptyList();
        L5:
            this.mItems.addAll(list);
            refresh();
            RunningProcessesView.access$200(this.this$0);
        }

        void refreshShowAllButton() {
            if (RunningProcessesView.access$1100(this.this$0) != null) goto L6;
            return;
        L6:
            if (this.mSuggestCleanItems.size() > 3) goto L8;
            RunningProcessesView.access$1100(this.this$0).setVisibility(8);
            return;
        L8:
            RunningProcessesView.access$1100(this.this$0).setVisibility(0);
        }

        void refreshOtherMemoryStatus() {
            if (RunningProcessesView.access$1200(this.this$0) != null) goto L5;
            return;
        L5:
            Iterator<RunningState.MergedItem> r0 = this.mCarefulItems.iterator();
            long r3 = 0;
        L7:
            if (r0.hasNext() == false) goto L10;
            r3 = r3 + r0.next().mMergeSize;
            goto L7
        L10:
            if (r3 <= 0) goto L12;
            ByteUnitPair r4 = ByteConverter.convert(r3, "B", 1000);
            OCardListItemExtKt.setEndText(RunningProcessesView.access$1200(this.this$0), r4.value + r4.unit);
        L13:
            Iterator<RunningState.MergedItem> r5 = this.mPersistfulItems.iterator();
            long r7 = 0;
        L15:
            if (r5.hasNext() == false) goto L18;
            r7 = r7 + r5.next().mMergeSize;
            goto L15
        L18:
            if (r7 <= 0) goto L20;
            ByteUnitPair r2 = ByteConverter.convert(r7, "B", 1000);
            OCardListItemExtKt.setEndText(RunningProcessesView.access$1300(this.this$0), r2.value + r2.unit);
            RunningProcessesView.access$1300(this.this$0).showTitle(true);
        L22:
            if (r3 <= 0) goto L25;
            if (r7 <= 0) goto L25;
            RunningProcessesView.access$1200(this.this$0).setVisibility(0);
            RunningProcessesView.access$1300(this.this$0).setVisibility(0);
            RunningProcessesView.access$1400(this.this$0);
            return;
        L25:
            if (r3 <= 0) goto L27;
            RunningProcessesView.access$1200(this.this$0).setVisibility(0);
            RunningProcessesView.access$1400(this.this$0);
            return;
        L27:
            if (r7 <= 0) goto L34;
            RunningProcessesView.access$1300(this.this$0).setVisibility(0);
            RunningProcessesView.access$1400(this.this$0);
            return;
        L34:
            return;
        L20:
            RunningProcessesView.access$1300(this.this$0).post(new RunningProcessesView$ServiceListAdapter$$ExternalSyntheticLambda2(this));
            goto L22
        L12:
            RunningProcessesView.access$1200(this.this$0).post(new RunningProcessesView$ServiceListAdapter$$ExternalSyntheticLambda1(this));
            goto L13
        }

        /* JADX INFO: renamed from: lambda$refreshOtherMemoryStatus$0$com-bytedanceos-clearmemory-RunningProcessesView$ServiceListAdapter, reason: not valid java name */
        /* synthetic */ void m93x47017bc1() {
            RunningProcessesView.access$1200(this.this$0).setVisibility(8);
            RunningProcessesView.access$1400(this.this$0);
        }

        /* JADX INFO: renamed from: lambda$refreshOtherMemoryStatus$1$com-bytedanceos-clearmemory-RunningProcessesView$ServiceListAdapter, reason: not valid java name */
        /* synthetic */ void m94x38530b42() {
            RunningProcessesView.access$1300(this.this$0).setVisibility(8);
            RunningProcessesView.access$1400(this.this$0);
        }

        public void refresh() {
            this.mSuggestCleanItems.clear();
            this.mSuggestShowItems.clear();
            this.mCarefulItems.clear();
            this.mPersistfulItems.clear();
            this.mClearCount = 0;
            Collections.sort(this.mItems, this.mSizeComparator);
            Iterator<RunningState.MergedItem> r1 = this.mItems.iterator();
        L4:
            if (r1.hasNext() == false) goto L31;
            RunningState.MergedItem r2 = r1.next();
            if (r2.mIsTaskPersist == true) goto L7;
            if (r2.mIsRecommendClear == true) goto L10;
            this.mCarefulItems.add(r2);
            goto L4
        L10:
            this.mClearCount++;
            Set r3 = (Set) RunningProcessesView.access$700().get(r2.mUserId, null);
            if (r3 != null) goto L13;
            r3 = new HashSet();
            RunningProcessesView.access$700().put(r2.mUserId, r3);
        L13:
            Set r4 = (Set) RunningProcessesView.access$800().get(r2.mUserId, null);
            if (r4 != null) goto L17;
            r4 = new HashSet();
            RunningProcessesView.access$800().put(r2.mUserId, r4);
        L17:
            if (r3.contains(r2.mPackageInfo.packageName) == false) goto L19;
        L28:
            this.mSuggestCleanItems.add(r2);
            goto L4
        L19:
            if (r4.add(r2.mPackageInfo.packageName) == false) goto L28;
            Object r5 = RunningProcessesView.access$900(this.this$0);
            monitor-enter(r5);
            RunningProcessesView.access$414(this.this$0, r2.mMergeSize);     // Catch: Throwable -> L25
            monitor-exit(r5);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        L7:
            this.mPersistfulItems.add(r2);
            goto L4
        L31:
            if (this.mShowAll == false) goto L33;
            this.mSuggestShowItems.addAll(this.mSuggestCleanItems);
        L39:
            refreshOtherMemoryStatus();
            refreshShowAllButton();
            RunningProcessesView.access$600(this.this$0);
            return;
        L33:
            int r6 = 3;
            if (this.mSuggestCleanItems.size() > 3) goto L37;
            r6 = this.mSuggestCleanItems.size();
        L37:
            if (r6 <= 0) goto L39;
            this.mSuggestShowItems.addAll(this.mSuggestCleanItems.subList(0, r6));
            goto L39
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mSuggestShowItems.size();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            if (this.mState.hasData() == true) goto L5;
        L7:
            return false;
        L5:
            if (getCount() != 0) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            if (position >= 0) goto L4;
            return null;
        L4:
            if (position < this.mSuggestShowItems.size()) goto L7;
            return null;
        L7:
            return this.mSuggestShowItems.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            Object r0 = getItem(position);
            if (r0 == null) goto L6;
            return r0.hashCode();
        L6:
            return position;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int position) {
            Object r0 = getItem(position);
            if ((r0 instanceof RunningState.MergedItem) == true) goto L7;
            return false;
        L7:
            return !((RunningState.MergedItem) r0).mIsProcess;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            int r0 = getItemViewType(position);
            if (convertView != null) goto L5;
            convertView = newView(parent, r0);
        L5:
            bindView(convertView, position);
            return convertView;
        }

        public View newView(ViewGroup parent, int viewType) {
            View r1 = this.mInflater.inflate(R.layout.running_processes_item_q, parent, false);
            new ViewHolder(r1);
            return r1;
        }

        public void bindView(View view, int position) {
            Object r0 = this.mState.mLock;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L5:
            if (position < this.mSuggestShowItems.size()) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L24
            return;
        L8:
            ViewHolder r1 = (ViewHolder) view.getTag();     // Catch: Throwable -> L24
            Object r2 = getItem(position);     // Catch: Throwable -> L24
            if ((r2 instanceof RunningState.MergedItem) == true) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L24
            return;
        L12:
            final RunningState.MergedItem r3 = (RunningState.MergedItem) r2;     // Catch: Throwable -> L24
            if (getCount() != 1) goto L15;
            r1.oCardListItem.setCardPosition(1);     // Catch: Throwable -> L24
        L18:
            ActiveItem r7 = r1.bind(this.mState, r3, this.this$0.mBuilder);     // Catch: Throwable -> L24
            r1.oCardListItem.showDivider(false);     // Catch: Throwable -> L24
            if (r1.cb == null) goto L21;
            r1.cb.setOnCheckedChangeListener(RunningProcessesView.access$1500(this.this$0));     // Catch: Throwable -> L24
        L21:
            this.this$0.mActiveItems.put(view, r7);     // Catch: Throwable -> L24
            r1.oCardListItem.setOnContentClickListener(new RunningProcessesView$ServiceListAdapter$$ExternalSyntheticLambda0(this, r3));     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
            return;
        L15:
            if (position != 0) goto L17;
            r1.oCardListItem.setCardPosition(1);     // Catch: Throwable -> L24
            goto L18
        L17:
            r1.oCardListItem.setCardPosition(2);     // Catch: Throwable -> L24
            goto L18
        }

        /* JADX INFO: renamed from: lambda$bindView$2$com-bytedanceos-clearmemory-RunningProcessesView$ServiceListAdapter, reason: not valid java name */
        /* synthetic */ void m92x56f4e7dd(RunningState.MergedItem r1, View r2) {
            if (Utils.isFastDoubleClick() == false) goto L6;
            return;
        L6:
            if (RunningProcessesView.access$1600(this.this$0) != null) goto L8;
        L9:
            if (r1 != null) goto L11;
            return;
        L11:
            RunningProcessesView.access$1702(this.this$0, r1);
            RunningProcessesView.access$1800(this.this$0);
            return;
        L8:
            if (RunningProcessesView.access$1600(this.this$0).isShowing() == false) goto L9;
        }
    }

    public static class ViewHolder {
        public static final int NAME_MAX_WIDTH = 580;
        public static final int NAME_MAX_WIDTH_PERSIST = 470;
        public OCheckBox cb;
        public OCardListItem oCardListItem;
        public View processesItem;
        public View rootView;
        public ApplicationsRunningViewModel viewModel;

        public ViewHolder(View v) {
            this.rootView = v;
            this.processesItem = v.findViewById(R.id.processes_item);
            this.oCardListItem = (OCardListItem) v.findViewById(R.id.oCard_list_item);
            v.setTag(this);
            Context r2 = v.getContext();
            this.viewModel = ApplicationsRunningViewModel.Companion.getManagerApplicationsRunningActivity(r2);     // Catch: Throwable -> L5
            return;
        L5:
            this.viewModel = null;
        }

        public ActiveItem bind(RunningState state, RunningState.BaseItem item, StringBuilder builder) {
            Object r2 = state.mLock;
            monitor-enter(r2);
            Context r3 = this.rootView.getContext();     // Catch: Throwable -> L48
            if (item.mPackageInfo == null) goto L7;
        L11:
            this.oCardListItem.setTitle(item.mDisplayLabel);     // Catch: Throwable -> L48
            boolean r5 = true;
            this.oCardListItem.showTitle(true);     // Catch: Throwable -> L48
            LogTag.d(RunningProcessesView.TAG, "bind item.mDisplayLabel========== " + item.mDisplayLabel);     // Catch: Throwable -> L48
            ActiveItem r1 = new ActiveItem();     // Catch: Throwable -> L48
            r1.mRootView = this.rootView;     // Catch: Throwable -> L48
            r1.mItem = item;     // Catch: Throwable -> L48
            r1.mHolder = this;     // Catch: Throwable -> L48
            r1.mFirstRunTime = item.mActiveSince;     // Catch: Throwable -> L48
            item.mCurSizeStr = null;     // Catch: Throwable -> L48
            this.oCardListItem.setAppIcon(OuiWidgetUtils.applyDopplegangerBadge(r3, item.loadIcon(r3, state), item.isDoppleganger));     // Catch: Throwable -> L48
            boolean r11 = item.isDoppleganger;     // Catch: Throwable -> L48
            this.oCardListItem.showIcon(true);     // Catch: Throwable -> L48
            OCardListItemExtKt.setEndText(this.oCardListItem, item.mSizeStr);     // Catch: Throwable -> L48
            if (this.oCardListItem.getStartCheckBox() != null) goto L14;
        L15:
            this.oCardListItem.setDefaultCustomStartView(0);     // Catch: Throwable -> L48
        L16:
            this.oCardListItem.showCustomStart(true);     // Catch: Throwable -> L48
            OCheckBox r12 = this.oCardListItem.getStartCheckBox().getCheckBox();     // Catch: Throwable -> L48
            r12.setTag(item);     // Catch: Throwable -> L48
            if ((item instanceof RunningState.MergedItem) == true) goto L19;
        L26:
            r12.setVisibility(4);     // Catch: Throwable -> L48
        L27:
            OCheckBoxLayout r6 = this.oCardListItem.getStartCheckBox();     // Catch: Throwable -> L48
            if (this.viewModel.getCleaningStatus().getValue() == CleanState.CLEANING) goto L30;
            boolean r8 = true;
        L31:
            r6.setEnabled(r8);     // Catch: Throwable -> L48
            this.cb = r12;     // Catch: Throwable -> L48
            r12.setTag(item);     // Catch: Throwable -> L48
            this.oCardListItem.setTag(item);     // Catch: Throwable -> L48
            if ((item instanceof RunningState.MergedItem) == true) goto L34;
        L46:
            monitor-exit(r2);     // Catch: Throwable -> L48
            return r1;
        L34:
            if (((RunningState.MergedItem) item).mIsTaskPersist == false) goto L36;
            this.cb.setVisibility(4);     // Catch: Throwable -> L48
            goto L46
        L36:
            this.cb.setVisibility(0);     // Catch: Throwable -> L48
            Set r13 = (Set) RunningProcessesView.access$800().get(item.mUserId, Collections.emptySet());     // Catch: Throwable -> L48
            Set r4 = (Set) RunningProcessesView.access$700().get(item.mUserId, null);     // Catch: Throwable -> L48
            if (r4 != null) goto L39;
            r4 = new HashSet();     // Catch: Throwable -> L48
            RunningProcessesView.access$700().put(item.mUserId, r4);     // Catch: Throwable -> L48
        L39:
            LogTag.d(RunningProcessesView.TAG, "bind item.sets========== " + r13);     // Catch: Throwable -> L48
            if (item.mPackageInfo == null) goto L46;
            LogTag.d(RunningProcessesView.TAG, "bind set checked========== " + r13.contains(item.mPackageInfo.packageName));     // Catch: Throwable -> L48
            OCheckBox r10 = this.cb;     // Catch: Throwable -> L48
            if (r4.contains(item.mPackageInfo.packageName) == false) goto L45;
            r5 = false;
        L45:
            r10.setChecked(r5);     // Catch: Throwable -> L48
            goto L46
        L30:
            r8 = false;
            goto L31
        L19:
            if (((RunningState.MergedItem) item).mIsTaskPersist == true) goto L26;
            if (item.mPackageInfo == null) goto L26;
            boolean r7 = ((Set) RunningProcessesView.access$800().get(item.mUserId, Collections.emptySet())).contains(item.mPackageInfo.packageName);     // Catch: Throwable -> L48
            if (r12.isChecked() == r7) goto L25;
            r12.setOnCheckedChangeListener(null);     // Catch: Throwable -> L48
            r12.setChecked(r7);     // Catch: Throwable -> L48
        L25:
            r12.setVisibility(0);     // Catch: Throwable -> L48
            goto L27
        L14:
            if (this.oCardListItem.getStartCheckBox().getCheckBox() != null) goto L16;
        L7:
            if ((item instanceof RunningState.MergedItem) == false) goto L11;
            if (((RunningState.MergedItem) item).mProcess == null) goto L11;
            ((RunningState.MergedItem) item).mProcess.ensureLabel(r3.getPackageManager());     // Catch: Throwable -> L48
            item.mPackageInfo = ((RunningState.MergedItem) item).mProcess.mPackageInfo;     // Catch: Throwable -> L48
            item.mDisplayLabel = ((RunningState.MergedItem) item).mProcess.mDisplayLabel;     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            throw th;
        }
    }

    private void vibrate() {
    }

    void updateTimes() {
    }

    static /* synthetic */ void access$000(RunningProcessesView r0) {
        r0.updateMemoryHeaderLayout();
    }

    static /* synthetic */ boolean access$100(RunningProcessesView r0) {
        return r0.mCleaningAllPackage;
    }

    static /* synthetic */ List access$1000(RunningProcessesView r0, ArrayList r1) {
        return r0.mergeRunningState(r1);
    }

    static /* synthetic */ boolean access$102(RunningProcessesView r0, boolean r1) {
        r0.mCleaningAllPackage = r1;
        return r1;
    }

    static /* synthetic */ View access$1100(RunningProcessesView r0) {
        return r0.mShowAllContainer;
    }

    static /* synthetic */ OCardListItem access$1200(RunningProcessesView r0) {
        return r0.mCarefulClean;
    }

    static /* synthetic */ OCardListItem access$1300(RunningProcessesView r0) {
        return r0.mPersistClean;
    }

    static /* synthetic */ void access$1400(RunningProcessesView r0) {
        r0.cardPosion();
    }

    static /* synthetic */ OCheckBox.OnCheckedChangeListener access$1500(RunningProcessesView r0) {
        return r0.mOnCheckedChangeListener;
    }

    static /* synthetic */ OActionDialog access$1600(RunningProcessesView r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ RunningState.MergedItem access$1700(RunningProcessesView r0) {
        return r0.mCurSelected;
    }

    static /* synthetic */ RunningState.MergedItem access$1702(RunningProcessesView r0, RunningState.MergedItem r1) {
        r0.mCurSelected = r1;
        return r1;
    }

    static /* synthetic */ void access$1800(RunningProcessesView r0) {
        r0.showItemMenu();
    }

    static /* synthetic */ void access$1900(RunningProcessesView r0, long r1, long r3, long r5, long r7) {
        r0.updateMemoryStatus(r1, r3, r5, r7);
    }

    static /* synthetic */ void access$200(RunningProcessesView r0) {
        r0.refreshCouldCleanSize();
    }

    static /* synthetic */ MyHandler access$2000(RunningProcessesView r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$2100(RunningProcessesView r0) {
        r0.scheduleUpdateMemoryHeaderLayout();
    }

    static /* synthetic */ void access$2200(RunningProcessesView r0) {
        r0.stopListFps();
    }

    static /* synthetic */ void access$2300(RunningProcessesView r0) {
        r0.startListFps();
    }

    static /* synthetic */ void access$2400(RunningProcessesView r0) {
        r0.clearSelectPackage();
    }

    static /* synthetic */ OCardListItem access$2500(RunningProcessesView r0) {
        return r0.mClearButton;
    }

    static /* synthetic */ SlideListView access$2600(RunningProcessesView r0) {
        return r0.mListView;
    }

    static /* synthetic */ boolean access$2700(RunningProcessesView r0, RunningState.MergedItem r1) {
        return r0.stopPackage(r1);
    }

    static /* synthetic */ void access$2800(RunningProcessesView r0, RunningState.MergedItem r1) {
        r0.showCleanToast(r1);
    }

    static /* synthetic */ void access$300(RunningProcessesView r0, long r1) {
        r0.refreshMemorySize(r1);
    }

    static /* synthetic */ long access$400(RunningProcessesView r2) {
        return r2.mCleanSize;
    }

    static /* synthetic */ long access$402(RunningProcessesView r0, long r1) {
        r0.mCleanSize = r1;
        return r1;
    }

    static /* synthetic */ long access$414(RunningProcessesView r2, long r3) {
        long r0 = r2.mCleanSize + r3;
        r2.mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ long access$422(RunningProcessesView r2, long r3) {
        long r0 = r2.mCleanSize - r3;
        r2.mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ CleanState access$500(RunningProcessesView r0) {
        return r0.mCleanState;
    }

    static /* synthetic */ CleanState access$502(RunningProcessesView r0, CleanState r1) {
        r0.mCleanState = r1;
        return r1;
    }

    static /* synthetic */ void access$600(RunningProcessesView r0) {
        r0.updateHeaderView();
    }

    static /* synthetic */ SparseArray access$700() {
        return mHadChooseUnclear;
    }

    static /* synthetic */ SparseArray access$800() {
        return mMarkClearPackage;
    }

    static /* synthetic */ Object access$900(RunningProcessesView r0) {
        return r0.mCleanSizeLock;
    }

    void refreshUi(boolean dataChanged) {
        refreshCouldCleanSize();
        refreshMemorySize();
        if (this.mCleanState == CleanState.IDLE) goto L5;
        return;
    L5:
        if (dataChanged == false) goto L7;
        ServiceListAdapter r3 = this.mAdapter;
        r3.refreshItems();
        r3.notifyDataSetChanged();
    L7:
        Runnable r4 = this.mDataAvail;
        if (r4 == null) goto L11;
        r4.run();
        this.mDataAvail = null;
        return;
    }

    private void refreshMemorySize(long changeSize) {
        updateMemoryStatus(this.mCurTotalRam, this.mCurHighRam, this.mCurMedRam, this.mCurLowRam + changeSize);
    }

    private void refreshMemorySize() {
        this.mWorkHandler.post(new AnonymousClass3(this));
    }

    private void updateMemoryStatus(long totalRam, long highRam, long medRam, long lowRam) {
        if (this.mCurTotalRam == totalRam) goto L5;
    L10:
        this.mCurTotalRam = totalRam;
        this.mCurHighRam = highRam;
        this.mCurMedRam = medRam;
        this.mCurLowRam = lowRam;
        BidiFormatter.getInstance();
        long r9 = (((totalRam / 1000) / 1000) / 1000) + 1;
        String r3 = r9 + "GB";
        long r10 = ((r9 * 1000) * 1000) * 1000;
        if (r10 >= totalRam) goto L13;
        r10 = totalRam;
    L13:
        long r4 = r10 - totalRam;
        long r11 = lowRam + r4;
        ByteUnitPair r13 = ByteConverter.convertGB(r11, 1000, 1);
        ByteConverter.convertGB((r10 - lowRam) - r4, 1000, 1);
        LogTag.i(TAG, "lowRam " + lowRam + " diff " + r4 + " totalRam " + totalRam + ",totalSizeStr=" + r3 + ",newTotal=" + r10);
        String[] r1 = Utils.spliteSizeStr(r3);
        if (r1 == null) goto L16;
        this.mMemoryTotal.setText(getResources().getString(R.string.total) + r1[0] + r1[1]);
    L16:
        if (r13 == null) goto L21;
        this.mMemoryUnused.setText(r13.getValue());
        OTextView r2 = this.mMemoryUnusedlUnit;
        if (r2 == null) goto L21;
        r2.setText(r13.getUnit());
    L21:
        if (this.mStorageProgress != null) goto L23;
        return;
    L23:
        if (r10 <= 0) goto L28;
        float r5 = getResources().getDisplayMetrics().density * 8.0f;
        this.mStorageProgress.setSegments(Arrays.asList(new MultiSegmentProgressBar.Segment[]{new MultiSegmentProgressBar.Segment(getResources().getColor(R.color.oui_blue_6), (r10 - r11) / r10, new float[]{r5, r5, 0.0f, 0.0f, 0.0f, 0.0f, r5, r5})}));
        return;
    L28:
        return;
    L5:
        if (this.mCurHighRam != highRam) goto L10;
        if (this.mCurMedRam != medRam) goto L10;
        if (this.mCurLowRam != lowRam) goto L10;
    }

    private void scheduleUpdateMemoryHeaderLayout() {
        ConstraintLayout r0 = this.mMemoryHeaderContent;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeCallbacks(this.mUpdateMemoryHeaderLayoutRunnable);
        this.mMemoryHeaderContent.post(this.mUpdateMemoryHeaderLayoutRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ConstraintLayout r0 = this.mMemoryHeaderContent;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.mUpdateMemoryHeaderLayoutRunnable);
    L5:
        super.onDetachedFromWindow();
    }

    private void updateMemoryHeaderLayout() {
        ConstraintLayout r0 = this.mMemoryHeaderContent;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mMemoryUnused != null) goto L7;
        return;
    L7:
        if (this.mMemoryUnusedlUnit != null) goto L9;
        return;
    L9:
        if (this.mMemoryAvailableSize != null) goto L11;
        return;
    L11:
        if (this.mMemoryTotal != null) goto L13;
        return;
    L13:
        if (this.mStorageProgress == null) goto L29;
        int r1 = (r0.getWidth() - this.mMemoryHeaderContent.getPaddingLeft()) - this.mMemoryHeaderContent.getPaddingRight();
        if (r1 > 0) goto L18;
        return;
    L18:
        int r2 = ((ViewGroup.MarginLayoutParams) this.mMemoryAvailableSize.getLayoutParams()).leftMargin + ((ViewGroup.MarginLayoutParams) this.mMemoryAvailableSize.getLayoutParams()).rightMargin;
        int r3 = Math.round(getResources().getDisplayMetrics().density * 4.0f);
        if ((((((getDesiredTextWidth(this.mMemoryUnused) + getDesiredTextWidth(this.mMemoryUnusedlUnit)) + getDesiredTextWidth(this.mMemoryAvailableSize)) + getDesiredTextWidth(this.mMemoryTotal)) + r2) + r3) <= r1) goto L21;
        boolean r4 = true;
    L22:
        applyMemoryHeaderConstraints(r4);
        return;
    L21:
        r4 = false;
        goto L22
    }

    private int getDesiredTextWidth(TextView textView) {
        if (textView != null) goto L5;
        return 0;
    L5:
        CharSequence r2 = textView.getText();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        return (((int) Math.ceil(Layout.getDesiredWidth(r2, textView.getPaint()))) + textView.getCompoundPaddingLeft()) + textView.getCompoundPaddingRight();
    }

    private void applyMemoryHeaderConstraints(boolean wrapToNextLine) {
        if (this.mMemoryHeaderContent != null) goto L5;
        return;
    L5:
        if (this.mIsMemoryHeaderWrapped == wrapToNextLine) goto L14;
        this.mIsMemoryHeaderWrapped = wrapToNextLine;
        ConstraintSet r0 = new ConstraintSet();
        r0.clone(this.mMemoryHeaderContent);
        int r6 = getResources().getDimensionPixelSize(R.dimen.inner_common_dimen_8dp);
        clearMemoryHeaderConstraints(r0, R.id.scanning_size);
        clearMemoryHeaderConstraints(r0, R.id.tv_used_unit);
        clearMemoryHeaderConstraints(r0, R.id.memory_available_size);
        clearMemoryHeaderConstraints(r0, R.id.tv_detail);
        clearMemoryHeaderConstraints(r0, R.id.storage_progress);
        r0.connect(R.id.scanning_size, 6, 0, 6);
        r0.connect(R.id.scanning_size, 3, 0, 3);
        if (wrapToNextLine == false) goto L10;
        r0.connect(R.id.tv_used_unit, 6, 0, 6);
        r0.connect(R.id.tv_used_unit, 3, R.id.scanning_size, 4);
        r0.connect(R.id.tv_used_unit, 5, R.id.memory_available_size, 5);
        r0.connect(R.id.memory_available_size, 6, R.id.tv_used_unit, 7);
        r0.connect(R.id.memory_available_size, 7, R.id.tv_detail, 6);
        r0.connect(R.id.memory_available_size, 3, R.id.scanning_size, 4);
        r0.connect(R.id.tv_detail, 7, 0, 7);
        r0.connect(R.id.tv_detail, 5, R.id.memory_available_size, 5);
        r0.connect(R.id.storage_progress, 3, R.id.memory_available_size, 4, r6);
    L11:
        r0.connect(R.id.storage_progress, 6, 0, 6);
        r0.connect(R.id.storage_progress, 7, 0, 7);
        r0.applyTo(this.mMemoryHeaderContent);
        return;
    L10:
        r0.connect(R.id.tv_used_unit, 6, R.id.scanning_size, 7);
        r0.connect(R.id.tv_used_unit, 5, R.id.scanning_size, 5);
        r0.connect(R.id.memory_available_size, 6, R.id.tv_used_unit, 7);
        r0.connect(R.id.memory_available_size, 7, R.id.tv_detail, 6);
        r0.connect(R.id.memory_available_size, 5, R.id.scanning_size, 5);
        r0.connect(R.id.tv_detail, 7, 0, 7);
        r0.connect(R.id.tv_detail, 5, R.id.scanning_size, 5);
        r0.connect(R.id.storage_progress, 3, R.id.scanning_size, 4, r6);
        goto L11
    }

    private void clearMemoryHeaderConstraints(ConstraintSet constraintSet, int viewId) {
        constraintSet.clear(viewId, 6);
        constraintSet.clear(viewId, 7);
        constraintSet.clear(viewId, 3);
        constraintSet.clear(viewId, 4);
        constraintSet.clear(viewId, 5);
    }

    private void refreshCouldCleanSize() {
        long r0 = this.mCleanSize;
        if (r0 >= 0) goto L6;
        LogTag.e(TAG, "clear size error " + this.mCleanSize);
        r0 = 0;
    L6:
        if (this.mCleanSizeText != null) goto L8;
        return;
    L8:
        ByteUnitPair r1 = ByteConverter.convert(r0, "B", 1000);
        this.mCleanSizeText.setText(r1.getValue() + r1.getUnit());
    }

    private void updateHeaderView() {
        if (this.mCleanState != CleanState.CLEANED) goto L6;
        this.mClearButton.setCardPosition(0);
        this.mClearButtonText.setText(getResources().getString(R.string.memory_has_clean));
    L17:
        syncViewModelCleanState();
        updateActiveItemsCheckBoxEnabled();
        return;
    L6:
        if (this.mCleanState != CleanState.CLEANING) goto L9;
        this.mClearButtonText.setText(getResources().getString(R.string.cleaning_memory));
        goto L17
    L9:
        if (this.mCleanState != CleanState.IDLE) goto L17;
        ServiceListAdapter r0 = this.mAdapter;
        if (r0 != null) goto L13;
    L15:
        this.mClearButton.setCardPosition(3);
    L16:
        this.mClearButtonText.setText(getResources().getString(R.string.memory_onestep_clean));
        goto L17
    L13:
        if (r0.mSuggestShowItems.isEmpty() == false) goto L15;
        this.mClearButton.setCardPosition(0);
        goto L16
    }

    private void updateActiveItemsCheckBoxEnabled() {
        if (this.mCleanState == CleanState.CLEANING) goto L5;
        boolean r0 = true;
    L6:
        Iterator<ActiveItem> r3 = this.mActiveItems.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L18;
        ActiveItem r1 = r3.next();
        if (r1 == null) goto L8;
        if (r1.mHolder == null) goto L8;
        if (r1.mHolder.oCardListItem == null) goto L8;
        if (r1.mHolder.oCardListItem.getStartCheckBox() == null) goto L8;
        r1.mHolder.oCardListItem.getStartCheckBox().setEnabled(r0);
        goto L8
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void syncViewModelCleanState() {
        if (this.mAppsRunningViewModel == null) goto L5;
    L7:
        ApplicationsRunningViewModel r0 = this.mAppsRunningViewModel;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.getCleaningStatus() == null) goto L14;
        this.mAppsRunningViewModel.getCleaningStatus().setValue(this.mCleanState);
        return;
    L14:
        return;
    L5:
        if (this.mOwner == null) goto L7;
        this.mAppsRunningViewModel = ApplicationsRunningViewModel.Companion.getManagerApplicationsRunningActivity(this.mOwner);
        goto L7
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        OActionDialog r2 = this.mMenuDialog;
        if (r2 != null) goto L8;
    L9:
        this.mCurSelected = (RunningState.MergedItem) parent.getAdapter().getItem(position);
        showItemMenu();
        return;
    L8:
        if (r2.isShowing() == false) goto L9;
    }

    private void showItemMenu() {
        if (this.mOwner != null) goto L5;
        return;
    L5:
        if (this.mCurSelected != null) goto L7;
        return;
    L7:
        if (this.mCleanState == CleanState.CLEANING) goto L22;
        OActionDialog r0 = this.mMenuDialog;
        if (r0 != null) goto L12;
    L14:
        final View r1 = LayoutInflater.from(getContext()).inflate(R.layout.running_process_action_dialog, null);
        OActionDialog.Modifier r2 = new OActionDialog.Modifier(getResources().getString(R.string.clean_process_choose_action_title), "", new AnonymousClass4(this, r1));
        this.mMenuDialog = new OActionDialog(getContext(), r2);
        OButton r3 = (OButton) r1.findViewById(R.id.btn_action_1);
        OButton r4 = (OButton) r1.findViewById(R.id.btn_action_2);
        OButton r5 = (OButton) r1.findViewById(R.id.btn_cancel);
        if (this.mCurSelected.mIsTaskPersist == false) goto L17;
        r3.setText(R.string.action_task_not_persist);
        r3.setOnClickListener(new RunningProcessesView$$ExternalSyntheticLambda1(this));
        r4.setVisibility(8);
    L18:
        r5.setOnClickListener(new RunningProcessesView$$ExternalSyntheticLambda4(this));
        this.mMenuDialog.show();
        return;
    L17:
        r3.setText(R.string.action_clean_memory);
        r3.setOnClickListener(new RunningProcessesView$$ExternalSyntheticLambda2(this));
        r4.setVisibility(0);
        r4.setText(R.string.memory_persist);
        r4.setOnClickListener(new RunningProcessesView$$ExternalSyntheticLambda3(this));
        goto L18
    L12:
        if (r0.isShowing() == false) goto L14;
        return;
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$0$com-bytedanceos-clearmemory-RunningProcessesView, reason: not valid java name */
    /* synthetic */ void m88x3919d9d8(View r1) {
        OActionDialog r2 = this.mMenuDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        updateTaskPersist(this.mCurSelected);
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$1$com-bytedanceos-clearmemory-RunningProcessesView, reason: not valid java name */
    /* synthetic */ void m89x2ac37ff7(View r2) {
        OActionDialog r3 = this.mMenuDialog;
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        this.mWorkHandler.post(new AnonymousClass5(this));
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$2$com-bytedanceos-clearmemory-RunningProcessesView, reason: not valid java name */
    /* synthetic */ void m90x1c6d2616(View r1) {
        OActionDialog r2 = this.mMenuDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        updateTaskPersist(this.mCurSelected);
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$3$com-bytedanceos-clearmemory-RunningProcessesView, reason: not valid java name */
    /* synthetic */ void m91xe16cc35(View r1) {
        OActionDialog r0 = this.mMenuDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean stopPackage(RunningState.MergedItem mi) {
        if (mi != null) goto L5;
        return false;
    L5:
        this.mHasClean = true;
        return RunningStateHelper.getInstance().stopPackage(mi, true);
    }

    private void showCleanToast(final RunningState.MergedItem curSelected) {
        Activity r0 = this.mOwner;
        if (r0 == null) goto L12;
        if (curSelected != null) goto L7;
        return;
    L7:
        if (r0.getResources().getConfiguration().locale.equals(Locale.ENGLISH) == false) goto L9;
        String r7 = getResources().getString(R.string.memory_has_clean_process, new Object[]{curSelected.mSizeStr, curSelected.mDisplayLabel});
    L10:
        Toast.makeText(getContext(), r7, 0).show();
        return;
    L9:
        r7 = getResources().getString(R.string.memory_has_clean_process, new Object[]{curSelected.mDisplayLabel, curSelected.mSizeStr});
        goto L10
    }

    private void updateTaskPersist(final RunningState.MergedItem mi) {
        if (mi != null) goto L4;
        return;
    L4:
        mi.mIsTaskPersist = !mi.mIsTaskPersist;
        AsyncTask.execute(new AnonymousClass6(this, mi));
        this.mAdapter.refresh();
        this.mAdapter.notifyDataSetChanged();
        if (mi.mIsTaskPersist == false) goto L29;
        Set<String> r0 = mMarkClearPackage.get(mi.mUserId, null);
        if (r0 != null) goto L10;
        r0 = new HashSet();
        mMarkClearPackage.put(mi.mUserId, r0);
    L10:
        if (r0.contains(mi.mPackageInfo.packageName) == false) goto L19;
        r0.remove(mi.mPackageInfo.packageName);
        Object r1 = this.mCleanSizeLock;
        monitor-enter(r1);
        this.mCleanSize -= mi.mMergeSize;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        Object r2 = this.mCleanSizeLock;
        monitor-enter(r2);
    L26:
        th = move-exception;
        throw th;
    L22:
        if (this.mCleanSize > 0) goto L24;
        this.mCleanSize = 0;     // Catch: Throwable -> L26
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L26
        Toast.makeText(getContext(), getResources().getString(R.string.app_persist_notice, new Object[]{mi.mDisplayLabel}), 0).show();
    L30:
        refreshCouldCleanSize();
        return;
    L29:
        Toast.makeText(getContext(), getResources().getString(R.string.app_not_persist_notice, new Object[]{mi.mDisplayLabel}), 0).show();
        goto L30
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        this.mActiveItems.remove(view);
    }

    public RunningProcessesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mActiveItems = new HashMap();
        this.mBuilder = new StringBuilder(128);
        this.mUpdateMemoryHeaderLayoutRunnable = new AnonymousClass1(this);
        this.mCurTotalRam = -1;
        this.mCurHighRam = -1;
        this.mCurMedRam = -1;
        this.mCurLowRam = -1;
        this.mCurShowCached = false;
        this.mCleanSizeLock = new Object();
        this.mCleanState = CleanState.IDLE;
        this.mMemInfoReader = new MemInfoReader();
        this.clearedItems = new HashSet();
        this.mHandler = new MyHandler(this);
        this.mListFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_MEMORY_CLEAN_RUNNING_LIST);
        this.mListFpsStarted = false;
        this.mOnCheckedChangeListener = new AnonymousClass2(this);
        this.mSlideListener = new AnonymousClass12(this);
        this.mMyUserId = UserHandle.myUserId();
    }

    public void doCreate() {
        LogTag.d(TAG, " doCreate ");
        removeAllViews();
        int r0 = getContext().getUserId();
        SparseArray<Set<String>> r1 = new SparseArray();
        mMarkClearPackage = r1;
        r1.put(r0, new HashSet());
        if (r0 != 0) goto L5;
        mMarkClearPackage.put(10, new HashSet());
    L5:
        SparseArray<Set<String>> r2 = new SparseArray();
        mHadChooseUnclear = r2;
        r2.put(r0, new HashSet());
        if (r0 != 0) goto L8;
        mHadChooseUnclear.put(10, new HashSet());
    L8:
        this.mState = RunningState.getInstance(getContext());
        this.mAm = (ActivityManager) getContext().getSystemService("activity");
        this.mIActivityManager = ActivityManagerNative.getDefault();
        LayoutInflater r3 = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (r3 != null) goto L11;
        return;
    L11:
        r3.inflate(R.layout.running_processes_view, this);
        View r4 = r3.inflate(R.layout.running_processes_header, null);
        this.mHeader = r4;
        this.mCleanSizeText = (TextView) r4.findViewById(R.id.selected_size);
        this.mMemoryHeaderContent = (ConstraintLayout) this.mHeader.findViewById(R.id.memory_header_content);
        this.mMemoryUnused = (TextView) this.mHeader.findViewById(R.id.scanning_size);
        this.mMemoryUnusedlUnit = (OTextView) this.mHeader.findViewById(R.id.tv_used_unit);
        this.mMemoryAvailableSize = (TextView) this.mHeader.findViewById(R.id.memory_available_size);
        this.mMemoryTotal = (TextView) this.mHeader.findViewById(R.id.tv_detail);
        MultiSegmentProgressBar r5 = (MultiSegmentProgressBar) this.mHeader.findViewById(R.id.storage_progress);
        this.mStorageProgress = r5;
        r5.setUseSegmentGap(true);
        this.mStorageProgress.setSegmentGap(2.0f);
        ConstraintLayout r6 = this.mMemoryHeaderContent;
        if (r6 == null) goto L14;
        r6.addOnLayoutChangeListener(new AnonymousClass7(this));
    L14:
        SlideListView r7 = (SlideListView) findViewById(R.id.list);
        this.mListView = r7;
        if (r7 == null) goto L17;
        r7.setDividerHeight(0);
    L17:
        ListViewScrollBarHelper.INSTANCE.adjustScrollBarVisibility(this.mListView, 3.0f);
        View r8 = r3.inflate(R.layout.running_process_list_footer_view_q, null);
        OCardListItem r9 = (OCardListItem) r8.findViewById(R.id.clear_process_bt);
        this.mClearButton = r9;
        r9.setCardType(2);
        OTextView r10 = new OTextView(getContext());
        this.mClearButtonText = r10;
        this.mClearButton.setCustomStartView(r10);
        this.mClearButtonText.setLayoutParams(new FrameLayout.LayoutParams(-1, OUnitExtensionKt.dp2px(48)));
        this.mClearButtonText.setText(R.string.memory_onestep_clean);
        this.mClearButtonText.setTextAppearance(R.style.Title_1_Medium);
        this.mClearButtonText.setTextColor(getContext().getColor(R.color.oui_accent_7_fg));
        this.mClearButtonText.setGravity(17);
        updateHeaderView();
        ServiceListAdapter r11 = new ServiceListAdapter(this, this.mState);
        this.mAdapter = r11;
        r11.refreshItems();
        SlideListView r12 = this.mListView;
        if (r12 == null) goto L20;
        r12.setRecyclerListener(this);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.addHeaderView(this.mHeader, null, false);
        this.mListView.addFooterView(r8, null, false);
        this.mListView.setSlideListener(this.mSlideListener);
        this.mListView.setOnScrollListener(new AnonymousClass8(this));
    L20:
        scheduleUpdateMemoryHeaderLayout();
        ListViewScrollBarHelper.INSTANCE.adjustScrollBarVisibility(this.mListView, 3.0f);
        this.mClearButton.setOnContentClickListener(new AnonymousClass9(this));
        OCardListItem r13 = (OCardListItem) findViewById(R.id.careful_clean);
        this.mCarefulClean = r13;
        r13.setCardType(0);
        this.mCarefulClean.setTitle(getContext().getString(R.string.memory_carful));
        this.mCarefulClean.setVisibility(8);
        this.mCarefulClean.setDefaultTailIcon(0);
        this.mCarefulClean.showTailIcon(true);
        OCardListItem r14 = this.mCarefulClean;
        if (r14 == null) goto L23;
        r14.setOnContentClickListener(new AnonymousClass10(this));
    L23:
        OCardListItem r15 = (OCardListItem) findViewById(R.id.persist_clean);
        this.mPersistClean = r15;
        r15.setTitle(getContext().getString(R.string.memory_persist));
        this.mPersistClean.setCardType(0);
        this.mPersistClean.setVisibility(8);
        this.mPersistClean.setDefaultTailIcon(0);
        this.mPersistClean.showTailIcon(true);
        cardPosion();
        OCardListItem r16 = this.mPersistClean;
        if (r16 == null) goto L26;
        r16.setOnContentClickListener(new AnonymousClass11(this));
    L26:
        View r17 = r8.findViewById(R.id.show_all_container);
        this.mShowAllContainer = r17;
        if (r17 == null) goto L29;
        this.dropdown = (ImageView) r17.findViewById(R.id.dropdown);
        final TextView r18 = (TextView) this.mShowAllContainer.findViewById(R.id.show_all_text);
        this.mShowAllContainer.setOnClickListener(new RunningProcessesView$$ExternalSyntheticLambda0(this, r18));
    L29:
        updateHeaderView();
        ActivityManager.MemoryInfo r19 = new ActivityManager.MemoryInfo();
        this.mAm.getMemoryInfo(r19);
        HandlerThread r20 = new HandlerThread("kill_process_thread");
        r20.start();
        this.mWorkHandler = new Handler(r20.getLooper());
    }

    /* JADX INFO: renamed from: lambda$doCreate$4$com-bytedanceos-clearmemory-RunningProcessesView, reason: not valid java name */
    /* synthetic */ void m87x8287b09c(TextView r2, View r3) {
        if (this.mAdapter != null) goto L5;
        return;
    L5:
        if (this.mCleanState == CleanState.CLEANING) goto L20;
        boolean r4 = !this.mAdapter.getCurrentShowAllStatus();
        this.mAdapter.setShowAll(r4);
        if (r4 == false) goto L12;
        this.dropdown.setRotation(180.0f);
        if (r2 == null) goto L17;
        r2.setText(R.string.common_collapse);
        return;
    L17:
        return;
    L12:
        this.dropdown.setRotation(0.0f);
        if (r2 == null) goto L19;
        r2.setText(R.string.common_expand_more);
        return;
    L19:
        return;
    }

    private void startListFps() {
        if (this.mListFpsStarted == false) goto L5;
        return;
    L5:
        this.mListFpsStarted = true;
        this.mListFpsSession.start();
    }

    private void stopListFps() {
        if (this.mListFpsStarted == true) goto L5;
        return;
    L5:
        this.mListFpsStarted = false;
        this.mListFpsSession.stop();
    }

    private void cardPosion() {
        if (this.mPersistClean.getVisibility() == 0) goto L5;
    L7:
        this.mCarefulClean.setCardPosition(0);
        this.mPersistClean.setCardPosition(0);
        return;
    L5:
        if (this.mCarefulClean.getVisibility() != 0) goto L7;
        this.mCarefulClean.setCardPosition(1);
        this.mPersistClean.setCardPosition(3);
    }

    private void clearSelectPackage() {
        if (this.mCleanState != CleanState.CLEANING) goto L5;
        return;
    L5:
        long r0 = this.mCleanSize;
        if (r0 <= 0) goto L8;
        this.mCleanState = CleanState.CLEANING;
        updateHeaderView();
        final ArrayList r2 = new ArrayList();
        JSONArray r3 = new JSONArray();
        Iterator<RunningState.MergedItem> r4 = this.mAdapter.mSuggestCleanItems.iterator();
    L14:
        if (r4.hasNext() == false) goto L25;
        RunningState.MergedItem r5 = r4.next();
        Set<String> r6 = mMarkClearPackage.get(r5.mUserId, null);
        if (r6 != null) goto L19;
        r6 = new HashSet();
        mMarkClearPackage.put(r5.mUserId, r6);
    L19:
        if (r6.contains(r5.mPackageInfo.packageName) == true) goto L20;
        if (r5.mIsTaskPersist == false) goto L14;
        r3.put(r5.mPackageInfo.packageName);
        goto L14
    L20:
        r2.add(r5);
        goto L14
    L25:
        if (r2.size() != this.mAdapter.mSuggestCleanItems.size()) goto L27;
        this.mCleaningAllPackage = true;
    L27:
        this.clearedItems.addAll(r2);
        AsyncTask.execute(new AnonymousClass13(this, r2));
        this.mWorkHandler.post(new AnonymousClass14(this, r2));
        trackCleanEvent(r3, r0);
        ClearProcessService.notifyClearProcessState(1);
        return;
    L8:
        if (this.mNotProcessClearToast != null) goto L10;
        this.mNotProcessClearToast = Toast.makeText(this.mOwner, R.string.has_not_process_clean, 0);
    L10:
        this.mNotProcessClearToast.show();
    }

    private void trackCleanEvent(JSONArray persistArray, long allCleanSize) {
        JSONObject r0 = new JSONObject();
        r0.put("resident", persistArray);     // Catch: JSONException -> L5
        r0.put("check", allCleanSize);     // Catch: JSONException -> L5
        long r6 = this.mCurTotalRam - this.mCurLowRam;     // Catch: JSONException -> L5
        r0.put("all", r6);     // Catch: JSONException -> L5
        r0.put("ram", this.mCurTotalRam);     // Catch: JSONException -> L5
        r0.put("check_ram_percent", this.mCleanSize / this.mCurTotalRam);     // Catch: JSONException -> L5
        r0.put("all_ram_percent", r6 / this.mCurTotalRam);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean hasClean() {
        return this.mHasClean;
    }

    public void doPause() {
        stopListFps();
        RunningState r0 = this.mState;
        if (r0 == null) goto L5;
        r0.unregistListener(this);
        this.mState.pause();
    L5:
        this.clearedItems.clear();
        this.mDataAvail = null;
        if (this.mCleanState == CleanState.IDLE) goto L9;
        this.mCleanState = CleanState.CLEANED;
        this.mHandler.sendEmptyMessageDelayed(5, 30000);
        return;
    }

    public void doDestroy() {
        stopListFps();
        RunningStateHelper.getInstance().doDestroy();
        SparseArray<Set<String>> r0 = mMarkClearPackage;
        if (r0 == null) goto L7;
        int r1 = r0.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        mMarkClearPackage.valueAt(r2).clear();
        r2 = r2 + 1;
    L7:
        SparseArray<Set<String>> r3 = mHadChooseUnclear;
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        if (this.mCleanState != CleanState.CLEANING) goto L13;
        this.mHandler.sendEmptyMessage(4);
    L14:
        Handler r4 = this.mWorkHandler;
        if (r4 == null) goto L19;
        r4.removeCallbacksAndMessages(null);
        return;
    L19:
        return;
    L13:
        this.mHandler.removeCallbacksAndMessages(null);
        goto L14
    }

    public boolean doResume(Activity owner, Runnable dataAvail) {
        this.mOwner = owner;
        this.mAppsRunningViewModel = ApplicationsRunningViewModel.Companion.getManagerApplicationsRunningActivity(owner);
        RunningState r2 = this.mState;
        if (r2 == null) goto L5;
        r2.registListener(this);
        this.mState.resume();
        this.mState.updateNow();
    L5:
        this.mHandler.removeMessages(5);
        if (this.mCleanState != CleanState.CLEANED) goto L8;
        this.mCleanState = CleanState.IDLE;
        updateHeaderView();
    L8:
        OActionDialog r3 = this.mMenuDialog;
        if (r3 != null) goto L11;
    L13:
        this.mDataAvail = dataAvail;
        return false;
    L11:
        if (r3.isShowing() == false) goto L13;
        this.mMenuDialog.dismiss();
        this.mCurSelected = null;
        goto L13
    }

    public void clearMergedItems() {
        RunningState r0 = this.mState;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.clearCurrentMergedItems();
    }

    @Override // com.bytedanceos.clearmemory.RunningState.OnRefreshUiListener
    public void onRefreshUi(int what) {
        if (what != 0) goto L4;
        updateTimes();
        return;
    L4:
        if (what != 1) goto L6;
        refreshUi(false);
        updateTimes();
        return;
    L6:
        if (what != 2) goto L14;
        refreshUi(true);
        updateTimes();
        return;
    }

    private List<RunningState.MergedItem> mergeRunningState(ArrayList<RunningState.MergedItem> mergedItems) {
        long r0 = 0;
        this.mCleanSize = 0;
        ArrayList r2 = new ArrayList();
        if (mergedItems.size() != 0) goto L5;
        return r2;
    L5:
        List<RunningState.MergedItem> r11 = RunningStateHelper.getInstance().mergedPackages(mergedItems);
        boolean r3 = false;
        if (r11 == null) goto L28;
        Iterator<RunningState.MergedItem> r12 = r11.iterator();
        long r4 = 0;
    L9:
        if (r12.hasNext() == false) goto L27;
        RunningState.MergedItem r6 = r12.next();
        r6.updateMergeSizeString(getContext());
        r6.enSureTaskPersist(getContext().getPackageManager());
        if (r6.mMergeSize <= 0) goto L9;
        RunningState.MergedItem r7 = this.mCurSelected;
        if (r7 == null) goto L22;
        if (r3 == true) goto L22;
        if (r7.mPackageInfo.packageName.equals(r6.mPackageInfo.packageName) == false) goto L22;
        if (this.mCurSelected.mPackageInfo.uid != r6.mPackageInfo.uid) goto L22;
        this.mCurSelected = r6;
        r3 = true;
    L22:
        if (r6.mIsTaskPersist == false) goto L24;
    L26:
        r2.add(r6);
        goto L9
    L24:
        if (mMarkClearPackage.get(r6.mUserId, Collections.emptySet()).contains(r6.mPackageInfo.packageName) == false) goto L26;
        r4 = r4 + r6.mMergeSize;
        goto L26
    L27:
        r0 = r4;
    L28:
        if (r3 == true) goto L35;
        OActionDialog r13 = this.mMenuDialog;
        if (r13 != null) goto L32;
    L34:
        this.mCurSelected = null;
        goto L35
    L32:
        if (r13.isShowing() == false) goto L34;
        this.mMenuDialog.dismiss();
    L35:
        this.mCleanSize = r0;
        return r2;
    }
}
