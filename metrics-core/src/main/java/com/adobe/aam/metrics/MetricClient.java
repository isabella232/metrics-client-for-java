/*
 * Copyright 2018 Adobe Systems Incorporated. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 */

package com.adobe.aam.metrics;

import com.adobe.aam.metrics.metric.Metric;

import java.util.Collection;

public interface MetricClient {

    void send(Metric metric);

    void send(Collection<Metric> metrics);

    /**
     * Flushes the collected metrics to the underlying publishers. Write them immediately to their
     * intended destination.
     */
    void flush();
}
