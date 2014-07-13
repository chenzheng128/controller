/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.cluster.raft;

/**
 * Represents the ReplicatedLog that needs to be kept in sync by the RaftActor
 */
public interface ReplicatedLog {
    /**
     * Get a replicated log entry at the specified index
     *
     * @param index
     * @return
     */
    ReplicatedLogEntry get(long index);


    /**
     * Get the last replicated log entry
     *
     * @return
     */
    ReplicatedLogEntry last();

    /**
     * Remove all the entries from the logs >= index
     *
     * @param index
     */
    void removeFrom(long index);

    /**
     * Append an entry to the log
     * @param replicatedLogEntry
     */
    void append(ReplicatedLogEntry replicatedLogEntry);
}