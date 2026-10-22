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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "()V", "sDebugMatchers", "", "sMatchersTag", "", "areActivityOrIntentComponentsMatching", "activity", "Landroid/app/Activity;", "ruleComponent", "Landroid/content/ComponentName;", "areActivityOrIntentComponentsMatching$window_release", "areComponentsMatching", "activityComponent", "areComponentsMatching$window_release", "wildcardMatch", "name", "pattern", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = null;
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    static {
        INSTANCE = new MatcherUtils();
    }

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String r12, String r13) {
        if (k.F(r13, "*", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (o.a(r13, "*") == false) goto L9;
        return true;
    L9:
        if (k.Q(r13, "*", 0, false, 6, null) == k.V(r13, "*", 0, false, 6, null)) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == false) goto L18;
        String r14 = r13.substring(0, r13.length() - 1);
        o.e(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        return k.A(r12, r14, false, 2, null);
    L18:
        throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
    L11:
        if (k.n(r13, "*", false, 2, null) == false) goto L13;
        r11 = true;
        goto L14
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity r2, ComponentName r3) {
        o.f(r2, "activity");
        o.f(r3, "ruleComponent");
        if (areComponentsMatching$window_release(r2.getComponentName(), r3) == false) goto L6;
        return true;
    L6:
        Intent r1 = r2.getIntent();
        if (r1 == null) goto L14;
        ComponentName r4 = r1.getComponent();
        if (r4 != null) goto L13;
        return false;
    L13:
        return INSTANCE.areComponentsMatching$window_release(r4, r3);
    L14:
        return false;
    }

    public final boolean areComponentsMatching$window_release(ComponentName r7, ComponentName r8) {
        o.f(r8, "ruleComponent");
        if (r7 == null) goto L5;
        String r3 = r7.toString();
        o.e(r3, "activityComponent.toString()");
        if ((!k.F(r3, "*", false, 2, null)) == false) goto L33;
        if (o.a(r7.getPackageName(), r8.getPackageName()) == true) goto L19;
        String r0 = r7.getPackageName();
        o.e(r0, "activityComponent.packageName");
        String r4 = r8.getPackageName();
        o.e(r4, "ruleComponent.packageName");
        if (wildcardMatch(r0, r4) == true) goto L19;
        boolean r1 = false;
    L21:
        if (o.a(r7.getClassName(), r8.getClassName()) == true) goto L26;
        String r9 = r7.getClassName();
        o.e(r9, "activityComponent.className");
        String r10 = r8.getClassName();
        o.e(r10, "ruleComponent.className");
        if (wildcardMatch(r9, r10) == true) goto L26;
        boolean r6 = false;
    L27:
        if (r1 == false) goto L31;
        if (r6 == false) goto L31;
        return true;
    L31:
        return false;
    L26:
        r6 = true;
    L19:
        r1 = true;
        goto L21
    L33:
        throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
    L5:
        if (o.a(r8.getPackageName(), "*") == false) goto L10;
        if (o.a(r8.getClassName(), "*") == false) goto L10;
        return true;
    L10:
        return false;
    }
}
