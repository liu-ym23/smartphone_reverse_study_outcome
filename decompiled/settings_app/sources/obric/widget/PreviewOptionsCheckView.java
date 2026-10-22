package obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class PreviewOptionsCheckView extends RelativeLayout implements View.OnClickListener {
    public static final int INVALID = -1;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private boolean mAutoCheck;
    private TextView mHeadTitle;
    private OptionCheckListener mOptionCheckListener;
    private PreviewOptionView mOptionViewLeft;
    private PreviewOptionView mOptionViewRight;

    public interface OptionCheckListener {
        void onOptionChecked(PreviewOptionsCheckView r1, int r2);
    }

    public PreviewOptionsCheckView(Context r2) {
        this(r2, null);
    }

    public PreviewOptionsCheckView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PreviewOptionsCheckView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mAutoCheck = true;
        View r5 = LayoutInflater.from(r2).inflate(com.android.settings.R.layout.preview_options_view_layout, this, true);
        this.mHeadTitle = (TextView) r5.findViewById(com.android.settings.R.id.preview_title);
        PreviewOptionView r6 = (PreviewOptionView) r5.findViewById(com.android.settings.R.id.item_preview_left);
        this.mOptionViewLeft = r6;
        r6.setTag(0);
        this.mOptionViewLeft.setOnClickListener(this);
        PreviewOptionView r7 = (PreviewOptionView) r5.findViewById(com.android.settings.R.id.item_preview_right);
        this.mOptionViewRight = r7;
        r7.setTag(1);
        this.mOptionViewRight.setOnClickListener(this);
    }

    public void setHeadTitle(int r2) {
        setHeadTitle(getContext().getResources().getString(r2));
    }

    public void setHeadTitle(String r2) {
        this.mHeadTitle.setText(r2);
        TextView r1 = this.mHeadTitle;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setPreviewIcons(int[] r3) {
        this.mOptionViewLeft.setPreview(r3[0]);
        this.mOptionViewRight.setPreview(r3[1]);
    }

    public void setPreviewIcons(Drawable[] r3) {
        this.mOptionViewLeft.setPreview(r3[0]);
        this.mOptionViewRight.setPreview(r3[1]);
    }

    public void setAutoCheck(boolean r1) {
        this.mAutoCheck = r1;
    }

    public void setCheck(int r5) {
        PreviewOptionView r0 = this.mOptionViewLeft;
        boolean r1 = false;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        PreviewOptionView r4 = this.mOptionViewRight;
        if (r5 != 1) goto L9;
        r1 = true;
    L9:
        r4.setChecked(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void bindPreviewOptionView(int r2, int r3, int r4) {
        if (r4 <= 0) goto L4;
        String r5 = getResources().getString(r4);
    L5:
        bindPreviewOptionView(r2, r3, r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void bindPreviewOptionView(int r2, int r3, String r4) {
        if (r2 != 0) goto L4;
        PreviewOptionView r1 = this.mOptionViewLeft;
    L9:
        r1.setTitle(r4);
        r1.setPreview(r3);
        return;
    L4:
        if (r2 != 1) goto L7;
        r1 = this.mOptionViewRight;
        goto L9
    L7:
        throw new UnsupportedOperationException("not support index " + r2);
    }

    public void setOptionCheckListener(OptionCheckListener r1) {
        this.mOptionCheckListener = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if ((r2 instanceof PreviewOptionView) == true) goto L5;
        return;
    L5:
        if ((!((PreviewOptionView) r2).isChecked()) == false) goto L14;
        int r3 = ((Integer) r2.getTag()).intValue();
        if (this.mAutoCheck == false) goto L9;
        setCheck(r3);
    L9:
        OptionCheckListener r0 = this.mOptionCheckListener;
        if (r0 == null) goto L15;
        r0.onOptionChecked(this, r3);
        return;
    L15:
        return;
    }

    public PreviewOptionView getOptionView(int r3) {
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return this.mOptionViewRight;
    L8:
        throw new UnsupportedOperationException("not support index " + r3);
    L10:
        return this.mOptionViewLeft;
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.mOptionViewRight.setEnabled(r2);
        this.mOptionViewLeft.setEnabled(r2);
    }
}
