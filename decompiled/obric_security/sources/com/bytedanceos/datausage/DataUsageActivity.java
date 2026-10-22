package com.bytedanceos.datausage;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AppGlobals;
import android.app.LoaderManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.net.INetworkStatsService;
import android.net.INetworkStatsSession;
import android.net.NetworkPolicy;
import android.net.NetworkPolicyManager;
import android.net.NetworkStats;
import android.net.NetworkStatsHistory;
import android.net.NetworkTemplate;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.NtpTrustedTime;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.telephony.ITelephony;
import com.bytedanceos.cleaner.CleanerUtils;
import com.bytedanceos.cloud.PreferenceMgr;
import com.bytedanceos.oui.MultiSegmentProgressBar;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.utils.ByteConverter;
import com.bytedanceos.utils.ByteUnitPair;
import com.bytedanceos.utils.NetworkPolicyEditor;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.security.R;
import com.obric.security.cleanerpage.DataUsageViewModel;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.security.trafficHigh.TrafficHighWarningReceiver;
import com.obric.security.util.NoticeEventRecorder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import obric.util.DisplayHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageActivity extends BaseActivity implements View.OnClickListener {
    private static final int ENABLE_ALL_NET_RESTRICT_BG = 1;
    private static final String EXTRA_RECHARGE_NUMBER_KEY = "phone_number";
    private static final String EXTRA_RECHARGE_TYPE_KEY = "recharge_type";
    private static int FIRST_SIM_INDEX = 0;
    public static final String FROM = "from";
    private static final String LAST_SUBSCRIBER_PROP = "persist.radio.last.subscriber";
    private static final int LOADER_CHART_DATA = 2;
    private static final int LOADER_SUMMARY = 3;
    public static final int MSG_REFRESH_BTN = 2;
    public static final int MSG_REFRESH_NETWORK = 3;
    public static final int MSG_SIM_CHANGE = 4;
    public static final int MSG_TRAFfICT_NOTIFY = 1;
    private static final long ONE_GB = 1073741824;
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final long ONE_TB = 1099511627776L;
    public static final int OTHER_USER_RANGE_START = -2000;
    public static int PAGE_SLOT = -1;
    private static final String RECHARGE_ACTIVITY = "com.bytedanceos.recharge.activity.RechargeServiceActivity";
    private static final String RECHARGE_PACKAGE = "com.bytedanceos.recharge";
    private static final String RESTRICT_ALL_NET_BG_STATE = "restrict_all_net_background_state";
    private static int SECOND_SIM_INDEX = 1;
    private static final String SOFT_SIM_APP_PKG_NAME = "com.redteamobile.global.roaming";
    private static final String SOFT_SIM_SETTING_CLASS_NAME = "com.redteamobile.roaming.activity.MainActivity";
    public static final String SUBSCRIPTION_KEY = "slot";
    private static final int TAB1_VIEW = 1;
    private static final int TAB2_VIEW = 2;
    private static String TAG = "dataUsage";
    private static final int TYPE_MONTH_ALL = 5;
    private static final int TYPE_MONTH_LEFT = 4;
    private static final int TYPE_MONTH_USED = 1;
    private static final int TYPE_TODAY_USED = 0;
    public static final int TYPE_WEB_TRAFFIC_ORDER = 1;
    NoticeEventRecorder dailyEventRecorder;
    private boolean isInitData;
    private boolean isSlot1Init;
    private boolean isSlot2Init;
    OCardListItem mAppNetControlItem;
    private BarChart mBarChart;
    private View mBarChartContainer;
    private AlertDialog mChargeInstallDialog;
    private ChartData mChartData;
    private final LoaderManager.LoaderCallbacks<ChartData> mChartDataCallbacks;
    private ChartUnit mChartUnit;
    private float mChartYAxisMax;
    private int mCurrentSlot;
    OCardListItem mDataUsageSettingItem;
    private ArrayList<AppItem> mItems;
    private boolean mKeepMonthlyChartDefaultStyle;
    TextView mMonthAll;
    TextView mMonthLeft;
    MultiSegmentProgressBar mMonthProgressBar;
    TextView mMonthUnit;
    private TextView mMonthUsedUnitTv;
    private TextView mMonthUsedValueTv;
    private View mNoCardView;
    private NetworkPolicy mPolicy;
    private NetworkPolicyEditor mPolicyEditor;
    private NetworkPolicyManager mPolicyManager;
    OCardListItem mRechargeItem;
    private boolean mRightAxisOffsetPostPending;
    private AlertDialog mRoamingChargeInstallDialog;
    private boolean mSim1Activied;
    private boolean mSim1Exist;
    private long mSim1Month;
    private long mSim1Today;
    private boolean mSim2Activied;
    private boolean mSim2Exist;
    private long mSim2Month;
    private long mSim2Today;
    private BroadcastReceiver mSimReceiver;
    LinearLayout mSortContainer;
    private INetworkStatsService mStatsService;
    private INetworkStatsSession mStatsSession;
    private final LoaderManager.LoaderCallbacks<NetworkStats> mSummaryCallbacks;
    OTabLayout mTabView;
    View mTabViewContainer;
    TelephonyManager mTelephonyMgr;
    private NetworkTemplate mTemplate;
    private UidDetailProvider mUidDetailProvider;
    public Handler uiHandler;
    private View usageDetail;
    private DataUsageViewModel viewModel;

    /* JADX INFO: renamed from: com.bytedanceos.datausage.DataUsageActivity$1, reason: invalid class name */
    class AnonymousClass1 implements OTabLayoutBase.OnTabSelectedListener {
        final /* synthetic */ DataUsageActivity this$0;

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(OTabLayoutBase.Tab tab) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(OTabLayoutBase.Tab tab) {
        }

        AnonymousClass1(final DataUsageActivity this$0) {
            this.this$0 = this$0;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(OTabLayoutBase.Tab tab) {
            if (tab.getPosition() != 0) goto L6;
            DataUsageActivity.access$002(this.this$0, DataUsageActivity.access$100());
            DataUsageActivity.PAGE_SLOT = DataUsageActivity.access$000(this.this$0);
            this.this$0.mTabView.postDelayed(new DataUsageActivity$1$$ExternalSyntheticLambda0(this), 300);
            return;
        L6:
            if (tab.getPosition() != 1) goto L10;
            DataUsageActivity.access$002(this.this$0, DataUsageActivity.access$200());
            DataUsageActivity.PAGE_SLOT = DataUsageActivity.access$000(this.this$0);
            this.this$0.mTabView.postDelayed(new DataUsageActivity$1$$ExternalSyntheticLambda1(this), 300);
            return;
        }

        /* JADX INFO: renamed from: lambda$onTabSelected$0$com-bytedanceos-datausage-DataUsageActivity$1, reason: not valid java name */
        /* synthetic */ void m106x4354928f() {
            this.this$0.refreshNetworkInfo();
        }

        /* JADX INFO: renamed from: lambda$onTabSelected$1$com-bytedanceos-datausage-DataUsageActivity$1, reason: not valid java name */
        /* synthetic */ void m107xb8ceb8d0() {
            this.this$0.refreshNetworkInfo();
        }
    }

    public static class AppItem implements Comparable<AppItem>, Parcelable {
        public static final Parcelable.Creator<AppItem> CREATOR = null;
        public final int key;
        public String packageName;
        public boolean restricted;
        public long total;
        public SparseBooleanArray uids;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AppItem another) {
            return compareTo2(another);
        }

        public AppItem(int key) {
            this.uids = new SparseBooleanArray();
            this.key = key;
        }

        public AppItem(Parcel parcel) {
            this.uids = new SparseBooleanArray();
            this.key = parcel.readInt();
            this.uids = parcel.readSparseBooleanArray();
            this.total = parcel.readLong();
            this.packageName = parcel.readString();
        }

        public void addUid(int uid) {
            this.uids.put(uid, true);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.key);
            dest.writeSparseBooleanArray(this.uids);
            dest.writeLong(this.total);
            dest.writeString(this.packageName);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(AppItem another) {
            return Long.compare(another.total, this.total);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static class AxisSpec {
        final float axisMaxInUnit;
        final ChartUnit unit;

        AxisSpec(ChartUnit unit, float axisMaxInUnit) {
            this.unit = unit;
            this.axisMaxInUnit = axisMaxInUnit;
        }
    }

    private static final enum ChartUnit extends Enum<ChartUnit> {
        private static final /* synthetic */ ChartUnit[] $VALUES = null;
        public static final ChartUnit B = null;
        public static final ChartUnit GB = null;
        public static final ChartUnit KB = null;
        public static final ChartUnit MB = null;
        public static final ChartUnit TB = null;
        final long bytes;
        final String suffix;

        private static /* synthetic */ ChartUnit[] $values() {
            return new ChartUnit[]{B, KB, MB, GB, TB};
        }

        public static ChartUnit valueOf(String name) {
            return (ChartUnit) Enum.valueOf(ChartUnit.class, name);
        }

        public static ChartUnit[] values() {
            return (ChartUnit[]) $VALUES.clone();
        }

        static {
            B = new ChartUnit("B", 0, "B", 1);
            KB = new ChartUnit("KB", 1, "KB", 1024);
            MB = new ChartUnit("MB", 2, "MB", 1048576);
            GB = new ChartUnit("GB", 3, "GB", 1073741824);
            TB = new ChartUnit("TB", 4, "TB", 1099511627776L);
            $VALUES = $values();
        }

        private ChartUnit(String $enum$name, int $enum$ordinal, String suffix, long bytes) {
            super($enum$name, $enum$ordinal);
            this.suffix = suffix;
            this.bytes = bytes;
        }
    }

    private static class FixedDaysXAxisRenderer extends XAxisRenderer {
        private final int axisColor;
        private float[] fixedEntries;
        private final float tickHeightPx;
        private final Paint tickPaint;

        public FixedDaysXAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer trans, float[] fixedEntries, int axisColor) {
            super(viewPortHandler, xAxis, trans);
            this.fixedEntries = fixedEntries;
            this.axisColor = axisColor;
            Paint r1 = new Paint(1);
            this.tickPaint = r1;
            r1.setStyle(Paint.Style.STROKE);
            r1.setColor(axisColor);
            r1.setStrokeWidth(Utils.convertDpToPixel(0.5f));
            this.tickHeightPx = Utils.convertDpToPixel(3.5f);
        }

        @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
        protected void computeAxisValues(float min, float max) {
            XAxis r2 = this.mXAxis;
            float[] r3 = this.fixedEntries;
            if (r3 != null) goto L5;
            int r4 = 0;
        L6:
            r2.mEntryCount = r4;
            XAxis r5 = this.mXAxis;
            float[] r6 = this.fixedEntries;
            if (r6 != null) goto L9;
            r6 = new float[0];
        L9:
            r5.mEntries = r6;
            this.mXAxis.mCenteredEntries = this.mXAxis.mEntries;
            computeSize();
            return;
        L5:
            r4 = r3.length;
            goto L6
        }

        @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
        public void renderAxisLabels(Canvas c) {
            if (this.mXAxis.isEnabled() == true) goto L5;
            return;
        L5:
            if (this.mXAxis.isDrawLabelsEnabled() == true) goto L7;
            return;
        L7:
            if (this.mXAxis.mEntryCount <= 0) goto L24;
            super.renderAxisLabels(c);
            int r0 = this.mXAxis.mEntryCount * 2;
            float[] r1 = new float[r0];
            int r2 = 0;
            int r3 = 0;
        L10:
            if (r3 >= r0) goto L12;
            r1[r3] = this.mXAxis.mEntries[r3 / 2];
            r1[r3 + 1] = 0.0f;
            r3 = r3 + 2;
            goto L10
        L12:
            this.mTrans.pointValuesToPixel(r1);
            float r4 = this.mViewPortHandler.contentBottom();
            float r10 = r4 + this.tickHeightPx;
        L13:
            if (r2 >= r0) goto L25;
            float r7 = r1[r2];
            if (this.mViewPortHandler.isInBoundsX(r7) == false) goto L17;
            c.drawLine(r7, r4, r7, r10, this.tickPaint);
        L17:
            r2 = r2 + 2;
            goto L13
        L25:
            return;
        }
    }

    private static class MinHeightBarChartRenderer extends BarChartRenderer {
        private final Path barPath;
        private final RectF barRect;
        private final float barYOffsetPx;
        private final float minBarHeightPx;
        private final float shrinkWhenHigherThanPx;
        private final float[] topCornerRadii;
        private final float topCornerRadiusPx;

        public MinHeightBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler, float minBarHeightPx) {
            super(chart, animator, viewPortHandler);
            this.barRect = new RectF();
            this.barPath = new Path();
            this.minBarHeightPx = minBarHeightPx;
            this.barYOffsetPx = DisplayHelper.dpToPx(2);
            this.shrinkWhenHigherThanPx = DisplayHelper.dpToPx(30);
            float r4 = DisplayHelper.dpToPx(1);
            this.topCornerRadiusPx = r4;
            this.topCornerRadii = new float[]{r4, r4, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f};
        }

        @Override // com.github.mikephil.charting.renderer.BarChartRenderer
        protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
            Transformer r0 = this.mChart.getTransformer(dataSet.getAxisDependency());
            this.mBarBorderPaint.setColor(dataSet.getBarBorderColor());
            this.mBarBorderPaint.setStrokeWidth(DisplayHelper.dpToPx((int) dataSet.getBarBorderWidth()));
            int r3 = 0;
            boolean r4 = true;
            if (dataSet.getBarBorderWidth() <= 0.0f) goto L5;
            boolean r1 = true;
        L6:
            float r5 = this.mAnimator.getPhaseX();
            float r6 = this.mAnimator.getPhaseY();
            BarBuffer r7 = this.mBarBuffers[index];
            r7.setPhases(r5, r6);
            r7.setDataSet(index);
            r7.setInverted(this.mChart.isInverted(dataSet.getAxisDependency()));
            r7.setBarWidth(this.mChart.getBarData().getBarWidth());
            r7.feed2(dataSet);
            r0.pointValuesToPixel(r7.buffer);
            if (dataSet.getColors().size() == 1) goto L10;
            r4 = false;
        L10:
            if (r4 == false) goto L13;
            this.mRenderPaint.setColor(dataSet.getColor());
        L13:
            if (r3 >= r7.size()) goto L49;
            int r8 = r3 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(r7.buffer[r8]) == false) goto L48;
            if (this.mViewPortHandler.isInBoundsRight(r7.buffer[r3]) == false) goto L58;
            if (r4 == true) goto L22;
            this.mRenderPaint.setColor(dataSet.getColor(r3 / 4));
        L22:
            float r15 = r7.buffer[r3];
            float r2 = r7.buffer[r3 + 1];
            float r9 = r7.buffer[r8];
            float r10 = r7.buffer[r3 + 3];
            float r11 = Math.abs(r10 - r2);
            if (r11 <= 0.0f) goto L33;
            float r12 = this.minBarHeightPx;
            if (r11 >= r12) goto L33;
            if (r10 <= r2) goto L29;
            r2 = r10 - r12;
        L31:
            if (r2 <= r10) goto L33;
            r10 = r2;
            r2 = r10;
            goto L33
        L29:
            r2 = r12 + r10;
        L33:
            float r13 = this.barYOffsetPx;
            if (r13 > 0.0f) goto L36;
        L40:
            this.barRect.set(r15, r2, r9, r10);
            if (this.topCornerRadiusPx <= 0.0f) goto L45;
            this.barPath.reset();
            this.barPath.addRoundRect(this.barRect, this.topCornerRadii, Path.Direction.CW);
            c.drawPath(this.barPath, this.mRenderPaint);
            if (r1 == false) goto L48;
            c.drawPath(this.barPath, this.mBarBorderPaint);
            goto L48
        L45:
            c.drawRect(this.barRect, this.mRenderPaint);
            if (r1 == false) goto L48;
            c.drawRect(this.barRect, this.mBarBorderPaint);
            goto L48
        L36:
            if ((r10 - r2) > this.shrinkWhenHigherThanPx) goto L39;
            r2 = r2 - r13;
        L39:
            r10 = r10 - r13;
            goto L40
        L58:
            return;
        L48:
            r3 = r3 + 4;
            goto L13
        L49:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
    }

    public static int buildKeyForUser(int userHandle) {
        return (-2000) - userHandle;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected boolean enablePerformanceActivityResumePeriod() {
        return true;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performancePageScene() {
        return PerformanceScenes.PAGE_PERMISSION_DATA_USAGE;
    }

    @Override // com.bytedanceos.security.BaseActivity
    protected String performanceThreadsSceneOnRealShow() {
        return PerformanceScenes.THREAD_PERMISSION_DATA_USAGE_LOAD;
    }

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "data_management_home_page";
    }

    public DataUsageActivity() {
        this.mChartUnit = ChartUnit.MB;
        this.mChartYAxisMax = 0.0f;
        this.mKeepMonthlyChartDefaultStyle = false;
        this.mRightAxisOffsetPostPending = false;
        this.mCurrentSlot = 0;
        this.isSlot1Init = false;
        this.isSlot2Init = false;
        this.mSim1Activied = false;
        this.mSim2Activied = false;
        this.mSim1Exist = false;
        this.mSim2Exist = false;
        this.isInitData = false;
        this.dailyEventRecorder = null;
        this.mChartDataCallbacks = new AnonymousClass5(this);
        this.mSimReceiver = new AnonymousClass7(this);
        this.mSummaryCallbacks = new AnonymousClass10(this);
        this.mItems = new ArrayList();
    }

    static /* synthetic */ int access$000(DataUsageActivity r0) {
        return r0.mCurrentSlot;
    }

    static /* synthetic */ int access$002(DataUsageActivity r0, int r1) {
        r0.mCurrentSlot = r1;
        return r1;
    }

    static /* synthetic */ int access$100() {
        return FIRST_SIM_INDEX;
    }

    static /* synthetic */ boolean access$1002(DataUsageActivity r0, boolean r1) {
        r0.mRightAxisOffsetPostPending = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(DataUsageActivity r0) {
        r0.updateRightAxisExtraOffset();
    }

    static /* synthetic */ BarChart access$1200(DataUsageActivity r0) {
        return r0.mBarChart;
    }

    static /* synthetic */ String access$1300() {
        return TAG;
    }

    static /* synthetic */ NetworkPolicyManager access$1400(DataUsageActivity r0) {
        return r0.mPolicyManager;
    }

    static /* synthetic */ ArrayList access$1500(DataUsageActivity r0) {
        return r0.mItems;
    }

    static /* synthetic */ UidDetailProvider access$1600(DataUsageActivity r0) {
        return r0.mUidDetailProvider;
    }

    static /* synthetic */ int access$200() {
        return SECOND_SIM_INDEX;
    }

    static /* synthetic */ void access$300(DataUsageActivity r0) {
        r0.refreshUI();
    }

    static /* synthetic */ void access$400(DataUsageActivity r0, boolean r1) {
        r0.updateSimCardInfo(r1);
    }

    static /* synthetic */ ChartUnit access$500(DataUsageActivity r0) {
        return r0.mChartUnit;
    }

    static /* synthetic */ INetworkStatsSession access$600(DataUsageActivity r0) {
        return r0.mStatsSession;
    }

    static /* synthetic */ ChartData access$702(DataUsageActivity r0, ChartData r1) {
        r0.mChartData = r1;
        return r1;
    }

    static /* synthetic */ void access$800(DataUsageActivity r0) {
        r0.updateDetailData();
    }

    static /* synthetic */ void access$900(DataUsageActivity r0) {
        r0.updateMonthlyBarChart();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_usage_activity_layout_main);
        if (TrafficHighWarningReceiver.FROM_TRAFFIC_HIGH_WARNING.equals(getIntent().getStringExtra("from")) == false) goto L5;
        this.dailyEventRecorder = new NoticeEventRecorder(this);
        this.dailyEventRecorder.recordCurrentTime(TrafficHighWarningReceiver.PREF_TRAFFIC_WARNING_DAY_TIME + getIntent().getIntExtra(TrafficHighWarningReceiver.EXTRA_SUB_ID, 0), NoticeEventRecorder.CycleType.NOON_TO_NOON);
    L5:
        this.viewModel = DataUsageViewModel.Companion.getDataUsageViewModel(this);
        initObserve();
        if (PreferenceMgr.getInstance(this).isAllowed() == true) goto L8;
        this.viewModel.popPermissionDialogIfNeeded(this, PreferenceMgr.getInstance(this).isAllowed());
    L8:
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mTelephonyMgr = (TelephonyManager) getApplicationContext().getSystemService("phone");
        initTitleBar(false, false);
        this.mTitle.setCenterTitle(getString(R.string.mobile_data_manager));
        this.mMonthLeft = (TextView) findViewById(R.id.data_usage_left_tv);
        this.mMonthAll = (TextView) findViewById(R.id.tv_detail);
        this.mMonthUnit = (TextView) findViewById(R.id.tv_used_unit);
        this.mMonthUsedValueTv = (TextView) findViewById(R.id.data_usage_left_tv_chart);
        this.mMonthUsedUnitTv = (TextView) findViewById(R.id.tv_used_unit_chart);
        MultiSegmentProgressBar r5 = (MultiSegmentProgressBar) findViewById(R.id.storage_progress);
        this.mMonthProgressBar = r5;
        if (r5 == null) goto L11;
        r5.setAnimationDuration(0);
    L11:
        this.usageDetail = findViewById(R.id.data_usage_detail);
        this.mNoCardView = findViewById(R.id.data_usage_no_card);
        this.mBarChartContainer = findViewById(R.id.cl_barChart);
        this.mBarChart = (BarChart) findViewById(R.id.chart);
        initMonthlyBarChart();
        OTabLayout r6 = (OTabLayout) findViewById(R.id.cycle_view);
        this.mTabView = r6;
        this.mTabViewContainer = (View) r6.getParent();
        this.mTabView.addOnTabSelectedListener(new AnonymousClass1(this));
        OCardListItem r7 = (OCardListItem) findViewById(R.id.item_recharge);
        this.mRechargeItem = r7;
        r7.setCustomEndView(0);
        this.mRechargeItem.showCustomEnd(true);
        this.mDataUsageSettingItem = (OCardListItem) findViewById(R.id.item_data_usage_settings);
        this.mAppNetControlItem = (OCardListItem) findViewById(R.id.app_network_control_settings);
        this.mSortContainer = (LinearLayout) findViewById(R.id.list_container);
        this.mDataUsageSettingItem.setDefaultTailIcon(0);
        this.mDataUsageSettingItem.showTailIcon(true);
        this.mAppNetControlItem.setDefaultTailIcon(0);
        this.mAppNetControlItem.showTailIcon(true);
        OCardListItem r8 = this.mRechargeItem;
        if (r8 == null) goto L14;
        r8.setOnContentClickListener(new DataUsageActivity$$ExternalSyntheticLambda0(this));
        this.mRechargeItem.setCardPosition(1);
    L14:
        OCardListItem r9 = this.mAppNetControlItem;
        if (r9 == null) goto L17;
        r9.setOnContentClickListener(new DataUsageActivity$$ExternalSyntheticLambda1(this));
        this.mAppNetControlItem.setCardPosition(3);
    L17:
        OCardListItem r10 = this.mDataUsageSettingItem;
        if (r10 == null) goto L21;
        r10.setOnContentClickListener(new DataUsageActivity$$ExternalSyntheticLambda2(this));
        this.mDataUsageSettingItem.setCardPosition(1);
    L21:
        if (PreferenceMgr.getInstance(this).isAllowed() == false) goto L23;
        initData();
    L23:
        this.uiHandler = new AnonymousClass2(this);
        this.mUidDetailProvider = new UidDetailProvider(this);
        updateViewWidth(R.id.ll_container);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-bytedanceos-datausage-DataUsageActivity, reason: not valid java name */
    /* synthetic */ void m103lambda$onCreate$0$combytedanceosdatausageDataUsageActivity(View r1) {
        launchRecharge(this);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-bytedanceos-datausage-DataUsageActivity, reason: not valid java name */
    /* synthetic */ void m104lambda$onCreate$1$combytedanceosdatausageDataUsageActivity(View r3) {
        Intent r4 = new Intent();
        r4.setClassName("com.obric.security", "com.bytedanceos.datausage.AppNetworkControlActivity");
        r4.putExtra("title_id", R.string.network_background_control);
        if (isFromSecurityCenter() == false) goto L5;
        String r0 = getString(R.string.data_usage_title);
    L6:
        r4.putExtra("back_text", r0);
        r4.putExtra(com.bytedanceos.security.Utils.INTENT_KEY_FROM_CENTER, true);
        startActivity(r4);
        return;
    L5:
        r0 = getString(R.string.data_usage_title_long);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-bytedanceos-datausage-DataUsageActivity, reason: not valid java name */
    /* synthetic */ void m105lambda$onCreate$2$combytedanceosdatausageDataUsageActivity(View r1) {
        LaunchDatausageSetting();
    }

    private void initMonthlyBarChart() {
        BarChart r0 = this.mBarChart;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setNoDataText("");
        this.mBarChart.getDescription().setEnabled(false);
        this.mBarChart.getLegend().setEnabled(false);
        this.mBarChart.setTouchEnabled(false);
        this.mBarChart.setScaleEnabled(false);
        this.mBarChart.setPinchZoom(false);
        this.mBarChart.setDoubleTapToZoomEnabled(false);
        this.mBarChart.setMinOffset(8.0f);
        this.mBarChart.setExtraBottomOffset(10.0f);
        XAxis r1 = this.mBarChart.getXAxis();
        r1.setPosition(XAxis.XAxisPosition.BOTTOM);
        r1.setDrawGridLines(false);
        r1.setDrawAxisLine(false);
        r1.setGranularity(1.0f);
        int r9 = getColor(R.color.oui_text_3b);
        int r10 = getColor(R.color.oui_line_3);
        r1.setTextColor(r9);
        r1.setTextSize(12.0f);
        r1.setAvoidFirstLastClipping(false);
        this.mBarChart.setXAxisRenderer(new FixedDaysXAxisRenderer(this.mBarChart.getViewPortHandler(), r1, this.mBarChart.getTransformer(YAxis.AxisDependency.LEFT), new float[]{4.0f, 11.0f, 18.0f, 25.0f}, r10));
        r1.setValueFormatter(new AnonymousClass3(this));
        YAxis r2 = this.mBarChart.getAxisLeft();
        r2.setDrawAxisLine(false);
        r2.setDrawGridLines(true);
        r2.setGridColor(r10);
        r2.setGridLineWidth(0.5f);
        r2.setAxisMinimum(0.0f);
        r2.setLabelCount(3, true);
        r2.setDrawLabels(false);
        YAxis r3 = this.mBarChart.getAxisRight();
        r3.setEnabled(true);
        r3.setDrawAxisLine(false);
        r3.setDrawGridLines(false);
        r3.setLabelCount(3, true);
        r3.setTextColor(r9);
        r3.setTextSize(12.0f);
        r3.setAxisMinimum(0.0f);
        r3.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        r3.setValueFormatter(new AnonymousClass4(this));
        applyMonthlyChartDefaultStyle();
        BarChart r4 = this.mBarChart;
        BarChart r5 = this.mBarChart;
        r4.setRenderer(new MinHeightBarChartRenderer(r5, r5.getAnimator(), this.mBarChart.getViewPortHandler(), 1.0f));
    }

    private void applyMonthlyChartDefaultStyle() {
        if (this.mBarChart != null) goto L5;
        return;
    L5:
        this.mKeepMonthlyChartDefaultStyle = true;
        this.mChartUnit = ChartUnit.MB;
        this.mChartYAxisMax = 128.0f;
        this.mBarChart.setExtraRightOffset(0.0f);
        int r1 = Calendar.getInstance().getActualMaximum(5);
        XAxis r3 = this.mBarChart.getXAxis();
        r3.setAxisMinimum(0.5f);
        r3.setAxisMaximum(r1 + 0.5f);
        YAxis r2 = this.mBarChart.getAxisLeft();
        r2.setAxisMinimum(0.0f);
        r2.setAxisMaximum(this.mChartYAxisMax);
        r2.setLabelCount(3, true);
        r2.setGranularity(this.mChartYAxisMax / 2.0f);
        YAxis r4 = this.mBarChart.getAxisRight();
        r4.setAxisMinimum(0.0f);
        r4.setAxisMaximum(this.mChartYAxisMax);
        r4.setLabelCount(3, true);
        r4.setGranularity(this.mChartYAxisMax / 2.0f);
        this.mBarChart.setData(new BarData());
        this.mBarChart.notifyDataSetChanged();
        this.mBarChart.invalidate();
        updateRightAxisExtraOffset();
    }

    private void initData() {
        if (this.isInitData == false) goto L5;
        return;
    L5:
        this.isInitData = true;
        long r1 = SystemClock.elapsedRealtime();
        this.mStatsService = INetworkStatsService.Stub.asInterface(ServiceManager.getService("netstats"));
        this.mPolicyManager = NetworkPolicyManager.from(this);
        NetworkPolicyEditor r3 = new NetworkPolicyEditor(this.mPolicyManager);
        this.mPolicyEditor = r3;
        r3.read();
        String r4 = getActiveSubscriberId();
        if (r4 == null) goto L16;
        NetworkTemplate r5 = NetworkTemplate.buildTemplateMobileAll(r4);
        this.mTemplate = r5;
        NetworkPolicy r6 = this.mPolicyEditor.getPolicy(r5);
        this.mPolicy = r6;
        if (r6 != null) goto L16;
        Time r7 = new Time();
        r7.setToNow();
        NetworkPolicy r14 = new NetworkPolicy(this.mTemplate, r7.monthDay, r7.timezone, -1, -1, -1, -1, true, true);
        this.mPolicy = r14;
        this.mPolicyEditor.addPolicy(r14);
    L16:
        this.mStatsSession = this.mStatsService.openSession();     // Catch: RemoteException -> L13
        PerformanceMonitors.reportActionTime(PerformanceScenes.ACTION_PERMISSION_DATA_USAGE_INIT, SystemClock.elapsedRealtime() - r1);
        return;
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void initObserve() {
        this.viewModel.getAgreeGrant().observe(this, new DataUsageActivity$$ExternalSyntheticLambda3(this));
    }

    /* JADX INFO: renamed from: lambda$initObserve$3$com-bytedanceos-datausage-DataUsageActivity, reason: not valid java name */
    /* synthetic */ void m102lambda$initObserve$3$combytedanceosdatausageDataUsageActivity(Boolean r1) {
        if (r1.booleanValue() == true) goto L6;
        finish();
        return;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (PreferenceMgr.getInstance(this).isAllowed() == false) goto L5;
        initData();
        registerReceiver(this.mSimReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        updateSimCardInfo(true);
    L5:
        PAGE_SLOT = this.mCurrentSlot;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        OLog.d(TAG, "onPause called", new Throwable("Check Stack Trace"));
        if (PreferenceMgr.getInstance(this).isAllowed() == false) goto L5;
        unregisterReceiver(this.mSimReceiver);
    L5:
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        PAGE_SLOT = -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.bytedanceos.security.Utils.isFastDoubleClick() == false) goto L6;
        return;
    L6:
        switch(view.getId()) {
            case 2131296439: goto L11;
            case 2131297017: goto L10;
            case 2131297158: goto L9;
            case 2131297166: goto L8;
            default: goto L20;
        };
    L8:
        launchRecharge(this);
        return;
    L9:
        LaunchDatausageSetting();
        return;
    L10:
        CleanerUtils.showToast(getApplicationContext(), R.string.feature_unavailable);
        return;
    L11:
        Intent r3 = new Intent();
        r3.setClassName("com.obric.security", "com.bytedanceos.datausage.AppNetworkControlActivity");
        r3.putExtra("title_id", R.string.network_background_control);
        if (isFromSecurityCenter() == false) goto L14;
        String r0 = getString(R.string.data_usage_title);
    L15:
        r3.putExtra("back_text", r0);
        r3.putExtra(com.bytedanceos.security.Utils.INTENT_KEY_FROM_CENTER, true);
        startActivity(r3);
        return;
    L14:
        r0 = getString(R.string.data_usage_title_long);
        goto L15
    }

    public void refreshNetworkInfo() {
        OLog.d(TAG, "refreshNetworkInfo is called");
        String r0 = getActiveSubscriberId();
        if (r0 != null) goto L6;
        updateDetailUI(false);
        return;
    L6:
        updateDetailUI(true);
        this.mTemplate = NetworkTemplate.buildTemplateMobileAll(r0);
        getLoaderManager().restartLoader(2, ChartDataLoader.buildArgs(this.mTemplate, null), this.mChartDataCallbacks);
    }

    void updateDetailUI(boolean visible) {
        if (visible == false) goto L4;
        this.usageDetail.setVisibility(0);
        return;
    L4:
        this.usageDetail.setVisibility(8);
    }

    private void refreshUI() {
        if (DatausageUtils.isPhoneChargeSupport(this) == false) goto L5;
        this.mRechargeItem.setVisibility(8);
        this.mRechargeItem.setEnabled(DatausageUtils.isPhoneChargeInstalled(this));
    L6:
        caculateSettlement();
        if (this.mCurrentSlot != FIRST_SIM_INDEX) goto L9;
        long r0 = this.mSim1Month;
    L10:
        formatFileSize(r0, 1, false);
        if (this.mCurrentSlot != FIRST_SIM_INDEX) goto L13;
        long r1 = this.mSim1Today;
    L14:
        formatFileSize(r1, 0, false);
        updateLimitSubtitle();
        return;
    L13:
        r1 = this.mSim2Today;
        goto L14
    L9:
        r0 = this.mSim2Month;
        goto L10
    L5:
        this.mRechargeItem.setVisibility(8);
        goto L6
    }

    private void updateLimitSubtitle() {
        this.mPolicyEditor.read();
        String r1 = getActiveSubscriberId();
        if (r1 != null) goto L9;
        TextView r2 = this.mMonthAll;
        if (r2 == null) goto L7;
        r2.setText("--");
    L7:
        updateMonthProgress(0.0f);
        return;
    L9:
        NetworkTemplate r3 = NetworkTemplate.buildTemplateMobileAll(r1);
        this.mTemplate = r3;
        NetworkPolicy r4 = this.mPolicyEditor.getPolicy(r3);
        this.mPolicy = r4;
        if (r4 != null) goto L13;
        Time r5 = new Time();
        r5.setToNow();
        NetworkPolicy r14 = new NetworkPolicy(this.mTemplate, r5.monthDay, r5.timezone, -1, -1, -1, -1, true, true);
        this.mPolicy = r14;
        this.mPolicyEditor.addPolicy(r14);
    L13:
        if (this.mPolicy.warningBytes <= 0) goto L15;
        formatFileSize(this.mPolicy.warningBytes, 5, false);
        return;
    L15:
        TextView r6 = this.mMonthAll;
        if (r6 == null) goto L18;
        r6.setText("--");
    L18:
        updateMonthProgress(0.0f);
    }

    private void updateMonthlyBarChart() {
        if (this.mBarChart != null) goto L6;
        return;
    L6:
        if (this.mKeepMonthlyChartDefaultStyle == false) goto L8;
        return;
    L8:
        ChartData r1 = this.mChartData;
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.network == null) goto L45;
        Calendar r2 = Calendar.getInstance();
        r2.set(11, 0);
        r2.set(12, 0);
        r2.set(13, 0);
        r2.set(14, 0);
        r2.set(5, 1);
        r2.getTimeInMillis();
        int r5 = r2.getActualMaximum(5);
        NtpTrustedTime r6 = NtpTrustedTime.getInstance(this);
        if (r6.hasCache() == false) goto L16;
        long r7 = r6.currentTimeMillis();
    L17:
        long[] r15 = new long[r5 + 1];
        int r13 = 1;
        long r18 = 0;
    L18:
        if (r13 > r5) goto L30;
        Calendar r8 = (Calendar) r2.clone();
        r8.set(5, r13);
        long r9 = r8.getTimeInMillis();
        Calendar r10 = (Calendar) r8.clone();
        r10.add(5, 1);
        long r11 = r10.getTimeInMillis();
        if (r9 <= r7) goto L22;
        r15[r13] = 0;
        int r21 = r13;
        long[] r22 = r15;
    L29:
        r13 = r21 + 1;
        r15 = r22;
        goto L18
    L22:
        r21 = r13;
        r22 = r15;
        NetworkStatsHistory.Entry r12 = this.mChartData.network.getValues(r9, Math.min(r11, r7), r7, null);
        if (r12 != null) goto L25;
        long r14 = 0;
    L26:
        r22[r21] = r14;
        if (r14 <= r18) goto L29;
        r18 = r14;
        goto L29
    L25:
        r14 = r12.rxBytes + r12.txBytes;
        goto L26
    L30:
        long[] r23 = r15;
        if (r18 > 0) goto L34;
        applyMonthlyChartDefaultStyle();
        return;
    L34:
        AxisSpec r3 = computeAxisSpec(r18);
        this.mChartUnit = r3.unit;
        this.mChartYAxisMax = r3.axisMaxInUnit;
        ArrayList r4 = new ArrayList();
        int r16 = 1;
    L35:
        if (r16 > r5) goto L37;
        r4.add(new BarEntry(r16, r23[r16] / this.mChartUnit.bytes));
        r16 = r16 + 1;
        goto L35
    L37:
        BarDataSet r17 = new BarDataSet(r4, "");
        r17.setColor(Color.parseColor("#00BF00"));
        r17.setDrawValues(false);
        r17.setHighLightAlpha(0);
        r17.setHighlightEnabled(false);
        BarData r19 = new BarData(new IBarDataSet[]{r17});
        r19.setBarWidth(0.6f);
        this.mBarChart.setData(r19);
        XAxis r20 = this.mBarChart.getXAxis();
        r20.setAxisMinimum(0.5f);
        r20.setAxisMaximum(r5 + 0.5f);
        YAxis r24 = this.mBarChart.getAxisLeft();
        r24.setAxisMinimum(0.0f);
        r24.setAxisMaximum(this.mChartYAxisMax);
        r24.setLabelCount(3, true);
        r24.setGranularity(this.mChartYAxisMax / 2.0f);
        YAxis r25 = this.mBarChart.getAxisRight();
        r25.setAxisMinimum(0.0f);
        r25.setAxisMaximum(this.mChartYAxisMax);
        r25.setLabelCount(3, true);
        r25.setGranularity(this.mChartYAxisMax / 2.0f);
        updateRightAxisExtraOffset();
        this.mBarChart.notifyDataSetChanged();
        this.mBarChart.invalidate();
        return;
    L16:
        r7 = System.currentTimeMillis();
        goto L17
    }

    private void updateRightAxisExtraOffset() {
        BarChart r0 = this.mBarChart;
        if (r0 != null) goto L5;
        return;
    L5:
        YAxis r1 = r0.getAxisRight();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.isEnabled() == true) goto L11;
        return;
    L11:
        if (this.mBarChart.getWidth() <= 0) goto L21;
        if (this.mBarChart.getHeight() <= 0) goto L21;
        float r3 = 0.0f;
        this.mBarChart.setExtraRightOffset(0.0f);
        this.mBarChart.notifyDataSetChanged();
        ValueFormatter r2 = r1.getValueFormatter();
        float r4 = r1.getAxisMaximum();
        String r6 = r2.getFormattedValue(0.0f);
        String r5 = r2.getFormattedValue(r4 / 2.0f);
        String r7 = r2.getFormattedValue(r4);
        Paint r8 = new Paint(1);
        r8.setTextSize(r1.getTextSize());
        r8.setTypeface(r1.getTypeface());
        float r9 = Math.max(0.0f, (Math.max(r8.measureText(r6), Math.max(r8.measureText(r5), r8.measureText(r7))) + Utils.convertDpToPixel(6.0f)) - this.mBarChart.getViewPortHandler().offsetRight());
        float r10 = getResources().getDisplayMetrics().density;
        if (r10 <= 0.0f) goto L18;
        r3 = r9 / r10;
    L18:
        this.mBarChart.setExtraRightOffset(r3);
        this.mBarChart.notifyDataSetChanged();
        return;
    L21:
        if (this.mRightAxisOffsetPostPending == true) goto L25;
        this.mRightAxisOffsetPostPending = true;
        this.mBarChart.post(new AnonymousClass6(this));
        return;
    }

    private static AxisSpec computeAxisSpec(long maxBytes) {
        if (maxBytes <= 0) goto L5;
        double r7 = maxBytes * 1.05d;
        if (r7 >= 1024.0d) goto L10;
        ChartUnit r0 = ChartUnit.B;
    L19:
        long r1 = 1;
    L21:
        if (r1 >= Math.ceil(r7 / r0.bytes)) goto L24;
        r1 = r1 << 1;
        goto L21
    L24:
        return new AxisSpec(r0, r1);
    L10:
        if (r7 >= 1048576.0d) goto L13;
        r0 = ChartUnit.KB;
        goto L19
    L13:
        if (r7 >= 1.073741824E9d) goto L16;
        r0 = ChartUnit.MB;
        goto L19
    L16:
        if (r7 >= 1.099511627776E12d) goto L18;
        r0 = ChartUnit.GB;
        goto L19
    L18:
        r0 = ChartUnit.TB;
        goto L19
    L5:
        return new AxisSpec(ChartUnit.MB, 128.0f);
    }

    private void updateDetailData() {
        OLog.d(TAG, "updateDetailData " + this.mCurrentSlot);
        NtpTrustedTime r1 = NtpTrustedTime.getInstance(this);
        if (r1.hasCache() == false) goto L5;
        long r2 = r1.currentTimeMillis();
    L6:
        Calendar r3 = Calendar.getInstance();
        r3.set(11, 0);
        r3.set(12, 0);
        r3.set(13, 0);
        long r4 = r3.getTimeInMillis();
        ChartData r5 = this.mChartData;
        NetworkStatsHistory.Entry r15 = null;
        if (r5 != null) goto L9;
    L11:
        NetworkStatsHistory.Entry r6 = null;
    L13:
        if (r6 == null) goto L15;
        long r8 = r6.rxBytes + r6.txBytes;
    L16:
        Calendar r7 = Calendar.getInstance();
        r7.set(11, 0);
        r7.set(12, 0);
        r7.set(13, 0);
        r7.set(5, 1);
        long r13 = r7.getTimeInMillis();
        ChartData r9 = this.mChartData;
        if (r9 == null) goto L22;
        if (r9.network == null) goto L22;
        r15 = this.mChartData.network.getValues(r13, r2, r2, null);
        OLog.d(TAG, "updateDetailData entryMonth" + r15 + " startMonth: " + r13 + ",end:" + r2 + ",now: " + r2 + ",mChartData.network: " + this.mChartData.network);
    L22:
        if (r15 == null) goto L24;
        long r10 = r15.rxBytes + r15.txBytes;
    L26:
        if (r10 > 0) goto L28;
        applyMonthlyChartDefaultStyle();
    L29:
        int r11 = this.mCurrentSlot;
        if (r11 != FIRST_SIM_INDEX) goto L32;
        this.mSim1Today = r8;
        this.mSim1Month = r10;
        this.isSlot1Init = true;
    L35:
        getLoaderManager().restartLoader(3, SummaryForAllUidLoader.buildArgs(this.mTemplate, r13, r2), this.mSummaryCallbacks);
        this.uiHandler.removeMessages(1);
        this.uiHandler.sendMessage(this.uiHandler.obtainMessage(1));
        return;
    L32:
        long r12 = r8;
        if (r11 != SECOND_SIM_INDEX) goto L35;
        this.mSim2Today = r12;
        this.mSim2Month = r10;
        this.isSlot2Init = true;
        goto L35
    L28:
        this.mKeepMonthlyChartDefaultStyle = false;
        goto L29
    L24:
        r10 = 0;
        goto L26
    L15:
        r8 = 0;
        goto L16
    L9:
        if (r5.network == null) goto L11;
        r6 = this.mChartData.network.getValues(r4, r2, r2, null);
        goto L13
    L5:
        r2 = System.currentTimeMillis();
        goto L6
    }

    private String getActiveSubscriberId() {
        String r0 = this.mTelephonyMgr.getSubscriberId(MultiSimAdapter.slot2Sub(this.mCurrentSlot));
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLastSubscriberId();
    }

    private String getLastSubscriberId() {
        return TelephonyManager.getTelephonyProperty(this.mCurrentSlot, LAST_SUBSCRIBER_PROP, null);
    }

    private void formatFileSize(long size, int type, boolean isKB) {
        if (size >= 0) goto L5;
        ByteUnitPair r3 = null;
        String r4 = "--";
    L7:
        if (type != 1) goto L9;
        TextView r8 = this.mMonthUsedValueTv;
        if (r8 == null) goto L44;
        r8.setText(r4);
    L44:
        TextView r9 = this.mMonthUsedUnitTv;
        if (r9 == null) goto L50;
        if (r3 == null) goto L48;
        String r10 = r3.unit;
    L49:
        r9.setText(r10);
        goto L50
    L48:
        r10 = "";
    L50:
        if (size > 0) goto L53;
        applyMonthlyChartDefaultStyle();
        return;
    L53:
        if (this.mKeepMonthlyChartDefaultStyle == false) goto L61;
        this.mKeepMonthlyChartDefaultStyle = false;
        updateMonthlyBarChart();
        return;
    L61:
        return;
    L9:
        if (type != 4) goto L11;
        this.mMonthLeft.setText(r4);
        this.mMonthUnit.setText(r3.unit);
        return;
    L11:
        if (type != 5) goto L62;
        if (r3 == null) goto L39;
        this.mMonthAll.setText(getResources().getString(R.string.total) + r4 + r3.unit);
        int r11 = this.mCurrentSlot;
        int r2 = FIRST_SIM_INDEX;
        if (r11 != r2) goto L17;
        boolean r5 = this.isSlot1Init;
    L18:
        if (r5 == false) goto L63;
        if (r11 != r2) goto L22;
        long r6 = this.mSim1Month;
    L23:
        if (size <= 0) goto L35;
        long r12 = size - r6;
        if (r12 >= 0) goto L27;
        r12 = 0;
    L27:
        float r7 = r12 / size;
        if (r12 <= 0) goto L33;
        if (r7 >= 0.001f) goto L33;
        r7 = r7 + 0.01f;
    L37:
        if (r6 == 0) goto L56;
        updateMonthProgress(r7);
        return;
    L56:
        return;
    L33:
        if (r6 <= 0) goto L37;
        r7 = r7 - 0.001f;
        goto L37
    L35:
        r7 = 0.0f;
        goto L37
    L22:
        r6 = this.mSim2Month;
        goto L23
    L63:
        return;
    L17:
        r5 = this.isSlot2Init;
        goto L18
    L39:
        this.mMonthAll.setText("--");
        return;
    L62:
        return;
    L5:
        r3 = ByteConverter.convert(size, "B", 1024);
        r4 = r3.value;
        goto L7
    }

    private void updateMonthProgress(float percent) {
        if (this.mMonthProgressBar != null) goto L5;
        return;
    L5:
        float r0 = 1.0f - Math.max(0.0f, Math.min(1.0f, percent));
        float r7 = getResources().getDisplayMetrics().density * 8.0f;
        this.mMonthProgressBar.setSegments(Arrays.asList(new MultiSegmentProgressBar.Segment[]{new MultiSegmentProgressBar.Segment(getResources().getColor(R.color.oui_blue_6), r0, new float[]{r7, r7, 0.0f, 0.0f, 0.0f, 0.0f, r7, r7})}));
    }

    private void caculateSettlement() {
        Calendar r1 = Calendar.getInstance();
        r1.getActualMaximum(5);
        r1.get(5);
    }

    public void launchRecharge(Context context) {
        Intent r4 = new Intent();
        r4.setComponent(new ComponentName("com.bytedanceos.recharge", RECHARGE_ACTIVITY));
        r4.putExtra(EXTRA_RECHARGE_NUMBER_KEY, bytedanceos.util.MultiSimAdapter.getLine1Number(this.mCurrentSlot));
        r4.putExtra(EXTRA_RECHARGE_TYPE_KEY, 1);
        r4.putExtra(com.bytedanceos.security.Utils.INTENT_KEY_FROM_CENTER, true);
        r4.putExtra("exposure", 4);
        if (isFromSecurityCenter() == false) goto L5;
        String r0 = "data_usage_title";
    L6:
        r4.putExtra("back_text_res_name", r0);
        startActivity(r4);
        return;
    L5:
        r0 = "data_usage_title_long";
        goto L6
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler r1 = this.uiHandler;
        if (r1 == null) goto L6;
        r1.removeCallbacksAndMessages(null);
        return;
    }

    private void updateSimCardInfo(boolean refreshUI) {
        this.mSim1Activied = DatausageUtils.isSubActive(this, FIRST_SIM_INDEX);
        this.mSim2Activied = DatausageUtils.isSubActive(this, SECOND_SIM_INDEX);
        if (DatausageUtils.hasMultiSimInDevice() == true) goto L5;
    L9:
        this.mSim1Exist = bytedanceos.util.MultiSimAdapter.hasIccCard(FIRST_SIM_INDEX);
        boolean r0 = bytedanceos.util.MultiSimAdapter.hasIccCard(SECOND_SIM_INDEX);
        this.mSim2Exist = r0;
        if (r0 == true) goto L12;
    L14:
        int r1 = FIRST_SIM_INDEX;
        this.mCurrentSlot = r1;
        PAGE_SLOT = r1;
    L15:
        this.mTabViewContainer.setVisibility(8);
        this.mTitle.setCenterTitle(getString(R.string.mobile_data_manager));
    L16:
        updateNoCardStateUi();
        if (refreshUI == false) goto L19;
        refreshNetworkInfo();
    L19:
        this.isSlot1Init = false;
        this.isSlot2Init = false;
        return;
    L12:
        if (this.mSim2Activied == false) goto L14;
        int r2 = SECOND_SIM_INDEX;
        this.mCurrentSlot = r2;
        PAGE_SLOT = r2;
        goto L15
    L5:
        if (this.mSim1Activied == false) goto L9;
        if (this.mSim2Activied == false) goto L9;
        this.mSim1Exist = true;
        this.mSim2Exist = true;
        this.mTitle.setCenterTitle("");
        this.mTabViewContainer.setVisibility(0);
        goto L16
    }

    private void updateNoCardStateUi() {
        int r1 = 0;
        if (this.mSim1Exist == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        View r2 = this.mNoCardView;
        if (r2 == null) goto L15;
        if (r0 == false) goto L13;
        int r4 = 8;
    L14:
        r2.setVisibility(r4);
        goto L15
    L13:
        r4 = 0;
    L15:
        View r5 = this.mBarChartContainer;
        if (r5 == null) goto L22;
        if (r0 == true) goto L20;
        r1 = 8;
    L20:
        r5.setVisibility(r1);
        return;
    L22:
        return;
    L5:
        if (this.mSim2Exist == true) goto L8;
        r0 = false;
        goto L9
    }

    private String getOperationName(int subscription) {
        ITelephony r0 = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        String r6 = null;
        if (r0 != null) goto L13;
    L7:
        OLog.d(TAG, "getOperationName " + r6);
        if (r6 != null) goto L11;
        return "";
    L11:
        return r6;
    L13:
        r0.getDisplayPlmnMsim(null, null, null, false, subscription);     // Catch: RemoteException -> L12
        r6 = "";
        goto L7
    }

    private void LaunchDatausageSetting() {
        Intent r0 = new Intent();
        r0.setClassName("com.obric.security", "com.bytedanceos.datausage.DataUsageDetailActivity");
        r0.putExtra(com.bytedanceos.security.Utils.INTENT_KEY_FROM_CENTER, true);
        r0.putExtra("hidden_list", true);
        r0.putExtra("slot", this.mCurrentSlot);
        r0.putExtra("title_id", R.string.data_usage_alarm);
        if (isFromSecurityCenter() == false) goto L5;
        int r1 = R.string.data_usage_title;
    L6:
        r0.putExtra("back_text_id", r1);
        startActivity(r0);
        return;
    L5:
        r1 = R.string.data_usage_title_long;
        goto L6
    }

    private void showInstallChargeDialog(final Context context) {
        if (context != null) goto L5;
        return;
    L5:
        if (this.mChargeInstallDialog != null) goto L8;
        this.mChargeInstallDialog = new AlertDialog.Builder(context).setTitle(R.string.dlg_title_notice).setMessage(R.string.dialog_recharge_app_not_installed).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.install_text, new AnonymousClass8(this, context)).create();
    L8:
        if (this.mChargeInstallDialog.isShowing() == true) goto L11;
        this.mChargeInstallDialog.show();
        return;
    }

    private void showInstallRoamingChargeDialog(final Context context) {
        if (context != null) goto L5;
        return;
    L5:
        if (this.mRoamingChargeInstallDialog != null) goto L8;
        this.mRoamingChargeInstallDialog = new AlertDialog.Builder(context).setTitle(R.string.dlg_title_notice).setMessage(R.string.redtea_roaming_not_installed_dialog_msg).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.install_text, new AnonymousClass9(this, context)).create();
    L8:
        if (this.mRoamingChargeInstallDialog.isShowing() == true) goto L11;
        this.mRoamingChargeInstallDialog.show();
        return;
    }

    public void bindStats(NetworkStats stats, int[] restrictedUids) {
        this.mItems.clear();
        IPackageManager r3 = AppGlobals.getPackageManager();
        int r4 = ActivityManager.getCurrentUser();
        SparseArray r5 = new SparseArray();
        if (stats == null) goto L5;
        int r7 = stats.size();
    L6:
        OLog.d(TAG, "mSummaryCallbacks bindStats size ================" + r7);
        NetworkStats.Entry r8 = null;
        int r9 = 0;
    L7:
        if (r9 >= r7) goto L30;
        r8 = stats.getValues(r9, r8);
        int r10 = r8.uid;
        int r12 = -4;
        if (UserHandle.isApp(r10) == true) goto L11;
        if (r10 != (-4)) goto L22;
    L25:
        r12 = r10;
    L26:
        AppItem r11 = (AppItem) r5.get(r12);
        if (r11 != null) goto L29;
        r11 = new AppItem(r12);
        this.mItems.add(r11);
        r5.put(r11.key, r11);
    L29:
        r11.addUid(r10);
        r11.total += r8.rxBytes + r8.txBytes;
        r9 = r9 + 1;
        r7 = r7;
        goto L7
    L22:
        if (r10 == (-5)) goto L25;
        r12 = 1000;
        goto L26
    L11:
        if (UserHandle.getUserId(r10) == r4) goto L25;
        if (r4 == 0) goto L15;
    L19:
        r12 = buildKeyForUser(UserHandle.getUserId(r10));
        goto L26
    L15:
        if (UserHandle.getUserId(r10) != 10) goto L19;
        if (DatausageUtils.doppelgangerAppExist(r3, r10) == true) goto L25;
    L30:
        int r1 = restrictedUids.length;
        int r6 = 0;
    L31:
        if (r6 >= r1) goto L40;
        int r13 = restrictedUids[r6];
        if (UserHandle.getUserId(r13) != r4) goto L39;
        AppItem r14 = (AppItem) r5.get(r13);
        if (r14 != null) goto L38;
        r14 = new AppItem(r13);
        r14.total = -1;
        this.mItems.add(r14);
        r5.put(r14.key, r14);
    L38:
        r14.restricted = true;
    L39:
        r6 = r6 + 1;
        goto L31
    L40:
        List<Integer> r2 = getNoDataUid(this.mItems, this);
        if (r2 != null) goto L43;
    L48:
        filterApplist();
        Collections.sort(this.mItems);
        return;
    L43:
        if (r2.size() <= 0) goto L48;
        Iterator<Integer> r15 = r2.iterator();
    L46:
        if (r15.hasNext() == false) goto L48;
        AppItem r16 = new AppItem(r15.next().intValue());
        r16.total = 0;
        this.mItems.add(r16);
        goto L46
    L5:
        r7 = 0;
        goto L6
    }

    private static List<Integer> getNoDataUid(ArrayList<AppItem> a2, Context context) {
        List<Integer> r3 = getInternetAppInfos(context);
        ArrayList r0 = new ArrayList();
        Iterator<AppItem> r2 = a2.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(Integer.valueOf(r2.next().key));
        goto L4
    L6:
        if (r3 == null) goto L8;
        r3.removeAll(r0);
    L8:
        return r3;
    }

    private static List<Integer> getInternetAppInfos(Context context) {
        PackageManager r0 = context.getPackageManager();
        if (r0 != null) goto L5;
        return null;
    L5:
        List<PackageInfo> r3 = r0.getInstalledPackages(4096);
        if (r3 != null) goto L8;
        return null;
    L8:
        UserManager r8 = (UserManager) context.getSystemService("user");
        UserHandle r4 = UserHandle.of(10);
        if (r8 != null) goto L11;
    L15:
        ArrayList r9 = new ArrayList();
        Iterator<PackageInfo> r1 = r3.iterator();
    L17:
        if (r1.hasNext() == false) goto L30;
        PackageInfo r2 = r1.next();
        String[] r5 = r2.requestedPermissions;
        if (r5 == null) goto L17;
        int r6 = r5.length;
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L17;
        if (r5[r7].equals("android.permission.INTERNET") == false) goto L29;
        ApplicationInfo r10 = r2.applicationInfo;
        int r11 = r10.uid;
        if ((r10.flags & 1) != 0) goto L29;
        if (UserHandle.isApp(r10.uid) == false) goto L29;
        r9.add(Integer.valueOf(r11));
    L29:
        r7 = r7 + 1;
        goto L21
    L30:
        return r9;
    L11:
        if (r8.isUserRunning(r4) == false) goto L15;
        if (r8.isUserUnlocked(r4) == false) goto L15;
        r3.addAll(r0.getInstalledPackagesAsUser(4096, 10));
        goto L15
    }

    public void launchAppStoreForPackage(Context context, String packageName) {
        Intent r3 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));     // Catch: ActivityNotFoundException -> L5
        r3.setPackage("com.obric.appstore");     // Catch: ActivityNotFoundException -> L5
        r3.addFlags(268435456);     // Catch: ActivityNotFoundException -> L5
        context.startActivity(r3);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void filterApplist() {
        OLog.d(TAG, "filterApplist...");
        ArrayList<AppItem> r0 = new ArrayList();
        Iterator<AppItem> r1 = this.mItems.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        AppItem r2 = r1.next();
        if (isSystemApp(r2) == true) goto L4;
        r0.add(r2);
        goto L4
    L8:
        this.mItems = r0;
    }

    private boolean isSystemApp(AppItem item) {
        if (item != null) goto L5;
        return true;
    L5:
        int r1 = item.key;
        if (r1 != (-5)) goto L8;
    L34:
        return true;
    L8:
        if (r1 == (-4)) goto L34;
        if (r1 == 1000) goto L34;
        PackageManager r2 = getPackageManager();
        if (r2 != null) goto L14;
        return false;
    L14:
        String[] r3 = r2.getPackagesForUid(r1);
        if (r3 != null) goto L17;
    L19:
        String r4 = null;
    L20:
        OLog.d(TAG, "pkg item: " + r4);
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        return false;
    L22:
        if (this.mUidDetailProvider.isSpecialSystemApp(r4) == false) goto L24;
        return true;
    L24:
        ApplicationInfo r6 = AppGlobals.getPackageManager().getApplicationInfo(r4, 0, UserHandle.getUserId(r1));     // Catch: RemoteException -> L31
        if (r6 != null) goto L27;
    L30:
        return true;
    L27:
        if ((r6.flags & 1) != 0) goto L30;
        if (UserHandle.isApp(r6.uid) == true) goto L33;
    L17:
        if (r3.length <= 0) goto L19;
        r4 = r3[0];
        item.packageName = r4;
        goto L20
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
