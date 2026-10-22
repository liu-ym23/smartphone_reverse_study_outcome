package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/window/embedding/SplitPairFilter;", "", "primaryActivityName", "Landroid/content/ComponentName;", "secondaryActivityName", "secondaryActivityIntentAction", "", "(Landroid/content/ComponentName;Landroid/content/ComponentName;Ljava/lang/String;)V", "getPrimaryActivityName", "()Landroid/content/ComponentName;", "getSecondaryActivityIntentAction", "()Ljava/lang/String;", "getSecondaryActivityName", "equals", "", "other", "hashCode", "", "matchesActivityIntentPair", "primaryActivity", "Landroid/app/Activity;", "secondaryActivityIntent", "Landroid/content/Intent;", "matchesActivityPair", "secondaryActivity", "toString", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName r13, ComponentName r14, String r15) {
        o.f(r13, "primaryActivityName");
        o.f(r14, "secondaryActivityName");
        this.primaryActivityName = r13;
        this.secondaryActivityName = r14;
        this.secondaryActivityIntentAction = r15;
        String r12 = r13.getPackageName();
        o.e(r12, "primaryActivityName.packageName");
        String r16 = r13.getClassName();
        o.e(r16, "primaryActivityName.className");
        String r17 = r14.getPackageName();
        o.e(r17, "secondaryActivityName.packageName");
        String r18 = r14.getClassName();
        o.e(r18, "secondaryActivityName.className");
        boolean r7 = true;
        if (r12.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L73;
        if (r16.length() != 0) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == false) goto L21;
    L26:
        boolean r3 = false;
    L27:
        if (r3 == false) goto L71;
        if (k.F(r12, "*", false, 2, null) == true) goto L31;
    L34:
        boolean r19 = true;
    L36:
        if (r19 == false) goto L69;
        if (k.F(r16, "*", false, 2, null) == true) goto L40;
    L43:
        boolean r110 = true;
    L45:
        if (r110 == false) goto L67;
        if (k.F(r17, "*", false, 2, null) == true) goto L49;
    L52:
        boolean r111 = true;
    L53:
        if (r111 == false) goto L65;
        if (k.F(r18, "*", false, 2, null) == true) goto L57;
    L60:
        if (r7 == false) goto L63;
        return;
    L63:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L57:
        if (k.Q(r18, "*", 0, false, 6, null) == (r18.length() - 1)) goto L60;
        r7 = false;
        goto L60
    L65:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L49:
        if (k.Q(r17, "*", 0, false, 6, null) == (r17.length() - 1)) goto L52;
        r111 = false;
        goto L53
    L67:
        throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
    L40:
        if (k.Q(r16, "*", 0, false, 6, null) == (r16.length() - 1)) goto L43;
        r110 = false;
        goto L45
    L69:
        throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
    L31:
        if (k.Q(r12, "*", 0, false, 6, null) == (r12.length() - 1)) goto L34;
        r19 = false;
        goto L36
    L71:
        throw new IllegalArgumentException("Activity class name must not be empty.".toString());
    L21:
        if (r18.length() != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L26;
        r3 = true;
        goto L27
    L23:
        r4 = false;
        goto L24
    L18:
        r2 = false;
        goto L19
    L73:
        throw new IllegalArgumentException("Package name must not be empty".toString());
    L8:
        if (r17.length() != 0) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
        r1 = true;
        goto L14
    L10:
        r5 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitPairFilter) == true) goto L8;
        return false;
    L8:
        SplitPairFilter r6 = (SplitPairFilter) r5;
        if (o.a(this.primaryActivityName, r6.primaryActivityName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.secondaryActivityName, r6.secondaryActivityName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.secondaryActivityIntentAction, r6.secondaryActivityIntentAction) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int r0 = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String r2 = this.secondaryActivityIntentAction;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final boolean matchesActivityIntentPair(Activity r4, Intent r5) {
        o.f(r4, "primaryActivity");
        o.f(r5, "secondaryActivityIntent");
        ComponentName r6 = r4.getComponentName();
        MatcherUtils r0 = MatcherUtils.INSTANCE;
        if (r0.areComponentsMatching$window_release(r6, this.primaryActivityName) == true) goto L6;
        return false;
    L6:
        if (r0.areComponentsMatching$window_release(r5.getComponent(), this.secondaryActivityName) == false) goto L16;
        String r3 = this.secondaryActivityIntentAction;
        if (r3 != null) goto L11;
    L12:
        return true;
    L11:
        if (o.a(r3, r5.getAction()) == true) goto L12;
        return false;
    L16:
        return false;
    }

    public final boolean matchesActivityPair(Activity r6, Activity r7) {
        o.f(r6, "primaryActivity");
        o.f(r7, "secondaryActivity");
        MatcherUtils r0 = MatcherUtils.INSTANCE;
        boolean r2 = true;
        if (r0.areComponentsMatching$window_release(r6.getComponentName(), this.primaryActivityName) == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r7.getIntent() == null) goto L17;
        if (r1 == false) goto L14;
        Intent r8 = r7.getIntent();
        o.e(r8, "secondaryActivity.intent");
        if (matchesActivityIntentPair(r6, r8) == false) goto L14;
    L16:
        return r2;
    L14:
        r2 = false;
        goto L16
    L17:
        return r1;
    L5:
        if (r0.areComponentsMatching$window_release(r7.getComponentName(), this.secondaryActivityName) == false) goto L7;
        r1 = true;
        goto L9
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
