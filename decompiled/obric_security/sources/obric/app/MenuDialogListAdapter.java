package obric.app;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import obric.widget.R;
import obric.widget.ShadowButton;

/* JADX INFO: loaded from: classes5.dex */
public class MenuDialogListAdapter extends BaseAdapter {
    private Context context;
    private Dialog dialog;
    private List<String> list;
    private List<View.OnClickListener> listener;
    private boolean mHasRecentCall;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    static /* synthetic */ Dialog access$000(MenuDialogListAdapter r0) {
        return r0.dialog;
    }

    static /* synthetic */ List access$100(MenuDialogListAdapter r0) {
        return r0.listener;
    }

    public MenuDialogListAdapter(Context context, List<String> list, List<View.OnClickListener> listener) {
        this(context, list, listener, false);
    }

    public MenuDialogListAdapter(Context context, List<String> list, List<View.OnClickListener> listener, boolean hasRecentCall) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        if (list == null) goto L10;
        if (listener == null) goto L10;
        if (list.size() != listener.size()) goto L10;
        this.mHasRecentCall = hasRecentCall;
        return;
    L10:
        throw new IllegalArgumentException();
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.list.get(position);
    }

    private int dipToPx(double dipValue) {
        return (int) ((dipValue * ((double) this.context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    @Override // android.widget.Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView != null) goto L5;
        convertView = LayoutInflater.from(this.context).inflate(R.layout.menu_dialog_list_item, null);
    L5:
        if (this.mHasRecentCall == false) goto L8;
        if (position != 0) goto L8;
        convertView.setBackgroundResource(R.drawable.recent_call_item_selector);
        int r4 = this.context.getResources().getDimensionPixelSize(R.dimen.recent_call_padding_left);
        convertView.setPadding(r4, 0, r4, 0);
    L9:
        final ShadowButton r5 = (ShadowButton) convertView;
        r5.setText(this.list.get(position));
        r5.setOnClickListener(new AnonymousClass1(this, position, r5));
        return convertView;
    L8:
        convertView.setBackgroundResource(R.drawable.menu_dialog_item_selector);
        goto L9
    }
}
