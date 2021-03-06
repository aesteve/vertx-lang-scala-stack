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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.MongoClientDeleteResult
import io.vertx.ext.mongo.WriteOption
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.IndexOptions
import io.vertx.ext.mongo.FindOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler
import io.vertx.ext.mongo.MongoClientUpdateResult
import io.vertx.ext.mongo.UpdateOptions

/**
  * A Vert.x service used to interact with MongoDB server instances.
  * 
  * Some of the operations might change <i>_id</i> field of passed  document.
  */
class MongoClient(private val _asJava: io.vertx.ext.mongo.MongoClient) {

  def asJava: io.vertx.ext.mongo.MongoClient = _asJava

  /**
    * Save a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @return result future will be provided with the id if document didn't already have one
    */
  def saveFuture(collection: String, document: io.vertx.core.json.JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.save(collection, document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Save a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @return result future will be provided with the id if document didn't already have one
    */
  def saveWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.saveWithOptions(collection, document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Insert a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @return result future will be provided with the id if document didn't already have one
    */
  def insertFuture(collection: String, document: io.vertx.core.json.JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.insert(collection, document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Insert a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @return result future will be provided with the id if document didn't already have one
    */
  def insertWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.insertWithOptions(collection, document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Update matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @return will be called when complete
    */
  def updateFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.update(collection, query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @return will be called when complete
    */
  def updateCollectionFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientUpdateResult,io.vertx.scala.ext.mongo.MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.updateCollection(collection, query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Update matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @return will be called when complete
    */
  def updateWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.updateWithOptions(collection, query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @return will be called when complete
    */
  def updateCollectionWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientUpdateResult,io.vertx.scala.ext.mongo.MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.updateCollectionWithOptions(collection, query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace matching documents in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @return will be called when complete
    */
  def replaceFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.replace(collection, query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @return will be called when complete
    */
  def replaceDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientUpdateResult,io.vertx.scala.ext.mongo.MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.replaceDocuments(collection, query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace matching documents in the specified collection, specifying options
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @return will be called when complete
    */
  def replaceWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.replaceWithOptions(collection, query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @return will be called when complete
    */
  def replaceDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.UpdateOptions): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientUpdateResult,io.vertx.scala.ext.mongo.MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match documents
    * @return will be provided with list of documents
    */
  def findFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.find(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find matching documents in the specified collection.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @return will be provided with each found document
    */
  def findBatchFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject]((x => x))
    _asJava.findBatch(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @return will be provided with list of documents
    */
  def findWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.findWithOptions(collection, query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find matching documents in the specified collection, specifying options.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @return will be provided with each found document
    */
  def findBatchWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.FindOptions): concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject]((x => x))
    _asJava.findBatchWithOptions(collection, query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Find a single matching document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param fields the fields
    * @return will be provided with the document, if any
    */
  def findOneFuture(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject]((x => x))
    _asJava.findOne(collection, query, fields, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Count matching documents in a collection.
    * @param collection the collection
    * @param query query used to match documents
    * @return will be provided with the number of matching documents
    */
  def countFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.count(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove matching documents from a collection
    * @param collection the collection
    * @param query query used to match documents
    * @return will be called when complete
    */
  def removeFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.remove(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @return will be called when complete
    */
  def removeDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientDeleteResult,io.vertx.scala.ext.mongo.MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocuments(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove matching documents from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @return will be called when complete
    */
  def removeWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @return will be called when complete
    */
  def removeDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientDeleteResult,io.vertx.scala.ext.mongo.MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a single matching document from a collection
    * @param collection the collection
    * @param query query used to match document
    * @return will be called when complete
    */
  def removeOneFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeOne(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @return will be called when complete
    */
  def removeDocumentFuture(collection: String, query: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientDeleteResult,io.vertx.scala.ext.mongo.MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocument(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a single matching document from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @return will be called when complete
    */
  def removeOneWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeOneWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @return will be called when complete
    */
  def removeDocumentWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[io.vertx.scala.ext.mongo.MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.mongo.MongoClientDeleteResult,io.vertx.scala.ext.mongo.MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocumentWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Create a new collection
    * @param collectionName the name of the collection
    * @return will be called when complete
    */
  def createCollectionFuture(collectionName: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createCollection(collectionName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get a list of all collections in the database.
    * @return will be called with a list of collections.
    */
  def getCollectionsFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asScala))
    _asJava.getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Drop a collection
    * @param collection the collection
    * @return will be called when complete
    */
  def dropCollectionFuture(collection: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.dropCollection(collection, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @return will be called when complete
    */
  def createIndexFuture(collection: String, key: io.vertx.core.json.JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createIndex(collection, key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
    * @return will be called when complete
    */
  def createIndexWithOptionsFuture(collection: String, key: io.vertx.core.json.JsonObject, options: io.vertx.scala.ext.mongo.IndexOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createIndexWithOptions(collection, key, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get all the indexes in this collection.
    * @param collection the collection
    * @return will be called when complete
    */
  def listIndexesFuture(collection: String): concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonArray,io.vertx.core.json.JsonArray]((x => x))
    _asJava.listIndexes(collection, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Drops the index given its name.
    * @param collection the collection
    * @param indexName the name of the index to remove
    * @return will be called when complete
    */
  def dropIndexFuture(collection: String, indexName: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.dropIndex(collection, indexName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Run an arbitrary MongoDB command.
    * @param commandName the name of the command
    * @param command the command
    * @return will be called with the result.
    */
  def runCommandFuture(commandName: String, command: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject]((x => x))
    _asJava.runCommand(commandName, command, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Gets the distinct values of the specified field name.
    * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
    * @param collection the collection
    * @param fieldName the field name
    * @return will be provided with array of values.
    */
  def distinctFuture(collection: String, fieldName: String, resultClassname: String): concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonArray,io.vertx.core.json.JsonArray]((x => x))
    _asJava.distinct(collection, fieldName, resultClassname, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Gets the distinct values of the specified field name.
    * This method use batchCursor for returning each found value.
    * Each value is a json fragment with fieldName key (eg: {"num": 1`).
    * @param collection the collection
    * @param fieldName the field name
    * @return will be provided with each found value
    */
  def distinctBatchFuture(collection: String, fieldName: String, resultClassname: String): concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject]((x => x))
    _asJava.distinctBatch(collection, fieldName, resultClassname, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the client and release its resources
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object MongoClient {

  def apply(_asJava: io.vertx.ext.mongo.MongoClient): io.vertx.scala.ext.mongo.MongoClient =
    new io.vertx.scala.ext.mongo.MongoClient(_asJava)

  def createNonShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createNonShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject, dataSourceName: String): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config, dataSourceName))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.mongo.MongoClient = {
    MongoClient.apply(io.vertx.ext.mongo.MongoClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

}
