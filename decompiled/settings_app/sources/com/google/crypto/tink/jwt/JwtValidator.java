package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class JwtValidator {
    private static final Duration MAX_CLOCK_SKEW = null;
    private final boolean allowMissingExpiration;
    private final Clock clock;
    private final Duration clockSkew;
    private final boolean expectIssuedInThePast;
    private final Optional<String> expectedAudience;
    private final Optional<String> expectedIssuer;
    private final Optional<String> expectedTypeHeader;
    private final boolean ignoreAudiences;
    private final boolean ignoreIssuer;
    private final boolean ignoreTypeHeader;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtValidator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private boolean allowMissingExpiration;
        private Clock clock;
        private Duration clockSkew;
        private boolean expectIssuedInThePast;
        private Optional<String> expectedAudience;
        private Optional<String> expectedIssuer;
        private Optional<String> expectedTypeHeader;
        private boolean ignoreAudiences;
        private boolean ignoreIssuer;
        private boolean ignoreTypeHeader;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ Optional access$000(Builder r0) {
            return r0.expectedTypeHeader;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.ignoreTypeHeader;
        }

        static /* synthetic */ Optional access$200(Builder r0) {
            return r0.expectedIssuer;
        }

        static /* synthetic */ boolean access$300(Builder r0) {
            return r0.ignoreIssuer;
        }

        static /* synthetic */ Optional access$400(Builder r0) {
            return r0.expectedAudience;
        }

        static /* synthetic */ boolean access$500(Builder r0) {
            return r0.ignoreAudiences;
        }

        static /* synthetic */ boolean access$600(Builder r0) {
            return r0.allowMissingExpiration;
        }

        static /* synthetic */ boolean access$700(Builder r0) {
            return r0.expectIssuedInThePast;
        }

        static /* synthetic */ Clock access$800(Builder r0) {
            return r0.clock;
        }

        static /* synthetic */ Duration access$900(Builder r0) {
            return r0.clockSkew;
        }

        private Builder() {
            this.clock = Clock.systemUTC();
            this.clockSkew = Duration.ZERO;
            this.expectedTypeHeader = Optional.empty();
            this.ignoreTypeHeader = false;
            this.expectedIssuer = Optional.empty();
            this.ignoreIssuer = false;
            this.expectedAudience = Optional.empty();
            this.ignoreAudiences = false;
            this.allowMissingExpiration = false;
            this.expectIssuedInThePast = false;
        }

        public Builder expectTypeHeader(String value) {
            if (value == null) goto L6;
            this.expectedTypeHeader = Optional.of(value);
            return this;
        L6:
            throw new NullPointerException("typ header cannot be null");
        }

        public Builder ignoreTypeHeader() {
            this.ignoreTypeHeader = true;
            return this;
        }

        public Builder expectIssuer(String value) {
            if (value == null) goto L6;
            this.expectedIssuer = Optional.of(value);
            return this;
        L6:
            throw new NullPointerException("issuer cannot be null");
        }

        public Builder ignoreIssuer() {
            this.ignoreIssuer = true;
            return this;
        }

        public Builder expectAudience(String value) {
            if (value == null) goto L6;
            this.expectedAudience = Optional.of(value);
            return this;
        L6:
            throw new NullPointerException("audience cannot be null");
        }

        public Builder ignoreAudiences() {
            this.ignoreAudiences = true;
            return this;
        }

        public Builder expectIssuedInThePast() {
            this.expectIssuedInThePast = true;
            return this;
        }

        public Builder setClock(Clock clock) {
            if (clock == null) goto L6;
            this.clock = clock;
            return this;
        L6:
            throw new NullPointerException("clock cannot be null");
        }

        public Builder setClockSkew(Duration clockSkew) {
            if (clockSkew.compareTo(JwtValidator.access$1100()) > 0) goto L7;
            this.clockSkew = clockSkew;
            return this;
        L7:
            throw new IllegalArgumentException("Clock skew too large, max is 10 minutes");
        }

        public Builder allowMissingExpiration() {
            this.allowMissingExpiration = true;
            return this;
        }

        public JwtValidator build() {
            if (this.ignoreTypeHeader == false) goto L10;
            if (this.expectedTypeHeader.isPresent() == false) goto L10;
            throw new IllegalArgumentException("ignoreTypeHeader() and expectedTypeHeader() cannot be used together.");
        L10:
            if (this.ignoreIssuer == false) goto L17;
            if (this.expectedIssuer.isPresent() == false) goto L17;
            throw new IllegalArgumentException("ignoreIssuer() and expectedIssuer() cannot be used together.");
        L17:
            if (this.ignoreAudiences == false) goto L24;
            if (this.expectedAudience.isPresent() == false) goto L24;
            throw new IllegalArgumentException("ignoreAudiences() and expectedAudience() cannot be used together.");
        L24:
            return new JwtValidator(this, null);
        }
    }

    /* synthetic */ JwtValidator(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Duration access$1100() {
        return MAX_CLOCK_SKEW;
    }

    static {
        MAX_CLOCK_SKEW = Duration.ofMinutes(10);
    }

    private JwtValidator(Builder builder) {
        this.expectedTypeHeader = Builder.access$000(builder);
        this.ignoreTypeHeader = Builder.access$100(builder);
        this.expectedIssuer = Builder.access$200(builder);
        this.ignoreIssuer = Builder.access$300(builder);
        this.expectedAudience = Builder.access$400(builder);
        this.ignoreAudiences = Builder.access$500(builder);
        this.allowMissingExpiration = Builder.access$600(builder);
        this.expectIssuedInThePast = Builder.access$700(builder);
        this.clock = Builder.access$800(builder);
        this.clockSkew = Builder.access$900(builder);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    private void validateTypeHeader(RawJwt target) throws JwtInvalidException {
        if (this.expectedTypeHeader.isPresent() == false) goto L14;
        if (target.hasTypeHeader() == false) goto L12;
        if (target.getTypeHeader().equals(this.expectedTypeHeader.get()) == false) goto L10;
        return;
    L10:
        throw new JwtInvalidException(String.format("invalid JWT; expected type header %s, but got %s", new Object[]{this.expectedTypeHeader.get(), target.getTypeHeader()}));
    L12:
        throw new JwtInvalidException(String.format("invalid JWT; missing expected type header %s.", new Object[]{this.expectedTypeHeader.get()}));
    L14:
        if (target.hasTypeHeader() == true) goto L16;
        return;
    L16:
        if (this.ignoreTypeHeader == false) goto L19;
        return;
    L19:
        throw new JwtInvalidException("invalid JWT; token has type header set, but validator not.");
    }

    private void validateIssuer(RawJwt target) throws JwtInvalidException {
        if (this.expectedIssuer.isPresent() == false) goto L14;
        if (target.hasIssuer() == false) goto L12;
        if (target.getIssuer().equals(this.expectedIssuer.get()) == false) goto L10;
        return;
    L10:
        throw new JwtInvalidException(String.format("invalid JWT; expected issuer %s, but got %s", new Object[]{this.expectedIssuer.get(), target.getIssuer()}));
    L12:
        throw new JwtInvalidException(String.format("invalid JWT; missing expected issuer %s.", new Object[]{this.expectedIssuer.get()}));
    L14:
        if (target.hasIssuer() == true) goto L16;
        return;
    L16:
        if (this.ignoreIssuer == false) goto L19;
        return;
    L19:
        throw new JwtInvalidException("invalid JWT; token has issuer set, but validator not.");
    }

    private void validateAudiences(RawJwt target) throws JwtInvalidException {
        if (this.expectedAudience.isPresent() == false) goto L12;
        if (target.hasAudiences() == false) goto L10;
        if (target.getAudiences().contains(this.expectedAudience.get()) == false) goto L10;
        return;
    L10:
        throw new JwtInvalidException(String.format("invalid JWT; missing expected audience %s.", new Object[]{this.expectedAudience.get()}));
    L12:
        if (target.hasAudiences() == true) goto L14;
        return;
    L14:
        if (this.ignoreAudiences == false) goto L17;
        return;
    L17:
        throw new JwtInvalidException("invalid JWT; token has audience set, but validator not.");
    }

    VerifiedJwt validate(RawJwt target) throws JwtInvalidException {
        validateTimestampClaims(target);
        validateTypeHeader(target);
        validateIssuer(target);
        validateAudiences(target);
        return new VerifiedJwt(target);
    }

    private void validateTimestampClaims(RawJwt target) throws JwtInvalidException {
        Instant r0 = this.clock.instant();
        if (target.hasExpiration() == true) goto L10;
        if (this.allowMissingExpiration == true) goto L10;
        throw new JwtInvalidException("token does not have an expiration set");
    L10:
        if (target.hasExpiration() == false) goto L17;
        if (target.getExpiration().isAfter(r0.minus(this.clockSkew)) == true) goto L17;
        throw new JwtInvalidException("token has expired since " + target.getExpiration());
    L17:
        if (target.hasNotBefore() == false) goto L24;
        if (target.getNotBefore().isAfter(r0.plus(this.clockSkew)) == false) goto L24;
        throw new JwtInvalidException("token cannot be used before " + target.getNotBefore());
    L24:
        if (this.expectIssuedInThePast == true) goto L26;
        return;
    L26:
        if (target.hasIssuedAt() == false) goto L33;
        if (target.getIssuedAt().isAfter(r0.plus(this.clockSkew)) == true) goto L31;
        return;
    L31:
        throw new JwtInvalidException("token has a invalid iat claim in the future: " + target.getIssuedAt());
    L33:
        throw new JwtInvalidException("token does not have an iat claim");
    }

    public String toString() {
        ArrayList r0 = new ArrayList();
        if (this.expectedTypeHeader.isPresent() == false) goto L6;
        r0.add("expectedTypeHeader=" + this.expectedTypeHeader.get());
    L6:
        if (this.ignoreTypeHeader == false) goto L9;
        r0.add("ignoreTypeHeader");
    L9:
        if (this.expectedIssuer.isPresent() == false) goto L12;
        r0.add("expectedIssuer=" + this.expectedIssuer.get());
    L12:
        if (this.ignoreIssuer == false) goto L15;
        r0.add("ignoreIssuer");
    L15:
        if (this.expectedAudience.isPresent() == false) goto L18;
        r0.add("expectedAudience=" + this.expectedAudience.get());
    L18:
        if (this.ignoreAudiences == false) goto L21;
        r0.add("ignoreAudiences");
    L21:
        if (this.allowMissingExpiration == false) goto L24;
        r0.add("allowMissingExpiration");
    L24:
        if (this.expectIssuedInThePast == false) goto L27;
        r0.add("expectIssuedInThePast");
    L27:
        if (this.clockSkew.isZero() == true) goto L29;
        r0.add("clockSkew=" + this.clockSkew);
    L29:
        StringBuilder r3 = new StringBuilder("JwtValidator{");
        Iterator r1 = r0.iterator();
        String r2 = "";
    L31:
        if (r1.hasNext() == false) goto L33;
        String r4 = (String) r1.next();
        r3.append(r2);
        r3.append(r4);
        r2 = ",";
        goto L31
    L33:
        r3.append(VectorFormat.DEFAULT_SUFFIX);
        return r3.toString();
    }
}
