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

import java.io.File;
import java.io.IOException;
import static net.sourceforge.tess4j.ImageFactory.reader;

/**
 *
 * @author DELL
 */
public class ocr {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final double THRESHOLD = 0.1;

    public static void main(String[] args) throws IOException {

        test_sample();
        // method reader (image path + image name ) can read any image
    }

    public static String test_sample() throws IOException {
        String result = "";
        File file = new File("images");
        File group[] = file.listFiles();
        for (int i = 0; i < group.length; i++) {
            result = reader("images//" + group[i].getName());
        }

        return result;
    }


}
