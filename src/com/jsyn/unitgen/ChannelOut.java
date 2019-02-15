/*
 * Copyright 2009 Phil Burk, Mobileer Inc
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

import com.jsyn.ports.UnitInputPort;

/**
 * Provides access to one channel of the audio output.
 *
 * @author Phil Burk (C) 2009 Mobileer Inc
 * @see ChannelIn
 */
public class ChannelOut extends UnitGenerator {
    public UnitInputPort input;
    private int channelIndex;

    public ChannelOut() {
        addPort(input = new UnitInputPort("Input"));
    }

    public int getChannelIndex() {
        return channelIndex;
    }

    public void setChannelIndex(int channelIndex) {
        this.channelIndex = channelIndex;
    }

    /**
     * This unit won't do anything unless you start() it.
     */
    @Override
    public boolean isStartRequired() {
        return true;
    }

    @Override
    public void generate(int start, int limit) {
        double[] inputs = input.getValues(0);
        double[] buffer = synthesisEngine.getOutputBuffer(channelIndex);
        for (int i = start; i < limit; i++) {
            buffer[i] += inputs[i];
        }
    }

}
