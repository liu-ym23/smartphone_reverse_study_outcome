package androidx.recyclerview.widget;

import android.util.Pair;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ConcatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final String TAG = "ConcatAdapter";
    private final ConcatAdapterController mController;

    public static final class Config {
        public static final Config DEFAULT = null;
        public final boolean isolateViewTypes;
        public final StableIdMode stableIdMode;

        public static final class Builder {
            private boolean mIsolateViewTypes;
            private StableIdMode mStableIdMode;

            public Builder() {
                this.mIsolateViewTypes = Config.DEFAULT.isolateViewTypes;
                this.mStableIdMode = Config.DEFAULT.stableIdMode;
            }

            public Builder setIsolateViewTypes(boolean r1) {
                this.mIsolateViewTypes = r1;
                return this;
            }

            public Builder setStableIdMode(StableIdMode r1) {
                this.mStableIdMode = r1;
                return this;
            }

            public Config build() {
                return new Config(this.mIsolateViewTypes, this.mStableIdMode);
            }
        }

        public static final enum StableIdMode extends Enum<StableIdMode> {
            private static final /* synthetic */ StableIdMode[] $VALUES = null;
            public static final StableIdMode ISOLATED_STABLE_IDS = null;
            public static final StableIdMode NO_STABLE_IDS = null;
            public static final StableIdMode SHARED_STABLE_IDS = null;

            private StableIdMode(String r1, int r2) {
                super(r1, r2);
            }

            public static StableIdMode valueOf(String r1) {
                return (StableIdMode) Enum.valueOf(StableIdMode.class, r1);
            }

            public static StableIdMode[] values() {
                return (StableIdMode[]) $VALUES.clone();
            }

            static {
                StableIdMode r0 = new StableIdMode("NO_STABLE_IDS", 0);
                NO_STABLE_IDS = r0;
                StableIdMode r1 = new StableIdMode("ISOLATED_STABLE_IDS", 1);
                ISOLATED_STABLE_IDS = r1;
                StableIdMode r3 = new StableIdMode("SHARED_STABLE_IDS", 2);
                SHARED_STABLE_IDS = r3;
                $VALUES = new StableIdMode[]{r0, r1, r3};
            }
        }

        static {
            DEFAULT = new Config(true, StableIdMode.NO_STABLE_IDS);
        }

        Config(boolean r1, StableIdMode r2) {
            this.isolateViewTypes = r1;
            this.stableIdMode = r2;
        }
    }

    @SafeVarargs
    public ConcatAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r2) {
        this(Config.DEFAULT, r2);
    }

    @SafeVarargs
    public ConcatAdapter(Config r1, RecyclerView.Adapter<? extends RecyclerView.ViewHolder>... r2) {
        this(r1, Arrays.asList(r2));
    }

    public ConcatAdapter(List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r2) {
        this(Config.DEFAULT, r2);
    }

    public ConcatAdapter(Config r2, List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r3) {
        this.mController = new ConcatAdapterController(this, r2);
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        addAdapter(r4.next());
        goto L4
    L6:
        super.setHasStableIds(this.mController.hasStableIds());
    }

    public boolean addAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1) {
        return this.mController.addAdapter(r1);
    }

    public boolean addAdapter(int r1, RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r2) {
        return this.mController.addAdapter(r1, r2);
    }

    public boolean removeAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1) {
        return this.mController.removeAdapter(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r1) {
        return this.mController.getItemViewType(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return this.mController.onCreateViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        this.mController.onBindViewHolder(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean r1) {
        throw new UnsupportedOperationException("Calling setHasStableIds is not allowed on the ConcatAdapter. Use the Config object passed in the constructor to control this behavior");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy r1) {
        throw new UnsupportedOperationException("Calling setStateRestorationPolicy is not allowed on the ConcatAdapter. This value is inferred from added adapters");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r1) {
        return this.mController.getItemId(r1);
    }

    void internalSetStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy r1) {
        super.setStateRestorationPolicy(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mController.getTotalCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder r1) {
        return this.mController.onFailedToRecycleView(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder r1) {
        this.mController.onViewAttachedToWindow(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r1) {
        this.mController.onViewDetachedFromWindow(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder r1) {
        this.mController.onViewRecycled(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r1) {
        this.mController.onAttachedToRecyclerView(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r1) {
        this.mController.onDetachedFromRecyclerView(r1);
    }

    public List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getAdapters() {
        return Collections.unmodifiableList(this.mController.getCopyOfAdapters());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r1, RecyclerView.ViewHolder r2, int r3) {
        return this.mController.getLocalAdapterPosition(r1, r2, r3);
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int r1) {
        return this.mController.getWrappedAdapterAndPosition(r1);
    }
}
