package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class Exceptions {
    private Exceptions() {
        throw new IllegalStateException("No instances!");
    }

    public static RuntimeException propagate(Throwable r0) {
        throw ExceptionHelper.wrapOrThrow(r0);
    }

    public static void throwIfFatal(Throwable r1) {
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
