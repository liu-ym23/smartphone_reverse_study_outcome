package com.google.common.collect;

import java.util.stream.Stream;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Streams$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Stream f$0;

    public /* synthetic */ Streams$$ExternalSyntheticLambda0(Stream r1) {
        this.f$0 = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.close();
    }
}
