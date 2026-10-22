package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes2.dex */
public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    @NonNull
    public static RuntimeException propagate(@NonNull Throwable r0) {
        throw ExceptionHelper.wrapOrThrow(r0);
    }

    public static void throwIfFatal(@NonNull Throwable r1) {
        if ((r1 instanceof VirtualMachineError) == true) goto L14;
        if ((r1 instanceof ThreadDeath) == true) goto L12;
        if ((r1 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r1);
    L12:
        throw ((ThreadDeath) r1);
    L14:
        throw ((VirtualMachineError) r1);
    }
}
