package com.bytedanceos.clearmemory;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.UserHandle;
import android.os.Vibrator;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedanceos.common.CardPositionDecider;
import com.bytedanceos.oui.OCardListItemExtKt;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.reflect.BytedanceOSHelper;
import com.bytedanceos.security.widget.SlideListView;
import com.obric.olog.OLog;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialProcessesActivity extends BaseActivity implements AdapterView.OnItemClickListener, AbsListView.RecyclerListener, RunningState.OnRefreshUiListener {
    private static final int CLEAN_ALL_DONE = 4;
    private static final int FINISH = 7;
    public static final String PARAM_SHOW_TYPE = "show_type";
    private static final int REFRESH_CLEAN_SIZE = 3;
    private static final int REMOVE_ITEM_FROM_ADPATER = 6;
    private static final int RESET_CLEANING_FLAG = 2;
    private static final int RESET_CLEAN_STATE = 5;
    public static final int SHOW_TYPE_CAREFUL = 1;
    public static final int SHOW_TYPE_PERSIST = 2;
    public static final String TAG = "RunningProcessesSubActivity";
    private static final int UPDATE_CLEAN_PROGRESS = 1;
    private static volatile long mCleanSize;
    private static final Object mCleanSizeLock = null;
    private static SparseArray<Set<String>> mMarkClearPackage;
    private ProcessListAdapter mAdapter;
    private StringBuilder mBuilder;
    private TextView mCleanSizeText;
    private CleanState mCleanState;
    private boolean mCleaningAllPackage;
    private OBottomActionBarFloating mClearBtn;
    private OButtonFloating mClearButton;
    private RunningState.MergedItem mCurSelected;
    private SparseArray<Set<String>> mHadChooseUnclear;
    private MyHandler mHandler;
    private View mHeader;
    private SlideListView mListView;
    private OActionDialog mMenuDialog;
    private int mMyUserId;
    private Toast mNotProcessClearToast;
    private final OCheckBox.OnCheckedChangeListener mOnCheckedChangedListener;
    private View.OnClickListener mPersistOnClickListener;
    private int mShowType;
    private SlideListView.Listener mSlideListener;
    private RunningState mState;
    private boolean mSupportItemClick;
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

    static final enum CleanState extends Enum<CleanState> {
        private static final /* synthetic */ CleanState[] $VALUES = null;
        public static final CleanState CLEANED = null;
        public static final CleanState CLEANING = null;
        public static final CleanState IDLE = null;

        private static /* synthetic */ CleanState[] $values() {
            return new CleanState[]{IDLE, CLEANING, CLEANED};
        }

        private CleanState(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static CleanState valueOf(String name) {
            return (CleanState) Enum.valueOf(CleanState.class, name);
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

    private class MyHandler extends Handler {
        final /* synthetic */ SpecialProcessesActivity this$0;

        private MyHandler(final SpecialProcessesActivity this$0) {
            this.this$0 = this$0;
        }

        /* synthetic */ MyHandler(SpecialProcessesActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            List<RunningState.MergedItem> r1 = null;
            switch(msg.what) {
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L7;
                case 7: goto L5;
                default: goto L30;
            };
        L5:
            this.this$0.finish();
            return;
        L13:
            SpecialProcessesActivity.access$502(this.this$0, CleanState.IDLE);
            return;
        L18:
            SpecialProcessesActivity.access$200(this.this$0);
            if (SpecialProcessesActivity.access$300() != 0) goto L28;
            SpecialProcessesActivity.access$400(this.this$0);
            removeMessages(4);
            sendEmptyMessage(4);
            return;
        L28:
            return;
        L21:
            SpecialProcessesActivity.access$102(this.this$0, false);
            return;
        L30:
            return;
        L7:
            if (msg.obj == null) goto L10;
            r1 = (List) msg.obj;
        L10:
            if (r1 != null) goto L12;
            return;
        L12:
            SpecialProcessesActivity.access$700(this.this$0).removeItem(r1);
            return;
        L15:
            if (SpecialProcessesActivity.access$100(this.this$0) == false) goto L17;
            SpecialProcessesActivity.access$502(this.this$0, CleanState.CLEANED);
            SpecialProcessesActivity.access$600(this.this$0);
            SpecialProcessesActivity.access$102(this.this$0, false);
            return;
        L17:
            SpecialProcessesActivity.access$502(this.this$0, CleanState.IDLE);
            SpecialProcessesActivity.access$600(this.this$0);
            removeCallbacksAndMessages(null);
        }
    }

    class ProcessListAdapter extends BaseAdapter {
        private static final int TYPE_ITEM = 0;
        private static final int TYPE_ITEM_HEADER = 1;
        final LayoutInflater mInflater;
        final List<RunningState.MergedItem> mItems;
        final ArrayList<RunningState.MergedItem> mOrigItems;
        int mShowCount;
        final Comparator<RunningState.MergedItem> mSizeComparator;
        final RunningState mState;
        final /* synthetic */ SpecialProcessesActivity this$0;

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

        ProcessListAdapter(final SpecialProcessesActivity this$0, RunningState state, Context context) {
            this.this$0 = this$0;
            this.mOrigItems = new ArrayList();
            this.mItems = new ArrayList();
            this.mShowCount = 0;
            this.mSizeComparator = new AnonymousClass1(this);
            this.mState = state;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
            refreshItems();
        }

        void removeItem(List<RunningState.MergedItem> item) {
            this.mItems.removeAll(item);
            this.mOrigItems.removeAll(item);
            notifyDataSetChanged();
        }

        void removeItem(RunningState.MergedItem item) {
            this.mItems.remove(item);
            this.mOrigItems.remove(item);
            notifyDataSetChanged();
        }

        void refreshItems() {
            refreshItems(SpecialProcessesActivity.access$1100(this.this$0, this.mState.getCurrentMergedItems()));
        }

        void refreshItems(List<RunningState.MergedItem> list) {
            if (SpecialProcessesActivity.access$500(this.this$0) != CleanState.CLEANED) goto L5;
            list = Collections.emptyList();
        L5:
            this.mOrigItems.clear();
            this.mOrigItems.addAll(list);
            refresh(this.mOrigItems);
            SpecialProcessesActivity.access$200(this.this$0);
        }

        public void refreshCurrent() {
            refresh(this.mOrigItems);
            notifyDataSetChanged();
        }

        public void refresh(List<RunningState.MergedItem> list) {
            this.mShowCount = 0;
            this.mItems.clear();
            Collections.sort(list, this.mSizeComparator);
            Iterator<RunningState.MergedItem> r8 = list.iterator();
        L4:
            if (r8.hasNext() == false) goto L36;
            RunningState.MergedItem r1 = r8.next();
            Set r2 = (Set) SpecialProcessesActivity.access$1200(this.this$0).get(r1.mUserId, null);
            if (r2 != null) goto L8;
            r2 = new HashSet();
            SpecialProcessesActivity.access$1200(this.this$0).put(r1.mUserId, r2);
        L8:
            Set r3 = (Set) SpecialProcessesActivity.access$800().get(r1.mUserId, null);
            if (r3 != null) goto L12;
            r3 = new HashSet();
            SpecialProcessesActivity.access$800().put(r1.mUserId, r3);
        L12:
            if (SpecialProcessesActivity.access$1300(this.this$0) != 2) goto L16;
            if (r1.mIsTaskPersist == false) goto L16;
        L21:
            boolean r4 = true;
        L23:
            if (r4 == false) goto L4;
            this.mShowCount++;
            this.mItems.add(r1);
            if (r2.contains(r1.mPackageInfo.packageName) == true) goto L4;
            if (r3.add(r1.mPackageInfo.packageName) == false) goto L4;
            Object r5 = SpecialProcessesActivity.access$900();
            monitor-enter(r5);
            SpecialProcessesActivity.access$314(r1.mMergeSize);     // Catch: Throwable -> L33
            monitor-exit(r5);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;
        L16:
            if (SpecialProcessesActivity.access$1300(this.this$0) == 1) goto L18;
        L22:
            r4 = false;
            goto L23
        L18:
            if (r1.mIsRecommendClear == true) goto L22;
            if (r1.mIsTaskPersist == true) goto L22;
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
        public Object getItem(int position) {
            return this.mItems.get(position);
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return getItem(position).hashCode();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int position) {
            return !((RunningState.MergedItem) getItem(position)).mIsProcess;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            int r0 = getItemViewType(position);
            if (convertView != null) goto L5;
            convertView = newView(parent, r0);
        L5:
            bindView(convertView, position);
            if (convertView == null) goto L8;
            setBackgroundRes(position, convertView);
        L8:
            return convertView;
        }

        private void setBackgroundRes(final int position, final View view) {
            if (view != null) goto L4;
            return;
        L4:
            OCardListItem r0 = (OCardListItem) view.findViewById(R.id.oCard_list_item);
            if (r0 != null) goto L8;
            return;
        L8:
            if (SpecialProcessesActivity.access$1300(this.this$0) != 1) goto L10;
            r0.setOnContentClickListener(new AnonymousClass2(this, view, position));
        L11:
            r0.setCardPosition(CardPositionDecider.compute(position, getCount(), new AnonymousClass4(this)));
            return;
        L10:
            r0.setTailIcon(this.this$0.getDrawable(R.drawable.ic_pin_task));
            r0.getTailIconView().setOnClickListener(new AnonymousClass3(this, position));
            r0.showTailIcon(true);
            goto L11
        }

        public View newView(ViewGroup parent, int viewType) {
            View r1 = this.mInflater.inflate(R.layout.processes_sub_list_item_ocard, parent, false);
            new ViewHolder(r1);
            return r1;
        }

        public void bindView(View view, int position) {
            Object r0 = this.mState.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (position < this.mItems.size()) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L8:
            ViewHolder r5 = (ViewHolder) view.getTag();     // Catch: Throwable -> L13
            RunningState.MergedItem r6 = (RunningState.MergedItem) getItem(position);     // Catch: Throwable -> L13
            r5.bind(this.mState, r6, SpecialProcessesActivity.access$1600(this.this$0), SpecialProcessesActivity.access$1700(this.this$0));     // Catch: Throwable -> L13
            if (r5.cb == null) goto L11;
            r5.cb.setOnCheckedChangeListener(SpecialProcessesActivity.access$1800(this.this$0));     // Catch: Throwable -> L13
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L13
        }
    }

    public static class ViewHolder {
        public OCheckBox cb;
        public OCardListItem oCardListItem;
        public View rootView;

        public ViewHolder(View v) {
            this.rootView = v;
            this.oCardListItem = (OCardListItem) v.findViewById(R.id.oCard_list_item);
            v.setTag(this);
        }

        public ActiveItem bind(RunningState state, RunningState.BaseItem item, StringBuilder builder, boolean clickable) {
            Object r7 = state.mLock;
            monitor-enter(r7);
            Context r8 = this.rootView.getContext();     // Catch: Throwable -> L25
            if (item.mPackageInfo == null) goto L7;
        L14:
            this.oCardListItem.setTitle(item.mDisplayLabel.toString());     // Catch: Throwable -> L25
            ActiveItem r0 = new ActiveItem();     // Catch: Throwable -> L25
            r0.mRootView = this.rootView;     // Catch: Throwable -> L25
            r0.mItem = item;     // Catch: Throwable -> L25
            r0.mHolder = this;     // Catch: Throwable -> L25
            r0.mFirstRunTime = item.mActiveSince;     // Catch: Throwable -> L25
            item.mCurSizeStr = null;     // Catch: Throwable -> L25
            this.oCardListItem.setAppIcon(OuiWidgetUtils.applyDopplegangerBadge(r8, item.loadIcon(r8, state), item.isDoppleganger));     // Catch: Throwable -> L25
            this.oCardListItem.showIcon(true);     // Catch: Throwable -> L25
            this.oCardListItem.setCardType(1);     // Catch: Throwable -> L25
            OCardListItemExtKt.setEndText(this.oCardListItem, item.mSizeStr);     // Catch: Throwable -> L25
            this.oCardListItem.setDefaultCustomStartView(0);     // Catch: Throwable -> L25
            this.oCardListItem.showCustomStart(true);     // Catch: Throwable -> L25
            OCheckBox r5 = this.oCardListItem.getStartCheckBox().getCheckBox();     // Catch: Throwable -> L25
            r5.setTag(item);     // Catch: Throwable -> L25
            if ((item instanceof RunningState.MergedItem) == true) goto L17;
        L21:
            this.oCardListItem.showCustomStart(false);     // Catch: Throwable -> L25
        L22:
            this.cb = r5;     // Catch: Throwable -> L25
            monitor-exit(r7);     // Catch: Throwable -> L25
            return r0;
        L17:
            if (((RunningState.MergedItem) item).mIsTaskPersist == true) goto L21;
            if (item.mPackageInfo == null) goto L21;
            Set r1 = Collections.emptySet();     // Catch: Throwable -> L25
            r5.setChecked(((Set) SpecialProcessesActivity.access$800().get(item.mUserId, r1)).contains(item.mPackageInfo.packageName));     // Catch: Throwable -> L25
            this.oCardListItem.showCustomStart(true);     // Catch: Throwable -> L25
            this.oCardListItem.setOnContentClickListener(new AnonymousClass1(this));     // Catch: Throwable -> L25
            goto L22
        L7:
            if ((item instanceof RunningState.MergedItem) == false) goto L14;
            if (((RunningState.MergedItem) item).mProcess == null) goto L14;
            PackageManager r2 = r8.getPackageManager();     // Catch: Throwable -> L25
            if (r2 == null) goto L13;
            ((RunningState.MergedItem) item).mProcess.ensureLabel(r2);     // Catch: Throwable -> L25
        L13:
            item.mPackageInfo = ((RunningState.MergedItem) item).mProcess.mPackageInfo;     // Catch: Throwable -> L25
            item.mDisplayLabel = ((RunningState.MergedItem) item).mProcess.mDisplayLabel;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
    }

    public SpecialProcessesActivity() {
        this.mShowType = 0;
        this.mBuilder = new StringBuilder(128);
        this.mCleanState = CleanState.IDLE;
        this.mSupportItemClick = false;
        this.mHandler = new MyHandler(this, null);
        this.mOnCheckedChangedListener = new AnonymousClass1(this);
        this.mPersistOnClickListener = new AnonymousClass2(this);
        this.mSlideListener = new AnonymousClass6(this);
    }

    static /* synthetic */ boolean access$100(SpecialProcessesActivity r0) {
        return r0.mCleaningAllPackage;
    }

    static /* synthetic */ void access$1000(SpecialProcessesActivity r0, RunningState.MergedItem r1) {
        r0.updateTaskPersist(r1);
    }

    static /* synthetic */ boolean access$102(SpecialProcessesActivity r0, boolean r1) {
        r0.mCleaningAllPackage = r1;
        return r1;
    }

    static /* synthetic */ List access$1100(SpecialProcessesActivity r0, ArrayList r1) {
        return r0.mergeRunningState(r1);
    }

    static /* synthetic */ SparseArray access$1200(SpecialProcessesActivity r0) {
        return r0.mHadChooseUnclear;
    }

    static /* synthetic */ int access$1300(SpecialProcessesActivity r0) {
        return r0.mShowType;
    }

    static /* synthetic */ SlideListView access$1400(SpecialProcessesActivity r0) {
        return r0.mListView;
    }

    static /* synthetic */ View.OnClickListener access$1500(SpecialProcessesActivity r0) {
        return r0.mPersistOnClickListener;
    }

    static /* synthetic */ StringBuilder access$1600(SpecialProcessesActivity r0) {
        return r0.mBuilder;
    }

    static /* synthetic */ boolean access$1700(SpecialProcessesActivity r0) {
        return r0.mSupportItemClick;
    }

    static /* synthetic */ OCheckBox.OnCheckedChangeListener access$1800(SpecialProcessesActivity r0) {
        return r0.mOnCheckedChangedListener;
    }

    static /* synthetic */ MyHandler access$1900(SpecialProcessesActivity r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$200(SpecialProcessesActivity r0) {
        r0.refreshCouldCleanSize();
    }

    static /* synthetic */ boolean access$2000(SpecialProcessesActivity r0, RunningState.MergedItem r1) {
        return r0.stopPackage(r1);
    }

    static /* synthetic */ RunningState access$2100(SpecialProcessesActivity r0) {
        return r0.mState;
    }

    static /* synthetic */ RunningState.MergedItem access$2200(SpecialProcessesActivity r0) {
        return r0.mCurSelected;
    }

    static /* synthetic */ void access$2300(SpecialProcessesActivity r0, RunningState.MergedItem r1) {
        r0.showCleanToast(r1);
    }

    static /* synthetic */ long access$300() {
        return mCleanSize;
    }

    static /* synthetic */ long access$302(long r0) {
        mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ long access$314(long r2) {
        long r0 = mCleanSize + r2;
        mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ long access$322(long r2) {
        long r0 = mCleanSize - r2;
        mCleanSize = r0;
        return r0;
    }

    static /* synthetic */ void access$400(SpecialProcessesActivity r0) {
        r0.vibrate();
    }

    static /* synthetic */ CleanState access$500(SpecialProcessesActivity r0) {
        return r0.mCleanState;
    }

    static /* synthetic */ CleanState access$502(SpecialProcessesActivity r0, CleanState r1) {
        r0.mCleanState = r1;
        return r1;
    }

    static /* synthetic */ void access$600(SpecialProcessesActivity r0) {
        r0.updateHeaderView();
    }

    static /* synthetic */ ProcessListAdapter access$700(SpecialProcessesActivity r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ SparseArray access$800() {
        return mMarkClearPackage;
    }

    static /* synthetic */ Object access$900() {
        return mCleanSizeLock;
    }

    static {
        mCleanSizeLock = new Object();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_process_sub_activity);
        int r7 = getIntent().getIntExtra(PARAM_SHOW_TYPE, 0);
        this.mShowType = r7;
        if (r7 != 1) goto L5;
    L8:
        getWindow().setBackgroundDrawable(null);
        if (this.mShowType != 1) goto L11;
        boolean r8 = true;
    L12:
        this.mSupportItemClick = r8;
        this.mMyUserId = UserHandle.myUserId();
        int r9 = getUserId();
        SparseArray<Set<String>> r3 = new SparseArray();
        mMarkClearPackage = r3;
        r3.put(r9, new HashSet());
        if (r9 != 0) goto L15;
        mMarkClearPackage.put(10, new HashSet());
    L15:
        SparseArray<Set<String>> r4 = new SparseArray();
        this.mHadChooseUnclear = r4;
        r4.put(r9, new HashSet());
        if (r9 != 0) goto L18;
        this.mHadChooseUnclear.put(10, new HashSet());
    L18:
        this.mClearBtn = (OBottomActionBarFloating) findViewById(R.id.bottom_delete_action);
        initDeleteActionView();
        this.mListView = (SlideListView) findViewById(R.id.list);
        LayoutInflater r5 = (LayoutInflater) getSystemService("layout_inflater");
        if (r5 != null) goto L22;
        return;
    L22:
        if (this.mShowType != 1) goto L26;
        OBottomActionBarFloating r0 = this.mClearBtn;
        if (r0 == null) goto L29;
        r0.setVisibility(0);
    L29:
        View r1 = r5.inflate(R.layout.processes_sub_list_foot, null);
        this.mState = RunningState.getInstance(this);
        this.mAdapter = new ProcessListAdapter(this, this.mState, this);
        SlideListView r6 = this.mListView;
        if (r6 == null) goto L35;
        r6.addFooterView(r1, null, false);
        if (this.mSupportItemClick == false) goto L34;
        this.mListView.setOnItemClickListener(this);
    L34:
        this.mListView.setRecyclerListener(this);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setSlideListener(this.mSlideListener);
    L35:
        initTitle();
        HandlerThread r2 = new HandlerThread("kill_special_process_thread");
        r2.start();
        this.mWorkHandler = new Handler(r2.getLooper());
        updateWidth();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bottom_delete_action), new SpecialProcessesActivity$$ExternalSyntheticLambda4());
        getWindow();
        return;
    L26:
        OBottomActionBarFloating r10 = this.mClearBtn;
        if (r10 == null) goto L29;
        r10.setVisibility(8);
        goto L29
    L11:
        r8 = false;
        goto L12
    L5:
        if (r7 == 2) goto L8;
        finish();
    }

    static /* synthetic */ WindowInsetsCompat lambda$onCreate$0(View r2, WindowInsetsCompat r3) {
        Insets r0 = r3.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        r1.bottomMargin = r0.bottom;
        r2.setLayoutParams(r1);
        return r3;
    }

    private void initDeleteActionView() {
        OButtonFloating r0 = (OButtonFloating) StyleUtil.createWidgetWithStyle(this.mClearBtn.getContext(), 2131821333, new SpecialProcessesActivity$$ExternalSyntheticLambda6(this));
        this.mClearButton = r0;
        OBottomActionBarFloating r3 = this.mClearBtn;
        if (r3 == null) goto L6;
        r3.setButtons(Collections.singletonList(r0));
        return;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$2$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ OButtonFloating m96x8b5dd95f(Context r4, Integer r5, Integer r6) {
        OButtonFloating r0 = new OButtonFloating(r4);
        r0.setTitle(getString(R.string.clear_text));
        r0.getTextView().setTextColor(this.mClearBtn.getContext().getColor(R.color.oui_functional_red_6));
        r0.setLayoutParams(new ViewGroup.LayoutParams(r5.intValue(), r6.intValue()));
        r0.setOnClickListener(new SpecialProcessesActivity$$ExternalSyntheticLambda5(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$1$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ void m95x71425ac0(View r2) {
        if (this.mCleanState != CleanState.IDLE) goto L6;
        clearSelectPackage();
        return;
    L6:
        if (this.mCleanState != CleanState.CLEANED) goto L10;
        finish();
        return;
    }

    private void updateWidth() {
        updateViewWidth(this.mListView);
    }

    private void initTitle() {
        initTitleBar(false, false);
        int r0 = this.mShowType;
        if (r0 != 1) goto L6;
        this.mTitle.setCenterTitle(getResources().getString(R.string.memory_carful));
        return;
    L6:
        if (r0 != 2) goto L10;
        this.mTitle.setCenterTitle(getResources().getString(R.string.memory_persist));
        return;
    }

    void refreshUi(boolean dataChanged) {
        if (this.mCleanState == CleanState.IDLE) goto L6;
        return;
    L6:
        if (this.mCleaningAllPackage == false) goto L8;
        return;
    L8:
        if (dataChanged == false) goto L10;
        ProcessListAdapter r3 = this.mAdapter;
        r3.refreshItems();
        r3.notifyDataSetChanged();
    L10:
        refreshCouldCleanSize();
    }

    private void refreshCouldCleanSize() {
        if (this.mClearButton != null) goto L5;
        return;
    L5:
        long r0 = mCleanSize;
        if (r0 >= 0) goto L9;
        OLog.e(TAG, "clear size error " + mCleanSize);
        r0 = 0;
    L9:
        if (r0 != 0) goto L11;
        this.mClearButton.setEnabled(false);
        return;
    L11:
        this.mClearButton.setEnabled(true);
    }

    private void updateHeaderView() {
        if (this.mShowType == 1) goto L6;
        return;
    L6:
        if (this.mCleanState != CleanState.CLEANED) goto L8;
        this.mHandler.sendEmptyMessageDelayed(7, 500);
        return;
    L8:
        this.mClearButton.setTitle(getResources().getString(R.string.action_clean));
        refreshCouldCleanSize();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        if (this.mSupportItemClick == true) goto L6;
        return;
    L6:
        if (Utils.isFastDoubleClick() == false) goto L8;
        return;
    L8:
        OActionDialog r2 = this.mMenuDialog;
        if (r2 != null) goto L11;
    L12:
        this.mCurSelected = (RunningState.MergedItem) parent.getAdapter().getItem(position);
        showItemMenu();
        return;
    L11:
        if (r2.isShowing() == false) goto L12;
    }

    private void showItemMenu() {
        if (this.mCurSelected != null) goto L5;
        return;
    L5:
        final View r0 = LayoutInflater.from(this).inflate(R.layout.running_process_action_dialog, null);
        this.mMenuDialog = new OActionDialog(this, new OActionDialog.Modifier(getResources().getString(R.string.clean_process_choose_action_title), "", new AnonymousClass3(this, r0)));
        OButton r1 = (OButton) r0.findViewById(R.id.btn_action_1);
        OButton r2 = (OButton) r0.findViewById(R.id.btn_action_2);
        OButton r3 = (OButton) r0.findViewById(R.id.btn_cancel);
        if (this.mCurSelected.mIsTaskPersist == false) goto L8;
        r1.setText(R.string.action_task_not_persist);
        r1.setOnClickListener(new SpecialProcessesActivity$$ExternalSyntheticLambda0(this));
        r2.setVisibility(8);
    L9:
        r3.setOnClickListener(new SpecialProcessesActivity$$ExternalSyntheticLambda3(this));
        this.mMenuDialog.show();
        return;
    L8:
        r1.setText(R.string.action_clean_memory);
        r1.setOnClickListener(new SpecialProcessesActivity$$ExternalSyntheticLambda1(this));
        r2.setVisibility(0);
        r2.setText(R.string.memory_persist);
        r2.setOnClickListener(new SpecialProcessesActivity$$ExternalSyntheticLambda2(this));
        goto L9
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$3$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ void m97x4fde24e5(View r1) {
        OActionDialog r2 = this.mMenuDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        updateTaskPersist(this.mCurSelected);
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$4$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ void m98x69f9a384(View r2) {
        OActionDialog r3 = this.mMenuDialog;
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        this.mWorkHandler.post(new AnonymousClass4(this));
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$5$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ void m99x84152223(View r1) {
        OActionDialog r2 = this.mMenuDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        updateTaskPersist(this.mCurSelected);
    }

    /* JADX INFO: renamed from: lambda$showItemMenu$6$com-bytedanceos-clearmemory-SpecialProcessesActivity, reason: not valid java name */
    /* synthetic */ void m100x9e30a0c2(View r1) {
        OActionDialog r0 = this.mMenuDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean stopPackage(RunningState.MergedItem mi) {
        if (mi != null) goto L6;
        return false;
    L6:
        return RunningStateHelper.getInstance().stopPackage(mi, true);
    }

    private void showCleanToast(final RunningState.MergedItem curSelected) {
        if (curSelected != null) goto L5;
        return;
    L5:
        if (getResources().getConfiguration().locale.equals(Locale.ENGLISH) == false) goto L7;
        String r7 = getResources().getString(R.string.memory_has_clean_process, new Object[]{curSelected.mSizeStr, curSelected.mDisplayLabel});
    L8:
        Toast.makeText(this, r7, 0).show();
        return;
    L7:
        r7 = getResources().getString(R.string.memory_has_clean_process, new Object[]{curSelected.mDisplayLabel, curSelected.mSizeStr});
        goto L8
    }

    private void updateTaskPersist(final RunningState.MergedItem mi) {
        mi.mIsTaskPersist = !mi.mIsTaskPersist;
        AsyncTask.execute(new AnonymousClass5(this, mi));
        this.mAdapter.refreshCurrent();
        if (mi.mIsTaskPersist == false) goto L27;
        Set<String> r0 = mMarkClearPackage.get(mi.mUserId, null);
        if (r0 != null) goto L8;
        r0 = new HashSet();
        mMarkClearPackage.put(mi.mUserId, r0);
    L8:
        if (r0.contains(mi.mPackageInfo.packageName) == false) goto L17;
        r0.remove(mi.mPackageInfo.packageName);
        Object r1 = mCleanSizeLock;
        monitor-enter(r1);
        mCleanSize -= mi.mMergeSize;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        Object r2 = mCleanSizeLock;
        monitor-enter(r2);
    L24:
        th = move-exception;
        throw th;
    L20:
        if (mCleanSize > 0) goto L22;
        mCleanSize = 0;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L24
        Toast.makeText(this, getResources().getString(R.string.app_persist_notice, new Object[]{mi.mDisplayLabel}), 0).show();
    L28:
        refreshCouldCleanSize();
        if (this.mAdapter.getCount() > 0) goto L36;
        this.mHandler.sendEmptyMessageDelayed(7, 500);
        return;
    L36:
        return;
    L27:
        Toast.makeText(this, getResources().getString(R.string.app_not_persist_notice, new Object[]{mi.mDisplayLabel}), 0).show();
        goto L28
    }

    private void clearSelectPackage() {
        if (this.mCleanState != CleanState.CLEANING) goto L6;
        return;
    L6:
        if (mCleanSize <= 0) goto L8;
        this.mCleanState = CleanState.CLEANING;
        this.mClearButton.setTitle(getResources().getString(R.string.cleaning_memory));
        this.mClearButton.setEnabled(false);
        final ArrayList r0 = new ArrayList();
        Iterator<RunningState.MergedItem> r1 = this.mAdapter.mItems.iterator();
    L14:
        if (r1.hasNext() == false) goto L22;
        RunningState.MergedItem r2 = r1.next();
        Set<String> r3 = mMarkClearPackage.get(r2.mUserId, null);
        if (r3 != null) goto L19;
        r3 = new HashSet();
        mMarkClearPackage.put(r2.mUserId, r3);
    L19:
        if (r3.contains(r2.mPackageInfo.packageName) == false) goto L14;
        r0.add(r2);
        goto L14
    L22:
        if (r0.size() != this.mAdapter.mItems.size()) goto L24;
        this.mCleaningAllPackage = true;
    L24:
        AsyncTask.execute(new AnonymousClass7(this, r0));
        this.mWorkHandler.post(new AnonymousClass8(this, r0));
        ClearProcessService.notifyClearProcessState(1);
        return;
    L8:
        if (this.mNotProcessClearToast != null) goto L10;
        this.mNotProcessClearToast = Toast.makeText(this, R.string.has_not_process_clean, 0);
    L10:
        this.mNotProcessClearToast.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mState.unregistListener(this);
        this.mState.pause();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RunningStateHelper.getInstance().doDestroy();
        SparseArray<Set<String>> r0 = mMarkClearPackage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r1 >= r2) goto L8;
        mMarkClearPackage.valueAt(r1).clear();
        r1 = r1 + 1;
        goto L6
    L8:
        SparseArray<Set<String>> r3 = this.mHadChooseUnclear;
        if (r3 == null) goto L12;
        r3.clear();
    L12:
        if (this.mCleanState != CleanState.CLEANING) goto L14;
        this.mHandler.sendEmptyMessage(4);
        return;
    L14:
        this.mHandler.removeCallbacksAndMessages(null);
        return;
    L5:
        r2 = r0.size();
        goto L6
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mState.registListener(this);
        this.mState.resume();
        this.mHandler.removeMessages(5);
        if (this.mState.hasData() == false) goto L11;
        OActionDialog r0 = this.mMenuDialog;
        if (r0 != null) goto L7;
    L9:
        refreshUi(true);
        return;
    L7:
        if (r0.isShowing() == false) goto L9;
        this.mMenuDialog.dismiss();
        this.mCurSelected = null;
        goto L9
    }

    @Override // com.bytedanceos.clearmemory.RunningState.OnRefreshUiListener
    public void onRefreshUi(int what) {
        if (what != 1) goto L5;
        refreshUi(false);
        return;
    L5:
        if (what != 2) goto L11;
        refreshUi(true);
        return;
    }

    private List<RunningState.MergedItem> mergeRunningState(ArrayList<RunningState.MergedItem> mergedItems) {
        ArrayList r0 = new ArrayList();
        if (mergedItems.size() != 0) goto L5;
        return r0;
    L5:
        List<RunningState.MergedItem> r11 = RunningStateHelper.getInstance().mergedPackages(mergedItems);
        long r1 = 0;
        boolean r3 = false;
        if (r11 == null) goto L28;
        Iterator<RunningState.MergedItem> r12 = r11.iterator();
        long r4 = 0;
    L9:
        if (r12.hasNext() == false) goto L27;
        RunningState.MergedItem r6 = r12.next();
        r6.updateMergeSizeString(this);
        r6.enSureTaskPersist(getPackageManager());
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
        r0.add(r6);
        goto L9
    L24:
        if (mMarkClearPackage.get(r6.mUserId, Collections.emptySet()).contains(r6.mPackageInfo.packageName) == false) goto L26;
        r4 = r4 + r6.mMergeSize;
        goto L26
    L27:
        r1 = r4;
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
        mCleanSize = r1;
        return r0;
    }

    private void vibrate() {
        BytedanceOSHelper.vibrateEffect((Vibrator) getSystemService("vibrator"), BytedanceOSHelper.xVibEffectSmt.getConstantValue("EFFECT_PIN_APP"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateWidth();
    }
}
