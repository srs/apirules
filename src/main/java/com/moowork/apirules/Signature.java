package com.moowork.apirules;

public final class Signature
{
    private final String ownerClass;

    private final String signature;

    private final Location location;

    public Signature( final String ownerClass, final String signature, final Location location )
    {
        this.ownerClass = ownerClass;
        this.signature = signature;
        this.location = location;
    }

    public String getOwnerClass()
    {
        return this.ownerClass;
    }

    public String getSignature()
    {
        return this.signature;
    }

    public Location getLocation()
    {
        return this.location;
    }
}
