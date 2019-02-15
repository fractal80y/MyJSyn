/*
 * Copyright 1997 Phil Burk, Mobileer Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jsyn.unitgen;

/**
 * Output 1.0 if the input crosses from zero while rising. Otherwise output zero. The output is a
 * single sample wide impulse. This can be used with a Latch to implement a "sample and hold"
 * circuit.
 *
 * @author (C) 1997-2010 Phil Burk, Mobileer Inc
 * @see Latch
 */
public class EdgeDetector extends UnitFilter {
    private double previous = 0.0;

    public EdgeDetector() {
    }

    @Override
    public void generate(int start, int limit) {
        double[] inputs = input.getValues();
        double[] outputs = output.getValues();

        for (int i = start; i < limit; i++) {
            double in = inputs[i];
            outputs[i] = ((previous <= 0.0) && (in > 0.0)) ? 1.0 : 0.0;
            previous = in;
        }
    }
}
