package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public ListAdapter(@NonNull DiffUtil.ItemCallback<T> r5) {
        AsyncListDiffer.ListListener<T> r0 = new AnonymousClass1(this);
        this.mListener = r0;
        AsyncListDiffer<T> r1 = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(r5).build());
        this.mDiffer = r1;
        r1.addListListener(r0);
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    public T getItem(int r1) {
        return this.mDiffer.getCurrentList().get(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public void onCurrentListChanged(@NonNull List<T> r1, @NonNull List<T> r2) {
    }

    public void submitList(@Nullable List<T> r1) {
        this.mDiffer.submitList(r1);
    }

    public void submitList(@Nullable List<T> r1, @Nullable Runnable r2) {
        this.mDiffer.submitList(r1, r2);
    }

    public ListAdapter(@NonNull AsyncDifferConfig<T> r4) {
        AsyncListDiffer.ListListener<T> r0 = new AnonymousClass1(this);
        this.mListener = r0;
        AsyncListDiffer<T> r1 = new AsyncListDiffer(new AdapterListUpdateCallback(this), r4);
        this.mDiffer = r1;
        r1.addListListener(r0);
    }
}
