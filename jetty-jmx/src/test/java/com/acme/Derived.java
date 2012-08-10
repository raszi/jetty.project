// ========================================================================
// Copyright (c) 2004-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package com.acme;

import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;

@ManagedObject(value="Test the mbean stuff", wrapper="com.acme.jmx.DerivedMBean")
public class Derived extends Base implements Signature
{
    String fname="Full Name";

    Managed managedInstance = new Managed();
    
    @ManagedAttribute(value="The full name of something", name="fname", setter="setFullName")
    public String getFullName()
    {
        return fname;
    }

    public void setFullName(String name)
    {
        fname=name;
    }

    @ManagedOperation("publish something")
    public void publish()
    {
        System.err.println("publish");
    }
    
    @ManagedOperation("Doodle something")
    public void doodle(@Name(value="doodle", description="A description of the argument") String doodle)
    {
        System.err.println("doodle "+doodle);
    }

    public String bad()
    {
        return "bad";
    }

    @ManagedAttribute( value="sample managed object")
    public Managed getManagedInstance()
    {
        return managedInstance;
    }

    public void setManagedInstance(Managed managedInstance)
    {
        this.managedInstance = managedInstance;
    }
    
    
}
