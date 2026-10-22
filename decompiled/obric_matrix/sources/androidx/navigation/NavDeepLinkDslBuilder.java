package androidx.navigation;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@NavDeepLinkDsl
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", "", "()V", "p", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "builder", "Landroidx/navigation/NavDeepLink$Builder;", "mimeType", "getMimeType", "setMimeType", "uriPattern", "getUriPattern", "setUriPattern", "build", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_release", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder;
    private String mimeType;
    private String uriPattern;

    public NavDeepLinkDslBuilder() {
        this.builder = new NavDeepLink.Builder();
    }

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder r0 = this.builder;
        String r1 = this.uriPattern;
        if (r1 == null) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L23;
        if (r1 == null) goto L14;
        r0.setUriPattern(r1);
    L14:
        String r3 = this.action;
        if (r3 == null) goto L17;
        r0.setAction(r3);
    L17:
        String r4 = this.mimeType;
        if (r4 == null) goto L21;
        r0.setMimeType(r4);
    L21:
        return r0.build();
    L23:
        throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
    L5:
        if (this.action != null) goto L10;
        if (this.mimeType != null) goto L10;
        r2 = false;
        goto L11
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(String r2) {
        if (r2 != null) goto L4;
    L11:
        this.action = r2;
        return;
    L4:
        if (r2.length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
    L6:
        r0 = false;
        goto L7
    }

    public final void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public final void setUriPattern(String r1) {
        this.uriPattern = r1;
    }
}
