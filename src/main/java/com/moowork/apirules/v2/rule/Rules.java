package com.moowork.apirules.v2.rule;

public final class Rules
{
    public Rules add( final Rule rule )
    {
        return this;
    }

    public Rules add( final String message, final String... patterns )
    {
        return add( new Rule( message, patterns ) );
    }
}
