/*
 * Copyright (C) The Apache Software Foundation. All rights reserved.
 *
 * This software is published under the terms of the Apache Software License
 * version 1.1, a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 */
package org.apache.antlib.core;

import org.apache.aut.converter.AbstractConverter;
import org.apache.aut.converter.ConverterException;
import org.apache.avalon.excalibur.i18n.ResourceManager;
import org.apache.avalon.excalibur.i18n.Resources;

/**
 * String to class converter
 *
 * @author <a href="mailto:peter@apache.org">Peter Donald</a>
 * @ant.converter source="java.lang.String" destination="java.lang.Class"
 */
public class StringToClassConverter
    extends AbstractConverter
{
    private final static Resources REZ =
        ResourceManager.getPackageResources( StringToClassConverter.class );

    public StringToClassConverter()
    {
        super( String.class, Class.class );
    }

    public Object convert( final Object object, final Object context )
        throws ConverterException
    {
        //TODO: Should we use ContextClassLoader here???
        try
        {
            return Class.forName( (String)object );
        }
        catch( final Exception e )
        {
            final String message = REZ.getString( "convert.bad-class.error", object );
            throw new ConverterException( message, e );
        }
    }
}

