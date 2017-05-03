package io.github.vjames19.brtest

import io.github.vjames19.brtest.generator.RandomAssetGenerator
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by vreventos on 5/3/17.
  */
class AssetTest extends FlatSpec with Matchers {

  val generator = new RandomAssetGenerator()

  "Image asset" should "have an assetType of Image" in {
    generator.generateImage().assetType shouldEqual AssetType.Image
  }

  "Video asset" should "have an assetType of Image" in {
    generator.generateVideo().assetType shouldEqual AssetType.Video
  }

  "Ad asset" should "have an assetType of Image" in {
    generator.generateAd().assetType shouldEqual AssetType.Ad
  }
}
