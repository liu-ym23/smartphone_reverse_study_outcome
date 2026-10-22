package com.bytedanceos.preventdisturb;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import bytedanceos.util.LogTag;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedanceos.preventdisturb.widget.AsyncDialog;
import com.bytedanceos.preventdisturb.widget.ConversationListItem;
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
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.utils.StyleUtil;
import com.obric.safecheck.util.serviceutil.EncryptPhoneToMd5Kt;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.securitycenter.api.TrackUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public class SpamConversationList extends Fragment implements ConversationListAdapter.ConversationListAdapterListener {
    public static final String ACTION_BYTEDANCE_INSERT_OR_EDIT = "com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit";
    private static int BLOCK_NUMBER = 0;
    private static final String COLUMN_NAME = "bl_note";
    private static final String COLUMN_NUMBER = "bl_phone_number";
    private static final String COLUMN_PHOTO = "bl_photo";
    private static final int DELETE_CONVERSATION_TOKEN = 1801;
    private static final Uri JOIN_OR_REMOVE_URI = null;
    private static final int MESSAGE_LIST_RESTORE_TOKEN = 9528;
    private static final Uri NOT_FILTER_NUMBER_URI = null;
    private static final String TAG = "SpamConversationList";
    private static final int THREAD_LIST_QUERY_TD_SMS_TOKEN = 1901;
    public static final int THREAD_LIST_QUERY_TOKEN = 1701;
    private static final String THREAD_LIST_SELECTION = "message_count > td_sms_count";
    private static final String THREAD_LIST_TD_SMS_SELECTION = "td_sms_count > 0";
    private static final int TOKEN_JOIN_BLACKLIST = 9881;
    private static final int TOKEN_REMOVE_FROM_BLACKLIST = 9880;
    private static int UNBLOCK_AND_ADD_NUMBER;
    private static int UNBLOCK_NUMBER_ONLY;
    private OButtonFloating bottomClear;
    private OAlertDialog delAllDialog;
    private OActionSheet deleteItemDialog;
    private FrameLayout emptyViewRoot;
    private OSectionTitleBar mAllCountView;
    private AsyncDialog mAsyncDialog;
    private int mBlockType;
    private OBottomActionBarFloating mClearBtn;
    private FrameLayout mClearView;
    private OPageStatus mEmptyView;
    private ConversationListAdapter mListAdapter;
    private final PerformanceMonitors.FpsSceneSession mListFpsSession;
    private HorizontalScrollListView mListView;
    private ConversationListItemClickListener mListener;
    private final PageMonitor mPageMonitor;
    private final HashMap<String, Long> mPeriodStarts;
    private ThreadListQueryHandler mQueryHandler;
    private ImageView mStatusLight;
    private ListContentItemText mTdSmsAllItem;
    private View mTdSmsAllView;
    private OActionSheet mUnblockDlg;
    private BroadcastReceiver mUpdateListReceiver;

    public interface ConversationListItemClickListener {
        void onConversationListItemClick(long key, String activityName);
    }

    private final class ThreadListQueryHandler extends Conversation.ConversationQueryHandler {
        final /* synthetic */ SpamConversationList this$0;

        public ThreadListQueryHandler(final SpamConversationList this$0, ContentResolver contentResolver) {
            this.this$0 = this$0;
            super(contentResolver);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (token == 1701) goto L8;
            if (token == SpamConversationList.THREAD_LIST_QUERY_TD_SMS_TOKEN) goto L8;
            OLog.e(SpamConversationList.TAG, "onQueryComplete called with unknown token " + token);
        L8:
            if (SpamConversationList.access$300(this.this$0).getEmptyView() != null) goto L10;
            SpamConversationList.access$300(this.this$0).setEmptyView(SpamConversationList.access$400(this.this$0));
        L10:
            SpamConversationList.access$500(this.this$0).changeCursor(cursor);
            SpamConversationList.access$500(this.this$0).notifyDataSetChanged();
            SpamConversationList r4 = this.this$0;
            if (cursor != null) goto L13;
        L15:
            boolean r1 = false;
        L16:
            SpamConversationList.access$600(r4, r1);
            if (this.this$0.isAdded() == false) goto L29;
            int r5 = cursor.getPosition();
            if (cursor == null) goto L25;
            cursor.moveToPosition(-1);
            int r2 = 0;
        L22:
            if (cursor.moveToNext() == false) goto L24;
            r2 = r2 + cursor.getInt(2);
            goto L22
        L24:
            cursor.moveToPosition(r5);
        L26:
            SpamConversationList.access$700(this.this$0).setTitleText(this.this$0.getResources().getString(R.string.spam_conversation, new Object[]{Integer.valueOf(r2)}));
            return;
        L25:
            r2 = 0;
            goto L26
        L29:
            return;
        L13:
            if (cursor.getCount() <= 0) goto L15;
            r1 = true;
            goto L16
        }

        @Override // com.bytedanceos.preventdisturb.Conversation.ConversationQueryHandler, android.content.AsyncQueryHandler
        protected void onDeleteComplete(int token, Object cookie, int result) {
            super.onDeleteComplete(token, cookie, result);
            if (token == SpamConversationList.DELETE_CONVERSATION_TOKEN) goto L6;
            return;
        L6:
            if (cookie != null) goto L11;
            if (Utils.hasTelephonyFeature(this.this$0.getContext()) == false) goto L18;
            Contact.init(SecurityCenterApplication.getApplication());
            Conversation.init(SecurityCenterApplication.getApplication(), true);
        L18:
            SpamConversationList.access$800(this.this$0);
            return;
        L11:
            if ((cookie instanceof UnBlockItem) == false) goto L14;
            HashSet r5 = new HashSet();
            UnBlockItem r4 = (UnBlockItem) cookie;
            r5.add(Long.valueOf(r4.threadId));
            this.this$0.doRemoveBlacklistAction(r4.phoneNumber);
        L17:
            Conversation.clearDeleteCache(r5, true);
            goto L18
        L14:
            if ((cookie instanceof Long) == false) goto L16;
            r5 = new HashSet();
            r5.add((Long) cookie);
            goto L17
        L16:
            r5 = null;
            goto L17
        }

        @Override // android.content.AsyncQueryHandler
        protected void onUpdateComplete(int token, Object cookie, int result) {
            if (token != SpamConversationList.MESSAGE_LIST_RESTORE_TOKEN) goto L16;
            if (cookie != null) goto L7;
            return;
        L7:
            if ((cookie instanceof Long) == false) goto L10;
            long r0 = ((Long) cookie).longValue();
        L13:
            LogTag.d(SpamConversationList.TAG, "MESSAGE_LIST_RESTORE_TOKEN threadid " + r0);
            SpamConversationList.access$900(this.this$0).startDelete(SpamConversationList.DELETE_CONVERSATION_TOKEN, cookie, ContentUris.withAppendedId(Uri.parse("content://bytedance_spam/conversations"), r0), null, null);
            return;
        L10:
            if ((cookie instanceof UnBlockItem) == false) goto L12;
            r0 = ((UnBlockItem) cookie).threadId;
            goto L13
        L12:
            r0 = 0;
            goto L13
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int token, Object cookie, Uri uri) {
            super.onInsertComplete(token, cookie, uri);
            Contact.invalidateCache();
            SpamConversationList.access$800(this.this$0);
        }
    }

    class UnBlockItem {
        String phoneNumber;
        final /* synthetic */ SpamConversationList this$0;
        long threadId;

        public UnBlockItem(final SpamConversationList this$0, String phoneNumber, long Id) {
            this.this$0 = this$0;
            this.threadId = Id;
            this.phoneNumber = phoneNumber;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$pPE5rbTeqE4Z-tDbHYjB4snUdbQ, reason: not valid java name */
    public static /* synthetic */ void m117$r8$lambda$pPE5rbTeqE4ZtDbHYjB4snUdbQ(SpamConversationList r0) {
        r0.setEmptyViewLayoutParams();
    }

    public void resetListView() {
    }

    public String scene() {
        return "intercept_sms_page";
    }

    public SpamConversationList() {
        this.mUnblockDlg = null;
        this.mPageMonitor = PerformanceMonitors.createPageMonitor(PerformanceScenes.PAGE_PERMISSION_DISTURB_SMS);
        this.mPeriodStarts = new HashMap();
        this.mListFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_PERMISSION_DISTURB_SMS_LIST);
        this.deleteItemDialog = null;
        this.mBlockType = BLOCK_NUMBER;
        this.delAllDialog = null;
        this.mUpdateListReceiver = new AnonymousClass11(this);
    }

    static /* synthetic */ void access$000(SpamConversationList r0, String r1) {
        r0.markEnd(r1);
    }

    static /* synthetic */ OBottomActionBarFloating access$100(SpamConversationList r0) {
        return r0.mClearBtn;
    }

    static /* synthetic */ int access$1000(SpamConversationList r0) {
        return r0.mBlockType;
    }

    static /* synthetic */ int access$1002(SpamConversationList r0, int r1) {
        r0.mBlockType = r1;
        return r1;
    }

    static /* synthetic */ int access$1100() {
        return BLOCK_NUMBER;
    }

    static /* synthetic */ void access$1200(SpamConversationList r0, boolean r1, Contact r2, long r3) {
        r0.unblockNumber(r1, r2, r3);
    }

    static /* synthetic */ OActionSheet access$1300(SpamConversationList r0) {
        return r0.mUnblockDlg;
    }

    static /* synthetic */ int access$1400() {
        return UNBLOCK_AND_ADD_NUMBER;
    }

    static /* synthetic */ void access$1500(SpamConversationList r0, Contact r1) {
        r0.addToContacts(r1);
    }

    static /* synthetic */ OAlertDialog access$1600(SpamConversationList r0) {
        return r0.delAllDialog;
    }

    static /* synthetic */ void access$1700(SpamConversationList r0, Contact r1) {
        r0.addToNotFilterDB(r1);
    }

    static /* synthetic */ PerformanceMonitors.FpsSceneSession access$200(SpamConversationList r0) {
        return r0.mListFpsSession;
    }

    static /* synthetic */ HorizontalScrollListView access$300(SpamConversationList r0) {
        return r0.mListView;
    }

    static /* synthetic */ OPageStatus access$400(SpamConversationList r0) {
        return r0.mEmptyView;
    }

    static /* synthetic */ ConversationListAdapter access$500(SpamConversationList r0) {
        return r0.mListAdapter;
    }

    static /* synthetic */ void access$600(SpamConversationList r0, boolean r1) {
        r0.setUiState(r1);
    }

    static /* synthetic */ OSectionTitleBar access$700(SpamConversationList r0) {
        return r0.mAllCountView;
    }

    static /* synthetic */ void access$800(SpamConversationList r0) {
        r0.startAsyncQuery();
    }

    static /* synthetic */ ThreadListQueryHandler access$900(SpamConversationList r0) {
        return r0.mQueryHandler;
    }

    static {
        NOT_FILTER_NUMBER_URI = Uri.parse("content://com.obric.nodisturb.provider/notfilter");
        JOIN_OR_REMOVE_URI = Uri.parse("content://com.obric.nodisturb.provider/blacklist");
        BLOCK_NUMBER = 0;
        UNBLOCK_NUMBER_ONLY = 1;
        UNBLOCK_AND_ADD_NUMBER = 2;
    }

    public void setListener(ConversationListItemClickListener l) {
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
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(PerformanceScenes.PAGE_PERMISSION_DISTURB_SMS, period), r1);
    L5:
        this.mPageMonitor.markEnd(period);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        markStart(PageMonitor.PERIOD_FRAGMENT_CREATE);
        if (getActivity() != null) goto L5;
    L7:
        super.onCreate(savedInstanceState);
        markEnd(PageMonitor.PERIOD_FRAGMENT_CREATE);
        return;
    L5:
        if (getActivity().getApplicationContext() == null) goto L7;
        this.mQueryHandler = new ThreadListQueryHandler(this, getActivity().getApplicationContext().getContentResolver());
        goto L7
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        markStart(PageMonitor.PERIOD_FRAGMENT_VIEW_CREATE);
        View r4 = inflater.inflate(R.layout.spam_conversation_list, container, false);
        this.mListView = (HorizontalScrollListView) r4.findViewById(R.id.system_list);
        initListAdapter();
        this.emptyViewRoot = (FrameLayout) r4.findViewById(R.id.empty_status_root);
        setEmptyViewLayoutParams();
        r4.addOnLayoutChangeListener(new SpamConversationList$$ExternalSyntheticLambda7(this));
        OPageStatus r0 = (OPageStatus) r4.findViewById(R.id.empty_status);
        this.mEmptyView = r0;
        r0.setTitle(getString(R.string.no_spam_sms));
        this.mClearView = (FrameLayout) r4.findViewById(R.id.clear_bt_contain);
        this.mClearBtn = (OBottomActionBarFloating) r4.findViewById(R.id.clear_all_msg);
        initDeleteActionView();
        View r3 = inflater.inflate(R.layout.all_count_layout, null);
        this.mTdSmsAllView = r3;
        this.mListView.addHeaderView(r3);
        this.mAllCountView = (OSectionTitleBar) this.mTdSmsAllView.findViewById(R.id.all_count_tv);
        PerformanceMonitors.markRealShowOnce(r4, new AnonymousClass1(this));
        markStart("userdata_real_show");
        markEnd(PageMonitor.PERIOD_FRAGMENT_VIEW_CREATE);
        return r4;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-bytedanceos-preventdisturb-SpamConversationList, reason: not valid java name */
    /* synthetic */ void m122x471884cb(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) == (r9 - r7)) goto L6;
        r1.post(new SpamConversationList$$ExternalSyntheticLambda3(this));
        return;
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

    private void initDeleteActionView() {
        OButtonFloating r0 = (OButtonFloating) StyleUtil.createWidgetWithStyle(this.mClearBtn.getContext(), 2131821350, new SpamConversationList$$ExternalSyntheticLambda8(this));
        this.bottomClear = r0;
        OBottomActionBarFloating r1 = this.mClearBtn;
        if (r1 == null) goto L9;
        r1.setButtons(Collections.singletonList(r0));
        ViewCompat.setOnApplyWindowInsetsListener(this.mClearBtn, new SpamConversationList$$ExternalSyntheticLambda9());
        if (ViewCompat.isAttachedToWindow(this.mClearBtn) == false) goto L7;
        ViewCompat.requestApplyInsets(this.mClearBtn);
        return;
    L7:
        this.mClearBtn.addOnAttachStateChangeListener(new AnonymousClass2(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$2$com-bytedanceos-preventdisturb-SpamConversationList, reason: not valid java name */
    /* synthetic */ OButtonFloating m121xf8557883(Context r4, Integer r5, Integer r6) {
        OButtonFloating r0 = new OButtonFloating(r4);
        r0.setTitle(getString(R.string.delete_btn));
        r0.getTextView().setTextColor(this.mClearBtn.getContext().getColor(R.color.oui_functional_red_6));
        r0.setLayoutParams(new ViewGroup.LayoutParams(r5.intValue(), r6.intValue()));
        r0.setOnClickListener(new SpamConversationList$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$initDeleteActionView$1$com-bytedanceos-preventdisturb-SpamConversationList, reason: not valid java name */
    /* synthetic */ void m120x6b1ac702(View r1) {
        getDeleteAllDialog().show();
    }

    static /* synthetic */ WindowInsetsCompat lambda$initDeleteActionView$3(View r2, WindowInsetsCompat r3) {
        Insets r0 = r3.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        r1.bottomMargin = r0.bottom;
        r2.setLayoutParams(r1);
        return r3;
    }

    private void initListAdapter() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        ConversationListAdapter r0 = new ConversationListAdapter(getActivity(), null, this, true);
        this.mListAdapter = r0;
        this.mListView.setAdapter(r0);
        this.mListView.setOverScrollMode(0);
        this.mListView.setRecyclerListener(this.mListAdapter);
        this.mListView.setOnScrollStateChangeListener(new AnonymousClass3(this));
    }

    private View initFootView() {
        if (getContext() != null) goto L5;
        return null;
    L5:
        View r0 = LayoutInflater.from(getContext()).inflate(R.layout.caches_footer, null);
        r0.setLayoutParams(new AbsListView.LayoutParams(1, Utils.dp2Pixels(getContext(), 74.0f)));
        return r0;
    }

    @Override // com.bytedanceos.preventdisturb.ConversationListAdapter.ConversationListAdapterListener
    public void onCursorChanged(Cursor cursor) {
        if (cursor != null) goto L4;
    L5:
        unbindListeners(null);
        return;
    L4:
        if (cursor.getCount() == 0) goto L5;
    }

    @Override // com.bytedanceos.preventdisturb.ConversationListAdapter.ConversationListAdapterListener
    public void onContentChanged(ConversationListAdapter adapter) {
        startAsyncQuery();
    }

    private void unbindListeners(final Collection<Long> threadIds) {
        if (this.mListView != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mListView.getChildCount()) goto L22;
        if (this.mListView.getChildAt(r0) == null) goto L21;
        View r1 = this.mListView.getChildAt(r0).findViewById(R.id.conversation_list_item);
        if (r1 == null) goto L21;
        if ((r1 instanceof ConversationListItem) == false) goto L20;
        if (threadIds != null) goto L18;
    L19:
        ((ConversationListItem) r1).unbind();
        goto L21
    L18:
        if (threadIds.contains(Long.valueOf(this.mListAdapter.getItemId(r0))) == false) goto L21;
    L20:
        OLog.e(TAG, "unbindListeners item view is not instanceof ConversationListItem, view: " + r1);
    L21:
        r0 = r0 + 1;
        goto L7
    }

    public void deleteThread(long threadId) {
        if (threadId >= 0) goto L5;
        threadId = -threadId;
    L5:
        HashSet r0 = new HashSet();
        r0.add(Long.valueOf(threadId));
        deleteThread(r0);
    }

    public void deleteThread(Collection<Long> threadIds) {
        unbindListeners(threadIds);
        Iterator<Long> r0 = threadIds.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        long r1 = r0.next().longValue();
        Conversation.startDeleteOneSpamThread(this.mQueryHandler, DELETE_CONVERSATION_TOKEN, Long.valueOf(r1));
        goto L4
    L6:
        threadIds.clear();
    }

    private void startAsyncQuery() {
        Conversation.startQuery(this.mQueryHandler, THREAD_LIST_QUERY_TOKEN, null, true);     // Catch: SQLiteException -> L4
        return;
    }

    private void startAsyncQueryTdSms() {
        Conversation.startQuery(this.mQueryHandler, THREAD_LIST_QUERY_TD_SMS_TOKEN, THREAD_LIST_TD_SMS_SELECTION, true);     // Catch: SQLiteException -> L4
        return;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        startAsyncQuery();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        unbindListeners(null);
        this.mListView.restoreScrollState(false);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        OActionSheet r0 = this.mUnblockDlg;
        if (r0 != null) goto L5;
    L7:
        super.onDestroy();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mUnblockDlg.dismiss();
        goto L7
    }

    public void openThread(long threadId) {
        if (threadId != 0) goto L5;
        return;
    L5:
        if (threadId >= 0) goto L7;
        threadId = -threadId;
    L7:
        this.mListener.onConversationListItemClick(threadId, "com.android.mms.spam.SpamComposeMessageActivity");
    }

    @Override // android.app.Fragment
    public void onResume() {
        markStart(PageMonitor.PERIOD_FRAGMENT_RESUME);
        registBroadcastReceiver();
        super.onResume();
        PerformanceMonitors.reportSceneFrequency(PerformanceScenes.PAGE_PERMISSION_DISTURB_SMS);
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
    public void onPause() {
        unregistBroadcastReceiver();
        this.mListFpsSession.stop();
        super.onPause();
    }

    private void registBroadcastReceiver() {
        IntentFilter r0 = new IntentFilter(SecurityCenterApplication.ACTION_UPDATE_COUNTRY_ISO);
        if (getActivity() == null) goto L6;
        getActivity().registerReceiver(this.mUpdateListReceiver, r0);
        return;
    }

    private void unregistBroadcastReceiver() {
        if (getActivity() == null) goto L6;
        getActivity().unregisterReceiver(this.mUpdateListReceiver);
        return;
    }

    @Override // com.bytedanceos.preventdisturb.ConversationListAdapter.ConversationListAdapterListener
    public void onScrollBtnClick(View v) {
        int r0 = v.getId();
        if (r0 != R.id.scroll_del_btn) goto L5;
        long r1 = ((Long) v.getTag()).longValue();
        OLog.d(TAG, "scroll_del_btn thread=" + r1);
        showDelDialog(r1);
        return;
    L5:
        if (r0 != R.id.scroll_unblock_btn) goto L11;
        long r2 = ((Long) v.getTag()).longValue();
        OLog.d(TAG, "scroll_unblock_btn thread=" + r2);
        showConfirmDialog(r2);
        return;
    }

    protected OActionSheet getUnblockDialog() {
        OActionSheet r0 = this.mUnblockDlg;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OActionSheet.Companion.Modifier r1 = new OActionSheet.Companion.Modifier(OInsetSheet.PanelWidth.NARROW_WIDTH, getString(R.string.unblock_number_confirm), "", new SpamConversationList$$ExternalSyntheticLambda1(this));
        this.mUnblockDlg = new OActionSheet(getActivity(), r1);
        View r2 = LayoutInflater.from(getActivity()).inflate(R.layout.block_unblock_menu_item, null);
        this.mUnblockDlg.setContainerView(r2);
        return this.mUnblockDlg;
    }

    /* JADX INFO: renamed from: lambda$getUnblockDialog$4$com-bytedanceos-preventdisturb-SpamConversationList, reason: not valid java name */
    /* synthetic */ Unit m119x44155715() {
        this.mUnblockDlg.dismiss();
        return Unit.INSTANCE;
    }

    public OInsetSheetTitleBar getOActionSheetTitleBar(OActionSheet oActionSheet) {
        return (OInsetSheetTitleBar) ((ViewGroup) oActionSheet.headerContainer.getChildAt(0)).getChildAt(0);
    L4:
        return null;
    }

    public void showConfirmDialog(final long threadid) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getApplicationContext() == null) goto L21;
        OActionSheet r0 = getUnblockDialog();
        this.mUnblockDlg = r0;
        FrameLayout r1 = r0.contentContainer;
        OInsetSheetTitleBar r2 = getOActionSheetTitleBar(this.mUnblockDlg);
        final Contact r3 = Conversation.get(getActivity().getApplicationContext(), threadid, true, true).getContact();
        OLog.d(TAG, "showConfirmDialog thread is " + threadid + ",contact " + r3.toString());
        new ArrayList();
        new ArrayList();
        if (r3.isInBlacklist() == false) goto L15;
        if (r2 == null) goto L11;
        r2.setTitleText(getString(R.string.unblock_number_confirm));
    L11:
        OButton r4 = (OButton) r1.findViewById(R.id.option1);
        r4.setText(R.string.unblock_number);
        r4.setVisibility(0);
        r4.setOnClickListener(new AnonymousClass4(this, r3, threadid));
        if (r3.getContactMethodId() != (-1)) goto L14;
        OButton r5 = (OButton) r1.findViewById(R.id.option2);
        r5.setText(R.string.unblock_and_add_number);
        r5.setVisibility(0);
        r5.setOnClickListener(new AnonymousClass5(this, r3, threadid));
    L18:
        this.mUnblockDlg.show();
        this.mUnblockDlg.rootContainer.setOnApplyWindowInsetsListener(null);
        ViewCompat.setOnApplyWindowInsetsListener(this.mUnblockDlg.rootContainer, new SpamConversationList$$ExternalSyntheticLambda2());
        return;
    L14:
        ((OButton) r1.findViewById(R.id.option2)).setVisibility(8);
        goto L18
    L15:
        if (r2 == null) goto L17;
        r2.setTitleText(getString(R.string.confirm_add_to_blacklist));
    L17:
        OButton r13 = (OButton) r1.findViewById(R.id.option1);
        r13.setText(R.string.confirm_add_to_blacklist_context);
        r13.setVisibility(0);
        r13.setOnClickListener(new AnonymousClass6(this, r3));
        ((OButton) r1.findViewById(R.id.option2)).setVisibility(8);
        goto L18
    }

    static /* synthetic */ WindowInsetsCompat lambda$showConfirmDialog$5(View r1, WindowInsetsCompat r2) {
        IndicatorExternalsKt.setMarginBottom(r1, 56);
        r1.setPadding(0, 0, 0, 0);
        return r2;
    }

    public void showDelDialog(final long threadId) {
        final OActionSheet r0 = getDeleteItemDialogDialog();
        r0.contentContainer.findViewById(R.id.delete_btn).setOnClickListener(new AnonymousClass7(this, r0, threadId));
        r0.show();
        r0.rootContainer.setOnApplyWindowInsetsListener(null);
        ViewCompat.setOnApplyWindowInsetsListener(r0.rootContainer, new SpamConversationList$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ WindowInsetsCompat lambda$showDelDialog$6(View r1, WindowInsetsCompat r2) {
        IndicatorExternalsKt.setMarginBottom(r1, 56);
        r1.setPadding(0, 0, 0, 0);
        return r2;
    }

    protected OActionSheet getDeleteItemDialogDialog() {
        OActionSheet r0 = this.deleteItemDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OActionSheet.Companion.Modifier r1 = new OActionSheet.Companion.Modifier(OInsetSheet.PanelWidth.NARROW_WIDTH, getString(R.string.dialog_title_text_delete_one), "", new SpamConversationList$$ExternalSyntheticLambda6(this));
        this.deleteItemDialog = new OActionSheet(getActivity(), r1);
        View r2 = genContentView();
        ((OButton) r2.findViewById(R.id.delete_btn)).setText(R.string.dialog_delete_conform);
        this.deleteItemDialog.setContainerView(r2);
        this.deleteItemDialog.setOnCancelListener(new AnonymousClass8(this));
        return this.deleteItemDialog;
    }

    /* JADX INFO: renamed from: lambda$getDeleteItemDialogDialog$7$com-bytedanceos-preventdisturb-SpamConversationList, reason: not valid java name */
    /* synthetic */ Unit m118x7558109c() {
        this.deleteItemDialog.dismiss();
        return Unit.INSTANCE;
    }

    private OAlertDialog getDeleteAllDialog() {
        OAlertDialog r0 = this.delAllDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OAlertDialogBuilder r1 = new OAlertDialogBuilder(getContext()).title(R.string.clear_all_confirm_title).overrideButtonStyleController(new SpamConversationList$$ExternalSyntheticLambda5()).horizontalButton(true);
        r1.positiveButton(R.string.confirm_clear, new AnonymousClass9(this));
        r1.negativeButton(R.string.cancel, new AnonymousClass10(this));
        OAlertDialog r2 = r1.build();
        this.delAllDialog = r2;
        OButton r3 = (OButton) r2.getPositiveButton();
        r3.setTextColor(getContext().getColor(R.color.oui_on_accent_default));
        r3.setBackgroundColor(getContext().getColor(R.color.oui_functional_red_6));
        return this.delAllDialog;
    }

    static /* synthetic */ ButtonStyleController lambda$getDeleteAllDialog$8(Context r1, Integer r2) {
        return new AlertDialogButtonStyleController(r1, r2.intValue());
    }

    private View genContentView() {
        return LayoutInflater.from(getActivity()).inflate(R.layout.delete_menu_item, null);
    }

    private void addToContacts(Contact contact) {
        LogTag.d(TAG, "addtocontacts contact " + contact.toString());
        Intent r4 = new Intent("com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit").setPackage("com.android.contacts").putExtra("phone", contact.getNumber());
        r4.setPackage("com.android.contacts");
        r4.addFlags(268435456);
        if (getActivity() == null) goto L6;
        getActivity().startActivity(r4);
        return;
    }

    private void unblockNumber(final boolean needAddToContacts, final Contact contact, final long threadid) {
        LogTag.d(TAG, "unblockNumber threadid " + threadid + ",contact is " + contact.toString());
        getAsyncDialog().runAsync(new AnonymousClass12(this, contact, threadid), new AnonymousClass13(this, needAddToContacts, contact), R.string.restoring_sms);
    }

    protected AsyncDialog getAsyncDialog() {
        if (this.mAsyncDialog != null) goto L6;
        this.mAsyncDialog = new AsyncDialog(getActivity());
    L6:
        return this.mAsyncDialog;
    }

    private void addToNotFilterDB(Contact contact) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getApplicationContext() == null) goto L13;
        if (contact != null) goto L9;
        return;
    L9:
        if (isNumberInNotFilterDB(getActivity().getApplicationContext(), contact.getNumber()) == true) goto L14;
        ContentValues r0 = new ContentValues();
        r0.put("phone_number", contact.getNumber());
        getActivity().getContentResolver().insert(NOT_FILTER_NUMBER_URI, r0);
        return;
    L14:
        return;
    }

    private boolean isNumberInNotFilterDB(Context context, String number) {
        Cursor r6 = context.getContentResolver().query(NOT_FILTER_NUMBER_URI, null, "PHONE_NUMBERS_EQUAL (phone_number,'" + number + "')", null, null);
        if (r6 != null) goto L18;
    L14:
        if (r6 == null) goto L21;
        r6.close();
        return false;
    L21:
        return false;
    L18:
        if (r6.getCount() <= 0) goto L14;
        if (r6 == null) goto L20;
        r6.close();
        return true;
    L20:
        return true;
    L10:
        th = move-exception;
        if (r6 == null) goto L13;
        r6.close();
    L13:
        throw th;
    }

    public void doRemoveBlacklistAction(String number) {
        OLog.d(TAG, "doRemoveBlacklistAction " + EncryptPhoneToMd5Kt.calculateMD5(number));
        this.mQueryHandler.startDelete(TOKEN_REMOVE_FROM_BLACKLIST, null, JOIN_OR_REMOVE_URI, "PHONE_NUMBERS_EQUAL(bl_phone_number, ?)", new String[]{number});
    }

    public void doJoinBlacklistAction(String name, byte[] photo, String number) {
        if (TextUtils.isEmpty(number.trim()) == false) goto L5;
        return;
    L5:
        ContentValues r0 = new ContentValues();
        if (TextUtils.isEmpty(name) == true) goto L8;
        r0.put("bl_note", name);
    L8:
        if (photo != null) goto L10;
    L12:
        r0.put("bl_phone_number", number);
        this.mQueryHandler.startInsert(TOKEN_JOIN_BLACKLIST, null, JOIN_OR_REMOVE_URI, r0);
        return;
    L10:
        if (photo.length <= 0) goto L12;
        r0.put("bl_photo", photo);
        goto L12
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

    private void updateTdSmsStatus(int read) {
        if (read <= 0) goto L5;
        int r3 = -1;
    L6:
        if (r3 <= (-1)) goto L8;
        this.mStatusLight.getDrawable().setLevel(r3);
        this.mStatusLight.setVisibility(0);
        return;
    L8:
        this.mStatusLight.setVisibility(8);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setEmptyViewLayoutParams();
    }
}
