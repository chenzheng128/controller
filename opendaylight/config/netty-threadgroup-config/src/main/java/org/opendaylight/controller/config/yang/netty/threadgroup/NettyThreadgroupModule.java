/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

/**
* Generated file

* Generated from: yang module name: nsos-threadpool  yang module local name: netty-threadgroup-fixed
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Fri Nov 08 08:31:45 CET 2013
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.controller.config.yang.netty.threadgroup;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;
import io.netty.channel.EventLoopGroup;
import java.lang.reflect.Method;
import org.opendaylight.controller.config.api.JmxAttributeValidationException;
import org.opendaylight.controller.config.api.osgi.WaitingServiceTracker;
import org.osgi.framework.BundleContext;

/**
*
*/
public final class NettyThreadgroupModule extends org.opendaylight.controller.config.yang.netty.threadgroup.AbstractNettyThreadgroupModule
{
    private BundleContext bundleContext;

    public NettyThreadgroupModule(org.opendaylight.controller.config.api.ModuleIdentifier name, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(name, dependencyResolver);
    }

    public NettyThreadgroupModule(org.opendaylight.controller.config.api.ModuleIdentifier name, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, NettyThreadgroupModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(name, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void validate(){
        if(getThreadCount()!=null) {
            JmxAttributeValidationException.checkCondition(getThreadCount() > 0, "value must be greater than 0",
                    threadCountJmxAttribute);
        }
    }

    @Override
    public AutoCloseable createInstance() {
        // The service is provided via blueprint so wait for and return it here for backwards compatibility.
        String typeFilter = String.format("(type=%s)", getIdentifier().getInstanceName());
        final WaitingServiceTracker<EventLoopGroup> tracker = WaitingServiceTracker.create(
                EventLoopGroup.class, bundleContext, typeFilter);
        final EventLoopGroup group = tracker.waitForService(WaitingServiceTracker.FIVE_MINUTES);

        return Reflection.newProxy(AutoCloseableEventLoopGroupInterface.class, new AbstractInvocationHandler() {
            @Override
            protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("close")) {
                    tracker.close();
                    return null;
                } else {
                    return method.invoke(group, args);
                }
            }
        });
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    private static interface AutoCloseableEventLoopGroupInterface extends EventLoopGroup, AutoCloseable {
    }
}
