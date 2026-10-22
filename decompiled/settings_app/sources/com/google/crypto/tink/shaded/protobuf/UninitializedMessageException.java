package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields;

    public UninitializedMessageException(final MessageLite message) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(final List<String> missingFields) {
        super(buildDescription(missingFields));
        this.missingFields = missingFields;
    }

    public List<String> getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }

    private static String buildDescription(final List<String> missingFields) {
        StringBuilder r0 = new StringBuilder("Message missing required fields: ");
        Iterator<String> r4 = missingFields.iterator();
        boolean r1 = true;
    L4:
        if (r4.hasNext() == false) goto L11;
        String r2 = r4.next();
        if (r1 == false) goto L8;
        r1 = false;
    L9:
        r0.append(r2);
        goto L4
    L8:
        r0.append(", ");
        goto L9
    L11:
        return r0.toString();
    }
}
