package com.android.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.settings.PreviewSettingItemView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalOptionCheckView extends RelativeLayout implements View.OnClickListener {
    private static final int DEF_OPTIONS_COUNT = 2;
    private Position mCurrentSelect;
    private PreviewSettingItemView mLeftItem;
    private PreviewSettingItemView mMiddleItem;
    private OptionSelectListener mOptionListener;
    private int mOptionsCount;
    private PreviewSettingItemView mRightItem;
    private TextView mTitle;

    /* JADX INFO: renamed from: com.android.settings.widget.HorizontalOptionCheckView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$widget$HorizontalOptionCheckView$Position = null;

        static {
            int[] r0 = new int[Position.values().length];
            $SwitchMap$com$android$settings$widget$HorizontalOptionCheckView$Position = r0;
            r0[Position.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$android$settings$widget$HorizontalOptionCheckView$Position[Position.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$settings$widget$HorizontalOptionCheckView$Position[Position.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public interface OptionSelectListener {
        void select(Position r1);
    }

    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES = null;
        public static final Position LEFT = null;
        public static final Position MIDDLE = null;
        public static final Position RIGHT = null;

        private static /* synthetic */ Position[] $values() {
            return new Position[]{LEFT, MIDDLE, RIGHT};
        }

        private Position(String r1, int r2) {
            super(r1, r2);
        }

        public static Position valueOf(String r1) {
            return (Position) Enum.valueOf(Position.class, r1);
        }

        public static Position[] values() {
            return (Position[]) $VALUES.clone();
        }

        static {
            LEFT = new Position("LEFT", 0);
            MIDDLE = new Position("MIDDLE", 1);
            RIGHT = new Position("RIGHT", 2);
            $VALUES = $values();
        }
    }

    public HorizontalOptionCheckView(Context r2) {
        this(r2, null);
    }

    public HorizontalOptionCheckView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public HorizontalOptionCheckView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        init();
        LayoutInflater.from(r4).inflate(R.layout.horizontal_options_chooser_layout, this, true);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.HorizontalOptionCheckView, r6, 0);
        String r8 = r7.getString(1);
        this.mOptionsCount = r7.getInt(0, 2);
        r7.recycle();
        View r9 = findViewById(R.id.id_container);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mLeftItem = (PreviewSettingItemView) findViewById(R.id.item_preview_left);
        this.mMiddleItem = (PreviewSettingItemView) findViewById(R.id.item_preview_middle);
        this.mRightItem = (PreviewSettingItemView) findViewById(R.id.item_preview_right);
        r9.setBackgroundResource(R.drawable.bg_preview_3);
        this.mLeftItem.setOnClickListener(this);
        this.mMiddleItem.setOnClickListener(this);
        this.mRightItem.setOnClickListener(this);
        if (this.mOptionsCount != 2) goto L5;
        this.mMiddleItem.setVisibility(8);
        r9.setBackgroundResource(R.drawable.one_hand_preview_bg_2);
    L5:
        setTitle(r8);
        clearCheck();
    }

    private void init() {
        this.mCurrentSelect = Position.LEFT;
    }

    public void setTitle(int r2) {
        this.mTitle.setText(r2);
        this.mTitle.setVisibility(0);
    }

    public void setTitle(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        this.mTitle.setVisibility(8);
        return;
    L6:
        this.mTitle.setText(r2);
        this.mTitle.setVisibility(0);
    }

    public void setPreviewHeight(int r2) {
        View r1 = findViewById(R.id.id_container);
        ViewGroup.LayoutParams r0 = r1.getLayoutParams();
        r0.height = r2;
        r1.setLayoutParams(r0);
    }

    public void updateSubTitles(int r2, int r3) {
        this.mLeftItem.setTitle(r2);
        this.mRightItem.setTitle(r3);
    }

    public void updateSubTitles(int r1, int r2, int r3) {
        updateSubTitles(r1, r3);
        if (this.mOptionsCount <= 2) goto L6;
        this.mMiddleItem.setTitle(r2);
        return;
    }

    public void updatePreviews(int r2, int r3) {
        this.mLeftItem.setPreview(r2);
        this.mRightItem.setPreview(r3);
    }

    public void updatePreviews(int r1, int r2, int r3) {
        updatePreviews(r1, r3);
        if (this.mOptionsCount <= 2) goto L6;
        this.mMiddleItem.setPreview(r2);
        return;
    }

    public void setSubtitle(Position r1, int r2) {
        getItemView(r1).setTitle(r2);
    }

    public void setPreview(Position r1, int r2) {
        getItemView(r1).setPreview(r2);
    }

    public void setOptionListener(OptionSelectListener r1) {
        this.mOptionListener = r1;
    }

    public void setCheck(Position r5) {
        PreviewSettingItemView r0 = this.mLeftItem;
        boolean r2 = true;
        if (r5 != Position.LEFT) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        PreviewSettingItemView r3 = this.mMiddleItem;
        if (r5 != Position.MIDDLE) goto L9;
        boolean r4 = true;
    L10:
        r3.setChecked(r4);
        PreviewSettingItemView r6 = this.mRightItem;
        if (r5 == Position.RIGHT) goto L14;
        r2 = false;
    L14:
        r6.setChecked(r2);
        this.mCurrentSelect = r5;
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public PreviewSettingItemView getItemView(Position r2) {
        int r3 = AnonymousClass1.$SwitchMap$com$android$settings$widget$HorizontalOptionCheckView$Position[r2.ordinal()];
        if (r3 == 1) goto L11;
        if (r3 == 2) goto L9;
        return this.mRightItem;
    L9:
        return this.mMiddleItem;
    L11:
        return this.mLeftItem;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        switch(r3.getId()) {
            case 2131429480: goto L6;
            case 2131429481: goto L5;
            default: goto L4;
        };
    L4:
        Position r4 = Position.RIGHT;
    L8:
        if (r4 != this.mCurrentSelect) goto L10;
        return;
    L10:
        clearCheck();
        getItemView(r4).setChecked(true);
        this.mCurrentSelect = r4;
        OptionSelectListener r2 = this.mOptionListener;
        if (r2 == null) goto L14;
        r2.select(r4);
        return;
    L14:
        return;
    L5:
        r4 = Position.MIDDLE;
        goto L8
    L6:
        r4 = Position.LEFT;
        goto L8
    }

    private void clearCheck() {
        this.mLeftItem.setChecked(false);
        this.mMiddleItem.setChecked(false);
        this.mRightItem.setChecked(false);
    }
}
