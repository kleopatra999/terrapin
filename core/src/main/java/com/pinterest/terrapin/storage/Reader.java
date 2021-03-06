/**
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.pinterest.terrapin.storage;

import com.twitter.util.Future;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/**
 * Creates a Reader for performing lookups on underlying files such as HFiles.
 */
public interface Reader {
  /**
   * Returns a map from key to union of value or exception (if an error occurs).
   * If a higher level error occurs, it will throw an exception.
   *
   * @param keyList The list of keys to query.
   * @return A map from key to either the value or an exception (if an error occurs.
   */
  public Future<Map<ByteBuffer, Pair<ByteBuffer, Throwable>>> getValues(
      List<ByteBuffer> keyList) throws Throwable;

  /**
   * Closes the reader releasing underlying resources.
   * @throws IOException
   */
  public void close() throws IOException;
}
