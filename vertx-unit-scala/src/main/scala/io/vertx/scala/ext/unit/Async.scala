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

package io.vertx.scala.ext.unit

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.scala.core.Future

/**
  * An asynchronous exit point for a test.<p/>
  */
class Async(private val _asJava: io.vertx.ext.unit.Async) {

  def asJava: io.vertx.ext.unit.Async = _asJava

  /**
    * Completes the future upon completion, otherwise fails it.
    * @param future the future to resolve
    */
  def resolve(future: io.vertx.scala.core.Future[Unit]): Unit = {
    _asJava.resolve(future.asJava.asInstanceOf[io.vertx.core.Future[java.lang.Void]])
  }

  /**
    * Completion handler to receive a completion signal when this completions completes.
    * @return the completion future
    */
  def handlerFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.handler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * @return the current count
    */
  def count(): Int = {
    _asJava.count()
  }

  /**
    * Count down the async.
    */
  def countDown(): Unit = {
    _asJava.countDown()
  }

  /**
    * Signals the asynchronous operation is done, this method must be called with a count greater than `0`,
    * otherwise it throw an `IllegalStateException` to signal the error.
    */
  def complete(): Unit = {
    _asJava.complete()
  }

}

object Async {

  def apply(_asJava: io.vertx.ext.unit.Async): io.vertx.scala.ext.unit.Async =
    new io.vertx.scala.ext.unit.Async(_asJava)

}
