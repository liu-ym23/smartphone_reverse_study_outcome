package com.obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.R;
import com.android.vcard.VCardConstants;
import com.obric.oui.checkbox.OCheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: compiled from: AILabTestItem.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001kB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010`\u001a\u00020\fJ\u0010\u0010a\u001a\u00020b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010c\u001a\u00020bJ\u0006\u0010d\u001a\u00020eJ\u000e\u0010f\u001a\u00020b2\u0006\u0010g\u001a\u00020eJ\u0016\u0010h\u001a\u00020b2\u0006\u0010i\u001a\u00020\t2\u0006\u00105\u001a\u00020\fJ\u0010\u0010Y\u001a\u00020b2\u0006\u0010W\u001a\u00020\fH\u0007J\u000e\u0010\\\u001a\u00020b2\u0006\u0010Z\u001a\u00020\fJ\u000e\u0010j\u001a\u00020b2\u0006\u0010D\u001a\u00020\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001c\u0010>\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\u001c\u0010A\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R\u001a\u0010D\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR\u001c\u0010T\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010K\"\u0004\bV\u0010MR\u001c\u0010W\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00108\"\u0004\bY\u0010:R\u001c\u0010Z\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00108\"\u0004\b\\\u0010:R\u001a\u0010]\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000e\"\u0004\b_\u0010\u0010¨\u0006l"}, d2 = {"Lcom/obric/widget/AILabTestItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "answer1", "", "getAnswer1", "()Ljava/lang/String;", "setAnswer1", "(Ljava/lang/String;)V", "answer2", "getAnswer2", "setAnswer2", "answer3", "getAnswer3", "setAnswer3", "answer4", "getAnswer4", "setAnswer4", "checkBox1", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox1", "()Lcom/obric/oui/checkbox/OCheckBox;", "setCheckBox1", "(Lcom/obric/oui/checkbox/OCheckBox;)V", "checkBox2", "getCheckBox2", "setCheckBox2", "checkBox3", "getCheckBox3", "setCheckBox3", "checkBox4", "getCheckBox4", "setCheckBox4", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "setDivider", "(Landroid/view/View;)V", "itemClickCallback", "Lcom/obric/widget/AILabTestItem$ItemClickCallback;", "getItemClickCallback", "()Lcom/obric/widget/AILabTestItem$ItemClickCallback;", "setItemClickCallback", "(Lcom/obric/widget/AILabTestItem$ItemClickCallback;)V", "optionText1", "Landroid/widget/TextView;", "getOptionText1", "()Landroid/widget/TextView;", "setOptionText1", "(Landroid/widget/TextView;)V", "optionText2", "getOptionText2", "setOptionText2", "optionText3", "getOptionText3", "setOptionText3", "optionText4", "getOptionText4", "setOptionText4", "optionType", "getOptionType", "()I", "setOptionType", "(I)V", "optionsLayout1", "getOptionsLayout1", "()Landroid/widget/LinearLayout;", "setOptionsLayout1", "(Landroid/widget/LinearLayout;)V", "optionsLayout2", "getOptionsLayout2", "setOptionsLayout2", "optionsLayout3", "getOptionsLayout3", "setOptionsLayout3", "optionsLayout4", "getOptionsLayout4", "setOptionsLayout4", "questionCode", "getQuestionCode", "setQuestionCode", "questionTitle", "getQuestionTitle", "setQuestionTitle", "testRightAnswers", "getTestRightAnswers", "setTestRightAnswers", "getAnswers", "init", "", "initCheckBoxListener", "isAnswerRight", "", "setDividerVisible", "visible", "setOptionText", "index", "setQuestionType", "ItemClickCallback", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AILabTestItem extends LinearLayout {
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private OCheckBox checkBox1;
    private OCheckBox checkBox2;
    private OCheckBox checkBox3;
    private OCheckBox checkBox4;
    private View divider;
    private ItemClickCallback itemClickCallback;
    private TextView optionText1;
    private TextView optionText2;
    private TextView optionText3;
    private TextView optionText4;
    private int optionType;
    private LinearLayout optionsLayout1;
    private LinearLayout optionsLayout2;
    private LinearLayout optionsLayout3;
    private LinearLayout optionsLayout4;
    private TextView questionCode;
    private TextView questionTitle;
    private String testRightAnswers;

    /* JADX INFO: compiled from: AILabTestItem.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/widget/AILabTestItem$ItemClickCallback;", "", "onItemClick", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface ItemClickCallback {
        void onItemClick();
    }

    /* JADX INFO: renamed from: $r8$lambda$bbHnhLy3-Y3L5VOyTKidJgHrqc4, reason: not valid java name */
    public static /* synthetic */ void m1475$r8$lambda$bbHnhLy3Y3L5VOyTKidJgHrqc4(AILabTestItem r0, OCheckBox r1, boolean r2) {
        initCheckBoxListener$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nkEl9BELuaDX25AGcuiBomyWCsc(AILabTestItem r0, OCheckBox r1, boolean r2) {
        initCheckBoxListener$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$wGvNscecWVXcFUEZqNZWXzl06cQ(AILabTestItem r0, OCheckBox r1, boolean r2) {
        initCheckBoxListener$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$yQtVV8j1d5F5FE9xDqytJo2EuSQ(AILabTestItem r0, OCheckBox r1, boolean r2) {
        initCheckBoxListener$lambda$3(r0, r1, r2);
    }

    public final TextView getQuestionCode() {
        return this.questionCode;
    }

    public final void setQuestionCode(TextView r1) {
        this.questionCode = r1;
    }

    public final TextView getQuestionTitle() {
        return this.questionTitle;
    }

    public final void setQuestionTitle(TextView r1) {
        this.questionTitle = r1;
    }

    public final TextView getOptionText1() {
        return this.optionText1;
    }

    public final void setOptionText1(TextView r1) {
        this.optionText1 = r1;
    }

    public final TextView getOptionText2() {
        return this.optionText2;
    }

    public final void setOptionText2(TextView r1) {
        this.optionText2 = r1;
    }

    public final TextView getOptionText3() {
        return this.optionText3;
    }

    public final void setOptionText3(TextView r1) {
        this.optionText3 = r1;
    }

    public final TextView getOptionText4() {
        return this.optionText4;
    }

    public final void setOptionText4(TextView r1) {
        this.optionText4 = r1;
    }

    public final OCheckBox getCheckBox1() {
        return this.checkBox1;
    }

    public final void setCheckBox1(OCheckBox r1) {
        this.checkBox1 = r1;
    }

    public final OCheckBox getCheckBox2() {
        return this.checkBox2;
    }

    public final void setCheckBox2(OCheckBox r1) {
        this.checkBox2 = r1;
    }

    public final OCheckBox getCheckBox3() {
        return this.checkBox3;
    }

    public final void setCheckBox3(OCheckBox r1) {
        this.checkBox3 = r1;
    }

    public final OCheckBox getCheckBox4() {
        return this.checkBox4;
    }

    public final void setCheckBox4(OCheckBox r1) {
        this.checkBox4 = r1;
    }

    public final LinearLayout getOptionsLayout1() {
        return this.optionsLayout1;
    }

    public final void setOptionsLayout1(LinearLayout r1) {
        this.optionsLayout1 = r1;
    }

    public final LinearLayout getOptionsLayout2() {
        return this.optionsLayout2;
    }

    public final void setOptionsLayout2(LinearLayout r1) {
        this.optionsLayout2 = r1;
    }

    public final LinearLayout getOptionsLayout3() {
        return this.optionsLayout3;
    }

    public final void setOptionsLayout3(LinearLayout r1) {
        this.optionsLayout3 = r1;
    }

    public final LinearLayout getOptionsLayout4() {
        return this.optionsLayout4;
    }

    public final void setOptionsLayout4(LinearLayout r1) {
        this.optionsLayout4 = r1;
    }

    public final View getDivider() {
        return this.divider;
    }

    public final void setDivider(View r1) {
        this.divider = r1;
    }

    public final int getOptionType() {
        return this.optionType;
    }

    public final void setOptionType(int r1) {
        this.optionType = r1;
    }

    public final String getAnswer1() {
        return this.answer1;
    }

    public final void setAnswer1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.answer1 = r2;
    }

    public final String getAnswer2() {
        return this.answer2;
    }

    public final void setAnswer2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.answer2 = r2;
    }

    public final String getAnswer3() {
        return this.answer3;
    }

    public final void setAnswer3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.answer3 = r2;
    }

    public final String getAnswer4() {
        return this.answer4;
    }

    public final void setAnswer4(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.answer4 = r2;
    }

    public final String getTestRightAnswers() {
        return this.testRightAnswers;
    }

    public final void setTestRightAnswers(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.testRightAnswers = r2;
    }

    public final ItemClickCallback getItemClickCallback() {
        return this.itemClickCallback;
    }

    public final void setItemClickCallback(ItemClickCallback r1) {
        this.itemClickCallback = r1;
    }

    public AILabTestItem(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.answer1 = "";
        this.answer2 = "";
        this.answer3 = "";
        this.answer4 = "";
        this.testRightAnswers = "";
        init(r2);
    }

    public AILabTestItem(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.answer1 = "";
        this.answer2 = "";
        this.answer3 = "";
        this.answer4 = "";
        this.testRightAnswers = "";
    }

    public AILabTestItem(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.answer1 = "";
        this.answer2 = "";
        this.answer3 = "";
        this.answer4 = "";
        this.testRightAnswers = "";
    }

    private final void init(Context r4) {
        LayoutInflater.from(r4).inflate(R.layout.ailab_test_item, this, true);
        this.questionCode = (TextView) findViewById(R.id.question_code);
        this.questionTitle = (TextView) findViewById(R.id.question_title);
        this.optionText1 = (TextView) findViewById(R.id.option_text_1);
        this.optionText2 = (TextView) findViewById(R.id.option_text_2);
        this.optionText3 = (TextView) findViewById(R.id.option_text_3);
        this.optionText4 = (TextView) findViewById(R.id.option_text_4);
        this.checkBox1 = (OCheckBox) findViewById(R.id.option_1);
        this.checkBox2 = (OCheckBox) findViewById(R.id.option_2);
        this.checkBox3 = (OCheckBox) findViewById(R.id.option_3);
        this.checkBox4 = (OCheckBox) findViewById(R.id.option_4);
        this.optionsLayout1 = (LinearLayout) findViewById(R.id.option_layout_1);
        this.optionsLayout2 = (LinearLayout) findViewById(R.id.option_layout_2);
        this.optionsLayout3 = (LinearLayout) findViewById(R.id.option_layout_3);
        this.optionsLayout4 = (LinearLayout) findViewById(R.id.option_layout_4);
        this.divider = findViewById(R.id.divider);
        initCheckBoxListener();
    }

    public final void setQuestionCode(String r3) {
        Intrinsics.checkNotNullParameter(r3, "questionCode");
        if (r3.length() != 1) goto L5;
        r3 = "0" + r3;
    L5:
        TextView r0 = this.questionCode;
        if (r0 == null) goto L14;
        StringBuilder r4 = new StringBuilder().append(r3).append(BytedanceJustifyTextView.TWO_BLANK);
        if (this.optionType != 0) goto L11;
        String r2 = "单选";
    L12:
        r0.setText(r4.append(r2).toString());
        return;
    L11:
        r2 = "多选";
        goto L12
    }

    public final void setQuestionTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "questionTitle");
        TextView r1 = this.questionTitle;
        if (r1 == null) goto L7;
        r1.setText(r2);
        return;
    }

    public final void setOptionText(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "optionText1");
        if (r3 != 0) goto L5;
        TextView r5 = this.optionText1;
        if (r5 == null) goto L39;
        r5.setText(r4);
    L39:
        LinearLayout r2 = this.optionsLayout1;
        if (r2 == null) goto L51;
        r2.setVisibility(0);
        return;
    L51:
        return;
    L5:
        if (r3 != 1) goto L7;
        TextView r6 = this.optionText2;
        if (r6 == null) goto L31;
        r6.setText(r4);
    L31:
        LinearLayout r7 = this.optionsLayout2;
        if (r7 == null) goto L50;
        r7.setVisibility(0);
        return;
    L50:
        return;
    L7:
        if (r3 != 2) goto L9;
        TextView r8 = this.optionText3;
        if (r8 == null) goto L23;
        r8.setText(r4);
    L23:
        LinearLayout r9 = this.optionsLayout3;
        if (r9 == null) goto L49;
        r9.setVisibility(0);
        return;
    L49:
        return;
    L9:
        if (r3 != 3) goto L47;
        TextView r10 = this.optionText4;
        if (r10 == null) goto L15;
        r10.setText(r4);
    L15:
        LinearLayout r11 = this.optionsLayout4;
        if (r11 == null) goto L48;
        r11.setVisibility(0);
        return;
    L48:
        return;
    }

    public final void setQuestionType(int r1) {
        this.optionType = r1;
    }

    public final boolean isAnswerRight() {
        return Intrinsics.areEqual(getAnswers(), this.testRightAnswers);
    }

    public final String getAnswers() {
        return this.answer1 + this.answer2 + this.answer3 + this.answer4;
    }

    public final void initCheckBoxListener() {
        OCheckBox r0 = this.checkBox1;
        if (r0 == null) goto L5;
        r0.setOnCheckedChangeListener(new AILabTestItem$$ExternalSyntheticLambda0(this));
    L5:
        OCheckBox r1 = this.checkBox2;
        if (r1 == null) goto L8;
        r1.setOnCheckedChangeListener(new AILabTestItem$$ExternalSyntheticLambda1(this));
    L8:
        OCheckBox r2 = this.checkBox3;
        if (r2 == null) goto L11;
        r2.setOnCheckedChangeListener(new AILabTestItem$$ExternalSyntheticLambda2(this));
    L11:
        OCheckBox r3 = this.checkBox4;
        if (r3 == null) goto L15;
        r3.setOnCheckedChangeListener(new AILabTestItem$$ExternalSyntheticLambda3(this));
        return;
    }

    private static final void initCheckBoxListener$lambda$0(AILabTestItem r2, OCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
        if (r4 == true) goto L5;
    L19:
        if (r4 == false) goto L21;
        r2.answer1 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    L22:
        ItemClickCallback r5 = r2.itemClickCallback;
        if (r5 == null) goto L26;
        r5.onItemClick();
        return;
    L26:
        return;
    L21:
        r2.answer1 = "";
        goto L22
    L5:
        if (r2.optionType != 0) goto L19;
        OCheckBox r6 = r2.checkBox2;
        if (r6 == null) goto L10;
        r6.setChecked(false);
    L10:
        OCheckBox r7 = r2.checkBox3;
        if (r7 == null) goto L14;
        r7.setChecked(false);
    L14:
        OCheckBox r8 = r2.checkBox4;
        if (r8 == null) goto L18;
        r8.setChecked(false);
    L18:
        r2.answer1 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        r2.answer2 = "";
        r2.answer3 = "";
        r2.answer4 = "";
        goto L22
    }

    private static final void initCheckBoxListener$lambda$1(AILabTestItem r2, OCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
        if (r4 == true) goto L5;
    L19:
        if (r4 == false) goto L21;
        r2.answer2 = VCardConstants.PARAM_ENCODING_B;
    L22:
        ItemClickCallback r5 = r2.itemClickCallback;
        if (r5 == null) goto L26;
        r5.onItemClick();
        return;
    L26:
        return;
    L21:
        r2.answer2 = "";
        goto L22
    L5:
        if (r2.optionType != 0) goto L19;
        OCheckBox r6 = r2.checkBox1;
        if (r6 == null) goto L10;
        r6.setChecked(false);
    L10:
        OCheckBox r7 = r2.checkBox3;
        if (r7 == null) goto L14;
        r7.setChecked(false);
    L14:
        OCheckBox r8 = r2.checkBox4;
        if (r8 == null) goto L18;
        r8.setChecked(false);
    L18:
        r2.answer2 = VCardConstants.PARAM_ENCODING_B;
        r2.answer1 = "";
        r2.answer3 = "";
        r2.answer4 = "";
        goto L22
    }

    private static final void initCheckBoxListener$lambda$2(AILabTestItem r2, OCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
        if (r4 == true) goto L5;
    L19:
        if (r4 == false) goto L21;
        r2.answer3 = "C";
    L22:
        ItemClickCallback r5 = r2.itemClickCallback;
        if (r5 == null) goto L26;
        r5.onItemClick();
        return;
    L26:
        return;
    L21:
        r2.answer3 = "";
        goto L22
    L5:
        if (r2.optionType != 0) goto L19;
        OCheckBox r6 = r2.checkBox1;
        if (r6 == null) goto L10;
        r6.setChecked(false);
    L10:
        OCheckBox r7 = r2.checkBox2;
        if (r7 == null) goto L14;
        r7.setChecked(false);
    L14:
        OCheckBox r8 = r2.checkBox4;
        if (r8 == null) goto L18;
        r8.setChecked(false);
    L18:
        r2.answer3 = "C";
        r2.answer1 = "";
        r2.answer2 = "";
        r2.answer4 = "";
        goto L22
    }

    private static final void initCheckBoxListener$lambda$3(AILabTestItem r2, OCheckBox r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 0>");
        if (r4 == true) goto L5;
    L19:
        if (r4 == false) goto L21;
        r2.answer4 = "D";
    L22:
        ItemClickCallback r5 = r2.itemClickCallback;
        if (r5 == null) goto L26;
        r5.onItemClick();
        return;
    L26:
        return;
    L21:
        r2.answer4 = "";
        goto L22
    L5:
        if (r2.optionType != 0) goto L19;
        OCheckBox r6 = r2.checkBox1;
        if (r6 == null) goto L10;
        r6.setChecked(false);
    L10:
        OCheckBox r7 = r2.checkBox2;
        if (r7 == null) goto L14;
        r7.setChecked(false);
    L14:
        OCheckBox r8 = r2.checkBox3;
        if (r8 == null) goto L18;
        r8.setChecked(false);
    L18:
        r2.answer4 = "D";
        r2.answer1 = "";
        r2.answer2 = "";
        r2.answer3 = "";
        goto L22
    }

    public final void setDividerVisible(boolean r1) {
        View r0 = this.divider;
        if (r0 == null) goto L10;
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }
}
