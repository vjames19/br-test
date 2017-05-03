package io.github.vjames19.brtest.generator

import io.github.vjames19.brtest.{Ad, AssetType, Image, Video}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vreventos on 5/3/17.
  */
class RandomAssetGeneratorTest extends FlatSpec with Matchers {

  val generator = new RandomAssetGenerator()

  behavior of "generate"

  it should "when called with a Ad assetType return a ad asset" in {
    generator.generate(AssetType.Ad) shouldBe a[Ad]
  }

  it should "when called with a Image assetType return a image asset" in {
    generator.generate(AssetType.Image) shouldBe a[Image]
  }

  it should "when called with a Video assetType return a video asset" in {
    generator.generate(AssetType.Video) shouldBe a[Video]
  }
}
