package androidx.window.embedding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import androidx.window.R;
import androidx.window.core.ExperimentalWindowApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.t0;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J%\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ \u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¨\u0006\u001f"}, d2 = {"Landroidx/window/embedding/SplitRuleParser;", "", "()V", "buildClassName", "Landroid/content/ComponentName;", "pkg", "", "clsSeq", "", "parseActivityFilter", "Landroidx/window/embedding/ActivityFilter;", "context", "Landroid/content/Context;", "parser", "Landroid/content/res/XmlResourceParser;", "parseSplitActivityRule", "Landroidx/window/embedding/ActivityRule;", "parseSplitPairFilter", "Landroidx/window/embedding/SplitPairFilter;", "parseSplitPairRule", "Landroidx/window/embedding/SplitPairRule;", "parseSplitPlaceholderRule", "Landroidx/window/embedding/SplitPlaceholderRule;", "parseSplitRules", "", "Landroidx/window/embedding/EmbeddingRule;", "staticRuleResourceId", "", "parseSplitRules$window_release", "parseSplitXml", "splitResourceId", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitRuleParser {
    public SplitRuleParser() {
    }

    private final ComponentName buildClassName(String r10, CharSequence r11) {
        if (r11 == null) goto L24;
        if (r11.length() != 0) goto L6;
        boolean r9 = true;
    L7:
        if (r9 == true) goto L24;
        String r12 = r11.toString();
        if (r12.charAt(0) == '.') goto L11;
        int r13 = k.P(r12, '/', 0, false, 6, null);
        if (r13 <= 0) goto L16;
        r10 = r12.substring(0, r13);
        o.e(r10, "this as java.lang.String…ing(startIndex, endIndex)");
        r12 = r12.substring(r13 + 1);
        o.e(r12, "this as java.lang.String).substring(startIndex)");
    L16:
        if (o.a(r12, "*") == true) goto L22;
        if (k.P(r12, '.', 0, false, 6, null) >= 0) goto L22;
        return new ComponentName(r10, r10 + '.' + r12);
    L22:
        return new ComponentName(r10, r12);
    L11:
        return new ComponentName(r10, o.m(r10, r12));
    L6:
        r9 = false;
    L24:
        throw new IllegalArgumentException("Activity name must not be null");
    }

    private final ActivityFilter parseActivityFilter(Context r4, XmlResourceParser r5) {
        TypedArray r6 = r4.getTheme().obtainStyledAttributes(r5, R.styleable.ActivityFilter, 0, 0);
        String r0 = r6.getString(R.styleable.ActivityFilter_activityName);
        String r7 = r6.getString(R.styleable.ActivityFilter_activityAction);
        String r8 = r4.getApplicationContext().getPackageName();
        o.e(r8, "packageName");
        return new ActivityFilter(buildClassName(r8, r0), r7);
    }

    private final ActivityRule parseSplitActivityRule(Context r2, XmlResourceParser r3) {
        boolean r1 = r2.getTheme().obtainStyledAttributes(r3, R.styleable.ActivityRule, 0, 0).getBoolean(R.styleable.ActivityRule_alwaysExpand, false);
        return new ActivityRule(t0.b(), r1);
    }

    private final SplitPairFilter parseSplitPairFilter(Context r4, XmlResourceParser r5) {
        TypedArray r6 = r4.getTheme().obtainStyledAttributes(r5, R.styleable.SplitPairFilter, 0, 0);
        String r0 = r6.getString(R.styleable.SplitPairFilter_primaryActivityName);
        String r1 = r6.getString(R.styleable.SplitPairFilter_secondaryActivityName);
        String r7 = r6.getString(R.styleable.SplitPairFilter_secondaryActivityAction);
        String r8 = r4.getApplicationContext().getPackageName();
        o.e(r8, "packageName");
        return new SplitPairFilter(buildClassName(r8, r0), buildClassName(r8, r1), r7);
    }

    private final SplitPairRule parseSplitPairRule(Context r11, XmlResourceParser r12) {
        TypedArray r10 = r11.getTheme().obtainStyledAttributes(r12, R.styleable.SplitPairRule, 0, 0);
        float r8 = r10.getFloat(R.styleable.SplitPairRule_splitRatio, 0.0f);
        int r6 = (int) r10.getDimension(R.styleable.SplitPairRule_splitMinWidth, 0.0f);
        int r7 = (int) r10.getDimension(R.styleable.SplitPairRule_splitMinSmallestWidth, 0.0f);
        int r9 = r10.getInt(R.styleable.SplitPairRule_splitLayoutDirection, 3);
        boolean r3 = r10.getBoolean(R.styleable.SplitPairRule_finishPrimaryWithSecondary, false);
        boolean r4 = r10.getBoolean(R.styleable.SplitPairRule_finishSecondaryWithPrimary, true);
        boolean r5 = r10.getBoolean(R.styleable.SplitPairRule_clearTop, false);
        return new SplitPairRule(t0.b(), r3, r4, r5, r6, r7, r8, r9);
    }

    private final SplitPlaceholderRule parseSplitPlaceholderRule(Context r11, XmlResourceParser r12) {
        TypedArray r13 = r11.getTheme().obtainStyledAttributes(r12, R.styleable.SplitPlaceholderRule, 0, 0);
        String r0 = r13.getString(R.styleable.SplitPlaceholderRule_placeholderActivityName);
        float r8 = r13.getFloat(R.styleable.SplitPlaceholderRule_splitRatio, 0.0f);
        int r6 = (int) r13.getDimension(R.styleable.SplitPlaceholderRule_splitMinWidth, 0.0f);
        int r7 = (int) r13.getDimension(R.styleable.SplitPlaceholderRule_splitMinSmallestWidth, 0.0f);
        int r9 = r13.getInt(R.styleable.SplitPlaceholderRule_splitLayoutDirection, 3);
        String r14 = r11.getApplicationContext().getPackageName();
        o.e(r14, "packageName");
        ComponentName r10 = buildClassName(r14, r0);
        Set r4 = t0.b();
        Intent r5 = new Intent().setComponent(r10);
        o.e(r5, "Intent().setComponent(pl…eholderActivityClassName)");
        return new SplitPlaceholderRule(r4, r5, r6, r7, r8, r9);
    }

    private final Set<EmbeddingRule> parseSplitXml(Context r9, int r10) {
        XmlResourceParser r11 = r9.getResources().getXml(r10);     // Catch: Resources.NotFoundException -> L58
        o.e(r11, "resources.getXml(splitResourceId)");     // Catch: Resources.NotFoundException -> L58
        HashSet r0 = new HashSet();
        int r2 = r11.getDepth();
        int r3 = r11.next();
        ActivityRule r4 = null;
        SplitPairRule r5 = null;
        SplitPlaceholderRule r6 = null;
    L6:
        if (r3 == 1) goto L57;
        if (r3 != 3) goto L12;
        if (r11.getDepth() <= r2) goto L57;
    L12:
        if (r11.getEventType() != 2) goto L56;
        if (o.a("split-config", r11.getName()) == true) goto L56;
        String r7 = r11.getName();
        if (r7 == null) goto L56;
        switch(r7.hashCode()) {
            case 511422343: goto L44;
            case 520447504: goto L39;
            case 1579230604: goto L32;
            case 1793077963: goto L27;
            case 2050988213: goto L22;
            default: goto L56;
        };
    L22:
        if (r7.equals("SplitPlaceholderRule") == false) goto L56;
        SplitPlaceholderRule r8 = parseSplitPlaceholderRule(r9, r11);
        r0.add(r8);
        r4 = null;
        r5 = null;
    L25:
        r6 = r8;
        goto L56
    L27:
        if (r7.equals("ActivityRule") == false) goto L56;
        ActivityRule r12 = parseSplitActivityRule(r9, r11);
        r0.add(r12);
        r5 = null;
        r6 = null;
    L30:
        r4 = r12;
        goto L56
    L32:
        if (r7.equals("SplitPairFilter") == false) goto L56;
        if (r5 == null) goto L37;
        SplitPairFilter r13 = parseSplitPairFilter(r9, r11);
        r0.remove(r5);
        SplitPairRule r14 = r5.plus$window_release(r13);
        r0.add(r14);
    L42:
        r5 = r14;
        goto L56
    L37:
        throw new IllegalArgumentException("Found orphaned SplitPairFilter outside of SplitPairRule");
    L39:
        if (r7.equals("SplitPairRule") == false) goto L56;
        r14 = parseSplitPairRule(r9, r11);
        r0.add(r14);
        r4 = null;
        r6 = null;
        goto L42
    L44:
        if (r7.equals("ActivityFilter") == false) goto L56;
        if (r4 != null) goto L51;
        if (r6 != null) goto L51;
        throw new IllegalArgumentException("Found orphaned ActivityFilter");
    L51:
        ActivityFilter r15 = parseActivityFilter(r9, r11);
        if (r4 == null) goto L54;
        r0.remove(r4);
        r12 = r4.plus$window_release(r15);
        r0.add(r12);
        goto L30
    L54:
        if (r6 == null) goto L56;
        r0.remove(r6);
        r8 = r6.plus$window_release(r15);
        r0.add(r8);
    L56:
        r3 = r11.next();
    L57:
        return r0;
    L58:
        return null;
    }

    public final Set<EmbeddingRule> parseSplitRules$window_release(Context r2, int r3) {
        o.f(r2, "context");
        return parseSplitXml(r2, r3);
    }
}
