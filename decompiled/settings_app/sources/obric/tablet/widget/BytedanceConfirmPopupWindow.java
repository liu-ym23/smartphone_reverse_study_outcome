package obric.tablet.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class BytedanceConfirmPopupWindow extends BytedanceDialogPopupWindow {
    private BytedanceJustifyTextView mMessageView;

    public BytedanceConfirmPopupWindow(View r1) {
        super(r1);
    }

    @Override // obric.tablet.widget.BytedanceDialogPopupWindow
    public void setView(View r1) {
        super.setView(r1);
    }

    public void setMessage(CharSequence r1) {
        BytedanceJustifyTextView r0 = this.mMessageView;
        if (r0 == null) goto L6;
        r0.setText(r1);
        return;
    }

    @Override // obric.tablet.widget.BytedanceDialogPopupWindow
    protected void initMsgContent(ViewGroup r4) {
        this.mMessageView = (BytedanceJustifyTextView) LayoutInflater.from(this.mContext).inflate(R.layout.revone_global_popupwindow_dialog_msg_layout, r4, true).findViewById(R.id.revone_popupwindow_dialog_message);
    }
}
