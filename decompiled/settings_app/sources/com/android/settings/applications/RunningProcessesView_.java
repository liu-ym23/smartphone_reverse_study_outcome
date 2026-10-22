package com.android.settings.applications;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.BidiFormatter;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.internal.util.MemInfoReader;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.Utils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class RunningProcessesView_ extends FrameLayout implements AdapterView.OnItemClickListener, AbsListView.RecyclerListener, RunningState_.OnRefreshUiListener {
    long SECONDARY_SERVER_MEM;
    final HashMap<View, ActiveItem> mActiveItems;
    ServiceListAdapter mAdapter;
    ActivityManager mAm;
    TextView mAppsProcessPrefix;
    TextView mAppsProcessText;
    TextView mAvaiSpaceTipsView;
    TextView mBackgroundProcessPrefix;
    TextView mBackgroundProcessText;
    StringBuilder mBuilder;
    LinearColorBar mColorBar;
    Dialog mCurDialog;
    long mCurHighRam;
    long mCurLowRam;
    long mCurMedRam;
    RunningState_.BaseItem mCurSelected;
    boolean mCurShowCached;
    long mCurTotalRam;
    Runnable mDataAvail;
    TextView mForegroundProcessPrefix;
    TextView mForegroundProcessText;
    View mHeader;
    ListView mListView;
    MemInfoReader mMemInfoReader;
    final int mMyUserId;
    Fragment mOwner;
    RunningState_ mState;

    public static class ActiveItem {
        long mFirstRunTime;
        ViewHolder mHolder;
        RunningState_.BaseItem mItem;
        View mRootView;
        ActivityManager.RunningServiceInfo mService;
        boolean mSetBackground;

        public ActiveItem() {
        }

        void updateTime(Context r9, StringBuilder r10) {
            RunningState_.BaseItem r0 = this.mItem;
            boolean r2 = true;
            if ((r0 instanceof RunningState_.ServiceItem) == false) goto L6;
            TextView r1 = this.mHolder.size;
        L21:
            if (r1 == null) goto L36;
            boolean r3 = false;
            this.mSetBackground = false;
            if (this.mFirstRunTime < 0) goto L25;
            r1.setText(DateUtils.formatElapsedTime(r10, (SystemClock.elapsedRealtime() - this.mFirstRunTime) / 1000));
            return;
        L25:
            RunningState_.BaseItem r8 = this.mItem;
            if ((r8 instanceof RunningState_.MergedItem) == true) goto L28;
        L32:
            if (r3 == false) goto L34;
            r1.setText(r9.getResources().getText(R.string.service_restarting));
            return;
        L34:
            r1.setText("");
            return;
        L28:
            if (((RunningState_.MergedItem) r8).mServices.size() > 0) goto L31;
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
            if ((this.mItem instanceof RunningState_.MergedItem) == false) goto L20;
            r1 = this.mHolder.uptime;
            goto L21
        L8:
            r4 = "";
            goto L10
        }
    }

    class ServiceListAdapter extends BaseAdapter {
        final LayoutInflater mInflater;
        final ArrayList<RunningState_.MergedItem> mItems;
        ArrayList<RunningState_.MergedItem> mOrigItems;
        boolean mShowBackground;
        final RunningState_ mState;
        final /* synthetic */ RunningProcessesView_ this$0;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        ServiceListAdapter(RunningProcessesView_ r2, RunningState_ r3) {
            this.this$0 = r2;
            this.mItems = new ArrayList();
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
            if (this.mShowBackground == false) goto L5;
            ArrayList<RunningState_.MergedItem> r0 = this.mState.getCurrentBackgroundItems();
        L7:
            if (this.mOrigItems == r0) goto L15;
            this.mOrigItems = r0;
            if (r0 != null) goto L11;
            this.mItems.clear();
            return;
        L11:
            this.mItems.clear();
            this.mItems.addAll(r0);
            if (this.mShowBackground == false) goto L17;
            Collections.sort(this.mItems, this.mState.mBackgroundComparator);
            return;
        L17:
            return;
        L15:
            return;
        L5:
            r0 = this.mState.getCurrentMergedItems();
            goto L7
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
            if (this.mItems.size() != 0) goto L7;
            return true;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mItems.get(r1);
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return this.mItems.get(r1).hashCode();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return !this.mItems.get(r1).mIsProcess;
        }

        @Override // android.widget.Adapter
        public View getView(int r1, View r2, ViewGroup r3) {
            if (r2 != null) goto L4;
            r2 = newView(r3);
        L4:
            bindView(r2, r1);
            return r2;
        }

        public View newView(ViewGroup r3) {
            View r2 = this.mInflater.inflate(R.layout.running_processes_item_, r3, false);
            new ViewHolder(r2);
            return r2;
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
            RunningState_.MergedItem r7 = this.mItems.get(r6);     // Catch: Throwable -> L11
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
        public TextView description;
        public ImageView icon;
        public TextView name;
        public View rootView;
        public TextView size;
        public TextView uptime;

        public ViewHolder(View r2) {
            this.rootView = r2;
            this.icon = (ImageView) r2.findViewById(R.id.icon);
            this.name = (TextView) r2.findViewById(R.id.name);
            this.description = (TextView) r2.findViewById(R.id.description);
            this.size = (TextView) r2.findViewById(R.id.size);
            this.uptime = (TextView) r2.findViewById(R.id.uptime);
            r2.setTag(this);
        }

        public ActiveItem bind(RunningState_ r6, RunningState_.BaseItem r7, StringBuilder r8) {
            Object r0 = r6.mLock;
            monitor-enter(r0);
            PackageManager r1 = this.rootView.getContext().getPackageManager();     // Catch: Throwable -> L18
            if (r7.mPackageInfo == null) goto L7;
        L11:
            this.name.setText(r7.mDisplayLabel);     // Catch: Throwable -> L18
            ActiveItem r2 = new ActiveItem();     // Catch: Throwable -> L18
            r2.mRootView = this.rootView;     // Catch: Throwable -> L18
            r2.mItem = r7;     // Catch: Throwable -> L18
            r2.mHolder = this;     // Catch: Throwable -> L18
            r2.mFirstRunTime = r7.mActiveSince;     // Catch: Throwable -> L18
            if (r7.mBackground == false) goto L14;
            this.description.setText(this.rootView.getContext().getText(R.string.cached));     // Catch: Throwable -> L18
        L15:
            r7.mCurSizeStr = null;     // Catch: Throwable -> L18
            this.icon.setImageDrawable(r7.loadIcon(this.rootView.getContext(), r6));     // Catch: Throwable -> L18
            this.icon.setVisibility(0);     // Catch: Throwable -> L18
            r2.updateTime(this.rootView.getContext(), r8);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            return r2;
        L14:
            this.description.setText(r7.mDescription);     // Catch: Throwable -> L18
            goto L15
        L7:
            if ((r7 instanceof RunningState_.MergedItem) == false) goto L11;
            if (((RunningState_.MergedItem) r7).mProcess == null) goto L11;
            ((RunningState_.MergedItem) r7).mProcess.ensureLabel(r1);     // Catch: Throwable -> L18
            r7.mPackageInfo = ((RunningState_.MergedItem) r7).mProcess.mPackageInfo;     // Catch: Throwable -> L18
            r7.mDisplayLabel = ((RunningState_.MergedItem) r7).mProcess.mDisplayLabel;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }
    }

    void refreshUi(boolean r18) {
        if (r18 == false) goto L5;
        ServiceListAdapter r1 = this.mAdapter;
        r1.refreshItems();
        r1.notifyDataSetChanged();
    L5:
        Runnable r2 = this.mDataAvail;
        if (r2 == null) goto L8;
        r2.run();
        this.mDataAvail = null;
    L8:
        this.mMemInfoReader.readMemInfo();
        Object r3 = this.mState.mLock;
        monitor-enter(r3);
    L31:
        th = move-exception;
        throw th;
    L11:
        if (this.mCurShowCached == this.mAdapter.mShowBackground) goto L16;
        boolean r4 = this.mAdapter.mShowBackground;     // Catch: Throwable -> L31
        this.mCurShowCached = r4;     // Catch: Throwable -> L31
        if (r4 == false) goto L15;
        this.mForegroundProcessPrefix.setText(getResources().getText(R.string.running_processes_header_used_prefix));     // Catch: Throwable -> L31
        this.mAppsProcessPrefix.setText(getResources().getText(R.string.running_processes_header_cached_prefix));     // Catch: Throwable -> L31
        goto L16
    L15:
        this.mForegroundProcessPrefix.setText(getResources().getText(R.string.running_processes_header_system_prefix));     // Catch: Throwable -> L31
        this.mAppsProcessPrefix.setText(getResources().getText(R.string.running_processes_header_apps_prefix));     // Catch: Throwable -> L31
    L16:
        long r5 = ((this.mMemInfoReader.getTotalSize() >> 30) + 1) << 30;     // Catch: Throwable -> L31
        if (this.mCurShowCached == false) goto L19;
        long r6 = this.mMemInfoReader.getFreeSize() + this.mMemInfoReader.getCachedSize();     // Catch: Throwable -> L31
        long r7 = this.mState.mBackgroundProcessMemory;     // Catch: Throwable -> L31
    L20:
        long r8 = (r5 - r7) - r6;     // Catch: Throwable -> L31
        if (this.mCurTotalRam == r5) goto L23;
    L28:
        this.mCurTotalRam = r5;     // Catch: Throwable -> L31
        this.mCurHighRam = r8;     // Catch: Throwable -> L31
        this.mCurMedRam = r7;     // Catch: Throwable -> L31
        this.mCurLowRam = r6;     // Catch: Throwable -> L31
        BidiFormatter r10 = BidiFormatter.getInstance();     // Catch: Throwable -> L31
        this.mBackgroundProcessText.setText(getResources().getString(R.string.running_processes_header_ram, new Object[]{r10.unicodeWrap(Formatter.formatShortFileSize(getContext(), r6))}));     // Catch: Throwable -> L31
        this.mAppsProcessText.setText(getResources().getString(R.string.running_processes_header_ram, new Object[]{r10.unicodeWrap(Formatter.formatShortFileSize(getContext(), r7))}));     // Catch: Throwable -> L31
        this.mForegroundProcessText.setText(getResources().getString(R.string.running_processes_header_ram, new Object[]{r10.unicodeWrap(Formatter.formatShortFileSize(getContext(), r8))}));     // Catch: Throwable -> L31
        float r9 = r5;
        this.mColorBar.setRatios(r8 / r9, r7 / r9, r6 / r9);     // Catch: Throwable -> L31
        this.mAvaiSpaceTipsView.setText(getResources().getString(R.string.running_processes_header_memory_used_prefix) + r10.unicodeWrap(Formatter.formatShortFileSize(getContext(), r5 - r6)) + LibrarianImpl.Constants.SEPARATOR + r10.unicodeWrap(Formatter.formatShortFileSize(getContext(), r5)));     // Catch: Throwable -> L31
    L29:
        monitor-exit(r3);     // Catch: Throwable -> L31
        return;
    L23:
        if (this.mCurHighRam != r8) goto L28;
        if (this.mCurMedRam != r7) goto L28;
        if (this.mCurLowRam == r6) goto L29;
    L19:
        r6 = (this.mMemInfoReader.getFreeSize() + this.mMemInfoReader.getCachedSize()) + this.mState.mBackgroundProcessMemory;     // Catch: Throwable -> L31
        r7 = this.mState.mServiceProcessMemory;     // Catch: Throwable -> L31
        goto L20
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        RunningState_.MergedItem r5 = (RunningState_.MergedItem) ((ListView) r1).getAdapter().getItem(r3);
        this.mCurSelected = r5;
        startServiceDetailsActivity(r5);
    }

    private void startServiceDetailsActivity(RunningState_.MergedItem r9) {
        if (this.mOwner == null) goto L10;
        if (r9 == null) goto L11;
        Bundle r3 = new Bundle();
        if (r9.mProcess == null) goto L8;
        r3.putInt("uid", r9.mProcess.mUid);
        r3.putString(DBHelper.BATTERY_COL_PROCESS_NAME, r9.mProcess.mProcessName);
    L8:
        r3.putInt("user_id", r9.mUserId);
        r3.putBoolean("background", this.mAdapter.mShowBackground);
        Utils.startActivity(this.mOwner.getActivity(), Utils.onBuildStartFragmentIntent(this.mOwner.getActivity(), RunningServiceDetails.class.getName(), r3, null, R.string.runningservicedetails_settings_title, null, false), 0);
        return;
    L11:
        return;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View r1) {
        this.mActiveItems.remove(r1);
    }

    public RunningProcessesView_(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mActiveItems = new HashMap();
        this.mBuilder = new StringBuilder(128);
        this.mCurTotalRam = -1;
        this.mCurHighRam = -1;
        this.mCurMedRam = -1;
        this.mCurLowRam = -1;
        this.mCurShowCached = false;
        this.mMemInfoReader = new MemInfoReader();
        this.mMyUserId = UserHandle.myUserId();
    }

    public void doCreate() {
        this.mAm = (ActivityManager) getContext().getSystemService("activity");
        this.mState = RunningState_.getInstance(getContext());
        LayoutInflater r0 = (LayoutInflater) getContext().getSystemService("layout_inflater");
        r0.inflate(R.layout.running_processes_view_, this);
        this.mListView = (ListView) findViewById(android.R.id.list);
        View r1 = findViewById(android.R.id.empty);
        if (r1 == null) goto L5;
        this.mListView.setEmptyView(r1);
    L5:
        this.mListView.setOnItemClickListener(this);
        this.mListView.setRecyclerListener(this);
        ServiceListAdapter r2 = new ServiceListAdapter(this, this.mState);
        this.mAdapter = r2;
        this.mListView.setAdapter(r2);
        View r3 = r0.inflate(R.layout.running_processes_header_, null);
        this.mHeader = r3;
        this.mColorBar = (LinearColorBar) r3.findViewById(R.id.color_bar);
        Context r4 = getContext();
        this.mColorBar.setColors(r4.getColor(R.color.running_processes_system_ram), MultiSDKAdapterNew.getColorAccent(r4), r4.getColor(R.color.running_processes_free_ram));
        this.mBackgroundProcessPrefix = (TextView) this.mHeader.findViewById(R.id.freeSizePrefix);
        this.mAppsProcessPrefix = (TextView) this.mHeader.findViewById(R.id.appsSizePrefix);
        this.mForegroundProcessPrefix = (TextView) this.mHeader.findViewById(R.id.systemSizePrefix);
        this.mBackgroundProcessText = (TextView) this.mHeader.findViewById(R.id.freeSize);
        this.mAppsProcessText = (TextView) this.mHeader.findViewById(R.id.appsSize);
        this.mForegroundProcessText = (TextView) this.mHeader.findViewById(R.id.systemSize);
        this.mAvaiSpaceTipsView = (TextView) findViewById(R.id.id_bottom_tips);
        ActivityManager.MemoryInfo r5 = new ActivityManager.MemoryInfo();
        this.mAm.getMemoryInfo(r5);
        this.SECONDARY_SERVER_MEM = r5.secondaryServerThreshold;
    }

    public void doPause() {
        this.mState.pause();
        this.mDataAvail = null;
        this.mOwner = null;
    }

    public boolean doResume(Fragment r1, Runnable r2) {
        this.mOwner = r1;
        this.mState.resume(this);
        if (this.mState.hasData() == false) goto L6;
        refreshUi(true);
        return true;
    L6:
        this.mDataAvail = r2;
        return false;
    }

    void updateTimes() {
        Iterator<ActiveItem> r0 = this.mActiveItems.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ActiveItem r1 = r0.next();
        if (r1.mRootView.getWindowToken() == null) goto L7;
        r1.updateTime(getContext(), this.mBuilder);
        goto L4
    L7:
        r0.remove();
        goto L4
    }

    @Override // com.android.settings.applications.RunningState_.OnRefreshUiListener
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
}
