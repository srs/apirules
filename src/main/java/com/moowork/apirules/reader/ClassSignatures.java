package com.moowork.apirules.reader;

import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

public final class ClassSignatures
    implements Iterable<String>
{
    private final String className;

    private final Set<String> set;

    public ClassSignatures( final String className )
    {
        this.className = className;
        this.set = Sets.newHashSet();
    }

    public String getClassName()
    {
        return this.className;
    }

    public Set<String> getSignatures()
    {
        return this.set;
    }

    @Override
    public Iterator<String> iterator()
    {
        return this.set.iterator();
    }

    public void add( final String signature )
    {
        this.set.add( signature );
    }
}
