/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

/**
* Generated file

* Generated from: yang module name: toaster-provider-impl  yang module local name: toaster-provider-impl
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Wed Feb 05 11:05:32 CET 2014
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.controller.config.yang.config.toaster_provider.impl;

import org.opendaylight.controller.sal.common.util.NoopAutoCloseable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
*/
public final class ToasterProviderModule extends
        org.opendaylight.controller.config.yang.config.toaster_provider.impl.AbstractToasterProviderModule {
    private static final Logger log = LoggerFactory.getLogger(ToasterProviderModule.class);

    public ToasterProviderModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public ToasterProviderModule(final org.opendaylight.controller.config.api.ModuleIdentifier identifier,
            final org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,
            final ToasterProviderModule oldModule, final java.lang.AutoCloseable oldInstance) {

        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    protected void customValidation() {
        // No need to validate dependencies, since all dependencies have
        // mandatory true flag in yang
        // config-subsystem will perform the validation for dependencies
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        // The components are created and wired via blueprint and, since this module doesn't advertise any
        // services, return an empty AutoCloseable. The config module is kept for backwards compatibility.
        return NoopAutoCloseable.INSTANCE;
    }
}
