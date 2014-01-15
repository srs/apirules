package com.moowork.apirules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Violations
    implements Iterable<Violation>
{
    private final List<Violation> list;

    public Violations()
    {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Violation> iterator()
    {
        return this.list.iterator();
    }

    public Violations add( final Violation violation )
    {
        this.list.add( violation );
        return this;
    }

    public Violations addAll( final Violations violations )
    {
        this.list.addAll( violations.list );
        return this;
    }
}
