package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedanceos.security.invokeHistory.InvokeHistoryActivity;
import com.obric.common.oui.R;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: OPhoneInputLayout.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\fJ\n\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0007H\u0016J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "areaCode", "", "enableArrowIcon", "", "isChinesePhoneNumber", "isTextFormating", "showAreaCode", "vAreaCodeContainer", "Landroid/widget/LinearLayout;", "vAreaCodeText", "Landroid/widget/TextView;", "vArrowIcon", "Landroid/widget/ImageView;", "doAfterTextStateChange", "", "editable", "Landroid/text/Editable;", "formatChinesePhoneNumber", "getAreaCode", "getConstraintLength", "s", "", "getEnableArrowIcon", "getText", "moveCursorToEnd", "resetFromChinesePhoneNumber", "setAreaClickListener", "listener", "Landroid/view/View$OnClickListener;", "setAreaCode", "setCustomStart", "resId", "setDefaultCustomStart", "defaultStart", "setEnableArrowIcon", "enableArrow", "setType", "type", "shouldApplyChinaMainlandConstraint", "showCustomStart", InvokeHistoryActivity.PREF_SHOW, "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPhoneInputLayout extends OInputLayout {
    private static final String CHINA_AREA_CODE = "+86";
    public static final Companion Companion = null;
    private String areaCode;
    private boolean enableArrowIcon;
    private boolean isChinesePhoneNumber;
    private boolean isTextFormating;
    private boolean showAreaCode;
    private final LinearLayout vAreaCodeContainer;
    private final TextView vAreaCodeText;
    private final ImageView vArrowIcon;

    /* JADX INFO: compiled from: OPhoneInputLayout.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout$Companion;", "", "()V", "CHINA_AREA_CODE", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OPhoneInputLayout(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OPhoneInputLayout(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OPhoneInputLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OPhoneInputLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.enableArrowIcon = true;
        setType(0);
        setCustomStart(R.layout.o_input_custom_start_area_code);
        showCustomStart(true);
        setInputType(3);
        View r0 = findViewById(R.id.o_input_area_code_container);
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.o_input_area_code_container)");
        this.vAreaCodeContainer = (LinearLayout) r0;
        View r1 = findViewById(R.id.o_input_area_code_text);
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.o_input_area_code_text)");
        this.vAreaCodeText = (TextView) r1;
        View r2 = findViewById(R.id.o_input_area_code_arrow);
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_area_code_arrow)");
        this.vArrowIcon = (ImageView) r2;
        TypedArray r7 = r4.getTheme().obtainStyledAttributes(r5, R.styleable.OPhoneInputLayout, r6, 0);
        setAreaCode(r7.getString(R.styleable.OPhoneInputLayout_oinput_areaCode));
        r7.recycle();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r1) {
        if (r1 == 0) goto L4;
        return;
    L4:
        super.setType(r1);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r1) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r1) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void showCustomStart(boolean r2) {
        if (this.showAreaCode != r2) goto L5;
        return;
    L5:
        this.showAreaCode = r2;
        super.showCustomStart(r2);
        doAfterTextStateChange(getVInput().getText());
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.isChinesePhoneNumber == false) goto L14;
        Editable r7 = getVInput().getText();
        String r0 = null;
        if (r7 == null) goto L12;
        String r1 = r7.toString();
        if (r1 == null) goto L12;
        r0 = StringsKt.replace$default(r1, " ", "", false, 4, null);
    L12:
        return r0;
    L14:
        return super.getText();
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

    @Override // com.obric.oui.forms.OInputLayout
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

    @Override // com.obric.oui.forms.OInputLayout
    public void doAfterTextStateChange(Editable r2) {
        if (shouldApplyChinaMainlandConstraint() == false) goto L11;
        if (r2 != null) goto L6;
        r2 = getVInput().getText();
    L6:
        if (r2 == null) goto L9;
        formatChinesePhoneNumber(r2);
    L9:
        this.isChinesePhoneNumber = true;
        return;
    L11:
        if (this.isChinesePhoneNumber == false) goto L20;
        if (r2 != null) goto L14;
        r2 = getVInput().getText();
    L14:
        if (r2 == null) goto L17;
        resetFromChinesePhoneNumber(r2);
    L17:
        this.isChinesePhoneNumber = false;
        return;
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
        L.w(OInputLayout.TAG, Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
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
        L.w(OInputLayout.TAG, Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
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
