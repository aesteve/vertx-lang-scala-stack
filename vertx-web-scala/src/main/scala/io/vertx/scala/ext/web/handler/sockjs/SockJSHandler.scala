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

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.scala.ext.web.Router
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions
import io.vertx.ext.web.handler.sockjs.BridgeOptions

/**
  *
  * A handler that allows you to handle SockJS connections from clients.
  * 
  * We currently support version 0.3.3 of the SockJS protocol, which can be found in
  * <a href="https://github.com/sockjs/sockjs-protocol/tree/v0.3.3">this tag:</a>
  */
class SockJSHandler(private val _asJava: io.vertx.ext.web.handler.sockjs.SockJSHandler) {

  def asJava: io.vertx.ext.web.handler.sockjs.SockJSHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Set a SockJS socket handler. This handler will be called with a SockJS socket whenever a SockJS connection
    * is made from a client
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def socketHandler(handler: io.vertx.scala.ext.web.handler.sockjs.SockJSSocket => Unit): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler = {
    _asJava.socketHandler(funcToMappedHandler(SockJSSocket.apply)(handler))
    this
  }

  /**
    * Bridge the SockJS handler to the Vert.x event bus. This basically installs a built-in SockJS socket handler
    * which takes SockJS traffic and bridges it to the event bus, thus allowing you to extend the server-side
    * Vert.x event bus to browsers
    * @param bridgeOptions options to configure the bridge withsee <a href="../../../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def bridge(bridgeOptions: io.vertx.scala.ext.web.handler.sockjs.BridgeOptions): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler = {
    _asJava.bridge(bridgeOptions.asJava)
    this
  }

  /**
    * Like [[io.vertx.scala.ext.web.handler.sockjs.SockJSHandler#bridge]] but specifying a handler
    * that will receive bridge events.
    * @param bridgeOptions options to configure the bridge withsee <a href="../../../../../../../../../cheatsheet/BridgeOptions.html">BridgeOptions</a>
    * @param bridgeEventHandler handler to receive bridge events
    * @return a reference to this, so the API can be used fluently
    */
  def bridge(bridgeOptions: io.vertx.scala.ext.web.handler.sockjs.BridgeOptions, bridgeEventHandler: io.vertx.scala.ext.web.handler.sockjs.BridgeEvent => Unit): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler = {
    _asJava.bridge(bridgeOptions.asJava, funcToMappedHandler(BridgeEvent.apply)(bridgeEventHandler))
    this
  }

}

object SockJSHandler {

  def apply(_asJava: io.vertx.ext.web.handler.sockjs.SockJSHandler): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler =
    new io.vertx.scala.ext.web.handler.sockjs.SockJSHandler(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler = {
    SockJSHandler.apply(io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.ext.web.handler.sockjs.SockJSHandlerOptions): io.vertx.scala.ext.web.handler.sockjs.SockJSHandler = {
    SockJSHandler.apply(io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

  def installTestApplications(router: io.vertx.scala.ext.web.Router, vertx: io.vertx.scala.core.Vertx): Unit = {
    io.vertx.ext.web.handler.sockjs.SockJSHandler.installTestApplications(router.asJava.asInstanceOf[io.vertx.ext.web.Router], vertx.asJava.asInstanceOf[io.vertx.core.Vertx])
  }

}
