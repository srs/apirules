package com.moowork.apirules;

public final class Violation
{
    private final String message;

    private final Signature signature;

    public Violation( final String message, final Signature signature )
    {
        this.message = message;
        this.signature = signature;
    }

    public String getMessage()
    {
        return this.message;
    }

    public Signature getSignature()
    {
        return this.signature;
    }

    @Override
    public String toString()
    {
        final StringBuilder str = new StringBuilder( this.message );
        str.append( this.message ).append( "\n\r  in " );
        str.append( this.signature.getOwnerClass() );

        if ( this.signature.getLocation() != null )
        {
            str.append( " (" ).append( this.signature.getLocation().toString() ).append( ")" );
        }

        return str.toString();
    }
}
