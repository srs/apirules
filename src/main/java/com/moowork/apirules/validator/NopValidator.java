package com.moowork.apirules.validator;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violations;

public final class NopValidator
    implements SignatureValidator
{
    @Override
    public Violations validate( final Signature signature )
    {
        return new Violations();
    }
}
