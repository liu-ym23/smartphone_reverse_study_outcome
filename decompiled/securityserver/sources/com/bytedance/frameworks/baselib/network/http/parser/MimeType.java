package com.bytedance.frameworks.baselib.network.http.parser;

import com.bytedance.librarian.LibrarianImpl;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class MimeType implements Externalizable {
    private static final String TSPECIALS = "()<>@,;:/[]?=\\\"";
    private MimeTypeParameterList parameters;
    private String primaryType;
    private String subType;

    public MimeType() {
        this.primaryType = "application";
        this.subType = "*";
        this.parameters = new MimeTypeParameterList();
    }

    private static boolean isTokenChar(char r1) {
        if (r1 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r1 >= 127) goto L9;
        if (TSPECIALS.indexOf(r1) >= 0) goto L9;
        return true;
    }

    private boolean isValidToken(String r4) {
        int r3 = r4.length();
        if (r3 <= 0) goto L12;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L10;
        if (isTokenChar(r4.charAt(r1)) == false) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    private void parse(String r5) {
        int r0 = r5.indexOf(47);
        int r1 = r5.indexOf(59);
        if (r0 >= 0) goto L8;
        if (r1 >= 0) goto L8;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L8:
        if (r0 >= 0) goto L14;
        if (r1 < 0) goto L14;
        throw new MimeTypeParseException("Unable to find a sub type.");
    L14:
        if (r0 < 0) goto L17;
        if (r1 >= 0) goto L17;
        String r2 = r5.substring(0, r0).trim();
        Locale r3 = Locale.ENGLISH;
        this.primaryType = r2.toLowerCase(r3);
        this.subType = r5.substring(r0 + 1).trim().toLowerCase(r3);
        this.parameters = new MimeTypeParameterList();
    L20:
        if (isValidToken(this.primaryType) == false) goto L27;
        if (isValidToken(this.subType) == false) goto L25;
        return;
    L25:
        throw new MimeTypeParseException("Sub type is invalid.");
    L27:
        throw new MimeTypeParseException("Primary type is invalid.");
    L17:
        if (r0 >= r1) goto L29;
        String r4 = r5.substring(0, r0).trim();
        Locale r6 = Locale.ENGLISH;
        this.primaryType = r4.toLowerCase(r6);
        this.subType = r5.substring(r0 + 1, r1).trim().toLowerCase(r6);
        this.parameters = new MimeTypeParameterList(r5.substring(r1));
        goto L20
    L29:
        throw new MimeTypeParseException("Unable to find a sub type.");
    }

    public String getBaseType() {
        return this.primaryType + LibrarianImpl.Constants.SEPARATOR + this.subType;
    }

    public String getParameter(String r1) {
        return this.parameters.get(r1);
    }

    public MimeTypeParameterList getParameters() {
        return this.parameters;
    }

    public String getPrimaryType() {
        return this.primaryType;
    }

    public String getSubType() {
        return this.subType;
    }

    public boolean match(MimeType r3) {
        if (this.primaryType.equals(r3.getPrimaryType()) == true) goto L5;
    L11:
        return false;
    L5:
        if (this.subType.equals("*") == false) goto L7;
    L10:
        return true;
    L7:
        if (r3.getSubType().equals("*") == true) goto L10;
        if (this.subType.equals(r3.getSubType()) == false) goto L11;
        goto L10
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r1) {
        parse(r1.readUTF());     // Catch: MimeTypeParseException -> L4
        return;
    L4:
        e = move-exception;
        throw new IOException(e.toString());
    }

    public void removeParameter(String r1) {
        this.parameters.remove(r1);
    }

    public void setParameter(String r1, String r2) {
        this.parameters.set(r1, r2);
    }

    public void setPrimaryType(String r2) {
        if (isValidToken(this.primaryType) == false) goto L7;
        this.primaryType = r2.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Primary type is invalid.");
    }

    public void setSubType(String r2) {
        if (isValidToken(this.subType) == false) goto L7;
        this.subType = r2.toLowerCase(Locale.ENGLISH);
        return;
    L7:
        throw new MimeTypeParseException("Sub type is invalid.");
    }

    public String toString() {
        return getBaseType() + this.parameters.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r1) {
        r1.writeUTF(toString());
        r1.flush();
    }

    public boolean match(String r2) {
        return match(new MimeType(r2));
    }

    public MimeType(String r1) {
        parse(r1);
    }

    public MimeType(String r2, String r3) {
        if (isValidToken(r2) == false) goto L11;
        Locale r0 = Locale.ENGLISH;
        this.primaryType = r2.toLowerCase(r0);
        if (isValidToken(r3) == false) goto L9;
        this.subType = r3.toLowerCase(r0);
        this.parameters = new MimeTypeParameterList();
        return;
    L9:
        throw new MimeTypeParseException("Sub type is invalid.");
    L11:
        throw new MimeTypeParseException("Primary type is invalid.");
    }
}
