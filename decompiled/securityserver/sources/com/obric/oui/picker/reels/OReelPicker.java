package com.obric.oui.picker.reels;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface OReelPicker {

    @Metadata
    public interface Builder {

        @Metadata
        public static final class DefaultImpls {
        }
    }

    @Metadata
    public static final class Reel {
        public final boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            if ((r1 instanceof Reel) == true) goto L7;
            return false;
        L7:
            Reel r2 = (Reel) r1;
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }

    @Metadata
    public interface ReelChangedListener {
    }
}
