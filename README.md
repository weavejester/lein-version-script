# lein-version-script

A small Leiningen plugin that sets the project version from a shell
script.

## Installation

Add the following to the `:plugins` section of your project.clj file:

```clojure
[lein-version-script "0.1.0"]
```

## Usage

Add a `:version-script` key to your project file that contains a bash
script to execute:

```clojure
:version-script "git rev-parse --short HEAD"
```

The STDOUT from this script will be used as the project version.

## License

Copyright © 2014 James Reeves

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
