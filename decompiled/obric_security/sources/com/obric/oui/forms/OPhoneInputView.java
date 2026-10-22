package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.datausage.DataUsageDetailActivity;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OPhoneInputView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0006\u0010!\u001a\u00020\fJ\n\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0007H\u0016J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\fJ\b\u0010/\u001a\u00020\fH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "areaCode", "", "enableArrowIcon", "", "isChinesePhoneNumber", "isTextFormating", "originLimitCount", "showAreaCode", "vAreaCodeContainer", "Landroid/widget/LinearLayout;", "vAreaCodeText", "Landroid/widget/TextView;", "vArrowIcon", "Landroid/widget/ImageView;", "doAfterTextStateChange", "", "editable", "Landroid/text/Editable;", "formatChinesePhoneNumber", "getAreaCode", "getConstraintLength", "s", "", "getContentViewRes", "getEnableArrowIcon", "getText", "moveCursorToEnd", "resetFromChinesePhoneNumber", "setAreaClickListener", "listener", "Landroid/view/View$OnClickListener;", "setAreaCode", "setEnableArrowIcon", "enableArrow", "setLimitCount", DataUsageDetailActivity.INTENT_EXTRA_LIMIT, "setShowAreaCode", InvokeHistoryActivity.PREF_SHOW, "shouldApplyChinaMainlandConstraint", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPhoneInputView extends OInputView {
    private static final String CHINA_AREA_CODE = "+86";
    private static final int CHINA_COUNT_LIMIT = 11;
    public static final Companion Companion = null;
    private String areaCode;
    private boolean enableArrowIcon;
    private boolean isChinesePhoneNumber;
    private boolean isTextFormating;
    private int originLimitCount;
    private boolean showAreaCode;
    private final LinearLayout vAreaCodeContainer;
    private final TextView vAreaCodeText;
    private final ImageView vArrowIcon;

    /* JADX INFO: compiled from: OPhoneInputView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView$Companion;", "", "()V", "CHINA_AREA_CODE", "", "CHINA_COUNT_LIMIT", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OPhoneInputView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPhoneInputView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPhoneInputView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OPhoneInputView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.originLimitCount = -1;
        this.enableArrowIcon = true;
        this.originLimitCount = getLimitCount();
        View r0 = findViewById(R.id.o_input_area_code_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.o_input_area_code_container)");
        this.vAreaCodeContainer = (LinearLayout) r0;
        View r1 = findViewById(R.id.o_input_area_code_text);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.o_input_area_code_text)");
        this.vAreaCodeText = (TextView) r1;
        View r2 = findViewById(R.id.o_input_area_code_arrow);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_area_code_arrow)");
        this.vArrowIcon = (ImageView) r2;
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, R.styleable.OPhoneInputView, r5, 0);
        setShowAreaCode(r6.getBoolean(R.styleable.OPhoneInputView_oui_showAreaCode, false));
        setAreaCode(r6.getString(R.styleable.OPhoneInputView_oui_areaCode));
        r6.recycle();
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return R.layout.o_phone_input_view_layout;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.isChinesePhoneNumber == false) goto L13;
        Editable r7 = getVInput().getText();
        if (r7 == null) goto L14;
        String r1 = r7.toString();
        if (r1 != null) goto L11;
        return null;
    L11:
        return StringsKt.replace$default(r1, " ", "", false, 4, null);
    L14:
        return null;
    L13:
        return super.getText();
    }

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r2) {
        this.originLimitCount = r2;
        if (this.isChinesePhoneNumber == false) goto L5;
        r2 = 11;
    L5:
        super.setLimitCount(r2);
    }

    public final void setShowAreaCode(boolean r3) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.showAreaCode != r3) goto L8;
        return;
    L8:
        this.showAreaCode = r3;
        ViewExtensionsKt.setVisibility(this.vAreaCodeContainer, r3);
        doAfterTextStateChange(getVInput().getText());
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L10;
        String r0 = this.areaCode;
        if (r0 != null) goto L6;
    L8:
        this.areaCode = r5;
        this.vAreaCodeText.setText(r5);
        doAfterTextStateChange(getVInput().getText());
        moveCursorToEnd();
        return;
    L6:
        if (StringsKt.equals$default(r0, r5, false, 2, null) == false) goto L8;
        return;
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    public final void setAreaClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.vAreaCodeContainer.setOnClickListener(r2);
    }

    @Override // com.obric.oui.forms.OInputView
    public int getConstraintLength(CharSequence r3) {
        int r0 = 0;
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (this.isChinesePhoneNumber == false) goto L8;
    L11:
        int r2 = 0;
    L13:
        if (r0 >= r3.length()) goto L22;
        if (Character.isDigit(r3.charAt(r0)) == false) goto L17;
        r2 = r2 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L22:
        return r2;
    L8:
        if (shouldApplyChinaMainlandConstraint() == true) goto L11;
        return r3.length();
    }

    private final boolean shouldApplyChinaMainlandConstraint() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.showAreaCode == false) goto L13;
        String r2 = this.areaCode;
        if (r2 != null) goto L9;
        String r3 = null;
    L11:
        if (Intrinsics.areEqual(r3, CHINA_AREA_CODE) == false) goto L13;
        return true;
    L9:
        r3 = StringsKt.trim(r2).toString();
        goto L11
    }

    @Override // com.obric.oui.forms.OInputView
    public void doAfterTextStateChange(Editable r2) {
        if (shouldApplyChinaMainlandConstraint() == false) goto L12;
        setLimitCountValue(11);
        if (r2 != null) goto L7;
        r2 = getVInput().getText();
    L7:
        if (r2 == null) goto L10;
        formatChinesePhoneNumber(r2);
    L10:
        this.isChinesePhoneNumber = true;
        this.originLimitCount = getLimitCount();
    L19:
        Editable r3 = getVInput().getText();
        if (r3 != null) goto L22;
        String r4 = null;
    L23:
        updateLimitIndicator(r4);
        return;
    L22:
        r4 = r3.toString();
        goto L23
    L12:
        if (this.isChinesePhoneNumber == false) goto L19;
        if (r2 != null) goto L15;
        r2 = getVInput().getText();
    L15:
        if (r2 == null) goto L18;
        resetFromChinesePhoneNumber(r2);
    L18:
        this.isChinesePhoneNumber = false;
        setLimitCountValue(this.originLimitCount);
        goto L19
    }

    private final void moveCursorToEnd() {
        Editable r0 = getVInput().getText();
        if (r0 != null) goto L5;
        int r1 = 0;
    L11:
        getVInput().setSelection(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        L.w(OInputView.TAG, Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L5:
        r1 = r0.length();
        goto L11
    }

    private final void formatChinesePhoneNumber(Editable r11) {
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r11.toString();
        String r1 = r0;
        StringBuilder r2 = new StringBuilder();
        int r3 = r1.length();
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L11;
        char r6 = r1.charAt(r5);
        if (Character.isDigit(r6) == false) goto L10;
        r2.append(r6);
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        String r4 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r7 = new StringBuilder();
        String r8 = r4;
        int r9 = 0;
        int r10 = 0;
    L13:
        if (r9 >= r8.length()) goto L22;
        int r12 = r10 + 1;
        r7.append(r8.charAt(r9));
        if (r10 == 2) goto L19;
        if (r10 == 6) goto L19;
    L21:
        r9 = r9 + 1;
        r10 = r12;
    L19:
        if (r10 == StringsKt.getLastIndex(r8)) goto L21;
        r7.append(' ');
        goto L21
    L22:
        String r13 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        if (Intrinsics.areEqual(r13, r0) == false) goto L25;
        return;
    L25:
        this.isTextFormating = true;
        r11.replace(0, r11.length(), r13);
        if (this.isChinesePhoneNumber == true) goto L48;
    L46:
        this.isTextFormating = false;
        return;
    L48:
        Iterator r14 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L44
    L29:
        if (r14.hasNext() == false) goto L46;
        int r15 = ((Number) r14.next()).intValue();     // Catch: Exception -> L44
        int r16 = r15 + 1;     // Catch: Exception -> L44
        if (r0.length() < r15) goto L29;
        if (r13.length() < r15) goto L29;
        if (r0.charAt(r15) == ' ') goto L29;
        if (r13.charAt(r15) != ' ') goto L29;
        if (getVInput().getSelectionStart() != r16) goto L29;
        if (getVInput().getSelectionEnd() != r16) goto L29;
        getVInput().setSelection(r16 + 1);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        L.w(OInputView.TAG, Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L46
    }

    private final void resetFromChinesePhoneNumber(Editable r8) {
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r8.toString();
        String r1 = StringsKt.replace$default(r0, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r1, r0) == false) goto L8;
        return;
    L8:
        this.isTextFormating = true;
        r8.replace(0, r8.length(), r1);
        this.isTextFormating = false;
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.enableArrowIcon != r2) goto L5;
        return;
    L5:
        this.enableArrowIcon = r2;
        ImageView r1 = this.vArrowIcon;
        if (r1 == null) goto L12;
        if (r2 == false) goto L9;
        float r3 = 1.0f;
    L10:
        r1.setAlpha(r3);
        return;
    L9:
        r3 = 0.3f;
        goto L10
    }

    public final boolean getEnableArrowIcon() {
        return this.enableArrowIcon;
    }
}
