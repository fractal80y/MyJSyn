/*
 * Copyright 2011 Phil Burk, Mobileer Inc
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

package com.jsyn.util;

import com.softsynth.shared.time.TimeStamp;

/**
 * A note player that references one or more voices by a noteNumber. This is similar to the MIDI
 * protocol that references voices by an integer pitch or keyIndex.
 * 
 * @author Phil Burk (C) 2011 Mobileer Inc
 */
public interface Instrument {
    // This will be applied to the voice when noteOn is called.
    void usePreset(int presetIndex, TimeStamp timeStamp);

    public void noteOn(int tag, double frequency, double amplitude, TimeStamp timeStamp);

    public void noteOff(int tag, TimeStamp timeStamp);

    public void setPort(int tag, String portName, double value, TimeStamp timeStamp);

    public void allNotesOff(TimeStamp timeStamp);
}
