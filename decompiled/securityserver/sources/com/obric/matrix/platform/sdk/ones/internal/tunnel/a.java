package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.obric.matrix.proto.Request;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements MaybeOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f153a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Request c;

    public /* synthetic */ a(int r1, Request r2, int r3) {
        this.f153a = r3;
        this.b = r1;
        this.c = r2;
    }

    @Override // io.reactivex.MaybeOnSubscribe
    public final void subscribe(MaybeEmitter r2) {
        switch(this.f153a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        CmdManager.b(this.b, this.c, r2);
        return;
    L6:
        CmdManager.d(this.b, this.c, r2);
    }
}
