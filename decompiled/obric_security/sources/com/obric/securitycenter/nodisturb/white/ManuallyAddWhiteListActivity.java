package com.obric.securitycenter.nodisturb.white;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.securitycenter.nodisturb.BaseActivity;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManuallyAddWhiteListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/ManuallyAddWhiteListActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "INSERT_WHITE_LIST_TOKEN", "", "IS_IN_WHITE_LIST_TOKEN", "note", "", "numberStr", "queryHandler", "Lcom/obric/securitycenter/nodisturb/white/ManuallyAddWhiteListActivity$QueryHandler;", "resolver", "Landroid/content/ContentResolver;", SafeCushionConstant.FINISH_STATE, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveWhiteList", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ManuallyAddWhiteListActivity extends BaseActivity {
    private final int INSERT_WHITE_LIST_TOKEN;
    private final int IS_IN_WHITE_LIST_TOKEN;
    private String note;
    private String numberStr;
    private QueryHandler queryHandler;
    private ContentResolver resolver;

    /* JADX INFO: compiled from: ManuallyAddWhiteListActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/obric/securitycenter/nodisturb/white/ManuallyAddWhiteListActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/white/ManuallyAddWhiteListActivity;Landroid/content/ContentResolver;)V", "onInsertComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "uri", "Landroid/net/Uri;", "onQueryComplete", "c", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ ManuallyAddWhiteListActivity this$0;

        public QueryHandler(ManuallyAddWhiteListActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r3, Object r4, Cursor r5) {
            if (r5 != null) goto L23;
            return;
        L23:
        L12:
            th = move-exception;
            r5.close();     // Catch: Exception -> L18
        L14:
            throw th;
        L5:
            if (r3 != ManuallyAddWhiteListActivity.access$getIS_IN_WHITE_LIST_TOKEN$p(this.this$0)) goto L19;
            if (r5.getCount() <= 0) goto L9;
            Toast.makeText(this.this$0.getApplicationContext(), this.this$0.getString(R.string.in_white_list_toast), 0).show();     // Catch: Exception -> L16 Throwable -> L12
            ManuallyAddWhiteListActivity.access$setNumberStr$p(this.this$0, "");     // Catch: Exception -> L16 Throwable -> L12
            goto L19
        L9:
            ContentValues r6 = new ContentValues();     // Catch: Exception -> L16 Throwable -> L12
            r6.put(ProviderConstants.WhiteList.WL_PHONE_NUMBER, ManuallyAddWhiteListActivity.access$getNumberStr$p(this.this$0));     // Catch: Exception -> L16 Throwable -> L12
            r6.put(ProviderConstants.WhiteList.WL_NOTE, ManuallyAddWhiteListActivity.access$getNote$p(this.this$0));     // Catch: Exception -> L16 Throwable -> L12
            startInsert(ManuallyAddWhiteListActivity.access$getINSERT_WHITE_LIST_TOKEN$p(this.this$0), null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), r6);     // Catch: Exception -> L16 Throwable -> L12
        L19:
            r5.close();     // Catch: Exception -> L17
        L27:
            return;
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            this.this$0.setResult(-1);
            this.this$0.finish();
        }
    }

    public static /* synthetic */ void $r8$lambda$YsX3kqiM0XLLjkT3Ws94Q2uLMKo(ManuallyAddWhiteListActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oXqGmxq5lCUnRbXqHlGWFywFSew(ManuallyAddWhiteListActivity r0, View r1) {
        onCreate$lambda$1(r0, r1);
    }

    public ManuallyAddWhiteListActivity() {
        this.INSERT_WHITE_LIST_TOKEN = 3;
        this.IS_IN_WHITE_LIST_TOKEN = 4;
        this.numberStr = "";
        this.note = "";
    }

    public static final /* synthetic */ int access$getINSERT_WHITE_LIST_TOKEN$p(ManuallyAddWhiteListActivity r0) {
        return r0.INSERT_WHITE_LIST_TOKEN;
    }

    public static final /* synthetic */ int access$getIS_IN_WHITE_LIST_TOKEN$p(ManuallyAddWhiteListActivity r0) {
        return r0.IS_IN_WHITE_LIST_TOKEN;
    }

    public static final /* synthetic */ String access$getNote$p(ManuallyAddWhiteListActivity r0) {
        return r0.note;
    }

    public static final /* synthetic */ String access$getNumberStr$p(ManuallyAddWhiteListActivity r0) {
        return r0.numberStr;
    }

    public static final /* synthetic */ void access$setNumberStr$p(ManuallyAddWhiteListActivity r0, String r1) {
        r0.numberStr = r1;
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        WindowManager.LayoutParams r5 = getWindow().getAttributes();
        Intrinsics.checkNotNullExpressionValue(r5, "window.attributes");
        TransitionAnimHelper.enableModalTransition(r5, true);
        setContentView(R.layout.manually_add_activity);
        initTitleBar(false);
        ContentResolver r0 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r0, "contentResolver");
        this.resolver = r0;
        ContentResolver r1 = this.resolver;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r1 = null;
    L5:
        this.queryHandler = new QueryHandler(this, r1);
        View r2 = findViewById(R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.title_bar)");
        OCTitleBar r3 = (OCTitleBar) r2;
        r3.setTitleText(getString(R.string.add_to_white_list));
        r3.setShowLeftBack(false);
        OButton r6 = r3.createNeutralButton(this, r3.getMLeftContainer());
        r6.setButtonSourceBitmap(R.drawable.o_ic_close);
        r6.setOnClickListener(new ManuallyAddWhiteListActivity$$ExternalSyntheticLambda0(this));
        final OButton r7 = r3.addRightButton(4, R.string.menu_save);
        r7.setOnClickListener(new ManuallyAddWhiteListActivity$$ExternalSyntheticLambda1(this));
        r7.setEnabled(false);
        ((OInputView) findViewById(R.id.phone_number)).getVInput().addTextChangedListener(new AnonymousClass3(r7));
    }

    private static final void onCreate$lambda$0(ManuallyAddWhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void onCreate$lambda$1(ManuallyAddWhiteListActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.saveWhiteList();
    }

    private final void saveWhiteList() {
        OEditText r0 = ((OInputView) findViewById(R.id.phone_number)).getVInput();
        Editable r1 = ((OInputView) findViewById(R.id.number_note)).getVInput().getText();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.toString();
        if (r3 == null) goto L6;
    L7:
        Editable r4 = r0.getText();
        if (r4 == null) goto L13;
        String r5 = r4.toString();
        if (r5 == null) goto L13;
        r2 = r5;
    L13:
        this.numberStr = r2;
        this.note = r3;
        if (TextUtils.isEmpty(r2) == true) goto L16;
        String r6 = PhoneNumberUtils.normalizeNumber(this.numberStr);
        Intrinsics.checkNotNullExpressionValue(r6, "normalizeNumber(numberStr)");
        this.numberStr = r6;
    L16:
        Uri r7 = Uri.withAppendedPath(ProviderConstants.INSTANCE.getIN_WHITE_LIST_URI(), this.numberStr);
        QueryHandler r8 = this.queryHandler;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        r8 = null;
    L19:
        r8.startQuery(this.IS_IN_WHITE_LIST_TOKEN, null, r7, null, null, null, null);
        return;
    L6:
        r3 = "";
        goto L7
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Modal);
    }
}
