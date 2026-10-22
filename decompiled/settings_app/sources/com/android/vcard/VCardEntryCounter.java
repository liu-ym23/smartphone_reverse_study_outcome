package com.android.vcard;

/* JADX INFO: loaded from: classes.dex */
public class VCardEntryCounter implements VCardInterpreter {
    private int mCount;

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryStarted() {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onPropertyCreated(VCardProperty r1) {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardEnded() {
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onVCardStarted() {
    }

    public VCardEntryCounter() {
    }

    public int getCount() {
        return this.mCount;
    }

    @Override // com.android.vcard.VCardInterpreter
    public void onEntryEnded() {
        this.mCount++;
    }
}
