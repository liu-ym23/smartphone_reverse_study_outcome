package obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class PreviewOptionView extends RelativeLayout {
    private ImageView mCheckedImage;
    private ImageView mPreviewImage;
    private TextView mPreviewTitle;

    public PreviewOptionView(Context r1) {
        super(r1);
    }

    public PreviewOptionView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PreviewOptionView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        View r4 = LayoutInflater.from(r1).inflate(com.android.settings.R.layout.preview_single_option_layout, this, true);
        this.mPreviewImage = (ImageView) r4.findViewById(com.android.settings.R.id.preview_image);
        this.mCheckedImage = (ImageView) r4.findViewById(com.android.settings.R.id.checked_image);
        this.mPreviewTitle = (TextView) r4.findViewById(com.android.settings.R.id.preview_title);
    }

    public void setChecked(boolean r1) {
        ImageView r0 = this.mCheckedImage;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public boolean isChecked() {
        if (this.mCheckedImage.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setTitle(int r2) {
        setTitle(getResources().getString(r2));
    }

    public void setTitle(CharSequence r2) {
        this.mPreviewTitle.setText(r2);
        TextView r1 = this.mPreviewTitle;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r3 = 8;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public void setPreview(Drawable r1) {
        this.mPreviewImage.setImageDrawable(r1);
    }

    public void setPreview(int r1) {
        this.mPreviewImage.setImageResource(r1);
    }

    public void setCheckImgMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mCheckedImage.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mCheckedImage.setLayoutParams(r0);
    }

    public void setPreviewImgMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mPreviewImage.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mPreviewImage.setLayoutParams(r0);
    }

    public void setPreviewTitleMarginDimens(int r2, int r3, int r4, int r5) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mPreviewTitle.getLayoutParams();
        r0.rightMargin = r3;
        r0.topMargin = r2;
        r0.bottomMargin = r4;
        r0.leftMargin = r5;
        this.mPreviewTitle.setLayoutParams(r0);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.mPreviewImage.setEnabled(r2);
        this.mPreviewTitle.setEnabled(r2);
        this.mCheckedImage.setEnabled(r2);
    }
}
