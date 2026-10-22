package com.google.common.net;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class InternetDomainName {
    private static final CharMatcher DASH_MATCHER = null;
    private static final CharMatcher DIGIT_MATCHER = null;
    private static final CharMatcher DOTS_MATCHER = null;
    private static final Joiner DOT_JOINER = null;
    private static final Splitter DOT_SPLITTER = null;
    private static final CharMatcher LETTER_MATCHER = null;
    private static final int MAX_DOMAIN_PART_LENGTH = 63;
    private static final int MAX_LENGTH = 253;
    private static final int MAX_PARTS = 127;
    private static final int NO_SUFFIX_FOUND = -1;
    private static final CharMatcher PART_CHAR_MATCHER = null;
    private final String name;
    private final ImmutableList<String> parts;
    private final int publicSuffixIndex;
    private final int registrySuffixIndex;

    static {
        DOTS_MATCHER = CharMatcher.anyOf(".。．｡");
        DOT_SPLITTER = Splitter.on('.');
        DOT_JOINER = Joiner.on('.');
        CharMatcher r0 = CharMatcher.anyOf("-_");
        DASH_MATCHER = r0;
        CharMatcher r1 = CharMatcher.inRange('0', '9');
        DIGIT_MATCHER = r1;
        CharMatcher r2 = CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z'));
        LETTER_MATCHER = r2;
        PART_CHAR_MATCHER = r1.or(r2).or(r0);
    }

    InternetDomainName(String r6) {
        String r7 = Ascii.toLowerCase(DOTS_MATCHER.replaceFrom(r6, '.'));
        boolean r1 = true;
        if (r7.endsWith(".") == false) goto L6;
        r7 = r7.substring(0, r7.length() - 1);
    L6:
        if (r7.length() > 253) goto L8;
        boolean r0 = true;
    L9:
        Preconditions.checkArgument(r0, "Domain name too long: '%s':", r7);
        this.name = r7;
        ImmutableList<String> r2 = ImmutableList.copyOf(DOT_SPLITTER.split(r7));
        this.parts = r2;
        if (r2.size() <= 127) goto L13;
        r1 = false;
    L13:
        Preconditions.checkArgument(r1, "Domain has too many parts: '%s'", r7);
        Preconditions.checkArgument(validateSyntax(r2), "Not a valid domain name: '%s'", r7);
        this.publicSuffixIndex = findSuffixOfType(Optional.absent());
        this.registrySuffixIndex = findSuffixOfType(Optional.of(PublicSuffixType.REGISTRY));
        return;
    L8:
        r0 = false;
        goto L9
    }

    private int findSuffixOfType(Optional<PublicSuffixType> r5) {
        int r0 = this.parts.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        String r2 = DOT_JOINER.join(this.parts.subList(r1, r0));
        if (matchesType(r5, Optional.fromNullable(PublicSuffixPatterns.EXACT.get(r2))) == true) goto L6;
        if (PublicSuffixPatterns.EXCLUDED.containsKey(r2) == true) goto L10;
        if (matchesWildcardSuffixType(r5, r2) == true) goto L13;
        r1 = r1 + 1;
        goto L3
    L13:
        return r1;
    L10:
        return r1 + 1;
    L6:
        return r1;
    L15:
        return -1;
    }

    public static InternetDomainName from(String r1) {
        return new InternetDomainName((String) Preconditions.checkNotNull(r1));
    }

    private static boolean validateSyntax(List<String> r5) {
        int r0 = r5.size() - 1;
        if (validatePart(r5.get(r0), true) == true) goto L5;
        return false;
    L5:
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (validatePart(r5.get(r2), false) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    private static boolean validatePart(String r4, boolean r5) {
        if (r4.length() >= 1) goto L5;
    L20:
        return false;
    L5:
        if (r4.length() > 63) goto L20;
        String r0 = CharMatcher.ascii().retainFrom(r4);
        if (PART_CHAR_MATCHER.matchesAllOf(r0) == true) goto L10;
        return false;
    L10:
        CharMatcher r1 = DASH_MATCHER;
        if (r1.matches(r4.charAt(0)) == true) goto L20;
        if (r1.matches(r4.charAt(r4.length() - 1)) == true) goto L20;
        if (r5 == true) goto L17;
    L19:
        return true;
    L17:
        if (DIGIT_MATCHER.matches(r4.charAt(0)) == false) goto L19;
        return false;
    }

    public ImmutableList<String> parts() {
        return this.parts;
    }

    public boolean isPublicSuffix() {
        if (this.publicSuffixIndex != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasPublicSuffix() {
        if (this.publicSuffixIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @CheckForNull
    public InternetDomainName publicSuffix() {
        if (hasPublicSuffix() == true) goto L7;
        return null;
    L7:
        return ancestor(this.publicSuffixIndex);
    }

    public boolean isUnderPublicSuffix() {
        if (this.publicSuffixIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTopPrivateDomain() {
        if (this.publicSuffixIndex == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain() == false) goto L5;
        return this;
    L5:
        Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.name);
        return ancestor(this.publicSuffixIndex - 1);
    }

    public boolean isRegistrySuffix() {
        if (this.registrySuffixIndex != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasRegistrySuffix() {
        if (this.registrySuffixIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @CheckForNull
    public InternetDomainName registrySuffix() {
        if (hasRegistrySuffix() == true) goto L7;
        return null;
    L7:
        return ancestor(this.registrySuffixIndex);
    }

    public boolean isUnderRegistrySuffix() {
        if (this.registrySuffixIndex <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        if (this.registrySuffixIndex == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix() == false) goto L5;
        return this;
    L5:
        Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.name);
        return ancestor(this.registrySuffixIndex - 1);
    }

    public boolean hasParent() {
        if (this.parts.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public InternetDomainName parent() {
        Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.name);
        return ancestor(1);
    }

    private InternetDomainName ancestor(int r3) {
        Joiner r0 = DOT_JOINER;
        ImmutableList<String> r2 = this.parts;
        return from(r0.join(r2.subList(r3, r2.size())));
    }

    public InternetDomainName child(String r3) {
        String r4 = (String) Preconditions.checkNotNull(r3);
        String r2 = this.name;
        return from(new StringBuilder((String.valueOf(r4).length() + 1) + String.valueOf(r2).length()).append(r4).append(".").append(r2).toString());
    }

    public static boolean isValid(String r0) {
        from(r0);     // Catch: IllegalArgumentException -> L5
        return true;
    L5:
        return false;
    }

    private static boolean matchesWildcardSuffixType(Optional<PublicSuffixType> r2, String r3) {
        List<String> r4 = DOT_SPLITTER.limit(2).splitToList(r3);
        if (r4.size() == 2) goto L5;
    L7:
        return false;
    L5:
        if (matchesType(r2, Optional.fromNullable(PublicSuffixPatterns.UNDER.get(r4.get(1)))) == false) goto L7;
        return true;
    }

    private static boolean matchesType(Optional<PublicSuffixType> r1, Optional<PublicSuffixType> r2) {
        if (r1.isPresent() == false) goto L6;
        return r1.equals(r2);
    L6:
        return r2.isPresent();
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(@CheckForNull Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof InternetDomainName) == true) goto L8;
        return false;
    L8:
        return this.name.equals(((InternetDomainName) r2).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }
}
