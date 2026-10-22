package com.android.creator;

interface IdsSupplier {
     boolean isSupported();
     String getUDID(String pkg);
     String getOAID();
}