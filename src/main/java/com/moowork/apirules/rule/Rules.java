package com.moowork.apirules.rule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violation;
import com.moowork.apirules.Violations;

public final class Rules
    implements Iterable<Rule>
{
    private final List<Rule> list;

    public Rules()
    {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty()
    {
        return this.list.isEmpty();
    }

    @Override
    public Iterator<Rule> iterator()
    {
        return this.list.iterator();
    }

    public Rules add( final Rule rule )
    {
        this.list.add( rule );
        return this;
    }

    public Rules addAll( final Iterable<Rule> rules )
    {
        for ( final Rule rule : rules )
        {
            this.list.add( rule );
        }

        return this;
    }

    public Violations check( final Signature signature )
    {
        final Violations result = new Violations();
        for ( final Rule rule : this.list )
        {
            final Violation violation = rule.check( signature );
            if ( violation != null )
            {
                result.add( violation );
            }
        }

        return result;
    }
}
