package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes2.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action r1) {
        super(r1);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(@NonNull Action r1) {
        onDisposed2(r1);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(@NonNull Action r1) {
        r1.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
