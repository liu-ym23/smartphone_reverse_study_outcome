package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(@NotNull SharedPreferences r1, boolean r2, @NotNull Function1<? super SharedPreferences.Editor, Unit> r3) {
        Intrinsics.g(r1, "$this$edit");
        Intrinsics.g(r3, "action");
        SharedPreferences.Editor r4 = r1.edit();
        Intrinsics.b(r4, "editor");
        r3.invoke(r4);
        if (r2 == false) goto L5;
        r4.commit();
        return;
    L5:
        r4.apply();
    }

    @SuppressLint({"ApplySharedPref"})
    public static /* synthetic */ void edit$default(SharedPreferences r0, boolean r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        Intrinsics.g(r0, "$this$edit");
        Intrinsics.g(r2, "action");
        SharedPreferences.Editor r5 = r0.edit();
        Intrinsics.b(r5, "editor");
        r2.invoke(r5);
        if (r1 == false) goto L8;
        r5.commit();
        return;
    L8:
        r5.apply();
    }
}
