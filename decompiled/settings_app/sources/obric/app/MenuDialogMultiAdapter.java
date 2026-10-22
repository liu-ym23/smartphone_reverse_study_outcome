package obric.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;
import obric.widget.FontFitTextView;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class MenuDialogMultiAdapter extends BaseAdapter {
    private Context mContext;
    private boolean mHasRecentCall;
    private LayoutInflater mLayoutInflater;
    private List<String> mList;

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public MenuDialogMultiAdapter(Context context, List<String> list) {
        this(context, list, false);
        this.mContext = context;
    }

    public MenuDialogMultiAdapter(Context context, List<String> list, boolean hasRecentCall) {
        if (list == null) goto L7;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mList = list;
        this.mHasRecentCall = hasRecentCall;
        return;
    L7:
        throw new IllegalArgumentException();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mList.get(position);
    }

    private int dipToPx(double dipValue) {
        return (int) ((dipValue * ((double) this.mContext.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) goto L5;
        convertView = this.mLayoutInflater.inflate(R.layout.menu_dialog_list_multi_item, null);
    L5:
        if (position != (getCount() - 1)) goto L8;
        convertView.setBackgroundResource(R.drawable.menu_dialog_last_item_selector);
    L12:
        FontFitTextView r4 = (FontFitTextView) convertView;
        r4.setText(this.mList.get(position));
        r4.setMinTextSize(r4.getResources().getDimension(R.dimen.menu_dialog_item_text_min_size));
        return convertView;
    L8:
        if (this.mHasRecentCall == false) goto L11;
        if (position != 0) goto L11;
        convertView.setBackgroundResource(R.drawable.recent_call_multi_item_selector);
        int r5 = this.mContext.getResources().getDimensionPixelSize(R.dimen.recent_call_padding);
        convertView.setPadding(r5, 0, r5, 0);
    L11:
        convertView.setBackgroundResource(R.drawable.menu_dialog_multi_item_selector);
        goto L12
    }
}
