package androidx.slice.builders;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import androidx.slice.Clock;
import androidx.slice.Slice;
import androidx.slice.SliceManager;
import androidx.slice.SliceProvider;
import androidx.slice.SliceSpec;
import androidx.slice.SystemClock;
import androidx.slice.builders.impl.TemplateBuilderImpl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class TemplateSliceBuilder {
    private static final String TAG = "TemplateSliceBuilder";
    private final Slice.Builder mBuilder;
    private final Context mContext;
    private final TemplateBuilderImpl mImpl;
    private List<SliceSpec> mSpecs;

    protected TemplateBuilderImpl selectImpl(Uri r1) {
        return null;
    }

    abstract void setImpl(TemplateBuilderImpl r1);

    protected TemplateSliceBuilder(TemplateBuilderImpl r2) {
        this.mContext = null;
        this.mBuilder = null;
        this.mImpl = r2;
        setImpl(r2);
    }

    public TemplateSliceBuilder(Context r2, Uri r3) {
        this.mBuilder = new Slice.Builder(r3);
        this.mContext = r2;
        this.mSpecs = getSpecs(r3);
        TemplateBuilderImpl r4 = selectImpl(r3);
        this.mImpl = r4;
        if (r4 == null) goto L7;
        setImpl(r4);
        return;
    L7:
        throw new IllegalArgumentException("No valid specs found");
    }

    public Slice build() {
        return this.mImpl.build();
    }

    protected Slice.Builder getBuilder() {
        return this.mBuilder;
    }

    protected boolean checkCompatible(SliceSpec r4, Uri r5) {
        int r6 = this.mSpecs.size();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        if (this.mSpecs.get(r1).canRender(r4) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private List<SliceSpec> getSpecs(Uri r2) {
        if (SliceProvider.getCurrentSpecs() == null) goto L7;
        return new ArrayList(SliceProvider.getCurrentSpecs());
    L7:
        return new ArrayList(SliceManager.getInstance(this.mContext).getPinnedSpecs(r2));
    }

    protected Clock getClock() {
        if (SliceProvider.getClock() == null) goto L7;
        return SliceProvider.getClock();
    L7:
        return new SystemClock();
    }

    static <T> Pair<SliceSpec, Class<? extends TemplateBuilderImpl>> pair(SliceSpec r1, Class<T> r2) {
        return new Pair(r1, r2);
    }
}
