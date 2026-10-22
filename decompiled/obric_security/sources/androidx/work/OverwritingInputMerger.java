package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends InputMerger {
    public OverwritingInputMerger() {
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> inputs) {
        Data.Builder r2 = new Data.Builder();
        HashMap r0 = new HashMap();
        Iterator<Data> r3 = inputs.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.putAll(r3.next().getKeyValueMap());
        goto L4
    L6:
        r2.putAll(r0);
        return r2.build();
    }
}
