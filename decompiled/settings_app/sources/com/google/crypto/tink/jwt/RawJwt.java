package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class RawJwt {
    private static final long MAX_TIMESTAMP_VALUE = 253402300799L;
    private final JsonObject payload;
    private final Optional<String> typeHeader;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.RawJwt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final JsonObject payload;
        private Optional<String> typeHeader;
        private boolean withoutExpiration;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ JsonObject access$000(Builder r0) {
            return r0.payload;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.withoutExpiration;
        }

        static /* synthetic */ Optional access$200(Builder r0) {
            return r0.typeHeader;
        }

        private Builder() {
            this.typeHeader = Optional.empty();
            this.withoutExpiration = false;
            this.payload = new JsonObject();
        }

        public Builder setTypeHeader(String value) {
            this.typeHeader = Optional.of(value);
            return this;
        }

        public Builder setIssuer(String value) {
            if (JsonUtil.isValidString(value) == false) goto L7;
            this.payload.add("iss", new JsonPrimitive(value));
            return this;
        L7:
            throw new IllegalArgumentException();
        }

        public Builder setSubject(String value) {
            if (JsonUtil.isValidString(value) == false) goto L7;
            this.payload.add("sub", new JsonPrimitive(value));
            return this;
        L7:
            throw new IllegalArgumentException();
        }

        public Builder setAudience(String value) {
            if (this.payload.has("aud") == false) goto L10;
            if (this.payload.get("aud").isJsonArray() == false) goto L10;
            throw new IllegalArgumentException("setAudience can't be used together with setAudiences or addAudience");
        L10:
            if (JsonUtil.isValidString(value) == false) goto L14;
            this.payload.add("aud", new JsonPrimitive(value));
            return this;
        L14:
            throw new IllegalArgumentException("invalid string");
        }

        public Builder setAudiences(List<String> values) {
            if (this.payload.has("aud") == false) goto L10;
            if (this.payload.get("aud").isJsonArray() == true) goto L10;
            throw new IllegalArgumentException("setAudiences can't be used together with setAudience");
        L10:
            if (values.isEmpty() == true) goto L22;
            JsonArray r0 = new JsonArray();
            Iterator<String> r5 = values.iterator();
        L13:
            if (r5.hasNext() == false) goto L19;
            String r2 = r5.next();
            if (JsonUtil.isValidString(r2) == false) goto L18;
            r0.add(r2);
            goto L13
        L18:
            throw new IllegalArgumentException("invalid string");
        L19:
            this.payload.add("aud", r0);
            return this;
        L22:
            throw new IllegalArgumentException("audiences must not be empty");
        }

        public Builder addAudience(String value) {
            if (JsonUtil.isValidString(value) == false) goto L15;
            if (this.payload.has("aud") == false) goto L11;
            JsonElement r0 = this.payload.get("aud");
            if (r0.isJsonArray() == false) goto L10;
            JsonArray r1 = r0.getAsJsonArray();
        L12:
            r1.add(value);
            this.payload.add("aud", r1);
            return this;
        L10:
            throw new IllegalArgumentException("addAudience can't be used together with setAudience");
        L11:
            r1 = new JsonArray();
            goto L12
        L15:
            throw new IllegalArgumentException("invalid string");
        }

        public Builder setJwtId(String value) {
            if (JsonUtil.isValidString(value) == false) goto L7;
            this.payload.add("jti", new JsonPrimitive(value));
            return this;
        L7:
            throw new IllegalArgumentException();
        }

        private void setTimestampClaim(String name, Instant value) {
            long r0 = value.getEpochSecond();
            if (r0 > RawJwt.MAX_TIMESTAMP_VALUE) goto L9;
            if (r0 < 0) goto L9;
            this.payload.add(name, new JsonPrimitive(Long.valueOf(r0)));
            return;
        L9:
            throw new IllegalArgumentException("timestamp of claim " + name + " is out of range");
        }

        public Builder setExpiration(Instant value) {
            setTimestampClaim("exp", value);
            return this;
        }

        public Builder withoutExpiration() {
            this.withoutExpiration = true;
            return this;
        }

        public Builder setNotBefore(Instant value) {
            setTimestampClaim("nbf", value);
            return this;
        }

        public Builder setIssuedAt(Instant value) {
            setTimestampClaim("iat", value);
            return this;
        }

        public Builder addBooleanClaim(String name, boolean value) {
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(Boolean.valueOf(value)));
            return this;
        }

        public Builder addNumberClaim(String name, long value) {
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(Long.valueOf(value)));
            return this;
        }

        public Builder addNumberClaim(String name, double value) {
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(Double.valueOf(value)));
            return this;
        }

        public Builder addStringClaim(String name, String value) {
            if (JsonUtil.isValidString(value) == false) goto L7;
            JwtNames.validate(name);
            this.payload.add(name, new JsonPrimitive(value));
            return this;
        L7:
            throw new IllegalArgumentException();
        }

        public Builder addNullClaim(String name) {
            JwtNames.validate(name);
            this.payload.add(name, JsonNull.INSTANCE);
            return this;
        }

        public Builder addJsonObjectClaim(String name, String encodedJsonObject) throws JwtInvalidException {
            JwtNames.validate(name);
            this.payload.add(name, JsonUtil.parseJson(encodedJsonObject));
            return this;
        }

        public Builder addJsonArrayClaim(String name, String encodedJsonArray) throws JwtInvalidException {
            JwtNames.validate(name);
            this.payload.add(name, JsonUtil.parseJsonArray(encodedJsonArray));
            return this;
        }

        public RawJwt build() {
            return new RawJwt(this, null);
        }
    }

    /* synthetic */ RawJwt(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private RawJwt(Builder builder) {
        if (Builder.access$000(builder).has("exp") == true) goto L10;
        if (Builder.access$100(builder) == true) goto L10;
        throw new IllegalArgumentException("neither setExpiration() nor withoutExpiration() was called");
    L10:
        if (Builder.access$000(builder).has("exp") == true) goto L12;
    L16:
        this.typeHeader = Builder.access$200(builder);
        this.payload = Builder.access$000(builder).deepCopy();
        return;
    L12:
        if (Builder.access$100(builder) == false) goto L16;
        throw new IllegalArgumentException("setExpiration() and withoutExpiration() must not be called together");
    }

    private RawJwt(Optional<String> typeHeader, String jsonPayload) throws JwtInvalidException {
        this.typeHeader = typeHeader;
        this.payload = JsonUtil.parseJson(jsonPayload);
        validateStringClaim("iss");
        validateStringClaim("sub");
        validateStringClaim("jti");
        validateTimestampClaim("exp");
        validateTimestampClaim("nbf");
        validateTimestampClaim("iat");
        validateAudienceClaim();
    }

    private void validateStringClaim(String name) throws JwtInvalidException {
        if (this.payload.has(name) == true) goto L6;
        return;
    L6:
        if (this.payload.get(name).isJsonPrimitive() == false) goto L11;
        if (this.payload.get(name).getAsJsonPrimitive().isString() == false) goto L11;
        return;
    L11:
        throw new JwtInvalidException("invalid JWT payload: claim " + name + " is not a string.");
    }

    private void validateTimestampClaim(String name) throws JwtInvalidException {
        if (this.payload.has(name) == true) goto L6;
        return;
    L6:
        if (this.payload.get(name).isJsonPrimitive() == false) goto L17;
        if (this.payload.get(name).getAsJsonPrimitive().isNumber() == false) goto L17;
        double r2 = this.payload.get(name).getAsJsonPrimitive().getAsDouble();
        if (r2 > 2.53402300799E11d) goto L15;
        if (r2 < 0.0d) goto L15;
        return;
    L15:
        throw new JwtInvalidException("invalid JWT payload: claim " + name + " has an invalid timestamp");
    L17:
        throw new JwtInvalidException("invalid JWT payload: claim " + name + " is not a number.");
    }

    private void validateAudienceClaim() throws JwtInvalidException {
        if (this.payload.has("aud") == true) goto L6;
        return;
    L6:
        if (this.payload.get("aud").isJsonPrimitive() == false) goto L11;
        if (this.payload.get("aud").getAsJsonPrimitive().isString() == false) goto L11;
        return;
    L11:
        if (getAudiences().size() < 1) goto L14;
        return;
    L14:
        throw new JwtInvalidException("invalid JWT payload: claim aud is present but empty.");
    }

    static RawJwt fromJsonPayload(Optional<String> typeHeader, String jsonPayload) throws JwtInvalidException {
        return new RawJwt(typeHeader, jsonPayload);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public String getJsonPayload() {
        return this.payload.toString();
    }

    boolean hasBooleanClaim(String name) {
        JwtNames.validate(name);
        if (this.payload.has(name) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.payload.get(name).isJsonPrimitive() == false) goto L9;
        if (this.payload.get(name).getAsJsonPrimitive().isBoolean() == false) goto L9;
        return true;
    }

    Boolean getBooleanClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (this.payload.has(name) == false) goto L13;
        if (this.payload.get(name).isJsonPrimitive() == false) goto L11;
        if (this.payload.get(name).getAsJsonPrimitive().isBoolean() == false) goto L11;
        return Boolean.valueOf(this.payload.get(name).getAsBoolean());
    L11:
        throw new JwtInvalidException("claim " + name + " is not a boolean");
    L13:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean hasNumberClaim(String name) {
        JwtNames.validate(name);
        if (this.payload.has(name) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.payload.get(name).isJsonPrimitive() == false) goto L9;
        if (this.payload.get(name).getAsJsonPrimitive().isNumber() == false) goto L9;
        return true;
    }

    Double getNumberClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (this.payload.has(name) == false) goto L13;
        if (this.payload.get(name).isJsonPrimitive() == false) goto L11;
        if (this.payload.get(name).getAsJsonPrimitive().isNumber() == false) goto L11;
        return Double.valueOf(this.payload.get(name).getAsDouble());
    L11:
        throw new JwtInvalidException("claim " + name + " is not a number");
    L13:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean hasStringClaim(String name) {
        JwtNames.validate(name);
        if (this.payload.has(name) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.payload.get(name).isJsonPrimitive() == false) goto L9;
        if (this.payload.get(name).getAsJsonPrimitive().isString() == false) goto L9;
        return true;
    }

    String getStringClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        return getStringClaimInternal(name);
    }

    private String getStringClaimInternal(String name) throws JwtInvalidException {
        if (this.payload.has(name) == false) goto L13;
        if (this.payload.get(name).isJsonPrimitive() == false) goto L11;
        if (this.payload.get(name).getAsJsonPrimitive().isString() == false) goto L11;
        return this.payload.get(name).getAsString();
    L11:
        throw new JwtInvalidException("claim " + name + " is not a string");
    L13:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean isNullClaim(String name) {
        JwtNames.validate(name);
        return JsonNull.INSTANCE.equals(this.payload.get(name));
    L5:
        return false;
    }

    boolean hasJsonObjectClaim(String name) {
        JwtNames.validate(name);
        if (this.payload.has(name) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.payload.get(name).isJsonObject() == false) goto L7;
        return true;
    }

    String getJsonObjectClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (this.payload.has(name) == false) goto L11;
        if (this.payload.get(name).isJsonObject() == false) goto L9;
        return this.payload.get(name).getAsJsonObject().toString();
    L9:
        throw new JwtInvalidException("claim " + name + " is not a JSON object");
    L11:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean hasJsonArrayClaim(String name) {
        JwtNames.validate(name);
        if (this.payload.has(name) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.payload.get(name).isJsonArray() == false) goto L7;
        return true;
    }

    String getJsonArrayClaim(String name) throws JwtInvalidException {
        JwtNames.validate(name);
        if (this.payload.has(name) == false) goto L11;
        if (this.payload.get(name).isJsonArray() == false) goto L9;
        return this.payload.get(name).getAsJsonArray().toString();
    L9:
        throw new JwtInvalidException("claim " + name + " is not a JSON array");
    L11:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean hasTypeHeader() {
        return this.typeHeader.isPresent();
    }

    String getTypeHeader() throws JwtInvalidException {
        if (this.typeHeader.isPresent() == false) goto L7;
        return this.typeHeader.get();
    L7:
        throw new JwtInvalidException("type header is not set");
    }

    boolean hasIssuer() {
        return this.payload.has("iss");
    }

    String getIssuer() throws JwtInvalidException {
        return getStringClaimInternal("iss");
    }

    boolean hasSubject() {
        return this.payload.has("sub");
    }

    String getSubject() throws JwtInvalidException {
        return getStringClaimInternal("sub");
    }

    boolean hasJwtId() {
        return this.payload.has("jti");
    }

    String getJwtId() throws JwtInvalidException {
        return getStringClaimInternal("jti");
    }

    boolean hasAudiences() {
        return this.payload.has("aud");
    }

    List<String> getAudiences() throws JwtInvalidException {
        if (hasAudiences() == false) goto L29;
        JsonElement r6 = this.payload.get("aud");
        if (r6.isJsonPrimitive() == false) goto L13;
        if (r6.getAsJsonPrimitive().isString() == false) goto L11;
        return Collections.unmodifiableList(Arrays.asList(new String[]{r6.getAsString()}));
    L11:
        throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{r6}));
    L13:
        if (r6.isJsonArray() == false) goto L27;
        JsonArray r7 = r6.getAsJsonArray();
        ArrayList r0 = new ArrayList(r7.size());
        int r4 = 0;
    L16:
        if (r4 >= r7.size()) goto L25;
        if (r7.get(r4).isJsonPrimitive() == false) goto L23;
        if (r7.get(r4).getAsJsonPrimitive().isString() == false) goto L23;
        r0.add(r7.get(r4).getAsString());
        r4 = r4 + 1;
    L23:
        throw new JwtInvalidException(String.format("invalid audience: got %s; want a string", new Object[]{r7.get(r4)}));
    L25:
        return Collections.unmodifiableList(r0);
    L27:
        throw new JwtInvalidException("claim aud is not a string or a JSON array");
    L29:
        throw new JwtInvalidException("claim aud does not exist");
    }

    private Instant getInstant(String name) throws JwtInvalidException {
        if (this.payload.has(name) == false) goto L16;
        if (this.payload.get(name).isJsonPrimitive() == false) goto L14;
        if (this.payload.get(name).getAsJsonPrimitive().isNumber() == false) goto L14;
        return Instant.ofEpochMilli((long) (this.payload.get(name).getAsJsonPrimitive().getAsDouble() * 1000.0d));
    L10:
        e = move-exception;
        throw new JwtInvalidException("claim " + name + " is not a timestamp: " + e);
    L14:
        throw new JwtInvalidException("claim " + name + " is not a timestamp");
    L16:
        throw new JwtInvalidException("claim " + name + " does not exist");
    }

    boolean hasExpiration() {
        return this.payload.has("exp");
    }

    Instant getExpiration() throws JwtInvalidException {
        return getInstant("exp");
    }

    boolean hasNotBefore() {
        return this.payload.has("nbf");
    }

    Instant getNotBefore() throws JwtInvalidException {
        return getInstant("nbf");
    }

    boolean hasIssuedAt() {
        return this.payload.has("iat");
    }

    Instant getIssuedAt() throws JwtInvalidException {
        return getInstant("iat");
    }

    Set<String> customClaimNames() {
        HashSet r0 = new HashSet();
        Iterator<String> r3 = this.payload.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        String r1 = r3.next();
        if (JwtNames.isRegisteredName(r1) == true) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return Collections.unmodifiableSet(r0);
    }

    public String toString() {
        JsonObject r0 = new JsonObject();
        if (this.typeHeader.isPresent() == false) goto L6;
        r0.add("typ", new JsonPrimitive(this.typeHeader.get()));
    L6:
        return r0 + "." + this.payload;
    }
}
