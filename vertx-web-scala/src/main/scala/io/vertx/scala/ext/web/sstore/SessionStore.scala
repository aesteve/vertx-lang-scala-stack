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

package io.vertx.scala.ext.web.sstore

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.Session
import io.vertx.core.Handler

/**
  * A session store is used to store sessions for an Vert.x-Web web app
  */
class SessionStore(private val _asJava: io.vertx.ext.web.sstore.SessionStore) {

  def asJava: io.vertx.ext.web.sstore.SessionStore = _asJava

  /**
    * The retry timeout value in milli seconds used by the session handler when it retrieves a value from the store.<p/>
    *
    * A non positive value means there is no retry at all.
    * @return the timeout value, in ms
    */
  def retryTimeout(): Long = {
    _asJava.retryTimeout()
  }

  /**
    * Create a new session
    * @param timeout - the session timeout, in ms
    * @return the session
    */
  def createSession(timeout: Long): io.vertx.scala.ext.web.Session = {
    Session.apply(_asJava.createSession(timeout))
  }

  /**
    * Get the session with the specified ID
    * @param id the unique ID of the session
    * @return will be called with a result holding the session, or a failure
    */
  def getFuture(id: String): concurrent.Future[io.vertx.scala.ext.web.Session] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.web.Session,io.vertx.scala.ext.web.Session]((x => if (x == null) null else Session.apply(x)))
    _asJava.get(id, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Delete the session with the specified ID
    * @param id the unique ID of the session
    * @return will be called with a result true/false, or a failure
    */
  def deleteFuture(id: String): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.delete(id, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add a session with the specified ID
    * @param session the session
    * @return will be called with a result true/false, or a failure
    */
  def putFuture(session: io.vertx.scala.ext.web.Session): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.put(session.asJava.asInstanceOf[io.vertx.ext.web.Session], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove all sessions from the store
    * @return will be called with a result true/false, or a failure
    */
  def clearFuture(): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get the number of sessions in the store
    * @return will be called with the number, or a failure
    */
  def sizeFuture(): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer,Int]((x => x))
    _asJava.size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the store
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object SessionStore {

  def apply(_asJava: io.vertx.ext.web.sstore.SessionStore): io.vertx.scala.ext.web.sstore.SessionStore =
    new io.vertx.scala.ext.web.sstore.SessionStore(_asJava)

}
