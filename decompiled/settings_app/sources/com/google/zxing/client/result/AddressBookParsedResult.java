package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes4.dex */
public final class AddressBookParsedResult extends ParsedResult {
    private final String[] addressTypes;
    private final String[] addresses;
    private final String birthday;
    private final String[] emailTypes;
    private final String[] emails;
    private final String[] geo;
    private final String instantMessenger;
    private final String[] names;
    private final String[] nicknames;
    private final String note;

    /* JADX INFO: renamed from: org, reason: collision with root package name */
    private final String f8org;
    private final String[] phoneNumbers;
    private final String[] phoneTypes;
    private final String pronunciation;
    private final String title;
    private final String[] urls;

    public AddressBookParsedResult(String[] r18, String[] r19, String[] r20, String[] r21, String[] r22, String[] r23, String[] r24) {
        this(r18, null, null, r19, r20, r21, r22, null, null, r23, r24, null, null, null, null, null);
    }

    public AddressBookParsedResult(String[] r10, String[] r11, String r12, String[] r13, String[] r14, String[] r15, String[] r16, String r17, String r18, String[] r19, String[] r20, String r21, String r22, String r23, String[] r24, String[] r25) {
        super(ParsedResultType.ADDRESSBOOK);
        if (r13 == null) goto L10;
        if (r14 == null) goto L10;
        if (r13.length == r14.length) goto L10;
        throw new IllegalArgumentException("Phone numbers and types lengths differ");
    L10:
        if (r15 == null) goto L17;
        if (r16 == null) goto L17;
        if (r15.length == r16.length) goto L17;
        throw new IllegalArgumentException("Emails and types lengths differ");
    L17:
        if (r19 == null) goto L24;
        if (r20 == null) goto L24;
        if (r19.length == r20.length) goto L24;
        throw new IllegalArgumentException("Addresses and types lengths differ");
    L24:
        this.names = r10;
        this.nicknames = r11;
        this.pronunciation = r12;
        this.phoneNumbers = r13;
        this.phoneTypes = r14;
        this.emails = r15;
        this.emailTypes = r16;
        this.instantMessenger = r17;
        this.note = r18;
        this.addresses = r19;
        this.addressTypes = r20;
        this.f8org = r21;
        this.birthday = r22;
        this.title = r23;
        this.urls = r24;
        this.geo = r25;
    }

    public String[] getNames() {
        return this.names;
    }

    public String[] getNicknames() {
        return this.nicknames;
    }

    public String getPronunciation() {
        return this.pronunciation;
    }

    public String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public String[] getPhoneTypes() {
        return this.phoneTypes;
    }

    public String[] getEmails() {
        return this.emails;
    }

    public String[] getEmailTypes() {
        return this.emailTypes;
    }

    public String getInstantMessenger() {
        return this.instantMessenger;
    }

    public String getNote() {
        return this.note;
    }

    public String[] getAddresses() {
        return this.addresses;
    }

    public String[] getAddressTypes() {
        return this.addressTypes;
    }

    public String getTitle() {
        return this.title;
    }

    public String getOrg() {
        return this.f8org;
    }

    public String[] getURLs() {
        return this.urls;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String[] getGeo() {
        return this.geo;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(100);
        maybeAppend(this.names, r0);
        maybeAppend(this.nicknames, r0);
        maybeAppend(this.pronunciation, r0);
        maybeAppend(this.title, r0);
        maybeAppend(this.f8org, r0);
        maybeAppend(this.addresses, r0);
        maybeAppend(this.phoneNumbers, r0);
        maybeAppend(this.emails, r0);
        maybeAppend(this.instantMessenger, r0);
        maybeAppend(this.urls, r0);
        maybeAppend(this.birthday, r0);
        maybeAppend(this.geo, r0);
        maybeAppend(this.note, r0);
        return r0.toString();
    }
}
