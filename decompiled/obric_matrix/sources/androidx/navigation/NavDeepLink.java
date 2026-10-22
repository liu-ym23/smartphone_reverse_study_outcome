package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u0.i;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 F2\u00020\u0001:\u0004EFGHB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ$\u0010)\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010*\u001a\u00060+j\u0002`,2\u0006\u0010-\u001a\u00020\u001cH\u0002J\u0013\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J(\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010504H\u0007J\u0010\u00106\u001a\u0002072\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u00108\u001a\u000207H\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010:\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010;\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u000103H\u0002J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u000203H\u0000¢\u0006\u0002\b=J\u0015\u0010<\u001a\u00020\u00122\u0006\u0010>\u001a\u00020?H\u0000¢\u0006\u0002\b=J*\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\b\u0010D\u001a\u0004\u0018\u000105H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR\u0010\u0010'\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\n¨\u0006I"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "uri", "", "(Ljava/lang/String;)V", "uriPattern", "action", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "arguments", "", "argumentsNames", "", "getArgumentsNames$navigation_common_release", "()Ljava/util/List;", "<set-?>", "", "isExactDeepLink", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isParameterizedQuery", "isSingleQueryParamValueOnly", "getMimeType", "mimeTypeFinalRegex", "mimeTypePattern", "Ljava/util/regex/Pattern;", "getMimeTypePattern", "()Ljava/util/regex/Pattern;", "mimeTypePattern$delegate", "Lkotlin/Lazy;", "paramArgMap", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "pattern", "getPattern", "pattern$delegate", "patternFinalRegex", "getUriPattern", "buildPathRegex", "uriRegex", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "fillInPattern", "equals", "other", "getMatchingArguments", "Landroid/os/Bundle;", "deepLink", "Landroid/net/Uri;", "", "Landroidx/navigation/NavArgument;", "getMimeTypeMatchRating", "", "hashCode", "matchAction", "matchMimeType", "matchUri", "matches", "matches$navigation_common_release", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "parseArgument", "bundle", "name", "value", "argument", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLink {
    private static final Companion Companion = null;

    @Deprecated
    private static final Pattern SCHEME_PATTERN = null;
    private final String action;
    private final List<String> arguments;
    private boolean isExactDeepLink;
    private boolean isParameterizedQuery;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;
    private String mimeTypeFinalRegex;
    private final h mimeTypePattern$delegate;
    private final Map<String, ParamQuery> paramArgMap;
    private final h pattern$delegate;
    private String patternFinalRegex;
    private final String uriPattern;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        private String action;
        private String mimeType;
        private String uriPattern;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g r1) {
                this();
            }

            public final Builder fromAction(String r1) {
                o.f(r1, "action");
                if (r1.length() <= 0) goto L5;
                boolean r0 = true;
            L6:
                if (r0 == false) goto L10;
                Builder r2 = new Builder();
                r2.setAction(r1);
                return r2;
            L10:
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            L5:
                r0 = false;
                goto L6
            }

            public final Builder fromMimeType(String r1) {
                o.f(r1, "mimeType");
                Builder r0 = new Builder();
                r0.setMimeType(r1);
                return r0;
            }

            public final Builder fromUriPattern(String r1) {
                o.f(r1, "uriPattern");
                Builder r0 = new Builder();
                r0.setUriPattern(r1);
                return r0;
            }
        }

        static {
            Companion = new Companion(null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder() {
        }

        public static final Builder fromAction(String r1) {
            return Companion.fromAction(r1);
        }

        public static final Builder fromMimeType(String r1) {
            return Companion.fromMimeType(r1);
        }

        public static final Builder fromUriPattern(String r1) {
            return Companion.fromUriPattern(r1);
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        public final Builder setAction(String r2) {
            o.f(r2, "action");
            if (r2.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.action = r2;
            return this;
        L10:
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final Builder setMimeType(String r2) {
            o.f(r2, "mimeType");
            this.mimeType = r2;
            return this;
        }

        public final Builder setUriPattern(String r2) {
            o.f(r2, "uriPattern");
            this.uriPattern = r2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", WsConstants.KEY_CONNECTION_TYPE, "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String r5) {
            o.f(r5, "mimeType");
            List<String> r6 = new i("/").f(r5, 0);
            if (r6.isEmpty() == true) goto L13;
            ListIterator<String> r0 = r6.listIterator(r6.size());
        L6:
            if (r0.hasPrevious() == false) goto L13;
            if (r0.previous().length() != 0) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == true) goto L6;
            List r7 = r.t0(r6, r0.nextIndex() + 1);
        L14:
            this.type = (String) r7.get(0);
            this.subType = (String) r7.get(1);
            return;
        L10:
            r3 = false;
        L13:
            r7 = r.g();
            goto L14
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(MimeType r3) {
            o.f(r3, "other");
            if (o.a(this.type, r3.type) == false) goto L5;
            int r0 = 2;
        L7:
            if (o.a(this.subType, r3.subType) == true) goto L9;
            return r0;
        L9:
            return r0 + 1;
        L5:
            r0 = 0;
            goto L7
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(MimeType r1) {
            return compareTo2(r1);
        }

        public final String getSubType() {
            return this.subType;
        }

        public final String getType() {
            return this.type;
        }

        public final void setSubType(String r2) {
            o.f(r2, "<set-?>");
            this.subType = r2;
        }

        public final void setType(String r2) {
            o.f(r2, "<set-?>");
            this.type = r2;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "()V", "arguments", "", "", "getArguments", "()Ljava/util/List;", "paramRegex", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "(Ljava/lang/String;)V", "addArgumentName", "", "name", "getArgumentName", "index", "", "size", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class ParamQuery {
        private final List<String> arguments;
        private String paramRegex;

        public ParamQuery() {
            this.arguments = new ArrayList();
        }

        public final void addArgumentName(String r2) {
            o.f(r2, "name");
            this.arguments.add(r2);
        }

        public final String getArgumentName(int r1) {
            return this.arguments.get(r1);
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String r1) {
            this.paramRegex = r1;
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    static {
        Companion = new Companion(null);
        SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLink(String r2) {
        o.f(r2, "uri");
        this(r2, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.regex.Matcher] */
    /* JADX WARN: Type inference failed for: r19v0, types: [androidx.navigation.NavDeepLink] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4, types: [int] */
    public NavDeepLink(String r20, String r21, String r22) {
        this.uriPattern = r20;
        this.action = r21;
        this.mimeType = r22;
        this.arguments = new ArrayList();
        this.paramArgMap = new LinkedHashMap();
        this.pattern$delegate = kotlin.i.b(new NavDeepLink$pattern$2(this));
        this.mimeTypePattern$delegate = kotlin.i.b(new NavDeepLink$mimeTypePattern$2(this));
        if (r20 == null) goto L33;
        Uri r2 = Uri.parse(r20);
        boolean r4 = true;
        if (r2.getQuery() == null) goto L7;
        boolean r3 = true;
    L8:
        this.isParameterizedQuery = r3;
        StringBuilder r5 = new StringBuilder("^");
        if (SCHEME_PATTERN.matcher(r20).find() == true) goto L11;
        r5.append("http[s]?://");
    L11:
        Pattern r6 = Pattern.compile("\\{(.+?)\\}");
        if (this.isParameterizedQuery == false) goto L30;
        Matcher r7 = Pattern.compile("(\\?)").matcher(r20);
        if (r7.find() == false) goto L16;
        String r1 = r20.substring(0, r7.start());
        o.e(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        o.e(r6, "fillInPattern");
        this.isExactDeepLink = buildPathRegex(r1, r5, r6);
    L16:
        Iterator<String> r8 = r2.getQueryParameterNames().iterator();
    L18:
        if (r8.hasNext() == false) goto L31;
        String r9 = r8.next();
        StringBuilder r10 = new StringBuilder();
        String r11 = r2.getQueryParameter(r9);
        if (r11 != null) goto L22;
        this.isSingleQueryParamValueOnly = r4;
        r11 = r9;
    L22:
        ?? r12 = r6.matcher(r11);
        ParamQuery r13 = new ParamQuery();
        int r14 = 0;
        ?? r15 = r4;
    L24:
        if (r12.find() == false) goto L27;
        String r16 = r12.group(r15);
        Objects.requireNonNull(r16, "null cannot be cast to non-null type kotlin.String");
        r13.addArgumentName(r16);
        o.e(r11, "queryParam");
        String r17 = r11.substring(r14, r12.start());
        o.e(r17, "this as java.lang.String…ing(startIndex, endIndex)");
        r10.append(Pattern.quote(r17));
        r10.append("(.+?)?");
        r14 = r12.end();
        r15 = 1;
        goto L24
    L27:
        if (r14 >= r11.length()) goto L29;
        o.e(r11, "queryParam");
        String r18 = r11.substring(r14);
        o.e(r18, "this as java.lang.String).substring(startIndex)");
        r10.append(Pattern.quote(r18));
    L29:
        String r19 = r10.toString();
        o.e(r19, "argRegex.toString()");
        r13.setParamRegex(k.w(r19, ".*", "\\E.*\\Q", false, 4, null));
        Map<String, ParamQuery> r23 = this.paramArgMap;
        o.e(r9, "paramName");
        r23.put(r9, r13);
        r4 = true;
    L31:
        String r24 = r5.toString();
        o.e(r24, "uriRegex.toString()");
        this.patternFinalRegex = k.w(r24, ".*", "\\E.*\\Q", false, 4, null);
        goto L33
    L30:
        o.e(r6, "fillInPattern");
        this.isExactDeepLink = buildPathRegex(r20, r5, r6);
        goto L31
    L7:
        r3 = false;
    L33:
        if (this.mimeType != null) goto L35;
        return;
    L35:
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches() == false) goto L38;
        MimeType r25 = new MimeType(this.mimeType);
        this.mimeTypeFinalRegex = k.w("^(" + r25.getType() + "|[*]+)/(" + r25.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
        return;
    L38:
        throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
    }

    public static final /* synthetic */ String access$getMimeTypeFinalRegex$p(NavDeepLink r0) {
        return r0.mimeTypeFinalRegex;
    }

    public static final /* synthetic */ String access$getPatternFinalRegex$p(NavDeepLink r0) {
        return r0.patternFinalRegex;
    }

    private final boolean buildPathRegex(String r6, StringBuilder r7, Pattern r8) {
        Matcher r9 = r8.matcher(r6);
        boolean r0 = !k.F(r6, ".*", false, 2, null);
        int r3 = 0;
    L4:
        if (r9.find() == false) goto L7;
        String r1 = r9.group(1);
        Objects.requireNonNull(r1, "null cannot be cast to non-null type kotlin.String");
        this.arguments.add(r1);
        String r2 = r6.substring(r3, r9.start());
        o.e(r2, "this as java.lang.String…ing(startIndex, endIndex)");
        r7.append(Pattern.quote(r2));
        r7.append("([^/]+?)");
        r3 = r9.end();
        r0 = false;
        goto L4
    L7:
        if (r3 >= r6.length()) goto L9;
        String r5 = r6.substring(r3);
        o.e(r5, "this as java.lang.String).substring(startIndex)");
        r7.append(Pattern.quote(r5));
    L9:
        r7.append("($|(\\?(.)*)|(\\#(.)*))");
        return r0;
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    private final Pattern getPattern() {
        return (Pattern) this.pattern$delegate.getValue();
    }

    private final boolean matchAction(String r5) {
        if (r5 != null) goto L5;
        boolean r2 = true;
    L6:
        String r4 = this.action;
        if (r4 == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L15;
        if (r5 != null) goto L14;
        return true;
    L14:
        if (o.a(r4, r5) == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private final boolean matchMimeType(String r5) {
        if (r5 != null) goto L5;
        boolean r2 = true;
    L7:
        if (this.mimeType == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L15;
        if (r5 == null) goto L16;
        Pattern r4 = getMimeTypePattern();
        o.c(r4);
        if (r4.matcher(r5).matches() == false) goto L15;
        return true;
    L16:
        return true;
    L15:
        return false;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    private final boolean matchUri(Uri r5) {
        if (r5 != null) goto L5;
        boolean r2 = true;
    L7:
        if (getPattern() == null) goto L9;
        boolean r3 = true;
    L10:
        if (r2 == r3) goto L15;
        if (r5 == null) goto L16;
        Pattern r4 = getPattern();
        o.c(r4);
        if (r4.matcher(r5.toString()).matches() == false) goto L15;
        return true;
    L16:
        return true;
    L15:
        return false;
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    private final boolean parseArgument(Bundle r1, String r2, String r3, NavArgument r4) {
        if (r4 == null) goto L4;
        r4.getType().parseAndPut(r1, r2, r3);
        return false;
    L4:
        r1.putString(r2, r3);
        return false;
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if ((r4 instanceof NavDeepLink) == false) goto L19;
        NavDeepLink r5 = (NavDeepLink) r4;
        if (o.a(this.uriPattern, r5.uriPattern) == true) goto L10;
        return false;
    L10:
        if (o.a(this.action, r5.action) == true) goto L12;
        return false;
    L12:
        if (o.a(this.mimeType, r5.mimeType) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public final String getAction() {
        return this.action;
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> r0 = this.arguments;
        Collection<ParamQuery> r3 = this.paramArgMap.values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r.v(r1, ((ParamQuery) r4.next()).getArguments());
        goto L4
    L7:
        return r.k0(r0, r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle getMatchingArguments(Uri r17, Map<String, NavArgument> r18) {
        o.f(r17, "deepLink");
        o.f(r18, "arguments");
        Pattern r3 = getPattern();
        if (r3 == null) goto L5;
        Matcher r4 = r3.matcher(r17.toString());
    L6:
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r4.matches() == true) goto L11;
        return null;
    L11:
        Bundle r5 = new Bundle();
        int r6 = this.arguments.size();
        int r8 = 0;
    L12:
        if (r8 >= r6) goto L18;
        String r9 = this.arguments.get(r8);
        r8 = r8 + 1;
        String r10 = Uri.decode(r4.group(r8));
        NavArgument r11 = r18.get(r9);
        o.e(r10, "value");     // Catch: IllegalArgumentException -> L66
        if (parseArgument(r5, r9, r10, r11) == false) goto L12;
    L16:
        return null;
    L18:
        if (this.isParameterizedQuery == false) goto L50;
        Iterator<String> r7 = this.paramArgMap.keySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L50;
        String r12 = r7.next();
        ParamQuery r13 = this.paramArgMap.get(r12);
        String r14 = r17.getQueryParameter(r12);
        if (this.isSingleQueryParamValueOnly == false) goto L27;
        String r15 = r17.toString();
        o.e(r15, "deepLink.toString()");
        String r16 = k.x0(r15, '?', null, 2, null);
        if (o.a(r16, r15) == true) goto L27;
        r14 = r16;
    L27:
        if (r14 == null) goto L31;
        o.c(r13);
        Matcher r19 = Pattern.compile(r13.getParamRegex(), 32).matcher(r14);
        if (r19.matches() == false) goto L30;
    L32:
        Bundle r20 = new Bundle();
        o.c(r13);     // Catch: IllegalArgumentException -> L67
        int r110 = r13.size();     // Catch: IllegalArgumentException -> L67
        int r111 = 0;
    L34:
        if (r111 >= r110) goto L48;
        if (r19 == null) goto L39;
        String r112 = r19.group(r111 + 1);     // Catch: IllegalArgumentException -> L67
        if (r112 != null) goto L40;
        r112 = "";
    L40:
        String r113 = r13.getArgumentName(r111);     // Catch: IllegalArgumentException -> L67
        NavArgument r114 = r18.get(r113);     // Catch: IllegalArgumentException -> L67
        if (r112 == null) goto L47;
        if (o.a(r112, '{' + r113 + '}') == true) goto L47;
        if (parseArgument(r20, r113, r112, r114) == false) goto L47;
        return null;
    L47:
        r111 = r111 + 1;     // Catch: IllegalArgumentException -> L67
        goto L34
    L39:
        r112 = null;
        goto L40
    L48:
        r5.putAll(r20);     // Catch: IllegalArgumentException -> L67
        goto L21
    L30:
        return null;
    L31:
        r19 = null;
    L50:
        Iterator<Map.Entry<String, NavArgument>> r0 = r18.entrySet().iterator();
    L52:
        if (r0.hasNext() == false) goto L65;
        Map.Entry<String, NavArgument> r1 = r0.next();
        String r2 = r1.getKey();
        NavArgument r21 = r1.getValue();
        if (r21 != null) goto L56;
    L60:
        boolean r22 = false;
    L61:
        if (r22 == false) goto L52;
        if (r5.containsKey(r2) == true) goto L52;
        return null;
    L56:
        if (r21.isNullable() == true) goto L60;
        if (r21.isDefaultValuePresent() == true) goto L60;
        r22 = true;
        goto L61
    L65:
        return r5;
    L5:
        r4 = null;
        goto L6
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMimeTypeMatchRating(String r2) {
        o.f(r2, "mimeType");
        if (this.mimeType == null) goto L8;
        Pattern r0 = getMimeTypePattern();
        o.c(r0);
        if (r0.matcher(r2).matches() == false) goto L8;
        return new MimeType(this.mimeType).compareTo2(new MimeType(r2));
    L8:
        return -1;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        String r0 = this.uriPattern;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = (r2 + 0) * 31;
        String r4 = this.action;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.mimeType;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(Uri r3) {
        o.f(r3, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(r3, null, null));
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest r3) {
        o.f(r3, "deepLinkRequest");
        if (matchUri(r3.getUri()) == true) goto L6;
        return false;
    L6:
        if (matchAction(r3.getAction()) == true) goto L9;
        return false;
    L9:
        return matchMimeType(r3.getMimeType());
    }

    public final void setExactDeepLink$navigation_common_release(boolean r1) {
        this.isExactDeepLink = r1;
    }
}
