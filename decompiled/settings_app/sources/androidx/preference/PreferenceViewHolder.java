package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> mCachedViews;
    private boolean mDividerAllowedAbove;
    private boolean mDividerAllowedBelow;

    PreferenceViewHolder(View r3) {
        super(r3);
        SparseArray<View> r0 = new SparseArray(4);
        this.mCachedViews = r0;
        r0.put(android.R.id.title, r3.findViewById(android.R.id.title));
        r0.put(android.R.id.summary, r3.findViewById(android.R.id.summary));
        r0.put(android.R.id.icon, r3.findViewById(android.R.id.icon));
        r0.put(R.id.icon_frame, r3.findViewById(R.id.icon_frame));
        r0.put(16908350, r3.findViewById(16908350));
    }

    public static PreferenceViewHolder createInstanceForTests(View r1) {
        return new PreferenceViewHolder(r1);
    }

    public View findViewById(int r2) {
        View r0 = this.mCachedViews.get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        View r1 = this.itemView.findViewById(r2);
        if (r1 == null) goto L8;
        this.mCachedViews.put(r2, r1);
    L8:
        return r1;
    }

    public boolean isDividerAllowedAbove() {
        return this.mDividerAllowedAbove;
    }

    public void setDividerAllowedAbove(boolean r1) {
        this.mDividerAllowedAbove = r1;
    }

    public boolean isDividerAllowedBelow() {
        return this.mDividerAllowedBelow;
    }

    public void setDividerAllowedBelow(boolean r1) {
        this.mDividerAllowedBelow = r1;
    }
}
