package org.threeten.bp;

import com.android.settings.CustomKeyUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: loaded from: classes6.dex */
final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern PATTERN = null;
    private static final long serialVersionUID = 8386373296231747096L;
    private final String id;
    private final transient ZoneRules rules;

    static {
        PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    }

    private static ZoneRegion ofLenient(String r5) {
        if (r5.equals("Z") == true) goto L46;
        if (r5.startsWith(CustomKeyUtils.KEY_SEPARATE_FOR_SHOW) == true) goto L46;
        if (r5.startsWith("-") == true) goto L46;
        if (r5.equals("UTC") == true) goto L44;
        if (r5.equals("GMT") == true) goto L44;
        if (r5.equals("UT") == true) goto L44;
        if (r5.startsWith("UTC+") == false) goto L18;
    L37:
        ZoneOffset r1 = ZoneOffset.of(r5.substring(3));
        if (r1.getTotalSeconds() != 0) goto L42;
        return new ZoneRegion(r5.substring(0, 3), r1.getRules());
    L42:
        return new ZoneRegion(r5.substring(0, 3) + r1.getId(), r1.getRules());
    L18:
        if (r5.startsWith("GMT+") == true) goto L37;
        if (r5.startsWith("UTC-") == true) goto L37;
        if (r5.startsWith("GMT-") == true) goto L37;
        if (r5.startsWith("UT+") == false) goto L27;
    L31:
        ZoneOffset r6 = ZoneOffset.of(r5.substring(2));
        if (r6.getTotalSeconds() != 0) goto L36;
        return new ZoneRegion("UT", r6.getRules());
    L36:
        return new ZoneRegion("UT" + r6.getId(), r6.getRules());
    L27:
        if (r5.startsWith("UT-") == true) goto L31;
        return ofId(r5, false);
    L44:
        return new ZoneRegion(r5, ZoneOffset.UTC.getRules());
    L46:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r5);
    }

    static ZoneRegion ofId(String r2, boolean r3) {
        Jdk8Methods.requireNonNull(r2, "zoneId");
        if (r2.length() < 2) goto L19;
        if (PATTERN.matcher(r2).matches() == false) goto L19;
        ZoneRules r4 = ZoneRulesProvider.getRules(r2, true);     // Catch: ZoneRulesException -> L9
    L16:
        return new ZoneRegion(r2, r4);
    L9:
        e = move-exception;
        if (r2.equals("GMT0") == false) goto L13;
        r4 = ZoneOffset.UTC.getRules();
        goto L16
    L13:
        if (r3 == true) goto L17;
        r4 = null;
        goto L16
    L17:
        throw e;
    L19:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r2);
    }

    ZoneRegion(String r1, ZoneRules r2) {
        this.id = r1;
        this.rules = r2;
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules r0 = this.rules;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ZoneRulesProvider.getRules(this.id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // org.threeten.bp.ZoneId
    void write(DataOutput r2) throws IOException {
        r2.writeByte(7);
        writeExternal(r2);
    }

    void writeExternal(DataOutput r1) throws IOException {
        r1.writeUTF(this.id);
    }

    static ZoneId readExternal(DataInput r0) throws IOException {
        return ofLenient(r0.readUTF());
    }
}
