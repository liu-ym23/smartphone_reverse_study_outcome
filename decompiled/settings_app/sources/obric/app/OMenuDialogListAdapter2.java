package obric.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.sheet.OInsetSheet;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class OMenuDialogListAdapter2 extends BaseAdapter {
    private Context context;
    private OInsetSheet dialog;
    private List<String> list;
    private List<View.OnClickListener> listener;
    private boolean mHasRecentCall;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    static /* synthetic */ OInsetSheet access$000(OMenuDialogListAdapter2 r0) {
        return r0.dialog;
    }

    static /* synthetic */ List access$100(OMenuDialogListAdapter2 r0) {
        return r0.listener;
    }

    public OMenuDialogListAdapter2(Context r2, List<String> r3, List<View.OnClickListener> r4) {
        this(r2, r3, r4, false);
    }

    public OMenuDialogListAdapter2(Context r1, List<String> r2, List<View.OnClickListener> r3, boolean r4) {
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

    public void setDialog(OInsetSheet r1) {
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
        if (r3 != null) goto L4;
        r3 = LayoutInflater.from(this.context).inflate(R.layout.password_menu_dialog_list_item2, null);
    L4:
        final OListItemGeneral r5 = (OListItemGeneral) r3;
        r5.setTitleString(this.list.get(r2));
        r5.setOnClickListener(new AnonymousClass1(this, r2, r5));
        return r3;
    }
}
