package com.obric.oui.indicator;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBaseIndicator$setViewPager2$2 extends RecyclerView.AdapterDataObserver implements OBaseIndicator.ReleaseMe {
    @Override // com.obric.oui.indicator.OBaseIndicator.ReleaseMe
    public final Function1 a() {
        return new OBaseIndicator$setViewPager2$2$releaseAction$1(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        super.onChanged();
        throw null;
    }
}
