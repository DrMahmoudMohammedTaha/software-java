/*
 * Copyright 2016 DELL.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sourceforge.tess4j;

/**
 *
 * @author DELL
 */
public class pixel {

    int x;
    int y;
    int position;

    public pixel(int x, int y, int position) {
        this.x = x;
        this.y = y;
        this.position = position;
    }

    public pixel(int pos) {
        this.position = pos;
    }

    public void set_data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String show() {
        return "new pixel (" + x + " , " + y + " , " + position + ")";
    }

    public static pixel get_target(pixel[] temp, int value) {
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].position == value) {
                return temp[i];
                
            }
        }
        return null;
    }

}
