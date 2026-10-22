package obric.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SelectionDialogAdapter extends RecyclerView.Adapter<SelectionViewHolder> {
    private final Context mContext;
    private List<String> mItemList;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View r1, int r2);
    }

    public static class SelectionViewHolder extends RecyclerView.ViewHolder {
        OCardListItem tvItem;

        public SelectionViewHolder(View r2) {
            super(r2);
            this.tvItem = (OCardListItem) r2.findViewById(R.id.pwd_type);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((SelectionViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    public SelectionDialogAdapter(Context r2) {
        this.mItemList = new ArrayList();
        this.mContext = r2;
    }

    public void setItems(List<String> r1) {
        if (r1 != null) goto L5;
        r1 = new ArrayList();
    L5:
        this.mItemList = r1;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener r1) {
        this.mOnItemClickListener = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelectionViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new SelectionViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.password_menu_dialog_list_item3, r2, false));
    }

    public void onBindViewHolder(SelectionViewHolder r4, final int r5) {
        String r0 = this.mItemList.get(r5);
        r4.tvItem.setTitle(r0);
        r4.tvItem.setShowCardBg(false);
        r4.tvItem.setCardType(0);
        if (r5 != 0) goto L6;
        r4.tvItem.setCardPosition(1);
    L9:
        r4.tvItem.setOnContentClickListener(new SelectionDialogAdapter$$ExternalSyntheticLambda0(this, r5));
        return;
    L6:
        if (r5 != (this.mItemList.size() - 1)) goto L8;
        r4.tvItem.showDivider(false);
        r4.tvItem.setCardPosition(3);
        goto L9
    L8:
        r4.tvItem.setCardPosition(2);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$obric-app-SelectionDialogAdapter, reason: not valid java name */
    /* synthetic */ void m3085lambda$onBindViewHolder$0$obricappSelectionDialogAdapter(int r1, View r2) {
        OnItemClickListener r0 = this.mOnItemClickListener;
        if (r0 == null) goto L6;
        r0.onItemClick(r2, r1);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItemList.size();
    }
}
