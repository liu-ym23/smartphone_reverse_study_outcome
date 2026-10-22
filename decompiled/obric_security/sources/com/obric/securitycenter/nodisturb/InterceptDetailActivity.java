package com.obric.securitycenter.nodisturb;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.securitycenter.nodisturb.utils.EncryptToMd5Kt;
import com.obric.securitycenter.nodisturb.utils.OCardListItemExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InterceptDetailActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0012\u0018\u0000 A2\u00020\u0001:\u0002ABB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005J\b\u0010.\u001a\u00020+H\u0002J\u0012\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020+H\u0014J\u0006\u00103\u001a\u00020+J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0002J\u001a\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010=\u001a\u00020+H\u0002J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020\u0005H\u0016J\b\u0010@\u001a\u00020+H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "CONTACT_PROJECTION", "", "", "[Ljava/lang/String;", "IS_IN_CONTACT_TOKEN", "", "NO_INTERCEPT_TOKEN", "QUERY_BLACK_LIST", "QUERY_CALL_LOG", "adapter", "Lcom/obric/securitycenter/nodisturb/BlackDetailAdapter;", "blackListId", "callInterceptCount", "", "callInterceptObserver", "com/obric/securitycenter/nodisturb/InterceptDetailActivity$callInterceptObserver$1", "Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity$callInterceptObserver$1;", "callSumItem", "Lcom/obric/oui/lisitem/OCardListItem;", "footerDivider", "Landroid/widget/TextView;", "listView", "Landroid/widget/ListView;", "noInterceptDialog", "Lcom/obric/oui/sheet/OInsetSheet;", "noteView", "numberStr", "numberView", AccountConst.KEY_PHONE_NUMBER, "photoView", "Landroid/widget/ImageView;", "queryHandler", "Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity$QueryHandler;", "resolver", "Landroid/content/ContentResolver;", "smsSumItem", "spamSmsInboxUri", "Landroid/net/Uri;", "startedByBlacklist", "addToContact", "", "formatPhone34X", "phone", "handleNoInterceptClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSetupTitleBar", "queryAllCallLog", "queryBlackList", "queryBlackListCallLog", "queryComplete", "token", "c", "Landroid/database/Cursor;", "querySpamSmsTotalCount", ProviderConstants.Sms.ADDRESS, "registerObserver", "removeFromBlackList", "scene", "unregisterObserver", "Companion", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InterceptDetailActivity extends BaseActivity {
    public static final Companion Companion = null;
    public static final String KEY_BLACK_ID = "blackid";
    public static final String LAUNCH_BY = "launch_by";
    public static final int LAUNCH_BY_BLACK_LIST = 0;
    public static final int LAUNCH_BY_CALL_LOG = 1;
    private final String[] CONTACT_PROJECTION;
    private final int IS_IN_CONTACT_TOKEN;
    private final int NO_INTERCEPT_TOKEN;
    private final int QUERY_BLACK_LIST;
    private final int QUERY_CALL_LOG;
    private BlackDetailAdapter adapter;
    private int blackListId;
    private long callInterceptCount;
    private final InterceptDetailActivity$callInterceptObserver$1 callInterceptObserver;
    private OCardListItem callSumItem;
    private TextView footerDivider;
    private ListView listView;
    private OInsetSheet noInterceptDialog;
    private TextView noteView;
    private String numberStr;
    private TextView numberView;
    private String phoneNumber;
    private ImageView photoView;
    private QueryHandler queryHandler;
    private ContentResolver resolver;
    private OCardListItem smsSumItem;
    private final Uri spamSmsInboxUri;
    private int startedByBlacklist;

    /* JADX INFO: compiled from: InterceptDetailActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity$Companion;", "", "()V", "KEY_BLACK_ID", "", "LAUNCH_BY", "LAUNCH_BY_BLACK_LIST", "", "LAUNCH_BY_CALL_LOG", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: InterceptDetailActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u000f"}, d2 = {"Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/InterceptDetailActivity;Landroid/content/ContentResolver;)V", "onDeleteComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "result", "onQueryComplete", "c", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ InterceptDetailActivity this$0;

        public QueryHandler(InterceptDetailActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            InterceptDetailActivity.access$queryComplete(this.this$0, r1, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onDeleteComplete(int r1, Object r2, int r3) {
            super.onDeleteComplete(r1, r2, r3);
        }
    }

    public static /* synthetic */ void $r8$lambda$A3CnpCsoqKDWhm5A7TNxfCcTFK0(InterceptDetailActivity r0, View r1) {
        queryComplete$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$HAYTRgyEeDFXNU2qgs9UsBnUIfg(InterceptDetailActivity r0, View r1) {
        queryComplete$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$mJksNVLqmyaqGgswd2re-WOkhnM, reason: not valid java name */
    public static /* synthetic */ void m608$r8$lambda$mJksNVLqmyaqGgswd2reWOkhnM(InterceptDetailActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public String scene() {
        return "intercept_detail_page";
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.securitycenter.nodisturb.InterceptDetailActivity$callInterceptObserver$1] */
    public InterceptDetailActivity() {
        this.QUERY_CALL_LOG = 1;
        this.NO_INTERCEPT_TOKEN = 2;
        this.IS_IN_CONTACT_TOKEN = 7;
        Uri r0 = Uri.parse("content://bytedance_spam_sms/inbox");
        Intrinsics.checkNotNullExpressionValue(r0, "parse(\"content://bytedance_spam_sms/inbox\")");
        this.spamSmsInboxUri = r0;
        this.numberStr = "";
        this.blackListId = -1;
        this.phoneNumber = "";
        this.CONTACT_PROJECTION = new String[]{"_id"};
        final Handler r1 = new Handler();
        this.callInterceptObserver = new InterceptDetailActivity$callInterceptObserver$1(this, r1);
    }

    public static final /* synthetic */ int access$getBlackListId$p(InterceptDetailActivity r0) {
        return r0.blackListId;
    }

    public static final /* synthetic */ void access$queryAllCallLog(InterceptDetailActivity r0) {
        r0.queryAllCallLog();
    }

    public static final /* synthetic */ void access$queryBlackList(InterceptDetailActivity r0) {
        r0.queryBlackList();
    }

    public static final /* synthetic */ void access$queryBlackListCallLog(InterceptDetailActivity r0) {
        r0.queryBlackListCallLog();
    }

    public static final /* synthetic */ void access$queryComplete(InterceptDetailActivity r0, int r1, Cursor r2) {
        r0.queryComplete(r1, r2);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r11) {
        super.onCreate(r11);
        setContentView(R.layout.intercept_detail_activity);
        initTitleBar(false);
        ContentResolver r0 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r0, "contentResolver");
        this.resolver = r0;
        ContentResolver r1 = this.resolver;
        TextView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r1 = null;
    L5:
        this.queryHandler = new QueryHandler(this, r1);
        Intent r3 = getIntent();
        if (r3 == null) goto L8;
        int r4 = r3.getIntExtra("launch_by", 0);
    L9:
        this.startedByBlacklist = r4;
        if (r3 == null) goto L12;
        int r5 = r3.getIntExtra("blackid", -1);
    L13:
        this.blackListId = r5;
        if (r3 == null) goto L16;
        String r6 = r3.getStringExtra(DisturbActivity.CALL_PHONE_NUMBER);
    L17:
        if (r6 != null) goto L19;
        r6 = "";
    L19:
        this.phoneNumber = r6;
        this.callInterceptCount = getIntent().getLongExtra("call_intercept_count", 0);
        InterceptDetailActivity r9 = this;
        OInsetSheet r7 = new OInsetSheet(r9);
        this.noInterceptDialog = r7;
        r7.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OInsetSheetTitleBar r8 = new OInsetSheetTitleBar(r9, null, 0, 6, null);
        r8.setTitleText(getString(R.string.detail_confirm_text));
        r8.setShowLeftBack(false);
        OButton r10 = r8.createNeutralButton(r9, r8.getMLeftContainer());
        r10.setButtonSourceBitmap(R.drawable.o_ic_close);
        r10.setOnClickListener(new InterceptDetailActivity$$ExternalSyntheticLambda0(this));
        OInsetSheet r12 = this.noInterceptDialog;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");
        r12 = null;
    L22:
        r12.setHeaderView(r8);
        View r13 = LayoutInflater.from(r9).inflate(R.layout.black_detail_list_header, null);
        View r14 = LayoutInflater.from(r9).inflate(R.layout.black_detail_list_footer, null);
        View r15 = findViewById(R.id.call_log_list);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.call_log_list)");
        ListView r16 = (ListView) r15;
        this.listView = r16;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r16 = null;
    L25:
        r16.addHeaderView(r13);
        ListView r17 = this.listView;
        if (r17 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r17 = null;
    L28:
        r17.addFooterView(r14);
        View r18 = findViewById(R.id.iv_content_img);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.iv_content_img)");
        this.photoView = (ImageView) r18;
        View r19 = findViewById(R.id.tv_content_title);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.tv_content_title)");
        this.noteView = (TextView) r19;
        View r20 = findViewById(R.id.tv_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tv_content_subtitle)");
        this.numberView = (TextView) r20;
        View r21 = findViewById(R.id.call_count);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.call_count)");
        this.callSumItem = (OCardListItem) r21;
        View r22 = findViewById(R.id.sms_count);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.sms_count)");
        this.smsSumItem = (OCardListItem) r22;
        View r23 = findViewById(R.id.footer_divider);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.footer_divider)");
        this.footerDivider = (TextView) r23;
        OCardListItem r24 = this.callSumItem;
        if (r24 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("callSumItem");
        r24 = null;
    L31:
        r24.setCardType(0);
        OCardListItem r25 = this.callSumItem;
        if (r25 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("callSumItem");
        r25 = null;
    L34:
        OCardListItem.setCardPosition$default(r25, 1, false, 2, null);
        OCardListItem r26 = this.smsSumItem;
        if (r26 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("smsSumItem");
        r26 = null;
    L37:
        OCardListItem.setCardPosition$default(r26, 3, false, 2, null);
        OCardListItem r27 = this.smsSumItem;
        if (r27 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("smsSumItem");
        r27 = null;
    L40:
        r27.setCardType(0);
        OCardListItem r28 = this.callSumItem;
        if (r28 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("callSumItem");
        r28 = null;
    L43:
        r28.setOnContentClickListener(null);
        OCardListItem r29 = this.smsSumItem;
        if (r29 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("smsSumItem");
        r29 = null;
    L46:
        r29.setOnContentClickListener(null);
        String r30 = getString(R.string.intercept_call_text, new Object[]{String.valueOf(this.callInterceptCount)});
        Intrinsics.checkNotNullExpressionValue(r30, "getString(R.string.inter…nterceptCount.toString())");
        OCardListItem r31 = this.callSumItem;
        if (r31 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("callSumItem");
        r31 = null;
    L49:
        OCardListItemExtKt.setEndText(r31, r30);
        TextView r32 = this.noteView;
        if (r32 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("noteView");
        r32 = null;
    L52:
        r32.setText(formatPhone34X(this.phoneNumber));
        TextView r33 = this.noteView;
        if (r33 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("noteView");
    L56:
        r2.setVisibility(0);
        registerObserver();
        if (this.blackListId == (-1)) goto L59;
        queryBlackList();
        queryBlackListCallLog();
        onSetupTitleBar();
        return;
    L59:
        queryAllCallLog();
        return;
    L55:
        r2 = r33;
        goto L56
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = -1;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    private static final void onCreate$lambda$0(InterceptDetailActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OInsetSheet r2 = r0.noInterceptDialog;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");
        r2 = null;
    L5:
        r2.dismiss();
    }

    private final void registerObserver() {
        ContentResolver r0 = this.resolver;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r0 = null;
    L5:
        r0.registerContentObserver(ProviderConstants.INSTANCE.getCALL_INTERCEPT_COUNT_URI(), true, this.callInterceptObserver);
    }

    public final String formatPhone34X(String r7) {
        Intrinsics.checkNotNullParameter(r7, "phone");
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

    private final void unregisterObserver() {
        ContentResolver r0 = this.resolver;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r0 = null;
    L5:
        r0.unregisterContentObserver(this.callInterceptObserver);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        unregisterObserver();
        super.onDestroy();
    }

    private final void queryAllCallLog() {
        String[] r7 = {"_id", ProviderConstants.BlockedCallLog.BCL_PHONE_NUMBER, "bcl_datetime"};
        String[] r9 = {this.phoneNumber};
        QueryHandler r0 = this.queryHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r0 = null;
    L5:
        r0.startQuery(this.QUERY_CALL_LOG, null, ProviderConstants.INSTANCE.getBLOCKED_CALL_LOG_URI(), r7, "bcl_phone_number = ?", r9, "_id DESC");
    }

    private final void queryBlackListCallLog() {
        QueryHandler r1 = this.queryHandler;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r1 = null;
    L5:
        r1.startQuery(this.QUERY_BLACK_LIST, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), null, "_id=?", new String[]{String.valueOf(this.blackListId)}, null);
        QueryHandler r2 = this.queryHandler;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r13 = null;
    L9:
        r13.startQuery(this.QUERY_CALL_LOG, null, ProviderConstants.INSTANCE.getBLOCKED_CALL_LOG_URI(), null, "bcl_bl_id=?", new String[]{String.valueOf(this.blackListId)}, "bcl_datetime DESC");
        return;
    L8:
        r13 = r2;
        goto L9
    }

    private final void queryBlackList() {
        QueryHandler r0 = this.queryHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r0 = null;
    L5:
        r0.startQuery(this.QUERY_BLACK_LIST, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), null, "_id=?", new String[]{String.valueOf(this.blackListId)}, null);
    }

    private final void queryComplete(int r20, Cursor r21) {
        OInsetSheet r9 = null;
        OCardListItem r10 = null;
        OCardListItem r11 = null;
        if (r20 != this.QUERY_BLACK_LIST) goto L61;
        if (r21 != null) goto L120;
        return;
    L120:
        int r1 = r21.getCount();     // Catch: Throwable -> L57
        String[] r12 = r21.getColumnNames();     // Catch: Throwable -> L57
        if (r12 == null) goto L9;
        String r4 = ArraysKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L57
    L10:
        OLog.d("InterceptDetailActivity", "QUERY_BLACK_LIST cursor: count=" + r1 + " columns=" + r4);     // Catch: Throwable -> L57
        if (r21.getCount() > 0) goto L13;
    L55:
        r21.close();     // Catch: Exception -> L115
    L124:
        return;
    L13:
        if (r21.moveToFirst() == false) goto L55;
        byte[] r2 = r21.getBlob(r21.getColumnIndexOrThrow("bl_photo"));     // Catch: Throwable -> L57
        String r3 = r21.getString(r21.getColumnIndexOrThrow("bl_note"));     // Catch: Throwable -> L57
        if (r2 == null) goto L20;
        ImageView r5 = this.photoView;     // Catch: Throwable -> L57
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("photoView");     // Catch: Throwable -> L57
        r5 = null;
    L19:
        r5.setImageBitmap(BitmapFactory.decodeByteArray(r2, 0, r2.length));     // Catch: Throwable -> L57
    L20:
        String r6 = r21.getString(r21.getColumnIndexOrThrow("bl_phone_number"));     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r6, "c.getString(c.getColumnI…ackList.BL_PHONE_NUMBER))");     // Catch: Throwable -> L57
        this.numberStr = r6;     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r3) == false) goto L30;
        TextView r7 = this.noteView;     // Catch: Throwable -> L57
        if (r7 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("noteView");     // Catch: Throwable -> L57
        r7 = null;
    L26:
        r7.setText(formatPhone34X(this.numberStr));     // Catch: Throwable -> L57
        TextView r8 = this.numberView;     // Catch: Throwable -> L57
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("numberView");     // Catch: Throwable -> L57
        r8 = null;
    L29:
        r8.setText("");     // Catch: Throwable -> L57
    L40:
        String r13 = r21.getString(r21.getColumnIndexOrThrow(ProviderConstants.BlackList.BL_CALL_SUM));     // Catch: Throwable -> L57
        String r14 = r21.getString(r21.getColumnIndexOrThrow(ProviderConstants.BlackList.BL_SMS_SUM));     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r13) == false) goto L45;
        r13 = "0";
    L45:
        if (TextUtils.isEmpty(r14) == false) goto L47;
        r14 = "0";
    L47:
        String r15 = getString(R.string.intercept_call_text, new Object[]{r13});     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r15, "getString(R.string.intercept_call_text, callCount)");     // Catch: Throwable -> L57
        String r16 = getString(R.string.intercept_sms_text, new Object[]{r14});     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.intercept_sms_text, smsCount)");     // Catch: Throwable -> L57
        OCardListItem r17 = this.callSumItem;     // Catch: Throwable -> L57
        if (r17 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("callSumItem");     // Catch: Throwable -> L57
        r17 = null;
    L50:
        OCardListItemExtKt.setEndText(r17, r15);     // Catch: Throwable -> L57
        OCardListItem r0 = this.smsSumItem;     // Catch: Throwable -> L57
        if (r0 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("smsSumItem");     // Catch: Throwable -> L57
    L54:
        OCardListItemExtKt.setEndText(r10, r16);     // Catch: Throwable -> L57
        goto L55
    L53:
        r10 = r0;
        goto L54
    L30:
        TextView r18 = this.noteView;     // Catch: Throwable -> L57
        if (r18 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("noteView");     // Catch: Throwable -> L57
        r18 = null;
    L33:
        r18.setText(r3);     // Catch: Throwable -> L57
        TextView r19 = this.numberView;     // Catch: Throwable -> L57
        if (r19 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("numberView");     // Catch: Throwable -> L57
        r19 = null;
    L36:
        r19.setText(formatPhone34X(this.numberStr));     // Catch: Throwable -> L57
        TextView r22 = this.numberView;     // Catch: Throwable -> L57
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("numberView");     // Catch: Throwable -> L57
        r22 = null;
    L39:
        r22.setVisibility(0);     // Catch: Throwable -> L57
        goto L40
    L9:
        r4 = null;
    L57:
        th = move-exception;
        r21.close();     // Catch: Exception -> L116
    L59:
        throw th;
    L61:
        if (r20 != this.QUERY_CALL_LOG) goto L93;
        if (r21 == null) goto L82;
        this.adapter = new BlackDetailAdapter(this, R.layout.intercept_detail_item, r21);
        ListView r23 = this.listView;
        if (r23 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r23 = null;
    L66:
        BlackDetailAdapter r24 = this.adapter;
        if (r24 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r24 = null;
    L69:
        r23.setAdapter(r24);
        ListView r25 = this.listView;
        if (r25 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r25 = null;
    L72:
        r25.setScrollBarStyle(16777216);
        ListView r26 = this.listView;
        if (r26 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r26 = null;
    L75:
        r26.setSelector(android.R.color.transparent);
        ListView r27 = this.listView;
        if (r27 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r27 = null;
    L78:
        r27.setDivider(null);
        TextView r28 = this.footerDivider;
        if (r28 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("footerDivider");
        r28 = null;
    L81:
        r28.setVisibility(8);
    L84:
        if ((!StringsKt.isBlank(this.numberStr)) == false) goto L86;
        String r29 = this.numberStr;
    L87:
        int r30 = querySpamSmsTotalCount(r29);
        String r31 = getString(R.string.intercept_sms_text, new Object[]{String.valueOf(r30)});
        Intrinsics.checkNotNullExpressionValue(r31, "getString(R.string.inter…s_text, total.toString())");
        OCardListItem r32 = this.smsSumItem;
        if (r32 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("smsSumItem");
    L91:
        OCardListItemExtKt.setEndText(r11, r31);
        OLog.d("InterceptDetailActivity", "QUERY_CALL_LOG smsTotal=" + r30 + " address=" + EncryptToMd5Kt.calculateMD5(r29));
        return;
    L90:
        r11 = r32;
        goto L91
    L86:
        r29 = this.phoneNumber;
        goto L87
    L82:
        OLog.w("InterceptDetailActivity", "QUERY_CALL_LOG cursor is null");
        goto L84
    L93:
        if (r20 != this.IS_IN_CONTACT_TOKEN) goto L130;
        if (r21 != null) goto L118;
        return;
    L118:
        View r33 = LayoutInflater.from(this).inflate(R.layout.no_intercept_item, null);     // Catch: Throwable -> L111
        ((OButton) r33.findViewById(R.id.no_intercept)).setOnClickListener(new InterceptDetailActivity$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L111
        OButton r34 = (OButton) r33.findViewById(R.id.no_intercept_and_add_contact);     // Catch: Throwable -> L111
        if (r21.getCount() <= 0) goto L99;
        r34.setVisibility(8);     // Catch: Throwable -> L111
    L100:
        OInsetSheet r35 = this.noInterceptDialog;     // Catch: Throwable -> L111
        if (r35 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");     // Catch: Throwable -> L111
        r35 = null;
    L104:
        r35.setContainerView(r33);     // Catch: Throwable -> L111
        OInsetSheet r36 = this.noInterceptDialog;     // Catch: Throwable -> L111
        if (r36 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");     // Catch: Throwable -> L111
    L108:
        r9.show();     // Catch: Throwable -> L111
        r21.close();     // Catch: Exception -> L115
        goto L124
    L107:
        r9 = r36;
        goto L108
    L99:
        r34.setVisibility(0);     // Catch: Throwable -> L111
        r34.setOnClickListener(new InterceptDetailActivity$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L111
    L111:
        th = move-exception;
        r21.close();     // Catch: Exception -> L117
    L113:
        throw th;
    L130:
        return;
    }

    private static final void queryComplete$lambda$1(InterceptDetailActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OInsetSheet r2 = r0.noInterceptDialog;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");
        r2 = null;
    L5:
        r2.dismiss();
        r0.removeFromBlackList();
    }

    private static final void queryComplete$lambda$2(InterceptDetailActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OInsetSheet r2 = r0.noInterceptDialog;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("noInterceptDialog");
        r2 = null;
    L5:
        r2.dismiss();
        r0.removeFromBlackList();
        r0.addToContact();
    }

    private final int querySpamSmsTotalCount(String r22) {
        String r3 = r22;
        if (StringsKt.isBlank(r3) == false) goto L5;
        return 0;
    L5:
        LinkedHashSet r0 = SetsKt.linkedSetOf(new String[]{r22, new Regex("\\D+").replace(r3, "")});
        ArrayList r5 = new ArrayList();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r9 = r1.next();
        if ((!StringsKt.isBlank((String) r9)) == false) goto L7;
        r5.add(r9);
        goto L7
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L41;
        String r14 = (String) r6.next();
        String[] r17 = {"COUNT(*) AS cnt"};     // Catch: Exception -> L39
        ContentResolver r2 = this.resolver;     // Catch: Exception -> L39
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");     // Catch: Exception -> L39
        ContentResolver r15 = null;
    L19:
        Cursor r4 = r15.query(this.spamSmsInboxUri, r17, "address = ?", new String[]{r14}, null);     // Catch: Exception -> L39
        if (r4 == null) goto L36;
        Cursor r10 = r4;     // Catch: Exception -> L39
        Cursor r7 = r10;     // Catch: Throwable -> L29
        if (r7.moveToFirst() == false) goto L26;
        int r8 = r7.getInt(r7.getColumnIndexOrThrow("cnt"));     // Catch: Throwable -> L29
    L27:
        CloseableKt.closeFinally(r10, null);     // Catch: Exception -> L39
    L37:
        if (r8 <= 0) goto L13;
        return r8;
    L26:
        r8 = 0;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);     // Catch: Exception -> L39
        throw th;     // Catch: Exception -> L39
    L36:
        r8 = 0;
        goto L37
    L18:
        r15 = r2;
    L39:
        e = move-exception;
        OLog.w("InterceptDetailActivity", "querySpamSmsTotalCount failed, address=" + EncryptToMd5Kt.calculateMD5(r14), e);
        goto L13
    L41:
        String r11 = new Regex("\\D+").replace(r3, "");
        if (r11.length() >= 5) goto L72;
    L69:
        return 0;
    L72:
        String[] r16 = {"COUNT(*) AS cnt"};     // Catch: Exception -> L67
        ContentResolver r12 = this.resolver;     // Catch: Exception -> L67
        if (r12 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");     // Catch: Exception -> L67
        ContentResolver r18 = null;
    L47:
        Cursor r13 = r18.query(this.spamSmsInboxUri, r16, "address LIKE ?", new String[]{"%" + r11 + "%"}, null);     // Catch: Exception -> L67
        if (r13 == null) goto L64;
        Cursor r19 = r13;     // Catch: Exception -> L67
        Cursor r20 = r19;     // Catch: Throwable -> L57
        if (r20.moveToFirst() == false) goto L54;
        int r21 = r20.getInt(r20.getColumnIndexOrThrow("cnt"));     // Catch: Throwable -> L57
    L55:
        CloseableKt.closeFinally(r19, null);     // Catch: Exception -> L67
    L65:
        if (r21 <= 0) goto L69;
        return r21;
    L54:
        r21 = 0;
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Exception -> L67
        throw th;     // Catch: Exception -> L67
    L64:
        r21 = 0;
        goto L65
    L46:
        r18 = r12;
    L67:
        e = move-exception;
        OLog.w("InterceptDetailActivity", "querySpamSmsTotalCount LIKE failed, digits=" + EncryptToMd5Kt.calculateMD5(r11), e);
        goto L69
    }

    public final void onSetupTitleBar() {
        if (this.mTitle != null) goto L5;
        return;
    L5:
        this.mTitle.removeEndAction();
    }

    private final void handleNoInterceptClick() {
        Uri r5 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.numberStr));
        QueryHandler r0 = this.queryHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r0 = null;
    L5:
        r0.startQuery(this.IS_IN_CONTACT_TOKEN, null, r5, this.CONTACT_PROJECTION, null, null, null);
    }

    private final void removeFromBlackList() {
        finish();
        if (this.blackListId < 0) goto L6;
        Uri.withAppendedPath(ProviderConstants.INSTANCE.getBLACK_LIST_URI(), String.valueOf(this.blackListId));
        return;
    }

    private final void addToContact() {
        Intent r0 = new Intent("com.android.contact.activities.ContactSelectionActivity.bytedanceInsertOrEdit").putExtra("phone", this.numberStr).setPackage("com.android.contacts").setFlags(272662528);
        Intrinsics.checkNotNullExpressionValue(r0, "Intent(\"com.android.cont…FLAG_ACTIVITY_CLEAR_TASK)");
        startActivity(r0);
    }
}
