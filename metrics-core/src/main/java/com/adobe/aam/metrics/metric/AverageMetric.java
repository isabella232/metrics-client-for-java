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

package com.adobe.aam.metrics.metric;

import java.util.List;

public class AverageMetric extends Metric {
	private final Object mutex = new Object();
	private double total;
	private long count;

	public AverageMetric(MetricLabels labels) {
		super(labels);
	}

	@Override
	public Type getType() {
		return Type.AVG;
	}

	@Override
	public void doTrack(double value) {
		synchronized (mutex) {
			total += value;
			count++;
		}
	}

	@Override
	public double doGetAndReset() {
		synchronized (mutex) {
			double result = get();
			total = count = 0;
			return result;
		}
	}

	@Override
	public double get() {
		synchronized (mutex) {
			if (count == 0) {
				return 0;
			}
			return total / count;
		}
	}
}
