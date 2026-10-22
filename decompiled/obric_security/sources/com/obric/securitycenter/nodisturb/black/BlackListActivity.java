package com.obric.securitycenter.nodisturb.black;

import android.content.ActivityNotFoundException;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: BlackListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0007*\u0002\u001fC\b\u0007\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0087\u0001\u0088\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010J\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010K\u001a\u00020F2\u0006\u0010L\u001a\u00020HH\u0002J\u0010\u0010M\u001a\u00020F2\u0006\u0010L\u001a\u00020HH\u0002J\b\u0010N\u001a\u00020FH\u0002J\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020FH\u0002J\u0010\u0010R\u001a\u00020F2\u0006\u0010S\u001a\u00020\bH\u0002J\b\u0010T\u001a\u00020FH\u0002J\b\u0010U\u001a\u00020FH\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u0005H\u0002J\u0010\u0010X\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010Y\u001a\u00020FH\u0002J\u0010\u0010Z\u001a\u00020F2\u0006\u0010[\u001a\u000206H\u0002J\b\u0010\\\u001a\u00020FH\u0002J\u0010\u0010]\u001a\u00020F2\u0006\u0010^\u001a\u00020\u0005H\u0002J\b\u0010_\u001a\u00020FH\u0002J\"\u0010`\u001a\u00020F2\u0006\u0010a\u001a\u00020\b2\u0006\u0010b\u001a\u00020\b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0014J\u0012\u0010e\u001a\u00020F2\b\u0010f\u001a\u0004\u0018\u00010gH\u0014J\b\u0010h\u001a\u00020FH\u0014J\b\u0010i\u001a\u00020FH\u0014J\b\u0010j\u001a\u00020FH\u0014J\b\u0010k\u001a\u00020FH\u0002J\b\u0010l\u001a\u00020FH\u0002J\u001a\u0010m\u001a\u00020F2\u0006\u0010n\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010o\u001a\u00020FH\u0002J\b\u0010p\u001a\u00020FH\u0002J\b\u0010q\u001a\u00020FH\u0002J\b\u0010r\u001a\u00020\u0005H\u0016J\b\u0010s\u001a\u00020FH\u0002J\b\u0010t\u001a\u00020FH\u0002J\b\u0010u\u001a\u00020FH\u0002J\b\u0010v\u001a\u00020FH\u0002J\b\u0010w\u001a\u00020FH\u0002J\b\u0010x\u001a\u00020FH\u0002J\b\u0010y\u001a\u00020FH\u0002J\b\u0010z\u001a\u00020FH\u0002J\b\u0010{\u001a\u00020FH\u0002J\b\u0010|\u001a\u00020FH\u0002J\u0010\u0010}\u001a\u00020F2\u0006\u0010~\u001a\u00020)H\u0002J\u001f\u0010\u007f\u001a\u00020F2\u0007\u0010\u0080\u0001\u001a\u00020H2\f\b\u0002\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\t\u0010\u0083\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020F2\u0007\u0010\u0085\u0001\u001a\u00020)H\u0002J\t\u0010\u0086\u0001\u001a\u00020FH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0010\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00060;R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006\u0089\u0001"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "CONTACT_PROJECTION", "", "", "[Ljava/lang/String;", "INSERT_BLACK_LIST_TOKEN", "", "IS_IN_BLACK_LIST_FROM_CALL_LOG_TOKEN", "IS_IN_BLACK_LIST_FROM_CONTACT_TOKEN", "IS_IN_BLACK_LIST_FROM_MANUAL_TOKEN", "IS_IN_CONTACT_FROM_MANUAL_TOKEN", "IS_IN_CONTACT_TOKEN", "PHONE_PROJECTION", "PHOTO_PROJECTION", "PICK_CONTACT_TOKEN", "QUERY_PHOTO_FROM_MANUAL_TOKEN", "QUERY_PHOTO_TOKEN", "REQ_CODE_PICK_CALL_LOG", "REQ_CODE_PICK_CONTACT", "STRAT_QUERY_TOKEN", "actionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "adapter", "Lcom/obric/securitycenter/nodisturb/black/BlackListSummaryAdapter;", "bottomClear", "Lcom/obric/oui/button/OButtonFloating;", "bottomDeleteAction", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "callInterceptObserver", "com/obric/securitycenter/nodisturb/black/BlackListActivity$callInterceptObserver$1", "Lcom/obric/securitycenter/nodisturb/black/BlackListActivity$callInterceptObserver$1;", "callLogNumber", "contentValues", "Landroid/content/ContentValues;", "deleteGroup", "Landroidx/constraintlayout/widget/Group;", "emptyStatus", "Lcom/obric/oui/status/OPageStatus;", "isSelectAllMode", "", "leftSelectAllBtn", "Lcom/obric/oui/button/OButton;", "listFpsSession", "Lcom/obric/securitycenter/nodisturb/BaseActivity$FpsSceneSession;", "listFpsStarted", "manualNoteStr", "manualNumberNoteInput", "Lcom/obric/oui/forms/OInputLayout;", "manualNumberStr", "manualPhoneNumberInput", "Lcom/obric/oui/forms/OPhoneInputLayout;", "manualSaveButton", "Landroid/view/View;", "manuallyAddSheet", "Lcom/obric/oui/sheet/v2/OSheet;", "photoId", "queryHandler", "Lcom/obric/securitycenter/nodisturb/black/BlackListActivity$QueryHandler;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "resolver", "Landroid/content/ContentResolver;", "selectedIds", "", "smsInterceptObserver", "com/obric/securitycenter/nodisturb/black/BlackListActivity$smsInterceptObserver$1", "Lcom/obric/securitycenter/nodisturb/black/BlackListActivity$smsInterceptObserver$1;", "checkIsInBlackListFromCallLog", "", "c", "Landroid/database/Cursor;", "checkIsInBlackListFromContact", "checkIsInBlackListFromManual", "checkIsInContactAndInsert", "contactCursor", "checkManualNumberInContactAndInsert", "clearManualAddSheetRefs", "createPhoneNumberDigitLimitFilter", "Landroid/text/InputFilter;", "deleteSelected", "deleteSingle", SlardarConfigConsts.CONFIG_ID, "enterSelectAllMode", "exitSelectAllMode", "formatNumber", "originalNumber", "handlePickContactResult", "initDeleteActionView", "initManualAddSheetContent", "contentView", "inputByHand", "insertBlackList", "number", "loadData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", AgentConstants.ON_START, "pickContact", "pickFromCallLog", "queryComplete", "token", "refreshBlackList", "registerObservers", "saveManualAdd", "scene", "setupTitleActions", "showAddMenu", "showManualAddSheet", "showNormalTitleButton", "showSelectAllButton", "startListFps", "stopListFps", "toggleSelectAllSelection", "unregisterObservers", "updateDeleteBtnEnabled", "updateEmptyStatus", InvokeHistoryActivity.PREF_SHOW, "updatePhotoAndInsert", "srcCursor", BaseHttpRequestInfo.KEY_COOKIE, "", "updateSelectAllButtonText", "updateTitleButtons", "hasData", "updateTitleSelectedCount", "Companion", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackListActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String MANUAL_ADD_COOKIE = "manual_add";
    private static final int MAX_PHONE_NUMBER_DIGITS = 11;
    private final String[] CONTACT_PROJECTION;
    private final int INSERT_BLACK_LIST_TOKEN;
    private final int IS_IN_BLACK_LIST_FROM_CALL_LOG_TOKEN;
    private final int IS_IN_BLACK_LIST_FROM_CONTACT_TOKEN;
    private final int IS_IN_BLACK_LIST_FROM_MANUAL_TOKEN;
    private final int IS_IN_CONTACT_FROM_MANUAL_TOKEN;
    private final int IS_IN_CONTACT_TOKEN;
    private final String[] PHONE_PROJECTION;
    private final String[] PHOTO_PROJECTION;
    private final int PICK_CONTACT_TOKEN;
    private final int QUERY_PHOTO_FROM_MANUAL_TOKEN;
    private final int QUERY_PHOTO_TOKEN;
    private final int REQ_CODE_PICK_CALL_LOG;
    private final int REQ_CODE_PICK_CONTACT;
    private final int STRAT_QUERY_TOKEN;
    private OActionDialog actionDialog;
    private BlackListSummaryAdapter adapter;
    private OButtonFloating bottomClear;
    private OBottomActionBarFloating bottomDeleteAction;
    private final BlackListActivity$callInterceptObserver$1 callInterceptObserver;
    private String callLogNumber;
    private ContentValues contentValues;
    private Group deleteGroup;
    private OPageStatus emptyStatus;
    private boolean isSelectAllMode;
    private OButton leftSelectAllBtn;
    private final BaseActivity.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private String manualNoteStr;
    private OInputLayout manualNumberNoteInput;
    private String manualNumberStr;
    private OPhoneInputLayout manualPhoneNumberInput;
    private View manualSaveButton;
    private OSheet manuallyAddSheet;
    private int photoId;
    private QueryHandler queryHandler;
    private RecyclerView recyclerView;
    private ContentResolver resolver;
    private final Set<Integer> selectedIds;
    private final BlackListActivity$smsInterceptObserver$1 smsInterceptObserver;

    /* JADX INFO: compiled from: BlackListActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListActivity$Companion;", "", "()V", "MANUAL_ADD_COOKIE", "", "MAX_PHONE_NUMBER_DIGITS", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: BlackListActivity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¨\u0006\u0012"}, d2 = {"Lcom/obric/securitycenter/nodisturb/black/BlackListActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/black/BlackListActivity;Landroid/content/ContentResolver;)V", "onDeleteComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "result", "onInsertComplete", "uri", "Landroid/net/Uri;", "onQueryComplete", "cursor", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ BlackListActivity this$0;

        public QueryHandler(BlackListActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            BlackListActivity.access$queryComplete(this.this$0, r1, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            if (r1 != BlackListActivity.access$getINSERT_BLACK_LIST_TOKEN$p(this.this$0)) goto L10;
            BlackListActivity.access$refreshBlackList(this.this$0);
            if (Intrinsics.areEqual(r2, BlackListActivity.MANUAL_ADD_COOKIE) == false) goto L11;
            OSheet r0 = BlackListActivity.access$getManuallyAddSheet$p(this.this$0);
            if (r0 == null) goto L12;
            r0.dismiss();
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            BlackListActivity.access$exitSelectAllMode(this.this$0);
            BlackListActivity.access$refreshBlackList(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.obric.securitycenter.nodisturb.black.BlackListActivity$initDeleteActionView$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlackListActivity.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButtonFloating;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButtonFloating> {
        final /* synthetic */ BlackListActivity this$0;

        public static /* synthetic */ void $r8$lambda$v6sAKfpdNiXGdx9cudHlD0rfRJ4(BlackListActivity r0, View r1) {
            invoke$lambda$1$lambda$0(r0, r1);
        }

        AnonymousClass1(BlackListActivity r1) {
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
            final BlackListActivity r8 = this.this$0;
            String r12 = r8.getString(R.string.delete_btn);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.delete_btn)");
            r0.setTitle(r12);
            OBaseTextView r13 = r0.getTextView();
            OBottomActionBarFloating r1 = BlackListActivity.access$getBottomDeleteAction$p(r8);
            Intrinsics.checkNotNull(r1);
            r13.setTextColor(r1.getContext().getColor(com.obric.common.oui.R.color.oui_functional_red_6));
            r0.setLayoutParams(new ViewGroup.LayoutParams(r10, r11));
            r0.setOnClickListener(new BlackListActivity$initDeleteActionView$1$$ExternalSyntheticLambda0(r8));
            return r0;
        }

        private static final void invoke$lambda$1$lambda$0(BlackListActivity r0, View r1) {
            Intrinsics.checkNotNullParameter(r0, "this$0");
            BlackListActivity.access$deleteSelected(r0);
        }
    }

    public static /* synthetic */ void $r8$lambda$7lg4oAU2LxRMKoMJm9xFrk22iMI(BlackListActivity r0, View r1) {
        showSelectAllButton$lambda$22(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$94eZDZLW3d914wYhwKQ0cqO9sxQ(BlackListActivity r0, View r1) {
        showAddMenu$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ex1-XkHo_H_UiWuLcsf5wPAwxdI, reason: not valid java name */
    public static /* synthetic */ void m609$r8$lambda$Ex1XkHo_H_UiWuLcsf5wPAwxdI(OSheet r0, View r1) {
        showManualAddSheet$lambda$8$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Jan2PfKxWADZGzABe6oyxZTZ0E8(BlackListActivity r0, View r1) {
        updateSelectAllButtonText$lambda$23(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$QE3Sma0hcF39lvQR_iEIPrhUDVg(BlackListActivity r0, View r1) {
        updateTitleButtons$lambda$19(r0, r1);
    }

    public static /* synthetic */ CharSequence $r8$lambda$SYRjFN_4krEK6RsqMN3LC5ZTCEI(CharSequence r0, int r1, int r2, Spanned r3, int r4, int r5) {
        return createPhoneNumberDigitLimitFilter$lambda$15(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$_SEUmwFokqbfPlB_02SwSut8vvw(BlackListActivity r0, View r1) {
        showAddMenu$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$b29pZSLMKM7oc4XzOD-p79tZbwQ, reason: not valid java name */
    public static /* synthetic */ void m610$r8$lambda$b29pZSLMKM7oc4XzODp79tZbwQ(BlackListActivity r0, View r1) {
        showAddMenu$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$cIILAbanQhcCuSFz6M6mK3Vg37Y(BlackListActivity r0, View r1) {
        showNormalTitleButton$lambda$21(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$jZvaW_kHnIjZgQZprsdZ8pZA_kw(BlackListActivity r0, DialogInterface r1) {
        showManualAddSheet$lambda$8$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ln_RjwS_HP7sDywAZK4Vq8miXxY(BlackListActivity r0, View r1) {
        showAddMenu$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$xScFFaRwapfq07c2j-qpJ1EGPdk, reason: not valid java name */
    public static /* synthetic */ void m611$r8$lambda$xScFFaRwapfq07c2jqpJ1EGPdk(BlackListActivity r0, View r1) {
        updateTitleButtons$lambda$20(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zCeRKZN473xDe5CQodRWIvSb268(BlackListActivity r0, View r1) {
        showManualAddSheet$lambda$8$lambda$6(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    private final InputFilter createPhoneNumberDigitLimitFilter() {
        return new BlackListActivity$$ExternalSyntheticLambda10();
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public String scene() {
        return "blacklist_page";
    }

    public static final /* synthetic */ void access$deleteSelected(BlackListActivity r0) {
        r0.deleteSelected();
    }

    public static final /* synthetic */ void access$deleteSingle(BlackListActivity r0, int r1) {
        r0.deleteSingle(r1);
    }

    public static final /* synthetic */ void access$enterSelectAllMode(BlackListActivity r0) {
        r0.enterSelectAllMode();
    }

    public static final /* synthetic */ void access$exitSelectAllMode(BlackListActivity r0) {
        r0.exitSelectAllMode();
    }

    public static final /* synthetic */ OBottomActionBarFloating access$getBottomDeleteAction$p(BlackListActivity r0) {
        return r0.bottomDeleteAction;
    }

    public static final /* synthetic */ int access$getINSERT_BLACK_LIST_TOKEN$p(BlackListActivity r0) {
        return r0.INSERT_BLACK_LIST_TOKEN;
    }

    public static final /* synthetic */ View access$getManualSaveButton$p(BlackListActivity r0) {
        return r0.manualSaveButton;
    }

    public static final /* synthetic */ OSheet access$getManuallyAddSheet$p(BlackListActivity r0) {
        return r0.manuallyAddSheet;
    }

    public static final /* synthetic */ Set access$getSelectedIds$p(BlackListActivity r0) {
        return r0.selectedIds;
    }

    public static final /* synthetic */ void access$loadData(BlackListActivity r0) {
        r0.loadData();
    }

    public static final /* synthetic */ void access$queryComplete(BlackListActivity r0, int r1, Cursor r2) {
        r0.queryComplete(r1, r2);
    }

    public static final /* synthetic */ void access$refreshBlackList(BlackListActivity r0) {
        r0.refreshBlackList();
    }

    public static final /* synthetic */ void access$startListFps(BlackListActivity r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(BlackListActivity r0) {
        r0.stopListFps();
    }

    public static final /* synthetic */ void access$updateDeleteBtnEnabled(BlackListActivity r0) {
        r0.updateDeleteBtnEnabled();
    }

    public static final /* synthetic */ void access$updateTitleSelectedCount(BlackListActivity r0) {
        r0.updateTitleSelectedCount();
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.obric.securitycenter.nodisturb.black.BlackListActivity$callInterceptObserver$1] */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.obric.securitycenter.nodisturb.black.BlackListActivity$smsInterceptObserver$1] */
    public BlackListActivity() {
        this.listFpsSession = new BaseActivity.FpsSceneSession(PerformanceScenes.FPS_NODISTURB_BLACKLIST_LIST);
        this.selectedIds = new LinkedHashSet();
        this.REQ_CODE_PICK_CONTACT = 1;
        this.REQ_CODE_PICK_CALL_LOG = 2;
        this.QUERY_PHOTO_TOKEN = 1;
        this.QUERY_PHOTO_FROM_MANUAL_TOKEN = 2;
        this.INSERT_BLACK_LIST_TOKEN = 3;
        this.IS_IN_BLACK_LIST_FROM_CONTACT_TOKEN = 5;
        this.IS_IN_BLACK_LIST_FROM_CALL_LOG_TOKEN = 6;
        this.IS_IN_CONTACT_TOKEN = 7;
        this.STRAT_QUERY_TOKEN = 8;
        this.IS_IN_BLACK_LIST_FROM_MANUAL_TOKEN = 9;
        this.IS_IN_CONTACT_FROM_MANUAL_TOKEN = 10;
        this.manualNumberStr = "";
        this.manualNoteStr = "";
        this.PHONE_PROJECTION = new String[]{"data1", "display_name", "photo_id"};
        this.CONTACT_PROJECTION = new String[]{"display_name", "photo_id"};
        this.PHOTO_PROJECTION = new String[]{"_id", "data15"};
        final Handler r0 = new Handler();
        this.callInterceptObserver = new BlackListActivity$callInterceptObserver$1(this, r0);
        final Handler r1 = new Handler();
        this.smsInterceptObserver = new BlackListActivity$smsInterceptObserver$1(this, r1);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r6) {
        super.onCreate(r6);
        setContentView(R.layout.activity_black_list);
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
        View r3 = findViewById(R.id.black_list);
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.black_list)");
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
        RecyclerView.ItemAnimator r8 = r7.getItemAnimator();
        if ((r8 instanceof SimpleItemAnimator) == false) goto L17;
        SimpleItemAnimator r9 = (SimpleItemAnimator) r8;
    L18:
        if (r9 == null) goto L21;
        r9.setSupportsChangeAnimations(false);
    L21:
        this.adapter = new BlackListSummaryAdapter(new C03911(this), new AnonymousClass2(this), new AnonymousClass3(this));
        RecyclerView r10 = this.recyclerView;
        if (r10 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r10 = null;
    L24:
        BlackListSummaryAdapter r11 = this.adapter;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r11 = null;
    L27:
        r10.setAdapter(r11);
        RecyclerView r12 = this.recyclerView;
        if (r12 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r12 = null;
    L30:
        r12.addOnScrollListener(new AnonymousClass4(this));
        this.bottomDeleteAction = (OBottomActionBarFloating) findViewById(R.id.bottom_delete_action);
        initDeleteActionView();
        View r13 = findViewById(R.id.empty_status);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.empty_status)");
        OPageStatus r14 = (OPageStatus) r13;
        this.emptyStatus = r14;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("emptyStatus");
        r14 = null;
    L33:
        r14.setTitle(getString(R.string.black_list_empty_title));
        OPageStatus r15 = this.emptyStatus;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("emptyStatus");
    L37:
        r2.setMessage(getString(R.string.black_list_empty_message));
        setupTitleActions();
        registerObservers();
        return;
    L36:
        r2 = r15;
        goto L37
    L17:
        r9 = null;
        goto L18
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopListFps();
        super.onPause();
    }

    private final void refreshBlackList() {
        loadData();
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

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        stopListFps();
        unregisterObservers();
        OSheet r0 = this.manuallyAddSheet;
        if (r0 == null) goto L5;
        r0.setOnDismissListener(null);
    L5:
        OSheet r1 = this.manuallyAddSheet;
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        this.manuallyAddSheet = null;
        super.onDestroy();
        BlackListSummaryAdapter.BlackVH.Companion.getCardItemRefs().clear();
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

    private final void registerObservers() {
        ContentResolver r0 = this.resolver;
        ContentResolver r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r0 = null;
    L5:
        r0.registerContentObserver(ProviderConstants.INSTANCE.getCALL_INTERCEPT_COUNT_URI(), true, this.callInterceptObserver);
        ContentResolver r2 = this.resolver;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
    L9:
        r1.registerContentObserver(ProviderConstants.INSTANCE.getSMS_INTERCEPT_COUNT_URI(), true, this.smsInterceptObserver);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void unregisterObservers() {
        ContentResolver r0 = this.resolver;
        ContentResolver r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r0 = null;
    L5:
        r0.unregisterContentObserver(this.callInterceptObserver);
        ContentResolver r2 = this.resolver;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
    L9:
        r1.unregisterContentObserver(this.smsInterceptObserver);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void loadData() {
        QueryHandler r0 = this.queryHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r0 = null;
    L5:
        r0.startQuery(this.STRAT_QUERY_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_SUMMARY_URI(), null, null, null, null);
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
        BlackListActivity r1 = this;
        final View r2 = LayoutInflater.from(r1).inflate(R.layout.blacklist_action_dialog, null);
        String r3 = getString(R.string.add_to_black_list);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.add_to_black_list)");
        this.actionDialog = new OActionDialog(r1, new OActionDialog.Modifier(r3, "", new BlackListActivity$showAddMenu$modifier$1(r2)));
        OButton r4 = (OButton) r2.findViewById(R.id.btn_contacts);
        OButton r5 = (OButton) r2.findViewById(R.id.btn_call_log);
        OButton r6 = (OButton) r2.findViewById(R.id.btn_manual);
        OButton r7 = (OButton) r2.findViewById(R.id.btn_cancel);
        r4.setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda5(this));
        r5.setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda6(this));
        r6.setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda7(this));
        r7.setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda8(this));
        OActionDialog r8 = this.actionDialog;
        if (r8 == null) goto L11;
        r8.show();
        return;
    }

    private static final void showAddMenu$lambda$0(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.pickContact();
    }

    private static final void showAddMenu$lambda$1(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.pickFromCallLog();
    }

    private static final void showAddMenu$lambda$2(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OActionDialog r2 = r0.actionDialog;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        r0.inputByHand();
    }

    private static final void showAddMenu$lambda$3(BlackListActivity r0, View r1) {
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
        showManualAddSheet();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r11, int r12, Intent r13) {
        super.onActivityResult(r11, r12, r13);
        if (r12 != (-1)) goto L38;
        if (r13 != null) goto L7;
        return;
    L7:
        if (r11 != this.REQ_CODE_PICK_CONTACT) goto L17;
        Uri r14 = r13.getData();
        if (r14 != null) goto L11;
        return;
    L11:
        Uri r5 = Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, r14.getLastPathSegment());
        Intrinsics.checkNotNullExpressionValue(r5, "withAppendedPath(Contact…URI, uri.lastPathSegment)");
        QueryHandler r15 = this.queryHandler;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r2 = null;
    L15:
        r2.startQuery(this.PICK_CONTACT_TOKEN, null, r5, this.PHONE_PROJECTION, null, null, null);
        return;
    L14:
        r2 = r15;
        goto L15
    L17:
        if (r11 != this.REQ_CODE_PICK_CALL_LOG) goto L40;
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
        if (r18 == true) goto L41;
        String r111 = formatNumber(r19);
        this.callLogNumber = r111;
        ContentValues r112 = new ContentValues();
        r112.put("bl_phone_number", r111);
        this.contentValues = r112;
        Uri r6 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI(), r111);
        QueryHandler r113 = this.queryHandler;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r3 = null;
    L36:
        r3.startQuery(this.IS_IN_BLACK_LIST_FROM_CALL_LOG_TOKEN, null, r6, null, null, null, null);
        return;
    L35:
        r3 = r113;
        goto L36
    L41:
        return;
    L29:
        if (r110.length() != 0) goto L31;
    L25:
        r19 = null;
        goto L26
    L21:
        r17 = null;
        goto L22
    L40:
        return;
    }

    private final void showManualAddSheet() {
        OSheet r1 = this.manuallyAddSheet;
        if (r1 == null) goto L7;
        boolean r3 = true;
        if (r1.isShowing() != true) goto L7;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        View r2 = getLayoutInflater().inflate(R.layout.manually_add_sheet_content, null, false);
        Intrinsics.checkNotNullExpressionValue(r2, "contentView");
        initManualAddSheetContent(r2);
        final OSheet r4 = new OSheet(this, 0, 0, false, false, 30, null);
        r4.setHeightMode(OSheet.HeightMode.FULL_HEIGHT);
        OSheetBase.DefaultImpls.setHeader$default(r4, OSheet.Header.ACTION, null, null, getString(R.string.add_to_black_list), null, false, new BlackListActivity$$ExternalSyntheticLambda1(r4), new BlackListActivity$$ExternalSyntheticLambda2(this), null, null, null, null, null, null, 16150, null);
        View r5 = r4.getEndActionButton();
        this.manualSaveButton = r5;
        if (r5 == null) goto L14;
        r5.setEnabled(false);
    L14:
        r4.setBodyView(r2);
        r4.setOnDismissListener(new BlackListActivity$$ExternalSyntheticLambda3(this));
        r4.show();
        this.manuallyAddSheet = r4;
        return;
    L7:
        r3 = false;
        goto L8
    }

    private static final void showManualAddSheet$lambda$8$lambda$5(OSheet r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "$this_apply");
        r0.dismiss();
    }

    private static final void showManualAddSheet$lambda$8$lambda$6(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.saveManualAdd();
    }

    private static final void showManualAddSheet$lambda$8$lambda$7(BlackListActivity r0, DialogInterface r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.clearManualAddSheetRefs();
    }

    private final void initManualAddSheetContent(View r7) {
        OCardListItem r0 = (OCardListItem) r7.findViewById(R.id.phone_number);
        OInputLayout r4 = null;
        if (r0 == null) goto L5;
        r0.setCardType(2);
        r0.setCustomStartView(R.layout.layout_phone_input_card);
        OCardListItem.setCardPosition$default(r0, 1, false, 2, null);
        r0.showDivider(true);
    L5:
        if (r0 == null) goto L7;
        View r1 = r0.getCustomStartView();
    L9:
        if ((r1 instanceof OPhoneInputLayout) == false) goto L11;
        OPhoneInputLayout r2 = (OPhoneInputLayout) r1;
    L12:
        this.manualPhoneNumberInput = r2;
        if (r2 == null) goto L15;
        r2.setHint(getString(R.string.phone_number_hint));
        r2.showCustomStart(false);
        r2.showClear(true);
        r2.showDivider(true);
    L15:
        OCardListItem r8 = (OCardListItem) r7.findViewById(R.id.number_note);
        if (r8 == null) goto L18;
        r8.setCardType(2);
        r8.setCustomStartView(R.layout.layout_normal_input_card);
        OCardListItem.setCardPosition$default(r8, 3, false, 2, null);
    L18:
        if (r8 == null) goto L20;
        View r9 = r8.getCustomStartView();
    L22:
        if ((r9 instanceof OInputLayout) == false) goto L24;
        r4 = (OInputLayout) r9;
    L24:
        this.manualNumberNoteInput = r4;
        if (r4 == null) goto L27;
        r4.setHint(getString(R.string.number_note_hint));
    L27:
        OPhoneInputLayout r10 = this.manualPhoneNumberInput;
        if (r10 == null) goto L34;
        OEditText r11 = r10.getVInput();
        if (r11 == null) goto L35;
        InputFilter[] r3 = r11.getFilters();
        Intrinsics.checkNotNullExpressionValue(r3, "numberInput.filters");
        List r5 = ArraysKt.toMutableList(r3);
        r5.add(createPhoneNumberDigitLimitFilter());
        r11.setFilters((InputFilter[]) r5.toArray(new InputFilter[0]));
        r11.addTextChangedListener(new AnonymousClass5(this));
        return;
    L35:
        return;
    L34:
        return;
    L20:
        r9 = null;
        goto L22
    L11:
        r2 = null;
        goto L12
    L7:
        r1 = null;
        goto L9
    }

    private static final CharSequence createPhoneNumberDigitLimitFilter$lambda$15(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
        int r0 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        StringBuilder r2 = new StringBuilder();
        r2.append(r6.subSequence(0, r7));
        r2.append(r6.subSequence(r8, r6.length()));
        String r9 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
        String r10 = r9;
        int r11 = 0;
        int r12 = 0;
    L14:
        if (r11 >= r10.length()) goto L19;
        if (Character.isDigit(r10.charAt(r11)) == false) goto L18;
        r12 = r12 + 1;
    L18:
        r11 = r11 + 1;
        goto L14
    L19:
        int r13 = 11 - r12;
        if (r13 <= 0) goto L22;
        CharSequence r14 = r3.subSequence(r4, r5);
        StringBuilder r15 = new StringBuilder(r14.length());
        int r16 = 0;
    L25:
        if (r0 >= r14.length()) goto L32;
        char r17 = r14.charAt(r0);
        if (Character.isDigit(r17) == false) goto L30;
        if (r16 >= r13) goto L32;
        r16 = r16 + 1;
    L30:
        r15.append(r17);
        r0 = r0 + 1;
    L32:
        if (r15.length() != r14.length()) goto L35;
        return null;
    L35:
        return r15.toString();
    L22:
        return "";
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final void saveManualAdd() {
        OPhoneInputLayout r0 = this.manualPhoneNumberInput;
        if (r0 == null) goto L9;
        OEditText r1 = r0.getVInput();
        if (r1 == null) goto L9;
        Editable r2 = r1.getText();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
    L10:
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        boolean r5 = true;
        if (r3.length() != 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return;
    L19:
        String r7 = PhoneNumberUtils.normalizeNumber(r3);
        Intrinsics.checkNotNullExpressionValue(r7, "normalizeNumber(rawNumber)");
        this.manualNumberStr = r7;
        if (r7.length() == 0) goto L23;
        r5 = false;
    L23:
        if (r5 == false) goto L25;
        return;
    L25:
        OInputLayout r8 = this.manualNumberNoteInput;
        if (r8 == null) goto L32;
        OEditText r9 = r8.getVInput();
        if (r9 == null) goto L32;
        Editable r10 = r9.getText();
        if (r10 == null) goto L32;
        String r11 = r10.toString();
    L33:
        if (r11 == null) goto L36;
        r4 = r11;
    L36:
        this.manualNoteStr = r4;
        ContentValues r12 = new ContentValues();
        r12.put("bl_phone_number", this.manualNumberStr);
        this.contentValues = r12;
        Uri r13 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI(), this.manualNumberStr);
        QueryHandler r14 = this.queryHandler;
        if (r14 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r15 = null;
    L40:
        r15.startQuery(this.IS_IN_BLACK_LIST_FROM_MANUAL_TOKEN, null, r13, null, null, null, null);
        return;
    L39:
        r15 = r14;
    L32:
        r11 = null;
        goto L33
    L16:
        r6 = false;
    L9:
        r3 = null;
        goto L10
    }

    private final void clearManualAddSheetRefs() {
        this.manuallyAddSheet = null;
        this.manualPhoneNumberInput = null;
        this.manualNumberNoteInput = null;
        this.manualSaveButton = null;
        this.manualNumberStr = "";
        this.manualNoteStr = "";
    }

    private final void insertBlackList(String r9) {
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Uri r2 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI(), r9);
        ContentResolver r1 = this.resolver;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        ContentResolver r3 = null;
    L12:
        Cursor r4 = r3.query(r2, null, null, null, null);
        Cursor r5 = r4;     // Catch: Throwable -> L25
        if (r5 != null) goto L16;
    L19:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r4, null);
        ContentValues r7 = new ContentValues();
        r7.put("bl_phone_number", r9);
        QueryHandler r10 = this.queryHandler;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r10 = null;
    L23:
        r10.startInsert(this.INSERT_BLACK_LIST_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), r7);
        return;
    L16:
        if (r5.getCount() <= 0) goto L19;
        CloseableKt.closeFinally(r4, null);
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L11:
        r3 = r1;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private final void queryComplete(int r5, Cursor r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        if (r5 != this.PICK_CONTACT_TOKEN) goto L7;
        handlePickContactResult(r6);
        return;
    L7:
        BlackListSummaryAdapter r1 = null;
        if (r5 != this.QUERY_PHOTO_TOKEN) goto L11;
        updatePhotoAndInsert$default(this, r6, null, 2, null);
        return;
    L11:
        if (r5 != this.QUERY_PHOTO_FROM_MANUAL_TOKEN) goto L14;
        updatePhotoAndInsert(r6, MANUAL_ADD_COOKIE);
        return;
    L14:
        if (r5 != this.IS_IN_BLACK_LIST_FROM_CONTACT_TOKEN) goto L17;
        checkIsInBlackListFromContact(r6);
        return;
    L17:
        if (r5 != this.IS_IN_BLACK_LIST_FROM_CALL_LOG_TOKEN) goto L20;
        checkIsInBlackListFromCallLog(r6);
        return;
    L20:
        if (r5 != this.IS_IN_BLACK_LIST_FROM_MANUAL_TOKEN) goto L23;
        checkIsInBlackListFromManual(r6);
        return;
    L23:
        if (r5 != this.IS_IN_CONTACT_TOKEN) goto L26;
        checkIsInContactAndInsert(r6);
        return;
    L26:
        if (r5 != this.IS_IN_CONTACT_FROM_MANUAL_TOKEN) goto L28;
        checkManualNumberInContactAndInsert(r6);
        return;
    L28:
        boolean r2 = false;
        if (r5 != this.INSERT_BLACK_LIST_TOKEN) goto L32;
    L30:
        boolean r7 = true;
    L36:
        if (r7 == false) goto L49;
        BlackListSummaryAdapter r8 = this.adapter;
        if (r8 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L41:
        r1.submitCursor(r6);
        if (r6.getCount() != 0) goto L44;
        boolean r9 = true;
    L45:
        updateEmptyStatus(r9);
        if (r6.getCount() <= 0) goto L48;
        r2 = true;
    L48:
        updateTitleButtons(r2);
        return;
    L44:
        r9 = false;
        goto L45
    L40:
        r1 = r8;
        goto L41
    L49:
        BlackListSummaryAdapter r10 = this.adapter;
        if (r10 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L53:
        r1.submitCursor(r6);
        if (r6.getCount() != 0) goto L56;
        boolean r11 = true;
    L57:
        updateEmptyStatus(r11);
        if (r6.getCount() <= 0) goto L60;
        r2 = true;
    L60:
        updateTitleButtons(r2);
        return;
    L56:
        r11 = false;
        goto L57
    L52:
        r1 = r10;
        goto L53
    L32:
        if (r5 == this.STRAT_QUERY_TOKEN) goto L30;
        r7 = false;
        goto L36
    }

    private final void updateEmptyStatus(boolean r1) {
        OPageStatus r0 = this.emptyStatus;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("emptyStatus");
        r0 = null;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    private final void handlePickContactResult(Cursor r11) {
    L28:
        th = move-exception;
        r11.close();
        throw th;
    L3:
        if (r11.moveToFirst() == false) goto L31;
        this.contentValues = new ContentValues();     // Catch: Throwable -> L28 Exception -> L33
        String r0 = r11.getString(r11.getColumnIndexOrThrow("data1"));     // Catch: Throwable -> L28 Exception -> L33
        String r1 = "";
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        String r2 = r11.getString(r11.getColumnIndexOrThrow("display_name"));     // Catch: Throwable -> L28 Exception -> L33
        if (r2 == null) goto L12;
        r1 = r2;
    L12:
        this.photoId = r11.getInt(r11.getColumnIndexOrThrow("photo_id"));     // Catch: Throwable -> L28 Exception -> L33
        String r3 = formatNumber(r0);     // Catch: Throwable -> L28 Exception -> L33
        if (r3.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L20;
        ContentValues r5 = this.contentValues;     // Catch: Throwable -> L28 Exception -> L33
        if (r5 == null) goto L20;
        r5.put("bl_phone_number", r3);     // Catch: Throwable -> L28 Exception -> L33
    L20:
        ContentValues r6 = this.contentValues;     // Catch: Throwable -> L28 Exception -> L33
        if (r6 == null) goto L23;
        r6.put("bl_note", r1);     // Catch: Throwable -> L28 Exception -> L33
    L23:
        Uri r7 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI(), r3);     // Catch: Throwable -> L28 Exception -> L33
        QueryHandler r8 = this.queryHandler;     // Catch: Throwable -> L28 Exception -> L33
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Throwable -> L28 Exception -> L33
        r8 = null;
    L26:
        r8.startQuery(this.IS_IN_BLACK_LIST_FROM_CONTACT_TOKEN, null, r7, null, null, null, null);     // Catch: Throwable -> L28 Exception -> L33
        goto L31
    L15:
        r4 = false;
    L31:
        r11.close();
    }

    private final void checkIsInBlackListFromContact(Cursor r9) {
    L18:
        th = move-exception;
        r9.close();     // Catch: Exception -> L24
    L20:
        throw th;
    L3:
        if (r9.getCount() <= 0) goto L7;
        Toast.makeText(getApplicationContext(), getString(R.string.in_black_list_toast), 0).show();     // Catch: Exception -> L22 Throwable -> L18
        this.photoId = 0;     // Catch: Exception -> L22 Throwable -> L18
        goto L25
    L7:
        if (this.photoId == 0) goto L12;
        QueryHandler r0 = this.queryHandler;     // Catch: Exception -> L22 Throwable -> L18
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L22 Throwable -> L18
        r0 = null;
    L11:
        r0.startQuery(this.QUERY_PHOTO_TOKEN, null, ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, this.photoId), this.PHOTO_PROJECTION, null, null, null);     // Catch: Exception -> L22 Throwable -> L18
        goto L25
    L12:
        QueryHandler r1 = this.queryHandler;     // Catch: Exception -> L22 Throwable -> L18
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L22 Throwable -> L18
        r1 = null;
    L15:
        r1.startInsert(this.INSERT_BLACK_LIST_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L22 Throwable -> L18
    L25:
        r9.close();     // Catch: Exception -> L23
        return;
    }

    private final void checkIsInBlackListFromManual(Cursor r11) {
    L12:
        th = move-exception;
        r11.close();     // Catch: Exception -> L18
    L14:
        throw th;
    L4:
        if (r11.getCount() <= 0) goto L6;
        Toast.makeText(getApplicationContext(), getString(R.string.in_black_list_toast), 0).show();     // Catch: Exception -> L16 Throwable -> L12
        this.photoId = 0;     // Catch: Exception -> L16 Throwable -> L12
        this.manualNoteStr = "";     // Catch: Exception -> L16 Throwable -> L12
        this.manualNumberStr = "";     // Catch: Exception -> L16 Throwable -> L12
        goto L19
    L6:
        Uri r5 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.manualNumberStr));     // Catch: Exception -> L16 Throwable -> L12
        QueryHandler r0 = this.queryHandler;     // Catch: Exception -> L16 Throwable -> L12
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L16 Throwable -> L12
        r0 = null;
    L9:
        r0.startQuery(this.IS_IN_CONTACT_FROM_MANUAL_TOKEN, null, r5, this.CONTACT_PROJECTION, null, null, null);     // Catch: Exception -> L16 Throwable -> L12
    L19:
        r11.close();     // Catch: Exception -> L17
        return;
    }

    private final void checkIsInBlackListFromCallLog(Cursor r11) {
    L15:
        th = move-exception;
        r11.close();     // Catch: Exception -> L22
    L17:
        throw th;
    L3:
        if (r11.getCount() <= 0) goto L5;
        Toast.makeText(getApplicationContext(), getString(R.string.in_black_list_toast), 0).show();     // Catch: Exception -> L20 Throwable -> L15
        this.photoId = 0;     // Catch: Exception -> L20 Throwable -> L15
        goto L23
    L5:
        String r0 = this.callLogNumber;     // Catch: Exception -> L20 Throwable -> L15
        if (r0 == null) goto L27;
        Uri r5 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r0));     // Catch: Exception -> L20 Throwable -> L15
        QueryHandler r1 = this.queryHandler;     // Catch: Exception -> L20 Throwable -> L15
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L20 Throwable -> L15
        r1 = null;
    L12:
        r1.startQuery(this.IS_IN_CONTACT_TOKEN, null, r5, this.CONTACT_PROJECTION, null, null, null);     // Catch: Exception -> L20 Throwable -> L15
        goto L23
    L27:
        r11.close();     // Catch: Exception -> L19
        return;
    L30:
        return;
    L23:
        r11.close();     // Catch: Exception -> L21
        return;
    }

    private final void checkManualNumberInContactAndInsert(Cursor r9) {
    L37:
        th = move-exception;
        r9.close();     // Catch: Exception -> L44
    L39:
        throw th;
    L3:
        QueryHandler r1 = null;
        if (r9.getCount() > 0) goto L6;
    L27:
        ContentValues r0 = this.contentValues;     // Catch: Exception -> L42 Throwable -> L37
        if (r0 == null) goto L30;
        r0.put("bl_note", this.manualNoteStr);     // Catch: Exception -> L42 Throwable -> L37
    L30:
        QueryHandler r2 = this.queryHandler;     // Catch: Exception -> L42 Throwable -> L37
        if (r2 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L42 Throwable -> L37
    L34:
        r1.startInsert(this.INSERT_BLACK_LIST_TOKEN, MANUAL_ADD_COOKIE, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L42 Throwable -> L37
        goto L47
    L33:
        r1 = r2;
        goto L34
    L6:
        if (r9.moveToFirst() == false) goto L27;
        if (this.manualNoteStr.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L16;
        String r4 = r9.getString(r9.getColumnIndexOrThrow(this.CONTACT_PROJECTION[0]));     // Catch: Exception -> L42 Throwable -> L37
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        this.manualNoteStr = r4;     // Catch: Exception -> L42 Throwable -> L37
    L16:
        ContentValues r5 = this.contentValues;     // Catch: Exception -> L42 Throwable -> L37
        if (r5 == null) goto L19;
        r5.put("bl_note", this.manualNoteStr);     // Catch: Exception -> L42 Throwable -> L37
    L19:
        int r6 = r9.getInt(r9.getColumnIndexOrThrow(this.CONTACT_PROJECTION[1]));     // Catch: Exception -> L42 Throwable -> L37
        this.photoId = r6;     // Catch: Exception -> L42 Throwable -> L37
        if (r6 == 0) goto L30;
        QueryHandler r7 = this.queryHandler;     // Catch: Exception -> L42 Throwable -> L37
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L42 Throwable -> L37
        r7 = null;
    L24:
        r7.startQuery(this.QUERY_PHOTO_FROM_MANUAL_TOKEN, null, ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, this.photoId), this.PHOTO_PROJECTION, null, null, null);     // Catch: Exception -> L42 Throwable -> L37
        r9.close();     // Catch: Exception -> L41
        return;
    L52:
        return;
    L10:
        r3 = false;
    L47:
        r9.close();     // Catch: Exception -> L43
        return;
    }

    private final void checkIsInContactAndInsert(Cursor r9) {
    L27:
        th = move-exception;
        r9.close();     // Catch: Exception -> L34
    L29:
        throw th;
    L4:
        if (r9.getCount() > 0) goto L6;
    L21:
        QueryHandler r0 = this.queryHandler;     // Catch: Exception -> L32 Throwable -> L27
        if (r0 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L32 Throwable -> L27
        r0 = null;
    L24:
        r0.startInsert(this.INSERT_BLACK_LIST_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L32 Throwable -> L27
        goto L37
    L6:
        if (r9.moveToFirst() == false) goto L21;
        String r1 = r9.getString(r9.getColumnIndexOrThrow(this.CONTACT_PROJECTION[0]));     // Catch: Exception -> L32 Throwable -> L27
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        ContentValues r3 = this.contentValues;     // Catch: Exception -> L32 Throwable -> L27
        if (r3 == null) goto L13;
        r3.put("bl_note", r1);     // Catch: Exception -> L32 Throwable -> L27
    L13:
        int r2 = r9.getInt(r9.getColumnIndexOrThrow(this.CONTACT_PROJECTION[1]));     // Catch: Exception -> L32 Throwable -> L27
        this.photoId = r2;     // Catch: Exception -> L32 Throwable -> L27
        if (r2 == 0) goto L21;
        QueryHandler r4 = this.queryHandler;     // Catch: Exception -> L32 Throwable -> L27
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L32 Throwable -> L27
        r4 = null;
    L18:
        r4.startQuery(this.QUERY_PHOTO_TOKEN, null, ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, this.photoId), this.PHOTO_PROJECTION, null, null, null);     // Catch: Exception -> L32 Throwable -> L27
        r9.close();     // Catch: Exception -> L31
        return;
    L42:
        return;
    L37:
        r9.close();     // Catch: Exception -> L33
        return;
    }

    static /* synthetic */ void updatePhotoAndInsert$default(BlackListActivity r0, Cursor r1, Object r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.updatePhotoAndInsert(r1, r2);
    }

    private final void updatePhotoAndInsert(Cursor r4, Object r5) {
    L15:
        th = move-exception;
        r4.close();     // Catch: Exception -> L21
    L17:
        throw th;
    L3:
        if (r4.moveToFirst() == true) goto L5;
    L9:
        QueryHandler r0 = this.queryHandler;     // Catch: Exception -> L19 Throwable -> L15
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L19 Throwable -> L15
        r0 = null;
    L12:
        r0.startInsert(this.INSERT_BLACK_LIST_TOKEN, r5, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L19 Throwable -> L15
        goto L22
    L5:
        if (r4.getBlob(1) == null) goto L9;
        ContentValues r1 = this.contentValues;     // Catch: Exception -> L19 Throwable -> L15
        if (r1 == null) goto L9;
        r1.put("bl_photo", r4.getBlob(1));     // Catch: Exception -> L19 Throwable -> L15
    L22:
        r4.close();     // Catch: Exception -> L20
        return;
    }

    private final String formatNumber(String r13) {
        return StringsKt.replace$default(StringsKt.replace$default(r13, "-", "", false, 4, null), " ", "", false, 4, null);
    }

    private final void deleteSingle(int r8) {
        Uri r4 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getBLACK_LIST_URI(), String.valueOf(r8));
        QueryHandler r7 = this.queryHandler;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r7 = null;
    L5:
        r7.startDelete(0, null, r4, null, null);
    }

    private final void deleteSelected() {
        if (this.selectedIds.isEmpty() == false) goto L5;
        return;
    L5:
        String r5 = "_id IN (" + CollectionsKt.joinToString$default(this.selectedIds, ",", null, null, 0, null, BlackListActivity$deleteSelected$placeholders$1.INSTANCE, 30, null) + ")";
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
        r10.startDelete(1, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), r5, r6);
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
        BlackListSummaryAdapter r2 = this.adapter;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L12:
        r2.setSelectAll(true);
        updateTitleSelectedCount();
        updateDeleteBtnEnabled();
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
        BlackListSummaryAdapter r3 = this.adapter;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r3 = null;
    L12:
        r3.setSelectAll(false);
    }

    private final void updateTitleSelectedCount() {
        if (this.isSelectAllMode == false) goto L5;
        this.mTitle.setCenterTitle(getString(R.string.select_some_items, new Object[]{Integer.valueOf(this.selectedIds.size())}));
        updateSelectAllButtonText();
        return;
    L5:
        this.mTitle.setCenterTitle(getString(R.string.black_list_title));
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

    private final void updateTitleButtons(boolean r10) {
        if (this.isSelectAllMode == false) goto L5;
        return;
    L5:
        this.mTitle.removeAllEndAction();
        OFloatingTitleBar r1 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "mTitle");
        OFloatingTitleBar.addEndAction$default(r1, R.drawable.icon_add, 0, null, 6, null).setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda0(this));
        if (r10 == false) goto L9;
        OFloatingTitleBar r3 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "mTitle");
        OFloatingTitleBar.addEndAction$default(r3, R.drawable.icon_select_all, 0, null, 4, null).setOnClickListener(new BlackListActivity$$ExternalSyntheticLambda4(this));
        return;
    }

    private static final void updateTitleButtons$lambda$19(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.showAddMenu();
    }

    private static final void updateTitleButtons$lambda$20(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        BlackListSummaryAdapter r2 = r0.adapter;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L6:
        if (r2.getItemCount() <= 0) goto L9;
        r0.enterSelectAllMode();
        return;
    }

    private final void showNormalTitleButton() {
        this.mTitle.removeEndAction();
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new BlackListActivity$$ExternalSyntheticLambda11(this));
        BlackListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L6:
        if (r0.getItemCount() <= 0) goto L8;
        boolean r1 = true;
    L9:
        updateTitleButtons(r1);
        this.mTitle.setCenterTitle(getString(R.string.black_list_title));
        this.mTitle.setEndButtonGroupStyle(R.style.OFloatingTitleBar_Action_Standard);
        return;
    L8:
        r1 = false;
        goto L9
    }

    private static final void showNormalTitleButton$lambda$21(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void showSelectAllButton() {
        this.mTitle.removeAllEndAction();
        this.mTitle.removeAllStartAction();
        this.mTitle.addStartAction(R.drawable.icon_close_black, -1, new BlackListActivity$$ExternalSyntheticLambda9(this));
        this.mTitle.setEndButtonGroupStyle(R.style.OFloatingTitleBar_Action_PrimaryLight_Text);
        updateSelectAllButtonText();
    }

    private static final void showSelectAllButton$lambda$22(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.exitSelectAllMode();
    }

    private final void updateSelectAllButtonText() {
        this.mTitle.removeEndAction();
        BlackListSummaryAdapter r0 = this.adapter;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        List<BlackListSummaryItem> r1 = r0.getAllItems();
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
        r3.addEndAction(r5, -1, new BlackListActivity$$ExternalSyntheticLambda12(this));
        return;
    L14:
        r4 = R.string.select_all;
        goto L15
    L8:
        if (this.selectedIds.size() != r1.size()) goto L10;
        goto L10
    }

    private static final void updateSelectAllButtonText$lambda$23(BlackListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.toggleSelectAllSelection();
    }

    private final void toggleSelectAllSelection() {
        BlackListSummaryAdapter r0 = this.adapter;
        BlackListSummaryAdapter r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        List<BlackListSummaryItem> r2 = r0.getAllItems();
        if (r2.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.selectedIds.size() != r2.size()) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L18;
        this.selectedIds.clear();
        BlackListSummaryAdapter r4 = this.adapter;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r1.selectItem(r2, false);
    L27:
        updateTitleSelectedCount();
        updateDeleteBtnEnabled();
        return;
    L16:
        r1 = r4;
        goto L17
    L18:
        this.selectedIds.clear();
        Set<Integer> r5 = this.selectedIds;
        List<BlackListSummaryItem> r6 = r2;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        r7.add(Integer.valueOf(((BlackListSummaryItem) r8.next()).getId()));
        goto L20
    L22:
        r5.addAll(r7);
        BlackListSummaryAdapter r9 = this.adapter;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L26:
        r1.selectItem(r2, true);
        goto L27
    L25:
        r1 = r9;
        goto L26
    L11:
        r3 = false;
        goto L12
    }
}
