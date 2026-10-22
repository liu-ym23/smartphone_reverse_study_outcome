package obric.app;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemGeneral;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class OMenuDialogListAdapter extends BaseAdapter {
    private Context context;
    private Dialog dialog;
    private List<String> list;
    private List<View.OnClickListener> listener;
    private boolean mHasRecentCall;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    static /* synthetic */ Dialog access$000(OMenuDialogListAdapter r0) {
        return r0.dialog;
    }

    static /* synthetic */ List access$100(OMenuDialogListAdapter r0) {
        return r0.listener;
    }

    public OMenuDialogListAdapter(Context r2, List<String> r3, List<View.OnClickListener> r4) {
        this(r2, r3, r4, false);
    }

    public OMenuDialogListAdapter(Context r1, List<String> r2, List<View.OnClickListener> r3, boolean r4) {
        this.context = r1;
        this.list = r2;
        this.listener = r3;
        if (r2 == null) goto L10;
        if (r3 == null) goto L10;
        if (r2.size() != r3.size()) goto L10;
        this.mHasRecentCall = r4;
        return;
    L10:
        throw new IllegalArgumentException();
    }

    public void setDialog(Dialog r1) {
        this.dialog = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.list.get(r1);
    }

    private int dipToPx(double r3) {
        return (int) ((r3 * ((double) this.context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    @Override // android.widget.Adapter
    public View getView(final int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L5;
        r3 = LayoutInflater.from(this.context).inflate(R.layout.password_menu_dialog_list_item, null);
    L5:
        if (this.mHasRecentCall == false) goto L8;
        if (r2 != 0) goto L8;
        int r5 = this.context.getResources().getDimensionPixelSize(R.dimen.recent_call_padding_left);
        r3.setPadding(r5, 0, r5, 0);
    L8:
        final OListItemGeneral r6 = (OListItemGeneral) r3.findViewById(R.id.app_item);
        r6.setTitleString(this.list.get(r2));
        r6.setOnClickListener(new AnonymousClass1(this, r2, r6));
        return r3;
    }
}
