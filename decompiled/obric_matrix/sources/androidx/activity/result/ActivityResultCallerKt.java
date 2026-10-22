package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000b\u001aY\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00072\u0006\u0010\b\u001a\u0002H\u00032\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "", "I", "O", "Landroidx/activity/result/ActivityResultCaller;", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "input", "callback", "Lkotlin/Function1;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "registry", "Landroidx/activity/result/ActivityResultRegistry;", "(Landroidx/activity/result/ActivityResultCaller;Landroidx/activity/result/contract/ActivityResultContract;Ljava/lang/Object;Landroidx/activity/result/ActivityResultRegistry;Lkotlin/jvm/functions/Function1;)Landroidx/activity/result/ActivityResultLauncher;", "activity-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ActivityResultCallerKt {
    public static /* synthetic */ void a(l r0, Object r1) {
        m4registerForActivityResult$lambda1(r0, r1);
    }

    public static /* synthetic */ void b(l r0, Object r1) {
        m3registerForActivityResult$lambda0(r0, r1);
    }

    public static final <I, O> ActivityResultLauncher<f0> registerForActivityResult(ActivityResultCaller r1, ActivityResultContract<I, O> r2, I r3, ActivityResultRegistry r4, final l<? super O, f0> r5) {
        o.f(r1, "<this>");
        o.f(r2, "contract");
        o.f(r4, "registry");
        o.f(r5, "callback");
        ActivityResultLauncher<I> r6 = r1.registerForActivityResult(r2, r4, new b(r5));
        o.e(r6, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCallerLauncher(r6, r2, r3);
    }

    public static final <I, O> ActivityResultLauncher<f0> registerForActivityResult(ActivityResultCaller r1, ActivityResultContract<I, O> r2, I r3, final l<? super O, f0> r4) {
        o.f(r1, "<this>");
        o.f(r2, "contract");
        o.f(r4, "callback");
        ActivityResultLauncher<I> r5 = r1.registerForActivityResult(r2, new a(r4));
        o.e(r5, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCallerLauncher(r5, r2, r3);
    }

    /* JADX INFO: renamed from: registerForActivityResult$lambda-0, reason: not valid java name */
    private static final void m3registerForActivityResult$lambda0(l r1, Object r2) {
        o.f(r1, "$callback");
        r1.invoke(r2);
    }

    /* JADX INFO: renamed from: registerForActivityResult$lambda-1, reason: not valid java name */
    private static final void m4registerForActivityResult$lambda1(l r1, Object r2) {
        o.f(r1, "$callback");
        r1.invoke(r2);
    }
}
