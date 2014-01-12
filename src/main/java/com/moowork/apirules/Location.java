package com.moowork.apirules;

public final class Location
{
    private final String source;

    private final int lineNumber;

    public Location( final String source, final int lineNumber )
    {
        this.source = source;
        this.lineNumber = lineNumber;
    }

    public String getSource()
    {
        return this.source;
    }

    public int getLineNumber()
    {
        return this.lineNumber;
    }

    @Override
    public String toString()
    {
        if ( this.lineNumber >= 0 )
        {
            return this.source + ":" + this.lineNumber;
        }
        else
        {
            return this.source;
        }
    }
}
