package com.obric.securitycenter.nodisturb;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.securitycenter.nodisturb.dialog.action.ActionDialogAdapter;
import com.obric.securitycenter.nodisturb.dialog.action.ActionDialogItemData;
import com.obric.securitycenter.nodisturb.dialog.action.ActionDialogItemDecoration;
import com.obric.securitycenter.nodisturb.utils.OCardListItemExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;

/* JADX INFO: compiled from: BlackDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 V2\u00020\u0001:\u0002VWB\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00182\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020'H\u0002J\u0012\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020:H\u0002J\u0010\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020CH\u0016J\u0012\u0010G\u001a\u00020:2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020:H\u0014J\u0012\u0010K\u001a\u00020:2\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020:H\u0002J\u001a\u0010O\u001a\u00020:2\u0006\u0010P\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010RH\u0002J\b\u0010S\u001a\u00020:H\u0002J\b\u0010T\u001a\u00020:H\u0002J\b\u0010U\u001a\u00020:H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R#\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010 \u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b!\u0010\u0015R#\u0010#\u001a\n \u000b*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b$\u0010\u0015R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010)\u001a\n \u000b*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000f\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\b\u0018\u00010/R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R#\u00103\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000f\u001a\u0004\b4\u0010\rR\u000e\u00106\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/obric/securitycenter/nodisturb/BlackDetailActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "mBlackDetailAdapter", "Lcom/obric/securitycenter/nodisturb/BlackDetailAdapter;", "mBlackListId", "", "mCallInterceptObserver", "Landroid/database/ContentObserver;", "mCallSum", "Lcom/obric/oui/lisitem/OCardListItem;", "kotlin.jvm.PlatformType", "getMCallSum", "()Lcom/obric/oui/lisitem/OCardListItem;", "mCallSum$delegate", "Lkotlin/Lazy;", "mContext", "Landroid/content/Context;", "mFooterDivider", "Landroid/widget/TextView;", "getMFooterDivider", "()Landroid/widget/TextView;", "mFooterDivider$delegate", "mGuardRail", "Landroid/graphics/Bitmap;", "mListView", "Landroid/widget/ListView;", "getMListView", "()Landroid/widget/ListView;", "mListView$delegate", "mNoInterceptDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "mNote", "getMNote", "mNote$delegate", "mNumber", "getMNumber", "mNumber$delegate", "mNumberStr", "", "mPhoneNumber", "mPhoto", "Landroid/widget/ImageView;", "getMPhoto", "()Landroid/widget/ImageView;", "mPhoto$delegate", "mQueryHandler", "Lcom/obric/securitycenter/nodisturb/BlackDetailActivity$QueryHandler;", "mResolver", "Landroid/content/ContentResolver;", "mSmsInterceptObserver", "mSmsSum", "getMSmsSum", "mSmsSum$delegate", "mStartedByBlacklist", "mUriSmsCountChange", "Landroid/net/Uri;", "addToContact", "", "bytes2Bitmap", "b", "", "formatPhone34X", "phone", "genDialogContentView", "Landroid/view/View;", "inContact", "", "handleNoInterceptClick", "initTitleBar", "hasRight", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "queryBlackListAndCallLog", "queryComplete", "token", "c", "Landroid/database/Cursor;", "registerObserver", "removeFromBlackList", "unregisterObserver", "Companion", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackDetailActivity extends BaseActivity {
    public static final String ACTION_BYTEDANCE_INSERT_OR_EDIT = "com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit";
    private static final String[] CONTACT_PROJECTION = null;
    public static final Companion Companion = null;
    private static final boolean DBG = false;
    private static final int IS_IN_CONTACT_TOKEN = 7;
    public static final String LAUNCH_BY = "launch_by";
    public static final int LAUNCH_BY_BLACK_LIST = 0;
    public static final int LAUNCH_BY_CALL_LOG = 1;
    private static final int NO_INTERCEPT_TOKEN = 2;
    private static final int QUERY_BLACK_LIST = 0;
    private static final int QUERY_CALL_LOG = 1;
    private static final String TAG = "BlackDetailActivity";
    private BlackDetailAdapter mBlackDetailAdapter;
    private int mBlackListId;
    private final ContentObserver mCallInterceptObserver;
    private final Lazy mCallSum$delegate;
    private Context mContext;
    private final Lazy mFooterDivider$delegate;
    private Bitmap mGuardRail;
    private final Lazy mListView$delegate;
    private OActionDialog mNoInterceptDialog;
    private final Lazy mNote$delegate;
    private final Lazy mNumber$delegate;
    private String mNumberStr;
    private String mPhoneNumber;
    private final Lazy mPhoto$delegate;
    private QueryHandler mQueryHandler;
    private ContentResolver mResolver;
    private final ContentObserver mSmsInterceptObserver;
    private final Lazy mSmsSum$delegate;
    private int mStartedByBlacklist;
    private final Uri mUriSmsCountChange;

    /* JADX INFO: compiled from: BlackDetailActivity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/securitycenter/nodisturb/BlackDetailActivity$Companion;", "", "()V", "ACTION_BYTEDANCE_INSERT_OR_EDIT", "", "CONTACT_PROJECTION", "", "[Ljava/lang/String;", "DBG", "", "IS_IN_CONTACT_TOKEN", "", "LAUNCH_BY", "LAUNCH_BY_BLACK_LIST", "LAUNCH_BY_CALL_LOG", "NO_INTERCEPT_TOKEN", "QUERY_BLACK_LIST", "QUERY_CALL_LOG", "TAG", "log", "", NotificationCompat.CATEGORY_MESSAGE, "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ void access$log(Companion r0, String r1) {
            r0.log(r1);
        }

        private final void log(String r1) {
            if (BlackDetailActivity.access$getDBG$cp() == false) goto L6;
            OLog.d(BlackDetailActivity.TAG, r1);
            return;
        }
    }

    /* JADX INFO: compiled from: BlackDetailActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/BlackDetailActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/BlackDetailActivity;Landroid/content/ContentResolver;)V", "onDeleteComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "result", "onQueryComplete", "c", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ BlackDetailActivity this$0;

        public QueryHandler(BlackDetailActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            BlackDetailActivity.access$queryComplete(this.this$0, r1, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            super.onDeleteComplete(r1, r2, r3);
        }
    }

    public static /* synthetic */ void $r8$lambda$wvIks0iu6H4GOL_apzJji7Z7aJg(BlackDetailActivity r0, View r1) {
        initTitleBar$lambda$6(r0, r1);
    }

    public BlackDetailActivity() {
        this.mPhoto$delegate = LazyKt.lazy(new BlackDetailActivity$mPhoto$2(this));
        this.mNote$delegate = LazyKt.lazy(new BlackDetailActivity$mNote$2(this));
        this.mNumber$delegate = LazyKt.lazy(new BlackDetailActivity$mNumber$2(this));
        this.mCallSum$delegate = LazyKt.lazy(new BlackDetailActivity$mCallSum$2(this));
        this.mSmsSum$delegate = LazyKt.lazy(new BlackDetailActivity$mSmsSum$2(this));
        this.mFooterDivider$delegate = LazyKt.lazy(new BlackDetailActivity$mFooterDivider$2(this));
        this.mListView$delegate = LazyKt.lazy(new BlackDetailActivity$mListView$2(this));
        this.mBlackListId = -1;
        this.mPhoneNumber = "";
        Uri r0 = Uri.parse("content://bytedance_spam_sms");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(\"content://bytedance_spam_sms\")");
        this.mUriSmsCountChange = r0;
        final Handler r1 = new Handler();
        this.mSmsInterceptObserver = new BlackDetailActivity$mSmsInterceptObserver$1(this, r1);
        final Handler r2 = new Handler();
        this.mCallInterceptObserver = new BlackDetailActivity$mCallInterceptObserver$1(this, r2);
    }

    public static final /* synthetic */ void access$addToContact(BlackDetailActivity r0) {
        r0.addToContact();
    }

    public static final /* synthetic */ View access$genDialogContentView(BlackDetailActivity r0, boolean r1) {
        return r0.genDialogContentView(r1);
    }

    public static final /* synthetic */ boolean access$getDBG$cp() {
        return DBG;
    }

    public static final /* synthetic */ OActionDialog access$getMNoInterceptDialog$p(BlackDetailActivity r0) {
        return r0.mNoInterceptDialog;
    }

    public static final /* synthetic */ void access$queryBlackListAndCallLog(BlackDetailActivity r0) {
        r0.queryBlackListAndCallLog();
    }

    public static final /* synthetic */ void access$queryComplete(BlackDetailActivity r0, int r1, Cursor r2) {
        r0.queryComplete(r1, r2);
    }

    public static final /* synthetic */ void access$removeFromBlackList(BlackDetailActivity r0) {
        r0.removeFromBlackList();
    }

    private final ImageView getMPhoto() {
        return (ImageView) this.mPhoto$delegate.getValue();
    }

    private final TextView getMNote() {
        return (TextView) this.mNote$delegate.getValue();
    }

    private final TextView getMNumber() {
        return (TextView) this.mNumber$delegate.getValue();
    }

    private final OCardListItem getMCallSum() {
        return (OCardListItem) this.mCallSum$delegate.getValue();
    }

    private final OCardListItem getMSmsSum() {
        return (OCardListItem) this.mSmsSum$delegate.getValue();
    }

    private final TextView getMFooterDivider() {
        return (TextView) this.mFooterDivider$delegate.getValue();
    }

    private final ListView getMListView() {
        return (ListView) this.mListView$delegate.getValue();
    }

    private final void registerObserver() {
        ContentResolver r0 = this.mResolver;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerContentObserver(ProviderConstants.INSTANCE.getCALL_INTERCEPT_COUNT_URI(), true, this.mCallInterceptObserver);
        r0.registerContentObserver(this.mUriSmsCountChange, true, this.mSmsInterceptObserver);
    }

    private final void unregisterObserver() {
        ContentResolver r0 = this.mResolver;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterContentObserver(this.mCallInterceptObserver);
        r0.unregisterContentObserver(this.mSmsInterceptObserver);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.black_detail_activity);
        getWindow().setBackgroundDrawable(null);
        this.mContext = this;
        Drawable r8 = getResources().getDrawable(R.drawable.guardrail_big);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        Bitmap r9 = ((BitmapDrawable) r8).getBitmap();
        Intrinsics.checkNotNullExpressionValue(r9, "resources.getDrawable(R.…as BitmapDrawable).bitmap");
        this.mGuardRail = r9;
        Intent r10 = getIntent();
        if (r10 != null) goto L27;
    L9:
        Object r11 = getSystemService("layout_inflater");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.LayoutInflater");
        LayoutInflater r12 = (LayoutInflater) r11;
        View r3 = r12.inflate(R.layout.black_detail_list_header, null);
        View r13 = r12.inflate(R.layout.black_detail_list_footer, null);
        ListView r4 = getMListView();
        if (r4 == null) goto L12;
        r4.addHeaderView(r3);
    L12:
        ListView r5 = getMListView();
        if (r5 == null) goto L15;
        r5.addFooterView(r13);
    L15:
        getMCallSum().setCardType(0);
        OCardListItem r14 = getMCallSum();
        Intrinsics.checkNotNullExpressionValue(r14, "mCallSum");
        OCardListItem.setCardPosition$default(r14, 1, false, 2, null);
        OCardListItem r15 = getMSmsSum();
        Intrinsics.checkNotNullExpressionValue(r15, "mSmsSum");
        OCardListItem.setCardPosition$default(r15, 3, false, 2, null);
        OCardListItem r16 = getMCallSum();
        if (r16 == null) goto L18;
        r16.setOnClickListener(null);
    L18:
        OCardListItem r17 = getMSmsSum();
        if (r17 == null) goto L21;
        r17.setOnClickListener(null);
    L21:
        getMNote().setText(formatPhone34X(this.mPhoneNumber));
        getMNote().setVisibility(0);
        this.mResolver = getContentResolver();
        ContentResolver r0 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r0, "contentResolver");
        this.mQueryHandler = new QueryHandler(this, r0);
        if (this.mBlackListId == (-1)) goto L24;
        queryBlackListAndCallLog();
    L24:
        initTitleBar(true);
        registerObserver();
        return;
    L27:
        this.mStartedByBlacklist = r10.getIntExtra("launch_by", 0);     // Catch: RuntimeException -> L26
        this.mBlackListId = r10.getIntExtra("blackid", -1);     // Catch: RuntimeException -> L26
        String r18 = r10.getStringExtra(DisturbActivity.CALL_PHONE_NUMBER);     // Catch: RuntimeException -> L26
        if (r18 != null) goto L7;
        r18 = "";
    L8:
        this.mPhoneNumber = r18;     // Catch: RuntimeException -> L26
        goto L9
    L7:
        Intrinsics.checkNotNullExpressionValue(r18, "i.getStringExtra(\"call_phone_number\") ?: \"\"");     // Catch: RuntimeException -> L26
        goto L8
    }

    static /* synthetic */ View genDialogContentView$default(BlackDetailActivity r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.genDialogContentView(r1);
    }

    private final View genDialogContentView(boolean r8) {
        BlackDetailActivity r1 = this;
        RecyclerView r0 = new RecyclerView(r1);
        r0.setOverScrollMode(2);
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext()));
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r0.addItemDecoration(new ActionDialogItemDecoration(MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics())), 4));
        ActionDialogAdapter r2 = new ActionDialogAdapter(r1);
        r0.setAdapter(r2);
        final ArrayList r3 = new ArrayList();
        String r4 = getString(R.string.unblock_number);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.unblock_number)");
        r3.add(new ActionDialogItemData(r4, R.style.OStyleV2_OButton_L_Standard_Red_Light));
        if (r8 == true) goto L5;
        String r5 = getString(R.string.no_intercept_and_add_contact);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.no_intercept_and_add_contact)");
        r3.add(new ActionDialogItemData(r5, R.style.OStyleV2_OButton_L_Standard_Red_Light));
    L5:
        String r6 = getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.cancel)");
        r3.add(new ActionDialogItemData(r6, R.style.OStyleV2_OButton_L_Standard_Neutral));
        r2.setItems(r3);
        r2.setOnItemClickListener(new AnonymousClass1(this, r3));
        return r0;
    }

    private final void queryBlackListAndCallLog() {
        QueryHandler r8 = this.mQueryHandler;
        if (r8 != null) goto L5;
        return;
    L5:
        r8.startQuery(0, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), null, "_id=?", new String[]{String.valueOf(this.mBlackListId)}, null);
        r8.startQuery(1, null, ProviderConstants.INSTANCE.getBLOCKED_CALL_LOG_URI(), null, "bcl_bl_id=?", new String[]{String.valueOf(this.mBlackListId)}, "bcl_datetime DESC");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r4) {
        if (r4 != null) goto L11;
    L8:
        super.onNewIntent(r4);
        return;
    L11:
        this.mStartedByBlacklist = r4.getIntExtra("launch_by", 0);     // Catch: RuntimeException -> L10
        this.mBlackListId = r4.getIntExtra("blackid", -1);     // Catch: RuntimeException -> L10
    L6:
        if (this.mBlackListId == (-1)) goto L8;
        queryBlackListAndCallLog();
        goto L8
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        BlackDetailAdapter r0 = this.mBlackDetailAdapter;
        if (r0 == null) goto L5;
        r0.changeCursor(null);
    L5:
        unregisterObserver();
        super.onDestroy();
    }

    private final void queryComplete(int r6, final Cursor r7) {
        Companion.access$log(Companion, "queryComplete");
        if (r7 != null) goto L5;
        return;
    L5:
        String r0 = "";
        if (r6 == 0) goto L118;
        if (r6 != 1) goto L9;
        this.mBlackDetailAdapter = new BlackDetailAdapter(this, R.layout.black_detail_item, r7);     // Catch: Exception -> L45
        ListView r8 = getMListView();     // Catch: Exception -> L45
        if (r8 == null) goto L29;
        r8.setAdapter(this.mBlackDetailAdapter);     // Catch: Exception -> L45
    L29:
        ListView r9 = getMListView();     // Catch: Exception -> L45
        if (r9 == null) goto L33;
        r9.setScrollBarStyle(16777216);     // Catch: Exception -> L45
    L33:
        ListView r10 = getMListView();     // Catch: Exception -> L45
        if (r10 == null) goto L36;
        r10.setSelector(android.R.color.transparent);     // Catch: Exception -> L45
    L36:
        ListView r11 = getMListView();     // Catch: Exception -> L45
        if (r11 == null) goto L40;
        r11.setDivider(null);     // Catch: Exception -> L45
    L40:
        TextView r5 = getMFooterDivider();     // Catch: Exception -> L45
        if (r5 == null) goto L123;
        r5.setVisibility(8);     // Catch: Exception -> L45
        return;
    L123:
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (r6 != 7) goto L125;
        Context r12 = this.mContext;     // Catch: Throwable -> L18 Exception -> L20
        if (r12 == null) goto L109;
        String r2 = getString(R.string.detail_confirm_text);     // Catch: Throwable -> L18 Exception -> L20
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.detail_confirm_text)");     // Catch: Throwable -> L18 Exception -> L20
        OActionDialog r1 = new OActionDialog(r12, new OActionDialog.Modifier(r2, "", new BlackDetailActivity$queryComplete$modifier$1(this, r7)));     // Catch: Throwable -> L18 Exception -> L20
        this.mNoInterceptDialog = r1;     // Catch: Throwable -> L18 Exception -> L20
        r1.show();     // Catch: Throwable -> L18 Exception -> L20
    L16:
        r7.close();     // Catch: Exception -> L103
    L116:
        return;
    L109:
        r7.close();     // Catch: Exception -> L102
        return;
    L122:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r7.close();     // Catch: Exception -> L104
    L24:
        throw th;
    L125:
        return;
    L118:
    L96:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L94
    L92:
        r7.close();     // Catch: Exception -> L103
        goto L116
    L48:
        if (r7.getCount() <= 0) goto L92;
        if (r7.moveToFirst() == false) goto L92;
        byte[] r13 = r7.getBlob(r7.getColumnIndexOrThrow("bl_photo"));     // Catch: Throwable -> L94 Exception -> L96
        String r3 = r7.getString(r7.getColumnIndexOrThrow("bl_note"));     // Catch: Throwable -> L94 Exception -> L96
        if (r13 == null) goto L56;
        ImageView r4 = getMPhoto();     // Catch: Throwable -> L94 Exception -> L96
        if (r4 == null) goto L56;
        r4.setImageBitmap(bytes2Bitmap(r13));     // Catch: Throwable -> L94 Exception -> L96
    L56:
        this.mNumberStr = r7.getString(r7.getColumnIndexOrThrow("bl_phone_number"));     // Catch: Throwable -> L94 Exception -> L96
        if (TextUtils.isEmpty(r3) == false) goto L66;
        TextView r14 = getMNote();     // Catch: Throwable -> L94 Exception -> L96
        if (r14 == null) goto L62;
        r14.setText(formatPhone34X(this.mPhoneNumber));     // Catch: Throwable -> L94 Exception -> L96
    L62:
        TextView r15 = getMNumber();     // Catch: Throwable -> L94 Exception -> L96
        if (r15 == null) goto L79;
        r15.setText("");     // Catch: Throwable -> L94 Exception -> L96
    L79:
        String r16 = r7.getString(r7.getColumnIndexOrThrow(ProviderConstants.BlackList.BL_CALL_SUM));     // Catch: Throwable -> L94 Exception -> L96
        String r17 = r7.getString(r7.getColumnIndexOrThrow(ProviderConstants.BlackList.BL_SMS_SUM));     // Catch: Throwable -> L94 Exception -> L96
        if (TextUtils.isEmpty(r16) == false) goto L84;
        r16 = "0";
    L84:
        if (TextUtils.isEmpty(r17) == false) goto L86;
        r17 = "0";
    L86:
        String r18 = getString(R.string.intercept_call_text, new Object[]{r16});     // Catch: Throwable -> L94 Exception -> L96
        Intrinsics.checkNotNullExpressionValue(r18, "getString(R.string.intercept_call_text, callCount)");     // Catch: Throwable -> L94 Exception -> L96
        String r19 = getString(R.string.intercept_sms_text, new Object[]{r17});     // Catch: Throwable -> L94 Exception -> L96
        Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.intercept_sms_text, smsCount)");     // Catch: Throwable -> L94 Exception -> L96
        OCardListItem r20 = getMCallSum();     // Catch: Throwable -> L94 Exception -> L96
        if (r20 == null) goto L89;
        OCardListItemExtKt.setEndText(r20, r18);     // Catch: Throwable -> L94 Exception -> L96
    L89:
        OCardListItem r21 = getMSmsSum();     // Catch: Throwable -> L94 Exception -> L96
        if (r21 == null) goto L92;
        OCardListItemExtKt.setEndText(r21, r19);     // Catch: Throwable -> L94 Exception -> L96
    L66:
        TextView r22 = getMNote();     // Catch: Throwable -> L94 Exception -> L96
        if (r22 == null) goto L70;
        r22.setText(r3);     // Catch: Throwable -> L94 Exception -> L96
    L70:
        TextView r23 = getMNumber();     // Catch: Throwable -> L94 Exception -> L96
        if (r23 == null) goto L78;
        String r24 = this.mNumberStr;     // Catch: Throwable -> L94 Exception -> L96
        if (r24 == null) goto L77;
        r0 = r24;
    L77:
        r23.setText(formatPhone34X(r0));     // Catch: Throwable -> L94 Exception -> L96
    L78:
        getMNumber().setVisibility(0);     // Catch: Throwable -> L94 Exception -> L96
    L94:
        th = move-exception;
        r7.close();     // Catch: Exception -> L105
    L101:
        throw th;
    }

    private final Bitmap bytes2Bitmap(byte[] r3) {
        if (r3.length != 0) goto L5;
        boolean r2 = true;
    L7:
        if ((!r2) == true) goto L11;
        Bitmap r4 = (Bitmap) null;
        return null;
    L11:
        return BitmapFactory.decodeByteArray(r3, 0, r3.length);
    L5:
        r2 = false;
        goto L7
    }

    private final String formatPhone34X(String r7) {
        String r6 = new Regex("\\D+").replace(r7, "");
        if (r6.length() > 3) goto L6;
        return r6;
    L6:
        if (r6.length() > 7) goto L8;
        String r8 = r6.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        String r9 = r6.substring(3);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).substring(startIndex)");
        return r8 + " " + r9;
    L8:
        String r10 = r6.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String…ing(startIndex, endIndex)");
        String r0 = r6.substring(3, 7);
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String…ing(startIndex, endIndex)");
        String r11 = r6.substring(7);
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).substring(startIndex)");
        return r10 + " " + r0 + " " + r11;
    }

    private final void handleNoInterceptClick() {
        QueryHandler r0 = this.mQueryHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        String r8 = this.mNumberStr;
        if (r8 != null) goto L8;
        return;
    L8:
        r0.startQuery(7, null, Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r8)), CONTACT_PROJECTION, null, null, null);
    }

    private final void removeFromBlackList() {
        finish();
        if (this.mBlackListId < 0) goto L9;
        QueryHandler r1 = this.mQueryHandler;
        if (r1 != null) goto L7;
        return;
    L7:
        r1.startDelete(2, null, Uri.withAppendedPath(ProviderConstants.INSTANCE.getBLACK_LIST_URI(), String.valueOf(this.mBlackListId)), null, null);
        return;
    }

    private final void addToContact() {
        String r0 = this.mNumberStr;
        if (r0 != null) goto L5;
        return;
    L5:
        Intent r1 = new Intent("com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit");
        r1.putExtra("phone", r0);
        r1.setPackage("com.android.contacts");
        r1.setFlags(272662528);
        startActivity(r1);     // Catch: Exception -> L8
        TransitionAnimHelper.overrideEnterAnim(this, TransitionAnimStyle.Modal);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public void initTitleBar(boolean r7) {
        super.initTitleBar(r7);
        if (this.mTitle != null) goto L5;
        return;
    L5:
        OFloatingTitleBar r0 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r0, "mTitle");
        String r1 = getString(R.string.no_intercept_text);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.no_intercept_text)");
        OFloatingTitleBar.addEndAction$default(r0, r1, 0, new BlackDetailActivity$$ExternalSyntheticLambda0(this), 2, null);
        this.mTitle.setCenterTitle(R.string.black_detail_title_text);
    }

    private static final void initTitleBar$lambda$6(BlackDetailActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.handleNoInterceptClick();
    }

    static {
        Companion = new Companion(null);
        DBG = true;
        CONTACT_PROJECTION = new String[]{"_id"};
    }
}
