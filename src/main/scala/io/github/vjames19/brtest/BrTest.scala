package io.github.vjames19.brtest

import java.io.{BufferedWriter, OutputStreamWriter}

import io.github.vjames19.brtest.generator.{AssetGenerator, ContainerGenerator, RandomAssetGenerator, StaticShowContainerGenerator}

class BrTest(private val assetGenerator: AssetGenerator,
             private val containerGenerator: ContainerGenerator,
             private val assetPrinter: AssetPrinter) {

  def run(): Unit = {
    generateContainer().assets.foreach(assetPrinter.print)
  }

  private[brtest] def generateContainer(): Container = {
    containerGenerator.generateContainer(generateAssets())
  }

  private[brtest] def generateAssets(): Seq[Asset] = {
    AssetType.values
      .map(assetGenerator.generate)
      .toSeq
  }
}

object BrTest {

  def main(args: Array[String]): Unit = {
    val writer = new BufferedWriter(new OutputStreamWriter(System.out))
    val test = new BrTest(new RandomAssetGenerator(),
      new StaticShowContainerGenerator(),
      new WriterAssetPrinter(writer))

    test.run()
    writer.close()
  }
}
