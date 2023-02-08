job "loginapp" {
  datacenters = ["dc1"]
  type = "service"

  group "webs" {
    count = 5

    network {
      port "http" {
        static = 8090
      }
    }
    service {
      port = "http"

      check {
        type     = "http"
        path     = "/signup"
        interval = "10s"
        timeout  = "2s"
      }
    }
    task "frontend" {
      # Specify the driver to be "docker". Nomad supports
      # multiple drivers.
      driver = "docker"

      config {
        image = "emn503/loginapp:1"
        ports = ["http"]
      }

      resources {
        cpu    = 1500 # MHz
        memory = 1280 # MB
      }
    }
  }
}
