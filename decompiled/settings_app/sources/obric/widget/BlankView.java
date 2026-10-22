package obric.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class BlankView extends LinearLayout {
    private static final int NORMAL = 0;
    private static final int SMALL = 1;
    private static final int WITH_ACTION = 2;
    private TextView mActionButton;
    private ImageView mImageView;
    private TextView mPrimaryHintView;
    private TextView mSecondaryHintView;

    public BlankView(Context context) {
        this(context, null);
    }

    public BlankView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlankView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r8 = LayoutInflater.from(getContext()).inflate(R.layout.blank_view, this, true);
        setOrientation(1);
        this.mImageView = (ImageView) r8.findViewById(R.id.empty_image);
        this.mPrimaryHintView = (TextView) r8.findViewById(R.id.empty_primary_hint);
        this.mSecondaryHintView = (TextView) r8.findViewById(R.id.empty_secondary_hint);
        this.mActionButton = (TextView) r8.findViewById(R.id.empty_action_btn);
        TypedArray r7 = context.obtainStyledAttributes(attrs, R.styleable.SmartisanBlankView);
        String r9 = r7.getString(R.styleable.SmartisanBlankView_primaryHint);     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r9) == true) goto L6;
        this.mPrimaryHintView.setText(r9);     // Catch: Throwable -> L30
    L6:
        String r10 = r7.getString(R.styleable.SmartisanBlankView_secondaryHint);     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r10) == true) goto L9;
        this.mSecondaryHintView.setText(r10);     // Catch: Throwable -> L30
    L9:
        int r11 = r7.getInt(R.styleable.SmartisanBlankView_blankStyle, 0);     // Catch: Throwable -> L30
        if (r11 == 1) goto L12;
        if (r11 == 2) goto L12;
    L16:
        if (r11 != 0) goto L18;
        int r6 = R.drawable.blank_icon_large;     // Catch: Throwable -> L30
    L19:
        int r12 = r7.getResourceId(R.styleable.SmartisanBlankView_emptyDrawable, r6);     // Catch: Throwable -> L30
        if (r12 < 0) goto L22;
        this.mImageView.setImageResource(r12);     // Catch: Throwable -> L30
    L22:
        int r13 = getContext().getResources().getDimensionPixelSize(R.dimen.blank_view_vertical_margin);     // Catch: Throwable -> L30
        if (r11 != 2) goto L27;
        this.mActionButton.setVisibility(0);     // Catch: Throwable -> L30
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) this.mActionButton.getLayoutParams();     // Catch: Throwable -> L30
        r14.bottomMargin = 0;     // Catch: Throwable -> L30
        this.mActionButton.setLayoutParams(r14);     // Catch: Throwable -> L30
        int r15 = r7.getResourceId(R.styleable.SmartisanBlankView_emptyActionBackground, -1);     // Catch: Throwable -> L30
        if (r15 < 0) goto L28;
        this.mActionButton.setBackgroundResource(r15);     // Catch: Throwable -> L30
    L28:
        r7.recycle();
        return;
    L27:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) this.mSecondaryHintView.getLayoutParams();     // Catch: Throwable -> L30
        r16.bottomMargin = r13;     // Catch: Throwable -> L30
        this.mSecondaryHintView.setLayoutParams(r16);     // Catch: Throwable -> L30
        goto L28
    L18:
        r6 = R.drawable.blank_icon_small;     // Catch: Throwable -> L30
    L12:
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mImageView.getLayoutParams();     // Catch: Throwable -> L30
        r1.width = context.getResources().getDimensionPixelOffset(R.dimen.small_blank_image_size);     // Catch: Throwable -> L30
        r1.height = context.getResources().getDimensionPixelOffset(R.dimen.small_blank_image_size);     // Catch: Throwable -> L30
        if (r11 != 2) goto L15;
        r1.topMargin = 0;     // Catch: Throwable -> L30
    L15:
        this.mImageView.setLayoutParams(r1);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    public ImageView getImageView() {
        return this.mImageView;
    }

    public TextView getPrimaryHintView() {
        return this.mPrimaryHintView;
    }

    public TextView getSecondaryHintView() {
        return this.mSecondaryHintView;
    }

    public TextView getActionButton() {
        return this.mActionButton;
    }
}
