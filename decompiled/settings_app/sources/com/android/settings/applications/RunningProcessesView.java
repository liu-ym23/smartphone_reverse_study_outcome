package com.android.settings.applications;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.app.IActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.Vibrator;
import android.text.BidiFormatter;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateYAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bytedanceos.api.VibratorSmt;
import com.android.internal.util.MemInfoReader;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import obric.app.OMenuDialog;
import obric.app.OMenuDialogListAdapter;
import obric.widget.ListContentItemText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RunningProcessesView extends FrameLayout implements AdapterView.OnItemClickListener, AbsListView.RecyclerListener, RunningState.OnRefreshUiListener {
    private static final int CLEAN_ALL_DONE = 4;
    public static final String RECORDER_PACKAGE = "com.obric.recorder";
    private static final int REFRESH_CLEAN_SIZE = 3;
    private static final int RESET_CLEANING_FLAG = 2;
    private static final int RESET_CLEAN_STATE = 5;
    private static final int RESET_CLEAN_STATE_INTERVAL = 30000;
    public static final String TAG = "RunningProcessesView";
    private static final int UPDATE_CLEAN_PROGRESS = 1;
    private static SparseArray<Set<String>> mMarkClearPackage;
    long SECONDARY_SERVER_MEM;
    final HashMap<View, ActiveItem> mActiveItems;
    ServiceListAdapter mAdapter;
    ActivityManager mAm;
    StringBuilder mBuilder;
    private AlertDialog mCleanAllDialog;
    private ImageView mCleanDoneImg;
    private TextView mCleanDoneText;
    private volatile long mCleanSize;
    private final Object mCleanSizeLock;
    private TextView mCleanSizeText;
    private TextView mCleanSizeUnit;
    private CleanState mCleanState;
    private boolean mCleaningAllPackage;
    private OButton mClearButton;
    long mCurHighRam;
    long mCurLowRam;
    long mCurMedRam;
    private RunningState.MergedItem mCurSelected;
    boolean mCurShowCached;
    long mCurTotalRam;
    Runnable mDataAvail;
    private SparseArray<Set<String>> mHadChooseUnclear;
    private MyHandler mHandler;
    private View mHeader;
    IActivityManager mIActivityManager;
    private long mLastCleanTime;
    MemInfoReader mMemInfoReader;
    private OMenuDialog mMenuDialog;
    final int mMyUserId;
    private boolean mNeedSaveCleanTime;
    private View.OnClickListener mOnClickListener;
    Activity mOwner;
    private LinearLayout mSelectedContain;
    private TextView mSelectedTip;
    RunningState mState;
    private TextView mUsedTotalSizeText;
    private Handler mWorkHandler;

    /* JADX INFO: renamed from: com.android.settings.applications.RunningProcessesView$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ RunningProcessesView this$0;

        AnonymousClass4(RunningProcessesView r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            RunningProcessesView.access$2300(this.this$0).post(new AnonymousClass1(this));
        }
    }

    public static class ActiveItem {
        long mFirstRunTime;
        ViewHolder mHolder;
        RunningState.BaseItem mItem;
        View mRootView;
        ActivityManager.RunningServiceInfo mService;
        boolean mSetBackground;

        public ActiveItem() {
        }

        void updateTime(Context r9, StringBuilder r10) {
            RunningState.BaseItem r0 = this.mItem;
            boolean r2 = true;
            if ((r0 instanceof RunningState.ServiceItem) == false) goto L6;
            TextView r1 = this.mHolder.size;
        L21:
            if (r1 == null) goto L36;
            boolean r3 = false;
            this.mSetBackground = false;
            if (this.mFirstRunTime < 0) goto L25;
            r1.setText(DateUtils.formatElapsedTime(r10, (SystemClock.elapsedRealtime() - this.mFirstRunTime) / 1000));
            return;
        L25:
            RunningState.BaseItem r8 = this.mItem;
            if ((r8 instanceof RunningState.MergedItem) == true) goto L28;
        L32:
            if (r3 == false) goto L34;
            r1.setText(r9.getResources().getText(R.string.service_restarting));
            return;
        L34:
            r1.setText("");
            return;
        L28:
            if (((RunningState.MergedItem) r8).mServices.size() > 0) goto L31;
            r2 = false;
        L31:
            r3 = r2;
            goto L32
        L36:
            return;
        L6:
            if (r0.mSizeStr == null) goto L8;
            String r4 = this.mItem.mSizeStr;
        L10:
            if (r4.equals(this.mItem.mCurSizeStr) == true) goto L13;
            this.mItem.mCurSizeStr = r4;
            this.mHolder.size.setText(r4);
        L13:
            if (this.mItem.mBackground == false) goto L18;
            if (this.mSetBackground == true) goto L20;
            this.mSetBackground = true;
            this.mHolder.uptime.setText("");
        L20:
            r1 = null;
            goto L21
        L18:
            if ((this.mItem instanceof RunningState.MergedItem) == false) goto L20;
            r1 = this.mHolder.uptime;
            goto L21
        L8:
            r4 = "";
            goto L10
        }
    }

    static final enum CleanState extends Enum<CleanState> {
        private static final /* synthetic */ CleanState[] $VALUES = null;
        public static final CleanState CLEANED = null;
        public static final CleanState CLEANING = null;
        public static final CleanState IDLE = null;

        private static /* synthetic */ CleanState[] $values() {
            return new CleanState[]{IDLE, CLEANING, CLEANED};
        }

        private CleanState(String r1, int r2) {
            super(r1, r2);
        }

        public static CleanState valueOf(String r1) {
            return (CleanState) Enum.valueOf(CleanState.class, r1);
        }

        public static CleanState[] values() {
            return (CleanState[]) $VALUES.clone();
        }

        static {
            IDLE = new CleanState("IDLE", 0);
            CLEANING = new CleanState("CLEANING", 1);
            CLEANED = new CleanState("CLEANED", 2);
            $VALUES = $values();
        }
    }

    private static class MyHandler extends Handler {
        WeakReference<RunningProcessesView> mReference;

        MyHandler(RunningProcessesView r2) {
            this.mReference = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            RunningProcessesView r0 = this.mReference.get();
            if (r0 != null) goto L5;
            return;
        L5:
            int r8 = r7.what;
            if (r8 != 2) goto L8;
            RunningProcessesView.access$002(r0, false);
            return;
        L8:
            if (r8 == 3) goto L15;
            if (r8 != 4) goto L11;
            RunningProcessesView.access$402(r0, CleanState.CLEANED);
            RunningProcessesView.access$502(r0, true);
            RunningProcessesView.access$600(r0, true);
            RunningProcessesView.access$702(r0, SystemClock.elapsedRealtime());
            ClearProcessService.saveCleanTime(RunningProcessesView.access$800(r0), RunningProcessesView.access$700(r0));
            removeCallbacksAndMessages(null);
            return;
        L11:
            if (r8 != 5) goto L24;
            OLog.d(RunningProcessesView.TAG, " handler msg RESET_CLEAN_STATE mCleanState = " + RunningProcessesView.access$400(r0));
            RunningProcessesView.access$402(r0, CleanState.IDLE);
            RunningProcessesView.access$600(r0, false);
            return;
        L24:
            return;
        L15:
            RunningProcessesView.access$100(r0);
            if (RunningProcessesView.access$200(r0) != 0) goto L22;
            r0.mAdapter.refreshItems(Collections.emptyList());
            r0.mAdapter.notifyDataSetChanged();
            RunningProcessesView.access$300(r0);
            sendEmptyMessage(4);
            return;
        }
    }

    class ServiceListAdapter extends BaseAdapter {
        private static final int TYPE_ITEM = 0;
        private static final int TYPE_ITEM_HEADER = 1;
        int mClearCount;
        final LayoutInflater mInflater;
        final List<RunningState.MergedItem> mItems;
        int mNotClearCount;
        ArrayList<RunningState.MergedItem> mOrigItems;
        int mPersistCount;
        boolean mShowBackground;
        final Comparator<RunningState.MergedItem> mSizeComparator;
        final RunningState mState;
        final /* synthetic */ RunningProcessesView this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        ServiceListAdapter(RunningProcessesView r2, RunningState r3) {
            this.this$0 = r2;
            this.mItems = new ArrayList();
            this.mClearCount = 0;
            this.mNotClearCount = 0;
            this.mPersistCount = 0;
            this.mSizeComparator = new AnonymousClass1(this);
            this.mState = r3;
            this.mInflater = (LayoutInflater) r2.getContext().getSystemService("layout_inflater");
            refreshItems();
        }

        void setShowBackground(boolean r2) {
            if (this.mShowBackground == r2) goto L6;
            this.mShowBackground = r2;
            this.mState.setWatchingBackgroundItems(r2);
            refreshItems();
            this.this$0.refreshUi(true);
            return;
        }

        boolean getShowBackground() {
            return this.mShowBackground;
        }

        void refreshItems() {
            refreshItems(RunningProcessesView.access$1100(this.this$0, this.mState.getCurrentMergedItems()));
        }

        void refreshItems(List<RunningState.MergedItem> r3) {
            this.mItems.clear();
            if (RunningProcessesView.access$400(this.this$0) != CleanState.CLEANED) goto L5;
            r3 = Collections.emptyList();
        L5:
            this.mItems.addAll(r3);
            refresh();
            RunningProcessesView.access$100(this.this$0);
        }

        public void refresh() {
            this.mPersistCount = 0;
            this.mClearCount = 0;
            this.mNotClearCount = 0;
            Collections.sort(this.mItems, this.mSizeComparator);
            Iterator<RunningState.MergedItem> r0 = this.mItems.iterator();
        L4:
            if (r0.hasNext() == false) goto L29;
            RunningState.MergedItem r1 = r0.next();
            if (r1.mIsTaskPersist == true) goto L7;
            if (r1.mIsRecommendClear == true) goto L10;
            this.mNotClearCount++;
            goto L4
        L10:
            this.mClearCount++;
            Set r2 = (Set) RunningProcessesView.access$1200(this.this$0).get(r1.mUserId, null);
            if (r2 != null) goto L13;
            r2 = new HashSet();
            RunningProcessesView.access$1200(this.this$0).put(r1.mUserId, r2);
        L13:
            Set r3 = (Set) RunningProcessesView.access$900().get(r1.mUserId, null);
            if (r3 != null) goto L17;
            r3 = new HashSet();
            RunningProcessesView.access$900().put(r1.mUserId, r3);
        L17:
            if (r2.contains(r1.mPackageInfo.packageName) == true) goto L4;
            if (r3.add(r1.mPackageInfo.packageName) == false) goto L4;
            Object r4 = RunningProcessesView.access$1000(this.this$0);
            monitor-enter(r4);
            RunningProcessesView.access$214(this.this$0, r1.mMergeSize);     // Catch: Throwable -> L25
            monitor-exit(r4);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        L7:
            this.mPersistCount++;
            goto L4
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mItems.size();
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
        public Object getItem(int r1) {
            return this.mItems.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return getItem(r1).hashCode();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r2) {
            if (r2 == 0) goto L10;
            int r0 = this.mClearCount;
            if (r2 != r0) goto L6;
            return 1;
        L6:
            if (r2 == (r0 + this.mNotClearCount)) goto L13;
            return 0;
        L13:
            return 1;
        L10:
            return 1;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return !((RunningState.MergedItem) getItem(r1)).mIsProcess;
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            int r0 = getItemViewType(r2);
            if (r3 != null) goto L5;
            r3 = newView(r4, r0);
        L5:
            bindView(r3, r2);
            View r5 = r3.findViewById(R.id.processes_item);
            if (r5 == null) goto L8;
            setBackgroundRes(r2, (ListContentItemText) r5);
        L8:
            return r3;
        }

        private void setBackgroundRes(int r8, ListContentItemText r9) {
            if (r9 != null) goto L4;
            return;
        L4:
            int r0 = ((View) r9.getParent()).getPaddingLeft();
            int r1 = Utils.dp2Pixels(this.this$0.getContext(), this.this$0.getResources().getDimension(R.dimen.running_process_list_item_padding_bottom));
            if (getCount() == 1) goto L35;
            int r2 = this.mClearCount;
            if (r2 == 1) goto L9;
        L10:
            int r5 = this.mNotClearCount;
            if (r5 != 1) goto L15;
            if (r8 == ((r2 + r5) - 1)) goto L35;
        L15:
            if (this.mPersistCount == 1) goto L17;
        L19:
            if (r8 == 0) goto L34;
            int r3 = this.mClearCount;
            if (r8 == r3) goto L34;
            int r6 = this.mNotClearCount;
            if (r8 == (r3 + r6)) goto L34;
            if (r8 != (r3 - 1)) goto L28;
        L33:
            ((View) r9.getParent()).setPadding(r0, 0, r0, r1);
            r9.setBackgroundStyle(4);
            return;
        L28:
            if (r8 == ((r3 + r6) - 1)) goto L33;
            if (r8 == (getCount() - 1)) goto L33;
            ((View) r9.getParent()).setPadding(r0, 0, r0, 0);
            r9.setBackgroundStyle(3);
            return;
        L34:
            ((View) r9.getParent()).setPadding(r0, 0, r0, 0);
            r9.setBackgroundStyle(2);
            return;
        L17:
            if (r8 != (getCount() - 1)) goto L19;
        L9:
            if (r8 != (r2 - 1)) goto L10;
        L35:
            ((View) r9.getParent()).setPadding(r0, 0, r0, r1);
            r9.setBackgroundStyle(1);
        }

        public View newView(ViewGroup r3, int r4) {
            if (r4 != 1) goto L5;
            View r5 = this.mInflater.inflate(R.layout.running_processes_item_header, r3, false);
        L6:
            new ViewHolder(r5).cb.setOnClickListener(RunningProcessesView.access$1300(this.this$0));
            return r5;
        L5:
            r5 = this.mInflater.inflate(R.layout.running_processes_item, r3, false);
            goto L6
        }

        public void bindView(View r5, int r6) {
            Object r0 = this.mState.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (r6 < this.mItems.size()) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L8:
            ViewHolder r1 = (ViewHolder) r5.getTag();     // Catch: Throwable -> L11
            RunningState.MergedItem r7 = (RunningState.MergedItem) getItem(r6);     // Catch: Throwable -> L11
            ActiveItem r8 = r1.bind(this.mState, r7, this.this$0.mBuilder);     // Catch: Throwable -> L11
            this.this$0.mActiveItems.put(r5, r8);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
        }
    }

    static class TimeTicker extends TextView {
        public TimeTicker(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public static class ViewHolder {
        public static final int NAME_MAX_WIDTH = 580;
        public static final int NAME_MAX_WIDTH_PERSIST = 470;
        public TextView categoryTitle;
        public CheckedTextView cb;
        public TextView description;
        public View gapView;
        public ImageView icon;
        public TextView name;
        public ImageView persist;
        public View rootView;
        public TextView size;
        public TextView uptime;

        public ViewHolder(View r2) {
            this.rootView = r2;
            this.icon = (ImageView) r2.findViewById(R.id.icon);
            this.name = (TextView) r2.findViewById(R.id.name);
            this.size = (TextView) r2.findViewById(R.id.size);
            this.persist = (ImageView) r2.findViewById(R.id.task_persist);
            this.gapView = r2.findViewById(R.id.process_item_gap);
            View r0 = r2.findViewById(R.id.category_title);
            if (r0 == null) goto L5;
            this.categoryTitle = (TextView) r0;
        L5:
            this.cb = (CheckedTextView) r2.findViewById(R.id.processes_item_cb);
            r2.setTag(this);
        }

        public ActiveItem bind(RunningState r5, RunningState.BaseItem r6, StringBuilder r7) {
            Object r8 = r5.mLock;
            monitor-enter(r8);
            Context r0 = this.rootView.getContext();     // Catch: Throwable -> L30
            if (r6.mPackageInfo == null) goto L7;
        L11:
            this.name.setText(r6.mDisplayLabel);     // Catch: Throwable -> L30
            ActiveItem r1 = new ActiveItem();     // Catch: Throwable -> L30
            r1.mRootView = this.rootView;     // Catch: Throwable -> L30
            r1.mItem = r6;     // Catch: Throwable -> L30
            r1.mHolder = this;     // Catch: Throwable -> L30
            r1.mFirstRunTime = r6.mActiveSince;     // Catch: Throwable -> L30
            r6.mCurSizeStr = null;     // Catch: Throwable -> L30
            this.icon.setImageDrawable(r6.loadIcon(r0, r5));     // Catch: Throwable -> L30
            this.icon.setVisibility(0);     // Catch: Throwable -> L30
            this.size.setText(r6.mSizeStr);     // Catch: Throwable -> L30
            this.cb.setTag(r6);     // Catch: Throwable -> L30
            if ((r6 instanceof RunningState.MergedItem) == false) goto L20;
            if (((RunningState.MergedItem) r6).mIsTaskPersist == false) goto L17;
            this.persist.setVisibility(0);     // Catch: Throwable -> L30
            this.cb.setVisibility(4);     // Catch: Throwable -> L30
            goto L20
        L17:
            if (r6.mPackageInfo == null) goto L20;
            this.persist.setVisibility(4);     // Catch: Throwable -> L30
            this.cb.setVisibility(0);     // Catch: Throwable -> L30
            Set r9 = Collections.emptySet();     // Catch: Throwable -> L30
            Set r10 = (Set) RunningProcessesView.access$900().get(r6.mUserId, r9);     // Catch: Throwable -> L30
            this.cb.setChecked(r10.contains(r6.mPackageInfo.packageName));     // Catch: Throwable -> L30
        L20:
            if (this.categoryTitle != null) goto L22;
        L28:
            monitor-exit(r8);     // Catch: Throwable -> L30
            return r1;
        L22:
            if (r6.mIsTaskPersist == false) goto L25;
            this.categoryTitle.setText(r0.getString(R.string.persist_tips));     // Catch: Throwable -> L30
            goto L28
        L25:
            if (r6.mIsRecommendClear == false) goto L27;
            this.categoryTitle.setText(r0.getString(R.string.recommend_clear_tips));     // Catch: Throwable -> L30
            goto L28
        L27:
            this.categoryTitle.setText(r0.getString(R.string.careful_clear_tips));     // Catch: Throwable -> L30
            goto L28
        L7:
            if ((r6 instanceof RunningState.MergedItem) == false) goto L11;
            if (((RunningState.MergedItem) r6).mProcess == null) goto L11;
            PackageManager r2 = r0.getPackageManager();     // Catch: Throwable -> L30
            ((RunningState.MergedItem) r6).mProcess.ensureLabel(r2);     // Catch: Throwable -> L30
            r6.mPackageInfo = ((RunningState.MergedItem) r6).mProcess.mPackageInfo;     // Catch: Throwable -> L30
            r6.mDisplayLabel = ((RunningState.MergedItem) r6).mProcess.mDisplayLabel;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
        }
    }

    void updateTimes() {
    }

    static /* synthetic */ boolean access$002(RunningProcessesView r0, boolean r1) {
        r0.mCleaningAllPackage = r1;
        return r1;
    }

    static /* synthetic */ void access$100(RunningProcessesView r0) {
        r0.refreshCouldCleanSize();
    }

    static /* synthetic */ Object access$1000(RunningProcessesView r0) {
        return r0.mCleanSizeLock;
    }

    static /* synthetic */ List access$1100(RunningProcessesView r0, ArrayList r1) {
        return r0.mergeRunningState(r1);
    }

    static /* synthetic */ SparseArray access$1200(RunningProcessesView r0) {
        return r0.mHadChooseUnclear;
    }

    static /* synthetic */ View.OnClickListener access$1300(RunningProcessesView r0) {
        return r0.mOnClickListener;
    }

    static /* synthetic */ TextView access$1400(RunningProcessesView r0) {
        return r0.mCleanSizeText;
    }

    static /* synthetic */ TextView access$1500(RunningProcessesView r0) {
        return r0.mCleanSizeUnit;
    }

    static /* synthetic */ TextView access$1600(RunningProcessesView r0) {
        return r0.mSelectedTip;
    }

    static /* synthetic */ TextView access$1700(RunningProcessesView r0) {
        return r0.mUsedTotalSizeText;
    }

    static /* synthetic */ RunningState.MergedItem access$1800(RunningProcessesView r0) {
        return r0.mCurSelected;
    }

    static /* synthetic */ void access$1900(RunningProcessesView r0, RunningState.MergedItem r1, PackageManager r2) {
        r0.updateTaskPersist(r1, r2);
    }

    static /* synthetic */ long access$200(RunningProcessesView r2) {
        return r2.mCleanSize;
    }

    static /* synthetic */ boolean access$2000(RunningProcessesView r0, RunningState.MergedItem r1) {
        return r0.stopPackage(r1);
    }

    static /* synthetic */ long access$202(RunningProcessesView r0, long r1) {
        r0.mCleanSize = r1;
        return r1;
    }

    static /* synthetic */ void access$2100(RunningProcessesView r0, RunningState.MergedItem r1) {
        r0.showCleanToast(r1);
    }

    static /* synthetic */ long access$214(RunningProcessesView r2, long r3) {
        long r0 = r2.mCleanSize + r3;
        r2.mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ MyHandler access$2200(RunningProcessesView r0) {
        return r0.mHandler;
    }

    static /* synthetic */ long access$222(RunningProcessesView r2, long r3) {
        long r0 = r2.mCleanSize - r3;
        r2.mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ Handler access$2300(RunningProcessesView r0) {
        return r0.mWorkHandler;
    }

    static /* synthetic */ void access$2400(RunningProcessesView r0) {
        r0.clearSelectPackage();
    }

    static /* synthetic */ void access$300(RunningProcessesView r0) {
        r0.vibrate();
    }

    static /* synthetic */ CleanState access$400(RunningProcessesView r0) {
        return r0.mCleanState;
    }

    static /* synthetic */ CleanState access$402(RunningProcessesView r0, CleanState r1) {
        r0.mCleanState = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(RunningProcessesView r0, boolean r1) {
        r0.mNeedSaveCleanTime = r1;
        return r1;
    }

    static /* synthetic */ void access$600(RunningProcessesView r0, boolean r1) {
        r0.updateHeaderView(r1);
    }

    static /* synthetic */ long access$700(RunningProcessesView r2) {
        return r2.mLastCleanTime;
    }

    static /* synthetic */ long access$702(RunningProcessesView r0, long r1) {
        r0.mLastCleanTime = r1;
        return r1;
    }

    static /* synthetic */ Context access$800(RunningProcessesView r0) {
        return r0.mContext;
    }

    static /* synthetic */ SparseArray access$900() {
        return mMarkClearPackage;
    }

    void refreshUi(boolean r3) {
        if (this.mCleanState == CleanState.IDLE) goto L6;
        return;
    L6:
        if (this.mCleaningAllPackage == false) goto L8;
        return;
    L8:
        if (r3 == false) goto L10;
        ServiceListAdapter r4 = this.mAdapter;
        r4.refreshItems();
        r4.notifyDataSetChanged();
    L10:
        Runnable r5 = this.mDataAvail;
        if (r5 == null) goto L13;
        r5.run();
        this.mDataAvail = null;
    L13:
        refreshCouldCleanSize();
        refreshMemorySize();
    }

    private void refreshMemorySize() {
        this.mMemInfoReader.readMemInfo();
        Object r1 = this.mState.mLock;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurShowCached == this.mAdapter.mShowBackground) goto L7;
        this.mCurShowCached = this.mAdapter.mShowBackground;     // Catch: Throwable -> L22
    L7:
        long r2 = this.mMemInfoReader.getTotalSize();     // Catch: Throwable -> L22
        if (this.mCurShowCached == false) goto L10;
        long r4 = this.mMemInfoReader.getFreeSize() + this.mMemInfoReader.getCachedSize();     // Catch: Throwable -> L22
        long r6 = this.mState.mBackgroundProcessMemory;     // Catch: Throwable -> L22
    L11:
        long r8 = (r2 - r6) - r4;     // Catch: Throwable -> L22
        if (this.mCurTotalRam == r2) goto L14;
    L19:
        this.mCurTotalRam = r2;     // Catch: Throwable -> L22
        this.mCurHighRam = r8;     // Catch: Throwable -> L22
        this.mCurMedRam = r6;     // Catch: Throwable -> L22
        this.mCurLowRam = r4;     // Catch: Throwable -> L22
        BidiFormatter r7 = BidiFormatter.getInstance();     // Catch: Throwable -> L22
        String r9 = Formatter.formatShortFileSize(getContext(), r4);     // Catch: Throwable -> L22
        OLog.i(TAG, "freeStr " + r9 + " size " + r4 + " totalRam " + r2);     // Catch: Throwable -> L22
        r7.unicodeWrap(r9);     // Catch: Throwable -> L22
        String r0 = r7.unicodeWrap(Formatter.formatShortFileSize(getContext(), r2 - r4));     // Catch: Throwable -> L22
        this.mUsedTotalSizeText.setText(new StringBuilder(getResources().getString(R.string.running_processes_header_memory_used_prefix)).append(r0).append(LibrarianImpl.Constants.SEPARATOR).append(((r2 >> 30) + 1) + " GB").toString());     // Catch: Throwable -> L22
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L14:
        if (this.mCurHighRam != r8) goto L19;
        if (this.mCurMedRam != r6) goto L19;
        if (this.mCurLowRam == r4) goto L20;
    L10:
        r4 = (this.mMemInfoReader.getFreeSize() + this.mMemInfoReader.getCachedSize()) + this.mState.mBackgroundProcessMemory;     // Catch: Throwable -> L22
        r6 = this.mState.mServiceProcessMemory;     // Catch: Throwable -> L22
        goto L11
    }

    private void refreshCouldCleanSize() {
        long r0 = this.mCleanSize;
        if (r0 >= 0) goto L6;
        OLog.e(TAG, "clear size error " + this.mCleanSize);
        r0 = 0;
    L6:
        if (this.mCleanSizeText != null) goto L8;
        return;
    L8:
        Formatter.BytesResult r1 = Formatter.formatBytes(getContext().getResources(), r0, 1);
        this.mCleanSizeText.setText(r1.value);
        this.mCleanSizeUnit.setText(r1.units);
    }

    private void updateHeaderView(boolean r18) {
        OLog.d(TAG, " updateHeaderView mCleanState = " + this.mCleanState + ", anim = " + r18);
        if (this.mCleanState != CleanState.CLEANED) goto L8;
        if (r18 == false) goto L6;
        AnimationSet r1 = new AnimationSet(false);
        ScaleAnimation r2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation r3 = new AlphaAnimation(0.1f, 1.0f);
        r2.setDuration(500);
        r3.setDuration(500);
        r1.addAnimation(r2);
        r1.addAnimation(r3);
        r1.setStartTime(500);
        this.mCleanDoneImg.startAnimation(r1);
        AlphaAnimation r4 = new AlphaAnimation(1.0f, 0.0f);
        r4.setDuration(500);
        r4.setAnimationListener(new AnonymousClass2(this));
        this.mCleanSizeText.startAnimation(r4);
        this.mCleanSizeUnit.startAnimation(r4);
        this.mSelectedTip.startAnimation(r4);
        this.mUsedTotalSizeText.startAnimation(r4);
        AlphaAnimation r5 = new AlphaAnimation(0.0f, 1.0f);
        r5.setDuration(500);
        r5.setFillAfter(true);
        Animation r6 = new TranslateYAnimation(-19.0f, 0.0f);
        r6.setDuration(500);
        r6.setFillAfter(true);
        AnimationSet r7 = new AnimationSet(false);
        r7.addAnimation(r6);
        r7.addAnimation(r5);
        this.mCleanDoneText.setText(getResources().getString(R.string.clean_processes_done));
        this.mCleanDoneText.startAnimation(r7);
    L7:
        this.mCleanDoneText.setVisibility(0);
        this.mCleanDoneImg.setVisibility(0);
        this.mClearButton.setText(getResources().getString(R.string.done));
        this.mClearButton.setEnabled(true);
        return;
    L6:
        OLog.d(TAG, " updateHeaderView had_clean_processes ");
        this.mCleanDoneText.setText(getResources().getString(R.string.had_clean_processes));
        this.mCleanSizeText.setVisibility(4);
        this.mCleanSizeUnit.setVisibility(4);
        this.mSelectedTip.setVisibility(4);
        this.mUsedTotalSizeText.setVisibility(4);
        goto L7
    L8:
        OLog.d(TAG, " updateHeaderView else  mCleanState = " + this.mCleanState);
        this.mCleanDoneText.setVisibility(4);
        this.mCleanDoneImg.setVisibility(4);
        this.mCleanSizeText.setVisibility(0);
        this.mCleanSizeUnit.setVisibility(0);
        this.mSelectedTip.setVisibility(0);
        this.mUsedTotalSizeText.setVisibility(0);
        this.mClearButton.setText(getResources().getString(R.string.action_clean));
        this.mClearButton.setEnabled(true);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        OMenuDialog r5 = this.mMenuDialog;
        if (r5 != null) goto L5;
    L6:
        this.mCurSelected = (RunningState.MergedItem) r1.getAdapter().getItem(r3);
        showItemMenu();
        return;
    L5:
        if (r5.isShowing() == false) goto L6;
    }

    private void showItemMenu() {
        if (this.mOwner != null) goto L5;
        return;
    L5:
        if (this.mCurSelected != null) goto L7;
        return;
    L7:
        if (this.mCleanState == CleanState.CLEANING) goto L20;
        ArrayList r0 = new ArrayList(2);
        if (this.mCurSelected.mIsTaskPersist == false) goto L12;
        r0.add(getResources().getString(R.string.action_task_not_persist));
    L13:
        OMenuDialog r2 = new OMenuDialog(this.mOwner);
        this.mMenuDialog = r2;
        r2.setTitle(R.string.clean_process_choose_action_title);
        ArrayList r3 = new ArrayList(2);
        r3.add(new AnonymousClass3(this));
        if (this.mCurSelected.mIsTaskPersist == true) goto L16;
        r3.add(0, new AnonymousClass4(this));
    L16:
        OMenuDialogListAdapter r1 = new OMenuDialogListAdapter(getContext(), r0, r3);
        this.mMenuDialog.setAdapter(r1);
        this.mMenuDialog.show();
        return;
    L12:
        String r4 = getResources().getString(R.string.action_task_persist);
        r0.add(getResources().getString(R.string.action_clean_memory));
        r0.add(r4);
        goto L13
    }

    private boolean stopPackage(RunningState.MergedItem r2) {
        return RunningStateHelper.getInstance().stopPackage(r2, true);
    }

    private void showCleanToast(RunningState.MergedItem r7) {
        Activity r0 = this.mOwner;
        if (r0 == null) goto L12;
        if (r7 != null) goto L7;
        return;
    L7:
        if (r0.getResources().getConfiguration().locale.equals(Locale.ENGLISH) == false) goto L9;
        String r8 = getResources().getString(R.string.memory_has_clean_process, new Object[]{r7.mSizeStr, r7.mDisplayLabel});
    L10:
        ToastUtils.showInView(getContext(), r8);
        return;
    L9:
        r8 = getResources().getString(R.string.memory_has_clean_process, new Object[]{r7.mDisplayLabel, r7.mSizeStr});
        goto L10
    }

    private void updateTaskPersist(final RunningState.MergedItem r7, final PackageManager r8) {
        r7.mIsTaskPersist = !r7.mIsTaskPersist;
        AsyncTask.execute(new AnonymousClass5(this, r8, r7));
        this.mAdapter.refresh();
        this.mAdapter.notifyDataSetChanged();
        if (r7.mIsTaskPersist == false) goto L27;
        Set<String> r9 = mMarkClearPackage.get(r7.mUserId, null);
        if (r9 != null) goto L8;
        r9 = new HashSet();
        mMarkClearPackage.put(r7.mUserId, r9);
    L8:
        if (r9.contains(r7.mPackageInfo.packageName) == false) goto L17;
        r9.remove(r7.mPackageInfo.packageName);
        Object r10 = this.mCleanSizeLock;
        monitor-enter(r10);
        this.mCleanSize -= r7.mMergeSize;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Object r11 = this.mCleanSizeLock;
        monitor-enter(r11);
    L24:
        th = move-exception;
        throw th;
    L20:
        if (this.mCleanSize > 0) goto L22;
        this.mCleanSize = 0;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r11);     // Catch: Throwable -> L24
        ToastUtils.show(getContext(), getResources().getString(R.string.app_persist_notice, new Object[]{r7.mDisplayLabel}));
    L28:
        refreshCouldCleanSize();
        return;
    L27:
        ToastUtils.show(getContext(), getResources().getString(R.string.app_not_persist_notice, new Object[]{r7.mDisplayLabel}));
        goto L28
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View r1) {
        this.mActiveItems.remove(r1);
    }

    public RunningProcessesView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mActiveItems = new HashMap();
        this.mBuilder = new StringBuilder(128);
        this.mCurTotalRam = -1;
        this.mCurHighRam = -1;
        this.mCurMedRam = -1;
        this.mCurLowRam = -1;
        this.mCurShowCached = false;
        this.mCleanSizeLock = new Object();
        this.mCleanState = CleanState.IDLE;
        this.mNeedSaveCleanTime = false;
        this.mMemInfoReader = new MemInfoReader();
        this.mHandler = new MyHandler(this);
        this.mOnClickListener = new AnonymousClass1(this);
        this.mMyUserId = UserHandle.myUserId();
    }

    public void doCreate() {
        OLog.d(TAG, " doCreate ");
        int r0 = getContext().getUserId();
        SparseArray<Set<String>> r2 = new SparseArray();
        mMarkClearPackage = r2;
        r2.put(r0, new HashSet());
        if (r0 != 0) goto L5;
        mMarkClearPackage.put(10, new HashSet());
    L5:
        SparseArray<Set<String>> r3 = new SparseArray();
        this.mHadChooseUnclear = r3;
        r3.put(r0, new HashSet());
        if (r0 != 0) goto L8;
        this.mHadChooseUnclear.put(10, new HashSet());
    L8:
        RunningState r1 = RunningState.getInstance(getContext());
        this.mState = r1;
        r1.resume(this);
        this.mAm = (ActivityManager) getContext().getSystemService("activity");
        PreferenceMgr.getInstance(this.mContext);
        long r4 = SystemClock.elapsedRealtime();
        this.mLastCleanTime = ClearProcessService.getLastCleanTime(this.mContext);
        OLog.d(TAG, " mLastCleanTime = " + this.mLastCleanTime + ", timeMillis=" + r4);
        long r5 = this.mLastCleanTime;
        if (r4 != r5) goto L11;
    L13:
        this.mIActivityManager = ActivityManagerNative.getDefault();
        LayoutInflater r6 = (LayoutInflater) getContext().getSystemService("layout_inflater");
        r6.inflate(R.layout.running_processes_view, this);
        View r7 = r6.inflate(R.layout.running_processes_header, null);
        this.mHeader = r7;
        this.mSelectedTip = (TextView) r7.findViewById(R.id.selected_text_tip);
        this.mCleanDoneImg = (ImageView) this.mHeader.findViewById(R.id.clean_done_image);
        this.mCleanDoneText = (TextView) this.mHeader.findViewById(R.id.clean_done_text);
        this.mAdapter = new ServiceListAdapter(this, this.mState);
        r6.inflate(R.layout.running_process_list_footer_view, null);
        this.mUsedTotalSizeText = (TextView) this.mHeader.findViewById(R.id.used_total_size);
        this.mCleanSizeText = (TextView) this.mHeader.findViewById(R.id.selected_size);
        this.mCleanSizeUnit = (TextView) this.mHeader.findViewById(R.id.selected_size_unit);
        OButton r8 = (OButton) findViewById(R.id.clear_process_bt);
        this.mClearButton = r8;
        r8.setOnClickListener(new AnonymousClass6(this));
        updateHeaderView(false);
        this.mAm.getMemoryInfo(new ActivityManager.MemoryInfo());
        HandlerThread r9 = new HandlerThread("kill_process_thread");
        r9.start();
        this.mWorkHandler = new Handler(r9.getLooper());
        return;
    L11:
        if ((r4 - r5) >= 30000) goto L13;
        this.mCleanState = CleanState.CLEANED;
        goto L13
    }

    public void showCleanAllNoticeDialog() {
        if (this.mCleanAllDialog != null) goto L5;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this.mOwner);
        r0.setTitle(R.string.clean_all_processes_title);
        r0.setMessage(R.string.clean_all_processes_message);
        r0.setPositiveButton(R.string.clean_all_processes_certain, new AnonymousClass7(this));
        r0.setNegativeButton(R.string.cancel, new AnonymousClass8(this));
        this.mCleanAllDialog = r0.show();
    L5:
        this.mCleanAllDialog.show();
    }

    private void clearSelectPackage() {
        if (this.mCleanState != CleanState.CLEANING) goto L5;
        return;
    L5:
        long r0 = this.mCleanSize;
        if (r0 > 0) goto L9;
        ToastUtils.show(this.mOwner, R.string.has_not_process_clean);
        return;
    L9:
        this.mCleanState = CleanState.CLEANING;
        this.mClearButton.setText(R.string.cleaning_memory);
        this.mClearButton.setEnabled(false);
        AsyncTask.execute(new AnonymousClass9(this));
        final ArrayList r2 = new ArrayList();
        JSONArray r3 = new JSONArray();
        Iterator<RunningState.MergedItem> r4 = this.mAdapter.mItems.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        RunningState.MergedItem r5 = r4.next();
        Set<String> r6 = mMarkClearPackage.get(r5.mUserId, null);
        if (r6 != null) goto L16;
        r6 = new HashSet();
        mMarkClearPackage.put(r5.mUserId, r6);
    L16:
        if (r6.contains(r5.mPackageInfo.packageName) == true) goto L17;
        if (r5.mIsTaskPersist == false) goto L11;
        r3.put(r5.mPackageInfo.packageName);
        goto L11
    L17:
        r2.add(r5);
        goto L11
    L21:
        this.mWorkHandler.post(new AnonymousClass10(this, r2));
        trackCleanEvent(r3, r0);
        ClearProcessService.notifyClearProcessState(1);
    }

    private void trackCleanEvent(JSONArray r6, long r7) {
        JSONObject r0 = new JSONObject();
        r0.put("resident", r6);     // Catch: JSONException -> L5
        r0.put("check", r7);     // Catch: JSONException -> L5
        long r8 = this.mCurTotalRam - this.mCurLowRam;     // Catch: JSONException -> L5
        r0.put(WsChannelMultiProcessSharedProvider.ALL_TYPE, r8);     // Catch: JSONException -> L5
        r0.put("ram", this.mCurTotalRam);     // Catch: JSONException -> L5
        r0.put("check_ram_percent", this.mCleanSize / this.mCurTotalRam);     // Catch: JSONException -> L5
        r0.put("all_ram_percent", r8 / this.mCurTotalRam);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void doPause() {
        this.mState.pause();
        this.mDataAvail = null;
        this.mCleanAllDialog = null;
        OLog.d(TAG, " doPause mCleanState= " + this.mCleanState + ", mNeedSaveCleanTime=" + this.mNeedSaveCleanTime);
        if (this.mCleanState != CleanState.IDLE) goto L5;
        return;
    L5:
        if (this.mNeedSaveCleanTime == false) goto L9;
        this.mCleanState = CleanState.CLEANED;
        this.mLastCleanTime = SystemClock.elapsedRealtime();
        this.mNeedSaveCleanTime = false;
        ClearProcessService.saveCleanTime(this.mContext, this.mLastCleanTime);
        this.mHandler.sendEmptyMessageDelayed(5, 30000);
        return;
    }

    public void doDestroy() {
        RunningStateHelper.getInstance().doDestroy();
        int r0 = mMarkClearPackage.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        mMarkClearPackage.valueAt(r1).clear();
        r1 = r1 + 1;
        goto L3
    L5:
        this.mHadChooseUnclear.clear();
        if (this.mCleanState != CleanState.CLEANING) goto L8;
        this.mHandler.sendEmptyMessage(4);
        return;
    L8:
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean doResume(Activity r7, Runnable r8) {
        this.mOwner = r7;
        this.mState.resume(this);
        this.mHandler.removeMessages(5);
        if (this.mCleanState != CleanState.CLEANED) goto L8;
        if ((SystemClock.uptimeMillis() - this.mLastCleanTime) < 30000) goto L8;
        this.mCleanState = CleanState.IDLE;
        updateHeaderView(false);
    L8:
        if (this.mState.hasData() == false) goto L16;
        OMenuDialog r9 = this.mMenuDialog;
        if (r9 != null) goto L12;
    L14:
        refreshUi(true);
        return true;
    L12:
        if (r9.isShowing() == false) goto L14;
        this.mMenuDialog.dismiss();
        this.mCurSelected = null;
        goto L14
    L16:
        this.mDataAvail = r8;
        if (this.mCleanState != CleanState.CLEANED) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.android.settings.applications.RunningState.OnRefreshUiListener
    public void onRefreshUi(int r3) {
        if (r3 != 0) goto L4;
        updateTimes();
        return;
    L4:
        if (r3 != 1) goto L6;
        refreshUi(false);
        updateTimes();
        return;
    L6:
        if (r3 != 2) goto L14;
        refreshUi(true);
        updateTimes();
        return;
    }

    private List<RunningState.MergedItem> mergeRunningState(ArrayList<RunningState.MergedItem> r11) {
        ArrayList r0 = new ArrayList();
        if (r11.size() != 0) goto L5;
        return r0;
    L5:
        Iterator<RunningState.MergedItem> r12 = RunningStateHelper.getInstance().mergedPackages(r11).iterator();
        boolean r3 = false;
        long r4 = 0;
    L7:
        if (r12.hasNext() == false) goto L25;
        RunningState.MergedItem r6 = r12.next();
        r6.updateMergeSizeString(getContext());
        r6.enSureTaskPersist(getContext().getPackageManager());
        if (r6.mMergeSize <= 0) goto L7;
        RunningState.MergedItem r7 = this.mCurSelected;
        if (r7 == null) goto L20;
        if (r3 == true) goto L20;
        if (r7.mPackageInfo.packageName.equals(r6.mPackageInfo.packageName) == false) goto L20;
        if (this.mCurSelected.mPackageInfo.uid != r6.mPackageInfo.uid) goto L20;
        this.mCurSelected = r6;
        r3 = true;
    L20:
        if (r6.mIsTaskPersist == false) goto L22;
    L24:
        r0.add(r6);
        goto L7
    L22:
        if (mMarkClearPackage.get(r6.mUserId, Collections.emptySet()).contains(r6.mPackageInfo.packageName) == false) goto L24;
        r4 = r4 + r6.mMergeSize;
        goto L24
    L25:
        if (r3 == true) goto L32;
        OMenuDialog r13 = this.mMenuDialog;
        if (r13 != null) goto L29;
    L31:
        this.mCurSelected = null;
        goto L32
    L29:
        if (r13.isShowing() == false) goto L31;
        this.mMenuDialog.dismiss();
    L32:
        this.mCleanSize = r4;
        return r0;
    }

    private void vibrate() {
        VibratorSmt.vibrateEffect((Vibrator) this.mContext.getSystemService("vibrator"), 0);
    }
}
