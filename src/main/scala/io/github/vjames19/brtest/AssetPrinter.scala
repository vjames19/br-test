package io.github.vjames19.brtest

import java.io.{BufferedWriter, OutputStreamWriter}

/**
  * Created by vreventos on 5/2/17.
  */
trait AssetPrinter {

  def print(asset: Asset): Unit
}

class WriterAssetPrinter(writer: BufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)))
  extends AssetPrinter {

  override def print(asset: Asset): Unit = {
    writer.write(asset.toString)
    writer.newLine()
  }
}
