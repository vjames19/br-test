package io.github.vjames19.brtest.generator

import io.github.vjames19.brtest.{Asset, Container, Show}

/**
  * Created by vreventos on 5/2/17.
  */
trait ContainerGenerator {
  def generateContainer(assets: Seq[Asset]): Container
}

class StaticShowContainerGenerator extends ContainerGenerator {
  override def generateContainer(assets: Seq[Asset]): Container = {
    Show(
      id = 1,
      name = "From Scala To Rocket!",
      description = "Test scala and prepare for takeoff.",
      assets = assets
    )
  }
}
