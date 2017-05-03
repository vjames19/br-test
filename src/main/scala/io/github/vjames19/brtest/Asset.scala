package io.github.vjames19.brtest

import java.time.LocalDateTime

import io.github.vjames19.brtest.AssetType.AssetType
import io.github.vjames19.brtest.VideoType.VideoType

sealed trait Asset {
  def id: Long

  def name: String

  def assetType: AssetType

  def url: String

  def expirationDate: LocalDateTime
}

final case class Ad(id: Long,
                    name: String,
                    url: String,
                    expirationDate: LocalDateTime,
                    productDescription: String) extends Asset {
  val assetType: AssetType = AssetType.Ad
}

final case class Image(id: Long,
                       name: String,
                       url: String,
                       expirationDate: LocalDateTime) extends Asset {
  val assetType: AssetType = AssetType.Image
}

final case class Video(id: Long,
                       name: String,
                       url: String,
                       expirationDate: LocalDateTime,
                       videoType: VideoType) extends Asset {
  val assetType: AssetType = AssetType.Video
}

object AssetType extends Enumeration {
  type AssetType = Value
  val Image = Value("image")
  val Video = Value("video")
  val Ad = Value("ad")
}

object VideoType extends Enumeration {
  type VideoType = Value
  val Movie = Value("movie")
  val FullEpisode = Value("fullEpisode")
  val Clip = Value("clip")
}
