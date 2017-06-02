# br-test
Interview Assignment

## Problem
```
You have information on videos for a show, a list of images associated with a show, and a list of video ads associated with a show all considered "assets".
Each asset has an ID, a name, a type indicator, a URL, and an expiration date.
Videos have a field that indicates if it is a movie, a full episode or a clip.
Image assets can be represented by a base asset.
Ad assets include a field for a product description.
Containers describe a collection of assets.
Containers can be considered a "show" with information that includes an ID, name, description, and assets.
Create a program that generates at least one container with many assets (at least one of each type) with all properties set.
The program should visit each asset and print information about that asset specific to the type of asset it is.
```

## How to run

sbt run

## How to test

sbt test

## Overview

The main class is BrTest.
