package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentViewHolder extends RecyclerView.ViewHolder {
    private FragmentViewHolder(@NonNull FrameLayout r1) {
        super(r1);
    }

    @NonNull
    public static FragmentViewHolder create(@NonNull ViewGroup r2) {
        FrameLayout r0 = new FrameLayout(r2.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r0.setId(ViewCompat.generateViewId());
        r0.setSaveEnabled(false);
        return new FragmentViewHolder(r0);
    }

    @NonNull
    public FrameLayout getContainer() {
        return (FrameLayout) this.itemView;
    }
}
