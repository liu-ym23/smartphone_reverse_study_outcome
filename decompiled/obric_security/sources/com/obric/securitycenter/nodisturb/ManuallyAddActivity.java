package com.obric.securitycenter.nodisturb;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.forms.OPhoneInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManuallyAddActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u000289B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0002J\u0012\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u001a\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\t2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020,H\u0002J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0011H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\r\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00060 R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ManuallyAddActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CONTACT_PROJECTION_BLACK", "", "", "[Ljava/lang/String;", "CONTACT_PROJECTION_WHITE", "INSERT_TOKEN", "", "IS_IN_CONTACT_TOKEN", "IS_IN_LIST_TOKEN", "PHOTO_PROJECTION", "QUERY_PHOTO_TOKEN", "contentValues", "Landroid/content/ContentValues;", "isWhiteList", "", "()Z", "isWhiteList$delegate", "Lkotlin/Lazy;", "noteStr", "numberNoteCard", "Lcom/obric/oui/lisitem/OCardListItem;", "numberNoteInput", "Lcom/obric/oui/forms/OInputLayout;", "numberStr", "phoneNumberCard", "phoneNumberInput", "Lcom/obric/oui/forms/OPhoneInputLayout;", "photoId", "queryHandler", "Lcom/obric/securitycenter/nodisturb/ManuallyAddActivity$QueryHandler;", "resolver", "Landroid/content/ContentResolver;", "saveButton", "Landroid/view/View;", "getSaveButton", "()Landroid/view/View;", "setSaveButton", "(Landroid/view/View;)V", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", SafeCushionConstant.FINISH_STATE, "", "initTitleBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "queryComplete", "token", "c", "Landroid/database/Cursor;", "save", "setwindow", "dismiss", "Companion", "QueryHandler", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ManuallyAddActivity extends AppCompatActivity {
    public static final Companion Companion = null;
    public static final String EXTRA_LIST_TYPE = "extra_list_type";
    public static final String LIST_TYPE_BLACK = "black";
    public static final String LIST_TYPE_WHITE = "white";
    private static final int MAX_PHONE_NUMBER_DIGITS = 11;
    private final String[] CONTACT_PROJECTION_BLACK;
    private final String[] CONTACT_PROJECTION_WHITE;
    private final int INSERT_TOKEN;
    private final int IS_IN_CONTACT_TOKEN;
    private final int IS_IN_LIST_TOKEN;
    private final String[] PHOTO_PROJECTION;
    private final int QUERY_PHOTO_TOKEN;
    private ContentValues contentValues;
    private final Lazy isWhiteList$delegate;
    private String noteStr;
    private OCardListItem numberNoteCard;
    private OInputLayout numberNoteInput;
    private String numberStr;
    private OCardListItem phoneNumberCard;
    private OPhoneInputLayout phoneNumberInput;
    private int photoId;
    private QueryHandler queryHandler;
    private ContentResolver resolver;
    private View saveButton;
    private OFloatingTitleBar titleBar;

    /* JADX INFO: compiled from: ManuallyAddActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ManuallyAddActivity$Companion;", "", "()V", "EXTRA_LIST_TYPE", "", "LIST_TYPE_BLACK", "LIST_TYPE_WHITE", "MAX_PHONE_NUMBER_DIGITS", "", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ManuallyAddActivity.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/obric/securitycenter/nodisturb/ManuallyAddActivity$QueryHandler;", "Landroid/content/AsyncQueryHandler;", "cr", "Landroid/content/ContentResolver;", "(Lcom/obric/securitycenter/nodisturb/ManuallyAddActivity;Landroid/content/ContentResolver;)V", "onInsertComplete", "", "token", "", BaseHttpRequestInfo.KEY_COOKIE, "", "uri", "Landroid/net/Uri;", "onQueryComplete", "c", "Landroid/database/Cursor;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ ManuallyAddActivity this$0;

        public QueryHandler(ManuallyAddActivity r2, ContentResolver r3) {
            Intrinsics.checkNotNullParameter(r3, "cr");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onQueryComplete(int r1, Object r2, Cursor r3) {
            ManuallyAddActivity.access$queryComplete(this.this$0, r1, r3);
        }

        @Override // android.content.AsyncQueryHandler
        protected void onInsertComplete(int r1, Object r2, Uri r3) {
            this.this$0.setResult(-1, new Intent());
            this.this$0.finish();
        }
    }

    public static /* synthetic */ void $r8$lambda$Tpu_UFG3hDa5TDz3dmYMzbyu6CE(ManuallyAddActivity r0, View r1) {
        initTitleBar$lambda$9(r0, r1);
    }

    public static /* synthetic */ CharSequence $r8$lambda$rUb2iXFT01K_ETvxcwAQchFtfN0(CharSequence r0, int r1, int r2, Spanned r3, int r4, int r5) {
        return onCreate$lambda$8$lambda$6(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$wLeh5ng3p77o1WQWon7EH6BWWiI(ManuallyAddActivity r0, View r1) {
        initTitleBar$lambda$10(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public ManuallyAddActivity() {
        this.IS_IN_CONTACT_TOKEN = 1;
        this.INSERT_TOKEN = 3;
        this.IS_IN_LIST_TOKEN = 4;
        this.QUERY_PHOTO_TOKEN = 5;
        this.CONTACT_PROJECTION_BLACK = new String[]{"display_name", "photo_id"};
        this.CONTACT_PROJECTION_WHITE = new String[]{"_id", "display_name"};
        this.PHOTO_PROJECTION = new String[]{"_id", "data15"};
        this.contentValues = new ContentValues();
        this.numberStr = "";
        this.noteStr = "";
        this.isWhiteList$delegate = LazyKt.lazy(new AnonymousClass2(this));
    }

    public static final /* synthetic */ void access$queryComplete(ManuallyAddActivity r0, int r1, Cursor r2) {
        r0.queryComplete(r1, r2);
    }

    public final View getSaveButton() {
        return this.saveButton;
    }

    public final void setSaveButton(View r1) {
        this.saveButton = r1;
    }

    private final boolean isWhiteList() {
        return ((Boolean) this.isWhiteList$delegate.getValue()).booleanValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r6) {
        super.onCreate(r6);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        WindowManager.LayoutParams r7 = getWindow().getAttributes();
        Intrinsics.checkNotNullExpressionValue(r7, "getWindow().getAttributes()");
        TransitionAnimHelper.enableModalTransition(r7, true);
        setContentView(R.layout.manually_add_activity);
        initTitleBar();
        OCardListItem r8 = (OCardListItem) findViewById(R.id.phone_number);
        this.phoneNumberCard = r8;
        OEditText r3 = null;
        if (r8 == null) goto L5;
        r8.setCardType(2);
        r8.setCustomStartView(R.layout.layout_phone_input_card);
        OCardListItem.setCardPosition$default(r8, 1, false, 2, null);
        r8.showDivider(true);
    L5:
        OCardListItem r9 = this.phoneNumberCard;
        if (r9 == null) goto L8;
        View r10 = r9.getCustomStartView();
    L10:
        if ((r10 instanceof OPhoneInputLayout) == false) goto L12;
        OPhoneInputLayout r11 = (OPhoneInputLayout) r10;
    L13:
        this.phoneNumberInput = r11;
        if (r11 == null) goto L16;
        r11.setHint(getString(R.string.phone_number_hint));
    L16:
        OPhoneInputLayout r12 = this.phoneNumberInput;
        if (r12 == null) goto L19;
        r12.showCustomStart(false);
    L19:
        OPhoneInputLayout r13 = this.phoneNumberInput;
        if (r13 == null) goto L22;
        r13.showClear(true);
    L22:
        OPhoneInputLayout r14 = this.phoneNumberInput;
        if (r14 == null) goto L25;
        r14.showDivider(true);
    L25:
        OCardListItem r15 = (OCardListItem) findViewById(R.id.number_note);
        this.numberNoteCard = r15;
        if (r15 == null) goto L28;
        r15.setCardType(2);
        r15.setCustomStartView(R.layout.layout_normal_input_card);
        OCardListItem.setCardPosition$default(r15, 3, false, 2, null);
    L28:
        OCardListItem r16 = this.numberNoteCard;
        if (r16 == null) goto L31;
        View r17 = r16.getCustomStartView();
    L33:
        if ((r17 instanceof OInputLayout) == false) goto L35;
        OInputLayout r18 = (OInputLayout) r17;
    L36:
        this.numberNoteInput = r18;
        if (r18 == null) goto L39;
        r18.setHint(getString(R.string.number_note_hint));
    L39:
        ContentResolver r19 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r19, "contentResolver");
        this.resolver = r19;
        ContentResolver r1 = this.resolver;
        if (r1 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("resolver");
        r1 = null;
    L42:
        this.queryHandler = new QueryHandler(this, r1);
        setwindow(false);
        OPhoneInputLayout r20 = this.phoneNumberInput;
        if (r20 == null) goto L45;
        r3 = r20.getVInput();
    L45:
        if (r3 == null) goto L47;
        InputFilter r21 = new ManuallyAddActivity$$ExternalSyntheticLambda2();
        InputFilter[] r2 = r3.getFilters();
        Intrinsics.checkNotNullExpressionValue(r2, "input.filters");
        List r4 = ArraysKt.toMutableList(r2);
        r4.add(r21);
        r3.setFilters((InputFilter[]) r4.toArray(new InputFilter[0]));
    L47:
        if (r3 == null) goto L50;
        r3.addTextChangedListener(new AnonymousClass6(this));
        return;
    L50:
        return;
    L35:
        r18 = null;
        goto L36
    L31:
        r17 = null;
        goto L33
    L12:
        r11 = null;
        goto L13
    L8:
        r10 = null;
        goto L10
    }

    private static final CharSequence onCreate$lambda$8$lambda$6(CharSequence r3, int r4, int r5, Spanned r6, int r7, int r8) {
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

    private final void initTitleBar() {
        OFloatingTitleBar r1 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        this.titleBar = r1;
        if (r1 == null) goto L5;
        View r0 = OFloatingTitleBar.addEndAction$default(r1, R.drawable.oic_confirm, 0, null, 6, null);
    L6:
        this.saveButton = r0;
        if (r0 == null) goto L10;
        r0.setEnabled(false);
    L10:
        View r2 = this.saveButton;
        if (r2 == null) goto L13;
        r2.setOnClickListener(new ManuallyAddActivity$$ExternalSyntheticLambda0(this));
    L13:
        OFloatingTitleBar r3 = this.titleBar;
        if (r3 == null) goto L16;
        r3.addStartAction(R.drawable.icon_close_black, -1, new ManuallyAddActivity$$ExternalSyntheticLambda1(this));
    L16:
        OFloatingTitleBar r4 = this.titleBar;
        if (r4 != null) goto L19;
        return;
    L19:
        if (isWhiteList() == false) goto L21;
        int r5 = R.string.add_to_white_list;
    L22:
        r4.setCenterTitle(getString(r5));
        return;
    L21:
        r5 = R.string.add_to_black_list;
        goto L22
    L5:
        r0 = null;
        goto L6
    }

    private static final void initTitleBar$lambda$9(ManuallyAddActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.save();
    }

    private static final void initTitleBar$lambda$10(ManuallyAddActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void save() {
        OPhoneInputLayout r0 = this.phoneNumberInput;
        if (r0 == null) goto L5;
        OEditText r1 = r0.getVInput();
    L6:
        OInputLayout r2 = this.numberNoteInput;
        if (r2 == null) goto L9;
        OEditText r3 = r2.getVInput();
    L10:
        String r4 = "";
        if (r1 == null) goto L16;
        Editable r5 = r1.getText();
        if (r5 == null) goto L16;
        String r6 = r5.toString();
        if (r6 == null) goto L16;
    L17:
        this.numberStr = r6;
        if (TextUtils.isEmpty(r6) == true) goto L20;
        String r7 = PhoneNumberUtils.normalizeNumber(this.numberStr);
        Intrinsics.checkNotNullExpressionValue(r7, "normalizeNumber(numberStr)");
        this.numberStr = r7;
    L20:
        if (r3 == null) goto L27;
        Editable r8 = r3.getText();
        if (r8 == null) goto L27;
        String r9 = r8.toString();
        if (r9 == null) goto L27;
        r4 = r9;
    L27:
        this.noteStr = r4;
        this.contentValues = new ContentValues();
        if (isWhiteList() == false) goto L30;
        this.contentValues.put(ProviderConstants.WhiteList.WL_PHONE_NUMBER, this.numberStr);
    L32:
        if (isWhiteList() == false) goto L34;
        Uri r10 = ProviderConstants.INSTANCE.getIN_WHITE_LIST_URI();
    L35:
        Uri r11 = Uri.withAppendedPath(r10, this.numberStr);
        QueryHandler r12 = this.queryHandler;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");
        QueryHandler r13 = null;
    L39:
        r13.startQuery(this.IS_IN_LIST_TOKEN, null, r11, null, null, null, null);
        return;
    L38:
        r13 = r12;
        goto L39
    L34:
        r10 = ProviderConstants.INSTANCE.getIN_BLACK_LIST_URI();
        goto L35
    L30:
        this.contentValues.put("bl_phone_number", this.numberStr);
    L16:
        r6 = "";
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void setwindow(boolean r5) {
        Window r4 = getWindow();
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4.getContext().getResources().getConfiguration().uiMode & 48) != 32) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        float r1 = 0.5f;
    L11:
        if (r5 == false) goto L13;
        r1 = 0.0f;
    L13:
        WindowManager.LayoutParams r6 = r4.getAttributes();
        r6.dimAmount = r1;
        r4.setAttributes(r6);
        WindowInsetsControllerCompat r7 = WindowCompat.getInsetsController(r4, r4.getDecorView());
        Intrinsics.checkNotNullExpressionValue(r7, "getInsetsController(this, this.decorView)");
        if (r0 == false) goto L18;
        if (r7 == null) goto L24;
        r7.setAppearanceLightStatusBars(false);
        return;
    L24:
        return;
    L18:
        if (r7 == null) goto L25;
        r7.setAppearanceLightStatusBars(true);
        return;
    L25:
        return;
    L10:
        r1 = 0.16f;
        goto L11
    L7:
        r0 = false;
        goto L8
    }

    private final void queryComplete(int r13, Cursor r14) {
        if (r14 != null) goto L107;
        return;
    L107:
    L90:
        th = move-exception;
        r14.close();     // Catch: Exception -> L98
    L92:
        throw th;
    L6:
        if (r13 != this.QUERY_PHOTO_TOKEN) goto L21;
        if (isWhiteList() == false) goto L12;
        r14.close();     // Catch: Exception -> L94
        return;
    L108:
        return;
    L12:
        if (r14.moveToFirst() == false) goto L16;
        byte[] r15 = r14.getBlob(1);     // Catch: Exception -> L96 Throwable -> L90
        if (r15 == null) goto L16;
        this.contentValues.put("bl_photo", r15);     // Catch: Exception -> L96 Throwable -> L90
    L16:
        QueryHandler r16 = this.queryHandler;     // Catch: Exception -> L96 Throwable -> L90
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L96 Throwable -> L90
        r16 = null;
    L19:
        r16.startInsert(this.INSERT_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L96 Throwable -> L90
        goto L105
    L21:
        String r5 = "";
        if (r13 != this.IS_IN_CONTACT_TOKEN) goto L71;
        if (isWhiteList() == false) goto L46;
        long r0 = 0;
        if (r14.getCount() > 0) goto L28;
    L36:
        long r6 = 0;
    L37:
        ContentValues r17 = this.contentValues;     // Catch: Exception -> L96 Throwable -> L90
        if (r6 <= 0) goto L40;
        r0 = r6;
    L40:
        r17.put(ProviderConstants.WhiteList.WL_CONTACT_ID, Long.valueOf(r0));     // Catch: Exception -> L96 Throwable -> L90
        this.contentValues.put(ProviderConstants.WhiteList.WL_NOTE, this.noteStr);     // Catch: Exception -> L96 Throwable -> L90
        QueryHandler r18 = this.queryHandler;     // Catch: Exception -> L96 Throwable -> L90
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L96 Throwable -> L90
        r18 = null;
    L43:
        r18.startInsert(this.INSERT_TOKEN, null, ProviderConstants.INSTANCE.getWHITE_LIST_URI(), this.contentValues);     // Catch: Exception -> L96 Throwable -> L90
        goto L105
    L28:
        if (r14.moveToFirst() == false) goto L36;
        r6 = r14.getLong(r14.getColumnIndexOrThrow("_id"));     // Catch: Exception -> L96 Throwable -> L90
        if (TextUtils.isEmpty(this.noteStr) == false) goto L37;
        String r19 = r14.getString(r14.getColumnIndexOrThrow("display_name"));     // Catch: Exception -> L96 Throwable -> L90
        if (r19 == null) goto L35;
        r5 = r19;
    L35:
        this.noteStr = r5;     // Catch: Exception -> L96 Throwable -> L90
        goto L37
    L46:
        if (r14.getCount() > 0) goto L48;
    L65:
        this.contentValues.put("bl_note", this.noteStr);     // Catch: Exception -> L96 Throwable -> L90
    L66:
        QueryHandler r110 = this.queryHandler;     // Catch: Exception -> L96 Throwable -> L90
        if (r110 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L96 Throwable -> L90
        r110 = null;
    L69:
        r110.startInsert(this.INSERT_TOKEN, null, ProviderConstants.INSTANCE.getBLACK_LIST_URI(), this.contentValues);     // Catch: Exception -> L96 Throwable -> L90
        goto L105
    L48:
        if (r14.moveToFirst() == false) goto L65;
        if (TextUtils.isEmpty(this.noteStr) == false) goto L56;
        String r111 = r14.getString(r14.getColumnIndexOrThrow(this.CONTACT_PROJECTION_BLACK[0]));     // Catch: Exception -> L96 Throwable -> L90
        if (r111 == null) goto L55;
        r5 = r111;
    L55:
        this.noteStr = r5;     // Catch: Exception -> L96 Throwable -> L90
    L56:
        this.contentValues.put("bl_note", this.noteStr);     // Catch: Exception -> L96 Throwable -> L90
        int r112 = r14.getInt(r14.getColumnIndexOrThrow(this.CONTACT_PROJECTION_BLACK[1]));     // Catch: Exception -> L96 Throwable -> L90
        this.photoId = r112;     // Catch: Exception -> L96 Throwable -> L90
        if (r112 == 0) goto L66;
        QueryHandler r113 = this.queryHandler;     // Catch: Exception -> L96 Throwable -> L90
        if (r113 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L96 Throwable -> L90
        QueryHandler r1 = null;
    L62:
        r1.startQuery(this.QUERY_PHOTO_TOKEN, null, ContentUris.withAppendedId(ContactsContract.Data.CONTENT_URI, this.photoId), this.PHOTO_PROJECTION, null, null, null);     // Catch: Exception -> L96 Throwable -> L90
        r14.close();     // Catch: Exception -> L95
        return;
    L109:
        return;
    L61:
        r1 = r113;
        goto L62
    L71:
        if (r13 != this.IS_IN_LIST_TOKEN) goto L105;
        if (r14.getCount() <= 0) goto L79;
        Context r114 = getApplicationContext();     // Catch: Exception -> L96 Throwable -> L90
        if (isWhiteList() == false) goto L77;
        int r2 = R.string.in_white_list_toast;     // Catch: Exception -> L96 Throwable -> L90
    L78:
        Toast.makeText(r114, getString(r2), 0).show();     // Catch: Exception -> L96 Throwable -> L90
        this.photoId = 0;     // Catch: Exception -> L96 Throwable -> L90
        this.noteStr = "";     // Catch: Exception -> L96 Throwable -> L90
        this.numberStr = "";     // Catch: Exception -> L96 Throwable -> L90
        goto L105
    L77:
        r2 = R.string.in_black_list_toast;     // Catch: Exception -> L96 Throwable -> L90
        goto L78
    L79:
        Uri r7 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(this.numberStr));     // Catch: Exception -> L96 Throwable -> L90
        QueryHandler r115 = this.queryHandler;     // Catch: Exception -> L96 Throwable -> L90
        if (r115 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("queryHandler");     // Catch: Exception -> L96 Throwable -> L90
        QueryHandler r4 = null;
    L83:
        int r8 = this.IS_IN_CONTACT_TOKEN;     // Catch: Exception -> L96 Throwable -> L90
        if (isWhiteList() == false) goto L86;
        String[] r12 = this.CONTACT_PROJECTION_WHITE;     // Catch: Exception -> L96 Throwable -> L90
    L87:
        r4.startQuery(r8, null, r7, r12, null, null, null);     // Catch: Exception -> L96 Throwable -> L90
        goto L105
    L86:
        r12 = this.CONTACT_PROJECTION_BLACK;     // Catch: Exception -> L96 Throwable -> L90
        goto L87
    L82:
        r4 = r115;
    L105:
        r14.close();     // Catch: Exception -> L97
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        setwindow(true);
        TransitionAnimHelper.overrideExitAnim(this, TransitionAnimStyle.Modal);
    }
}
