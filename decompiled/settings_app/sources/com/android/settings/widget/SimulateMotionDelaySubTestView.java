package com.android.settings.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.Utils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes.dex */
public class SimulateMotionDelaySubTestView extends LinearLayout implements AdapterView.OnItemClickListener {
    private static final int BTN_TAG_CONFIRM = 0;
    private static final int BTN_TAG_TEST_AGAIN = 1;
    private static final int BTN_TAG_TEST_START = 2;
    private static final long COUNTDOWN_INTERVAL = 1000;
    private static final long COUNTDOWN_TIME = 120000;
    private static final int DEFAULT_BC_SELECTED_VALUE = 0;
    private static final int DEFAULT_FEEL_SELECTED_VALUE = -1;
    private static final long LAST_COUNTDOWN_TIME = 60000;
    private static final String TAG = "SmdSubTestView";
    private BaseAdapter mBadCaseAdapter;
    private ArrayList<String> mBadCaseList;
    private SubListView mBadCaseListView;
    private boolean mBadCaseSelected;
    private int mBadCaseSelectedIndex;
    private Button mBtnConfirm;
    private Context mContext;
    private long mCountdownTime;
    private CountDownTimer mCountdownTimer;
    private int mCurIndex;
    private TextView mCurrentCountText;
    private BaseAdapter mFeelAdapter;
    private ArrayList<String> mFeelList;
    private SubListView mFeelListView;
    private boolean mFeelSelected;
    private int mFeelSelectedIndex;
    private boolean mFirstTestFinished;
    private boolean mIsCountingDown;
    private View mSubResultView;
    private onSubTestViewListener mSubTestViewListener;
    private ArrayList<String> mSubTitleList;
    private int mTestIndex;

    private class BadCaseAdapter extends BaseAdapter {
        final /* synthetic */ SimulateMotionDelaySubTestView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private BadCaseAdapter(SimulateMotionDelaySubTestView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BadCaseAdapter(SimulateMotionDelaySubTestView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SimulateMotionDelaySubTestView.access$2100(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = View.inflate(SimulateMotionDelaySubTestView.access$1900(this.this$0), R.layout.list_content_item_check, null);
            SettingItemCheck r6 = (SettingItemCheck) NullSafe.nonNull(r4.findViewById(R.id.item_check));
            r4.setTag(r6);
        L5:
            Utils.setItemBgStyle(r6, getCount(), r3);
            r6.setTitle((CharSequence) SimulateMotionDelaySubTestView.access$2100(this.this$0).get(r3));
            boolean r1 = true;
            int r7 = 1 << r3;
            if ((r7 & SimulateMotionDelaySubTestView.access$500(this.this$0)) != 0) goto L9;
            r1 = false;
        L9:
            r6.setChecked(r1);
            r6.setEnabled(SimulateMotionDelaySubTestView.access$2200(this.this$0).isEnabled());
            return r4;
        L4:
            r6 = (SettingItemCheck) r4.getTag();
            goto L5
        }
    }

    private class FeelAdapter extends BaseAdapter {
        final /* synthetic */ SimulateMotionDelaySubTestView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private FeelAdapter(SimulateMotionDelaySubTestView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ FeelAdapter(SimulateMotionDelaySubTestView r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SimulateMotionDelaySubTestView.access$1800(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 != null) goto L4;
            r3 = View.inflate(SimulateMotionDelaySubTestView.access$1900(this.this$0), R.layout.list_content_item_check, null);
            SettingItemCheck r5 = (SettingItemCheck) NullSafe.nonNull(r3.findViewById(R.id.item_check));
            r3.setTag(r5);
        L5:
            Utils.setItemBgStyle(r5, getCount(), r2);
            r5.setTitle((CharSequence) SimulateMotionDelaySubTestView.access$1800(this.this$0).get(r2));
            if (r2 != SimulateMotionDelaySubTestView.access$400(this.this$0)) goto L8;
            boolean r6 = true;
        L9:
            r5.setChecked(r6);
            r5.setEnabled(SimulateMotionDelaySubTestView.access$2000(this.this$0).isEnabled());
            return r3;
        L8:
            r6 = false;
            goto L9
        L4:
            r5 = (SettingItemCheck) r3.getTag();
            goto L5
        }
    }

    public static class SubListView extends ListView {
        public SubListView(Context r1) {
            super(r1);
        }

        public SubListView(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public SubListView(Context r1, AttributeSet r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    public interface onSubTestViewListener {
        void onConfirmed(int r1, int r2, int r3, String r4);

        void onTestAgain(int r1, int r2);

        void onTestStart(int r1, int r2);
    }

    static /* synthetic */ boolean access$1002(SimulateMotionDelaySubTestView r0, boolean r1) {
        r0.mFirstTestFinished = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$1100(SimulateMotionDelaySubTestView r0) {
        return r0.mFeelAdapter;
    }

    static /* synthetic */ boolean access$1202(SimulateMotionDelaySubTestView r0, boolean r1) {
        r0.mFeelSelected = r1;
        return r1;
    }

    static /* synthetic */ BaseAdapter access$1300(SimulateMotionDelaySubTestView r0) {
        return r0.mBadCaseAdapter;
    }

    static /* synthetic */ boolean access$1402(SimulateMotionDelaySubTestView r0, boolean r1) {
        r0.mBadCaseSelected = r1;
        return r1;
    }

    static /* synthetic */ void access$1500(SimulateMotionDelaySubTestView r0, long r1) {
        r0.refreshStateText(r1);
    }

    static /* synthetic */ void access$1600(SimulateMotionDelaySubTestView r0) {
        r0.showResultView();
    }

    static /* synthetic */ boolean access$1702(SimulateMotionDelaySubTestView r0, boolean r1) {
        r0.mIsCountingDown = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1800(SimulateMotionDelaySubTestView r0) {
        return r0.mFeelList;
    }

    static /* synthetic */ Context access$1900(SimulateMotionDelaySubTestView r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$200(SimulateMotionDelaySubTestView r0) {
        return r0.mCurIndex;
    }

    static /* synthetic */ SubListView access$2000(SimulateMotionDelaySubTestView r0) {
        return r0.mFeelListView;
    }

    static /* synthetic */ ArrayList access$2100(SimulateMotionDelaySubTestView r0) {
        return r0.mBadCaseList;
    }

    static /* synthetic */ SubListView access$2200(SimulateMotionDelaySubTestView r0) {
        return r0.mBadCaseListView;
    }

    static /* synthetic */ int access$300(SimulateMotionDelaySubTestView r0) {
        return r0.mTestIndex;
    }

    static /* synthetic */ int access$400(SimulateMotionDelaySubTestView r0) {
        return r0.mFeelSelectedIndex;
    }

    static /* synthetic */ int access$402(SimulateMotionDelaySubTestView r0, int r1) {
        r0.mFeelSelectedIndex = r1;
        return r1;
    }

    static /* synthetic */ int access$500(SimulateMotionDelaySubTestView r0) {
        return r0.mBadCaseSelectedIndex;
    }

    static /* synthetic */ int access$502(SimulateMotionDelaySubTestView r0, int r1) {
        r0.mBadCaseSelectedIndex = r1;
        return r1;
    }

    static /* synthetic */ String access$600(SimulateMotionDelaySubTestView r0, int r1) {
        return r0.transformBadCaseToString(r1);
    }

    static /* synthetic */ onSubTestViewListener access$700(SimulateMotionDelaySubTestView r0) {
        return r0.mSubTestViewListener;
    }

    static /* synthetic */ Button access$800(SimulateMotionDelaySubTestView r0) {
        return r0.mBtnConfirm;
    }

    static /* synthetic */ void access$900(SimulateMotionDelaySubTestView r0, boolean r1) {
        r0.enableLists(r1);
    }

    public SimulateMotionDelaySubTestView(Context r2) {
        this(r2, null);
    }

    public SimulateMotionDelaySubTestView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public SimulateMotionDelaySubTestView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mCountdownTime = 120000;
        this.mSubTitleList = new ArrayList();
        this.mFeelList = new ArrayList();
        this.mBadCaseList = new ArrayList();
        this.mFeelSelectedIndex = -1;
        this.mBadCaseSelectedIndex = 0;
        this.mFeelSelected = false;
        this.mBadCaseSelected = false;
        this.mIsCountingDown = false;
        this.mFirstTestFinished = false;
        this.mContext = r1;
        initStringLists();
    }

    private void initStringLists() {
        OLog.e(TAG, "Init string lists.");
        String[] r0 = getResources().getStringArray(R.array.smd_sub_test_title);
        String[] r1 = getResources().getStringArray(R.array.smd_sub_test_overall_feel);
        String[] r2 = getResources().getStringArray(R.array.smd_sub_test_bad_case);
        this.mSubTitleList.clear();
        this.mFeelList.clear();
        this.mBadCaseList.clear();
        this.mSubTitleList.addAll(Arrays.asList(r0));
        this.mFeelList.addAll(Arrays.asList(r1));
        this.mBadCaseList.addAll(Arrays.asList(r2));
    }

    public void initViews(int r3, int r4, onSubTestViewListener r5, boolean r6, boolean r7) {
        OLog.e(TAG, "Init views curIndex = " + r3 + ", testIndex : " + r4 + ", should start : " + r6 + ", is last test : " + r7);
        this.mCurIndex = r3;
        this.mTestIndex = r4;
        this.mSubTestViewListener = r5;
        this.mCurrentCountText = (TextView) NullSafe.nonNull(findViewById(R.id.sub_test_tips));
        if (r7 == false) goto L5;
        long r8 = 60000;
    L6:
        this.mCountdownTime = r8;
        refreshStateText(r8);
        this.mSubResultView = NullSafe.nonNull(findViewById(R.id.sub_test_result));
        ((TextView) NullSafe.nonNull(findViewById(R.id.sub_test_title))).setText(this.mContext.getString(R.string.motion_delay_sub_test_title, new Object[]{this.mSubTitleList.get(this.mCurIndex)}));
        SubListView r9 = (SubListView) NullSafe.nonNull(findViewById(R.id.overall_feel_list));
        this.mFeelListView = r9;
        r9.setOnItemClickListener(this);
        AnonymousClass1 r10 = null;
        FeelAdapter r11 = new FeelAdapter(this, r10);
        this.mFeelAdapter = r11;
        this.mFeelListView.setAdapter(r11);
        SubListView r12 = (SubListView) NullSafe.nonNull(findViewById(R.id.bad_case_list));
        this.mBadCaseListView = r12;
        r12.setOnItemClickListener(this);
        BadCaseAdapter r13 = new BadCaseAdapter(this, r10);
        this.mBadCaseAdapter = r13;
        this.mBadCaseListView.setAdapter(r13);
        Button r14 = (Button) NullSafe.nonNull(findViewById(R.id.btn_sub_result_confirm));
        this.mBtnConfirm = r14;
        if (r6 == false) goto L9;
        r14.setTag(0);
        this.mBtnConfirm.setEnabled(false);
        this.mBtnConfirm.setText(R.string.ok);
    L10:
        this.mBtnConfirm.setOnClickListener(new AnonymousClass1(this));
        return;
    L9:
        r14.setTag(2);
        this.mBtnConfirm.setEnabled(true);
        this.mBtnConfirm.setText(R.string.motion_delay_btn_start_test);
        goto L10
    L5:
        r8 = 120000;
        goto L6
    }

    private void enableLists(boolean r2) {
        this.mFeelListView.setEnabled(r2);
        this.mFeelAdapter.notifyDataSetChanged();
        this.mBadCaseListView.setEnabled(r2);
        this.mBadCaseAdapter.notifyDataSetChanged();
    }

    public void disableEverything() {
        enableLists(false);
        this.mBtnConfirm.setEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r2, View r3, int r4, long r5) {
        int r6 = r2.getId();
        if (r6 != R.id.bad_case_list) goto L5;
        OLog.e(TAG, "On bad case list item clicked, id : " + r4);
        if (r4 >= 0) goto L15;
    L30:
        if (this.mFeelSelected == false) goto L35;
        if (this.mBadCaseSelected == false) goto L35;
        OLog.e(TAG, "All result selected, enable confirm button.");
        this.mBtnConfirm.setEnabled(true);
        return;
    L35:
        if (this.mBtnConfirm.isEnabled() == false) goto L39;
        this.mBtnConfirm.setEnabled(false);
        return;
    L39:
        return;
    L15:
        if (r4 >= this.mBadCaseAdapter.getCount()) goto L30;
        int r7 = 1 << (this.mBadCaseAdapter.getCount() - 1);
        if (r4 != (this.mBadCaseAdapter.getCount() - 1)) goto L19;
        this.mBadCaseSelectedIndex = r7;
    L24:
        OLog.e(TAG, "mBadCaseSelectedIndex ： " + this.mBadCaseSelectedIndex);
        this.mBadCaseAdapter.notifyDataSetChanged();
        if (this.mBadCaseSelectedIndex == 0) goto L27;
        boolean r8 = true;
    L28:
        this.mBadCaseSelected = r8;
        goto L30
    L27:
        r8 = false;
        goto L28
    L19:
        int r9 = this.mBadCaseSelectedIndex;
        if (r9 >= r7) goto L22;
        int r10 = (1 << r4) ^ r9;
    L23:
        this.mBadCaseSelectedIndex = r10;
        goto L24
    L22:
        r10 = 1 << r4;
        goto L23
    L5:
        if (r6 != R.id.overall_feel_list) goto L30;
        OLog.e(TAG, "On feel list item clicked, id :" + r4);
        if (r4 < 0) goto L30;
        if (r4 >= this.mFeelAdapter.getCount()) goto L30;
        this.mFeelSelectedIndex = r4;
        this.mFeelAdapter.notifyDataSetChanged();
        this.mFeelSelected = true;
        goto L30
    }

    public void startSubTest() {
        OLog.e(TAG, "Start sub test.");
        startCountdown();
        ToastUtils.showInView(getContext(), R.string.motion_delay_start_test_toast);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.android.settings.widget.SimulateMotionDelaySubTestView$2] */
    private void startCountdown() {
        OLog.e(TAG, "Start countdown.");
        if (this.mCountdownTimer == null) goto L5;
        stopCountdown();
    L5:
        final long r3 = this.mCountdownTime;
        final long r5 = 1000;
        this.mCountdownTimer = new AnonymousClass2(this, r3, r5).start();
        this.mIsCountingDown = true;
    }

    public void stopCountdown() {
        OLog.e(TAG, "Stop countdown.");
        CountDownTimer r0 = this.mCountdownTimer;
        if (r0 == null) goto L5;
        r0.cancel();
        this.mCountdownTimer = null;
    L5:
        this.mIsCountingDown = false;
        refreshStateText(this.mCountdownTime);
    }

    public boolean isCountingDown() {
        OLog.e(TAG, "Is countdown going : " + this.mIsCountingDown);
        return this.mIsCountingDown;
    }

    public void stopTest() {
        OLog.e(TAG, "Stop test, index = " + this.mCurIndex);
        if (isCountingDown() == false) goto L5;
        stopCountdown();
    L5:
        this.mBtnConfirm.setEnabled(true);
        if (this.mFirstTestFinished == false) goto L8;
        this.mBtnConfirm.setText(R.string.motion_delay_sub_result_test_again);
        this.mBtnConfirm.setTag(1);
    L8:
        enableLists(false);
    }

    private void refreshStateText(long r3) {
        this.mCurrentCountText.setText(this.mContext.getString(R.string.motion_delay_sub_test_tips, new Object[]{Integer.valueOf((int) Math.rint(Math.round((r3 * 1.0d) / 1000.0d)))}));
    }

    private void showResultView() {
        OLog.e(TAG, "Show result view.");
        this.mCurrentCountText.setVisibility(8);
        this.mSubResultView.setVisibility(0);
        this.mBtnConfirm.setTag(0);
        this.mBtnConfirm.setText(R.string.ok);
        enableLists(true);
    }

    private String transformBadCaseToString(int r4) {
        String r0 = "";
        int r1 = 0;
    L4:
        if (r1 >= this.mBadCaseList.size()) goto L12;
        if (((1 << r1) & r4) == 0) goto L11;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = String.valueOf(r1 + 1);
        goto L11
    L10:
        r0 = r0 + "," + (r1 + 1);
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }
}
