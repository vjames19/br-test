package io.github.vjames19.brtest

import io.github.vjames19.brtest.generator.{RandomAssetGenerator, StaticShowContainerGenerator}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vreventos on 5/3/17.
  */
class BrTestTest extends FlatSpec with Matchers {

  val br = new BrTest(
    new RandomAssetGenerator(),
    new StaticShowContainerGenerator(),
    new WriterAssetPrinter()
  )

  "generateAssets" should "generate an asset for each assetType" in {
    br.generateAssets().map(_.assetType).toSet shouldEqual AssetType.values
  }

  "generateContainer" should "generate a container with an asset for each assetType" in {
    br.generateContainer().assets.map(_.assetType).toSet shouldEqual AssetType.values
  }
}
