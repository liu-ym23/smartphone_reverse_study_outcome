package androidx.window.embedding;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tJ(\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0007J(\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\tH\u0007J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0007J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\tH\u0007J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J*\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\u000fH\u0082\u0002¢\u0006\u0002\u0010 J*\u0010!\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001e\"\u0004\b\u0001\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\u000fH\u0082\u0002¢\u0006\u0002\u0010 ¨\u0006\""}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "()V", "translate", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "", "splitInfoList", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateActivityIntentPredicates", "Ljava/util/function/Predicate;", "Landroid/util/Pair;", "Landroid/app/Activity;", "Landroid/content/Intent;", "splitPairFilters", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityPairPredicates", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateIntentPredicates", "translateParentMetricsPredicate", "Landroid/view/WindowMetrics;", "splitRule", "Landroidx/window/embedding/SplitRule;", "component1", "F", "S", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmbeddingAdapter {
    public EmbeddingAdapter() {
    }

    public static /* synthetic */ boolean a(Set r0, Activity r1) {
        return m46translateActivityPredicates$lambda6(r0, r1);
    }

    public static /* synthetic */ boolean b(SplitRule r0, WindowMetrics r1) {
        return m48translateParentMetricsPredicate$lambda4(r0, r1);
    }

    public static /* synthetic */ boolean c(EmbeddingAdapter r0, Set r1, Pair r2) {
        return m44translateActivityIntentPredicates$lambda3(r0, r1, r2);
    }

    private final <F, S> F component1(Pair<F, S> r1) {
        o.f(r1, "<this>");
        return (F) r1.first;
    }

    private final <F, S> S component2(Pair<F, S> r1) {
        o.f(r1, "<this>");
        return (S) r1.second;
    }

    public static /* synthetic */ boolean d(EmbeddingAdapter r0, Set r1, Pair r2) {
        return m45translateActivityPairPredicates$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ boolean e(Set r0, Intent r1) {
        return m47translateIntentPredicates$lambda8(r0, r1);
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo r5) {
        androidx.window.extensions.embedding.ActivityStack r4 = r5.getPrimaryActivityStack();
        o.e(r4, "splitInfo.primaryActivityStack");
        boolean r0 = false;
        boolean r1 = r4.isEmpty();     // Catch: NoSuchMethodError -> L5
    L6:
        List r6 = r4.getActivities();
        o.e(r6, "primaryActivityStack.activities");
        ActivityStack r2 = new ActivityStack(r6, r1);
        androidx.window.extensions.embedding.ActivityStack r7 = r5.getSecondaryActivityStack();
        o.e(r7, "splitInfo.secondaryActivityStack");
        r0 = r7.isEmpty();     // Catch: NoSuchMethodError -> L10
    L8:
        List r8 = r7.getActivities();
        o.e(r8, "secondaryActivityStack.activities");
        return new SplitInfo(r2, new ActivityStack(r8, r0), r5.getSplitRatio());
    L5:
        r1 = false;
        goto L6
    }

    /* JADX INFO: renamed from: translateActivityIntentPredicates$lambda-3, reason: not valid java name */
    private static final boolean m44translateActivityIntentPredicates$lambda3(EmbeddingAdapter r2, Set r3, Pair r4) {
        o.f(r2, "this$0");
        o.f(r3, "$splitPairFilters");
        o.e(r4, "(first, second)");
        Activity r0 = (Activity) r2.component1(r4);
        Intent r5 = (Intent) r2.component2(r4);
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r3.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((SplitPairFilter) r6.next()).matchesActivityIntentPair(r0, r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }

    /* JADX INFO: renamed from: translateActivityPairPredicates$lambda-1, reason: not valid java name */
    private static final boolean m45translateActivityPairPredicates$lambda1(EmbeddingAdapter r2, Set r3, Pair r4) {
        o.f(r2, "this$0");
        o.f(r3, "$splitPairFilters");
        o.e(r4, "(first, second)");
        Activity r0 = (Activity) r2.component1(r4);
        Activity r5 = (Activity) r2.component2(r4);
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r6 = r3.iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        if (((SplitPairFilter) r6.next()).matchesActivityPair(r0, r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }

    /* JADX INFO: renamed from: translateActivityPredicates$lambda-6, reason: not valid java name */
    private static final boolean m46translateActivityPredicates$lambda6(Set r3, Activity r4) {
        o.f(r3, "$activityFilters");
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        ActivityFilter r0 = (ActivityFilter) r5.next();
        o.e(r4, "activity");
        if (r0.matchesActivity(r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }

    /* JADX INFO: renamed from: translateIntentPredicates$lambda-8, reason: not valid java name */
    private static final boolean m47translateIntentPredicates$lambda8(Set r3, Intent r4) {
        o.f(r3, "$activityFilters");
        if ((r3 instanceof Collection) == true) goto L5;
    L7:
        Iterator r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        ActivityFilter r0 = (ActivityFilter) r5.next();
        o.e(r4, "intent");
        if (r0.matchesIntent(r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r3.isEmpty() == false) goto L7;
        return false;
    }

    /* JADX INFO: renamed from: translateParentMetricsPredicate$lambda-4, reason: not valid java name */
    private static final boolean m48translateParentMetricsPredicate$lambda4(SplitRule r1, WindowMetrics r2) {
        o.f(r1, "$splitRule");
        o.e(r2, "windowMetrics");
        return r1.checkParentMetrics(r2);
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> r3) {
        o.f(r3, "splitInfoList");
        ArrayList r0 = new ArrayList(r.q(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(translate((androidx.window.extensions.embedding.SplitInfo) r4.next()));
        goto L4
    L6:
        return r0;
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Set<? extends EmbeddingRule> r8) {
        o.f(r8, "rules");
        ArrayList r0 = new ArrayList(r.q(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L19;
        EmbeddingRule r1 = (EmbeddingRule) r9.next();
        if ((r1 instanceof SplitPairRule) == false) goto L10;
        SplitPairRule r3 = (SplitPairRule) r1;
        androidx.window.extensions.embedding.SplitPairRule r2 = new androidx.window.extensions.embedding.SplitPairRule.Builder(translateActivityPairPredicates(r3.getFilters()), translateActivityIntentPredicates(r3.getFilters()), translateParentMetricsPredicate((SplitRule) r1)).setSplitRatio(r3.getSplitRatio()).setLayoutDirection(r3.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(r3.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(r3.getFinishSecondaryWithPrimary()).setShouldClearTop(r3.getClearTop()).build();
        String r4 = "SplitPairRuleBuilder(\n  …                 .build()";
    L8:
        o.e(r2, r4);
        r0.add((androidx.window.extensions.embedding.EmbeddingRule) r2);
        goto L4
    L10:
        if ((r1 instanceof SplitPlaceholderRule) == false) goto L13;
        SplitPlaceholderRule r5 = (SplitPlaceholderRule) r1;
        r2 = new androidx.window.extensions.embedding.SplitPlaceholderRule.Builder(r5.getPlaceholderIntent(), translateActivityPredicates(r5.getFilters()), translateIntentPredicates(r5.getFilters()), translateParentMetricsPredicate((SplitRule) r1)).setSplitRatio(r5.getSplitRatio()).setLayoutDirection(r5.getLayoutDirection()).build();
        r4 = "SplitPlaceholderRuleBuil…                 .build()";
        goto L8
    L13:
        if ((r1 instanceof ActivityRule) == false) goto L17;
        ActivityRule r6 = (ActivityRule) r1;
        r2 = new androidx.window.extensions.embedding.ActivityRule.Builder(translateActivityPredicates(r6.getFilters()), translateIntentPredicates(r6.getFilters())).setShouldAlwaysExpand(r6.getAlwaysExpand()).build();
        r4 = "ActivityRuleBuilder(\n   …                 .build()";
        goto L8
    L17:
        throw new IllegalArgumentException("Unsupported rule type");
    L19:
        return r.D0(r0);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(final Set<SplitPairFilter> r2) {
        o.f(r2, "splitPairFilters");
        return new c(this, r2);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(final Set<SplitPairFilter> r2) {
        o.f(r2, "splitPairFilters");
        return new d(this, r2);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Activity> translateActivityPredicates(final Set<ActivityFilter> r1) {
        o.f(r1, "activityFilters");
        return new a(r1);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Intent> translateIntentPredicates(final Set<ActivityFilter> r1) {
        o.f(r1, "activityFilters");
        return new e(r1);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(final SplitRule r1) {
        o.f(r1, "splitRule");
        return new b(r1);
    }
}
