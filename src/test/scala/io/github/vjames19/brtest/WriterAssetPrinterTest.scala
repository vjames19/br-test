package io.github.vjames19.brtest

import java.io.{BufferedWriter, StringWriter}

import io.github.vjames19.brtest.generator.RandomAssetGenerator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vreventos on 5/3/17.
  */
class WriterAssetPrinterTest extends FlatSpec with Matchers {

  val generator = new RandomAssetGenerator()

  "print" should "write the asset details using the case class toString and output a newLine" in {
    val stringWriter = new StringWriter()
    val writer = new BufferedWriter(stringWriter)
    val printer = new WriterAssetPrinter(writer)

    val asset = generator.generateVideo()
    printer.print(asset)
    writer.close()

    stringWriter.toString shouldEqual s"$asset\n"
  }

  it should "be able to write multiple assets" in {
    val stringWriter = new StringWriter()
    val writer = new BufferedWriter(stringWriter)
    val printer = new WriterAssetPrinter(writer)

    val videoAsset = generator.generateVideo()
    val adAsset = generator.generateAd()

    printer.print(videoAsset)
    printer.print(adAsset)
    writer.close()

    stringWriter.toString shouldEqual s"$videoAsset\n$adAsset\n"
  }
}
