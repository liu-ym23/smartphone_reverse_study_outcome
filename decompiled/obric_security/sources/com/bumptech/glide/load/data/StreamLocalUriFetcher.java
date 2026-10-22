package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER = null;

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ void close(InputStream r1) throws IOException {
        close2(r1);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected /* bridge */ /* synthetic */ InputStream loadResource(Uri r1, ContentResolver r2) throws FileNotFoundException {
        return loadResource(r1, r2);
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        URI_MATCHER = r0;
        r0.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        r0.addURI("com.android.contacts", "contacts/lookup/*", 1);
        r0.addURI("com.android.contacts", "contacts/#/photo", 2);
        r0.addURI("com.android.contacts", "contacts/#", 3);
        r0.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        r0.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver r1, Uri r2) {
        super(r1, r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected InputStream loadResource(Uri r2, ContentResolver r3) throws FileNotFoundException {
        InputStream r1 = loadResourceFromUri(r2, r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new FileNotFoundException("InputStream is null for " + r2);
    }

    private InputStream loadResourceFromUri(Uri r3, ContentResolver r4) throws FileNotFoundException {
        int r0 = URI_MATCHER.match(r3);
        if (r0 != 1) goto L5;
    L12:
        Uri r5 = ContactsContract.Contacts.lookupContact(r4, r3);
        if (r5 == null) goto L17;
        return openContactPhotoInputStream(r4, r5);
    L17:
        throw new FileNotFoundException("Contact cannot be found");
    L5:
        if (r0 == 3) goto L11;
        if (r0 == 5) goto L12;
        return r4.openInputStream(r3);
    L11:
        return openContactPhotoInputStream(r4, r3);
    }

    private InputStream openContactPhotoInputStream(ContentResolver r1, Uri r2) {
        return ContactsContract.Contacts.openContactPhotoInputStream(r1, r2, true);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    protected void close2(InputStream r1) throws IOException {
        r1.close();
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
