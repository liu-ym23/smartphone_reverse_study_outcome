package com.obric.oui.orecyclerview.base;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VelocityTrackerFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/orecyclerview/base/VelocityTrackerFactory;", "", "()V", "Companion", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VelocityTrackerFactory {
    public static final Companion Companion = null;
    public static final int VELOCITY_TRACKER_IMPL_OPTIMIZED = 2;
    public static final int VELOCITY_TRACKER_IMPL_SYSTEM = 1;

    /* JADX INFO: compiled from: VelocityTrackerFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/orecyclerview/base/VelocityTrackerFactory$Companion;", "", "()V", "VELOCITY_TRACKER_IMPL_OPTIMIZED", "", "VELOCITY_TRACKER_IMPL_SYSTEM", "create", "Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "context", "Landroid/content/Context;", "impl", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VelocityTracker create(Context r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            if (r2 == 1) goto L11;
            if (r2 != 2) goto L9;
            return new FluidVelocityTracker(r1);
        L9:
            throw new RuntimeException("impl is not supported");
        L11:
            return new SystemVelocityTrackerAdapter();
        }

        @JvmStatic
        public final VelocityTracker create(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return create(r2, 1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final VelocityTracker create(Context r1) {
        return Companion.create(r1);
    }

    @JvmStatic
    public static final VelocityTracker create(Context r1, int r2) {
        return Companion.create(r1, r2);
    }

    private VelocityTrackerFactory() {
    }
}
