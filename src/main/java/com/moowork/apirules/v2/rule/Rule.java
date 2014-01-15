package com.moowork.apirules.v2.rule;

import java.util.Set;
import java.util.regex.Pattern;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;

public final class Rule
{
    private final String message;

    private final ImmutableSet<String> patterns;

    private final Iterable<Pattern> compiled;

    public Rule( final String message, final String... patterns )
    {
        this.message = message;
        this.patterns = ImmutableSet.copyOf( patterns );
        this.compiled = Collections2.transform( this.patterns, new Function<String, Pattern>()
        {
            @Override
            public Pattern apply( final String input )
            {
                return compile( input );
            }
        } );
    }

    public String getMessage()
    {
        return this.message;
    }

    public Set<String> getPatterns()
    {
        return this.patterns;
    }

    public boolean matches( final String signature )
    {
        for ( final Pattern pattern : this.compiled )
        {
            if ( pattern.matcher( signature ).matches() )
            {
                return true;
            }
        }

        return false;
    }

    private static Pattern compile( final String pattern )
    {
        final String regExp = pattern.replace( "*", ".+" ).replace( ".", "\\." );
        return Pattern.compile( regExp );
    }
}
