package androidx.window.embedding;

import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0080\u0002¢\u0006\u0002\b\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitRule;", "filters", "", "Landroidx/window/embedding/ActivityFilter;", "placeholderIntent", "Landroid/content/Intent;", "minWidth", "", "minSmallestWidth", "splitRatio", "", "layoutDirection", "(Ljava/util/Set;Landroid/content/Intent;IIFI)V", "getFilters", "()Ljava/util/Set;", "getPlaceholderIntent", "()Landroid/content/Intent;", "equals", "", "other", "", "hashCode", "plus", "filter", "plus$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    public SplitPlaceholderRule(Set<ActivityFilter> r2, Intent r3, int r4, int r5, float r6, int r7) {
        o.f(r2, "filters");
        o.f(r3, "placeholderIntent");
        super(r4, r5, r6, r7);
        this.placeholderIntent = r3;
        this.filters = r.D0(r2);
    }

    public /* synthetic */ SplitPlaceholderRule(Set r10, Intent r11, int r12, int r13, float r14, int r15, int r16, g r17) {
        if ((r16 & 4) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r16 & 8) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r16 & 16) == 0) goto L13;
        float r7 = 0.5f;
    L15:
        if ((r16 & 32) == 0) goto L17;
        int r8 = 3;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitPlaceholderRule) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        SplitPlaceholderRule r6 = (SplitPlaceholderRule) r5;
        if (o.a(this.filters, r6.filters) == true) goto L18;
        return false;
    L18:
        if (o.a(this.placeholderIntent, r6.placeholderIntent) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter r10) {
        o.f(r10, "filter");
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll(this.filters);
        r0.add(r10);
        return new SplitPlaceholderRule(r.D0(r0), this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
