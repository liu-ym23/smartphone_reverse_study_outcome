package com.obric.securitycenter.nodisturb.white;

import android.content.ActivityNotFoundException;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.securitycenter.nodisturb.BaseActivity;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: WhiteListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 a2\u00020\u0001:\u0002abB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020-H\u0002J\b\u00101\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u00107\u001a\u00020-2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020-2\u0006\u00108\u001a\u000209H\u0002J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0002J\u001a\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00052\b\b\u0002\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020-H\u0002J\"\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\u0012\u0010F\u001a\u00020-2\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\b\u0010I\u001a\u00020-H\u0014J\b\u0010J\u001a\u00020-H\u0014J\b\u0010K\u001a\u00020-H\u0014J\b\u0010L\u001a\u00020-H\u0002J\b\u0010M\u001a\u00020-H\u0002J\u001a\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010P\u001a\u00020-H\u0002J\u0010\u0010Q\u001a\u00020-2\u0006\u00106\u001a\u00020\u0005H\u0002J\b\u0010R\u001a\u00020\u0005H\u0016J\b\u0010S\u001a\u00020-H\u0002J\b\u0010T\u001a\u00020-H\u0002J\b\u0010U\u001a\u00020-H\u0002J\b\u0010V\u001a\u00020-H\u0002J\b\u0010W\u001a\u00020-H\u0002J\b\u0010X\u001a\u00020-H\u0002J\b\u0010Y\u001a\u00020-H\u0002J\u0012\u0010Z\u001a\u00020-2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\b\u0010[\u001a\u00020-H\u0002J\b\u0010\\\u001a\u00020-H\u0002J\b\u0010]\u001a\u00020-H\u0002J\u0010\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u00020\u001cH\u0002J\b\u0010`\u001a\u00020-H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "CONTACT_PROJECTION", "", "", "[Ljava/lang/String;", "INSERT_WHITE_LIST_TOKEN", "", "IS_IN_CONTACT_TOKEN", "IS_IN_WHITE_LIST_TOKEN", "PICK_CONTACT_TOKEN", "REQ_CODE_MANUALLY_ADD", "REQ_CODE_PICK_CALL_LOG", "REQ_CODE_PICK_CONTACT", "STRAT_QUERY_TOKEN", "actionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "adapter", "Lcom/obric/securitycenter/nodisturb/white/WhiteListSummaryAdapter;", "bottomClear", "Lcom/obric/oui/button/OButtonFloating;", "bottomDeleteAction", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "callLogNumber", "emptyPageStatus", "Lcom/obric/oui/status/OPageStatus;", "isSelectAllMode", "", "leftSelectAllBtn", "Lcom/obric/oui/button/OButton;", "listFpsSession", "Lcom/obric/securitycenter/nodisturb/BaseActivity$FpsSceneSession;", "listFpsStarted", "queryHandler", "Lcom/obric/securitycenter/nodisturb/white/WhiteListActivity$QueryHandler;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "resolver", "Landroid/content/ContentResolver;", "selectAllBtn", "Landroid/view/View;", "selectedIds", "", "deleteSelected", "", "deleteSingle", SlardarConfigConsts.CONFIG_ID, "enterSelectAllMode", "exitSelectAllMode", "formatNumber", "originalNumber", "getContactIdByPhoneNumber", "", AccountConst.KEY_PHONE_NUMBER, "handleCallLogContactResult", "c", "Landroid/database/Cursor;", "handlePickContactResult", "initDeleteActionView", "inputByHand", "insertWhiteList", "number", "name", "loadData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", AgentConstants.ON_START, "pickContact", "pickFromCallLog", "queryComplete", "token", "refreshWhiteList", "saveWhiteList", "scene", "setupTitleActions", "showAddMenu", "showAddWhiteListDialog", "showNormalTitleButton", "showSelectAllButton", "startListFps", "stopListFps", "submitCursorAndUpdateUi", "toggleSelectAllSelection", "updateDeleteBtnEnabled", "updateSelectAllButtonText", "updateTitleButtons", "hasData", "updateTitleSelectedCount", "Companion", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WhiteListActivity extends BaseActivity {
    private static final Companion Companion = null;

    @Deprecated
    private static final int MAX_PHONE_NUMBER_DIGITS = 11;
    private final String[] CONTACT_PROJECTION;
    private final int INSERT_WHITE_LIST_TOKEN;
    private final int IS_IN_CONTACT_TOKEN;
    private final int IS_IN_WHITE_LIST_TOKEN;
    private final int PICK_CONTACT_TOKEN;
    private final int REQ_CODE_MANUALLY_ADD;
    private final int REQ_CODE_PICK_CALL_LOG;
    private final int REQ_CODE_PICK_CONTACT;
    private final int STRAT_QUERY_TOKEN;
    private OActionDialog actionDialog;
    private WhiteListSummaryAdapter adapter;
    private OButtonFloating bottomClear;
    private OBottomActionBarFloating bottomDeleteAction;
    private String callLogNumber;
    private OPageStatus emptyPageStatus;
    private boolean isSelectAllMode;
    private OButton leftSelectAllBtn;
    private final BaseActivity.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private QueryHandler queryHandler;
    private RecyclerView recyclerView;
    private ContentResolver resolver;
    private View selectAllBtn;
    private final Set<Integer> selectedIds;

    /* JADX INFO: compiled from: WhiteListActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListActivity$Companion;", "", "()V", "MAX_PHONE_NUMBER_DIGITS", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: WhiteListActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/WhiteListActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/white/WhiteListActivity;Landroid/content/ContentResolver;)V", "onDeleteComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "result", "onInsertComplete", "uri", "Landroid/net/Uri;", "onQueryComplete", "cursor", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ WhiteListActivity this$0;

        public QueryHandler(WhiteListActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            WhiteListActivity.access$queryComplete(this.this$0, r1, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            if (r1 != WhiteListActivity.access$getINSERT_WHITE_LIST_TOKEN$p(this.this$0)) goto L6;
            WhiteListActivity.access$refreshWhiteList(this.this$0);
            return;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            WhiteListActivity.access$exitSelectAllMode(this.this$0);
            WhiteListActivity.access$refreshWhiteList(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.white.WhiteListActivity$initDeleteActionView$1, reason: invalid class name */
    /* JADX INFO: compiled from: WhiteListActivity.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButtonFloating;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButtonFloating> {
        final /* synthetic */ WhiteListActivity this$0;

        public static /* synthetic */ void $r8$lambda$LVoEmhn_fo1qoVDVZYtSaIP45_c(WhiteListActivity r0, View r1) {
            invoke$lambda$1$lambda$0(r0, r1);
        }

        AnonymousClass1(WhiteListActivity r1) {
            this.this$0 = r1;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButtonFloating invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButtonFloating invoke(Context r9, int r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            OButtonFloating r0 = new OButtonFloating(r9, null, 0, 0, 14, null);
            final WhiteListActivity r8 = this.this$0;
            String r12 = r8.getString(R.string.delete_btn);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.delete_btn)");
            r0.setTitle(r12);
            OBaseTextView r13 = r0.getTextView();
            OBottomActionBarFloating r1 = WhiteListActivity.access$getBottomDeleteAction$p(r8);
            Intrinsics.checkNotNull(r1);
            r13.setTextColor(r1.getContext().getColor(com.obric.common.oui.R.color.oui_functional_red_6));
            r0.setLayoutParams(new ViewGroup.LayoutParams(r10, r11));
            r0.setOnClickListener(new WhiteListActivity$initDeleteActionView$1$$ExternalSyntheticLambda0(r8));
            return r0;
        }

        private static final void invoke$lambda$1$lambda$0(WhiteListActivity r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            WhiteListActivity.access$deleteSelected(r0);
        }
    }

    public static /* synthetic */ void $r8$lambda$93PwQhVapnmvwrJDxQk14tbU_Q8(WhiteListActivity r0, View r1) {
        updateTitleButtons$lambda$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Pr1OkHQFMBiFxRcckQzITJm7q-Q, reason: not valid java name */
    public static /* synthetic */ void m619$r8$lambda$Pr1OkHQFMBiFxRcckQzITJm7qQ(WhiteListActivity r0, View r1) {
        updateTitleButtons$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Sl5rLGxfOAa8pU2ht78U6S0zOAU(WhiteListActivity r0, View r1) {
        showAddMenu$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZWegpoAMQ_HlVvAMXcDAJJVzr3o(WhiteListActivity r0, View r1) {
        showNormalTitleButton$lambda$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$a4LaEFx2Kx7SXWhuMVjhA1p3qks(WhiteListActivity r0, View r1) {
        showAddMenu$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bSMOWkIb3ENKN1h_tH0YP2uQxmM(WhiteListActivity r0, View r1) {
        showAddMenu$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bZO3pjtCc5TFtlssEaLxIiqCXSw(WhiteListActivity r0, View r1) {
        showSelectAllButton$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$lDge5X0kHub-8RxnAnBS2xMOH3w, reason: not valid java name */
    public static /* synthetic */ void m620$r8$lambda$lDge5X0kHub8RxnAnBS2xMOH3w(WhiteListActivity r0, View r1) {
        updateSelectAllButtonText$lambda$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$lXTEWR6gwxcMLCvWNXqixau2Fk0(WhiteListActivity r0, View r1) {
        showAddMenu$lambda$1(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public String scene() {
        return "whitelist_page";
    }

    public static final /* synthetic */ void access$deleteSelected(WhiteListActivity r0) {
        r0.deleteSelected();
    }

    public static final /* synthetic */ void access$deleteSingle(WhiteListActivity r0, int r1) {
        r0.deleteSingle(r1);
    }

    public static final /* synthetic */ void access$enterSelectAllMode(WhiteListActivity r0) {
        r0.enterSelectAllMode();
    }

    public static final /* synthetic */ void access$exitSelectAllMode(WhiteListActivity r0) {
        r0.exitSelectAllMode();
    }

    public static final /* synthetic */ WhiteListSummaryAdapter access$getAdapter$p(WhiteListActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ OBottomActionBarFloating access$getBottomDeleteAction$p(WhiteListActivity r0) {
        return r0.bottomDeleteAction;
    }

    public static final /* synthetic */ int access$getINSERT_WHITE_LIST_TOKEN$p(WhiteListActivity r0) {
        return r0.INSERT_WHITE_LIST_TOKEN;
    }

    public static final /* synthetic */ Set access$getSelectedIds$p(WhiteListActivity r0) {
        return r0.selectedIds;
    }

    public static final /* synthetic */ void access$queryComplete(WhiteListActivity r0, int r1, Cursor r2) {
        r0.queryComplete(r1, r2);
    }

    public static final /* synthetic */ void access$refreshWhiteList(WhiteListActivity r0) {
        r0.refreshWhiteList();
    }

    public static final /* synthetic */ void access$saveWhiteList(WhiteListActivity r0, String r1) {
        r0.saveWhiteList(r1);
    }

    public static final /* synthetic */ void access$startListFps(WhiteListActivity r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(WhiteListActivity r0) {
        r0.stopListFps();
    }

    public static final /* synthetic */ void access$updateDeleteBtnEnabled(WhiteListActivity r0) {
        r0.updateDeleteBtnEnabled();
    }

    public static final /* synthetic */ void access$updateTitleSelectedCount(WhiteListActivity r0) {
        r0.updateTitleSelectedCount();
    }

    public WhiteListActivity() {
        this.listFpsSession = new BaseActivity.FpsSceneSession(PerformanceScenes.FPS_NODISTURB_WHITELIST_LIST);
        this.selectedIds = new LinkedHashSet();
        this.REQ_CODE_PICK_CONTACT = 1;
        this.REQ_CODE_PICK_CALL_LOG = 2;
        this.REQ_CODE_MANUALLY_ADD = 3;
        this.INSERT_WHITE_LIST_TOKEN = 3;
        this.STRAT_QUERY_TOKEN = 8;
        this.IS_IN_WHITE_LIST_TOKEN = 4;
        this.IS_IN_CONTACT_TOKEN = 7;
        this.CONTACT_PROJECTION = new String[]{"display_name"};
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.activity_white_list);
        initTitleBar(false, false);
        getWindow().setStatusBarColor(0);
        ContentResolver r0 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r0, "contentResolver");
        this.resolver = r0;
        ContentResolver r1 = this.resolver;
        OPageStatus r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r1 = null;
    L5:
        this.queryHandler = new QueryHandler(this, r1);
        View r3 = findViewById(R.id.white_list);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.white_list)");
        RecyclerView r4 = (RecyclerView) r3;
        this.recyclerView = r4;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r4 = null;
    L8:
        r4.setClipToPadding(false);
        RecyclerView r5 = this.recyclerView;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r5 = null;
    L11:
        r5.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView r7 = this.recyclerView;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L14:
        r7.setDescendantFocusability(393216);
        RecyclerView r8 = this.recyclerView;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r8 = null;
    L17:
        RecyclerView.ItemAnimator r9 = r8.getItemAnimator();
        if ((r9 instanceof SimpleItemAnimator) == false) goto L20;
        SimpleItemAnimator r10 = (SimpleItemAnimator) r9;
    L21:
        if (r10 == null) goto L24;
        r10.setSupportsChangeAnimations(false);
    L24:
        this.adapter = new WhiteListSummaryAdapter(new C03961(this), new AnonymousClass2(this), new AnonymousClass3(this));
        RecyclerView r11 = this.recyclerView;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L27:
        WhiteListSummaryAdapter r12 = this.adapter;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r12 = null;
    L30:
        r11.setAdapter(r12);
        RecyclerView r13 = this.recyclerView;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L33:
        r13.addOnScrollListener(new AnonymousClass4(this));
        this.bottomDeleteAction = (OBottomActionBarFloating) findViewById(R.id.bottom_delete_action);
        initDeleteActionView();
        View r14 = findViewById(R.id.empty_status);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.empty_status)");
        OPageStatus r15 = (OPageStatus) r14;
        this.emptyPageStatus = r15;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("emptyPageStatus");
        r15 = null;
    L36:
        r15.setTitle(getString(R.string.empty_white_list_title));
        OPageStatus r16 = this.emptyPageStatus;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("emptyPageStatus");
    L40:
        r2.setMessage(getString(R.string.empty_white_list_message));
        setupTitleActions();
        return;
    L39:
        r2 = r16;
        goto L40
    L20:
        r10 = null;
        goto L21
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopListFps();
        super.onPause();
    }

    private final void initDeleteActionView() {
        OBottomActionBarFloating r0 = this.bottomDeleteAction;
        Intrinsics.checkNotNull(r0);
        Context r1 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "bottomDeleteAction!!.context");
        OButtonFloating r2 = (OButtonFloating) StyleUtil.createWidgetWithStyle(r1, R.style.OStyleV2_OButtonFloating_M_Standard_Text, new AnonymousClass1(this));
        this.bottomClear = r2;
        OBottomActionBarFloating r3 = this.bottomDeleteAction;
        if (r3 == null) goto L6;
        List<? extends View> r4 = CollectionsKt.listOf(r2);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.List<android.view.View>");
        r3.setButtons(r4);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        loadData();
    }

    private final void loadData() {
        String[] r7 = {"_id", ProviderConstants.WhiteList.WL_PHONE_NUMBER, ProviderConstants.WhiteList.WL_NOTE};
        QueryHandler r0 = this.queryHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r0 = null;
    L5:
        r0.startQuery(this.STRAT_QUERY_TOKEN, null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), r7, null, null, null);
    }

    private final void refreshWhiteList() {
        loadData();
    }

    private final void setupTitleActions() {
        showNormalTitleButton();
    }

    private final void showAddMenu() {
        OActionDialog r0 = this.actionDialog;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        if (r0.isShowing() == false) goto L7;
        return;
    L7:
        WhiteListActivity r1 = this;
        final View r2 = LayoutInflater.from(r1).inflate(R.layout.blacklist_action_dialog, null);
        String r3 = getString(R.string.add_to_white_list);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.add_to_white_list)");
        this.actionDialog = new OActionDialog(r1, new OActionDialog.Modifier(r3, "", new WhiteListActivity$showAddMenu$modifier$1(r2)));
        OButton r4 = (OButton) r2.findViewById(R.id.btn_contacts);
        OButton r5 = (OButton) r2.findViewById(R.id.btn_call_log);
        OButton r6 = (OButton) r2.findViewById(R.id.btn_manual);
        OButton r7 = (OButton) r2.findViewById(R.id.btn_cancel);
        r4.setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda5(this));
        r5.setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda6(this));
        r6.setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda7(this));
        r7.setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda8(this));
        OActionDialog r8 = this.actionDialog;
        if (r8 == null) goto L11;
        r8.show();
        return;
    }

    private static final void showAddMenu$lambda$0(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.pickContact();
    }

    private static final void showAddMenu$lambda$1(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.pickFromCallLog();
    }

    private static final void showAddMenu$lambda$2(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.inputByHand();
    }

    private static final void showAddMenu$lambda$3(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }

    private final void pickContact() {
        Intent r0 = new Intent("android.intent.action.PICK");
        r0.addCategory("android.intent.category.DEFAULT");
        r0.setPackage("com.android.contacts");
        r0.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(r0, this.REQ_CODE_PICK_CONTACT);     // Catch: ActivityNotFoundException -> L5
        return;
    }

    private final void pickFromCallLog() {
        Intent r0 = new Intent("android.intent.action.PICK");
        r0.setType("vnd.android.cursor.dir/calls");
        startActivityForResult(r0, this.REQ_CODE_PICK_CALL_LOG);     // Catch: ActivityNotFoundException -> L5
        return;
    }

    private final void inputByHand() {
        showAddWhiteListDialog();
    }

    private final void showAddWhiteListDialog() {
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        String r2 = getString(R.string.add_to_white_list);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.add_to_white_list)");
        String r3 = r2;
        String r4 = getString(R.string.empty_white_list_message);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.empty_white_list_message)");
        String r5 = r4;
        OSimpleFormDialog.InputViewConfig r6 = new OSimpleFormDialog.InputViewConfig(true, true, new WhiteListActivity$showAddWhiteListDialog$modifier$1(this, r1));
        Function1 r13 = null;
        DefaultConstructorMarker r15 = null;
        OSimpleFormDialog.InputViewConfig r7 = new OSimpleFormDialog.InputViewConfig(false, false, r13, 6, r15);
        String r8 = getString(R.string.keyword_empty_add);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.keyword_empty_add)");
        OBaseDialog.ButtonConfig r9 = new OBaseDialog.ButtonConfig(r8, new WhiteListActivity$showAddWhiteListDialog$modifier$2(r1, this), null, 4, null);
        String r11 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(r11, "getString(R.string.cancel)");
        WhiteListActivity r0 = this;
        new OSimpleFormDialog(r0, new OSimpleFormDialog.Modifier(r3, r5, r6, r7, r9, new OBaseDialog.ButtonConfig(r11, WhiteListActivity$showAddWhiteListDialog$modifier$3.INSTANCE, r13, 4, r15))).show();
    }

    private final void saveWhiteList(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        insertWhiteList$default(this, r3, null, 2, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r11, int r12, Intent r13) {
        super.onActivityResult(r11, r12, r13);
        if (r12 != (-1)) goto L42;
        if (r13 == null) goto L42;
        if (r11 != this.REQ_CODE_PICK_CONTACT) goto L17;
        Uri r14 = r13.getData();
        if (r14 != null) goto L11;
        return;
    L11:
        Uri r5 = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, r14.getLastPathSegment());
        Intrinsics.checkNotNullExpressionValue(r5, "withAppendedPath(android…URI, uri.lastPathSegment)");
        QueryHandler r15 = this.queryHandler;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r2 = null;
    L15:
        r2.startQuery(this.PICK_CONTACT_TOKEN, null, r5, new String[]{"data1", "display_name"}, null, null, null);
        return;
    L14:
        r2 = r15;
        goto L15
    L17:
        if (r11 != this.REQ_CODE_PICK_CALL_LOG) goto L38;
        Bundle r16 = r13.getExtras();
        if (r16 == null) goto L21;
        String[] r17 = r16.getStringArray("com.android.contacts.extra.PHONE_URIS");
    L22:
        boolean r18 = false;
        if (r17 == null) goto L25;
        String r19 = (String) ArraysKt.getOrNull(r17, 0);
    L26:
        String r110 = r19;
        if (r110 != null) goto L29;
    L30:
        r18 = true;
    L31:
        if (r18 == true) goto L46;
        String r111 = formatNumber(r19);
        this.callLogNumber = r111;
        Uri r6 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r111));
        QueryHandler r112 = this.queryHandler;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r3 = null;
    L36:
        r3.startQuery(this.IS_IN_CONTACT_TOKEN, null, r6, this.CONTACT_PROJECTION, null, null, null);
        return;
    L35:
        r3 = r112;
        goto L36
    L46:
        return;
    L29:
        if (r110.length() != 0) goto L31;
    L25:
        r19 = null;
        goto L26
    L21:
        r17 = null;
        goto L22
    L38:
        if (r11 != this.REQ_CODE_MANUALLY_ADD) goto L48;
        loadData();
        return;
    L48:
        return;
    L42:
        if (r11 != this.REQ_CODE_MANUALLY_ADD) goto L49;
        loadData();
        return;
    }

    private final void queryComplete(int r2, Cursor r3) {
        if (r2 != this.STRAT_QUERY_TOKEN) goto L6;
        submitCursorAndUpdateUi(r3);
        return;
    L6:
        if (r2 != this.PICK_CONTACT_TOKEN) goto L10;
        if (r3 == null) goto L20;
        handlePickContactResult(r3);
        return;
    L20:
        return;
    L10:
        if (r2 != this.IS_IN_CONTACT_TOKEN) goto L13;
        if (r3 == null) goto L22;
        handleCallLogContactResult(r3);
        return;
    L22:
        return;
    L13:
        if (r3 == null) goto L24;
        r3.close();     // Catch: Exception -> L16
        return;
    L25:
        return;
    }

    private final void submitCursorAndUpdateUi(Cursor r9) {
        ArrayList r0 = new ArrayList();
        if (r9 == null) goto L18;
        int r1 = r9.getColumnIndex("_id");
        int r2 = r9.getColumnIndex(ProviderConstants.WhiteList.WL_PHONE_NUMBER);
        int r3 = r9.getColumnIndex(ProviderConstants.WhiteList.WL_NOTE);
        if (r1 < 0) goto L18;
        if (r2 < 0) goto L18;
    L8:
        if (r9.moveToNext() == false) goto L18;
        int r4 = (int) r9.getLong(r1);
        String r5 = r9.getString(r2);
        String r6 = "";
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        if (r3 < 0) goto L17;
        String r7 = r9.getString(r3);
        if (r7 == null) goto L17;
        r6 = r7;
    L17:
        r0.add(new WhiteListSummaryItem(r4, r5, r6));
    L18:
        boolean r8 = !r0.isEmpty();
        if (r8 == true) goto L24;
        if (this.isSelectAllMode == false) goto L24;
        exitSelectAllMode();
    L24:
        if (this.isSelectAllMode == true) goto L26;
    L32:
        OPageStatus r10 = this.emptyPageStatus;
        WhiteListSummaryAdapter r11 = null;
        if (r10 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("emptyPageStatus");
        r10 = null;
    L35:
        if (r8 == false) goto L37;
        int r12 = 8;
    L38:
        r10.setVisibility(r12);
        WhiteListSummaryAdapter r13 = this.adapter;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r13 = null;
    L41:
        r13.submitItems(r0);
        WhiteListSummaryAdapter r14 = this.adapter;
        if (r14 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L45:
        r11.setSelectedIds(this.selectedIds);
        updateTitleButtons(r8);
        if (r9 == null) goto L57;
        r9.close();     // Catch: Exception -> L49
        return;
    L58:
        return;
    L57:
        return;
    L44:
        r11 = r14;
        goto L45
    L37:
        r12 = 0;
        goto L38
    L26:
        if ((!this.selectedIds.isEmpty()) == false) goto L32;
        ArrayList r15 = r0;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L31;
        r16.add(Integer.valueOf(((WhiteListSummaryItem) r17.next()).getId()));
        goto L29
    L31:
        this.selectedIds.retainAll(CollectionsKt.toSet(r16));
        goto L32
    }

    private final void updateTitleButtons(boolean r10) {
        if (this.isSelectAllMode == false) goto L5;
        return;
    L5:
        this.mTitle.removeAllEndAction();
        OFloatingTitleBar r1 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "mTitle");
        OFloatingTitleBar.addEndAction$default(r1, R.drawable.icon_add, 0, null, 6, null).setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda1(this));
        if (r10 == false) goto L11;
        OFloatingTitleBar r3 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "mTitle");
        View r11 = OFloatingTitleBar.addEndAction$default(r3, R.drawable.icon_select_all, 0, null, 4, null);
        this.selectAllBtn = r11;
        if (r11 == null) goto L12;
        r11.setOnClickListener(new WhiteListActivity$$ExternalSyntheticLambda2(this));
        return;
    L12:
        return;
    }

    private static final void updateTitleButtons$lambda$5(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        WhiteListSummaryAdapter r2 = r0.adapter;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L5:
        r2.refreshSwipeState();
        r0.showAddMenu();
    }

    private static final void updateTitleButtons$lambda$6(WhiteListActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        WhiteListSummaryAdapter r4 = r2.adapter;
        WhiteListSummaryAdapter r0 = null;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L6:
        if (r4.getItemCount() <= 0) goto L13;
        WhiteListSummaryAdapter r5 = r2.adapter;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L11:
        r0.refreshSwipeState();
        r2.enterSelectAllMode();
        return;
    L10:
        r0 = r5;
        goto L11
    }

    private final void handlePickContactResult(Cursor r5) {
    L19:
        th = move-exception;
        r5.close();     // Catch: Exception -> L25
    L21:
        throw th;
    L3:
        if (r5.moveToFirst() == false) goto L26;
        boolean r0 = false;
        String r1 = r5.getString(0);     // Catch: Exception -> L23 Throwable -> L19
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r3 = r5.getString(r5.getColumnIndexOrThrow("display_name"));     // Catch: Exception -> L23 Throwable -> L19
        if (r3 == null) goto L12;
        r2 = r3;
    L12:
        String r4 = formatNumber(r1);     // Catch: Exception -> L23 Throwable -> L19
        if (r4.length() <= 0) goto L15;
        r0 = true;
    L15:
        if (r0 == false) goto L26;
        insertWhiteList(r4, r2);     // Catch: Exception -> L23 Throwable -> L19
    L26:
        r5.close();     // Catch: Exception -> L24
        return;
    }

    private final void handleCallLogContactResult(Cursor r4) {
        String r0 = this.callLogNumber;     // Catch: Exception -> L23 Throwable -> L18
        if (r0 != null) goto L7;
        r4.close();     // Catch: Exception -> L22
        return;
    L34:
        return;
    L7:
        String r2 = "";
        if (r4.getCount() > 0) goto L10;
    L15:
        insertWhiteList(r0, r2);     // Catch: Exception -> L23 Throwable -> L18
        goto L26
    L10:
        if (r4.moveToFirst() == false) goto L15;
        String r1 = r4.getString(r4.getColumnIndexOrThrow("display_name"));     // Catch: Exception -> L23 Throwable -> L18
        if (r1 == null) goto L15;
        r2 = r1;
    L18:
        th = move-exception;
        r4.close();     // Catch: Exception -> L25
    L20:
        throw th;
    L26:
        r4.close();     // Catch: Exception -> L24
        return;
    }

    static /* synthetic */ void insertWhiteList$default(WhiteListActivity r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        r0.insertWhiteList(r1, r2);
    }

    private final void insertWhiteList(String r10, String r11) {
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Uri r3 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_WHITE_LIST_URI(), r10);
        ContentResolver r1 = this.resolver;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        ContentResolver r2 = null;
    L12:
        Cursor r4 = r2.query(r3, null, null, null, null);
        Cursor r5 = r4;     // Catch: Throwable -> L30
        if (r5 != null) goto L16;
    L20:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r4, null);
        ContentValues r7 = new ContentValues();
        r7.put(ProviderConstants.WhiteList.WL_PHONE_NUMBER, r10);
        long r8 = getContactIdByPhoneNumber(r10);
        if (r8 > 0) goto L25;
        r8 = 0;
    L25:
        r7.put(ProviderConstants.WhiteList.WL_CONTACT_ID, Long.valueOf(r8));
        r7.put(ProviderConstants.WhiteList.WL_NOTE, r11);
        QueryHandler r12 = this.queryHandler;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r12 = null;
    L28:
        r12.startInsert(this.INSERT_WHITE_LIST_TOKEN, null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), r7);
        return;
    L16:
        if (r5.getCount() <= 0) goto L20;
        Toast.makeText(getApplicationContext(), getString(R.string.in_white_list_toast), 0).show();     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r4, null);
        return;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L11:
        r2 = r1;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final String formatNumber(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(r13, "-", "", false, 4, null), " ", "", false, 4, null);
    }

    private final void deleteSingle(int r7) {
        QueryHandler r6 = this.queryHandler;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r6 = null;
    L5:
        r6.startDelete(0, null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), "_id = ?", new String[]{String.valueOf(r7)});
    }

    private final void deleteSelected() {
        if (this.selectedIds.isEmpty() == false) goto L5;
        return;
    L5:
        String r5 = "_id IN (" + CollectionsKt.joinToString$default(this.selectedIds, ",", null, null, 0, null, WhiteListActivity$deleteSelected$placeholders$1.INSTANCE, 30, null) + ")";
        Set<Integer> r0 = this.selectedIds;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        r1.add(String.valueOf(((Number) r2.next()).intValue()));
        goto L7
    L9:
        String[] r6 = (String[]) r1.toArray(new String[0]);
        QueryHandler r10 = this.queryHandler;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r10 = null;
    L12:
        r10.startDelete(1, null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), r5, r6);
    }

    private final void enterSelectAllMode() {
        if (this.isSelectAllMode == false) goto L5;
        return;
    L5:
        this.isSelectAllMode = true;
        this.selectedIds.clear();
        OBottomActionBarFloating r1 = this.bottomDeleteAction;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        showSelectAllButton();
        WhiteListSummaryAdapter r2 = this.adapter;
        WhiteListSummaryAdapter r3 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L12:
        r2.setSelectionMode(true);
        WhiteListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L16:
        r3.setSelectedIds(this.selectedIds);
        updateTitleSelectedCount();
        updateDeleteBtnEnabled();
        return;
    L15:
        r3 = r0;
        goto L16
    }

    private final void exitSelectAllMode() {
        if (this.isSelectAllMode == true) goto L5;
        return;
    L5:
        this.isSelectAllMode = false;
        this.selectedIds.clear();
        OBottomActionBarFloating r1 = this.bottomDeleteAction;
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        showNormalTitleButton();
        WhiteListSummaryAdapter r2 = this.adapter;
        WhiteListSummaryAdapter r3 = null;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L12:
        r2.setSelectionMode(false);
        WhiteListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L16:
        r3.setSelectedIds(this.selectedIds);
        return;
    L15:
        r3 = r0;
        goto L16
    }

    private final void updateTitleSelectedCount() {
        if (this.isSelectAllMode == false) goto L5;
        this.mTitle.setCenterTitle(getString(R.string.select_some_items, new Object[]{Integer.valueOf(this.selectedIds.size())}));
        updateSelectAllButtonText();
        return;
    L5:
        this.mTitle.setCenterTitle(getString(R.string.white_list_title));
    }

    private final void updateDeleteBtnEnabled() {
        boolean r0 = !this.selectedIds.isEmpty();
        OButtonFloating r1 = this.bottomClear;
        if (r1 == null) goto L6;
        r1.setEnabled(r0);
    L6:
        OButtonFloating r2 = this.bottomClear;
        if (r2 == null) goto L11;
        OBaseTextView r3 = r2.getTextView();
        if (r3 == null) goto L11;
        r3.setTextColor(getResources().getColor(com.obric.common.oui.R.color.oui_functional_red_6));
    L11:
        OButtonFloating r4 = this.bottomClear;
        if (r4 == null) goto L14;
        OBaseTextView r5 = r4.getTextView();
    L15:
        if (r5 == null) goto L22;
        if (r0 == false) goto L19;
        float r6 = 1.0f;
    L20:
        r5.setAlpha(r6);
        return;
    L19:
        r6 = 0.5f;
        goto L20
    L22:
        return;
    L14:
        r5 = null;
        goto L15
    }

    private final void showNormalTitleButton() {
        this.mTitle.removeEndAction();
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new WhiteListActivity$$ExternalSyntheticLambda3(this));
        WhiteListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L6:
        if (r0.getItemCount() <= 0) goto L8;
        boolean r1 = true;
    L9:
        updateTitleButtons(r1);
        this.mTitle.setCenterTitle(getString(R.string.white_list_title));
        this.mTitle.setEndButtonGroupStyle(R.style.OFloatingTitleBar_Action_Standard);
        return;
    L8:
        r1 = false;
        goto L9
    }

    private static final void showNormalTitleButton$lambda$9(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void showSelectAllButton() {
        this.mTitle.removeAllEndAction();
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(R.drawable.icon_close_black, -1, new WhiteListActivity$$ExternalSyntheticLambda4(this));
        this.mTitle.setEndButtonGroupStyle(R.style.OFloatingTitleBar_Action_PrimaryLight_Text);
        updateSelectAllButtonText();
    }

    private static final void showSelectAllButton$lambda$10(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.exitSelectAllMode();
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        stopListFps();
        super.onDestroy();
    }

    private final void startListFps() {
        if (this.listFpsStarted == false) goto L5;
        return;
    L5:
        this.listFpsStarted = true;
        this.listFpsSession.start();
    }

    private final void stopListFps() {
        if (this.listFpsStarted == true) goto L5;
        return;
    L5:
        this.listFpsStarted = false;
        this.listFpsSession.stop();
    }

    private final void updateSelectAllButtonText() {
        this.mTitle.removeEndAction();
        WhiteListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        List<WhiteListSummaryItem> r1 = r0.getAllItems();
        boolean r2 = true;
        if ((!r1.isEmpty()) == true) goto L8;
    L10:
        r2 = false;
    L11:
        OFloatingTitleBar r3 = this.mTitle;
        if (r2 == false) goto L14;
        int r4 = R.string.cancel_all;
    L15:
        String r5 = getString(r4);
        Intrinsics.checkNotNullExpressionValue(r5, "if (isAllSelected) getSt…ring(R.string.select_all)");
        r3.addEndAction(r5, -1, new WhiteListActivity$$ExternalSyntheticLambda0(this));
        return;
    L14:
        r4 = R.string.select_all;
        goto L15
    L8:
        if (this.selectedIds.size() != r1.size()) goto L10;
        goto L10
    }

    private static final void updateSelectAllButtonText$lambda$11(WhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.toggleSelectAllSelection();
    }

    private final void toggleSelectAllSelection() {
        WhiteListSummaryAdapter r0 = this.adapter;
        WhiteListSummaryAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        List<WhiteListSummaryItem> r2 = r0.getAllItems();
        if (r2.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.selectedIds.size() != r2.size()) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        this.selectedIds.clear();
    L19:
        WhiteListSummaryAdapter r4 = this.adapter;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L23:
        r1.setSelectedIds(this.selectedIds);
        updateTitleSelectedCount();
        updateDeleteBtnEnabled();
        return;
    L22:
        r1 = r4;
        goto L23
    L14:
        this.selectedIds.clear();
        Set<Integer> r5 = this.selectedIds;
        List<WhiteListSummaryItem> r6 = r2;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r7.add(Integer.valueOf(((WhiteListSummaryItem) r8.next()).getId()));
        goto L16
    L18:
        r5.addAll(r7);
        goto L19
    L11:
        r3 = false;
        goto L12
    }

    private final long getContactIdByPhoneNumber(String r11) {
        if (r11.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L29;
        return -1;
    L29:
        Cursor r10 = getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r11)), new String[]{"_id"}, null, null, null);     // Catch: Exception -> L26
        if (r10 == null) goto L34;
        Cursor r12 = r10;     // Catch: Exception -> L26
        Cursor r13 = r12;     // Catch: Throwable -> L21
        if (r13.moveToFirst() == false) goto L17;
        long r1 = r13.getLong(0);     // Catch: Throwable -> L21
    L19:
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L26
        return r1;
    L17:
        r1 = -1;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    L34:
        return -1;
    L26:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L5:
        r0 = false;
        goto L7
    }
}
