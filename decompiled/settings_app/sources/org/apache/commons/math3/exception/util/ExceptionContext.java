package org.apache.commons.math3.exception.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class ExceptionContext implements Serializable {
    private static final long serialVersionUID = -6024911025449780478L;
    private Map<String, Object> context;
    private List<Object[]> msgArguments;
    private List<Localizable> msgPatterns;
    private Throwable throwable;

    public ExceptionContext(Throwable r1) {
        this.throwable = r1;
        this.msgPatterns = new ArrayList();
        this.msgArguments = new ArrayList();
        this.context = new HashMap();
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void addMessage(Localizable r2, Object... r3) {
        this.msgPatterns.add(r2);
        this.msgArguments.add(ArgUtils.flatten(r3));
    }

    public void setValue(String r1, Object r2) {
        this.context.put(r1, r2);
    }

    public Object getValue(String r1) {
        return this.context.get(r1);
    }

    public Set<String> getKeys() {
        return this.context.keySet();
    }

    public String getMessage() {
        return getMessage(Locale.US);
    }

    public String getLocalizedMessage() {
        return getMessage(Locale.getDefault());
    }

    public String getMessage(Locale r2) {
        return buildMessage(r2, ": ");
    }

    public String getMessage(Locale r1, String r2) {
        return buildMessage(r1, r2);
    }

    private String buildMessage(Locale r8, String r9) {
        StringBuilder r0 = new StringBuilder();
        int r1 = this.msgPatterns.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Localizable r4 = this.msgPatterns.get(r2);
        r0.append(new MessageFormat(r4.getLocalizedString(r8), r8).format(this.msgArguments.get(r2)));
        r3 = r3 + 1;
        if (r3 >= r1) goto L7;
        r0.append(r9);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0.toString();
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.writeObject(this.throwable);
        serializeMessages(r2);
        serializeContext(r2);
    }

    private void readObject(ObjectInputStream r2) throws IOException, ClassNotFoundException {
        this.throwable = (Throwable) r2.readObject();
        deSerializeMessages(r2);
        deSerializeContext(r2);
    }

    private void serializeMessages(ObjectOutputStream r9) throws IOException {
        int r0 = this.msgPatterns.size();
        r9.writeInt(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        r9.writeObject(this.msgPatterns.get(r2));
        Object[] r3 = this.msgArguments.get(r2);
        int r4 = r3.length;
        r9.writeInt(r4);
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L11;
        Object r6 = r3[r5];
        if ((r6 instanceof Serializable) == false) goto L9;
        r9.writeObject(r6);
    L10:
        r5 = r5 + 1;
        goto L5
    L9:
        r9.writeObject(nonSerializableReplacement(r6));
        goto L10
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private void deSerializeMessages(ObjectInputStream r8) throws IOException, ClassNotFoundException {
        int r0 = r8.readInt();
        this.msgPatterns = new ArrayList(r0);
        this.msgArguments = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        this.msgPatterns.add((Localizable) r8.readObject());
        int r3 = r8.readInt();
        Object[] r4 = new Object[r3];
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L7;
        r4[r5] = r8.readObject();
        r5 = r5 + 1;
        goto L5
    L7:
        this.msgArguments.add(r4);
        r2 = r2 + 1;
        goto L3
    }

    private void serializeContext(ObjectOutputStream r4) throws IOException {
        r4.writeInt(this.context.size());
        Iterator<Map.Entry<String, Object>> r0 = this.context.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, Object> r1 = r0.next();
        r4.writeObject(r1.getKey());
        Object r2 = r1.getValue();
        if ((r2 instanceof Serializable) == true) goto L7;
        r4.writeObject(nonSerializableReplacement(r2));
        goto L4
    L7:
        r4.writeObject(r2);
        goto L4
    }

    private void deSerializeContext(ObjectInputStream r6) throws IOException, ClassNotFoundException {
        int r0 = r6.readInt();
        this.context = new HashMap();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = (String) r6.readObject();
        Object r3 = r6.readObject();
        this.context.put(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    private String nonSerializableReplacement(Object r2) {
        return "[Object could not be serialized: " + r2.getClass().getName() + "]";
    }
}
