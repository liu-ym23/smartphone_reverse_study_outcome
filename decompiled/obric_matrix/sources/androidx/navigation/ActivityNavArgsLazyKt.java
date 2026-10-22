package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.MainThread;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\u0087\b¨\u0006\u0005"}, d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroid/app/Activity;", "navigation-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActivityNavArgsLazyKt {

    /* JADX INFO: renamed from: androidx.navigation.ActivityNavArgsLazyKt$navArgs$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends q implements kotlin.n0.c.a<Bundle> {
        final /* synthetic */ Activity $this_navArgs;

        public AnonymousClass1(Activity r1) {
            this.$this_navArgs = r1;
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Bundle invoke() {
            Intent r0 = this.$this_navArgs.getIntent();
            if (r0 == null) goto L9;
            Activity r2 = this.$this_navArgs;
            Bundle r3 = r0.getExtras();
            if (r3 == null) goto L8;
        L10:
            if (r3 == null) goto L13;
            return r3;
        L13:
            throw new IllegalStateException("Activity " + this.$this_navArgs + " has a null Intent");
        L8:
            throw new IllegalStateException("Activity " + r2 + " has null extras in " + r0);
        L9:
            r3 = null;
            goto L10
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Bundle invoke() {
            return invoke();
        }
    }

    @MainThread
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Activity r1) {
        o.f(r1, "<this>");
        o.j(4, "Args");
        throw null;
    }
}
