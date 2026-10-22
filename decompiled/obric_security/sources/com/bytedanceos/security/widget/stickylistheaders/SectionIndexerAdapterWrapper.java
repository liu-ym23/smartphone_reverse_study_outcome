package com.bytedanceos.security.widget.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

/* JADX INFO: loaded from: classes2.dex */
class SectionIndexerAdapterWrapper extends AdapterWrapper implements SectionIndexer {
    final SectionIndexer mSectionIndexerDelegate;

    SectionIndexerAdapterWrapper(Context context, StickyListHeadersAdapter delegate) {
        super(context, delegate);
        this.mSectionIndexerDelegate = (SectionIndexer) delegate;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int section) {
        return this.mSectionIndexerDelegate.getPositionForSection(section);
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int position) {
        return this.mSectionIndexerDelegate.getSectionForPosition(position);
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.mSectionIndexerDelegate.getSections();
    }
}
