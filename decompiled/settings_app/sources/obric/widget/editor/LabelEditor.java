package obric.widget.editor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import obric.widget.QuickDeleteEditText;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class LabelEditor extends AbsEditor {
    private final int[] mGrayIconDrawables;
    private EditorLeftLabelWidget mLeftWidget;
    private TextWatcher mLineChangeWatcher;
    private EditorRightIconWidget mRightWidget;

    /* JADX INFO: renamed from: obric.widget.editor.LabelEditor$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$obric$widget$editor$LabelEditor$LeftIconContainerBgStyle = null;

        static {
            int[] r0 = new int[LeftIconContainerBgStyle.values().length];
            $SwitchMap$obric$widget$editor$LabelEditor$LeftIconContainerBgStyle = r0;
            r0[LeftIconContainerBgStyle.GRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public static final enum LeftIconContainerBgStyle extends Enum<LeftIconContainerBgStyle> {
        private static final /* synthetic */ LeftIconContainerBgStyle[] $VALUES = null;
        public static final LeftIconContainerBgStyle GRAY = null;

        private LeftIconContainerBgStyle(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static LeftIconContainerBgStyle valueOf(String name) {
            return (LeftIconContainerBgStyle) Enum.valueOf(LeftIconContainerBgStyle.class, name);
        }

        public static LeftIconContainerBgStyle[] values() {
            return (LeftIconContainerBgStyle[]) $VALUES.clone();
        }

        static {
            LeftIconContainerBgStyle r0 = new LeftIconContainerBgStyle("GRAY", 0);
            GRAY = r0;
            $VALUES = new LeftIconContainerBgStyle[]{r0};
        }
    }

    static /* synthetic */ void access$000(LabelEditor r0, boolean r1) {
        r0.editorLineCountChange(r1);
    }

    public LabelEditor(Context context) {
        this(context, null);
    }

    public LabelEditor(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mGrayIconDrawables = new int[]{R.drawable.editor_left_icon_bg_single, R.drawable.editor_left_icon_bg_top, R.drawable.editor_left_icon_bg_middle, R.drawable.editor_left_icon_bg_bottom};
        this.mLineChangeWatcher = new AnonymousClass1(this);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.LabelEditor);
        setLeftIcon(r4.getDrawable(R.styleable.LabelEditor_leftIcon));
        setLeftLabel(r4.getString(R.styleable.LabelEditor_leftLabel));
        setShowLeftLabelArrow(r4.getBoolean(R.styleable.LabelEditor_showLeftArrow, false));
        Drawable r5 = r4.getDrawable(R.styleable.LabelEditor_rightIcon);
        setRightIcon(r5);
        boolean r6 = r4.getBoolean(R.styleable.LabelEditor_showRightDivide, false);
        if (r5 == null) goto L5;
        setShowRightDevide(r6);
    L5:
        setRightLabel(r4.getString(R.styleable.LabelEditor_rightLabel));
        r4.recycle();
        this.mEditor.addTextChangedListener(this.mLineChangeWatcher);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mEditor.removeTextChangedListener(this.mLineChangeWatcher);
    }

    public void setShowLeftWidget(boolean show) {
        EditorLeftLabelWidget r0 = this.mLeftWidget;
        if (show == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setOnLeftLabelClickListener(View.OnClickListener listener) {
        this.mLeftWidget.setOnLabelClickListener(listener);
    }

    public void setOnLeftIconClickListener(View.OnClickListener listener) {
        this.mLeftWidget.setOnIconClickListener(listener);
    }

    public void setLeftIcon(Drawable d) {
        if (d == null) goto L4;
        setContainerLeftPadding(0);
    L5:
        this.mLeftWidget.setIconDrawable(d);
        return;
    L4:
        resetLeftIconPadding();
        goto L5
    }

    private void resetLeftIconPadding() {
        setContainerLeftPadding(getResources().getDimensionPixelOffset(R.dimen.editor_horizontal_padding));
    }

    public void setLeftIconResource(int resId) {
        setContainerLeftPadding(0);
        this.mLeftWidget.setIconResource(resId);
    }

    public void setLeftIconContainerBgStyle(LeftIconContainerBgStyle style) {
        if (AnonymousClass2.$SwitchMap$obric$widget$editor$LabelEditor$LeftIconContainerBgStyle[style.ordinal()] == 1) goto L5;
        int r3 = -1;
    L6:
        if (r3 <= 0) goto L9;
        this.mLeftWidget.setIconContainerBackground(r3);
        return;
    L9:
        return;
    L5:
        r3 = this.mGrayIconDrawables[this.mBackgroundStyle - 1];
        goto L6
    }

    public void setLeftLabelClickListener(View.OnClickListener listener) {
        this.mLeftWidget.setOnLabelClickListener(listener);
    }

    public void setLeftWidgetExpandView(View view) {
        this.mLeftWidget.setRightExpandView(view);
    }

    public void setLeftLabel(CharSequence s) {
        this.mLeftWidget.setText(s);
    }

    public void setLeftLabel(int resId) {
        this.mLeftWidget.setText(resId);
    }

    public void setShowLeftLabelArrow(boolean show) {
        this.mLeftWidget.setArrowVisible(show);
    }

    public void setLeftLabelWidth(int width) {
        this.mLeftWidget.setLabelWidth(width);
    }

    public int getLeftLabelWidth() {
        return (int) (((double) this.mLeftWidget.getTextWidth()) + 0.5d);
    }

    public void setLeftWidgetBackgroundResource(int id) {
        setContainerLeftPadding(0);
        this.mLeftWidget.setBackgroundResource(id);
    }

    public void setLeftLabelRightMargin(int marginRight) {
        this.mLeftWidget.setLabelRightMargin(marginRight);
    }

    public void setLeftLabelLeftMargin(int marginLeft) {
        this.mLeftWidget.setLabelLeftMargin(marginLeft);
    }

    public void setLeftLabelGravity(int gravity) {
        this.mEditor.removeTextChangedListener(this.mLineChangeWatcher);
        this.mLeftWidget.setLabelGravity(gravity);
    }

    public View getLeftWidgetIconView() {
        return this.mLeftWidget.getIconView();
    }

    public void setShowRightWidget(boolean show) {
        EditorRightIconWidget r0 = this.mRightWidget;
        if (show == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public void setRightLabel(CharSequence s) {
        this.mRightWidget.setText(s);
    }

    public void setRightLabel(int resId) {
        this.mRightWidget.setText(resId);
    }

    public void setRightIcon(Drawable d) {
        this.mRightWidget.setIconDrawable(d);
    }

    public void setRightIconResource(int resId) {
        this.mRightWidget.setIconResource(resId);
    }

    public void setRightIconContentDescription(String description) {
        this.mRightWidget.setIconContentDescription(description);
    }

    public void setOnRightWidgetClickListener(View.OnClickListener listener) {
        this.mRightWidget.setOnClickListener(listener);
    }

    public void setRightWidgetWidth(int width) {
        this.mRightWidget.setWidth(width);
    }

    public void setShowRightDevide(boolean showDevide) {
        if (showDevide == false) goto L4;
        setContainerRightPadding(0);
    L4:
        this.mRightWidget.setDevideVisible(showDevide);
    }

    public void setShowLeftDivider(boolean showLeftDivider) {
        this.mLeftWidget.setShowDivider(showLeftDivider);
    }

    public void addSpecialEditorRightExpandView(View view) {
        if ((this.mEditor instanceof QuickDeleteEditText) == false) goto L8;
        ViewGroup r1 = (ViewGroup) this.mMidContainer.findViewById(R.id.rightExpandView);
        r1.removeAllViews();
        if (view == null) goto L9;
        r1.addView(view);
        return;
    L9:
        return;
    }

    @Override // obric.widget.editor.AbsEditor
    protected int getDefaultLeftLayout() {
        return R.layout.label_editor_left_layout;
    }

    @Override // obric.widget.editor.AbsEditor
    protected void initLeftWidget() {
        this.mLeftWidget = (EditorLeftLabelWidget) findViewById(R.id.left_widget);
    }

    @Override // obric.widget.editor.AbsEditor
    protected void initRightWidget() {
        this.mRightWidget = (EditorRightIconWidget) findViewById(R.id.right_widget);
    }

    @Override // obric.widget.editor.AbsEditor
    protected int getDefaultRightLayout() {
        return R.layout.label_editor_right_layout;
    }

    @Override // obric.widget.editor.AbsEditor
    public void setSingleLine(boolean singleLine) {
        super.setSingleLine(singleLine);
        editorLineCountChange(singleLine);
    }

    private void editorLineCountChange(boolean singleLine) {
        setLeftContainerCenterVertical(singleLine);
        EditorLeftLabelWidget r0 = this.mLeftWidget;
        if (singleLine == false) goto L5;
        int r1 = 16;
    L6:
        r0.setLabelGravity(r1);
        return;
    L5:
        r1 = 48;
        goto L6
    }

    public View getLeftContainer() {
        return this.mLeftWidget;
    }

    public View getRightContainer() {
        return this.mRightWidget;
    }
}
