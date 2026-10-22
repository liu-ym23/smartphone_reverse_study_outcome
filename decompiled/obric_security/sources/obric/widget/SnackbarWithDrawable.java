package obric.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class SnackbarWithDrawable extends LinearLayout {
    private View.OnClickListener mActionListener;
    private View mContent;
    private ImageView mImageView;
    private TextView mMessageView;

    static /* synthetic */ View.OnClickListener access$000(SnackbarWithDrawable r0) {
        return r0.mActionListener;
    }

    public SnackbarWithDrawable(Context context) {
        this(context, null);
    }

    public SnackbarWithDrawable(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnackbarWithDrawable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r1 = LayoutInflater.from(context).inflate(R.layout.snackbar_with_drawable_layout, this, true);
        this.mMessageView = (TextView) r1.findViewById(R.id.message);
        this.mContent = r1.findViewById(R.id.content);
        ImageView r2 = (ImageView) r1.findViewById(R.id.action_img);
        this.mImageView = r2;
        r2.setOnClickListener(new AnonymousClass1(this));
    }

    public void setMessage(CharSequence text) {
        this.mMessageView.setText(text);
    }

    public void setMessage(int resId) {
        this.mMessageView.setText(resId);
    }

    public void setImageDrawable(Drawable drawable) {
        this.mImageView.setImageDrawable(drawable);
    }

    public void setImageResource(int resId) {
        this.mImageView.setImageResource(resId);
    }

    public void setActionListener(View.OnClickListener listener) {
        this.mActionListener = listener;
    }
}
