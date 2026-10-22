package com.android.vcard;

/* JADX INFO: loaded from: classes.dex */
public interface VCardInterpreter {
    void onEntryEnded();

    void onEntryStarted();

    void onPropertyCreated(VCardProperty r1);

    void onVCardEnded();

    void onVCardStarted();
}
