/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.mongo

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options for configuring updates.
  */

class UpdateOptions(val asJava: io.vertx.ext.mongo.UpdateOptions) {

  /**
    * Set whether multi is enabled
    */
  def setMulti(value:Boolean) = {
    asJava.setMulti(value)
    this
  }
  def isMulti = {
    asJava.isMulti()
  }

  /**
    * Set whether upsert is enabled
    */
  def setUpsert(value:Boolean) = {
    asJava.setUpsert(value)
    this
  }
  def isUpsert = {
    asJava.isUpsert()
  }

  /**
    * Set the write option
    */
  def setWriteOption(value:io.vertx.ext.mongo.WriteOption) = {
    asJava.setWriteOption(value)
    this
  }
  def getWriteOption = {
    asJava.getWriteOption()
  }
}

object UpdateOptions {
  type UpdateOptionsJava = io.vertx.ext.mongo.UpdateOptions
  
  def apply(t: UpdateOptionsJava) = {
    if(t != null)
      new UpdateOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):UpdateOptions = {
    if(json != null)
      new UpdateOptions(new UpdateOptionsJava(json))
    else
      null
  }
}
