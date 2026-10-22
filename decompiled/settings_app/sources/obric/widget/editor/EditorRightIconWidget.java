package obric.widget.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class EditorRightIconWidget extends LinearLayout {
    private View mDividerView;
    private ImageView mIcon;
    private TextView mLabel;

    public EditorRightIconWidget(Context context) {
        this(context, null);
    }

    public EditorRightIconWidget(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditorRightIconWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.editor_left_right_widget_min_height));
        View r1 = LayoutInflater.from(context).inflate(R.layout.editor_right_icon_widget_layout, this, true);
        this.mLabel = (TextView) r1.findViewById(R.id.label);
        this.mIcon = (ImageView) r1.findViewById(R.id.icon);
        this.mDividerView = r1.findViewById(R.id.devide);
    }

    public void setText(CharSequence s) {
        if (s != null) goto L4;
        this.mLabel.setVisibility(8);
        return;
    L4:
        this.mLabel.setVisibility(0);
        this.mLabel.setText(s);
    }

    public void setText(int resId) {
        setText(getResources().getString(resId));
    }

    public void setIconDrawable(Drawable d) {
        if (d != null) goto L4;
        this.mIcon.setVisibility(8);
        return;
    L4:
        this.mIcon.setVisibility(0);
        this.mIcon.setImageDrawable(d);
    }

    public void setIconResource(int resId) {
        this.mIcon.setVisibility(0);
        this.mIcon.setImageResource(resId);
    }

    public void setIconContentDescription(String description) {
        this.mIcon.setContentDescription(description);
    }

    public void setWidth(int width) {
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new LinearLayout.LayoutParams(width, -2);
    L6:
        setLayoutParams(r0);
        return;
    L5:
        r0.width = width;
        goto L6
    }

    public void setDevideVisible(boolean visible) {
        View r0 = this.mDividerView;
        int r1 = 0;
        if (visible == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (visible == true) goto L10;
        r1 = getResources().getDimensionPixelOffset(R.dimen.editor_horizontal_padding);
    L10:
        setLeftMargin(r1);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    private void setLeftMargin(int leftMargin) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) this.mIcon.getLayoutParams();
        r0.leftMargin = leftMargin;
        this.mIcon.setLayoutParams(r0);
    }

    public TextView getLabelTextView() {
        return this.mLabel;
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
