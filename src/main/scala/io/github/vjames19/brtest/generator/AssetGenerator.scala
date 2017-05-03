package io.github.vjames19.brtest.generator

import java.time.LocalDateTime

import io.github.vjames19.brtest.AssetType.AssetType
import io.github.vjames19.brtest.VideoType.VideoType
import io.github.vjames19.brtest._

import scala.util.Random

/**
  * Created by vreventos on 5/2/17.
  */
trait AssetGenerator {

  def generate(assetType: AssetType): Asset = {
    assetType match {
      case AssetType.Ad => generateAd()
      case AssetType.Image => generateImage()
      case AssetType.Video => generateVideo()
    }
  }

  def generateImage(): Image

  def generateVideo(): Video

  def generateAd(): Ad
}

class RandomAssetGenerator extends AssetGenerator {
  private val random = new Random()

  override def generateImage(): Image = {
    val id = randomId()
    Image(
      id = id,
      name = s"image$id",
      url = url("image", id),
      expirationDate = expirationDate()
    )
  }

  override def generateVideo(): Video = {
    val id = randomId()
    Video(
      id = id,
      name = s"video$id",
      url = url("video", id),
      expirationDate = expirationDate(),
      videoType = videoType()
    )
  }

  override def generateAd(): Ad = {
    val id = randomId()
    Ad(
      id = id,
      name = s"ad$id",
      url = url("video", id),
      expirationDate = expirationDate(),
      productDescription = s"An amazing product description $id"
    )
  }

  private def randomId(): Long = Math.abs(random.nextLong() % 10000)

  private def url(asset: String, id: Long): String = {
    s"http://mycdn.com/$asset/$id"
  }

  private def expirationDate(): LocalDateTime = LocalDateTime.now().plusDays(random.nextInt(365))

  private def videoType(): VideoType = {
    val values = VideoType.values.toSeq
    values(random.nextInt(values.size))
  }
}
