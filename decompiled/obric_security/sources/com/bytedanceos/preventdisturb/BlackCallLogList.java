package com.bytedanceos.preventdisturb;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.AsyncQueryHandler;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.Loader;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import bytedanceos.util.LogTag;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.preventdisturb.widget.BlackCallListItem;
import com.bytedanceos.preventdisturb.widget.HorizontalScrollListView;
import com.bytedanceos.security.Utils;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.PageMonitor;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.AlertDialogButtonStyleController;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.indicator.IndicatorExternalsKt;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.toast.OToast;
import com.obric.oui.utils.StyleUtil;
import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.securitycenter.api.TrackUtils;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public class BlackCallLogList extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, BlackListCallLogAdapter.BlackListCallAdapterListener {
    public static final String ACTION_BYTEDANCE_INSERT_OR_EDIT = "com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit";
    public static final String AUTHORITY = "com.obric.nodisturb.provider";
    public static final Uri AUTHORITY_URI = null;
    private static final String BLACKLIST_DELETED_COLUMN = "deleted";
    public static final Uri BLACK_LIST_URI = null;
    public static final Uri BLOCKED_CALL_LOG_URI = null;
    public static final String CALLLOG_ORDER = "bcl_datetime";
    public static final String[] CALLLOG_PROJECTION = null;
    public static final Uri CALL_INTERCEPT_COUNT_URI = null;
    public static final Uri CALL_LOG_SUMMARY_LIST_URI = null;
    public static final int CALL_NOTE = 2;
    public static final int CALL_PHONE_NUMBER = 1;
    public static final int CALL_PHOTO = 3;
    public static final int CALL_SUM = 4;
    public static final int CALL_SUMMARY_ID = 0;
    private static final String[] CONTACT_PROJECTION = null;
    public static final int CS_PHONE_NUMBER_BLACKLIST_ID = 6;
    public static final int CS_PHONE_NUMBER_WHITELIST_ID = 5;
    private static final int DEL_ONE_CALL = 10;
    private static final int GET_TELEPHONE_NUMBER = 8;
    private static final int IS_IN_CONTACT_TOKEN = 7;
    public static final String KEY_BLACK_ID = "blackid";
    public static final int LOADER_BLACKLIST_CALLLOG = 1;
    private static final int NO_INTERCEPT_TOKEN = 9;
    private static final String TAG = "BlackCallLogList";
    public static final Uri WHITE_LIST_URI = null;
    private OButtonFloating bottomClear;
    private OAlertDialog delAllDialog;
    private FrameLayout emptyViewRoot;
    private OSectionTitleBar mAllCountView;
    private ContentObserver mCallInterceptObserver;
    private HorizontalScrollListView mCallList;
    private BlackListCallLogAdapter mCallLogAdapter;
    private final Set<Long> mCleanedInvalidBlackIds;
    private OBottomActionBarFloating mClearBtn;
    private FrameLayout mClearView;
    private OPageStatus mEmptyView;
    private Cursor mFilteredCursor;
    private final PerformanceMonitors.FpsSceneSession mListFpsSession;
    private BlackListCallItemClickListener mListener;
    private OInsetSheet mMenuDialog;
    private OActionSheet mNoInterceptDialog;
    private final PageMonitor mPageMonitor;
    private final HashMap<String, Long> mPeriodStarts;
    private QueryCallHandler mQueryCallHandler;
    private ContentResolver mResolver;
    private View mTdSmsAllView;
    private BroadcastReceiver mUpdateListReceiver;

    public interface BlackListCallItemClickListener {
        void onCallListItemClick(int key);
    }

    class BlackListItem {
        String Id;
        String phoneNumber;
        final /* synthetic */ BlackCallLogList this$0;

        public BlackListItem(final BlackCallLogList this$0, String phoneNumber, String Id) {
            this.this$0 = this$0;
            this.Id = Id;
            this.phoneNumber = phoneNumber;
        }
    }

    public static final class CallSummary implements BaseColumns {
        public static final String CS_NOTE = "bl_note";
        public static final String CS_PHONE_NUMBER = "bl_phone_number";
        public static final String CS_PHOTO = "bl_photo";
        public static final String CS_SUM = "cs_sum";

        public CallSummary() {
        }
    }

    private class QueryCallHandler extends AsyncQueryHandler {
        final /* synthetic */ BlackCallLogList this$0;

        public QueryCallHandler(final BlackCallLogList this$0, ContentResolver cr) {
            this.this$0 = this$0;
            super(cr);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int token, Object cookie, Cursor c) {
            BlackCallLogList.access$400(this.this$0, token, cookie, c);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int token, Object cookie, int result) {
            super.onDeleteComplete(token, cookie, result);
            if (token != 9) goto L5;
        L6:
            this.this$0.getLoaderManager().restartLoader(1, null, this.this$0);
            return;
        L5:
            if (token == 10) goto L6;
        }
    }

    public static /* synthetic */ void $r8$lambda$R6H5XtyuQzNKn8yvZ2LIpaTeFP4(BlackCallLogList r0) {
        r0.setEmptyViewLayoutParams();
    }

    private void updateButtonWidth() {
    }

    public void resetListView() {
    }

    public String scene() {
        return "intercept_call_page";
    }

    public BlackCallLogList() {
        this.mPageMonitor = PerformanceMonitors.createPageMonitor(PerformanceScenes.PAGE_PERMISSION_DISTURB_CALL);
        this.mPeriodStarts = new HashMap();
        this.mListFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_PERMISSION_DISTURB_CALL_LIST);
        this.mCleanedInvalidBlackIds = new HashSet();
        this.mQueryCallHandler = null;
        this.mMenuDialog = null;
        this.delAllDialog = null;
        final Handler r1 = new Handler();
        this.mCallInterceptObserver = new AnonymousClass4(this, r1);
        this.mUpdateListReceiver = new AnonymousClass5(this);
    }

    static /* synthetic */ PerformanceMonitors.FpsSceneSession access$000(BlackCallLogList r0) {
        return r0.mListFpsSession;
    }

    static /* synthetic */ void access$100(BlackCallLogList r0, String r1) {
        r0.markEnd(r1);
    }

    static /* synthetic */ OInsetSheet access$1000(BlackCallLogList r0) {
        return r0.mMenuDialog;
    }

    static /* synthetic */ void access$1100(BlackCallLogList r0, String r1) {
        r0.removeCallLogByPhoneNumber(r1);
    }

    static /* synthetic */ OBottomActionBarFloating access$200(BlackCallLogList r0) {
        return r0.mClearBtn;
    }

    static /* synthetic */ BlackListCallLogAdapter access$300(BlackCallLogList r0) {
        return r0.mCallLogAdapter;
    }

    static /* synthetic */ void access$400(BlackCallLogList r0, int r1, Object r2, Cursor r3) {
        r0.queryComplete(r1, r2, r3);
    }

    static /* synthetic */ void access$500(BlackCallLogList r0, String r1) {
        r0.addPhoneToWhiteList(r1);
    }

    static /* synthetic */ void access$600(BlackCallLogList r0, String r1) {
        r0.addToContacts(r1);
    }

    static /* synthetic */ OAlertDialog access$700(BlackCallLogList r0) {
        return r0.delAllDialog;
    }

    static /* synthetic */ QueryCallHandler access$800(BlackCallLogList r0) {
        return r0.mQueryCallHandler;
    }

    static /* synthetic */ HorizontalScrollListView access$900(BlackCallLogList r0) {
        return r0.mCallList;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        onLoadFinished2(loader, data);
    }

    static {
        Uri r0 = Uri.parse("content://com.obric.nodisturb.provider");
        AUTHORITY_URI = r0;
        CALL_INTERCEPT_COUNT_URI = Uri.withAppendedPath(r0, "callinterceptcount");
        CALL_LOG_SUMMARY_LIST_URI = Uri.withAppendedPath(r0, "callsummaryloglist");
        BLOCKED_CALL_LOG_URI = Uri.withAppendedPath(r0, "blockedcalllog");
        BLACK_LIST_URI = Uri.withAppendedPath(r0, ProviderConstants.TABLE_BLACK_LIST);
        WHITE_LIST_URI = Uri.withAppendedPath(r0, "whitelist");
        CALLLOG_PROJECTION = new String[]{"_id", "bl_phone_number", "bl_note", "bl_photo", CallSummary.CS_SUM};
        CONTACT_PROJECTION = new String[]{"_id"};
    }

    public void setListener(BlackListCallItemClickListener l) {
        this.mListener = l;
    }

    private void markStart(String period) {
        this.mPeriodStarts.put(period, Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.mPageMonitor.markStart(period);
    }

    private void markEnd(String period) {
        Long r0 = this.mPeriodStarts.remove(period);
        if (r0 == null) goto L5;
        long r1 = PerformanceMonitors.nowElapsedMs() - r0.longValue();
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(PerformanceScenes.PAGE_PERMISSION_DISTURB_CALL, period), r1);
    L5:
        this.mPageMonitor.markEnd(period);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        markStart(PageMonitor.PERIOD_FRAGMENT_CREATE);
        if (getContext() == null) goto L5;
        this.mResolver = getContext().getContentResolver();
        this.mQueryCallHandler = new QueryCallHandler(this, this.mResolver);
    L5:
        registerObserver();
        super.onCreate(savedInstanceState);
        markEnd(PageMonitor.PERIOD_FRAGMENT_CREATE);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        markStart(PageMonitor.PERIOD_FRAGMENT_VIEW_CREATE);
        View r6 = inflater.inflate(R.layout.spam_conversation_list, container, false);
        HorizontalScrollListView r0 = (HorizontalScrollListView) r6.findViewById(R.id.system_list);
        this.mCallList = r0;
        if (r0 == null) goto L5;
        initFootView();
    L5:
        this.emptyViewRoot = (FrameLayout) r6.findViewById(R.id.empty_status_root);
        setEmptyViewLayoutParams();
        r6.addOnLayoutChangeListener(new BlackCallLogList$$ExternalSyntheticLambda2(this));
        OPageStatus r1 = (OPageStatus) r6.findViewById(R.id.empty_status);
        this.mEmptyView = r1;
        r1.setTitle(getString(R.string.blc_list_empty_info));
        this.mClearView = (FrameLayout) r6.findViewById(R.id.clear_bt_contain);
        this.mClearBtn = (OBottomActionBarFloating) r6.findViewById(R.id.clear_all_msg);
        initDeleteActionView();
        View r5 = inflater.inflate(R.layout.all_count_layout, null);
        this.mTdSmsAllView = r5;
        this.mCallList.addHeaderView(r5);
        OSectionTitleBar r7 = (OSectionTitleBar) this.mTdSmsAllView.findViewById(R.id.all_count_tv);
        this.mAllCountView = r7;
        r7.setTitleText(getResources().getString(R.string.black_call_log_list, new Object[]{0}));
        updateButtonWidth();
        this.mCallList.setOnScrollStateChangeListener(new AnonymousClass1(this));
        PerformanceMonitors.markRealShowOnce(r6, new AnonymousClass2(this));
        markStart("userdata_real_show");
        markEnd(PageMonitor.PERIOD_FRAGMENT_VIEW_CREATE);
        return r6;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-bytedanceos-preventdisturb-BlackCallLogList, reason: not valid java name */
    /* synthetic */ void m115x2a533c66(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) == (r9 - r7)) goto L6;
        r1.post(new BlackCallLogList$$ExternalSyntheticLambda9(this));
        return;
    }

    private void initDeleteActionView() {
        OButtonFloating r0 = (OButtonFloating) StyleUtil.createWidgetWithStyle(this.mClearBtn.getContext(), 2131821350, new BlackCallLogList$$ExternalSyntheticLambda6(this));
        this.bottomClear = r0;
        OBottomActionBarFloating r1 = this.mClearBtn;
        if (r1 == null) goto L9;
        r1.setButtons(Collections.singletonList(r0));
        ViewCompat.setOnApplyWindowInsetsListener(this.mClearBtn, new BlackCallLogList$$ExternalSyntheticLambda7());
        if (ViewCompat.isAttachedToWindow(this.mClearBtn) == false) goto L7;
        ViewCompat.requestApplyInsets(this.mClearBtn);
        return;
    L7:
        this.mClearBtn.addOnAttachStateChangeListener(new AnonymousClass3(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$2$com-bytedanceos-preventdisturb-BlackCallLogList, reason: not valid java name */
    /* synthetic */ OButtonFloating m114x27cecc1e(Context r4, Integer r5, Integer r6) {
        OButtonFloating r0 = new OButtonFloating(r4);
        r0.setTitle(getString(R.string.delete_btn));
        r0.getTextView().setTextColor(this.mClearBtn.getContext().getColor(R.color.oui_functional_red_6));
        r0.setLayoutParams(new ViewGroup.LayoutParams(r5.intValue(), r6.intValue()));
        r0.setOnClickListener(new BlackCallLogList$$ExternalSyntheticLambda3(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$1$com-bytedanceos-preventdisturb-BlackCallLogList, reason: not valid java name */
    /* synthetic */ void m113x2845321d(View r1) {
        getDeleteAllDialog().show();
    }

    static /* synthetic */ WindowInsetsCompat lambda$initDeleteActionView$3(View r2, WindowInsetsCompat r3) {
        Insets r0 = r3.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        r1.bottomMargin = r0.bottom;
        r2.setLayoutParams(r1);
        return r3;
    }

    private void setEmptyViewLayoutParams() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        if (this.emptyViewRoot == null) goto L13;
        int r0 = (getActivity().getWindowManager().getCurrentWindowMetrics().getBounds().height() - Utils.dp2Pixels(getContext(), 300.0f)) / 2;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) this.emptyViewRoot.getLayoutParams();
        r1.bottomMargin = r0;
        this.emptyViewRoot.setLayoutParams(r1);
        return;
    }

    private View initFootView() {
        if (getContext() != null) goto L5;
        return null;
    L5:
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.caches_footer, null);
        r0.setLayoutParams(new AbsListView.LayoutParams(1, Utils.dp2Pixels(getContext(), 74.0f)));
        return r0;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (getActivity() != null) goto L7;
        return null;
    L7:
        return new CursorLoader(getActivity(), CALL_LOG_SUMMARY_LIST_URI, CALLLOG_PROJECTION, null, null, "bcl_datetime");
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader loader, Cursor data) {
        BlackListCallLogAdapter r6 = this.mCallLogAdapter;
        boolean r0 = false;
        if (r6 == null) goto L5;
        r6.changeCursor(data);
    L8:
        if (data == null) goto L14;
        int r7 = data.getPosition();
        data.moveToPosition(-1);
        int r1 = 0;
    L11:
        if (data.moveToNext() == false) goto L13;
        r1 = r1 + data.getInt(4);
        goto L11
    L13:
        data.moveToPosition(r7);
    L15:
        this.mAllCountView.setTitleText(getResources().getString(R.string.black_call_log_list, new Object[]{Integer.valueOf(r1)}));
        if (this.mCallList.getEmptyView() != null) goto L18;
        this.mCallList.setEmptyView(this.mEmptyView);
    L18:
        if (data != null) goto L20;
    L22:
        setUiState(r0);
        return;
    L20:
        if (data.getCount() <= 0) goto L22;
        r0 = true;
        goto L22
    L14:
        r1 = 0;
        goto L15
    L5:
        if (getActivity() == null) goto L8;
        BlackListCallLogAdapter r8 = new BlackListCallLogAdapter(getActivity(), data, this, false);
        this.mCallLogAdapter = r8;
        this.mCallList.setAdapter(r8);
        goto L8
    }

    private Cursor filterCallSummaryCursor(Cursor data) {
        if (data != null) goto L6;
        closeFilteredCursorIfNeeded();
        return null;
    L6:
        int r1 = data.getColumnIndex("_id");
        if (r1 >= 0) goto L10;
        closeFilteredCursorIfNeeded();
        return data;
    L10:
        HashSet r2 = new HashSet();
        int r3 = data.getPosition();
        data.moveToPosition(-1);
        boolean r6 = false;
    L12:
        if (data.moveToNext() == false) goto L20;
        if (data.isNull(r1) == true) goto L15;
        long r11 = data.getLong(r1);
        if (r11 <= 0) goto L15;
        r2.add(Long.valueOf(r11));
    L15:
        r6 = true;
        goto L12
    L20:
        data.moveToPosition(r3);
        Set<Long> r7 = queryNotDeletedBlackListIds(r2);
        if (r7.size() >= r2.size()) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L28;
        HashSet r13 = new HashSet(r2);
        r13.removeAll(r7);
        r13.removeAll(this.mCleanedInvalidBlackIds);
        if (r13.isEmpty() == true) goto L28;
        deleteBlockedCallLogsByBlackIds(r13);
        this.mCleanedInvalidBlackIds.addAll(r13);
    L28:
        if (r6 == true) goto L32;
        if (r12 == true) goto L32;
        closeFilteredCursorIfNeeded();
        return data;
    L32:
        MatrixCursor r14 = new MatrixCursor(data.getColumnNames());
        data.moveToPosition(-1);
    L34:
        if (data.moveToNext() == false) goto L61;
        if (data.isNull(r1) == true) goto L34;
        long r15 = data.getLong(r1);
        if (r15 <= 0) goto L34;
        if (r7.contains(Long.valueOf(r15)) == false) goto L34;
        Object[] r4 = new Object[data.getColumnCount()];
        int r8 = 0;
    L46:
        if (r8 >= data.getColumnCount()) goto L60;
        int r16 = data.getType(r8);
        if (r16 == 0) goto L58;
        if (r16 != 1) goto L51;
        r4[r8] = Long.valueOf(data.getLong(r8));
    L59:
        r8 = r8 + 1;
        goto L46
    L51:
        if (r16 != 2) goto L53;
        r4[r8] = Double.valueOf(data.getDouble(r8));
        goto L59
    L53:
        if (r16 == 4) goto L55;
        r4[r8] = data.getString(r8);
        goto L59
    L55:
        r4[r8] = data.getBlob(r8);
        goto L59
    L58:
        r4[r8] = null;
        goto L59
    L60:
        r14.addRow(r4);
        goto L34
    L61:
        data.moveToPosition(r3);
        OLog.d(TAG, "filterCallSummaryCursor: origin=" + data.getCount() + ", candidateIds=" + r2.size() + ", aliveBlackIds=" + r7.size() + ", filtered=" + r14.getCount());
        closeFilteredCursorIfNeeded();
        this.mFilteredCursor = r14;
        return r14;
    L23:
        r12 = false;
        goto L24
    }

    private void deleteBlockedCallLogsByBlackIds(Set<Long> blackIds) {
        if (this.mQueryCallHandler == null) goto L24;
        if (blackIds != null) goto L6;
        return;
    L6:
        if (blackIds.isEmpty() == false) goto L9;
        return;
    L9:
        if (blackIds.size() != 1) goto L12;
        this.mQueryCallHandler.startDelete(9, null, BLOCKED_CALL_LOG_URI, "bcl_bl_id=?", new String[]{String.valueOf(blackIds.iterator().next().longValue())});
        return;
    L12:
        Long[] r13 = (Long[]) blackIds.toArray(new Long[0]);
        int r0 = 0;
    L14:
        if (r0 >= r13.length) goto L32;
        int r1 = r0 + 300;
        int r3 = Math.min(r1, r13.length) - r0;
        StringBuilder r4 = new StringBuilder("bcl_bl_id IN (");
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L20;
        if (r5 <= 0) goto L19;
        r4.append(',');
    L19:
        r4.append('?');
        r5 = r5 + 1;
        goto L16
    L20:
        r4.append(')');
        String[] r11 = new String[r3];
        int r6 = 0;
    L21:
        if (r6 >= r3) goto L23;
        r11[r6] = String.valueOf(r13[r0 + r6]);
        r6 = r6 + 1;
        goto L21
    L23:
        this.mQueryCallHandler.startDelete(9, null, BLOCKED_CALL_LOG_URI, r4.toString(), r11);
        r0 = r1;
        goto L14
    L32:
        return;
    }

    private Set<Long> queryNotDeletedBlackListIds(Set<Long> ids) {
        HashSet r3 = new HashSet();
        if (this.mResolver == null) goto L48;
        if (ids == null) goto L48;
        if (ids.isEmpty() == true) goto L48;
        Long[] r5 = (Long[]) ids.toArray(new Long[0]);
        int r0 = 0;
    L10:
        if (r0 >= r5.length) goto L48;
        int r6 = r0 + 300;
        int r7 = Math.min(r6, r5.length) - r0;
        StringBuilder r8 = new StringBuilder("_id IN (");
        int r9 = 0;
    L12:
        if (r9 >= r7) goto L16;
        if (r9 <= 0) goto L15;
        r8.append(',');
    L15:
        r8.append('?');
        r9 = r9 + 1;
        goto L12
    L16:
        r8.append(") AND deleted=0");
        String[] r10 = new String[r7];
        int r11 = 0;
    L17:
        if (r11 >= r7) goto L61;
        r10[r11] = String.valueOf(r5[r0 + r11]);
        r11 = r11 + 1;
        goto L17
    L61:
        Cursor r1 = this.mResolver.query(BLACK_LIST_URI, new String[]{"_id"}, r8.toString(), r10, null);     // Catch: Exception -> L21
    L32:
        Cursor r12 = r1;
        if (r12 == null) goto L47;
        int r2 = r12.getColumnIndex("_id");     // Catch: Throwable -> L44
    L36:
        if (r12.moveToNext() == false) goto L51;
        if (r2 < 0) goto L36;
        if (r12.isNull(r2) == true) goto L36;
        r3.add(Long.valueOf(r12.getLong(r2)));     // Catch: Throwable -> L44
        goto L36
    L51:
        r12.close();     // Catch: Exception -> L49
    L44:
        th = move-exception;
        r12.close();     // Catch: Exception -> L50
    L46:
        throw th;
    L47:
        r0 = r6;
    L21:
        e = move-exception;
        OLog.w(TAG, "queryNotDeletedBlackListIds query with deleted=0 failed, fallback to existence check", e);
        r1 = this.mResolver.query(BLACK_LIST_URI, new String[]{"_id"}, r8.toString().replace(" AND deleted=0", ""), r10, null);     // Catch: Exception -> L27
    L27:
        e = e;
    L31:
        OLog.e(TAG, "queryNotDeletedBlackListIds fallback query failed", e);
        r1 = null;
    L29:
        e = e;
    L48:
        return r3;
    }

    private void closeFilteredCursorIfNeeded() {
        Cursor r0 = this.mFilteredCursor;
        if (r0 == null) goto L10;
        r0.close();     // Catch: Exception -> L7
    L5:
        this.mFilteredCursor = null;
        return;
    }

    private void setUiState(boolean canUse) {
        if (canUse == false) goto L5;
        this.mClearBtn.setEnabled(true);
        this.mClearView.setVisibility(0);
        return;
    L5:
        this.mClearBtn.setEnabled(false);
        this.mClearView.setVisibility(8);
        OAlertDialog r2 = this.delAllDialog;
        if (r2 == null) goto L10;
        r2.dismiss();
        return;
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        BlackListCallLogAdapter r2 = this.mCallLogAdapter;
        if (r2 == null) goto L5;
        r2.changeCursor(null);
    L5:
        closeFilteredCursorIfNeeded();
    }

    private void registerObserver() {
        ContentResolver r0 = this.mResolver;
        if (r0 == null) goto L6;
        r0.registerContentObserver(CALL_INTERCEPT_COUNT_URI, true, this.mCallInterceptObserver);
        return;
    }

    private void unregisterObserver() {
        ContentResolver r0 = this.mResolver;
        if (r0 == null) goto L6;
        r0.unregisterContentObserver(this.mCallInterceptObserver);
        return;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        getLoaderManager().restartLoader(1, null, this);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        getLoaderManager().destroyLoader(1);
        unregisterObserver();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onResume() {
        markStart(PageMonitor.PERIOD_FRAGMENT_RESUME);
        getLoaderManager().restartLoader(1, null, this);
        registBroadcastReceiver();
        super.onResume();
        PerformanceMonitors.reportSceneFrequency(PerformanceScenes.PAGE_PERMISSION_DISTURB_CALL);
        onPageShow();
        PerformanceMonitors.reportThreads(PerformanceScenes.THREAD_PERMISSION_DISTURB_LOAD);
        markEnd(PageMonitor.PERIOD_FRAGMENT_RESUME);
    }

    private void onPageShow() {
        HashMap r0 = new HashMap();
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, scene());
        TrackUtils.INSTANCE.trackEvent("page_show", r0);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.mCallLogAdapter = null;
        unbindListeners(-1);
    }

    @Override // android.app.Fragment
    public void onPause() {
        unregistBroadcastReceiver();
        this.mListFpsSession.stop();
        super.onPause();
    }

    private void registBroadcastReceiver() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getApplicationContext() == null) goto L10;
        IntentFilter r0 = new IntentFilter(SecurityCenterApplication.ACTION_UPDATE_COUNTRY_ISO);
        getActivity().getApplicationContext().registerReceiver(this.mUpdateListReceiver, r0);
        return;
    }

    private void unregistBroadcastReceiver() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getApplicationContext() == null) goto L10;
        getActivity().getApplicationContext().unregisterReceiver(this.mUpdateListReceiver);
        return;
    }

    private void queryComplete(int token, final Object cookie, Cursor c) {
        if (c != null) goto L41;
        return;
    L41:
        if (token == 7) goto L52;
        if (token != 8) goto L54;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L14:
        c.close();     // Catch: Exception -> L38
    L48:
        return;
    L10:
        if (c.getCount() <= 0) goto L14;
        if (c.moveToFirst() == false) goto L14;
        String r11 = c.getString(c.getColumnIndexOrThrow("bl_phone_number"));     // Catch: Throwable -> L16 Exception -> L18
        String r12 = String.valueOf(cookie);     // Catch: Throwable -> L16 Exception -> L18
        LogTag.d(TAG, "GET_TELEPHONE_NUMBER phoneNumber=" + r11 + ",blackId=" + r12);     // Catch: Throwable -> L16 Exception -> L18
        this.mQueryCallHandler.startQuery(7, new BlackListItem(this, r11, r12), Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r11)), CONTACT_PROJECTION, null, null, null);     // Catch: Throwable -> L16 Exception -> L18
    L54:
        return;
    L16:
        th = move-exception;
        c.close();     // Catch: Exception -> L39
    L22:
        throw th;
    L52:
        FrameLayout r13 = getUnblockDialog().contentContainer;     // Catch: Throwable -> L30 Exception -> L32
        if (c.getCount() <= 0) goto L26;
        OButton r0 = (OButton) r13.findViewById(R.id.option1);     // Catch: Throwable -> L30 Exception -> L32
        r0.setText(R.string.unblock_number);     // Catch: Throwable -> L30 Exception -> L32
        r0.setVisibility(0);     // Catch: Throwable -> L30 Exception -> L32
        r0.setOnClickListener(new AnonymousClass6(this, cookie));     // Catch: Throwable -> L30 Exception -> L32
        ((OButton) r13.findViewById(R.id.option2)).setVisibility(8);     // Catch: Throwable -> L30 Exception -> L32
    L27:
        getUnblockDialog().show();     // Catch: Throwable -> L30 Exception -> L32
        getUnblockDialog().rootContainer.setOnApplyWindowInsetsListener(null);     // Catch: Throwable -> L30 Exception -> L32
        ViewCompat.setOnApplyWindowInsetsListener(getUnblockDialog().rootContainer, new BlackCallLogList$$ExternalSyntheticLambda1());     // Catch: Throwable -> L30 Exception -> L32
    L28:
        c.close();     // Catch: Exception -> L38
        goto L48
    L26:
        OButton r1 = (OButton) r13.findViewById(R.id.option1);     // Catch: Throwable -> L30 Exception -> L32
        r1.setText(R.string.unblock_number);     // Catch: Throwable -> L30 Exception -> L32
        r1.setVisibility(0);     // Catch: Throwable -> L30 Exception -> L32
        r1.setOnClickListener(new AnonymousClass7(this, cookie));     // Catch: Throwable -> L30 Exception -> L32
        OButton r14 = (OButton) r13.findViewById(R.id.option2);     // Catch: Throwable -> L30 Exception -> L32
        r14.setText(R.string.unblock_and_add_number);     // Catch: Throwable -> L30 Exception -> L32
        r14.setVisibility(0);     // Catch: Throwable -> L30 Exception -> L32
        r14.setOnClickListener(new AnonymousClass8(this, cookie));     // Catch: Throwable -> L30 Exception -> L32
    L32:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        c.close();     // Catch: Exception -> L40
    L37:
        throw th;
    }

    static /* synthetic */ WindowInsetsCompat lambda$queryComplete$4(View r1, WindowInsetsCompat r2) {
        IndicatorExternalsKt.setMarginBottom(r1, 56);
        r1.setPadding(0, 0, 0, 0);
        return r2;
    }

    private void removeFromBlackList(String blackListId) {
        if (TextUtils.isEmpty(blackListId) == true) goto L6;
        Uri r4 = Uri.withAppendedPath(BLACK_LIST_URI, blackListId);
        this.mQueryCallHandler.startDelete(9, null, r4, null, null);
        unbindListeners(Long.parseLong(blackListId));
        new OToast(getActivity(), getContext().getString(R.string.unblock_number_toast), 48).show();
        return;
    }

    private void addPhoneToWhiteList(String phoneNumber) {
        if (this.mResolver != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(phoneNumber) == true) goto L18;
        ContentValues r0 = new ContentValues();     // Catch: Exception -> L12
        r0.put(ProviderConstants.WhiteList.WL_PHONE_NUMBER, phoneNumber);     // Catch: Exception -> L12
        this.mResolver.insert(WHITE_LIST_URI, r0);     // Catch: Exception -> L12
        if (getContext() == null) goto L10;
        new OToast(getActivity(), getContext().getString(R.string.unblock_number_toast), 48).show();     // Catch: Exception -> L12
    L10:
        getLoaderManager().restartLoader(1, null, this);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "addPhoneToWhiteList failed: " + EncryptPhoneToMd5Kt.calculateMD5(phoneNumber), e);
        return;
    }

    protected OActionSheet getUnblockDialog() {
        OActionSheet r0 = this.mNoInterceptDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OActionSheet.Companion.Modifier r1 = new OActionSheet.Companion.Modifier(OInsetSheet.PanelWidth.NARROW_WIDTH, getString(R.string.unblock_number_confirm), "", new BlackCallLogList$$ExternalSyntheticLambda5(this));
        this.mNoInterceptDialog = new OActionSheet(getActivity(), r1);
        View r2 = LayoutInflater.from(getActivity()).inflate(R.layout.block_unblock_menu_item, null);
        this.mNoInterceptDialog.setContainerView(r2);
        return this.mNoInterceptDialog;
    }

    /* JADX INFO: renamed from: lambda$getUnblockDialog$5$com-bytedanceos-preventdisturb-BlackCallLogList, reason: not valid java name */
    /* synthetic */ Unit m112xbee25db1() {
        this.mNoInterceptDialog.dismiss();
        return Unit.INSTANCE;
    }

    private OAlertDialog getDeleteAllDialog() {
        OAlertDialog r0 = this.delAllDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OAlertDialogBuilder r1 = new OAlertDialogBuilder(getContext()).title(R.string.clear_dialog_title_text).overrideButtonStyleController(new BlackCallLogList$$ExternalSyntheticLambda8()).horizontalButton(true);
        r1.positiveButton(R.string.dialog_delete_conform, new AnonymousClass9(this));
        r1.negativeButton(R.string.cancel, new AnonymousClass10(this));
        OAlertDialog r2 = r1.build();
        this.delAllDialog = r2;
        OButton r3 = (OButton) r2.getPositiveButton();
        r3.setTextColor(getContext().getColor(R.color.oui_on_accent_default));
        r3.setBackgroundColor(getContext().getColor(R.color.oui_functional_red_6));
        return this.delAllDialog;
    }

    static /* synthetic */ ButtonStyleController lambda$getDeleteAllDialog$6(Context r1, Integer r2) {
        return new AlertDialogButtonStyleController(r1, r2.intValue());
    }

    protected OInsetSheet getMenuDialog() {
        OInsetSheet r0 = this.mMenuDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OActionSheet.Companion.Modifier r1 = new OActionSheet.Companion.Modifier(OInsetSheet.PanelWidth.NARROW_WIDTH, getString(R.string.dialog_title_text_delete_one_call), "", new BlackCallLogList$$ExternalSyntheticLambda0(this));
        this.mMenuDialog = new OActionSheet(getActivity(), r1);
        View r2 = LayoutInflater.from(getActivity()).inflate(R.layout.delete_menu_item, null);
        ((OButton) r2.findViewById(R.id.delete_btn)).setText(R.string.dialog_delete_conform);
        this.mMenuDialog.setContainerView(r2);
        this.mMenuDialog.setOnCancelListener(new AnonymousClass11(this));
        return this.mMenuDialog;
    }

    /* JADX INFO: renamed from: lambda$getMenuDialog$7$com-bytedanceos-preventdisturb-BlackCallLogList, reason: not valid java name */
    /* synthetic */ Unit m111xd68eda50() {
        this.mMenuDialog.dismiss();
        return Unit.INSTANCE;
    }

    public void showDelCallDialog(final String phoneNumber) {
        OInsetSheet r0 = getMenuDialog();
        r0.contentContainer.findViewById(R.id.delete_btn).setOnClickListener(new AnonymousClass12(this, phoneNumber));
        r0.show();
        r0.rootContainer.setOnApplyWindowInsetsListener(null);
        ViewCompat.setOnApplyWindowInsetsListener(r0.rootContainer, new BlackCallLogList$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ WindowInsetsCompat lambda$showDelCallDialog$8(View r1, WindowInsetsCompat r2) {
        IndicatorExternalsKt.setMarginBottom(r1, 56);
        r1.setPadding(0, 0, 0, 0);
        return r2;
    }

    private void removeCallLogByPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber) == true) goto L6;
        OLog.d(TAG, "deleteCallByPhoneNumber phoneNumber is " + EncryptPhoneToMd5Kt.calculateMD5(phoneNumber));
        this.mQueryCallHandler.startDelete(10, null, BLOCKED_CALL_LOG_URI, "bcl_phone_number=?", new String[]{phoneNumber});
        return;
    }

    private void removeFromBlackList(int threadId) {
        if (threadId <= 0) goto L5;
        this.mQueryCallHandler.startDelete(9, null, BLOCKED_CALL_LOG_URI, "bcl_bl_id=?", new String[]{String.valueOf(threadId)});
        return;
    }

    @Override // com.bytedanceos.preventdisturb.BlackListCallLogAdapter.BlackListCallAdapterListener
    public void onCallScrollBtnClick(View v) {
        int r0 = v.getId();
        if (r0 != R.id.scroll_del_btn) goto L5;
        showDelCallDialog((String) v.getTag());
        return;
    L5:
        if (r0 != R.id.scroll_unblock_btn) goto L11;
        String r11 = (String) v.getTag();
        Uri r5 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r11));
        this.mQueryCallHandler.startQuery(7, new BlackListItem(this, r11, r11), r5, CONTACT_PROJECTION, null, null, null);
        return;
    }

    @Override // com.bytedanceos.preventdisturb.BlackListCallLogAdapter.BlackListCallAdapterListener
    public void onCallCursorChanged(Cursor cursor) {
        if (cursor != null) goto L4;
    L5:
        unbindListeners(-1);
        return;
    L4:
        if (cursor.getCount() == 0) goto L5;
    }

    private void addToContacts(String phoneNum) {
        Intent r4 = new Intent("com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit").setPackage("com.android.contacts").putExtra("phone", phoneNum);
        r4.setPackage("com.android.contacts");
        r4.addFlags(268435456);
        startActivity(r4);
    }

    private void unbindListeners(long threadId) {
        if (this.mCallList != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mCallList.getChildCount()) goto L23;
        if (this.mCallList.getChildAt(r0) == null) goto L22;
        View r1 = this.mCallList.getChildAt(r0).findViewById(R.id.conversation_list_item);
        if (r1 == null) goto L22;
        if ((r1 instanceof BlackCallListItem) == true) goto L17;
        OLog.e(TAG, "unbindListeners item view is not instanceof BlackCallListItem, view: " + r1);
        goto L22
    L17:
        if (threadId != (-1)) goto L19;
    L20:
        ((BlackCallListItem) r1).unbind();
        goto L22
    L19:
        if (threadId == this.mCallLogAdapter.getItemId(r0)) goto L20;
    L22:
        r0 = r0 + 1;
        goto L7
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateButtonWidth();
        setEmptyViewLayoutParams();
    }
}
