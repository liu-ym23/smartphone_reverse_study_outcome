package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class SnackbarWithButton extends LinearLayout {
    private TextView mActionButton;
    private View.OnClickListener mActionListener;
    private TextView mMessageView;

    static /* synthetic */ View.OnClickListener access$000(SnackbarWithButton r0) {
        return r0.mActionListener;
    }

    public SnackbarWithButton(Context context) {
        this(context, null);
    }

    public SnackbarWithButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SnackbarWithButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View r1 = LayoutInflater.from(context).inflate(R.layout.snackbar_with_btn_layout, this, true);
        setGravity(16);
        this.mActionButton = (TextView) r1.findViewById(R.id.action_btn);
        this.mMessageView = (TextView) r1.findViewById(R.id.message);
        this.mActionButton.setOnClickListener(new AnonymousClass1(this));
    }

    public void setMessage(CharSequence text) {
        this.mMessageView.setText(text);
    }

    public void setMessage(int resId) {
        this.mMessageView.setText(resId);
    }

    public void setActionText(CharSequence text) {
        this.mActionButton.setText(text);
    }

    public void setActionText(int resId) {
        this.mActionButton.setText(resId);
    }

    public void setActionListener(View.OnClickListener listener) {
        this.mActionListener = listener;
    }
}
