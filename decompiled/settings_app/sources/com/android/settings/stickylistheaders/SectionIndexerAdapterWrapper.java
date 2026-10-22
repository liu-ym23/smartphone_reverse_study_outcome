package com.android.settings.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

/* JADX INFO: loaded from: classes2.dex */
class SectionIndexerAdapterWrapper extends AdapterWrapper implements SectionIndexer {
    final SectionIndexer mSectionIndexerDelegate;

    SectionIndexerAdapterWrapper(Context r1, StickyListHeadersAdapter r2) {
        super(r1, r2);
        this.mSectionIndexerDelegate = (SectionIndexer) r2;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int r1) {
        return this.mSectionIndexerDelegate.getPositionForSection(r1);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int r1) {
        return this.mSectionIndexerDelegate.getSectionForPosition(r1);
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.mSectionIndexerDelegate.getSections();
    }
}
