package io.github.vjames19.brtest

/**
  * Created by vreventos on 5/2/17.
  */
trait Container {
  def assets: Seq[Asset]
}

final case class Show(id: Long,
                      name: String,
                      description: String,
                      assets: Seq[Asset]) extends Container
