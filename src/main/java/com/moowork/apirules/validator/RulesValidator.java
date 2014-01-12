package com.moowork.apirules.validator;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violations;
import com.moowork.apirules.rule.Rules;

public final class RulesValidator
    implements SignatureValidator
{
    private final Rules rules;

    public RulesValidator( final Rules rules )
    {
        this.rules = rules;
    }

    @Override
    public Violations validate( final Signature signature )
    {
        return this.rules.check( signature );
    }
}
